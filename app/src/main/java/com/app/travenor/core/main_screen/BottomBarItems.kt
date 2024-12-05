package com.app.travenor.core.main_screen

import androidx.annotation.DrawableRes
import com.app.travenor.R
import com.app.travenor.routes.AppRoute
import com.app.travenor.routes.AppRoute.PopularAppRoute
import com.app.travenor.routes.AppRoute.HomeAppRoute
import com.app.travenor.routes.AppRoute.FavouritesAppRoute
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
        appRoute = PopularAppRoute,
        title = "Popular",
        icon = R.drawable.ic_popular,
    ),
    BottomNavigationItem(
        appRoute = SearchAppRoute,
        title = "Search",
        icon = R.drawable.ic_search,
    ),
    BottomNavigationItem(
        appRoute = FavouritesAppRoute,
        title = "Favourites",
        icon = R.drawable.ic_bookmark_icon,
    ),
    BottomNavigationItem(
        appRoute = ProfileAppRoute,
        title = "Profile",
        icon = R.drawable.ic_profile,
    )
)