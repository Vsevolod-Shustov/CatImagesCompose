package com.example.catimagescompose.ui

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import com.example.catimagescompose.R
import com.example.catimagescompose.data.UserPreferencesStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun ThemeSwitcher(){
    val context = LocalContext.current
    val store = UserPreferencesStore(context)
    val themePref = store.getThemePreference.collectAsState(initial = false).value
    val darkModeIcon = painterResource(R.drawable.outline_dark_mode_24)
    val lightModeIcon = painterResource(R.drawable.outline_light_mode_24)

    var icon: Painter

    when (themePref) {
        true -> icon = darkModeIcon
        false -> icon = lightModeIcon
    }


    IconButton(onClick = {
        CoroutineScope(Dispatchers.IO).launch {
            store.changeThemePreference(!themePref)
        }
    }) {
        Icon(
            painter = icon,
            contentDescription = null
        )
    }
}