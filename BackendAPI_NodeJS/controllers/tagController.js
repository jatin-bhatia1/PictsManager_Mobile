const { Tag, Rel_Tag_Image ,User } = require('../database/models');


// Get all tags by user_id
exports.getByUser = function (req, res) {
  let user_id = req.params.user_id;

  if(user_id == null){res.status(400).json({ error: 'missing user Id' });}

  Tag.findAll({
    where: {
      UserID: user_id,
    },
  }).then((tags) => {
    res.json(tags);
  })
  .catch((err) => {
    res.json({ err });
  });   
};

// Save a tag
exports.create = function (req, res) {
    const name = req.body.tag.name;
    const userId = req.body.tag.userId;

    if(name == null || userId == null){res.status(400).json({ error: 'missing necessary parameteres' });}
  
    Tag.findOne({
        where: {
          Name: name,
        },      
      })
        .then((tagFound) => {
          if (!tagFound) {
            const newTag = Tag.create({
                Name: name,
                UserID : userId
              })
                .then((album) => {
                  res.json({ message: 'new tag inserted' });
                })
                .catch((err) => {
                  res.json({ err });
                });            
          } else {
            res.status(500).json({ error: 'Same Name tag aready exists' });
          }
        })
        .catch((err) => {
          res.status(500).json(err);
        });    
  };

  // Delete a tag
exports.delete = function (req, res) {
    const tagId = req.params.tag_id;
  
    // deletes the image with the corresponding id
    const deleteTag = Tag.destroy({
        where: {
          id: tagId,
        },
      }).then((album) => {
        res.json({ message: 'Chosen Tag deleted' });
      })
      .catch((err) => {
        res.status(500).json(err);
      });
  };