package org.bimserver.shared;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class ResultType {

	private String niceName;
	private String contentType;
	private UseInCheckout useInCheckout;
	private UserType userType;
	private Type multiple;
	private DefaultSelected defaultSelected;
	private String extension;

	@XmlAttribute(name="name")
	private String name;

	private boolean enabled;
	private Class<?> serializerClass;

	public ResultType() {
	}
	
	public static enum UseInCheckout {
		USE_IN_CHECKOUT,
		USE_NOT_IN_CHECKOUT;
	}
	
	public static enum UserType {
		USER_TYPE,
		NO_USER_TYPE;
	}
	
	public static enum Type {
		SINGLE,
		MULTIPLE;
	}
	
	public static enum DefaultSelected {
		TRUE,
		FALSE
	}
	
	public ResultType(String name, String niceName, String defaultExtension, String contentType, UseInCheckout useInCheckout, UserType userType, Type multiple, DefaultSelected defaultSelected, boolean enabled) {
		this.name = name;
		this.niceName = niceName;
		this.extension = defaultExtension;
		this.contentType = contentType;
		this.setUseInCheckout(useInCheckout);
		this.setUserType(userType);
		this.setMultiple(multiple);
		this.setDefaultSelected(defaultSelected);
		this.setEnabled(enabled);
	}

	public int compareTo(ResultType o2) {
		return name.compareTo(o2.getName());
	}

	public String getNiceName() {
		return niceName;
	}

	public Class<?> getSerializerClass() {
		return serializerClass;
	}

	public String getExtension() {
		return extension;
	}

	public String getName() {
		return name;
	}

	public String getContentType() {
		return contentType;
	}

	public DefaultSelected getDefaultSelected() {
		return defaultSelected;
	}

	public UserType getUserType() {
		return userType;
	}

	public UseInCheckout getUseInCheckout() {
		return useInCheckout;
	}

	public boolean isEnabled() {
		return enabled;
	}
	
	public boolean isDefaultSelected() {
		return getDefaultSelected() == DefaultSelected.TRUE;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public void setNiceName(String niceName) {
		this.niceName = niceName;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public void setUseInCheckout(UseInCheckout useInCheckout) {
		this.useInCheckout = useInCheckout;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public void setMultiple(Type multiple) {
		this.multiple = multiple;
	}

	public Type getMultiple() {
		return multiple;
	}

	public void setDefaultSelected(DefaultSelected defaultSelected) {
		this.defaultSelected = defaultSelected;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public void setSerializerClass(Class<?> serializerClass) {
		this.serializerClass = serializerClass;
	}
}