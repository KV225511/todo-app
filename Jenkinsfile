pipeline {
    agent any

    tools {
        maven 'Maven 3'
    }

    environment {
        IMAGE_NAME = "todo-app:1.0"
        JAR_NAME = "target/todo-app-1.0-SNAPSHOT.jar"
    }

    stages {
        stage('Checkout Code') {
            steps {
                checkout scm
            }
        }

        stage('Build with Maven') {
            steps {
                sh 'mvn clean package -Dmaven.compiler.source=17 -Dmaven.compiler.target=17'
            }
        }

        stage('Run CLI App (console output)') {
            steps {
                echo "Running your program..."
                sh 'java -jar $JAR_NAME < input.txt || true'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh '''
                    echo "[INFO] Switching Docker to Minikube..."
                    eval $(minikube docker-env) && \
                    docker build -t $IMAGE_NAME .
                '''
            }
        }

        stage('Deploy to Minikube') {
            steps {
                sh 'kubectl apply -f k8s-deployment.yaml'
            }
        }

        stage('Check Deployment') {
            steps {
                sh 'kubectl get pods'
                sh 'kubectl logs deployment/todo-app-deployment || true'
            }
        }
    }

    post {
        success {
            echo " Pipeline completed successfully."
        }
        failure {
            echo " Pipeline failed."
        }
    }
}

