package com.docusketch.domain.model

import com.squareup.moshi.Json

data class ApiUser(
    @Json(name = "avatar_url")
    var avatarUrl: String? = "",
    @Json(name = "events_url")
    var eventsUrl: String? = "",
    @Json(name = "followers_url")
    var followersUrl: String? = "",
    @Json(name = "following_url")
    var followingUrl: String? = "",
    @Json(name = "gists_url")
    var gistsUrl: String? = "",
    @Json(name = "gravatar_id")
    var gravatarId: String? = "",
    @Json(name = "html_url")
    var htmlUrl: String? = "",
    @Json(name = "id")
    var id: Int? = 0,
    @Json(name = "login")
    var login: String? = "",
    @Json(name = "node_id")
    var nodeId: String? = "",
    @Json(name = "organizations_url")
    var organizationsUrl: String? = "",
    @Json(name = "received_events_url")
    var receivedEventsUrl: String? = "",
    @Json(name = "repos_url")
    var reposUrl: String? = "",
    @Json(name = "site_admin")
    var siteAdmin: Boolean? = false,
    @Json(name = "starred_url")
    var starredUrl: String? = "",
    @Json(name = "subscriptions_url")
    var subscriptionsUrl: String? = "",
    @Json(name = "type")
    var type: String? = "",
    @Json(name = "url")
    var url: String? = "",
    @Json(name = "score")
    var score: Float = 0f,
    @Json(name = "name")
    var name: String? = "",
    @Json(name = "company")
    var company: String? = "",
    @Json(name = "blog")
    var blog: String? = "",
    @Json(name = "location")
    var location: String? = "",
    @Json(name = "email")
    var email: String? = "",
    @Json(name = "hireable")
    var hireable: String? = "",
    @Json(name = "bio")
    var bio: String? = "",
    @Json(name = "public_repos")
    var publicRepos: Int = 0,
    @Json(name = "public_gists")
    var publicGists: Int = 0,
    @Json(name = "followers")
    var followers: Int = 0,
    @Json(name = "following")
    var following: Int = 0,
    @Json(name = "created_at")
    var createdAt: String = "",
    @Json(name = "updated_at")
    var updatedAt: String = ""
)

