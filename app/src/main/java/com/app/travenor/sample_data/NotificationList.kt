package com.app.travenor.sample_data

import androidx.annotation.DrawableRes
import com.app.travenor.R

data class Notification(
    val id: Int,
    val notificationTitle: String,
    val notificationDesc: String,
    val notificationTime: String,
    val notificationIcon: String,
    @DrawableRes val placeHolderIcon: Int
)

val notificationList = listOf(
    Notification(
        id = 0,
        notificationTitle = "Super Offer",
        notificationDesc = "Get 60% in our first booking",
        notificationIcon = "https://cdn-icons-png.flaticon.com/512/2919/2919906.png",
        notificationTime = "Mon,12:40pm",
        placeHolderIcon = R.drawable.profile_ph1
    ),
    Notification(
        id = 1,
        notificationTitle = "Super Offer",
        notificationDesc = "Get 50% in our first booking",
        notificationIcon = "https://img.freepik.com/premium-vector/student-avatar-illustration-user-profile-icon-youth-avatar_118339-4405.jpg",
        notificationTime = "Sun,02:20am",
        placeHolderIcon = R.drawable.profile_ph2
    ),
    Notification(
        id = 2,
        notificationTitle = "Super Offer",
        notificationDesc = "Get 40% in our first booking",
        notificationIcon = "https://img.freepik.com/premium-photo/cartoon-boy-with-glasses-smiling-modern-line-icon-avatar_1106493-512908.jpg",
        notificationTime = "Tue,04:50am",
        placeHolderIcon = R.drawable.profile_ph3
    ),
    Notification(
        id = 3,
        notificationTitle = "Super Offer",
        notificationDesc = "Get 30% in our first booking",
        notificationIcon = "https://picsbed.top/file/oFWsedso%2FpQ9yeDpEvaEqEO4UvrWajYdGOem1ePC9Is%3D",
        notificationTime = "Sun,08:00pm",
        placeHolderIcon = R.drawable.profile_ph4
    ),
    Notification(
        id = 4,
        notificationTitle = "Super Offer",
        notificationDesc = "Get 20% in our first booking",
        notificationIcon = "https://img.freepik.com/premium-vector/businessman-avatar-illustration-cartoon-user-portrait-user-profile-icon_118339-5502.jpg",
        notificationTime = "Sun,11:40am",
        placeHolderIcon = R.drawable.profile_ph5
    ),
    Notification(
        id = 5,
        notificationTitle = "Super Offer",
        notificationDesc = "Get 10% in our first booking",
        notificationIcon = "https://png.pngtree.com/png-clipart/20240723/original/pngtree-flat-people-man-icon-illustration-vector-png-image_15612321.png",
        notificationTime = "Wed,12:00pm",
        placeHolderIcon = R.drawable.profile_ph6
    ),
    Notification(
        id = 6,
        notificationTitle = "Super Offer",
        notificationDesc = "Get 90% in our first booking",
        notificationIcon = "https://img.freepik.com/premium-photo/profile-icon-white-background_941097-162565.jpg",
        notificationTime = "Sat,01:50am",
        placeHolderIcon = R.drawable.profile_ph7
    ),
    Notification(
        id = 7,
        notificationTitle = "Super Offer",
        notificationDesc = "Get 20% in our first booking",
        notificationIcon = "https://img.freepik.com/premium-vector/businessman-avatar-illustration-cartoon-user-portrait-user-profile-icon_118339-5502.jpg",
        notificationTime = "Sun,11:40am",
        placeHolderIcon = R.drawable.profile_ph5
    ),
    Notification(
        id = 8,
        notificationTitle = "Super Offer",
        notificationDesc = "Get 10% in our first booking",
        notificationIcon = "https://png.pngtree.com/png-clipart/20240723/original/pngtree-flat-people-man-icon-illustration-vector-png-image_15612321.png",
        notificationTime = "Wed,12:00pm",
        placeHolderIcon = R.drawable.profile_ph6
    ),
    Notification(
        id = 9,
        notificationTitle = "Super Offer",
        notificationDesc = "Get 90% in our first booking",
        notificationIcon = "https://img.freepik.com/premium-photo/profile-icon-white-background_941097-162565.jpg",
        notificationTime = "Sat,01:50am",
        placeHolderIcon = R.drawable.profile_ph7
    ),
    Notification(
        id = 10,
        notificationTitle = "Super Offer",
        notificationDesc = "Get 20% in our first booking",
        notificationIcon = "https://img.freepik.com/premium-vector/businessman-avatar-illustration-cartoon-user-portrait-user-profile-icon_118339-5502.jpg",
        notificationTime = "Sun,11:40am",
        placeHolderIcon = R.drawable.profile_ph5
    ),
    Notification(
        id = 11,
        notificationTitle = "Super Offer",
        notificationDesc = "Get 10% in our first booking",
        notificationIcon = "https://png.pngtree.com/png-clipart/20240723/original/pngtree-flat-people-man-icon-illustration-vector-png-image_15612321.png",
        notificationTime = "Wed,12:00pm",
        placeHolderIcon = R.drawable.profile_ph6
    ),
    Notification(
        id = 12,
        notificationTitle = "Super Offer",
        notificationDesc = "Get 90% in our first booking",
        notificationIcon = "https://img.freepik.com/premium-photo/profile-icon-white-background_941097-162565.jpg",
        notificationTime = "Sat,01:50am",
        placeHolderIcon = R.drawable.profile_ph7
    )
)

