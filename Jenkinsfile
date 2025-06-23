pipeline {
    agent any

    environment {
        IMAGE_NAME = "todo-app:1.0"
    }

    tools {
        maven 'Maven 3'
    }

    stages {
        stage('Clone Repository') {
            steps {
                git 'https://github.com/KV225511/todo-app.git'
            }
        }

        stage('Build with Maven') {
            steps {
                sh 'mvn clean package -Dmaven.compiler.source=17 -Dmaven.compiler.target=17'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'eval $(minikube docker-env) && docker build -t $IMAGE_NAME .'
            }
        }

        stage('Deploy to Minikube') {
            steps {
                sh 'kubectl apply -f k8s-deployment.yaml'
            }
        }
    }
}
