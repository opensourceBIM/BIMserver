package org.bimserver.emf;

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

import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Date;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.bimserver.models.store.IfcHeader;
import org.bimserver.plugins.serializers.ObjectProvider;
import org.bimserver.plugins.serializers.ProgressReporter;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.StreamingReader;
import org.bimserver.shared.HashMapVirtualObject;
import org.bimserver.shared.HashMapWrappedVirtualObject;
import org.bimserver.shared.MinimalVirtualObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Charsets;

public class SharedJsonStreamingSerializer implements StreamingReader {
	private static final Logger LOGGER = LoggerFactory.getLogger(SharedJsonStreamingSerializer.class);
	enum Mode {
		HEADER, BODY, FOOTER, DONE
	}

	private static final boolean SERIALIZE_EMPTY_LISTS = false;

	private Mode mode = Mode.HEADER;
	private boolean firstObject = true;

	private OutputStream outputStream;

	private boolean includeHidden;

	private ObjectProvider objectProvider;

	private IfcHeader ifcHeader;

	public SharedJsonStreamingSerializer(ObjectProvider objectProvider, IfcHeader ifcHeader, boolean includeHidden) throws SerializerException {
		if (objectProvider == null) {
			throw new SerializerException("No object provider");
		}
		this.objectProvider = objectProvider;
		this.ifcHeader = ifcHeader;
		this.includeHidden = includeHidden;
	}

	private void print(String line) throws IOException {
		byte[] bytes = line.getBytes(Charsets.UTF_8);
		outputStream.write(bytes, 0, bytes.length);
	}
	
	public boolean write(OutputStream outputStream, ProgressReporter progressReporter) throws SerializerException {
		this.outputStream = outputStream;
		try {
			if (mode == Mode.HEADER) {
				print("{");
				if (ifcHeader != null) {
					print("\"header\":");
//					writeObject(ifcHeader);
					print("\n,");
				}
				print("\"objects\":[");
				mode = Mode.BODY;
				return true;
			} else if (mode == Mode.BODY) {
				HashMapVirtualObject object = objectProvider.next();
				if (object != null) {
					if (object.getOid() == -1) {
						throw new SerializerException("Object cannot have oid -1 " + object.eClass().getName());
					}
					if (object.eClass().getEAnnotation("hidden") == null || includeHidden) {
						if (!firstObject) {
							print(",");
						} else {
							firstObject = false;
						}
						writeObject(object);
					}
					return true;
				} else {
					print("]");
					print("}");
					mode = Mode.FOOTER;
					return true;
				}
			} else if (mode == Mode.FOOTER) {
				mode = Mode.DONE;
				return false;
			}
		} catch (Throwable e) {
			throw new SerializerException(e);
		}
		return false;
	}

	private void writeObject(HashMapVirtualObject object) throws IOException {
//		if (((IdEObjectImpl) object).getLoadingState() != State.LOADED) {
//			print("{");
//			print("\"_i\":" + object.getOid() + ",");
//			print("\"_t\":\"" + object.eClass().getName() + "\",");
//			print("\"_s\":0");
//			print("}\n");
//		} else {
			print("{");
			print("\"_i\":" + object.getOid() + ",");
			print("\"_t\":\"" + object.eClass().getName() + "\",");
			print("\"_s\":1");
			for (EStructuralFeature eStructuralFeature : object.eClass().getEAllStructuralFeatures()) {
				if (eStructuralFeature.getEAnnotation("nolazyload") == null && (eStructuralFeature.getEAnnotation("hidden") == null || includeHidden)) {
					if (eStructuralFeature instanceof EReference) {
						Object value = object.eGet(eStructuralFeature);
						if (value != null) {
							if (eStructuralFeature.isMany()) {
								List<?> list = (List<?>) value;
								if (SERIALIZE_EMPTY_LISTS || !list.isEmpty()) {
									print(",");
									int wrapped = 0;
									int referred = 0;
									for (Object o : list) {
										if (o instanceof Long) {
											referred++;
										} else if (o instanceof HashMapWrappedVirtualObject) {
											wrapped++;
										}
									}
									if (wrapped == 0 && referred != 0) {
										print("\"_r" + eStructuralFeature.getName() + "\":[");
									} else if (wrapped != 0 && referred == 0) {
										print("\"_e" + eStructuralFeature.getName() + "\":[");
									} else if (wrapped == 0 && referred == 0) {
										// should not happen
									} else {
										// both, this can occur,
										// for example
										// IfcTrimmedCurve.Trim1
										print("\"_e" + eStructuralFeature.getName() + "\":[");
									}
									boolean f = true;
									for (Object o : list) {
										if (o == null) {
											LOGGER.info("Unexpeced null in list " + object.eClass().getName() + ":" + object.getOid() + "." + eStructuralFeature.getName());
										} else {
											if (!f) {
												print(",");
											} else {
												f = false;
											}
											if (o instanceof Long) {
												long ref = (Long)o;
												if (wrapped != 0 && referred != 0) {
													// Special
													// situation,
													// where we have
													// to construct
													// an object
													// around the
													// OID to make
													// it
													// distinguishable
													// from embedded
													// objects
													print("{");
													print("\"_i\":");
													print("" + ref);
													print("}");
												} else {
													print("" + ref);
												}
											} else if (o instanceof HashMapWrappedVirtualObject) {
												write((HashMapWrappedVirtualObject) o);
											} else {
												LOGGER.info("Unimplemented " + o);
											}
										}
									}
									print("]");
								}
							} else {
								print(",");
								if (value instanceof Long) {
									long ref = (Long) value;
									print("\"_r" + eStructuralFeature.getName() + "\":"	+ ref);
								} else if (value instanceof HashMapWrappedVirtualObject) {
									print("\"_e" + eStructuralFeature.getName() + "\":");
									HashMapWrappedVirtualObject hashMapWrappedVirtualObject = (HashMapWrappedVirtualObject)value;
									write(hashMapWrappedVirtualObject);
								} else {
//									print("\"" + eStructuralFeature.getName() + "\":");
//									writePrimitive(eStructuralFeature, ((IfcGloballyUniqueId) ref).getWrappedValue());
								}
							}
						}
					} else {
						Object value = object.eGet(eStructuralFeature);
						if (value != null) {
							if (eStructuralFeature.isMany()) {
								List<?> list = (List<?>) value;
								if (SERIALIZE_EMPTY_LISTS || !list.isEmpty()) {
									print(",");
									print("\"" + eStructuralFeature.getName() + "\":[");
									boolean f = true;
									for (Object o : list) {
										if (!f) {
											print(",");
										} else {
											f = false;
										}
										writePrimitive(eStructuralFeature, o);
									}
									print("]");
								}
							} else {
								print(",");
								print("\"" + eStructuralFeature.getName() + "\":");
								writePrimitive(eStructuralFeature, value);
							}
						}
					}
				}
			}
			print("}\n");
//		}
	}

	private void write(MinimalVirtualObject object) throws IOException {
		if (object.eClass().getEAnnotation("wrapped") != null) {
			EStructuralFeature wrappedFeature = object.eClass().getEStructuralFeature("wrappedValue");
			print("{");
			print("\"_t\":\"" + object.eClass().getName() + "\",");
			print("\"_v\":");
			writePrimitive(wrappedFeature, object.eGet(wrappedFeature));
			print("}");
		} else if (object instanceof HashMapVirtualObject) {
			print("" + ((HashMapVirtualObject)object).getOid());
		} else if (object instanceof HashMapWrappedVirtualObject) {
			print("{");
			print("\"_t\":\"" + object.eClass().getName() + "\",");
			for (EStructuralFeature eStructuralFeature : object.eClass().getEAllStructuralFeatures()) {
				print("\"" + eStructuralFeature.getName() + "\":");
				writePrimitive(eStructuralFeature, object.eGet(eStructuralFeature));
				if (object.eClass().getEAllStructuralFeatures().get(object.eClass().getEAllStructuralFeatures().size()-1) != eStructuralFeature) {
					print(",");
				}
			}
			print("}");
		}
	}
	
	// Following two methods copied from http://www.json.org/java/org/json/JSONObject.java
	public static String quote(String string) {
		StringWriter sw = new StringWriter();
		synchronized (sw.getBuffer()) {
			try {
				return quote(string, sw).toString();
			} catch (IOException ignored) {
				// will never happen - we are writing to a string writer
				return "";
			}
		}
	}
	
	public static Writer quote(String string, Writer w) throws IOException {
        if (string == null || string.length() == 0) {
            w.write("\"\"");
            return w;
        }

        char b;
        char c = 0;
        String hhhh;
        int i;
        int len = string.length();

        w.write('"');
        for (i = 0; i < len; i += 1) {
            b = c;
            c = string.charAt(i);
            switch (c) {
            case '\\':
            case '"':
                w.write('\\');
                w.write(c);
                break;
            case '/':
                if (b == '<') {
                    w.write('\\');
                }
                w.write(c);
                break;
            case '\b':
                w.write("\\b");
                break;
            case '\t':
                w.write("\\t");
                break;
            case '\n':
                w.write("\\n");
                break;
            case '\f':
                w.write("\\f");
                break;
            case '\r':
                w.write("\\r");
                break;
            default:
                if (c < ' ' || (c >= '\u0080' && c < '\u00a0')
                        || (c >= '\u2000' && c < '\u2100')) {
                    w.write("\\u");
                    hhhh = Integer.toHexString(c);
                    w.write("0000", 0, 4 - hhhh.length());
                    w.write(hhhh);
                } else {
                    w.write(c);
                }
            }
        }
        w.write('"');
        return w;
    }

	private void writePrimitive(EStructuralFeature feature, Object value) throws IOException {
		if (value instanceof String) {
			print(quote((String) value));
		} else if (value instanceof byte[]) {
			print("\"" + new String(Base64.encodeBase64((byte[]) value), Charsets.UTF_8) + "\"");
		} else if (value instanceof Date) {
			print(Long.toString(((Date)value).getTime()));
		} else if (value instanceof Enum) {
			if (value.toString().equalsIgnoreCase("true") || value.toString().equalsIgnoreCase("false")) {
				print(value.toString().toLowerCase());
			} else {
				print("\"" + value + "\"");
			}
		} else {
			print("" + value);
		}
	}

	@Override
	public boolean write(OutputStream out) throws SerializerException {
		return write(out, null);
	}
}