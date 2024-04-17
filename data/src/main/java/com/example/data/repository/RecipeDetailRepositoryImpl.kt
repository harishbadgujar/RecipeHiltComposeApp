package com.example.data.repository

import com.example.core.dto.NetworkResponseState
import com.example.data.datasource.remote.ReceipeRemoteDataSource
import com.example.data.mapper.RecipeDetailResponseToModelMapper
import com.example.domain.model.RecipeDetailMapperModel
import com.example.domain.repository.RecipeDetailRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RecipeDetailRepositoryImpl(
    private val recipeRemoteDataSource: ReceipeRemoteDataSource,
    private val recipeDetailResponseToModelMapper: RecipeDetailResponseToModelMapper,
    private val iODispatcher: CoroutineDispatcher = Dispatchers.IO
) : RecipeDetailRepository {
    override fun getRecipesDetail(id: Int?): Flow<NetworkResponseState<RecipeDetailMapperModel>> {
       return flow {
           emit(NetworkResponseState.Loading)
           when(val response = recipeRemoteDataSource.getRecipeDetail(id)){

               is NetworkResponseState.Success -> {
                   emit(NetworkResponseState.Success(response.result?.let { recipeDetailResponseToModelMapper.invoke(it) }))
               }

               is NetworkResponseState.Error -> {
                   emit(NetworkResponseState.Error(response.exception))
               }
               else -> {}
           }
       }.flowOn(iODispatcher)
    }
}