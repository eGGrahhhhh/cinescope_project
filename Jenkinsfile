node {

    stage("checkout repo") {
        git branch: 'testVersion',
        url: 'https://github.com/eGGrahhhhh/cinescope_project.git'
    }

    stage("build") {
        sh "chmod +x ./gradlew"
        sh "./gradlew clean assemble"
    }

    stage('Run API Tests') {
        sh "./gradlew test -Dgroups=API_tests -Dlogging=${LOGGING}"
            }

    stage('Run UI Tests') {
        sh "./gradlew test -Dgroups=UI_tests -Dlogging=${LOGGING}"
            }

    allure([
        jdk: '',
        properties: [],
        reportBuildPolicy: 'ALWAYS',
        results: [[path: 'api/build/allure-results'],[path: 'ui/build/allure-results']]
    ])
}