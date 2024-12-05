package com.app.travenor.features.profile.presentation.profile_view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.travenor.R
import com.app.travenor.features.profile.presentation.ProfileReDirectItems

@Composable
fun ProfileReDirectItem(profileReDirectItem: ProfileReDirectItems, onItemClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onItemClick()
            }
            .padding(top = 24.dp)
            .padding(bottom = 16.dp)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = profileReDirectItem.icon),
                contentDescription = profileReDirectItem.contentDesc,
                tint = MaterialTheme.colorScheme.tertiary
            )
            Text(
                text = profileReDirectItem.name,
                modifier = Modifier.padding(start = 14.dp),
                fontSize = 16.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight.Medium
            )
        }
        Icon(
            imageVector = Icons.AutoMirrored.Default.KeyboardArrowRight,
            contentDescription = "Right Arrow",
            tint = MaterialTheme.colorScheme.tertiary
        )
    }
        HorizontalDivider()
}

@Composable
@Preview
fun ProfileReDirectItemPreview() {
    ProfileReDirectItem(ProfileReDirectItems(R.drawable.ic_profile, "Profile", "Profile icon"), {})
}