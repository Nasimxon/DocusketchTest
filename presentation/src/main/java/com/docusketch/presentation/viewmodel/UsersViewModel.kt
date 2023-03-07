package com.docusketch.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.docusketch.common.utils.network.NetworkStatus
import com.docusketch.domain.entites.DbUser
import com.docusketch.domain.interactors.UsersInteractor
import com.docusketch.presentation.mappers.mapToListItem
import com.docusketch.presentation.model.UserListItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class UsersViewModel @Inject constructor(
    private val usersInteractor: UsersInteractor
) : ViewModel() {

    private val _usersLiveData = MutableLiveData<NetworkStatus<List<UserListItem>>>()
    val usersLiveData = _usersLiveData

    private var lastUserId: Int? = null

    fun getAllUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            usersInteractor.getUsers().collect {
                updateData(it)
            }
        }
    }

    fun getMoreUsers() {
        if (lastUserId != null) {
            viewModelScope.launch(Dispatchers.IO) {
                usersInteractor.getUsers(lastUserId ?: 1).collect {
                    updateData(it)
                }
            }
        }
    }

    private fun updateData(response: NetworkStatus<List<DbUser>>) {
        when (response) {
            is NetworkStatus.Loading -> {
                if (lastUserId == null) {
                    if (response.data.isNullOrEmpty().not()) {
                        val items = response.data?.map {
                            it.mapToListItem()
                        }
                        _usersLiveData.postValue(NetworkStatus.Loading(items))
                    } else {
                        _usersLiveData.postValue(NetworkStatus.Loading())
                    }
                }
            }
            is NetworkStatus.Success -> {
                if (response.data.isNullOrEmpty().not()) {
                    val newItems = response.data?.map {
                        it.mapToListItem()
                    }
                    lastUserId = newItems?.last()?.id
                    _usersLiveData.postValue(NetworkStatus.Success(newItems))
                }
            }
            is NetworkStatus.Error -> {
                if (response.data.isNullOrEmpty().not()) {
                    _usersLiveData.postValue(
                        NetworkStatus.Error(null)
                    )
                } else {
                    _usersLiveData.postValue(
                        NetworkStatus.Error(
                            response.errorMessage,
                            null
                        )
                    )
                }
            }
        }
    }
}