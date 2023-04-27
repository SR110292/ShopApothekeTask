# SHOP APOTHEKE API Test Task

REST API automation framework using Cucumber, RestAssured and Maven

## Project Description

This project is to implement a framework for REST API automation tests with Cucumber, RestAssured and Maven. Project was
developed using:

1. Cucumber - 7.11.2 - latest version
2. Rest-Assured - 5.3.0 - latest version
3. Maven-cucumber-reporting - plugin to generate HTML reports after test execution

## Design


### Request and Response:

1. To enable easy test creation and maintenance, the request fields are modeled as String payload
2. The response json is parsed using JsonPath class in the Step Definition file


### Project Structure:

1. Acceptance Tests written as Cucumber feature file can be found at _src/test/java/features/LoginValidation.feature_
2. The relevant step definitions of each step can be found at _src/test/java/stepDefinitions/Steps.java_
3. The base URL can be found in the properties file at _src/test/java/resources/config.properties_
4. All other parameters are defined in enum classes which can be found at _src/test/java/resources/enums_
5. Request payload builder can be found at _src/test/java/resources/PayloadBuilder.java_
6. Utility functions can be found at _src/test/java/resources/Utils.java_

### Assertions:

1. JUnit assertion methods are used to verify response JSON data

### Prerequisites to Run the project

1. Environment Requirements: Maven v4.0.0 or later, Java 1.8 or later, Eclipse or IntelliJ IDE

## Execution Instructions

1. Please clone the project. 
2. Please add the respective user credentials and other input values in the Example Table for each test case 
3. Please compile using the IDE Maven plugin or `mvn clean compile`
4. Please run the command `mvn clean test` to run the scenarios in the Cucumber feature files.

### Run Configuration:

Alternative way to run the project is by use of:
TestRunner at _src/test/java/cucumber/options/TestRunner.java_ or Using IDE Run configuration, for IntelliJ:

1. Right click project and click Run as
2. Select Maven Build
3. Enter goals - clean test
4. Click Run

### Reports and Logs:

1. After execution, HTML report can be found in _output/cucumber-html-reports/overview-features.html_
2. HTTP requests and responses logs can be found in _logs/log.txt_

## Final Note:

1. Instead of Cucumber framework, we can also implement this project in Data Driven - Hybrid TestNg Framework
3. When this project is integrated in a Jenkins pipeline, _cucumber-report.json_ file in _target/jsonReports_ can be
   integrated in the Build using Jenkins Cucumber plugin
