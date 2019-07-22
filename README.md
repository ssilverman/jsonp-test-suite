# JSON-P Test Suite
[![Build Status](https://travis-ci.org/leadpony/jsonp-test-suite.svg?branch=master)](https://travis-ci.org/leadpony/jsonp-test-suite)
[![Release](https://jitpack.io/v/org.leadpony/jsonp-test-suite.svg)](https://jitpack.io/#org.leadpony/jsonp-test-suite)

This project provides a set of tests for implementations of [Java API for JSON Processing (JSR 374)].

## JSON-P Test Suite

### Latest Test Results

[JSON-P Test Suite Reports] shows the latest test results of the following JSON-P implementations.
* [Reference Implementation]
* [Apache Johnzon]

### Using as a Test Dependency

The jar-packaged artifact of this test suite is available from [JitPack] repository.

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>org.leadpony</groupId>
        <artifactId>jsonp-test-suite</artifactId>
        <version>0.13.0</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```
The test suite can be run by using Maven Surefire Plugin.

```xml
<plguins>
    <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-surefire-plugin</artifactId>
        <configuration>
            <dependenciesToScan>
                <dependency>org.leadpony:jsonp-test-suite</dependency>
            </dependenciesToScan>
            <excludes>
                <exclude />
            </excludes>
        </configuration>
    </plugin>
</plguins>
```

### How to Build

The following tools are required to build and run the artifacts.
* JDK 9 or higher
* [Apache Maven] 3.6.0 or higher

The commands below build and install the test suite into your local Maven repository.

```bash
mvn clean install
```

When testing with the Reference Implementation:

```bash
mvn test -P test-with-ri
```

When testing with [Apache Johnzon]:

```bash
mvn test -P test-with-johnzon
```

## Copyright Notice
Copyright &copy; 2019 JSON-P Test Suite Authors. This software is licensed under [Apache License, Versions 2.0][Apache 2.0 License].

[Apache 2.0 License]: https://www.apache.org/licenses/LICENSE-2.0
[Java API for JSON Processing (JSR 374)]: https://eclipse-ee4j.github.io/jsonp/
[Reference Implementation]: https://eclipse-ee4j.github.io/jsonp/
[Apache Maven]: https://maven.apache.org/
[Apache Johnzon]: https://johnzon.apache.org/
[JSON-P Test Suite Reports]: https://leadpony.github.io/jsonp-test-suite/project-reports.html
[JitPack]: https://jitpack.io/#org.leadpony/jsonp-test-suite
