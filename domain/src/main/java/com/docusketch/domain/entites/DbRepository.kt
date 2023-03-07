package com.docusketch.domain.entites

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DbRepository(
    var name: String? = "",
    @PrimaryKey
    var id: Int? = null,
    var htmlUrl: String? = ""
)

