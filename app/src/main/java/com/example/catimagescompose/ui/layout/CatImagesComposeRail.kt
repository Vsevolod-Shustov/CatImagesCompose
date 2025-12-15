package com.example.catimagescompose.ui.layout

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation3.runtime.NavKey

@Composable
fun CatImagesComposeRail(backStack: SnapshotStateList<NavKey>) {
    NavigationRail {
        NavigationRailItem(
            selected = false,
            onClick = { backStack.add(Grid) },
            label = { Text("Home") },
            icon = { Icon(Icons.Default.Home, contentDescription = "Item 1") }
        )
    }
}