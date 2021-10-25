package com.romanbialek.mvvmtest.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

data class GetCharactersListResponse(
    var offset: Long,
    var limit: Long,
    var total: Long,
    var count: Long,
)



