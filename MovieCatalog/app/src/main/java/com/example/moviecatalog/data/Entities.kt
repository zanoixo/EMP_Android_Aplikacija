package com.example.moviecatalog.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "watch_later")
data class WatchLaterEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val year: Int,
    val rating: Double,
    val description: String
)

@Entity(tableName = "favorite")
data class FavoriteEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val year: Int,
    val rating: Double,
    val description: String
)
