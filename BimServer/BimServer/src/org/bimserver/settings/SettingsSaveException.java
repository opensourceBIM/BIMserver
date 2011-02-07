package org.bimserver.settings;

import javax.xml.bind.JAXBException;

public class SettingsSaveException extends Exception {

	private static final long serialVersionUID = 6153193305510621720L;

	public SettingsSaveException(JAXBException e) {
		super(e);
	}
}
