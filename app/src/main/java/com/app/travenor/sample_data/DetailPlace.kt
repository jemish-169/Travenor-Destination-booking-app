package com.app.travenor.sample_data

import androidx.annotation.DrawableRes
import kotlinx.serialization.Serializable

@Serializable
data class DetailPlace(
    val id: Int,
    val name: String,
    val location: String,
    val imageUrl: String,
    @DrawableRes val placeHolder: Int,
    val amount: String,
    val rating: Int
)