import com.nbteam.hislite.his.api.outpatient.vo.OutpatientPayParamVo;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

/**
 * @ClassName: TestCxf
 * @Description: TODO（一句话）
 * @author chenxin
 * @date 2018-09-22 13:53
 */
public class TestCxf {
    public static void main(String args[]) throws Exception{
        JaxWsDynamicClientFactory dcf =JaxWsDynamicClientFactory.newInstance();
        org.apache.cxf.endpoint.Client client =dcf.createClient("http://localhost:8840/webservice/cxfService/outpatientPay?wsdl");
        //getUser 为接口中定义的方法名称  张三为传递的参数   返回一个Object数组
        OutpatientPayParamVo outpatientPayParamVo = new OutpatientPayParamVo();
        outpatientPayParamVo.setPrescriptionNo("111");
        Object[] objects = client.invoke("outpatientPay",outpatientPayParamVo);
        //输出调用结果
        System.out.println("*****"+objects[0].toString());
    }
}
