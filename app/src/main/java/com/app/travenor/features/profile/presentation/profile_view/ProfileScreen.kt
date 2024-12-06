package com.app.travenor.features.profile.presentation.profile_view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
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
import com.app.travenor.features.profile.presentation.profileReDirectItems
import com.app.travenor.sample_data.profileData

@Composable
fun ProfileScreen(
    innerPadding: PaddingValues,
    onBackClick: () -> Unit, onEditClick: () -> Unit, onSignOut: () -> Unit
) {
    val profileData = profileData
    var showSignOutDialog by remember { mutableStateOf(false) }

    if (showSignOutDialog) {
        AlertDialog(onDismissRequest = { showSignOutDialog = false }, title = {
            Text(text = "Sign Out", style = MaterialTheme.typography.titleLarge)
        }, text = {
            Text(
                text = "Are you sure you want to sign out?",
                style = MaterialTheme.typography.bodyMedium
            )
        }, confirmButton = {
            TextButton(onClick = {
                showSignOutDialog = false
                onSignOut()
            }) {
                Text(text = "Yes")
            }
        }, dismissButton = {
            TextButton(onClick = { showSignOutDialog = false }) {
                Text(text = "No")
            }
        })
    }

    Column(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
            .padding(top = 20.dp)
            .padding(horizontal = 20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
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
                text = "Profile",
                fontSize = 18.sp,
                lineHeight = 22.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onSurface
            )

            IconButton(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.onTertiary),
                onClick = onEditClick
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_edit_profile),
                    contentDescription = "Edit Icon",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }

        Column(
            modifier = Modifier
                .padding(top = 30.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(profileData.profileUrl)
                    .crossfade(true)
                    .build(),
                modifier = Modifier
                    .size(96.dp)
                    .clip(CircleShape),
                placeholder = painterResource(id = R.drawable.ic_profile_img),
                error = painterResource(id = R.drawable.ic_profile_img),
                fallback = painterResource(id = R.drawable.ic_profile_img),
                contentDescription = "Profile image"
            )

            Text(
                modifier = Modifier.padding(top = 8.dp),
                text = profileData.profileName,
                fontSize = 24.sp,
                lineHeight = 34.sp,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onSurface
            )

            Text(
                modifier = Modifier.padding(top = 4.dp),
                text = profileData.profileMail,
                fontSize = 14.sp,
                lineHeight = 16.sp,
                fontWeight = FontWeight.Normal,
                color = MaterialTheme.colorScheme.tertiary
            )
        }


        Row(
            modifier = Modifier
                .padding(top = 30.dp)
                .fillMaxWidth()
                .shadow(
                    elevation = 3.dp,
                    shape = RoundedCornerShape(24.dp),
                    spotColor = MaterialTheme.colorScheme.tertiary.copy(alpha = 0.3f)
                )
                .background(MaterialTheme.colorScheme.surface)
                .clip(RoundedCornerShape(16.dp))
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ShowProfileNumericData(
                fieldName = "Reward Points",
                fieldPoints = 360
            )


            ShowProfileNumericData(
                fieldName = "Travel Trips",
                fieldPoints = 238
            )

            ShowProfileNumericData(
                fieldName = "Bucket List",
                fieldPoints = 473
            )
        }

        Column(
            modifier = Modifier
                .padding(top = 30.dp)
                .fillMaxWidth()
                .shadow(
                    elevation = 3.dp,
                    spotColor = MaterialTheme.colorScheme.tertiary.copy(alpha = 0.3f)
                )
                .background(MaterialTheme.colorScheme.surface),
        ) {
            profileReDirectItems.forEachIndexed { index, profileReDirectItem ->
                ProfileReDirectItem(profileReDirectItem, onItemClick = {
                    if (index == 5) {
                        showSignOutDialog = true
                    }
                })
            }
        }
        Spacer(modifier = Modifier.height(16.dp).fillMaxWidth())
    }
}

@Preview
@Composable
fun ProfileScreenPreview() {
    ProfileScreen(PaddingValues(0.dp), {}, {}, {})
}