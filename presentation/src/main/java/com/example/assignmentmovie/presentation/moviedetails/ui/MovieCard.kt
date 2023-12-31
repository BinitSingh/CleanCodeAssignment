package com.example.assignmentmovie.presentation.moviedetails.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.assignmentmovie.domain.model.MovieDetailInfo
import com.example.assignmentmovie.presentation.ui.components.CustomImage
import com.example.assignmentmovie.presentation.ui.components.CustomText
import com.example.assignmentmovie.presentation.R

@Composable
fun MovieCard(movieDetailInfo: MovieDetailInfo, modifier: Modifier) {

    Column(
        modifier = modifier
            .padding(bottom = 10.dp)
            .verticalScroll(rememberScrollState())
    ) {
        CustomImage(
            data = movieDetailInfo.backdropPath,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        CustomText(
            movieDetailInfo.title,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp),
            color = Color.Black, maxLines = 1
        )
        CustomText(
            movieDetailInfo.tagline,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp),
            color = Color.Gray
        )

        CustomText(
            stringResource(id = R.string.overview),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp, start = 10.dp, end = 10.dp),
            color = Color.Black,
        )


        CustomText(
            movieDetailInfo.overview,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            color = Color.Black,
        )

        CustomText(
            stringResource(id = R.string.about_movie),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp, start = 10.dp, end = 10.dp),
            color = Color.Black,
        )

        CustomText(
            stringResource(id = R.string.release_date),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, start = 10.dp, end = 10.dp),
            color = Color.Black,
        )

        CustomText(
            movieDetailInfo.releaseDate,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp, start = 10.dp, end = 10.dp),
            color = Color.Black,
        )

        CustomText(
            stringResource(id = R.string.run_time),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, start = 10.dp, end = 10.dp),
            color = Color.Black,
        )

        CustomText(
            movieDetailInfo.runtime,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp, start = 10.dp, end = 10.dp),
            color = Color.Black,
        )
    }
}