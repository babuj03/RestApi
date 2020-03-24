node{

stage('SCM Checkout'){
  git 'https://github.com/babuj03/RestApi'
 }
 stage('Compile-Package') {
 
   bat 'mvn clean install'
 }
  stage('deploy') {
    sshagent(['tomcat-Auth']) {
     sh """
       scp -o StrictHostKeyChecking=no target/     ec2-user@13.233.83.113:/opt/tomcat8/webapps/
       ssh  ec2-user@13.233.83.113 /opt/tomcat8/bin/shutdown.sh
       ssh  ec2-user@13.233.83.113 /opt/tomcat8/bin/startup.sh
      """
   }
  }
}
