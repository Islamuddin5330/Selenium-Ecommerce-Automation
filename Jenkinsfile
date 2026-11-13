
pipeline {
    agent any

    tools {
        jdk 'JDK21'
        maven 'Maven3'
    }

    stages {

        stage('Checkout') {
            steps {
                echo 'Checking out GitHub project'
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo 'Building Maven project'
                bat 'mvn clean compile'
            }
        }

        stage('Run Selenium Tests') {
            steps {
                echo 'Executing TestNG test suite'
                bat 'mvn test -Dsurefire.suiteXmlFiles=testng.xml -Dheadless=true'
            }
        }
    }

    post {
        always {
            junit allowEmptyResults: true,
                  testResults: '**/surefire-reports/*.xml'

            archiveArtifacts artifacts:
                'src/test/resources/ExtentReport/**,src/test/resources/ScreenShot/**',
                allowEmptyArchive: true
        }

        success {
            echo 'Automation execution successful!'
        }

        failure {
            echo 'Automation execution failed!'
        }
    }
}
