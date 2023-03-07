package com.docusketch.users.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.docusketch.presentation.model.UserListItem
import com.docusketch.users.R
import com.docusketch.users.databinding.ViewHolderUserItemBinding

class UsersAdapter(
    private var items: List<UserListItem>,
    val callback: UserAdapterCallback
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.view_holder_user_item, viewGroup, false)
       return UsersViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is UsersViewHolder) {
            val item = items[position] as UserListItem.UserItem
            with(holder.binding) {
                tvTitle.text = item.login
                tvSubtitle.text = item.htmlUrl

                Glide.with(ivAvatar.context)
                    .load(item.avatarUrl)
                    .apply(RequestOptions.circleCropTransform())
                    .into(ivAvatar)
            }
        }
    }

    fun updateAdapter(list: List<UserListItem>) {
        items = list
        notifyDataSetChanged()
    }

    inner class UsersViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ViewHolderUserItemBinding.bind(view)

        init {
            itemView.setOnClickListener {
                val item = items[absoluteAdapterPosition] as UserListItem.UserItem
                callback.onClick(item.login)
            }
        }
    }
}