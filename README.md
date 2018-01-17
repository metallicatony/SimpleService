# SimpleService
SimpleService is a spring boot application using which the following objectives are accomplished
1) How to build and deploy a cloud-native app in Pivotal Cloud Foundry (PaaS)
2) How to host a custom service (oracle) in Amazon AWS Cloud (IaaS)
3) How to create a CUPS service in PCF and deliver service credentials
4) How to integrate a PCF app with an AWS hosted service

Blog hosted at: http://metallicatony.blogspot.com/2018/01/spring-boot-application-hosted-in.html

### Step 1
Create a AWS free tier account and install a db.t2.micro oracle database standard edition instance that comes as part of free tier. Setup the security group rules in such a way that it allows inbound and outbound connections from outside world.

### Step 2
Create a spring boot application by exposing a bunch of services. Use the db credentials from the previous step. The source code from this repository helps for this step. It demonstrates the use of spring boot, spring data and repository concepts.

### Step 3
* Create a PCF free tier account, org and space in your account
* Download and install cf cli tools in your development environment
* cf login with your credentials
* cf push with a manifest file already provided as part of the source or manually push by using cf push SimpleServiceApp -p target/simpleservice-1.0.0.jar -b https://github.com/cloudfoundry/java-buildpack.git

### Step 4
* Create user provided service instance in pivotal cloud foundry to deliver the uri and service credentials 
cf cups oracle-aws -p '{"uri":"oracle://admin:xxx@myoracleinstance.c9anhdk2mqpc.us-west-1.rds.amazonaws.com:1521/ORCL"}'
* Validate in PCF dashboard

### Step 5
Bind the oracle-aws service with SimpleServiceApp either through manifest file or manually by using cf bind-service SimpleServiceApp oracle-aws. Either restage or push your app again to PCF.

### Step 6
Test the app by using a browser or rest client https://simpleserviceapp.cfapps.io/applications/
