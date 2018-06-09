
package com.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.bagins.ws package. 
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

    private final static QName _GetConcertListResponse_QNAME = new QName("http://ws.com/", "getFlightListResponse");
    private final static QName _DeleteReservationResponse_QNAME = new QName("http://ws.com/", "deleteReservationResponse");
    private final static QName _GetHelloWorldAsString_QNAME = new QName("http://ws.com/", "getHelloWorldAsString");
    private final static QName _DeleteReservation_QNAME = new QName("http://ws.com/", "deleteReservation");
    private final static QName _GetHelloWorldAsStringResponse_QNAME = new QName("http://ws.com/", "getHelloWorldAsStringResponse");
    private final static QName _GetReservationList2_QNAME = new QName("http://ws.com/", "getReservationList2");
    private final static QName _GetConcertList_QNAME = new QName("http://ws.com/", "getFlightList");
    private final static QName _GetReservationList_QNAME = new QName("http://ws.com/", "getReservationList");
    private final static QName _GetReservationList2Response_QNAME = new QName("http://ws.com/", "getReservationList2Response");
    private final static QName _GetReservationListResponse_QNAME = new QName("http://ws.com/", "getReservationListResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.bagins.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetHelloWorldAsString }
     * 
     */
    public GetHelloWorldAsString createGetHelloWorldAsString() {
        return new GetHelloWorldAsString();
    }

    /**
     * Create an instance of {@link GetFlightListResponse }
     * 
     */
    public GetFlightListResponse createGetFlightListResponse() {
        return new GetFlightListResponse();
    }

    /**
     * Create an instance of {@link GetReservationList }
     * 
     */
    public GetReservationList createGetReservationList() {
        return new GetReservationList();
    }

    /**
     * Create an instance of {@link GetReservationList2 }
     * 
     */
    public GetReservationList2 createGetReservationList2() {
        return new GetReservationList2();
    }

    /**
     * Create an instance of {@link GetHelloWorldAsStringResponse }
     * 
     */
    public GetHelloWorldAsStringResponse createGetHelloWorldAsStringResponse() {
        return new GetHelloWorldAsStringResponse();
    }

    /**
     * Create an instance of {@link GetFlightList }
     * 
     */
    public GetFlightList createGetFlightList() {
        return new GetFlightList();
    }

    /**
     * Create an instance of {@link GetReservationList2Response }
     * 
     */
    public GetReservationList2Response createGetReservationList2Response() {
        return new GetReservationList2Response();
    }

    /**
     * Create an instance of {@link GetReservationListResponse }
     * 
     */
    public GetReservationListResponse createGetReservationListResponse() {
        return new GetReservationListResponse();
    }

    /**
     * Create an instance of {@link Flight }
     * 
     */
    public Flight createFlight() {
        return new Flight();
    }

    /**
     * Create an instance of {@link Reservation }
     * 
     */
    public Reservation createReservation() {
        return new Reservation();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFlightListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.com/", name = "getFlightListResponse")
    public JAXBElement<GetFlightListResponse> createGetFlightListResponse(GetFlightListResponse value) {
        return new JAXBElement<GetFlightListResponse>(_GetConcertListResponse_QNAME, GetFlightListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHelloWorldAsString }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.com/", name = "getHelloWorldAsString")
    public JAXBElement<GetHelloWorldAsString> createGetHelloWorldAsString(GetHelloWorldAsString value) {
        return new JAXBElement<GetHelloWorldAsString>(_GetHelloWorldAsString_QNAME, GetHelloWorldAsString.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHelloWorldAsStringResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.com/", name = "getHelloWorldAsStringResponse")
    public JAXBElement<GetHelloWorldAsStringResponse> createGetHelloWorldAsStringResponse(GetHelloWorldAsStringResponse value) {
        return new JAXBElement<GetHelloWorldAsStringResponse>(_GetHelloWorldAsStringResponse_QNAME, GetHelloWorldAsStringResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetReservationList2 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.com/", name = "getReservationList2")
    public JAXBElement<GetReservationList2> createGetReservationList2(GetReservationList2 value) {
        return new JAXBElement<GetReservationList2>(_GetReservationList2_QNAME, GetReservationList2 .class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFlightList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.com/", name = "getFlightList")
    public JAXBElement<GetFlightList> createGetFlightList(GetFlightList value) {
        return new JAXBElement<GetFlightList>(_GetConcertList_QNAME, GetFlightList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetReservationList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.com/", name = "getReservationList")
    public JAXBElement<GetReservationList> createGetReservationList(GetReservationList value) {
        return new JAXBElement<GetReservationList>(_GetReservationList_QNAME, GetReservationList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetReservationList2Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.com/", name = "getReservationList2Response")
    public JAXBElement<GetReservationList2Response> createGetReservationList2Response(GetReservationList2Response value) {
        return new JAXBElement<GetReservationList2Response>(_GetReservationList2Response_QNAME, GetReservationList2Response.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetReservationListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.com/", name = "getReservationListResponse")
    public JAXBElement<GetReservationListResponse> createGetReservationListResponse(GetReservationListResponse value) {
        return new JAXBElement<GetReservationListResponse>(_GetReservationListResponse_QNAME, GetReservationListResponse.class, null, value);
    }

}
