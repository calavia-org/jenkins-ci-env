FROM jenkins/lts-alpine
#USER root
#RUN apt-get update && apt-get install -y apt-transport-https \
       ca-certificates curl gnupg2 \
       software-properties-common
RUN curl -fsSL https://download.docker.com/linux/debian/gpg | apt-key add -
RUN apt-key fingerprint 0EBFCD88
RUN add-apt-repository \
       "deb [arch=amd64] https://download.docker.com/linux/debian \
       $(lsb_release -cs) stable"
RUN apt-get update && apt-get install -y docker-ce-cli

ARG SONAR_SCANNER_VERSION=4.6.0.2311
RUN curl -s -L https://binaries.sonarsource.com/Distribution/sonar-scanner-cli/sonar-scanner-cli-${SONAR_SCANNER_VERSION}.zip -o sonarscanner.zip \
  && unzip -qq sonarscanner.zip -d /opt \
  && rm -rf /opt/sonarscanner.zip \
  && mv /opt/sonar-scanner-${SONAR_SCANNER_VERSION} /opt/sonar-scanner


USER jenkins

# Disable Setup Wizard
ENV JAVA_OPTS="-Djenkins.install.runSetupWizard=false -Dpermissive-script-security.enabled=true"

COPY src/plugins.txt /var/jenkins_home/plugins.txt
RUN jenkins-plugin-cli --plugin-file /var/jenkins_home/plugins.txt --verbose --latest true --latest-specified

