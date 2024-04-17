package com.example.data.repository

import android.app.Application
import com.example.core.dto.NetworkResponseState
import com.example.data.datasource.remote.ReceipeRemoteDataSource
import com.example.data.mapper.ReceipeResponseToModelMapper
import com.example.data.utils.Constants
import com.example.data.utils.Utils
import com.example.domain.model.RecipeMapperModel
import com.example.domain.repository.ReceipeRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ReceipeRepositoryImpl @Inject constructor(
    private val receipeRemoteDataSource: ReceipeRemoteDataSource,
    private val receipeResponseToModelMapper: ReceipeResponseToModelMapper,
    private val iODispatcher: CoroutineDispatcher = Dispatchers.IO
) : ReceipeRepository {
    override  fun getReceipesInfo(context: Application): Flow<NetworkResponseState<List<RecipeMapperModel>>> {
         return  flow {
             val isInternetConnected = Utils.hasInternetConnection(context)
             if (isInternetConnected) {
                 emit(NetworkResponseState.Loading)
                 when(val response = receipeRemoteDataSource.getReceipes()){

                     is NetworkResponseState.Success -> {
                         emit(NetworkResponseState.Success(response.result?.let { receipeResponseToModelMapper.invoke(it) }))
                     }

                     is NetworkResponseState.Error -> {
                         emit(NetworkResponseState.Error(response.exception))
                     }
                     else -> {}
                 }
             }else{
                 emit(NetworkResponseState.Error(Constants.API_INTERNET_MESSAGE))
             }

         }.flowOn(iODispatcher)
    }
}