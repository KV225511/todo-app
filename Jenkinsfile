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
                sh 'mvn clean package -Dmaven.compiler.source=17 -Dmaven.compiler.target=17'
            }
        }

        stage('Run Application') {
            steps {
                echo " Running the compiled Java application..."
                sh 'java -jar $JAR_NAME || true'
            }
        }

        stage('Run Tests (JUnit)') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Publish Test Results') {
            steps {
                junit '**/target/surefire-reports/*.xml'
            }
        }
    }

    post {
        success {
            echo " Pipeline completed successfully!"
        }
        failure {
            echo " Something went wrong. Check logs above."
        }
    }
}

