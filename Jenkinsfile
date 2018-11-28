pipeline{
    agent none
    stages{
        stage('Checkout'){
            steps{
                git branch: 'dev', credentialsId: '27f40f03-e6e4-4a02-a2e8-b9bc98819a6b', url: 'https://github.com/teteatetemitr/gaming.git'
            }
        }
        stage('Build'){
            steps{
                sh 'mvn -B clean verify'
            }
        }
        stage('Test'){
            steps{
                sh 'make check'
                junit 'reports/**/*.xml'
            }
        }
        stage('analysis'){
            steps{
                sh "mvn sonar:sonar -Dsonar.host.url=${env.SONARQUBE_HOST}"
            }
        }
        stage('deploy'){
            steps{
                sh 'make publish'
            }
        }
    }
}