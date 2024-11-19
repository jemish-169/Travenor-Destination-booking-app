package com.app.travenor.features.search.presentation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SearchScreen(innerPadding: PaddingValues, onBackClick: () -> Unit) {
    Text(text = "SearchScreen")

}

@Composable
@Preview
fun SearchScreenPreview() {
    SearchScreen(PaddingValues(0.dp)) { }
}