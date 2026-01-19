package com.example.catimagescompose.ui.layout

import androidx.activity.SystemBarStyle.Companion.auto
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavKey

@Composable
fun CatImagesComposeRail(backStack: SnapshotStateList<Screen>) {
    NavigationRail {
        NavigationRailItem(
            selected = false,
            onClick = { backStack.add(Screen.Grid) },
            label = { Text("Home") },
            icon = { Icon(Icons.Default.Home, contentDescription = "Item 1") }
        )
        Spacer(modifier = Modifier.weight(1f))
        NavigationRailItem(
            selected = false,
            onClick = { backStack.add(Screen.About) },
            label = { Text("About") },
            icon = { Icon(Icons.Default.Info, contentDescription = "Item 1") }
        )
    }
}