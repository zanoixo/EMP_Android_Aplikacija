package com.example.moviecatalog.data


class MovieCatalogRepositoryImpl(
    private val favoriteDao: FavoriteDao,
    private val watchLaterDao: WatchLaterDao
) : MovieCatalogRepository {



    override suspend fun removeFavorite(name: String){
        favoriteDao.deleteFavorite(name)
    }

    override suspend fun getFavoriteBelow5(): List<Movie> {
        return favoriteDao.getFavorite().map { entity ->
            Movie(name = entity.name, year = entity.year, rating = entity.rating, description = entity.description)
        }
    }

    override suspend fun getWatchLaterAbove5(): List<Movie> {
        return watchLaterDao.getWatchLater().map { entity ->
            Movie(name = entity.name, year = entity.year, rating = entity.rating, description = entity.description)
        }
    }

    override suspend fun removeWatchLater(name: String){
        watchLaterDao.deleteWatchLater(name)
    }

    override suspend fun getFavoriteList(): List<Movie> {
        return favoriteDao.getFavorite().map { entity ->
            Movie(name = entity.name, year = entity.year, rating = entity.rating, description = entity.description)
        }
    }

    override suspend fun getWatchLaterList(): List<Movie> {
        return watchLaterDao.getWatchLater().map { entity ->
            Movie(name = entity.name, year = entity.year, rating = entity.rating, description = entity.description)
        }
    }

    override suspend fun addFavorite(movie: FavoriteEntity) {
        favoriteDao.addFavorite(
            FavoriteEntity(
            name = movie.name,
            year = movie.year,
            rating = movie.rating,
            description = movie.description
            )
        )
    }

    override suspend fun addWatchLater(movie: WatchLaterEntity) {
        watchLaterDao.addWatchLaterEntry(
            WatchLaterEntity(
                name = movie.name,
                year = movie.year,
                rating = movie.rating,
                description = movie.description
            )
        )
    }


}