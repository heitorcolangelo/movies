package com.heitorcolangelo.data.movie.source

import androidx.paging.PagingSource
import com.heitorcolangelo.data.common.model.PageDataModel
import com.heitorcolangelo.data.movie.model.MovieDataModel
import java.io.IOException
import javax.inject.Inject
import javax.xml.ws.http.HTTPException

private const val START_PAGE = 1

class MoviePagingSource @Inject constructor(
    private val movieRemoteData: MovieRemoteData
) : PagingSource<Int, MovieDataModel>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieDataModel> {
        val nextPage = params.key ?: START_PAGE
        val newPage: PageDataModel<MovieDataModel> = movieRemoteData.getMovies(nextPage)
        return try {
            LoadResult.Page(
                data = newPage.items,
                prevKey = if (nextPage == START_PAGE) null else nextPage - 1,
                nextKey = if (newPage.items.isEmpty()) null else nextPage + 1
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HTTPException) {
            return LoadResult.Error(exception)
        }
    }
}
