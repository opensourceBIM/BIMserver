package org.bimserver.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bimserver.utils.LittleEndianBinUtils;

public class ReadTest {
	static class Field {
		public Field(byte type, byte nrComponents) {
			this.type = type;
			this.nrComponents = nrComponents;
		}

		public byte type;
		public byte nrComponents;
	}

	public static void main(String[] args) {
		try {
//			FileInputStream fis = new FileInputStream(new File("C:\\Documents and Settings\\Ruben de Laat\\My Documents\\index-buffers.bin"));
			FileInputStream fis = new FileInputStream(new File("C:\\Workspaces\\BimServer\\BimServer\\www\\index-buffers.bin"));
			byte[] buffer = new byte[4];
			fis.read(buffer);
			System.out.println("id: " + new String(buffer, "ASCII"));
			buffer = new byte[4];
			fis.read(buffer);
			System.out.println("version: " + LittleEndianBinUtils.byteArrayToInt(buffer));
			buffer = new byte[4];
			fis.read(buffer);
			int numFields = LittleEndianBinUtils.byteArrayToInt(buffer);
			System.out.println("num fields: " + numFields);
			List<Field> fields = new ArrayList<Field>();
			for (int i = 0; i < numFields; i++) {
				buffer = new byte[1];
				fis.read(buffer);
				byte fieldType = LittleEndianBinUtils.byteArrayToByte(buffer);
				System.out.println("field type: " + fieldType);
				buffer = new byte[1];
				fis.read(buffer);
				byte nrComponents = LittleEndianBinUtils.byteArrayToByte(buffer);
				System.out.println("num components: " + nrComponents);
				fields.add(new Field(fieldType, nrComponents));
			}
			buffer = new byte[4];
			fis.read(buffer);
			int numElements = LittleEndianBinUtils.byteArrayToInt(buffer);
			System.out.println("num elements: " + numElements);
			for (int i = 0; i < numElements; i++) {
				for (Field field : fields) {
					for (int k = 0; k < field.nrComponents; k++) {
						if (field.type == 1) {
							buffer = new byte[4];
							fis.read(buffer);
							System.out.println("element: " + LittleEndianBinUtils.byteArrayToFloat(buffer));
						}
						if (field.type == 2) {
							buffer = new byte[4];
							fis.read(buffer);
							System.out.println("element: " + LittleEndianBinUtils.byteArrayToInt(buffer));
						}
					}
				}
			}
			System.out.println(fis.available());
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}