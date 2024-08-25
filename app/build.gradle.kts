plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.ksp)
    id("androidx.navigation.safeargs")
}

android {
    namespace = "com.example.mycrypto"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.mycrypto"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    buildFeatures{
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

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //Retrofit
    implementation(libs.gson)
    implementation(libs.retrofit)
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    //Room
    implementation(libs.androidx.room)
    ksp(libs.androidx.room.compiler)

    //Dagger2
    implementation(libs.dagger.android)
    ksp(libs.dagger.compiler)

    //LifeCycle
    implementation(libs.androidx.lifecycle.viewmodel.ktx)

    //Glide
    implementation(libs.glide)

}