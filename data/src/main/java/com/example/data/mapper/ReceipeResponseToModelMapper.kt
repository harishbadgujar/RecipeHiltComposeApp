package com.example.data.mapper

import com.example.core.mapper.DomainMapper
import com.example.data.model.RecipesApiResponseModel
import com.example.domain.model.RecipeMapperModel

class ReceipeResponseToModelMapper :
    DomainMapper<RecipesApiResponseModel, List<RecipeMapperModel>> {
    override fun invoke(recipesApiResponseModel: RecipesApiResponseModel): List<RecipeMapperModel> {
        return recipesApiResponseModel.recipes.map { receipeResponseItem ->
            RecipeMapperModel(
                recipeId = receipeResponseItem.id,
                recipeName = receipeResponseItem.name,
                prepareTimeMinutes = receipeResponseItem.prepTimeMinutes,
                cookedTimeMinutes = receipeResponseItem.cookTimeMinutes,
                servingsTime = receipeResponseItem.servings,
                recipeImage = receipeResponseItem.image
            )
        }
    }
}
