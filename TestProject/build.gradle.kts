plugins {
    kotlin("jvm") version "2.0.0" // Kotlin version to use
    application
}

version = "1.0" // Version to assign to the built artifact

repositories {
    mavenCentral() 
}

dependencies {
    testImplementation(kotlin("test")) // The Kotlin test library

    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5") 

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

application {
    mainClass = "MainKt"
}

tasks.test {
    useJUnitPlatform()
}
