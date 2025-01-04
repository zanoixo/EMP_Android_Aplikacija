package com.example.moviecatalog.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.moviecatalog.data.FavoriteEntity
import com.example.moviecatalog.data.WatchLaterEntity




@Database(entities = [WatchLaterEntity::class, FavoriteEntity::class], version = 1, exportSchema = false)
abstract class MovieCatalogDatabase : RoomDatabase() {

    abstract fun favoriteDao(): FavoriteDao
    abstract fun watchLaterDao(): WatchLaterDao

    companion object {

        //The value of a variable annotated with @Volatile is never cache.
        //R/W operations are the from/to main memory.
        @Volatile
        private var INSTANCE: MovieCatalogDatabase? = null

        // if the INSTANCE is not null, return it, otherwise create a new database instance.
        fun getDatabase(context: Context): MovieCatalogDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(context, MovieCatalogDatabase::class.java, "movie_catalog_database")
                    .build()
                    .also { INSTANCE = it }
            }

        }
    }


}