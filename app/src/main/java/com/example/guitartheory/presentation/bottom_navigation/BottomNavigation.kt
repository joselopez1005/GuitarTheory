package com.example.guitartheory.presentation.bottom_navigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import com.example.guitartheory.R

@Composable
fun HomeScreenBottomNavigation(
	modifier: Modifier = Modifier
) {
	BottomNavigation(
		backgroundColor = MaterialTheme.colors.background,
		modifier = modifier
	) {
		BottomNavigationItem(
			icon = {
				   Icon(
					   contentDescription = null,
					   imageVector = Icons.Default.MusicNote,
				   )
			},
			selected = true,
			onClick = { /*TODO*/ }
		)
		BottomNavigationItem(
			icon = {
				Icon(
					contentDescription = null,
					imageVector = Icons.Default.AccountCircle,
					modifier = Modifier.align(Alignment.CenterVertically)
				)
			},
			selected = false,
			onClick = { /*TODO*/ }
		)

	}

}