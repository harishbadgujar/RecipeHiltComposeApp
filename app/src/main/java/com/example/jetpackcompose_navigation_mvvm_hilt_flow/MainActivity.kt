package com.example.jetpackcompose_navigation_mvvm_hilt_flow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpackcompose_navigation_mvvm_hilt_flow.UiComponent.RecipeDetailScreen
import com.example.jetpackcompose_navigation_mvvm_hilt_flow.UiComponent.RecipeListScreen
import com.example.jetpackcompose_navigation_mvvm_hilt_flow.ui.theme.JetpackCompose_Navigation_MVVM_Hilt_FlowTheme
import com.example.jetpackcompose_navigation_mvvm_hilt_flow.utils.Routes
import com.example.jetpackcompose_navigation_mvvm_hilt_flow.viewmodel.MainApiViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }

    @Composable
    private fun MainScreen() {
        val mainApiViewModel = hiltViewModel<MainApiViewModel>()
        val state by mainApiViewModel.state.collectAsState()
        JetpackCompose_Navigation_MVVM_Hilt_FlowTheme {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = Routes.LIST_SCREEN) {
                composable(Routes.LIST_SCREEN) {
                    RecipeListScreen(navController, mainApiViewModel, state)
                }

                composable(Routes.DETAIL_SCREEN, arguments = listOf(navArgument("idValue") {
                    type = NavType.IntType
                })) { backStackEntry ->

                    RecipeDetailScreen(
                        navController,
                        mainApiViewModel,
                        backStackEntry.arguments?.getInt(Routes.Values.IDVALUE, 0)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackCompose_Navigation_MVVM_Hilt_FlowTheme {
        Greeting("Android")
    }
}