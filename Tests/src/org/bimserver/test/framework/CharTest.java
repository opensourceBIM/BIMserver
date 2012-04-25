package org.bimserver.test.framework;

import java.nio.CharBuffer;

import com.google.common.base.Charsets;

public class CharTest {
	public static void main(String[] args) {
		char c = '\u00E7';
		CharBuffer wrap = CharBuffer.wrap(new char[]{c});
		byte[] array = Charsets.UTF_16.encode(wrap).array();
		System.out.println(array);
	}
}
