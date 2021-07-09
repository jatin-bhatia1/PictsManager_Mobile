'use strict';

module.exports = {
  up: async (queryInterface, Sequelize) => {
    await queryInterface.bulkInsert(
      'Tags',
      [
        {
          Name: 'friends',
          createdAt: new Date(),
          updatedAt: new Date()
        },
        {          
          Name: 'family',
          createdAt: new Date(),
          updatedAt: new Date()
        },
        {
          Name: 'trip',
          createdAt: new Date(),
          updatedAt: new Date()
        },
        {
          Name: 'instagram',
          createdAt: new Date(),
          updatedAt: new Date()
        },
      ],
      {}
    );
  },

  down: async (queryInterface, Sequelize) => {
    await queryInterface.bulkDelete('Tags', null, {});
  }
};
