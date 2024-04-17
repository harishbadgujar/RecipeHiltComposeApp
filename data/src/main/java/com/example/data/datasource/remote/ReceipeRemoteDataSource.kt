package com.example.data.datasource.remote

import com.example.core.dto.NetworkResponseState
import com.example.data.model.RecipeDetailModel.RecipeDetailApiResponseModel
import com.example.data.model.RecipesApiResponseModel

interface ReceipeRemoteDataSource {
      suspend fun getReceipes() : NetworkResponseState<RecipesApiResponseModel>
      suspend fun getRecipeDetail(id: Int?): NetworkResponseState<RecipeDetailApiResponseModel>
}