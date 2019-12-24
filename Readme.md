# Test automation framework using Selenium with Java, TestNG, Maven
This is a sample test automation project to automate web application using Selenium with Java. TestNg is the test framework and Maven is the build automation tool used in this project. Page design patern or Page object model is used to store object repositories and its actions. Few of the Mercury demo web site functionalities are automated.

### Dependencies
* Selenium-Java
* TestNg
* Apache POI

### Steps to clone & execute the tests
```
> git clone https://github.com/babuthangam/MercuryMavenProject
> cd MercurySeleniumTestngMavenProject
> mvn clean test
```

### Things to do:
* Ensure that the browser driver executables are present as per location mentioned in config.properties
* If the adminlogin username password does not works, create another credentials using registration feature in demo * mercury tours website

### Troubleshooting Tips:
** If executing using maven if it returns below error;**
* No compiler is provided in this environment. Perhaps you are running on a JRE rather than a JDK?
* Fix Installed JREs section (Eclipse > Window > Preferences > Java > Installed JREs & Java build path - Installed JRE)
* Ensure that it points to jre folder of jdk example - C:\Program Files\Java\jdk1.8.0_231\jre
