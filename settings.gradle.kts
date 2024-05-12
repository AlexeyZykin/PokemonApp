pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "PokemonApp"
include(":app")
include(":core:network")
include(":core:data")
include(":core:model")
include(":core:datasource")
include(":feature:pokemon_catalog")
include(":core:domain")
include(":core:resources")
include(":feature:pokemon_details")
include(":core:common")
