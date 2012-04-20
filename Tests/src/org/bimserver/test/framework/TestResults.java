package org.bimserver.test.framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.bimserver.test.framework.actions.Action;
import org.bimserver.test.framework.actions.ActionResults;

import com.google.common.base.Charsets;

public class TestResults {
	private PrintWriter out;
	private int rowNr;

	public TestResults() {
		try {
			out = new PrintWriter(new File("results.html"));
			File f = new File("static/header.html");
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			if (f.exists()) {
				IOUtils.copy(new FileInputStream(f), byteArrayOutputStream);
			} else {
				InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("static/header.html");
				IOUtils.copy(resourceAsStream, byteArrayOutputStream);
			}
			out.write(new String(byteArrayOutputStream.toByteArray(), Charsets.UTF_8));
		} catch (IOException e) {
			e.printStackTrace();
		}
		startTable("Virtual User", "Action", "Result", "Message");
	}

	public synchronized void addRow(ActionResults actionResults, VirtualUser virtualUser, Action action, String... values) {
		String type = actionResults.getType();
		out.println("<tr user=\"" + virtualUser.getName() + "\" action=\"" + action.getClass().getSimpleName() + "\" type=\"" + type + "\">");
		out.println("<td>" + rowNr + ".</td>");
		out.println("<td>" + virtualUser.getName() + "</td>");
		out.println("<td>" + action.getClass().getSimpleName() + "</td>");
		out.println("<td class=\"type_" + type + "\">" + type + "</td>");
		out.println("<td>" + actionResults.getText() + "</td>");
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