const { Tag, Rel_Tag_Image ,User } = require('../database/models');


// Save a tag
exports.create = function (req, res) {
    const name = req.body.tag.name;

    if(name == null){res.status(400).json({ error: 'missing album name' });}
  
    tag.findOne({
        where: {
          Name: name,
        },      
      })
        .then((tagFound) => {
          if (!tagFound) {
            const newTag = Tag.create({
                Name: name
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