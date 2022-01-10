package com.example.movieapp.screens.details

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.movieapp.MovieRow
import com.example.movieapp.model.Movie
import com.example.movieapp.model.getMovies

@ExperimentalAnimationApi
@Composable
fun DetailsScreen(navController: NavController, movieId:String?){

    val newMovieList= getMovies().filter { movie->
        movie.id==movieId
    }
    print("new movie list")
    println(newMovieList.toString())

    Scaffold(topBar = {
        TopAppBar(backgroundColor = MaterialTheme.colors.primary, elevation = 0.dp) {
            Row(horizontalArrangement = Arrangement.Start) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription ="Back arrow", modifier = Modifier.clickable {
                    navController.popBackStack()
                })
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "Movies",style = MaterialTheme.typography.h5)


            }

        }
    }) {



    Surface(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top) {

         MovieRow(movie = newMovieList[0])
//            Text(text = newMovieList[0].title, style = MaterialTheme.typography.h2)

            Spacer(modifier = Modifier.height(5.dp))
            Divider()
            Text("Movie Images")
            HorScrollView(newMovieList)
        }
    }
    }
}

@Composable
private fun HorScrollView(newMovieList: List<Movie>) {
    LazyRow {
        items(newMovieList[0].images) { image ->
            Card(
                modifier = Modifier
                    .padding(12.dp)
                    .size(240.dp), elevation = 5.dp
            ) {
                Image(painter = rememberImagePainter(data = image), contentDescription = "Image")


            }

        }
    }
}