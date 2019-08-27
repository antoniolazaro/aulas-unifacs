/**
 * ServerServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.unifacs.jaxws.demo.main;

public class ServerServiceLocator extends org.apache.axis.client.Service implements br.unifacs.jaxws.demo.main.ServerService {

    public ServerServiceLocator() {
    }


    public ServerServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ServerServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ServerPort
    private java.lang.String ServerPort_address = "http://localhost:8080/livros";

    public java.lang.String getServerPortAddress() {
        return ServerPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ServerPortWSDDServiceName = "ServerPort";

    public java.lang.String getServerPortWSDDServiceName() {
        return ServerPortWSDDServiceName;
    }

    public void setServerPortWSDDServiceName(java.lang.String name) {
        ServerPortWSDDServiceName = name;
    }

    public br.unifacs.jaxws.demo.main.Server getServerPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ServerPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getServerPort(endpoint);
    }

    public br.unifacs.jaxws.demo.main.Server getServerPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            br.unifacs.jaxws.demo.main.ServerPortBindingStub _stub = new br.unifacs.jaxws.demo.main.ServerPortBindingStub(portAddress, this);
            _stub.setPortName(getServerPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setServerPortEndpointAddress(java.lang.String address) {
        ServerPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (br.unifacs.jaxws.demo.main.Server.class.isAssignableFrom(serviceEndpointInterface)) {
                br.unifacs.jaxws.demo.main.ServerPortBindingStub _stub = new br.unifacs.jaxws.demo.main.ServerPortBindingStub(new java.net.URL(ServerPort_address), this);
                _stub.setPortName(getServerPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ServerPort".equals(inputPortName)) {
            return getServerPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://main.demo.jaxws.unifacs.br/", "ServerService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://main.demo.jaxws.unifacs.br/", "ServerPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ServerPort".equals(portName)) {
            setServerPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
