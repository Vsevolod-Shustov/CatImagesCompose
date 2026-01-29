package com.example.catimagescompose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.Modifier
import com.example.catimagescompose.ui.layout.CatImagesComposeDrawer
import com.example.catimagescompose.ui.theme.CatImagesComposeTheme

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            CatImagesComposeTheme {
                //CatImagesComposeScaffold(modifier = Modifier.fillMaxSize())
                CatImagesComposeDrawer(modifier = Modifier.fillMaxWidth())
            }
        }
    }
}