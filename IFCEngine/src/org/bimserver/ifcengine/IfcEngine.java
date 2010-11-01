//package org.bimserver.ifcengine;
//
//import java.io.File;
//import java.io.IOException;
//import java.io.InputStream;
//import java.nio.ByteBuffer;
//import java.util.HashSet;
//import java.util.Set;
//
//import org.bimserver.database.store.Clash;
//import org.bimserver.database.store.StoreFactory;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.xvolks.jnative.JNative;
//import org.xvolks.jnative.Type;
//import org.xvolks.jnative.exceptions.NativeException;
//import org.xvolks.jnative.pointers.Pointer;
//import org.xvolks.jnative.pointers.memory.MemoryBlockFactory;
//import org.xvolks.jnative.util.Callback;
//
///**
// * @author Peter Willems (TNO)
// * 
// */
//public class IfcEngine {
//	public static final int sdaiADB = 1;
//	public static final int sdaiAGGR = sdaiADB + 1;
//	public static final int sdaiBINARY = sdaiAGGR + 1;
//	public static final int sdaiBOOLEAN = sdaiBINARY + 1;
//	public static final int sdaiENUM = sdaiBOOLEAN + 1;
//	public static final int sdaiINSTANCE = sdaiENUM + 1;
//	public static final int sdaiINTEGER = sdaiINSTANCE + 1;
//	public static final int sdaiLOGICAL = sdaiINTEGER + 1;
//	public static final int sdaiREAL = sdaiLOGICAL + 1;
//	public static final int sdaiSTRING = sdaiREAL + 1;
//
//	public static final int D3DFVF_XYZ = 0x002;
//	public static final int D3DFVF_XYZRHW = 0x004;
//	public static final int D3DFVF_NORMAL = 0x010;
//	public static final int D3DFVF_PSIZE = 0x020;
//	public static final int D3DFVF_DIFFUSE = 0x040;
//	public static final int D3DFVF_SPECULAR = 0x080;
//	public static final int D3DFVF_TEX1 = 0x100;
//
//	public static final int LINE_REP_MODE = 0;
//	public static final int COMPLEX_OBJECT_REP_MODE = 1;
//	public static final int BOUNDING_BOX_REP_MODE = 2;
//
//	public static final int IFCWINDOW = 1;
//	public static final int IFCANNOTATION = IFCWINDOW + 1;
//	public static final int IFCBEAM = IFCANNOTATION + 1;
//	public static final int IFCBUILDINGELEMENTCOMPONENT = IFCBEAM + 1;
//	public static final int IFCSTRUCTURALCURVEMEMBER = IFCBUILDINGELEMENTCOMPONENT + 1;
//	public static final int IFCSTRUCTURALSURFACEMEMBER = IFCSTRUCTURALCURVEMEMBER + 1;
//	public static final int IFCBUILDINGELEMENTPROXY = IFCSTRUCTURALSURFACEMEMBER + 1;
//	public static final int IFCCOLUMN = IFCBUILDINGELEMENTPROXY + 1;
//	public static final int IFCCOVERING = IFCCOLUMN + 1;
//	public static final int IFCCURTAINWALL = IFCCOVERING + 1;
//	public static final int IFCDOOR = IFCCURTAINWALL + 1;
//	public static final int IFCELEMENTASSEMBLY = IFCDOOR + 1;
//	public static final int IFCFASTENER = IFCELEMENTASSEMBLY + 1;
//	public static final int IFCFOOTING = IFCFASTENER + 1;
//	public static final int IFCMECHANICALFASTENER = IFCFOOTING + 1;
//	public static final int IFCMEMBER = IFCMECHANICALFASTENER + 1;
//	public static final int IFCPILE = IFCMEMBER + 1;
//	public static final int IFCPLATE = IFCPILE + 1;
//	public static final int IFCRAILING = IFCPLATE + 1;
//	public static final int IFCRAMP = IFCRAILING + 1;
//	public static final int IFCRAMPFLIGHT = IFCRAMP + 1;
//	public static final int IFCROOF = IFCRAMPFLIGHT + 1;
//	public static final int IFCSLAB = IFCROOF + 1;
//	public static final int IFCSTAIR = IFCSLAB + 1;
//	public static final int IFCSTAIRFLIGHT = IFCSTAIR + 1;
//	public static final int IFCSPACE = IFCSTAIRFLIGHT + 1;
//	public static final int IFCWALL = IFCSPACE + 1;
//	public static final int IFCWALLSTANDARDCASE = IFCWALL + 1;
//	public static final int IFCAIRTERMINAL = IFCWALLSTANDARDCASE + 1;
//	public static final int IFCDISTRIBUTIONELEMENT = IFCAIRTERMINAL + 1;
//	public static final int IFCENERGYCONVERSIONDEVICE = IFCDISTRIBUTIONELEMENT + 1;
//	public static final int IFCFURNISHINGELEMENT = IFCENERGYCONVERSIONDEVICE + 1;
//	public static final int IFCFLOWCONTROLLER = IFCFURNISHINGELEMENT + 1;
//	public static final int IFCFLOWFITTING = IFCFLOWCONTROLLER + 1;
//	public static final int IFCFLOWMOVINGDEVICE = IFCFLOWFITTING + 1;
//	public static final int IFCFLOWSEGMENT = IFCFLOWMOVINGDEVICE + 1;
//	public static final int IFCFLOWSTORAGEDEVICE = IFCFLOWSEGMENT + 1;
//	public static final int IFCFLOWTERMINAL = IFCFLOWSTORAGEDEVICE + 1;
//	public static final int IFCFLOWTREATMENTDEVICE = IFCFLOWTERMINAL + 1;
//	public static final int IFCGRID = IFCFLOWTREATMENTDEVICE + 1;
//
//	public static final String[] IFC_ENTITY_NAMES = { "Unknown", "IFCWINDOW", "IFCANNOTATION", "IFCBEAM", "IFCBUILDINGELEMENTCOMPONENT", "IFCSTRUCTURALCURVEMEMBER",
//			"IFCSTRUCTURALSURFACEMEMBER", "IFCBUILDINGELEMENTPROXY", "IFCCOLUMN", "IFCCOVERING", "IFCCURTAINWALL", "IFCDOOR", "IFCELEMENTASSEMBLY", "IFCFASTENER", "IFCFOOTING",
//			"IFCMECHANICALFASTENER", "IFCMEMBER", "IFCPILE", "IFCPLATE", "IFCRAILING", "IFCRAMP", "IFCRAMPFLIGHT", "IFCROOF", "IFCSLAB", "IFCSTAIR", "IFCSTAIRFLIGHT", "IFCSPACE",
//			"IFCWALL", "IFCWALLSTANDARDCASE", "IFCAIRTERMINAL", "IFCDISTRIBUTIONELEMENT", "IFCENERGYCONVERSIONDEVICE", "IFCFURNISHINGELEMENT", "IFCFLOWCONTROLLER",
//			"IFCFLOWFITTING", "IFCFLOWMOVINGDEVICE", "IFCFLOWSEGMENT", "IFCFLOWSTORAGEDEVICE", "IFCFLOWTERMINAL", "IFCFLOWTREATMENTDEVICE", "IFCGRID" };
//
//	public static final String[] IFC_ENTITY_DESCRIPTIONS = { "Unknown", "Window", "Annotation", "Beam", "Building element component", "Structural curve member",
//			"Structural surface member", "Building element proxy", "Column", "Covering", "Curtain wall", "Door", "Element assembly", "Fastener", "Footing", "Mechanical fastener",
//			"Member", "Pile", "Plate", "Railing", "Ramp", "Ramp flight", "Roof", "Slab", "Stair", "Stair flight", "Space", "Wall", "Wall standard case", "Air terminal",
//			"Distribution element", "Energy conversion device", "Furnishing element", "Flow controller", "Flow fitting", "Flow moving device", "Flow segment",
//			"Flow storage device", "Flow terminal", "Flow treatment device", "Grid" };
//
//	private static final String IFC_ENGINE_DLL_32 = "32" + File.separator + "IFCClashEngine.dll";
//	private static final String IFC_ENGINE_DLL_64 = "64" + File.separator + "IFCEngine.dll";
//	private static final String IFC_ENGINE_SO_32 = "32" + File.separator + "libifcengine_linux.so";
//	private static final String IFC_ENGINE_SO_64 = "64" + File.separator + "libifcengine_linux.so";
//
//	private final String libraryPath;
//	private static final Logger LOGGER = LoggerFactory.getLogger(IfcEngine.class);
//
//	public IfcEngine(File nativeBaseDir) {
//		System.setProperty("jnative.loadNative", "manual");
//		try {
//			File jnativeFile = new File(nativeBaseDir, JNative.DLL_NAME);
//			System.load(jnativeFile.getAbsolutePath());
//			LOGGER.info("Successfully loaded " + jnativeFile);
//		} catch (UnsatisfiedLinkError e) {
//			// Not throwing another exception because we assume it's this
//			// message:
//			// 'already loaded in another classloader'
//			LOGGER.warn(e.getMessage());
//		}
//		if (System.getProperty("os.name").startsWith("Windows")) {
//			if (System.getProperty("sun.arch.data.model").equals("32")) {
//				libraryPath = nativeBaseDir.getAbsolutePath() + File.separator + IFC_ENGINE_DLL_32;
//			} else if (System.getProperty("sun.arch.data.model").equals("64")) {
//				libraryPath = nativeBaseDir.getAbsolutePath() + File.separator + IFC_ENGINE_DLL_64;
//			} else {
//				throw new RuntimeException("Unknown JVM data model");
//			}
//		} else {
//			if (System.getProperty("sun.arch.data.model").equals("32")) {
//				libraryPath = nativeBaseDir.getAbsolutePath() + File.separator + IFC_ENGINE_SO_32;
//			} else if (System.getProperty("sun.arch.data.model").equals("64")) {
//				libraryPath = nativeBaseDir.getAbsolutePath() + File.separator + IFC_ENGINE_SO_64;
//			} else {
//				throw new RuntimeException("Unknown JVM data model");
//			}
//		}
//		LOGGER.info("Using " + libraryPath + " as IFCEngine");
//	}
//
//	public Pointer pResponseBuffer;
//
//	public class StreamCallback implements Callback {
//
//		private int myAddress = -1;
//		private final InputStream in;
//
//		public StreamCallback(InputStream in) {
//			this.in = in;
//		}
//
//		@Override
//		public int callback(long[] arg0) {
//			try {
//				return in.read(pResponseBuffer.getMemory());
//			} catch (NativeException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			return -1;
//		}
//
//		@Override
//		public int getCallbackAddress() throws NativeException {
//			if (myAddress == -1) {
//				myAddress = JNative.createCallback(0, this);
//			}
//			return myAddress;
//		}
//	}
//
//	private JNative assignCallback;
//
//	public void loadFromInputStream(InputStream in) {
//		try {
//			pResponseBuffer = new Pointer(MemoryBlockFactory.createMemoryBlock(1024));
//			StreamCallback streamCallback = new StreamCallback(in);
//			int callbackAddress = streamCallback.getCallbackAddress();
//			if (assignCallback == null) {
//				assignCallback = new JNative(libraryPath, "sdaiOpenModelByStream");
//			}
//			assignCallback.setParameter(0, callbackAddress);
//			assignCallback.setParameter(1, pResponseBuffer);
//			assignCallback.invoke();
//		} catch (NativeException e1) {
//			e1.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		}
//	}
//
//	private JNative nativeSetStringUnicode;
//
//	/**
//	 * @param unicode
//	 * @return
//	 * @throws Exception
//	 */
//	public int setStringUnicode(boolean unicode) throws Exception {
//		int returnValue = 0;
//		if (nativeSetStringUnicode == null) {
//			nativeSetStringUnicode = new JNative(libraryPath, "setStringUnicode");
//		}
//		nativeSetStringUnicode.setRetVal(Type.INT);
//		nativeSetStringUnicode.setParameter(0, unicode ? 1 : 0);
//		nativeSetStringUnicode.invoke();
//		returnValue = nativeSetStringUnicode.getRetValAsInt();
//		return returnValue;
//
//		// int returnValue = 0;
//		// jn = new JNative(libraryPath, "setStringUnicode");
//		// jn.setRetVal(Type.INT);
//		// jn.setParameter(0, unicode ? 1 : 0);
//		// jn.invoke();
//		// returnValue = jn.getRetValAsInt();
//		// return returnValue;
//	}
//
//	private JNative nativeSdaiOpenModelBN;
//
//	/**
//	 * Opens a model and its belonging schema. This functions differs slightly
//	 * from the official SDAI definition because the IFC Engine DLL is able to
//	 * open repository, model and schema in 1 call. It returns the modelID or
//	 * zero if the model could not be created.
//	 * 
//	 * @param repository
//	 *            Unused, the IFC Engine DLL currently (8 March 2006) only
//	 *            supports exactly 1 repository for each model.
//	 * @param fileName
//	 *            String containing the name and path of the file that will be
//	 *            opened.
//	 * @param schemaName
//	 *            String containing the name of the schema belonging to the file
//	 *            mentioned in fileName. If this string is referring to a
//	 *            non-existing file no schema will be loaded, preferred use is
//	 *            in that case '' (empty string). If this pointer is empty the
//	 *            default schema for this file is loaded (using the knowledge of
//	 *            the IFC Engine Viewer).
//	 * 
//	 * @return modelID
//	 * @throws Exception
//	 */
//	public int sdaiOpenModelBN(int repository, String fileName, String schemaName) throws Exception {
//		int returnValue = 0;
//		if (nativeSdaiOpenModelBN == null) {
//			nativeSdaiOpenModelBN = new JNative(libraryPath, "sdaiOpenModelBN");
//		}
//		nativeSdaiOpenModelBN.setRetVal(Type.INT);
//		nativeSdaiOpenModelBN.setParameter(0, repository);
//		nativeSdaiOpenModelBN.setParameter(1, fileName);
//		nativeSdaiOpenModelBN.setParameter(2, schemaName);
//		nativeSdaiOpenModelBN.invoke();
//		returnValue = nativeSdaiOpenModelBN.getRetValAsInt();
//		return returnValue;
//
//		// int returnValue = 0;
//		// jn = new JNative(libraryPath, "sdaiOpenModelBN");
//		// jn.setRetVal(Type.INT);
//		// jn.setParameter(0, repository);
//		// jn.setParameter(1, fileName);
//		// jn.setParameter(2, schemaName);
//		// jn.invoke();
//		// returnValue = jn.getRetValAsInt();
//		// return returnValue;
//	}
//
//	private JNative nativeSdaiCreateModelBN;
//
//	/**
//	 * Creates a new model instantiated from a specific schema. It returns the
//	 * modelID, zero if the model could not be created.
//	 * 
//	 * @param repository
//	 *            Unused, the IFC Engine DLL currently (8 March 2006) only
//	 *            supports exactly 1 repository for each model.
//	 * @param fileName
//	 *            String containing the name and path of the file that will be
//	 *            created.
//	 * @param schemaName
//	 *            String containing the name of the schema belonging to the file
//	 *            mentioned in fileName. If this string is referring to a
//	 *            non-existing file no schema will be loaded, preferred use is
//	 *            in that case '' (empty string). If this pointer is empty the
//	 *            default schema for this file is loaded (using the knowledge of
//	 *            the IFC Engine Viewer).
//	 * 
//	 * @return modelID
//	 */
//	public int sdaiCreateModelBN(int repository, String fileName, String schemaName) throws Exception {
//		int returnValue = 0;
//		if (nativeSdaiCreateModelBN == null) {
//			nativeSdaiCreateModelBN = new JNative(libraryPath, "sdaiCreateModelBN");
//		}
//		nativeSdaiCreateModelBN.setRetVal(Type.INT);
//		nativeSdaiCreateModelBN.setParameter(0, repository);
//		nativeSdaiCreateModelBN.setParameter(1, fileName);
//		nativeSdaiCreateModelBN.setParameter(2, schemaName);
//		nativeSdaiCreateModelBN.invoke();
//		returnValue = nativeSdaiCreateModelBN.getRetValAsInt();
//		return returnValue;
//
//		// int returnValue = 0;
//		// jn = new JNative(libraryPath, "sdaiCreateModelBN");
//		// jn.setRetVal(Type.INT);
//		// jn.setParameter(0, repository);
//		// jn.setParameter(1, fileName);
//		// jn.setParameter(2, schemaName);
//		// jn.invoke();
//		// returnValue = jn.getRetValAsInt();
//		// return returnValue;
//	}
//
//	private JNative nativeSdaiSaveModelBN;
//
//	/**
//	 * Saves an 'in memory' model.
//	 * 
//	 * @param repository
//	 *            Unused, the IFC Engine DLL currently (8 March 2006) only
//	 *            supports exactly 1 repository for each model
//	 * @param fileName
//	 *            String containing the name and path of the file that will be
//	 *            saved.
//	 * @throws Exception
//	 */
//	public void sdaiSaveModelBN(int repository, String fileName) throws Exception {
//		if (nativeSdaiSaveModelBN == null) {
//			nativeSdaiSaveModelBN = new JNative(libraryPath, "sdaiSaveModelBN");
//		}
//		nativeSdaiSaveModelBN.setParameter(0, repository);
//		nativeSdaiSaveModelBN.setParameter(1, fileName);
//		nativeSdaiSaveModelBN.invoke();
//
//		// jn = new JNative(libraryPath, "sdaiSaveModelBN");
//		// jn.setParameter(0, repository);
//		// jn.setParameter(1, fileName);
//		// jn.invoke();
//	}
//
//	private JNative nativeSdaiSaveModelAsXmlBN;
//
//	/**
//	 * @param model
//	 * @param fileName
//	 * @throws Exception
//	 */
//	public void sdaiSaveModelAsXmlBN(int model, String fileName) throws Exception {
//		if (nativeSdaiSaveModelAsXmlBN == null) {
//			nativeSdaiSaveModelAsXmlBN = new JNative(libraryPath, "sdaiSaveModelAsXmlBN");
//		}
//		nativeSdaiSaveModelAsXmlBN.setParameter(0, model);
//		nativeSdaiSaveModelAsXmlBN.setParameter(1, fileName);
//		nativeSdaiSaveModelAsXmlBN.invoke();
//
//		// jn = new JNative(libraryPath, "sdaiSaveModelAsXmlBN");
//		// jn.setParameter(0, model);
//		// jn.setParameter(1, fileName);
//		// jn.invoke();
//	}
//
//	private JNative nativeSdaiCloseModel;
//
//	/**
//	 * Closes a SPFF (possibly IFC) file. The file will NOT be saved.
//	 * 
//	 * @param model
//	 *            ModelID referring to the model.
//	 * @throws Exception
//	 */
//	public void sdaiCloseModel(int model) throws Exception {
//		if (nativeSdaiCloseModel == null) {
//			nativeSdaiCloseModel = new JNative(libraryPath, "sdaiCloseModel");
//		}
//		nativeSdaiCloseModel.setParameter(0, model);
//		nativeSdaiCloseModel.invoke();
//
//		// jn = new JNative(libraryPath, "sdaiCloseModel");
//		// jn.setParameter(0, model);
//		// jn.invoke();
//	}
//
//	private JNative nativeEngiGetAggrElement;
//
//	/**
//	 * Returns a data field in the actual aggregate element.
//	 * 
//	 * @param aggregate
//	 * @param elementIndex
//	 * @param valueType
//	 * @return
//	 */
//	public Object engiGetAggrElement(int aggregate, int elementIndex, int valueType) throws Exception {
//		if (nativeEngiGetAggrElement == null) {
//			nativeEngiGetAggrElement = new JNative(libraryPath, "engiGetAggrElement");
//		}
//		nativeEngiGetAggrElement.setParameter(0, aggregate);
//		nativeEngiGetAggrElement.setParameter(1, elementIndex);
//		nativeEngiGetAggrElement.setParameter(2, valueType);
//		Pointer ptr = new Pointer(MemoryBlockFactory.createMemoryBlock(8));
//		nativeEngiGetAggrElement.setParameter(3, ptr);
//
//		nativeEngiGetAggrElement.invoke();
//
//		Object returnValue = getReturnValue(ptr, valueType);
//		ptr.dispose();
//		return returnValue;
//
//		// jn = new JNative(libraryPath, "engiGetAggrElement");
//		//
//		// jn.setParameter(0, aggregate);
//		// jn.setParameter(1, elementIndex);
//		// jn.setParameter(2, valueType);
//		// Pointer ptr = new Pointer(MemoryBlockFactory.createMemoryBlock(8));
//		// jn.setParameter(3, ptr);
//		//
//		// jn.invoke();
//		//
//		// Object returnValue = getReturnValue(ptr, valueType);
//		// ptr.dispose();
//		// return returnValue;
//	}
//
//	private Object getReturnValue(Pointer ptr, int valueType) throws NativeException {
//		Object returnValue = null;
//		switch (valueType) {
//		case sdaiADB:
//		case sdaiAGGR:
//		case sdaiBINARY:
//		case sdaiENUM:
//		case sdaiINSTANCE:
//		case sdaiINTEGER:
//		case sdaiLOGICAL:
//			int intValue = ptr.getAsInt(0);
//			returnValue = Integer.valueOf(intValue);
//			break;
//		case sdaiBOOLEAN:
//			int boolValue = ptr.getAsInt(0);
//			returnValue = boolValue == 0 ? false : true;
//			break;
//		case sdaiREAL:
//			double doubleValue = ptr.getAsDouble(0);
//			returnValue = Double.valueOf(doubleValue);
//			break;
//		case sdaiSTRING:
//			int addr = ptr.getAsInt(0);
//			if (addr > 0) {
//				byte[] buffer = JNative.getMemory(addr, 256);
//				StringBuffer str = new StringBuffer();
//				for (int index = 0; buffer[index] != 0 && index < buffer.length; index++) {
//					str.append((char) buffer[index]);
//				}
//				returnValue = str.toString();
//			}
//			break;
//		}
//		return returnValue;
//	}
//
//	private JNative nativeEngiGetInstanceMetaInfo;
//
//	/**
//	 * @param instance
//	 * @param localId
//	 * @param className
//	 * @param classNameUC
//	 * @return
//	 * @throws Exception
//	 */
//	public int engiGetInstanceMetaInfo(int instance, int localId, int className, int classNameUC) throws Exception {
//		int returnValue = 0;
//		if (nativeEngiGetInstanceMetaInfo == null) {
//			nativeEngiGetInstanceMetaInfo = new JNative(libraryPath, "engiGetInstanceMetaInfo");
//		}
//		nativeEngiGetInstanceMetaInfo.setRetVal(Type.INT);
//		nativeEngiGetInstanceMetaInfo.setParameter(0, instance);
//		nativeEngiGetInstanceMetaInfo.setParameter(1, localId);
//		nativeEngiGetInstanceMetaInfo.setParameter(2, className);
//		nativeEngiGetInstanceMetaInfo.setParameter(3, classNameUC);
//		nativeEngiGetInstanceMetaInfo.invoke();
//		returnValue = nativeEngiGetInstanceMetaInfo.getRetValAsInt();
//		return returnValue;
//
//		// int returnValue = 0;
//		// jn = new JNative(libraryPath, "engiGetInstanceMetaInfo");
//		// jn.setRetVal(Type.INT);
//		// jn.setParameter(0, instance);
//		// jn.setParameter(1, localId);
//		// jn.setParameter(2, className);
//		// jn.setParameter(3, classNameUC);
//		// jn.invoke();
//		// returnValue = jn.getRetValAsInt();
//		// return returnValue;
//	}
//
//	private JNative nativeEngiGetInstanceLocalId;
//
//	/**
//	 * Returns the line number as used for this instance in the SPFF file.
//	 * 
//	 * @param instance
//	 *            A numeric instanceID that uniquely identifies an instance.
//	 * @return line number
//	 * @throws Exception
//	 */
//	public int engiGetInstanceLocalId(int instance) throws Exception {
//		int returnValue = 0;
//		if (nativeEngiGetInstanceLocalId == null) {
//			nativeEngiGetInstanceLocalId = new JNative(libraryPath, "engiGetInstanceLocalId");
//		}
//		nativeEngiGetInstanceLocalId.setRetVal(Type.INT);
//		nativeEngiGetInstanceLocalId.setParameter(0, instance);
//		nativeEngiGetInstanceLocalId.invoke();
//		returnValue = nativeEngiGetInstanceLocalId.getRetValAsInt();
//		return returnValue;
//		// int returnValue = 0;
//		// jn = new JNative(libraryPath, "engiGetInstanceLocalId");
//		// jn.setRetVal(Type.INT);
//		// jn.setParameter(0, instance);
//		// jn.invoke();
//		// returnValue = jn.getRetValAsInt();
//		// return returnValue;
//	}
//
//	private JNative nativeEngiGetInstanceClassInfo;
//
//	/**
//	 * Returns the class name as used in the SPFF file.
//	 * 
//	 * @param instance
//	 *            A numeric instanceID that uniquely identifies an instance
//	 * @return class name
//	 * @throws Exception
//	 */
//	public String engiGetInstanceClassInfo(int instance) throws Exception {
//		String returnValue = null;
//		if (nativeEngiGetInstanceClassInfo == null) {
//			nativeEngiGetInstanceClassInfo = new JNative(libraryPath, "engiGetInstanceClassInfo");
//		}
//		nativeEngiGetInstanceClassInfo.setRetVal(Type.STRING);
//		nativeEngiGetInstanceClassInfo.setParameter(0, instance);
//		nativeEngiGetInstanceClassInfo.invoke();
//		returnValue = nativeEngiGetInstanceClassInfo.getRetVal();
//		return returnValue;
//
//		// String returnValue = null;
//		// jn = new JNative(libraryPath, "engiGetInstanceClassInfo");
//		// jn.setRetVal(Type.STRING);
//		// jn.setParameter(0, instance);
//		// jn.invoke();
//		// returnValue = jn.getRetVal();
//		// return returnValue;
//	}
//
//	private JNative nativeEngiGetInstanceClassInfoUC;
//
//	/**
//	 * Returns the UPPER CASE version of the class name as used in the Schema
//	 * file.
//	 * 
//	 * @param instance
//	 *            A numeric instanceID that uniquely identifies an instance.
//	 * @return UPPER CASE version of the class name
//	 * @throws Exception
//	 */
//	public String engiGetInstanceClassInfoUC(int instance) throws Exception {
//		String returnValue = null;
//		if (nativeEngiGetInstanceClassInfoUC == null) {
//			nativeEngiGetInstanceClassInfoUC = new JNative(libraryPath, "engiGetInstanceClassInfoUC");
//		}
//		nativeEngiGetInstanceClassInfoUC.setRetVal(Type.STRING);
//		nativeEngiGetInstanceClassInfoUC.setParameter(0, instance);
//		nativeEngiGetInstanceClassInfoUC.invoke();
//		returnValue = nativeEngiGetInstanceClassInfoUC.getRetVal();
//		return returnValue;
//
//		// String returnValue = null;
//		// jn = new JNative(libraryPath, "engiGetInstanceClassInfoUC");
//		// jn.setRetVal(Type.STRING);
//		// jn.setParameter(0, instance);
//		// jn.invoke();
//		// returnValue = jn.getRetVal();
//		// return returnValue;
//	}
//
//	private JNative nativeSdaiAppend;
//
//	/**
//	 * Adds an attribute value at the end of an attribute list.
//	 * 
//	 * @param list
//	 * @param valueType
//	 * @param value
//	 */
//	public void sdaiAppend(int list, int valueType, Object value) throws Exception {
//		if (nativeSdaiAppend == null) {
//			nativeSdaiAppend = new JNative(libraryPath, "sdaiAppend");
//		}
//		nativeSdaiAppend.setRetVal(Type.VOID);
//		nativeSdaiAppend.setParameter(0, list);
//		nativeSdaiAppend.setParameter(1, valueType);
//		switch (valueType) {
//		case sdaiADB:
//			nativeSdaiAppend.setParameter(2, ((Integer) value).intValue());
//			break;
//		case sdaiAGGR:
//			nativeSdaiAppend.setParameter(2, ((Integer) value).intValue());
//			break;
//		case sdaiBINARY:
//			nativeSdaiAppend.setParameter(2, ((Integer) value).intValue());
//			break;
//		case sdaiBOOLEAN:
//			if ((Boolean) value)
//				nativeSdaiAppend.setParameter(2, 1);
//			else
//				nativeSdaiAppend.setParameter(2, 0);
//			break;
//		case sdaiENUM:
//			nativeSdaiAppend.setParameter(2, ((Integer) value).intValue());
//			break;
//		case sdaiINSTANCE:
//			nativeSdaiAppend.setParameter(2, ((Integer) value).intValue());
//			break;
//		case sdaiINTEGER:
//			nativeSdaiAppend.setParameter(2, ((Integer) value).intValue());
//			break;
//		case sdaiLOGICAL:
//			nativeSdaiAppend.setParameter(2, ((Integer) value).intValue());
//			break;
//		case sdaiREAL:
//			nativeSdaiAppend.setParameter(2, Type.DOUBLE, ((Double) value).toString());
//			break;
//		case sdaiSTRING:
//			nativeSdaiAppend.setParameter(2, Type.STRING, (String) value);
//			break;
//		}
//		nativeSdaiAppend.invoke();
//
//		// jn = new JNative(libraryPath, "sdaiAppend");
//		// jn.setRetVal(Type.VOID);
//		// jn.setParameter(0, list);
//		// jn.setParameter(1, valueType);
//		// switch (valueType) {
//		// case sdaiADB:
//		// jn.setParameter(2, ((Integer) value).intValue());
//		// break;
//		// case sdaiAGGR:
//		// jn.setParameter(2, ((Integer) value).intValue());
//		// break;
//		// case sdaiBINARY:
//		// jn.setParameter(2, ((Integer) value).intValue());
//		// break;
//		// case sdaiBOOLEAN:
//		// if ((Boolean) value)
//		// jn.setParameter(2, 1);
//		// else
//		// jn.setParameter(2, 0);
//		// break;
//		// case sdaiENUM:
//		// jn.setParameter(2, ((Integer) value).intValue());
//		// break;
//		// case sdaiINSTANCE:
//		// jn.setParameter(2, ((Integer) value).intValue());
//		// break;
//		// case sdaiINTEGER:
//		// jn.setParameter(2, ((Integer) value).intValue());
//		// break;
//		// case sdaiLOGICAL:
//		// jn.setParameter(2, ((Integer) value).intValue());
//		// break;
//		// case sdaiREAL:
//		// jn.setParameter(2, Type.DOUBLE, ((Double) value).toString());
//		// break;
//		// case sdaiSTRING:
//		// jn.setParameter(2, Type.STRING, (String) value);
//		// break;
//		// }
//		// jn.invoke();
//	}
//
//	private JNative nativeSdaiBeginning;
//
//	/**
//	 * Adds an attribute value at the beginning of an attribute list.
//	 * 
//	 * @param iterator
//	 * @throws Exception
//	 */
//	public void sdaiBeginning(int iterator) throws Exception {
//		if (nativeSdaiBeginning == null) {
//			nativeSdaiBeginning = new JNative(libraryPath, "sdaiBeginning");
//		}
//		nativeSdaiBeginning.setRetVal(Type.VOID);
//		nativeSdaiBeginning.setParameter(0, iterator);
//		nativeSdaiBeginning.invoke();
//
//		// jn = new JNative(libraryPath, "sdaiBeginning");
//		// jn.setRetVal(Type.VOID);
//		// jn.setParameter(0, iterator);
//		// jn.invoke();
//	}
//
//	private JNative nativeSdaiCreateADB;
//
//	/**
//	 * Creates an Attribute Data Block (ADB).
//	 * 
//	 * @param valueType
//	 *            identifies the type of parameter value.
//	 * @param value
//	 *            identifies the data to be stored in the new ADB.
//	 * @return the handle of the newly created ADB.
//	 * @throws Exception
//	 */
//	public int sdaiCreateADB(int valueType, Object value) throws Exception {
//		int returnValue = 0;
//		if (nativeSdaiCreateADB == null) {
//			nativeSdaiCreateADB = new JNative(libraryPath, "sdaiCreateADB");
//		}
//		nativeSdaiCreateADB.setRetVal(Type.INT);
//		nativeSdaiCreateADB.setParameter(0, valueType);
//		switch (valueType) {
//		case sdaiADB:
//			nativeSdaiCreateADB.setParameter(1, ((Integer) value).intValue());
//			break;
//		case sdaiAGGR:
//			nativeSdaiCreateADB.setParameter(1, ((Integer) value).intValue());
//			break;
//		case sdaiBINARY:
//			nativeSdaiCreateADB.setParameter(1, ((Integer) value).intValue());
//			break;
//		case sdaiBOOLEAN:
//			if ((Boolean) value)
//				nativeSdaiCreateADB.setParameter(1, 1);
//			else
//				nativeSdaiCreateADB.setParameter(1, 0);
//			break;
//		case sdaiENUM:
//			nativeSdaiCreateADB.setParameter(1, ((Integer) value).intValue());
//			break;
//		case sdaiINSTANCE:
//			nativeSdaiCreateADB.setParameter(1, ((Integer) value).intValue());
//			break;
//		case sdaiINTEGER:
//			nativeSdaiCreateADB.setParameter(1, ((Integer) value).intValue());
//			break;
//		case sdaiLOGICAL:
//			nativeSdaiCreateADB.setParameter(1, ((Integer) value).intValue());
//			break;
//		case sdaiREAL:
//			nativeSdaiCreateADB.setParameter(1, Type.DOUBLE, ((Double) value).toString());
//			break;
//		case sdaiSTRING:
//			nativeSdaiCreateADB.setParameter(1, Type.STRING, (String) value);
//			break;
//		}
//		nativeSdaiCreateADB.invoke();
//		returnValue = nativeSdaiCreateADB.getRetValAsInt();
//		return returnValue;
//
//		// int returnValue = 0;
//		// jn = new JNative(libraryPath, "sdaiCreateADB");
//		// jn.setRetVal(Type.INT);
//		// jn.setParameter(0, valueType);
//		// switch (valueType) {
//		// case sdaiADB:
//		// jn.setParameter(1, ((Integer) value).intValue());
//		// break;
//		// case sdaiAGGR:
//		// jn.setParameter(1, ((Integer) value).intValue());
//		// break;
//		// case sdaiBINARY:
//		// jn.setParameter(1, ((Integer) value).intValue());
//		// break;
//		// case sdaiBOOLEAN:
//		// if ((Boolean) value)
//		// jn.setParameter(1, 1);
//		// else
//		// jn.setParameter(1, 0);
//		// break;
//		// case sdaiENUM:
//		// jn.setParameter(1, ((Integer) value).intValue());
//		// break;
//		// case sdaiINSTANCE:
//		// jn.setParameter(1, ((Integer) value).intValue());
//		// break;
//		// case sdaiINTEGER:
//		// jn.setParameter(1, ((Integer) value).intValue());
//		// break;
//		// case sdaiLOGICAL:
//		// jn.setParameter(1, ((Integer) value).intValue());
//		// break;
//		// case sdaiREAL:
//		// jn.setParameter(1, Type.DOUBLE, ((Double) value).toString());
//		// break;
//		// case sdaiSTRING:
//		// jn.setParameter(1, Type.STRING, (String) value);
//		// break;
//		// }
//		// jn.invoke();
//		// returnValue = jn.getRetValAsInt();
//		// return returnValue;
//	}
//
//	private JNative nativeSdaiCreateAggr;
//
//	/**
//	 * Creates an aggregation for an attribute in a specific instance.
//	 * 
//	 * @param instance
//	 *            A numeric instanceID that uniquely identifies an instance.
//	 * @param attribute
//	 *            A numeric attributerID that uniquely identifies an attribute
//	 *            definition instance.
//	 * @return
//	 * @throws Exception
//	 */
//	public int sdaiCreateAggr(int instance, int attribute) throws Exception {
//		int returnValue = 0;
//		if (nativeSdaiCreateAggr == null) {
//			nativeSdaiCreateAggr = new JNative(libraryPath, "sdaiCreateAggr");
//		}
//		nativeSdaiCreateAggr.setRetVal(Type.INT);
//		nativeSdaiCreateAggr.setParameter(0, instance);
//		nativeSdaiCreateAggr.setParameter(1, attribute);
//		nativeSdaiCreateAggr.invoke();
//		returnValue = nativeSdaiCreateAggr.getRetValAsInt();
//		return returnValue;
//
//		// int returnValue = 0;
//		// jn = new JNative(libraryPath, "sdaiCreateAggr");
//		// jn.setRetVal(Type.INT);
//		// jn.setParameter(0, instance);
//		// jn.setParameter(1, attribute);
//		// jn.invoke();
//		// returnValue = jn.getRetValAsInt();
//		// return returnValue;
//	}
//
//	private JNative nativeSdaiCreateAggrBN;
//
//	/**
//	 * Creates an aggregation for an attribute in a specific instance.
//	 * 
//	 * @param instance
//	 *            A numeric instanceID that uniquely identifies an instance.
//	 * @param attributeName
//	 *            A string that contains an attribute name existing in the
//	 *            mentioned instance.
//	 * @return
//	 * @throws Exception
//	 */
//	public int sdaiCreateAggrBN(int instance, String attributeName) throws Exception {
//		int returnValue = 0;
//		if (nativeSdaiCreateAggrBN == null) {
//			nativeSdaiCreateAggrBN = new JNative(libraryPath, "sdaiCreateAggrBN");
//		}
//		nativeSdaiCreateAggrBN.setRetVal(Type.INT);
//		nativeSdaiCreateAggrBN.setParameter(0, instance);
//		nativeSdaiCreateAggrBN.setParameter(1, Type.STRING, attributeName);
//		nativeSdaiCreateAggrBN.invoke();
//		returnValue = nativeSdaiCreateAggrBN.getRetValAsInt();
//		return returnValue;
//
//		// int returnValue = 0;
//		// jn = new JNative(libraryPath, "sdaiCreateAggrBN");
//		// jn.setRetVal(Type.INT);
//		// jn.setParameter(0, instance);
//		// jn.setParameter(1, Type.STRING, attributeName);
//		// jn.invoke();
//		// returnValue = jn.getRetValAsInt();
//		// return returnValue;
//	}
//
//	private JNative nativeSdaiCreateInstance;
//
//	/**
//	 * Creates an instance of a specific schema entity.
//	 * 
//	 * @param model
//	 *            Unique number identifying the model in the opened file.
//	 * @param entity
//	 *            A numeric entityID that uniquely identifies a (schema) entity
//	 *            existing in the mentioned model.
//	 * @return
//	 * @throws Exception
//	 */
//	public int sdaiCreateInstance(int model, int entity) throws Exception {
//		int returnValue = 0;
//		if (nativeSdaiCreateInstance == null) {
//			nativeSdaiCreateInstance = new JNative(libraryPath, "sdaiCreateInstance");
//		}
//		nativeSdaiCreateInstance.setRetVal(Type.INT);
//		nativeSdaiCreateInstance.setParameter(0, model);
//		nativeSdaiCreateInstance.setParameter(1, entity);
//		nativeSdaiCreateInstance.invoke();
//		returnValue = nativeSdaiCreateInstance.getRetValAsInt();
//		return returnValue;
//
//		// int returnValue = 0;
//		// jn = new JNative(libraryPath, "sdaiCreateInstance");
//		// jn.setRetVal(Type.INT);
//		// jn.setParameter(0, model);
//		// jn.setParameter(1, entity);
//		// jn.invoke();
//		// returnValue = jn.getRetValAsInt();
//		// return returnValue;
//	}
//
//	private JNative nativeSdaiCreateInstanceBN;
//
//	/**
//	 * Creates an instance of a specific schema entity.
//	 * 
//	 * @param model
//	 *            Unique number identifying the model in the opened file.
//	 * @param entityName
//	 *            A string that contains a (schema) entity name existing in the
//	 *            mentioned model.
//	 * @return
//	 * @throws Exception
//	 */
//	public int sdaiCreateInstanceBN(int model, String entityName) throws Exception {
//		int returnValue = 0;
//		if (nativeSdaiCreateInstanceBN == null) {
//			nativeSdaiCreateInstanceBN = new JNative(libraryPath, "sdaiCreateInstanceBN");
//		}
//		nativeSdaiCreateInstanceBN.setRetVal(Type.INT);
//		nativeSdaiCreateInstanceBN.setParameter(0, model);
//		nativeSdaiCreateInstanceBN.setParameter(1, Type.STRING, entityName);
//		nativeSdaiCreateInstanceBN.invoke();
//		returnValue = nativeSdaiCreateInstanceBN.getRetValAsInt();
//		return returnValue;
//
//		// int returnValue = 0;
//		// jn = new JNative(libraryPath, "sdaiCreateInstanceBN");
//		// jn.setRetVal(Type.INT);
//		// jn.setParameter(0, model);
//		// jn.setParameter(1, Type.STRING, entityName);
//		// jn.invoke();
//		// returnValue = jn.getRetValAsInt();
//		// return returnValue;
//	}
//
//	private JNative nativeSdaiCreateInstanceBNEI;
//
//	/**
//	 * Creates an instance of a specific schema entity.
//	 * 
//	 * @param model
//	 *            Unique number identifying the model in the opened file.
//	 * @param entityName
//	 *            A string that contains a (schema) entity name existing in the
//	 *            mentioned model.
//	 * @param express_id
//	 * @return
//	 * @throws Exception
//	 */
//	public int sdaiCreateInstanceBNEI(int model, String entityName, int express_id) throws Exception {
//		int returnValue = 0;
//		if (nativeSdaiCreateInstanceBNEI == null) {
//			nativeSdaiCreateInstanceBNEI = new JNative(libraryPath, "sdaiCreateInstanceBNEI");
//		}
//		nativeSdaiCreateInstanceBNEI.setRetVal(Type.INT);
//		nativeSdaiCreateInstanceBNEI.setParameter(0, model);
//		nativeSdaiCreateInstanceBNEI.setParameter(1, Type.STRING, entityName);
//		nativeSdaiCreateInstanceBNEI.invoke();
//		returnValue = nativeSdaiCreateInstanceBNEI.getRetValAsInt();
//		return returnValue;
//
//		// int returnValue = 0;
//		// jn = new JNative(libraryPath, "sdaiCreateInstanceBNEI");
//		// jn.setRetVal(Type.INT);
//		// jn.setParameter(0, model);
//		// jn.setParameter(1, Type.STRING, entityName);
//		// jn.invoke();
//		// returnValue = jn.getRetValAsInt();
//		// return returnValue;
//	}
//
//	private JNative nativeSdaiCreateIterator;
//
//	/**
//	 * Creates an iterator for an existing aggregation.
//	 * 
//	 * @param aggregate
//	 *            Existing aggregation.
//	 * @return
//	 * @throws Exception
//	 */
//	public int sdaiCreateIterator(int aggregate) throws Exception {
//		int returnValue = 0;
//		if (nativeSdaiCreateIterator == null) {
//			nativeSdaiCreateIterator = new JNative(libraryPath, "sdaiCreateIterator");
//		}
//		nativeSdaiCreateIterator.setRetVal(Type.INT);
//		nativeSdaiCreateIterator.setParameter(0, aggregate);
//		nativeSdaiCreateIterator.invoke();
//		returnValue = nativeSdaiCreateIterator.getRetValAsInt();
//		return returnValue;
//
//		// int returnValue = 0;
//		// jn = new JNative(libraryPath, "sdaiCreateIterator");
//		// jn.setRetVal(Type.INT);
//		// jn.setParameter(0, aggregate);
//		// jn.invoke();
//		// returnValue = jn.getRetValAsInt();
//		// return returnValue;
//	}
//
//	private JNative nativeSdaiDeleteInstance;
//
//	/**
//	 * Deletes an existing instance.
//	 * 
//	 * @param instance
//	 *            A numeric instanceID that uniquely identifies an instance.
//	 * @throws Exception
//	 */
//	public void sdaiDeleteInstance(int instance) throws Exception {
//		if (nativeSdaiDeleteInstance == null) {
//			nativeSdaiDeleteInstance = new JNative(libraryPath, "sdaiDeleteInstance");
//		}
//		nativeSdaiDeleteInstance.setRetVal(Type.VOID);
//		nativeSdaiDeleteInstance.setParameter(0, instance);
//		nativeSdaiDeleteInstance.invoke();
//
//		// jn = new JNative(libraryPath, "sdaiDeleteInstance");
//		// jn.setRetVal(Type.VOID);
//		// jn.setParameter(0, instance);
//		// jn.invoke();
//	}
//
//	private JNative nativeSdaiDeleteIterator;
//
//	/**
//	 * Deletes an existing iterator.
//	 * 
//	 * @param iterator
//	 *            Existing iterator.
//	 * @throws Exception
//	 */
//	public void sdaiDeleteIterator(int iterator) throws Exception {
//		if (nativeSdaiDeleteIterator == null) {
//			nativeSdaiDeleteIterator = new JNative(libraryPath, "sdaiDeleteIterator");
//		}
//		nativeSdaiDeleteIterator.setRetVal(Type.VOID);
//		nativeSdaiDeleteIterator.setParameter(0, iterator);
//		nativeSdaiDeleteIterator.invoke();
//
//		// jn = new JNative(libraryPath, "sdaiDeleteIterator");
//		// jn.setRetVal(Type.VOID);
//		// jn.setParameter(0, iterator);
//		// jn.invoke();
//	}
//
//	private JNative nativeSdaiEnd;
//
//	/**
//	 * Moves the active position in an iterator to the last object.
//	 * 
//	 * @param iterator
//	 *            Existing iterator.
//	 * @throws Exception
//	 */
//	public void sdaiEnd(int iterator) throws Exception {
//		if (nativeSdaiEnd == null) {
//			nativeSdaiEnd = new JNative(libraryPath, "sdaiEnd");
//		}
//		nativeSdaiEnd.setRetVal(Type.VOID);
//		nativeSdaiEnd.setParameter(0, iterator);
//		nativeSdaiEnd.invoke();
//
//		// jn = new JNative(libraryPath, "sdaiEnd");
//		// jn.setRetVal(Type.VOID);
//		// jn.setParameter(0, iterator);
//		// jn.invoke();
//	}
//
//	private JNative nativeSdaiErrorQuery;
//
//	/**
//	 * Implementation postponed till version 1.10
//	 * 
//	 * @return
//	 * @throws Exception
//	 */
//	public int sdaiErrorQuery() throws Exception {
//		int returnValue = 0;
//		if (nativeSdaiErrorQuery == null) {
//			nativeSdaiErrorQuery = new JNative(libraryPath, "sdaiErrorQuery");
//		}
//		nativeSdaiErrorQuery.setRetVal(Type.INT);
//		nativeSdaiErrorQuery.invoke();
//		returnValue = nativeSdaiErrorQuery.getRetValAsInt();
//		return returnValue;
//
//		// int returnValue = 0;
//		// jn = new JNative(libraryPath, "sdaiErrorQuery");
//		// jn.setRetVal(Type.INT);
//		// jn.invoke();
//		// returnValue = jn.getRetValAsInt();
//		// return returnValue;
//	}
//
//	private JNative nativeSdaiGetAggrByIterator;
//
//	/**
//	 * Implementation postponed till version 1.10
//	 * 
//	 * @param iterator
//	 *            Existing iterator
//	 * @param valueType
//	 *            Type of output value
//	 * @return
//	 * @throws Exception
//	 */
//	public Object sdaiGetAggrByIterator(int iterator, int valueType) throws Exception {
//		if (nativeSdaiGetAggrByIterator == null) {
//			nativeSdaiGetAggrByIterator = new JNative(libraryPath, "sdaiGetAggrByIterator");
//		}
//		nativeSdaiGetAggrByIterator.setParameter(0, iterator);
//		nativeSdaiGetAggrByIterator.setParameter(1, valueType);
//		Pointer ptr = new Pointer(MemoryBlockFactory.createMemoryBlock(8));
//		nativeSdaiGetAggrByIterator.setParameter(2, ptr);
//
//		nativeSdaiGetAggrByIterator.invoke();
//
//		Object returnValue = getReturnValue(ptr, valueType);
//		ptr.dispose();
//		return returnValue;
//
//		// jn = new JNative(libraryPath, "sdaiGetAggrByIterator");
//		//
//		// jn.setParameter(0, iterator);
//		// jn.setParameter(1, valueType);
//		// Pointer ptr = new Pointer(MemoryBlockFactory.createMemoryBlock(8));
//		// jn.setParameter(2, ptr);
//		//
//		// jn.invoke();
//		//
//		// Object returnValue = getReturnValue(ptr, valueType);
//		// ptr.dispose();
//		// return returnValue;
//	}
//
//	private JNative nativeSdaiGetAttr;
//
//	/**
//	 * Returns the data value of the specified attribute in the actual instance.
//	 * The actual instance is specified by a numeric instanceID that uniquely
//	 * identifies an instance.
//	 * 
//	 * @param instance
//	 *            A numeric instanceID that uniquely identifies an instance.
//	 * @param attribute
//	 *            A numeric attributerID that uniquely identifies an attribute
//	 *            definition instance.
//	 * @param valueType
//	 *            Type of output value.
//	 * @return Output value of the specific element in the aggregation.
//	 * @throws Exception
//	 */
//	public Object sdaiGetAttr(int instance, int attribute, int valueType) throws Exception {
//		if (nativeSdaiGetAttr == null) {
//			nativeSdaiGetAttr = new JNative(libraryPath, "sdaiGetAttr");
//		}
//		nativeSdaiGetAttr.setParameter(0, instance);
//		nativeSdaiGetAttr.setParameter(1, attribute);
//		nativeSdaiGetAttr.setParameter(2, valueType);
//		Pointer ptr = new Pointer(MemoryBlockFactory.createMemoryBlock(8));
//		nativeSdaiGetAttr.setParameter(3, ptr);
//
//		nativeSdaiGetAttr.invoke();
//
//		Object returnValue = getReturnValue(ptr, valueType);
//		ptr.dispose();
//		return returnValue;
//
//		// jn = new JNative(libraryPath, "sdaiGetAttr");
//		//
//		// jn.setParameter(0, instance);
//		// jn.setParameter(1, attribute);
//		// jn.setParameter(2, valueType);
//		// Pointer ptr = new Pointer(MemoryBlockFactory.createMemoryBlock(8));
//		// jn.setParameter(3, ptr);
//		//
//		// jn.invoke();
//		//
//		// Object returnValue = getReturnValue(ptr, valueType);
//		// ptr.dispose();
//		// return returnValue;
//	}
//
//	private JNative nativeSdaiGetAttrBN;
//
//	/**
//	 * Returns the data value of the specified attribute in the actual instance.
//	 * The actual instance is specified by a numeric instanceID that uniquely
//	 * identifies an instance.
//	 * 
//	 * @param instance
//	 *            A numeric instanceID that uniquely identifies an instance.
//	 * @param attributeName
//	 *            A character that contains an attribute name existing in the
//	 *            mentioned instance.
//	 * @param valueType
//	 *            Type of output value.
//	 * @return Output value of the specific element in the aggregation.
//	 * @throws Exception
//	 */
//	public Object sdaiGetAttrBN(int instance, String attributeName, int valueType) throws Exception {
//		if (nativeSdaiGetAttrBN == null) {
//			nativeSdaiGetAttrBN = new JNative(libraryPath, "sdaiGetAttrBN");
//		}
//
//		nativeSdaiGetAttrBN.setParameter(0, instance);
//		nativeSdaiGetAttrBN.setParameter(1, Type.STRING, attributeName);
//		nativeSdaiGetAttrBN.setParameter(2, valueType);
//		Pointer ptr = new Pointer(MemoryBlockFactory.createMemoryBlock(8));
//		nativeSdaiGetAttrBN.setParameter(3, ptr);
//
//		nativeSdaiGetAttrBN.invoke();
//
//		Object returnValue = getReturnValue(ptr, valueType);
//		ptr.dispose();
//		return returnValue;
//
//		// jn = new JNative(libraryPath, "sdaiGetAttrBN");
//		//
//		// jn.setParameter(0, instance);
//		// jn.setParameter(1, Type.STRING, attributeName);
//		// jn.setParameter(2, valueType);
//		// Pointer ptr = new Pointer(MemoryBlockFactory.createMemoryBlock(8));
//		// jn.setParameter(3, ptr);
//		//
//		// jn.invoke();
//		//
//		// Object returnValue = getReturnValue(ptr, valueType);
//		// ptr.dispose();
//		// return returnValue;
//	}
//
//	private JNative nativeSdaiGetAttrDefinition;
//
//	/**
//	 * Returns a numeric attributeID that uniquely identifies an attribute
//	 * definition instance.
//	 * 
//	 * @param entity
//	 *            A numeric entityID that uniquely identifies a (schema) entity
//	 *            existing in the mentioned model.
//	 * @param attributeName
//	 *            A string that contains an attribute name existing in the
//	 *            mentioned instance.
//	 * @return a numeric attributeID
//	 * @throws Exception
//	 */
//	public int sdaiGetAttrDefinition(int entity, String attributeName) throws Exception {
//		int returnValue = 0;
//		if (nativeSdaiGetAttrDefinition == null) {
//			nativeSdaiGetAttrDefinition = new JNative(libraryPath, "sdaiGetAttrDefinition");
//		}
//		nativeSdaiGetAttrDefinition.setRetVal(Type.INT);
//		nativeSdaiGetAttrDefinition.setParameter(0, entity);
//		nativeSdaiGetAttrDefinition.setParameter(1, Type.STRING, attributeName);
//		nativeSdaiGetAttrDefinition.invoke();
//		returnValue = nativeSdaiGetAttrDefinition.getRetValAsInt();
//		return returnValue;
//
//		// int returnValue = 0;
//		// jn = new JNative(libraryPath, "sdaiGetAttrDefinition");
//		// jn.setRetVal(Type.INT);
//		// jn.setParameter(0, entity);
//		// jn.setParameter(1, Type.STRING, attributeName);
//		// jn.invoke();
//		// returnValue = jn.getRetValAsInt();
//		// return returnValue;
//	}
//
//	private JNative nativeSdaiGetEntity;
//
//	/**
//	 * Returns a numeric entityID that uniquely identifies an entity definition
//	 * instance.
//	 * 
//	 * @param model
//	 *            Unique number identifying the model in the opened file.
//	 * @param entityName
//	 *            Name of the Entity.
//	 * @return a numeric entityID
//	 * @throws Exception
//	 */
//	public int sdaiGetEntity(int model, String entityName) throws Exception {
//		int returnValue = 0;
//		if (nativeSdaiGetEntity == null) {
//			nativeSdaiGetEntity = new JNative(libraryPath, "sdaiGetEntity");
//		}
//		nativeSdaiGetEntity.setRetVal(Type.INT);
//		nativeSdaiGetEntity.setParameter(0, model);
//		nativeSdaiGetEntity.setParameter(1, Type.STRING, entityName);
//		nativeSdaiGetEntity.invoke();
//		returnValue = nativeSdaiGetEntity.getRetValAsInt();
//		return returnValue;
//
//		// int returnValue = 0;
//		// jn = new JNative(libraryPath, "sdaiGetEntity");
//		// jn.setRetVal(Type.INT);
//		// jn.setParameter(0, model);
//		// jn.setParameter(1, Type.STRING, entityName);
//		// jn.invoke();
//		// returnValue = jn.getRetValAsInt();
//		// return returnValue;
//	}
//
//	private JNative nativeSdaiGetEntityExtent;
//
//	/**
//	 * Returns a numeric aggregateID that uniquely identifies the aggregate that
//	 * holds all instances of one particular type in a model.
//	 * 
//	 * @param model
//	 *            Unique number identifying the model in the opened file.
//	 * @param entity
//	 *            A numeric entityID that uniquely identifies a (schema) entity
//	 *            existing in the mentioned model.
//	 * @return a numeric aggregateID
//	 * @throws Exception
//	 */
//	public int sdaiGetEntityExtent(int model, int entity) throws Exception {
//		int returnValue = 0;
//		if (nativeSdaiGetEntityExtent == null) {
//			nativeSdaiGetEntityExtent = new JNative(libraryPath, "sdaiGetEntityExtent");
//		}
//		nativeSdaiGetEntityExtent.setRetVal(Type.INT);
//		nativeSdaiGetEntityExtent.setParameter(0, model);
//		nativeSdaiGetEntityExtent.setParameter(1, entity);
//		nativeSdaiGetEntityExtent.invoke();
//		returnValue = nativeSdaiGetEntityExtent.getRetValAsInt();
//		return returnValue;
//
//		// int returnValue = 0;
//		// jn = new JNative(libraryPath, "sdaiGetEntityExtent");
//		// jn.setRetVal(Type.INT);
//		// jn.setParameter(0, model);
//		// jn.setParameter(1, entity);
//		// jn.invoke();
//		// returnValue = jn.getRetValAsInt();
//		// return returnValue;
//	}
//
//	private JNative nativeSdaiGetEntityExtentBN;
//
//	/**
//	 * Returns a numeric aggregateID that uniquely identifies the aggregate that
//	 * holds all instances of one particular type in a model.
//	 * 
//	 * @param model
//	 *            Unique number identifying the model in the opened file.
//	 * @param entityName
//	 *            Name of the Entity.
//	 * @return a numeric aggregateID
//	 * @throws Exception
//	 */
//	public int sdaiGetEntityExtentBN(int model, String entityName) throws Exception {
//		int returnValue = 0;
//		if (nativeSdaiGetEntityExtentBN == null) {
//			nativeSdaiGetEntityExtentBN = new JNative(libraryPath, "sdaiGetEntityExtentBN");
//		}
//		nativeSdaiGetEntityExtentBN.setRetVal(Type.INT);
//		nativeSdaiGetEntityExtentBN.setParameter(0, model);
//		nativeSdaiGetEntityExtentBN.setParameter(1, Type.STRING, entityName);
//		nativeSdaiGetEntityExtentBN.invoke();
//		returnValue = nativeSdaiGetEntityExtentBN.getRetValAsInt();
//		return returnValue;
//
//		// int returnValue = 0;
//		// jn = new JNative(libraryPath, "sdaiGetEntityExtentBN");
//		// jn.setRetVal(Type.INT);
//		// jn.setParameter(0, model);
//		// jn.setParameter(1, Type.STRING, entityName);
//		// jn.invoke();
//		// returnValue = jn.getRetValAsInt();
//		// return returnValue;
//	}
//
//	private JNative nativeSdaiGetInstanceType;
//
//	/**
//	 * Return the instance type of the specified instance. The instance type is
//	 * returned as an entityID that uniquely identifies the entity definition
//	 * instance.
//	 * 
//	 * @param instance
//	 *            A numeric instanceID that uniquely identifies an instance.
//	 * @return the instance type
//	 * @throws Exception
//	 */
//	public int sdaiGetInstanceType(int instance) throws Exception {
//		int returnValue = 0;
//		if (nativeSdaiGetInstanceType == null) {
//			nativeSdaiGetInstanceType = new JNative(libraryPath, "sdaiGetInstanceType");
//		}
//		nativeSdaiGetInstanceType.setRetVal(Type.INT);
//		nativeSdaiGetInstanceType.setParameter(0, instance);
//		nativeSdaiGetInstanceType.invoke();
//		returnValue = nativeSdaiGetInstanceType.getRetValAsInt();
//		return returnValue;
//
//		// int returnValue = 0;
//		// jn = new JNative(libraryPath, "sdaiGetInstanceType");
//		// jn.setRetVal(Type.INT);
//		// jn.setParameter(0, instance);
//		// jn.invoke();
//		// returnValue = jn.getRetValAsInt();
//		// return returnValue;
//	}
//
//	private JNative nativeSdaiGetMemberCount;
//
//	/**
//	 * Returns the number of elements in the specified aggregate.
//	 * 
//	 * @param aggregate
//	 *            Existing aggregation.
//	 * @return the number of elements
//	 * @throws Exception
//	 */
//	public int sdaiGetMemberCount(int aggregate) throws Exception {
//		int returnValue = 0;
//		if (nativeSdaiGetMemberCount == null) {
//			nativeSdaiGetMemberCount = new JNative(libraryPath, "sdaiGetMemberCount");
//		}
//		nativeSdaiGetMemberCount.setRetVal(Type.INT);
//		nativeSdaiGetMemberCount.setParameter(0, aggregate);
//		nativeSdaiGetMemberCount.invoke();
//		returnValue = nativeSdaiGetMemberCount.getRetValAsInt();
//		return returnValue;
//
//		// int returnValue = 0;
//		// jn = new JNative(libraryPath, "sdaiGetMemberCount");
//		// jn.setRetVal(Type.INT);
//		// jn.setParameter(0, aggregate);
//		// jn.invoke();
//		// returnValue = jn.getRetValAsInt();
//		// return returnValue;
//	}
//
//	private JNative nativeSdaiIsInstanceOf;
//
//	/**
//	 * Checks if a certain instance is from the type Entity.
//	 * 
//	 * @param instance
//	 *            A numeric instanceID that uniquely identifies an instance.
//	 * @param entity
//	 *            A numeric entityID that uniquely identifies a (schema) entity
//	 *            existing in the mentioned model.
//	 * @return test result
//	 * @throws Exception
//	 */
//	public boolean sdaiIsInstanceOf(int instance, int entity) throws Exception {
//		boolean returnValue = false;
//		if (nativeSdaiIsInstanceOf == null) {
//			nativeSdaiIsInstanceOf = new JNative(libraryPath, "sdaiIsInstanceOf");
//		}
//		nativeSdaiIsInstanceOf.setRetVal(Type.INT);
//		nativeSdaiIsInstanceOf.setParameter(0, instance);
//		nativeSdaiIsInstanceOf.setParameter(1, entity);
//		nativeSdaiIsInstanceOf.invoke();
//		returnValue = nativeSdaiIsInstanceOf.getRetValAsInt() == 0 ? false : true;
//		return returnValue;
//
//		// boolean returnValue = false;
//		// jn = new JNative(libraryPath, "sdaiIsInstanceOf");
//		// jn.setRetVal(Type.INT);
//		// jn.setParameter(0, instance);
//		// jn.setParameter(1, entity);
//		// jn.invoke();
//		// returnValue = jn.getRetValAsInt() == 0 ? false : true;
//		// return returnValue;
//	}
//
//	private JNative nativeSdaiIsInstanceOfBN;
//
//	/**
//	 * Checks if a certain instance is from the type Entity.
//	 * 
//	 * @param instance
//	 *            A numeric instanceID that uniquely identifies an instance.
//	 * @param entityName
//	 *            Name of the Entity.
//	 * @return test result
//	 * @throws Exception
//	 */
//	public boolean sdaiIsInstanceOfBN(int instance, String entityName) throws Exception {
//		boolean returnValue = false;
//		if (nativeSdaiIsInstanceOfBN == null) {
//			nativeSdaiIsInstanceOfBN = new JNative(libraryPath, "sdaiIsInstanceOfBN");
//		}
//		nativeSdaiIsInstanceOfBN.setRetVal(Type.INT);
//		nativeSdaiIsInstanceOfBN.setParameter(0, instance);
//		nativeSdaiIsInstanceOfBN.setParameter(1, Type.STRING, entityName);
//		nativeSdaiIsInstanceOfBN.invoke();
//		returnValue = nativeSdaiIsInstanceOfBN.getRetValAsInt() == 0 ? false : true;
//		return returnValue;
//
//		// boolean returnValue = false;
//		// jn = new JNative(libraryPath, "sdaiIsInstanceOfBN");
//		// jn.setRetVal(Type.INT);
//		// jn.setParameter(0, instance);
//		// jn.setParameter(1, Type.STRING, entityName);
//		// jn.invoke();
//		// returnValue = jn.getRetValAsInt() == 0 ? false : true;
//		// return returnValue;
//	}
//
//	private JNative nativeSdaiNext;
//
//	/**
//	 * Implementation postponed till version 1.10>
//	 * 
//	 * @param iterator
//	 * @return
//	 * @throws Exception
//	 */
//	public boolean sdaiNext(int iterator) throws Exception {
//		boolean returnValue = false;
//		if (nativeSdaiNext == null) {
//			nativeSdaiNext = new JNative(libraryPath, "sdaiNext");
//		}
//		nativeSdaiNext.setRetVal(Type.INT);
//		nativeSdaiNext.setParameter(0, iterator);
//		nativeSdaiNext.invoke();
//		returnValue = nativeSdaiNext.getRetValAsInt() == 0 ? false : true;
//		return returnValue;
//
//		// boolean returnValue = false;
//		// jn = new JNative(libraryPath, "sdaiNext");
//		// jn.setRetVal(Type.INT);
//		// jn.setParameter(0, iterator);
//		// jn.invoke();
//		// returnValue = jn.getRetValAsInt() == 0 ? false : true;
//		// return returnValue;
//	}
//
//	private JNative nativeSdaiPrepend;
//
//	/**
//	 * Implementation postponed till version 1.10
//	 * 
//	 * @param list
//	 * @param valueType
//	 * @param value
//	 * @throws Exception
//	 */
//	public void sdaiPrepend(int list, int valueType, Object value) throws Exception {
//		if (nativeSdaiPrepend == null) {
//			nativeSdaiPrepend = new JNative(libraryPath, "sdaiPrepend");
//		}
//		nativeSdaiPrepend.setRetVal(Type.VOID);
//		nativeSdaiPrepend.setParameter(0, list);
//		nativeSdaiPrepend.setParameter(1, valueType);
//		switch (valueType) {
//		case sdaiADB:
//			nativeSdaiPrepend.setParameter(2, ((Integer) value).intValue());
//			break;
//		case sdaiAGGR:
//			nativeSdaiPrepend.setParameter(2, ((Integer) value).intValue());
//			break;
//		case sdaiBINARY:
//			nativeSdaiPrepend.setParameter(2, ((Integer) value).intValue());
//			break;
//		case sdaiBOOLEAN:
//			if ((Boolean) value)
//				nativeSdaiPrepend.setParameter(2, 1);
//			else
//				nativeSdaiPrepend.setParameter(2, 0);
//			break;
//		case sdaiENUM:
//			nativeSdaiPrepend.setParameter(2, ((Integer) value).intValue());
//			break;
//		case sdaiINSTANCE:
//			nativeSdaiPrepend.setParameter(2, ((Integer) value).intValue());
//			break;
//		case sdaiINTEGER:
//			nativeSdaiPrepend.setParameter(2, ((Integer) value).intValue());
//			break;
//		case sdaiLOGICAL:
//			nativeSdaiPrepend.setParameter(2, ((Integer) value).intValue());
//			break;
//		case sdaiREAL:
//			nativeSdaiPrepend.setParameter(2, Type.DOUBLE, ((Double) value).toString());
//			break;
//		case sdaiSTRING:
//			nativeSdaiPrepend.setParameter(2, Type.STRING, (String) value);
//			break;
//		}
//		nativeSdaiPrepend.invoke();
//
//		// jn = new JNative(libraryPath, "sdaiPrepend");
//		// jn.setRetVal(Type.VOID);
//		// jn.setParameter(0, list);
//		// jn.setParameter(1, valueType);
//		// switch (valueType) {
//		// case sdaiADB:
//		// jn.setParameter(2, ((Integer) value).intValue());
//		// break;
//		// case sdaiAGGR:
//		// jn.setParameter(2, ((Integer) value).intValue());
//		// break;
//		// case sdaiBINARY:
//		// jn.setParameter(2, ((Integer) value).intValue());
//		// break;
//		// case sdaiBOOLEAN:
//		// if ((Boolean) value)
//		// jn.setParameter(2, 1);
//		// else
//		// jn.setParameter(2, 0);
//		// break;
//		// case sdaiENUM:
//		// jn.setParameter(2, ((Integer) value).intValue());
//		// break;
//		// case sdaiINSTANCE:
//		// jn.setParameter(2, ((Integer) value).intValue());
//		// break;
//		// case sdaiINTEGER:
//		// jn.setParameter(2, ((Integer) value).intValue());
//		// break;
//		// case sdaiLOGICAL:
//		// jn.setParameter(2, ((Integer) value).intValue());
//		// break;
//		// case sdaiREAL:
//		// jn.setParameter(2, Type.DOUBLE, ((Double) value).toString());
//		// break;
//		// case sdaiSTRING:
//		// jn.setParameter(2, Type.STRING, (String) value);
//		// break;
//		// }
//		// jn.invoke();
//	}
//
//	private JNative nativeSdaiPrevious;
//
//	/**
//	 * Implementation postponed till version 1.10
//	 * 
//	 * @param iterator
//	 * @return
//	 * @throws Exception
//	 */
//	public boolean sdaiPrevious(int iterator) throws Exception {
//		boolean returnValue = false;
//		if (nativeSdaiPrevious == null) {
//			nativeSdaiPrevious = new JNative(libraryPath, "sdaiPrevious");
//		}
//		nativeSdaiPrevious.setRetVal(Type.INT);
//		nativeSdaiPrevious.setParameter(0, iterator);
//		nativeSdaiPrevious.invoke();
//		returnValue = nativeSdaiPrevious.getRetValAsInt() == 0 ? false : true;
//		return returnValue;
//
//		// boolean returnValue = false;
//		// jn = new JNative(libraryPath, "sdaiPrevious");
//		// jn.setRetVal(Type.INT);
//		// jn.setParameter(0, iterator);
//		// jn.invoke();
//		// returnValue = jn.getRetValAsInt() == 0 ? false : true;
//		// return returnValue;
//	}
//
//	private JNative nativeSdaiPutADBTypePath;
//
//	/**
//	 * @param ADB
//	 * @param pathCount
//	 * @param path
//	 * @throws Exception
//	 */
//	public void sdaiPutADBTypePath(int ADB, int pathCount, String path) throws Exception {
//		if (nativeSdaiPutADBTypePath == null) {
//			nativeSdaiPutADBTypePath = new JNative(libraryPath, "sdaiPutADBTypePath");
//		}
//		nativeSdaiPutADBTypePath.setRetVal(Type.VOID);
//		nativeSdaiPutADBTypePath.setParameter(0, ADB);
//		nativeSdaiPutADBTypePath.setParameter(1, pathCount);
//		nativeSdaiPutADBTypePath.setParameter(2, Type.STRING, path);
//		nativeSdaiPutADBTypePath.invoke();
//
//		// jn = new JNative(libraryPath, "sdaiPutADBTypePath");
//		// jn.setRetVal(Type.VOID);
//		// jn.setParameter(0, ADB);
//		// jn.setParameter(1, pathCount);
//		// jn.setParameter(2, Type.STRING, path);
//		// jn.invoke();
//	}
//
//	private JNative nativeSdaiPutAggrByIterator;
//
//	private JNative nativeSetPostProcessing;
//
//	public void setPostProcessing(int modelId, boolean on) throws NativeException, IllegalAccessException {
//		if (nativeSetPostProcessing == null) {
//			nativeSetPostProcessing = new JNative(libraryPath, "setPostProcessing");
//		}
//		nativeSetPostProcessing.setParameter(0, modelId);
//		nativeSetPostProcessing.setParameter(1, 1);
//		nativeSetPostProcessing.invoke();
//	}
//
//	public void sdaiPutAggrByIterator(int iterator, int valueType, Object value) throws Exception {
//		if (nativeSdaiPutAggrByIterator == null) {
//			nativeSdaiPutAggrByIterator = new JNative(libraryPath, "sdaiPutAggrByIterator");
//		}
//		nativeSdaiPutAggrByIterator.setRetVal(Type.VOID);
//		nativeSdaiPutAggrByIterator.setParameter(0, iterator);
//		nativeSdaiPutAggrByIterator.setParameter(1, valueType);
//		switch (valueType) {
//		case sdaiADB:
//			nativeSdaiPutAggrByIterator.setParameter(2, ((Integer) value).intValue());
//			break;
//		case sdaiAGGR:
//			nativeSdaiPutAggrByIterator.setParameter(2, ((Integer) value).intValue());
//			break;
//		case sdaiBINARY:
//			nativeSdaiPutAggrByIterator.setParameter(2, ((Integer) value).intValue());
//			break;
//		case sdaiBOOLEAN:
//			if ((Boolean) value)
//				nativeSdaiPutAggrByIterator.setParameter(2, 1);
//			else
//				nativeSdaiPutAggrByIterator.setParameter(2, 0);
//			break;
//		case sdaiENUM:
//			nativeSdaiPutAggrByIterator.setParameter(2, ((Integer) value).intValue());
//			break;
//		case sdaiINSTANCE:
//			nativeSdaiPutAggrByIterator.setParameter(2, ((Integer) value).intValue());
//			break;
//		case sdaiINTEGER:
//			nativeSdaiPutAggrByIterator.setParameter(2, ((Integer) value).intValue());
//			break;
//		case sdaiLOGICAL:
//			nativeSdaiPutAggrByIterator.setParameter(2, ((Integer) value).intValue());
//			break;
//		case sdaiREAL:
//			nativeSdaiPutAggrByIterator.setParameter(2, Type.DOUBLE, ((Double) value).toString());
//			break;
//		case sdaiSTRING:
//			nativeSdaiPutAggrByIterator.setParameter(2, Type.STRING, (String) value);
//			break;
//		}
//		nativeSdaiPutAggrByIterator.invoke();
//		// jn = new JNative(libraryPath, "sdaiPutAggrByIterator");
//		// jn.setRetVal(Type.VOID);
//		// jn.setParameter(0, iterator);
//		// jn.setParameter(1, valueType);
//		// switch (valueType) {
//		// case sdaiADB:
//		// jn.setParameter(2, ((Integer) value).intValue());
//		// break;
//		// case sdaiAGGR:
//		// jn.setParameter(2, ((Integer) value).intValue());
//		// break;
//		// case sdaiBINARY:
//		// jn.setParameter(2, ((Integer) value).intValue());
//		// break;
//		// case sdaiBOOLEAN:
//		// if ((Boolean) value)
//		// jn.setParameter(2, 1);
//		// else
//		// jn.setParameter(2, 0);
//		// break;
//		// case sdaiENUM:
//		// jn.setParameter(2, ((Integer) value).intValue());
//		// break;
//		// case sdaiINSTANCE:
//		// jn.setParameter(2, ((Integer) value).intValue());
//		// break;
//		// case sdaiINTEGER:
//		// jn.setParameter(2, ((Integer) value).intValue());
//		// break;
//		// case sdaiLOGICAL:
//		// jn.setParameter(2, ((Integer) value).intValue());
//		// break;
//		// case sdaiREAL:
//		// jn.setParameter(2, Type.DOUBLE, ((Double) value).toString());
//		// break;
//		// case sdaiSTRING:
//		// jn.setParameter(2, Type.STRING, (String) value);
//		// break;
//		// }
//		// jn.invoke();
//	}
//
//	private JNative nativeSdaiPutAttr;
//
//	/**
//	 * Adds an attribute value to an attribute in a specific instance.
//	 * 
//	 * @param instance
//	 *            A numeric instanceID that uniquely identifies an instance.
//	 * @param attribute
//	 *            A numeric attributerID that uniquely identifies an attribute
//	 *            definition instance.
//	 * @param valueType
//	 *            Type of output value.
//	 * @param value
//	 *            Input value of the specific element in the aggregation.
//	 * @throws Exception
//	 */
//	public void sdaiPutAttr(int instance, int attribute, int valueType, Object value) throws Exception {
//		if (nativeSdaiPutAttr == null) {
//			nativeSdaiPutAttr = new JNative(libraryPath, "sdaiPutAttr");
//		}
//		nativeSdaiPutAttr.setRetVal(Type.VOID);
//		nativeSdaiPutAttr.setParameter(0, instance);
//		nativeSdaiPutAttr.setParameter(1, attribute);
//		nativeSdaiPutAttr.setParameter(2, valueType);
//		switch (valueType) {
//		case sdaiADB:
//			nativeSdaiPutAttr.setParameter(3, ((Integer) value).intValue());
//			break;
//		case sdaiAGGR:
//			nativeSdaiPutAttr.setParameter(3, ((Integer) value).intValue());
//			break;
//		case sdaiBINARY:
//			nativeSdaiPutAttr.setParameter(3, ((Integer) value).intValue());
//			break;
//		case sdaiBOOLEAN:
//			if ((Boolean) value)
//				nativeSdaiPutAttr.setParameter(3, 1);
//			else
//				nativeSdaiPutAttr.setParameter(3, 0);
//			break;
//		case sdaiENUM:
//			nativeSdaiPutAttr.setParameter(3, ((Integer) value).intValue());
//			break;
//		case sdaiINSTANCE:
//			nativeSdaiPutAttr.setParameter(3, ((Integer) value).intValue());
//			break;
//		case sdaiINTEGER:
//			nativeSdaiPutAttr.setParameter(3, ((Integer) value).intValue());
//			break;
//		case sdaiLOGICAL:
//			nativeSdaiPutAttr.setParameter(3, ((Integer) value).intValue());
//			break;
//		case sdaiREAL:
//			nativeSdaiPutAttr.setParameter(3, Type.DOUBLE, ((Double) value).toString());
//			break;
//		case sdaiSTRING:
//			nativeSdaiPutAttr.setParameter(3, Type.STRING, (String) value);
//			break;
//		}
//		nativeSdaiPutAttr.invoke();
//
//		// jn = new JNative(libraryPath, "sdaiPutAttr");
//		// jn.setRetVal(Type.VOID);
//		// jn.setParameter(0, instance);
//		// jn.setParameter(1, attribute);
//		// jn.setParameter(2, valueType);
//		// switch (valueType) {
//		// case sdaiADB:
//		// jn.setParameter(3, ((Integer) value).intValue());
//		// break;
//		// case sdaiAGGR:
//		// jn.setParameter(3, ((Integer) value).intValue());
//		// break;
//		// case sdaiBINARY:
//		// jn.setParameter(3, ((Integer) value).intValue());
//		// break;
//		// case sdaiBOOLEAN:
//		// if ((Boolean) value)
//		// jn.setParameter(3, 1);
//		// else
//		// jn.setParameter(3, 0);
//		// break;
//		// case sdaiENUM:
//		// jn.setParameter(3, ((Integer) value).intValue());
//		// break;
//		// case sdaiINSTANCE:
//		// jn.setParameter(3, ((Integer) value).intValue());
//		// break;
//		// case sdaiINTEGER:
//		// jn.setParameter(3, ((Integer) value).intValue());
//		// break;
//		// case sdaiLOGICAL:
//		// jn.setParameter(3, ((Integer) value).intValue());
//		// break;
//		// case sdaiREAL:
//		// jn.setParameter(3, Type.DOUBLE, ((Double) value).toString());
//		// break;
//		// case sdaiSTRING:
//		// jn.setParameter(3, Type.STRING, (String) value);
//		// break;
//		// }
//		// jn.invoke();
//	}
//
//	private JNative nativeSdaiPutAttrBN;
//
//	/**
//	 * Adds an attribute value to an attribute in a specific instance.
//	 * 
//	 * @param instance
//	 *            A numeric instanceID that uniquely identifies an instance.
//	 * @param attributeName
//	 *            Name of the attribute.
//	 * @param valueType
//	 *            Type of output value.
//	 * @param value
//	 *            Input value of the specific element in the aggregation.
//	 * @throws Exception
//	 */
//	public void sdaiPutAttrBN(int instance, String attributeName, int valueType, Object value) throws Exception {
//		if (nativeSdaiPutAttrBN == null) {
//			nativeSdaiPutAttrBN = new JNative(libraryPath, "sdaiPutAttrBN");
//		}
//		nativeSdaiPutAttrBN.setRetVal(Type.VOID);
//		nativeSdaiPutAttrBN.setParameter(0, instance);
//		nativeSdaiPutAttrBN.setParameter(1, Type.STRING, attributeName);
//		nativeSdaiPutAttrBN.setParameter(2, valueType);
//		switch (valueType) {
//		case sdaiADB:
//			nativeSdaiPutAttrBN.setParameter(3, ((Integer) value).intValue());
//			break;
//		case sdaiAGGR:
//			nativeSdaiPutAttrBN.setParameter(3, ((Integer) value).intValue());
//			break;
//		case sdaiBINARY:
//			nativeSdaiPutAttrBN.setParameter(3, ((Integer) value).intValue());
//			break;
//		case sdaiBOOLEAN:
//			if ((Boolean) value)
//				nativeSdaiPutAttrBN.setParameter(3, 1);
//			else
//				nativeSdaiPutAttrBN.setParameter(3, 0);
//			break;
//		case sdaiENUM:
//			nativeSdaiPutAttrBN.setParameter(3, ((Integer) value).intValue());
//			break;
//		case sdaiINSTANCE:
//			nativeSdaiPutAttrBN.setParameter(3, ((Integer) value).intValue());
//			break;
//		case sdaiINTEGER:
//			nativeSdaiPutAttrBN.setParameter(3, ((Integer) value).intValue());
//			break;
//		case sdaiLOGICAL:
//			nativeSdaiPutAttrBN.setParameter(3, ((Integer) value).intValue());
//			break;
//		case sdaiREAL:
//			nativeSdaiPutAttrBN.setParameter(3, Type.DOUBLE, ((Double) value).toString());
//			break;
//		case sdaiSTRING:
//			nativeSdaiPutAttrBN.setParameter(3, Type.STRING, (String) value);
//			break;
//		}
//		nativeSdaiPutAttrBN.invoke();
//
//		// jn = new JNative(libraryPath, "sdaiPutAttrBN");
//		// jn.setRetVal(Type.VOID);
//		// jn.setParameter(0, instance);
//		// jn.setParameter(1, Type.STRING, attributeName);
//		// jn.setParameter(2, valueType);
//		// switch (valueType) {
//		// case sdaiADB:
//		// jn.setParameter(3, ((Integer) value).intValue());
//		// break;
//		// case sdaiAGGR:
//		// jn.setParameter(3, ((Integer) value).intValue());
//		// break;
//		// case sdaiBINARY:
//		// jn.setParameter(3, ((Integer) value).intValue());
//		// break;
//		// case sdaiBOOLEAN:
//		// if ((Boolean) value)
//		// jn.setParameter(3, 1);
//		// else
//		// jn.setParameter(3, 0);
//		// break;
//		// case sdaiENUM:
//		// jn.setParameter(3, ((Integer) value).intValue());
//		// break;
//		// case sdaiINSTANCE:
//		// jn.setParameter(3, ((Integer) value).intValue());
//		// break;
//		// case sdaiINTEGER:
//		// jn.setParameter(3, ((Integer) value).intValue());
//		// break;
//		// case sdaiLOGICAL:
//		// jn.setParameter(3, ((Integer) value).intValue());
//		// break;
//		// case sdaiREAL:
//		// jn.setParameter(3, Type.DOUBLE, ((Double) value).toString());
//		// break;
//		// case sdaiSTRING:
//		// jn.setParameter(3, Type.STRING, (String) value);
//		// break;
//		// }
//		// jn.invoke();
//	}
//
//	private JNative nativeSdaiTestAttr;
//
//	/**
//	 * Implementing expected working correctly April 2006
//	 * 
//	 * @param instance
//	 *            A numeric instanceID that uniquely identifies an instance
//	 * @param attribute
//	 *            A numeric attributerID that uniquely identifies an attribute
//	 *            definition instance.
//	 * @return test result.
//	 * @throws Exception
//	 */
//	public boolean sdaiTestAttr(int instance, int attribute) throws Exception {
//		boolean returnValue = false;
//		if (nativeSdaiTestAttr == null) {
//			nativeSdaiTestAttr = new JNative(libraryPath, "sdaiTestAttr");
//		}
//		nativeSdaiTestAttr.setRetVal(Type.INT);
//		nativeSdaiTestAttr.setParameter(0, instance);
//		nativeSdaiTestAttr.setParameter(1, attribute);
//		nativeSdaiTestAttr.invoke();
//		returnValue = nativeSdaiTestAttr.getRetValAsInt() == 0 ? false : true;
//		return returnValue;
//
//		// boolean returnValue = false;
//		// jn = new JNative(libraryPath, "sdaiTestAttr");
//		// jn.setRetVal(Type.INT);
//		// jn.setParameter(0, instance);
//		// jn.setParameter(1, attribute);
//		// jn.invoke();
//		// returnValue = jn.getRetValAsInt() == 0 ? false : true;
//		// return returnValue;
//	}
//
//	private JNative nativeSdaiTestAttrBN;
//
//	/**
//	 * Implementing expected working correctly April 2006.
//	 * 
//	 * @param instance
//	 *            A numeric instanceID that uniquely identifies an instance.
//	 * @param attributeName
//	 *            A string that contains an attribute name existing in the
//	 *            mentioned instance.
//	 * @return
//	 * @throws Exception
//	 */
//	public boolean sdaiTestAttrBN(int instance, String attributeName) throws Exception {
//		boolean returnValue = false;
//		if (nativeSdaiTestAttrBN == null) {
//			nativeSdaiTestAttrBN = new JNative(libraryPath, "sdaiTestAttrBN");
//		}
//		nativeSdaiTestAttrBN.setRetVal(Type.INT);
//		nativeSdaiTestAttrBN.setParameter(0, instance);
//		nativeSdaiTestAttrBN.setParameter(1, Type.STRING, attributeName);
//		nativeSdaiTestAttrBN.invoke();
//		returnValue = nativeSdaiTestAttrBN.getRetValAsInt() == 0 ? false : true;
//		return returnValue;
//
//		// boolean returnValue = false;
//		// jn = new JNative(libraryPath, "sdaiTestAttrBN");
//		// jn.setRetVal(Type.INT);
//		// jn.setParameter(0, instance);
//		// jn.setParameter(1, Type.STRING, attributeName);
//		// jn.invoke();
//		// returnValue = jn.getRetValAsInt() == 0 ? false : true;
//		// return returnValue;
//	}
//
//	static public class SurfaceProperties {
//		private int model;
//		private int instance;
//		private int instanceList;
//		private int noVertices;
//		private int noIndices;
//		private double scale;
//
//		public SurfaceProperties(int model, int noVertices, int noIndices, double scale) {
//			this.model = model;
//			this.noVertices = noVertices;
//			this.noIndices = noIndices;
//			this.scale = scale;
//			this.instance = -1;
//			this.instanceList = -1;
//		}
//
//		public SurfaceProperties(int model, int instance, int noVertices, int noIndices, double scale) {
//			this(model, noVertices, noIndices, scale);
//			this.instance = instance;
//		}
//
//		public SurfaceProperties(int model, int instance, int instanceList, int noVertices, int noIndices, double scale) {
//			this(model, instance, noVertices, noIndices, scale);
//			this.instanceList = instanceList;
//		}
//
//		public int getModel() {
//			return model;
//		}
//
//		public int getInstance() {
//			return instance;
//		}
//
//		public int getInstanceList() {
//			return instanceList;
//		}
//
//		public int getIndicesCount() {
//			return noIndices;
//		}
//
//		public int getVerticesCount() {
//			return noVertices;
//		}
//
//		public double getScale() {
//			return scale;
//		}
//
//		public boolean hasInstance() {
//			return instance != -1;
//		}
//
//		public boolean hasInstanceList() {
//			return instanceList != -1;
//		}
//	}
//
//	private JNative nativeInitializeModelling;
//
//	/**
//	 * The surfaces of the IFC 3D geometry are calculated based on the supported
//	 * mapping (if not yet up2date). The amount of space required to store the
//	 * vertices and indices is returned.
//	 * 
//	 * @param model
//	 *            Unique number identifying the model in the opened file.
//	 * @param scale
//	 *            If this value is 0 no scaling is executed, if this value is 1
//	 *            all mashes will be scaled between -1 and 1.
//	 * @return The amount of space required to store the vertices and indices.
//	 */
//	public SurfaceProperties initializeModelling(int model, double scale) throws Exception {
//		if (nativeInitializeModelling == null) {
//			nativeInitializeModelling = new JNative(libraryPath, "initializeModelling");
//		}
//		nativeInitializeModelling.setRetVal(Type.INT);
//		nativeInitializeModelling.setParameter(0, model);
//		int pV = JNative.allocMemory(4);
//		nativeInitializeModelling.setParameter(1, pV);
//		int pI = JNative.allocMemory(4);
//		nativeInitializeModelling.setParameter(2, pI);
//		nativeInitializeModelling.setParameter(3, Type.DOUBLE, Double.toString(scale));
//		nativeInitializeModelling.invoke();
//		int noVertices = getInt(pV);
//		JNative.freeMemory(pV);
//		int noIndices = getInt(pI);
//		JNative.freeMemory(pI);
//		return new SurfaceProperties(model, noVertices, noIndices, scale);
//
//		// jn = new JNative(libraryPath, "initializeModelling");
//		// jn.setRetVal(Type.INT);
//		// jn.setParameter(0, model);
//		// int pV = JNative.allocMemory(4);
//		// jn.setParameter(1, pV);
//		// int pI = JNative.allocMemory(4);
//		// jn.setParameter(2, pI);
//		// jn.setParameter(3, Type.DOUBLE, Double.toString(scale));
//		// jn.invoke();
//		// int noVertices = getInt(pV);
//		// JNative.freeMemory(pV);
//		// int noIndices = getInt(pI);
//		// JNative.freeMemory(pI);
//		// return new SurfaceProperties(model, noVertices, noIndices, scale);
//	}
//
//	private JNative nativeInitializeClashes;
//	
//	public int initializeClashes(int modelId, double dist) throws Exception {
//		if (nativeInitializeClashes == null) {
//			nativeInitializeClashes = new JNative(libraryPath, "initializeClashes");
//		}
//		nativeInitializeClashes.setParameter(0, modelId);
//		int pV = JNative.allocMemory(4);
//		nativeInitializeClashes.setParameter(1, pV);
//		nativeInitializeClashes.setParameter(2, Type.DOUBLE, Double.toString(dist));
//		nativeInitializeClashes.invoke();
//		int noClashes = getInt(pV);
//		JNative.freeMemory(pV);
//		return noClashes;
//	}
//	
//	private JNative nativeFinalizeClashesByGuid;
//	
//	public Set<Clash> finalizeClashesByGuid(int modelId, int size) throws Exception {
//		Set<Clash> clashes = new HashSet<Clash>();
//		if (nativeFinalizeClashesByGuid == null) {
//			nativeFinalizeClashesByGuid = new JNative(libraryPath, "finalizeClashesByGuid");
//		}
//		int pG1 = JNative.allocMemory(size * 4);
//		int pG2 = JNative.allocMemory(size * 4);
//		nativeFinalizeClashesByGuid.setParameter(0, modelId);
//		nativeFinalizeClashesByGuid.setParameter(1, pG1);
//		nativeFinalizeClashesByGuid.setParameter(2, pG2);
//		nativeFinalizeClashesByGuid.invoke();
//		for (int i=0; i<size; i++) {
//			int string1Pointer = getInt(pG1 + i*4);
//			byte[] memory1 = JNative.getMemory(string1Pointer, 22);
//
//			int string2Pointer = getInt(pG2 + i*4);
//			byte[] memory2 = JNative.getMemory(string2Pointer, 22);
//
//			Clash clash = StoreFactory.eINSTANCE.createClash();
//			clash.setGuid1(new String(memory1));
//			clash.setGuid2(new String(memory2));
//			clashes.add(clash);
//		}
//		return clashes;
//	}
//	
//	private JNative nativeInitializeModellingInstance;
//
//	/**
//	 * The surfaces of the IFC 3D geometry object, i.e wall instance, column
//	 * instance, door instance, etc..
//	 * 
//	 * @param model
//	 *            Unique number identifying the model in the opened file.
//	 * @param scale
//	 *            If this value is 0.0 no scaling is executed, if this value is
//	 *            1.0 all mashes will be scaled between -1 and 1.
//	 * @param instance
//	 *            A numeric instanceID that uniquely identifies an instance.
//	 * @return
//	 * @throws Exception
//	 */
//	public SurfaceProperties initializeModellingInstance(int model, double scale, int instance) throws Exception {
//		if (nativeInitializeModellingInstance == null) {
//			nativeInitializeModellingInstance = new JNative(libraryPath, "initializeModellingInstance");
//		}
//		nativeInitializeModellingInstance.setRetVal(Type.INT);
//		nativeInitializeModellingInstance.setParameter(0, model);
//		int pV = JNative.allocMemory(4);
//		nativeInitializeModellingInstance.setParameter(1, pV);
//		int pI = JNative.allocMemory(4);
//		nativeInitializeModellingInstance.setParameter(2, pI);
//		nativeInitializeModellingInstance.setParameter(3, Type.DOUBLE, Double.toString(scale));
//		nativeInitializeModellingInstance.setParameter(4, instance);
//		nativeInitializeModellingInstance.invoke();
//		int noVertices = getInt(pV);
//		JNative.freeMemory(pV);
//		int noIndices = getInt(pI);
//		JNative.freeMemory(pI);
//		return new SurfaceProperties(model, instance, noVertices, noIndices, scale);
//
//		// jn = new JNative(libraryPath, "initializeModellingInstance");
//		// jn.setRetVal(Type.INT);
//		// jn.setParameter(0, model);
//		// int pV = JNative.allocMemory(4);
//		// jn.setParameter(1, pV);
//		// int pI = JNative.allocMemory(4);
//		// jn.setParameter(2, pI);
//		// jn.setParameter(3, Type.DOUBLE, Double.toString(scale));
//		// jn.setParameter(4, instance);
//		// jn.invoke();
//		// int noVertices = getInt(pV);
//		// JNative.freeMemory(pV);
//		// int noIndices = getInt(pI);
//		// JNative.freeMemory(pI);
//		// return new SurfaceProperties(model, instance, noVertices, noIndices,
//		// scale);
//	}
//
//	private JNative nativeInitializeModellingInstanceEx;
//
//	/**
//	 * The surfaces of the IFC 3D geometry object, i.e wall instance, column
//	 * instance, door instance, etc.. With defined what openings should be
//	 * subtracted from the solid.
//	 * 
//	 * @param model
//	 *            Unique number identifying the model in the opened file.
//	 * @param scale
//	 *            If this value is 0 no scaling is executed, if this value is 1
//	 *            all mashes will be scaled between -1 and 1.
//	 * @param instance
//	 *            A numeric instanceID that uniquely identifies an instance of a
//	 *            wall, column, door, etc.
//	 * @param instanceList
//	 *            Instances of openings that should be subtracted from the
//	 *            object.
//	 * @return
//	 * @throws Exception
//	 */
//	public SurfaceProperties initializeModellingInstanceEx(int model, double scale, int instance, int instanceList) throws Exception {
//		if (nativeInitializeModellingInstanceEx == null) {
//			nativeInitializeModellingInstanceEx = new JNative(libraryPath, "initializeModellingInstanceEx");
//		}
//		nativeInitializeModellingInstanceEx.setRetVal(Type.INT);
//		nativeInitializeModellingInstanceEx.setParameter(0, model);
//		int pV = JNative.allocMemory(4);
//		nativeInitializeModellingInstanceEx.setParameter(1, pV);
//		int pI = JNative.allocMemory(4);
//		nativeInitializeModellingInstanceEx.setParameter(2, pI);
//		nativeInitializeModellingInstanceEx.setParameter(3, Type.DOUBLE, Double.toString(scale));
//		nativeInitializeModellingInstanceEx.setParameter(4, instance);
//		nativeInitializeModellingInstanceEx.setParameter(5, instanceList);
//		nativeInitializeModellingInstanceEx.invoke();
//		int noVertices = getInt(pV);
//		JNative.freeMemory(pV);
//		int noIndices = getInt(pI);
//		JNative.freeMemory(pI);
//		return new SurfaceProperties(model, instance, instanceList, noVertices, noIndices, scale);
//
//		// jn = new JNative(libraryPath, "initializeModellingInstanceEx");
//		// jn.setRetVal(Type.INT);
//		// jn.setParameter(0, model);
//		// int pV = JNative.allocMemory(4);
//		// jn.setParameter(1, pV);
//		// int pI = JNative.allocMemory(4);
//		// jn.setParameter(2, pI);
//		// jn.setParameter(3, Type.DOUBLE, Double.toString(scale));
//		// jn.setParameter(4, instance);
//		// jn.setParameter(5, instanceList);
//		// jn.invoke();
//		// int noVertices = getInt(pV);
//		// JNative.freeMemory(pV);
//		// int noIndices = getInt(pI);
//		// JNative.freeMemory(pI);
//		// return new SurfaceProperties(model, instance, instanceList,
//		// noVertices,
//		// noIndices, scale);
//	}
//
//	private JNative nativeFinalizeModelling;
//
//	/**
//	 * Fills the allocated areas (allocated by the calling program) with the
//	 * vertices and indices generated based on the supported mapping.
//	 * 
//	 * @param model
//	 *            Unique number identifying the model in the opened file.
//	 * @param coordinates
//	 *            The calling program should be sure this parameter is pointing
//	 *            to an area with size 3 * sizeof(float) * noVertices (as given
//	 *            in InitializeModelling(..)). The area will be filled with the
//	 *            correct vectors.
//	 * @param normals
//	 *            The calling program should be sure this parameter is pointing
//	 *            to an area with size 3 * sizeof(float) * noVertices (as given
//	 *            in InitializeModelling(..)). The area will be filled with the
//	 *            correct normals.
//	 * @param indices
//	 *            The calling program should be sure this parameter is pointing
//	 *            to an area with size sizeof(int) * noIndices (as given in
//	 *            InitializeModelling(..)). The area will be filled with the
//	 *            indices (used to build meshes).
//	 * @return
//	 * @throws Exception
//	 */
//	public int finalizeModelling(int model, float[] coordinates, float[] normals, int[] indices) throws Exception {
//		int fvf = 0;
//		int size = 0;
//		int noVertices = 0;
//		int noIndices = 0;
//		if (coordinates != null) {
//			fvf |= IfcEngine.D3DFVF_XYZ;
//			size += 3;
//			noVertices = coordinates.length / 3;
//		}
//		if (normals != null) {
//			fvf |= IfcEngine.D3DFVF_NORMAL;
//			size += 3;
//		}
//		if (indices != null) {
//			noIndices = indices.length;
//		}
//
//		if (nativeFinalizeModelling == null) {
//			nativeFinalizeModelling = new JNative(libraryPath, "finalizeModelling");
//		}
//		nativeFinalizeModelling.setRetVal(Type.INT);
//		nativeFinalizeModelling.setParameter(0, model);
//		int pV = JNative.allocMemory(noVertices * size * 4);
//		nativeFinalizeModelling.setParameter(1, pV);
//		int pI = JNative.allocMemory(noIndices * 4);
//		nativeFinalizeModelling.setParameter(2, pI);
//		nativeFinalizeModelling.setParameter(3, fvf);
//		nativeFinalizeModelling.invoke();
//		for (int i = 0; i < noVertices * size; i += size) {
//			int p = i;
//			if ((fvf & IfcEngine.D3DFVF_XYZ) != 0) {
//				for (int j = 0; j < 3; j++) {
//					coordinates[i / 2 + j] = getFloat(pV + (p * 4));
//					p++;
//				}
//			}
//			if ((fvf & IfcEngine.D3DFVF_NORMAL) != 0) {
//				for (int j = 0; j < 3; j++) {
//					normals[i / 2 + j] = getFloat(pV + (p * 4));
//					p++;
//				}
//			}
//		}
//		JNative.freeMemory(pV);
//		for (int i = 0; i < noIndices; i++) {
//			indices[i] = getInt(pI + (i * 4));
//		}
//		JNative.freeMemory(pI);
//		return nativeFinalizeModelling.getRetValAsInt();
//
//		// int fvf = 0;
//		// int size = 0;
//		// int noVertices = 0;
//		// int noIndices = 0;
//		// if (coordinates != null) {
//		// fvf |= IfcEngine.D3DFVF_XYZ;
//		// size += 3;
//		// noVertices = coordinates.length / 3;
//		// }
//		// if (normals != null) {
//		// fvf |= IfcEngine.D3DFVF_NORMAL;
//		// size += 3;
//		// }
//		// if (indices != null) {
//		// noIndices = indices.length;
//		// }
//		//
//		// jn = new JNative(libraryPath, "finalizeModelling");
//		// jn.setRetVal(Type.INT);
//		// jn.setParameter(0, model);
//		// int pV = JNative.allocMemory(noVertices * size * 4);
//		// jn.setParameter(1, pV);
//		// int pI = JNative.allocMemory(noIndices * 4);
//		// jn.setParameter(2, pI);
//		// jn.setParameter(3, fvf);
//		// jn.invoke();
//		// for (int i = 0; i < noVertices * size; i += size) {
//		// int p = i;
//		// if ((fvf & IfcEngine.D3DFVF_XYZ) != 0) {
//		// for (int j = 0; j < 3; j++) {
//		// coordinates[i / 2 + j] = getFloat(pV + (p * 4));
//		// p++;
//		// }
//		// }
//		// if ((fvf & IfcEngine.D3DFVF_NORMAL) != 0) {
//		// for (int j = 0; j < 3; j++) {
//		// normals[i / 2 + j] = getFloat(pV + (p * 4));
//		// p++;
//		// }
//		// }
//		// }
//		// JNative.freeMemory(pV);
//		// for (int i = 0; i < noIndices; i++) {
//		// indices[i] = getInt(pI + (i * 4));
//		// }
//		// JNative.freeMemory(pI);
//		// return jn.getRetValAsInt();
//	}
//
//	static public class InstanceVisualisationProperties {
//		private int startVertex;
//		private int startIndex;
//		private int primitiveCount;
//
//		public InstanceVisualisationProperties(int startVertex, int startIndex, int primitiveCount) {
//			this.startVertex = startVertex;
//			this.startIndex = startIndex;
//			this.primitiveCount = primitiveCount;
//		}
//
//		public int getStartVertex() {
//			return startVertex;
//		}
//
//		public int getStartIndex() {
//			return startIndex;
//		}
//
//		public int getPrimitiveCount() {
//			return primitiveCount;
//		}
//	}
//
//	private JNative nativeGetInstanceInModelling;
//
//	/**
//	 * Returns the visualisation properties of a specific express instance.
//	 * 
//	 * @param model
//	 *            Unique number identifying the model in the opened file.
//	 * @param instance
//	 *            A numeric instanceID that uniquely identifies an instance.
//	 * @param mode
//	 *            The representation mode that should be visualised, options: 0
//	 *            line representation; 1 complex object representation; 2
//	 *            bounding box representation.
//	 * @return
//	 * @throws Exception
//	 */
//	public InstanceVisualisationProperties getInstanceInModelling(int model, int instance, int mode) throws Exception {
//		if (nativeGetInstanceInModelling == null) {
//			nativeGetInstanceInModelling = new JNative(libraryPath, "getInstanceInModelling");
//		}
//		nativeGetInstanceInModelling.setRetVal(Type.INT);
//		nativeGetInstanceInModelling.setParameter(0, model);
//		nativeGetInstanceInModelling.setParameter(1, instance);
//		nativeGetInstanceInModelling.setParameter(2, mode);
//		int pV = JNative.allocMemory(4);
//		nativeGetInstanceInModelling.setParameter(3, pV);
//		int pI = JNative.allocMemory(4);
//		nativeGetInstanceInModelling.setParameter(4, pI);
//		int pC = JNative.allocMemory(4);
//		nativeGetInstanceInModelling.setParameter(5, pC);
//		nativeGetInstanceInModelling.invoke();
//		int startVertex = getInt(pV);
//		JNative.freeMemory(pV);
//		int startIndex = getInt(pI);
//		JNative.freeMemory(pI);
//		int primitiveCount = getInt(pC);
//		JNative.freeMemory(pC);
//		return new InstanceVisualisationProperties(startVertex, startIndex, primitiveCount);
//
//		// jn = new JNative(libraryPath, "getInstanceInModelling");
//		// jn.setRetVal(Type.INT);
//		// jn.setParameter(0, model);
//		// jn.setParameter(1, instance);
//		// jn.setParameter(2, mode);
//		// int pV = JNative.allocMemory(4);
//		// jn.setParameter(3, pV);
//		// int pI = JNative.allocMemory(4);
//		// jn.setParameter(4, pI);
//		// int pC = JNative.allocMemory(4);
//		// jn.setParameter(5, pC);
//		// jn.invoke();
//		// int startVertex = getInt(pV);
//		// JNative.freeMemory(pV);
//		// int startIndex = getInt(pI);
//		// JNative.freeMemory(pI);
//		// int primitiveCount = getInt(pC);
//		// JNative.freeMemory(pC);
//		// return new InstanceVisualisationProperties(startVertex, startIndex,
//		// primitiveCount);
//	}
//
//	public class InstanceDerivedProperties {
//		private int model, instance;
//		private double height, width, thickness;
//
//		public InstanceDerivedProperties(int model, int instance, double height, double width, double thickness) {
//			this.model = model;
//			this.instance = instance;
//			this.height = height;
//			this.width = width;
//			this.thickness = thickness;
//		}
//
//		public int getModel() {
//			return model;
//		}
//
//		public int getInstance() {
//			return instance;
//		}
//
//		public double getHeight() {
//			return height;
//		}
//
//		public double getWidth() {
//			return width;
//		}
//
//		public double getThickness() {
//			return thickness;
//		}
//	}
//
//	private JNative nativeGetInstanceDerivedPropertiesInModelling;
//
//	/**
//	 * Return derived properties from the 3D visualisation.
//	 * 
//	 * @param model
//	 *            Unique number identifying the model in the opened file.
//	 * @param instance
//	 *            A numeric instanceID that uniquely identifies an instance.
//	 * @return InstanceDerivedProperties object
//	 * @throws Exception
//	 */
//	public InstanceDerivedProperties getInstanceDerivedPropertiesInModelling(int model, int instance) throws Exception {
//		if (nativeGetInstanceDerivedPropertiesInModelling == null) {
//			nativeGetInstanceDerivedPropertiesInModelling = new JNative(libraryPath, "getInstanceDerivedPropertiesInModelling");
//		}
//		nativeGetInstanceDerivedPropertiesInModelling.setRetVal(Type.INT);
//		nativeGetInstanceDerivedPropertiesInModelling.setParameter(0, model);
//		nativeGetInstanceDerivedPropertiesInModelling.setParameter(1, instance);
//		int pH = JNative.allocMemory(8);
//		nativeGetInstanceDerivedPropertiesInModelling.setParameter(2, pH);
//		int pW = JNative.allocMemory(8);
//		nativeGetInstanceDerivedPropertiesInModelling.setParameter(2, pW);
//		int pT = JNative.allocMemory(8);
//		nativeGetInstanceDerivedPropertiesInModelling.setParameter(2, pT);
//		nativeGetInstanceDerivedPropertiesInModelling.invoke();
//		double height = getDouble(getInt(pH));
//		JNative.freeMemory(pH);
//		double width = getDouble(getInt(pW));
//		JNative.freeMemory(pW);
//		double thickness = getDouble(getInt(pT));
//		JNative.freeMemory(pT);
//		return new InstanceDerivedProperties(model, instance, height, width, thickness);
//
//		// jn = new JNative(libraryPath,
//		// "getInstanceDerivedPropertiesInModelling");
//		// jn.setRetVal(Type.INT);
//		// jn.setParameter(0, model);
//		// jn.setParameter(1, instance);
//		// int pH = JNative.allocMemory(8);
//		// jn.setParameter(2, pH);
//		// int pW = JNative.allocMemory(8);
//		// jn.setParameter(2, pW);
//		// int pT = JNative.allocMemory(8);
//		// jn.setParameter(2, pT);
//		// jn.invoke();
//		// double height = getDouble(getInt(pH));
//		// JNative.freeMemory(pH);
//		// double width = getDouble(getInt(pW));
//		// JNative.freeMemory(pW);
//		// double thickness = getDouble(getInt(pT));
//		// JNative.freeMemory(pT);
//		// return new InstanceDerivedProperties(model, instance, height, width,
//		// thickness);
//	}
//
//	public class InstanceDerivedBoundingBox {
//		int model, instance;
//		double ox, oy, oz, vx, vy, vz;
//
//		public InstanceDerivedBoundingBox(int model, int instance, double ox, double oy, double oz, double vx, double vy, double vz) {
//			this.model = model;
//			this.instance = instance;
//			this.ox = ox;
//			this.oy = oy;
//			this.oz = oz;
//			this.vx = vx;
//			this.vy = vy;
//			this.vz = vz;
//		}
//
//		public int getModel() {
//			return model;
//		}
//
//		public int getInstance() {
//			return instance;
//		}
//
//		public double getOx() {
//			return ox;
//		}
//
//		public double getOy() {
//			return oy;
//		}
//
//		public double getOz() {
//			return oz;
//		}
//
//		public double getVx() {
//			return vx;
//		}
//
//		public double getVy() {
//			return vy;
//		}
//
//		public double getVz() {
//			return vz;
//		}
//	}
//
//	private JNative nativeGetInstanceDerivedBoundingBox;
//
//	/**
//	 * Returns advanced bounding box measures, can be used in combination with
//	 * getInstanceDerivedTransformationMatrix().
//	 * 
//	 * @param model
//	 *            Unique number identifying the model in the opened file.
//	 * @param instance
//	 *            A numeric instanceID that uniquely identifies an instance.
//	 * @return InstanceDerivedBoundingBox object
//	 * @throws Exception
//	 */
//	public InstanceDerivedBoundingBox getInstanceDerivedBoundingBox(int model, int instance) throws Exception {
//		if (nativeGetInstanceDerivedBoundingBox == null) {
//			nativeGetInstanceDerivedBoundingBox = new JNative(libraryPath, "_getInstanceDerivedBoundingBox@32");
//		}
//		nativeGetInstanceDerivedBoundingBox.setRetVal(Type.INT);
//		nativeGetInstanceDerivedBoundingBox.setParameter(0, model);
//		nativeGetInstanceDerivedBoundingBox.setParameter(1, instance);
//		int pOx = JNative.allocMemory(8);
//		nativeGetInstanceDerivedBoundingBox.setParameter(2, pOx);
//		int pOy = JNative.allocMemory(8);
//		nativeGetInstanceDerivedBoundingBox.setParameter(3, pOy);
//		int pOz = JNative.allocMemory(8);
//		nativeGetInstanceDerivedBoundingBox.setParameter(3, pOz);
//		int pVx = JNative.allocMemory(8);
//		nativeGetInstanceDerivedBoundingBox.setParameter(4, pVx);
//		int pVy = JNative.allocMemory(8);
//		nativeGetInstanceDerivedBoundingBox.setParameter(5, pVy);
//		int pVz = JNative.allocMemory(8);
//		nativeGetInstanceDerivedBoundingBox.setParameter(6, pVz);
//		nativeGetInstanceDerivedBoundingBox.invoke();
//		double ox = getDouble(getInt(pOx));
//		JNative.freeMemory(pOx);
//		double oy = getDouble(getInt(pOy));
//		JNative.freeMemory(pOy);
//		double oz = getDouble(getInt(pOz));
//		JNative.freeMemory(pOz);
//		double vx = getDouble(getInt(pVx));
//		JNative.freeMemory(pVx);
//		double vy = getDouble(getInt(pVy));
//		JNative.freeMemory(pVy);
//		double vz = getDouble(getInt(pVz));
//		JNative.freeMemory(pVz);
//		return new InstanceDerivedBoundingBox(model, instance, ox, oy, oz, vx, vy, vz);
//
//		// jn = new JNative(libraryPath,
//		// "_getInstanceDerivedBoundingBox@32");
//		// jn.setRetVal(Type.INT);
//		// jn.setParameter(0, model);
//		// jn.setParameter(1, instance);
//		// int pOx = JNative.allocMemory(8);
//		// jn.setParameter(2, pOx);
//		// int pOy = JNative.allocMemory(8);
//		// jn.setParameter(3, pOy);
//		// int pOz = JNative.allocMemory(8);
//		// jn.setParameter(3, pOz);
//		// int pVx = JNative.allocMemory(8);
//		// jn.setParameter(4, pVx);
//		// int pVy = JNative.allocMemory(8);
//		// jn.setParameter(5, pVy);
//		// int pVz = JNative.allocMemory(8);
//		// jn.setParameter(6, pVz);
//		// jn.invoke();
//		// double ox = getDouble(getInt(pOx));
//		// JNative.freeMemory(pOx);
//		// double oy = getDouble(getInt(pOy));
//		// JNative.freeMemory(pOy);
//		// double oz = getDouble(getInt(pOz));
//		// JNative.freeMemory(pOz);
//		// double vx = getDouble(getInt(pVx));
//		// JNative.freeMemory(pVx);
//		// double vy = getDouble(getInt(pVy));
//		// JNative.freeMemory(pVy);
//		// double vz = getDouble(getInt(pVz));
//		// JNative.freeMemory(pVz);
//		// return new InstanceDerivedBoundingBox(model, instance, ox, oy, oz,
//		// vx,
//		// vy, vz);
//	}
//
//	public class InstanceDerivedTransformationMatrix {
//		int model, instance;
//		double _11, _12, _13, _14, _21, _22, _23, _24, _31, _32, _33, _34, _41, _42, _43, _44;
//
//		public InstanceDerivedTransformationMatrix(int model, int instance, double _11, double _12, double _13, double _14, double _21, double _22, double _23, double _24,
//				double _31, double _32, double _33, double _34, double _41, double _42, double _43, double _44) {
//			this.model = model;
//			this.instance = instance;
//			this._11 = _11;
//			this._12 = _12;
//			this._13 = _13;
//			this._14 = _14;
//			this._21 = _21;
//			this._22 = _22;
//			this._23 = _23;
//			this._24 = _24;
//			this._31 = _31;
//			this._32 = _32;
//			this._33 = _33;
//			this._34 = _34;
//			this._41 = _41;
//			this._42 = _42;
//			this._43 = _43;
//			this._44 = _44;
//		}
//
//		public int getModel() {
//			return model;
//		}
//
//		public int getInstance() {
//			return instance;
//		}
//
//		public double get_11() {
//			return _11;
//		}
//
//		public double get_12() {
//			return _12;
//		}
//
//		public double get_13() {
//			return _13;
//		}
//
//		public double get_14() {
//			return _14;
//		}
//
//		public double get_21() {
//			return _21;
//		}
//
//		public double get_22() {
//			return _22;
//		}
//
//		public double get_23() {
//			return _23;
//		}
//
//		public double get_24() {
//			return _24;
//		}
//
//		public double get_31() {
//			return _31;
//		}
//
//		public double get_32() {
//			return _32;
//		}
//
//		public double get_33() {
//			return _33;
//		}
//
//		public double get_34() {
//			return _34;
//		}
//
//		public double get_41() {
//			return _41;
//		}
//
//		public double get_42() {
//			return _42;
//		}
//
//		public double get_43() {
//			return _43;
//		}
//
//		public double get_44() {
//			return _44;
//		}
//
//	}
//
//	private JNative nativeGetInstanceDerivedTransformationMatrix;
//
//	/**
//	 * Returns internally created transformation matrix. This function can be
//	 * applied to every instance that needs a transformation matrix (i.e.
//	 * IfcColumn, IfcLocalPlacement, IfcPolyline).
//	 * 
//	 * @param model
//	 *            Unique number identifying the model in the opened file.
//	 * @param instance
//	 *            A numeric instanceID that uniquely identifies an instance.
//	 * @return InstanceDerivedTransformationMatrix object
//	 * @throws Exception
//	 */
//	public InstanceDerivedTransformationMatrix getInstanceDerivedTransformationMatrix(int model, int instance) throws Exception {
//		if (nativeGetInstanceDerivedTransformationMatrix == null) {
//			nativeGetInstanceDerivedTransformationMatrix = new JNative(libraryPath, "getInstanceDerivedTransformationMatrix");
//		}
//		nativeGetInstanceDerivedTransformationMatrix.setRetVal(Type.INT);
//		nativeGetInstanceDerivedTransformationMatrix.setParameter(0, model);
//		nativeGetInstanceDerivedTransformationMatrix.setParameter(1, instance);
//		int p_11 = JNative.allocMemory(8);
//		nativeGetInstanceDerivedTransformationMatrix.setParameter(2, p_11);
//		int p_12 = JNative.allocMemory(8);
//		nativeGetInstanceDerivedTransformationMatrix.setParameter(3, p_12);
//		int p_13 = JNative.allocMemory(8);
//		nativeGetInstanceDerivedTransformationMatrix.setParameter(4, p_13);
//		int p_14 = JNative.allocMemory(8);
//		nativeGetInstanceDerivedTransformationMatrix.setParameter(5, p_14);
//		int p_21 = JNative.allocMemory(8);
//		nativeGetInstanceDerivedTransformationMatrix.setParameter(6, p_21);
//		int p_22 = JNative.allocMemory(8);
//		nativeGetInstanceDerivedTransformationMatrix.setParameter(7, p_22);
//		int p_23 = JNative.allocMemory(8);
//		nativeGetInstanceDerivedTransformationMatrix.setParameter(8, p_23);
//		int p_24 = JNative.allocMemory(8);
//		nativeGetInstanceDerivedTransformationMatrix.setParameter(9, p_24);
//		int p_31 = JNative.allocMemory(8);
//		nativeGetInstanceDerivedTransformationMatrix.setParameter(10, p_31);
//		int p_32 = JNative.allocMemory(8);
//		nativeGetInstanceDerivedTransformationMatrix.setParameter(11, p_32);
//		int p_33 = JNative.allocMemory(8);
//		nativeGetInstanceDerivedTransformationMatrix.setParameter(12, p_33);
//		int p_34 = JNative.allocMemory(8);
//		nativeGetInstanceDerivedTransformationMatrix.setParameter(13, p_34);
//		int p_41 = JNative.allocMemory(8);
//		nativeGetInstanceDerivedTransformationMatrix.setParameter(14, p_41);
//		int p_42 = JNative.allocMemory(8);
//		nativeGetInstanceDerivedTransformationMatrix.setParameter(15, p_42);
//		int p_43 = JNative.allocMemory(8);
//		nativeGetInstanceDerivedTransformationMatrix.setParameter(16, p_43);
//		int p_44 = JNative.allocMemory(8);
//		nativeGetInstanceDerivedTransformationMatrix.setParameter(17, p_44);
//		nativeGetInstanceDerivedTransformationMatrix.invoke();
//		double _11 = getDouble(getInt(p_11));
//		JNative.freeMemory(p_11);
//		double _12 = getDouble(getInt(p_12));
//		JNative.freeMemory(p_12);
//		double _13 = getDouble(getInt(p_13));
//		JNative.freeMemory(p_13);
//		double _14 = getDouble(getInt(p_14));
//		JNative.freeMemory(p_14);
//		double _21 = getDouble(getInt(p_21));
//		JNative.freeMemory(p_21);
//		double _22 = getDouble(getInt(p_22));
//		JNative.freeMemory(p_22);
//		double _23 = getDouble(getInt(p_23));
//		JNative.freeMemory(p_23);
//		double _24 = getDouble(getInt(p_24));
//		JNative.freeMemory(p_24);
//		double _31 = getDouble(getInt(p_31));
//		JNative.freeMemory(p_31);
//		double _32 = getDouble(getInt(p_32));
//		JNative.freeMemory(p_32);
//		double _33 = getDouble(getInt(p_33));
//		JNative.freeMemory(p_33);
//		double _34 = getDouble(getInt(p_34));
//		JNative.freeMemory(p_34);
//		double _41 = getDouble(getInt(p_41));
//		JNative.freeMemory(p_41);
//		double _42 = getDouble(getInt(p_42));
//		JNative.freeMemory(p_42);
//		double _43 = getDouble(getInt(p_43));
//		JNative.freeMemory(p_43);
//		double _44 = getDouble(getInt(p_44));
//		JNative.freeMemory(p_44);
//		return new InstanceDerivedTransformationMatrix(model, instance, _11, _12, _13, _14, _21, _22, _23, _24, _31, _32, _33, _34, _41, _42, _43, _44);
//
//		// jn = new JNative(libraryPath,
//		// "getInstanceDerivedTransformationMatrix");
//		// jn.setRetVal(Type.INT);
//		// jn.setParameter(0, model);
//		// jn.setParameter(1, instance);
//		// int p_11 = JNative.allocMemory(8);
//		// jn.setParameter(2, p_11);
//		// int p_12 = JNative.allocMemory(8);
//		// jn.setParameter(3, p_12);
//		// int p_13 = JNative.allocMemory(8);
//		// jn.setParameter(4, p_13);
//		// int p_14 = JNative.allocMemory(8);
//		// jn.setParameter(5, p_14);
//		// int p_21 = JNative.allocMemory(8);
//		// jn.setParameter(6, p_21);
//		// int p_22 = JNative.allocMemory(8);
//		// jn.setParameter(7, p_22);
//		// int p_23 = JNative.allocMemory(8);
//		// jn.setParameter(8, p_23);
//		// int p_24 = JNative.allocMemory(8);
//		// jn.setParameter(9, p_24);
//		// int p_31 = JNative.allocMemory(8);
//		// jn.setParameter(10, p_31);
//		// int p_32 = JNative.allocMemory(8);
//		// jn.setParameter(11, p_32);
//		// int p_33 = JNative.allocMemory(8);
//		// jn.setParameter(12, p_33);
//		// int p_34 = JNative.allocMemory(8);
//		// jn.setParameter(13, p_34);
//		// int p_41 = JNative.allocMemory(8);
//		// jn.setParameter(14, p_41);
//		// int p_42 = JNative.allocMemory(8);
//		// jn.setParameter(15, p_42);
//		// int p_43 = JNative.allocMemory(8);
//		// jn.setParameter(16, p_43);
//		// int p_44 = JNative.allocMemory(8);
//		// jn.setParameter(17, p_44);
//		// jn.invoke();
//		// double _11 = getDouble(getInt(p_11));
//		// JNative.freeMemory(p_11);
//		// double _12 = getDouble(getInt(p_12));
//		// JNative.freeMemory(p_12);
//		// double _13 = getDouble(getInt(p_13));
//		// JNative.freeMemory(p_13);
//		// double _14 = getDouble(getInt(p_14));
//		// JNative.freeMemory(p_14);
//		// double _21 = getDouble(getInt(p_21));
//		// JNative.freeMemory(p_21);
//		// double _22 = getDouble(getInt(p_22));
//		// JNative.freeMemory(p_22);
//		// double _23 = getDouble(getInt(p_23));
//		// JNative.freeMemory(p_23);
//		// double _24 = getDouble(getInt(p_24));
//		// JNative.freeMemory(p_24);
//		// double _31 = getDouble(getInt(p_31));
//		// JNative.freeMemory(p_31);
//		// double _32 = getDouble(getInt(p_32));
//		// JNative.freeMemory(p_32);
//		// double _33 = getDouble(getInt(p_33));
//		// JNative.freeMemory(p_33);
//		// double _34 = getDouble(getInt(p_34));
//		// JNative.freeMemory(p_34);
//		// double _41 = getDouble(getInt(p_41));
//		// JNative.freeMemory(p_41);
//		// double _42 = getDouble(getInt(p_42));
//		// JNative.freeMemory(p_42);
//		// double _43 = getDouble(getInt(p_43));
//		// JNative.freeMemory(p_43);
//		// double _44 = getDouble(getInt(p_44));
//		// JNative.freeMemory(p_44);
//		// return new InstanceDerivedTransformationMatrix(model, instance, _11,
//		// _12, _13, _14, _21, _22, _23, _24, _31, _32, _33, _34, _41,
//		// _42, _43, _44);
//	}
//
//	private JNative nativeCircleSegments;
//
//	/**
//	 * Change the number of segments a circle should be represented as.
//	 * 
//	 * @param circles
//	 *            The count of segments for each circle or circle part (by
//	 *            default 30). 0 is ignored.
//	 * @param smallCircles
//	 *            The count of segments for less important circle(parts), like
//	 *            circles between the legs in a I, T, U or L profile structure
//	 *            (by default 5). 0 is ignored.
//	 * @throws Exception
//	 */
//	public void circleSegments(int circles, int smallCircles) throws Exception {
//		if (nativeCircleSegments == null) {
//			nativeCircleSegments = new JNative(libraryPath, "circleSegments");
//		}
//		nativeCircleSegments.setRetVal(Type.VOID);
//		nativeCircleSegments.setParameter(0, circles);
//		nativeCircleSegments.setParameter(1, smallCircles);
//		nativeCircleSegments.invoke();
//
//		// jn = new JNative(libraryPath, "circleSegments");
//		// jn.setRetVal(Type.VOID);
//		// jn.setParameter(0, circles);
//		// jn.setParameter(1, smallCircles);
//		// jn.invoke();
//	}
//
//	private JNative nativeGetTimeStamp;
//
//	/**
//	 * Returns an integer representing internal 'clock'.
//	 * 
//	 * @param model
//	 *            Unique number identifying the model in the opened file.
//	 * @return an integer representing internal 'clock'.
//	 * @throws Exception
//	 */
//	public int getTimeStamp(int model) throws Exception {
//		int returnValue = 0;
//		if (nativeGetTimeStamp == null) {
//			nativeGetTimeStamp = new JNative(libraryPath, "getTimeStamp");
//		}
//		nativeGetTimeStamp.setRetVal(Type.INT);
//		nativeGetTimeStamp.setParameter(0, model);
//		nativeGetTimeStamp.invoke();
//		returnValue = nativeGetTimeStamp.getRetValAsInt();
//		return returnValue;
//
//		// int returnValue = 0;
//		// jn = new JNative(libraryPath, "getTimeStamp");
//		// jn.setRetVal(Type.INT);
//		// jn.setParameter(0, model);
//		// jn.invoke();
//		// returnValue = jn.getRetValAsInt();
//		// return returnValue;
//	}
//
//	private JNative nativeGetChangedData;
//
//	/**
//	 * @param model
//	 * @param timeStamp
//	 * @return
//	 * @throws Exception
//	 */
//	public String getChangedData(int model, int timeStamp) throws Exception {
//		if (nativeGetChangedData == null) {
//			nativeGetChangedData = new JNative(libraryPath, "getChangedData");
//		}
//		nativeGetChangedData.setRetVal(Type.STRING);
//		nativeGetChangedData.setParameter(0, model);
//		nativeGetChangedData.setParameter(1, timeStamp);
//		nativeGetChangedData.invoke();
//		return nativeGetChangedData.getRetVal();
//
//		// jn = new JNative(libraryPath, "getChangedData");
//		// jn.setRetVal(Type.STRING);
//		// jn.setParameter(0, model);
//		// jn.setParameter(1, timeStamp);
//		// jn.invoke();
//		// return jn.getRetVal();
//	}
//
//	private JNative nativeSetChangedData;
//
//	/**
//	 * @param model
//	 * @param timeStamp
//	 * @param changedData
//	 * @throws Exception
//	 */
//	public void setChangedData(int model, int timeStamp, String changedData) throws Exception {
//		if (nativeSetChangedData == null) {
//			nativeSetChangedData = new JNative(libraryPath, "setChangedData");
//		}
//		nativeSetChangedData.setRetVal(Type.VOID);
//		nativeSetChangedData.setParameter(0, model);
//		nativeSetChangedData.setParameter(1, timeStamp);
//		nativeSetChangedData.setParameter(2, Type.STRING, changedData);
//		nativeSetChangedData.invoke();
//
//		// jn = new JNative(libraryPath, "setChangedData");
//		// jn.setRetVal(Type.VOID);
//		// jn.setParameter(0, model);
//		// jn.setParameter(1, timeStamp);
//		// jn.setParameter(2, Type.STRING, changedData);
//		// jn.invoke();
//	}
//
//	private JNative nativeInternalGetBoundingBox;
//
//	/**
//	 * @param model
//	 * @param instance
//	 * @return
//	 * @throws Exception
//	 */
//	public int internalGetBoundingBox(int model, int instance) throws Exception {
//		int returnValue = 0;
//		if (nativeInternalGetBoundingBox == null) {
//			nativeInternalGetBoundingBox = new JNative(libraryPath, "internalGetBoundingBox");
//		}
//		nativeInternalGetBoundingBox.setRetVal(Type.INT);
//		nativeInternalGetBoundingBox.setParameter(0, model);
//		nativeInternalGetBoundingBox.setParameter(1, instance);
//		nativeInternalGetBoundingBox.invoke();
//		returnValue = nativeInternalGetBoundingBox.getRetValAsInt();
//		return returnValue;
//
//		// int returnValue = 0;
//		// jn = new JNative(libraryPath, "internalGetBoundingBox");
//		// jn.setRetVal(Type.INT);
//		// jn.setParameter(0, model);
//		// jn.setParameter(1, instance);
//		// jn.invoke();
//		// returnValue = jn.getRetValAsInt();
//		// return returnValue;
//	}
//
//	private JNative nativeInternalGetCenter;
//
//	/**
//	 * @param model
//	 * @param instance
//	 * @return
//	 * @throws Exception
//	 */
//	public int internalGetCenter(int model, int instance) throws Exception {
//		int returnValue = 0;
//		if (nativeInternalGetCenter == null) {
//			nativeInternalGetCenter = new JNative(libraryPath, "internalGetCenter");
//		}
//		nativeInternalGetCenter.setRetVal(Type.INT);
//		nativeInternalGetCenter.setParameter(0, model);
//		nativeInternalGetCenter.setParameter(1, instance);
//		nativeInternalGetCenter.invoke();
//		returnValue = nativeInternalGetCenter.getRetValAsInt();
//		return returnValue;
//
//		// int returnValue = 0;
//		// jn = new JNative(libraryPath, "internalGetCenter");
//		// jn.setRetVal(Type.INT);
//		// jn.setParameter(0, model);
//		// jn.setParameter(1, instance);
//		// jn.invoke();
//		// returnValue = jn.getRetValAsInt();
//		// return returnValue;
//	}
//
//	private JNative nativeInternalSetLink;
//
//	/**
//	 * @param instance
//	 * @param attributeName
//	 * @param linked_id
//	 * @throws Exception
//	 */
//	public void internalSetLink(int instance, String attributeName, int linked_id) throws Exception {
//		if (nativeInternalSetLink == null) {
//			nativeInternalSetLink = new JNative(libraryPath, "internalSetLink");
//		}
//		nativeInternalSetLink.setRetVal(Type.VOID);
//		nativeInternalSetLink.setParameter(0, instance);
//		nativeInternalSetLink.setParameter(1, Type.STRING, attributeName);
//		nativeInternalSetLink.setParameter(2, linked_id);
//		nativeInternalSetLink.invoke();
//
//		// jn = new JNative(libraryPath, "internalSetLink");
//		// jn.setRetVal(Type.VOID);
//		// jn.setParameter(0, instance);
//		// jn.setParameter(1, Type.STRING, attributeName);
//		// jn.setParameter(2, linked_id);
//		// jn.invoke();
//	}
//
//	private JNative nativeInternalAddAggrLink;
//
//	/**
//	 * @param list
//	 * @param linked_id
//	 * @throws Exception
//	 */
//	public void internalAddAggrLink(int list, int linked_id) throws Exception {
//		if (nativeInternalAddAggrLink == null) {
//			nativeInternalAddAggrLink = new JNative(libraryPath, "internalAddAggrLink");
//		}
//		nativeInternalAddAggrLink.setRetVal(Type.VOID);
//		nativeInternalAddAggrLink.setParameter(0, list);
//		nativeInternalAddAggrLink.setParameter(1, linked_id);
//		nativeInternalAddAggrLink.invoke();
//
//		// jn = new JNative(libraryPath, "internalAddAggrLink");
//		// jn.setRetVal(Type.VOID);
//		// jn.setParameter(0, list);
//		// jn.setParameter(1, linked_id);
//		// jn.invoke();
//	}
//
//	private JNative nativeSdaiGetStringAttrBN;
//
//	/**
//	 * @param instance
//	 * @param attributeName
//	 * @return
//	 * @throws Exception
//	 */
//	public String sdaiGetStringAttrBN(int instance, String attributeName) throws Exception {
//		if (nativeSdaiGetStringAttrBN == null) {
//			nativeSdaiGetStringAttrBN = new JNative(libraryPath, "sdaiGetStringAttrBN");
//		}
//		nativeSdaiGetStringAttrBN.setRetVal(Type.STRING);
//		nativeSdaiGetStringAttrBN.setParameter(0, instance);
//		nativeSdaiGetStringAttrBN.setParameter(1, Type.STRING, attributeName);
//		nativeSdaiGetStringAttrBN.invoke();
//		return nativeSdaiGetStringAttrBN.getRetVal();
//
//		// jn = new JNative(libraryPath, "sdaiGetStringAttrBN");
//		// jn.setRetVal(Type.STRING);
//		// jn.setParameter(0, instance);
//		// jn.setParameter(1, Type.STRING, attributeName);
//		// jn.invoke();
//		// return jn.getRetVal();
//	}
//
//	private JNative nativeSdaiGetInstanceAttrBN;
//
//	/**
//	 * @param instance
//	 * @param attributeName
//	 * @return
//	 * @throws Exception
//	 */
//	public int sdaiGetInstanceAttrBN(int instance, String attributeName) throws Exception {
//		int returnValue = 0;
//		if (nativeSdaiGetInstanceAttrBN == null) {
//			nativeSdaiGetInstanceAttrBN = new JNative(libraryPath, "sdaiGetInstanceAttrBN");
//		}
//		nativeSdaiGetInstanceAttrBN.setRetVal(Type.INT);
//		nativeSdaiGetInstanceAttrBN.setParameter(0, instance);
//		nativeSdaiGetInstanceAttrBN.setParameter(1, Type.STRING, attributeName);
//		nativeSdaiGetInstanceAttrBN.invoke();
//		returnValue = nativeSdaiGetInstanceAttrBN.getRetValAsInt();
//		return returnValue;
//
//		// int returnValue = 0;
//		// jn = new JNative(libraryPath, "sdaiGetInstanceAttrBN");
//		// jn.setRetVal(Type.INT);
//		// jn.setParameter(0, instance);
//		// jn.setParameter(1, Type.STRING, attributeName);
//		// jn.invoke();
//		// returnValue = jn.getRetValAsInt();
//		// return returnValue;
//	}
//
//	private JNative nativeSdaiGetAggregationAttrBN;
//
//	/**
//	 * @param instance
//	 * @param attributeName
//	 * @return
//	 * @throws Exception
//	 */
//	public int sdaiGetAggregationAttrBN(int instance, String attributeName) throws Exception {
//		int returnValue = 0;
//		if (nativeSdaiGetAggregationAttrBN == null) {
//			nativeSdaiGetAggregationAttrBN = new JNative(libraryPath, "sdaiGetAggregationAttrBN");
//		}
//		nativeSdaiGetAggregationAttrBN.setRetVal(Type.INT);
//		nativeSdaiGetAggregationAttrBN.setParameter(0, instance);
//		nativeSdaiGetAggregationAttrBN.setParameter(1, Type.STRING, attributeName);
//		nativeSdaiGetAggregationAttrBN.invoke();
//		returnValue = nativeSdaiGetAggregationAttrBN.getRetValAsInt();
//		return returnValue;
//
//		// int returnValue = 0;
//		// jn = new JNative(libraryPath, "sdaiGetAggregationAttrBN");
//		// jn.setRetVal(Type.INT);
//		// jn.setParameter(0, instance);
//		// jn.setParameter(1, Type.STRING, attributeName);
//		// jn.invoke();
//		// returnValue = jn.getRetValAsInt();
//		// return returnValue;
//	}
//
//	private int getInt(int pointer) throws Exception {
//		byte[] bytes = JNative.getMemory(pointer, 4);
//		reverse4Bytes(bytes);
//		ByteBuffer buf = ByteBuffer.wrap(bytes);
//		return buf.getInt();
//	}
//
//	private float getFloat(int pointer) throws Exception {
//		byte[] bytes = JNative.getMemory(pointer, 4);
//		reverse4Bytes(bytes);
//		ByteBuffer buf = ByteBuffer.wrap(bytes);
//		return buf.getFloat();
//	}
//
//	private double getDouble(int pointer) throws Exception {
//		byte[] bytes = JNative.getMemory(pointer, 8);
//		reverse8Bytes(bytes);
//		ByteBuffer buf = ByteBuffer.wrap(bytes);
//		return buf.getDouble();
//	}
//
//	private void reverse4Bytes(byte[] bytes) {
//		byte byte0 = bytes[0], byte1 = bytes[1], byte2 = bytes[2], byte3 = bytes[3];
//		bytes[0] = byte3;
//		bytes[1] = byte2;
//		bytes[2] = byte1;
//		bytes[3] = byte0;
//	}
//
//	private void reverse8Bytes(byte[] bytes) {
//		byte byte0 = bytes[0], byte1 = bytes[1], byte2 = bytes[2], byte3 = bytes[3], byte4 = bytes[4], byte5 = bytes[5], byte6 = bytes[6], byte7 = bytes[7];
//		bytes[0] = byte7;
//		bytes[1] = byte6;
//		bytes[2] = byte5;
//		bytes[3] = byte4;
//		bytes[4] = byte3;
//		bytes[5] = byte2;
//		bytes[6] = byte1;
//		bytes[7] = byte0;
//	}
//}