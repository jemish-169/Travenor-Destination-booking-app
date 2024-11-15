package com.app.travenor.features.notification.presentation

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@Composable
fun NotificationScreen(
    innerPadding: PaddingValues,
    onBackClick: () -> Unit,
    onClearAllClicked: (Int) -> Unit
) {
    val pagerState = rememberPagerState(pageCount = { 3 })
    val animationScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
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
                modifier = Modifier.clickable {
                    onClearAllClicked(pagerState.currentPage)
                }
            )

        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp)
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "Recent",
                fontSize = 16.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.clickable {
                    if (pagerState.currentPage != 0) {
                        animationScope.launch {
                            pagerState.animateScrollToPage(
                                page = 0,
                                animationSpec = spring(stiffness = Spring.StiffnessLow)
                            )
                        }
                    }
                },
                color = if (pagerState.currentPage == 0) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.onSurface
            )

            Text(
                text = "Earlier",
                fontSize = 16.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.clickable {
                    if (pagerState.currentPage != 1) {
                        animationScope.launch {
                            pagerState.animateScrollToPage(
                                page = 1,
                                animationSpec = spring(stiffness = Spring.StiffnessLow)
                            )
                        }
                    }
                },
                color = if (pagerState.currentPage == 1) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.onSurface
            )

            Text(
                text = "Archived",
                fontSize = 16.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.clickable {
                    if (pagerState.currentPage != 2) {
                        animationScope.launch {
                            pagerState.animateScrollToPage(
                                page = 2,
                                animationSpec = spring(stiffness = Spring.StiffnessLow)
                            )
                        }
                    }
                },
                color = if (pagerState.currentPage == 2) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.onSurface
            )

        }

        HorizontalDivider(modifier = Modifier.padding(top = 12.dp, bottom = 16.dp))

        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(1f),
            verticalAlignment = Alignment.Top
        ) { position ->
            when (position) {
                0 -> RecentNotificationScreen()
                1 -> EarlierNotificationScreen()
                else -> ArchivedNotificationScreen()
            }
        }
    }
}

@Composable
@Preview
fun NotificationScreenPreview() {
    NotificationScreen(PaddingValues(0.dp), {}) {}
}
