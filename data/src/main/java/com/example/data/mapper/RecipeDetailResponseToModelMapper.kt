package com.example.data.mapper

import com.example.core.mapper.DomainMapper
import com.example.data.model.RecipeDetailModel.RecipeDetailApiResponseModel
import com.example.domain.model.RecipeDetailMapperModel

class RecipeDetailResponseToModelMapper :
    DomainMapper<RecipeDetailApiResponseModel, RecipeDetailMapperModel> {
    override fun invoke(recipeDetailApiResponseModel: RecipeDetailApiResponseModel): RecipeDetailMapperModel {
        return RecipeDetailMapperModel(
            recipeDetailImage = recipeDetailApiResponseModel.image,
            recipeDetailName = recipeDetailApiResponseModel.name,
            recipeDetailIngredients = recipeDetailApiResponseModel.ingredients,
            recipeDetailInstructions = recipeDetailApiResponseModel.instructions
        )
    }
}