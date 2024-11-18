package com.app.travenor.sample_data

data class EditProfileData(
    val profileUrl: String,
    val firstName: String,
    val lastName: String,
    val location: String,
    val mobileNumber: String
)

val editProfileData = EditProfileData(
    profileUrl = "https://img.freepik.com/premium-vector/student-avatar-illustration-user-profile-icon-youth-avatar_118339-4405.jpg",
    firstName = "Leonardo",
    lastName = "Ahmed",
    location = "Sylhet Bangladesh",
    mobileNumber = "9123456789"
)