package org.bimserver.tests;

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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class HtmlWriter {
	private PrintWriter out;
	private int rowNr = 1;
	
	public HtmlWriter(File file) {
		try {
			out = new PrintWriter(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void addRow(String... values) {
		out.println("<tr>");
		out.println("<td>" + rowNr + ".</td>");
		for (String value : values) {
			if (value.equals("true") || value.equals("OKE")) {
				out.println("<td style=\"background-color: #00FF00\">" + value + "</td>");
			} else if (value.equals("false") || value.equals("ERROR")) {
				out.println("<td style=\"background-color: red\">" + value + "</td>");
			} else if (value.equals("false") || value.equals("WARN")) {
				out.println("<td style=\"background-color: orange\">" + value + "</td>");
			} else {
				out.println("<td>" + value + "</td>");
			}
		}
		out.println("</tr>");
		out.flush();
		rowNr++;
	}
	
	public void write(String text) {
		out.write(text);
	}

	public void startTable(String... headers) {
		out.println("<table>");
		out.println("<tr>");
		out.println("<th>#</th>");
		for (String header : headers) {
			out.println("<th>" + header + "</td>");
		}
		out.println("</tr>");
	}
	
	public void endTable() {
		out.println("</table>");
	}

	public void close() {
		out.close();
	}
}
