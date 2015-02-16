package org.bimserver.ifcengine.jvm;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * BIMserver software uses the IFC Engine DLL library build.
 * This binary Engine DLL is NOT open source. The IFC Engine DLL is a closed source product owned by the Netherlands Organisation for Applied Scientifc Research TNO.
 * The latest versions are available for download from http://ifcengine.com.
 * In case of none commercial use there is no license fee and redistribution of the binary is allowed as long as clearly mentioned that the IFC Engine DLL is used. The BIMserver.org software is non-commercial so users of the BIMserver software can use it free of charge.
 * Within the Open Source BIMserver software there is one exception to the normal conditions: A special version of the IFC Engine DLL is used that includes Clashdetection functionality, this version is not commercially available. For more information, please contact the owner at info@ifcengine.com
 *****************************************************************************/

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class TestConvertingInputStream {
	public static void main(String[] args) throws IOException {
		ByteArrayOutputStream testStream = new ByteArrayOutputStream();
		DataOutputStream testDataStream = new DataOutputStream(testStream);
		testDataStream.writeInt(8000);
		testDataStream.write(new byte[8000]);
		testDataStream.writeInt(200);
		testDataStream.write(new byte[200]);
		testDataStream.writeInt(9090);
		testDataStream.write(new byte[9090]);
		testDataStream.writeInt(-1);
		testDataStream.flush();

		ConvertingInputStream convertingInputStream = new ConvertingInputStream(new DataInputStream(new ByteArrayInputStream(testStream.toByteArray())));
		byte[] buffer = new byte[1024];
		int read = convertingInputStream.read(buffer, 0, 1024);
		ByteArrayOutputStream compareStream = new ByteArrayOutputStream();
		while (read != -1) {
			compareStream.write(buffer, 0, read);
			read = convertingInputStream.read(buffer, 0, 1024);
		}
		convertingInputStream.close();

		byte[] compare = new byte[8000 + 200 + 9090];
		if (compare.length != compareStream.size()) {
			System.out.println("FAIL! Size different " + compare.length + "/" + compareStream.size());
		}
		if (Arrays.equals(compareStream.toByteArray(), compare)) {
			System.out.println("OK!");
		} else {
			System.out.println("FAIL!");
		}
	}
}