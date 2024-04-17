package com.example.jetpackcompose_navigation_mvvm_hilt_flow.UiComponent

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jetpackcompose_navigation_mvvm_hilt_flow.viewmodel.MainApiViewModel

@Composable
fun RecipeDetailScreen(navController: NavController, mainApiViewModel: MainApiViewModel, id: Int?) {
    val scrollstate = rememberScrollState()
    val state by mainApiViewModel.state.collectAsState()
    Scaffold(topBar = {
        CustomToolAppBar(navController = navController, title = "Detail", true)
    }) { innerPadding ->

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(scrollstate)
                .padding(2.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            LaunchedEffect(key1 = Unit) {
                getReceipesDetails(mainApiViewModel, id)
            }

            if(state.showProgress){
                ProgressLoader()
            }

            if (state.getRecipeDetail != null){
                RecipeDetailView(state.getRecipeDetail!!)
            }

        }
    }
}

private fun getReceipesDetails(mainViewModel: MainApiViewModel, id: Int?) {
    mainViewModel.getRecipeDetail(id)
}
