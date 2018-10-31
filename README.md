## README

The aim of the project is to learn the encryption methodology and best practice.


#### This repository

 * *hashing*: Project name.

* *Version*: 0.0.1-SNAPSHOT


#### Set up

You need to make sure you have the latest jdk install, take a look to the pom.xml file, 
to find out the current jdk in used.<br>
    `<java.version>jdk-11.0.1</java.version>`

I use [toolchains](https://maven.apache.org/guides/mini/guide-using-toolchains.html) so here is my my file under ~/.m2/toolchains.xml

```
<?xml version="1.0" encoding="UTF8"?>

<toolchains>

  <toolchain>
    <type>jdk</type>
    <provides>
      <id>jdk-10.0.2</id>
      <version>jdk-10.0.2</version>
      <vendor>oracle</vendor>
    </provides>
    <configuration>
      <jdkHome>/data/app/programs/java/jdk-10.0.2</jdkHome>
    </configuration>
  </toolchain>

  <toolchain>
    <type>jdk</type>
    <provides>
      <id>jdk-11.0.1</id>
      <version>jdk-11.0.1</version>
      <vendor>oracle</vendor>
    </provides>
    <configuration>
      <jdkHome>/data/links/jdk</jdkHome>
    </configuration>
  </toolchain>

</toolchains>

```

At compilation, you will see those lines:

```
[INFO] --- maven-toolchains-plugin:1.1:toolchain (default) @ hashing ---
[INFO] Required toolchain: jdk [ vendor='oracle' version='jdk-11.0.1' ]
[INFO] Found matching toolchain for type jdk: JDK[/data/links/jdk]

```


**Local configuration**

Make sure that you have the latest jdk install.


```
	open a terminal
	move in your workspace where you want the project
	execute those commands:
	    git clone https://github.com/ghandalf/hashing.git
	    mvn compile
	    mvn eclipse:eclipse | mvn idea:idea // Eclipse or IntelliJ GUI configuration
	    mvn clean install -DskipTests // will deploy each artifacts in your local repository
```

