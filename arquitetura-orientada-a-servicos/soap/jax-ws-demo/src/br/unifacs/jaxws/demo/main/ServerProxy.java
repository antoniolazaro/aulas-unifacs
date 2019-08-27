package br.unifacs.jaxws.demo.main;

public class ServerProxy implements br.unifacs.jaxws.demo.main.Server {
  private String _endpoint = null;
  private br.unifacs.jaxws.demo.main.Server server = null;
  
  public ServerProxy() {
    _initServerProxy();
  }
  
  public ServerProxy(String endpoint) {
    _endpoint = endpoint;
    _initServerProxy();
  }
  
  private void _initServerProxy() {
    try {
      server = (new br.unifacs.jaxws.demo.main.ServerServiceLocator()).getServerPort();
      if (server != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)server)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)server)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (server != null)
      ((javax.xml.rpc.Stub)server)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public br.unifacs.jaxws.demo.main.Server getServer() {
    if (server == null)
      _initServerProxy();
    return server;
  }
  
  public java.lang.String helloWorldComParametro(java.lang.String nome) throws java.rmi.RemoteException{
    if (server == null)
      _initServerProxy();
    return server.helloWorldComParametro(nome);
  }
  
  public java.lang.String helloWorld() throws java.rmi.RemoteException{
    if (server == null)
      _initServerProxy();
    return server.helloWorld();
  }
  
  public java.lang.String helloWorldComErro(java.lang.String nome) throws java.rmi.RemoteException{
    if (server == null)
      _initServerProxy();
    return server.helloWorldComErro(nome);
  }
  
  
}