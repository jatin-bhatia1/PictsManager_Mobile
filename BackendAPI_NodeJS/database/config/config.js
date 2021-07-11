module.exports = {
    development: {
      "username": "postgres@countup.tech",
      "password": "Pass123$",
      "database": "PictsManager_dev",
      "host": "localhost:5051",
      "dialect": "postgres",
    },
    production: {
      "username": "postgres",
      "password": "postgres",
      "database": "PictsManager_prod",
      "host": "localhost",
      "dialect": "postgres",
    },
  };