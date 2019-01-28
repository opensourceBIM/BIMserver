package org.bimserver.utils;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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
import java.nio.ByteOrder;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.Date;

import com.google.common.base.Charsets;

public class LittleEndianBinUtils {
	public static byte[] longToByteArray(long inLong) {
		byte[] bArray = new byte[8];
		ByteBuffer bBuffer = ByteBuffer.wrap(bArray);
		bBuffer.order(ByteOrder.LITTLE_ENDIAN);
		LongBuffer lBuffer = bBuffer.asLongBuffer();
		lBuffer.put(inLong);
		return bArray;
	}

	public static byte[] intToByteArray(int inInt) {
		byte[] bArray = new byte[4];
		ByteBuffer bBuffer = ByteBuffer.wrap(bArray);
		bBuffer.order(ByteOrder.LITTLE_ENDIAN);
		IntBuffer lBuffer = bBuffer.asIntBuffer();
		lBuffer.put(inInt);
		return bArray;
	}

	public static long byteArrayToLong(byte[] bytes) {
		ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
		return byteBuffer.getLong();
	}

	public static byte byteArrayToByte(byte[] bytes) {
		ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
		byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
		return byteBuffer.get();
	}

	public static int byteArrayToInt(byte[] bytes) {
		ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
		byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
		return byteBuffer.getInt();
	}

	public static byte[] floatToByteArray(Float inFloat) {
		byte[] bArray = new byte[4];
		ByteBuffer bBuffer = ByteBuffer.wrap(bArray);
		bBuffer.order(ByteOrder.LITTLE_ENDIAN);
		FloatBuffer lBuffer = bBuffer.asFloatBuffer();
		lBuffer.put(inFloat);
		return bArray;
	}

	public static float byteArrayToFloat(byte[] data) {
		ByteBuffer byteBuffer = ByteBuffer.wrap(data);
		byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
		return byteBuffer.getFloat();
	}

	public static double byteArrayToDouble(byte[] data) {
		ByteBuffer byteBuffer = ByteBuffer.wrap(data);
		return byteBuffer.getDouble();
	}

	public static byte[] doubleToByteArray(Double inDouble) {
		byte[] bArray = new byte[8];
		ByteBuffer bBuffer = ByteBuffer.wrap(bArray);
		bBuffer.order(ByteOrder.LITTLE_ENDIAN);
		DoubleBuffer lBuffer = bBuffer.asDoubleBuffer();
		lBuffer.put(inDouble);
		return bArray;
	}

	public static byte[] booleanToByteArray(Boolean inBoolean) {
		byte[] bArray = new byte[1];
		bArray[0] = inBoolean ? (byte)1 : (byte)0;
		return bArray;
	}

	public static boolean byteArrayToBoolean(byte[] data) {
		return data[0] == 1;
	}

	public static String byteArrayToString(byte[] value) {
		return new String(value, Charsets.UTF_8);
	}

	public static String byteArrayToString(byte[] value, int index, int length) {
		return new String(value, index, length, Charsets.UTF_8);
	}
	
	public static Short byteArrayToShort(byte[] data) {
		ByteBuffer byteBuffer = ByteBuffer.wrap(data);
		return byteBuffer.getShort();
	}

	public static byte[] shortToByteArray(short inShort) {
		byte[] bArray = new byte[2];
		ByteBuffer bBuffer = ByteBuffer.wrap(bArray);
		bBuffer.order(ByteOrder.LITTLE_ENDIAN);
		ShortBuffer lBuffer = bBuffer.asShortBuffer();
		lBuffer.put(inShort);
		return bArray;
	}

	public static byte[] stringToByteArray(String value) {
		return value.getBytes(Charsets.UTF_8);
	}

	public static byte[] dateToByteArray(Date value) {
		return longToByteArray(value.getTime());
	}

	public static Date byteArrayToDate(byte[] dateBuffer) {
		return new Date(byteArrayToLong(dateBuffer));
	}
	
	public static void dumpByteArray(byte[] array) {
		System.out.print("[");
		for (byte b : array) {
			System.out.print(b + ", ");
		}
		System.out.println("]");
	}

	public static int readInt(byte[] bytes, int index) {
		ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
		return byteBuffer.getInt(index);
	}

	public static short readShort(byte[] value, int index) {
		ByteBuffer byteBuffer = ByteBuffer.wrap(value);
		return byteBuffer.getShort(index);
	}

	public static int byteArrayToInt(byte[] value, int index) {
		ByteBuffer byteBuffer = ByteBuffer.wrap(value);
		return byteBuffer.getInt(index);
	}

	public static long byteArrayToLong(byte[] value, int index) {
		ByteBuffer byteBuffer = ByteBuffer.wrap(value);
		return byteBuffer.getLong(index);
	}

	public static float byteArrayToFloat(byte[] value, int index) {
		ByteBuffer byteBuffer = ByteBuffer.wrap(value);
		return byteBuffer.getFloat(index);
	}

	public static String readString(ByteBuffer buffer, short length) {
		byte[] charBuffer = new byte[length];
		buffer.get(charBuffer);
		return new String(charBuffer, Charsets.UTF_8);
	}

	public static byte[] byteToByteArray(byte b) {
		byte[] bArray = new byte[1];
		ByteBuffer bBuffer = ByteBuffer.wrap(bArray);
		bBuffer.order(ByteOrder.LITTLE_ENDIAN);
		ByteBuffer lBuffer = bBuffer;
		lBuffer.put(b);
		return bArray;
	}
}