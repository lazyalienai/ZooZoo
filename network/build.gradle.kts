plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.hilt.android)
    alias(libs.plugins.kotlin.kapt)
}

android {
    namespace = "com.saayi.network"
    compileSdk = 36

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {

        debug {
            buildConfigField("String", "POSTS_BASE_URL","\"https://jsonplaceholder.typicode.com/\"" )


            buildConfigField("String", "MOVIES_API_KEY","\"85392febe00c0a6de35058f29785ffff\"" )
            buildConfigField("String", "MOVIES_BASE_URL","\"https://api.themoviedb.org/3/movie/\"" )
            buildConfigField("String", "MOVIES_IMAGE_BASE_URL","\"https://image.tmdb.org/t/p/original\"" )
        }
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String", "POSTS_BASE_URL","\"https://jsonplaceholder.typicode.com/\"" )

            buildConfigField("String", "MOVIES_API_KEY","\"85392febe00c0a6de35058f29785ffff\"" )
            buildConfigField("String", "MOVIES_BASE_URL","\"https://api.themoviedb.org/3/movie/\"" )
            buildConfigField("String", "MOVIES_IMAGE_BASE_URL","\"https://image.tmdb.org/t/p/original\"" )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_18
        targetCompatibility = JavaVersion.VERSION_18
    }
    kotlinOptions {
        jvmTarget = "18"
    }
    buildFeatures {
        buildConfig = true
    }

}

dependencies {
    implementation(project(":common"))
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Retrofit & Gson
    implementation(libs.retrofit)
    implementation(libs.retrofit.gson)

    implementation(libs.okhttp)
    implementation(libs.okhttp.logging)

    // Coroutines
    implementation(libs.kotlinx.coroutines.android)

    // Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
    implementation(libs.hilt.navigation.compose)
}