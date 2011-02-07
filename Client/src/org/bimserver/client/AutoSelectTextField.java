package org.bimserver.client;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

class AutoSelectTextField extends JTextField implements FocusListener {

	private static final long serialVersionUID = -2481437824390245192L;

	public AutoSelectTextField(String text) {
		super(text);
		addFocusListener(this);
	}

	public AutoSelectTextField(int i) {
		super(i);
		addFocusListener(this);
	}

	public void focusLost(FocusEvent fe) {
	}

	public void focusGained(FocusEvent fe) {
		setCaretPosition(0);
		if (getText() != null) {
			moveCaretPosition(getText().length());
		}
	}

	public static void main(String[] args) {
		JFrame f = new JFrame();
		Container c = f.getContentPane();
		c.setLayout(new GridLayout(0, 1));
		StringBuffer sb = new StringBuffer();
		for (int ii = 0; ii < 10; ii++) {
			c.add(new AutoSelectTextField(sb.toString()));
			sb.append("Ha ");
		}
		f.pack();
		f.setVisible(true);
	}
}