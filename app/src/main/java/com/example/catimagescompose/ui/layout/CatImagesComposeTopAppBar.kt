package com.example.catimagescompose.ui.layout

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.example.catimagescompose.ui.MainDropdownMenu
import com.example.catimagescompose.ui.ThemeSwitcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatImagesComposeTopAppBar(drawerState: DrawerState, scope: CoroutineScope, backStack: SnapshotStateList<Screen>) {
    TopAppBar(
    colors = topAppBarColors(
    containerColor = MaterialTheme.colorScheme.primaryContainer,
    titleContentColor = MaterialTheme.colorScheme.primary,
    ),
    title = {
        Text("Top app bar")
    },
    actions = {
        ThemeSwitcher()
        MainDropdownMenu(backStack)
    },
    navigationIcon = {
        IconButton(onClick = {
            scope.launch {
                if (drawerState.isClosed) {
                    drawerState.open()
                } else {
                    drawerState.close()
                }
            }
        }) {
            Icon(Icons.Default.Menu, contentDescription = "Menu")
        }
    }
    )
}