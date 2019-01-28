package org.bimserver.utils;

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

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class AutoSelectTextField extends JTextField implements FocusListener {

	private static final long serialVersionUID = -2481437824390245192L;

	public AutoSelectTextField(String text) {
		super(text);
		addFocusListener(this);
	}

	public AutoSelectTextField(int i) {
		super(i);
		addFocusListener(this);
	}

	public AutoSelectTextField(String string, int i) {
		super(string, i);
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