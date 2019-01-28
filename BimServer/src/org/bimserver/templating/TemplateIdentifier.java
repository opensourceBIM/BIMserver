package org.bimserver.templating;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

public enum TemplateIdentifier {
	SELF_REGISTRATION_EMAIL_BODY("self_registration_email_body.template"),
	SELF_REGISTRATION_EMAIL_SUBJECT("self_registration_email_subject.template"),
	ADMIN_REGISTRATION_EMAIL_BODY("admin_registration_email_body.template"),
	ADMIN_REGISTRATION_EMAIL_SUBJECT("admin_registration_email_subject.template"),
	PASSWORD_RESET_EMAIL_BODY("password_reset_email_body.template"),
	PASSWORD_RESET_EMAIL_SUBJECT("password_reset_email_subject.template"),
	NEW_REVISION_EMAIL_BODY("new_revision_email_body.template"),
	NEW_REVISION_EMAIL_SUBJECT("new_revision_email_subject.template");
	
	private final String fileName;

	TemplateIdentifier(String fileName) {
		this.fileName = fileName;
	}
	
	public String getFileName() {
		return fileName;
	}
}