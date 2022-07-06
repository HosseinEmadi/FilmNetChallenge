package com.filmNet.android.app.searchMovies.presenter.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.filmNet.android.app.R
import com.filmNet.android.domain.model.Movie
import com.skydoves.landscapist.glide.GlideImage


@Composable
fun MoviesList(
    modifier: Modifier = Modifier,
    list: List<Movie>
) {
    val listState = rememberLazyListState()




    LazyColumn(
        modifier = modifier.padding(10.dp),
        state = listState
    ){
        items(list){ item ->
            MovieCard(
                item)
        }
    }
}

@Composable
fun MovieCard(movie: Movie,
              modifier: Modifier = Modifier) {
    Card(
        modifier = Modifier
            .padding(all = 8.dp)) {
        Row(
            modifier = Modifier
                .padding(all = 10.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically

        ) {

            movie.cover_image?.path?.let {
                GlideImage(
                    modifier = Modifier
                        .size(70.dp)
                        .clip(CircleShape)
                        .background(color = MaterialTheme.colors.secondary),
                    imageModel = GlideUrl(
                        it,
                        LazyHeaders
                            .Builder()
                            .build()
                    ),
                    requestBuilder = Glide
                        .with(LocalContext.current)
                        .asBitmap()
                        .apply(
                            RequestOptions().diskCacheStrategy(
                                DiskCacheStrategy.ALL
                            )
                        )
                        .thumbnail(0.6f)
                        .transition(BitmapTransitionOptions.withCrossFade()),
                )
            }



            Spacer(modifier = Modifier.width(8.dp))
            Column(modifier = Modifier.fillMaxWidth()){
                Text(
                    text = movie.title ?: "",
                    modifier = Modifier.padding(all = 4.dp),
                    color = Color.Black,
                    // If the message is expanded, we display all its content
                    // otherwise we only display the first line
                    style = MaterialTheme.typography.body1,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "${LocalContext.current.getString(R.string.movie_duration)} ${movie.duration}" ,
                    color = MaterialTheme.colors.secondary,
                    modifier = Modifier
                        .padding(all = 4.dp)
                        .align(alignment = Alignment.End),
                    // If the message is expanded, we display all its content
                    // otherwise we only display the first line
                    style = MaterialTheme.typography.caption
                )
            }

        }

    }

}