plugins {
    //id("com.android.application")
    alias(libs.plugins.com.android.application)
    //id("org.jetbrains.kotlin.android")
    alias(libs.plugins.org.jetbrains.kotlin.android)
    //id ("kotlin-android")
    //id ("kotlin-kapt")
    kotlin("kapt")
    //id("com.google.dagger.hilt.android")
    alias(libs.plugins.com.google.dagger.hilt.android)
}

android {
    namespace = "com.example.prayertracker"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.prayertracker"
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
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    /*implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")

    implementation("androidx.compose.material3:material3")

    implementation("androidx.navigation:navigation-compose:2.7.6")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.6.2")
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.compose.bom))
    */
    //implementation("androidx.compose.material3:material3:1.1.2")
    implementation(libs.material3)

    implementation(libs.bundles.androidx.compose)

    //testImplementation("junit:junit:4.13.2")
    testImplementation(libs.junit)
    //androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation(libs.test.ext)
    //androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(libs.espresso.core)
    //androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation(platform(libs.compose.bom))

    //androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    androidTestImplementation(libs.compose.ui.test)

    //debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation(libs.compose.ui.tooling)



    /*implementation("com.google.dagger:hilt-android:2.49")
    implementation("androidx.hilt:hilt-navigation-fragment:1.1.0")

    kapt("androidx.hilt:hilt-compiler:1.1.0")

    implementation("androidx.hilt:hilt-navigation-compose:1.1.0")
    kapt("com.google.dagger:hilt-android-compiler:2.49")*/

    implementation(libs.bundles.androidx.hilt.impl)
    kapt(libs.bundles.androidx.hilt.kapt)

    //implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")
    implementation(libs.org.core.ktx)


    /*implementation("androidx.room:room-runtime:2.6.1")
    annotationProcessor("androidx.room:room-compiler:2.6.1")
    kapt("androidx.room:room-compiler:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")*/

    //implementation(libs.androidx.room.runtime)
    implementation(libs.bundles.androidx.room)
    annotationProcessor(libs.androidx.room.compiler)
    kapt(libs.androidx.room.compiler)

    /*implementation("com.github.bumptech.glide:glide:4.12.0")
    annotationProcessor("com.github.bumptech.glide:compiler:4.12.0")*/
    implementation(libs.github.glide)
    annotationProcessor(libs.github.glide.compiler)
}