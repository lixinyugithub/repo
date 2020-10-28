package com.com.gzhc365.sapi.openapi;

import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

/**
 * @ClassName: TestClient
 * @Description: TODO（一句话）
 */
public class TestClient {
    public static void main(String[] args) throws ServiceException, MalformedURLException, RemoteException {
        String endpoint = "http://220.170.195.141:3002/soap/IJhyyCal";
        StringBuilder builder = new StringBuilder();
		builder.append("<request>");
		builder.append("<patientCard>" + 123456 + "</paientCard>");
		builder.append("</request>");
        //创建一个服务（service）调用（call）
        Service service = new Service();
        Call call = (Call) service.createCall();

        //设置service所在的url
        call.setTargetEndpointAddress(new java.net.URL(endpoint));
        call.setOperationName(new QName("namespace","queryPatientInfo"));
        String ret = (String)call.invoke(new Object[]{"请求体"});
        System.out.println(ret);
    }
}
