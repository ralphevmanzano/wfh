object Config {
  const val minSdkVersion = 21
  const val targetSdkVersion = 31
  const val compileSdkVersion = 31
  const val versionCode = 1
  const val versionName = "1.0.0"
  const val applicationId = "com.ralphevmanzano.workoutsforhumans"
  const val androidTestInstrumentation = "androidx.test.runner.AndroidJUnitRunner"
  const val consumerRulesPro = "consumer-rules.pro"
}

object Modules {
  const val app = ":app"
  const val common = ":common"
  const val core = ":core"
}

object Features {
  const val home = ":features:home"
  const val details = ":features:details"
}

object Versions {
  const val kotlin = "1.6.0"
  const val coroutines = "1.6.0"
  const val gradleTools = "7.0.4"

  const val androidxCore = "1.7.0"
  const val androidxAppCompat = "1.4.1"
  const val googleMaterial = "1.5.0"
  const val androidxConstraintLayout = "2.1.3"
  const val androidxLegacySupport = "1.0.0"

  const val room = "2.4.1"
  const val fragment = "1.4.1"
  const val lifecycle = "2.4.0"
  const val navigation = "2.4.0"
  const val hiltAndroid = "2.40.5"
  const val hilt = "1.0.0-alpha03"

  const val glide = "4.12.0"

  const val timber = "5.0.1"

  const val junit = "4.13.2"
  const val junitTestExt = "1.1.3"
  const val espresso = "3.4.0"
  const val mockito = "3.5.15"
  const val archCoreTesting = "2.1.0"
}

object Libs {
  const val gradleTools = "com.android.tools.build:gradle:${Versions.gradleTools}"

  // Kotlin
  const val kotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"

  // Coroutines
  const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
  const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
  const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"

  const val androidxCore = "androidx.core:core-ktx:${Versions.androidxCore}"
  const val androidxAppCompat = "androidx.appcompat:appcompat:${Versions.androidxAppCompat}"
  const val googleMaterial = "com.google.android.material:material:${Versions.googleMaterial}"
  const val androidXConstraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.androidxConstraintLayout}"
  const val androidxLegacySupport = "androidx.legacy:legacy-support-v4:${Versions.androidxLegacySupport}"

  // Fragments
  const val fragments = "androidx.fragment:fragment-ktx:${Versions.fragment}"
  const val viewModels = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"

  // Navigation
  const val navigation = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
  const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
  const val safeArgsPlugin = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}"

  // Room
  const val room = "androidx.room:room-runtime:${Versions.room}"
  const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
  const val roomKtx = "androidx.room:room-ktx:${Versions.room}"

  // Hilt
  const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hiltAndroid}"
  const val hiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hiltAndroid}"
  const val hiltPlugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hiltAndroid}"
  const val hiltLifecycleViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hilt}"
  const val hiltCompiler = "androidx.hilt:hilt-compiler:${Versions.hilt}"

  // Glide
  const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
  const val glideProcessor = "com.github.bumptech.glide:compiler:${Versions.glide}"

  // Timber
  const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

  // Test
  const val junit = "junit:junit:${Versions.junit}"
  const val junitExt = "androidx.test.ext:junit:${Versions.junitTestExt}"
  const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
  const val mockito = "org.mockito:mockito-core:${Versions.mockito}"
  const val archCoreTesting = "androidx.arch.core:core-testing:${Versions.archCoreTesting}"
  const val kotlinCoroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.kotlin}"
}

