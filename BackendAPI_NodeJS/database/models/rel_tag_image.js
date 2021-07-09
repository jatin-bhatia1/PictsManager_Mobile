'use strict';
const {
  Model
} = require('sequelize');
module.exports = (sequelize, DataTypes) => {
  class Rel_Tag_Image extends Model {
    /**
     * Helper method for defining associations.
     * This method is not a part of Sequelize lifecycle.
     * The `models/index` file will call this method automatically.
     */
    static associate(models) {
      // define association here
      Rel_Tag_Image.belongsTo(models.Tag, {
        foreignKey: 'TagID',
        as: 'tag',
        onDelete: 'CASCADE'
      });
      Rel_Tag_Image.belongsTo(models.Image, {
        foreignKey: 'ImageID',
        as: 'image',
        onDelete: 'CASCADE'
      });
    }
  };
  Rel_Tag_Image.init({
    TagID: DataTypes.INTEGER,
    ImageID: DataTypes.INTEGER
  }, {
    sequelize,
    modelName: 'Rel_Tag_Image',
  });
  return Rel_Tag_Image;
};