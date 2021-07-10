'use strict';

module.exports = {
  up: async (queryInterface, Sequelize) => {
   
    await queryInterface.bulkInsert(
      'Images',
      [
        {
          Name: 'Image1',
          Type: 'jpeg',
          Date: new Date(),
          ImageString: '$2a$06$IMYYTt4GQOtcxdJyACik1.qskLjYU0GQRcYpGdYfqxEIDqugb4Nry',          
          AlbumID: 1,
          UserID : 1,
          createdAt: new Date(),
          updatedAt: new Date()
        },
        {
          Name: 'Image2',
          Type: 'png',
          Date: new Date(),
          ImageString: '$2a$06$IMYYTt4GQOtcxdJyACik1.qskLjYU0GQRcYpGdYfqxEIDqugb4Nry',          
          AlbumID: 2,
          UserID : 1,
          createdAt: new Date(),
          updatedAt: new Date()
        },
        {
          Name: 'Image3',
          Type: 'jpeg',
          Date: new Date(),
          ImageString: '$2a$06$IMYYTt4GQOtcxdJyACik1.qskLjYU0GQRcYpGdYfqxEIDqugb4Nry',          
          AlbumID: 3,
          UserID : 2,
          createdAt: new Date(),
          updatedAt: new Date()
        },
        {
          Name: 'Image4',
          Type: 'png',
          Date: new Date(),
          ImageString: '$2a$06$IMYYTt4GQOtcxdJyACik1.qskLjYU0GQRcYpGdYfqxEIDqugb4Nry',          
          AlbumID: 4,
          UserID : 2,
          createdAt: new Date(),
          updatedAt: new Date()
        },
      ],
      {}
    );  
  },

  down: async (queryInterface, Sequelize) => {
    await queryInterface.bulkDelete('Images', null, {});
  }
};
