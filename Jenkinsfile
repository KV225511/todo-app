pipeline {
    agent any

    tools {
        maven 'Maven 3'
    }

    environment {
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
                echo "🔧 Building the project..."
                sh 'mvn clean package -Dmaven.compiler.source=17 -Dmaven.compiler.target=17'
            }
        }

        stage('Run CLI App with Simulated Input') {
            steps {
                echo "🧪 Running TodoManager with input.txt..."
                sh 'java -jar $JAR_NAME < input.txt || true'
            }
        }

        stage('Run Unit Tests') {
            steps {
                echo "🧪 Running JUnit tests..."
                sh 'mvn test'
            }
        }

        stage('Publish JUnit Test Results') {
            steps {
                junit '**/target/surefire-reports/*.xml'
            }
        }
    }

    post {
        success {
            echo ' Pipeline completed successfully!'
        }
        failure {
            echo ' Pipeline failed. Check the logs above.'
        }
    }
}

