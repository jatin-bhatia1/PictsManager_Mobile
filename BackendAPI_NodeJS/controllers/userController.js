const { User} = require('../database/models');
const bcrypt = require('bcryptjs');
const jsonwebtoken = require('jsonwebtoken');
const userController = require('./userController');
const jwt = require('../utils/jwt.utils');


// Get one user by user_id
exports.getById = function (req, res) {
  const user_id = req.params.user_id;

  // check empty field
  if (user_id == null) {
    res.status(400).json({ error: 'missing User ID' });
  }

  User.findOne({    
    where: {
      id: user_id,
    },
  }).then((user) => {
    res.json(user);
  })
  .catch((err) => {
    res.status(500).json(err);
  });
  
};

// Authenticate user
exports.login = function (req, res) {
    const email = req.body.user.email;
    const password = req.body.user.password;
  
    // check empty field
    if (email == null || password == null) {
      console.log("inside!");
      res.status(400).json({ error: 'missing fields' });
    }
  
    User.findOne({
      where: {
        Email: email,
      },      
    })
      .then((userFound) => {
        if (userFound) {
          bcrypt.compare(password, userFound.Password, (errBcrypt, resBcrypt) => {
            console.log(resBcrypt);
            if (resBcrypt) {
              const jwtToken = jwt.generateJwtToken(userFound);
              const csrfToken = jwt.generateCsrfToken();
  
              // Creates a cookie which expires after 30 day
              const oneMonth = 24 * 60 * 60 * 30;
  
              res
                .cookie('jwt_token', jwtToken, {
                  maxAge: oneMonth,
                  httpOnly: true,
                  secure: process.env.NODE_ENV === 'development' ? true : false,
                })
                .cookie('csrf_token', csrfToken, {
                  maxAge: oneMonth,
                  secure: process.env.NODE_ENV === 'development' ? true : false,
                })
                .json({ user_id: userFound.id });
            } else {
              res.status(500).json({ error: 'Password error' });
            }
          });
        } else {
          res.status(500).json({ error: 'Fail connection' });
        }
      })
      .catch((err) => {
        res.status(500).json(err);
      });
  };

  // Log out user
exports.logout = function (req, res) {
  res.clearCookie('jwt_token');
  res.clearCookie('csrf_token');
  res.json({ message: 'User disconnected' });
};

  // create user
exports.create = function (req, res) {
  const lastname = req.body.user.lastname;
  const firstname = req.body.user.firstname;  
  const email = req.body.user.email;
  const password = req.body.user.password;

  // check empty field
  if (
    email == null ||
    password == null ||
    firstname == null ||
    lastname == null
  ) {
    res.status(400).json({ error: 'missing fields' });
  }

  const { Op } = require('sequelize');

  User.findOne({
    attributes: ['Email'],
    where: {
      [Op.or]: [{ Email: email }],
    },
  }).then((userExist) => {
    if (!userExist) {

      //Hash the password before creating the user
      const hash = bcrypt.hashSync(password, 10);

      const newUser = User.create({
        Lastname: lastname,
        Firstname: firstname,
        Email: email,
        Password: hash,        
      }).then((user) => {
        console.log(User.Email);
        console.log(user.Password);
        console.log(user.Lastname);
        console.log(user.Firstname);
        
        res.status(201).json({ user });
      });
    } else {
      res.status(409).json({ error: 'User already exist in db' });
    }
  })
  .catch(err => {
    res.status(500).send({ message: err.message });
  });
};

// Delete a user
exports.delete = function (req, res) {
  const userId = req.params.user_id;
  
    const deleteUser = User.destroy({
      where: {
        id: userId,
      },
    }).then((user) => {
      res.json({ message: 'user deleted' });
    });
};

exports.getUserConnected = function (req, res) {
  const dataToken = userController.decryptToken(req, res);
  return dataToken;
};

exports.checkUserData = function (req, res) {
  const dataToken = userController.decryptToken(req, res);
  res.json({ userId: dataToken.userId });
}; 