package com.example.domain.model

data class RecipeDetailMapperModel(
    val recipeDetailImage: String? = null,
    val recipeDetailName: String? = null,
    val recipeDetailIngredients: List<String?>? = null,
    val recipeDetailInstructions: List<String?>? = null,
)
