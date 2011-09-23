package org.bimserver.client;

/******************************************************************************
 * Copyright (C) 2009-2011  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Console extends JPanel implements LogHandler {

	private static final long serialVersionUID = -629614537593184569L;
	private final JTextArea textArea;

	public Console() {
		setLayout(new BorderLayout());
		textArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textArea);
		textArea.setEditable(false);
		textArea.setFont(new Font("MonoSpaced", Font.PLAIN, 11));
		add(scrollPane, BorderLayout.CENTER);
	}

	@Override
	public void log(String line) {
		textArea.append(line + "\n");
		textArea.setCaretPosition(textArea.getDocument().getLength());
	}
}
