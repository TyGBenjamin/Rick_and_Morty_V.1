// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application").version("7.2.1").apply(false)
    id("com.android.library").version("7.2.1").apply(false)
    id("org.jetbrains.kotlin.android").version("1.7.0").apply(false)
}

tasks.register(name = "type", type = Delete::class) {
    delete(rootProject.buildDir)
}