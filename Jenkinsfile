pipeline {
//     agent {
//         docker { image 'hello-world:latest'}
//     }
    agent {
        label 'maven'
    }

    stages {
        stage('Build') {
            steps {
                echo " ============== build =================="
                sh 'mvn clean package'
            }
        }

        stage('Create Docker-Compose') {
            steps {
                echo " ============== Create Docker-Compose =================="
                sh 'docker-compose up --force-recreate --no-start'
            }
        }


        stage('Docker login') {
            steps {
                 echo " ============== docker login =================="
//                  sh 'whoami'
                 sh 'cat /home/ubuntu/docker_password.txt | docker login --username fillswim --password-stdin'
//                  withCredentials([usernamePassword(credentialsId: 'DockerHub-fillswim', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]){
//                     sh 'docker login -u $USERNAME -p $PASSWORD'
//                  }
            }
        }
//         stage('1-Pull') {
//             steps {
//                 sh 'docker pull hello-world'
//             }
//         }
//         stage('2-Run') {
//             steps {
//                 sh 'docker run hello-world'
//             }
//         }
    }
}