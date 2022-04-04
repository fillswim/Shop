pipeline {
//     agent {
//         docker { image 'hello-world:latest'}
//     }
    agent {
        label 'master'
    }

    stages {
        stage('1-Pull') {
            steps {
                sh 'docker pull hello-world'
            }
        }
        stage('2-Run') {
            steps {
                sh 'docker run hello-world'
            }
        }
    }
}