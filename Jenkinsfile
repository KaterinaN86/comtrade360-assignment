node {
def WORKSPACE = "/var/lib/jenkins/workspace/springboot-demo-deploy"
def dockerImageTag = "assignment:latest"
  
  try{
       stage('Clone Repo') {
        // for display purposes
        // Get some code from a GitHub repository
        git url: 'https://github.com/KaterinaN86/comtrade360-assignment.git',
            credentialsId: 'my_credentials',
            branch: 'main'
     }    
       stage('Deploy docker'){
              echo "Docker Image Tag Name: ${dockerImageTag}"
              sh "docker stop assignment || true && docker rm assignment || true"
              sh "docker run --name assignment -d -p 8084:8084 assignment:latest"
      }
}catch(e){
    currentBuild.result = "FAILED"
    throw e
}
 
}
