package PredictingNumbers.buildTypes

import jetbrains.buildServer.configs.kotlin.v10.*
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.MavenBuildStep
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.MavenBuildStep.*
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.ScriptBuildStep
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.ScriptBuildStep.*
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v10.triggers.VcsTrigger
import jetbrains.buildServer.configs.kotlin.v10.triggers.VcsTrigger.*
import jetbrains.buildServer.configs.kotlin.v10.triggers.vcs

object PredictingNumbers_Build : BuildType({
    uuid = "f9d7a1dc-0faf-4fc5-ae3a-0c7527e9cb8a"
    extId = "PredictingNumbers_Build"
    name = "Build"

    vcs {
        root(PredictingNumbers.vcsRoots.PredictingNumbers_HttpsGithubComChufanzhuPredictingNumbersGitRefsHeadsMaster)

    }

    steps {
        maven {
            goals = "clean compile test"
            mavenVersion = defaultProvidedVersion()
        }
        script {
            name = "hello world hello"
            scriptContent = """echo "hello world""""
        }
    }

    triggers {
        vcs {
        }
    }
})
