# Conductor Boot Wrapper with OAuth2 + MySQL and / or Optional Embedded MariaDB4j

Before starting, for details on Netflix Conductor, refer to http://netflix.github.io/conductor/


## Note

 • Only MySQL is supported as external Database

   Or

 • Embedded MariaDB4j is supported, which is persistent and data is not lost, thus eliminating the need for external



## Overview

The idea is to build a single Spring Boot Jar with the following 

 • Micro Services Orchestration - by Conductor Server

 • OAuth2 Authentication & Authorization - by Auth & Resource Servers

 • Zuul Gateway - by Netflix Zuul Proxy for acting as proxy to Conductor Server APIs

 • Optional Embedded Persistent MariaDB4j



## Build Status - ![Java CI with Maven](https://github.com/conductor-boot/conductor-boot-wrapper-oauth2-embedded-mariadb4j/workflows/Java%20CI%20with%20Maven/badge.svg)



## Motivation

To avoid the pain points of

 • Hosting OAuth2 Server for securing Conductor Server APIs

 • Housing external database engine for Conductor Server persistence unit


## Tech/framework used

- Docker Image to bundle the entire setup.

- Docker or Kubernetes to run the docker image.

 -Spring Boot Wrapper

     • Spring Cloud OAuth2

     • MariaDB4j

     • Flyway Initialiser

     • Netflix Conductor Server with MySQL as persistence option (with pre-existing flyway migration).

     • Netflix Zuul Proxy Server
