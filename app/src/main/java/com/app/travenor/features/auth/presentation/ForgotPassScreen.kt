package com.app.travenor.features.auth.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.travenor.R

@Composable
fun ForgotPassScreen(
    innerPadding: PaddingValues,
    onBackClick: () -> Unit,
    validateAndMove: (String) -> Unit
) {
    var emailText by remember { mutableStateOf(TextFieldValue("")) }

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
                text = "Forgot password",
                fontSize = 26.sp,
                fontWeight = FontWeight.SemiBold,
                lineHeight = 34.sp,
                color = MaterialTheme.colorScheme.onSurface
            )

            Text(
                modifier = Modifier
                    .padding(top = 12.dp)
                    .align(Alignment.CenterHorizontally),
                text = "Enter your email account to reset\nyour password",
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                lineHeight = 20.sp,
                textAlign = TextAlign.Center,
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

            Text(text = "Reset Password",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(MaterialTheme.colorScheme.primary)
                    .clickable { validateAndMove(emailText.text) }
                    .padding(16.dp),
                fontSize = 16.sp,
                lineHeight = 20.sp,
                color = MaterialTheme.colorScheme.surface)
        }
    }
}

@Composable
@Preview
fun ForgotPassScreenPreview() {
    ForgotPassScreen(innerPadding = PaddingValues(0.dp), {}, { _ -> })
}