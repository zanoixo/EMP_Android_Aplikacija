package com.example.moviecatalog.data

import kotlinx.serialization.Serializable

@Serializable
data class Top10 (
    val rank: Int,
    val title: String
)