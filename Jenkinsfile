node{

stage('SCM Checkout'){
  git 'https://github.com/babuj03/RestApi'
 }
 stage('Compile-Package') {
 
   bat 'mvn clean install'
 }
}
