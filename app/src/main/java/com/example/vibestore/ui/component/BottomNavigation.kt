package com.example.vibestore.ui.component

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.vibestore.R
import com.example.vibestore.ui.navigation.model.NavigationItem
import com.example.vibestore.ui.navigation.model.Screen
import com.example.vibestore.ui.theme.VibeStoreTheme
import com.example.vibestore.ui.theme.poppinsFontFamily

@Composable
fun BottomNavigation(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    // Get screen width to adjust layout dynamically
    val screenWidth = LocalConfiguration.current.screenWidthDp

    val isCompactScreen = screenWidth < 360 // Example breakpoint for compact devices

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.background,
        modifier = modifier
            .height(if (isCompactScreen) 60.dp else 75.dp)
            .drawWithContent {
                drawContent()
                drawLine(
                    color = Color(0xFFE3E3E3),
                    start = Offset(0f, 0f),
                    end = Offset(size.width, 0f),
                    strokeWidth = 2f
                )
            }
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        val navigationItems = listOf(
            NavigationItem(
                title = "Home",
                icon = painterResource(R.drawable.icon_home_outlined),
                iconActive = painterResource(R.drawable.icon_home_filled),
                screen = Screen.Home
            ),
            NavigationItem(
                title = "Product",
                icon = painterResource(R.drawable.icon_shopping_bag_outlined),
                iconActive = painterResource(R.drawable.icon_shopping_bag_filled),
                screen = Screen.OurProduct
            ),
            NavigationItem(
                title = "Coupon",
                icon = painterResource(R.drawable.icon_coupon_outlined),
                iconActive = painterResource(R.drawable.icon_coupon_filled),
                screen = Screen.Coupon
            ),
            NavigationItem(
                title = "Starred",
                icon = painterResource(R.drawable.icon_favourite_outlined),
                iconActive = painterResource(R.drawable.icon_favourite_filled),
                screen = Screen.Favourite
            ),
            NavigationItem(
                title = "Profile",
                icon = painterResource(R.drawable.icon_profile_outlined),
                iconActive = painterResource(R.drawable.icon_profile_filled),
                screen = Screen.Profile
            ),
        )

        navigationItems.map { item ->
            val isSelected = currentRoute == item.screen.route
            NavigationBarItem(
                selected = isSelected,
                icon = {
                    Icon(
                        painter = if (isSelected) item.iconActive else item.icon,
                        contentDescription = item.title,
                        tint = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline,
                        modifier = Modifier.size(if (isCompactScreen) 20.dp else 24.dp)
                    )
                },
                label = {
                    if (!isCompactScreen) {
                        Text(
                            text = item.title,
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight.Normal,
                            color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis // Optional: Add "..." if text overflows
                        )
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = MaterialTheme.colorScheme.background
                ),
                onClick = {
                    navController.navigate(item.screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}

@Preview
@Composable
private fun BottomNavigationPreview() {
    VibeStoreTheme(
        dynamicColor = false
    ) {
        BottomNavigation(rememberNavController())
    }
}