'use strict';

module.exports = {
  up: async (queryInterface, Sequelize) => {
    await queryInterface.bulkInsert(
      'Rel_Tag_Images',
      [
        {
          TagID: 1,
          ImageID: 1,
          createdAt: new Date(),
          updatedAt: new Date()
        },
        {
          TagID: 2,
          ImageID: 2,
          createdAt: new Date(),
          updatedAt: new Date()
        },
        {
          TagID: 3,
          ImageID: 3,
          createdAt: new Date(),
          updatedAt: new Date()
        },
        {
          TagID: 4,
          ImageID: 4,
          createdAt: new Date(),
          updatedAt: new Date()
        },
        {
          TagID: 2,
          ImageID: 3,
          createdAt: new Date(),
          updatedAt: new Date()
        },
        {
          TagID: 2,
          ImageID: 4,
          createdAt: new Date(),
          updatedAt: new Date()
        },
      ],
      {}
    );
  },

  down: async (queryInterface, Sequelize) => {
    await queryInterface.bulkDelete('Rel_Tag_Images', null, {});
  }
};
