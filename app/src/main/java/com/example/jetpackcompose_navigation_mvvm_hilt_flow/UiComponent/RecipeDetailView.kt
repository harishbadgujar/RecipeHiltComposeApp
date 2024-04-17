package com.example.jetpackcompose_navigation_mvvm_hilt_flow.UiComponent

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.domain.model.RecipeDetailMapperModel


@Composable
fun RecipeDetailView(recipeDetail: RecipeDetailMapperModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Image(
            painter = rememberAsyncImagePainter(recipeDetail.recipeDetailImage),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )

        ViewSpacer(16.dp)

        TextViewComponent(
            text = recipeDetail.recipeDetailName ?: "",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Color.Gray
        )

        ViewSpacer(8.dp)

        TextViewComponent(
            text = "Ingredients:",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = Color.Gray
        )

        Column(
            modifier = Modifier.padding(start = 16.dp)
        ) {
            recipeDetail.recipeDetailIngredients?.forEach { ingredient ->

                TextViewComponent(
                    text = "• $ingredient",
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    color = Color.Black
                )
            }
        }

        ViewSpacer(16.dp)

        TextViewComponent(
            text = "Instructions:",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = Color.Gray
        )

        Column(
            modifier = Modifier.padding(start = 16.dp)
        ) {
            recipeDetail.recipeDetailInstructions?.forEachIndexed { index, instruction ->

                TextViewComponent(
                    text = "${index + 1}. $instruction",
                    fontSize = 16.sp,
                    color = Color.Black
                )
            }
        }
    }
}