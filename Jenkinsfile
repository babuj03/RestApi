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
    
          stage('deploy') {
                steps {
                      sshagent(['tomcat-Auth']) {
                       sh """
                         scp -o StrictHostKeyChecking=no target/PhoneRestApi-0.0.1-SNAPSHOT.jar   ec2-user@13.233.83.113:/opt/tomcat8/webapps/
                         ssh  ec2-user@13.233.83.113 /opt/tomcat8/bin/shutdown.sh
                         ssh  ec2-user@13.233.83.113 /opt/tomcat8/bin/startup.sh
                        """
                     }
                  }
             }
    }
}
