#!/usr/bin/env groovy



def gv

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
                script {
                    gv = load "script.groovy"
                    gv.testApp()
                }
            }
        }
        stage("build image") {
            steps {
                script {
                    gv.buildApp()
                 
                }
            }
        }
        stage("deploy") {
            steps {
                script {
                    gv.deployApp() 
                }
            }
        }
    }
}
