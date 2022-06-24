package com.example.guitartheory

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.example.guitartheory.presentation.NavGraphs
import com.example.guitartheory.presentation.bottom_navigation.HomeScreenBottomNavigation
import com.example.guitartheory.ui.theme.GuitarTheoryTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.ramcosta.composedestinations.DestinationsNavHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			GuitarTheoryTheme {

				// A surface container using the 'background' color from the theme
				Surface(
					modifier = Modifier.fillMaxSize(),
					color = MaterialTheme.colors.background
				) {
					Scaffold(
						bottomBar = { HomeScreenBottomNavigation(Modifier.fillMaxWidth()) }
					) { innerPadding ->
						Box(modifier = Modifier.padding(innerPadding)) {
							val systemUiController = rememberSystemUiController()
							systemUiController.setSystemBarsColor(
								color = MaterialTheme.colors.primary
							)
							DestinationsNavHost(navGraph = NavGraphs.root)
						}
					}
				}
			}

		}
	}
}
