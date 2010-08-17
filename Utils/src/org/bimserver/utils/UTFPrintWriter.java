package org.bimserver.utils;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class UTFPrintWriter extends PrintWriter {

	public UTFPrintWriter(OutputStream out) {
		super(new PrintWriter(new OutputStreamWriter(out, DefaultCharset.UTF_8)), false);
	}
}