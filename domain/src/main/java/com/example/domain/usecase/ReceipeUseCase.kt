package com.example.domain.usecase

import android.app.Application
import com.example.core.dto.NetworkResponseState
import com.example.domain.model.RecipeMapperModel
import com.example.domain.repository.ReceipeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ReceipeUseCase @Inject constructor(
    private val repository: ReceipeRepository,
) {
     fun getReceipeList(context: Application): Flow<NetworkResponseState<List<RecipeMapperModel>>>{
       return repository.getReceipesInfo(context)
    }
}