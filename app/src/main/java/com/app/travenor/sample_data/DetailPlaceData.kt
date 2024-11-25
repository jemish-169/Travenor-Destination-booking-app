package com.app.travenor.sample_data

import androidx.annotation.DrawableRes
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import com.app.travenor.R
import com.app.travenor.ui.theme.primary

data class DetailPlaceData(
    val placeImageUrl: String,
    val placeName: String,
    val placeAddress: String,
    val placeLoc: String,
    val rating: String,
    val ratingCount: Int,
    val amount: AnnotatedString,
    val placeDesc: String,
    val placeImageList: List<String>,
    val profileUrl: String,
    @DrawableRes val placePlaceHolderImage: Int,
    @DrawableRes val profilePlaceHolder: Int,
    @DrawableRes val placePlaceHolderImageList: List<Int>
)

val detailPlaceData = DetailPlaceData(
    placeImageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTuNTSBhUk-g77DopubwSKrD7Ie6jPeTlWBPA&s",
    placeName = "Niladri Reservoir",
    placeAddress = "Tekergat, Sunamgnj",
    placeLoc = "Tekergat",
    rating = "4.7",
    ratingCount = 2498,
    amount = getAmount("$59"),
    placeDesc = "You will get a complete travel package on the beaches. Packages in the form of airline tickets, recommended Hotel rooms, Transportation, Have you ever been on holiday to the Greek, You will get a complete travel package on the beaches. Packages in the form of airline tickets, recommended Hotel rooms, Transportation, Have you ever been on holiday to the Greek, You will get a complete travel package on the beaches. Packages in the form of airline tickets, recommended Hotel rooms, Transportation, Have you ever been on holiday to the Greek",
    placeImageList = listOf(
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ69nti-8_ijCzxKdRYCZfKH7wfL4DT7UFltA&s",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ69nti-8_ijCzxKdRYCZfKH7wfL4DT7UFltA&s",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ69nti-8_ijCzxKdRYCZfKH7wfL4DT7UFltA&s",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ69nti-8_ijCzxKdRYCZfKH7wfL4DT7UFltA&s",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ69nti-8_ijCzxKdRYCZfKH7wfL4DT7UFltA&s",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ69nti-8_ijCzxKdRYCZfKH7wfL4DT7UFltA&s",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ69nti-8_ijCzxKdRYCZfKH7wfL4DT7UFltA&s",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ69nti-8_ijCzxKdRYCZfKH7wfL4DT7UFltA&s",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ69nti-8_ijCzxKdRYCZfKH7wfL4DT7UFltA&s",
    ),
    placePlaceHolderImage = R.drawable.search_img_1,
    profileUrl = "https://cdn-icons-png.flaticon.com/512/2919/2919906.png",
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

private fun getAmount(amount: String): AnnotatedString {
    return buildAnnotatedString {
        withStyle(SpanStyle(color = primary)) {
            append("$amount/")
        }
        append("Person")
    }
}
