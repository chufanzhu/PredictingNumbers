package PredictingNumbers

import PredictingNumbers.buildTypes.*
import PredictingNumbers.vcsRoots.*
import PredictingNumbers.vcsRoots.PredictingNumbers_HttpsGithubComChufanzhuPredictingNumbersGitRefsHeadsMaster
import jetbrains.buildServer.configs.kotlin.v10.*
import jetbrains.buildServer.configs.kotlin.v10.Project
import jetbrains.buildServer.configs.kotlin.v10.projectFeatures.VersionedSettings
import jetbrains.buildServer.configs.kotlin.v10.projectFeatures.VersionedSettings.*
import jetbrains.buildServer.configs.kotlin.v10.projectFeatures.versionedSettings

object Project : Project({
    uuid = "bca92631-0b59-44b9-a7f8-32ee360a8043"
    extId = "PredictingNumbers"
    parentId = "_Root"
    name = "PredictingNumbers"

    vcsRoot(PredictingNumbers_HttpsGithubComChufanzhuPredictingNumbersGitRefsHeadsMaster)

    buildType(PredictingNumbers_Build)

    features {
        versionedSettings {
            id = "PROJECT_EXT_2"
            mode = VersionedSettings.Mode.ENABLED
            buildSettingsMode = VersionedSettings.BuildSettingsMode.PREFER_CURRENT_SETTINGS
            rootExtId = PredictingNumbers_HttpsGithubComChufanzhuPredictingNumbersGitRefsHeadsMaster.extId
            showChanges = true
            settingsFormat = VersionedSettings.Format.KOTLIN
            param("credentialsStorageType", "credentialsJSON")
        }
    }
})
