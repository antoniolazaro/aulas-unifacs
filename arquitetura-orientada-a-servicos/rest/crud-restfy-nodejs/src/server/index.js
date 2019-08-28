/**http://restify.com/ 
 * https://github.com/restify/node-restify
*/
const restify = require('restify')
/**
 * configuracao de seguranca
 * https://medium.com/@alexandremjacques/entendendo-o-cors-parte-8331d0a777e1
https://github.com/Tabcorp/restify-cors-middleware
 * 
 */
const cors = require('./cors')
 //configura rotas que o restify responde
const routes = require('../http/routes')
//cria server
const server = restify.createServer()

//configurar cors
server.pre(cors.preflight)
//configurar cors
server.use(cors.actual)
//define conversor nativo para o response
server.use(restify.plugins.bodyParser())

//configura rotas
routes(server)

module.exports = server
