const getAllCategories = require('../services/db/categoryPostgres')

const routes = (server) => {
// define qual resposta para chamada do contexto default
  server.get('/', (req, res, next) => {
    res.send('Welcome to the Jungle')
    next()
  })

  server.get('/categorias',(req, res, next) => {
    console.log('vai processar')
    getAllCategories
    .then(categories =>res.send((categories))
    .catch(error => res.send((error))))
    next()

  })

  server.get('/categoria',(req, res, next) => {

    res.send(['1','lalala'])
    next()

  })

  server.post('/categoria',(req, res, next) => {

    const {name} = req.params
    res.send(name)
    next()

  })

//   server.put('/categoria',(req, res, next) => {

//     res.send()
//     next()

//   })

//   server.delete('/categoria',(req, res, next) => {

//     res.send()
//     next()

//   })
}

module.exports = routes
