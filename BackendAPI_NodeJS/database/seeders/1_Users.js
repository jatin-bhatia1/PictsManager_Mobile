 'use strict';

module.exports = {
  up: async (queryInterface, Sequelize) => {    
    await queryInterface.bulkInsert(
      'Users',
      [
        {
          FirstName: 'admin',
          LastName: 'admin',
          Password: '$2a$06$IMYYTt4GQOtcxdJyACik1.qskLjYU0GQRcYpGdYfqxEIDqugb4Nry',          
          Email: 'admin@admin.com',
          createdAt: new Date(),
          updatedAt: new Date()
        },
        {          
          FirstName: 'Romain',
          LastName: 'PIOT',
          Password: '$2a$06$IMYYTt4GQOtcxdJyACik1.qskLjYU0GQRcYpGdYfqxEIDqugb4Nry',
          Email: 'romainpiot.pro@gmail.com',
          createdAt: new Date(),
          updatedAt: new Date()
        },
        {
          FirstName: 'Jatin',
          LastName: 'BBB',
          Password: '$2a$06$IMYYTt4GQOtcxdJyACik1.qskLjYU0GQRcYpGdYfqxEIDqugb4Nry',          
          Email: 'jatinb@gmail.com',
          createdAt: new Date(),
          updatedAt: new Date()
        },
        {
          FirstName: 'Paul',
          LastName: 'Polochon',
          Password: '$2a$06$IMYYTt4GQOtcxdJyACik1.qskLjYU0GQRcYpGdYfqxEIDqugb4Nry',          
          Email: 'popol@gmail.com',
          createdAt: new Date(),
          updatedAt: new Date()
        },
      ],
      {}
    );    
  },

  down: async (queryInterface, Sequelize) => {
    
    await queryInterface.bulkDelete('Users', null, {});
  }
};
