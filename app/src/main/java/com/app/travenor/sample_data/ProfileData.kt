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
    profileUrl = "https://img.freepik.com/premium-vector/student-avatar-illustration-user-profile-icon-youth-avatar_118339-4405.jpg",
    profileName = "Leonardo",
    profileMail = "leonardo@gmail.com",
    rewardPoints = 360,
    travelTrips = 238,
    bucketList = 473
)