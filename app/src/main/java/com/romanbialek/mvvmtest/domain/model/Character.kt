package com.romanbialek.mvvmtest.domain.model

data class Character(
    val id: Long,
    val name: String?,
    val description: String?,
    val modified: String?,
    val thumbnail: CharacterThumbnail?,
    val resourceURI: String?
)

data class CharacterThumbnail(
    val path: String?,
    val extension: String?
)