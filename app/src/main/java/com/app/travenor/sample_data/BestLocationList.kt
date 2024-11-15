package com.app.travenor.sample_data

import androidx.annotation.DrawableRes
import com.app.travenor.R

data class BestLocations(
    val id: Int,
    val locName: String,
    var isBookmarked: Boolean,
    val locAddress: String,
    val rating: String,
    val locImageUrl: String,
    @DrawableRes val placeHolderImage: Int,
    val profileList: List<String>
)

val bestLocationList = listOf(
    BestLocations(
        id = 0,
        locName = "Prime Resort",
        isBookmarked = true,
        locAddress = "Amreli, Gujarat",
        rating = "4.7",
        locImageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcREI7Uh1Do9A11i6eyrrzg4xC96grBJCJy8_yrm81F5tdDHqF34epK0RFs&s",
        placeHolderImage = R.drawable.onboarding_1,
        profileList = listOf(
            "https://cdn-icons-png.flaticon.com/512/2919/2919906.png",
            "https://img.freepik.com/premium-vector/student-avatar-illustration-user-profile-icon-youth-avatar_118339-4405.jpg",
            "https://img.freepik.com/premium-photo/cartoon-boy-with-glasses-smiling-modern-line-icon-avatar_1106493-512908.jpg",
            "https://picsbed.top/file/oFWsedso%2FpQ9yeDpEvaEqEO4UvrWajYdGOem1ePC9Is%3D",
            "https://img.freepik.com/premium-vector/businessman-avatar-illustration-cartoon-user-portrait-user-profile-icon_118339-5502.jpg",
            "https://png.pngtree.com/png-clipart/20240723/original/pngtree-flat-people-man-icon-illustration-vector-png-image_15612321.png",
            "https://img.freepik.com/premium-photo/profile-icon-white-background_941097-162565.jpg"
        )
    ),
    BestLocations(
        id = 1,
        locName = "Supreme Resort",
        isBookmarked = true,
        locAddress = "Surat, Gujarat",
        rating = "4.7",
        locImageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR78OI5Pcmb5ELnr2lNRHjn_sMJAG2VxNRQug&s",
        placeHolderImage = R.drawable.onboarding_2,
        profileList = listOf(
            "https://cdn-icons-png.flaticon.com/512/2919/2919906.png",
            "https://img.freepik.com/premium-vector/student-avatar-illustration-user-profile-icon-youth-avatar_118339-4405.jpg",
            "https://img.freepik.com/premium-photo/cartoon-boy-with-glasses-smiling-modern-line-icon-avatar_1106493-512908.jpg",
            "https://picsbed.top/file/oFWsedso%2FpQ9yeDpEvaEqEO4UvrWajYdGOem1ePC9Is%3D",
            "https://img.freepik.com/premium-vector/businessman-avatar-illustration-cartoon-user-portrait-user-profile-icon_118339-5502.jpg",
            "https://png.pngtree.com/png-clipart/20240723/original/pngtree-flat-people-man-icon-illustration-vector-png-image_15612321.png",
            "https://img.freepik.com/premium-photo/profile-icon-white-background_941097-162565.jpg"
        )
    ),
    BestLocations(
        id = 2,
        locName = "Elite Resort",
        isBookmarked = true,
        locAddress = "Ahmedabad, Gujarat",
        rating = "4.9",
        locImageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQug22WOXV0cQUSD7sGQpfyJ0950cOsljEUSw&s",
        placeHolderImage = R.drawable.onboarding_3,
        profileList = listOf(
            "https://cdn-icons-png.flaticon.com/512/2919/2919906.png",
            "https://img.freepik.com/premium-vector/student-avatar-illustration-user-profile-icon-youth-avatar_118339-4405.jpg",
            "https://img.freepik.com/premium-photo/cartoon-boy-with-glasses-smiling-modern-line-icon-avatar_1106493-512908.jpg",
            "https://picsbed.top/file/oFWsedso%2FpQ9yeDpEvaEqEO4UvrWajYdGOem1ePC9Is%3D",
            "https://img.freepik.com/premium-vector/businessman-avatar-illustration-cartoon-user-portrait-user-profile-icon_118339-5502.jpg",
            "https://png.pngtree.com/png-clipart/20240723/original/pngtree-flat-people-man-icon-illustration-vector-png-image_15612321.png",
            "https://img.freepik.com/premium-photo/profile-icon-white-background_941097-162565.jpg"
        )
    ),
    BestLocations(
        id = 3,
        locName = "Resort Enjoyable",
        isBookmarked = true,
        locAddress = "Vadodara, Gujarat",
        rating = "4.5",
        locImageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTgluRMtxuPlS6jUJ7LuZIr3npcmobP9yX2w&s",
        placeHolderImage = R.drawable.onboarding_4,
        profileList = listOf(
            "https://cdn-icons-png.flaticon.com/512/2919/2919906.png",
            "https://img.freepik.com/premium-vector/student-avatar-illustration-user-profile-icon-youth-avatar_118339-4405.jpg",
            "https://img.freepik.com/premium-photo/cartoon-boy-with-glasses-smiling-modern-line-icon-avatar_1106493-512908.jpg",
            "https://picsbed.top/file/oFWsedso%2FpQ9yeDpEvaEqEO4UvrWajYdGOem1ePC9Is%3D",
            "https://img.freepik.com/premium-vector/businessman-avatar-illustration-cartoon-user-portrait-user-profile-icon_118339-5502.jpg",
            "https://png.pngtree.com/png-clipart/20240723/original/pngtree-flat-people-man-icon-illustration-vector-png-image_15612321.png",
            "https://img.freepik.com/premium-photo/profile-icon-white-background_941097-162565.jpg"
        )
    ),
    BestLocations(
        id = 4,
        locName = "Resort Shivgiri",
        isBookmarked = false,
        locAddress = "Junagadh, Gujarat",
        rating = "4.0",
        locImageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTuNTSBhUk-g77DopubwSKrD7Ie6jPeTlWBPA&s",
        placeHolderImage = R.drawable.onboarding_5,
        profileList = listOf(
            "https://cdn-icons-png.flaticon.com/512/2919/2919906.png",
            "https://img.freepik.com/premium-vector/student-avatar-illustration-user-profile-icon-youth-avatar_118339-4405.jpg",
            "https://img.freepik.com/premium-photo/cartoon-boy-with-glasses-smiling-modern-line-icon-avatar_1106493-512908.jpg",
            "https://picsbed.top/file/oFWsedso%2FpQ9yeDpEvaEqEO4UvrWajYdGOem1ePC9Is%3D",
            "https://img.freepik.com/premium-vector/businessman-avatar-illustration-cartoon-user-portrait-user-profile-icon_118339-5502.jpg",
            "https://png.pngtree.com/png-clipart/20240723/original/pngtree-flat-people-man-icon-illustration-vector-png-image_15612321.png",
            "https://img.freepik.com/premium-photo/profile-icon-white-background_941097-162565.jpg"
        )
    ),
    BestLocations(
        id = 5,
        locName = "No-name Resort",
        isBookmarked = false,
        locAddress = "Anand, Gujarat",
        rating = "5.0",
        locImageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTEPPXE2UzEaXDQxAX-XJF9OX7-NUsAhlhusAdLPYQOaDNsrbENARFvCGw&s",
        placeHolderImage = R.drawable.onboarding_1,
        profileList = listOf(
            "https://cdn-icons-png.flaticon.com/512/2919/2919906.png",
            "https://img.freepik.com/premium-vector/student-avatar-illustration-user-profile-icon-youth-avatar_118339-4405.jpg",
            "https://img.freepik.com/premium-photo/cartoon-boy-with-glasses-smiling-modern-line-icon-avatar_1106493-512908.jpg",
            "https://picsbed.top/file/oFWsedso%2FpQ9yeDpEvaEqEO4UvrWajYdGOem1ePC9Is%3D",
            "https://img.freepik.com/premium-vector/businessman-avatar-illustration-cartoon-user-portrait-user-profile-icon_118339-5502.jpg",
            "https://png.pngtree.com/png-clipart/20240723/original/pngtree-flat-people-man-icon-illustration-vector-png-image_15612321.png",
            "https://img.freepik.com/premium-photo/profile-icon-white-background_941097-162565.jpg"
        )
    )
)