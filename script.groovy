def buildApp() {
    echo "Building the image version ${params.VERSION}"
}

def testApp() {
    echo "testing the application"
}

def deploydApp() {
   echo "Deploying the image"
}
return this
