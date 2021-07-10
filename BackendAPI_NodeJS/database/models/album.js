'use strict';
const {
  Model
} = require('sequelize');
module.exports = (sequelize, DataTypes) => {
  class Album extends Model {
    /**
     * Helper method for defining associations.
     * This method is not a part of Sequelize lifecycle.
     * The `models/index` file will call this method automatically.
     */
    static associate(models) {
      // define association here
      Album.hasMany(models.Image, {
        foreignKey: 'AlbumID',
        as: 'Image',
        onDelete: 'CASCADE',
      });
      Album.belongsTo(models.User, {
        foreignKey: 'UserID',
        as: 'user',
        onDelete: 'CASCADE'
      });
    }
  };
  Album.init({
    Name: DataTypes.STRING,
    UserID: DataTypes.INTEGER
  }, {
    sequelize,
    modelName: 'Album',
  });
  return Album;
};