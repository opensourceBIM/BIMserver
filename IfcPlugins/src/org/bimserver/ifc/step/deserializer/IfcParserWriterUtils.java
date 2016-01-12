package org.bimserver.ifc.step.deserializer;

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
 *****************************************************************************/

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.serializers.SerializerException;
import org.eclipse.emf.common.util.Enumerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Charsets;

public class IfcParserWriterUtils {
	private static final Logger LOGGER = LoggerFactory.getLogger(IfcParserWriterUtils.class);
	private static final boolean USE_ISO_8859_1 = false;

	public static Object convertSimpleValue(Class<?> instanceClass, String value, int lineNumber) throws DeserializeException {
		if (!value.equals("")) {
			if (instanceClass == Integer.class || instanceClass == int.class) {
				return Integer.parseInt(value);
			} else if (instanceClass == Long.class || instanceClass == long.class) {
				return Long.parseLong(value);
			} else if (instanceClass == Boolean.class || instanceClass == boolean.class) {
				return Boolean.parseBoolean(value);
			} else if (instanceClass == Double.class || instanceClass == double.class) {
				try {
					return Double.parseDouble(value);
				} catch (NumberFormatException e) {
					throw new DeserializeException(lineNumber, "Incorrect double floating point value: " + value, e);
				}
			} else if (instanceClass == String.class) {
				if (value.startsWith("'") && value.endsWith("'")) {
					return readString(value, lineNumber);
				} else {
					return value;
				}
			} else if (instanceClass == byte[].class) {
				if (value.startsWith("\"") && value.endsWith("\"")) {
					try {
						// TODO Skipping the first one here to make even...
						String substring = value.substring(2, value.length() - 1);
						byte[] decoded = Hex.decodeHex(substring.toCharArray());
						return decoded;
					} catch (DecoderException e) {
						throw new DeserializeException(e);
					}
				} else {
					throw new DeserializeException("Byte[] not starting/ending with \"");
				}
			} else {
				throw new DeserializeException("Unimplemented " + instanceClass);
			}
		}
		return null;
	}
	
	public static String readString(String value, int lineNumber) throws DeserializeException {
		String result = value.substring(1, value.length() - 1);
		// Replace all '' with '
		while (result.contains("''")) {
			int index = result.indexOf("''");
			result = result.substring(0, index) + "'" + result.substring(index + 2);
		}
		while (result.contains("\\S\\")) {
			int index = result.indexOf("\\S\\");
			char x = result.charAt(index + 3);
			ByteBuffer b = ByteBuffer.wrap(new byte[] { (byte) (x + 128) });
			CharBuffer decode = Charsets.ISO_8859_1.decode(b);
			result = result.substring(0, index) + decode.get() + result.substring(index + 4);
		}
		while (result.contains("\\X\\")) {
			int index = result.indexOf("\\X\\");
			int code = Integer.parseInt(result.substring(index + 3, index + 5), 16);
			ByteBuffer b = ByteBuffer.wrap(new byte[] { (byte) (code) });
			CharBuffer decode = Charsets.ISO_8859_1.decode(b);
			result = result.substring(0, index) + decode.get() + result.substring(index + 5);
		}
		while (result.contains("\\X2\\")) {
			int index = result.indexOf("\\X2\\");
			int indexOfEnd = result.indexOf("\\X0\\");
			if (indexOfEnd == -1) {
				throw new DeserializeException(lineNumber, "\\X2\\ not closed with \\X0\\");
			}
			if ((indexOfEnd - index) % 4 != 0) {
				throw new DeserializeException(lineNumber, "Number of hex chars in \\X2\\ definition not divisible by 4");
			}
			try {
				ByteBuffer buffer = ByteBuffer.wrap(Hex.decodeHex(result.substring(index + 4, indexOfEnd).toCharArray()));
				CharBuffer decode = Charsets.UTF_16BE.decode(buffer);
				result = result.substring(0, index) + decode.toString() + result.substring(indexOfEnd + 4);
			} catch (DecoderException e) {
				throw new DeserializeException(lineNumber, e);
			}
		}
		while (result.contains("\\X4\\")) {
			int index = result.indexOf("\\X4\\");
			int indexOfEnd = result.indexOf("\\X0\\");
			if (indexOfEnd == -1) {
				throw new DeserializeException(lineNumber, "\\X4\\ not closed with \\X0\\");
			}
			if ((indexOfEnd - index) % 8 != 0) {
				throw new DeserializeException(lineNumber, "Number of hex chars in \\X4\\ definition not divisible by 8");
			}
			try {
				ByteBuffer buffer = ByteBuffer.wrap(Hex.decodeHex(result.substring(index + 4, indexOfEnd).toCharArray()));
				CharBuffer decode = Charset.forName("UTF-32").decode(buffer);
				result = result.substring(0, index) + decode.toString() + result.substring(indexOfEnd + 4);
			} catch (DecoderException e) {
				throw new DeserializeException(lineNumber, e);
			} catch (UnsupportedCharsetException e) {
				throw new DeserializeException(lineNumber, "UTF-32 is not supported on your system", e);
			}
		}
		// Replace all \\ with \
		while (result.contains("\\\\")) {
			int index = result.indexOf("\\\\");
			result = result.substring(0, index) + "\\" + result.substring(index + 2);
		}
		return result;
	}

	public static void writePrimitive(Object val, OutputStream outputStream) throws SerializerException, IOException {
		if (val.getClass().getSimpleName().equals("Tristate")) {
			if (val.toString().equals("TRUE")) {
				outputStream.write(".T.".getBytes(Charsets.UTF_8));
			} else if (val.toString().equals("FALSE")) {
				outputStream.write(".F.".getBytes(Charsets.UTF_8));
			} else if (val.toString().equals("UNDEFINED")) {
				outputStream.write(".U.".getBytes(Charsets.UTF_8));
			}
		} else if (val instanceof Double) {
			if (((Double)val).isInfinite() || (((Double)val).isNaN())) {
				LOGGER.info("Serializing infinite or NaN double as 0.0");
				outputStream.write("0.0".getBytes(Charsets.UTF_8));
			} else {
				String string = val.toString();
				if (string.endsWith(".0")) {
					outputStream.write((string.substring(0, string.length() - 1)).getBytes(Charsets.UTF_8));
				} else {
					outputStream.write(string.getBytes(Charsets.UTF_8));
				}
			}
		} else if (val instanceof Boolean) {
			Boolean bool = (Boolean)val;
			if (bool) {
				outputStream.write(".T.".getBytes(Charsets.UTF_8));
			} else {
				outputStream.write(".F.".getBytes(Charsets.UTF_8));
			}
		} else if (val instanceof String) {
			outputStream.write("'".getBytes(Charsets.UTF_8));
			String stringVal = (String)val;
			for (int i=0; i<stringVal.length(); i++) {
				char c = stringVal.charAt(i);
				if (c == '\'') {
					outputStream.write("\'\'".getBytes(Charsets.UTF_8));
				} else if (c == '\\') {
					outputStream.write("\\\\".getBytes(Charsets.UTF_8));
				} else if (c >= 32 && c <= 126) {
					// ISO 8859-1
					outputStream.write(("" + c).getBytes(Charsets.UTF_8));
				} else if (c < 255) {
					//  ISO 10646 and ISO 8859-1 are the same < 255 , using ISO_8859_1
					outputStream.write(("\\X\\" + new String(Hex.encodeHex(Charsets.ISO_8859_1.encode(CharBuffer.wrap(new char[]{(char) c})).array())).toUpperCase()).getBytes(Charsets.UTF_8));
				} else {
					if (USE_ISO_8859_1) {
						// ISO 8859-1 with -128 offset
						ByteBuffer encode = Charsets.ISO_8859_1.encode(new String(new char[]{(char) (c - 128)}));
						outputStream.write(("\\S\\" + (char)encode.get()).getBytes(Charsets.UTF_8));
					} else {
						// The following code has not been tested (2012-04-25)
						// Use UCS-2 or UCS-4
						
						// TODO when multiple sequential characters should be encoded in UCS-2 or UCS-4, we don't really need to add all those \X0\ \X2\ and \X4\ chars
						if (Character.isLowSurrogate(c)) {
							throw new SerializerException("Unexpected low surrogate range char");
						} else if (Character.isHighSurrogate(c)) {
							// We need UCS-4, this is probably never happening
							if (i + 1 < stringVal.length()) {
								char low = stringVal.charAt(i + 1);
								if (!Character.isLowSurrogate(low)) {
									throw new SerializerException("High surrogate char should be followed by char in low surrogate range");
								}
								try {
									outputStream.write(("\\X4\\" + new String(Hex.encodeHex(Charset.forName("UTF-32").encode(new String(new char[]{c, low})).array())).toUpperCase() + "\\X0\\").getBytes(Charsets.UTF_8));
								} catch (UnsupportedCharsetException e) {
									throw new SerializerException(e);
								}
								i++;
							} else {
								throw new SerializerException("High surrogate char should be followed by char in low surrogate range, but end of string reached");
							}
						} else {
							// UCS-2 will do
							outputStream.write(("\\X2\\" + new String(Hex.encodeHex(Charsets.UTF_16BE.encode(CharBuffer.wrap(new char[]{c})).array())).toUpperCase() + "\\X0\\").getBytes(Charsets.UTF_8));
						}
					}
				}
			}
			outputStream.write("'".getBytes(Charsets.UTF_8));
		} else if (val instanceof Enumerator) {
			outputStream.write(("." + val + ".").getBytes(Charsets.UTF_8));
		} else if (val instanceof byte[]) {
			// TODO printing default leading 0, must be wrong
			outputStream.write(("\"0" + Hex.encodeHexString((byte[])val) + "\"").getBytes(Charsets.UTF_8));
		} else {
			outputStream.write((val == null ? "$" : val.toString()).getBytes(Charsets.UTF_8));
		}
	}
}