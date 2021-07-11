 'use strict';

module.exports = {
  up: async (queryInterface, Sequelize) => {    
    await queryInterface.bulkInsert(
      'Users',
      [
        {
          FirstName: 'admin',
          LastName: 'admin',
          Password: '$2a$10$f/klGeXoqAtQ5YNTcXggueqnjrUKwbBO/rrA7wdw.D6S.A89HemDS',          
          Email: 'admin@admin.com',
          createdAt: new Date(),
          updatedAt: new Date()
        },
        {          
          FirstName: 'Romain',
          LastName: 'PIOT',
          Password: '$2a$10$f/klGeXoqAtQ5YNTcXggueqnjrUKwbBO/rrA7wdw.D6S.A89HemDS',
          Email: 'romainpiot.pro@gmail.com',
          createdAt: new Date(),
          updatedAt: new Date()
        },
        {
          FirstName: 'Jatin',
          LastName: 'BBB',
          Password: '$2a$10$f/klGeXoqAtQ5YNTcXggueqnjrUKwbBO/rrA7wdw.D6S.A89HemDS',          
          Email: 'jatinb@gmail.com',
          createdAt: new Date(),
          updatedAt: new Date()
        },
        {
          FirstName: 'Paul',
          LastName: 'Polochon',
          Password: '$2a$10$f/klGeXoqAtQ5YNTcXggueqnjrUKwbBO/rrA7wdw.D6S.A89HemDS',          
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
