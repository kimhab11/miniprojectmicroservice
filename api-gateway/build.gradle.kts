plugins {
    id("org.springframework.boot")
    kotlin("jvm")
    kotlin("plugin.spring")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.springframework.boot:spring-boot-starter-test")
    implementation("org.springframework.cloud:spring-cloud-starter-sleuth:3.1.4")
    implementation("org.springframework.cloud:spring-cloud-starter-config:3.1.4")
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client:3.1.4")
    implementation ("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.cloud:spring-cloud-starter-gateway:3.1.4")
    implementation("org.springdoc:springdoc-openapi-webflux-core:1.6.11")
    implementation("org.springdoc:springdoc-openapi-webflux-ui:1.6.11")

    implementation("org.springframework.cloud:spring-cloud-sleuth-zipkin:3.1.4")

}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}