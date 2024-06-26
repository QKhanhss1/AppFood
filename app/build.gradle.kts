plugins {
    alias(libs.plugins.androidApplication)
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.AppFood"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.AppFood"
        minSdk = 25
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        vectorDrawables.useSupportLibrary = true

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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.firebase.analytics)
    implementation(libs.firebase.auth)
    implementation(libs.firebase.database)
    implementation(libs.firebase.storage)
    implementation(libs.firebase.messaging)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    // Extra dependencies
    implementation("com.squareup.retrofit2:retrofit:2.6.1")
    implementation("com.squareup.retrofit2:converter-gson:2.6.1")
    implementation("com.google.android.material:material:1.1.0")
    implementation("androidx.vectordrawable:vectordrawable:1.1.0")
    implementation("androidx.navigation:navigation-fragment:2.3.0")
    implementation("androidx.cardview:cardview:1.0.0")
    implementation("com.squareup.picasso:picasso:2.71828")
    implementation("androidx.recyclerview:recyclerview:1.1.0")
    annotationProcessor("com.github.bumptech.glide:compiler:4.11.0")
    implementation("com.github.bumptech.glide:glide:4.11.0")
    implementation("androidx.navigation:navigation-ui:2.3.0")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("com.hbb20:ccp:2.6.1")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("com.firebaseui:firebase-ui-database:8.0.2")
//    implementation("com.cepheuen.elegant-number-button:lib:1.0.2")
//    implementation("com.theartofdev.edmodo:android-image-cropper:2.8.0")

}
