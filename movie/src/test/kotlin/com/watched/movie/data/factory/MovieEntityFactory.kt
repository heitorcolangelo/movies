package com.watched.movie.data.factory

import com.watched.common.test.MockFactory
import com.watched.data.local.movie.entity.MovieEntity

object MovieEntityFactory : MockFactory<MovieEntity> {
    override fun make(): MovieEntity {
        return MovieEntity(
            id = randomId(),
            title = randomString(),
            overview = randomString(),
            backdropPath = randomString(),
            posterPath = randomString(),
            voteAverage = randomFloat(),
            popularity = randomFloat(),
            releaseDate = randomString()
        )
    }
}
