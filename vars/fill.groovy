def gitdown(repo)
{
  git "https://github.com/IntelliqDevops/${repo}"
}
def contbuild()
{
  sh 'mvn package'
}
def deploy(jobname,ipaddress,filename)
{
  sh "scp var/lib/jenkins/workspace/${jobname}/webapp/target/webapp.war ubuntu@${ipaddress}:var/lib/tomcat10/webapps/${filename}.war"
}
def test()
{
  sh "java -jar var/lib/tomcat10/webapp/${filename}.jar"
}
