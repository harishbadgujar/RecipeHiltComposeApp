// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainKotlin) apply false
    alias(libs.plugins.androidLibrary) apply false
   /* alias(libs.plugins.org.jetbrains.kotlin.kapt) apply false*/
    alias(libs.plugins.androidHilt) apply false

    //id("com.google.dagger.hilt.android") version ("2.41") apply false
   // id("com.google.dagger.hilt.android") version "2.48" apply false
}