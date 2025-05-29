pipeline {
    agent any

    tools {
        maven 'Maven 3.6.0'
        jdk 'Java 17'
    }

    stages {
        stage("Build") {
            steps {
                sh 'mvn clean install'
            }
        }

        stage("Test") {
            steps {
                sh 'mvn test'
            }
        }

        stage("Publish Test Results") {
            steps {
                junit allowEmptyResults: true, testResults: '**/test-output/testng-results.xml'
            }
        }
    }

    post {
        always {
            echo 'Pipeline completed.'
        }
    }
}
