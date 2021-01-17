package com.watched.movie.model

import com.watched.presentation.common.model.FormattedDateUiModel
import com.watched.presentation.common.model.UiModel

data class MovieDetailsUiModel(
    override val id: String,
    val title: String,
    val overview: String,
    val releaseDate: FormattedDateUiModel,
    val voteAverage: Float,
    val backdropPath: String
) : UiModel