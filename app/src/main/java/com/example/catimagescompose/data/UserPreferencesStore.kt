package com.example.catimagescompose.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserPreferencesStore(private val context: Context) {
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("userToken")
        private val USER_PREFERS_DARK_THEME = booleanPreferencesKey("user_prefers_dark_theme")
        private val LIKED_IMAGES = stringSetPreferencesKey("liked_images")
    }

    val getThemePreference: Flow<Boolean> = context.dataStore.data.map { preferences -> preferences[USER_PREFERS_DARK_THEME] ?: false }

    suspend fun changeThemePreference(pref: Boolean) {
        context.dataStore.edit { preferences -> preferences[USER_PREFERS_DARK_THEME] = pref }
    }

    val getLikedImages: Flow<List<String>> = context.dataStore.data.map { prefs ->
        prefs[LIKED_IMAGES]?.toList() ?: emptyList()
    }

    suspend fun addLikedImage(likedImage: String) {
        context.dataStore.edit { preferences ->
            val current = preferences[LIKED_IMAGES] ?: emptySet()
            val updated = current.toMutableSet()
            updated.add(likedImage)
            preferences[LIKED_IMAGES] = updated
        }
    }

    suspend fun removeLikedImage(unlikedImage: String) {
        context.dataStore.edit { preferences ->
            val current = preferences[LIKED_IMAGES] ?: emptySet()
            val updated = current.toMutableSet()
            updated.remove(unlikedImage)
            preferences[LIKED_IMAGES] = updated
        }
    }
}