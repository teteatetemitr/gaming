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
                }
            }
            post{
                always{                    
                  junit allowEmptyResults: true, testResults:'/var/jenkins_home/workspace/target/surefire-reports/*.xml'
                }
            }
        }
        stage('analysis'){
            steps{
                withEnv(["PATH+MAVEN=${tool "apache-maven-3.6.0"}/bin"]){
                sh "mvn sonar:sonar -Dsonar.host.url=http://my50335dns.eastus2.cloudapp.azure.com:9000"
                }
            }
        }
        /* 
        stage('deploy'){
            steps{
                sh 'cp /var/jenkins_home/workspace/myGamingApp_dev/target/*.war /usr/local/tomcat/webapps/'
            }
        } */
    }
}