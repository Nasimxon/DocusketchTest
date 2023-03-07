package com.docusketch.details.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.docusketch.details.R
import com.docusketch.details.databinding.ViewHolderReposItemBinding
import com.docusketch.domain.entites.DbRepository

class ReposAdapter(
    private var items: List<DbRepository>,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.view_holder_repos_item, viewGroup, false)
        return ReposViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ReposViewHolder) {
            val item = items[position]
            with(holder.binding) {
                tvTitle.text = item.name
                tvSubtitle.text = item.htmlUrl
            }
        }
    }

    fun updateAdapter(list: List<DbRepository>) {
        items = list
        notifyDataSetChanged()
    }

    inner class ReposViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ViewHolderReposItemBinding.bind(view)
    }
}