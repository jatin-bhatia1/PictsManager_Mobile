const { Image, User } = require('../database/models');
const userController = require('../controllers/userController');

// Get all images by user_id
exports.getByUser = function (req, res) {
  let user_id = req.params.user_id;

  console.log(user_id);

  Image.findAll({
    where: {
      UserID: user_id,
    },
  }).then((images) => {
    res.json(images);
  })
  .catch((err) => {
    res.json({ err });
  }); 
  
};

// Save an image
exports.create = function (req, res) {

    console.log(req.body);
    const name = req.body.image.name;
    const type = req.body.image.type;
    const imageString = req.body.image.imageString;
    const userId = req.params.user_id;
    const albumId = req.body.image.album_id;

    //Si albumId est null, on prend l'abum camera par défaut
    // if(albumId == null){albumId = 1;}

    // check empty field
    if (
      name == null ||
      type == null ||
      imageString == null ||
      userId == null
    ) {
      res.status(400).json({ error: 'missing fields' });
    }
  
    const newImage = Image.create({
        Name: name,
        Type: type,
        Date: new Date(),
        ImageString: imageString,        
        UserID: userId,
        AlbumID: albumId
      })
        .then((image) => {
          res.json({ message: 'new image inserted' });
        })
        .catch((err) => {
          res.json({ err });
        });    
  };

  // Delete an image
exports.delete = function (req, res) {
    const userId = req.params.user_id;
    const imageId = req.params.image_id;
  
    // deletes the image with the corresponding id
    const deleteImage = Image.destroy({
        where: {          
          id: imageId,
          UserID : userId
        },
      }).then((image) => {
        res.json({ message: 'Chosen Image deleted' });
      });
  };