pipeline {
  agent any
  stages {
    stage('Clean') {
      steps {
        git(url: 'https://github.com/jahanvibansal/ApacheCamelSpringBoot.git', poll: true)
      }
    }

    stage('Build') {
      parallel {
        stage('Build') {
          steps {
            sh 'sh \'maven package\''
          }
        }

        stage('Test') {
          steps {
            sh 'mvn test'
          }
        }

      }
    }

    stage('Notification') {
      steps {
        junit '**/target/surefire-reports/TEST-*.xml'
      }
    }

  }
}