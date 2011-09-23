package org.bimserver.o3d;

/******************************************************************************
 * Copyright (C) 2011  BIMserver.org
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
 *****************************************************************************/

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.bimserver.utils.LittleEndianBinUtils;

public class BinaryIndexBuffer {

	private final List<Integer> indices = new ArrayList<Integer>();
	
	public void addIndex(int index) {
		indices.add(index);
	}

	public int getNrIndices() {
		return indices.size();
	}

	public List<Integer> getIndices() {
		return indices;
	}
	
	public void serialize(OutputStream outputStream) throws IOException {
		outputStream.write(LittleEndianBinUtils.intToByteArray(indices.size()));
		for (Integer index : indices) {
			outputStream.write(LittleEndianBinUtils.intToByteArray(index));
		}		
	}
}