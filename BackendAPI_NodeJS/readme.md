# PictsManager API

## Requirements

- Nodejs 14.x
- PostgreSQL 8.4

## Installation

- Run `npm install` to download the dependencies
- Run PostgreSql server
- Run `createdb -U postgres PictsManager_dev` to create the database (if this doesn't work, you'll have to create the database yourself, like with pgadmin)
- Before running sequelize, make sure that the logins in file config.js are good
- If the sequelize commands doesn't work you'll have to install sequelize-cli : `npm install sequelize-cli`
- Run `npm start` to start the server and create db associations
- Run `npx sequelize db:seed:all` to import default data in tables

## Informations
- Mobile application logins : 
    - username : 'admin@admin.com
    - password : 'moto1234'
- Postman :
    - To test the api with the routes, you'll have to set variable path as : 'localhost:4000'