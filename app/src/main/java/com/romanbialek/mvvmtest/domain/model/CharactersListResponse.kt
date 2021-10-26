package com.romanbialek.mvvmtest.domain.model

import com.google.gson.annotations.SerializedName

data class GetCharactersListResponse(
    var offset: Long,
    var limit: Long,
    var total: Long,
    var count: Long,
    @SerializedName("results")
    var characters: List<Character>?
)


