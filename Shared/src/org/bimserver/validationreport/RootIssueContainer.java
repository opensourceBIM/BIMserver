package org.bimserver.validationreport;

public class RootIssueContainer extends IssueContainer {

	private ValidationMetaData validationMetaData;

	public RootIssueContainer() {
		this.validationMetaData = new ValidationMetaData();
	}
	
	public void setValidationMetaData(ValidationMetaData validationMetaData) {
		this.validationMetaData = validationMetaData;
	}
	
	public ValidationMetaData getValidationMetaData() {
		return validationMetaData;
	}
}
