const express = require('express');
const router = express();
const image = require('../controllers/imageController');

/**
 * Prefix des url : 
 * 
 * http://localhost:4000/api/images
*/

router.get('/:user_id', image.getByUser);
router.get('/album/:album_id', image.getByAlbum);
router.get('/tag/:tag_id', image.getAllByTag);
router.post('/:user_id', image.create);
router.delete('/:user_id/:image_id', image.delete);


module.exports = router;