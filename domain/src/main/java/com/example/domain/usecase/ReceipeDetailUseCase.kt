package com.example.domain.usecase

import com.example.core.dto.NetworkResponseState
import com.example.domain.model.RecipeDetailMapperModel
import com.example.domain.model.RecipeMapperModel
import com.example.domain.repository.ReceipeRepository
import com.example.domain.repository.RecipeDetailRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ReceipeDetailUseCase @Inject constructor(
    private val recipeDetailRepository: RecipeDetailRepository
) {
    fun getRecipeDetail(id: Int?): Flow<NetworkResponseState<RecipeDetailMapperModel>> {
        return recipeDetailRepository.getRecipesDetail(id)
    }
}