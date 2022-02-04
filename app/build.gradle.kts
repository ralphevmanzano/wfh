plugins {
  id("com.android.application")
  kotlin("android")
  kotlin("kapt")
  id("dagger.hilt.android.plugin")
  id("androidx.navigation.safeargs.kotlin")
}

android {
  compileSdk = Config.compileSdkVersion

  defaultConfig {
    applicationId = Config.applicationId
    minSdk  = Config.minSdkVersion
    targetSdk = Config.targetSdkVersion
    versionCode = Config.versionCode
    versionName = Config.versionName

    testInstrumentationRunner = Config.androidTestInstrumentation
  }

  buildTypes {
    getByName("release") {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }

  buildFeatures {
    viewBinding = true
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }

  kotlinOptions {
    jvmTarget = "1.8"
  }
}

dependencies {
  implementation(project(Modules.common))
  implementation(project(Features.home))
  implementation(project(Features.details))

  implementation(Libs.androidxCore)
  implementation(Libs.androidxAppCompat)
  implementation(Libs.googleMaterial)
  implementation(Libs.androidXConstraintLayout)

  implementation(Libs.fragments)

  implementation(Libs.navigation)
  implementation(Libs.navigationUi)

  implementation(Libs.hiltAndroid)
  kapt(Libs.hiltAndroidCompiler)

  implementation(Libs.timber)

  testImplementation(Libs.junit)
  androidTestImplementation(Libs.junitExt)
  androidTestImplementation(Libs.espresso)
}

kapt {
  correctErrorTypes = true
}