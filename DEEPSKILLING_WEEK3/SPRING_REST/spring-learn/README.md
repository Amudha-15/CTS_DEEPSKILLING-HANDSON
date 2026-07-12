# spring-learn

Minimal Spring Boot project created per request.

Build (with proxy flags if needed):

```powershell
mvn clean package -Dhttp.proxyHost=proxy.cognizant.com -Dhttp.proxyPort=6050 -Dhttps.proxyHost=proxy.cognizant.com -Dhttps.proxyPort=6050 -Dhttp.proxyUser=123456
```

Import into Eclipse:

- File > Import > Maven > Existing Maven Projects
- Browse to the extracted `spring-learn` folder and Finish

Run:

- Run `SpringLearnApplication` as Java Application or use `mvn spring-boot:run`

Files of interest:

- [spring-learn/pom.xml](spring-learn/pom.xml)
- [spring-learn/src/main/java/com/cognizant/springlearn/SpringLearnApplication.java](src/main/java/com/cognizant/springlearn/SpringLearnApplication.java)
- [spring-learn/src/main/resources/date-format.xml](src/main/resources/date-format.xml)
