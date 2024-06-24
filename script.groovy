def testApp() {
    echo "testing the application"
}

def buildApp() {
    echo "Building the docker image version ${params.VERSION}"
    withCredentials([usernamePassword(credentialsId: 'docker_hub_repo', usernameVariable: 'USER', passwordVariable: 'PWD')]) {
                        sh "docker build -t walidali123/my-repo:${params.VERSION} ."
                        sh "echo $PWD | docker login -u $USER --password-stdin"
                        sh "docker push walidali123/my-repo:${params.VERSION}"
                    }
}

def deployApp() {
   echo "Deploying the image"
}
return this
