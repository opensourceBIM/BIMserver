package org.bimserver.ifc.step.deserializer;

import java.io.BufferedReader;
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
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.emf.MetaDataException;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.emf.Schema;
import org.bimserver.models.store.IfcHeader;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.plugins.deserializers.ByteProgressReporter;
import org.bimserver.plugins.deserializers.DatabaseInterface;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.StreamingDeserializer;
import org.bimserver.plugins.schema.Attribute;
import org.bimserver.plugins.schema.EntityDefinition;
import org.bimserver.plugins.schema.ExplicitAttribute;
import org.bimserver.plugins.services.BimServerClientException;
import org.bimserver.shared.ByteBufferVirtualObject;
import org.bimserver.shared.ByteBufferWrappedVirtualObject;
import org.bimserver.shared.ListWaitingVirtualObject;
import org.bimserver.shared.QueryContext;
import org.bimserver.shared.SingleWaitingVirtualObject;
import org.bimserver.shared.VirtualObject;
import org.bimserver.shared.WaitingListVirtualObject;
import org.bimserver.shared.WrappedVirtualObject;
import org.bimserver.utils.FakeClosingInputStream;
import org.bimserver.utils.StringUtils;
import org.bimserver.utils.TokenizeException;
import org.bimserver.utils.Tokenizer;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EClassImpl;
import org.eclipse.emf.ecore.impl.EEnumImpl;

import com.google.common.base.Charsets;

public abstract class IfcStepStreamingDeserializer implements StreamingDeserializer {
	private ByteProgressReporter byteProgressReporter;
	private PackageMetaData packageMetaData;
	private static final String WRAPPED_VALUE = "wrappedValue";
	private final WaitingListVirtualObject<Integer> waitingList = new WaitingListVirtualObject<Integer>();
	private Mode mode = Mode.HEADER;
	private int lineNumber;
	private Schema schema;
	
	// ExpressID -> ObjectID
	// TODO find more efficient implementation
	private final Map<Integer, Long> mappedObjects = new HashMap<>();
	private QueryContext reusable;
	private IfcHeader ifcHeader;
	
	private static MetricCollector metricCollector = new MetricCollector();
	
	private final Map<EClass, AtomicInteger> summaryMap = new TreeMap<>(new Comparator<EClass>(){

		@Override
		public int compare(EClass o1, EClass o2) {
			return o1.getName().compareTo(o2.getName());
		}});

	@Override
	public void init(PackageMetaData packageMetaData) {
		this.packageMetaData = packageMetaData;
		this.schema = packageMetaData.getSchema();
	}
	
	@Override
	public Map<EClass, Integer> getSummaryMap() {
		Map<EClass, Integer> newMap = new HashMap<>();
		for (EClass key : this.summaryMap.keySet()) {
			newMap.put(key, this.summaryMap.get(key).get());
		}
		return newMap;
	}
	
	@Override
	public void setProgressReporter(ByteProgressReporter byteProgressReporter) {
		this.byteProgressReporter = byteProgressReporter;
	}
	
	public enum Mode {
		HEADER, DATA, FOOTER, DONE
	}

	public PackageMetaData getPackageMetaData() {
		return packageMetaData;
	}
	
	@Override
	public long read(InputStream in, String filename, long fileSize, QueryContext reusable) throws DeserializeException {
		this.reusable = reusable;
		mode = Mode.HEADER;
		if (filename != null && (filename.toUpperCase().endsWith(".ZIP") || filename.toUpperCase().endsWith(".IFCZIP"))) {
			ZipInputStream zipInputStream = new ZipInputStream(in);
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
					}
				} else {
					throw new DeserializeException("Zip files must contain exactly one IFC-file, this zip-file seems to have one or more non-IFC files");
				}
			} catch (IOException e) {
				throw new DeserializeException(e);
			}
		} else {
			return read(in, fileSize);
		}
		return -1;
	}

	private void filterComments(Tokenizer tokenizer) throws TokenizeException {
		if (tokenizer.startsWith("/*")) {
			tokenizer.zoomIn("/*", "*/");
			tokenizer.readAll();
			tokenizer.zoomOut();
		}
	}
	
	private long read(InputStream inputStream, long fileSize) throws DeserializeException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, Charsets.UTF_8));
		long bytesRead = 0;
		lineNumber = 0;
		try {
			String line = reader.readLine();
			if (line == null) {
				throw new DeserializeException("Unexpected end of stream reading first line");
			}
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
				bytesRead += bytes.length;
				if (byteProgressReporter != null) {
					byteProgressReporter.progress(bytesRead);
				}

				line = reader.readLine();
				lineNumber++;
			}
//			model.getModelMetaData().setChecksum(md.digest());
			if (mode == Mode.HEADER) {
				throw new DeserializeException(lineNumber, "No valid IFC header found");
			}
			return lineNumber;
		} catch (FileNotFoundException e) {
			throw new DeserializeException(lineNumber, e);
		} catch (IOException e) {
			throw new DeserializeException(lineNumber, e);
		} catch (NoSuchAlgorithmException e) {
			throw new DeserializeException(lineNumber, e);
		}
	}

	private boolean processLine(String line) throws DeserializeException, MetaDataException, BimserverDatabaseException {
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
				try {
					waitingList.dumpIfNotEmpty();
				} catch (BimServerClientException e) {
					e.printStackTrace();
				}
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

	public IfcHeader getIfcHeader() {
		return ifcHeader;
	}
	
	private void processHeader(String line) throws DeserializeException {
		try {
			if (ifcHeader == null) {
				ifcHeader = StoreFactory.eINSTANCE.createIfcHeader();
			}
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
				if (!ifcSchemaVersion.toLowerCase().equalsIgnoreCase(schema.getHeaderName().toLowerCase())) {
					throw new DeserializeException(lineNumber, ifcSchemaVersion + " is not supported by this deserializer (" + schema.getHeaderName() + " is)");
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

	private VirtualObject newVirtualObject(EClass eClass, int lineLength) {
		return new ByteBufferVirtualObject(reusable, eClass, metricCollector.estimateRequiredBytes(lineLength));
	}

	private WrappedVirtualObject newWrappedVirtualObject(EClass eClass) {
		return new ByteBufferWrappedVirtualObject(reusable, eClass);
	}
	
	public void processRecord(String line) throws DeserializeException, MetaDataException, BimserverDatabaseException {
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
		VirtualObject object = newVirtualObject(eClass, line.length());
		
		AtomicInteger atomicInteger = summaryMap.get(eClass);
		if (atomicInteger == null) {
			summaryMap.put(eClass, new AtomicInteger(1));
		} else {
			atomicInteger.incrementAndGet();
		}
		mappedObjects.put(recordNumber, object.getOid());

		boolean openReferences = false;
		boolean hasSingleOpposites = false;
		boolean hasMultiOpposites = false;

		if (eClass != null) {
			String realData = line.substring(indexOfFirstParen + 1, indexOfLastParen);
			int lastIndex = 0;
			EntityDefinition entityBN = getPackageMetaData().getSchemaDefinition().getEntityBN(name);
			if (entityBN == null) {
				throw new DeserializeException(lineNumber, "Unknown entity " + name);
			}
			for (EStructuralFeature eStructuralFeature : eClass.getEAllStructuralFeatures()) {
				if (getPackageMetaData().useForSerialization(eClass, eStructuralFeature)) {
					if (getPackageMetaData().useForDatabaseStorage(eClass, eStructuralFeature)) {
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
							throw new DeserializeException(lineNumber, eClass.getName() + " expects " + expected + " fields, but less found (" + e.getMessage() + ")");
						}
						lastIndex = nextIndex;
						char firstChar = val.charAt(0);
						if (firstChar == '$') {
							object.eUnset(eStructuralFeature);
							if (eStructuralFeature.getEType() == EcorePackage.eINSTANCE.getEDouble()) {
								EStructuralFeature doubleStringFeature = eClass.getEStructuralFeature(eStructuralFeature.getName() + "AsString");
								object.eUnset(doubleStringFeature);
							}
						} else if (firstChar == '#') {
							if (!readReference(val, object, eStructuralFeature)) {
								openReferences = true;
							}
						} else if (firstChar == '.') {
							readEnum(val, object, eStructuralFeature);
						} else if (firstChar == '(') {
							if (!readList(val, object, eStructuralFeature)) {
								openReferences = true;
							}
						} else if (firstChar == '*') {
							object.eUnset(eStructuralFeature);
						} else {
							if (!eStructuralFeature.isMany()) {
								object.setAttribute(eStructuralFeature, convert(eStructuralFeature.getEType(), val));
								if (eStructuralFeature.getEType() == EcorePackage.eINSTANCE.getEDouble()) {
									EStructuralFeature doubleStringFeature = eClass.getEStructuralFeature(eStructuralFeature.getName() + "AsString");
									object.setAttribute(doubleStringFeature, val);
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
				} else {
					if (getPackageMetaData().useForDatabaseStorage(eClass, eStructuralFeature)) {
						if (eStructuralFeature instanceof EReference && getPackageMetaData().isInverse((EReference) eStructuralFeature)) {
							EReference eReference = (EReference)eStructuralFeature;
							if (eReference.isMany()) {
								hasMultiOpposites = true;
							} else {
								hasSingleOpposites = true;
							}
							object.eUnset(eStructuralFeature);
						} else {
							if (eStructuralFeature.getEAnnotation("asstring") == null) {
								object.eUnset(eStructuralFeature);
							}
						}
					}
				}
			}
			
			// Other objects waiting for me?
			if (waitingList.containsKey(recordNumber)) {
				waitingList.updateNode(recordNumber, eClass, object);
			}

			if (!openReferences) {
				int nrBytes = getDatabaseInterface().save(object);
				metricCollector.collect(line.length(), nrBytes);
			}
		} else {
			throw new DeserializeException(lineNumber, name + " is not a known entity");
		}
	}
	
	private DatabaseInterface getDatabaseInterface() {
		return reusable.getDatabaseInterface();
	}

	private boolean readList(String val, VirtualObject object, EStructuralFeature structuralFeature) throws DeserializeException, MetaDataException, BimserverDatabaseException {
		int index = 0;
		if (!structuralFeature.isMany()) {
			throw new DeserializeException(lineNumber, "Field " + structuralFeature.getName() + " of " + structuralFeature.getEContainingClass().getName() + " is no aggregation");
		}
		boolean isDouble = structuralFeature.getEType() == EcorePackage.eINSTANCE.getEDouble();
		EStructuralFeature doubleStringFeature = null;
		if (isDouble) {
			doubleStringFeature = structuralFeature.getEContainingClass().getEStructuralFeature(structuralFeature.getName() + "AsString");
			if (doubleStringFeature == null) {
				throw new DeserializeException(lineNumber, "Field not found: " + structuralFeature.getName() + "AsString");
			}
		}
		String realData = val.substring(1, val.length() - 1);
		int lastIndex = 0;
		object.startList(structuralFeature);
		// TODO not always instantiate
		List<String> doubles = new ArrayList<>();
		boolean complete = true;
		while (lastIndex != realData.length() + 1) {
			int nextIndex = StringUtils.nextString(realData, lastIndex);
			String stringValue = realData.substring(lastIndex, nextIndex - 1).trim();
			lastIndex = nextIndex;
			if (stringValue.length() > 0) {
				if (stringValue.charAt(0) == '#') {
					Integer referenceId = Integer.parseInt(stringValue.substring(1));
					if (mappedObjects.containsKey(referenceId)) {
						Long referencedOid = mappedObjects.get(referenceId);
						if (referencedOid != null) {
							EClass referenceEClass = getDatabaseInterface().getEClassForOid(referencedOid);
							if (((EClass) structuralFeature.getEType()).isSuperTypeOf(referenceEClass)) {
								// TODO unique checking?
								object.setListItemReference(structuralFeature, index, referenceEClass, referencedOid, -1);
							} else {
								throw new DeserializeException(lineNumber, referenceEClass.getName() + " cannot be stored in " + structuralFeature.getName());
							}
						}
					} else {
						int pos = object.reserveSpaceForListReference();
						waitingList.add(referenceId, new ListWaitingVirtualObject(lineNumber, object, structuralFeature, index, pos));
						complete = false;
					}
				} else if (stringValue.charAt(0) == '(') {
					// Two dimensional list
					VirtualObject newObject = newVirtualObject((EClass) structuralFeature.getEType(), stringValue.length());
					readList(stringValue, newObject, newObject.eClass().getEStructuralFeature("List"));
					// TODO unique?
					object.setListItemReference(structuralFeature, index, newObject.eClass(), newObject.getOid(), -1);
				} else {
					Object convert = convert(structuralFeature.getEType(), stringValue);
					if (convert != null) {
						object.setListItem(structuralFeature, index, convert);
						if (isDouble) {
							doubles.add(stringValue);
						}
					}
				}
			}
			index++;
		}
		object.endList();
		// TODO make more efficient
		if (isDouble) {
			object.startList(doubleStringFeature);
			int i=0;
			for (String d : doubles) {
				object.setListItem(doubleStringFeature, i++, d);
			}
			object.endList();
		}
		return complete;
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
					throw new DeserializeException(lineNumber, "Incorrect double floating point value: " + value, e);
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

	private Object convert(EClassifier classifier, String value) throws DeserializeException, MetaDataException, BimserverDatabaseException {
		if (classifier != null) {
			if (classifier instanceof EClassImpl) {
				if (null != ((EClassImpl) classifier).getEStructuralFeature(WRAPPED_VALUE)) {
					WrappedVirtualObject newObject = newWrappedVirtualObject((EClass) classifier);
					Class<?> instanceClass = newObject.eClass().getEStructuralFeature(WRAPPED_VALUE).getEType().getInstanceClass();
					if (value.equals("")) {

					} else {
						if (instanceClass == Integer.class || instanceClass == int.class) {
							try {
								newObject.setAttribute(newObject.eClass().getEStructuralFeature(WRAPPED_VALUE), Integer.parseInt(value));
							} catch (NumberFormatException e) {
								throw new DeserializeException(lineNumber, value + " is not a valid integer value");
							}
						} else if (instanceClass == Long.class || instanceClass == long.class) {
							newObject.setAttribute(newObject.eClass().getEStructuralFeature(WRAPPED_VALUE), Long.parseLong(value));
						} else if (instanceClass == Boolean.class || instanceClass == boolean.class) {
							newObject.setAttribute(newObject.eClass().getEStructuralFeature(WRAPPED_VALUE), value.equals(".T."));
						} else if (instanceClass == Double.class || instanceClass == double.class) {
							try {
								newObject.setAttribute(newObject.eClass().getEStructuralFeature(WRAPPED_VALUE), Double.parseDouble(value));
							} catch (NumberFormatException e) {
								throw new DeserializeException(lineNumber, value + " is not a valid double floating point number");
							}
							newObject.setAttribute(newObject.eClass().getEStructuralFeature(WRAPPED_VALUE + "AsString"), value);
						} else if (instanceClass == String.class) {
							newObject.setAttribute(newObject.eClass().getEStructuralFeature(WRAPPED_VALUE), readString(value));
						} else if (instanceClass.getSimpleName().equals("Tristate")) {
							Object tristate = null;
							if (value.equals(".T.")) {
								tristate = getPackageMetaData().getEEnumLiteral("Tristate", "TRUE");
							} else if (value.equals(".F.")) {
								tristate = getPackageMetaData().getEEnumLiteral("Tristate", "FALSE");
							} else if (value.equals(".U.")) {
								tristate = getPackageMetaData().getEEnumLiteral("Tristate", "UNDEFINED");
							}
							newObject.setAttribute(newObject.eClass().getEStructuralFeature(WRAPPED_VALUE), tristate);
						}
					}
					return newObject;
				} else {
					return processInline(classifier, value);
				}
			} else if (classifier instanceof EDataType) {
				return convertSimpleValue(classifier.getInstanceClass(), value);
			}
		}
		return null;
	}

	private Object processInline(EClassifier classifier, String value) throws DeserializeException, MetaDataException, BimserverDatabaseException {
		if (value.indexOf("(") != -1) {
			String typeName = value.substring(0, value.indexOf("(")).trim();
			String v = value.substring(value.indexOf("(") + 1, value.length() - 1);
			EClassifier eClassifier = getPackageMetaData().getEClassifierCaseInsensitive(typeName);
			if (eClassifier instanceof EClass) {
				return convert(eClassifier, v);
			} else {
				throw new DeserializeException(lineNumber, typeName + " is not an existing IFC entity");
			}
		} else {
			return convertSimpleValue(classifier.getInstanceClass(), value);
		}
	}

	private void readEnum(String val, VirtualObject object, EStructuralFeature structuralFeature) throws DeserializeException, MetaDataException, BimserverDatabaseException {
		if (val.equals(".T.")) {
			if (structuralFeature.getEType().getName().equals("Tristate")) {
				object.setAttribute(structuralFeature, getPackageMetaData().getEEnumLiteral("Tristate", "TRUE").getInstance());
			} else if (structuralFeature.getEType().getName().equals("IfcBoolean")) {
				EClass eClass = getPackageMetaData().getEClass("IfcBoolean");
				VirtualObject createIfcBoolean = newVirtualObject(eClass, val.length());
				createIfcBoolean.setAttribute(eClass.getEStructuralFeature("WrappedValue"), getPackageMetaData().getEEnumLiteral("Tristate", "TRUE").getInstance());
				object.setAttribute(structuralFeature, createIfcBoolean);
			} else if (structuralFeature.getEType() == EcorePackage.eINSTANCE.getEBoolean()) {
				object.setAttribute(structuralFeature, true);
			} else {
				EClass eClass = getPackageMetaData().getEClass("IfcLogical");
				VirtualObject createIfcBoolean = newVirtualObject(eClass, val.length());
				createIfcBoolean.setAttribute(eClass.getEStructuralFeature("WrappedValue"), getPackageMetaData().getEEnumLiteral("Tristate", "TRUE").getInstance());
				object.setAttribute(structuralFeature, createIfcBoolean);
			}
		} else if (val.equals(".F.")) {
			if (structuralFeature.getEType().getName().equals("Tristate")) {
				object.setAttribute(structuralFeature, getPackageMetaData().getEEnumLiteral("Tristate", "FALSE").getInstance());
			} else if (structuralFeature.getEType().getName().equals("IfcBoolean")) {
				EClass eClass = getPackageMetaData().getEClass("IfcBoolean");
				VirtualObject createIfcBoolean = newVirtualObject(eClass, val.length());
				createIfcBoolean.setAttribute(eClass.getEStructuralFeature("WrappedValue"), getPackageMetaData().getEEnumLiteral("Tristate", "FALSE").getInstance());
				object.setAttribute(structuralFeature, createIfcBoolean);
			} else if (structuralFeature.getEType() == EcorePackage.eINSTANCE.getEBoolean()) {
				object.setAttribute(structuralFeature, false);
			} else {
				EClass eClass = getPackageMetaData().getEClass("IfcLogical");
				VirtualObject createIfcBoolean = newVirtualObject(eClass, val.length());
				createIfcBoolean.setAttribute(eClass.getEStructuralFeature("WrappedValue"), getPackageMetaData().getEEnumLiteral("Tristate", "FALSE").getInstance());
				object.setAttribute(structuralFeature, createIfcBoolean);
			}
		} else if (val.equals(".U.")) {
			if (structuralFeature.getEType().getName().equals("Tristate")) {
				object.setAttribute(structuralFeature, getPackageMetaData().getEEnumLiteral("Tristate", "UNDEFINED").getInstance());
			} else if (structuralFeature.getEType() == EcorePackage.eINSTANCE.getEBoolean()) {
				object.eUnset(structuralFeature);
			} else {
				EClass eClass = getPackageMetaData().getEClass("IfcLogical");
				VirtualObject createIfcBoolean = newVirtualObject(eClass, val.length());
				createIfcBoolean.setAttribute(eClass.getEStructuralFeature("WrappedValue"), getPackageMetaData().getEEnumLiteral("Tristate", "UNDEFINED").getInstance());
				object.setAttribute(structuralFeature, createIfcBoolean);
			}
		} else {
			if (structuralFeature.getEType() instanceof EEnumImpl) {
				String realEnumValue = val.substring(1, val.length() - 1);
				EEnumLiteral enumValue = (((EEnumImpl) structuralFeature.getEType()).getEEnumLiteral(realEnumValue));
				if (enumValue == null) {
					throw new DeserializeException(lineNumber, "Enum type " + structuralFeature.getEType().getName() + " has no literal value '" + realEnumValue + "'");
				}
				object.setAttribute(structuralFeature, enumValue.getInstance());
			} else {
				throw new DeserializeException(lineNumber, "Value " + val + " indicates enum type but " + structuralFeature.getEType().getName() + " expected");
			}
		}
	}

	private boolean readReference(String val, VirtualObject object, EStructuralFeature structuralFeature) throws DeserializeException, BimserverDatabaseException {
		try {
			int referenceId = Integer.parseInt(val.substring(1));
			if (mappedObjects.containsKey(referenceId)) {
				object.setReference(structuralFeature, mappedObjects.get(referenceId), -1);
				return true;
			} else {
				int pos = object.reserveSpaceForReference(structuralFeature);
				waitingList.add(referenceId, new SingleWaitingVirtualObject(lineNumber, object, structuralFeature, pos));
				return false;
			}
		} catch (NumberFormatException e) {
			throw new DeserializeException(lineNumber, "'" + val + "' is not a valid reference");
		}
	}
}