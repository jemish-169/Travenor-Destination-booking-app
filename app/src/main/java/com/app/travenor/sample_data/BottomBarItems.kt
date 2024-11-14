package com.app.travenor.sample_data

import androidx.annotation.DrawableRes
import com.app.travenor.R
import com.app.travenor.routes.AppRoute
import com.app.travenor.routes.AppRoute.CalenderAppRoute
import com.app.travenor.routes.AppRoute.HomeAppRoute
import com.app.travenor.routes.AppRoute.MessagesAppRoute
import com.app.travenor.routes.AppRoute.ProfileAppRoute
import com.app.travenor.routes.AppRoute.SearchAppRoute

data class BottomNavigationItem(
    val appRoute: AppRoute,
    val title: String,
    @DrawableRes val icon: Int
)

val items = listOf(
    BottomNavigationItem(
        appRoute = HomeAppRoute,
        title = "Home",
        icon = R.drawable.ic_home,
    ),
    BottomNavigationItem(
        appRoute = CalenderAppRoute,
        title = "Calender",
        icon = R.drawable.ic_calendar,
    ),
    BottomNavigationItem(
        appRoute = SearchAppRoute,
        title = "Search",
        icon = R.drawable.ic_search,
    ),
    BottomNavigationItem(
        appRoute = MessagesAppRoute,
        title = "Messages",
        icon = R.drawable.ic_chat,
    ),
    BottomNavigationItem(
        appRoute = ProfileAppRoute,
        title = "Profile",
        icon = R.drawable.ic_profile,
    )
)