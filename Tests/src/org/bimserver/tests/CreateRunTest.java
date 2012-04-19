package org.bimserver.tests;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class CreateRunTest {
	public static void main(String[] args) {
		new CreateRunTest().start();
	}

	private void start() {
		try {
			PrintWriter out = new PrintWriter(new File("runtest.sh"));
			out.println("#!/bin/sh");
			addEclipseProject(out, new File("BimCombined"));
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void addEclipseProject(PrintWriter out, File projectFolder) {
	}
}