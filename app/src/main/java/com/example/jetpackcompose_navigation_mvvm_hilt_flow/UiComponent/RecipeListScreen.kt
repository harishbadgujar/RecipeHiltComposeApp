package com.example.jetpackcompose_navigation_mvvm_hilt_flow.UiComponent

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.domain.model.RecipeMapperModel
import com.example.jetpackcompose_navigation_mvvm_hilt_flow.utils.Routes
import com.example.jetpackcompose_navigation_mvvm_hilt_flow.viewmodel.MainApiViewModel
import com.example.jetpackcompose_navigation_mvvm_hilt_flow.viewmodel.ReceipeViewState

@Composable
fun RecipeListScreen(
    navController: NavController,
    mainApiViewModel: MainApiViewModel,
    state: ReceipeViewState
) {

    Scaffold(
        topBar = {
            CustomToolAppBar(navController, "Home", false)
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (state.showProgress) {
                ProgressLoader()
            }

            if (state.getReceipeList != null) {
                RecipeList(state.getReceipeList) {
                    navController.navigate(Routes.getSecondScreenPath(it.recipeId))
                }
            }

        }

    }

}


@Composable
fun RecipeList(
    receipeList: List<RecipeMapperModel>,
    onRecipeListItemClick: (RecipeMapperModel) -> Unit
) {
    LazyColumn {
        items(receipeList) {
            RecipeListCard(it) { onRecipeListItemClick(it) }
        }
    }
}


@Composable
fun RecipeListCard(
    recipeMapperModel: RecipeMapperModel,
    onRecipeListItemClick: (RecipeMapperModel) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(10),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .clickable {
                    onRecipeListItemClick(recipeMapperModel)
                },
            verticalAlignment = Alignment.CenterVertically
        ) {

            ImageComponent(recipeMapperModel.recipeImage,100.dp,10.dp,ContentScale.Crop)

            Column(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .weight(1f)
            ) {


                TextViewComponent(
                    recipeMapperModel.recipeName ?: "",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                )

                TextViewComponent(
                    "Prep Time : ${recipeMapperModel.prepareTimeMinutes} mins.",
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    color = Black
                )

                TextViewComponent(
                    "Cook Time: ${recipeMapperModel.cookedTimeMinutes} mins.",
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    color = Black
                )

                TextViewComponent(
                    "Servings: ${recipeMapperModel.servingsTime}",
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    color = Black
                )

            }
        }
    }
}
