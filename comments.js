// Create web server
// npm install express
const express = require('express');
const app = express();
const port = 3000;
// npm install cors
const cors = require('cors');
app.use(cors());
// npm install body-parser
const bodyParser = require('body-parser');
app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());

// Create connection
const mysql = require('mysql');
const connection = mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: '123456',
    database: 'comments'
});
connection.connect((err) => {
    if (err) throw err;
    console.log('Connected!');
});

// Get all comments
app.get('/comments', (req, res) => {
    let sql = 'SELECT * FROM comments';
    connection.query(sql, (err, results) => {
        if (err) throw err;
        res.json(results);
    });
});

// Get comment by ID
app.get('/comments/:id', (req, res) => {
    let sql = 'SELECT * FROM comments WHERE id=?';
    connection.query(sql, [req.params.id], (err, results) => {
        if (err) throw err;
        res.json(results[0]);
    });
});

// Add new comment
app.post('/comments', (req, res) => {
    let sql = 'INSERT INTO comments SET ?';
    connection.query(sql, req.body, (err, results) => {
        if (err) throw err;
        res.json(results);
    });
});

// Update comment
app.put('/comments/:id', (req, res) => {
    let sql = 'UPDATE comments SET ? WHERE id=?';
    connection.query(sql, [req.body, req.params.id], (err, results) => {
        if (err) throw err;
        res.json(results);
    });
});

// Delete comment
app.delete('/comments/:id', (req, res) => {
    let sql = 'DELETE FROM comments WHERE id=?';
    connection.query(sql, [req.params.id], (err, results) => {
        if (err) throw err;
        res.json(results);
    });
});

// Start server
app.listen(port, () => console.log(`Server is running on port ${port}`));