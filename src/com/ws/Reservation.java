
package com.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for reservation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="reservation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idFlight" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idReservation" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="user" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reservation", propOrder = {
    "idFlight",
    "idReservation",
    "user"
})
public class Reservation {

    protected int idFlight;
    protected int idReservation;
    protected int user;

    /**
     * Gets the value of the idFlight property.
     * 
     */
    public int getIdFlight() {
        return idFlight;
    }

    /**
     * Sets the value of the idFlight property.
     * 
     */
    public void setIdFlight(int value) {
        this.idFlight = value;
    }

    /**
     * Gets the value of the idReservation property.
     * 
     */
    public int getIdReservation() {
        return idReservation;
    }

    /**
     * Sets the value of the idReservation property.
     * 
     */
    public void setIdReservation(int value) {
        this.idReservation = value;
    }

    /**
     * Gets the value of the user property.
     * 
     */
    public int getUser() {
        return user;
    }

    /**
     * Sets the value of the user property.
     * 
     */
    public void setUser(int value) {
        this.user = value;
    }

}
