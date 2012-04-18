package org.bimserver.test.framework;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.commons.io.FileUtils;
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

//	public void addResult(VirtualUser virtualUser, Action action, Exception e) {
//		String type = "ERROR";
//		if (e instanceof UserException) {
//			type = "WARN";
//		}
//		addRow(virtualUser.getName() + "", action.getClass().getSimpleName(), type, e.getMessage());
//	}
//
//	public void addResult(VirtualUser virtualUser, Action action) {
//		addRow(virtualUser.getName() + "", action.getClass().getSimpleName(), "OKE", "");
//	}
//
//	public void addResult(VirtualUser virtualUser, Action action, ActionResults actionResults) {
//		addRow(virtualUser.getName() + "", action.getClass().getSimpleName(), "OKE", actionResults.getText());
//	}
	
	public synchronized void addRow(ActionResults actionResults, VirtualUser virtualUser, Action action, String... values) {
		String type = actionResults.getType();
		out.println("<tr user=\"" + virtualUser.getName() + "\" action=\"" + action.getClass().getSimpleName() + "\" type=\"" + type + "\">");
		out.println("<td>" + rowNr + ".</td>");
		out.println("<td>" + virtualUser.getName() + "</td>");
		out.println("<td>" + action.getClass().getSimpleName() + "</td>");
		out.println("<td>" + type + "</td>");
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