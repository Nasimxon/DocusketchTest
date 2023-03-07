package com.docusketch.presentation.mappers

import com.docusketch.domain.entites.DbUser
import com.docusketch.presentation.model.UserListItem

fun DbUser.mapToListItem() = UserListItem.UserItem(
    id = id,
    avatarUrl = avatarUrl,
    htmlUrl = htmlUrl,
    login = login
)