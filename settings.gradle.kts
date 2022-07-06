pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_PROJECT)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "FilmNetChallenge"
include(":app", ":common",
    ":domain", ":data")
includeBuild("DependenciesPlugin")
includeBuild("BuildConfigPlugin")

