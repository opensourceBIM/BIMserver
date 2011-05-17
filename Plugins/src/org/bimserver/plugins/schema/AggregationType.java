package org.bimserver.plugins.schema;
/**
 * Abstract class for aggregations such as EXPRESS <code>LIST, BAG, SET</code>
 * 
 * 
 * @author Jakob Beetz
 * @version %I% %G%
 */
public abstract class AggregationType  implements BaseType, UnderlyingType{
	/**
	 * the base type this aggregation collects
	 */
	private BaseType element_type;

	
	/** Standard constructor
	 * @param element_type a base element type this aggregation collects
	 */
	public AggregationType( BaseType element_type) {
		
		this.element_type = element_type;
	}

	/**
	 * @return the element type this type aggregates
	 */
	public BaseType getElement_type() {
		return element_type;
	}

	/**
	 * @param element_type set the base type this type aggregates
	 */
	public void setElement_type(BaseType element_type) {
		this.element_type = element_type;
	}
}
