plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    kotlin("jvm")
    kotlin("plugin.spring")
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springdoc:springdoc-openapi-ui:1.6.9")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
//    implementation("org.keycloak:keycloak-spring-boot-starter:19.0.2")
    implementation("org.keycloak:keycloak-admin-client:16.1.1")
    implementation("org.keycloak:keycloak-spring-boot-starter:16.1.1")
//    implementation("org.keycloak:keycloak-admin-client:19.0.2")
    implementation(platform("org.keycloak.bom:keycloak-adapter-bom:16.1.1"))
    implementation("org.springframework.boot:spring-boot-starter-test:2.7.4")
    implementation("org.springframework.cloud:spring-cloud-starter-sleuth:3.1.4")
    implementation("org.springframework.cloud:spring-cloud-starter-config:3.1.4")
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client:3.1.4")
    implementation(platform("org.keycloak.bom:keycloak-adapter-bom:16.1.1"))
// https://mavenlibs.com/maven/dependency/org.keycloak/keycloak-core
    implementation("org.keycloak:keycloak-core:16.1.1")
    implementation("org.springframework.boot:spring-boot-starter-security")
    testImplementation("org.springframework.security:spring-security-test")




}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}