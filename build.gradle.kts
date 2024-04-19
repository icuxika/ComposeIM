import org.jetbrains.compose.ExperimentalComposeLibrary
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    id("org.jetbrains.compose")
}

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
}

dependencies {
    // Note, if you develop a library, you should use compose.desktop.common.
    // compose.desktop.currentOs should be used in launcher-sourceSet
    // (in a separate module for demo project and in testMain).
    // With compose.desktop.common you will also lose @Preview functionality
    implementation(compose.desktop.currentOs)
    implementation(compose.material3)
    implementation(compose.materialIconsExtended)
    @OptIn(ExperimentalComposeLibrary::class)
    implementation(compose.desktop.components.splitPane)
    implementation(compose.components.resources)

    // Include the Test API
    testImplementation(compose.desktop.uiTestJUnit4)
}

compose.desktop {
    application {
        mainClass = "MainKt"
        jvmArgs("--enable-preview", "--enable-native-access=ALL-UNNAMED", "-Dsun.stdout.encoding=UTF-8")

        nativeDistributions {
            windows {
                upgradeUuid = "e84caa7e-cb40-402f-8daa-58e79678cd89"
                perUserInstall = true
                menu = true
                shortcut = true
            }

            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "ComposeIM"
            packageVersion = "1.0.0"
            description = "Compose Example App"
            copyright = "© 2024 icuxika. All rights reserved."
            vendor = "My Manufacturer Name"
        }
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "21"
    }
}

tasks.withType<JavaCompile> {
    options.release.set(21)
    options.compilerArgs.add("--enable-preview")
}