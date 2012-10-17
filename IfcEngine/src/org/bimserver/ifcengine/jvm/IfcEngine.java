/**
 * 
 */
package org.bimserver.ifcengine.jvm;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
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

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.Set;

import org.bimserver.ifcengine.jvm.IfcEngineInterface.StreamCallback;
import org.bimserver.plugins.ifcengine.IfcEngineClash;
import org.bimserver.plugins.ifcengine.IfcEngineInstanceVisualisationProperties;

import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.DoubleByReference;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;

/**
 * @author Peter Willems
 * 
 */
public class IfcEngine {

	public static final int D3DFVF_XYZ = 0x002;
	public static final int D3DFVF_XYZRHW = 0x004;
	public static final int D3DFVF_NORMAL = 0x010;
	public static final int D3DFVF_PSIZE = 0x020;
	public static final int D3DFVF_DIFFUSE = 0x040;
	public static final int D3DFVF_SPECULAR = 0x080;
	public static final int D3DFVF_TEX1 = 0x100;
	
	private final Set<StreamCallback> callBacks = new HashSet<StreamCallback>();

	private final IfcEngineInterface engine;

	public IfcEngine() {
		engine = IfcEngineInterface.INSTANCE;
	}

	public Pointer loadFromInputStream(final InputStream in, final int size, String schemaName) {
		IfcEngineInterface.StreamCallback fn = new IfcEngineInterface.StreamCallback() {
			int total = 0;
			
			public int invoke(Pointer pointer) {
				if (total == size) {
					return -1;
				}
				ByteBuffer byteBuffer = pointer.getByteBuffer(0, 1024);
				try {
					byte[] buffer = new byte[1024];
					int red = in.read(buffer, 0, Math.min(1024, size - total));
					if (red == -1) {
						return -1;
					}
					total += red;
					byteBuffer.put(buffer, 0, red);
					return red;
				} catch (IOException e) {
				}
				return -1;
			}
		};
		callBacks.add(fn);
		return engine.xxxxOpenModelByStream(0, fn, schemaName);
	}

	static public class SurfaceProperties {
		private Pointer model;
		private Pointer instance;
		private Pointer instanceList;
		private int noVertices;
		private int noIndices;
		private double scale;

		public SurfaceProperties(Pointer model, int noVertices, int noIndices, double scale) {
			this.model = model;
			this.noVertices = noVertices;
			this.noIndices = noIndices;
			this.scale = scale;
			this.instance = null;
			this.instanceList = null;
		}

		public SurfaceProperties(Pointer model, Pointer instance, int noVertices, int noIndices, double scale) {
			this(model, noVertices, noIndices, scale);
			this.instance = instance;
		}

		public SurfaceProperties(Pointer model, Pointer instance, Pointer instanceList, int noVertices, int noIndices, double scale) {
			this(model, instance, noVertices, noIndices, scale);
			this.instanceList = instanceList;
		}

		public Pointer getModel() {
			return model;
		}

		public Pointer getInstance() {
			return instance;
		}

		public Pointer getInstanceList() {
			return instanceList;
		}

		public int getIndicesCount() {
			return noIndices;
		}

		public int getVerticesCount() {
			return noVertices;
		}

		public double getScale() {
			return scale;
		}

		public boolean hasInstance() {
			return instance != null;
		}

		public boolean hasInstanceList() {
			return instanceList != null;
		}
	}

	public class InstanceDerivedProperties {
		private int model;
		private Pointer instance;
		private double height, width, thickness;

		public InstanceDerivedProperties(int model, Pointer instance, double height, double width, double thickness) {
			this.model = model;
			this.instance = instance;
			this.height = height;
			this.width = width;
			this.thickness = thickness;
		}

		public int getModel() {
			return model;
		}

		public Pointer getInstance() {
			return instance;
		}

		public double getHeight() {
			return height;
		}

		public double getWidth() {
			return width;
		}

		public double getThickness() {
			return thickness;
		}
	}

	public class InstanceDerivedBoundingBox {
		Pointer model;
		Pointer instance;
		double ox, oy, oz, vx, vy, vz;

		public InstanceDerivedBoundingBox(Pointer model, Pointer instance, double ox, double oy, double oz, double vx, double vy, double vz) {
			this.model = model;
			this.instance = instance;
			this.ox = ox;
			this.oy = oy;
			this.oz = oz;
			this.vx = vx;
			this.vy = vy;
			this.vz = vz;
		}

		public Pointer getModel() {
			return model;
		}

		public Pointer getInstance() {
			return instance;
		}

		public double getOx() {
			return ox;
		}

		public double getOy() {
			return oy;
		}

		public double getOz() {
			return oz;
		}

		public double getVx() {
			return vx;
		}

		public double getVy() {
			return vy;
		}

		public double getVz() {
			return vz;
		}
	}

	public class InstanceDerivedTransformationMatrix {
		Pointer model;
		Pointer instance;
		double _11, _12, _13, _14, _21, _22, _23, _24, _31, _32, _33, _34, _41, _42, _43, _44;

		public InstanceDerivedTransformationMatrix(Pointer model, Pointer instance, double _11, double _12, double _13, double _14, double _21, double _22, double _23, double _24,
				double _31, double _32, double _33, double _34, double _41, double _42, double _43, double _44) {
			this.model = model;
			this.instance = instance;
			this._11 = _11;
			this._12 = _12;
			this._13 = _13;
			this._14 = _14;
			this._21 = _21;
			this._22 = _22;
			this._23 = _23;
			this._24 = _24;
			this._31 = _31;
			this._32 = _32;
			this._33 = _33;
			this._34 = _34;
			this._41 = _41;
			this._42 = _42;
			this._43 = _43;
			this._44 = _44;
		}

		public Pointer getModel() {
			return model;
		}

		public Pointer getInstance() {
			return instance;
		}

		public double get_11() {
			return _11;
		}

		public double get_12() {
			return _12;
		}

		public double get_13() {
			return _13;
		}

		public double get_14() {
			return _14;
		}

		public double get_21() {
			return _21;
		}

		public double get_22() {
			return _22;
		}

		public double get_23() {
			return _23;
		}

		public double get_24() {
			return _24;
		}

		public double get_31() {
			return _31;
		}

		public double get_32() {
			return _32;
		}

		public double get_33() {
			return _33;
		}

		public double get_34() {
			return _34;
		}

		public double get_41() {
			return _41;
		}

		public double get_42() {
			return _42;
		}

		public double get_43() {
			return _43;
		}

		public double get_44() {
			return _44;
		}

	}

	/**
	 * Change the number of segments a circle should be represented as.
	 * 
	 * @param circles
	 *            The count of segments for each circle or circle part (by
	 *            default 30). 0 is ignored.
	 * @param smallCircles
	 *            The count of segments for less important circle(parts), like
	 *            circles between the legs in a I, T, U or L profile structure
	 *            (by default 5). 0 is ignored.
	 */
	public void circleSegments(int circles, int smallCircles) {
		engine.circleSegments(circles, smallCircles);
	}

	/**
	 * Returns a data field in the actual aggregate element.
	 * 
	 * @param aggregate
	 *            Existing aggregation
	 * @param elementIndex
	 *            Position in the existing aggregation, first position is 0
	 * @param valueType
	 *            Type of output value
	 * @return Value of the specific element in the aggregation
	 */
	public Object engiGetAggrElement(Pointer aggregate, int elementIndex, SdaiTypes valueType) {
		Object returnValue = null;
		switch (valueType) {
		case INTEGER:
			IntByReference intRef = new IntByReference();
			engine.engiGetAggrElement(aggregate, elementIndex, valueType.ordinal(), intRef);
			returnValue = new Integer(intRef.getValue());
			break;
		case REAL:
			DoubleByReference dblRef = new DoubleByReference();
			engine.engiGetAggrElement(aggregate, elementIndex, valueType.ordinal(), dblRef);
			returnValue = new Double(dblRef.getValue());
			break;
		case STRING:
			PointerByReference strRef = new PointerByReference();
			engine.engiGetAggrElement(aggregate, elementIndex, valueType.ordinal(), strRef);
			Pointer strPtr = strRef.getValue();
			if (strPtr != null)
				returnValue = strPtr.getString(0);
			break;
		default:
			PointerByReference ptrRef = new PointerByReference();
			engine.engiGetAggrElement(aggregate, elementIndex, valueType.ordinal(), ptrRef);
			returnValue = ptrRef.getValue();
			break;
		}
		return returnValue;
	}

	/**
	 * Returns the class name as used in the SPFF file.
	 * 
	 * @param instance
	 *            A numeric instanceID that uniquely identifies an instance
	 * @return class name
	 */
	public String engiGetInstanceClassInfo(Pointer instance) {
		return engine.engiGetInstanceClassInfo(instance);
	}

	/**
	 * Returns the UPPER CASE version of the class name as used in the Schema
	 * file.
	 * 
	 * @param instance
	 *            A numeric instanceID that uniquely identifies an instance.
	 * @return UPPER CASE version of the class name
	 */
	public String engiGetInstanceClassInfoUC(Pointer instance) {
		return engine.engiGetInstanceClassInfoUC(instance);
	}

	/**
	 * Returns the line number as used for this instance in the SPFF file.
	 * 
	 * @param instance
	 *            A numeric instanceID that uniquely identifies an instance.
	 * @return line number
	 */
	public int engiGetInstanceLocalId(Pointer instance) {
		return engine.engiGetInstanceLocalId(instance);
	}

	/**
	 * Returns 'meta' information from a specific instance.
	 * 
	 * @param instance
	 *            A numeric instanceID that uniquely identifies an instance.
	 * @param className
	 *            as used in the SPFF file.
	 * @param classNameUC
	 *            UPPER CASE version of the class name (as used in the schema).
	 * @return
	 */
	public int engiGetInstanceMetaInfo(Pointer instance, String className, String classNameUC) {
		IntByReference localIdRef = new IntByReference();
		PointerByReference classNameRef = new PointerByReference();
		PointerByReference classNameUCRef = new PointerByReference();
		engine.engiGetInstanceMetaInfo(instance, localIdRef, classNameRef, classNameUCRef);
		className = classNameRef.getValue().getString(0);
		classNameUC = classNameUCRef.getValue().getString(0);
		return localIdRef.getValue();
	}

	private int getPlatformMultiplier() {
		return System.getProperty("sun.arch.data.model").equals("32") ? 1 : 2;
	}

	/**
	 * @param modelId
	 * @param size
	 * @return
	 */
	public Set<IfcEngineClash> finalizeClashesByEI(Pointer modelId, int size) {
		Set<IfcEngineClash> clashes = new HashSet<IfcEngineClash>();
		
		Memory pG1 = new Memory(size * 4 * getPlatformMultiplier());
		Memory pG2 = new Memory(size * 4 * getPlatformMultiplier());
		engine.finalizeClashesByEI(modelId, pG1, pG2);
		for (int i = 0; i < size; i++) {
			Long eid1 = null;
			Long eid2 = null;
			if (getPlatformMultiplier() == 1) {
				eid1 = (long)pG1.getInt(i * 4 * getPlatformMultiplier());
				eid2 = (long)pG2.getInt(i * 4 * getPlatformMultiplier());
			} else {
				eid1 = pG1.getLong(i * 4 * getPlatformMultiplier());
				eid2 = pG2.getLong(i * 4 * getPlatformMultiplier());
			}

			IfcEngineClash clash = new IfcEngineClash();
			clash.setEid1(eid1);
			clash.setEid2(eid2);
			clashes.add(clash);
		}
		return clashes;
	}

	/**
	 * @param modelId
	 * @param size
	 * @return
	 */
	public Set<IfcEngineClash> finalizeClashesByGuid(Pointer modelId, int size) {
		Set<IfcEngineClash> clashes = new HashSet<IfcEngineClash>();
		Memory pG1 = new Memory(size * 4 * getPlatformMultiplier());
		Memory pG2 = new Memory(size * 4 * getPlatformMultiplier());
		engine.finalizeClashesByGuid(modelId, pG1, pG2);
		for (int i = 0; i < size; i++) {
			Pointer memory1 = pG1.getPointer(i * 4 * getPlatformMultiplier());
			String pG1Str = memory1.getString(0);
			Pointer memory2 = pG2.getPointer(i * 4 * getPlatformMultiplier());
			String pG2Str = memory2.getString(0);

			IfcEngineClash clash = new IfcEngineClash();
			clash.setGuid1(pG1Str);
			clash.setGuid2(pG2Str);
			clashes.add(clash);
		}
		return clashes;
	}

	/**
	 * The surfaces of the IFC 3D geometry object, i.e wall instance, column
	 * instance, door instance, etc..
	 * 
	 * @param model
	 *            Unique number identifying the model in the opened file.
	 * @param scale
	 *            If this value is 0.0 no scaling is executed, if this value is
	 *            1.0 all mashes will be scaled between -1 and 1.
	 * @param instance
	 *            A numeric instanceID that uniquely identifies an instance.
	 * @return
	 */
	public SurfaceProperties initializeModellingInstance(Pointer model, double scale, Pointer instance) {
		IntByReference pV = new IntByReference();
		IntByReference pI = new IntByReference();
		engine.initializeModellingInstance(model, pV, pI, scale, instance);
		int noVertices = pV.getValue();
		int noIndices = pI.getValue();
		return new SurfaceProperties(model, instance, noVertices, noIndices, scale);
	}

	/**
	 * The surfaces of the IFC 3D geometry object, i.e wall instance, column
	 * instance, door instance, etc.. With defined what openings should be
	 * subtracted from the solid.
	 * 
	 * @param model
	 *            Unique number identifying the model in the opened file.
	 * @param scale
	 *            If this value is 0 no scaling is executed, if this value is 1
	 *            all mashes will be scaled between -1 and 1.
	 * @param instance
	 *            A numeric instanceID that uniquely identifies an instance of a
	 *            wall, column, door, etc.
	 * @param instanceList
	 *            Instances of openings that should be subtracted from the
	 *            object.
	 * @return
	 */
	public SurfaceProperties initializeModellingInstanceEx(Pointer model, double scale, Pointer instance, Pointer instanceList) {
		IntByReference pV = new IntByReference();
		IntByReference pI = new IntByReference();
		engine.initializeModellingInstanceEx(model, pV, pI, scale, instance, instanceList);
		int noVertices = pV.getValue();
		int noIndices = pI.getValue();
		return new SurfaceProperties(model, instance, instanceList, noVertices, noIndices, scale);
	}

	/**
	 * Fills the allocated areas (allocated by the calling program) with the
	 * vertices and indices generated based on the supported mapping.
	 * 
	 * @param model
	 *            Unique number identifying the model in the opened file.
	 * @param coordinates
	 *            The calling program should be sure this parameter is pointing
	 *            to an area with size 3 * sizeof(float) * noVertices (as given
	 *            in InitializeModelling(..)). The area will be filled with the
	 *            correct vectors.
	 * @param normals
	 *            The calling program should be sure this parameter is pointing
	 *            to an area with size 3 * sizeof(float) * noVertices (as given
	 *            in InitializeModelling(..)). The area will be filled with the
	 *            correct normals.
	 * @param indices
	 *            The calling program should be sure this parameter is pointing
	 *            to an area with size sizeof(int) * noIndices (as given in
	 *            InitializeModelling(..)). The area will be filled with the
	 *            indices (used to build meshes).
	 * @return
	 * @throws Exception
	 */
	public int finalizeModelling(Pointer model, float[] coordinates, float[] normals, int[] indices) {
		int fvf = 0;
		int size = 0;
		int noVertices = 0;
		int noIndices = 0;
		if (coordinates != null) {
			fvf |= D3DFVF_XYZ;
			size += 3;
			noVertices = coordinates.length / 3;
		}
		if (normals != null) {
			fvf |= D3DFVF_NORMAL;
			size += 3;
		}
		if (indices != null) {
			noIndices = indices.length;
		}
		Memory pV = new Memory(noVertices * size * 4 * getPlatformMultiplier());
		Memory pI = new Memory(noIndices * 4 * getPlatformMultiplier());
		int finalizeModelling = engine.finalizeModelling(model, pV, pI, fvf);
		for (int i = 0; i < noVertices * size; i += size) {
			int p = i;
			if ((fvf & D3DFVF_XYZ) != 0) {
				for (int j = 0; j < 3; j++) {
					coordinates[i / 2 + j] = pV.getFloat(p * 4);
					p++;
				}
			}
			if ((fvf & D3DFVF_NORMAL) != 0) {
				for (int j = 0; j < 3; j++) {
					normals[i / 2 + j] = pV.getFloat(p * 4);
					p++;
				}
			}
		}
		for (int i = 0; i < noIndices; i++) {
			indices[i] = pI.getInt(i * 4);
		}
		return finalizeModelling;
	}

	/**
	 * Returns the visualization properties of a specific express instance.
	 * 
	 * @param model
	 *            Unique number identifying the model in the opened file.
	 * @param instance
	 *            A numeric instanceID that uniquely identifies an instance.
	 * @param mode
	 *            The representation mode that should be visualized, options: 0
	 *            line representation; 1 complex object representation; 2
	 *            bounding box representation.
	 * @return
	 */
	public IfcEngineInstanceVisualisationProperties getInstanceInModelling(Pointer model, Pointer instance, int mode) {
		IntByReference pV = new IntByReference();
		IntByReference pI = new IntByReference();
		IntByReference pC = new IntByReference();
		engine.getInstanceInModelling(model, instance, mode, pV, pI, pC);
		int startVertex = pV.getValue();
		int startIndex = pI.getValue();
		int primitiveCount = pC.getValue();
		return new IfcEngineInstanceVisualisationProperties(startVertex, startIndex, primitiveCount);
	}

	/**
	 * Returns an integer representing internal 'clock'.
	 * 
	 * @param model
	 *            Unique number identifying the model in the opened file.
	 * @return an integer representing internal 'clock'.
	 * @throws Exception
	 */
	public int getTimeStamp(Pointer model) {
		return engine.getTimeStamp(model);
	}

	/**
	 * @param model
	 * @param timeStamp
	 * @return
	 */
	public String getChangedData(Pointer model, int timeStamp) {
		return engine.getChangedData(model, timeStamp);
	}

	/**
	 * @param model
	 * @param timeStamp
	 * @param changedData
	 */
	public void setChangedData(Pointer model, int timeStamp, String changedData) {
		engine.setChangedData(model, timeStamp, changedData);
	}

	/**
	 * @param unicode
	 * @return
	 */
	public int setStringUnicode(boolean unicode) {
		return engine.setStringUnicode(unicode);
	}

	/**
	 * Return derived properties from the 3D visualisation.
	 * 
	 * @param model
	 *            Unique number identifying the model in the opened file.
	 * @param instance
	 *            A numeric instanceID that uniquely identifies an instance.
	 * @return InstanceDerivedProperties object
	 */
	public InstanceDerivedProperties getInstanceDerivedPropertiesInModelling(int model, Pointer instance) {
		DoubleByReference pH = new DoubleByReference();
		DoubleByReference pW = new DoubleByReference();
		DoubleByReference pT = new DoubleByReference();
		engine.getInstanceDerivedPropertiesInModelling(model, instance, pH, pW, pT);
		double height = pH.getValue();
		double width = pW.getValue();
		double thickness = pT.getValue();
		return new InstanceDerivedProperties(model, instance, height, width, thickness);
	}

	/**
	 * Returns advanced bounding box measures, can be used in combination with
	 * getInstanceDerivedTransformationMatrix().
	 * 
	 * @param model
	 *            Unique number identifying the model in the opened file.
	 * @param instance
	 *            A numeric instanceID that uniquely identifies an instance.
	 * @return InstanceDerivedBoundingBox object
	 * @throws Exception
	 */
	public InstanceDerivedBoundingBox getInstanceDerivedBoundingBox(Pointer model, Pointer instance) {
		DoubleByReference pOx = new DoubleByReference();
		DoubleByReference pOy = new DoubleByReference();
		DoubleByReference pOz = new DoubleByReference();
		DoubleByReference pVx = new DoubleByReference();
		DoubleByReference pVy = new DoubleByReference();
		DoubleByReference pVz = new DoubleByReference();
		engine._getInstanceDerivedBoundingBox(model, instance, pOx, pOy, pOz, pVx, pVy, pVz);
		double ox = pOx.getValue();
		double oy = pOy.getValue();
		double oz = pOz.getValue();
		double vx = pVx.getValue();
		double vy = pVy.getValue();
		double vz = pVz.getValue();
		return new InstanceDerivedBoundingBox(model, instance, ox, oy, oz, vx, vy, vz);
	}

	/**
	 * Returns internally created transformation matrix. This function can be
	 * applied to every instance that needs a transformation matrix (i.e.
	 * IfcColumn, IfcLocalPlacement, IfcPolyline).
	 * 
	 * @param model
	 *            Unique number identifying the model in the opened file.
	 * @param instance
	 *            A numeric instanceID that uniquely identifies an instance.
	 * @return InstanceDerivedTransformationMatrix object
	 */
	public InstanceDerivedTransformationMatrix getInstanceDerivedTransformationMatrix(Pointer model, Pointer instance) {
		DoubleByReference p_11 = new DoubleByReference();
		DoubleByReference p_12 = new DoubleByReference();
		DoubleByReference p_13 = new DoubleByReference();
		DoubleByReference p_14 = new DoubleByReference();
		DoubleByReference p_21 = new DoubleByReference();
		DoubleByReference p_22 = new DoubleByReference();
		DoubleByReference p_23 = new DoubleByReference();
		DoubleByReference p_24 = new DoubleByReference();
		DoubleByReference p_31 = new DoubleByReference();
		DoubleByReference p_32 = new DoubleByReference();
		DoubleByReference p_33 = new DoubleByReference();
		DoubleByReference p_34 = new DoubleByReference();
		DoubleByReference p_41 = new DoubleByReference();
		DoubleByReference p_42 = new DoubleByReference();
		DoubleByReference p_43 = new DoubleByReference();
		DoubleByReference p_44 = new DoubleByReference();
		engine.getInstanceDerivedTransformationMatrix(model, instance, p_11, p_12, p_13, p_14, p_21, p_22, p_23, p_24, p_31, p_32, p_33, p_34, p_41, p_42, p_43, p_44);
		double _11 = p_11.getValue();
		double _12 = p_12.getValue();
		double _13 = p_13.getValue();
		double _14 = p_14.getValue();
		double _21 = p_21.getValue();
		double _22 = p_22.getValue();
		double _23 = p_23.getValue();
		double _24 = p_24.getValue();
		double _31 = p_31.getValue();
		double _32 = p_32.getValue();
		double _33 = p_33.getValue();
		double _34 = p_34.getValue();
		double _41 = p_41.getValue();
		double _42 = p_42.getValue();
		double _43 = p_43.getValue();
		double _44 = p_44.getValue();
		return new InstanceDerivedTransformationMatrix(model, instance, _11, _12, _13, _14, _21, _22, _23, _24, _31, _32, _33, _34, _41, _42, _43, _44);
	}

	/**
	 * @param model
	 * @param instance
	 * @return
	 */
	public Pointer internalGetBoundingBox(Pointer model, Pointer instance) {
		return engine.internalGetBoundingBox(model, instance);
	}

	/**
	 * @param model
	 * @param instance
	 * @return
	 * @throws Exception
	 */
	public Pointer internalGetCenter(Pointer model, Pointer instance) throws Exception {
		return engine.internalGetCenter(model, instance);
	}

	/**
	 * @param instance
	 * @param attributeName
	 * @param linked_id
	 */
	public void internalSetLink(Pointer instance, String attributeName, int linked_id) {
		engine.internalSetLink(instance, attributeName, linked_id);
	}

	/**
	 * @param list
	 * @param linked_id
	 */
	public void internalAddAggrLink(int list, int linked_id) {
		engine.internalAddAggrLink(list, linked_id);
	}

	/**
	 * @param instance
	 * @param attributeName
	 * @return
	 */
	public int sdaiGetAggregationAttrBN(Pointer instance, String attributeName) {
		return engine.sdaiGetAggregationAttrBN(instance, attributeName);
	}

	/**
	 * Returns the data value of the specified attribute in the actual instance.
	 * The actual instance is specified by a numeric instanceID that uniquely
	 * identifies an instance.
	 * 
	 * @param instance
	 *            A numeric instanceID that uniquely identifies an instance.
	 * @param attributeName
	 *            A character that contains an attribute name existing in the
	 *            mentioned instance.
	 * @param valueType
	 *            Type of output value.
	 * @return Output value of the specific element in the aggregation.
	 */
	public Object sdaiGetAttrBN(Pointer instance, String attributeName, SdaiTypes valueType) {
		PointerByReference ptrRef = new PointerByReference();
		engine.sdaiGetAttrBN(instance, attributeName, valueType.ordinal(), ptrRef);
		switch (valueType) {
		case STRING:
			return ptrRef.getValue().getString(0);
		default:
			return ptrRef.getValue();
		}
	}

	/**
	 * Returns a numeric entityID that uniquely identifies an entity definition
	 * instance.
	 * 
	 * @param model
	 *            Unique number identifying the model in the opened file.
	 * @param entityName
	 *            Name of the Entity.
	 * @return a numeric entityID
	 */
	public Pointer sdaiGetEntity(Pointer model, String entityName) {
		return engine.sdaiGetEntity(model, entityName);
	}

	/**
	 * Returns a numeric aggregateID that uniquely identifies the aggregate that
	 * holds all instances of one particular type in a model.
	 * 
	 * @param model
	 *            Unique number identifying the model in the opened file.
	 * @param entityName
	 *            Name of the Entity.
	 * @return a numeric aggregateID
	 */
	public Pointer sdaiGetEntityExtentBN(Pointer model, String entityName) {
		return engine.sdaiGetEntityExtentBN(model, entityName);
	}

	/**
	 * @param instance
	 * @param attributeName
	 * @return
	 */
	public int sdaiGetInstanceAttrBN(Pointer instance, String attributeName) {
		return engine.sdaiGetInstanceAttrBN(instance, attributeName);
	}

	/**
	 * Return the instance type of the specified instance. The instance type is
	 * returned as an entityID that uniquely identifies the entity definition
	 * instance.
	 * 
	 * @param instance
	 *            A numeric instanceID that uniquely identifies an instance.
	 * @return the instance type
	 */
	public Pointer sdaiGetInstanceType(Pointer instance) {
		return engine.sdaiGetInstanceType(instance);
	}

	/**
	 * Returns the number of elements in the specified aggregate.
	 * 
	 * @param aggregate
	 *            Existing aggregation.
	 * @return the number of elements
	 */
	public int sdaiGetMemberCount(Pointer aggregate) {
		return engine.sdaiGetMemberCount(aggregate);
	}

	/**
	 * @param instance
	 * @param attributeName
	 * @return
	 * @throws Exception
	 */
	public String sdaiGetStringAttrBN(Pointer instance, String attributeName) {
		return engine.sdaiGetStringAttrBN(instance, attributeName);
	}

	/**
	 * Opens a model and its belonging schema. This functions differs slightly
	 * from the official SDAI definition because the IFC Engine DLL is able to
	 * open repository, model and schema in 1 call. It returns the modelID or
	 * zero if the model could not be created.
	 * 
	 * @param repository
	 *            Unused, the IFC Engine DLL currently (8 March 2006) only
	 *            supports exactly 1 repository for each model.
	 * @param fileName
	 *            String containing the name and path of the file that will be
	 *            opened.
	 * @param schemaName
	 *            String containing the name of the schema belonging to the file
	 *            mentioned in fileName. If this string is referring to a
	 *            non-existing file no schema will be loaded, preferred use is
	 *            in that case '' (empty string). If this pointer is empty the
	 *            default schema for this file is loaded (using the knowledge of
	 *            the IFC Engine Viewer).
	 * 
	 * @return modelID
	 */
	public Pointer sdaiOpenModelBN(int repository, String fileName, String schemaName) {
		return engine.sdaiOpenModelBN(1, fileName, schemaName);
	}

	/**
	 * Creates a new model instantiated from a specific schema. It returns the
	 * modelID, zero if the model could not be created.
	 * 
	 * @param repository
	 *            Unused, the IFC Engine DLL currently (8 March 2006) only
	 *            supports exactly 1 repository for each model.
	 * @param fileName
	 *            String containing the name and path of the file that will be
	 *            created.
	 * @param schemaName
	 *            String containing the name of the schema belonging to the file
	 *            mentioned in fileName. If this string is referring to a
	 *            non-existing file no schema will be loaded, preferred use is
	 *            in that case '' (empty string). If this pointer is empty the
	 *            default schema for this file is loaded (using the knowledge of
	 *            the IFC Engine Viewer).
	 * 
	 * @return modelID
	 */
	public int sdaiCreateModelBN(int repository, String fileName, String schemaName) {
		return engine.sdaiCreateModelBN(repository, fileName, schemaName);
	}

	/**
	 * Saves an 'in memory' model.
	 * 
	 * @param repository
	 *            Unused, the IFC Engine DLL currently (8 March 2006) only
	 *            supports exactly 1 repository for each model
	 * @param fileName
	 *            String containing the name and path of the file that will be
	 *            saved.
	 */
	public void sdaiSaveModelBN(int repository, String fileName) {
		engine.sdaiSaveModelBN(repository, fileName);
	}

	/**
	 * @param model
	 * @param fileName
	 */
	public void sdaiSaveModelAsXmlBN(Pointer model, String fileName) {
		engine.sdaiSaveModelAsXmlBN(model, fileName);
	}

	/**
	 * Closes a SPFF (possibly IFC) file. The file will NOT be saved.
	 * 
	 * @param model
	 *            ModelID referring to the model.
	 */
	public void sdaiCloseModel(Pointer model) {
		engine.sdaiCloseModel(model);
	}

	/**
	 * Adds an attribute value at the end of an attribute list.
	 * 
	 * @param list
	 * @param valueType
	 * @param value
	 */
	public void sdaiAppend(int list, SdaiTypes valueType, Object value) {
		switch (valueType) {
		case INTEGER:
		case BOOLEAN:
		case LOGICAL:
			IntByReference iVal = new IntByReference((Integer) value);
			engine.sdaiAppend(list, valueType.ordinal(), iVal);
			break;
		case REAL:
			DoubleByReference dVal = new DoubleByReference((Double) value);
			engine.sdaiAppend(list, valueType.ordinal(), dVal);
			break;
		case STRING:
			engine.sdaiAppend(list, valueType.ordinal(), (String) value);
			break;
		default:
			engine.sdaiAppend(list, valueType.ordinal(), (Pointer) value);
			break;
		}
	}

	/**
	 * Adds an attribute value at the beginning of an attribute list.
	 * 
	 * @param iterator
	 * @throws Exception
	 */
	public void sdaiBeginning(int iterator) throws Exception {
		engine.sdaiBeginning(iterator);
	}

	/**
	 * Creates an Attribute Data Block (ADB).
	 * 
	 * @param valueType
	 *            identifies the type of parameter value.
	 * @param value
	 *            identifies the data to be stored in the new ADB.
	 * @return the handle of the newly created ADB.
	 */
	public Pointer sdaiCreateADB(SdaiTypes valueType, Object value) {
		Pointer returnValue = null;
		switch (valueType) {
		case INTEGER:
		case BOOLEAN:
		case LOGICAL:
			IntByReference iVal = new IntByReference((Integer) value);
			returnValue = engine.sdaiCreateADB(valueType.ordinal(), iVal);
			break;
		case REAL:
			DoubleByReference dVal = new DoubleByReference((Double) value);
			returnValue = engine.sdaiCreateADB(valueType.ordinal(), dVal);
			break;
		case STRING:
			returnValue = engine.sdaiCreateADB(valueType.ordinal(), (String) value);
			break;
		default:
			returnValue = engine.sdaiCreateADB(valueType.ordinal(), (Pointer) value);
			break;
		}

		return returnValue;
	}

	/**
	 * Creates an aggregation for an attribute in a specific instance.
	 * 
	 * @param instance
	 *            A numeric instanceID that uniquely identifies an instance.
	 * @param attribute
	 *            A numeric attributerID that uniquely identifies an attribute
	 *            definition instance.
	 * @return
	 */
	public Pointer sdaiCreateAggr(Pointer instance, int attribute) {
		return engine.sdaiCreateAggr(instance, attribute);
	}

	/**
	 * Creates an aggregation for an attribute in a specific instance.
	 * 
	 * @param instance
	 *            A numeric instanceID that uniquely identifies an instance.
	 * @param attributeName
	 *            A string that contains an attribute name existing in the
	 *            mentioned instance.
	 * @return
	 */
	public Pointer sdaiCreateAggrBN(Pointer instance, String attributeName) {
		return engine.sdaiCreateAggrBN(instance, attributeName);
	}

	/**
	 * Creates an instance of a specific schema entity.
	 * 
	 * @param model
	 *            Unique number identifying the model in the opened file.
	 * @param entity
	 *            A numeric entityID that uniquely identifies a (schema) entity
	 *            existing in the mentioned model.
	 * @return
	 */
	public Pointer sdaiCreateInstance(Pointer model, int entity) {
		return engine.sdaiCreateInstance(model, entity);
	}

	/**
	 * Creates an instance of a specific schema entity.
	 * 
	 * @param model
	 *            Unique number identifying the model in the opened file.
	 * @param entityName
	 *            A string that contains a (schema) entity name existing in the
	 *            mentioned model.
	 * @return
	 */
	public Pointer sdaiCreateInstanceBN(Pointer model, String entityName) {
		return engine.sdaiCreateInstanceBN(model, entityName);
	}

	/**
	 * Creates an instance of a specific schema entity.
	 * 
	 * @param model
	 *            Unique number identifying the model in the opened file.
	 * @param entityName
	 *            A string that contains a (schema) entity name existing in the
	 *            mentioned model.
	 * @param express_id
	 * @return
	 */
	public Pointer sdaiCreateInstanceBNEI(Pointer model, String entityName, int express_id) {
		return engine.sdaiCreateInstanceBNEI(model, entityName, express_id);
	}

	/**
	 * Creates an iterator for an existing aggregation.
	 * 
	 * @param aggregate
	 *            Existing aggregation.
	 * @return
	 */
	public Pointer sdaiCreateIterator(Pointer aggregate) {
		return engine.sdaiCreateIterator(aggregate);
	}

	/**
	 * Deletes an existing instance.
	 * 
	 * @param instance
	 *            A numeric instanceID that uniquely identifies an instance.
	 */
	public void sdaiDeleteInstance(Pointer instance) {
		engine.sdaiDeleteInstance(instance);
	}

	/**
	 * Deletes an existing iterator.
	 * 
	 * @param iterator
	 *            Existing iterator.
	 */
	public void sdaiDeleteIterator(Pointer iterator) {
		engine.sdaiDeleteIterator(iterator);
	}

	/**
	 * Moves the active position in an iterator to the last object.
	 * 
	 * @param iterator
	 *            Existing iterator.
	 */
	public void sdaiEnd(Pointer iterator) {
		engine.sdaiEnd(iterator);
	}

	/**
	 * Implementation postponed till version 1.10
	 * 
	 * @return
	 */
	public int sdaiErrorQuery() {
		return engine.sdaiErrorQuery();
	}

	/**
	 * Implementation postponed till version 1.10
	 * 
	 * @param iterator
	 *            Existing iterator
	 * @param valueType
	 *            Type of output value
	 * @return
	 */
	public Object sdaiGetAggrByIterator(Pointer iterator, SdaiTypes valueType) {
		Object returnValue = null;

		switch (valueType) {
		case REAL:
			DoubleByReference dVal = new DoubleByReference();
			engine.sdaiGetAggrByIterator(iterator, valueType.ordinal(), dVal);
			returnValue = new Double(dVal.getValue());
			break;
		case INTEGER:
		case BOOLEAN:
		case LOGICAL:
			IntByReference iVal = new IntByReference();
			engine.sdaiGetAggrByIterator(iterator, valueType.ordinal(), iVal);
			returnValue = new Integer(iVal.getValue());
			break;
		case STRING:
			PointerByReference sVal = new PointerByReference();
			engine.sdaiGetAggrByIterator(iterator, valueType.ordinal(), sVal);
			returnValue = (String) sVal.getValue().getString(0);
			break;
		default:
			PointerByReference ptr = new PointerByReference();
			engine.sdaiGetAggrByIterator(iterator, valueType.ordinal(), ptr);
			returnValue = ptr.getValue();
			break;
		}
		return returnValue;
	}

	/**
	 * Returns the data value of the specified attribute in the actual instance.
	 * The actual instance is specified by a numeric instanceID that uniquely
	 * identifies an instance.
	 * 
	 * @param instance
	 *            A numeric instanceID that uniquely identifies an instance.
	 * @param attribute
	 *            A numeric attributerID that uniquely identifies an attribute
	 *            definition instance.
	 * @param valueType
	 *            Type of output value.
	 * @return Output value of the specific element in the aggregation.
	 */
	public Object sdaiGetAttr(Pointer instance, int attribute, SdaiTypes valueType) {
		Object returnValue = null;

		switch (valueType) {
		case REAL:
			DoubleByReference dVal = new DoubleByReference();
			engine.sdaiGetAggrByIterator(instance, valueType.ordinal(), dVal);
			returnValue = new Double(dVal.getValue());
			break;
		case INTEGER:
		case BOOLEAN:
		case LOGICAL:
			IntByReference iVal = new IntByReference();
			engine.sdaiGetAggrByIterator(instance, valueType.ordinal(), iVal);
			returnValue = new Integer(iVal.getValue());
			break;
		case STRING:
			PointerByReference sVal = new PointerByReference();
			engine.sdaiGetAggrByIterator(instance, valueType.ordinal(), sVal);
			returnValue = (String) sVal.getValue().getString(0);
			break;
		default:
			PointerByReference ptr = new PointerByReference();
			engine.sdaiGetAggrByIterator(instance, valueType.ordinal(), ptr);
			returnValue = ptr.getValue();
			break;
		}
		return returnValue;
	}

	/**
	 * Returns a numeric attributeID that uniquely identifies an attribute
	 * definition instance.
	 * 
	 * @param entity
	 *            A numeric entityID that uniquely identifies a (schema) entity
	 *            existing in the mentioned model.
	 * @param attributeName
	 *            A string that contains an attribute name existing in the
	 *            mentioned instance.
	 * @return a numeric attributeID
	 */
	public Pointer sdaiGetAttrDefinition(Pointer entity, String attributeName) {
		return engine.sdaiGetAttrDefinition(entity, attributeName);
	}

	public SurfaceProperties initializeModelling(Pointer model, double scale) {
		IntByReference pV = new IntByReference();
		IntByReference pI = new IntByReference();
		engine.initializeModelling(model, pV, pI, scale);
		int noVertices = pV.getValue();
		int noIndices = pI.getValue();
		return new SurfaceProperties(model, noVertices, noIndices, scale);
	}

	public void setPostProcessing(Pointer model, int on) {
		engine.setPostProcessing(model, on);
	}

	public int initializeClashes(Pointer model, double dist) {
		IntByReference pV = new IntByReference();
		engine.initializeClashes(model, pV, dist);
		int noClashes = pV.getValue();
		return noClashes;
	}

	public int internalGetP21Line(Pointer instanceId) {
		return engine.internalGetP21Line(instanceId);
	}
	
	public Pointer internalGetInstanceFromP21Line(int expressId) {
		return engine.internalGetInstanceFromP21Line(expressId);
	}
	
	/**
	 * Returns a numeric aggregateID that uniquely identifies the aggregate that
	 * holds all instances of one particular type and its sub-types in a model.
	 * 
	 * @param model
	 *            Unique number identifying the model in the opened file.
	 * @param entityName
	 *            Name of the Entity.
	 * @return a numeric aggregateID
	 **/
	public Pointer xxxxGetEntityAndSubTypesExtentBN(Pointer model, String entityName) {
		return engine.xxxxGetEntityAndSubTypesExtentBN(model, entityName);
	}
}