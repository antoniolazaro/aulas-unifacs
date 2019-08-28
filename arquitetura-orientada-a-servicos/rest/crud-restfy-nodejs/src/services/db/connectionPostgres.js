const {Client,Pool} = require('pg')

const client = new Client({
  user: 'consilium_pcp',
  host: 'localhost',
  database: 'consilium',
  password: 'consilium_pcp',
  port: 5432
})
client.connect()


module.exports = client