
package com.ws;

import java.awt.*;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "AirportService", targetNamespace = "http://ws.com/")
@XmlSeeAlso({
    com.ws.ObjectFactory.class,
    net.java.dev.jaxb.array.ObjectFactory.class
})
public interface AirportService {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<com.bagins.ws.Reservation>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getReservationList2", targetNamespace = "http://ws.com/", className = "com.ws.GetReservationList2")
    @ResponseWrapper(localName = "getReservationList2Response", targetNamespace = "http://ws.com/", className = "com.ws.GetReservationList2Response")
    @Action(input = "http://ws.com/AirportService/getReservationList2Request", output = "http://ws.com/AirportService/getReservationList2Response")
    public List<Reservation> getReservationList2(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<com.bagins.ws.Reservation>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getReservationList", targetNamespace = "http://ws.com/", className = "com.ws.GetReservationList")
    @ResponseWrapper(localName = "getReservationListResponse", targetNamespace = "http://ws.com/", className = "com.ws.GetReservationListResponse")
    @Action(input = "http://ws.com/AirportService/getReservationListRequest", output = "http://ws.com/AirportService/getReservationListResponse")
    public List<Reservation> getReservationList(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "deleteReservation", targetNamespace = "http://ws.com/", className = "com.ws.DeleteReservation")
    @ResponseWrapper(localName = "deleteReservationResponse", targetNamespace = "http://ws.com/", className = "com.ws.DeleteReservationResponse")
    @Action(input = "http://ws.com/AirportService/deleteReservationRequest", output = "http://ws.com/AirportService/deleteReservationResponse")
    public void deleteReservation(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getHelloWorldAsString", targetNamespace = "http://ws.com/", className = "com.ws.GetHelloWorldAsString")
    @ResponseWrapper(localName = "getHelloWorldAsStringResponse", targetNamespace = "http://ws.com/", className = "com.ws.GetHelloWorldAsStringResponse")
    @Action(input = "http://ws.com/AirportService/getHelloWorldAsStringRequest", output = "http://ws.com/AirportService/getHelloWorldAsStringResponse")
    public String getHelloWorldAsString(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "checkReservation", targetNamespace = "http://ws.com/", className = "com.ws.CheckReservation")
    @ResponseWrapper(localName = "checkReservationResponse", targetNamespace = "http://ws.com/", className = "com.ws.CheckReservationResponse")
    @Action(input = "http://ws.com/AirportService/checkReservationRequest", output = "http://ws.com/AirportService/checkReservationResponse")
    public boolean checkReservation(
        @WebParam(name = "arg0", targetNamespace = "")
        List<Reservation> arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1);


    /**
     * 
     * @return
     *     returns java.util.List<com.bagins.ws.Flight>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getFlightList", targetNamespace = "http://ws.com/", className = "com.ws.GetFlightList")
    @ResponseWrapper(localName = "getFlightListResponse", targetNamespace = "http://ws.com/", className = "com.ws.GetFlightListResponse")
    @Action(input = "http://ws.com/AirportService/getFlightListRequest", output = "http://ws.com/AirportService/getFlightListResponse")
    public List<Flight> getFlightList();

}
