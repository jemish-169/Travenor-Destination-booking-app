package com.app.travenor.features.auth.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OtpVerifyScreen(
    innerPadding: PaddingValues,
    onBackClick: () -> Unit,
    validateAndMove: (String) -> Unit,
) {
    val otpText = remember { mutableStateListOf("", "", "", "") }

    Column(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
            .padding(20.dp)
    ) {
        Column(modifier = Modifier.weight(1f)) {
            IconButton(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.onTertiary), onClick = onBackClick
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                    contentDescription = "Back Icon"
                )
            }

            Text(
                modifier = Modifier
                    .padding(top = 36.dp)
                    .align(Alignment.CenterHorizontally),
                text = "OTP Verification",
                fontSize = 26.sp,
                fontWeight = FontWeight.SemiBold,
                lineHeight = 34.sp,
                color = MaterialTheme.colorScheme.onSurface
            )

            Text(
                modifier = Modifier
                    .padding(top = 12.dp)
                    .padding(horizontal = 8.dp),
                text = "Please check your email www.uihut@gmail.com to see the verification code",
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                lineHeight = 20.sp,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.tertiary
            )

            Text(
                text = "OTP Code",
                fontSize = 20.sp,
                lineHeight = 28.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(top = 40.dp, bottom = 8.dp),
                color = MaterialTheme.colorScheme.onSurface
            )

            OTPInputTextFields(
                otpValues = otpText,
                otpLength = 4,
                onUpdateOtpValuesByIndex = { index, value ->
                    otpText[index] = value
                },
                onOtpInputComplete = {
//                    validateAndMove(otpText.toString())
                },
                isError = false,
                modifier = Modifier.align(Alignment.CenterHorizontally),
            )

            Text(text = "Verify",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(MaterialTheme.colorScheme.primary)
                    .clickable {
                        validateAndMove(otpText.toString())
                    }
                    .padding(16.dp),
                fontSize = 16.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.surface)

            Row(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = "Resend code to",
                    color = MaterialTheme.colorScheme.tertiary,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    lineHeight = 16.sp,
                )
                Text(
                    text = "1:30",
                    color = MaterialTheme.colorScheme.secondary,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier
                        .padding(start = 8.dp),
                    lineHeight = 16.sp
                )
            }
        }
    }
}

@Composable
fun OTPInputTextFields(
    otpLength: Int,
    onUpdateOtpValuesByIndex: (Int, String) -> Unit,
    onOtpInputComplete: () -> Unit,
    modifier: Modifier = Modifier,
    otpValues: List<String> = List(otpLength) { "" }, // Pass this as default for future reference
    isError: Boolean = false,
) {
    val focusRequesters = List(otpLength) { FocusRequester() }
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        otpValues.forEachIndexed { index, value ->
            OutlinedTextField(
                modifier = Modifier
                    .weight(1f)
                    .padding(6.dp)
                    .focusRequester(focusRequesters[index])
                    .onKeyEvent { keyEvent ->
                        if (keyEvent.key == Key.Backspace) {
                            if (otpValues[index].isEmpty() && index > 0) {
                                onUpdateOtpValuesByIndex(index, "")
                                focusRequesters[index - 1].requestFocus()
                            } else {
                                onUpdateOtpValuesByIndex(index, otpValues[index])
                            }
                            true
                        } else {
                            false
                        }
                    },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = MaterialTheme.colorScheme.onTertiary,
                    unfocusedContainerColor = MaterialTheme.colorScheme.onTertiary
                ),
                value = value,
                onValueChange = { newValue ->
                    if (newValue.length == otpLength) {
                        for (i in otpValues.indices) {
                            onUpdateOtpValuesByIndex(
                                i,
                                if (i < newValue.length && newValue[i].isDigit()) newValue[i].toString() else ""
                            )
                        }

                        keyboardController?.hide()
                        onOtpInputComplete()
                    } else if (newValue.length <= 1) {
                        onUpdateOtpValuesByIndex(index, newValue)
                        if (newValue.isNotEmpty()) {
                            if (index < otpLength - 1) {
                                focusRequesters[index + 1].requestFocus()
                            } else {
                                keyboardController?.hide()
                                focusManager.clearFocus()
                                onOtpInputComplete()
                            }
                        }
                    } else {
                        if (index < otpLength - 1) focusRequesters[index + 1].requestFocus()
                    }
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.NumberPassword,
                    imeAction = if (index == otpLength - 1) ImeAction.Done else ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = {
                        if (index < otpLength - 1) {
                            focusRequesters[index + 1].requestFocus()
                        }
                    },
                    onDone = {
                        keyboardController?.hide()
                        focusManager.clearFocus()
                        onOtpInputComplete()
                    }
                ),
                singleLine = true,
                shape = MaterialTheme.shapes.small,
                isError = isError,
                textStyle = TextStyle(
                    textAlign = TextAlign.Center,
                    fontSize = MaterialTheme.typography.bodyLarge.fontSize
                )
            )

            LaunchedEffect(value) {
                if (otpValues.all { it.isNotEmpty() }) {
                    focusManager.clearFocus()
                    onOtpInputComplete()
                }
            }
        }
    }

    LaunchedEffect(Unit) {
        focusRequesters.first().requestFocus()
    }
}

@Composable
@Preview
fun OtpVerifyScreenPreview() {
    OtpVerifyScreen(innerPadding = PaddingValues(0.dp), {}, { _ -> })
}