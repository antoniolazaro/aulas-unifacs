API node-js com restify usando nodejs.

* Passo 0: Instalar VsCode
https://code.visualstudio.com/download
* Passo 1: Criar diretório:
* Passo 2: npm init -y (sem y, ele questiona os parâmetros)
* Passo 3: Verificar versão node instalado (npm -v node -v)
* Passo 4: npm i restify eslint --save-dev
eslint = Validador sintatico javascript https://eslint.org/ // https://github.com/eslint/eslint
* Passo 5: ./node_modules/.bin/eslint --init
- **? How would you like to use ESLint?** 
- To check syntax, find problems, and enforce code style
- **? What type of modules does your project use?** 
- CommonJS (require/exports)
- **? Which framework does your project use?** 
- None of these
- **? Where does your code run? (Press <space> to select, <a> to toggle all, <i> to invert** selection)- Node
- **? How would you like to define a style for your project?** 
- Use a popular style guide
**? Which style guide do you want to follow?** 
- Standard (https://github.com/standard/standard)
- ** ? What format do you want your config file to be in?**
- JSON
* Passo 6: Criar o server
* Passo 7: package json em scripts configurar: "dev": "node src/index.js"
* Passo 8: npm run dev
* Passo 9: Configurar rota restify
* Passo 10: Configurar nodemon (npm i -g nodemon) //-g serve para dizer que é instalado localmente apenas
* Passo 11: Separar arquivos de rotas e server do index.js
* Passo 12: Instalar npm i --save-dev restify-cors-middleware
https://medium.com/@alexandremjacques/entendendo-o-cors-parte-8331d0a777e1
https://github.com/Tabcorp/restify-cors-middleware
* Passo 13: Configurar rotas categorias
* Passo 14: Configurar banco de dados.
https://github.com/mysqljs/mysql npm install mysql --save-dev
https://node-postgres.com/ npm install pg --save-dev
* Passo 15: npm i -g n 
https://github.com/tj/n