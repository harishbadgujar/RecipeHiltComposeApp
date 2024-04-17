package com.example.domain.repository

import com.example.core.dto.NetworkResponseState
import com.example.domain.model.RecipeDetailMapperModel
import kotlinx.coroutines.flow.Flow

interface RecipeDetailRepository {
    fun getRecipesDetail(id: Int?): Flow<NetworkResponseState<RecipeDetailMapperModel>>
}