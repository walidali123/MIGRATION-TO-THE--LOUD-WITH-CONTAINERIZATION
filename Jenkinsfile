#!/usr/bin/env groovy


pipeline {
    agent any
    environment {
        NEW_VERSION = '1.3.0'
    }

    stages {

        stage("test") {

            
            steps{
                echo " testing the application"
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
                }
            }
        }
    }
}

