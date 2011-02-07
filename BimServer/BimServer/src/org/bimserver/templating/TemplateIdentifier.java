package org.bimserver.templating;

public enum TemplateIdentifier {
	SELF_REGISTRATION_EMAIL_BODY("self_registration_email_body.template"),
	SELF_REGISTRATION_EMAIL_SUBJECT("self_registration_email_subject.template"),
	ADMIN_REGISTRATION_EMAIL_BODY("admin_registration_email_body.template"),
	ADMIN_REGISTRATION_EMAIL_SUBJECT("admin_registration_email_subject.template"),
	PASSWORD_RESET_EMAIL_BODY("password_reset_email_body.template"),
	PASSWORD_RESET_EMAIL_SUBJECT("password_reset_email_subject.template"),
	CLASH_DETECTION_EMAIL_BODY("clash_detection_email_body.template"),
	CLASH_DETECTION_EMAIL_SUBJECT("clash_detection_email_subject.template");
	
	private final String fileName;

	TemplateIdentifier(String fileName) {
		this.fileName = fileName;
	}
	
	public String getFileName() {
		return fileName;
	}
}