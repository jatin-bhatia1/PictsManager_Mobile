'use strict';
const {
  Model
} = require('sequelize');
module.exports = (sequelize, DataTypes) => {
  class User extends Model {
    /**
     * Helper method for defining associations.
     * This method is not a part of Sequelize lifecycle.
     * The `models/index` file will call this method automatically.
     */
    static associate(models) {
      // define association here
      User.hasMany(models.Image, {
        foreignKey: 'UserID',
        as: 'Images',
        onDelete: 'CASCADE'
      });
      User.hasMany(models.Album, {
        foreignKey: 'UserID',
        as: 'Albums',
        onDelete: 'CASCADE'
      });
      User.hasMany(models.Album, {
        foreignKey: 'UserID',
        as: 'Album',
        onDelete: 'CASCADE'
      });
      User.hasMany(models.Tag, {
        foreignKey: 'UserID',
        as: 'Tag',
        onDelete: 'CASCADE'
      });
    }
  };
  User.init({
    LastName: DataTypes.STRING,
    FirstName: DataTypes.STRING,
    Email: DataTypes.STRING,
    Password: DataTypes.STRING
  }, {
    sequelize,
    modelName: 'User',
  });
  return User;
};