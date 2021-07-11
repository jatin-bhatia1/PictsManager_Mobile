'use strict';
const {
  Model
} = require('sequelize');
module.exports = (sequelize, DataTypes) => {
  class Image extends Model {
    /**
     * Helper method for defining associations.
     * This method is not a part of Sequelize lifecycle.
     * The `models/index` file will call this method automatically.
     */
    static associate(models) {
      // define association here
      Image.belongsTo(models.Album, {
        foreignKey: 'AlbumID',
        as: 'album',
        onDelete: 'CASCADE'
      });
      Image.belongsTo(models.User, {
        foreignKey: 'UserID',
        as: 'user',
        onDelete: 'CASCADE'
      });
      Image.hasMany(models.Rel_Tag_Image, {
        foreignKey: 'ImageID',
        as: 'rel_Tag_Image',
        onDelete: 'CASCADE',
      });
    }
  };
  Image.init({
    Name : DataTypes.STRING,
    Type : DataTypes.STRING,
    Date : DataTypes.DATE,
    ImageString : DataTypes.STRING.BINARY,
    AlbumID: DataTypes.INTEGER,
    UserID: DataTypes.INTEGER

  }, {
    sequelize,
    modelName: 'Image',
  });
  return Image;
};