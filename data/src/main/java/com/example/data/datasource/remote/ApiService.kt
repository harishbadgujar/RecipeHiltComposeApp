package com.example.data.datasource.remote

import com.example.core.dto.NetworkResponseState
import com.example.data.model.RecipeDetailModel.RecipeDetailApiResponseModel
import com.example.data.model.RecipesApiResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("recipes")
    suspend fun getReceipes(): RecipesApiResponseModel

    @GET("recipes/{id}")
    suspend fun getRecipeDetails(@Path("id")id:Int?): RecipeDetailApiResponseModel
}