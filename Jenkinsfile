#!/usr/bin/env groovy


pipeline {
    agent any
    parameters {
      
        choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
        booleanParam(name: 'executeTest', defaultValue: true, description: '')
    }
    environment {
        NEW_VERSION = '1.3.0'
        SERVER_CREDENTIALS = credentials('docker_hub_repo')
    }
   

    stages {

        stage("test") {
            when {
                expression {
                    params.executeTest
                }
            }
       
            
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
                        sh "some script ${USER} ${PWD}"

                     }
                }
            }
        }
    }
}


