// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("io.realm:realm-gradle-plugin:10.11.1")
        classpath("io.realm:realm-gradle-plugin:10.13.3-transformer-api")

    }
}

plugins {
    id("com.android.application") version "8.1.0" apply false
    id("org.jetbrains.kotlin.android") version "1.8.0" apply false
//    id("io.realm.kotlin") version "1.10.0" apply false

}