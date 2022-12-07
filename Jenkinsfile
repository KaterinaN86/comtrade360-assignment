pipeline {
  agent any
  
  environment {
    DOCKERHUB_CREDENTIALS = credentials('dockerhub_credentials')
  }
  stages {
    stage('Build') {
      steps {
        sh 'docker build -t katerina86/assignment:latest .'
      }
    }
    stage('Login') {
      steps {
        sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
      }
    }
    stage('Push') {
      steps {
        sh 'docker push katerina86/assignment:latest'
      }
    }
  }
  post {
    always {
      sh 'docker logout'
    }
  }
}
