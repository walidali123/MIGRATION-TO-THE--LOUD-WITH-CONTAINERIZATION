#!/usr/bin/env groovy


pipeline {
    agent any
    environment {
        NEW_VERSION = '1.3.0'
        SERVER_CREDENTIALS = credentials('docker_hub_repo')
    }
   

    stages {

        stage("test") {

            
            steps{
                echo " testing the application ${NEW_VERSION}"
            }
        }

        stage("build image") {
            steps {
                script {
                    echo " building the image version ${NEW_VERSION} "
                }
            }
        }
        stage("deploy") {
            steps {
                script {
                     echo "deploying the image"
                     withCredentials([
                        usernamePassword(credentials: 'docker_hub_repo', usernameVariable: USER, passwordVariable: PWD )

                     ]) {

                     }
                }
            }
        }
    }
}


