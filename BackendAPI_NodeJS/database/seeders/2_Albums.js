'use strict';

module.exports = {
  up: async (queryInterface, Sequelize) => {
    await queryInterface.bulkInsert(
      'Albums',
      [
        {
          Name: 'Camera',
          UserID: 1,
          createdAt: new Date(),
          updatedAt: new Date()
        },
        {          
          Name: 'Pictures',
          UserID: 1,
          createdAt: new Date(),
          updatedAt: new Date()
        },
        {
          Name: 'Whatsup Images',
          UserID: 2,
          createdAt: new Date(),
          updatedAt: new Date()
        },
        {
          Name: 'Instagram Images',
          UserID: 2,
          createdAt: new Date(),
          updatedAt: new Date()
        },
      ],
      {}
    );  
  },

  down: async (queryInterface, Sequelize) => {
    await queryInterface.bulkDelete('Albums', null, {});
  }
};
