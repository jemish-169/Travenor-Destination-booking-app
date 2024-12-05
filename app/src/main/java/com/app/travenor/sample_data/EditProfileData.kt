package com.app.travenor.sample_data

data class EditProfileData(
    val profileUrl: String,
    val firstName: String,
    val lastName: String,
    val location: String,
    val mobileNumber: String
)

val editProfileData = EditProfileData(
    profileUrl = "https://img.freepik.com/premium-photo/profile-icon-white-background_941097-162565.jpg",
    firstName = "Leonardo",
    lastName = "Ahmed",
    location = "Sylhet Bangladesh",
    mobileNumber = "9123456789"
)