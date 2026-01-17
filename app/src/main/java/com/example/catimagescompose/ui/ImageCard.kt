package com.example.catimagescompose.ui

import android.R.attr.contentDescription
import android.R.color.black
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.example.catimagescompose.R
import com.example.catimagescompose.data.ImageDataModel
import com.example.catimagescompose.data.UserPreferencesStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun ImageCard(
    id: String,
    liked: Boolean = false,
    addLikedImage: suspend (String) -> Unit,
    removeLikedImage: suspend (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val tintColor = if (liked) Red else White

    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Box {
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data("https://cataas.com/cat/${id}")
                    .crossfade(true)
                    .build(),
                error = painterResource(R.drawable.ic_broken_image),
                placeholder = painterResource(R.drawable.loading_img),
                contentDescription = stringResource(R.string.photo),
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
            )
            Icon(
                if (liked) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                contentDescription = "Like icon",
                tint = tintColor,
                modifier = Modifier
                    .size(64.dp)
                    .padding(8.dp)
                    .align(Alignment.BottomStart)
                    .clickable(onClick = {
                        CoroutineScope(Dispatchers.IO).launch {
                            if (liked) {
                                removeLikedImage(id)
                            } else {
                                addLikedImage(id)
                            }
                        }
                    }),
            )
        }

    }
}