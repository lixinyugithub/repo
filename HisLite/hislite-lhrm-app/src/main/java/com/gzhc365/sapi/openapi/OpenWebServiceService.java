/**
 * OpenWebServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Nov 19, 2006 (02:31:34 GMT+00:00) WSDL2Java emitter.
 */

package com.gzhc365.sapi.openapi;

public interface OpenWebServiceService extends javax.xml.rpc.Service {
    public java.lang.String getwsAddress();

    public com.gzhc365.sapi.openapi.OpenWebService getws() throws javax.xml.rpc.ServiceException;

    public com.gzhc365.sapi.openapi.OpenWebService getws(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
