package com.app.travenor.features.notification.presentation

import android.net.Uri
import android.os.Bundle
import androidx.navigation.NavType
import com.app.travenor.sample_data.Notification
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString

object NotificationCustomNav {

    val NotificationNavType = object : NavType<Notification>(
        isNullableAllowed = false
    ) {
        override fun get(bundle: Bundle, key: String): Notification? {
            return Json.decodeFromString(bundle.getString(key) ?: return null)
        }

        override fun parseValue(value: String): Notification {
            return Json.decodeFromString(Uri.decode(value))
        }

        override fun serializeAsValue(value: Notification): String {
            return Uri.encode(Json.encodeToString(value))
        }

        override fun put(bundle: Bundle, key: String, value: Notification) {
            bundle.putString(key, Json.encodeToString(value))
        }
    }
}