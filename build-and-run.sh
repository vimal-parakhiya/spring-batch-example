#!/bin/bash

#Notes:
#   This script assumes that JDK-8 and mvn are available in PATH
#   This script should be run from the directory where it is located

#Build Spring Batch Example jar
mvn clean install

#Source environment variables.
#Modify properties in config.env
#   to switch from in-memory repository to JDBC repository and
#   to modify DB connection details
source config.env

echo "***********************   Executing Batch Application  **********************************"
java -jar target/spring-batch-example-1.0.0.jar
echo "*********************** Executed Batch Application with exit code: " `echo $?` "*********"