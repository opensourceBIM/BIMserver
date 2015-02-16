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

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ConvertingInputStream extends InputStream {

	private DataInputStream in;
	private byte[] buffer = new byte[0];
	private int pos;
	private boolean end = false;

	public ConvertingInputStream(DataInputStream in) {
		this.in = in;
	}

	@Override
	public int read(byte[] b, int off, int len) throws IOException {
		if (end) {
			int min = Math.min(buffer.length - pos, len);
			if (min == 0) {
				return -1;
			}
			System.arraycopy(buffer, pos, b, off, min);
			return min;
		}
		while (buffer.length - pos < len) {
			// We need to read some more data
			int size = in.readInt();
			if (size == -1) {
				// No more data, just return whatever we have left
				end = true;
				int min = Math.min(buffer.length - pos, len);
				System.arraycopy(buffer, pos, b, off, min);
				pos += min;
				return min;
			} else {
				byte[] tmp = buffer;
				buffer = new byte[buffer.length + size];
				System.arraycopy(tmp, 0, buffer, 0, tmp.length);
				in.readFully(buffer, tmp.length, size);
			}
		}
		// We have enough data
		System.arraycopy(buffer, pos, b, off, len);
		pos += len;
		return len;
	}
	
	@Override
	public int read() throws IOException {
		return 0;
	}
}