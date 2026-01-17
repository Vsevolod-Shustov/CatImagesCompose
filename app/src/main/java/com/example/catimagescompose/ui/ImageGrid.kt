package com.example.catimagescompose.ui

import android.R.attr.onClick
import android.os.Parcelable
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.datastore.dataStore
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation3.runtime.NavKey
import com.example.catimagescompose.data.ImageDataModel
import com.example.catimagescompose.data.UserPreferencesStore
import com.example.catimagescompose.ui.layout.Screen
import kotlin.text.contains


@Composable
fun ImageGrid(backStack: SnapshotStateList<Screen>, viewModel: ImageViewModel = hiltViewModel()) {
    val data by viewModel.data.observeAsState(emptyList())

    val context = LocalContext.current
    val store = UserPreferencesStore(context)
    val likedImages = store.getLikedImages.collectAsState(initial = emptySet()).value
    val addLikedImage = store::addLikedImage
    val removeLikedImage = store::removeLikedImage

    LaunchedEffect(Unit) {
        viewModel.loadData()
    }

    Column {
        Text("Liked images: ${likedImages}")

        LazyColumn(
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {

            items(data) { image ->
                ImageCard(
                    image.id,
                    likedImages.contains(image.id),
                    addLikedImage,
                    removeLikedImage,
                    modifier = Modifier
                        .fillParentMaxWidth()
                        .clickable { backStack.add(Screen.Single(image.id)) }
                )
            }
        }
    }
}