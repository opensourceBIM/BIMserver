package org.bimserver.test.framework;

import java.nio.charset.Charset;
import java.util.SortedMap;

public class DumpCharsets {
	public static void main(String[] args) {
		SortedMap<String, Charset> availableCharsets = Charset.availableCharsets();
		for (String s : availableCharsets.keySet()) {
			System.out.println(s + ": " + availableCharsets.get(s));
		}
	}
}
