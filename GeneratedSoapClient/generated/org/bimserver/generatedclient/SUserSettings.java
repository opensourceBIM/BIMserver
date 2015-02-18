
package org.bimserver.generatedclient;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sUserSettings complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sUserSettings">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="defaultModelCompareId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="defaultModelMergerId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="defaultObjectIDMId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="defaultQueryEngineId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="defaultRenderEngineId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="defaultSerializerId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="deserializers" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="modelcompares" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="modelmergers" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="objectIDMs" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="oid" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="queryengines" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="renderEngines" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="rid" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="serializers" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="services" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sUserSettings", propOrder = {
    "defaultModelCompareId",
    "defaultModelMergerId",
    "defaultObjectIDMId",
    "defaultQueryEngineId",
    "defaultRenderEngineId",
    "defaultSerializerId",
    "deserializers",
    "modelcompares",
    "modelmergers",
    "objectIDMs",
    "oid",
    "queryengines",
    "renderEngines",
    "rid",
    "serializers",
    "services"
})
public class SUserSettings {

    protected long defaultModelCompareId;
    protected long defaultModelMergerId;
    protected long defaultObjectIDMId;
    protected long defaultQueryEngineId;
    protected long defaultRenderEngineId;
    protected long defaultSerializerId;
    @XmlElement(nillable = true)
    protected List<Long> deserializers;
    @XmlElement(nillable = true)
    protected List<Long> modelcompares;
    @XmlElement(nillable = true)
    protected List<Long> modelmergers;
    @XmlElement(nillable = true)
    protected List<Long> objectIDMs;
    protected long oid;
    @XmlElement(nillable = true)
    protected List<Long> queryengines;
    @XmlElement(nillable = true)
    protected List<Long> renderEngines;
    protected int rid;
    @XmlElement(nillable = true)
    protected List<Long> serializers;
    @XmlElement(nillable = true)
    protected List<Long> services;

    /**
     * Gets the value of the defaultModelCompareId property.
     * 
     */
    public long getDefaultModelCompareId() {
        return defaultModelCompareId;
    }

    /**
     * Sets the value of the defaultModelCompareId property.
     * 
     */
    public void setDefaultModelCompareId(long value) {
        this.defaultModelCompareId = value;
    }

    /**
     * Gets the value of the defaultModelMergerId property.
     * 
     */
    public long getDefaultModelMergerId() {
        return defaultModelMergerId;
    }

    /**
     * Sets the value of the defaultModelMergerId property.
     * 
     */
    public void setDefaultModelMergerId(long value) {
        this.defaultModelMergerId = value;
    }

    /**
     * Gets the value of the defaultObjectIDMId property.
     * 
     */
    public long getDefaultObjectIDMId() {
        return defaultObjectIDMId;
    }

    /**
     * Sets the value of the defaultObjectIDMId property.
     * 
     */
    public void setDefaultObjectIDMId(long value) {
        this.defaultObjectIDMId = value;
    }

    /**
     * Gets the value of the defaultQueryEngineId property.
     * 
     */
    public long getDefaultQueryEngineId() {
        return defaultQueryEngineId;
    }

    /**
     * Sets the value of the defaultQueryEngineId property.
     * 
     */
    public void setDefaultQueryEngineId(long value) {
        this.defaultQueryEngineId = value;
    }

    /**
     * Gets the value of the defaultRenderEngineId property.
     * 
     */
    public long getDefaultRenderEngineId() {
        return defaultRenderEngineId;
    }

    /**
     * Sets the value of the defaultRenderEngineId property.
     * 
     */
    public void setDefaultRenderEngineId(long value) {
        this.defaultRenderEngineId = value;
    }

    /**
     * Gets the value of the defaultSerializerId property.
     * 
     */
    public long getDefaultSerializerId() {
        return defaultSerializerId;
    }

    /**
     * Sets the value of the defaultSerializerId property.
     * 
     */
    public void setDefaultSerializerId(long value) {
        this.defaultSerializerId = value;
    }

    /**
     * Gets the value of the deserializers property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the deserializers property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDeserializers().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getDeserializers() {
        if (deserializers == null) {
            deserializers = new ArrayList<Long>();
        }
        return this.deserializers;
    }

    /**
     * Gets the value of the modelcompares property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the modelcompares property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getModelcompares().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getModelcompares() {
        if (modelcompares == null) {
            modelcompares = new ArrayList<Long>();
        }
        return this.modelcompares;
    }

    /**
     * Gets the value of the modelmergers property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the modelmergers property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getModelmergers().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getModelmergers() {
        if (modelmergers == null) {
            modelmergers = new ArrayList<Long>();
        }
        return this.modelmergers;
    }

    /**
     * Gets the value of the objectIDMs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the objectIDMs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getObjectIDMs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getObjectIDMs() {
        if (objectIDMs == null) {
            objectIDMs = new ArrayList<Long>();
        }
        return this.objectIDMs;
    }

    /**
     * Gets the value of the oid property.
     * 
     */
    public long getOid() {
        return oid;
    }

    /**
     * Sets the value of the oid property.
     * 
     */
    public void setOid(long value) {
        this.oid = value;
    }

    /**
     * Gets the value of the queryengines property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the queryengines property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getQueryengines().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getQueryengines() {
        if (queryengines == null) {
            queryengines = new ArrayList<Long>();
        }
        return this.queryengines;
    }

    /**
     * Gets the value of the renderEngines property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the renderEngines property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRenderEngines().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getRenderEngines() {
        if (renderEngines == null) {
            renderEngines = new ArrayList<Long>();
        }
        return this.renderEngines;
    }

    /**
     * Gets the value of the rid property.
     * 
     */
    public int getRid() {
        return rid;
    }

    /**
     * Sets the value of the rid property.
     * 
     */
    public void setRid(int value) {
        this.rid = value;
    }

    /**
     * Gets the value of the serializers property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the serializers property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSerializers().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getSerializers() {
        if (serializers == null) {
            serializers = new ArrayList<Long>();
        }
        return this.serializers;
    }

    /**
     * Gets the value of the services property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the services property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServices().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getServices() {
        if (services == null) {
            services = new ArrayList<Long>();
        }
        return this.services;
    }

}
