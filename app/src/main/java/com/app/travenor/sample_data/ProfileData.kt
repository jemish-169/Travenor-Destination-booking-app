package com.app.travenor.sample_data

data class ProfileData(
    val profileUrl: String,
    val profileName: String,
    val profileMail: String,
    val rewardPoints: Int,
    val travelTrips: Int,
    val bucketList: Int
)

val profileData = ProfileData(
    profileUrl = "https://img.freepik.com/premium-photo/profile-icon-white-background_941097-162565.jpg",
    profileName = "Leonardo",
    profileMail = "leonardo@gmail.com",
    rewardPoints = 360,
    travelTrips = 238,
    bucketList = 473
)