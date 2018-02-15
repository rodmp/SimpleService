FROM payara/micro

COPY ./target/SimpleService.war /opt/payara/deployments
