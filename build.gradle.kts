plugins {
    java
    application
}

group = "nz.ac.aucklanduni.rfen629"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("junit", "junit", "4.12")
}

application {
    mainClass.set("$group.Main")
}

tasks.getByName<JavaExec>("run") {
    standardInput = System.`in`
}