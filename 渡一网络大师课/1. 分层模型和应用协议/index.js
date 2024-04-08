const express = require('express');
const app = express();
app.get('/a', (req, res) => {
  if (req.query.id) {
    res.send(`给你id为${req.query.id}的新闻`);
  } else {
    res.send(`给你新闻列表`);
  }
});

app.get('/movie', (req, res) => {
  res.send(`一部电影`);
});

const PORT = 9527;

app.listen(PORT, () => {
  console.log(`server start on port ${PORT}`);
});
