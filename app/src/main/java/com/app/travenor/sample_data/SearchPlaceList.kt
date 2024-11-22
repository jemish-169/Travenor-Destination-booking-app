package com.app.travenor.sample_data

import androidx.annotation.DrawableRes
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import com.app.travenor.R
import com.app.travenor.ui.theme.primary
import com.app.travenor.ui.theme.secondary

data class SearchPlace(
    val id: Int,
    val name: String,
    val location: String,
    val amount: AnnotatedString,
    val imageUrl: String,
    @DrawableRes val placeHolder: Int
)

val searchPlaceList = listOf(
    SearchPlace(
        id = 1,
        name = "Prime Resort",
        location = "Amreli, Gujarat",
        amount = getAmount("$851"),
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ69nti-8_ijCzxKdRYCZfKH7wfL4DT7UFltA&s",
        placeHolder = R.drawable.search_img_1
    ),
    SearchPlace(
        id = 2,
        name = "Supreme Resort",
        location = "Surat, Gujarat",
        amount = getAmount("$824"),
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ69nti-8_ijCzxKdRYCZfKH7wfL4DT7UFltA&s",
        placeHolder = R.drawable.search_img_2
    ),
    SearchPlace(
        id = 3,
        name = "Elite Resort",
        location = "Ahmedabad, Gujarat",
        amount = getAmount("$999"),
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ69nti-8_ijCzxKdRYCZfKH7wfL4DT7UFltA&s",
        placeHolder = R.drawable.search_img_3
    ),
    SearchPlace(
        id = 4,
        name = "Resort Enjoyable",
        location = "Vadodara, Gujarat",
        amount = getAmount("$994"),
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ69nti-8_ijCzxKdRYCZfKH7wfL4DT7UFltA&s",
        placeHolder = R.drawable.search_img_4
    ),
    SearchPlace(
        id = 5,
        name = "Prime Resort",
        location = "Amreli, Gujarat",
        amount = getAmount("$851"),
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ69nti-8_ijCzxKdRYCZfKH7wfL4DT7UFltA&s",
        placeHolder = R.drawable.search_img_1
    ),
    SearchPlace(
        id = 6,
        name = "Supreme Resort",
        location = "Surat, Gujarat",
        amount = getAmount("$824"),
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ69nti-8_ijCzxKdRYCZfKH7wfL4DT7UFltA&s",
        placeHolder = R.drawable.search_img_2
    ),
    SearchPlace(
        id = 7,
        name = "Elite Resort",
        location = "Ahmedabad, Gujarat",
        amount = getAmount("$999"),
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ69nti-8_ijCzxKdRYCZfKH7wfL4DT7UFltA&s",
        placeHolder = R.drawable.search_img_3
    ),
    SearchPlace(
        id = 8,
        name = "Resort Enjoyable",
        location = "Vadodara, Gujarat",
        amount = getAmount("$994"),
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ69nti-8_ijCzxKdRYCZfKH7wfL4DT7UFltA&s",
        placeHolder = R.drawable.search_img_4
    ),
    SearchPlace(
        id = 9,
        name = "Prime Resort",
        location = "Amreli, Gujarat",
        amount = getAmount("$851"),
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ69nti-8_ijCzxKdRYCZfKH7wfL4DT7UFltA&s",
        placeHolder = R.drawable.search_img_1
    ),
    SearchPlace(
        id = 10,
        name = "Supreme Resort",
        location = "Surat, Gujarat",
        amount = getAmount("$824"),
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ69nti-8_ijCzxKdRYCZfKH7wfL4DT7UFltA&s",
        placeHolder = R.drawable.search_img_2
    ),
    SearchPlace(
        id = 11,
        name = "Elite Resort",
        location = "Ahmedabad, Gujarat",
        amount = getAmount("$999"),
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ69nti-8_ijCzxKdRYCZfKH7wfL4DT7UFltA&s",
        placeHolder = R.drawable.search_img_3
    ),
    SearchPlace(
        id = 12,
        name = "Resort Enjoyable",
        location = "Vadodara, Gujarat",
        amount = getAmount("$994"),
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ69nti-8_ijCzxKdRYCZfKH7wfL4DT7UFltA&s",
        placeHolder = R.drawable.search_img_4
    ),
    SearchPlace(
        id = 13,
        name = "Prime Resort",
        location = "Amreli, Gujarat",
        amount = getAmount("$851"),
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ69nti-8_ijCzxKdRYCZfKH7wfL4DT7UFltA&s",
        placeHolder = R.drawable.search_img_1
    ),
    SearchPlace(
        id = 14,
        name = "Supreme Resort",
        location = "Surat, Gujarat",
        amount = getAmount("$824"),
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ69nti-8_ijCzxKdRYCZfKH7wfL4DT7UFltA&s",
        placeHolder = R.drawable.search_img_2
    ),
    SearchPlace(
        id = 15,
        name = "Elite Resort",
        location = "Ahmedabad, Gujarat",
        amount = getAmount("$999"),
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ69nti-8_ijCzxKdRYCZfKH7wfL4DT7UFltA&s",
        placeHolder = R.drawable.search_img_3
    ),
    SearchPlace(
        id = 16,
        name = "Resort Enjoyable",
        location = "Vadodara, Gujarat",
        amount = getAmount("$994"),
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ69nti-8_ijCzxKdRYCZfKH7wfL4DT7UFltA&s",
        placeHolder = R.drawable.search_img_4
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