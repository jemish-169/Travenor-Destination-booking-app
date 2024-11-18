package com.app.travenor.features.profile.presentation.profile_view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ShowProfileNumericData(fieldName: String, fieldPoints: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = fieldName,
            fontSize = 14.sp,
            lineHeight = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.onSurface
        )
        Text(
            text = fieldPoints.toString(),
            modifier = Modifier.padding(top = 10.dp),
            fontSize = 16.sp,
            lineHeight = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.secondary
        )

    }
}

@Composable
@Preview
fun ShowProfileNumericDataPreview() {
    ShowProfileNumericData(fieldName = "Rewarded Points", fieldPoints = 360)
}