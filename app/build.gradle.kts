plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "org.coffeetrainlabs.genericserializerfailure"
    compileSdk {
        version = release(37)
    }

    defaultConfig {
        applicationId = "org.coffeetrainlabs.genericserializerfailure"
        minSdk = 24
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            optimization {
                enable = false
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_25
        targetCompatibility = JavaVersion.VERSION_25
    }
}

dependencies {
    implementation(platform(libs.kotlin.bom))
    implementation(libs.androidx.appcompat)
    implementation(libs.kotlin.serialization.core)
    implementation(libs.kotlin.serialization.json)
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)
    testImplementation(libs.junit)
    testImplementation(libs.truth)
}
