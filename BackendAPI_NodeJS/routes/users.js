const express = require('express');
const router = express();
const user = require('../controllers/userController');

/**
 * Prefix des url : 
 * 
 * http://localhost:4000/api/users
*/

router.get('/:user_id', user.getById);
router.delete('/:user_id', user.delete);

module.exports = router;
