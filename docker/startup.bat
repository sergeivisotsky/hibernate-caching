@echo off

if "%1" == "all" (
    call docker stop postgres-tmp hibernate-caching-app
    call docker rm -f postgres-tmp hibernate-caching-app

    pushd ..\
        call mvn clean install -DskipTests -T1C
    popd

    call docker-compose -p hibernate-caching up -d --build
)

