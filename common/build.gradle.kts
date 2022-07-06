
plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
    id("myDependencies")
    id("myBuildConfig")

}

android {
    compileSdkVersion(Android.COMPILE_SDK_VERSION)

    defaultConfig {
        minSdkVersion(Android.MIN_SDK_VERSION)
        targetSdkVersion(Android.TARGET_SDK_VERSION)
        vectorDrawables.useSupportLibrary = true
        multiDexEnabled = true

    }


    @Suppress("UnstableApiUsage")
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    api(LibDependency.COROUTINES_ANDROID)
    api(LibDependency.COROUTINES)
    api (LibDependency.CORE_KTX)

    api (LibDependency.KOTLIN)
    api (LibDependency.KOTLIN_RUNTIME)


    api(LibDependency.LIFECYCLE_EXTENSIONS)
    api(LibDependency.LIFECYCLE_PROCESS)
    api(LibDependency.LIFE_CYCLES_RUN_TIME)

    api (LibDependency.APP_COMPAT)

    api(LibDependency.COMPOSE_ACTIVITY)
    api(LibDependency.COMPOSE_MATERIAL)
    api(LibDependency.COMPOSE_UI_TOOLING)
    api(LibDependency.COMPOSE_VIEW_MODEL_LIFE_CYCLE)
    api(LibDependency.COMPOSE_NAVIGATION)
    api(LibDependency.COMPOSE_KOIN)
    api(LibDependency.COMPOSE_GLIDE)
    api(LibDependency.COMPOSE_RUNTIME_LIVE_DATA)
    api(LibDependency.COMPOSE_COIL)
    api (LibDependency.GLIDE)
    api (LibDependency.GSON)
    api (LibDependency.RETROFIT_CONVERTER)
    api (LibDependency.OKHTTP)
    debugApi (LibDependency.LOGGING)
    api (LibDependency.RETROFIT)
    api (LibDependency.RETROFIT_RX_CONVERTER)

}
