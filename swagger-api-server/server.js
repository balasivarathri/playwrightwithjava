const express = require('express');
const { body, param, validationResult } = require('express-validator');
const swaggerUi = require('swagger-ui-express');
const YAML = require('yamljs');
const jwt = require('jsonwebtoken');

const swaggerDocument = YAML.load('./swagger.yaml');

const app = express();
app.use(express.json());

const ACCESS_SECRET = 'access_secret_key';

const users = new Map(); // id -> user object
let currentId = 1;

// Generate access token
function generateTokens(username) {
  const accessToken = jwt.sign({ username }, ACCESS_SECRET, { expiresIn: '1h' });
  return { accessToken };
}

// Middleware to authenticate access token
function authenticateAccessToken(req, res, next) {
  const authHeader = req.headers['authorization'];
  const token = authHeader?.split(' ')[1];

  if (!token) return res.status(401).json({ error: 'Token missing' });

  jwt.verify(token, ACCESS_SECRET, (err, user) => {
    if (err) return res.status(403).json({ error: 'Invalid or expired token' });
    req.user = user;
    next();
  });
}

// Middleware to handle validation errors
function handleValidationErrors(req, res, next) {
  const errors = validationResult(req);
  if (!errors.isEmpty()) return res.status(400).json({ errors: errors.array() });
  next();
}

// Login route
app.post(
  '/login',
  body('username').isString().notEmpty().withMessage('Username is required'),
  handleValidationErrors,
  (req, res) => {
    const { username } = req.body;
    const tokens = generateTokens(username);
    res.json(tokens);
  }
);

// Create user
app.post(
  '/user',
  authenticateAccessToken,
  [
    body('username')
      .isString().isLength({ min: 3, max: 20 }).withMessage('Username must be between 3 and 20 characters'),
    body('firstName')
      .isString().isLength({ min: 2, max: 30 }).withMessage('First name must be between 2 and 30 characters'),
    body('lastName')
      .isString().isLength({ min: 2, max: 30 }).withMessage('Last name must be between 2 and 30 characters'),
    body('email')
      .isEmail().withMessage('Email must be valid'),
    body('phone')
      .optional()
      .isString().isLength({ max: 15 }).withMessage('Phone number cannot exceed 15 characters'),
  ],
  handleValidationErrors,
  (req, res) => {
    const user = req.body;
    user.id = currentId++;
    users.set(user.id, user);
    res.status(201).json(user);
  }
);

// Get user by ID
app.get(
  '/user/:id',
  authenticateAccessToken,
  param('id').isInt({ min: 1 }).withMessage('ID must be a positive integer'),
  handleValidationErrors,
  (req, res) => {
    const id = parseInt(req.params.id, 10);
    const user = users.get(id);
    if (!user) return res.status(404).json({ error: 'User not found' });
    res.json(user);
  }
);

// Get user by username
app.get(
  '/user/by-username/:username',
  authenticateAccessToken,
  param('username').isString().notEmpty().withMessage('Username is required'),
  handleValidationErrors,
  (req, res) => {
    const username = req.params.username;
    const user = [...users.values()].find(u => u.username === username);
    if (!user) return res.status(404).json({ error: 'User not found' });
    res.json(user);
  }
);

// Update user by ID
app.put(
  '/user/:id',
  authenticateAccessToken,
  [
    param('id').isInt({ min: 1 }).withMessage('ID must be a positive integer'),
    body('username')
      .isString().isLength({ min: 3, max: 20 }).withMessage('Username must be between 3 and 20 characters'),
    body('firstName')
      .isString().isLength({ min: 2, max: 30 }).withMessage('First name must be between 2 and 30 characters'),
    body('lastName')
      .isString().isLength({ min: 2, max: 30 }).withMessage('Last name must be between 2 and 30 characters'),
    body('email')
      .isEmail().withMessage('Email must be valid'),
    body('phone')
      .optional()
      .isString().isLength({ max: 15 }).withMessage('Phone number cannot exceed 15 characters'),
  ],
  handleValidationErrors,
  (req, res) => {
    const id = parseInt(req.params.id, 10);
    if (!users.has(id)) return res.status(404).json({ error: 'User not found' });

    const updatedUser = { ...req.body, id };
    users.set(id, updatedUser);
    res.json(updatedUser);
  }
);

// Delete user by ID
app.delete(
  '/user/:id',
  authenticateAccessToken,
  param('id').isInt({ min: 1 }).withMessage('ID must be a positive integer'),
  handleValidationErrors,
  (req, res) => {
    const id = parseInt(req.params.id, 10);
    if (!users.has(id)) return res.status(404).json({ error: 'User not found' });
    users.delete(id);
    res.status(204).send();
  }
);

// Swagger docs
app.use('/api-docs', swaggerUi.serve, swaggerUi.setup(swaggerDocument));

const PORT = process.env.PORT || 3000;
app.listen(PORT, () => console.log(`Server running at http://localhost:${PORT}`));
