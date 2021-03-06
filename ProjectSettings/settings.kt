import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.python
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.vcs
import jetbrains.buildServer.configs.kotlin.v2019_2.vcs.GitVcsRoot

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2021.2"

project {

    vcsRoot(HttpsGithubComNagendra1522TeamCityPracticeGitRefsHeadsMain)

    buildType(Build)
}

object Build : BuildType({
    name = "Testing Build"

    vcs {
        root(HttpsGithubComNagendra1522TeamCityPracticeGitRefsHeadsMain)
    }

    steps {
        python {
            command = file {
                filename = "one.py"
            }
        }
        python {
            command = file {
                filename = "two.py"
            }
        }
    }

    triggers {
        vcs {
        }
    }
})

object HttpsGithubComNagendra1522TeamCityPracticeGitRefsHeadsMain : GitVcsRoot({
    name = "https://github.com/Nagendra1522/TeamCity-Practice.git#refs/heads/main"
    url = "https://github.com/Nagendra1522/TeamCity-Practice.git"
    branch = "refs/heads/main"
    branchSpec = "refs/heads/*"
    authMethod = password {
        userName = "Nagendra1522"
        password = "credentialsJSON:8e5b5319-00e6-4d90-91d3-74e80c86098b"
    }
})
