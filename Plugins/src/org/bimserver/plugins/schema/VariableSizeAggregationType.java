package org.bimserver.plugins.schema;

public abstract class VariableSizeAggregationType extends AggregationType {

	private Bound lower_bound;
	private Bound upper_bound;
	


	public VariableSizeAggregationType(BaseType element_type) {
		super(element_type);
		// TODO Auto-generated constructor stub
	}

	public Bound getLower_bound() {
		return lower_bound;
	}

	public void setLower_bound(Bound lower_bound) {
		this.lower_bound = lower_bound;
	}

	public Bound getUpper_bound() {
		return upper_bound;
	}

	public void setUpper_bound(Bound upper_bound) {
		this.upper_bound = upper_bound;
	}

}
