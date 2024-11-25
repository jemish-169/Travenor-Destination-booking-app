package com.app.travenor.sample_data

import androidx.annotation.DrawableRes
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import com.app.travenor.R
import com.app.travenor.ui.theme.primary

data class PopularPlace(
    val id: Int,
    val name: String,
    val location: String,
    val amount: AnnotatedString,
    val rating: Int,
    val imageUrl: String,
    @DrawableRes val placeHolder: Int
)

val popularPlaceList = listOf(
    PopularPlace(
        id = 1,
        name = "Prime Resort",
        location = "Amreli, Gujarat",
        amount = getAmount("$851"),
        rating = 2,
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ69nti-8_ijCzxKdRYCZfKH7wfL4DT7UFltA&s",
        placeHolder = R.drawable.search_img_1
    ),
    PopularPlace(
        id = 2,
        name = "Supreme Resort",
        location = "Surat, Gujarat",
        amount = getAmount("$824"),
        rating = 3,
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ69nti-8_ijCzxKdRYCZfKH7wfL4DT7UFltA&s",
        placeHolder = R.drawable.search_img_2
    ),
    PopularPlace(
        id = 3,
        name = "Elite Resort",
        location = "Ahmedabad, Gujarat",
        amount = getAmount("$999"),
        rating = 4,
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ69nti-8_ijCzxKdRYCZfKH7wfL4DT7UFltA&s",
        placeHolder = R.drawable.search_img_3
    ),
    PopularPlace(
        id = 4,
        name = "Resort Enjoyable",
        location = "Vadodara, Gujarat",
        amount = getAmount("$994"),
        rating = 5,
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ69nti-8_ijCzxKdRYCZfKH7wfL4DT7UFltA&s",
        placeHolder = R.drawable.search_img_4
    ),
    PopularPlace(
        id = 5,
        name = "Prime Resort",
        location = "Amreli, Gujarat",
        amount = getAmount("$851"),
        rating = 2,
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ69nti-8_ijCzxKdRYCZfKH7wfL4DT7UFltA&s",
        placeHolder = R.drawable.search_img_1
    ),
    PopularPlace(
        id = 6,
        name = "Supreme Resort",
        location = "Surat, Gujarat",
        amount = getAmount("$824"),
        rating = 3,
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ69nti-8_ijCzxKdRYCZfKH7wfL4DT7UFltA&s",
        placeHolder = R.drawable.search_img_2
    ),
    PopularPlace(
        id = 7,
        name = "Elite Resort",
        location = "Ahmedabad, Gujarat",
        amount = getAmount("$999"),
        rating = 4,
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ69nti-8_ijCzxKdRYCZfKH7wfL4DT7UFltA&s",
        placeHolder = R.drawable.search_img_3
    ),
    PopularPlace(
        id = 8,
        name = "Resort Enjoyable",
        location = "Vadodara, Gujarat",
        amount = getAmount("$994"),
        rating = 1,
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ69nti-8_ijCzxKdRYCZfKH7wfL4DT7UFltA&s",
        placeHolder = R.drawable.search_img_4
    ),
    PopularPlace(
        id = 9,
        name = "Prime Resort",
        location = "Amreli, Gujarat",
        amount = getAmount("$851"),
        rating = 2,
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ69nti-8_ijCzxKdRYCZfKH7wfL4DT7UFltA&s",
        placeHolder = R.drawable.search_img_1
    ),
    PopularPlace(
        id = 10,
        name = "Supreme Resort",
        location = "Surat, Gujarat",
        amount = getAmount("$824"),
        rating = 5,
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ69nti-8_ijCzxKdRYCZfKH7wfL4DT7UFltA&s",
        placeHolder = R.drawable.search_img_2
    ),
    PopularPlace(
        id = 11,
        name = "Elite Resort",
        location = "Ahmedabad, Gujarat",
        amount = getAmount("$999"),
        rating = 2,
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ69nti-8_ijCzxKdRYCZfKH7wfL4DT7UFltA&s",
        placeHolder = R.drawable.search_img_3
    ),
    PopularPlace(
        id = 12,
        name = "Resort Enjoyable",
        location = "Vadodara, Gujarat",
        amount = getAmount("$994"),
        rating = 4,
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ69nti-8_ijCzxKdRYCZfKH7wfL4DT7UFltA&s",
        placeHolder = R.drawable.search_img_4
    ),
    PopularPlace(
        id = 13,
        name = "Prime Resort",
        location = "Amreli, Gujarat",
        amount = getAmount("$851"),
        rating = 3,
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ69nti-8_ijCzxKdRYCZfKH7wfL4DT7UFltA&s",
        placeHolder = R.drawable.search_img_1
    ),
    PopularPlace(
        id = 14,
        name = "Supreme Resort",
        location = "Surat, Gujarat",
        amount = getAmount("$824"),
        rating = 2,
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ69nti-8_ijCzxKdRYCZfKH7wfL4DT7UFltA&s",
        placeHolder = R.drawable.search_img_2
    ),
    PopularPlace(
        id = 15,
        name = "Elite Resort",
        location = "Ahmedabad, Gujarat",
        amount = getAmount("$999"),
        rating = 5,
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ69nti-8_ijCzxKdRYCZfKH7wfL4DT7UFltA&s",
        placeHolder = R.drawable.search_img_3
    ),
    PopularPlace(
        id = 16,
        name = "Resort Enjoyable",
        location = "Vadodara, Gujarat",
        amount = getAmount("$994"),
        rating = 1,
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