package com.app.travenor.features.home.presentation

import androidx.compose.foundation.background
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.app.travenor.R
import com.app.travenor.sample_data.BestLocations
import com.app.travenor.ui.theme.secondary

@Composable
fun DestinationItem(location: BestLocations, onBookmarkClick: () -> Unit) {
    val isBookmarked = remember { mutableStateOf(location.isBookmarked) }
    Column(
        modifier = Modifier
            .padding(1.dp)
            .padding(end = 16.dp)
            .shadow(
                elevation = 3.dp,
                shape = RoundedCornerShape(24.dp),
                spotColor = MaterialTheme.colorScheme.tertiary.copy(alpha = 0.3f)
            )
            .clip(RoundedCornerShape(24.dp))
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
                    .data(location.locImageUrl)
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(id = location.placeHolderImage),
                error = painterResource(id = location.placeHolderImage),
                fallback = painterResource(id = location.placeHolderImage),
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
                    location.isBookmarked = isBookmarked.value
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
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = location.locName,
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp,
                    lineHeight = 24.sp,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(3.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_star),
                        contentDescription = "rating icon",
                        tint = secondary
                    )
                    Text(
                        text = location.rating,
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
                        text = location.locAddress,
                        fontWeight = FontWeight.Normal,
                        fontSize = 15.sp,
                        lineHeight = 20.sp,
                        color = MaterialTheme.colorScheme.tertiary
                    )
                }

                Row(horizontalArrangement = Arrangement.spacedBy((-11).dp)) {
                    if (location.profileList.size >= 3) {
                        location.profileList.take(3).forEachIndexed { index, imgUrl ->
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
                                text = "+${location.profileList.size - 3}",
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
        BestLocations(
            id = 1,
            locName = "Elite Resort",
            isBookmarked = true,
            locAddress = "Ahmedabad, Gujarat",
            rating = "4.9",
            locImageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR78OI5Pcmb5ELnr2lNRHjn_sMJAG2VxNRQug&s",
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
        )
    ) {}
}