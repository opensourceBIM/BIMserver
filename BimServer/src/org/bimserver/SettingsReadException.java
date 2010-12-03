package org.bimserver;

import javax.xml.bind.JAXBException;

public class SettingsReadException extends Exception {

	private static final long serialVersionUID = -5894073898351414659L;

	public SettingsReadException(JAXBException e) {
		super(e);
	}
}
