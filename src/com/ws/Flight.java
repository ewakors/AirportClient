
package com.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for concert complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="concert">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="band" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="day" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hour" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idConcert" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="imageName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="seats" type="{http://jaxb.dev.java.net/array}intArray" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "flight", propOrder = {
    "id",
    "cityFrom",
    "cityTo",
    "day",
    "time"
})
public class Flight {

    protected String cityFrom;
    protected String cityTo;
    protected String day;
    protected int id;
    protected String time;
// @XmlElement(nillable = true)

    

    /**
     * Gets the value of the cityFrom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCityForm() {
        return cityFrom;
    }

    /**
     * Sets the value of the cityFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCityFrom(String value) {
        this.cityFrom = value;
    }

    /**
     * Gets the value of the day property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDay() {
        return day;
    }

    /**
     * Sets the value of the day property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDay(String value) {
        this.day = value;
    }

    /**
     * Gets the value of the cityTo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCityTo() {
        return cityTo;
    }

    /**
     * Sets the value of the cityTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCityTo(String value) {
        this.cityTo = value;
    }



    /**
     * Gets the value of the imageName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTime() {
        return time;
    }

    /**
     * Sets the value of the imageName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTime(String value) {
        this.time = value;
    }
    
            /**
     * Gets the value of the idConcert property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the idConcert property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }
}
