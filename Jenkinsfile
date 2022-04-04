pipeline {
    agent {
        docker { image 'hello-world:latest'}
    }

    stages {
        stage('1-Build') {
            steps {
                sh 'docker run hello-world'
            }
        }
    }
}