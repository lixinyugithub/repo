
package com.witontek.ehospital;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.witontek.ehospital package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CloseOrder_QNAME = new QName("http://www.witontek.com/ehospital/", "closeOrder");
    private final static QName _CloseOrderResponse_QNAME = new QName("http://www.witontek.com/ehospital/", "closeOrderResponse");
    private final static QName _CreateOrder_QNAME = new QName("http://www.witontek.com/ehospital/", "createOrder");
    private final static QName _CreateOrderResponse_QNAME = new QName("http://www.witontek.com/ehospital/", "createOrderResponse");
    private final static QName _MicroPay_QNAME = new QName("http://www.witontek.com/ehospital/", "microPay");
    private final static QName _MicroPayResponse_QNAME = new QName("http://www.witontek.com/ehospital/", "microPayResponse");
    private final static QName _QrCodeReverse_QNAME = new QName("http://www.witontek.com/ehospital/", "qrCodeReverse");
    private final static QName _QrCodeReverseResponse_QNAME = new QName("http://www.witontek.com/ehospital/", "qrCodeReverseResponse");
    private final static QName _QryOrderStatus_QNAME = new QName("http://www.witontek.com/ehospital/", "qryOrderStatus");
    private final static QName _QryOrderStatusResponse_QNAME = new QName("http://www.witontek.com/ehospital/", "qryOrderStatusResponse");
    private final static QName _QryPayStatus_QNAME = new QName("http://www.witontek.com/ehospital/", "qryPayStatus");
    private final static QName _QryPayStatusResponse_QNAME = new QName("http://www.witontek.com/ehospital/", "qryPayStatusResponse");
    private final static QName _QryRefund_QNAME = new QName("http://www.witontek.com/ehospital/", "qryRefund");
    private final static QName _QryRefundResponse_QNAME = new QName("http://www.witontek.com/ehospital/", "qryRefundResponse");
    private final static QName _QueryRefundStatus_QNAME = new QName("http://www.witontek.com/ehospital/", "queryRefundStatus");
    private final static QName _QueryRefundStatusResponse_QNAME = new QName("http://www.witontek.com/ehospital/", "queryRefundStatusResponse");
    private final static QName _Refund_QNAME = new QName("http://www.witontek.com/ehospital/", "refund");
    private final static QName _RefundResponse_QNAME = new QName("http://www.witontek.com/ehospital/", "refundResponse");
    private final static QName _RefundReverse_QNAME = new QName("http://www.witontek.com/ehospital/", "refundReverse");
    private final static QName _RefundReverseResponse_QNAME = new QName("http://www.witontek.com/ehospital/", "refundReverseResponse");
    private final static QName _ReverseOrder_QNAME = new QName("http://www.witontek.com/ehospital/", "reverseOrder");
    private final static QName _ReverseOrderResponse_QNAME = new QName("http://www.witontek.com/ehospital/", "reverseOrderResponse");
    private final static QName _ScanRefund_QNAME = new QName("http://www.witontek.com/ehospital/", "scanRefund");
    private final static QName _ScanRefundResponse_QNAME = new QName("http://www.witontek.com/ehospital/", "scanRefundResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.witontek.ehospital
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CloseOrder }
     * 
     */
    public CloseOrder createCloseOrder() {
        return new CloseOrder();
    }

    /**
     * Create an instance of {@link CloseOrderResponse }
     * 
     */
    public CloseOrderResponse createCloseOrderResponse() {
        return new CloseOrderResponse();
    }

    /**
     * Create an instance of {@link CreateOrder }
     * 
     */
    public CreateOrder createCreateOrder() {
        return new CreateOrder();
    }

    /**
     * Create an instance of {@link CreateOrderResponse }
     * 
     */
    public CreateOrderResponse createCreateOrderResponse() {
        return new CreateOrderResponse();
    }

    /**
     * Create an instance of {@link MicroPay }
     * 
     */
    public MicroPay createMicroPay() {
        return new MicroPay();
    }

    /**
     * Create an instance of {@link MicroPayResponse }
     * 
     */
    public MicroPayResponse createMicroPayResponse() {
        return new MicroPayResponse();
    }

    /**
     * Create an instance of {@link QrCodeReverse }
     * 
     */
    public QrCodeReverse createQrCodeReverse() {
        return new QrCodeReverse();
    }

    /**
     * Create an instance of {@link QrCodeReverseResponse }
     * 
     */
    public QrCodeReverseResponse createQrCodeReverseResponse() {
        return new QrCodeReverseResponse();
    }

    /**
     * Create an instance of {@link QryOrderStatus }
     * 
     */
    public QryOrderStatus createQryOrderStatus() {
        return new QryOrderStatus();
    }

    /**
     * Create an instance of {@link QryOrderStatusResponse }
     * 
     */
    public QryOrderStatusResponse createQryOrderStatusResponse() {
        return new QryOrderStatusResponse();
    }

    /**
     * Create an instance of {@link QryPayStatus }
     * 
     */
    public QryPayStatus createQryPayStatus() {
        return new QryPayStatus();
    }

    /**
     * Create an instance of {@link QryPayStatusResponse }
     * 
     */
    public QryPayStatusResponse createQryPayStatusResponse() {
        return new QryPayStatusResponse();
    }

    /**
     * Create an instance of {@link QryRefund }
     * 
     */
    public QryRefund createQryRefund() {
        return new QryRefund();
    }

    /**
     * Create an instance of {@link QryRefundResponse }
     * 
     */
    public QryRefundResponse createQryRefundResponse() {
        return new QryRefundResponse();
    }

    /**
     * Create an instance of {@link QueryRefundStatus }
     * 
     */
    public QueryRefundStatus createQueryRefundStatus() {
        return new QueryRefundStatus();
    }

    /**
     * Create an instance of {@link QueryRefundStatusResponse }
     * 
     */
    public QueryRefundStatusResponse createQueryRefundStatusResponse() {
        return new QueryRefundStatusResponse();
    }

    /**
     * Create an instance of {@link Refund }
     * 
     */
    public Refund createRefund() {
        return new Refund();
    }

    /**
     * Create an instance of {@link RefundResponse }
     * 
     */
    public RefundResponse createRefundResponse() {
        return new RefundResponse();
    }

    /**
     * Create an instance of {@link RefundReverse }
     * 
     */
    public RefundReverse createRefundReverse() {
        return new RefundReverse();
    }

    /**
     * Create an instance of {@link RefundReverseResponse }
     * 
     */
    public RefundReverseResponse createRefundReverseResponse() {
        return new RefundReverseResponse();
    }

    /**
     * Create an instance of {@link ReverseOrder }
     * 
     */
    public ReverseOrder createReverseOrder() {
        return new ReverseOrder();
    }

    /**
     * Create an instance of {@link ReverseOrderResponse }
     * 
     */
    public ReverseOrderResponse createReverseOrderResponse() {
        return new ReverseOrderResponse();
    }

    /**
     * Create an instance of {@link ScanRefund }
     * 
     */
    public ScanRefund createScanRefund() {
        return new ScanRefund();
    }

    /**
     * Create an instance of {@link ScanRefundResponse }
     * 
     */
    public ScanRefundResponse createScanRefundResponse() {
        return new ScanRefundResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CloseOrder }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.witontek.com/ehospital/", name = "closeOrder")
    public JAXBElement<CloseOrder> createCloseOrder(CloseOrder value) {
        return new JAXBElement<CloseOrder>(_CloseOrder_QNAME, CloseOrder.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CloseOrderResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.witontek.com/ehospital/", name = "closeOrderResponse")
    public JAXBElement<CloseOrderResponse> createCloseOrderResponse(CloseOrderResponse value) {
        return new JAXBElement<CloseOrderResponse>(_CloseOrderResponse_QNAME, CloseOrderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateOrder }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.witontek.com/ehospital/", name = "createOrder")
    public JAXBElement<CreateOrder> createCreateOrder(CreateOrder value) {
        return new JAXBElement<CreateOrder>(_CreateOrder_QNAME, CreateOrder.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateOrderResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.witontek.com/ehospital/", name = "createOrderResponse")
    public JAXBElement<CreateOrderResponse> createCreateOrderResponse(CreateOrderResponse value) {
        return new JAXBElement<CreateOrderResponse>(_CreateOrderResponse_QNAME, CreateOrderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MicroPay }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.witontek.com/ehospital/", name = "microPay")
    public JAXBElement<MicroPay> createMicroPay(MicroPay value) {
        return new JAXBElement<MicroPay>(_MicroPay_QNAME, MicroPay.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MicroPayResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.witontek.com/ehospital/", name = "microPayResponse")
    public JAXBElement<MicroPayResponse> createMicroPayResponse(MicroPayResponse value) {
        return new JAXBElement<MicroPayResponse>(_MicroPayResponse_QNAME, MicroPayResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QrCodeReverse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.witontek.com/ehospital/", name = "qrCodeReverse")
    public JAXBElement<QrCodeReverse> createQrCodeReverse(QrCodeReverse value) {
        return new JAXBElement<QrCodeReverse>(_QrCodeReverse_QNAME, QrCodeReverse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QrCodeReverseResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.witontek.com/ehospital/", name = "qrCodeReverseResponse")
    public JAXBElement<QrCodeReverseResponse> createQrCodeReverseResponse(QrCodeReverseResponse value) {
        return new JAXBElement<QrCodeReverseResponse>(_QrCodeReverseResponse_QNAME, QrCodeReverseResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QryOrderStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.witontek.com/ehospital/", name = "qryOrderStatus")
    public JAXBElement<QryOrderStatus> createQryOrderStatus(QryOrderStatus value) {
        return new JAXBElement<QryOrderStatus>(_QryOrderStatus_QNAME, QryOrderStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QryOrderStatusResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.witontek.com/ehospital/", name = "qryOrderStatusResponse")
    public JAXBElement<QryOrderStatusResponse> createQryOrderStatusResponse(QryOrderStatusResponse value) {
        return new JAXBElement<QryOrderStatusResponse>(_QryOrderStatusResponse_QNAME, QryOrderStatusResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QryPayStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.witontek.com/ehospital/", name = "qryPayStatus")
    public JAXBElement<QryPayStatus> createQryPayStatus(QryPayStatus value) {
        return new JAXBElement<QryPayStatus>(_QryPayStatus_QNAME, QryPayStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QryPayStatusResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.witontek.com/ehospital/", name = "qryPayStatusResponse")
    public JAXBElement<QryPayStatusResponse> createQryPayStatusResponse(QryPayStatusResponse value) {
        return new JAXBElement<QryPayStatusResponse>(_QryPayStatusResponse_QNAME, QryPayStatusResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QryRefund }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.witontek.com/ehospital/", name = "qryRefund")
    public JAXBElement<QryRefund> createQryRefund(QryRefund value) {
        return new JAXBElement<QryRefund>(_QryRefund_QNAME, QryRefund.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QryRefundResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.witontek.com/ehospital/", name = "qryRefundResponse")
    public JAXBElement<QryRefundResponse> createQryRefundResponse(QryRefundResponse value) {
        return new JAXBElement<QryRefundResponse>(_QryRefundResponse_QNAME, QryRefundResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryRefundStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.witontek.com/ehospital/", name = "queryRefundStatus")
    public JAXBElement<QueryRefundStatus> createQueryRefundStatus(QueryRefundStatus value) {
        return new JAXBElement<QueryRefundStatus>(_QueryRefundStatus_QNAME, QueryRefundStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryRefundStatusResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.witontek.com/ehospital/", name = "queryRefundStatusResponse")
    public JAXBElement<QueryRefundStatusResponse> createQueryRefundStatusResponse(QueryRefundStatusResponse value) {
        return new JAXBElement<QueryRefundStatusResponse>(_QueryRefundStatusResponse_QNAME, QueryRefundStatusResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Refund }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.witontek.com/ehospital/", name = "refund")
    public JAXBElement<Refund> createRefund(Refund value) {
        return new JAXBElement<Refund>(_Refund_QNAME, Refund.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RefundResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.witontek.com/ehospital/", name = "refundResponse")
    public JAXBElement<RefundResponse> createRefundResponse(RefundResponse value) {
        return new JAXBElement<RefundResponse>(_RefundResponse_QNAME, RefundResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RefundReverse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.witontek.com/ehospital/", name = "refundReverse")
    public JAXBElement<RefundReverse> createRefundReverse(RefundReverse value) {
        return new JAXBElement<RefundReverse>(_RefundReverse_QNAME, RefundReverse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RefundReverseResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.witontek.com/ehospital/", name = "refundReverseResponse")
    public JAXBElement<RefundReverseResponse> createRefundReverseResponse(RefundReverseResponse value) {
        return new JAXBElement<RefundReverseResponse>(_RefundReverseResponse_QNAME, RefundReverseResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReverseOrder }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.witontek.com/ehospital/", name = "reverseOrder")
    public JAXBElement<ReverseOrder> createReverseOrder(ReverseOrder value) {
        return new JAXBElement<ReverseOrder>(_ReverseOrder_QNAME, ReverseOrder.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReverseOrderResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.witontek.com/ehospital/", name = "reverseOrderResponse")
    public JAXBElement<ReverseOrderResponse> createReverseOrderResponse(ReverseOrderResponse value) {
        return new JAXBElement<ReverseOrderResponse>(_ReverseOrderResponse_QNAME, ReverseOrderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ScanRefund }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.witontek.com/ehospital/", name = "scanRefund")
    public JAXBElement<ScanRefund> createScanRefund(ScanRefund value) {
        return new JAXBElement<ScanRefund>(_ScanRefund_QNAME, ScanRefund.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ScanRefundResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.witontek.com/ehospital/", name = "scanRefundResponse")
    public JAXBElement<ScanRefundResponse> createScanRefundResponse(ScanRefundResponse value) {
        return new JAXBElement<ScanRefundResponse>(_ScanRefundResponse_QNAME, ScanRefundResponse.class, null, value);
    }

}
