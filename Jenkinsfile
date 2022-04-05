pipeline {
//     agent {
//         docker { image 'hello-world:latest'}
//     }
    agent {
        label 'master'
    }

    stages {
        stage('Docker login') {
            steps {
                 echo " ============== docker login =================="
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