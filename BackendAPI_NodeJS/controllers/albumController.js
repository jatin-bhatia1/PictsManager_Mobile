const { Album, User } = require('../database/models');

//Get albums by UserId
exports.getByUser = function (req, res) {
  let user_id = req.params.user_id;

  Album.findAll({
    where: {
      UserID: user_id,
    },
  }).then((albums) => {
    res.json(albums);
  })
  .catch((err) => {
    res.json({ err });
  });
};

// Save an album
exports.create = function (req, res) {
    const name = req.body.album.name;

    if(name == null){res.status(400).json({ error: 'missing album name' });}
  
    Album.findOne({
        where: {
          Name: name,
        },      
      })
        .then((albumFound) => {
          if (!albumFound) {
            const newAlbum = Album.create({
                Name: name
              })
                .then((album) => {
                  res.json({ message: 'new album inserted' });
                })
                .catch((err) => {
                  res.json({ err });
                });            
          } else {
            res.status(500).json({ error: 'Same Name Album aready exists' });
          }
        })
        .catch((err) => {
          res.status(500).json(err);
        });    
};

  // Delete an album
exports.delete = function (req, res) {
    const albumId = req.params.album_id;
  
    // deletes the image with the corresponding id
    const deleteAlbum = Album.destroy({
        where: {
          id: albumId,
        },
      }).then((album) => {
        res.json({ message: 'Chosen Album deleted' });
      })
      .catch((err) => {
        res.status(500).json(err);
      });
  };