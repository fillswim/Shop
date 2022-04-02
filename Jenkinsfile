pipeline {
    agent {
        docker { image 'python:latest'}
    }

    stages {
        stage('1-Build') {
            steps {
                sh 'python --version'
            }
        }
    }
}