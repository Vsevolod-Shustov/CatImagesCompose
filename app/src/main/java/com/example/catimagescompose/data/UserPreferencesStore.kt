package com.example.catimagescompose.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserPreferencesStore(private val context: Context) {
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("userToken")
        private val USER_PREFERS_DARK_THEME = booleanPreferencesKey("user_prefers_dark_theme")
    }

    val getThemePreference: Flow<Boolean> = context.dataStore.data.map { preferences -> preferences[USER_PREFERS_DARK_THEME] ?: false }

    suspend fun changeThemePreference(pref: Boolean) {
        context.dataStore.edit { preferences -> preferences[USER_PREFERS_DARK_THEME] = pref }
    }
}