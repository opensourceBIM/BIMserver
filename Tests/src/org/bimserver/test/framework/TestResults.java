package org.bimserver.test.framework;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.commons.io.FileUtils;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.test.framework.actions.Action;
import org.bimserver.test.framework.actions.ActionResults;

public class TestResults {
	private PrintWriter out;
	private int rowNr;

	public TestResults() {
		try {
			out = new PrintWriter(new File("results.html"));
			out.write(FileUtils.readFileToString(new File("static/header.html")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		startTable("Virtual User", "Action", "Result", "Message");
	}

	public void addResult(VirtualUser virtualUser, Action action, Exception e) {
		String type = "ERROR";
		if (e instanceof UserException) {
			type = "WARN";
		}
		addRow(virtualUser.getName() + "", action.getClass().getSimpleName(), type, e.getMessage());
	}

	public void addResult(VirtualUser virtualUser, Action action) {
		addRow(virtualUser.getName() + "", action.getClass().getSimpleName(), "OKE", "");
	}

	public void addResult(VirtualUser virtualUser, Action action, ActionResults actionResults) {
		addRow(virtualUser.getName() + "", action.getClass().getSimpleName(), "OKE", actionResults.getText());
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