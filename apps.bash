#!/bin/bash

open_frontend(){
    cd "frontend\notes-app-frontend"
    npm start
}

open_backend(){
    cd "backend\notes-app"
    ./mvnw quarkus:dev
}

open_frontend &
open_backend &