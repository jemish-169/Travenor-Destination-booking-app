package com.app.travenor.features.onboarding.domain

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import com.app.travenor.R
import com.app.travenor.features.onboarding.models.OnBoardingDetail
import com.app.travenor.ui.theme.secondary

fun getOnBoardingDetailList(): List<OnBoardingDetail> {
    return listOf(
        OnBoardingDetail(
            image = R.drawable.onboarding_1,
            titleText = getAnnotatedString(
                otherText = "Life is short and the world is ",
                mainText = "wide"
            ),
            detailText = "At Friends tours and travel, we customize trustworthy tours to destinations all over the world",
            buttonText = "Next",
            descriptionOfImage = "Page 1"
        ), OnBoardingDetail(
            image = R.drawable.onboarding_2,
            titleText = getAnnotatedString(
                otherText = "It’s a big world out there go ",
                mainText = "explore"
            ),
            detailText = "To get the best of your adventure you just need to go where you like. we are waiting for you",
            buttonText = "Next",
            descriptionOfImage = "Page 2"
        ), OnBoardingDetail(
            image = R.drawable.onboarding_3,
            titleText = getAnnotatedString(
                otherText = "It's always, Journey over ",
                mainText = "destination"
            ),
            detailText = "Whether it's your first step or your hundredth, we're here to make your journey unforgettable.",
            buttonText = "Get Started",
            descriptionOfImage = "Page 3"
        )
    )
}

private fun getAnnotatedString(otherText: String, mainText: String): AnnotatedString {
    return buildAnnotatedString {
        append(otherText)
        withStyle(SpanStyle(color = secondary)) {
            append(mainText)
        }
    }
}

fun getMainPageText(): AnnotatedString {
    return buildAnnotatedString {
        append("Explore the")
        withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
            append("\nBeautiful ")
            withStyle(SpanStyle(color = secondary)) {
                append("world!")
            }
        }
    }
}