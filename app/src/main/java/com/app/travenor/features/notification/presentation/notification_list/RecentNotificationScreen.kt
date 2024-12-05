package com.app.travenor.features.notification.presentation.notification_list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.app.travenor.R
import com.app.travenor.sample_data.Notification
import com.app.travenor.sample_data.notificationList

@Composable
fun RecentNotificationScreen(onNotificationClick: (Int, Notification) -> Unit) {
    LazyColumn {
        items(items = notificationList.takeLast(5), key = { it.id }) { notification ->
            ListItem(
                modifier = Modifier.clickable { onNotificationClick(1, notification) },
                headlineContent = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = notification.notificationTitle,
                            fontSize = 18.sp,
                            lineHeight = 24.sp,
                            fontWeight = FontWeight.Medium,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.weight(1f),
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = notification.notificationTime,
                            fontSize = 11.sp,
                            lineHeight = 16.sp,
                            fontWeight = FontWeight.Normal,
                            color = MaterialTheme.colorScheme.tertiary
                        )
                    }
                },
                supportingContent = {
                    Text(
                        text = notification.notificationDesc,
                        fontSize = 14.sp,
                        lineHeight = 16.sp,
                        fontWeight = FontWeight.Normal,
                        color = MaterialTheme.colorScheme.tertiary,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                leadingContent = {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(notification.notificationIcon)
                            .crossfade(true)
                            .build(),
                        modifier = Modifier
                            .size(48.dp)
                            .clip(CircleShape),
                        placeholder = painterResource(id = R.drawable.profile_ph1),
                        error = painterResource(id = R.drawable.profile_ph1),
                        fallback = painterResource(id = R.drawable.profile_ph1),
                        contentDescription = "Profile icon"
                    )
                }
            )
        }
    }
}


@Preview
@Composable
fun NotificationPagerScreenPreview() {
    RecentNotificationScreen{ _, _ -> }
}

