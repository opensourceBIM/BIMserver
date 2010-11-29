package org.bimserver.templating;

public enum TemplateIdentifier {
	REGISTRATION_EMAIL_BODY("registration_email_body.template"),
	REGISTRATION_EMAIL_SUBJECT("registration_email_subject.template"),
	PASSWORD_RESET_EMAIL_BODY("password_reset_email_body.template"),
	PASSWORD_RESET_EMAIL_SUBJECT("password_reset_email_subject.template");
	
	private final String fileName;

	TemplateIdentifier(String fileName) {
		this.fileName = fileName;
	}
	
	public String getFileName() {
		return fileName;
	}
}