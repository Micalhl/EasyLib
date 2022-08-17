plugins {
    `java-library`
    `maven-publish`
    id("org.jetbrains.kotlin.jvm") version "1.5.10"
}

val taboolibVersion = "6.0.9-63"
repositories {
    mavenCentral()
    maven("https://repo.tabooproject.org/repository/releases")
}

dependencies {
    compileOnly("ink.ptms:nms-all:1.0.0")
    compileOnly("ink.ptms.core:v11900:11900-minimize:mapped")
    compileOnly("ink.ptms.core:v11900:11900-minimize:universal")
    compileOnly(kotlin("stdlib"))
    compileOnly(fileTree("libs"))

    compileOnly("io.izzel:taboolib:${taboolibVersion}:common")
    compileOnly("io.izzel:taboolib:${taboolibVersion}:platform-bukkit")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs = listOf("-Xjvm-default=all")
    }
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

publishing {
    repositories {
        maven {
            url = uri("https://repo.tabooproject.org/repository/releases")
            credentials {
                username = project.findProperty("taboolibUsername").toString()
                password = project.findProperty("taboolibPassword").toString()
            }
            authentication {
                create<BasicAuthentication>("basic")
            }
        }
    }
    publications {
        create<MavenPublication>("library") {
            from(components["java"])
            groupId = project.group.toString()
        }
    }
}