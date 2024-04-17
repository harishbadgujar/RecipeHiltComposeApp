package com.example.jetpackcompose_navigation_mvvm_hilt_flow.viewmodel

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.example.core.dto.NetworkResponseState
import com.example.domain.model.RecipeDetailMapperModel
import com.example.domain.model.RecipeMapperModel
import com.example.domain.usecase.ReceipeDetailUseCase
import com.example.domain.usecase.ReceipeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainApiViewModel @Inject constructor(
    private val receipeUseCase: ReceipeUseCase,
    private val receipeDetailUseCase: ReceipeDetailUseCase,
    application: Application
) : BaseViewModel(application) {

    private val _state = MutableStateFlow(ReceipeViewState())
    val state: StateFlow<ReceipeViewState>
        get() = _state.asStateFlow()

    /*private val _stateRecipeDetail = MutableStateFlow(ReceipeViewState())
    val stateRecipeDetail: StateFlow<ReceipeViewState>
        get() = _stateRecipeDetail.asStateFlow()*/

    init {
        getReceipes(context)
       // getRecipeDetail(1)
    }

    fun getReceipes(context: Application) {
        val result = receipeUseCase.getReceipeList(context)
        viewModelScope.launch {
            result.collectLatest {
                when (it) {
                    is NetworkResponseState.Error -> {
                        _state.value = _state.value.copy(showProgress = false)
                    }
                    NetworkResponseState.Loading -> {
                        _state.value = _state.value.copy(showProgress = false)
                    }
                    is NetworkResponseState.Success -> {
                        _state.value = _state.value.copy(
                            showProgress = false,
                            getReceipeList = it.result,
                        )
                    }
                }
            }
        }

    }

    fun getRecipeDetail(id:Int?){
        val recipeDetail = receipeDetailUseCase.getRecipeDetail(id)
        viewModelScope.launch {
            recipeDetail.collectLatest {
                when (it) {
                    is NetworkResponseState.Error -> {
                        _state.value = _state.value.copy(showProgress = false)
                    }
                    NetworkResponseState.Loading -> {
                        _state.value = _state.value.copy(showProgress = false)
                    }
                    is NetworkResponseState.Success -> {
                        _state.value = _state.value.copy(
                            showProgress = false,
                            getRecipeDetail = it.result,
                        )
                    }
                }
            }
        }
    }
}


data class ReceipeViewState(
    val showProgress: Boolean = true,
    val showAlertDialog: Boolean = false,
    val getReceipeList: List<RecipeMapperModel>? = emptyList(),
    val getRecipeDetail: RecipeDetailMapperModel? = null
)



