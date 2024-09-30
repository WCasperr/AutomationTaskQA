Prerequisites

Java IDE (IntelliJ Idea)

Java 11

Postman (in case of "On Demand" run)

teamcity-server
__________________

docker stop teamcity-server

docker rm teamcity-server

docker run -d -p 8111:8111 --name teamcity-server jetbrains/teamcity-server
____

TeamCity First Start - > proceed
Database connection setup -> internal - > proceed
License Agreement for JetBrains® TeamCity® -> scroll down -> accept -> continue

_____

Create Administrator Account

Can be created manually - http://localhost:8111/setupAdmin.html
credentials admin/password
____

Tests can be run one by one or using suites 
___
allure logs in folder allure-results