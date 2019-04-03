package PredictingNumbers.vcsRoots

import jetbrains.buildServer.configs.kotlin.v10.*
import jetbrains.buildServer.configs.kotlin.v10.vcs.GitVcsRoot

object PredictingNumbers_HttpsGithubComChufanzhuPredictingNumbersGitRefsHeadsMaster : GitVcsRoot({
    uuid = "bbe9ff1a-0f7f-44f5-a623-3af2d46e09db"
    extId = "PredictingNumbers_HttpsGithubComChufanzhuPredictingNumbersGitRefsHeadsMaster"
    name = "https://github.com/chufanzhu/PredictingNumbers.git#refs/heads/master"
    url = "https://github.com/chufanzhu/PredictingNumbers.git"
    branchSpec = "+:refs/heads/*"
    authMethod = password {
        userName = "chufanzhu@hotmail.com"
        password = "zxx688a918ef67155109118170e6b41b8bb38961e548f6ab99c403947bd2a09ab334527966cca81690c32f0fbeb4ba81499c54e25cbca34eec8"
    }
})
