def buildJar() {
    echo "building the application..."
    sh 'mvn package'
} 

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'b4a8af34-f778-49ef-9c08-02a6ad8901e5', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t abinash8/myrepo:j-1.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push abinash8/myrepo:j-1.0'
    }
} 

def deployApp() {
    echo 'deploying the application...'
} 

return this