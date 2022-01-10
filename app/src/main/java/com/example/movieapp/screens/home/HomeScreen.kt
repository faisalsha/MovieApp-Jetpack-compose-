package com.example.movieapp.screens.home

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieapp.MovieRow
import com.example.movieapp.model.Movie
import com.example.movieapp.model.getMovies
import com.example.movieapp.navigation.MovieScreen

@ExperimentalAnimationApi
@Composable
fun HomeScreen(navController:NavController){
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                content = { Icon(imageVector = Icons.Default.Add, contentDescription = "add") },

                onClick = { println("heyy")})


        },
        topBar = {
            TopAppBar(backgroundColor = MaterialTheme.colors.primary, elevation = 0.dp) {
                Row() {
                    Spacer(modifier = Modifier.width(20.dp))
                    Text(text = "Movies", style = MaterialTheme.typography.h5)
                }


            }
        }) {
        MainContent(navController = navController)

    }

}


@ExperimentalAnimationApi
@Composable
fun MainContent(navController:NavController,
                movieList:List<Movie> = getMovies()
){
    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn{
            items(items = movieList){
                MovieRow(movie = it){ movie->
                  navController.navigate(route = MovieScreen.DetailsScreen.name+"/$movie")

                }

            }
        }

    }
}