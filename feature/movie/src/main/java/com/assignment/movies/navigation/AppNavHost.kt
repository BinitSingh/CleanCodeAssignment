package com.assignment.movies.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.assignment.movies.ui.details.MovieDetailScreen
import com.assignment.movies.ui.list.MovieListScreen
import com.assignment.movies.util.Constants

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = AppNav.MovieList.route,
    ) {
        composable(route = AppNav.MovieList.route) {
            MovieListScreen {
                navController.navigate(
                    AppNav.MovieDetail.route + "/$it",
                )
            }
        }

        composable(
            route = AppNav.MovieDetail.route + "/{${Constants.MOVIE_ID}}",
        ) {
            MovieDetailScreen {
                navController.navigateUp()
            }
        }
    }
}
