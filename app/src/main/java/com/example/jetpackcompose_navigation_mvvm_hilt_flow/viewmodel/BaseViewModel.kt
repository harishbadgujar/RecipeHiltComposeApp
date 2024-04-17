package com.example.jetpackcompose_navigation_mvvm_hilt_flow.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel


open class BaseViewModel(application: Application) : AndroidViewModel(application) {
  protected val context
    get() = getApplication<Application>()
}