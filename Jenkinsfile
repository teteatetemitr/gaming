pipeline{
    agent none
    stages{
        stage('Starting pipeline')
        {
            agent any
            triggers {
                cron('H */4 * * 1-5')
                }
        stage('Checkout'){
            git branch: 'dev', credentialsId: '27f40f03-e6e4-4a02-a2e8-b9bc98819a6b', url: 'https://github.com/teteatetemitr/gaming.git'
        }
        stage('Build'){
            sh 'mvn -B clean verify'
        }
        stage('Test'){
            sh 'make check'
            junit 'reports/**/*.xml'
        }
        stage('analysis'){
            sh "mvn sonar:sonar -Dsonar.host.url=${env.SONARQUBE_HOST}"
        }
        stage('deploy'){
            sh 'make publish'
        }
        }
         }
       }