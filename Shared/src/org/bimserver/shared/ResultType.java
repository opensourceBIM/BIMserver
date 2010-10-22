package org.bimserver.shared;

import java.util.HashSet;
import java.util.Set;

public enum ResultType {
	CITYGML("City GML 1.0.0", "gml", "application/gml", UseInCheckout.USE_NOT_IN_CHECKOUT, UserType.USER_TYPE, Type.MULTIPLE, DefaultSelected.FALSE),
	COLLADA("Collada", "dae", "appliction/collada", UseInCheckout.USE_NOT_IN_CHECKOUT, UserType.USER_TYPE, Type.MULTIPLE, DefaultSelected.FALSE),
	IFC("IFC2x3", "ifc", "application/ifc", UseInCheckout.USE_IN_CHECKOUT, UserType.USER_TYPE, Type.MULTIPLE, DefaultSelected.TRUE), 
	IFCXML("IFCXML2x3", "ifcxml", "application/ifcxml", UseInCheckout.USE_IN_CHECKOUT, UserType.USER_TYPE, Type.MULTIPLE, DefaultSelected.FALSE), 
	O3D_JSON("Google O3D", "o3djson", "appliction/json", UseInCheckout.USE_NOT_IN_CHECKOUT, UserType.USER_TYPE, Type.MULTIPLE, DefaultSelected.FALSE),
	O3D_TGZ("Google O3D", "o3dtgz", "appliction/tgz", UseInCheckout.USE_NOT_IN_CHECKOUT, UserType.USER_TYPE, Type.MULTIPLE, DefaultSelected.FALSE),
	OBJECT_INFO("Object Info", "html", "text/html", UseInCheckout.USE_NOT_IN_CHECKOUT, UserType.USER_TYPE, Type.SINGLE, DefaultSelected.FALSE),
	TEXT("Plain text IFC", "txt", "text", UseInCheckout.USE_NOT_IN_CHECKOUT, UserType.USER_TYPE, Type.MULTIPLE, DefaultSelected.FALSE),
	KML("KML", "kml", "application/vnd.google-earth.kml+xml", UseInCheckout.USE_NOT_IN_CHECKOUT, UserType.NO_USER_TYPE, Type.MULTIPLE, DefaultSelected.FALSE),
	KMZ("KMZ", "kmz", "application/vnd.google-earth.kmz", UseInCheckout.USE_NOT_IN_CHECKOUT, UserType.USER_TYPE, Type.MULTIPLE, DefaultSelected.FALSE);

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
	
	private final String defaultExtension;
	private final String contentType;
	private final String niceName;
	private final UseInCheckout useInCheckout;
	private final UserType userType;
	private final Type type;
	private final DefaultSelected defaultSelected;

	ResultType(String niceName, String defaultExtension, String contentType, UseInCheckout useInCheckout, UserType userType, Type type, DefaultSelected defaultSelected) {
		this.niceName = niceName;
		this.defaultExtension = defaultExtension;
		this.contentType = contentType;
		this.useInCheckout = useInCheckout;
		this.userType = userType;
		this.type = type;
		this.defaultSelected = defaultSelected;
	}
	
	public String getDefaultExtension() {
		return defaultExtension;
	}

	public String getContentType() {
		return contentType;
	}
	
	public boolean useInCheckout() {
		return useInCheckout == UseInCheckout.USE_IN_CHECKOUT;
	}

	public boolean isUserType() {
		return userType == UserType.USER_TYPE;
	}
	
	public Type getType() {
		return type;
	}

	public String getNiceName() {
		return niceName;
	}
	
	public static Set<ResultType> getUserTypes() {
		Set<ResultType> types = new HashSet<ResultType>();
		for (ResultType resultType : values()) {
			if (resultType.isUserType()) {
				types.add(resultType);
			}
		}
		return types;
	}

	public boolean isDefaultSelected() {
		return defaultSelected == DefaultSelected.TRUE;
	}
	
	public DefaultSelected getDefaultSelected() {
		return defaultSelected;
	}
}