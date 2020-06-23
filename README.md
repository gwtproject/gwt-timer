# GWT Timer

![GWT3/J2CL compatible](https://img.shields.io/badge/GWT3/J2CL-compatible-brightgreen.svg)  [![License](https://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html) [![Chat on Gitter](https://badges.gitter.im/hal/elemento.svg)](https://gitter.im/gwtproject/gwt-modules) ![CI](https://github.com/gwtproject/gwt-timer/workflows/CI/badge.svg)

A future-proof port of the `com.google.gwt.user.client.Timer` GWT module, with no dependency on `gwt-user` (besides the Java Runtime Emulation), to prepare for GWT 3 / J2Cl.

##  Migrating from `com.google.gwt.user.client.Timer`

1. Add the dependency to your build.

   For Maven:

   ```xml
   <dependency>
     <groupId>org.gwtproject.timer</groupId>
     <artifactId>gwt-timer</artifactId>
     <version>HEAD-SNAPSHOT</version>
   </dependency>
   ```

   For Gradle:

   ```gradle
   implementation("org.gwtproject.timer:gwt-timer:HEAD-SNAPSHOT")
   ```

2. Update your GWT module to use

   ```xml
   <inherits name="org.gwtproject.timer.Timer" />
   ```

3. Change the `import`s in your Java source files:

   ```java
   import org.gwtproject.timer.client.Timer;
   ```

## Instructions

To build gwt-timer:

* run `mvn clean verify`

on the parent directory. This will build the artifact and run tests against the JVM, J2CL, and GWT2.

## System Requirements

**GWT Timer requires GWT 2.9.0 or newer!**


## Dependencies

GWT Timer does not depend on any other module.

## Samples
A simplified, browser-safe timer class. This class serves the same purpose as `java.util.Timer` ,  but is simplified because of the single-threaded environment. To schedule a timer, simply create a subclass of it (overriding run) and call schedule or scheduleRepeating.

```java
new Timer() {
    @Override
    public void run() {
        DomGlobal.console.info("this block run only once.");
    }
}.run();


new Timer() {
    @Override
    public void run() {
        DomGlobal.console.info("this block run once after 1 second");
    }
}.schedule(1000);


new Timer() {
    @Override
    public void run() {
        DomGlobal.console.info("this block runs every 1 second");
    }
}.scheduleRepeating(1000);

```

