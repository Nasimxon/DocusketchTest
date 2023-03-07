package com.docusketch.presentation.model

sealed class UserListItem {

    data class UserItem(
        val id: Int? = 0,
        val avatarUrl: String? = "",
        val htmlUrl: String? = "",
        val login: String? = ""
    ) : UserListItem()

}