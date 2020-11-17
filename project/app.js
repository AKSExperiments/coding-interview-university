const express = require('express');
const cookieParser = require('cookie-parser');
const bodyParser = require('body-parser');

const app = express();

app.use(cookieParser);
app.use(bodyParser);

// const routes = app.router();

app.get('/', function(req, res) {
    res.send('hi');
});

app.use(function() {
    res.sendStatus(404);
});

app.listen(3000, () => {
    console.log('Started');
})

var middleware = function(req, res, next) {
    next(middleware);
}
middleware2 = function(req, res, next, err) {
    err();
}

