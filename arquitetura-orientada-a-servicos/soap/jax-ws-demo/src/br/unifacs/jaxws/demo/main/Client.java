package br.unifacs.jaxws.demo.main;

public class Client {

	public static void main(String[] args) throws Exception{
		ServerService service = new ServerServiceLocator();
		Server portBindingStub = service.getServerPort();
		System.out.println(portBindingStub.helloWorld());
		System.out.println(portBindingStub.helloWorldComParametro("teste"));
		System.out.println(portBindingStub.helloWorldComParametro("Jose"));
		System.out.println(portBindingStub.helloWorldComErro("Jose"));
	}
}
