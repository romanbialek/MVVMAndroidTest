package com.romanbialek.mvvmtest.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

data class Character(
    @PrimaryKey var id: Long,
    var title: String,
    val url: String,
    val thumbnailUrl: String?
) {
    fun setName(text: String) {
        title = text
    }
}