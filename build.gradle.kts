plugins {
    java
    id("application")
}

repositories {
    mavenLocal()
    mavenCentral()
}

val codecVersion : String by project
val junitVersion : String by project

dependencies {
    implementation("commons-codec:commons-codec:${codecVersion}")
    testImplementation(platform("org.junit:junit-bom:${junitVersion}"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

group = "com.example"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.compilerArgs.add("-parameters")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
application {
    mainClass.set("com.example.App")
}