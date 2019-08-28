package br.unifacs.jaxws.demo.server;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class ServerHelloWorld {

	public String helloWorld() {
		return "Hello";
	}
	
	public String helloWorldComParametro(@WebParam(name="nome") String nome) {
		return "Hello "+nome;
	}
	
	public String helloWorldComErro(@WebParam(name="nome") String nome) {
		throw new RuntimeException("Erro "+nome);
	}
	
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8080/livros", new ServerHelloWorld());
		System.out.println("Serviço inicializado!");
		// http://localhost:8080/livros?wsdl

		// %JAVA_HOME%/bin/wsimport.exe -s generated -keep
		// http://localhost:8080/livros?wsdl
	}
}
