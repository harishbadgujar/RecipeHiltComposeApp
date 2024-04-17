package com.example.domain.model

data class RecipeMapperModel(
    val recipeId: Int? = null,
    val recipeName: String? = null,
    val prepareTimeMinutes: Int? = null,
    val cookedTimeMinutes: Int? = null,
    val servingsTime: Int? = null,
    val recipeImage: String? = null
)
