package org.bimserver.utils;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import com.google.common.base.Charsets;

public class UTFPrintWriter extends PrintWriter {

	public UTFPrintWriter(OutputStream out) {
		super(new PrintWriter(new OutputStreamWriter(out, Charsets.UTF_8)), false);
	}
}