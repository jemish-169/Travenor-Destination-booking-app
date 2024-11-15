package com.app.travenor.core.main_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.NavigationRailItemColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.app.travenor.sample_data.items

@Composable
fun AppBottomBar(
    navController: NavHostController
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar(
        modifier = Modifier.graphicsLayer {
            clip = true
            shape = RoundedCornerShape(topEnd = 24.dp, topStart = 24.dp)
        }) {
        items.forEachIndexed { index, item ->
            val isSelected = currentRoute == item.appRoute.name

            NavigationRailItem(
                colors = NavigationRailItemColors(
                    selectedIndicatorColor = Color.Transparent,
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    unselectedIconColor = MaterialTheme.colorScheme.tertiary,
                    unselectedTextColor = MaterialTheme.colorScheme.tertiary,
                    disabledIconColor = MaterialTheme.colorScheme.tertiary,
                    disabledTextColor = MaterialTheme.colorScheme.tertiary
                ),
                selected = isSelected && index != 2,
                onClick = {
                    navController.navigate(item.appRoute) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                label = {
                    if (index != 2)
                        Text(
                            text = item.title,
                            fontSize = 12.sp,
                            lineHeight = 16.sp,
                            fontWeight = FontWeight.Medium
                        )
                },
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.title,
                        tint = if (isSelected && index != 2) MaterialTheme.colorScheme.primary
                        else if (index == 2) Color.White
                        else MaterialTheme.colorScheme.tertiary,
                        modifier = if (index == 2)
                            Modifier
                                .background(MaterialTheme.colorScheme.primary, CircleShape)
                                .padding(12.dp)
                        else Modifier

                    )
                },
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
@Preview
fun AppBottomBarPreview() {
    val appNavController = rememberNavController()

    AppBottomBar(navController = appNavController)
}