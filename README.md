![GWT3/J2CL compatible](https://img.shields.io/badge/GWT3/J2CL-compatible-brightgreen.svg)

# gwt-timer
A simplified, browser-safe timer class. This class serves the same purpose as java.util.Timer, but is simplified because of the single-threaded
    environment.
    To schedule a timer, simply create a subclass of it (overriding run) and call schedule or scheduleRepeating.

### Dependency

```
<dependency>
    <groupId>org.gwtproject.timer</groupId>
    <artifactId>gwt-timer</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

### Samples

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
