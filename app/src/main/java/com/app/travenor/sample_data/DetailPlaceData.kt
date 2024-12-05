package com.app.travenor.sample_data

import androidx.annotation.DrawableRes
import com.app.travenor.R

data class DetailPlaceData(
    val ratingCount: Int,
    val placeDesc: String,
    val placeImageList: List<String>,
    val profileUrl: String,
    @DrawableRes val placePlaceHolderImage: Int,
    @DrawableRes val profilePlaceHolder: Int,
    @DrawableRes val placePlaceHolderImageList: List<Int>
)

val detailPlaceData = DetailPlaceData(
    ratingCount = 2498,
    placeDesc = "You will get a complete travel package on the beaches. Packages in the form of airline tickets, recommended Hotel rooms, Transportation, Have you ever been on holiday to the Greek, You will get a complete travel package on the beaches. Packages in the form of airline tickets, recommended Hotel rooms, Transportation, Have you ever been on holiday to the Greek, You will get a complete travel package on the beaches. Packages in the form of airline tickets, recommended Hotel rooms, Transportation, Have you ever been on holiday to the Greek",
    placeImageList = listOf(
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQO54ZW1yyW2bf8VoCetfFbmT333QbRq6ojEQ&s",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcReVUVEFUBMS5u3km8UI_QMllavMhy9rx2N6g&s",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQYvJ_VDDff-v-bWxRLApKXgxCiAuo5GZhyAA&s",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT1Jnm5bF4_mNsczJElFSBwZnSxmcT4tL2Wug&s",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQGwwG2DylOSV8rTzGcNnUM2Ff2ToHvS_r3hQ&s",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQPUDeOatnwnFfLgb6n3S6rsVH_53Ot7xxdDA&s",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQPA0iyiJWcnLWckBvNRkgv_-nS13hxolTjTQ&s",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSAnzn8eKGElfjQi-1Ua9EPglTjx-2flCLIiQ&s",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcREhf4wQzODwQbirGynt7BuQA8VjxQXMfdvjQ&s",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTlfjFjk8ueSxubadOOtMiHuPIKSuR7Sriumw&s",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR4FC1KkYoy8GQgXIg3soYH8hMgbCZ4JizMOA&s"
    ),
    placePlaceHolderImage = R.drawable.search_img_1,
    profileUrl = "https://img.freepik.com/free-vector/young-boy-vector-illustration_1308-175706.jpg",
    profilePlaceHolder = R.drawable.profile_ph3,
    placePlaceHolderImageList = listOf(
        R.drawable.search_img_1,
        R.drawable.search_img_2,
        R.drawable.search_img_3,
        R.drawable.search_img_4,
        R.drawable.onboarding_1,
        R.drawable.onboarding_2,
        R.drawable.onboarding_3,
        R.drawable.onboarding_4,
        R.drawable.onboarding_5,
    )
)