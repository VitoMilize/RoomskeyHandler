package com.example.roomskeyhandler

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.outlined.List
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null
)

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val items = listOf(
                BottomNavigationItem(
                    title = "Home",
                    selectedIcon = Icons.Filled.List,
                    unselectedIcon = Icons.Outlined.List,
                    hasNews = false
                ),
                BottomNavigationItem(
                    title = "Home",
                    selectedIcon = Icons.Filled.List,
                    unselectedIcon = Icons.Outlined.List,
                    hasNews = false,
                    badgeCount = 30
                ),
                BottomNavigationItem(
                    title = "Home",
                    selectedIcon = Icons.Filled.List,
                    unselectedIcon = Icons.Outlined.List,
                    hasNews = true
                )
            )
            var selectedItemIndex by rememberSaveable {
                mutableIntStateOf(0)
            }
            Scaffold(
                bottomBar = {
                    NavigationBar {
                        items.forEachIndexed { index, item ->
                            NavigationBarItem(
                                selected = selectedItemIndex == index,
                                onClick = {
                                    selectedItemIndex = index
//                                navController.navigate(item.title)
                                },
                                label = {
                                    Text(text = item.title)
                                },
                                icon = {
                                    BadgedBox(
                                        badge = {
                                            if (item.badgeCount != null) {
                                                Badge {
                                                    Text(text = item.badgeCount.toString())
                                                }
                                            } else if (item.hasNews) {
                                                Badge()
                                            }
                                        }
                                    ) {
                                        Icon(
                                            imageVector = if (index == selectedItemIndex) {
                                                item.selectedIcon
                                            } else item.unselectedIcon,
                                            contentDescription = item.title)
                                    }
                                }
                            )
                        }
                    }

                }
            ) {

            }
            LoginScreen()
        }
    }
}
