package com.example.midtest.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.studentroster.ui.screens.AddStudentScreen
import com.example.studentroster.ui.screens.DashboardScreen
import com.example.studentroster.ui.screens.LoginScreen

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Dashboard : Screen("dashboard")
    object AddStudent : Screen("add_student")
}

@Composable
fun StudentRosterNavGraph(
    navController: NavHostController,
    startDestination: String = Screen.Login.route
) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable(Screen.Login.route) {
            LoginScreen {
                navController.navigate(Screen.Dashboard.route) {
                    popUpTo(Screen.Login.route) { inclusive = true }
                }
            }
        }
        composable(Screen.Dashboard.route) {
            DashboardScreen {
                navController.navigate(Screen.AddStudent.route)
            }
        }
        composable(Screen.AddStudent.route) {
            AddStudentScreen {
                navController.navigate(Screen.Dashboard.route) {
                    popUpTo(Screen.Dashboard.route) { inclusive = true }
                }
            }
        }
    }
}