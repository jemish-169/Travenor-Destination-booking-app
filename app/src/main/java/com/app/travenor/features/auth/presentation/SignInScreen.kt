package com.app.travenor.features.auth.presentation

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.travenor.R

@Composable
fun SignInScreen(
    innerPadding: PaddingValues,
    onBackClick: () -> Unit,
    validateAndMove: (String, String) -> Unit,
    moveToForgetPassword: (String) -> Unit,
    moveToSignUp: () -> Unit
) {
    var emailText by remember { mutableStateOf(TextFieldValue("")) }
    var passwordText by remember { mutableStateOf(TextFieldValue("")) }
    var isPasswordVisible by remember { mutableStateOf(false) }


    Column(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
            .padding(20.dp)
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
                modifier = Modifier
                    .padding(top = 36.dp)
                    .align(Alignment.CenterHorizontally),
                text = "Sign in now",
                fontSize = 26.sp,
                fontWeight = FontWeight.SemiBold,
                lineHeight = 34.sp,
                color = MaterialTheme.colorScheme.onSurface
            )

            Text(
                modifier = Modifier
                    .padding(top = 12.dp)
                    .align(Alignment.CenterHorizontally),
                text = "Please sign in to continue our app",
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                lineHeight = 20.sp,
                color = MaterialTheme.colorScheme.tertiary
            )

            OutlinedTextField(
                value = emailText,
                onValueChange = { emailText = it },
                label = { Text(text = stringResource(id = R.string.email)) },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp)
            )

            OutlinedTextField(
                value = passwordText,
                onValueChange = { passwordText = it },
                label = { Text(text = stringResource(id = R.string.password)) },
                singleLine = true,
                trailingIcon = {
                    val icon = if (isPasswordVisible) Icons.Filled.Visibility
                    else Icons.Filled.VisibilityOff

                    IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                        Icon(
                            imageVector = icon,
                            contentDescription = stringResource(id = R.string.password_visibility_toggle),
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, bottom = 8.dp),
                visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation()
            )

            Text(
                text = "Forget Password?",
                color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier
                    .align(Alignment.End)
                    .clip(RoundedCornerShape(100))
                    .clickable {
                        moveToForgetPassword(emailText.text)
                    }
                    .padding(vertical = 6.dp)
                    .padding(horizontal = 10.dp),
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                lineHeight = 16.sp
            )

            Text(text = "Sign In",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 40.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(MaterialTheme.colorScheme.primary)
                    .clickable { validateAndMove(emailText.text, passwordText.text) }
                    .padding(16.dp),
                fontSize = 16.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.surface)

            Row(
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
            ) {
                Text(
                    text = "Don't have an account?",
                    color = MaterialTheme.colorScheme.tertiary,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    lineHeight = 16.sp
                )
                Text(
                    text = "Sign up",
                    color = MaterialTheme.colorScheme.secondary,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .clickable {
                            moveToSignUp()
                        },
                    lineHeight = 16.sp,
                    fontWeight = FontWeight.Medium,
                )
            }

            Text(
                text = "Or Connect",
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 24.dp),
                lineHeight = 16.sp
            )
        Row(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(vertical = 32.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_facebook_logo),
                contentDescription = "FaceBook Logo"
            )
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_instagram_logo),
                contentDescription = "Instagram Logo"
            )
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_twitter_logo),
                contentDescription = "Instagram Logo"
            )
        }
    }
}

@Composable
@Preview
fun SignInScreenPreview() {
    SignInScreen(innerPadding = PaddingValues(0.dp), {}, { _, _ -> }, { _ -> }, {})
}