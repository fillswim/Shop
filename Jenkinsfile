pipeline {
    agent {
        label 'maven'
    }

    stages {
        stage('Build') {
            steps {
                echo "============== Build =================="
                sh 'mvn clean package'
            }
        }

        stage('Create Docker-Compose') {
            steps {
                echo "============== Create Docker-Compose =================="
                sh 'docker-compose up --force-recreate --no-start'
            }
        }

        stage('Docker login') {
            steps {
                echo "============== Docker login =================="
//                  sh 'whoami'
                sh 'cat /home/ubuntu/docker_password.txt | docker login --username fillswim --password-stdin'
            }
        }

        stage('Push') {
            steps {
                echo "============== Docker push =================="
                sh 'docker-compose push'
            }
        }
    }
}