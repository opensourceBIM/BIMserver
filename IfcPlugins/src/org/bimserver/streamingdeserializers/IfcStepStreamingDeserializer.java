package org.bimserver.streamingdeserializers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.bimserver.database.DatabaseSessionInterface;
import org.bimserver.database.Record;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.emf.MetaDataException;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.emf.Schema;
import org.bimserver.interfaces.objects.SIfcHeader;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.schema.Attribute;
import org.bimserver.plugins.schema.EntityDefinition;
import org.bimserver.plugins.schema.ExplicitAttribute;
import org.bimserver.plugins.streamingdeserializers.StreamingDeserializer;
import org.bimserver.shared.ListWaitingObject;
import org.bimserver.shared.SingleWaitingObject;
import org.bimserver.shared.WaitingList;
import org.bimserver.utils.FakeClosingInputStream;
import org.bimserver.utils.StringUtils;
import org.bimserver.utils.TokenizeException;
import org.bimserver.utils.Tokenizer;
import org.eclipse.emf.common.util.AbstractEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EClassImpl;
import org.eclipse.emf.ecore.impl.EEnumImpl;

import com.google.common.base.Charsets;

public abstract class IfcStepStreamingDeserializer implements StreamingDeserializer {
	/*
	 * The following hacks are present
	 * 
	 * - For every feature of type double there is an extra feature (name
	 * appended with "AsString") of type String to keep the original String
	 * version this is also done for aggregate features - WrappedValues for all
	 * for derived primitive types and enums that are used in a "select"
	 */

	private PackageMetaData packageMetaData;
	private static final int AVERAGE_LINE_LENGTH = 58;
	private static final String WRAPPED_VALUE = "wrappedValue";
	private Mode mode = Mode.HEADER;
	private int lineNumber;
	private Schema schema2;
	private DatabaseSessionInterface databaseSession;
	private final Map<Integer, Long> converted = new HashMap<>();
	private WaitingList<Long> waitingList = new WaitingList<>();

	public enum Mode {
		HEADER, DATA, FOOTER, DONE
	}

	public void init(PackageMetaData packageMetaData) {
		this.packageMetaData = packageMetaData;
	}
	
	public PackageMetaData getPackageMetaData() {
		return packageMetaData;
	}
	
	@Override
	public void read(InputStream inputStream, DatabaseSessionInterface databaseSession, String filename, long fileSize) throws DeserializeException {
		this.databaseSession = databaseSession;
		mode = Mode.HEADER;
		if (filename != null && (filename.toUpperCase().endsWith(".ZIP") || filename.toUpperCase().endsWith(".IFCZIP"))) {
			ZipInputStream zipInputStream = new ZipInputStream(inputStream);
			ZipEntry nextEntry;
			try {
				nextEntry = zipInputStream.getNextEntry();
				if (nextEntry == null) {
					throw new DeserializeException("Zip files must contain exactly one IFC-file, this zip-file looks empty");
				}
				if (nextEntry.getName().toUpperCase().endsWith(".IFC")) {
					FakeClosingInputStream fakeClosingInputStream = new FakeClosingInputStream(zipInputStream);
					read(fakeClosingInputStream, fileSize);
//					if (model.size() == 0) {
//						throw new DeserializeException("Uploaded file does not seem to be a correct IFC file");
//					}
					if (zipInputStream.getNextEntry() != null) {
						zipInputStream.close();
						throw new DeserializeException("Zip files may only contain one IFC-file, this zip-file contains more files");
					} else {
						zipInputStream.close();
						return;
					}
				} else {
					throw new DeserializeException("Zip files must contain exactly one IFC-file, this zip-file seems to have one or more non-IFC files");
				}
			} catch (IOException e) {
				throw new DeserializeException(e);
			}
		} else {
			read(inputStream, fileSize);
		}
	}

	private void filterComments(Tokenizer tokenizer) throws TokenizeException {
		if (tokenizer.startsWith("/*")) {
			tokenizer.zoomIn("/*", "*/");
			tokenizer.readAll();
			tokenizer.zoomOut();
		}
	}
	
	private void read(InputStream inputStream, long fileSize) throws DeserializeException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, Charsets.UTF_8));
		int initialCapacity = (int) (fileSize / AVERAGE_LINE_LENGTH);
		lineNumber = 0;
		try {
			String line = reader.readLine();
			MessageDigest md = MessageDigest.getInstance("MD5");
			while (line != null) {
				byte[] bytes = line.getBytes(Charsets.UTF_8);
				md.update(bytes, 0, bytes.length);
				try {
					while (!processLine(line.trim())) {
						String readLine = reader.readLine();
						if (readLine == null) {
							break;
						}
						line += readLine;
						lineNumber++;
					}
				} catch (Exception e) {
					if (e instanceof DeserializeException) {
						throw (DeserializeException)e;
					} else {
						throw new DeserializeException(lineNumber, " (" + e.getMessage() + ") " + line, e);
					}
				}
				line = reader.readLine();
				lineNumber++;
			}
			model.getModelMetaData().setChecksum(md.digest());
			if (mode == Mode.HEADER) {
				throw new DeserializeException(lineNumber, "No valid IFC header found");
			}
		} catch (FileNotFoundException e) {
			throw new DeserializeException(lineNumber, e);
		} catch (IOException e) {
			throw new DeserializeException(lineNumber, e);
		} catch (NoSuchAlgorithmException e) {
			throw new DeserializeException(lineNumber, e);
		}
	}

	private boolean processLine(String line) throws DeserializeException, MetaDataException {
		switch (mode) {
		case HEADER:
			if (line.length() > 0) {
				if (line.endsWith(";")) {
					processHeader(line);
				} else {
					return false;
				}
			}
			if (line.equals("DATA;")) {
				mode = Mode.DATA;
			}
			break;
		case DATA:
			if (line.equals("ENDSEC;")) {
				mode = Mode.FOOTER;
			} else {
				if (line.length() > 0 && line.charAt(0) == '#') {
					while (line.endsWith("*/")) {
						line = line.substring(0, line.lastIndexOf("/*")).trim();
					}
					if (line.endsWith(";")) {
						processRecord(line);
					} else {
						return false;
					}
				}
			}
			break;
		case FOOTER:
			if (line.equals("ENDSEC;")) {
				mode = Mode.DONE;
			}
			break;
		case DONE:
		}
		return true;
	}

	private void processHeader(String line) throws DeserializeException {
		try {
			SIfcHeader ifcHeader = new SIfcHeader();
			if (line.startsWith("FILE_DESCRIPTION")) {
				Tokenizer tokenizer = new Tokenizer(line.substring(line.indexOf("(")));
				tokenizer.zoomIn("(", ")");
				tokenizer.zoomIn("(", ")");
				filterComments(tokenizer);
				while (!tokenizer.isEmpty()) {
					ifcHeader.getDescription().add(tokenizer.readSingleQuoted());
					if (tokenizer.nextIsAComma()) {
						tokenizer.readComma();
					}
				}
				tokenizer.zoomOut();
				tokenizer.readComma();
				filterComments(tokenizer);
				ifcHeader.setImplementationLevel(tokenizer.readSingleQuoted());
				tokenizer.zoomOut();
				tokenizer.shouldBeFinished();
			} else if (line.startsWith("FILE_NAME")) {
				Tokenizer tokenizer = new Tokenizer(line.substring(line.indexOf("(")));
				tokenizer.zoomIn("(", ")");
				filterComments(tokenizer);
				ifcHeader.setFilename(tokenizer.readSingleQuoted());
				SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'kk:mm:ss");
				tokenizer.readComma();
				filterComments(tokenizer);
				ifcHeader.setTimeStamp(dateFormatter.parse(tokenizer.readSingleQuoted()));
				tokenizer.readComma();
				filterComments(tokenizer);
				tokenizer.zoomIn("(", ")");
				while (!tokenizer.isEmpty()) {
					ifcHeader.getAuthor().add(tokenizer.readSingleQuoted());
					if (tokenizer.nextIsAComma()) {
						tokenizer.readComma();
					}
				}
				tokenizer.zoomOut();
				tokenizer.readComma();
				filterComments(tokenizer);
				tokenizer.zoomIn("(", ")");
				while (!tokenizer.isEmpty()) {
					ifcHeader.getOrganization().add(tokenizer.readSingleQuoted());
					if (tokenizer.nextIsAComma()) {
						tokenizer.readComma();
					}
				}
				tokenizer.zoomOut();
				tokenizer.readComma();
				filterComments(tokenizer);
				ifcHeader.setPreProcessorVersion(tokenizer.readSingleQuoted());
				tokenizer.readComma();
				filterComments(tokenizer);
				ifcHeader.setOriginatingSystem(tokenizer.readSingleQuoted());
				tokenizer.readComma();
				filterComments(tokenizer);
				if (tokenizer.nextIsDollar()) {
					tokenizer.readDollar();
				} else {
					ifcHeader.setAuthorization(tokenizer.readSingleQuoted());
				}
				tokenizer.zoomOut();
				tokenizer.shouldBeFinished();
			} else if (line.startsWith("FILE_SCHEMA")) {
				Tokenizer tokenizer = new Tokenizer(line.substring(line.indexOf("(")));
				String ifcSchemaVersion = tokenizer.zoomIn("(", ")").zoomIn("(", ")").readSingleQuoted();
				if (!ifcSchemaVersion.toLowerCase().equalsIgnoreCase(schema2.getHeaderName().toLowerCase())) {
					throw new DeserializeException(lineNumber, ifcSchemaVersion + " is not supported by this deserializer (" + schema2.getHeaderName() + " is)");
				}
				ifcHeader.setIfcSchemaVersion(ifcSchemaVersion);
			} else if (line.startsWith("ENDSEC;")) {
				// Do nothing
			}
		} catch (TokenizeException e) {
			throw new DeserializeException(lineNumber, e);
		} catch (ParseException e) {
			throw new DeserializeException(lineNumber, e);
		}
	}

	public void processRecord(String line) throws DeserializeException, MetaDataException {
		int equalSignLocation = line.indexOf("=");
		int lastIndexOfSemiColon = line.lastIndexOf(";");
		if (lastIndexOfSemiColon == -1) {
			throw new DeserializeException(lineNumber, "No semicolon found in line");
		}
		int indexOfFirstParen = line.indexOf("(", equalSignLocation);
		if (indexOfFirstParen == -1) {
			throw new DeserializeException(lineNumber, "No left parenthesis found in line");
		}
		int indexOfLastParen = line.lastIndexOf(")", lastIndexOfSemiColon);
		if (indexOfLastParen == -1) {
			throw new DeserializeException(lineNumber, "No right parenthesis found in line");
		}
		int recordNumber = Integer.parseInt(line.substring(1, equalSignLocation).trim());
		String name = line.substring(equalSignLocation + 1, indexOfFirstParen).trim();
		EClass eClass = (EClass) getPackageMetaData().getEClassifierCaseInsensitive(name);
		if (eClass != null) {
			Record record = new Record(eClass);
			String realData = line.substring(indexOfFirstParen + 1, indexOfLastParen);
			int lastIndex = 0;
			EntityDefinition entityBN = getPackageMetaData().getSchemaDefinition().getEntityBN(name);
			if (entityBN == null) {
				throw new DeserializeException(lineNumber, "Unknown entity " + name);
			}
			for (Attribute attribute : entityBN.getAttributesCached(true)) {
				if (attribute instanceof ExplicitAttribute) {
					if (!entityBN.isDerived(attribute.getName())) {
						EStructuralFeature structuralFeature = eClass.getEStructuralFeature(attribute.getName());
						if (structuralFeature == null) {
							throw new DeserializeException(lineNumber, "Unknown feature " + eClass.getName() + "." + attribute.getName());
						}
						int nextIndex = StringUtils.nextString(realData, lastIndex);
						String val = null;
						try {
							val = realData.substring(lastIndex, nextIndex - 1).trim();
						} catch (Exception e) {
							int expected = 0;
							for (Attribute attribute2 : entityBN.getAttributesCached(true)) {
								if (attribute2 instanceof ExplicitAttribute) {
									expected++;
								}
							}
							throw new DeserializeException(lineNumber, eClass.getName() + " expects " + expected + " fields, but less found");
						}
						lastIndex = nextIndex;
						char firstChar = val.charAt(0);
						if (firstChar == '$') {
							record.eUnset(structuralFeature);
							if (structuralFeature.getEType() == EcorePackage.eINSTANCE.getEDouble()) {
								EStructuralFeature doubleStringFeature = eClass.getEStructuralFeature(attribute.getName() + "AsString");
								record.eSet(doubleStringFeature, val);
							}
						} else if (firstChar == '#') {
							readReference(val, record, structuralFeature);
						} else if (firstChar == '.') {
							readEnum(val, record, structuralFeature);
						} else if (firstChar == '(') {
							readList(val, record, structuralFeature);
						} else if (firstChar == '*') {
						} else {
							if (!structuralFeature.isMany()) {
								record.eSet(structuralFeature, convert(structuralFeature.getEType(), val));
								if (structuralFeature.getEType() == EcorePackage.eINSTANCE.getEDouble()) {
									EStructuralFeature doubleStringFeature = eClass.getEStructuralFeature(attribute.getName() + "AsString");
									record.eSet(doubleStringFeature, val);
								}
							} else {
								// It's not a list in the file, but it is in the
								// schema??
							}
						}
					} else {
						int nextIndex = StringUtils.nextString(realData, lastIndex);
						lastIndex = nextIndex;
					}
				}
			}
			if (waitingList.containsKey(recordNumber)) {
				waitingList.updateNode(recordNumber, eClass, record);
			}
		} else {
			throw new DeserializeException(lineNumber, name + " is not a known entity");
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void readList(String val, Record record, EStructuralFeature structuralFeature) throws DeserializeException, MetaDataException {
		int index = 0;
		if (!structuralFeature.isMany()) {
			throw new DeserializeException(lineNumber, "Field " + structuralFeature.getName() + " of " + structuralFeature.getEContainingClass().getName() + " is no aggregation");
		}
		AbstractEList list = (AbstractEList) object.eGet(structuralFeature);
		AbstractEList doubleStringList = null;
		if (structuralFeature.getEType() == EcorePackage.eINSTANCE.getEDouble()) {
			EStructuralFeature doubleStringFeature = structuralFeature.getEContainingClass().getEStructuralFeature(structuralFeature.getName() + "AsString");
			if (doubleStringFeature == null) {
				throw new DeserializeException(lineNumber, "Field not found: " + structuralFeature.getName() + "AsString");
			}
			doubleStringList = (AbstractEList) object.eGet(doubleStringFeature);
		}
		String realData = val.substring(1, val.length() - 1);
		int lastIndex = 0;
		while (lastIndex != realData.length() + 1) {
			int nextIndex = StringUtils.nextString(realData, lastIndex);
			String stringValue = realData.substring(lastIndex, nextIndex - 1).trim();
			lastIndex = nextIndex;
			if (stringValue.length() > 0) {
				if (stringValue.charAt(0) == '#') {
					Integer referenceId = Integer.parseInt(stringValue.substring(1));
					if (model.contains(referenceId)) {
						EObject referencedObject = model.get(referenceId);
						if (referencedObject != null) {
							EClass referenceEClass = referencedObject.eClass();
							if (((EClass) structuralFeature.getEType()).isSuperTypeOf(referenceEClass)) {
								while (list.size() <= index) {
									list.addUnique(getPackageMetaData().create(referenceEClass));
								}
								list.setUnique(index, referencedObject);
							} else {
								throw new DeserializeException(lineNumber, referenceEClass.getName() + " cannot be stored in " + structuralFeature.getName());
							}
						}
					} else {
						waitingList.add(referenceId, new ListWaitingObject(lineNumber, object, structuralFeature, index));
					}
				} else {
					Object convert = convert(structuralFeature.getEType(), stringValue);
					if (convert != null) {
						while (list.size() <= index) {
							if (doubleStringList != null) {
								doubleStringList.addUnique(stringValue);
							}
							list.addUnique(convert);
						}
						if (doubleStringList != null) {
							doubleStringList.setUnique(index, stringValue);
						}
						list.setUnique(index, convert);
					}
				}
			}
			index++;
		}
	}

	private Object convertSimpleValue(Class<?> instanceClass, String value) throws DeserializeException {
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
					throw new DeserializeException(lineNumber, "Incorrect double floating point value", e);
				}
			} else if (instanceClass == String.class) {
				if (value.startsWith("'") && value.endsWith("'")) {
					return readString(value);
				} else {
					return value;
				}
			}
		}
		return null;
	}

	private String readString(String value) throws DeserializeException {
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

	private Object convert(EClassifier classifier, String value) throws DeserializeException, MetaDataException {
		if (classifier != null) {
			if (classifier instanceof EClassImpl) {
				if (null != ((EClassImpl) classifier).getEStructuralFeature(WRAPPED_VALUE)) {
					IdEObject create = (IdEObject) getPackageMetaData().create((EClass) classifier);
					Class<?> instanceClass = create.eClass().getEStructuralFeature(WRAPPED_VALUE).getEType().getInstanceClass();
					if (value.equals("")) {

					} else {
						if (instanceClass == Integer.class || instanceClass == int.class) {
							try {
								create.eSet(create.eClass().getEStructuralFeature(WRAPPED_VALUE), Integer.parseInt(value));
							} catch (NumberFormatException e) {
								throw new DeserializeException(lineNumber, value + " is not a valid integer value");
							}
						} else if (instanceClass == Long.class || instanceClass == long.class) {
							create.eSet(create.eClass().getEStructuralFeature(WRAPPED_VALUE), Long.parseLong(value));
						} else if (instanceClass == Boolean.class || instanceClass == boolean.class) {
							create.eSet(create.eClass().getEStructuralFeature(WRAPPED_VALUE), value.equals(".T."));
						} else if (instanceClass == Double.class || instanceClass == double.class) {
							try {
								create.eSet(create.eClass().getEStructuralFeature(WRAPPED_VALUE), Double.parseDouble(value));
							} catch (NumberFormatException e) {
								throw new DeserializeException(lineNumber, value + " is not a valid double floating point number");
							}
							create.eSet(create.eClass().getEStructuralFeature(WRAPPED_VALUE + "AsString"), value);
						} else if (instanceClass == String.class) {
							create.eSet(create.eClass().getEStructuralFeature(WRAPPED_VALUE), readString(value));
						} else if (instanceClass.getName().equals("Tristate")) {
							Object tristate = null;
							if (value.equals(".T.")) {
								tristate = getPackageMetaData().getEEnumLiteral("Tristate", "TRUE");
							} else if (value.equals(".F.")) {
								tristate = getPackageMetaData().getEEnumLiteral("Tristate", "FALSE");
							} else if (value.equals(".U.")) {
								tristate = getPackageMetaData().getEEnumLiteral("Tristate", "UNDEFINED");
							}
							create.eSet(create.eClass().getEStructuralFeature(WRAPPED_VALUE), tristate);
						}
					}
					return create;
				} else {
					return processInline(classifier, value);
				}
			} else if (classifier instanceof EDataType) {
				return convertSimpleValue(classifier.getInstanceClass(), value);
			}
		}
		return null;
	}

	private Object processInline(EClassifier classifier, String value) throws DeserializeException, MetaDataException {
		if (value.indexOf("(") != -1) {
			String typeName = value.substring(0, value.indexOf("(")).trim();
			String v = value.substring(value.indexOf("(") + 1, value.length() - 1);
			EClassifier eClassifier = getPackageMetaData().getEClassifierCaseInsensitive(typeName);
			if (eClassifier instanceof EClass) {
				Object convert = convert(eClassifier, v);
				try {
					model.add(-1, (IdEObject) convert);
				} catch (IfcModelInterfaceException e) {
					throw new DeserializeException(lineNumber, e);
				}
				return convert;
			} else {
				throw new DeserializeException(lineNumber, typeName + " is not an existing IFC entity");
			}
		} else {
			return convertSimpleValue(classifier.getInstanceClass(), value);
		}
	}

	private void readEnum(String val, Record record, EStructuralFeature structuralFeature) throws DeserializeException, MetaDataException {
		if (val.equals(".T.")) {
			if (structuralFeature.getEType().getName().equals("Tristate")) {
				record.eSet(structuralFeature, getPackageMetaData().getEEnumLiteral("Tristate", "TRUE").getInstance());
			} else if (structuralFeature.getEType().getName().equals("IfcBoolean")) {
//				EClass eClass = getPackageMetaData().getEClass("IfcBoolean");
//				EObject createIfcBoolean = getPackageMetaData().create(eClass);
//				createIfcBoolean.eSet(eClass.getEStructuralFeature("WrappedValue"), );
				record.setWrapped(structuralFeature, getPackageMetaData().getEClass("IfcBoolean"), getPackageMetaData().getEEnumLiteral("Tristate", "TRUE").getInstance());
			} else if (structuralFeature.getEType() == EcorePackage.eINSTANCE.getEBoolean()) {
				record.eSet(structuralFeature, true);
			} else {
//				EClass eClass = getPackageMetaData().getEClass("IfcLogical");
//				EObject createIfcBoolean = getPackageMetaData().create(eClass);
//				createIfcBoolean.eSet(eClass.getEStructuralFeature("WrappedValue"), getPackageMetaData().getEEnumLiteral("Tristate", "TRUE").getInstance());
				record.setWrapped(structuralFeature, getPackageMetaData().getEClass("IfcLogical"), getPackageMetaData().getEEnumLiteral("Tristate", "TRUE").getInstance());
//				record.eSet(structuralFeature, createIfcBoolean);
			}
		} else if (val.equals(".F.")) {
			if (structuralFeature.getEType().getName().equals("Tristate")) {
				record.eSet(structuralFeature, getPackageMetaData().getEEnumLiteral("Tristate", "FALSE").getInstance());
			} else if (structuralFeature.getEType().getName().equals("IfcBoolean")) {
//				EClass eClass = getPackageMetaData().getEClass("IfcBoolean");
//				EObject createIfcBoolean = getPackageMetaData().create(eClass);
//				createIfcBoolean.eSet(eClass.getEStructuralFeature("WrappedValue"), getPackageMetaData().getEEnumLiteral("Tristate", "FALSE").getInstance());
				record.setWrapped(structuralFeature, getPackageMetaData().getEClass("IfcBoolean"), getPackageMetaData().getEEnumLiteral("Tristate", "FALSE").getInstance());
//				record.eSet(structuralFeature, createIfcBoolean);
			} else if (structuralFeature.getEType() == EcorePackage.eINSTANCE.getEBoolean()) {
				record.eSet(structuralFeature, false);
			} else {
//				EClass eClass = getPackageMetaData().getEClass("IfcLogical");
//				EObject createIfcBoolean = getPackageMetaData().create(eClass);
//				createIfcBoolean.eSet(eClass.getEStructuralFeature("WrappedValue"), getPackageMetaData().getEEnumLiteral("Tristate", "FALSE").getInstance());
//				record.eSet(structuralFeature, createIfcBoolean);
				record.setWrapped(structuralFeature, getPackageMetaData().getEClass("IfcLogical"), getPackageMetaData().getEEnumLiteral("Tristate", "FALSE").getInstance());
			}
		} else if (val.equals(".U.")) {
			if (structuralFeature.getEType().getName().equals("Tristate")) {
				record.eSet(structuralFeature, getPackageMetaData().getEEnumLiteral("Tristate", "UNDEFINED").getInstance());
			} else if (structuralFeature.getEType() == EcorePackage.eINSTANCE.getEBoolean()) {
				record.eUnset(structuralFeature);
			} else {
//				EClass eClass = getPackageMetaData().getEClass("IfcLogical");
//				EObject createIfcBoolean = getPackageMetaData().create(eClass);
//				createIfcBoolean.eSet(eClass.getEStructuralFeature("WrappedValue"), getPackageMetaData().getEEnumLiteral("Tristate", "UNDEFINED").getInstance());
//				record.eSet(structuralFeature, createIfcBoolean);
				record.setWrapped(structuralFeature, getPackageMetaData().getEClass("IfcLogical"), getPackageMetaData().getEEnumLiteral("Tristate", "UNDEFINED").getInstance());
			}
		} else {
			if (structuralFeature.getEType() instanceof EEnumImpl) {
				String realEnumValue = val.substring(1, val.length() - 1);
				EEnumLiteral enumValue = (((EEnumImpl) structuralFeature.getEType()).getEEnumLiteral(realEnumValue));
				if (enumValue == null) {
					throw new DeserializeException(lineNumber, "Enum type " + structuralFeature.getEType().getName() + " has no literal value '" + realEnumValue + "'");
				}
				record.eSet(structuralFeature, enumValue.getInstance());
			} else {
				throw new DeserializeException(lineNumber, "Value " + val + " indicates enum type but " + structuralFeature.getEType().getName() + " expected");
			}
		}
	}

	private void readReference(String val, Record record, EStructuralFeature structuralFeature) throws DeserializeException {
		int referenceId;
		try {
			referenceId = Integer.parseInt(val.substring(1));
		} catch (NumberFormatException e) {
			throw new DeserializeException(lineNumber, "'" + val + "' is not a valid reference");
		}
		long referredOid = converted.get(referenceId);
		if (referredOid == 0) {
			databaseSession.createOid()
			converted.put(referenceId, referredOid);
		}
		if (converted.containsKey(referenceId)) {
			record.setReference(structuralFeature, converted.get(referenceId));
		} else {
			waitingList.add(referenceId, new SingleWaitingObject(lineNumber, object, structuralFeature));
		}
	}
}