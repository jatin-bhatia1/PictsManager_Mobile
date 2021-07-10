'use strict';

module.exports = {
  up: async (queryInterface, Sequelize) => {
    await queryInterface.bulkInsert(
      'Tags',
      [
        {
          Name: 'friends',
          UserID: 1,
          createdAt: new Date(),
          updatedAt: new Date()
        },
        {          
          Name: 'family',
          UserID: 1,
          createdAt: new Date(),
          updatedAt: new Date()
        },
        {
          Name: 'trip',
          UserID: 2,
          createdAt: new Date(),
          updatedAt: new Date()
        },
        {
          Name: 'instagram',
          UserID: 2,
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
