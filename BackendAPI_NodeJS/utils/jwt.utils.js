const jwt = require('jsonwebtoken');
const csrf = require('csrf');
const csrfObj = new csrf();
var secret = csrfObj.secretSync();
var csrfToken = csrfObj.create(secret);

const SECRET_SIGN = '34greh61981etgrt13e8g7br9b1vefze3ncv8n';

exports.generateJwtToken = (userData) => {

  return jwt.sign(
    {
      csrfToken: csrfToken,
      userId: userData.id,
    },
    csrfToken,
    {
      expiresIn: '30 days',
    }
  );
};

exports.generateCsrfToken = () => {
  return csrfToken;
};