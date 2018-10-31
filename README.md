## README

The aim of the project is to learn the encryption methodology and best practice.
I found this url where Lokesh Gupta did a very good job to explain different password encryption.
https://howtodoinjava.com/security/how-to-generate-secure-password-hash-md5-sha-pbkdf2-bcrypt-examples/

Next step will be to use Spring Security and have a good understanding of hashing/encryption methodology.

#### This repository

 * *hashing*: Project name.

* *Version*: 0.0.1-SNAPSHOT


#### Set up

You need to make sure you have the jdk install. 
Take a look to the pom.xml file, to find out the current jdk in used.

    ```<java.version>jdk-10.0.2</java.version>```

Unfortunalty, I would like to use jdk-11 but due to M2E. I need maven-compiler-plugin source and target at version 10.<br>

```
		<maven.compiler.source>10</maven.compiler.source>
		<maven.compiler.target>10</maven.compiler.target>
		...
		<plugin>
			<groupId>org.apache.maven.plugins</groupId>
			<artifactId>maven-compiler-plugin</artifactId>
			<version>3.8.0</version>
			<configuration>
				<source>${maven.compiler.source}</source>
				<target>${maven.compiler.target}</target>
			</configuration>
		</plugin>
```

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
[INFO] Required toolchain: jdk [ vendor='oracle' version='jdk-10.0.2' ]
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

### TODO ###
Add and fix current tests