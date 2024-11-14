package com.app.travenor.sample_data

import androidx.annotation.DrawableRes
import com.app.travenor.R

data class BestLocations(
    val id: Int,
    val locName: String,
    var isBookmarked: Boolean,
    val locAddress: String,
    val rating: String,
    @DrawableRes val locImage: Int,
    val profileList: List<String>
)

val bestLocationList = listOf(
    BestLocations(
        id = 0,
        locAddress = "Amreli, Gujarat",
        locName = "Prime Resort",
        isBookmarked = true,
        locImage = R.drawable.onboarding_1,
        rating = "4.7",
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
        locAddress = "Surat, Gujarat",
        locName = "Supreme Resort",
        isBookmarked = true,
        locImage = R.drawable.onboarding_2,
        rating = "4.7",
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
        locAddress = "Ahmedabad, Gujarat",
        locName = "Elite Resort",
        isBookmarked = true,
        locImage = R.drawable.onboarding_3,
        rating = "4.9",
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
        locAddress = "Vadodara, Gujarat",
        locName = "Resort Enjoyable",
        isBookmarked = true,
        locImage = R.drawable.onboarding_4,
        rating = "4.5",
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
        locAddress = "Junagadh, Gujarat",
        locName = "Resort Shivgiri",
        isBookmarked = false,
        locImage = R.drawable.onboarding_5,
        rating = "4.0",
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
        locAddress = "Anand, Gujarat",
        locName = "No-name Resort",
        isBookmarked = false,
        locImage = R.drawable.onboarding_1,
        rating = "5.0",
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