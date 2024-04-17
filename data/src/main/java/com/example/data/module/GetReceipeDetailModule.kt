package com.example.data.module

import com.example.data.datasource.remote.ReceipeRemoteDataSource
import com.example.data.mapper.RecipeDetailResponseToModelMapper
import com.example.data.repository.RecipeDetailRepositoryImpl
import com.example.domain.repository.RecipeDetailRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
class GetReceipeDetailModule {

    @Provides
    fun providesReceipeDetailResponseToModelMapper() : RecipeDetailResponseToModelMapper {
        return RecipeDetailResponseToModelMapper()
    }

    @Provides
    fun providesReceipeDetailRepository(
        receipeRemoteDataSource : ReceipeRemoteDataSource,
        domainMapper: RecipeDetailResponseToModelMapper
    ) : RecipeDetailRepository {
        return RecipeDetailRepositoryImpl(
            receipeRemoteDataSource,
            domainMapper
        )
    }

   /* @Provides
    fun providesReceipeDetailRemoteDataSource(api : ApiService) : ReceipeRemoteDataSource {
        return ApiServiceDataSourceImpl(api)
    }*/

}
