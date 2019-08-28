package br.unifacs.jaxws.demo.server;

import java.util.Collection;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class ServerCategoriaJaxWs {

	public Collection<Categoria> listar() {
		return CategoriaBD.bd.values();
	}
	
	public Categoria listarPorId(@WebParam(name="id") Long id) {
		Categoria categoriaEncontrada = obterPorChave(id);
		if (categoriaEncontrada != null) {
			return categoriaEncontrada;
		} else {
			throw new RuntimeException("Categoria não encontrada");
		}
	}

	private Categoria obterPorChave(Long id) {
		Categoria categoriaEncontrada = CategoriaBD.bd.get(id);
		return categoriaEncontrada;
	}

	public void post(@WebParam(name="categoria") Categoria categoria) {
		CategoriaBD.bd.put(categoria.getId(),categoria);
	}
	
	public void put(@WebParam(name="categoria") Categoria categoria) {
		Categoria categoriaEncontrada = obterPorChave(categoria.getId());
		if (categoriaEncontrada != null) {
			CategoriaBD.bd.put(categoriaEncontrada.getId(),categoria);
		} else {
			throw new RuntimeException("Categoria não encontrada");
		}
	}

	public void delete(@WebParam(name="categoria") Categoria categoria) {
		Categoria categoriaEncontrada = obterPorChave(categoria.getId());
		if (categoriaEncontrada != null) {
			CategoriaBD.bd.remove(categoriaEncontrada.getId());
		} else {
			throw new RuntimeException("Categoria não encontrada");
		}

	}

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8080/categoria", new ServerCategoriaJaxWs());
		System.out.println("Serviço inicializado em http://localhost:8080/categoria?wsdl!");
	}
}
