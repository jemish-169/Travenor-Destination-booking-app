package com.app.travenor.features.home.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.app.travenor.R
import com.app.travenor.sample_data.Place
import com.app.travenor.ui.theme.ratingBarColor

@Composable
fun DestinationItem(
    place: Place,
    onBookmarkClick: () -> Unit,
    onItemClick: () -> Unit
) {
    val isBookmarked = remember { mutableStateOf(place.isBookMarked) }
    Column(
        modifier = Modifier
            .padding(1.dp)
            .shadow(
                elevation = 3.dp,
                shape = RoundedCornerShape(24.dp),
                spotColor = MaterialTheme.colorScheme.tertiary.copy(alpha = 0.3f)
            )
            .clip(RoundedCornerShape(24.dp))
            .clickable { onItemClick() }
            .background(MaterialTheme.colorScheme.surface)
            .width(268.dp)
            .height(384.dp)
            .padding(14.dp)
    ) {
        Box {
            AsyncImage(
                modifier = Modifier
                    .width(240.dp)
                    .height(286.dp)
                    .clip(RoundedCornerShape(20.dp)),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(place.imageUrl)
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(id = place.placeHolder),
                error = painterResource(id = place.placeHolder),
                fallback = painterResource(id = place.placeHolder),
                contentDescription = "item desc",
                contentScale = ContentScale.Crop
            )
            IconButton(
                modifier = Modifier
                    .padding(top = 14.dp)
                    .padding(end = 14.dp)
                    .height(34.dp)
                    .width(34.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.tertiary.copy(alpha = 0.35f))
                    .align(Alignment.TopEnd)
                    .padding(8.dp),
                onClick = {
                    isBookmarked.value = !isBookmarked.value
                    onBookmarkClick()
                }
            ) {
                Icon(
                    imageVector = if (isBookmarked.value) Icons.Default.Bookmark else Icons.Default.BookmarkBorder,
                    contentDescription = "Back Icon",
                    tint = MaterialTheme.colorScheme.secondary
                )
            }
        }

        Column(
            modifier = Modifier
                .padding(horizontal = 6.dp)
                .padding(top = 14.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = place.name,
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp,
                    lineHeight = 24.sp,
                    color = MaterialTheme.colorScheme.onSurface,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(3.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_star),
                        contentDescription = "rating icon",
                        tint = ratingBarColor
                    )
                    Text(
                        text = place.rating.toString(),
                        fontWeight = FontWeight.Normal,
                        fontSize = 15.sp,
                        lineHeight = 20.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }

            Row(
                modifier = Modifier
                    .padding(top = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Row(
                    modifier = Modifier
                        .weight(1f),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_location),
                        contentDescription = "location icon",
                        tint = MaterialTheme.colorScheme.tertiary
                    )
                    Text(
                        text = place.location,
                        fontWeight = FontWeight.Normal,
                        fontSize = 15.sp,
                        lineHeight = 20.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        color = MaterialTheme.colorScheme.tertiary
                    )
                }

                Row(horizontalArrangement = Arrangement.spacedBy((-11).dp)) {
                    if (place.reviewerProfiles.size >= 3) {
                        place.reviewerProfiles.take(3).forEachIndexed { index, imgUrl ->
                            AsyncImage(
                                model = ImageRequest.Builder(LocalContext.current)
                                    .data(imgUrl)
                                    .crossfade(true)
                                    .build(),
                                contentDescription = "profile icon $index",
                                placeholder = painterResource(id = getPlaceHolderImage(index)),
                                error = painterResource(id = getPlaceHolderImage(index)),
                                fallback = painterResource(id = getPlaceHolderImage(index)),
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(24.dp)
                                    .clip(CircleShape)
                            )
                        }
                        Box(
                            modifier = Modifier
                                .size(24.dp)
                                .clip(CircleShape)
                                .background(MaterialTheme.colorScheme.primary),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "+${place.reviewerProfiles.size - 3}",
                                color = MaterialTheme.colorScheme.background,
                                fontSize = 11.sp,
                                lineHeight = 13.sp,
                                fontWeight = FontWeight.Normal
                            )
                        }
                    }
                }
            }
        }
    }
}

fun getPlaceHolderImage(index: Int): Int {
    return when (index) {
        0 -> R.drawable.profile_ph3
        1 -> R.drawable.profile_ph2
        else -> R.drawable.profile_ph1
    }
}

@Preview
@Composable
fun DestinationItemPreview() {
    DestinationItem(
        Place(
            id = 1,
            name = "Sunrise Oasis Resort",
            location = "Junagadh, Gujarat",
            amount = AnnotatedString("$672"),
            rating = 4,
            reviewerProfiles = listOf(
                "https://img.freepik.com/premium-photo/cartoon-boy-with-glasses-smiling-modern-line-icon-avatar_1106493-512908.jpg",
                "https://img.freepik.com/premium-vector/student-avatar-illustration-user-profile-icon-youth-avatar_118339-4405.jpg",
                "https://img.freepik.com/premium-vector/businessman-avatar-illustration-cartoon-user-portrait-user-profile-icon_118339-5502.jpg",
                "https://picsbed.top/file/oFWsedso%2FpQ9yeDpEvaEqEO4UvrWajYdGOem1ePC9Is%3D",
                "https://png.pngtree.com/png-clipart/20240723/original/pngtree-flat-people-man-icon-illustration-vector-png-image_15612321.png",
                "https://cdn-icons-png.flaticon.com/512/2919/2919906.png",
                "https://img.freepik.com/premium-photo/profile-icon-white-background_941097-162565.jpg"
            ),
            imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQO54ZW1yyW2bf8VoCetfFbmT333QbRq6ojEQ&s",
            placeHolder = R.drawable.search_img_1,
            isBookMarked = false
        ),
        {},
        {  }
    )
}