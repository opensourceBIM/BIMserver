package org.bimserver.serializers;

public class Test {
	public static void main(String[] args) {
		for (int i=0; i<255;i++) {
			byte b = (byte)i;
			
			int t = (byte)b;
			if (b < 0) {
				t = t + 255;
			}
			float x = t / 255f;
			System.out.println(x);
		}
	}
}
