package com.example.catimagescompose.ui.layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.catimagescompose.ui.ImageGrid
import kotlinx.coroutines.CoroutineScope

@ExperimentalMaterial3Api
@Composable
fun CatImagesComposeScaffold(modifier: Modifier = Modifier, drawerState: DrawerState, scope: CoroutineScope) {

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
            //DataStoreExample(innerPadding)
            //ListDetailLayout()
            //Photos()
            ImageGrid()
        }
    }
}