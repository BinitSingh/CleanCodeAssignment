package com.example.assignmentmovie.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.assignmentmovie.presentation.ui.theme.AssignmentMovieTheme
import com.example.assignmentmovie.presentation.moviedetails.viewmodel.MovieDetailsViewModel
import com.example.assignmentmovie.presentation.movielist.viewmodel.MovieListViewModel
import com.example.assignmentmovie.presentation.navigation.AppNavHost
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val movieListViewModel: MovieListViewModel by viewModels()
    private val movieDetailsViewModel: MovieDetailsViewModel by viewModels()

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val toolbarTitle = remember { mutableStateOf("") }
            val secondaryScreenHeader = remember { mutableStateOf(false) }
            val navHostController: NavHostController = rememberNavController()
            AssignmentMovieTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(topBar = {
                        TopAppBar(
                            title = {
                                Text(
                                    text = toolbarTitle.value,
                                    maxLines = 1
                                )
                            },
                            colors = TopAppBarDefaults.smallTopAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primary,
                                titleContentColor = Color.Transparent,
                            ),
                            navigationIcon = {
                                if (secondaryScreenHeader.value) {
                                    IconButton(onClick = { navHostController.popBackStack() }) {
                                        Icon(
                                            imageVector = Icons.Filled.ArrowBack,
                                            contentDescription = "Back"
                                        )
                                    }
                                }
                            }

                        )
                    }, content = {
                        AppNavHost(
                            navHostController = navHostController,
                            movieListViewModel = movieListViewModel,
                            movieDetailsViewModel = movieDetailsViewModel,
                            modifier = Modifier.padding(it),
                            toolBarTitle = toolbarTitle,
                            secondaryScreenHeader = secondaryScreenHeader,
                        )
                    }
                    )
                }

            }
        }
    }
}


