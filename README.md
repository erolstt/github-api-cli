This is a commandline application that makes request to github api and 
Search Github for repositories that match the given search string.

### Requirements to run this application
* Java version 1.8.0_152 or later

### Tech Stack
* Build Tool : Gradle
* [Spring Shell](https://projects.spring.io/spring-shell/)

### How to run the application
Build a jar file by running

`./gradlew clean build -x test`

That command will generate **github-api-cli-0.1.0.jar** under _build/libs/_

Run the jar file

`java -jar github-api-cli-0.1.0.jar`

After you run the jar file, you will the shell

```
github-shell:>
```
 You can search github repositories by typing the **search** command
 
 ```
 github-shell:> search testng 6.1.1
 ```
 
 Above command will return below information
 
 ``
 Name: testng,  Description: TestNG testing framework,  Number of Stars: 1119.  You provided older release tag. Latest release is 6.9.5
 ``
 
 When you are done type exit and hit ENTER
 
```
github-shell:> exit
```

