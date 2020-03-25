pipeline {

  agent any
  
  stages{
              stage('SCM Checkout'){
                  steps {
                       git 'https://github.com/babuj03/RestApi'
                   }
              }
           stage('Compile-Package') {
                 steps {
                    bat 'mvn clean install'
                 }
           }
    
          stage('Deploy to Tomcat') {
                steps {
                  
                  
                     sshagent(['EC2-SSH']) {
                          sh 'C:\Users\ukx4661\AppData\Local\Programs\Git\usr\bin\ssh-agent.exe'
                         
                       
                     }
                  }
             }
    }
}
