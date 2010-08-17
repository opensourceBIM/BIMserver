package org.bimserver.utils;

import java.nio.charset.Charset;

public class DefaultCharset {
	public static final Charset UTF_8 = getUTF8();

	private static Charset getUTF8() {
		return Charset.forName("UTF-8");
	}
}
