package com.app.travenor.features.notification.presentation.notification_list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.travenor.sample_data.Notification

@Composable
fun NotificationListScreen(
    innerPadding: PaddingValues,
    onBackClick: () -> Unit,
    onNotificationClick: (Int, Notification) -> Unit,
    onClearAllClicked: (Int) -> Unit
) {
    val pagerState = rememberPagerState(pageCount = { 3 })
    val tabList = listOf("Recent", "Earlier", "Archived")

    Column(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
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
                    .background(MaterialTheme.colorScheme.onTertiary),
                onClick = onBackClick
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                    contentDescription = "Back Icon"
                )
            }

            Text(
                text = "Notification",
                fontSize = 18.sp,
                lineHeight = 22.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onSurface
            )

            Text(
                text = "Clear all",
                fontSize = 16.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier
                    .clip(RoundedCornerShape(100))
                    .clickable {
                        onClearAllClicked(pagerState.currentPage)
                    }
                    .padding(vertical = 6.dp)
                    .padding(horizontal = 10.dp)
            )

        }
        Spacer(modifier = Modifier.height(6.dp))
        TabRow(
            selectedTabIndex = pagerState.currentPage,
            indicator = { tabPositions ->
                TabRowDefaults.SecondaryIndicator(
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier
                        .tabIndicatorOffset(tabPositions[pagerState.currentPage])
                )
            }) {
            tabList.forEachIndexed { index, title ->
                Tab(
                    selected = pagerState.currentPage == index,
                    onClick = {},
                    text = {
                        Text(
                            text = title,
                            fontSize = 16.sp,
                            lineHeight = 20.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    },
                    selectedContentColor = MaterialTheme.colorScheme.secondary,
                    unselectedContentColor = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.clip(
                        RoundedCornerShape(
                            topStartPercent = 20,
                            topEndPercent = 20
                        )
                    )

                )
            }
        }

        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(1f),
            verticalAlignment = Alignment.Top
        ) { position ->
            when (position) {
                0 -> RecentNotificationScreen(onNotificationClick = onNotificationClick)
                1 -> EarlierNotificationScreen(onNotificationClick = onNotificationClick)
                else -> ArchivedNotificationScreen(onNotificationClick = onNotificationClick)
            }
        }
    }
}

@Composable
@Preview
fun NotificationScreenPreview() {
    NotificationListScreen(PaddingValues(0.dp), {}, { _, _ -> }) {}
}
