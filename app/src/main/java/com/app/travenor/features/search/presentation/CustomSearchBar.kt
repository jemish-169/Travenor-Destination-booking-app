package com.app.travenor.features.search.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.travenor.R


@Composable
fun CustomSearchBar(onMicBtnClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.onTertiary)
            .padding(12.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        var searchText by remember { mutableStateOf("") }

        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.weight(1f)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "Search-bar Icon",
                tint = MaterialTheme.colorScheme.tertiary
            )
            BasicTextField(
                modifier = Modifier.weight(1f),
                value = searchText,
                onValueChange = { searchText = it },
                singleLine = true,
                decorationBox = { innerTextField ->
                    if (searchText.isEmpty()) {
                        Text(
                            text = "Search place",
                            fontSize = 16.sp,
                            lineHeight = 16.sp,
                            fontWeight = FontWeight.Normal,
                            color = MaterialTheme.colorScheme.tertiary
                        )
                    }
                    innerTextField()
                }
            )
        }
        VerticalDivider(
            modifier = Modifier
                .height(24.dp)
                .padding(horizontal = 16.dp)
        )
        IconButton(modifier = Modifier.size(24.dp), onClick = onMicBtnClick) {
            Icon(
                painter = painterResource(id = R.drawable.ic_microphone_icon),
                contentDescription = "microphone-bar Icon",
                tint = MaterialTheme.colorScheme.tertiary
            )
        }
    }
}

@Composable
@Preview
fun CustomSearchBarPreview() {
    CustomSearchBar() {}
}