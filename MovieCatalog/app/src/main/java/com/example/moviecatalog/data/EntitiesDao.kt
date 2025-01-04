package com.example.moviecatalog.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface FavoriteDao {
    @Query("SELECT * FROM favorite ORDER BY name ASC")
    suspend fun getFavorite(): List<FavoriteEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFavorite(movie: FavoriteEntity)

    @Query("DELETE FROM favorite WHERE name LIKE :nameDel")
    suspend fun deleteFavorite(nameDel: String)

    @Query("SELECT * FROM favorite WHERE rating < 5 ORDER BY name ASC")
    suspend fun getFavoriteBelow5(): List<FavoriteEntity>
}

@Dao
interface WatchLaterDao {
    @Query("SELECT * FROM watch_later ORDER BY name ASC")
    suspend fun getWatchLater(): List<WatchLaterEntity>

    @Query("SELECT * FROM watch_later WHERE rating > 5 ORDER BY name ASC")
    suspend fun getWatchLaterAbove5(): List<WatchLaterEntity>

    @Insert
    suspend fun addWatchLaterEntry(movie: WatchLaterEntity)

    @Query("DELETE FROM watch_later WHERE name LIKE :nameDel")
    suspend fun deleteWatchLater(nameDel: String)

}