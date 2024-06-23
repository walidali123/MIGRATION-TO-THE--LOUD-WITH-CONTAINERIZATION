#!/usr/bin/env groovy



pipeline {
    agent any

    stages {


        stage("build image") {
            steps {
                script {
                    echo "building the image"
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

