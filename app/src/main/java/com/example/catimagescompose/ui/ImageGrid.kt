package com.example.catimagescompose.ui

import android.R.attr.onClick
import android.os.Parcelable
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation3.runtime.NavKey
import com.example.catimagescompose.data.ImageDataModel
import com.example.catimagescompose.ui.layout.Single


@Composable
fun ImageGrid(backStack: SnapshotStateList<NavKey>, viewModel: ImageViewModel = hiltViewModel()) {
    val data by viewModel.data.observeAsState(emptyList())

    LaunchedEffect(Unit) {
        viewModel.loadData()
    }

    LazyColumn(
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(data) { image ->
            ImageCard(
                image.id,
                modifier = Modifier
                    .fillParentMaxWidth()
                    .clickable { backStack.add(Single(image.id)) }
            )
        }
    }
}