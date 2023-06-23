pluginManagement {
    includeBuild("build-logic")

    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {

    val githubUsername = if (extra.properties.keys.contains("gprUser")) {
        extra["gprUser"].toString()
    } else {
        System.getenv("USERNAME")
    }

    val githubSecret = if (extra.properties.keys.contains("gprKey")) {
        extra["gprKey"].toString()
    } else {
        System.getenv("GHPR_PAT")
    }

    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        // Uncomment for artifacts to be resolved from .m2 directory
        // mavenLocal()

        google()
        mavenCentral()
        maven(url = "https://jitpack.io")

        maven {
            name = "GithubPackages"
            url = uri("https://maven.pkg.github.com/viluahealthcare/android-shadowflight-sdk")
            credentials {
                username = githubUsername
                password = githubSecret
            }
        }
    }
}

rootProject.name = "android-recco-sdk"

include(
    "api:ui",
    //":headless",
    ":showcase",
    "internal:core:base",
    "internal:core:logger",
    "internal:core:openapi",
    "internal:core:network",
    "internal:core:persistence",
    "internal:core:ui",
    "internal:core:model",
    "internal:core:repository",
    "internal:feature:questionnaire",
    "internal:feature:feed",
    "internal:feature:article",
    "internal:feature:onboarding",
    "internal:feature:bookmark"
)
