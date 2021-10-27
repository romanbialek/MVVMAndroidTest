package com.romanbialek.mvvmtest.domain.model

import com.google.gson.annotations.SerializedName

data class Character(
    val id: Long,
    val name: String?,
    val description: String?,
    val modified: String?,
    val thumbnail: CharacterThumbnail?,
    val resourceURI: String?,
    @SerializedName("comics")
    val comicsResponse: ComicsResponse,
    @SerializedName("series")
    val seriesResponse: SeriesResponse,
    @SerializedName("events")
    val eventsResponse: EventsResponse,
    @SerializedName("stories")
    val storiesResponse: StoriesResponse
)

data class CharacterThumbnail(
    val path: String?,
    val extension: String?
)

data class SeriesResponse(
    val available: Int?,
)

data class EventsResponse(
    val available: Int?,
)

data class StoriesResponse(
    val available: Int?,
)
data class ComicsResponse(
    val available: Int?,
)