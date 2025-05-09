def gitdown(repo)
{
  git "https://github.com/IntelliqDevops/${repo}"
}
def contbuild()
{
  sh 'mvn package'
}
def deploy(jobname,ipaddress,context)
{
  sh "scp /var/lib/jenkins/workspace/${jobname}/webapp/target/webapp.war ubuntu@${ipaddress}:/var/lib/tomcat10/webapps/${context}.war"
}
def test(jobname)
{
  sh "java -jar /var/lib/jenkins/workspace/${jobname}/testing.jar"
}
