package com.example.data.module

import com.example.data.datasource.remote.ApiService
import com.example.data.datasource.remote.ApiServiceDataSourceImpl
import com.example.data.datasource.remote.ReceipeRemoteDataSource
import com.example.data.mapper.ReceipeResponseToModelMapper
import com.example.data.repository.ReceipeRepositoryImpl
import com.example.domain.repository.ReceipeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class GetReceipeModule {

    @Provides
    fun providesReceipeResponseToModelMapper() : ReceipeResponseToModelMapper {
        return ReceipeResponseToModelMapper()
    }

    @Provides
    fun providesReceipeRepository(
        receipeRemoteDataSource : ReceipeRemoteDataSource,
        domainMapper: ReceipeResponseToModelMapper
    ) : ReceipeRepository {
        return ReceipeRepositoryImpl(
            receipeRemoteDataSource,
            domainMapper
        )
    }

    @Provides
    fun providesReceipeRemoteDataSource(api : ApiService) : ReceipeRemoteDataSource {
        return ApiServiceDataSourceImpl(api)
    }

}