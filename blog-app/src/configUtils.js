// configUtils.js

const fs = require('fs');
const path = require('path');

const configFilePath = path.join(__dirname, 'config.js'); // Adjust the path as needed

function updateArticleList(newArticle) {
  try {
    // Read the config file
    const config = require(configFilePath);

    // Access the articleList array
    const articleList = config.ArticleList;

    // Modify the articleList array
    articleList.push(newArticle);

    // Convert the config object back to a string
    const updatedConfig = `module.exports = ${JSON.stringify(config, null, 2)};\n`;

    // Write the updated config back to the file
    fs.writeFileSync(configFilePath, updatedConfig, 'utf8');

    console.log('Config file has been updated successfully.');

    return true;
  } catch (error) {
    console.error('Error updating the config file:', error);
    return false;
  }
}

module.exports = { updateArticleList };
