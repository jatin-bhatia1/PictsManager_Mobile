const express = require("express");
const bodyParser = require("body-parser");
const coockieParser = require('cookie-parser');
const listEndpoints = require('express-list-endpoints');
const cors = require("cors");

const usersRoutes = require('./routes/users.js');
const imagesRoutes = require('./routes/images.js');
const albumsRoutes = require('./routes/albums.js');
const tagsRoutes = require('./routes/tags.js');
const globalRoutes = require('./routes/global.js');

const router = express();
const PORT = 4000;

router.use(
  cors({
    origin: true,
    credentials: true,
  })
);
router.use(coockieParser());
router.use(express.json());
router.use(express.urlencoded({ extended: false }));

router.use('/api/users', usersRoutes);
router.use('/api/images', imagesRoutes);
router.use('/api/albums', albumsRoutes);
router.use('/api/tags', tagsRoutes);
router.use('/api/', globalRoutes);

// set port, listen for requests
router.listen(PORT, () => {
    console.log('Server is running on http://localhost:' + PORT);
  });

// simple route
router.get('/', (req, res) => {
    // res.setHeader('Content-Type', 'text/json');
    // home page works?
    // return routes on home
    res.send(listEndpoints(router));
});
  
module.exports = router;
