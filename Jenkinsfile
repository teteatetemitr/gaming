pipeline{
    agent any
    stages{
        stage('Checkout'){
            steps{
                git branch: 'dev', credentialsId: '27f40f03-e6e4-4a02-a2e8-b9bc98819a6b', url: 'https://github.com/teteatetemitr/gaming.git'
            }
        }
        stage('Build'){
            steps{
                withEnv(["PATH+MAVEN=${tool "apache-maven-3.6.0"}/bin"]){
                sh 'mvn clean install'
                }
            }
        }
        stage('Test'){
            steps{
                withEnv(["PATH+MAVEN=${tool "apache-maven-3.6.0"}/bin"]){
                sh 'mvn test'
                cd '/var/jenkins_home/reports'
                copy(file:"*.xml", tofile:"$WORKSPACE")
                junit '/var/jenkins_home/reports/*.xml'
                }
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