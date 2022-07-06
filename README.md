# Installation guide

- Prerequisites:
  - IDE Backend: Eclipse (with Spring extension) or Spring Tool Suite
  - IDE Frontend: Visual Studio Code
  - Client HTTP: Postman
  - Database: MySQL DB
  - Client database: MySQL Workbench or DBeaver
  
- Code:
  - Backend: https://github.com/NunzioFiore99/PirelliTechChallengeBE.git
  - Frontend: https://github.com/NunzioFiore99/PirelliTechChallengeFE.git

- Guide:
  - Database:
    - Create a server DB connection using a MySQL DB
  - Backend:
    - Open Postman and import a collection of request (Pirelli_Tech_Challenge.postman_collection.json)
    - Open Eclipse (Check if Spring framework is installed) or STS (Spring Tool Suite) and import Maven Project (PirelliTechChallengeBE)
    - Build and launch a Spring Boot Application to start Web Services
    - Use Postman calls to test connection to DB (Important, use "Store measurement data" to simulate entering the measurement data, after check with other calls)
  - Frontend:
    - Open Visual Studio Code and open project folder (PirelliTechChallengeFE)
    - Important: before proceeding, install the NG ZORRO library for graphics (For more information: https://ng.ant.design/docs/getting-started/en)
    - launch "npm install"
    - Enter with terminal into pirelliTechChallengeFE folder and launch "ng serve" to run Angular frontend application
    - Open browser in localhost:4200
