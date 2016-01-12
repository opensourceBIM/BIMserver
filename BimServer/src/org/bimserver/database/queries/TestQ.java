package org.bimserver.database.queries;

/******************************************************************************
 * Copyright (C) 2009-2016  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.nio.ByteBuffer;
import java.util.Random;

public class TestQ {
	public static void main(String[] args) {
		Random random = new Random();
		long total1 = 0;
		long total2 = 0;
		long error = 0;
		for (int i=0; i<100000000; i++) {
			long oid = random.nextLong() + random.nextLong();
			
			long s = System.nanoTime();
			short short1 = method1(oid);
			long e = System.nanoTime();
			total1 += (e - s);

			s = System.nanoTime();
			short short2 = method2(oid);
			e = System.nanoTime();
			total2 += (e - s);
			
			if (short1 != short2) {
				error++;
//				System.out.println("Error for " + oid + ": " + short1 + " / " + short2);
			}
		}
		System.out.println("Total 1: " + (total1 / 1000000) + " ms");
		System.out.println("Total 2: " + (total2 / 1000000) + " ms");
		System.out.println("Error: " + error);
	}
	
	public static short method2(long oid) {
		return (short)oid;
	}
	
	public static short method1(long oid) {
		ByteBuffer buffer = ByteBuffer.wrap(new byte[8]);
		buffer.putLong(oid);
		short cid = buffer.getShort(6);
		return cid;
	}
}