package com.app.travenor.features.detail.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.StarRate
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.app.travenor.R
import com.app.travenor.sample_data.detailPlaceData
import com.app.travenor.ui.theme.ratingBarColor

@Composable
fun DetailScreen(
    innerPadding: PaddingValues,
    onBackClick: () -> Unit,
    onBookNowClick: () -> Unit
) {
    val data = detailPlaceData
    var isExpanded by remember { mutableStateOf(false) }
    val maxLines by animateIntAsState(targetValue = if (isExpanded) Int.MAX_VALUE else 3,
        label = "desc animation"
    )

    Box(
        modifier = Modifier
            .padding(innerPadding),
        contentAlignment = Alignment.TopCenter
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(data.profileUrl)
                .crossfade(true)
                .build(),
            placeholder = painterResource(id = data.placePlaceHolderImage),
            error = painterResource(id = data.placePlaceHolderImage),
            fallback = painterResource(id = data.placePlaceHolderImage),
            contentDescription = "place image"
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.tertiary),
                onClick = onBackClick
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                    contentDescription = "Back Icon",
                    tint = MaterialTheme.colorScheme.surface
                )
            }

            Text(
                text = "Details",
                fontSize = 18.sp,
                lineHeight = 22.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.surface
            )

            IconButton(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.tertiary),
                onClick = {
                }
            ) {
                Icon(
                    imageVector = Icons.Default.BookmarkBorder,
                    contentDescription = "Book-mark Icon",
                    tint = MaterialTheme.colorScheme.surface
                )
            }
        }
    }

    Box(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(topEnd = 32.dp, topStart = 32.dp))
                .background(MaterialTheme.colorScheme.surface)
                .padding(20.dp)
        ) {
            Spacer(
                modifier = Modifier
                    .height(5.dp)
                    .width(36.dp)
                    .clip(RoundedCornerShape(50))
                    .align(Alignment.CenterHorizontally)
                    .background(MaterialTheme.colorScheme.tertiary)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = data.placeName,
                        fontSize = 24.sp,
                        lineHeight = 32.sp,
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = data.placeAddress,
                        fontSize = 15.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight.Normal,
                        color = MaterialTheme.colorScheme.tertiary
                    )
                }
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(data.profileUrl)
                        .crossfade(true)
                        .build(),
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape),
                    placeholder = painterResource(id = data.profilePlaceHolder),
                    error = painterResource(id = data.profilePlaceHolder),
                    fallback = painterResource(id = data.profilePlaceHolder),
                    contentDescription = "Profile icon"
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_location),
                        contentDescription = "location icon",
                        tint = MaterialTheme.colorScheme.tertiary
                    )
                    Text(
                        text = data.placeLoc,
                        fontSize = 15.sp,
                        lineHeight = 20.sp,
                        color = MaterialTheme.colorScheme.tertiary,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        modifier = Modifier.size(16.dp),
                        imageVector = Icons.Default.StarRate,
                        contentDescription = "location icon",
                        tint = ratingBarColor
                    )
                    Text(
                        text = data.rating,
                        fontSize = 15.sp,
                        lineHeight = 20.sp,
                        color = MaterialTheme.colorScheme.onSurface,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier.padding(start = 4.dp),
                    )
                    Text(
                        text = "(${data.ratingCount})",
                        fontSize = 15.sp,
                        lineHeight = 20.sp,
                        color = MaterialTheme.colorScheme.tertiary,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier.padding(start = 2.dp),
                    )
                }

                Text(
                    text = data.amount,
                    fontSize = 15.sp,
                    lineHeight = 20.sp,
                    color = MaterialTheme.colorScheme.tertiary,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(start = 4.dp)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                for (i in 0..3) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(data.placeImageUrl[i])
                            .crossfade(true)
                            .build(),
                        modifier = Modifier
                            .size(42.dp)
                            .clip(RoundedCornerShape(12.dp)),
                        contentScale = ContentScale.Crop,
                        placeholder = painterResource(id = data.placePlaceHolderImageList[i]),
                        error = painterResource(id = data.placePlaceHolderImageList[i]),
                        fallback = painterResource(id = data.placePlaceHolderImageList[i]),
                        contentDescription = "place image"
                    )
                }
                Box(contentAlignment = Alignment.Center) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(data.placeImageUrl[4])
                            .crossfade(true)
                            .build(),
                        modifier = Modifier
                            .size(42.dp)
                            .clip(RoundedCornerShape(12.dp)),
                        contentScale = ContentScale.Crop,
                        placeholder = painterResource(id = data.placePlaceHolderImageList[4]),
                        error = painterResource(id = data.placePlaceHolderImageList[4]),
                        fallback = painterResource(id = data.placePlaceHolderImageList[4]),
                        contentDescription = "place image"
                    )
                    Spacer(
                        modifier = Modifier
                            .size(42.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(MaterialTheme.colorScheme.tertiary.copy(0.5f))
                    )
                    Text(
                        text = "+${data.placePlaceHolderImageList.size - 4}",
                        fontSize = 15.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight.Normal,
                        color = MaterialTheme.colorScheme.surface
                    )
                }
            }

            Text(
                text = "About Destination",
                fontSize = 20.sp,
                lineHeight = 28.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.padding(top = 24.dp)
            )

            AnimatedVisibility(visible = true) {
                Text(
                    text = data.placeDesc,
                    maxLines = maxLines.coerceAtLeast(1),
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .pointerInput(Unit) {
                            detectTapGestures(
                                onTap = {
                                    isExpanded = !isExpanded
                                }
                            )
                        },
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 13.sp,
                    lineHeight = 22.sp,
                    fontWeight = FontWeight.Normal,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }

            Text(
                text = "Book Now",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(MaterialTheme.colorScheme.primary)
                    .clickable { onBookNowClick() }
                    .padding(16.dp),
                fontSize = 16.sp,
                lineHeight = 20.sp,
                color = MaterialTheme.colorScheme.surface
            )
        }
    }
}

@Preview
@Composable
fun DetailScreenPreview() {
    DetailScreen(innerPadding = PaddingValues(0.dp), {}, {})
}
