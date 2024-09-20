plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)

    //dagger
    id("com.google.devtools.ksp")

    //id("org.jetbrains.kotlin.jvm") version  "1.9.0" <-типо надо, но с ним не раб
}

android {
    namespace = "com.example.myapplication"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.myapplication"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.8"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    //hilt
    val hiltVers = 2.52
    ksp("com.google.dagger:dagger-compiler:$hiltVers")
    ksp("com.google.dagger:hilt-compiler:$hiltVers")
    //\ поменять на 2.50 если не полетит
    implementation("com.google.dagger:hilt-android:$hiltVers")
    annotationProcessor("com.google.dagger:hilt-compiler:$hiltVers")
    //На всякий случай с Баженова
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")

    //navigation
    implementation("androidx.navigation:navigation-compose:2.7.7")

    //Room
    val RoomVers = "2.6.1"
    implementation("androidx.room:room-runtime:$RoomVers")
    annotationProcessor("androidx.room:room-compiler:$RoomVers")
    ksp("androidx.room:room-compiler:$RoomVers")

    //livedata
    implementation("androidx.compose.runtime:runtime-livedata:1.6.8")

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}

