package com.app.travenor.features.detail.presentation

import android.net.Uri
import android.os.Bundle
import androidx.navigation.NavType
import com.app.travenor.sample_data.DetailPlace
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

object PlaceDetailCustomNav {

    val DetailPlaceNavType = object : NavType<DetailPlace>(
        isNullableAllowed = false
    ) {
        override fun get(bundle: Bundle, key: String): DetailPlace? {
            return Json.decodeFromString(bundle.getString(key) ?: return null)
        }

        override fun parseValue(value: String): DetailPlace {
            return Json.decodeFromString(Uri.decode(value))
        }

        override fun serializeAsValue(value: DetailPlace): String {
            return Uri.encode(Json.encodeToString(value))
        }

        override fun put(bundle: Bundle, key: String, value: DetailPlace) {
            bundle.putString(key, Json.encodeToString(value))
        }
    }
}