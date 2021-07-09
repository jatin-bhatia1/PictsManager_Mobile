'use strict';

module.exports = {
  up: async (queryInterface, Sequelize) => {
    await queryInterface.createTable('Image', {
      Id: {
        allowNull: false,
        autoIncrement: true,
        primaryKey: true,
        type: Sequelize.INTEGER
      },     
      Type: {
        allowNull: false,
        type: Sequelize.STRING
      },
      Date: {
        allowNull: false,
        type: Sequelize.DATE
      },
      ImageString: {
        type: Sequelize.STRING
      },
      AlbumID: {
        allowNull: false,
        type: Sequelize.INTEGER
      },
      UserID: {
        allowNull: false,
        type: Sequelize.INTEGER
      },
      createdAt: {
        allowNull: true,
        type: Sequelize.DATE
      },
      updatedAt: {
        allowNull: true,
        type: Sequelize.DATE
      }
    });
  },

  down: async (queryInterface, Sequelize) => {
    await queryInterface.dropTable('Image');
  }
};
