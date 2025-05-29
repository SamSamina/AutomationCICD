pipeline {
    agent any

    tools {
        maven 'Maven 3.9.9' // or whatever name you see in Jenkins > Global Tool Configuration
        // Remove JDK if it's not installed/configured
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
    }

    post {
        always {
            echo 'Pipeline completed.'
        }
    }
}
