const express = require('express');
const router = express();
const tag = require('../controllers/tagController');

/**
 * Prefix des url : 
 * 
 * http://localhost:4000/api/tags
*/

router.post('/', tag.create);
router.delete('/:tag_id', tag.delete);

module.exports = router;