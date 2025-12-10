package com.example.catimagescompose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.catimagescompose.data.ImageDataModel

@Composable
fun SingleImage(id: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Red.copy(alpha = 0.1f))
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Column {
            ImageCard(id)
            Text(
                "Item: ${id}",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}