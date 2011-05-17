package org.bimserver.plugins.schema;

public class ArrayType extends AggregationType {
	private Bound lower_index;
	private Bound upper_index;
	private boolean unique_flag;
	private boolean optional_flag;
	
	public ArrayType(BaseType element_type) {
		super(element_type);
		// TODO Auto-generated constructor stub
	}



	public Bound getLower_index() {
		return lower_index;
	}

	public void setLower_index(Bound lower_index) {
		this.lower_index = lower_index;
	}

	public boolean isOptional_flag() {
		return optional_flag;
	}

	public void setOptional_flag(boolean optional_flag) {
		this.optional_flag = optional_flag;
	}

	public boolean isUnique_flag() {
		return unique_flag;
	}

	public void setUnique_flag(boolean unique_flag) {
		this.unique_flag = unique_flag;
	}

	public Bound getUpper_index() {
		return upper_index;
	}

	public void setUpper_index(Bound upper_index) {
		this.upper_index = upper_index;
	}

}
