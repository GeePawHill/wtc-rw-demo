import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "org.geepawhill"
version = "1.0-SNAPSHOT"

plugins {
    application
    java
    kotlin("jvm")
    kotlin("plugin.serialization") version "1.5.30"
}

repositories {
    jcenter()
}

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.2.2")
}

application {
    mainClass.set("org.geepawhill.rws.ServerKt")
}

kotlin {
    tasks.withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "14"
        }
    }
}
tasks.withType<Test> {
    useJUnitPlatform()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.4.10")
    implementation(project(":rwu"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.5.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.5.2")
    testImplementation("org.assertj:assertj-core:3.11.1")
}