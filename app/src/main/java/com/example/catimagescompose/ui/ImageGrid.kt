package com.example.catimagescompose.ui

import android.os.Parcelable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.parcelize.Parcelize

@Parcelize
class Photo(val id: String): Parcelable

@Composable
fun ImageGrid(viewModel: ImageViewModel = hiltViewModel()) {
    val data by viewModel.data.observeAsState(emptyList())

    LaunchedEffect(Unit) {
        viewModel.loadData()
    }

    LazyColumn(
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(data) { photo ->
            ImageCard(
                photo,
                modifier = Modifier
                    .fillParentMaxWidth()
            )
        }
    }
}