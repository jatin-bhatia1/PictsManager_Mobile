const express = require('express');
const router = express();
const album = require('../controllers/albumController');

/**
 * Prefix des url : 
 * 
 * http://localhost:4000/api/albums
*/
router.post('/', album.create);
router.get('/:user_id', album.getByUser);
router.delete('/:album_id', album.delete);


module.exports = router;