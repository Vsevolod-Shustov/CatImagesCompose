package com.example.catimagescompose.ui.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key.Companion.Home
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.example.catimagescompose.ui.ImageGrid
import com.example.catimagescompose.ui.ListDetailSceneStrategy
import com.example.catimagescompose.ui.SingleImage
import com.example.catimagescompose.ui.rememberListDetailSceneStrategy
import kotlinx.coroutines.CoroutineScope
import kotlinx.serialization.Serializable
import java.util.Map.entry

@Serializable
object Grid: NavKey

@Serializable
data class Single(val id: String): NavKey

@ExperimentalMaterial3Api
@Composable
fun CatImagesComposeScaffold(modifier: Modifier = Modifier, drawerState: DrawerState, scope: CoroutineScope) {

    val backStack = remember { mutableStateListOf<NavKey>(Grid) }
    val listDetailStrategy = rememberListDetailSceneStrategy<NavKey>()

    Scaffold(
        topBar = {
            CatImagesComposeTopAppBar(drawerState, scope)
        },
        bottomBar = {
            CatImagesComposeBottomAppBar()
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { }) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            NavDisplay(
                backStack = backStack,
                onBack = { backStack.removeLastOrNull() },
                sceneStrategy = listDetailStrategy,
                entryProvider = entryProvider {
                    entry<Grid>(
                        metadata = ListDetailSceneStrategy.listPane()
                    ) {
                        Column {
                            ImageGrid(backStack)
                        }
                    }
                    entry<Single>(
                        metadata = ListDetailSceneStrategy.detailPane()
                    ) { image ->
                        SingleImage(image.id)
                    }
                }
            )
        }
    }
}