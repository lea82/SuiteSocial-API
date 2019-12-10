#!/bin/bash
set -e

case $1 in
    build)
        mvn clean package -DskipTests=true
        java -jar target/SuiteSocial-0.0.1-SNAPSHOT.war
    ;;
        
esac

exec "$@"
