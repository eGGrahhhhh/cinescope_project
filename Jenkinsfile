node {

    stage("checkout repo"){
        git branch: 'testVersion',
        url: 'https://github.com/eGGrahhhhh/cinescope_project.git'
    }

    stage("build"){
        sh 'chmod +x ./gradlew'
        sh "./gradlew clean assemble"
    }

    stage("run api and ui tests"){
        sh 'chmod +x ./gradlew'
        sh "./gradlew test -Dlogging=${LOGGING}"
    }

    allure{
        includeProperties: false,
        jdk: '',
        results: [[path: 'api/build/allure-results'], [path: 'ui/build/allure-results']]
    }
}