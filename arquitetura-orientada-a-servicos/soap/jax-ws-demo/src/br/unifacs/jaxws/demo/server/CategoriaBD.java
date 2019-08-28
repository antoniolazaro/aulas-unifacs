package br.unifacs.jaxws.demo.server;
import java.util.HashMap;
import java.util.Map;

public final class CategoriaBD {
	
	public static final Map<Long,Categoria> bd = new HashMap<>();
	
	static {
	    bd.put(1L,new Categoria(1L, "Category A"));
	    bd.put(2L,new Categoria(2L, "Category B"));
	}

}
