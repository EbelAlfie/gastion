import java.net.URI

// Top-level build file where you can add configuration options common to all sub-projects/modules.
//repositories {
//
//}
buildscript {
  dependencies {
    classpath("com.google.android.libraries.mapsplatform.secrets-gradle-plugin:secrets-gradle-plugin:2.0.1")
  }
}
plugins {
  alias(libs.plugins.androidApplication) apply false
  alias(libs.plugins.jetbrainsKotlinAndroid) apply false
  id("com.google.dagger.hilt.android") version "2.48" apply false
}
