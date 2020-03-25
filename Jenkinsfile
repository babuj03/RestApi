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
                
                          
                          bat 'C:\\Users\\ukx4661\\AppData\\Local\\Programs\\Git\\usr\\bin\\scp -i D:\\Babu\\Aws\\keypair_babu.pem -o StrictHostKeyChecking=no target/PhoneRestApi-0.0.1-SNAPSHOT.jar   ec2-user@13.233.83.113:/opt/tomcat8/webapps/'
                       
                          bat 'C:\\Users\\ukx4661\\AppData\\Local\\Programs\\Git\\usr\\bin\\ssh -i D:\\Babu\\Aws\\keypair_babu.pem -o StrictHostKeyChecking=no ec2-user@13.233.83.113 /opt/tomcat8/bin/shutdown.sh
                    
                          bat 'C:\\Users\\ukx4661\\AppData\\Local\\Programs\\Git\\usr\\bin\\ssh -i D:\\Babu\\Aws\\keypair_babu.pem -o StrictHostKeyChecking=no ec2-user@13.233.83.113 /opt/tomcat8/bin/startup.sh
                  }
             }
    }
}
