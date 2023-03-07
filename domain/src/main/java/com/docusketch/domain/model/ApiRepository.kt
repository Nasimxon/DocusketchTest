package com.docusketch.domain.model

import com.squareup.moshi.Json

data class ApiRepository(
    @Json(name = "name")
    var name: String? = "",
    @Json(name = "id")
    var id: Int? = null,
    @Json(name = "html_url")
    var htmlUrl: String? = ""
)

