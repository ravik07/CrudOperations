pipeline {
    agent any

    tools {
        maven 'Maven' 
        jdk 'Java17'  
    }

    stages {

        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('SonarQube Analysis') {
            steps {
            	echo 'Running SonarQube analysis...'
                withSonarQubeEnv('BankSonar') {
                    bat 'mvn sonar:sonar -Dsonar.projectKey=crud-app -Dsonar.host.url=http://localhost:9000 -Dsonar.login=sqa_f5359f3b47a9f4f2b8586d6e753a942320f92440'
                }
            }
        }

    }

}