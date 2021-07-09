const express = require('express');
const router = express();
const user = require('../controllers/userController');

/**
 * Prefix des url : 
 * 
 * http://localhost:4000/api
*/

router.post('/login', user.login);
router.post('/logout', user.logout);
router.post('/register', user.create);
router.post('/check-token', user.checkUserData);

module.exports = router;
