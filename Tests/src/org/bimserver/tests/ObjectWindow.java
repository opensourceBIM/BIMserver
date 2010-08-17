package org.bimserver.tests;

import javax.swing.JFrame;

import org.eclipse.emf.ecore.EClass;

public class ObjectWindow extends JFrame {

	private static final long serialVersionUID = 352827198086573388L;

	public ObjectWindow(EClass eClass, byte[] value) {
		setTitle(eClass.getName());
		setSize(300, 500);
	}
}
