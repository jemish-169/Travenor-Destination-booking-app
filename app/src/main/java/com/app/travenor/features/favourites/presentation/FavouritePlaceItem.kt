package com.app.travenor.features.favourites.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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

@Composable
fun FavouritePlaceItem(place: Place, onItemClick: () -> Unit) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .padding(1.dp)
                .shadow(
                    elevation = 3.dp,
                    shape = RoundedCornerShape(16.dp),
                    spotColor = MaterialTheme.colorScheme.tertiary.copy(alpha = 0.3f)
                )
                .clip(RoundedCornerShape(16.dp))
                .clickable { onItemClick() }
                .background(MaterialTheme.colorScheme.surface)
                .padding(12.dp)
                .width(137.dp)
        ) {
            AsyncImage(
                modifier = Modifier
                    .width(137.dp)
                    .height(124.dp)
                    .clip(RoundedCornerShape(16.dp)),
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
            Text(
                text = place.name,
                fontSize = 14.sp,
                lineHeight = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onSurface,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(top = 8.dp, start = 4.dp)
            )
            Row(
                modifier = Modifier.padding(top = 6.dp),
                horizontalArrangement = Arrangement.spacedBy(3.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_location),
                    contentDescription = "location icon",
                    tint = MaterialTheme.colorScheme.tertiary
                )
                Text(
                    text = place.location,
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = MaterialTheme.colorScheme.tertiary,
                    fontWeight = FontWeight.Normal
                )
            }
        }
    }
}

@Preview
@Composable
fun FavouritePlaceItemPreView() {
    FavouritePlaceItem(
        place = Place(
            id = 1,
            name = "Sunrise Oasis Resort",
            location = "Junagadh, Gujarat",
            amount = AnnotatedString("$672"),
            rating = 4,
            imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQO54ZW1yyW2bf8VoCetfFbmT333QbRq6ojEQ&s",
            placeHolder = R.drawable.search_img_1,
            isBookMarked = false
        ),
        onItemClick = {},
    )
}