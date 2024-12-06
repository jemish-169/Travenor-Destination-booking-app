package com.app.travenor.features.profile.presentation.profile_edit

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.app.travenor.R
import com.app.travenor.sample_data.editProfileData

@Composable
fun EditProfileScreen(
    innerPadding: PaddingValues,
    onBackClick: () -> Unit,
    onSaveProfile: () -> Unit
) {
    val editProfileData = editProfileData
    var firstName by remember { mutableStateOf(TextFieldValue(editProfileData.firstName)) }
    var lastName by remember { mutableStateOf(TextFieldValue(editProfileData.lastName)) }
    var locationText by remember { mutableStateOf(TextFieldValue(editProfileData.location)) }
    var mobileNumber by remember { mutableStateOf(TextFieldValue(editProfileData.mobileNumber)) }
    val isError = List(4) { remember { mutableStateOf(false) } }

    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
            .padding(20.dp)
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
                text = "Edit Profile",
                fontSize = 18.sp,
                lineHeight = 22.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onSurface
            )

            Text(
                text = "Done",
                fontSize = 16.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier
                    .clip(RoundedCornerShape(100))
                    .clickable {
                        val result = verifyData(
                            firstName = firstName.text,
                            lastName = lastName.text,
                            locationText = locationText.text,
                            mobileNumber = mobileNumber.text
                        )

                        isError[0].value = result.second[0]
                        isError[1].value = result.second[1]
                        isError[2].value = result.second[2]
                        isError[3].value = result.second[3]

                        if (result.first)
                            onSaveProfile()
                    }
                    .padding(vertical = 6.dp)
                    .padding(horizontal = 10.dp)
            )
        }

        Column(
            modifier = Modifier
                .padding(top = 30.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(editProfileData.profileUrl)
                    .crossfade(true)
                    .build(),
                modifier = Modifier
                    .size(96.dp)
                    .clip(CircleShape),
                placeholder = painterResource(id = R.drawable.profile_ph1),
                error = painterResource(id = R.drawable.profile_ph1),
                fallback = painterResource(id = R.drawable.profile_ph1),
                contentDescription = "Profile picture"
            )

            Text(
                modifier = Modifier.padding(top = 8.dp),
                text = editProfileData.firstName,
                fontSize = 24.sp,
                lineHeight = 34.sp,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onSurface
            )

            Text(
                modifier = Modifier.padding(top = 4.dp),
                text = "Change Profile Picture",
                fontSize = 16.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.secondary
            )
        }

        Column(
            modifier = Modifier
                .padding(top = 30.dp)
                .fillMaxWidth(),
        ) {
            Text(
                text = "First Name",
                fontSize = 18.sp,
                lineHeight = 24.sp,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onSurface
            )
            OutlinedTextField(
                value = firstName,
                onValueChange = { firstName = it },
                singleLine = true,
                trailingIcon = {
                    if (firstName.text.length > 3) {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = "Complete icon",
                            tint = MaterialTheme.colorScheme.secondary
                        )
                        isError[0].value = false
                    }
                },
                isError = isError[0].value,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
                    .focusRequester(FocusRequester())
            )

            Text(
                text = "Last Name",
                fontSize = 18.sp,
                lineHeight = 24.sp,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.padding(top = 16.dp)
            )
            OutlinedTextField(
                value = lastName,
                onValueChange = { lastName = it },
                singleLine = true,
                trailingIcon = {
                    if (lastName.text.length > 3) {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = "Complete icon",
                            tint = MaterialTheme.colorScheme.secondary
                        )
                        isError[1].value = false
                    }
                },
                isError = isError[1].value,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            )

            Text(
                text = "Location",
                fontSize = 18.sp,
                lineHeight = 24.sp,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.padding(top = 16.dp)
            )
            OutlinedTextField(
                value = locationText,
                onValueChange = { locationText = it },
                singleLine = true,
                trailingIcon = {
                    if (locationText.text.length > 2) {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = "Complete icon",
                            tint = MaterialTheme.colorScheme.secondary
                        )
                        isError[2].value = false
                    }
                },
                isError = isError[2].value,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            )

            Text(
                text = "Mobile Number",
                fontSize = 18.sp,
                lineHeight = 24.sp,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.padding(top = 16.dp)
            )
            OutlinedTextField(
                value = mobileNumber,
                onValueChange = { mobileNumber = it },
                singleLine = true,
                trailingIcon = {
                    if (mobileNumber.text.length == 10 && mobileNumber.text.all { char -> char.isDigit() }) {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = "Complete icon",
                            tint = MaterialTheme.colorScheme.secondary
                        )
                        isError[3].value = false
                    }
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.NumberPassword,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        keyboardController?.hide()
                        focusManager.clearFocus()
                        val result = verifyData(
                            firstName = firstName.text,
                            lastName = lastName.text,
                            locationText = locationText.text,
                            mobileNumber = mobileNumber.text
                        )

                        isError[0].value = result.second[0]
                        isError[1].value = result.second[1]
                        isError[2].value = result.second[2]
                        isError[3].value = result.second[3]

                        if (result.first)
                            onSaveProfile()
                    }
                ),
                isError = isError[3].value,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            )
        }
    }
}

fun verifyData(
    firstName: String,
    lastName: String,
    locationText: String,
    mobileNumber: String
): Pair<Boolean, List<Boolean>> {
    var isCorrectProfile = true
    val isError = MutableList<Boolean>(4) { false }

    if (firstName.length <= 3) {
        isCorrectProfile = false
        isError[0] = true
    }
    if (lastName.length <= 3) {
        isCorrectProfile = false
        isError[1] = true
    }
    if (locationText.length <= 2) {
        isCorrectProfile = false
        isError[2] = true
    }
    if (mobileNumber.length != 10 || mobileNumber.all { char -> !char.isDigit() }) {
        isCorrectProfile = false
        isError[3] = true
    }
    return Pair(isCorrectProfile, isError)
}

//@Preview
//@Composable
//fun EditProfileScreenPreview() {
//    EditProfileScreen(PaddingValues(0.dp), {}, {})
//}