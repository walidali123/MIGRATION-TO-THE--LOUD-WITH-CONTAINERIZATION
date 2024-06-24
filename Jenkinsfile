#!#!/usr/bin/env groovy

pipeline {
    agent any
    parameters {
        choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
        booleanParam(name: 'executeTest', defaultValue: true, description: '')
    }
    environment {
        
        SERVER_CREDENTIALS = credentials('docker_hub_repo')
    }
    stages {
        stage("test") {
            when {
                expression {
                    params.executeTest
                }
            }
            steps {
                echo "Testing the application ${params.VERSION}"
            }
        }
        stage("build image") {
            steps {
                script {
                    echo "Building the image version ${params.VERSION}"
                }
            }
        }
        stage("deploy") {
            steps {
                script {
                    echo "Deploying the image"
                    withCredentials([usernamePassword(credentialsId: 'docker_hub_repo', usernameVariable: 'USER', passwordVariable: 'PWD')]) {
                        sh "echo some script \${USER} \${PWD}"
                    }
                }
            }
        }
    }
}
