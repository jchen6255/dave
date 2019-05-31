pipeline {

	agent any
	stages {
	
		stage('Checkout') {
			steps {
				git 'ssh git@github.com:jchen6255/dave.git'
			}
		}
	
		stage('First') {
		
			steps {
				sh 'mvn clean compile'
			}
		}
		
		stage('Test') {
			steps {
				sh 'mvn test'
			}
		}
		
		stage('Package'){
			steps {
				sh 'mvn package'
			}
		}
		
		stage('Docker') {
			steps {
				sh 'sudo docker build -t dave .'
				sh 'sudo docker tag dave:latest 740287161772.dkr.ecr.us-east-2.amazonaws.com/dave:latest'
				sh 'sudo docker push 740287161772.dkr.ecr.us-east-2.amazonaws.com/dave:latest'
			}
		}
	
	}
	

}