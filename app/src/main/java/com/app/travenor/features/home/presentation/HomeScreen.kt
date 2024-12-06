package com.app.travenor.features.home.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.app.travenor.features.onboarding.domain.getMainPageText
import com.app.travenor.sample_data.DetailPlace
import com.app.travenor.sample_data.getProfileUrl
import com.app.travenor.sample_data.placesList
import com.app.travenor.sample_data.toDetailPlace

@Composable
fun HomeScreen(
    innerPadding: PaddingValues,
    onNotificationClick: () -> Unit,
    onProfileClick: () -> Unit,
    onItemClick: (DetailPlace) -> Unit,
    navigateToPopular: () -> Unit
) {

    Column(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
            .padding(20.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.onTertiary, CircleShape)
                    .clip(CircleShape)
                    .clickable { onProfileClick() }
                    .padding(4.dp)
                    .padding(end = 8.dp)
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(getProfileUrl())
                        .crossfade(true)
                        .build(),
                    modifier = Modifier
                        .size(37.dp)
                        .clip(CircleShape),
                    placeholder = painterResource(id = R.drawable.ic_profile_img),
                    error = painterResource(id = R.drawable.ic_profile_img),
                    fallback = painterResource(id = R.drawable.ic_profile_img),
                    contentDescription = "Profile icon"
                )
                Text(
                    text = "Leonardo",
                    fontSize = 14.sp,
                    lineHeight = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
            IconButton(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.onTertiary),
                onClick = onNotificationClick
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_notification_icon),
                    contentDescription = "Notification Icon"
                )
            }
        }

        Text(
            modifier = Modifier
                .padding(top = 36.dp),
            text = getMainPageText(),
            fontSize = 38.sp,
            lineHeight = 50.sp,
            color = MaterialTheme.colorScheme.onSurface
        )

        Row(
            modifier = Modifier
                .padding(top = 26.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Best Destination",
                fontSize = 20.sp,
                lineHeight = 28.sp,
                color = MaterialTheme.colorScheme.onSurface,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = "View all",
                fontSize = 20.sp,
                lineHeight = 28.sp,
                color = MaterialTheme.colorScheme.secondary,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .clip(RoundedCornerShape(100))
                    .clickable {
                        navigateToPopular()
                    }
                    .padding(vertical = 2.dp)
                    .padding(horizontal = 10.dp)
            )
        }

        LazyRow(
            contentPadding = PaddingValues(vertical = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(items = placesList.take(5), key = { it.id }) { place ->
                DestinationItem(
                    place = place,
                    onItemClick = { onItemClick(place.toDetailPlace()) },
                    onBookmarkClick = { }
                )
            }
        }
    }
}

@Composable
@Preview
fun HomeScreenPreView() {
    HomeScreen(PaddingValues(0.dp), {}, {}, {}, {})
}