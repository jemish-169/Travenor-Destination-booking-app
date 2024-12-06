package com.app.travenor.features.onboarding.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.travenor.features.onboarding.models.OnBoardingDetail

@Composable
fun PagerScreen(onBoardingDetail: OnBoardingDetail) {
    Column {
        Image(
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .clip(RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp)),
            painter = painterResource(id = onBoardingDetail.image),
            contentDescription = onBoardingDetail.descriptionOfImage
        )
        Column {
            Text(
                modifier = Modifier
                    .padding(horizontal = 36.dp)
                    .padding(top = 36.dp)
                    .fillMaxWidth(),
                text = onBoardingDetail.titleText,
                fontSize = 30.sp,
                fontWeight = FontWeight.Black,
                lineHeight = 36.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                modifier = Modifier
                    .padding(36.dp)
                    .fillMaxWidth(),
                text = onBoardingDetail.detailText,
                fontSize = 16.sp,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                lineHeight = 24.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Normal,
                color = MaterialTheme.colorScheme.tertiary
            )
        }
    }
}

@Preview
@Composable
fun OnBoardingScreenPreview() {
    OnBoardingScreen(innerPadding = PaddingValues(0.dp)) {}
}