package com.app.travenor.features.profile.presentation

import androidx.annotation.DrawableRes
import com.app.travenor.R

data class ProfileReDirectItems(
    @DrawableRes val icon: Int,
    val name: String,
    val contentDesc: String
)

val profileReDirectItems = listOf(
    ProfileReDirectItems(R.drawable.ic_profile, "Profile", "Profile icon"),
    ProfileReDirectItems(R.drawable.ic_bookmark_icon, "Bookmarked", "Bookmark icon"),
    ProfileReDirectItems(R.drawable.ic_travel_plane_icon, "Previous Trips", "Trip Plane icon"),
    ProfileReDirectItems(R.drawable.ic_settings_icon, "Settings", "Setting icon"),
    ProfileReDirectItems(R.drawable.ic_version_icon, "Version", "Version icon"),
    ProfileReDirectItems(R.drawable.ic_logout, "Sign Out", "Sign Out icon"),
)