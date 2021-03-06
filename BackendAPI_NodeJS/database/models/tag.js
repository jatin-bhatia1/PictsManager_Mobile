'use strict';
const {
  Model
} = require('sequelize');
module.exports = (sequelize, DataTypes) => {
  class Tag extends Model {
    /**
     * Helper method for defining associations.
     * This method is not a part of Sequelize lifecycle.
     * The `models/index` file will call this method automatically.
     */
    static associate(models) {
      // define association here
      Tag.hasMany(models.Rel_Tag_Image, {
        foreignKey: 'TagID',
        as: 'tag',
        onDelete: 'CASCADE'
      });
      Tag.belongsTo(models.User, {
        foreignKey: 'UserID',
        as: 'user',
        onDelete: 'CASCADE'
      });
    }
  };
  Tag.init({
    Name: DataTypes.STRING,
    UserID: DataTypes.INTEGER
  }, {
    sequelize,
    modelName: 'Tag',
  });
  return Tag;
};