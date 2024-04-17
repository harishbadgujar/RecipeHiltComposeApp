package com.example.data.datasource.remote

import com.example.core.dto.NetworkResponseState
import com.example.data.model.RecipeDetailModel.RecipeDetailApiResponseModel
import com.example.data.model.RecipesApiResponseModel
import javax.inject.Inject

class ApiServiceDataSourceImpl @Inject constructor(
    private val apiService: ApiService
) :  ReceipeRemoteDataSource{
    override suspend fun getReceipes(): NetworkResponseState<RecipesApiResponseModel> {
         return NetworkResponseState.Success(apiService.getReceipes())
    }

    override suspend fun getRecipeDetail(id: Int?): NetworkResponseState<RecipeDetailApiResponseModel> {
         return NetworkResponseState.Success(apiService.getRecipeDetails(id))
    }

}