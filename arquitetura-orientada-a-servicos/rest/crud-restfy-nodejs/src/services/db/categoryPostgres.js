const client = require('./connectionPostgres')


const getAllCategories = new Promise((resolve,reject)=>{
  client.query('SELECT id,name FROM category ORDER BY name ASC', (error, results) => {
    if (error) {
      reject(error)
    }
    resolve({categories: results.rows})    
  })
})



module.exports = getAllCategories