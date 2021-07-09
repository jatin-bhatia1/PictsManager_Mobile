'use strict';

module.exports = {
  up: async (queryInterface, Sequelize) => {
    await queryInterface.bulkInsert(
      'Albums',
      [
        {
          Name: 'Camera',
          createdAt: new Date(),
          updatedAt: new Date()
        },
        {          
          Name: 'Pictures',
          createdAt: new Date(),
          updatedAt: new Date()
        },
        {
          Name: 'Whatsup Images',
          createdAt: new Date(),
          updatedAt: new Date()
        },
        {
          Name: 'Instagram Images',
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
