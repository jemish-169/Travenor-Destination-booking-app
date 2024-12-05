package com.app.travenor.sample_data

import androidx.annotation.DrawableRes
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import com.app.travenor.R
import com.app.travenor.ui.theme.primary

data class Place(
    val id: Int,
    val name: String,
    val location: String,
    val amount: AnnotatedString,
    val rating: Int,
    val imageUrl: String,
    val isBookMarked: Boolean,
    val reviewerProfiles: List<String> = emptyList(),
    @DrawableRes val placeHolder: Int
)

val placesList = listOf(
    Place(
        id = 1,
        name = "Sunrise Oasis Resort",
        location = "Junagadh, Gujarat",
        amount = getAmount("$672"),
        rating = 4,
        isBookMarked = true,
        reviewerProfiles = listOf(
            "https://img.freepik.com/premium-photo/cartoon-boy-with-glasses-smiling-modern-line-icon-avatar_1106493-512908.jpg",
            "https://img.freepik.com/premium-vector/student-avatar-illustration-user-profile-icon-youth-avatar_118339-4405.jpg",
            "https://img.freepik.com/premium-vector/businessman-avatar-illustration-cartoon-user-portrait-user-profile-icon_118339-5502.jpg",
            "https://picsbed.top/file/oFWsedso%2FpQ9yeDpEvaEqEO4UvrWajYdGOem1ePC9Is%3D",
            "https://png.pngtree.com/png-clipart/20240723/original/pngtree-flat-people-man-icon-illustration-vector-png-image_15612321.png",
            "https://cdn-icons-png.flaticon.com/512/2919/2919906.png",
            "https://img.freepik.com/premium-photo/profile-icon-white-background_941097-162565.jpg"
        ),
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQYvJ_VDDff-v-bWxRLApKXgxCiAuo5GZhyAA&s",
        placeHolder = R.drawable.search_img_1
    ),
    Place(
        id = 2,
        name = "Emerald Valley Retreat",
        location = "Rajkot, Gujarat",
        amount = getAmount("$945"),
        rating = 3,
        reviewerProfiles = listOf(
            "https://img.freepik.com/premium-vector/student-avatar-illustration-user-profile-icon-youth-avatar_118339-4405.jpg",
            "https://png.pngtree.com/png-clipart/20240723/original/pngtree-flat-people-man-icon-illustration-vector-png-image_15612321.png",
            "https://picsbed.top/file/oFWsedso%2FpQ9yeDpEvaEqEO4UvrWajYdGOem1ePC9Is%3D",
            "https://img.freepik.com/premium-photo/cartoon-boy-with-glasses-smiling-modern-line-icon-avatar_1106493-512908.jpg",
            "https://img.freepik.com/premium-vector/businessman-avatar-illustration-cartoon-user-portrait-user-profile-icon_118339-5502.jpg",
            "https://cdn-icons-png.flaticon.com/512/2919/2919906.png",
            "https://img.freepik.com/premium-photo/profile-icon-white-background_941097-162565.jpg"
        ),
        isBookMarked = false,
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcReVUVEFUBMS5u3km8UI_QMllavMhy9rx2N6g&s",
        placeHolder = R.drawable.search_img_2
    ),
    Place(
        id = 3,
        name = "Harmony Hills Resort",
        location = "Gandhinagar, Gujarat",
        amount = getAmount("$789"),
        rating = 5,
        isBookMarked = true,
        reviewerProfiles = listOf(
            "https://img.freepik.com/premium-photo/profile-icon-white-background_941097-162565.jpg",
            "https://png.pngtree.com/png-clipart/20240723/original/pngtree-flat-people-man-icon-illustration-vector-png-image_15612321.png",
            "https://img.freepik.com/premium-vector/student-avatar-illustration-user-profile-icon-youth-avatar_118339-4405.jpg",
            "https://img.freepik.com/premium-vector/businessman-avatar-illustration-cartoon-user-portrait-user-profile-icon_118339-5502.jpg",
            "https://img.freepik.com/premium-photo/cartoon-boy-with-glasses-smiling-modern-line-icon-avatar_1106493-512908.jpg",
            "https://picsbed.top/file/oFWsedso%2FpQ9yeDpEvaEqEO4UvrWajYdGOem1ePC9Is%3D",
            "https://cdn-icons-png.flaticon.com/512/2919/2919906.png"
        ),
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQGwwG2DylOSV8rTzGcNnUM2Ff2ToHvS_r3hQ&s",
        placeHolder = R.drawable.search_img_3
    ),
    Place(
        id = 4,
        name = "Golden Shores Retreat",
        location = "Bharuch, Gujarat",
        amount = getAmount("$612"),
        rating = 2,
        isBookMarked = true,
        reviewerProfiles = listOf(
            "https://img.freepik.com/premium-vector/businessman-avatar-illustration-cartoon-user-portrait-user-profile-icon_118339-5502.jpg",
            "https://cdn-icons-png.flaticon.com/512/2919/2919906.png",
            "https://img.freepik.com/premium-photo/cartoon-boy-with-glasses-smiling-modern-line-icon-avatar_1106493-512908.jpg",
            "https://img.freepik.com/premium-photo/profile-icon-white-background_941097-162565.jpg",
            "https://img.freepik.com/premium-vector/student-avatar-illustration-user-profile-icon-youth-avatar_118339-4405.jpg",
            "https://picsbed.top/file/oFWsedso%2FpQ9yeDpEvaEqEO4UvrWajYdGOem1ePC9Is%3D",
            "https://png.pngtree.com/png-clipart/20240723/original/pngtree-flat-people-man-icon-illustration-vector-png-image_15612321.png"
        ),
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT1Jnm5bF4_mNsczJElFSBwZnSxmcT4tL2Wug&s",
        placeHolder = R.drawable.search_img_4
    ),
    Place(
        id = 5,
        name = "Crystal Springs Resort",
        location = "Porbandar, Gujarat",
        amount = getAmount("$856"),
        rating = 5,
        reviewerProfiles = listOf(
            "https://cdn-icons-png.flaticon.com/512/2919/2919906.png",
            "https://png.pngtree.com/png-clipart/20240723/original/pngtree-flat-people-man-icon-illustration-vector-png-image_15612321.png",
            "https://img.freepik.com/premium-photo/profile-icon-white-background_941097-162565.jpg",
            "https://img.freepik.com/premium-vector/student-avatar-illustration-user-profile-icon-youth-avatar_118339-4405.jpg",
            "https://img.freepik.com/premium-photo/cartoon-boy-with-glasses-smiling-modern-line-icon-avatar_1106493-512908.jpg",
            "https://picsbed.top/file/oFWsedso%2FpQ9yeDpEvaEqEO4UvrWajYdGOem1ePC9Is%3D",
            "https://img.freepik.com/premium-vector/businessman-avatar-illustration-cartoon-user-portrait-user-profile-icon_118339-5502.jpg"
        ),
        isBookMarked = false,
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQO54ZW1yyW2bf8VoCetfFbmT333QbRq6ojEQ&s",
        placeHolder = R.drawable.search_img_1
    ),
    Place(
        id = 6,
        name = "Tranquil Meadows Retreat",
        location = "Jamnagar, Gujarat",
        amount = getAmount("$723"),
        rating = 4,
        isBookMarked = true,
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQPUDeOatnwnFfLgb6n3S6rsVH_53Ot7xxdDA&s",
        placeHolder = R.drawable.search_img_2
    ),
    Place(
        id = 7,
        name = "Mountain View Sanctuary",
        location = "Anand, Gujarat",
        amount = getAmount("$901"),
        rating = 3,
        isBookMarked = true,
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQPA0iyiJWcnLWckBvNRkgv_-nS13hxolTjTQ&s",
        placeHolder = R.drawable.search_img_3
    ),
    Place(
        id = 8,
        name = "Riverside Serenity Resort",
        location = "Nadiad, Gujarat",
        amount = getAmount("$534"),
        rating = 5,
        isBookMarked = false,
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSAnzn8eKGElfjQi-1Ua9EPglTjx-2flCLIiQ&s",
        placeHolder = R.drawable.search_img_4
    ),
    Place(
        id = 9,
        name = "Coastal Breeze Retreat",
        location = "Morbi, Gujarat",
        amount = getAmount("$678"),
        rating = 2,
        isBookMarked = true,
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcREhf4wQzODwQbirGynt7BuQA8VjxQXMfdvjQ&s",
        placeHolder = R.drawable.search_img_1
    ),
    Place(
        id = 10,
        name = "Woodland Haven Resort",
        location = "Bhavnagar, Gujarat",
        amount = getAmount("$912"),
        rating = 1,
        isBookMarked = false,
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTlfjFjk8ueSxubadOOtMiHuPIKSuR7Sriumw&s",
        placeHolder = R.drawable.search_img_2
    ),
    Place(
        id = 11,
        name = "Lakeside Paradise Resort",
        location = "Palanpur, Gujarat",
        amount = getAmount("$567"),
        rating = 4,
        isBookMarked = true,
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR4FC1KkYoy8GQgXIg3soYH8hMgbCZ4JizMOA&s",
        placeHolder = R.drawable.search_img_3
    ),
    Place(
        id = 12,
        name = "Green Valley Escape",
        location = "Navsari, Gujarat",
        amount = getAmount("$834"),
        rating = 3,
        isBookMarked = true,
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSjt3l0YaKL_mQJb7AZPKzGOQ_DkdP5GreQIQ&s",
        placeHolder = R.drawable.search_img_4
    ),
    Place(
        id = 13,
        name = "Sunshine Peaks Resort",
        location = "Vapi, Gujarat",
        amount = getAmount("$456"),
        rating = 5,
        isBookMarked = false,
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRrOk3Z2AkK4E5GIgZ7beF0cNE1vtelqJuxvw&s",
        placeHolder = R.drawable.search_img_1
    ),
    Place(
        id = 14,
        name = "Ocean View Lodge",
        location = "Mehsana, Gujarat",
        amount = getAmount("$789"),
        rating = 2,
        isBookMarked = true,
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSNHebuJmquvqj2DrQRD2iNU8-ecvPi6fUcuA&s",
        placeHolder = R.drawable.search_img_2
    ),
    Place(
        id = 15,
        name = "Forest Retreat Sanctuary",
        location = "Valsad, Gujarat",
        amount = getAmount("$901"),
        rating = 5,
        isBookMarked = false,
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR0Y2efO-h1dNvTw_vp0zqmDZJneRDk-PO_yA&s",
        placeHolder = R.drawable.search_img_3
    ),
    Place(
        id = 16,
        name = "Canyon Creek Resort",
        location = "Amreli, Gujarat",
        amount = getAmount("$623"),
        rating = 4,
        isBookMarked = true,
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