plugins {
    kotlin("multiplatform") version "2.2.0"
}

group = "com.wattsonic"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    js {
        //useEsModules()
        browser {
//            webpackTask {
//                output.libraryTarget = "commonjs2"
//            }
        }
        nodejs()
        binaries.executable()
        generateTypeScriptDefinitions()
    }

    sourceSets {
        val jsMain by getting {
            dependencies {
                implementation(kotlin("stdlib-js"))
            }
        }
    }
}