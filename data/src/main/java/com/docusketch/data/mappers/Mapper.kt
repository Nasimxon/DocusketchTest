package com.docusketch.data.mappers

import com.docusketch.domain.entites.DbRepository
import com.docusketch.domain.entites.DbUser
import com.docusketch.domain.model.ApiRepository
import com.docusketch.domain.model.ApiUser

fun ApiUser.map() = DbUser(
    id = id,
    type = type,
    avatarUrl = avatarUrl,
    eventsUrl = eventsUrl,
    followersUrl = followersUrl,
    followingUrl = followingUrl,
    gistsUrl = gistsUrl,
    gravatarId = gravatarId,
    htmlUrl = htmlUrl,
    login = login,
    nodeId = nodeId,
    organizationsUrl = organizationsUrl,
    reposUrl = reposUrl,
    siteAdmin = siteAdmin,
    starredUrl = starredUrl,
    receivedEventsUrl = receivedEventsUrl,
    subscriptionsUrl = subscriptionsUrl,
    url = url,
    name = name,
    updatedAt = updatedAt,
    bio = bio,
    blog = blog,
    company = company,
    createdAt = createdAt,
    email = email,
    followers = followers,
    following = following,
    hireable = hireable,
    location = location,
    publicGists = publicGists,
    publicRepos = publicRepos,
    score = score
)

fun ApiRepository.map() = DbRepository(
    name = name,
    id = id,
    htmlUrl = htmlUrl
)