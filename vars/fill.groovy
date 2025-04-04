def gitdown(repo)
{
  git "https://github.com/nikky1804/${repo}.git"
}
def contbuilt()
{
  sh 'mvn package'
}
def deploy(jobname,ipaddress,filename)
{
  sh "scp var/lib/jenkins/workspace/${jobname}/webapps/target/webapp.war ubuntu@${ipaddress}:var/lib/tomcat10/webapp/${filename}.war"
}
def test()
{
  sh "java -jar var/lib/tomcat10/webapp/${filename}.jar"
}
