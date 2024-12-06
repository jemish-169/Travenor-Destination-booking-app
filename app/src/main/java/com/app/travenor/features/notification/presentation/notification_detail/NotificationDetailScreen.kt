package com.app.travenor.features.notification.presentation.notification_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
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
import com.app.travenor.sample_data.Notification
import com.app.travenor.sample_data.notificationList

@Composable
fun NotificationDetailScreen(
    innerPadding: PaddingValues,
    notificationType: Int,
    notification: Notification,
    onBackClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
        ) {
            IconButton(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.onTertiary),
                onClick = onBackClick
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                    contentDescription = "Back Icon"
                )
            }

            Text(
                modifier = Modifier.align(Alignment.Center),
                text = getNotificationType(notificationType),
                fontSize = 18.sp,
                lineHeight = 22.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onSurface
            )
        }

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(notification.notificationIcon)
                .crossfade(true)
                .build(),
            modifier = Modifier
                .clip(CircleShape),
            placeholder = painterResource(id = R.drawable.profile_ph1),
            error = painterResource(id = R.drawable.profile_ph1),
            fallback = painterResource(id = R.drawable.profile_ph1),
            contentDescription = "Profile image"
        )

        Text(
            modifier = Modifier.padding(top = 24.dp),
            text = notification.notificationTitle,
            fontSize = 24.sp,
            lineHeight = 28.sp,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.onSurface
        )
        Text(
            modifier = Modifier
                .padding(top = 8.dp)
                .align(Alignment.End),
            text = notification.notificationTime,
            fontSize = 14.sp,
            lineHeight = 18.sp,
            fontWeight = FontWeight.Normal,
            color = MaterialTheme.colorScheme.tertiary
        )
        Text(
            modifier = Modifier.padding(top = 24.dp),
            text = notification.notificationDesc,
            fontSize = 16.sp,
            lineHeight = 22.sp,
            fontWeight = FontWeight.Normal,
            color = MaterialTheme.colorScheme.tertiary
        )
    }
}

fun getNotificationType(notificationType: Int): String {
    return when (notificationType) {
        1 -> "Recent Notification"
        2 -> "Earlier Notification"
        else -> "Archived notification"
    }
}

@Preview
@Composable
fun NotificationDetailScreenPreview() {
    NotificationDetailScreen(
        innerPadding = PaddingValues(0.dp),
        notificationType = 1,
        notification = notificationList.first()
    ) {}
}