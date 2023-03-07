package com.docusketch.details.ui

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.docusketch.common.base.BaseFragment
import com.docusketch.common.utils.getCreatedDate
import com.docusketch.common.utils.network.NetworkStatus
import com.docusketch.core.extensions.coreComponent
import com.docusketch.details.databinding.FragmentUserDetailsBinding
import com.docusketch.details.di.DaggerUserDetailsComponent
import com.docusketch.domain.entites.DbUser
import com.docusketch.presentation.viewmodel.UserDetailsViewModel
import javax.inject.Inject

class UserDetailsFragment : BaseFragment() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private val viewModel: UserDetailsViewModel by viewModels { factory }
    private lateinit var binding: FragmentUserDetailsBinding
    private val args: UserDetailsFragmentArgs by navArgs()
    lateinit var adapter: ReposAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        DaggerUserDetailsComponent.factory().create(coreComponent()).inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        viewModel.getUserDetails(args.username)
        viewModel.getUserRepos(args.username)
        observeUsers()
        observeUserRepos()
    }

    private fun observeUsers() {
        viewModel.userLiveData.observe(viewLifecycleOwner) { result ->
            when (result) {
                is NetworkStatus.Loading -> {
                    // do nothing
                }
                is NetworkStatus.Error -> {
                    if (result.data != null) {
                        result.data?.let {
                            setUserData(it)
                        }
                    } else {
                        getRequestFailed(result.errorMessage!!)
                    }
                }
                is NetworkStatus.Success -> {
                    result.data?.let {
                        setUserData(it)
                    }
                }
            }
        }
    }

    private fun observeUserRepos() {
        viewModel.reposLiveData.observe(viewLifecycleOwner) { result ->
            when (result) {
                is NetworkStatus.Loading -> {
                    if (result.data.isNullOrEmpty().not()) {
                        hideLoading()
                        result.data?.let { adapter.updateAdapter(it) }
                    } else showLoading()
                }
                is NetworkStatus.Error -> {
                    if (result.data.isNullOrEmpty().not()) {
                        hideLoading()
                        result.data?.let { adapter.updateAdapter(it) }
                    } else {
                        hideLoading()
                        getRequestFailed(result.errorMessage)
                    }
                }
                is NetworkStatus.Success -> {
                    hideLoading()
                    result.data?.let { adapter.updateAdapter(it) }
                }
            }
        }
    }

    private fun initRecyclerView() {
        adapter = ReposAdapter(emptyList())
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rvRepos.adapter = adapter
        binding.rvRepos.layoutManager = layoutManager
    }

    @SuppressLint("SetTextI18n")
    private fun setUserData(user: DbUser) {
        with(binding) {
            Glide.with(ivAvatar.context)
                .load(user.avatarUrl)
                .apply(RequestOptions.circleCropTransform())
                .into(ivAvatar)

            tvName.text = user.name ?: user.login
            tvEmail.text = user.email ?: "no email"
            tvOrganization.text = user.company ?: "no company"
            tvFollowers.text = "Followers: ${user.followers}"
            tvCreated.text = user.createdAt.getCreatedDate()
        }
    }

    override fun showLoading() {
        binding.progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        binding.progressBar.visibility = View.GONE
    }
}