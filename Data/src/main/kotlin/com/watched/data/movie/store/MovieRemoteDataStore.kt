package com.watched.data.movie.store

import com.watched.data.common.model.PageDataModel
import com.watched.data.common.store.RemoteDataStore
import com.watched.data.movie.model.MovieDataModel
import com.watched.data.movie.model.SortOptionsDataModel
import com.watched.data.movie.source.MovieRemoteDataSource
import javax.inject.Inject

class MovieRemoteDataStore @Inject constructor(
    private val dataSource: MovieRemoteDataSource
) : MovieDataStore, RemoteDataStore {

    override suspend fun getMoviePage(
        page: Int,
        sortOption: SortOptionsDataModel,
        forceRefresh: Boolean
    ): PageDataModel<MovieDataModel> {
        return dataSource.getMovies(page, sortOption)
    }

    override suspend fun saveMovies(movies: List<MovieDataModel>) {
        throw UnsupportedOperationException("Save is not supported by remote data source.")
    }

    override suspend fun getMovie(movieId: String): MovieDataModel {
        return dataSource.getMovie(movieId)
    }
}
