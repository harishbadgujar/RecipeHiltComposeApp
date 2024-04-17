package com.example.domain.repository

import android.app.Application
import com.example.core.dto.NetworkResponseState
import com.example.domain.model.RecipeMapperModel
import kotlinx.coroutines.flow.Flow

interface ReceipeRepository {

     fun getReceipesInfo(context: Application): Flow<NetworkResponseState<List<RecipeMapperModel>>>

}