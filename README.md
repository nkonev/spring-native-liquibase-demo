# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Spring Native Reference Guide](https://docs.spring.io/spring-native/docs/current/reference/htmlsingle/)
* [Issue](https://github.com/spring-projects-experimental/spring-native/issues/620)


## Spring Native

This project has been configured to let you generate either a lightweight container or a native executable.

### Lightweight Container with Cloud Native Buildpacks
If you're already familiar with Spring Boot container images support, this is the easiest way to get started with Spring Native.
Docker should be installed and configured on your machine prior to creating the image, see [the Getting Started section of the reference guide](https://docs.spring.io/spring-native/docs/0.11.0-RC1/reference/htmlsingle/#getting-started-buildpacks).

To create the image, run the following goal:

```
$ ./mvnw spring-boot:build-image
```

Then, you can run the app like any other container:

```
$ docker run --rm spring-native-demo:0.0.1-SNAPSHOT
```

### Executable with Native Build Tools
Use this option if you want to explore more options such as running your tests in a native image.
The GraalVM native-image compiler should be installed and configured on your machine, see [the Getting Started section of the reference guide](https://docs.spring.io/spring-native/docs/0.11.0-RC1/reference/htmlsingle/#getting-started-native-build-tools).

To create the executable, run the following goal:

```
$ ./mvnw package -Pnative
```

Then, you can run the app as follows:
```
$ target/spring-native-demo
```


# My experiments (works liquibase yaml + sql)

```
su -
setenforce 0
```

```
./mvnw clean spring-boot:build-image
```

```
docker run --rm -t -e 'spring.datasource.url=jdbc:postgresql://postgresql:5432/aaa?connectTimeout=10&socketTimeout=40&ApplicationName=aaa-app' --network spring-native-demo_default -p 8080:8080 docker.io/library/spring-native-demo:0.0.1-SNAPSHOT
```

```
curl -i 'http://localhost:8080/user'
```