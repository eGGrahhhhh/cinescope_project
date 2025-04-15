node {

    stage("checkout repo"){
        git branch: 'testVersion',
        url: 'https://github.com/eGGrahhhhh/cinescope_project.git'
    }

    stage("build"){
        sh "./gradlew clean assemble"
    }

    stage("run api and ui tests")
        sh "./gradlew test -Dlogging=true"

}