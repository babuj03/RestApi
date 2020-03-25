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
                          bat 'C:\Users\ukx4661\AppData\Local\Programs\Git\cmd\start-ssh-agent.cmd'
                         
                       
                     }
                  }
             }
    }
}
