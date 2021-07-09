'use strict';

module.exports = {
  up: async (queryInterface, Sequelize) => {
    await queryInterface.bulkInsert(
      'Rel_Tag_Images',
      [
        {
          TagID: 1,
          ImageID: 9,
          createdAt: new Date(),
          updatedAt: new Date()
        },
        {
          TagID: 2,
          ImageID: 10,
          createdAt: new Date(),
          updatedAt: new Date()
        },
        {
          TagID: 3,
          ImageID: 11,
          createdAt: new Date(),
          updatedAt: new Date()
        },
        {
          TagID: 4,
          ImageID: 12,
          createdAt: new Date(),
          updatedAt: new Date()
        }
      ],
      {}
    );
  },

  down: async (queryInterface, Sequelize) => {
    await queryInterface.bulkDelete('Rel_Tag_Images', null, {});
  }
};
