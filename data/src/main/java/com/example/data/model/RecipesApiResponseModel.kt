package com.example.data.model

data class RecipesApiResponseModel(
    val limit: Int,
    val recipes: List<Recipe>,
    val skip: Int,
    val total: Int
){
    data class Recipe(
        val caloriesPerServing: Int? = null,
        val cookTimeMinutes: Int? = null,
        val cuisine: String? = null,
        val difficulty: String? = null,
        val id: Int? = null,
        val image: String? = null,
        val ingredients: List<String?>? = null,
        val instructions: List<String?>? = null,
        val mealType: List<String?>? = null,
        val name: String? = null,
        val prepTimeMinutes: Int? = null,
        val rating: Double? = null,
        val reviewCount: Int? = null,
        val servings: Int? = null,
        val tags: List<String?>? = null,
        val userId: Int? = null
    )
}