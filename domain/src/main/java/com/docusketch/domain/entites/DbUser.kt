package com.docusketch.domain.entites

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DbUser(
    var avatarUrl: String? = "",
    var eventsUrl: String? = "",
    var followersUrl: String? = "",
    var followingUrl: String? = "",
    var gistsUrl: String? = "",
    var gravatarId: String? = "",
    var htmlUrl: String? = "",
    @PrimaryKey
    var id: Int? = 0,
    var login: String? = "",
    var nodeId: String? = "",
    var organizationsUrl: String? = "",
    var receivedEventsUrl: String? = "",
    var reposUrl: String? = "",
    var siteAdmin: Boolean? = false,
    var starredUrl: String? = "",
    var subscriptionsUrl: String? = "",
    var type: String? = "",
    var url: String? = "",
    var score: Float? = 0f,
    var name: String? = "",
    var company: String? = "",
    var blog: String? = "",
    var location: String? = "",
    var email: String? = "",
    var hireable: String? = "",
    var bio: String? = "",
    var publicRepos: Int = 0,
    var publicGists: Int = 0,
    var followers: Int = 0,
    var following: Int = 0,
    var createdAt: String = "",
    var updatedAt: String = ""
)