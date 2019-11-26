package org.bimserver.interfaces;

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

import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.interfaces.objects.*;
import java.util.*;
import org.bimserver.models.log.*;
import org.bimserver.models.store.*;
import org.bimserver.models.geometry.*;
import org.bimserver.database.DatabaseSession;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.OldQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SConverter {
	private static final Logger LOGGER = LoggerFactory.getLogger(SConverter.class);

	public Set<SGeometryInfo> convertToSSetGeometryInfo(Collection<GeometryInfo> input) {
		Set<SGeometryInfo> result = new HashSet<SGeometryInfo>();
		for (GeometryInfo o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<GeometryInfo> convertFromSSetGeometryInfo(Collection<SGeometryInfo> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<GeometryInfo> result = new HashSet<GeometryInfo>();
		for (SGeometryInfo o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SGeometryInfo> convertToSListGeometryInfo(Collection<GeometryInfo> input) {
		List<SGeometryInfo> result = new ArrayList<SGeometryInfo>();
		for (GeometryInfo o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<GeometryInfo> convertFromSListGeometryInfo(Collection<SGeometryInfo> input, DatabaseSession session) throws BimserverDatabaseException {
		List<GeometryInfo> result = new ArrayList<GeometryInfo>();
		for (SGeometryInfo o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SGeometryInfo convertToSObject(GeometryInfo input) {
		if (input == null) {
			return null;
		}
		
		SGeometryInfo result = new SGeometryInfo();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setStartVertex(input.getStartVertex());
		result.setStartIndex(input.getStartIndex());
		result.setPrimitiveCount(input.getPrimitiveCount());
		result.setTransformation(input.getTransformation());
		result.setArea(input.getArea());
		result.setVolume(input.getVolume());
		result.setHasTransparency(input.isHasTransparency());
		result.setIfcProductOid(input.getIfcProductOid());
		result.setIfcProductUuid(input.getIfcProductUuid());
		result.setIfcProductRid(input.getIfcProductRid());
		result.setDensity(input.getDensity());
		result.setAdditionalData(input.getAdditionalData());
		result.setNrColors(input.getNrColors());
		result.setNrVertices(input.getNrVertices());
		result.setIfcProductPid(input.getIfcProductPid());
		Bounds boundsVal = input.getBounds();
		result.setBounds(convertToSObject(boundsVal));
		Bounds boundsUntransformedVal = input.getBoundsUntransformed();
		result.setBoundsUntransformed(convertToSObject(boundsUntransformedVal));
		GeometryData dataVal = input.getData();
		result.setDataId(dataVal == null ? -1 : dataVal.getOid());
		Bounds boundsMmVal = input.getBoundsMm();
		result.setBoundsMm(convertToSObject(boundsMmVal));
		Bounds boundsUntransformedMmVal = input.getBoundsUntransformedMm();
		result.setBoundsUntransformedMm(convertToSObject(boundsUntransformedMmVal));
		return result;
	}

	public GeometryInfo convertFromSObject(SGeometryInfo input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		GeometryInfo result = convertFromSObject(input, (GeometryInfo)session.create(GeometryPackage.eINSTANCE.getGeometryInfo()), session);
		
		
		return result;
	}

	public GeometryInfo convertFromSObject(SGeometryInfo input) throws BimserverDatabaseException {
		GeometryInfo result = convertFromSObject(input, GeometryFactory.eINSTANCE.createGeometryInfo(), null);
		return result;
	}

	public GeometryInfo convertFromSObject(SGeometryInfo input, GeometryInfo result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setStartVertex(input.getStartVertex());
		result.setStartIndex(input.getStartIndex());
		result.setPrimitiveCount(input.getPrimitiveCount());
		result.setTransformation(input.getTransformation());
		result.setArea(input.getArea());
		result.setVolume(input.getVolume());
		result.setHasTransparency(input.isHasTransparency());
		result.setIfcProductOid(input.getIfcProductOid());
		result.setIfcProductUuid(input.getIfcProductUuid());
		result.setIfcProductRid(input.getIfcProductRid());
		result.setDensity(input.getDensity());
		result.setAdditionalData(input.getAdditionalData());
		result.setNrColors(input.getNrColors());
		result.setNrVertices(input.getNrVertices());
		result.setIfcProductPid(input.getIfcProductPid());
		result.setBounds(convertFromSObject(input.getBounds(), session));
		result.setBoundsUntransformed(convertFromSObject(input.getBoundsUntransformed(), session));
		result.setData((GeometryData)session.get(GeometryPackage.eINSTANCE.getGeometryData(), input.getDataId(), OldQuery.getDefault()));
		result.setBoundsMm(convertFromSObject(input.getBoundsMm(), session));
		result.setBoundsUntransformedMm(convertFromSObject(input.getBoundsUntransformedMm(), session));
		return result;
	}

	public Set<SVector3f> convertToSSetVector3f(Collection<Vector3f> input) {
		Set<SVector3f> result = new HashSet<SVector3f>();
		for (Vector3f o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<Vector3f> convertFromSSetVector3f(Collection<SVector3f> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<Vector3f> result = new HashSet<Vector3f>();
		for (SVector3f o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SVector3f> convertToSListVector3f(Collection<Vector3f> input) {
		List<SVector3f> result = new ArrayList<SVector3f>();
		for (Vector3f o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<Vector3f> convertFromSListVector3f(Collection<SVector3f> input, DatabaseSession session) throws BimserverDatabaseException {
		List<Vector3f> result = new ArrayList<Vector3f>();
		for (SVector3f o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SVector3f convertToSObject(Vector3f input) {
		if (input == null) {
			return null;
		}
		
		SVector3f result = new SVector3f();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setX(input.getX());
		result.setY(input.getY());
		result.setZ(input.getZ());
		return result;
	}

	public Vector3f convertFromSObject(SVector3f input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		Vector3f result = convertFromSObject(input, (Vector3f)session.create(GeometryPackage.eINSTANCE.getVector3f()), session);
		
		
		return result;
	}

	public Vector3f convertFromSObject(SVector3f input) throws BimserverDatabaseException {
		Vector3f result = convertFromSObject(input, GeometryFactory.eINSTANCE.createVector3f(), null);
		return result;
	}

	public Vector3f convertFromSObject(SVector3f input, Vector3f result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setX(input.getX());
		result.setY(input.getY());
		result.setZ(input.getZ());
		return result;
	}

	public Set<SBounds> convertToSSetBounds(Collection<Bounds> input) {
		Set<SBounds> result = new HashSet<SBounds>();
		for (Bounds o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<Bounds> convertFromSSetBounds(Collection<SBounds> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<Bounds> result = new HashSet<Bounds>();
		for (SBounds o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SBounds> convertToSListBounds(Collection<Bounds> input) {
		List<SBounds> result = new ArrayList<SBounds>();
		for (Bounds o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<Bounds> convertFromSListBounds(Collection<SBounds> input, DatabaseSession session) throws BimserverDatabaseException {
		List<Bounds> result = new ArrayList<Bounds>();
		for (SBounds o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SBounds convertToSObject(Bounds input) {
		if (input == null) {
			return null;
		}
		
		SBounds result = new SBounds();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		Vector3f minVal = input.getMin();
		result.setMin(convertToSObject(minVal));
		Vector3f maxVal = input.getMax();
		result.setMax(convertToSObject(maxVal));
		return result;
	}

	public Bounds convertFromSObject(SBounds input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		Bounds result = convertFromSObject(input, (Bounds)session.create(GeometryPackage.eINSTANCE.getBounds()), session);
		
		
		return result;
	}

	public Bounds convertFromSObject(SBounds input) throws BimserverDatabaseException {
		Bounds result = convertFromSObject(input, GeometryFactory.eINSTANCE.createBounds(), null);
		return result;
	}

	public Bounds convertFromSObject(SBounds input, Bounds result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setMin(convertFromSObject(input.getMin(), session));
		result.setMax(convertFromSObject(input.getMax(), session));
		return result;
	}

	public Set<SBuffer> convertToSSetBuffer(Collection<Buffer> input) {
		Set<SBuffer> result = new HashSet<SBuffer>();
		for (Buffer o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<Buffer> convertFromSSetBuffer(Collection<SBuffer> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<Buffer> result = new HashSet<Buffer>();
		for (SBuffer o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SBuffer> convertToSListBuffer(Collection<Buffer> input) {
		List<SBuffer> result = new ArrayList<SBuffer>();
		for (Buffer o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<Buffer> convertFromSListBuffer(Collection<SBuffer> input, DatabaseSession session) throws BimserverDatabaseException {
		List<Buffer> result = new ArrayList<Buffer>();
		for (SBuffer o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SBuffer convertToSObject(Buffer input) {
		if (input == null) {
			return null;
		}
		
		SBuffer result = new SBuffer();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setData(input.getData());
		return result;
	}

	public Buffer convertFromSObject(SBuffer input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		Buffer result = convertFromSObject(input, (Buffer)session.create(GeometryPackage.eINSTANCE.getBuffer()), session);
		
		
		return result;
	}

	public Buffer convertFromSObject(SBuffer input) throws BimserverDatabaseException {
		Buffer result = convertFromSObject(input, GeometryFactory.eINSTANCE.createBuffer(), null);
		return result;
	}

	public Buffer convertFromSObject(SBuffer input, Buffer result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setData(input.getData());
		return result;
	}

	public Set<SGeometryData> convertToSSetGeometryData(Collection<GeometryData> input) {
		Set<SGeometryData> result = new HashSet<SGeometryData>();
		for (GeometryData o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<GeometryData> convertFromSSetGeometryData(Collection<SGeometryData> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<GeometryData> result = new HashSet<GeometryData>();
		for (SGeometryData o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SGeometryData> convertToSListGeometryData(Collection<GeometryData> input) {
		List<SGeometryData> result = new ArrayList<SGeometryData>();
		for (GeometryData o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<GeometryData> convertFromSListGeometryData(Collection<SGeometryData> input, DatabaseSession session) throws BimserverDatabaseException {
		List<GeometryData> result = new ArrayList<GeometryData>();
		for (SGeometryData o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SGeometryData convertToSObject(GeometryData input) {
		if (input == null) {
			return null;
		}
		
		SGeometryData result = new SGeometryData();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setNrIndices(input.getNrIndices());
		result.setNrVertices(input.getNrVertices());
		result.setNrNormals(input.getNrNormals());
		result.setNrColors(input.getNrColors());
		result.setHasTransparency(input.isHasTransparency());
		result.setReused(input.getReused());
		result.setType(input.getType());
		result.setSaveableTriangles(input.getSaveableTriangles());
		result.setNrLineIndices(input.getNrLineIndices());
		Buffer indicesVal = input.getIndices();
		result.setIndicesId(indicesVal == null ? -1 : indicesVal.getOid());
		Buffer verticesVal = input.getVertices();
		result.setVerticesId(verticesVal == null ? -1 : verticesVal.getOid());
		Buffer verticesQuantizedVal = input.getVerticesQuantized();
		result.setVerticesQuantizedId(verticesQuantizedVal == null ? -1 : verticesQuantizedVal.getOid());
		Buffer normalsVal = input.getNormals();
		result.setNormalsId(normalsVal == null ? -1 : normalsVal.getOid());
		Buffer normalsQuantizedVal = input.getNormalsQuantized();
		result.setNormalsQuantizedId(normalsQuantizedVal == null ? -1 : normalsQuantizedVal.getOid());
		Buffer colorsQuantizedVal = input.getColorsQuantized();
		result.setColorsQuantizedId(colorsQuantizedVal == null ? -1 : colorsQuantizedVal.getOid());
		Vector4f colorVal = input.getColor();
		result.setColor(convertToSObject(colorVal));
		Vector4f mostUsedColorVal = input.getMostUsedColor();
		result.setMostUsedColor(convertToSObject(mostUsedColorVal));
		Bounds boundsMmVal = input.getBoundsMm();
		result.setBoundsMm(convertToSObject(boundsMmVal));
		ColorPack colorPackVal = input.getColorPack();
		result.setColorPack(convertToSObject(colorPackVal));
		Buffer lineIndicesVal = input.getLineIndices();
		result.setLineIndicesId(lineIndicesVal == null ? -1 : lineIndicesVal.getOid());
		return result;
	}

	public GeometryData convertFromSObject(SGeometryData input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		GeometryData result = convertFromSObject(input, (GeometryData)session.create(GeometryPackage.eINSTANCE.getGeometryData()), session);
		
		
		return result;
	}

	public GeometryData convertFromSObject(SGeometryData input) throws BimserverDatabaseException {
		GeometryData result = convertFromSObject(input, GeometryFactory.eINSTANCE.createGeometryData(), null);
		return result;
	}

	public GeometryData convertFromSObject(SGeometryData input, GeometryData result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setNrIndices(input.getNrIndices());
		result.setNrVertices(input.getNrVertices());
		result.setNrNormals(input.getNrNormals());
		result.setNrColors(input.getNrColors());
		result.setHasTransparency(input.isHasTransparency());
		result.setReused(input.getReused());
		result.setType(input.getType());
		result.setSaveableTriangles(input.getSaveableTriangles());
		result.setNrLineIndices(input.getNrLineIndices());
		result.setIndices((Buffer)session.get(GeometryPackage.eINSTANCE.getBuffer(), input.getIndicesId(), OldQuery.getDefault()));
		result.setVertices((Buffer)session.get(GeometryPackage.eINSTANCE.getBuffer(), input.getVerticesId(), OldQuery.getDefault()));
		result.setVerticesQuantized((Buffer)session.get(GeometryPackage.eINSTANCE.getBuffer(), input.getVerticesQuantizedId(), OldQuery.getDefault()));
		result.setNormals((Buffer)session.get(GeometryPackage.eINSTANCE.getBuffer(), input.getNormalsId(), OldQuery.getDefault()));
		result.setNormalsQuantized((Buffer)session.get(GeometryPackage.eINSTANCE.getBuffer(), input.getNormalsQuantizedId(), OldQuery.getDefault()));
		result.setColorsQuantized((Buffer)session.get(GeometryPackage.eINSTANCE.getBuffer(), input.getColorsQuantizedId(), OldQuery.getDefault()));
		result.setColor(convertFromSObject(input.getColor(), session));
		result.setMostUsedColor(convertFromSObject(input.getMostUsedColor(), session));
		result.setBoundsMm(convertFromSObject(input.getBoundsMm(), session));
		result.setColorPack(convertFromSObject(input.getColorPack(), session));
		result.setLineIndices((Buffer)session.get(GeometryPackage.eINSTANCE.getBuffer(), input.getLineIndicesId(), OldQuery.getDefault()));
		return result;
	}

	public Set<SVector4f> convertToSSetVector4f(Collection<Vector4f> input) {
		Set<SVector4f> result = new HashSet<SVector4f>();
		for (Vector4f o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<Vector4f> convertFromSSetVector4f(Collection<SVector4f> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<Vector4f> result = new HashSet<Vector4f>();
		for (SVector4f o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SVector4f> convertToSListVector4f(Collection<Vector4f> input) {
		List<SVector4f> result = new ArrayList<SVector4f>();
		for (Vector4f o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<Vector4f> convertFromSListVector4f(Collection<SVector4f> input, DatabaseSession session) throws BimserverDatabaseException {
		List<Vector4f> result = new ArrayList<Vector4f>();
		for (SVector4f o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SVector4f convertToSObject(Vector4f input) {
		if (input == null) {
			return null;
		}
		
		SVector4f result = new SVector4f();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setX(input.getX());
		result.setY(input.getY());
		result.setZ(input.getZ());
		result.setW(input.getW());
		return result;
	}

	public Vector4f convertFromSObject(SVector4f input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		Vector4f result = convertFromSObject(input, (Vector4f)session.create(GeometryPackage.eINSTANCE.getVector4f()), session);
		
		
		return result;
	}

	public Vector4f convertFromSObject(SVector4f input) throws BimserverDatabaseException {
		Vector4f result = convertFromSObject(input, GeometryFactory.eINSTANCE.createVector4f(), null);
		return result;
	}

	public Vector4f convertFromSObject(SVector4f input, Vector4f result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setX(input.getX());
		result.setY(input.getY());
		result.setZ(input.getZ());
		result.setW(input.getW());
		return result;
	}

	public Set<SColorPack> convertToSSetColorPack(Collection<ColorPack> input) {
		Set<SColorPack> result = new HashSet<SColorPack>();
		for (ColorPack o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ColorPack> convertFromSSetColorPack(Collection<SColorPack> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ColorPack> result = new HashSet<ColorPack>();
		for (SColorPack o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SColorPack> convertToSListColorPack(Collection<ColorPack> input) {
		List<SColorPack> result = new ArrayList<SColorPack>();
		for (ColorPack o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ColorPack> convertFromSListColorPack(Collection<SColorPack> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ColorPack> result = new ArrayList<ColorPack>();
		for (SColorPack o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SColorPack convertToSObject(ColorPack input) {
		if (input == null) {
			return null;
		}
		
		SColorPack result = new SColorPack();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setData(input.getData());
		return result;
	}

	public ColorPack convertFromSObject(SColorPack input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		ColorPack result = convertFromSObject(input, (ColorPack)session.create(GeometryPackage.eINSTANCE.getColorPack()), session);
		
		
		return result;
	}

	public ColorPack convertFromSObject(SColorPack input) throws BimserverDatabaseException {
		ColorPack result = convertFromSObject(input, GeometryFactory.eINSTANCE.createColorPack(), null);
		return result;
	}

	public ColorPack convertFromSObject(SColorPack input, ColorPack result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setData(input.getData());
		return result;
	}
		public SAccessMethod convertToSObject(AccessMethod input) {
			return SAccessMethod.values()[input.ordinal()];
		}
		
		public AccessMethod convertFromSObject(SAccessMethod input) {
			return AccessMethod.values()[input.ordinal()];
		}

	public Set<SLogAction> convertToSSetLogAction(Collection<LogAction> input) {
		Set<SLogAction> result = new HashSet<SLogAction>();
		for (LogAction o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<LogAction> convertFromSSetLogAction(Collection<SLogAction> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<LogAction> result = new HashSet<LogAction>();
		for (SLogAction o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SLogAction> convertToSListLogAction(Collection<LogAction> input) {
		List<SLogAction> result = new ArrayList<SLogAction>();
		for (LogAction o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<LogAction> convertFromSListLogAction(Collection<SLogAction> input, DatabaseSession session) throws BimserverDatabaseException {
		List<LogAction> result = new ArrayList<LogAction>();
		for (SLogAction o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SLogAction convertToSObject(LogAction input) {
		if (input == null) {
			return null;
		}
		
		if (input instanceof CheckoutRelated) {
			return convertToSObject((CheckoutRelated)input);
		}
		else if (input instanceof DatabaseCreated) {
			return convertToSObject((DatabaseCreated)input);
		}
		else if (input instanceof Download) {
			return convertToSObject((Download)input);
		}
		else if (input instanceof ExtendedDataAddedToProject) {
			return convertToSObject((ExtendedDataAddedToProject)input);
		}
		else if (input instanceof ExtendedDataAddedToRevision) {
			return convertToSObject((ExtendedDataAddedToRevision)input);
		}
		else if (input instanceof GeoTagUpdated) {
			return convertToSObject((GeoTagUpdated)input);
		}
		else if (input instanceof NewObjectIDMUploaded) {
			return convertToSObject((NewObjectIDMUploaded)input);
		}
		else if (input instanceof ProjectRelated) {
			return convertToSObject((ProjectRelated)input);
		}
		else if (input instanceof RemoteServiceCalled) {
			return convertToSObject((RemoteServiceCalled)input);
		}
		else if (input instanceof RevisionBranched) {
			return convertToSObject((RevisionBranched)input);
		}
		else if (input instanceof RevisionRelated) {
			return convertToSObject((RevisionRelated)input);
		}
		else if (input instanceof ServerStarted) {
			return convertToSObject((ServerStarted)input);
		}
		else if (input instanceof SettingsSaved) {
			return convertToSObject((SettingsSaved)input);
		}
		else if (input instanceof UserRelated) {
			return convertToSObject((UserRelated)input);
		}
		SLogAction result = new SLogAction();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		return result;
	}

	public LogAction convertFromSObject(SLogAction input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		LogAction result = convertFromSObject(input, (LogAction)session.create(LogPackage.eINSTANCE.getLogAction()), session);
		
		
		return result;
	}

	public LogAction convertFromSObject(SLogAction input) throws BimserverDatabaseException {
		LogAction result = convertFromSObject(input, LogFactory.eINSTANCE.createLogAction(), null);
		return result;
	}

	public LogAction convertFromSObject(SLogAction input, LogAction result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		if (input instanceof SCheckoutRelated) {
			return convertFromSObject((SCheckoutRelated)input, session);
		}
		else if (input instanceof SDatabaseCreated) {
			return convertFromSObject((SDatabaseCreated)input, session);
		}
		else if (input instanceof SDownload) {
			return convertFromSObject((SDownload)input, session);
		}
		else if (input instanceof SExtendedDataAddedToProject) {
			return convertFromSObject((SExtendedDataAddedToProject)input, session);
		}
		else if (input instanceof SExtendedDataAddedToRevision) {
			return convertFromSObject((SExtendedDataAddedToRevision)input, session);
		}
		else if (input instanceof SGeoTagUpdated) {
			return convertFromSObject((SGeoTagUpdated)input, session);
		}
		else if (input instanceof SNewObjectIDMUploaded) {
			return convertFromSObject((SNewObjectIDMUploaded)input, session);
		}
		else if (input instanceof SProjectRelated) {
			return convertFromSObject((SProjectRelated)input, session);
		}
		else if (input instanceof SRemoteServiceCalled) {
			return convertFromSObject((SRemoteServiceCalled)input, session);
		}
		else if (input instanceof SRevisionBranched) {
			return convertFromSObject((SRevisionBranched)input, session);
		}
		else if (input instanceof SRevisionRelated) {
			return convertFromSObject((SRevisionRelated)input, session);
		}
		else if (input instanceof SServerStarted) {
			return convertFromSObject((SServerStarted)input, session);
		}
		else if (input instanceof SSettingsSaved) {
			return convertFromSObject((SSettingsSaved)input, session);
		}
		else if (input instanceof SUserRelated) {
			return convertFromSObject((SUserRelated)input, session);
		}
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), OldQuery.getDefault()));
		return result;
	}

	public Set<SServerLog> convertToSSetServerLog(Collection<ServerLog> input) {
		Set<SServerLog> result = new HashSet<SServerLog>();
		for (ServerLog o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ServerLog> convertFromSSetServerLog(Collection<SServerLog> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ServerLog> result = new HashSet<ServerLog>();
		for (SServerLog o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SServerLog> convertToSListServerLog(Collection<ServerLog> input) {
		List<SServerLog> result = new ArrayList<SServerLog>();
		for (ServerLog o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ServerLog> convertFromSListServerLog(Collection<SServerLog> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ServerLog> result = new ArrayList<ServerLog>();
		for (SServerLog o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SServerLog convertToSObject(ServerLog input) {
		if (input == null) {
			return null;
		}
		
		SServerLog result = new SServerLog();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		List<Long> listactions = new ArrayList<Long>();
		for (LogAction v : input.getActions()) {
			listactions.add(v.getOid());
		}
		result.setActions(listactions);
		return result;
	}

	public ServerLog convertFromSObject(SServerLog input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		ServerLog result = convertFromSObject(input, (ServerLog)session.create(LogPackage.eINSTANCE.getServerLog()), session);
		
		
		return result;
	}

	public ServerLog convertFromSObject(SServerLog input) throws BimserverDatabaseException {
		ServerLog result = convertFromSObject(input, LogFactory.eINSTANCE.createServerLog(), null);
		return result;
	}

	public ServerLog convertFromSObject(SServerLog input, ServerLog result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		List<LogAction> listactions = result.getActions();
		for (long oid : input.getActions()) {
			listactions.add((LogAction)session.get(LogPackage.eINSTANCE.getLogAction(), oid, OldQuery.getDefault()));
		}
		return result;
	}

	public Set<SProjectRelated> convertToSSetProjectRelated(Collection<ProjectRelated> input) {
		Set<SProjectRelated> result = new HashSet<SProjectRelated>();
		for (ProjectRelated o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ProjectRelated> convertFromSSetProjectRelated(Collection<SProjectRelated> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ProjectRelated> result = new HashSet<ProjectRelated>();
		for (SProjectRelated o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SProjectRelated> convertToSListProjectRelated(Collection<ProjectRelated> input) {
		List<SProjectRelated> result = new ArrayList<SProjectRelated>();
		for (ProjectRelated o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ProjectRelated> convertFromSListProjectRelated(Collection<SProjectRelated> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ProjectRelated> result = new ArrayList<ProjectRelated>();
		for (SProjectRelated o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SProjectRelated convertToSObject(ProjectRelated input) {
		if (input == null) {
			return null;
		}
		
		if (input instanceof NewProjectAdded) {
			return convertToSObject((NewProjectAdded)input);
		}
		else if (input instanceof ProjectDeleted) {
			return convertToSObject((ProjectDeleted)input);
		}
		else if (input instanceof ProjectUndeleted) {
			return convertToSObject((ProjectUndeleted)input);
		}
		else if (input instanceof ProjectUpdated) {
			return convertToSObject((ProjectUpdated)input);
		}
		SProjectRelated result = new SProjectRelated();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		Project projectVal = input.getProject();
		result.setProjectId(projectVal == null ? -1 : projectVal.getOid());
		return result;
	}

	public ProjectRelated convertFromSObject(SProjectRelated input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		ProjectRelated result = convertFromSObject(input, (ProjectRelated)session.create(LogPackage.eINSTANCE.getProjectRelated()), session);
		
		
		return result;
	}

	public ProjectRelated convertFromSObject(SProjectRelated input) throws BimserverDatabaseException {
		ProjectRelated result = convertFromSObject(input, LogFactory.eINSTANCE.createProjectRelated(), null);
		return result;
	}

	public ProjectRelated convertFromSObject(SProjectRelated input, ProjectRelated result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		if (input instanceof SNewProjectAdded) {
			return convertFromSObject((SNewProjectAdded)input, session);
		}
		else if (input instanceof SProjectDeleted) {
			return convertFromSObject((SProjectDeleted)input, session);
		}
		else if (input instanceof SProjectUndeleted) {
			return convertFromSObject((SProjectUndeleted)input, session);
		}
		else if (input instanceof SProjectUpdated) {
			return convertFromSObject((SProjectUpdated)input, session);
		}
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), OldQuery.getDefault()));
		result.setProject((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getProjectId(), OldQuery.getDefault()));
		return result;
	}

	public Set<SCheckoutRelated> convertToSSetCheckoutRelated(Collection<CheckoutRelated> input) {
		Set<SCheckoutRelated> result = new HashSet<SCheckoutRelated>();
		for (CheckoutRelated o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<CheckoutRelated> convertFromSSetCheckoutRelated(Collection<SCheckoutRelated> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<CheckoutRelated> result = new HashSet<CheckoutRelated>();
		for (SCheckoutRelated o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SCheckoutRelated> convertToSListCheckoutRelated(Collection<CheckoutRelated> input) {
		List<SCheckoutRelated> result = new ArrayList<SCheckoutRelated>();
		for (CheckoutRelated o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<CheckoutRelated> convertFromSListCheckoutRelated(Collection<SCheckoutRelated> input, DatabaseSession session) throws BimserverDatabaseException {
		List<CheckoutRelated> result = new ArrayList<CheckoutRelated>();
		for (SCheckoutRelated o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SCheckoutRelated convertToSObject(CheckoutRelated input) {
		if (input == null) {
			return null;
		}
		
		if (input instanceof NewCheckoutAdded) {
			return convertToSObject((NewCheckoutAdded)input);
		}
		SCheckoutRelated result = new SCheckoutRelated();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		Checkout checkoutVal = input.getCheckout();
		result.setCheckoutId(checkoutVal == null ? -1 : checkoutVal.getOid());
		return result;
	}

	public CheckoutRelated convertFromSObject(SCheckoutRelated input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		CheckoutRelated result = convertFromSObject(input, (CheckoutRelated)session.create(LogPackage.eINSTANCE.getCheckoutRelated()), session);
		
		
		return result;
	}

	public CheckoutRelated convertFromSObject(SCheckoutRelated input) throws BimserverDatabaseException {
		CheckoutRelated result = convertFromSObject(input, LogFactory.eINSTANCE.createCheckoutRelated(), null);
		return result;
	}

	public CheckoutRelated convertFromSObject(SCheckoutRelated input, CheckoutRelated result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		if (input instanceof SNewCheckoutAdded) {
			return convertFromSObject((SNewCheckoutAdded)input, session);
		}
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), OldQuery.getDefault()));
		result.setCheckout((Checkout)session.get(StorePackage.eINSTANCE.getCheckout(), input.getCheckoutId(), OldQuery.getDefault()));
		return result;
	}

	public Set<SRevisionRelated> convertToSSetRevisionRelated(Collection<RevisionRelated> input) {
		Set<SRevisionRelated> result = new HashSet<SRevisionRelated>();
		for (RevisionRelated o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<RevisionRelated> convertFromSSetRevisionRelated(Collection<SRevisionRelated> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<RevisionRelated> result = new HashSet<RevisionRelated>();
		for (SRevisionRelated o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SRevisionRelated> convertToSListRevisionRelated(Collection<RevisionRelated> input) {
		List<SRevisionRelated> result = new ArrayList<SRevisionRelated>();
		for (RevisionRelated o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<RevisionRelated> convertFromSListRevisionRelated(Collection<SRevisionRelated> input, DatabaseSession session) throws BimserverDatabaseException {
		List<RevisionRelated> result = new ArrayList<RevisionRelated>();
		for (SRevisionRelated o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SRevisionRelated convertToSObject(RevisionRelated input) {
		if (input == null) {
			return null;
		}
		
		if (input instanceof NewRevisionAdded) {
			return convertToSObject((NewRevisionAdded)input);
		}
		else if (input instanceof RevisionUpdated) {
			return convertToSObject((RevisionUpdated)input);
		}
		SRevisionRelated result = new SRevisionRelated();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		Revision revisionVal = input.getRevision();
		result.setRevisionId(revisionVal == null ? -1 : revisionVal.getOid());
		return result;
	}

	public RevisionRelated convertFromSObject(SRevisionRelated input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		RevisionRelated result = convertFromSObject(input, (RevisionRelated)session.create(LogPackage.eINSTANCE.getRevisionRelated()), session);
		
		
		return result;
	}

	public RevisionRelated convertFromSObject(SRevisionRelated input) throws BimserverDatabaseException {
		RevisionRelated result = convertFromSObject(input, LogFactory.eINSTANCE.createRevisionRelated(), null);
		return result;
	}

	public RevisionRelated convertFromSObject(SRevisionRelated input, RevisionRelated result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		if (input instanceof SNewRevisionAdded) {
			return convertFromSObject((SNewRevisionAdded)input, session);
		}
		else if (input instanceof SRevisionUpdated) {
			return convertFromSObject((SRevisionUpdated)input, session);
		}
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), OldQuery.getDefault()));
		result.setRevision((Revision)session.get(StorePackage.eINSTANCE.getRevision(), input.getRevisionId(), OldQuery.getDefault()));
		return result;
	}

	public Set<SUserRelated> convertToSSetUserRelated(Collection<UserRelated> input) {
		Set<SUserRelated> result = new HashSet<SUserRelated>();
		for (UserRelated o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<UserRelated> convertFromSSetUserRelated(Collection<SUserRelated> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<UserRelated> result = new HashSet<UserRelated>();
		for (SUserRelated o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SUserRelated> convertToSListUserRelated(Collection<UserRelated> input) {
		List<SUserRelated> result = new ArrayList<SUserRelated>();
		for (UserRelated o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<UserRelated> convertFromSListUserRelated(Collection<SUserRelated> input, DatabaseSession session) throws BimserverDatabaseException {
		List<UserRelated> result = new ArrayList<UserRelated>();
		for (SUserRelated o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SUserRelated convertToSObject(UserRelated input) {
		if (input == null) {
			return null;
		}
		
		if (input instanceof NewUserAdded) {
			return convertToSObject((NewUserAdded)input);
		}
		else if (input instanceof PasswordChanged) {
			return convertToSObject((PasswordChanged)input);
		}
		else if (input instanceof PasswordReset) {
			return convertToSObject((PasswordReset)input);
		}
		else if (input instanceof UserAddedToProject) {
			return convertToSObject((UserAddedToProject)input);
		}
		else if (input instanceof UserChanged) {
			return convertToSObject((UserChanged)input);
		}
		else if (input instanceof UserDeleted) {
			return convertToSObject((UserDeleted)input);
		}
		else if (input instanceof UserRemovedFromProject) {
			return convertToSObject((UserRemovedFromProject)input);
		}
		else if (input instanceof UserUndeleted) {
			return convertToSObject((UserUndeleted)input);
		}
		SUserRelated result = new SUserRelated();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		User userVal = input.getUser();
		result.setUserId(userVal == null ? -1 : userVal.getOid());
		return result;
	}

	public UserRelated convertFromSObject(SUserRelated input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		UserRelated result = convertFromSObject(input, (UserRelated)session.create(LogPackage.eINSTANCE.getUserRelated()), session);
		
		
		return result;
	}

	public UserRelated convertFromSObject(SUserRelated input) throws BimserverDatabaseException {
		UserRelated result = convertFromSObject(input, LogFactory.eINSTANCE.createUserRelated(), null);
		return result;
	}

	public UserRelated convertFromSObject(SUserRelated input, UserRelated result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		if (input instanceof SNewUserAdded) {
			return convertFromSObject((SNewUserAdded)input, session);
		}
		else if (input instanceof SPasswordChanged) {
			return convertFromSObject((SPasswordChanged)input, session);
		}
		else if (input instanceof SPasswordReset) {
			return convertFromSObject((SPasswordReset)input, session);
		}
		else if (input instanceof SUserAddedToProject) {
			return convertFromSObject((SUserAddedToProject)input, session);
		}
		else if (input instanceof SUserChanged) {
			return convertFromSObject((SUserChanged)input, session);
		}
		else if (input instanceof SUserDeleted) {
			return convertFromSObject((SUserDeleted)input, session);
		}
		else if (input instanceof SUserRemovedFromProject) {
			return convertFromSObject((SUserRemovedFromProject)input, session);
		}
		else if (input instanceof SUserUndeleted) {
			return convertFromSObject((SUserUndeleted)input, session);
		}
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), OldQuery.getDefault()));
		result.setUser((User)session.get(StorePackage.eINSTANCE.getUser(), input.getUserId(), OldQuery.getDefault()));
		return result;
	}

	public Set<SNewUserAdded> convertToSSetNewUserAdded(Collection<NewUserAdded> input) {
		Set<SNewUserAdded> result = new HashSet<SNewUserAdded>();
		for (NewUserAdded o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<NewUserAdded> convertFromSSetNewUserAdded(Collection<SNewUserAdded> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<NewUserAdded> result = new HashSet<NewUserAdded>();
		for (SNewUserAdded o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SNewUserAdded> convertToSListNewUserAdded(Collection<NewUserAdded> input) {
		List<SNewUserAdded> result = new ArrayList<SNewUserAdded>();
		for (NewUserAdded o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<NewUserAdded> convertFromSListNewUserAdded(Collection<SNewUserAdded> input, DatabaseSession session) throws BimserverDatabaseException {
		List<NewUserAdded> result = new ArrayList<NewUserAdded>();
		for (SNewUserAdded o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SNewUserAdded convertToSObject(NewUserAdded input) {
		if (input == null) {
			return null;
		}
		
		SNewUserAdded result = new SNewUserAdded();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		User userVal = input.getUser();
		result.setUserId(userVal == null ? -1 : userVal.getOid());
		return result;
	}

	public NewUserAdded convertFromSObject(SNewUserAdded input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		NewUserAdded result = convertFromSObject(input, (NewUserAdded)session.create(LogPackage.eINSTANCE.getNewUserAdded()), session);
		
		
		return result;
	}

	public NewUserAdded convertFromSObject(SNewUserAdded input) throws BimserverDatabaseException {
		NewUserAdded result = convertFromSObject(input, LogFactory.eINSTANCE.createNewUserAdded(), null);
		return result;
	}

	public NewUserAdded convertFromSObject(SNewUserAdded input, NewUserAdded result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), OldQuery.getDefault()));
		result.setUser((User)session.get(StorePackage.eINSTANCE.getUser(), input.getUserId(), OldQuery.getDefault()));
		return result;
	}

	public Set<SNewProjectAdded> convertToSSetNewProjectAdded(Collection<NewProjectAdded> input) {
		Set<SNewProjectAdded> result = new HashSet<SNewProjectAdded>();
		for (NewProjectAdded o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<NewProjectAdded> convertFromSSetNewProjectAdded(Collection<SNewProjectAdded> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<NewProjectAdded> result = new HashSet<NewProjectAdded>();
		for (SNewProjectAdded o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SNewProjectAdded> convertToSListNewProjectAdded(Collection<NewProjectAdded> input) {
		List<SNewProjectAdded> result = new ArrayList<SNewProjectAdded>();
		for (NewProjectAdded o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<NewProjectAdded> convertFromSListNewProjectAdded(Collection<SNewProjectAdded> input, DatabaseSession session) throws BimserverDatabaseException {
		List<NewProjectAdded> result = new ArrayList<NewProjectAdded>();
		for (SNewProjectAdded o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SNewProjectAdded convertToSObject(NewProjectAdded input) {
		if (input == null) {
			return null;
		}
		
		SNewProjectAdded result = new SNewProjectAdded();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		Project projectVal = input.getProject();
		result.setProjectId(projectVal == null ? -1 : projectVal.getOid());
		Project parentProjectVal = input.getParentProject();
		result.setParentProjectId(parentProjectVal == null ? -1 : parentProjectVal.getOid());
		return result;
	}

	public NewProjectAdded convertFromSObject(SNewProjectAdded input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		NewProjectAdded result = convertFromSObject(input, (NewProjectAdded)session.create(LogPackage.eINSTANCE.getNewProjectAdded()), session);
		
		
		return result;
	}

	public NewProjectAdded convertFromSObject(SNewProjectAdded input) throws BimserverDatabaseException {
		NewProjectAdded result = convertFromSObject(input, LogFactory.eINSTANCE.createNewProjectAdded(), null);
		return result;
	}

	public NewProjectAdded convertFromSObject(SNewProjectAdded input, NewProjectAdded result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), OldQuery.getDefault()));
		result.setProject((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getProjectId(), OldQuery.getDefault()));
		result.setParentProject((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getParentProjectId(), OldQuery.getDefault()));
		return result;
	}

	public Set<SRevisionBranched> convertToSSetRevisionBranched(Collection<RevisionBranched> input) {
		Set<SRevisionBranched> result = new HashSet<SRevisionBranched>();
		for (RevisionBranched o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<RevisionBranched> convertFromSSetRevisionBranched(Collection<SRevisionBranched> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<RevisionBranched> result = new HashSet<RevisionBranched>();
		for (SRevisionBranched o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SRevisionBranched> convertToSListRevisionBranched(Collection<RevisionBranched> input) {
		List<SRevisionBranched> result = new ArrayList<SRevisionBranched>();
		for (RevisionBranched o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<RevisionBranched> convertFromSListRevisionBranched(Collection<SRevisionBranched> input, DatabaseSession session) throws BimserverDatabaseException {
		List<RevisionBranched> result = new ArrayList<RevisionBranched>();
		for (SRevisionBranched o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SRevisionBranched convertToSObject(RevisionBranched input) {
		if (input == null) {
			return null;
		}
		
		SRevisionBranched result = new SRevisionBranched();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		Revision oldrevisionVal = input.getOldrevision();
		result.setOldrevisionId(oldrevisionVal == null ? -1 : oldrevisionVal.getOid());
		Revision newrevisionVal = input.getNewrevision();
		result.setNewrevisionId(newrevisionVal == null ? -1 : newrevisionVal.getOid());
		return result;
	}

	public RevisionBranched convertFromSObject(SRevisionBranched input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		RevisionBranched result = convertFromSObject(input, (RevisionBranched)session.create(LogPackage.eINSTANCE.getRevisionBranched()), session);
		
		
		return result;
	}

	public RevisionBranched convertFromSObject(SRevisionBranched input) throws BimserverDatabaseException {
		RevisionBranched result = convertFromSObject(input, LogFactory.eINSTANCE.createRevisionBranched(), null);
		return result;
	}

	public RevisionBranched convertFromSObject(SRevisionBranched input, RevisionBranched result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), OldQuery.getDefault()));
		result.setOldrevision((Revision)session.get(StorePackage.eINSTANCE.getRevision(), input.getOldrevisionId(), OldQuery.getDefault()));
		result.setNewrevision((Revision)session.get(StorePackage.eINSTANCE.getRevision(), input.getNewrevisionId(), OldQuery.getDefault()));
		return result;
	}

	public Set<SNewRevisionAdded> convertToSSetNewRevisionAdded(Collection<NewRevisionAdded> input) {
		Set<SNewRevisionAdded> result = new HashSet<SNewRevisionAdded>();
		for (NewRevisionAdded o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<NewRevisionAdded> convertFromSSetNewRevisionAdded(Collection<SNewRevisionAdded> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<NewRevisionAdded> result = new HashSet<NewRevisionAdded>();
		for (SNewRevisionAdded o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SNewRevisionAdded> convertToSListNewRevisionAdded(Collection<NewRevisionAdded> input) {
		List<SNewRevisionAdded> result = new ArrayList<SNewRevisionAdded>();
		for (NewRevisionAdded o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<NewRevisionAdded> convertFromSListNewRevisionAdded(Collection<SNewRevisionAdded> input, DatabaseSession session) throws BimserverDatabaseException {
		List<NewRevisionAdded> result = new ArrayList<NewRevisionAdded>();
		for (SNewRevisionAdded o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SNewRevisionAdded convertToSObject(NewRevisionAdded input) {
		if (input == null) {
			return null;
		}
		
		SNewRevisionAdded result = new SNewRevisionAdded();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		Revision revisionVal = input.getRevision();
		result.setRevisionId(revisionVal == null ? -1 : revisionVal.getOid());
		Project projectVal = input.getProject();
		result.setProjectId(projectVal == null ? -1 : projectVal.getOid());
		return result;
	}

	public NewRevisionAdded convertFromSObject(SNewRevisionAdded input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		NewRevisionAdded result = convertFromSObject(input, (NewRevisionAdded)session.create(LogPackage.eINSTANCE.getNewRevisionAdded()), session);
		
		
		return result;
	}

	public NewRevisionAdded convertFromSObject(SNewRevisionAdded input) throws BimserverDatabaseException {
		NewRevisionAdded result = convertFromSObject(input, LogFactory.eINSTANCE.createNewRevisionAdded(), null);
		return result;
	}

	public NewRevisionAdded convertFromSObject(SNewRevisionAdded input, NewRevisionAdded result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), OldQuery.getDefault()));
		result.setRevision((Revision)session.get(StorePackage.eINSTANCE.getRevision(), input.getRevisionId(), OldQuery.getDefault()));
		result.setProject((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getProjectId(), OldQuery.getDefault()));
		return result;
	}

	public Set<SNewCheckoutAdded> convertToSSetNewCheckoutAdded(Collection<NewCheckoutAdded> input) {
		Set<SNewCheckoutAdded> result = new HashSet<SNewCheckoutAdded>();
		for (NewCheckoutAdded o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<NewCheckoutAdded> convertFromSSetNewCheckoutAdded(Collection<SNewCheckoutAdded> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<NewCheckoutAdded> result = new HashSet<NewCheckoutAdded>();
		for (SNewCheckoutAdded o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SNewCheckoutAdded> convertToSListNewCheckoutAdded(Collection<NewCheckoutAdded> input) {
		List<SNewCheckoutAdded> result = new ArrayList<SNewCheckoutAdded>();
		for (NewCheckoutAdded o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<NewCheckoutAdded> convertFromSListNewCheckoutAdded(Collection<SNewCheckoutAdded> input, DatabaseSession session) throws BimserverDatabaseException {
		List<NewCheckoutAdded> result = new ArrayList<NewCheckoutAdded>();
		for (SNewCheckoutAdded o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SNewCheckoutAdded convertToSObject(NewCheckoutAdded input) {
		if (input == null) {
			return null;
		}
		
		SNewCheckoutAdded result = new SNewCheckoutAdded();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		Checkout checkoutVal = input.getCheckout();
		result.setCheckoutId(checkoutVal == null ? -1 : checkoutVal.getOid());
		return result;
	}

	public NewCheckoutAdded convertFromSObject(SNewCheckoutAdded input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		NewCheckoutAdded result = convertFromSObject(input, (NewCheckoutAdded)session.create(LogPackage.eINSTANCE.getNewCheckoutAdded()), session);
		
		
		return result;
	}

	public NewCheckoutAdded convertFromSObject(SNewCheckoutAdded input) throws BimserverDatabaseException {
		NewCheckoutAdded result = convertFromSObject(input, LogFactory.eINSTANCE.createNewCheckoutAdded(), null);
		return result;
	}

	public NewCheckoutAdded convertFromSObject(SNewCheckoutAdded input, NewCheckoutAdded result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), OldQuery.getDefault()));
		result.setCheckout((Checkout)session.get(StorePackage.eINSTANCE.getCheckout(), input.getCheckoutId(), OldQuery.getDefault()));
		return result;
	}

	public Set<SSettingsSaved> convertToSSetSettingsSaved(Collection<SettingsSaved> input) {
		Set<SSettingsSaved> result = new HashSet<SSettingsSaved>();
		for (SettingsSaved o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<SettingsSaved> convertFromSSetSettingsSaved(Collection<SSettingsSaved> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<SettingsSaved> result = new HashSet<SettingsSaved>();
		for (SSettingsSaved o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SSettingsSaved> convertToSListSettingsSaved(Collection<SettingsSaved> input) {
		List<SSettingsSaved> result = new ArrayList<SSettingsSaved>();
		for (SettingsSaved o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<SettingsSaved> convertFromSListSettingsSaved(Collection<SSettingsSaved> input, DatabaseSession session) throws BimserverDatabaseException {
		List<SettingsSaved> result = new ArrayList<SettingsSaved>();
		for (SSettingsSaved o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SSettingsSaved convertToSObject(SettingsSaved input) {
		if (input == null) {
			return null;
		}
		
		SSettingsSaved result = new SSettingsSaved();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		return result;
	}

	public SettingsSaved convertFromSObject(SSettingsSaved input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		SettingsSaved result = convertFromSObject(input, (SettingsSaved)session.create(LogPackage.eINSTANCE.getSettingsSaved()), session);
		
		
		return result;
	}

	public SettingsSaved convertFromSObject(SSettingsSaved input) throws BimserverDatabaseException {
		SettingsSaved result = convertFromSObject(input, LogFactory.eINSTANCE.createSettingsSaved(), null);
		return result;
	}

	public SettingsSaved convertFromSObject(SSettingsSaved input, SettingsSaved result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), OldQuery.getDefault()));
		return result;
	}

	public Set<SUserAddedToProject> convertToSSetUserAddedToProject(Collection<UserAddedToProject> input) {
		Set<SUserAddedToProject> result = new HashSet<SUserAddedToProject>();
		for (UserAddedToProject o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<UserAddedToProject> convertFromSSetUserAddedToProject(Collection<SUserAddedToProject> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<UserAddedToProject> result = new HashSet<UserAddedToProject>();
		for (SUserAddedToProject o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SUserAddedToProject> convertToSListUserAddedToProject(Collection<UserAddedToProject> input) {
		List<SUserAddedToProject> result = new ArrayList<SUserAddedToProject>();
		for (UserAddedToProject o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<UserAddedToProject> convertFromSListUserAddedToProject(Collection<SUserAddedToProject> input, DatabaseSession session) throws BimserverDatabaseException {
		List<UserAddedToProject> result = new ArrayList<UserAddedToProject>();
		for (SUserAddedToProject o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SUserAddedToProject convertToSObject(UserAddedToProject input) {
		if (input == null) {
			return null;
		}
		
		SUserAddedToProject result = new SUserAddedToProject();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		User userVal = input.getUser();
		result.setUserId(userVal == null ? -1 : userVal.getOid());
		Project projectVal = input.getProject();
		result.setProjectId(projectVal == null ? -1 : projectVal.getOid());
		return result;
	}

	public UserAddedToProject convertFromSObject(SUserAddedToProject input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		UserAddedToProject result = convertFromSObject(input, (UserAddedToProject)session.create(LogPackage.eINSTANCE.getUserAddedToProject()), session);
		
		
		return result;
	}

	public UserAddedToProject convertFromSObject(SUserAddedToProject input) throws BimserverDatabaseException {
		UserAddedToProject result = convertFromSObject(input, LogFactory.eINSTANCE.createUserAddedToProject(), null);
		return result;
	}

	public UserAddedToProject convertFromSObject(SUserAddedToProject input, UserAddedToProject result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), OldQuery.getDefault()));
		result.setUser((User)session.get(StorePackage.eINSTANCE.getUser(), input.getUserId(), OldQuery.getDefault()));
		result.setProject((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getProjectId(), OldQuery.getDefault()));
		return result;
	}

	public Set<SNewObjectIDMUploaded> convertToSSetNewObjectIDMUploaded(Collection<NewObjectIDMUploaded> input) {
		Set<SNewObjectIDMUploaded> result = new HashSet<SNewObjectIDMUploaded>();
		for (NewObjectIDMUploaded o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<NewObjectIDMUploaded> convertFromSSetNewObjectIDMUploaded(Collection<SNewObjectIDMUploaded> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<NewObjectIDMUploaded> result = new HashSet<NewObjectIDMUploaded>();
		for (SNewObjectIDMUploaded o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SNewObjectIDMUploaded> convertToSListNewObjectIDMUploaded(Collection<NewObjectIDMUploaded> input) {
		List<SNewObjectIDMUploaded> result = new ArrayList<SNewObjectIDMUploaded>();
		for (NewObjectIDMUploaded o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<NewObjectIDMUploaded> convertFromSListNewObjectIDMUploaded(Collection<SNewObjectIDMUploaded> input, DatabaseSession session) throws BimserverDatabaseException {
		List<NewObjectIDMUploaded> result = new ArrayList<NewObjectIDMUploaded>();
		for (SNewObjectIDMUploaded o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SNewObjectIDMUploaded convertToSObject(NewObjectIDMUploaded input) {
		if (input == null) {
			return null;
		}
		
		SNewObjectIDMUploaded result = new SNewObjectIDMUploaded();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		return result;
	}

	public NewObjectIDMUploaded convertFromSObject(SNewObjectIDMUploaded input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		NewObjectIDMUploaded result = convertFromSObject(input, (NewObjectIDMUploaded)session.create(LogPackage.eINSTANCE.getNewObjectIDMUploaded()), session);
		
		
		return result;
	}

	public NewObjectIDMUploaded convertFromSObject(SNewObjectIDMUploaded input) throws BimserverDatabaseException {
		NewObjectIDMUploaded result = convertFromSObject(input, LogFactory.eINSTANCE.createNewObjectIDMUploaded(), null);
		return result;
	}

	public NewObjectIDMUploaded convertFromSObject(SNewObjectIDMUploaded input, NewObjectIDMUploaded result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), OldQuery.getDefault()));
		return result;
	}

	public Set<SDownload> convertToSSetDownload(Collection<Download> input) {
		Set<SDownload> result = new HashSet<SDownload>();
		for (Download o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<Download> convertFromSSetDownload(Collection<SDownload> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<Download> result = new HashSet<Download>();
		for (SDownload o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SDownload> convertToSListDownload(Collection<Download> input) {
		List<SDownload> result = new ArrayList<SDownload>();
		for (Download o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<Download> convertFromSListDownload(Collection<SDownload> input, DatabaseSession session) throws BimserverDatabaseException {
		List<Download> result = new ArrayList<Download>();
		for (SDownload o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SDownload convertToSObject(Download input) {
		if (input == null) {
			return null;
		}
		
		SDownload result = new SDownload();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		return result;
	}

	public Download convertFromSObject(SDownload input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		Download result = convertFromSObject(input, (Download)session.create(LogPackage.eINSTANCE.getDownload()), session);
		
		
		return result;
	}

	public Download convertFromSObject(SDownload input) throws BimserverDatabaseException {
		Download result = convertFromSObject(input, LogFactory.eINSTANCE.createDownload(), null);
		return result;
	}

	public Download convertFromSObject(SDownload input, Download result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), OldQuery.getDefault()));
		return result;
	}

	public Set<SUserRemovedFromProject> convertToSSetUserRemovedFromProject(Collection<UserRemovedFromProject> input) {
		Set<SUserRemovedFromProject> result = new HashSet<SUserRemovedFromProject>();
		for (UserRemovedFromProject o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<UserRemovedFromProject> convertFromSSetUserRemovedFromProject(Collection<SUserRemovedFromProject> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<UserRemovedFromProject> result = new HashSet<UserRemovedFromProject>();
		for (SUserRemovedFromProject o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SUserRemovedFromProject> convertToSListUserRemovedFromProject(Collection<UserRemovedFromProject> input) {
		List<SUserRemovedFromProject> result = new ArrayList<SUserRemovedFromProject>();
		for (UserRemovedFromProject o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<UserRemovedFromProject> convertFromSListUserRemovedFromProject(Collection<SUserRemovedFromProject> input, DatabaseSession session) throws BimserverDatabaseException {
		List<UserRemovedFromProject> result = new ArrayList<UserRemovedFromProject>();
		for (SUserRemovedFromProject o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SUserRemovedFromProject convertToSObject(UserRemovedFromProject input) {
		if (input == null) {
			return null;
		}
		
		SUserRemovedFromProject result = new SUserRemovedFromProject();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		User userVal = input.getUser();
		result.setUserId(userVal == null ? -1 : userVal.getOid());
		Project projectVal = input.getProject();
		result.setProjectId(projectVal == null ? -1 : projectVal.getOid());
		return result;
	}

	public UserRemovedFromProject convertFromSObject(SUserRemovedFromProject input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		UserRemovedFromProject result = convertFromSObject(input, (UserRemovedFromProject)session.create(LogPackage.eINSTANCE.getUserRemovedFromProject()), session);
		
		
		return result;
	}

	public UserRemovedFromProject convertFromSObject(SUserRemovedFromProject input) throws BimserverDatabaseException {
		UserRemovedFromProject result = convertFromSObject(input, LogFactory.eINSTANCE.createUserRemovedFromProject(), null);
		return result;
	}

	public UserRemovedFromProject convertFromSObject(SUserRemovedFromProject input, UserRemovedFromProject result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), OldQuery.getDefault()));
		result.setUser((User)session.get(StorePackage.eINSTANCE.getUser(), input.getUserId(), OldQuery.getDefault()));
		result.setProject((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getProjectId(), OldQuery.getDefault()));
		return result;
	}

	public Set<SProjectDeleted> convertToSSetProjectDeleted(Collection<ProjectDeleted> input) {
		Set<SProjectDeleted> result = new HashSet<SProjectDeleted>();
		for (ProjectDeleted o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ProjectDeleted> convertFromSSetProjectDeleted(Collection<SProjectDeleted> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ProjectDeleted> result = new HashSet<ProjectDeleted>();
		for (SProjectDeleted o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SProjectDeleted> convertToSListProjectDeleted(Collection<ProjectDeleted> input) {
		List<SProjectDeleted> result = new ArrayList<SProjectDeleted>();
		for (ProjectDeleted o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ProjectDeleted> convertFromSListProjectDeleted(Collection<SProjectDeleted> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ProjectDeleted> result = new ArrayList<ProjectDeleted>();
		for (SProjectDeleted o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SProjectDeleted convertToSObject(ProjectDeleted input) {
		if (input == null) {
			return null;
		}
		
		SProjectDeleted result = new SProjectDeleted();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		Project projectVal = input.getProject();
		result.setProjectId(projectVal == null ? -1 : projectVal.getOid());
		return result;
	}

	public ProjectDeleted convertFromSObject(SProjectDeleted input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		ProjectDeleted result = convertFromSObject(input, (ProjectDeleted)session.create(LogPackage.eINSTANCE.getProjectDeleted()), session);
		
		
		return result;
	}

	public ProjectDeleted convertFromSObject(SProjectDeleted input) throws BimserverDatabaseException {
		ProjectDeleted result = convertFromSObject(input, LogFactory.eINSTANCE.createProjectDeleted(), null);
		return result;
	}

	public ProjectDeleted convertFromSObject(SProjectDeleted input, ProjectDeleted result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), OldQuery.getDefault()));
		result.setProject((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getProjectId(), OldQuery.getDefault()));
		return result;
	}

	public Set<SUserDeleted> convertToSSetUserDeleted(Collection<UserDeleted> input) {
		Set<SUserDeleted> result = new HashSet<SUserDeleted>();
		for (UserDeleted o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<UserDeleted> convertFromSSetUserDeleted(Collection<SUserDeleted> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<UserDeleted> result = new HashSet<UserDeleted>();
		for (SUserDeleted o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SUserDeleted> convertToSListUserDeleted(Collection<UserDeleted> input) {
		List<SUserDeleted> result = new ArrayList<SUserDeleted>();
		for (UserDeleted o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<UserDeleted> convertFromSListUserDeleted(Collection<SUserDeleted> input, DatabaseSession session) throws BimserverDatabaseException {
		List<UserDeleted> result = new ArrayList<UserDeleted>();
		for (SUserDeleted o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SUserDeleted convertToSObject(UserDeleted input) {
		if (input == null) {
			return null;
		}
		
		SUserDeleted result = new SUserDeleted();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		User userVal = input.getUser();
		result.setUserId(userVal == null ? -1 : userVal.getOid());
		return result;
	}

	public UserDeleted convertFromSObject(SUserDeleted input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		UserDeleted result = convertFromSObject(input, (UserDeleted)session.create(LogPackage.eINSTANCE.getUserDeleted()), session);
		
		
		return result;
	}

	public UserDeleted convertFromSObject(SUserDeleted input) throws BimserverDatabaseException {
		UserDeleted result = convertFromSObject(input, LogFactory.eINSTANCE.createUserDeleted(), null);
		return result;
	}

	public UserDeleted convertFromSObject(SUserDeleted input, UserDeleted result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), OldQuery.getDefault()));
		result.setUser((User)session.get(StorePackage.eINSTANCE.getUser(), input.getUserId(), OldQuery.getDefault()));
		return result;
	}

	public Set<SPasswordReset> convertToSSetPasswordReset(Collection<PasswordReset> input) {
		Set<SPasswordReset> result = new HashSet<SPasswordReset>();
		for (PasswordReset o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<PasswordReset> convertFromSSetPasswordReset(Collection<SPasswordReset> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<PasswordReset> result = new HashSet<PasswordReset>();
		for (SPasswordReset o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SPasswordReset> convertToSListPasswordReset(Collection<PasswordReset> input) {
		List<SPasswordReset> result = new ArrayList<SPasswordReset>();
		for (PasswordReset o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<PasswordReset> convertFromSListPasswordReset(Collection<SPasswordReset> input, DatabaseSession session) throws BimserverDatabaseException {
		List<PasswordReset> result = new ArrayList<PasswordReset>();
		for (SPasswordReset o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SPasswordReset convertToSObject(PasswordReset input) {
		if (input == null) {
			return null;
		}
		
		SPasswordReset result = new SPasswordReset();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		User userVal = input.getUser();
		result.setUserId(userVal == null ? -1 : userVal.getOid());
		return result;
	}

	public PasswordReset convertFromSObject(SPasswordReset input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		PasswordReset result = convertFromSObject(input, (PasswordReset)session.create(LogPackage.eINSTANCE.getPasswordReset()), session);
		
		
		return result;
	}

	public PasswordReset convertFromSObject(SPasswordReset input) throws BimserverDatabaseException {
		PasswordReset result = convertFromSObject(input, LogFactory.eINSTANCE.createPasswordReset(), null);
		return result;
	}

	public PasswordReset convertFromSObject(SPasswordReset input, PasswordReset result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), OldQuery.getDefault()));
		result.setUser((User)session.get(StorePackage.eINSTANCE.getUser(), input.getUserId(), OldQuery.getDefault()));
		return result;
	}

	public Set<SDatabaseCreated> convertToSSetDatabaseCreated(Collection<DatabaseCreated> input) {
		Set<SDatabaseCreated> result = new HashSet<SDatabaseCreated>();
		for (DatabaseCreated o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<DatabaseCreated> convertFromSSetDatabaseCreated(Collection<SDatabaseCreated> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<DatabaseCreated> result = new HashSet<DatabaseCreated>();
		for (SDatabaseCreated o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SDatabaseCreated> convertToSListDatabaseCreated(Collection<DatabaseCreated> input) {
		List<SDatabaseCreated> result = new ArrayList<SDatabaseCreated>();
		for (DatabaseCreated o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<DatabaseCreated> convertFromSListDatabaseCreated(Collection<SDatabaseCreated> input, DatabaseSession session) throws BimserverDatabaseException {
		List<DatabaseCreated> result = new ArrayList<DatabaseCreated>();
		for (SDatabaseCreated o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SDatabaseCreated convertToSObject(DatabaseCreated input) {
		if (input == null) {
			return null;
		}
		
		SDatabaseCreated result = new SDatabaseCreated();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setPath(input.getPath());
		result.setVersion(input.getVersion());
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		return result;
	}

	public DatabaseCreated convertFromSObject(SDatabaseCreated input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		DatabaseCreated result = convertFromSObject(input, (DatabaseCreated)session.create(LogPackage.eINSTANCE.getDatabaseCreated()), session);
		
		
		return result;
	}

	public DatabaseCreated convertFromSObject(SDatabaseCreated input) throws BimserverDatabaseException {
		DatabaseCreated result = convertFromSObject(input, LogFactory.eINSTANCE.createDatabaseCreated(), null);
		return result;
	}

	public DatabaseCreated convertFromSObject(SDatabaseCreated input, DatabaseCreated result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setPath(input.getPath());
		result.setVersion(input.getVersion());
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), OldQuery.getDefault()));
		return result;
	}

	public Set<SServerStarted> convertToSSetServerStarted(Collection<ServerStarted> input) {
		Set<SServerStarted> result = new HashSet<SServerStarted>();
		for (ServerStarted o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ServerStarted> convertFromSSetServerStarted(Collection<SServerStarted> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ServerStarted> result = new HashSet<ServerStarted>();
		for (SServerStarted o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SServerStarted> convertToSListServerStarted(Collection<ServerStarted> input) {
		List<SServerStarted> result = new ArrayList<SServerStarted>();
		for (ServerStarted o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ServerStarted> convertFromSListServerStarted(Collection<SServerStarted> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ServerStarted> result = new ArrayList<ServerStarted>();
		for (SServerStarted o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SServerStarted convertToSObject(ServerStarted input) {
		if (input == null) {
			return null;
		}
		
		SServerStarted result = new SServerStarted();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		return result;
	}

	public ServerStarted convertFromSObject(SServerStarted input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		ServerStarted result = convertFromSObject(input, (ServerStarted)session.create(LogPackage.eINSTANCE.getServerStarted()), session);
		
		
		return result;
	}

	public ServerStarted convertFromSObject(SServerStarted input) throws BimserverDatabaseException {
		ServerStarted result = convertFromSObject(input, LogFactory.eINSTANCE.createServerStarted(), null);
		return result;
	}

	public ServerStarted convertFromSObject(SServerStarted input, ServerStarted result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), OldQuery.getDefault()));
		return result;
	}

	public Set<SProjectUpdated> convertToSSetProjectUpdated(Collection<ProjectUpdated> input) {
		Set<SProjectUpdated> result = new HashSet<SProjectUpdated>();
		for (ProjectUpdated o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ProjectUpdated> convertFromSSetProjectUpdated(Collection<SProjectUpdated> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ProjectUpdated> result = new HashSet<ProjectUpdated>();
		for (SProjectUpdated o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SProjectUpdated> convertToSListProjectUpdated(Collection<ProjectUpdated> input) {
		List<SProjectUpdated> result = new ArrayList<SProjectUpdated>();
		for (ProjectUpdated o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ProjectUpdated> convertFromSListProjectUpdated(Collection<SProjectUpdated> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ProjectUpdated> result = new ArrayList<ProjectUpdated>();
		for (SProjectUpdated o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SProjectUpdated convertToSObject(ProjectUpdated input) {
		if (input == null) {
			return null;
		}
		
		SProjectUpdated result = new SProjectUpdated();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		Project projectVal = input.getProject();
		result.setProjectId(projectVal == null ? -1 : projectVal.getOid());
		return result;
	}

	public ProjectUpdated convertFromSObject(SProjectUpdated input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		ProjectUpdated result = convertFromSObject(input, (ProjectUpdated)session.create(LogPackage.eINSTANCE.getProjectUpdated()), session);
		
		
		return result;
	}

	public ProjectUpdated convertFromSObject(SProjectUpdated input) throws BimserverDatabaseException {
		ProjectUpdated result = convertFromSObject(input, LogFactory.eINSTANCE.createProjectUpdated(), null);
		return result;
	}

	public ProjectUpdated convertFromSObject(SProjectUpdated input, ProjectUpdated result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), OldQuery.getDefault()));
		result.setProject((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getProjectId(), OldQuery.getDefault()));
		return result;
	}

	public Set<SUserUndeleted> convertToSSetUserUndeleted(Collection<UserUndeleted> input) {
		Set<SUserUndeleted> result = new HashSet<SUserUndeleted>();
		for (UserUndeleted o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<UserUndeleted> convertFromSSetUserUndeleted(Collection<SUserUndeleted> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<UserUndeleted> result = new HashSet<UserUndeleted>();
		for (SUserUndeleted o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SUserUndeleted> convertToSListUserUndeleted(Collection<UserUndeleted> input) {
		List<SUserUndeleted> result = new ArrayList<SUserUndeleted>();
		for (UserUndeleted o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<UserUndeleted> convertFromSListUserUndeleted(Collection<SUserUndeleted> input, DatabaseSession session) throws BimserverDatabaseException {
		List<UserUndeleted> result = new ArrayList<UserUndeleted>();
		for (SUserUndeleted o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SUserUndeleted convertToSObject(UserUndeleted input) {
		if (input == null) {
			return null;
		}
		
		SUserUndeleted result = new SUserUndeleted();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		User userVal = input.getUser();
		result.setUserId(userVal == null ? -1 : userVal.getOid());
		return result;
	}

	public UserUndeleted convertFromSObject(SUserUndeleted input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		UserUndeleted result = convertFromSObject(input, (UserUndeleted)session.create(LogPackage.eINSTANCE.getUserUndeleted()), session);
		
		
		return result;
	}

	public UserUndeleted convertFromSObject(SUserUndeleted input) throws BimserverDatabaseException {
		UserUndeleted result = convertFromSObject(input, LogFactory.eINSTANCE.createUserUndeleted(), null);
		return result;
	}

	public UserUndeleted convertFromSObject(SUserUndeleted input, UserUndeleted result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), OldQuery.getDefault()));
		result.setUser((User)session.get(StorePackage.eINSTANCE.getUser(), input.getUserId(), OldQuery.getDefault()));
		return result;
	}

	public Set<SProjectUndeleted> convertToSSetProjectUndeleted(Collection<ProjectUndeleted> input) {
		Set<SProjectUndeleted> result = new HashSet<SProjectUndeleted>();
		for (ProjectUndeleted o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ProjectUndeleted> convertFromSSetProjectUndeleted(Collection<SProjectUndeleted> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ProjectUndeleted> result = new HashSet<ProjectUndeleted>();
		for (SProjectUndeleted o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SProjectUndeleted> convertToSListProjectUndeleted(Collection<ProjectUndeleted> input) {
		List<SProjectUndeleted> result = new ArrayList<SProjectUndeleted>();
		for (ProjectUndeleted o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ProjectUndeleted> convertFromSListProjectUndeleted(Collection<SProjectUndeleted> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ProjectUndeleted> result = new ArrayList<ProjectUndeleted>();
		for (SProjectUndeleted o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SProjectUndeleted convertToSObject(ProjectUndeleted input) {
		if (input == null) {
			return null;
		}
		
		SProjectUndeleted result = new SProjectUndeleted();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		Project projectVal = input.getProject();
		result.setProjectId(projectVal == null ? -1 : projectVal.getOid());
		return result;
	}

	public ProjectUndeleted convertFromSObject(SProjectUndeleted input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		ProjectUndeleted result = convertFromSObject(input, (ProjectUndeleted)session.create(LogPackage.eINSTANCE.getProjectUndeleted()), session);
		
		
		return result;
	}

	public ProjectUndeleted convertFromSObject(SProjectUndeleted input) throws BimserverDatabaseException {
		ProjectUndeleted result = convertFromSObject(input, LogFactory.eINSTANCE.createProjectUndeleted(), null);
		return result;
	}

	public ProjectUndeleted convertFromSObject(SProjectUndeleted input, ProjectUndeleted result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), OldQuery.getDefault()));
		result.setProject((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getProjectId(), OldQuery.getDefault()));
		return result;
	}

	public Set<SRevisionUpdated> convertToSSetRevisionUpdated(Collection<RevisionUpdated> input) {
		Set<SRevisionUpdated> result = new HashSet<SRevisionUpdated>();
		for (RevisionUpdated o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<RevisionUpdated> convertFromSSetRevisionUpdated(Collection<SRevisionUpdated> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<RevisionUpdated> result = new HashSet<RevisionUpdated>();
		for (SRevisionUpdated o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SRevisionUpdated> convertToSListRevisionUpdated(Collection<RevisionUpdated> input) {
		List<SRevisionUpdated> result = new ArrayList<SRevisionUpdated>();
		for (RevisionUpdated o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<RevisionUpdated> convertFromSListRevisionUpdated(Collection<SRevisionUpdated> input, DatabaseSession session) throws BimserverDatabaseException {
		List<RevisionUpdated> result = new ArrayList<RevisionUpdated>();
		for (SRevisionUpdated o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SRevisionUpdated convertToSObject(RevisionUpdated input) {
		if (input == null) {
			return null;
		}
		
		SRevisionUpdated result = new SRevisionUpdated();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		Revision revisionVal = input.getRevision();
		result.setRevisionId(revisionVal == null ? -1 : revisionVal.getOid());
		return result;
	}

	public RevisionUpdated convertFromSObject(SRevisionUpdated input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		RevisionUpdated result = convertFromSObject(input, (RevisionUpdated)session.create(LogPackage.eINSTANCE.getRevisionUpdated()), session);
		
		
		return result;
	}

	public RevisionUpdated convertFromSObject(SRevisionUpdated input) throws BimserverDatabaseException {
		RevisionUpdated result = convertFromSObject(input, LogFactory.eINSTANCE.createRevisionUpdated(), null);
		return result;
	}

	public RevisionUpdated convertFromSObject(SRevisionUpdated input, RevisionUpdated result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), OldQuery.getDefault()));
		result.setRevision((Revision)session.get(StorePackage.eINSTANCE.getRevision(), input.getRevisionId(), OldQuery.getDefault()));
		return result;
	}

	public Set<SGeoTagUpdated> convertToSSetGeoTagUpdated(Collection<GeoTagUpdated> input) {
		Set<SGeoTagUpdated> result = new HashSet<SGeoTagUpdated>();
		for (GeoTagUpdated o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<GeoTagUpdated> convertFromSSetGeoTagUpdated(Collection<SGeoTagUpdated> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<GeoTagUpdated> result = new HashSet<GeoTagUpdated>();
		for (SGeoTagUpdated o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SGeoTagUpdated> convertToSListGeoTagUpdated(Collection<GeoTagUpdated> input) {
		List<SGeoTagUpdated> result = new ArrayList<SGeoTagUpdated>();
		for (GeoTagUpdated o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<GeoTagUpdated> convertFromSListGeoTagUpdated(Collection<SGeoTagUpdated> input, DatabaseSession session) throws BimserverDatabaseException {
		List<GeoTagUpdated> result = new ArrayList<GeoTagUpdated>();
		for (SGeoTagUpdated o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SGeoTagUpdated convertToSObject(GeoTagUpdated input) {
		if (input == null) {
			return null;
		}
		
		SGeoTagUpdated result = new SGeoTagUpdated();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		GeoTag geoTagVal = input.getGeoTag();
		result.setGeoTagId(geoTagVal == null ? -1 : geoTagVal.getOid());
		return result;
	}

	public GeoTagUpdated convertFromSObject(SGeoTagUpdated input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		GeoTagUpdated result = convertFromSObject(input, (GeoTagUpdated)session.create(LogPackage.eINSTANCE.getGeoTagUpdated()), session);
		
		
		return result;
	}

	public GeoTagUpdated convertFromSObject(SGeoTagUpdated input) throws BimserverDatabaseException {
		GeoTagUpdated result = convertFromSObject(input, LogFactory.eINSTANCE.createGeoTagUpdated(), null);
		return result;
	}

	public GeoTagUpdated convertFromSObject(SGeoTagUpdated input, GeoTagUpdated result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), OldQuery.getDefault()));
		result.setGeoTag((GeoTag)session.get(StorePackage.eINSTANCE.getGeoTag(), input.getGeoTagId(), OldQuery.getDefault()));
		return result;
	}

	public Set<SPasswordChanged> convertToSSetPasswordChanged(Collection<PasswordChanged> input) {
		Set<SPasswordChanged> result = new HashSet<SPasswordChanged>();
		for (PasswordChanged o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<PasswordChanged> convertFromSSetPasswordChanged(Collection<SPasswordChanged> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<PasswordChanged> result = new HashSet<PasswordChanged>();
		for (SPasswordChanged o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SPasswordChanged> convertToSListPasswordChanged(Collection<PasswordChanged> input) {
		List<SPasswordChanged> result = new ArrayList<SPasswordChanged>();
		for (PasswordChanged o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<PasswordChanged> convertFromSListPasswordChanged(Collection<SPasswordChanged> input, DatabaseSession session) throws BimserverDatabaseException {
		List<PasswordChanged> result = new ArrayList<PasswordChanged>();
		for (SPasswordChanged o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SPasswordChanged convertToSObject(PasswordChanged input) {
		if (input == null) {
			return null;
		}
		
		SPasswordChanged result = new SPasswordChanged();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		User userVal = input.getUser();
		result.setUserId(userVal == null ? -1 : userVal.getOid());
		return result;
	}

	public PasswordChanged convertFromSObject(SPasswordChanged input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		PasswordChanged result = convertFromSObject(input, (PasswordChanged)session.create(LogPackage.eINSTANCE.getPasswordChanged()), session);
		
		
		return result;
	}

	public PasswordChanged convertFromSObject(SPasswordChanged input) throws BimserverDatabaseException {
		PasswordChanged result = convertFromSObject(input, LogFactory.eINSTANCE.createPasswordChanged(), null);
		return result;
	}

	public PasswordChanged convertFromSObject(SPasswordChanged input, PasswordChanged result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), OldQuery.getDefault()));
		result.setUser((User)session.get(StorePackage.eINSTANCE.getUser(), input.getUserId(), OldQuery.getDefault()));
		return result;
	}

	public Set<SUserChanged> convertToSSetUserChanged(Collection<UserChanged> input) {
		Set<SUserChanged> result = new HashSet<SUserChanged>();
		for (UserChanged o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<UserChanged> convertFromSSetUserChanged(Collection<SUserChanged> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<UserChanged> result = new HashSet<UserChanged>();
		for (SUserChanged o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SUserChanged> convertToSListUserChanged(Collection<UserChanged> input) {
		List<SUserChanged> result = new ArrayList<SUserChanged>();
		for (UserChanged o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<UserChanged> convertFromSListUserChanged(Collection<SUserChanged> input, DatabaseSession session) throws BimserverDatabaseException {
		List<UserChanged> result = new ArrayList<UserChanged>();
		for (SUserChanged o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SUserChanged convertToSObject(UserChanged input) {
		if (input == null) {
			return null;
		}
		
		SUserChanged result = new SUserChanged();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		User userVal = input.getUser();
		result.setUserId(userVal == null ? -1 : userVal.getOid());
		return result;
	}

	public UserChanged convertFromSObject(SUserChanged input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		UserChanged result = convertFromSObject(input, (UserChanged)session.create(LogPackage.eINSTANCE.getUserChanged()), session);
		
		
		return result;
	}

	public UserChanged convertFromSObject(SUserChanged input) throws BimserverDatabaseException {
		UserChanged result = convertFromSObject(input, LogFactory.eINSTANCE.createUserChanged(), null);
		return result;
	}

	public UserChanged convertFromSObject(SUserChanged input, UserChanged result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), OldQuery.getDefault()));
		result.setUser((User)session.get(StorePackage.eINSTANCE.getUser(), input.getUserId(), OldQuery.getDefault()));
		return result;
	}

	public Set<SExtendedDataAddedToRevision> convertToSSetExtendedDataAddedToRevision(Collection<ExtendedDataAddedToRevision> input) {
		Set<SExtendedDataAddedToRevision> result = new HashSet<SExtendedDataAddedToRevision>();
		for (ExtendedDataAddedToRevision o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ExtendedDataAddedToRevision> convertFromSSetExtendedDataAddedToRevision(Collection<SExtendedDataAddedToRevision> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ExtendedDataAddedToRevision> result = new HashSet<ExtendedDataAddedToRevision>();
		for (SExtendedDataAddedToRevision o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SExtendedDataAddedToRevision> convertToSListExtendedDataAddedToRevision(Collection<ExtendedDataAddedToRevision> input) {
		List<SExtendedDataAddedToRevision> result = new ArrayList<SExtendedDataAddedToRevision>();
		for (ExtendedDataAddedToRevision o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ExtendedDataAddedToRevision> convertFromSListExtendedDataAddedToRevision(Collection<SExtendedDataAddedToRevision> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ExtendedDataAddedToRevision> result = new ArrayList<ExtendedDataAddedToRevision>();
		for (SExtendedDataAddedToRevision o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SExtendedDataAddedToRevision convertToSObject(ExtendedDataAddedToRevision input) {
		if (input == null) {
			return null;
		}
		
		SExtendedDataAddedToRevision result = new SExtendedDataAddedToRevision();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		Revision revisionVal = input.getRevision();
		result.setRevisionId(revisionVal == null ? -1 : revisionVal.getOid());
		ExtendedData extendedDataVal = input.getExtendedData();
		result.setExtendedDataId(extendedDataVal == null ? -1 : extendedDataVal.getOid());
		return result;
	}

	public ExtendedDataAddedToRevision convertFromSObject(SExtendedDataAddedToRevision input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		ExtendedDataAddedToRevision result = convertFromSObject(input, (ExtendedDataAddedToRevision)session.create(LogPackage.eINSTANCE.getExtendedDataAddedToRevision()), session);
		
		
		return result;
	}

	public ExtendedDataAddedToRevision convertFromSObject(SExtendedDataAddedToRevision input) throws BimserverDatabaseException {
		ExtendedDataAddedToRevision result = convertFromSObject(input, LogFactory.eINSTANCE.createExtendedDataAddedToRevision(), null);
		return result;
	}

	public ExtendedDataAddedToRevision convertFromSObject(SExtendedDataAddedToRevision input, ExtendedDataAddedToRevision result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), OldQuery.getDefault()));
		result.setRevision((Revision)session.get(StorePackage.eINSTANCE.getRevision(), input.getRevisionId(), OldQuery.getDefault()));
		result.setExtendedData((ExtendedData)session.get(StorePackage.eINSTANCE.getExtendedData(), input.getExtendedDataId(), OldQuery.getDefault()));
		return result;
	}

	public Set<SExtendedDataAddedToProject> convertToSSetExtendedDataAddedToProject(Collection<ExtendedDataAddedToProject> input) {
		Set<SExtendedDataAddedToProject> result = new HashSet<SExtendedDataAddedToProject>();
		for (ExtendedDataAddedToProject o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ExtendedDataAddedToProject> convertFromSSetExtendedDataAddedToProject(Collection<SExtendedDataAddedToProject> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ExtendedDataAddedToProject> result = new HashSet<ExtendedDataAddedToProject>();
		for (SExtendedDataAddedToProject o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SExtendedDataAddedToProject> convertToSListExtendedDataAddedToProject(Collection<ExtendedDataAddedToProject> input) {
		List<SExtendedDataAddedToProject> result = new ArrayList<SExtendedDataAddedToProject>();
		for (ExtendedDataAddedToProject o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ExtendedDataAddedToProject> convertFromSListExtendedDataAddedToProject(Collection<SExtendedDataAddedToProject> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ExtendedDataAddedToProject> result = new ArrayList<ExtendedDataAddedToProject>();
		for (SExtendedDataAddedToProject o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SExtendedDataAddedToProject convertToSObject(ExtendedDataAddedToProject input) {
		if (input == null) {
			return null;
		}
		
		SExtendedDataAddedToProject result = new SExtendedDataAddedToProject();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		Project projectVal = input.getProject();
		result.setProjectId(projectVal == null ? -1 : projectVal.getOid());
		ExtendedData extendedDataVal = input.getExtendedData();
		result.setExtendedDataId(extendedDataVal == null ? -1 : extendedDataVal.getOid());
		return result;
	}

	public ExtendedDataAddedToProject convertFromSObject(SExtendedDataAddedToProject input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		ExtendedDataAddedToProject result = convertFromSObject(input, (ExtendedDataAddedToProject)session.create(LogPackage.eINSTANCE.getExtendedDataAddedToProject()), session);
		
		
		return result;
	}

	public ExtendedDataAddedToProject convertFromSObject(SExtendedDataAddedToProject input) throws BimserverDatabaseException {
		ExtendedDataAddedToProject result = convertFromSObject(input, LogFactory.eINSTANCE.createExtendedDataAddedToProject(), null);
		return result;
	}

	public ExtendedDataAddedToProject convertFromSObject(SExtendedDataAddedToProject input, ExtendedDataAddedToProject result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), OldQuery.getDefault()));
		result.setProject((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getProjectId(), OldQuery.getDefault()));
		result.setExtendedData((ExtendedData)session.get(StorePackage.eINSTANCE.getExtendedData(), input.getExtendedDataId(), OldQuery.getDefault()));
		return result;
	}

	public Set<SRemoteServiceCalled> convertToSSetRemoteServiceCalled(Collection<RemoteServiceCalled> input) {
		Set<SRemoteServiceCalled> result = new HashSet<SRemoteServiceCalled>();
		for (RemoteServiceCalled o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<RemoteServiceCalled> convertFromSSetRemoteServiceCalled(Collection<SRemoteServiceCalled> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<RemoteServiceCalled> result = new HashSet<RemoteServiceCalled>();
		for (SRemoteServiceCalled o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SRemoteServiceCalled> convertToSListRemoteServiceCalled(Collection<RemoteServiceCalled> input) {
		List<SRemoteServiceCalled> result = new ArrayList<SRemoteServiceCalled>();
		for (RemoteServiceCalled o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<RemoteServiceCalled> convertFromSListRemoteServiceCalled(Collection<SRemoteServiceCalled> input, DatabaseSession session) throws BimserverDatabaseException {
		List<RemoteServiceCalled> result = new ArrayList<RemoteServiceCalled>();
		for (SRemoteServiceCalled o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SRemoteServiceCalled convertToSObject(RemoteServiceCalled input) {
		if (input == null) {
			return null;
		}
		
		SRemoteServiceCalled result = new SRemoteServiceCalled();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setState(SNotifictionResultEnum.values()[input.getState().ordinal()]);
		result.setPercentage(input.getPercentage());
		result.getInfos().addAll(input.getInfos());
		result.getWarnings().addAll(input.getWarnings());
		result.getErrors().addAll(input.getErrors());
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		Service serviceVal = input.getService();
		result.setServiceId(serviceVal == null ? -1 : serviceVal.getOid());
		return result;
	}

	public RemoteServiceCalled convertFromSObject(SRemoteServiceCalled input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		RemoteServiceCalled result = convertFromSObject(input, (RemoteServiceCalled)session.create(LogPackage.eINSTANCE.getRemoteServiceCalled()), session);
		
		
		return result;
	}

	public RemoteServiceCalled convertFromSObject(SRemoteServiceCalled input) throws BimserverDatabaseException {
		RemoteServiceCalled result = convertFromSObject(input, LogFactory.eINSTANCE.createRemoteServiceCalled(), null);
		return result;
	}

	public RemoteServiceCalled convertFromSObject(SRemoteServiceCalled input, RemoteServiceCalled result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setState(NotifictionResultEnum.values()[input.getState().ordinal()]);
		result.setPercentage(input.getPercentage());
		result.getInfos().addAll(input.getInfos());
		result.getWarnings().addAll(input.getWarnings());
		result.getErrors().addAll(input.getErrors());
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), OldQuery.getDefault()));
		result.setService((Service)session.get(StorePackage.eINSTANCE.getService(), input.getServiceId(), OldQuery.getDefault()));
		return result;
	}
		public SUserType convertToSObject(UserType input) {
			return SUserType.values()[input.ordinal()];
		}
		
		public UserType convertFromSObject(SUserType input) {
			return UserType.values()[input.ordinal()];
		}
		public SSIPrefix convertToSObject(SIPrefix input) {
			return SSIPrefix.values()[input.ordinal()];
		}
		
		public SIPrefix convertFromSObject(SSIPrefix input) {
			return SIPrefix.values()[input.ordinal()];
		}
		public SObjectState convertToSObject(ObjectState input) {
			return SObjectState.values()[input.ordinal()];
		}
		
		public ObjectState convertFromSObject(SObjectState input) {
			return ObjectState.values()[input.ordinal()];
		}

	public Set<SProject> convertToSSetProject(Collection<Project> input) {
		Set<SProject> result = new HashSet<SProject>();
		for (Project o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<Project> convertFromSSetProject(Collection<SProject> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<Project> result = new HashSet<Project>();
		for (SProject o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SProject> convertToSListProject(Collection<Project> input) {
		List<SProject> result = new ArrayList<SProject>();
		for (Project o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<Project> convertFromSListProject(Collection<SProject> input, DatabaseSession session) throws BimserverDatabaseException {
		List<Project> result = new ArrayList<Project>();
		for (SProject o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SProject convertToSObject(Project input) {
		if (input == null) {
			return null;
		}
		
		SProject result = new SProject();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setId(input.getId());
		result.setName(input.getName());
		result.setState(SObjectState.values()[input.getState().ordinal()]);
		result.setCreatedDate(input.getCreatedDate());
		result.setDescription(input.getDescription());
		result.setExportLengthMeasurePrefix(SSIPrefix.values()[input.getExportLengthMeasurePrefix().ordinal()]);
		result.setSchema(input.getSchema());
		result.setSendEmailOnNewRevision(input.isSendEmailOnNewRevision());
		result.setCheckinInProgress(input.getCheckinInProgress());
		List<Long> listhasAuthorizedUsers = new ArrayList<Long>();
		for (User v : input.getHasAuthorizedUsers()) {
			listhasAuthorizedUsers.add(v.getOid());
		}
		result.setHasAuthorizedUsers(listhasAuthorizedUsers);
		List<Long> listconcreteRevisions = new ArrayList<Long>();
		for (ConcreteRevision v : input.getConcreteRevisions()) {
			listconcreteRevisions.add(v.getOid());
		}
		result.setConcreteRevisions(listconcreteRevisions);
		List<Long> listrevisions = new ArrayList<Long>();
		for (Revision v : input.getRevisions()) {
			listrevisions.add(v.getOid());
		}
		result.setRevisions(listrevisions);
		ConcreteRevision lastConcreteRevisionVal = input.getLastConcreteRevision();
		result.setLastConcreteRevisionId(lastConcreteRevisionVal == null ? -1 : lastConcreteRevisionVal.getOid());
		Revision lastRevisionVal = input.getLastRevision();
		result.setLastRevisionId(lastRevisionVal == null ? -1 : lastRevisionVal.getOid());
		List<Long> listcheckouts = new ArrayList<Long>();
		for (Checkout v : input.getCheckouts()) {
			listcheckouts.add(v.getOid());
		}
		result.setCheckouts(listcheckouts);
		User createdByVal = input.getCreatedBy();
		result.setCreatedById(createdByVal == null ? -1 : createdByVal.getOid());
		GeoTag geoTagVal = input.getGeoTag();
		result.setGeoTagId(geoTagVal == null ? -1 : geoTagVal.getOid());
		List<Long> listsubProjects = new ArrayList<Long>();
		for (Project v : input.getSubProjects()) {
			listsubProjects.add(v.getOid());
		}
		result.setSubProjects(listsubProjects);
		Project parentVal = input.getParent();
		result.setParentId(parentVal == null ? -1 : parentVal.getOid());
		List<Long> listextendedData = new ArrayList<Long>();
		for (ExtendedData v : input.getExtendedData()) {
			listextendedData.add(v.getOid());
		}
		result.setExtendedData(listextendedData);
		List<Long> listservices = new ArrayList<Long>();
		for (Service v : input.getServices()) {
			listservices.add(v.getOid());
		}
		result.setServices(listservices);
		List<Long> listlogs = new ArrayList<Long>();
		for (ProjectRelated v : input.getLogs()) {
			listlogs.add(v.getOid());
		}
		result.setLogs(listlogs);
		List<Long> listmodelCheckers = new ArrayList<Long>();
		for (ModelCheckerInstance v : input.getModelCheckers()) {
			listmodelCheckers.add(v.getOid());
		}
		result.setModelCheckers(listmodelCheckers);
		List<Long> listnewServices = new ArrayList<Long>();
		for (NewService v : input.getNewServices()) {
			listnewServices.add(v.getOid());
		}
		result.setNewServices(listnewServices);
		return result;
	}

	public Project convertFromSObject(SProject input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		Project result = convertFromSObject(input, (Project)session.create(StorePackage.eINSTANCE.getProject()), session);
		
		
		return result;
	}

	public Project convertFromSObject(SProject input) throws BimserverDatabaseException {
		Project result = convertFromSObject(input, StoreFactory.eINSTANCE.createProject(), null);
		return result;
	}

	public Project convertFromSObject(SProject input, Project result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setId(input.getId());
		result.setName(input.getName());
		result.setState(ObjectState.values()[input.getState().ordinal()]);
		result.setCreatedDate(input.getCreatedDate());
		result.setDescription(input.getDescription());
		result.setExportLengthMeasurePrefix(SIPrefix.values()[input.getExportLengthMeasurePrefix().ordinal()]);
		result.setSchema(input.getSchema());
		result.setSendEmailOnNewRevision(input.isSendEmailOnNewRevision());
		result.setCheckinInProgress(input.getCheckinInProgress());
		List<User> listhasAuthorizedUsers = result.getHasAuthorizedUsers();
		for (long oid : input.getHasAuthorizedUsers()) {
			listhasAuthorizedUsers.add((User)session.get(StorePackage.eINSTANCE.getUser(), oid, OldQuery.getDefault()));
		}
		List<ConcreteRevision> listconcreteRevisions = result.getConcreteRevisions();
		for (long oid : input.getConcreteRevisions()) {
			listconcreteRevisions.add((ConcreteRevision)session.get(StorePackage.eINSTANCE.getConcreteRevision(), oid, OldQuery.getDefault()));
		}
		List<Revision> listrevisions = result.getRevisions();
		for (long oid : input.getRevisions()) {
			listrevisions.add((Revision)session.get(StorePackage.eINSTANCE.getRevision(), oid, OldQuery.getDefault()));
		}
		result.setLastConcreteRevision((ConcreteRevision)session.get(StorePackage.eINSTANCE.getConcreteRevision(), input.getLastConcreteRevisionId(), OldQuery.getDefault()));
		result.setLastRevision((Revision)session.get(StorePackage.eINSTANCE.getRevision(), input.getLastRevisionId(), OldQuery.getDefault()));
		List<Checkout> listcheckouts = result.getCheckouts();
		for (long oid : input.getCheckouts()) {
			listcheckouts.add((Checkout)session.get(StorePackage.eINSTANCE.getCheckout(), oid, OldQuery.getDefault()));
		}
		result.setCreatedBy((User)session.get(StorePackage.eINSTANCE.getUser(), input.getCreatedById(), OldQuery.getDefault()));
		result.setGeoTag((GeoTag)session.get(StorePackage.eINSTANCE.getGeoTag(), input.getGeoTagId(), OldQuery.getDefault()));
		List<Project> listsubProjects = result.getSubProjects();
		for (long oid : input.getSubProjects()) {
			listsubProjects.add((Project)session.get(StorePackage.eINSTANCE.getProject(), oid, OldQuery.getDefault()));
		}
		result.setParent((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getParentId(), OldQuery.getDefault()));
		List<ExtendedData> listextendedData = result.getExtendedData();
		for (long oid : input.getExtendedData()) {
			listextendedData.add((ExtendedData)session.get(StorePackage.eINSTANCE.getExtendedData(), oid, OldQuery.getDefault()));
		}
		List<Service> listservices = result.getServices();
		for (long oid : input.getServices()) {
			listservices.add((Service)session.get(StorePackage.eINSTANCE.getService(), oid, OldQuery.getDefault()));
		}
		List<ProjectRelated> listlogs = result.getLogs();
		for (long oid : input.getLogs()) {
			listlogs.add((ProjectRelated)session.get(LogPackage.eINSTANCE.getProjectRelated(), oid, OldQuery.getDefault()));
		}
		List<ModelCheckerInstance> listmodelCheckers = result.getModelCheckers();
		for (long oid : input.getModelCheckers()) {
			listmodelCheckers.add((ModelCheckerInstance)session.get(StorePackage.eINSTANCE.getModelCheckerInstance(), oid, OldQuery.getDefault()));
		}
		List<NewService> listnewServices = result.getNewServices();
		for (long oid : input.getNewServices()) {
			listnewServices.add((NewService)session.get(StorePackage.eINSTANCE.getNewService(), oid, OldQuery.getDefault()));
		}
		return result;
	}

	public Set<SUser> convertToSSetUser(Collection<User> input) {
		Set<SUser> result = new HashSet<SUser>();
		for (User o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<User> convertFromSSetUser(Collection<SUser> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<User> result = new HashSet<User>();
		for (SUser o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SUser> convertToSListUser(Collection<User> input) {
		List<SUser> result = new ArrayList<SUser>();
		for (User o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<User> convertFromSListUser(Collection<SUser> input, DatabaseSession session) throws BimserverDatabaseException {
		List<User> result = new ArrayList<User>();
		for (SUser o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SUser convertToSObject(User input) {
		if (input == null) {
			return null;
		}
		
		SUser result = new SUser();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setName(input.getName());
		result.setPasswordHash(input.getPasswordHash());
		result.setPasswordSalt(input.getPasswordSalt());
		result.setState(SObjectState.values()[input.getState().ordinal()]);
		result.setCreatedOn(input.getCreatedOn());
		result.setUserType(SUserType.values()[input.getUserType().ordinal()]);
		result.setUsername(input.getUsername());
		result.setLastSeen(input.getLastSeen());
		result.setToken(input.getToken());
		result.setValidationToken(input.getValidationToken());
		result.setValidationTokenCreated(input.getValidationTokenCreated());
		List<Long> listhasRightsOn = new ArrayList<Long>();
		for (Project v : input.getHasRightsOn()) {
			listhasRightsOn.add(v.getOid());
		}
		result.setHasRightsOn(listhasRightsOn);
		User createdByVal = input.getCreatedBy();
		result.setCreatedById(createdByVal == null ? -1 : createdByVal.getOid());
		UserSettings userSettingsVal = input.getUserSettings();
		result.setUserSettingsId(userSettingsVal == null ? -1 : userSettingsVal.getOid());
		List<Long> listschemas = new ArrayList<Long>();
		for (ExtendedDataSchema v : input.getSchemas()) {
			listschemas.add(v.getOid());
		}
		result.setSchemas(listschemas);
		List<Long> listextendedData = new ArrayList<Long>();
		for (ExtendedData v : input.getExtendedData()) {
			listextendedData.add(v.getOid());
		}
		result.setExtendedData(listextendedData);
		List<Long> listservices = new ArrayList<Long>();
		for (Service v : input.getServices()) {
			listservices.add(v.getOid());
		}
		result.setServices(listservices);
		List<Long> listlogs = new ArrayList<Long>();
		for (UserRelated v : input.getLogs()) {
			listlogs.add(v.getOid());
		}
		result.setLogs(listlogs);
		List<Long> listoAuthAuthorizationCodes = new ArrayList<Long>();
		for (OAuthAuthorizationCode v : input.getOAuthAuthorizationCodes()) {
			listoAuthAuthorizationCodes.add(v.getOid());
		}
		result.setOAuthAuthorizationCodes(listoAuthAuthorizationCodes);
		List<Long> listoAuthIssuedAuthorizationCodes = new ArrayList<Long>();
		for (OAuthAuthorizationCode v : input.getOAuthIssuedAuthorizationCodes()) {
			listoAuthIssuedAuthorizationCodes.add(v.getOid());
		}
		result.setOAuthIssuedAuthorizationCodes(listoAuthIssuedAuthorizationCodes);
		return result;
	}

	public User convertFromSObject(SUser input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		User result = convertFromSObject(input, (User)session.create(StorePackage.eINSTANCE.getUser()), session);
		
		
		return result;
	}

	public User convertFromSObject(SUser input) throws BimserverDatabaseException {
		User result = convertFromSObject(input, StoreFactory.eINSTANCE.createUser(), null);
		return result;
	}

	public User convertFromSObject(SUser input, User result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setName(input.getName());
		result.setPasswordHash(input.getPasswordHash());
		result.setPasswordSalt(input.getPasswordSalt());
		result.setState(ObjectState.values()[input.getState().ordinal()]);
		result.setCreatedOn(input.getCreatedOn());
		result.setUserType(UserType.values()[input.getUserType().ordinal()]);
		result.setUsername(input.getUsername());
		result.setLastSeen(input.getLastSeen());
		result.setToken(input.getToken());
		result.setValidationToken(input.getValidationToken());
		result.setValidationTokenCreated(input.getValidationTokenCreated());
		List<Project> listhasRightsOn = result.getHasRightsOn();
		for (long oid : input.getHasRightsOn()) {
			listhasRightsOn.add((Project)session.get(StorePackage.eINSTANCE.getProject(), oid, OldQuery.getDefault()));
		}
		result.setCreatedBy((User)session.get(StorePackage.eINSTANCE.getUser(), input.getCreatedById(), OldQuery.getDefault()));
		result.setUserSettings((UserSettings)session.get(StorePackage.eINSTANCE.getUserSettings(), input.getUserSettingsId(), OldQuery.getDefault()));
		List<ExtendedDataSchema> listschemas = result.getSchemas();
		for (long oid : input.getSchemas()) {
			listschemas.add((ExtendedDataSchema)session.get(StorePackage.eINSTANCE.getExtendedDataSchema(), oid, OldQuery.getDefault()));
		}
		List<ExtendedData> listextendedData = result.getExtendedData();
		for (long oid : input.getExtendedData()) {
			listextendedData.add((ExtendedData)session.get(StorePackage.eINSTANCE.getExtendedData(), oid, OldQuery.getDefault()));
		}
		List<Service> listservices = result.getServices();
		for (long oid : input.getServices()) {
			listservices.add((Service)session.get(StorePackage.eINSTANCE.getService(), oid, OldQuery.getDefault()));
		}
		List<UserRelated> listlogs = result.getLogs();
		for (long oid : input.getLogs()) {
			listlogs.add((UserRelated)session.get(LogPackage.eINSTANCE.getUserRelated(), oid, OldQuery.getDefault()));
		}
		List<OAuthAuthorizationCode> listoAuthAuthorizationCodes = result.getOAuthAuthorizationCodes();
		for (long oid : input.getOAuthAuthorizationCodes()) {
			listoAuthAuthorizationCodes.add((OAuthAuthorizationCode)session.get(StorePackage.eINSTANCE.getOAuthAuthorizationCode(), oid, OldQuery.getDefault()));
		}
		List<OAuthAuthorizationCode> listoAuthIssuedAuthorizationCodes = result.getOAuthIssuedAuthorizationCodes();
		for (long oid : input.getOAuthIssuedAuthorizationCodes()) {
			listoAuthIssuedAuthorizationCodes.add((OAuthAuthorizationCode)session.get(StorePackage.eINSTANCE.getOAuthAuthorizationCode(), oid, OldQuery.getDefault()));
		}
		return result;
	}

	public Set<SRevision> convertToSSetRevision(Collection<Revision> input) {
		Set<SRevision> result = new HashSet<SRevision>();
		for (Revision o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<Revision> convertFromSSetRevision(Collection<SRevision> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<Revision> result = new HashSet<Revision>();
		for (SRevision o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SRevision> convertToSListRevision(Collection<Revision> input) {
		List<SRevision> result = new ArrayList<SRevision>();
		for (Revision o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<Revision> convertFromSListRevision(Collection<SRevision> input, DatabaseSession session) throws BimserverDatabaseException {
		List<Revision> result = new ArrayList<Revision>();
		for (SRevision o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SRevision convertToSObject(Revision input) {
		if (input == null) {
			return null;
		}
		
		SRevision result = new SRevision();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setId(input.getId());
		result.setDate(input.getDate());
		result.setComment(input.getComment());
		result.setSize(input.getSize());
		result.setTag(input.getTag());
		result.setLastError(input.getLastError());
		result.setBmi(input.getBmi());
		result.setHasGeometry(input.isHasGeometry());
		result.setNrPrimitives(input.getNrPrimitives());
		User userVal = input.getUser();
		result.setUserId(userVal == null ? -1 : userVal.getOid());
		List<Long> listconcreteRevisions = new ArrayList<Long>();
		for (ConcreteRevision v : input.getConcreteRevisions()) {
			listconcreteRevisions.add(v.getOid());
		}
		result.setConcreteRevisions(listconcreteRevisions);
		ConcreteRevision lastConcreteRevisionVal = input.getLastConcreteRevision();
		result.setLastConcreteRevisionId(lastConcreteRevisionVal == null ? -1 : lastConcreteRevisionVal.getOid());
		List<Long> listcheckouts = new ArrayList<Long>();
		for (Checkout v : input.getCheckouts()) {
			listcheckouts.add(v.getOid());
		}
		result.setCheckouts(listcheckouts);
		Project projectVal = input.getProject();
		result.setProjectId(projectVal == null ? -1 : projectVal.getOid());
		List<Long> listextendedData = new ArrayList<Long>();
		for (ExtendedData v : input.getExtendedData()) {
			listextendedData.add(v.getOid());
		}
		result.setExtendedData(listextendedData);
		List<Long> listlogs = new ArrayList<Long>();
		for (RevisionRelated v : input.getLogs()) {
			listlogs.add(v.getOid());
		}
		result.setLogs(listlogs);
		Service serviceVal = input.getService();
		result.setServiceId(serviceVal == null ? -1 : serviceVal.getOid());
		Bounds boundsVal = input.getBounds();
		result.setBounds(convertToSObject(boundsVal));
		Bounds boundsUntransformedVal = input.getBoundsUntransformed();
		result.setBoundsUntransformed(convertToSObject(boundsUntransformedVal));
		Bounds boundsMmVal = input.getBoundsMm();
		result.setBoundsMm(convertToSObject(boundsMmVal));
		Bounds boundsUntransformedMmVal = input.getBoundsUntransformedMm();
		result.setBoundsUntransformedMm(convertToSObject(boundsUntransformedMmVal));
		List<Long> listservicesLinked = new ArrayList<Long>();
		for (NewService v : input.getServicesLinked()) {
			listservicesLinked.add(v.getOid());
		}
		result.setServicesLinked(listservicesLinked);
		DensityCollection densityCollectionVal = input.getDensityCollection();
		result.setDensityCollectionId(densityCollectionVal == null ? -1 : densityCollectionVal.getOid());
		return result;
	}

	public Revision convertFromSObject(SRevision input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		Revision result = convertFromSObject(input, (Revision)session.create(StorePackage.eINSTANCE.getRevision()), session);
		
		
		return result;
	}

	public Revision convertFromSObject(SRevision input) throws BimserverDatabaseException {
		Revision result = convertFromSObject(input, StoreFactory.eINSTANCE.createRevision(), null);
		return result;
	}

	public Revision convertFromSObject(SRevision input, Revision result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setId(input.getId());
		result.setDate(input.getDate());
		result.setComment(input.getComment());
		result.setSize(input.getSize());
		result.setTag(input.getTag());
		result.setLastError(input.getLastError());
		result.setBmi(input.getBmi());
		result.setHasGeometry(input.isHasGeometry());
		result.setNrPrimitives(input.getNrPrimitives());
		result.setUser((User)session.get(StorePackage.eINSTANCE.getUser(), input.getUserId(), OldQuery.getDefault()));
		List<ConcreteRevision> listconcreteRevisions = result.getConcreteRevisions();
		for (long oid : input.getConcreteRevisions()) {
			listconcreteRevisions.add((ConcreteRevision)session.get(StorePackage.eINSTANCE.getConcreteRevision(), oid, OldQuery.getDefault()));
		}
		result.setLastConcreteRevision((ConcreteRevision)session.get(StorePackage.eINSTANCE.getConcreteRevision(), input.getLastConcreteRevisionId(), OldQuery.getDefault()));
		List<Checkout> listcheckouts = result.getCheckouts();
		for (long oid : input.getCheckouts()) {
			listcheckouts.add((Checkout)session.get(StorePackage.eINSTANCE.getCheckout(), oid, OldQuery.getDefault()));
		}
		result.setProject((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getProjectId(), OldQuery.getDefault()));
		List<ExtendedData> listextendedData = result.getExtendedData();
		for (long oid : input.getExtendedData()) {
			listextendedData.add((ExtendedData)session.get(StorePackage.eINSTANCE.getExtendedData(), oid, OldQuery.getDefault()));
		}
		List<RevisionRelated> listlogs = result.getLogs();
		for (long oid : input.getLogs()) {
			listlogs.add((RevisionRelated)session.get(LogPackage.eINSTANCE.getRevisionRelated(), oid, OldQuery.getDefault()));
		}
		result.setService((Service)session.get(StorePackage.eINSTANCE.getService(), input.getServiceId(), OldQuery.getDefault()));
		result.setBounds(convertFromSObject(input.getBounds(), session));
		result.setBoundsUntransformed(convertFromSObject(input.getBoundsUntransformed(), session));
		result.setBoundsMm(convertFromSObject(input.getBoundsMm(), session));
		result.setBoundsUntransformedMm(convertFromSObject(input.getBoundsUntransformedMm(), session));
		List<NewService> listservicesLinked = result.getServicesLinked();
		for (long oid : input.getServicesLinked()) {
			listservicesLinked.add((NewService)session.get(StorePackage.eINSTANCE.getNewService(), oid, OldQuery.getDefault()));
		}
		result.setDensityCollection((DensityCollection)session.get(StorePackage.eINSTANCE.getDensityCollection(), input.getDensityCollectionId(), OldQuery.getDefault()));
		return result;
	}

	public Set<SConcreteRevision> convertToSSetConcreteRevision(Collection<ConcreteRevision> input) {
		Set<SConcreteRevision> result = new HashSet<SConcreteRevision>();
		for (ConcreteRevision o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ConcreteRevision> convertFromSSetConcreteRevision(Collection<SConcreteRevision> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ConcreteRevision> result = new HashSet<ConcreteRevision>();
		for (SConcreteRevision o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SConcreteRevision> convertToSListConcreteRevision(Collection<ConcreteRevision> input) {
		List<SConcreteRevision> result = new ArrayList<SConcreteRevision>();
		for (ConcreteRevision o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ConcreteRevision> convertFromSListConcreteRevision(Collection<SConcreteRevision> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ConcreteRevision> result = new ArrayList<ConcreteRevision>();
		for (SConcreteRevision o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SConcreteRevision convertToSObject(ConcreteRevision input) {
		if (input == null) {
			return null;
		}
		
		SConcreteRevision result = new SConcreteRevision();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setId(input.getId());
		result.setChecksum(input.getChecksum());
		result.setSize(input.getSize());
		result.setDate(input.getDate());
		result.setLastError(input.getLastError());
		result.setClear(input.isClear());
		result.setOidCounters(input.getOidCounters());
		result.setMultiplierToMm(input.getMultiplierToMm());
		Project projectVal = input.getProject();
		result.setProjectId(projectVal == null ? -1 : projectVal.getOid());
		List<Long> listrevisions = new ArrayList<Long>();
		for (Revision v : input.getRevisions()) {
			listrevisions.add(v.getOid());
		}
		result.setRevisions(listrevisions);
		RevisionSummary summaryVal = input.getSummary();
		result.setSummaryId(summaryVal == null ? -1 : summaryVal.getOid());
		User userVal = input.getUser();
		result.setUserId(userVal == null ? -1 : userVal.getOid());
		IfcHeader ifcHeaderVal = input.getIfcHeader();
		result.setIfcHeaderId(ifcHeaderVal == null ? -1 : ifcHeaderVal.getOid());
		Bounds boundsVal = input.getBounds();
		result.setBounds(convertToSObject(boundsVal));
		Bounds boundsUntransformedVal = input.getBoundsUntransformed();
		result.setBoundsUntransformed(convertToSObject(boundsUntransformedVal));
		DensityCollection densityCollectionVal = input.getDensityCollection();
		result.setDensityCollectionId(densityCollectionVal == null ? -1 : densityCollectionVal.getOid());
		return result;
	}

	public ConcreteRevision convertFromSObject(SConcreteRevision input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		ConcreteRevision result = convertFromSObject(input, (ConcreteRevision)session.create(StorePackage.eINSTANCE.getConcreteRevision()), session);
		
		
		return result;
	}

	public ConcreteRevision convertFromSObject(SConcreteRevision input) throws BimserverDatabaseException {
		ConcreteRevision result = convertFromSObject(input, StoreFactory.eINSTANCE.createConcreteRevision(), null);
		return result;
	}

	public ConcreteRevision convertFromSObject(SConcreteRevision input, ConcreteRevision result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setId(input.getId());
		result.setChecksum(input.getChecksum());
		result.setSize(input.getSize());
		result.setDate(input.getDate());
		result.setLastError(input.getLastError());
		result.setClear(input.isClear());
		result.setOidCounters(input.getOidCounters());
		result.setMultiplierToMm(input.getMultiplierToMm());
		result.setProject((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getProjectId(), OldQuery.getDefault()));
		List<Revision> listrevisions = result.getRevisions();
		for (long oid : input.getRevisions()) {
			listrevisions.add((Revision)session.get(StorePackage.eINSTANCE.getRevision(), oid, OldQuery.getDefault()));
		}
		result.setSummary((RevisionSummary)session.get(StorePackage.eINSTANCE.getRevisionSummary(), input.getSummaryId(), OldQuery.getDefault()));
		result.setUser((User)session.get(StorePackage.eINSTANCE.getUser(), input.getUserId(), OldQuery.getDefault()));
		result.setIfcHeader((IfcHeader)session.get(StorePackage.eINSTANCE.getIfcHeader(), input.getIfcHeaderId(), OldQuery.getDefault()));
		result.setBounds(convertFromSObject(input.getBounds(), session));
		result.setBoundsUntransformed(convertFromSObject(input.getBoundsUntransformed(), session));
		result.setDensityCollection((DensityCollection)session.get(StorePackage.eINSTANCE.getDensityCollection(), input.getDensityCollectionId(), OldQuery.getDefault()));
		return result;
	}

	public Set<SGeoTag> convertToSSetGeoTag(Collection<GeoTag> input) {
		Set<SGeoTag> result = new HashSet<SGeoTag>();
		for (GeoTag o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<GeoTag> convertFromSSetGeoTag(Collection<SGeoTag> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<GeoTag> result = new HashSet<GeoTag>();
		for (SGeoTag o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SGeoTag> convertToSListGeoTag(Collection<GeoTag> input) {
		List<SGeoTag> result = new ArrayList<SGeoTag>();
		for (GeoTag o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<GeoTag> convertFromSListGeoTag(Collection<SGeoTag> input, DatabaseSession session) throws BimserverDatabaseException {
		List<GeoTag> result = new ArrayList<GeoTag>();
		for (SGeoTag o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SGeoTag convertToSObject(GeoTag input) {
		if (input == null) {
			return null;
		}
		
		SGeoTag result = new SGeoTag();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setEnabled(input.getEnabled());
		result.setX(input.getX());
		result.setY(input.getY());
		result.setZ(input.getZ());
		result.setEpsg(input.getEpsg());
		result.setDirectionAngle(input.getDirectionAngle());
		List<Long> listprojects = new ArrayList<Long>();
		for (Project v : input.getProjects()) {
			listprojects.add(v.getOid());
		}
		result.setProjects(listprojects);
		return result;
	}

	public GeoTag convertFromSObject(SGeoTag input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		GeoTag result = convertFromSObject(input, (GeoTag)session.create(StorePackage.eINSTANCE.getGeoTag()), session);
		
		
		return result;
	}

	public GeoTag convertFromSObject(SGeoTag input) throws BimserverDatabaseException {
		GeoTag result = convertFromSObject(input, StoreFactory.eINSTANCE.createGeoTag(), null);
		return result;
	}

	public GeoTag convertFromSObject(SGeoTag input, GeoTag result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setEnabled(input.getEnabled());
		result.setX(input.getX());
		result.setY(input.getY());
		result.setZ(input.getZ());
		result.setEpsg(input.getEpsg());
		result.setDirectionAngle(input.getDirectionAngle());
		List<Project> listprojects = result.getProjects();
		for (long oid : input.getProjects()) {
			listprojects.add((Project)session.get(StorePackage.eINSTANCE.getProject(), oid, OldQuery.getDefault()));
		}
		return result;
	}

	public Set<SCheckout> convertToSSetCheckout(Collection<Checkout> input) {
		Set<SCheckout> result = new HashSet<SCheckout>();
		for (Checkout o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<Checkout> convertFromSSetCheckout(Collection<SCheckout> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<Checkout> result = new HashSet<Checkout>();
		for (SCheckout o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SCheckout> convertToSListCheckout(Collection<Checkout> input) {
		List<SCheckout> result = new ArrayList<SCheckout>();
		for (Checkout o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<Checkout> convertFromSListCheckout(Collection<SCheckout> input, DatabaseSession session) throws BimserverDatabaseException {
		List<Checkout> result = new ArrayList<Checkout>();
		for (SCheckout o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SCheckout convertToSObject(Checkout input) {
		if (input == null) {
			return null;
		}
		
		SCheckout result = new SCheckout();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setDate(input.getDate());
		result.setActive(input.getActive());
		User userVal = input.getUser();
		result.setUserId(userVal == null ? -1 : userVal.getOid());
		Revision revisionVal = input.getRevision();
		result.setRevision(convertToSObject(revisionVal));
		Project projectVal = input.getProject();
		result.setProjectId(projectVal == null ? -1 : projectVal.getOid());
		Revision checkinVal = input.getCheckin();
		result.setCheckin(convertToSObject(checkinVal));
		List<Long> listlogs = new ArrayList<Long>();
		for (CheckoutRelated v : input.getLogs()) {
			listlogs.add(v.getOid());
		}
		result.setLogs(listlogs);
		return result;
	}

	public Checkout convertFromSObject(SCheckout input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		Checkout result = convertFromSObject(input, (Checkout)session.create(StorePackage.eINSTANCE.getCheckout()), session);
		
		
		return result;
	}

	public Checkout convertFromSObject(SCheckout input) throws BimserverDatabaseException {
		Checkout result = convertFromSObject(input, StoreFactory.eINSTANCE.createCheckout(), null);
		return result;
	}

	public Checkout convertFromSObject(SCheckout input, Checkout result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setDate(input.getDate());
		result.setActive(input.getActive());
		result.setUser((User)session.get(StorePackage.eINSTANCE.getUser(), input.getUserId(), OldQuery.getDefault()));
		result.setRevision(convertFromSObject(input.getRevision(), session));
		result.setProject((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getProjectId(), OldQuery.getDefault()));
		result.setCheckin(convertFromSObject(input.getCheckin(), session));
		List<CheckoutRelated> listlogs = result.getLogs();
		for (long oid : input.getLogs()) {
			listlogs.add((CheckoutRelated)session.get(LogPackage.eINSTANCE.getCheckoutRelated(), oid, OldQuery.getDefault()));
		}
		return result;
	}

	public Set<SServerSettings> convertToSSetServerSettings(Collection<ServerSettings> input) {
		Set<SServerSettings> result = new HashSet<SServerSettings>();
		for (ServerSettings o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ServerSettings> convertFromSSetServerSettings(Collection<SServerSettings> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ServerSettings> result = new HashSet<ServerSettings>();
		for (SServerSettings o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SServerSettings> convertToSListServerSettings(Collection<ServerSettings> input) {
		List<SServerSettings> result = new ArrayList<SServerSettings>();
		for (ServerSettings o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ServerSettings> convertFromSListServerSettings(Collection<SServerSettings> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ServerSettings> result = new ArrayList<ServerSettings>();
		for (SServerSettings o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SServerSettings convertToSObject(ServerSettings input) {
		if (input == null) {
			return null;
		}
		
		SServerSettings result = new SServerSettings();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setSendConfirmationEmailAfterRegistration(input.isSendConfirmationEmailAfterRegistration());
		result.setAllowSelfRegistration(input.getAllowSelfRegistration());
		result.setAllowUsersToCreateTopLevelProjects(input.isAllowUsersToCreateTopLevelProjects());
		result.setCheckinMergingEnabled(input.getCheckinMergingEnabled());
		result.setSmtpServer(input.getSmtpServer());
		result.setEmailSenderAddress(input.getEmailSenderAddress());
		result.setEmailSenderName(input.getEmailSenderName());
		result.setSiteAddress(input.getSiteAddress());
		result.setGenerateGeometryOnCheckin(input.isGenerateGeometryOnCheckin());
		result.setAllowOnlyWhitelisted(input.isAllowOnlyWhitelisted());
		result.getWhitelistedDomains().addAll(input.getWhitelistedDomains());
		result.setHideUserListForNonAdmin(input.getHideUserListForNonAdmin());
		result.setProtocolBuffersPort(input.getProtocolBuffersPort());
		result.setCacheOutputFiles(input.getCacheOutputFiles());
		result.setServiceRepositoryUrl(input.getServiceRepositoryUrl());
		result.setSendEmailOnNewRevision(input.isSendEmailOnNewRevision());
		result.setSessionTimeOutSeconds(input.getSessionTimeOutSeconds());
		result.setSmtpUsername(input.getSmtpUsername());
		result.setSmtpPassword(input.getSmtpPassword());
		result.setSmtpPort(input.getSmtpPort());
		result.setSmtpProtocol(SSmtpProtocol.values()[input.getSmtpProtocol().ordinal()]);
		result.setReuseGeometry(input.isReuseGeometry());
		result.setAllowCreateValidatedUser(input.isAllowCreateValidatedUser());
		result.setRenderEngineProcesses(input.getRenderEngineProcesses());
		result.setPluginStrictVersionChecking(input.isPluginStrictVersionChecking());
		result.setName(input.getName());
		result.setDescription(input.getDescription());
		result.setIcon(input.getIcon());
		result.setStoreLastLogin(input.isStoreLastLogin());
		result.setStoreServiceRuns(input.isStoreServiceRuns());
		result.setOptimizeMappedItems(input.isOptimizeMappedItems());
		List<Long> listwebModules = new ArrayList<Long>();
		for (WebModulePluginConfiguration v : input.getWebModules()) {
			listwebModules.add(v.getOid());
		}
		result.setWebModules(listwebModules);
		WebModulePluginConfiguration webModuleVal = input.getWebModule();
		result.setWebModuleId(webModuleVal == null ? -1 : webModuleVal.getOid());
		PluginDescriptor defaultRenderEnginePluginVal = input.getDefaultRenderEnginePlugin();
		result.setDefaultRenderEnginePluginId(defaultRenderEnginePluginVal == null ? -1 : defaultRenderEnginePluginVal.getOid());
		return result;
	}

	public ServerSettings convertFromSObject(SServerSettings input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		ServerSettings result = convertFromSObject(input, (ServerSettings)session.create(StorePackage.eINSTANCE.getServerSettings()), session);
		
		
		return result;
	}

	public ServerSettings convertFromSObject(SServerSettings input) throws BimserverDatabaseException {
		ServerSettings result = convertFromSObject(input, StoreFactory.eINSTANCE.createServerSettings(), null);
		return result;
	}

	public ServerSettings convertFromSObject(SServerSettings input, ServerSettings result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setSendConfirmationEmailAfterRegistration(input.isSendConfirmationEmailAfterRegistration());
		result.setAllowSelfRegistration(input.getAllowSelfRegistration());
		result.setAllowUsersToCreateTopLevelProjects(input.isAllowUsersToCreateTopLevelProjects());
		result.setCheckinMergingEnabled(input.getCheckinMergingEnabled());
		result.setSmtpServer(input.getSmtpServer());
		result.setEmailSenderAddress(input.getEmailSenderAddress());
		result.setEmailSenderName(input.getEmailSenderName());
		result.setSiteAddress(input.getSiteAddress());
		result.setGenerateGeometryOnCheckin(input.isGenerateGeometryOnCheckin());
		result.setAllowOnlyWhitelisted(input.isAllowOnlyWhitelisted());
		result.getWhitelistedDomains().addAll(input.getWhitelistedDomains());
		result.setHideUserListForNonAdmin(input.getHideUserListForNonAdmin());
		result.setProtocolBuffersPort(input.getProtocolBuffersPort());
		result.setCacheOutputFiles(input.getCacheOutputFiles());
		result.setServiceRepositoryUrl(input.getServiceRepositoryUrl());
		result.setSendEmailOnNewRevision(input.isSendEmailOnNewRevision());
		result.setSessionTimeOutSeconds(input.getSessionTimeOutSeconds());
		result.setSmtpUsername(input.getSmtpUsername());
		result.setSmtpPassword(input.getSmtpPassword());
		result.setSmtpPort(input.getSmtpPort());
		result.setSmtpProtocol(SmtpProtocol.values()[input.getSmtpProtocol().ordinal()]);
		result.setReuseGeometry(input.isReuseGeometry());
		result.setAllowCreateValidatedUser(input.isAllowCreateValidatedUser());
		result.setRenderEngineProcesses(input.getRenderEngineProcesses());
		result.setPluginStrictVersionChecking(input.isPluginStrictVersionChecking());
		result.setName(input.getName());
		result.setDescription(input.getDescription());
		result.setIcon(input.getIcon());
		result.setStoreLastLogin(input.isStoreLastLogin());
		result.setStoreServiceRuns(input.isStoreServiceRuns());
		result.setOptimizeMappedItems(input.isOptimizeMappedItems());
		List<WebModulePluginConfiguration> listwebModules = result.getWebModules();
		for (long oid : input.getWebModules()) {
			listwebModules.add((WebModulePluginConfiguration)session.get(StorePackage.eINSTANCE.getWebModulePluginConfiguration(), oid, OldQuery.getDefault()));
		}
		result.setWebModule((WebModulePluginConfiguration)session.get(StorePackage.eINSTANCE.getWebModulePluginConfiguration(), input.getWebModuleId(), OldQuery.getDefault()));
		result.setDefaultRenderEnginePlugin((PluginDescriptor)session.get(StorePackage.eINSTANCE.getPluginDescriptor(), input.getDefaultRenderEnginePluginId(), OldQuery.getDefault()));
		return result;
	}

	public Set<SUserSettings> convertToSSetUserSettings(Collection<UserSettings> input) {
		Set<SUserSettings> result = new HashSet<SUserSettings>();
		for (UserSettings o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<UserSettings> convertFromSSetUserSettings(Collection<SUserSettings> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<UserSettings> result = new HashSet<UserSettings>();
		for (SUserSettings o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SUserSettings> convertToSListUserSettings(Collection<UserSettings> input) {
		List<SUserSettings> result = new ArrayList<SUserSettings>();
		for (UserSettings o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<UserSettings> convertFromSListUserSettings(Collection<SUserSettings> input, DatabaseSession session) throws BimserverDatabaseException {
		List<UserSettings> result = new ArrayList<UserSettings>();
		for (SUserSettings o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SUserSettings convertToSObject(UserSettings input) {
		if (input == null) {
			return null;
		}
		
		SUserSettings result = new SUserSettings();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		List<Long> listserializers = new ArrayList<Long>();
		for (SerializerPluginConfiguration v : input.getSerializers()) {
			listserializers.add(v.getOid());
		}
		result.setSerializers(listserializers);
		List<Long> listobjectIDMs = new ArrayList<Long>();
		for (ObjectIDMPluginConfiguration v : input.getObjectIDMs()) {
			listobjectIDMs.add(v.getOid());
		}
		result.setObjectIDMs(listobjectIDMs);
		List<Long> listrenderEngines = new ArrayList<Long>();
		for (RenderEnginePluginConfiguration v : input.getRenderEngines()) {
			listrenderEngines.add(v.getOid());
		}
		result.setRenderEngines(listrenderEngines);
		List<Long> listdeserializers = new ArrayList<Long>();
		for (DeserializerPluginConfiguration v : input.getDeserializers()) {
			listdeserializers.add(v.getOid());
		}
		result.setDeserializers(listdeserializers);
		List<Long> listqueryEngines = new ArrayList<Long>();
		for (QueryEnginePluginConfiguration v : input.getQueryEngines()) {
			listqueryEngines.add(v.getOid());
		}
		result.setQueryEngines(listqueryEngines);
		List<Long> listmodelMergers = new ArrayList<Long>();
		for (ModelMergerPluginConfiguration v : input.getModelMergers()) {
			listmodelMergers.add(v.getOid());
		}
		result.setModelMergers(listmodelMergers);
		List<Long> listmodelCompares = new ArrayList<Long>();
		for (ModelComparePluginConfiguration v : input.getModelCompares()) {
			listmodelCompares.add(v.getOid());
		}
		result.setModelCompares(listmodelCompares);
		ModelMergerPluginConfiguration defaultModelMergerVal = input.getDefaultModelMerger();
		result.setDefaultModelMergerId(defaultModelMergerVal == null ? -1 : defaultModelMergerVal.getOid());
		ModelComparePluginConfiguration defaultModelCompareVal = input.getDefaultModelCompare();
		result.setDefaultModelCompareId(defaultModelCompareVal == null ? -1 : defaultModelCompareVal.getOid());
		QueryEnginePluginConfiguration defaultQueryEngineVal = input.getDefaultQueryEngine();
		result.setDefaultQueryEngineId(defaultQueryEngineVal == null ? -1 : defaultQueryEngineVal.getOid());
		RenderEnginePluginConfiguration defaultRenderEngineVal = input.getDefaultRenderEngine();
		result.setDefaultRenderEngineId(defaultRenderEngineVal == null ? -1 : defaultRenderEngineVal.getOid());
		SerializerPluginConfiguration defaultSerializerVal = input.getDefaultSerializer();
		result.setDefaultSerializerId(defaultSerializerVal == null ? -1 : defaultSerializerVal.getOid());
		ObjectIDMPluginConfiguration defaultObjectIDMVal = input.getDefaultObjectIDM();
		result.setDefaultObjectIDMId(defaultObjectIDMVal == null ? -1 : defaultObjectIDMVal.getOid());
		List<Long> listservices = new ArrayList<Long>();
		for (InternalServicePluginConfiguration v : input.getServices()) {
			listservices.add(v.getOid());
		}
		result.setServices(listservices);
		return result;
	}

	public UserSettings convertFromSObject(SUserSettings input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		UserSettings result = convertFromSObject(input, (UserSettings)session.create(StorePackage.eINSTANCE.getUserSettings()), session);
		
		
		return result;
	}

	public UserSettings convertFromSObject(SUserSettings input) throws BimserverDatabaseException {
		UserSettings result = convertFromSObject(input, StoreFactory.eINSTANCE.createUserSettings(), null);
		return result;
	}

	public UserSettings convertFromSObject(SUserSettings input, UserSettings result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		List<SerializerPluginConfiguration> listserializers = result.getSerializers();
		for (long oid : input.getSerializers()) {
			listserializers.add((SerializerPluginConfiguration)session.get(StorePackage.eINSTANCE.getSerializerPluginConfiguration(), oid, OldQuery.getDefault()));
		}
		List<ObjectIDMPluginConfiguration> listobjectIDMs = result.getObjectIDMs();
		for (long oid : input.getObjectIDMs()) {
			listobjectIDMs.add((ObjectIDMPluginConfiguration)session.get(StorePackage.eINSTANCE.getObjectIDMPluginConfiguration(), oid, OldQuery.getDefault()));
		}
		List<RenderEnginePluginConfiguration> listrenderEngines = result.getRenderEngines();
		for (long oid : input.getRenderEngines()) {
			listrenderEngines.add((RenderEnginePluginConfiguration)session.get(StorePackage.eINSTANCE.getRenderEnginePluginConfiguration(), oid, OldQuery.getDefault()));
		}
		List<DeserializerPluginConfiguration> listdeserializers = result.getDeserializers();
		for (long oid : input.getDeserializers()) {
			listdeserializers.add((DeserializerPluginConfiguration)session.get(StorePackage.eINSTANCE.getDeserializerPluginConfiguration(), oid, OldQuery.getDefault()));
		}
		List<QueryEnginePluginConfiguration> listqueryEngines = result.getQueryEngines();
		for (long oid : input.getQueryEngines()) {
			listqueryEngines.add((QueryEnginePluginConfiguration)session.get(StorePackage.eINSTANCE.getQueryEnginePluginConfiguration(), oid, OldQuery.getDefault()));
		}
		List<ModelMergerPluginConfiguration> listmodelMergers = result.getModelMergers();
		for (long oid : input.getModelMergers()) {
			listmodelMergers.add((ModelMergerPluginConfiguration)session.get(StorePackage.eINSTANCE.getModelMergerPluginConfiguration(), oid, OldQuery.getDefault()));
		}
		List<ModelComparePluginConfiguration> listmodelCompares = result.getModelCompares();
		for (long oid : input.getModelCompares()) {
			listmodelCompares.add((ModelComparePluginConfiguration)session.get(StorePackage.eINSTANCE.getModelComparePluginConfiguration(), oid, OldQuery.getDefault()));
		}
		result.setDefaultModelMerger((ModelMergerPluginConfiguration)session.get(StorePackage.eINSTANCE.getModelMergerPluginConfiguration(), input.getDefaultModelMergerId(), OldQuery.getDefault()));
		result.setDefaultModelCompare((ModelComparePluginConfiguration)session.get(StorePackage.eINSTANCE.getModelComparePluginConfiguration(), input.getDefaultModelCompareId(), OldQuery.getDefault()));
		result.setDefaultQueryEngine((QueryEnginePluginConfiguration)session.get(StorePackage.eINSTANCE.getQueryEnginePluginConfiguration(), input.getDefaultQueryEngineId(), OldQuery.getDefault()));
		result.setDefaultRenderEngine((RenderEnginePluginConfiguration)session.get(StorePackage.eINSTANCE.getRenderEnginePluginConfiguration(), input.getDefaultRenderEngineId(), OldQuery.getDefault()));
		result.setDefaultSerializer((SerializerPluginConfiguration)session.get(StorePackage.eINSTANCE.getSerializerPluginConfiguration(), input.getDefaultSerializerId(), OldQuery.getDefault()));
		result.setDefaultObjectIDM((ObjectIDMPluginConfiguration)session.get(StorePackage.eINSTANCE.getObjectIDMPluginConfiguration(), input.getDefaultObjectIDMId(), OldQuery.getDefault()));
		List<InternalServicePluginConfiguration> listservices = result.getServices();
		for (long oid : input.getServices()) {
			listservices.add((InternalServicePluginConfiguration)session.get(StorePackage.eINSTANCE.getInternalServicePluginConfiguration(), oid, OldQuery.getDefault()));
		}
		return result;
	}

	public Set<SPluginConfiguration> convertToSSetPluginConfiguration(Collection<PluginConfiguration> input) {
		Set<SPluginConfiguration> result = new HashSet<SPluginConfiguration>();
		for (PluginConfiguration o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<PluginConfiguration> convertFromSSetPluginConfiguration(Collection<SPluginConfiguration> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<PluginConfiguration> result = new HashSet<PluginConfiguration>();
		for (SPluginConfiguration o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SPluginConfiguration> convertToSListPluginConfiguration(Collection<PluginConfiguration> input) {
		List<SPluginConfiguration> result = new ArrayList<SPluginConfiguration>();
		for (PluginConfiguration o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<PluginConfiguration> convertFromSListPluginConfiguration(Collection<SPluginConfiguration> input, DatabaseSession session) throws BimserverDatabaseException {
		List<PluginConfiguration> result = new ArrayList<PluginConfiguration>();
		for (SPluginConfiguration o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SPluginConfiguration convertToSObject(PluginConfiguration input) {
		if (input == null) {
			return null;
		}
		
		if (input instanceof DeserializerPluginConfiguration) {
			return convertToSObject((DeserializerPluginConfiguration)input);
		}
		else if (input instanceof InternalServicePluginConfiguration) {
			return convertToSObject((InternalServicePluginConfiguration)input);
		}
		else if (input instanceof ModelComparePluginConfiguration) {
			return convertToSObject((ModelComparePluginConfiguration)input);
		}
		else if (input instanceof ModelMergerPluginConfiguration) {
			return convertToSObject((ModelMergerPluginConfiguration)input);
		}
		else if (input instanceof ObjectIDMPluginConfiguration) {
			return convertToSObject((ObjectIDMPluginConfiguration)input);
		}
		else if (input instanceof QueryEnginePluginConfiguration) {
			return convertToSObject((QueryEnginePluginConfiguration)input);
		}
		else if (input instanceof RenderEnginePluginConfiguration) {
			return convertToSObject((RenderEnginePluginConfiguration)input);
		}
		else if (input instanceof SerializerPluginConfiguration) {
			return convertToSObject((SerializerPluginConfiguration)input);
		}
		else if (input instanceof WebModulePluginConfiguration) {
			return convertToSObject((WebModulePluginConfiguration)input);
		}
		SPluginConfiguration result = new SPluginConfiguration();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setName(input.getName());
		result.setEnabled(input.getEnabled());
		result.setDescription(input.getDescription());
		PluginDescriptor pluginDescriptorVal = input.getPluginDescriptor();
		result.setPluginDescriptorId(pluginDescriptorVal == null ? -1 : pluginDescriptorVal.getOid());
		ObjectType settingsVal = input.getSettings();
		result.setSettingsId(settingsVal == null ? -1 : settingsVal.getOid());
		return result;
	}

	public PluginConfiguration convertFromSObject(SPluginConfiguration input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		PluginConfiguration result = convertFromSObject(input, (PluginConfiguration)session.create(StorePackage.eINSTANCE.getPluginConfiguration()), session);
		
		
		return result;
	}

	public PluginConfiguration convertFromSObject(SPluginConfiguration input) throws BimserverDatabaseException {
		PluginConfiguration result = convertFromSObject(input, StoreFactory.eINSTANCE.createPluginConfiguration(), null);
		return result;
	}

	public PluginConfiguration convertFromSObject(SPluginConfiguration input, PluginConfiguration result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		if (input instanceof SDeserializerPluginConfiguration) {
			return convertFromSObject((SDeserializerPluginConfiguration)input, session);
		}
		else if (input instanceof SInternalServicePluginConfiguration) {
			return convertFromSObject((SInternalServicePluginConfiguration)input, session);
		}
		else if (input instanceof SModelComparePluginConfiguration) {
			return convertFromSObject((SModelComparePluginConfiguration)input, session);
		}
		else if (input instanceof SModelMergerPluginConfiguration) {
			return convertFromSObject((SModelMergerPluginConfiguration)input, session);
		}
		else if (input instanceof SObjectIDMPluginConfiguration) {
			return convertFromSObject((SObjectIDMPluginConfiguration)input, session);
		}
		else if (input instanceof SQueryEnginePluginConfiguration) {
			return convertFromSObject((SQueryEnginePluginConfiguration)input, session);
		}
		else if (input instanceof SRenderEnginePluginConfiguration) {
			return convertFromSObject((SRenderEnginePluginConfiguration)input, session);
		}
		else if (input instanceof SSerializerPluginConfiguration) {
			return convertFromSObject((SSerializerPluginConfiguration)input, session);
		}
		else if (input instanceof SWebModulePluginConfiguration) {
			return convertFromSObject((SWebModulePluginConfiguration)input, session);
		}
		result.setName(input.getName());
		result.setEnabled(input.getEnabled());
		result.setDescription(input.getDescription());
		result.setPluginDescriptor((PluginDescriptor)session.get(StorePackage.eINSTANCE.getPluginDescriptor(), input.getPluginDescriptorId(), OldQuery.getDefault()));
		result.setSettings((ObjectType)session.get(StorePackage.eINSTANCE.getObjectType(), input.getSettingsId(), OldQuery.getDefault()));
		return result;
	}

	public Set<SSerializerPluginConfiguration> convertToSSetSerializerPluginConfiguration(Collection<SerializerPluginConfiguration> input) {
		Set<SSerializerPluginConfiguration> result = new HashSet<SSerializerPluginConfiguration>();
		for (SerializerPluginConfiguration o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<SerializerPluginConfiguration> convertFromSSetSerializerPluginConfiguration(Collection<SSerializerPluginConfiguration> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<SerializerPluginConfiguration> result = new HashSet<SerializerPluginConfiguration>();
		for (SSerializerPluginConfiguration o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SSerializerPluginConfiguration> convertToSListSerializerPluginConfiguration(Collection<SerializerPluginConfiguration> input) {
		List<SSerializerPluginConfiguration> result = new ArrayList<SSerializerPluginConfiguration>();
		for (SerializerPluginConfiguration o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<SerializerPluginConfiguration> convertFromSListSerializerPluginConfiguration(Collection<SSerializerPluginConfiguration> input, DatabaseSession session) throws BimserverDatabaseException {
		List<SerializerPluginConfiguration> result = new ArrayList<SerializerPluginConfiguration>();
		for (SSerializerPluginConfiguration o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SSerializerPluginConfiguration convertToSObject(SerializerPluginConfiguration input) {
		if (input == null) {
			return null;
		}
		
		if (input instanceof MessagingSerializerPluginConfiguration) {
			return convertToSObject((MessagingSerializerPluginConfiguration)input);
		}
		SSerializerPluginConfiguration result = new SSerializerPluginConfiguration();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setName(input.getName());
		result.setEnabled(input.getEnabled());
		result.setDescription(input.getDescription());
		result.setStreaming(input.isStreaming());
		PluginDescriptor pluginDescriptorVal = input.getPluginDescriptor();
		result.setPluginDescriptorId(pluginDescriptorVal == null ? -1 : pluginDescriptorVal.getOid());
		ObjectType settingsVal = input.getSettings();
		result.setSettingsId(settingsVal == null ? -1 : settingsVal.getOid());
		ObjectIDMPluginConfiguration objectIDMVal = input.getObjectIDM();
		result.setObjectIDMId(objectIDMVal == null ? -1 : objectIDMVal.getOid());
		UserSettings userSettingsVal = input.getUserSettings();
		result.setUserSettingsId(userSettingsVal == null ? -1 : userSettingsVal.getOid());
		RenderEnginePluginConfiguration renderEngineVal = input.getRenderEngine();
		result.setRenderEngineId(renderEngineVal == null ? -1 : renderEngineVal.getOid());
		return result;
	}

	public SerializerPluginConfiguration convertFromSObject(SSerializerPluginConfiguration input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		SerializerPluginConfiguration result = convertFromSObject(input, (SerializerPluginConfiguration)session.create(StorePackage.eINSTANCE.getSerializerPluginConfiguration()), session);
		
		
		return result;
	}

	public SerializerPluginConfiguration convertFromSObject(SSerializerPluginConfiguration input) throws BimserverDatabaseException {
		SerializerPluginConfiguration result = convertFromSObject(input, StoreFactory.eINSTANCE.createSerializerPluginConfiguration(), null);
		return result;
	}

	public SerializerPluginConfiguration convertFromSObject(SSerializerPluginConfiguration input, SerializerPluginConfiguration result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		if (input instanceof SMessagingSerializerPluginConfiguration) {
			return convertFromSObject((SMessagingSerializerPluginConfiguration)input, session);
		}
		result.setName(input.getName());
		result.setEnabled(input.getEnabled());
		result.setDescription(input.getDescription());
		result.setStreaming(input.isStreaming());
		result.setPluginDescriptor((PluginDescriptor)session.get(StorePackage.eINSTANCE.getPluginDescriptor(), input.getPluginDescriptorId(), OldQuery.getDefault()));
		result.setSettings((ObjectType)session.get(StorePackage.eINSTANCE.getObjectType(), input.getSettingsId(), OldQuery.getDefault()));
		result.setObjectIDM((ObjectIDMPluginConfiguration)session.get(StorePackage.eINSTANCE.getObjectIDMPluginConfiguration(), input.getObjectIDMId(), OldQuery.getDefault()));
		result.setUserSettings((UserSettings)session.get(StorePackage.eINSTANCE.getUserSettings(), input.getUserSettingsId(), OldQuery.getDefault()));
		result.setRenderEngine((RenderEnginePluginConfiguration)session.get(StorePackage.eINSTANCE.getRenderEnginePluginConfiguration(), input.getRenderEngineId(), OldQuery.getDefault()));
		return result;
	}

	public Set<SObjectIDMPluginConfiguration> convertToSSetObjectIDMPluginConfiguration(Collection<ObjectIDMPluginConfiguration> input) {
		Set<SObjectIDMPluginConfiguration> result = new HashSet<SObjectIDMPluginConfiguration>();
		for (ObjectIDMPluginConfiguration o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ObjectIDMPluginConfiguration> convertFromSSetObjectIDMPluginConfiguration(Collection<SObjectIDMPluginConfiguration> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ObjectIDMPluginConfiguration> result = new HashSet<ObjectIDMPluginConfiguration>();
		for (SObjectIDMPluginConfiguration o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SObjectIDMPluginConfiguration> convertToSListObjectIDMPluginConfiguration(Collection<ObjectIDMPluginConfiguration> input) {
		List<SObjectIDMPluginConfiguration> result = new ArrayList<SObjectIDMPluginConfiguration>();
		for (ObjectIDMPluginConfiguration o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ObjectIDMPluginConfiguration> convertFromSListObjectIDMPluginConfiguration(Collection<SObjectIDMPluginConfiguration> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ObjectIDMPluginConfiguration> result = new ArrayList<ObjectIDMPluginConfiguration>();
		for (SObjectIDMPluginConfiguration o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SObjectIDMPluginConfiguration convertToSObject(ObjectIDMPluginConfiguration input) {
		if (input == null) {
			return null;
		}
		
		SObjectIDMPluginConfiguration result = new SObjectIDMPluginConfiguration();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setName(input.getName());
		result.setEnabled(input.getEnabled());
		result.setDescription(input.getDescription());
		PluginDescriptor pluginDescriptorVal = input.getPluginDescriptor();
		result.setPluginDescriptorId(pluginDescriptorVal == null ? -1 : pluginDescriptorVal.getOid());
		ObjectType settingsVal = input.getSettings();
		result.setSettingsId(settingsVal == null ? -1 : settingsVal.getOid());
		List<Long> listserializers = new ArrayList<Long>();
		for (SerializerPluginConfiguration v : input.getSerializers()) {
			listserializers.add(v.getOid());
		}
		result.setSerializers(listserializers);
		UserSettings userSettingsVal = input.getUserSettings();
		result.setUserSettingsId(userSettingsVal == null ? -1 : userSettingsVal.getOid());
		return result;
	}

	public ObjectIDMPluginConfiguration convertFromSObject(SObjectIDMPluginConfiguration input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		ObjectIDMPluginConfiguration result = convertFromSObject(input, (ObjectIDMPluginConfiguration)session.create(StorePackage.eINSTANCE.getObjectIDMPluginConfiguration()), session);
		
		
		return result;
	}

	public ObjectIDMPluginConfiguration convertFromSObject(SObjectIDMPluginConfiguration input) throws BimserverDatabaseException {
		ObjectIDMPluginConfiguration result = convertFromSObject(input, StoreFactory.eINSTANCE.createObjectIDMPluginConfiguration(), null);
		return result;
	}

	public ObjectIDMPluginConfiguration convertFromSObject(SObjectIDMPluginConfiguration input, ObjectIDMPluginConfiguration result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setName(input.getName());
		result.setEnabled(input.getEnabled());
		result.setDescription(input.getDescription());
		result.setPluginDescriptor((PluginDescriptor)session.get(StorePackage.eINSTANCE.getPluginDescriptor(), input.getPluginDescriptorId(), OldQuery.getDefault()));
		result.setSettings((ObjectType)session.get(StorePackage.eINSTANCE.getObjectType(), input.getSettingsId(), OldQuery.getDefault()));
		List<SerializerPluginConfiguration> listserializers = result.getSerializers();
		for (long oid : input.getSerializers()) {
			listserializers.add((SerializerPluginConfiguration)session.get(StorePackage.eINSTANCE.getSerializerPluginConfiguration(), oid, OldQuery.getDefault()));
		}
		result.setUserSettings((UserSettings)session.get(StorePackage.eINSTANCE.getUserSettings(), input.getUserSettingsId(), OldQuery.getDefault()));
		return result;
	}

	public Set<SRenderEnginePluginConfiguration> convertToSSetRenderEnginePluginConfiguration(Collection<RenderEnginePluginConfiguration> input) {
		Set<SRenderEnginePluginConfiguration> result = new HashSet<SRenderEnginePluginConfiguration>();
		for (RenderEnginePluginConfiguration o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<RenderEnginePluginConfiguration> convertFromSSetRenderEnginePluginConfiguration(Collection<SRenderEnginePluginConfiguration> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<RenderEnginePluginConfiguration> result = new HashSet<RenderEnginePluginConfiguration>();
		for (SRenderEnginePluginConfiguration o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SRenderEnginePluginConfiguration> convertToSListRenderEnginePluginConfiguration(Collection<RenderEnginePluginConfiguration> input) {
		List<SRenderEnginePluginConfiguration> result = new ArrayList<SRenderEnginePluginConfiguration>();
		for (RenderEnginePluginConfiguration o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<RenderEnginePluginConfiguration> convertFromSListRenderEnginePluginConfiguration(Collection<SRenderEnginePluginConfiguration> input, DatabaseSession session) throws BimserverDatabaseException {
		List<RenderEnginePluginConfiguration> result = new ArrayList<RenderEnginePluginConfiguration>();
		for (SRenderEnginePluginConfiguration o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SRenderEnginePluginConfiguration convertToSObject(RenderEnginePluginConfiguration input) {
		if (input == null) {
			return null;
		}
		
		SRenderEnginePluginConfiguration result = new SRenderEnginePluginConfiguration();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setName(input.getName());
		result.setEnabled(input.getEnabled());
		result.setDescription(input.getDescription());
		PluginDescriptor pluginDescriptorVal = input.getPluginDescriptor();
		result.setPluginDescriptorId(pluginDescriptorVal == null ? -1 : pluginDescriptorVal.getOid());
		ObjectType settingsVal = input.getSettings();
		result.setSettingsId(settingsVal == null ? -1 : settingsVal.getOid());
		List<Long> listserializers = new ArrayList<Long>();
		for (SerializerPluginConfiguration v : input.getSerializers()) {
			listserializers.add(v.getOid());
		}
		result.setSerializers(listserializers);
		UserSettings userSettingsVal = input.getUserSettings();
		result.setUserSettingsId(userSettingsVal == null ? -1 : userSettingsVal.getOid());
		return result;
	}

	public RenderEnginePluginConfiguration convertFromSObject(SRenderEnginePluginConfiguration input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		RenderEnginePluginConfiguration result = convertFromSObject(input, (RenderEnginePluginConfiguration)session.create(StorePackage.eINSTANCE.getRenderEnginePluginConfiguration()), session);
		
		
		return result;
	}

	public RenderEnginePluginConfiguration convertFromSObject(SRenderEnginePluginConfiguration input) throws BimserverDatabaseException {
		RenderEnginePluginConfiguration result = convertFromSObject(input, StoreFactory.eINSTANCE.createRenderEnginePluginConfiguration(), null);
		return result;
	}

	public RenderEnginePluginConfiguration convertFromSObject(SRenderEnginePluginConfiguration input, RenderEnginePluginConfiguration result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setName(input.getName());
		result.setEnabled(input.getEnabled());
		result.setDescription(input.getDescription());
		result.setPluginDescriptor((PluginDescriptor)session.get(StorePackage.eINSTANCE.getPluginDescriptor(), input.getPluginDescriptorId(), OldQuery.getDefault()));
		result.setSettings((ObjectType)session.get(StorePackage.eINSTANCE.getObjectType(), input.getSettingsId(), OldQuery.getDefault()));
		List<SerializerPluginConfiguration> listserializers = result.getSerializers();
		for (long oid : input.getSerializers()) {
			listserializers.add((SerializerPluginConfiguration)session.get(StorePackage.eINSTANCE.getSerializerPluginConfiguration(), oid, OldQuery.getDefault()));
		}
		result.setUserSettings((UserSettings)session.get(StorePackage.eINSTANCE.getUserSettings(), input.getUserSettingsId(), OldQuery.getDefault()));
		return result;
	}

	public Set<SDeserializerPluginConfiguration> convertToSSetDeserializerPluginConfiguration(Collection<DeserializerPluginConfiguration> input) {
		Set<SDeserializerPluginConfiguration> result = new HashSet<SDeserializerPluginConfiguration>();
		for (DeserializerPluginConfiguration o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<DeserializerPluginConfiguration> convertFromSSetDeserializerPluginConfiguration(Collection<SDeserializerPluginConfiguration> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<DeserializerPluginConfiguration> result = new HashSet<DeserializerPluginConfiguration>();
		for (SDeserializerPluginConfiguration o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SDeserializerPluginConfiguration> convertToSListDeserializerPluginConfiguration(Collection<DeserializerPluginConfiguration> input) {
		List<SDeserializerPluginConfiguration> result = new ArrayList<SDeserializerPluginConfiguration>();
		for (DeserializerPluginConfiguration o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<DeserializerPluginConfiguration> convertFromSListDeserializerPluginConfiguration(Collection<SDeserializerPluginConfiguration> input, DatabaseSession session) throws BimserverDatabaseException {
		List<DeserializerPluginConfiguration> result = new ArrayList<DeserializerPluginConfiguration>();
		for (SDeserializerPluginConfiguration o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SDeserializerPluginConfiguration convertToSObject(DeserializerPluginConfiguration input) {
		if (input == null) {
			return null;
		}
		
		SDeserializerPluginConfiguration result = new SDeserializerPluginConfiguration();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setName(input.getName());
		result.setEnabled(input.getEnabled());
		result.setDescription(input.getDescription());
		PluginDescriptor pluginDescriptorVal = input.getPluginDescriptor();
		result.setPluginDescriptorId(pluginDescriptorVal == null ? -1 : pluginDescriptorVal.getOid());
		ObjectType settingsVal = input.getSettings();
		result.setSettingsId(settingsVal == null ? -1 : settingsVal.getOid());
		UserSettings userSettingsVal = input.getUserSettings();
		result.setUserSettingsId(userSettingsVal == null ? -1 : userSettingsVal.getOid());
		return result;
	}

	public DeserializerPluginConfiguration convertFromSObject(SDeserializerPluginConfiguration input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		DeserializerPluginConfiguration result = convertFromSObject(input, (DeserializerPluginConfiguration)session.create(StorePackage.eINSTANCE.getDeserializerPluginConfiguration()), session);
		
		
		return result;
	}

	public DeserializerPluginConfiguration convertFromSObject(SDeserializerPluginConfiguration input) throws BimserverDatabaseException {
		DeserializerPluginConfiguration result = convertFromSObject(input, StoreFactory.eINSTANCE.createDeserializerPluginConfiguration(), null);
		return result;
	}

	public DeserializerPluginConfiguration convertFromSObject(SDeserializerPluginConfiguration input, DeserializerPluginConfiguration result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setName(input.getName());
		result.setEnabled(input.getEnabled());
		result.setDescription(input.getDescription());
		result.setPluginDescriptor((PluginDescriptor)session.get(StorePackage.eINSTANCE.getPluginDescriptor(), input.getPluginDescriptorId(), OldQuery.getDefault()));
		result.setSettings((ObjectType)session.get(StorePackage.eINSTANCE.getObjectType(), input.getSettingsId(), OldQuery.getDefault()));
		result.setUserSettings((UserSettings)session.get(StorePackage.eINSTANCE.getUserSettings(), input.getUserSettingsId(), OldQuery.getDefault()));
		return result;
	}

	public Set<SDownloadResult> convertToSSetDownloadResult(Collection<DownloadResult> input) {
		Set<SDownloadResult> result = new HashSet<SDownloadResult>();
		for (DownloadResult o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<DownloadResult> convertFromSSetDownloadResult(Collection<SDownloadResult> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<DownloadResult> result = new HashSet<DownloadResult>();
		for (SDownloadResult o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SDownloadResult> convertToSListDownloadResult(Collection<DownloadResult> input) {
		List<SDownloadResult> result = new ArrayList<SDownloadResult>();
		for (DownloadResult o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<DownloadResult> convertFromSListDownloadResult(Collection<SDownloadResult> input, DatabaseSession session) throws BimserverDatabaseException {
		List<DownloadResult> result = new ArrayList<DownloadResult>();
		for (SDownloadResult o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SDownloadResult convertToSObject(DownloadResult input) {
		if (input == null) {
			return null;
		}
		
		if (input instanceof CheckoutResult) {
			return convertToSObject((CheckoutResult)input);
		}
		SDownloadResult result = new SDownloadResult();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setProjectName(input.getProjectName());
		result.setRevisionNr(input.getRevisionNr());
		result.setFile(input.getFile());
		result.setSerializerOid(input.getSerializerOid());
		return result;
	}

	public DownloadResult convertFromSObject(SDownloadResult input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		DownloadResult result = convertFromSObject(input, (DownloadResult)session.create(StorePackage.eINSTANCE.getDownloadResult()), session);
		
		
		return result;
	}

	public DownloadResult convertFromSObject(SDownloadResult input) throws BimserverDatabaseException {
		DownloadResult result = convertFromSObject(input, StoreFactory.eINSTANCE.createDownloadResult(), null);
		return result;
	}

	public DownloadResult convertFromSObject(SDownloadResult input, DownloadResult result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		if (input instanceof SCheckoutResult) {
			return convertFromSObject((SCheckoutResult)input, session);
		}
		result.setProjectName(input.getProjectName());
		result.setRevisionNr(input.getRevisionNr());
		result.setFile(input.getFile());
		result.setSerializerOid(input.getSerializerOid());
		return result;
	}

	public Set<SCheckoutResult> convertToSSetCheckoutResult(Collection<CheckoutResult> input) {
		Set<SCheckoutResult> result = new HashSet<SCheckoutResult>();
		for (CheckoutResult o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<CheckoutResult> convertFromSSetCheckoutResult(Collection<SCheckoutResult> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<CheckoutResult> result = new HashSet<CheckoutResult>();
		for (SCheckoutResult o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SCheckoutResult> convertToSListCheckoutResult(Collection<CheckoutResult> input) {
		List<SCheckoutResult> result = new ArrayList<SCheckoutResult>();
		for (CheckoutResult o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<CheckoutResult> convertFromSListCheckoutResult(Collection<SCheckoutResult> input, DatabaseSession session) throws BimserverDatabaseException {
		List<CheckoutResult> result = new ArrayList<CheckoutResult>();
		for (SCheckoutResult o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SCheckoutResult convertToSObject(CheckoutResult input) {
		if (input == null) {
			return null;
		}
		
		SCheckoutResult result = new SCheckoutResult();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setProjectName(input.getProjectName());
		result.setRevisionNr(input.getRevisionNr());
		result.setFile(input.getFile());
		result.setSerializerOid(input.getSerializerOid());
		return result;
	}

	public CheckoutResult convertFromSObject(SCheckoutResult input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		CheckoutResult result = convertFromSObject(input, (CheckoutResult)session.create(StorePackage.eINSTANCE.getCheckoutResult()), session);
		
		
		return result;
	}

	public CheckoutResult convertFromSObject(SCheckoutResult input) throws BimserverDatabaseException {
		CheckoutResult result = convertFromSObject(input, StoreFactory.eINSTANCE.createCheckoutResult(), null);
		return result;
	}

	public CheckoutResult convertFromSObject(SCheckoutResult input, CheckoutResult result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setProjectName(input.getProjectName());
		result.setRevisionNr(input.getRevisionNr());
		result.setFile(input.getFile());
		result.setSerializerOid(input.getSerializerOid());
		return result;
	}

	public Set<SDataValue> convertToSSetDataValue(Collection<DataValue> input) {
		Set<SDataValue> result = new HashSet<SDataValue>();
		for (DataValue o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<DataValue> convertFromSSetDataValue(Collection<SDataValue> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<DataValue> result = new HashSet<DataValue>();
		for (SDataValue o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SDataValue> convertToSListDataValue(Collection<DataValue> input) {
		List<SDataValue> result = new ArrayList<SDataValue>();
		for (DataValue o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<DataValue> convertFromSListDataValue(Collection<SDataValue> input, DatabaseSession session) throws BimserverDatabaseException {
		List<DataValue> result = new ArrayList<DataValue>();
		for (SDataValue o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SDataValue convertToSObject(DataValue input) {
		if (input == null) {
			return null;
		}
		
		if (input instanceof ListDataValue) {
			return convertToSObject((ListDataValue)input);
		}
		else if (input instanceof ReferenceDataValue) {
			return convertToSObject((ReferenceDataValue)input);
		}
		else if (input instanceof SimpleDataValue) {
			return convertToSObject((SimpleDataValue)input);
		}
		SDataValue result = new SDataValue();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setFieldName(input.getFieldName());
		return result;
	}

	public DataValue convertFromSObject(SDataValue input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		DataValue result = convertFromSObject(input, (DataValue)session.create(StorePackage.eINSTANCE.getDataValue()), session);
		
		
		return result;
	}

	public DataValue convertFromSObject(SDataValue input) throws BimserverDatabaseException {
		DataValue result = convertFromSObject(input, StoreFactory.eINSTANCE.createDataValue(), null);
		return result;
	}

	public DataValue convertFromSObject(SDataValue input, DataValue result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		if (input instanceof SListDataValue) {
			return convertFromSObject((SListDataValue)input, session);
		}
		else if (input instanceof SReferenceDataValue) {
			return convertFromSObject((SReferenceDataValue)input, session);
		}
		else if (input instanceof SSimpleDataValue) {
			return convertFromSObject((SSimpleDataValue)input, session);
		}
		result.setFieldName(input.getFieldName());
		return result;
	}

	public Set<SDataObject> convertToSSetDataObject(Collection<DataObject> input) {
		Set<SDataObject> result = new HashSet<SDataObject>();
		for (DataObject o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<DataObject> convertFromSSetDataObject(Collection<SDataObject> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<DataObject> result = new HashSet<DataObject>();
		for (SDataObject o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SDataObject> convertToSListDataObject(Collection<DataObject> input) {
		List<SDataObject> result = new ArrayList<SDataObject>();
		for (DataObject o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<DataObject> convertFromSListDataObject(Collection<SDataObject> input, DatabaseSession session) throws BimserverDatabaseException {
		List<DataObject> result = new ArrayList<DataObject>();
		for (SDataObject o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SDataObject convertToSObject(DataObject input) {
		if (input == null) {
			return null;
		}
		
		SDataObject result = new SDataObject();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setType(input.getType());
		result.setGuid(input.getGuid());
		result.setName(input.getName());
		List<SDataValue> listvalues = new ArrayList<SDataValue>();
		for (DataValue v : input.getValues()) {
			listvalues.add(convertToSObject(v));
		}
		result.setValues(listvalues);
		return result;
	}

	public DataObject convertFromSObject(SDataObject input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		DataObject result = convertFromSObject(input, (DataObject)session.create(StorePackage.eINSTANCE.getDataObject()), session);
		
		
		return result;
	}

	public DataObject convertFromSObject(SDataObject input) throws BimserverDatabaseException {
		DataObject result = convertFromSObject(input, StoreFactory.eINSTANCE.createDataObject(), null);
		return result;
	}

	public DataObject convertFromSObject(SDataObject input, DataObject result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setType(input.getType());
		result.setGuid(input.getGuid());
		result.setName(input.getName());
		List<DataValue> listvalues = result.getValues();
		for (SDataValue v : input.getValues()) {
			listvalues.add(convertFromSObject(v, session));
		}
		return result;
	}

	public Set<SUserSession> convertToSSetUserSession(Collection<UserSession> input) {
		Set<SUserSession> result = new HashSet<SUserSession>();
		for (UserSession o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<UserSession> convertFromSSetUserSession(Collection<SUserSession> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<UserSession> result = new HashSet<UserSession>();
		for (SUserSession o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SUserSession> convertToSListUserSession(Collection<UserSession> input) {
		List<SUserSession> result = new ArrayList<SUserSession>();
		for (UserSession o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<UserSession> convertFromSListUserSession(Collection<SUserSession> input, DatabaseSession session) throws BimserverDatabaseException {
		List<UserSession> result = new ArrayList<UserSession>();
		for (SUserSession o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SUserSession convertToSObject(UserSession input) {
		if (input == null) {
			return null;
		}
		
		SUserSession result = new SUserSession();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setUsername(input.getUsername());
		result.setName(input.getName());
		result.setType(SUserType.values()[input.getType().ordinal()]);
		result.setRemoteAddress(input.getRemoteAddress());
		result.setActiveSince(input.getActiveSince());
		result.setLastActive(input.getLastActive());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User userVal = input.getUser();
		result.setUserId(userVal == null ? -1 : userVal.getOid());
		return result;
	}

	public UserSession convertFromSObject(SUserSession input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		UserSession result = convertFromSObject(input, (UserSession)session.create(StorePackage.eINSTANCE.getUserSession()), session);
		
		
		return result;
	}

	public UserSession convertFromSObject(SUserSession input) throws BimserverDatabaseException {
		UserSession result = convertFromSObject(input, StoreFactory.eINSTANCE.createUserSession(), null);
		return result;
	}

	public UserSession convertFromSObject(SUserSession input, UserSession result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setUsername(input.getUsername());
		result.setName(input.getName());
		result.setType(UserType.values()[input.getType().ordinal()]);
		result.setRemoteAddress(input.getRemoteAddress());
		result.setActiveSince(input.getActiveSince());
		result.setLastActive(input.getLastActive());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setUser((User)session.get(StorePackage.eINSTANCE.getUser(), input.getUserId(), OldQuery.getDefault()));
		return result;
	}

	public Set<SMigration> convertToSSetMigration(Collection<Migration> input) {
		Set<SMigration> result = new HashSet<SMigration>();
		for (Migration o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<Migration> convertFromSSetMigration(Collection<SMigration> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<Migration> result = new HashSet<Migration>();
		for (SMigration o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SMigration> convertToSListMigration(Collection<Migration> input) {
		List<SMigration> result = new ArrayList<SMigration>();
		for (Migration o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<Migration> convertFromSListMigration(Collection<SMigration> input, DatabaseSession session) throws BimserverDatabaseException {
		List<Migration> result = new ArrayList<Migration>();
		for (SMigration o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SMigration convertToSObject(Migration input) {
		if (input == null) {
			return null;
		}
		
		SMigration result = new SMigration();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setNumber(input.getNumber());
		result.setDescription(input.getDescription());
		result.setExecuted(input.getExecuted());
		return result;
	}

	public Migration convertFromSObject(SMigration input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		Migration result = convertFromSObject(input, (Migration)session.create(StorePackage.eINSTANCE.getMigration()), session);
		
		
		return result;
	}

	public Migration convertFromSObject(SMigration input) throws BimserverDatabaseException {
		Migration result = convertFromSObject(input, StoreFactory.eINSTANCE.createMigration(), null);
		return result;
	}

	public Migration convertFromSObject(SMigration input, Migration result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setNumber(input.getNumber());
		result.setDescription(input.getDescription());
		result.setExecuted(input.getExecuted());
		return result;
	}

	public Set<SReferenceDataValue> convertToSSetReferenceDataValue(Collection<ReferenceDataValue> input) {
		Set<SReferenceDataValue> result = new HashSet<SReferenceDataValue>();
		for (ReferenceDataValue o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ReferenceDataValue> convertFromSSetReferenceDataValue(Collection<SReferenceDataValue> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ReferenceDataValue> result = new HashSet<ReferenceDataValue>();
		for (SReferenceDataValue o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SReferenceDataValue> convertToSListReferenceDataValue(Collection<ReferenceDataValue> input) {
		List<SReferenceDataValue> result = new ArrayList<SReferenceDataValue>();
		for (ReferenceDataValue o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ReferenceDataValue> convertFromSListReferenceDataValue(Collection<SReferenceDataValue> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ReferenceDataValue> result = new ArrayList<ReferenceDataValue>();
		for (SReferenceDataValue o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SReferenceDataValue convertToSObject(ReferenceDataValue input) {
		if (input == null) {
			return null;
		}
		
		SReferenceDataValue result = new SReferenceDataValue();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setFieldName(input.getFieldName());
		result.setTypeName(input.getTypeName());
		result.setGuid(input.getGuid());
		return result;
	}

	public ReferenceDataValue convertFromSObject(SReferenceDataValue input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		ReferenceDataValue result = convertFromSObject(input, (ReferenceDataValue)session.create(StorePackage.eINSTANCE.getReferenceDataValue()), session);
		
		
		return result;
	}

	public ReferenceDataValue convertFromSObject(SReferenceDataValue input) throws BimserverDatabaseException {
		ReferenceDataValue result = convertFromSObject(input, StoreFactory.eINSTANCE.createReferenceDataValue(), null);
		return result;
	}

	public ReferenceDataValue convertFromSObject(SReferenceDataValue input, ReferenceDataValue result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setFieldName(input.getFieldName());
		result.setTypeName(input.getTypeName());
		result.setGuid(input.getGuid());
		return result;
	}

	public Set<SListDataValue> convertToSSetListDataValue(Collection<ListDataValue> input) {
		Set<SListDataValue> result = new HashSet<SListDataValue>();
		for (ListDataValue o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ListDataValue> convertFromSSetListDataValue(Collection<SListDataValue> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ListDataValue> result = new HashSet<ListDataValue>();
		for (SListDataValue o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SListDataValue> convertToSListListDataValue(Collection<ListDataValue> input) {
		List<SListDataValue> result = new ArrayList<SListDataValue>();
		for (ListDataValue o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ListDataValue> convertFromSListListDataValue(Collection<SListDataValue> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ListDataValue> result = new ArrayList<ListDataValue>();
		for (SListDataValue o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SListDataValue convertToSObject(ListDataValue input) {
		if (input == null) {
			return null;
		}
		
		SListDataValue result = new SListDataValue();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setFieldName(input.getFieldName());
		List<SDataValue> listvalues = new ArrayList<SDataValue>();
		for (DataValue v : input.getValues()) {
			listvalues.add(convertToSObject(v));
		}
		result.setValues(listvalues);
		return result;
	}

	public ListDataValue convertFromSObject(SListDataValue input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		ListDataValue result = convertFromSObject(input, (ListDataValue)session.create(StorePackage.eINSTANCE.getListDataValue()), session);
		
		
		return result;
	}

	public ListDataValue convertFromSObject(SListDataValue input) throws BimserverDatabaseException {
		ListDataValue result = convertFromSObject(input, StoreFactory.eINSTANCE.createListDataValue(), null);
		return result;
	}

	public ListDataValue convertFromSObject(SListDataValue input, ListDataValue result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setFieldName(input.getFieldName());
		List<DataValue> listvalues = result.getValues();
		for (SDataValue v : input.getValues()) {
			listvalues.add(convertFromSObject(v, session));
		}
		return result;
	}

	public Set<SSimpleDataValue> convertToSSetSimpleDataValue(Collection<SimpleDataValue> input) {
		Set<SSimpleDataValue> result = new HashSet<SSimpleDataValue>();
		for (SimpleDataValue o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<SimpleDataValue> convertFromSSetSimpleDataValue(Collection<SSimpleDataValue> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<SimpleDataValue> result = new HashSet<SimpleDataValue>();
		for (SSimpleDataValue o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SSimpleDataValue> convertToSListSimpleDataValue(Collection<SimpleDataValue> input) {
		List<SSimpleDataValue> result = new ArrayList<SSimpleDataValue>();
		for (SimpleDataValue o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<SimpleDataValue> convertFromSListSimpleDataValue(Collection<SSimpleDataValue> input, DatabaseSession session) throws BimserverDatabaseException {
		List<SimpleDataValue> result = new ArrayList<SimpleDataValue>();
		for (SSimpleDataValue o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SSimpleDataValue convertToSObject(SimpleDataValue input) {
		if (input == null) {
			return null;
		}
		
		SSimpleDataValue result = new SSimpleDataValue();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setFieldName(input.getFieldName());
		result.setStringValue(input.getStringValue());
		return result;
	}

	public SimpleDataValue convertFromSObject(SSimpleDataValue input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		SimpleDataValue result = convertFromSObject(input, (SimpleDataValue)session.create(StorePackage.eINSTANCE.getSimpleDataValue()), session);
		
		
		return result;
	}

	public SimpleDataValue convertFromSObject(SSimpleDataValue input) throws BimserverDatabaseException {
		SimpleDataValue result = convertFromSObject(input, StoreFactory.eINSTANCE.createSimpleDataValue(), null);
		return result;
	}

	public SimpleDataValue convertFromSObject(SSimpleDataValue input, SimpleDataValue result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setFieldName(input.getFieldName());
		result.setStringValue(input.getStringValue());
		return result;
	}

	public Set<SDatabaseInformationItem> convertToSSetDatabaseInformationItem(Collection<DatabaseInformationItem> input) {
		Set<SDatabaseInformationItem> result = new HashSet<SDatabaseInformationItem>();
		for (DatabaseInformationItem o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<DatabaseInformationItem> convertFromSSetDatabaseInformationItem(Collection<SDatabaseInformationItem> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<DatabaseInformationItem> result = new HashSet<DatabaseInformationItem>();
		for (SDatabaseInformationItem o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SDatabaseInformationItem> convertToSListDatabaseInformationItem(Collection<DatabaseInformationItem> input) {
		List<SDatabaseInformationItem> result = new ArrayList<SDatabaseInformationItem>();
		for (DatabaseInformationItem o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<DatabaseInformationItem> convertFromSListDatabaseInformationItem(Collection<SDatabaseInformationItem> input, DatabaseSession session) throws BimserverDatabaseException {
		List<DatabaseInformationItem> result = new ArrayList<DatabaseInformationItem>();
		for (SDatabaseInformationItem o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SDatabaseInformationItem convertToSObject(DatabaseInformationItem input) {
		if (input == null) {
			return null;
		}
		
		SDatabaseInformationItem result = new SDatabaseInformationItem();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setKey(input.getKey());
		result.setValue(input.getValue());
		return result;
	}

	public DatabaseInformationItem convertFromSObject(SDatabaseInformationItem input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		DatabaseInformationItem result = convertFromSObject(input, (DatabaseInformationItem)session.create(StorePackage.eINSTANCE.getDatabaseInformationItem()), session);
		
		
		return result;
	}

	public DatabaseInformationItem convertFromSObject(SDatabaseInformationItem input) throws BimserverDatabaseException {
		DatabaseInformationItem result = convertFromSObject(input, StoreFactory.eINSTANCE.createDatabaseInformationItem(), null);
		return result;
	}

	public DatabaseInformationItem convertFromSObject(SDatabaseInformationItem input, DatabaseInformationItem result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setKey(input.getKey());
		result.setValue(input.getValue());
		return result;
	}

	public Set<SDatabaseInformationCategory> convertToSSetDatabaseInformationCategory(Collection<DatabaseInformationCategory> input) {
		Set<SDatabaseInformationCategory> result = new HashSet<SDatabaseInformationCategory>();
		for (DatabaseInformationCategory o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<DatabaseInformationCategory> convertFromSSetDatabaseInformationCategory(Collection<SDatabaseInformationCategory> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<DatabaseInformationCategory> result = new HashSet<DatabaseInformationCategory>();
		for (SDatabaseInformationCategory o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SDatabaseInformationCategory> convertToSListDatabaseInformationCategory(Collection<DatabaseInformationCategory> input) {
		List<SDatabaseInformationCategory> result = new ArrayList<SDatabaseInformationCategory>();
		for (DatabaseInformationCategory o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<DatabaseInformationCategory> convertFromSListDatabaseInformationCategory(Collection<SDatabaseInformationCategory> input, DatabaseSession session) throws BimserverDatabaseException {
		List<DatabaseInformationCategory> result = new ArrayList<DatabaseInformationCategory>();
		for (SDatabaseInformationCategory o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SDatabaseInformationCategory convertToSObject(DatabaseInformationCategory input) {
		if (input == null) {
			return null;
		}
		
		SDatabaseInformationCategory result = new SDatabaseInformationCategory();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setTitle(input.getTitle());
		List<SDatabaseInformationItem> listitems = new ArrayList<SDatabaseInformationItem>();
		for (DatabaseInformationItem v : input.getItems()) {
			listitems.add(convertToSObject(v));
		}
		result.setItems(listitems);
		return result;
	}

	public DatabaseInformationCategory convertFromSObject(SDatabaseInformationCategory input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		DatabaseInformationCategory result = convertFromSObject(input, (DatabaseInformationCategory)session.create(StorePackage.eINSTANCE.getDatabaseInformationCategory()), session);
		
		
		return result;
	}

	public DatabaseInformationCategory convertFromSObject(SDatabaseInformationCategory input) throws BimserverDatabaseException {
		DatabaseInformationCategory result = convertFromSObject(input, StoreFactory.eINSTANCE.createDatabaseInformationCategory(), null);
		return result;
	}

	public DatabaseInformationCategory convertFromSObject(SDatabaseInformationCategory input, DatabaseInformationCategory result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setTitle(input.getTitle());
		List<DatabaseInformationItem> listitems = result.getItems();
		for (SDatabaseInformationItem v : input.getItems()) {
			listitems.add(convertFromSObject(v, session));
		}
		return result;
	}

	public Set<SDatabaseInformation> convertToSSetDatabaseInformation(Collection<DatabaseInformation> input) {
		Set<SDatabaseInformation> result = new HashSet<SDatabaseInformation>();
		for (DatabaseInformation o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<DatabaseInformation> convertFromSSetDatabaseInformation(Collection<SDatabaseInformation> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<DatabaseInformation> result = new HashSet<DatabaseInformation>();
		for (SDatabaseInformation o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SDatabaseInformation> convertToSListDatabaseInformation(Collection<DatabaseInformation> input) {
		List<SDatabaseInformation> result = new ArrayList<SDatabaseInformation>();
		for (DatabaseInformation o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<DatabaseInformation> convertFromSListDatabaseInformation(Collection<SDatabaseInformation> input, DatabaseSession session) throws BimserverDatabaseException {
		List<DatabaseInformation> result = new ArrayList<DatabaseInformation>();
		for (SDatabaseInformation o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SDatabaseInformation convertToSObject(DatabaseInformation input) {
		if (input == null) {
			return null;
		}
		
		SDatabaseInformation result = new SDatabaseInformation();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setNumberOfProjects(input.getNumberOfProjects());
		result.setNumberOfUsers(input.getNumberOfUsers());
		result.setNumberOfRevisions(input.getNumberOfRevisions());
		result.setNumberOfCheckouts(input.getNumberOfCheckouts());
		result.setDatabaseSizeInBytes(input.getDatabaseSizeInBytes());
		result.setType(input.getType());
		result.setCreated(input.getCreated());
		result.setLocation(input.getLocation());
		result.setSchemaVersion(input.getSchemaVersion());
		List<SDatabaseInformationCategory> listcategories = new ArrayList<SDatabaseInformationCategory>();
		for (DatabaseInformationCategory v : input.getCategories()) {
			listcategories.add(convertToSObject(v));
		}
		result.setCategories(listcategories);
		return result;
	}

	public DatabaseInformation convertFromSObject(SDatabaseInformation input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		DatabaseInformation result = convertFromSObject(input, (DatabaseInformation)session.create(StorePackage.eINSTANCE.getDatabaseInformation()), session);
		
		
		return result;
	}

	public DatabaseInformation convertFromSObject(SDatabaseInformation input) throws BimserverDatabaseException {
		DatabaseInformation result = convertFromSObject(input, StoreFactory.eINSTANCE.createDatabaseInformation(), null);
		return result;
	}

	public DatabaseInformation convertFromSObject(SDatabaseInformation input, DatabaseInformation result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setNumberOfProjects(input.getNumberOfProjects());
		result.setNumberOfUsers(input.getNumberOfUsers());
		result.setNumberOfRevisions(input.getNumberOfRevisions());
		result.setNumberOfCheckouts(input.getNumberOfCheckouts());
		result.setDatabaseSizeInBytes(input.getDatabaseSizeInBytes());
		result.setType(input.getType());
		result.setCreated(input.getCreated());
		result.setLocation(input.getLocation());
		result.setSchemaVersion(input.getSchemaVersion());
		List<DatabaseInformationCategory> listcategories = result.getCategories();
		for (SDatabaseInformationCategory v : input.getCategories()) {
			listcategories.add(convertFromSObject(v, session));
		}
		return result;
	}

	public Set<SPluginDescriptor> convertToSSetPluginDescriptor(Collection<PluginDescriptor> input) {
		Set<SPluginDescriptor> result = new HashSet<SPluginDescriptor>();
		for (PluginDescriptor o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<PluginDescriptor> convertFromSSetPluginDescriptor(Collection<SPluginDescriptor> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<PluginDescriptor> result = new HashSet<PluginDescriptor>();
		for (SPluginDescriptor o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SPluginDescriptor> convertToSListPluginDescriptor(Collection<PluginDescriptor> input) {
		List<SPluginDescriptor> result = new ArrayList<SPluginDescriptor>();
		for (PluginDescriptor o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<PluginDescriptor> convertFromSListPluginDescriptor(Collection<SPluginDescriptor> input, DatabaseSession session) throws BimserverDatabaseException {
		List<PluginDescriptor> result = new ArrayList<PluginDescriptor>();
		for (SPluginDescriptor o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SPluginDescriptor convertToSObject(PluginDescriptor input) {
		if (input == null) {
			return null;
		}
		
		SPluginDescriptor result = new SPluginDescriptor();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setName(input.getName());
		result.setPluginClassName(input.getPluginClassName());
		result.setDescription(input.getDescription());
		result.setLocation(input.getLocation());
		result.setEnabled(input.getEnabled());
		result.setPluginInterfaceClassName(input.getPluginInterfaceClassName());
		result.setIdentifier(input.getIdentifier());
		result.setInstallForNewUsers(input.isInstallForNewUsers());
		List<Long> listconfigurations = new ArrayList<Long>();
		for (PluginConfiguration v : input.getConfigurations()) {
			listconfigurations.add(v.getOid());
		}
		result.setConfigurations(listconfigurations);
		PluginBundleVersion pluginBundleVersionVal = input.getPluginBundleVersion();
		result.setPluginBundleVersionId(pluginBundleVersionVal == null ? -1 : pluginBundleVersionVal.getOid());
		ObjectType settingsVal = input.getSettings();
		result.setSettingsId(settingsVal == null ? -1 : settingsVal.getOid());
		return result;
	}

	public PluginDescriptor convertFromSObject(SPluginDescriptor input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		PluginDescriptor result = convertFromSObject(input, (PluginDescriptor)session.create(StorePackage.eINSTANCE.getPluginDescriptor()), session);
		
		
		return result;
	}

	public PluginDescriptor convertFromSObject(SPluginDescriptor input) throws BimserverDatabaseException {
		PluginDescriptor result = convertFromSObject(input, StoreFactory.eINSTANCE.createPluginDescriptor(), null);
		return result;
	}

	public PluginDescriptor convertFromSObject(SPluginDescriptor input, PluginDescriptor result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setName(input.getName());
		result.setPluginClassName(input.getPluginClassName());
		result.setDescription(input.getDescription());
		result.setLocation(input.getLocation());
		result.setEnabled(input.getEnabled());
		result.setPluginInterfaceClassName(input.getPluginInterfaceClassName());
		result.setIdentifier(input.getIdentifier());
		result.setInstallForNewUsers(input.isInstallForNewUsers());
		List<PluginConfiguration> listconfigurations = result.getConfigurations();
		for (long oid : input.getConfigurations()) {
			listconfigurations.add((PluginConfiguration)session.get(StorePackage.eINSTANCE.getPluginConfiguration(), oid, OldQuery.getDefault()));
		}
		result.setPluginBundleVersion((PluginBundleVersion)session.get(StorePackage.eINSTANCE.getPluginBundleVersion(), input.getPluginBundleVersionId(), OldQuery.getDefault()));
		result.setSettings((ObjectType)session.get(StorePackage.eINSTANCE.getObjectType(), input.getSettingsId(), OldQuery.getDefault()));
		return result;
	}

	public Set<SRevisionSummaryType> convertToSSetRevisionSummaryType(Collection<RevisionSummaryType> input) {
		Set<SRevisionSummaryType> result = new HashSet<SRevisionSummaryType>();
		for (RevisionSummaryType o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<RevisionSummaryType> convertFromSSetRevisionSummaryType(Collection<SRevisionSummaryType> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<RevisionSummaryType> result = new HashSet<RevisionSummaryType>();
		for (SRevisionSummaryType o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SRevisionSummaryType> convertToSListRevisionSummaryType(Collection<RevisionSummaryType> input) {
		List<SRevisionSummaryType> result = new ArrayList<SRevisionSummaryType>();
		for (RevisionSummaryType o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<RevisionSummaryType> convertFromSListRevisionSummaryType(Collection<SRevisionSummaryType> input, DatabaseSession session) throws BimserverDatabaseException {
		List<RevisionSummaryType> result = new ArrayList<RevisionSummaryType>();
		for (SRevisionSummaryType o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SRevisionSummaryType convertToSObject(RevisionSummaryType input) {
		if (input == null) {
			return null;
		}
		
		SRevisionSummaryType result = new SRevisionSummaryType();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setName(input.getName());
		result.setCount(input.getCount());
		result.setSchema(input.getSchema());
		return result;
	}

	public RevisionSummaryType convertFromSObject(SRevisionSummaryType input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		RevisionSummaryType result = convertFromSObject(input, (RevisionSummaryType)session.create(StorePackage.eINSTANCE.getRevisionSummaryType()), session);
		
		
		return result;
	}

	public RevisionSummaryType convertFromSObject(SRevisionSummaryType input) throws BimserverDatabaseException {
		RevisionSummaryType result = convertFromSObject(input, StoreFactory.eINSTANCE.createRevisionSummaryType(), null);
		return result;
	}

	public RevisionSummaryType convertFromSObject(SRevisionSummaryType input, RevisionSummaryType result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setName(input.getName());
		result.setCount(input.getCount());
		result.setSchema(input.getSchema());
		return result;
	}

	public Set<SRevisionSummaryContainer> convertToSSetRevisionSummaryContainer(Collection<RevisionSummaryContainer> input) {
		Set<SRevisionSummaryContainer> result = new HashSet<SRevisionSummaryContainer>();
		for (RevisionSummaryContainer o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<RevisionSummaryContainer> convertFromSSetRevisionSummaryContainer(Collection<SRevisionSummaryContainer> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<RevisionSummaryContainer> result = new HashSet<RevisionSummaryContainer>();
		for (SRevisionSummaryContainer o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SRevisionSummaryContainer> convertToSListRevisionSummaryContainer(Collection<RevisionSummaryContainer> input) {
		List<SRevisionSummaryContainer> result = new ArrayList<SRevisionSummaryContainer>();
		for (RevisionSummaryContainer o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<RevisionSummaryContainer> convertFromSListRevisionSummaryContainer(Collection<SRevisionSummaryContainer> input, DatabaseSession session) throws BimserverDatabaseException {
		List<RevisionSummaryContainer> result = new ArrayList<RevisionSummaryContainer>();
		for (SRevisionSummaryContainer o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SRevisionSummaryContainer convertToSObject(RevisionSummaryContainer input) {
		if (input == null) {
			return null;
		}
		
		SRevisionSummaryContainer result = new SRevisionSummaryContainer();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setName(input.getName());
		List<SRevisionSummaryType> listtypes = new ArrayList<SRevisionSummaryType>();
		for (RevisionSummaryType v : input.getTypes()) {
			listtypes.add(convertToSObject(v));
		}
		result.setTypes(listtypes);
		return result;
	}

	public RevisionSummaryContainer convertFromSObject(SRevisionSummaryContainer input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		RevisionSummaryContainer result = convertFromSObject(input, (RevisionSummaryContainer)session.create(StorePackage.eINSTANCE.getRevisionSummaryContainer()), session);
		
		
		return result;
	}

	public RevisionSummaryContainer convertFromSObject(SRevisionSummaryContainer input) throws BimserverDatabaseException {
		RevisionSummaryContainer result = convertFromSObject(input, StoreFactory.eINSTANCE.createRevisionSummaryContainer(), null);
		return result;
	}

	public RevisionSummaryContainer convertFromSObject(SRevisionSummaryContainer input, RevisionSummaryContainer result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setName(input.getName());
		List<RevisionSummaryType> listtypes = result.getTypes();
		for (SRevisionSummaryType v : input.getTypes()) {
			listtypes.add(convertFromSObject(v, session));
		}
		return result;
	}

	public Set<SRevisionSummary> convertToSSetRevisionSummary(Collection<RevisionSummary> input) {
		Set<SRevisionSummary> result = new HashSet<SRevisionSummary>();
		for (RevisionSummary o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<RevisionSummary> convertFromSSetRevisionSummary(Collection<SRevisionSummary> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<RevisionSummary> result = new HashSet<RevisionSummary>();
		for (SRevisionSummary o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SRevisionSummary> convertToSListRevisionSummary(Collection<RevisionSummary> input) {
		List<SRevisionSummary> result = new ArrayList<SRevisionSummary>();
		for (RevisionSummary o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<RevisionSummary> convertFromSListRevisionSummary(Collection<SRevisionSummary> input, DatabaseSession session) throws BimserverDatabaseException {
		List<RevisionSummary> result = new ArrayList<RevisionSummary>();
		for (SRevisionSummary o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SRevisionSummary convertToSObject(RevisionSummary input) {
		if (input == null) {
			return null;
		}
		
		SRevisionSummary result = new SRevisionSummary();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		List<SRevisionSummaryContainer> listlist = new ArrayList<SRevisionSummaryContainer>();
		for (RevisionSummaryContainer v : input.getList()) {
			listlist.add(convertToSObject(v));
		}
		result.setList(listlist);
		return result;
	}

	public RevisionSummary convertFromSObject(SRevisionSummary input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		RevisionSummary result = convertFromSObject(input, (RevisionSummary)session.create(StorePackage.eINSTANCE.getRevisionSummary()), session);
		
		
		return result;
	}

	public RevisionSummary convertFromSObject(SRevisionSummary input) throws BimserverDatabaseException {
		RevisionSummary result = convertFromSObject(input, StoreFactory.eINSTANCE.createRevisionSummary(), null);
		return result;
	}

	public RevisionSummary convertFromSObject(SRevisionSummary input, RevisionSummary result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		List<RevisionSummaryContainer> listlist = result.getList();
		for (SRevisionSummaryContainer v : input.getList()) {
			listlist.add(convertFromSObject(v, session));
		}
		return result;
	}

	public Set<SLongAction> convertToSSetLongAction(Collection<LongAction> input) {
		Set<SLongAction> result = new HashSet<SLongAction>();
		for (LongAction o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<LongAction> convertFromSSetLongAction(Collection<SLongAction> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<LongAction> result = new HashSet<LongAction>();
		for (SLongAction o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SLongAction> convertToSListLongAction(Collection<LongAction> input) {
		List<SLongAction> result = new ArrayList<SLongAction>();
		for (LongAction o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<LongAction> convertFromSListLongAction(Collection<SLongAction> input, DatabaseSession session) throws BimserverDatabaseException {
		List<LongAction> result = new ArrayList<LongAction>();
		for (SLongAction o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SLongAction convertToSObject(LongAction input) {
		if (input == null) {
			return null;
		}
		
		SLongAction result = new SLongAction();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setIdentification(input.getIdentification());
		result.setStart(input.getStart());
		result.setUsername(input.getUsername());
		result.setName(input.getName());
		User userVal = input.getUser();
		result.setUserId(userVal == null ? -1 : userVal.getOid());
		return result;
	}

	public LongAction convertFromSObject(SLongAction input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		LongAction result = convertFromSObject(input, (LongAction)session.create(StorePackage.eINSTANCE.getLongAction()), session);
		
		
		return result;
	}

	public LongAction convertFromSObject(SLongAction input) throws BimserverDatabaseException {
		LongAction result = convertFromSObject(input, StoreFactory.eINSTANCE.createLongAction(), null);
		return result;
	}

	public LongAction convertFromSObject(SLongAction input, LongAction result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setIdentification(input.getIdentification());
		result.setStart(input.getStart());
		result.setUsername(input.getUsername());
		result.setName(input.getName());
		result.setUser((User)session.get(StorePackage.eINSTANCE.getUser(), input.getUserId(), OldQuery.getDefault()));
		return result;
	}

	public Set<SObjectIDMPluginDescriptor> convertToSSetObjectIDMPluginDescriptor(Collection<ObjectIDMPluginDescriptor> input) {
		Set<SObjectIDMPluginDescriptor> result = new HashSet<SObjectIDMPluginDescriptor>();
		for (ObjectIDMPluginDescriptor o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ObjectIDMPluginDescriptor> convertFromSSetObjectIDMPluginDescriptor(Collection<SObjectIDMPluginDescriptor> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ObjectIDMPluginDescriptor> result = new HashSet<ObjectIDMPluginDescriptor>();
		for (SObjectIDMPluginDescriptor o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SObjectIDMPluginDescriptor> convertToSListObjectIDMPluginDescriptor(Collection<ObjectIDMPluginDescriptor> input) {
		List<SObjectIDMPluginDescriptor> result = new ArrayList<SObjectIDMPluginDescriptor>();
		for (ObjectIDMPluginDescriptor o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ObjectIDMPluginDescriptor> convertFromSListObjectIDMPluginDescriptor(Collection<SObjectIDMPluginDescriptor> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ObjectIDMPluginDescriptor> result = new ArrayList<ObjectIDMPluginDescriptor>();
		for (SObjectIDMPluginDescriptor o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SObjectIDMPluginDescriptor convertToSObject(ObjectIDMPluginDescriptor input) {
		if (input == null) {
			return null;
		}
		
		SObjectIDMPluginDescriptor result = new SObjectIDMPluginDescriptor();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setClassName(input.getClassName());
		return result;
	}

	public ObjectIDMPluginDescriptor convertFromSObject(SObjectIDMPluginDescriptor input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		ObjectIDMPluginDescriptor result = convertFromSObject(input, (ObjectIDMPluginDescriptor)session.create(StorePackage.eINSTANCE.getObjectIDMPluginDescriptor()), session);
		
		
		return result;
	}

	public ObjectIDMPluginDescriptor convertFromSObject(SObjectIDMPluginDescriptor input) throws BimserverDatabaseException {
		ObjectIDMPluginDescriptor result = convertFromSObject(input, StoreFactory.eINSTANCE.createObjectIDMPluginDescriptor(), null);
		return result;
	}

	public ObjectIDMPluginDescriptor convertFromSObject(SObjectIDMPluginDescriptor input, ObjectIDMPluginDescriptor result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setClassName(input.getClassName());
		return result;
	}
		public SCompareType convertToSObject(CompareType input) {
			return SCompareType.values()[input.ordinal()];
		}
		
		public CompareType convertFromSObject(SCompareType input) {
			return CompareType.values()[input.ordinal()];
		}

	public Set<SCompareItem> convertToSSetCompareItem(Collection<CompareItem> input) {
		Set<SCompareItem> result = new HashSet<SCompareItem>();
		for (CompareItem o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<CompareItem> convertFromSSetCompareItem(Collection<SCompareItem> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<CompareItem> result = new HashSet<CompareItem>();
		for (SCompareItem o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SCompareItem> convertToSListCompareItem(Collection<CompareItem> input) {
		List<SCompareItem> result = new ArrayList<SCompareItem>();
		for (CompareItem o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<CompareItem> convertFromSListCompareItem(Collection<SCompareItem> input, DatabaseSession session) throws BimserverDatabaseException {
		List<CompareItem> result = new ArrayList<CompareItem>();
		for (SCompareItem o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SCompareItem convertToSObject(CompareItem input) {
		if (input == null) {
			return null;
		}
		
		if (input instanceof ObjectAdded) {
			return convertToSObject((ObjectAdded)input);
		}
		else if (input instanceof ObjectModified) {
			return convertToSObject((ObjectModified)input);
		}
		else if (input instanceof ObjectRemoved) {
			return convertToSObject((ObjectRemoved)input);
		}
		SCompareItem result = new SCompareItem();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		DataObject dataObjectVal = input.getDataObject();
		result.setDataObject(convertToSObject(dataObjectVal));
		return result;
	}

	public CompareItem convertFromSObject(SCompareItem input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		CompareItem result = convertFromSObject(input, (CompareItem)session.create(StorePackage.eINSTANCE.getCompareItem()), session);
		
		
		return result;
	}

	public CompareItem convertFromSObject(SCompareItem input) throws BimserverDatabaseException {
		CompareItem result = convertFromSObject(input, StoreFactory.eINSTANCE.createCompareItem(), null);
		return result;
	}

	public CompareItem convertFromSObject(SCompareItem input, CompareItem result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		if (input instanceof SObjectAdded) {
			return convertFromSObject((SObjectAdded)input, session);
		}
		else if (input instanceof SObjectModified) {
			return convertFromSObject((SObjectModified)input, session);
		}
		else if (input instanceof SObjectRemoved) {
			return convertFromSObject((SObjectRemoved)input, session);
		}
		result.setDataObject(convertFromSObject(input.getDataObject(), session));
		return result;
	}

	public Set<SObjectAdded> convertToSSetObjectAdded(Collection<ObjectAdded> input) {
		Set<SObjectAdded> result = new HashSet<SObjectAdded>();
		for (ObjectAdded o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ObjectAdded> convertFromSSetObjectAdded(Collection<SObjectAdded> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ObjectAdded> result = new HashSet<ObjectAdded>();
		for (SObjectAdded o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SObjectAdded> convertToSListObjectAdded(Collection<ObjectAdded> input) {
		List<SObjectAdded> result = new ArrayList<SObjectAdded>();
		for (ObjectAdded o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ObjectAdded> convertFromSListObjectAdded(Collection<SObjectAdded> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ObjectAdded> result = new ArrayList<ObjectAdded>();
		for (SObjectAdded o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SObjectAdded convertToSObject(ObjectAdded input) {
		if (input == null) {
			return null;
		}
		
		SObjectAdded result = new SObjectAdded();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		DataObject dataObjectVal = input.getDataObject();
		result.setDataObject(convertToSObject(dataObjectVal));
		return result;
	}

	public ObjectAdded convertFromSObject(SObjectAdded input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		ObjectAdded result = convertFromSObject(input, (ObjectAdded)session.create(StorePackage.eINSTANCE.getObjectAdded()), session);
		
		
		return result;
	}

	public ObjectAdded convertFromSObject(SObjectAdded input) throws BimserverDatabaseException {
		ObjectAdded result = convertFromSObject(input, StoreFactory.eINSTANCE.createObjectAdded(), null);
		return result;
	}

	public ObjectAdded convertFromSObject(SObjectAdded input, ObjectAdded result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setDataObject(convertFromSObject(input.getDataObject(), session));
		return result;
	}

	public Set<SObjectRemoved> convertToSSetObjectRemoved(Collection<ObjectRemoved> input) {
		Set<SObjectRemoved> result = new HashSet<SObjectRemoved>();
		for (ObjectRemoved o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ObjectRemoved> convertFromSSetObjectRemoved(Collection<SObjectRemoved> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ObjectRemoved> result = new HashSet<ObjectRemoved>();
		for (SObjectRemoved o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SObjectRemoved> convertToSListObjectRemoved(Collection<ObjectRemoved> input) {
		List<SObjectRemoved> result = new ArrayList<SObjectRemoved>();
		for (ObjectRemoved o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ObjectRemoved> convertFromSListObjectRemoved(Collection<SObjectRemoved> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ObjectRemoved> result = new ArrayList<ObjectRemoved>();
		for (SObjectRemoved o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SObjectRemoved convertToSObject(ObjectRemoved input) {
		if (input == null) {
			return null;
		}
		
		SObjectRemoved result = new SObjectRemoved();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		DataObject dataObjectVal = input.getDataObject();
		result.setDataObject(convertToSObject(dataObjectVal));
		return result;
	}

	public ObjectRemoved convertFromSObject(SObjectRemoved input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		ObjectRemoved result = convertFromSObject(input, (ObjectRemoved)session.create(StorePackage.eINSTANCE.getObjectRemoved()), session);
		
		
		return result;
	}

	public ObjectRemoved convertFromSObject(SObjectRemoved input) throws BimserverDatabaseException {
		ObjectRemoved result = convertFromSObject(input, StoreFactory.eINSTANCE.createObjectRemoved(), null);
		return result;
	}

	public ObjectRemoved convertFromSObject(SObjectRemoved input, ObjectRemoved result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setDataObject(convertFromSObject(input.getDataObject(), session));
		return result;
	}

	public Set<SObjectModified> convertToSSetObjectModified(Collection<ObjectModified> input) {
		Set<SObjectModified> result = new HashSet<SObjectModified>();
		for (ObjectModified o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ObjectModified> convertFromSSetObjectModified(Collection<SObjectModified> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ObjectModified> result = new HashSet<ObjectModified>();
		for (SObjectModified o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SObjectModified> convertToSListObjectModified(Collection<ObjectModified> input) {
		List<SObjectModified> result = new ArrayList<SObjectModified>();
		for (ObjectModified o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ObjectModified> convertFromSListObjectModified(Collection<SObjectModified> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ObjectModified> result = new ArrayList<ObjectModified>();
		for (SObjectModified o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SObjectModified convertToSObject(ObjectModified input) {
		if (input == null) {
			return null;
		}
		
		SObjectModified result = new SObjectModified();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setFieldName(input.getFieldName());
		result.setOldValue(input.getOldValue());
		result.setNewValue(input.getNewValue());
		DataObject dataObjectVal = input.getDataObject();
		result.setDataObject(convertToSObject(dataObjectVal));
		return result;
	}

	public ObjectModified convertFromSObject(SObjectModified input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		ObjectModified result = convertFromSObject(input, (ObjectModified)session.create(StorePackage.eINSTANCE.getObjectModified()), session);
		
		
		return result;
	}

	public ObjectModified convertFromSObject(SObjectModified input) throws BimserverDatabaseException {
		ObjectModified result = convertFromSObject(input, StoreFactory.eINSTANCE.createObjectModified(), null);
		return result;
	}

	public ObjectModified convertFromSObject(SObjectModified input, ObjectModified result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setFieldName(input.getFieldName());
		result.setOldValue(input.getOldValue());
		result.setNewValue(input.getNewValue());
		result.setDataObject(convertFromSObject(input.getDataObject(), session));
		return result;
	}

	public Set<SCompareContainer> convertToSSetCompareContainer(Collection<CompareContainer> input) {
		Set<SCompareContainer> result = new HashSet<SCompareContainer>();
		for (CompareContainer o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<CompareContainer> convertFromSSetCompareContainer(Collection<SCompareContainer> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<CompareContainer> result = new HashSet<CompareContainer>();
		for (SCompareContainer o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SCompareContainer> convertToSListCompareContainer(Collection<CompareContainer> input) {
		List<SCompareContainer> result = new ArrayList<SCompareContainer>();
		for (CompareContainer o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<CompareContainer> convertFromSListCompareContainer(Collection<SCompareContainer> input, DatabaseSession session) throws BimserverDatabaseException {
		List<CompareContainer> result = new ArrayList<CompareContainer>();
		for (SCompareContainer o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SCompareContainer convertToSObject(CompareContainer input) {
		if (input == null) {
			return null;
		}
		
		SCompareContainer result = new SCompareContainer();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setType(input.getType());
		List<SCompareItem> listitems = new ArrayList<SCompareItem>();
		for (CompareItem v : input.getItems()) {
			listitems.add(convertToSObject(v));
		}
		result.setItems(listitems);
		return result;
	}

	public CompareContainer convertFromSObject(SCompareContainer input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		CompareContainer result = convertFromSObject(input, (CompareContainer)session.create(StorePackage.eINSTANCE.getCompareContainer()), session);
		
		
		return result;
	}

	public CompareContainer convertFromSObject(SCompareContainer input) throws BimserverDatabaseException {
		CompareContainer result = convertFromSObject(input, StoreFactory.eINSTANCE.createCompareContainer(), null);
		return result;
	}

	public CompareContainer convertFromSObject(SCompareContainer input, CompareContainer result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setType(input.getType());
		List<CompareItem> listitems = result.getItems();
		for (SCompareItem v : input.getItems()) {
			listitems.add(convertFromSObject(v, session));
		}
		return result;
	}

	public Set<SCompareResult> convertToSSetCompareResult(Collection<CompareResult> input) {
		Set<SCompareResult> result = new HashSet<SCompareResult>();
		for (CompareResult o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<CompareResult> convertFromSSetCompareResult(Collection<SCompareResult> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<CompareResult> result = new HashSet<CompareResult>();
		for (SCompareResult o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SCompareResult> convertToSListCompareResult(Collection<CompareResult> input) {
		List<SCompareResult> result = new ArrayList<SCompareResult>();
		for (CompareResult o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<CompareResult> convertFromSListCompareResult(Collection<SCompareResult> input, DatabaseSession session) throws BimserverDatabaseException {
		List<CompareResult> result = new ArrayList<CompareResult>();
		for (SCompareResult o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SCompareResult convertToSObject(CompareResult input) {
		if (input == null) {
			return null;
		}
		
		SCompareResult result = new SCompareResult();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		List<SCompareContainer> listitems = new ArrayList<SCompareContainer>();
		for (CompareContainer v : input.getItems()) {
			listitems.add(convertToSObject(v));
		}
		result.setItems(listitems);
		return result;
	}

	public CompareResult convertFromSObject(SCompareResult input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		CompareResult result = convertFromSObject(input, (CompareResult)session.create(StorePackage.eINSTANCE.getCompareResult()), session);
		
		
		return result;
	}

	public CompareResult convertFromSObject(SCompareResult input) throws BimserverDatabaseException {
		CompareResult result = convertFromSObject(input, StoreFactory.eINSTANCE.createCompareResult(), null);
		return result;
	}

	public CompareResult convertFromSObject(SCompareResult input, CompareResult result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		List<CompareContainer> listitems = result.getItems();
		for (SCompareContainer v : input.getItems()) {
			listitems.add(convertFromSObject(v, session));
		}
		return result;
	}
		public SActionState convertToSObject(ActionState input) {
			return SActionState.values()[input.ordinal()];
		}
		
		public ActionState convertFromSObject(SActionState input) {
			return ActionState.values()[input.ordinal()];
		}

	public Set<SLongActionState> convertToSSetLongActionState(Collection<LongActionState> input) {
		Set<SLongActionState> result = new HashSet<SLongActionState>();
		for (LongActionState o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<LongActionState> convertFromSSetLongActionState(Collection<SLongActionState> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<LongActionState> result = new HashSet<LongActionState>();
		for (SLongActionState o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SLongActionState> convertToSListLongActionState(Collection<LongActionState> input) {
		List<SLongActionState> result = new ArrayList<SLongActionState>();
		for (LongActionState o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<LongActionState> convertFromSListLongActionState(Collection<SLongActionState> input, DatabaseSession session) throws BimserverDatabaseException {
		List<LongActionState> result = new ArrayList<LongActionState>();
		for (SLongActionState o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SLongActionState convertToSObject(LongActionState input) {
		if (input == null) {
			return null;
		}
		
		if (input instanceof LongCheckinActionState) {
			return convertToSObject((LongCheckinActionState)input);
		}
		SLongActionState result = new SLongActionState();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setStart(input.getStart());
		result.setEnd(input.getEnd());
		result.setProgress(input.getProgress());
		result.setState(SActionState.values()[input.getState().ordinal()]);
		result.setTitle(input.getTitle());
		result.setStage(input.getStage());
		result.getErrors().addAll(input.getErrors());
		result.getWarnings().addAll(input.getWarnings());
		result.getInfos().addAll(input.getInfos());
		result.setTopicId(input.getTopicId());
		return result;
	}

	public LongActionState convertFromSObject(SLongActionState input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		LongActionState result = convertFromSObject(input, (LongActionState)session.create(StorePackage.eINSTANCE.getLongActionState()), session);
		
		
		return result;
	}

	public LongActionState convertFromSObject(SLongActionState input) throws BimserverDatabaseException {
		LongActionState result = convertFromSObject(input, StoreFactory.eINSTANCE.createLongActionState(), null);
		return result;
	}

	public LongActionState convertFromSObject(SLongActionState input, LongActionState result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		if (input instanceof SLongCheckinActionState) {
			return convertFromSObject((SLongCheckinActionState)input, session);
		}
		result.setStart(input.getStart());
		result.setEnd(input.getEnd());
		result.setProgress(input.getProgress());
		result.setState(ActionState.values()[input.getState().ordinal()]);
		result.setTitle(input.getTitle());
		result.setStage(input.getStage());
		result.getErrors().addAll(input.getErrors());
		result.getWarnings().addAll(input.getWarnings());
		result.getInfos().addAll(input.getInfos());
		result.setTopicId(input.getTopicId());
		return result;
	}
		public SServerState convertToSObject(ServerState input) {
			return SServerState.values()[input.ordinal()];
		}
		
		public ServerState convertFromSObject(SServerState input) {
			return ServerState.values()[input.ordinal()];
		}

	public Set<SServerInfo> convertToSSetServerInfo(Collection<ServerInfo> input) {
		Set<SServerInfo> result = new HashSet<SServerInfo>();
		for (ServerInfo o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ServerInfo> convertFromSSetServerInfo(Collection<SServerInfo> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ServerInfo> result = new HashSet<ServerInfo>();
		for (SServerInfo o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SServerInfo> convertToSListServerInfo(Collection<ServerInfo> input) {
		List<SServerInfo> result = new ArrayList<SServerInfo>();
		for (ServerInfo o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ServerInfo> convertFromSListServerInfo(Collection<SServerInfo> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ServerInfo> result = new ArrayList<ServerInfo>();
		for (SServerInfo o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SServerInfo convertToSObject(ServerInfo input) {
		if (input == null) {
			return null;
		}
		
		SServerInfo result = new SServerInfo();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setServerState(SServerState.values()[input.getServerState().ordinal()]);
		result.setErrorMessage(input.getErrorMessage());
		Version versionVal = input.getVersion();
		result.setVersion(convertToSObject(versionVal));
		return result;
	}

	public ServerInfo convertFromSObject(SServerInfo input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		ServerInfo result = convertFromSObject(input, (ServerInfo)session.create(StorePackage.eINSTANCE.getServerInfo()), session);
		
		
		return result;
	}

	public ServerInfo convertFromSObject(SServerInfo input) throws BimserverDatabaseException {
		ServerInfo result = convertFromSObject(input, StoreFactory.eINSTANCE.createServerInfo(), null);
		return result;
	}

	public ServerInfo convertFromSObject(SServerInfo input, ServerInfo result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setServerState(ServerState.values()[input.getServerState().ordinal()]);
		result.setErrorMessage(input.getErrorMessage());
		result.setVersion(convertFromSObject(input.getVersion(), session));
		return result;
	}

	public Set<SVersion> convertToSSetVersion(Collection<Version> input) {
		Set<SVersion> result = new HashSet<SVersion>();
		for (Version o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<Version> convertFromSSetVersion(Collection<SVersion> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<Version> result = new HashSet<Version>();
		for (SVersion o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SVersion> convertToSListVersion(Collection<Version> input) {
		List<SVersion> result = new ArrayList<SVersion>();
		for (Version o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<Version> convertFromSListVersion(Collection<SVersion> input, DatabaseSession session) throws BimserverDatabaseException {
		List<Version> result = new ArrayList<Version>();
		for (SVersion o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SVersion convertToSObject(Version input) {
		if (input == null) {
			return null;
		}
		
		SVersion result = new SVersion();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setMajor(input.getMajor());
		result.setMinor(input.getMinor());
		result.setRevision(input.getRevision());
		result.setFullString(input.getFullString());
		result.setDate(input.getDate());
		result.setDownloadUrl(input.getDownloadUrl());
		result.setSupportUrl(input.getSupportUrl());
		result.setSupportEmail(input.getSupportEmail());
		return result;
	}

	public Version convertFromSObject(SVersion input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		Version result = convertFromSObject(input, (Version)session.create(StorePackage.eINSTANCE.getVersion()), session);
		
		
		return result;
	}

	public Version convertFromSObject(SVersion input) throws BimserverDatabaseException {
		Version result = convertFromSObject(input, StoreFactory.eINSTANCE.createVersion(), null);
		return result;
	}

	public Version convertFromSObject(SVersion input, Version result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setMajor(input.getMajor());
		result.setMinor(input.getMinor());
		result.setRevision(input.getRevision());
		result.setFullString(input.getFullString());
		result.setDate(input.getDate());
		result.setDownloadUrl(input.getDownloadUrl());
		result.setSupportUrl(input.getSupportUrl());
		result.setSupportEmail(input.getSupportEmail());
		return result;
	}

	public Set<SFile> convertToSSetFile(Collection<File> input) {
		Set<SFile> result = new HashSet<SFile>();
		for (File o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<File> convertFromSSetFile(Collection<SFile> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<File> result = new HashSet<File>();
		for (SFile o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SFile> convertToSListFile(Collection<File> input) {
		List<SFile> result = new ArrayList<SFile>();
		for (File o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<File> convertFromSListFile(Collection<SFile> input, DatabaseSession session) throws BimserverDatabaseException {
		List<File> result = new ArrayList<File>();
		for (SFile o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SFile convertToSObject(File input) {
		if (input == null) {
			return null;
		}
		
		SFile result = new SFile();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setData(input.getData());
		result.setFilename(input.getFilename());
		result.setMime(input.getMime());
		result.setSize(input.getSize());
		return result;
	}

	public File convertFromSObject(SFile input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		File result = convertFromSObject(input, (File)session.create(StorePackage.eINSTANCE.getFile()), session);
		
		
		return result;
	}

	public File convertFromSObject(SFile input) throws BimserverDatabaseException {
		File result = convertFromSObject(input, StoreFactory.eINSTANCE.createFile(), null);
		return result;
	}

	public File convertFromSObject(SFile input, File result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setData(input.getData());
		result.setFilename(input.getFilename());
		result.setMime(input.getMime());
		result.setSize(input.getSize());
		return result;
	}

	public Set<SExtendedDataSchema> convertToSSetExtendedDataSchema(Collection<ExtendedDataSchema> input) {
		Set<SExtendedDataSchema> result = new HashSet<SExtendedDataSchema>();
		for (ExtendedDataSchema o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ExtendedDataSchema> convertFromSSetExtendedDataSchema(Collection<SExtendedDataSchema> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ExtendedDataSchema> result = new HashSet<ExtendedDataSchema>();
		for (SExtendedDataSchema o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SExtendedDataSchema> convertToSListExtendedDataSchema(Collection<ExtendedDataSchema> input) {
		List<SExtendedDataSchema> result = new ArrayList<SExtendedDataSchema>();
		for (ExtendedDataSchema o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ExtendedDataSchema> convertFromSListExtendedDataSchema(Collection<SExtendedDataSchema> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ExtendedDataSchema> result = new ArrayList<ExtendedDataSchema>();
		for (SExtendedDataSchema o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SExtendedDataSchema convertToSObject(ExtendedDataSchema input) {
		if (input == null) {
			return null;
		}
		
		SExtendedDataSchema result = new SExtendedDataSchema();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setName(input.getName());
		result.setUrl(input.getUrl());
		result.setContentType(input.getContentType());
		result.setDescription(input.getDescription());
		result.setSize(input.getSize());
		File fileVal = input.getFile();
		result.setFileId(fileVal == null ? -1 : fileVal.getOid());
		List<Long> listusers = new ArrayList<Long>();
		for (User v : input.getUsers()) {
			listusers.add(v.getOid());
		}
		result.setUsers(listusers);
		List<Long> listextendedData = new ArrayList<Long>();
		for (ExtendedData v : input.getExtendedData()) {
			listextendedData.add(v.getOid());
		}
		result.setExtendedData(listextendedData);
		return result;
	}

	public ExtendedDataSchema convertFromSObject(SExtendedDataSchema input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		ExtendedDataSchema result = convertFromSObject(input, (ExtendedDataSchema)session.create(StorePackage.eINSTANCE.getExtendedDataSchema()), session);
		
		
		return result;
	}

	public ExtendedDataSchema convertFromSObject(SExtendedDataSchema input) throws BimserverDatabaseException {
		ExtendedDataSchema result = convertFromSObject(input, StoreFactory.eINSTANCE.createExtendedDataSchema(), null);
		return result;
	}

	public ExtendedDataSchema convertFromSObject(SExtendedDataSchema input, ExtendedDataSchema result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setName(input.getName());
		result.setUrl(input.getUrl());
		result.setContentType(input.getContentType());
		result.setDescription(input.getDescription());
		result.setSize(input.getSize());
		result.setFile((File)session.get(StorePackage.eINSTANCE.getFile(), input.getFileId(), OldQuery.getDefault()));
		List<User> listusers = result.getUsers();
		for (long oid : input.getUsers()) {
			listusers.add((User)session.get(StorePackage.eINSTANCE.getUser(), oid, OldQuery.getDefault()));
		}
		List<ExtendedData> listextendedData = result.getExtendedData();
		for (long oid : input.getExtendedData()) {
			listextendedData.add((ExtendedData)session.get(StorePackage.eINSTANCE.getExtendedData(), oid, OldQuery.getDefault()));
		}
		return result;
	}

	public Set<SExtendedData> convertToSSetExtendedData(Collection<ExtendedData> input) {
		Set<SExtendedData> result = new HashSet<SExtendedData>();
		for (ExtendedData o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ExtendedData> convertFromSSetExtendedData(Collection<SExtendedData> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ExtendedData> result = new HashSet<ExtendedData>();
		for (SExtendedData o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SExtendedData> convertToSListExtendedData(Collection<ExtendedData> input) {
		List<SExtendedData> result = new ArrayList<SExtendedData>();
		for (ExtendedData o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ExtendedData> convertFromSListExtendedData(Collection<SExtendedData> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ExtendedData> result = new ArrayList<ExtendedData>();
		for (SExtendedData o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SExtendedData convertToSObject(ExtendedData input) {
		if (input == null) {
			return null;
		}
		
		SExtendedData result = new SExtendedData();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setUrl(input.getUrl());
		result.setSize(input.getSize());
		result.setTitle(input.getTitle());
		result.setAdded(input.getAdded());
		result.setTimeToGenerate(input.getTimeToGenerate());
		File fileVal = input.getFile();
		result.setFileId(fileVal == null ? -1 : fileVal.getOid());
		User userVal = input.getUser();
		result.setUserId(userVal == null ? -1 : userVal.getOid());
		ExtendedDataSchema schemaVal = input.getSchema();
		result.setSchemaId(schemaVal == null ? -1 : schemaVal.getOid());
		Revision revisionVal = input.getRevision();
		result.setRevisionId(revisionVal == null ? -1 : revisionVal.getOid());
		Project projectVal = input.getProject();
		result.setProjectId(projectVal == null ? -1 : projectVal.getOid());
		return result;
	}

	public ExtendedData convertFromSObject(SExtendedData input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		ExtendedData result = convertFromSObject(input, (ExtendedData)session.create(StorePackage.eINSTANCE.getExtendedData()), session);
		
		
		return result;
	}

	public ExtendedData convertFromSObject(SExtendedData input) throws BimserverDatabaseException {
		ExtendedData result = convertFromSObject(input, StoreFactory.eINSTANCE.createExtendedData(), null);
		return result;
	}

	public ExtendedData convertFromSObject(SExtendedData input, ExtendedData result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setUrl(input.getUrl());
		result.setSize(input.getSize());
		result.setTitle(input.getTitle());
		result.setAdded(input.getAdded());
		result.setTimeToGenerate(input.getTimeToGenerate());
		result.setFile((File)session.get(StorePackage.eINSTANCE.getFile(), input.getFileId(), OldQuery.getDefault()));
		result.setUser((User)session.get(StorePackage.eINSTANCE.getUser(), input.getUserId(), OldQuery.getDefault()));
		result.setSchema((ExtendedDataSchema)session.get(StorePackage.eINSTANCE.getExtendedDataSchema(), input.getSchemaId(), OldQuery.getDefault()));
		result.setRevision((Revision)session.get(StorePackage.eINSTANCE.getRevision(), input.getRevisionId(), OldQuery.getDefault()));
		result.setProject((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getProjectId(), OldQuery.getDefault()));
		return result;
	}

	public Set<SQueryEnginePluginConfiguration> convertToSSetQueryEnginePluginConfiguration(Collection<QueryEnginePluginConfiguration> input) {
		Set<SQueryEnginePluginConfiguration> result = new HashSet<SQueryEnginePluginConfiguration>();
		for (QueryEnginePluginConfiguration o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<QueryEnginePluginConfiguration> convertFromSSetQueryEnginePluginConfiguration(Collection<SQueryEnginePluginConfiguration> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<QueryEnginePluginConfiguration> result = new HashSet<QueryEnginePluginConfiguration>();
		for (SQueryEnginePluginConfiguration o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SQueryEnginePluginConfiguration> convertToSListQueryEnginePluginConfiguration(Collection<QueryEnginePluginConfiguration> input) {
		List<SQueryEnginePluginConfiguration> result = new ArrayList<SQueryEnginePluginConfiguration>();
		for (QueryEnginePluginConfiguration o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<QueryEnginePluginConfiguration> convertFromSListQueryEnginePluginConfiguration(Collection<SQueryEnginePluginConfiguration> input, DatabaseSession session) throws BimserverDatabaseException {
		List<QueryEnginePluginConfiguration> result = new ArrayList<QueryEnginePluginConfiguration>();
		for (SQueryEnginePluginConfiguration o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SQueryEnginePluginConfiguration convertToSObject(QueryEnginePluginConfiguration input) {
		if (input == null) {
			return null;
		}
		
		SQueryEnginePluginConfiguration result = new SQueryEnginePluginConfiguration();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setName(input.getName());
		result.setEnabled(input.getEnabled());
		result.setDescription(input.getDescription());
		PluginDescriptor pluginDescriptorVal = input.getPluginDescriptor();
		result.setPluginDescriptorId(pluginDescriptorVal == null ? -1 : pluginDescriptorVal.getOid());
		ObjectType settingsVal = input.getSettings();
		result.setSettingsId(settingsVal == null ? -1 : settingsVal.getOid());
		UserSettings userSettingsVal = input.getUserSettings();
		result.setUserSettingsId(userSettingsVal == null ? -1 : userSettingsVal.getOid());
		return result;
	}

	public QueryEnginePluginConfiguration convertFromSObject(SQueryEnginePluginConfiguration input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		QueryEnginePluginConfiguration result = convertFromSObject(input, (QueryEnginePluginConfiguration)session.create(StorePackage.eINSTANCE.getQueryEnginePluginConfiguration()), session);
		
		
		return result;
	}

	public QueryEnginePluginConfiguration convertFromSObject(SQueryEnginePluginConfiguration input) throws BimserverDatabaseException {
		QueryEnginePluginConfiguration result = convertFromSObject(input, StoreFactory.eINSTANCE.createQueryEnginePluginConfiguration(), null);
		return result;
	}

	public QueryEnginePluginConfiguration convertFromSObject(SQueryEnginePluginConfiguration input, QueryEnginePluginConfiguration result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setName(input.getName());
		result.setEnabled(input.getEnabled());
		result.setDescription(input.getDescription());
		result.setPluginDescriptor((PluginDescriptor)session.get(StorePackage.eINSTANCE.getPluginDescriptor(), input.getPluginDescriptorId(), OldQuery.getDefault()));
		result.setSettings((ObjectType)session.get(StorePackage.eINSTANCE.getObjectType(), input.getSettingsId(), OldQuery.getDefault()));
		result.setUserSettings((UserSettings)session.get(StorePackage.eINSTANCE.getUserSettings(), input.getUserSettingsId(), OldQuery.getDefault()));
		return result;
	}

	public Set<SWebModulePluginConfiguration> convertToSSetWebModulePluginConfiguration(Collection<WebModulePluginConfiguration> input) {
		Set<SWebModulePluginConfiguration> result = new HashSet<SWebModulePluginConfiguration>();
		for (WebModulePluginConfiguration o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<WebModulePluginConfiguration> convertFromSSetWebModulePluginConfiguration(Collection<SWebModulePluginConfiguration> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<WebModulePluginConfiguration> result = new HashSet<WebModulePluginConfiguration>();
		for (SWebModulePluginConfiguration o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SWebModulePluginConfiguration> convertToSListWebModulePluginConfiguration(Collection<WebModulePluginConfiguration> input) {
		List<SWebModulePluginConfiguration> result = new ArrayList<SWebModulePluginConfiguration>();
		for (WebModulePluginConfiguration o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<WebModulePluginConfiguration> convertFromSListWebModulePluginConfiguration(Collection<SWebModulePluginConfiguration> input, DatabaseSession session) throws BimserverDatabaseException {
		List<WebModulePluginConfiguration> result = new ArrayList<WebModulePluginConfiguration>();
		for (SWebModulePluginConfiguration o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SWebModulePluginConfiguration convertToSObject(WebModulePluginConfiguration input) {
		if (input == null) {
			return null;
		}
		
		SWebModulePluginConfiguration result = new SWebModulePluginConfiguration();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setName(input.getName());
		result.setEnabled(input.getEnabled());
		result.setDescription(input.getDescription());
		PluginDescriptor pluginDescriptorVal = input.getPluginDescriptor();
		result.setPluginDescriptorId(pluginDescriptorVal == null ? -1 : pluginDescriptorVal.getOid());
		ObjectType settingsVal = input.getSettings();
		result.setSettingsId(settingsVal == null ? -1 : settingsVal.getOid());
		ServerSettings serverSettingsVal = input.getServerSettings();
		result.setServerSettingsId(serverSettingsVal == null ? -1 : serverSettingsVal.getOid());
		return result;
	}

	public WebModulePluginConfiguration convertFromSObject(SWebModulePluginConfiguration input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		WebModulePluginConfiguration result = convertFromSObject(input, (WebModulePluginConfiguration)session.create(StorePackage.eINSTANCE.getWebModulePluginConfiguration()), session);
		
		
		return result;
	}

	public WebModulePluginConfiguration convertFromSObject(SWebModulePluginConfiguration input) throws BimserverDatabaseException {
		WebModulePluginConfiguration result = convertFromSObject(input, StoreFactory.eINSTANCE.createWebModulePluginConfiguration(), null);
		return result;
	}

	public WebModulePluginConfiguration convertFromSObject(SWebModulePluginConfiguration input, WebModulePluginConfiguration result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setName(input.getName());
		result.setEnabled(input.getEnabled());
		result.setDescription(input.getDescription());
		result.setPluginDescriptor((PluginDescriptor)session.get(StorePackage.eINSTANCE.getPluginDescriptor(), input.getPluginDescriptorId(), OldQuery.getDefault()));
		result.setSettings((ObjectType)session.get(StorePackage.eINSTANCE.getObjectType(), input.getSettingsId(), OldQuery.getDefault()));
		result.setServerSettings((ServerSettings)session.get(StorePackage.eINSTANCE.getServerSettings(), input.getServerSettingsId(), OldQuery.getDefault()));
		return result;
	}

	public Set<SModelMergerPluginConfiguration> convertToSSetModelMergerPluginConfiguration(Collection<ModelMergerPluginConfiguration> input) {
		Set<SModelMergerPluginConfiguration> result = new HashSet<SModelMergerPluginConfiguration>();
		for (ModelMergerPluginConfiguration o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ModelMergerPluginConfiguration> convertFromSSetModelMergerPluginConfiguration(Collection<SModelMergerPluginConfiguration> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ModelMergerPluginConfiguration> result = new HashSet<ModelMergerPluginConfiguration>();
		for (SModelMergerPluginConfiguration o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SModelMergerPluginConfiguration> convertToSListModelMergerPluginConfiguration(Collection<ModelMergerPluginConfiguration> input) {
		List<SModelMergerPluginConfiguration> result = new ArrayList<SModelMergerPluginConfiguration>();
		for (ModelMergerPluginConfiguration o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ModelMergerPluginConfiguration> convertFromSListModelMergerPluginConfiguration(Collection<SModelMergerPluginConfiguration> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ModelMergerPluginConfiguration> result = new ArrayList<ModelMergerPluginConfiguration>();
		for (SModelMergerPluginConfiguration o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SModelMergerPluginConfiguration convertToSObject(ModelMergerPluginConfiguration input) {
		if (input == null) {
			return null;
		}
		
		SModelMergerPluginConfiguration result = new SModelMergerPluginConfiguration();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setName(input.getName());
		result.setEnabled(input.getEnabled());
		result.setDescription(input.getDescription());
		PluginDescriptor pluginDescriptorVal = input.getPluginDescriptor();
		result.setPluginDescriptorId(pluginDescriptorVal == null ? -1 : pluginDescriptorVal.getOid());
		ObjectType settingsVal = input.getSettings();
		result.setSettingsId(settingsVal == null ? -1 : settingsVal.getOid());
		UserSettings userSettingsVal = input.getUserSettings();
		result.setUserSettingsId(userSettingsVal == null ? -1 : userSettingsVal.getOid());
		return result;
	}

	public ModelMergerPluginConfiguration convertFromSObject(SModelMergerPluginConfiguration input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		ModelMergerPluginConfiguration result = convertFromSObject(input, (ModelMergerPluginConfiguration)session.create(StorePackage.eINSTANCE.getModelMergerPluginConfiguration()), session);
		
		
		return result;
	}

	public ModelMergerPluginConfiguration convertFromSObject(SModelMergerPluginConfiguration input) throws BimserverDatabaseException {
		ModelMergerPluginConfiguration result = convertFromSObject(input, StoreFactory.eINSTANCE.createModelMergerPluginConfiguration(), null);
		return result;
	}

	public ModelMergerPluginConfiguration convertFromSObject(SModelMergerPluginConfiguration input, ModelMergerPluginConfiguration result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setName(input.getName());
		result.setEnabled(input.getEnabled());
		result.setDescription(input.getDescription());
		result.setPluginDescriptor((PluginDescriptor)session.get(StorePackage.eINSTANCE.getPluginDescriptor(), input.getPluginDescriptorId(), OldQuery.getDefault()));
		result.setSettings((ObjectType)session.get(StorePackage.eINSTANCE.getObjectType(), input.getSettingsId(), OldQuery.getDefault()));
		result.setUserSettings((UserSettings)session.get(StorePackage.eINSTANCE.getUserSettings(), input.getUserSettingsId(), OldQuery.getDefault()));
		return result;
	}

	public Set<SModelComparePluginConfiguration> convertToSSetModelComparePluginConfiguration(Collection<ModelComparePluginConfiguration> input) {
		Set<SModelComparePluginConfiguration> result = new HashSet<SModelComparePluginConfiguration>();
		for (ModelComparePluginConfiguration o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ModelComparePluginConfiguration> convertFromSSetModelComparePluginConfiguration(Collection<SModelComparePluginConfiguration> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ModelComparePluginConfiguration> result = new HashSet<ModelComparePluginConfiguration>();
		for (SModelComparePluginConfiguration o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SModelComparePluginConfiguration> convertToSListModelComparePluginConfiguration(Collection<ModelComparePluginConfiguration> input) {
		List<SModelComparePluginConfiguration> result = new ArrayList<SModelComparePluginConfiguration>();
		for (ModelComparePluginConfiguration o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ModelComparePluginConfiguration> convertFromSListModelComparePluginConfiguration(Collection<SModelComparePluginConfiguration> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ModelComparePluginConfiguration> result = new ArrayList<ModelComparePluginConfiguration>();
		for (SModelComparePluginConfiguration o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SModelComparePluginConfiguration convertToSObject(ModelComparePluginConfiguration input) {
		if (input == null) {
			return null;
		}
		
		SModelComparePluginConfiguration result = new SModelComparePluginConfiguration();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setName(input.getName());
		result.setEnabled(input.getEnabled());
		result.setDescription(input.getDescription());
		PluginDescriptor pluginDescriptorVal = input.getPluginDescriptor();
		result.setPluginDescriptorId(pluginDescriptorVal == null ? -1 : pluginDescriptorVal.getOid());
		ObjectType settingsVal = input.getSettings();
		result.setSettingsId(settingsVal == null ? -1 : settingsVal.getOid());
		UserSettings userSettingsVal = input.getUserSettings();
		result.setUserSettingsId(userSettingsVal == null ? -1 : userSettingsVal.getOid());
		return result;
	}

	public ModelComparePluginConfiguration convertFromSObject(SModelComparePluginConfiguration input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		ModelComparePluginConfiguration result = convertFromSObject(input, (ModelComparePluginConfiguration)session.create(StorePackage.eINSTANCE.getModelComparePluginConfiguration()), session);
		
		
		return result;
	}

	public ModelComparePluginConfiguration convertFromSObject(SModelComparePluginConfiguration input) throws BimserverDatabaseException {
		ModelComparePluginConfiguration result = convertFromSObject(input, StoreFactory.eINSTANCE.createModelComparePluginConfiguration(), null);
		return result;
	}

	public ModelComparePluginConfiguration convertFromSObject(SModelComparePluginConfiguration input, ModelComparePluginConfiguration result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setName(input.getName());
		result.setEnabled(input.getEnabled());
		result.setDescription(input.getDescription());
		result.setPluginDescriptor((PluginDescriptor)session.get(StorePackage.eINSTANCE.getPluginDescriptor(), input.getPluginDescriptorId(), OldQuery.getDefault()));
		result.setSettings((ObjectType)session.get(StorePackage.eINSTANCE.getObjectType(), input.getSettingsId(), OldQuery.getDefault()));
		result.setUserSettings((UserSettings)session.get(StorePackage.eINSTANCE.getUserSettings(), input.getUserSettingsId(), OldQuery.getDefault()));
		return result;
	}
		public STrigger convertToSObject(Trigger input) {
			return STrigger.values()[input.ordinal()];
		}
		
		public Trigger convertFromSObject(STrigger input) {
			return Trigger.values()[input.ordinal()];
		}

	public Set<SProfileDescriptor> convertToSSetProfileDescriptor(Collection<ProfileDescriptor> input) {
		Set<SProfileDescriptor> result = new HashSet<SProfileDescriptor>();
		for (ProfileDescriptor o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ProfileDescriptor> convertFromSSetProfileDescriptor(Collection<SProfileDescriptor> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ProfileDescriptor> result = new HashSet<ProfileDescriptor>();
		for (SProfileDescriptor o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SProfileDescriptor> convertToSListProfileDescriptor(Collection<ProfileDescriptor> input) {
		List<SProfileDescriptor> result = new ArrayList<SProfileDescriptor>();
		for (ProfileDescriptor o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ProfileDescriptor> convertFromSListProfileDescriptor(Collection<SProfileDescriptor> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ProfileDescriptor> result = new ArrayList<ProfileDescriptor>();
		for (SProfileDescriptor o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SProfileDescriptor convertToSObject(ProfileDescriptor input) {
		if (input == null) {
			return null;
		}
		
		SProfileDescriptor result = new SProfileDescriptor();
		result.setName(input.getName());
		result.setDescription(input.getDescription());
		result.setPublicProfile(input.isPublicProfile());
		result.setIdentifier(input.getIdentifier());
		return result;
	}

	public ProfileDescriptor convertFromSObject(SProfileDescriptor input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		ProfileDescriptor result = convertFromSObject(input, (ProfileDescriptor)session.create(StorePackage.eINSTANCE.getProfileDescriptor()), session);
		
		return result;
	}

	public ProfileDescriptor convertFromSObject(SProfileDescriptor input) throws BimserverDatabaseException {
		ProfileDescriptor result = convertFromSObject(input, StoreFactory.eINSTANCE.createProfileDescriptor(), null);
		return result;
	}

	public ProfileDescriptor convertFromSObject(SProfileDescriptor input, ProfileDescriptor result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setName(input.getName());
		result.setDescription(input.getDescription());
		result.setPublicProfile(input.isPublicProfile());
		result.setIdentifier(input.getIdentifier());
		return result;
	}

	public Set<SServiceDescriptor> convertToSSetServiceDescriptor(Collection<ServiceDescriptor> input) {
		Set<SServiceDescriptor> result = new HashSet<SServiceDescriptor>();
		for (ServiceDescriptor o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ServiceDescriptor> convertFromSSetServiceDescriptor(Collection<SServiceDescriptor> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ServiceDescriptor> result = new HashSet<ServiceDescriptor>();
		for (SServiceDescriptor o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SServiceDescriptor> convertToSListServiceDescriptor(Collection<ServiceDescriptor> input) {
		List<SServiceDescriptor> result = new ArrayList<SServiceDescriptor>();
		for (ServiceDescriptor o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ServiceDescriptor> convertFromSListServiceDescriptor(Collection<SServiceDescriptor> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ServiceDescriptor> result = new ArrayList<ServiceDescriptor>();
		for (SServiceDescriptor o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SServiceDescriptor convertToSObject(ServiceDescriptor input) {
		if (input == null) {
			return null;
		}
		
		SServiceDescriptor result = new SServiceDescriptor();
		result.setName(input.getName());
		result.setUrl(input.getUrl());
		result.setToken(input.getToken());
		result.setIdentifier(input.getIdentifier());
		result.setNotificationProtocol(SAccessMethod.values()[input.getNotificationProtocol().ordinal()]);
		result.setDescription(input.getDescription());
		result.setTrigger(STrigger.values()[input.getTrigger().ordinal()]);
		result.setReadRevision(input.isReadRevision());
		result.setReadExtendedData(input.getReadExtendedData());
		result.setWriteRevision(input.isWriteRevision());
		result.setWriteExtendedData(input.getWriteExtendedData());
		result.setProviderName(input.getProviderName());
		result.setCompanyUrl(input.getCompanyUrl());
		result.setTokenUrl(input.getTokenUrl());
		result.setNewProfileUrl(input.getNewProfileUrl());
		result.setRegisterUrl(input.getRegisterUrl());
		result.setAuthorizeUrl(input.getAuthorizeUrl());
		return result;
	}

	public ServiceDescriptor convertFromSObject(SServiceDescriptor input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		ServiceDescriptor result = convertFromSObject(input, (ServiceDescriptor)session.create(StorePackage.eINSTANCE.getServiceDescriptor()), session);
		
		return result;
	}

	public ServiceDescriptor convertFromSObject(SServiceDescriptor input) throws BimserverDatabaseException {
		ServiceDescriptor result = convertFromSObject(input, StoreFactory.eINSTANCE.createServiceDescriptor(), null);
		return result;
	}

	public ServiceDescriptor convertFromSObject(SServiceDescriptor input, ServiceDescriptor result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setName(input.getName());
		result.setUrl(input.getUrl());
		result.setToken(input.getToken());
		result.setIdentifier(input.getIdentifier());
		result.setNotificationProtocol(AccessMethod.values()[input.getNotificationProtocol().ordinal()]);
		result.setDescription(input.getDescription());
		result.setTrigger(Trigger.values()[input.getTrigger().ordinal()]);
		result.setReadRevision(input.isReadRevision());
		result.setReadExtendedData(input.getReadExtendedData());
		result.setWriteRevision(input.isWriteRevision());
		result.setWriteExtendedData(input.getWriteExtendedData());
		result.setProviderName(input.getProviderName());
		result.setCompanyUrl(input.getCompanyUrl());
		result.setTokenUrl(input.getTokenUrl());
		result.setNewProfileUrl(input.getNewProfileUrl());
		result.setRegisterUrl(input.getRegisterUrl());
		result.setAuthorizeUrl(input.getAuthorizeUrl());
		return result;
	}

	public Set<SService> convertToSSetService(Collection<Service> input) {
		Set<SService> result = new HashSet<SService>();
		for (Service o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<Service> convertFromSSetService(Collection<SService> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<Service> result = new HashSet<Service>();
		for (SService o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SService> convertToSListService(Collection<Service> input) {
		List<SService> result = new ArrayList<SService>();
		for (Service o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<Service> convertFromSListService(Collection<SService> input, DatabaseSession session) throws BimserverDatabaseException {
		List<Service> result = new ArrayList<Service>();
		for (SService o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SService convertToSObject(Service input) {
		if (input == null) {
			return null;
		}
		
		SService result = new SService();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setName(input.getName());
		result.setServiceName(input.getServiceName());
		result.setServiceIdentifier(input.getServiceIdentifier());
		result.setProviderName(input.getProviderName());
		result.setUrl(input.getUrl());
		result.setToken(input.getToken());
		result.setNotificationProtocol(SAccessMethod.values()[input.getNotificationProtocol().ordinal()]);
		result.setDescription(input.getDescription());
		result.setTrigger(STrigger.values()[input.getTrigger().ordinal()]);
		result.setReadRevision(input.isReadRevision());
		result.setProfileIdentifier(input.getProfileIdentifier());
		result.setProfileName(input.getProfileName());
		result.setProfileDescription(input.getProfileDescription());
		result.setProfilePublic(input.isProfilePublic());
		ExtendedDataSchema readExtendedDataVal = input.getReadExtendedData();
		result.setReadExtendedDataId(readExtendedDataVal == null ? -1 : readExtendedDataVal.getOid());
		Project writeRevisionVal = input.getWriteRevision();
		result.setWriteRevisionId(writeRevisionVal == null ? -1 : writeRevisionVal.getOid());
		ExtendedDataSchema writeExtendedDataVal = input.getWriteExtendedData();
		result.setWriteExtendedDataId(writeExtendedDataVal == null ? -1 : writeExtendedDataVal.getOid());
		Project projectVal = input.getProject();
		result.setProjectId(projectVal == null ? -1 : projectVal.getOid());
		User userVal = input.getUser();
		result.setUserId(userVal == null ? -1 : userVal.getOid());
		InternalServicePluginConfiguration internalServiceVal = input.getInternalService();
		result.setInternalServiceId(internalServiceVal == null ? -1 : internalServiceVal.getOid());
		List<Long> listmodelCheckers = new ArrayList<Long>();
		for (ModelCheckerInstance v : input.getModelCheckers()) {
			listmodelCheckers.add(v.getOid());
		}
		result.setModelCheckers(listmodelCheckers);
		return result;
	}

	public Service convertFromSObject(SService input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		Service result = convertFromSObject(input, (Service)session.create(StorePackage.eINSTANCE.getService()), session);
		
		
		return result;
	}

	public Service convertFromSObject(SService input) throws BimserverDatabaseException {
		Service result = convertFromSObject(input, StoreFactory.eINSTANCE.createService(), null);
		return result;
	}

	public Service convertFromSObject(SService input, Service result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setName(input.getName());
		result.setServiceName(input.getServiceName());
		result.setServiceIdentifier(input.getServiceIdentifier());
		result.setProviderName(input.getProviderName());
		result.setUrl(input.getUrl());
		result.setToken(input.getToken());
		result.setNotificationProtocol(AccessMethod.values()[input.getNotificationProtocol().ordinal()]);
		result.setDescription(input.getDescription());
		result.setTrigger(Trigger.values()[input.getTrigger().ordinal()]);
		result.setReadRevision(input.isReadRevision());
		result.setProfileIdentifier(input.getProfileIdentifier());
		result.setProfileName(input.getProfileName());
		result.setProfileDescription(input.getProfileDescription());
		result.setProfilePublic(input.isProfilePublic());
		result.setReadExtendedData((ExtendedDataSchema)session.get(StorePackage.eINSTANCE.getExtendedDataSchema(), input.getReadExtendedDataId(), OldQuery.getDefault()));
		result.setWriteRevision((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getWriteRevisionId(), OldQuery.getDefault()));
		result.setWriteExtendedData((ExtendedDataSchema)session.get(StorePackage.eINSTANCE.getExtendedDataSchema(), input.getWriteExtendedDataId(), OldQuery.getDefault()));
		result.setProject((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getProjectId(), OldQuery.getDefault()));
		result.setUser((User)session.get(StorePackage.eINSTANCE.getUser(), input.getUserId(), OldQuery.getDefault()));
		result.setInternalService((InternalServicePluginConfiguration)session.get(StorePackage.eINSTANCE.getInternalServicePluginConfiguration(), input.getInternalServiceId(), OldQuery.getDefault()));
		List<ModelCheckerInstance> listmodelCheckers = result.getModelCheckers();
		for (long oid : input.getModelCheckers()) {
			listmodelCheckers.add((ModelCheckerInstance)session.get(StorePackage.eINSTANCE.getModelCheckerInstance(), oid, OldQuery.getDefault()));
		}
		return result;
	}

	public Set<SToken> convertToSSetToken(Collection<Token> input) {
		Set<SToken> result = new HashSet<SToken>();
		for (Token o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<Token> convertFromSSetToken(Collection<SToken> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<Token> result = new HashSet<Token>();
		for (SToken o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SToken> convertToSListToken(Collection<Token> input) {
		List<SToken> result = new ArrayList<SToken>();
		for (Token o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<Token> convertFromSListToken(Collection<SToken> input, DatabaseSession session) throws BimserverDatabaseException {
		List<Token> result = new ArrayList<Token>();
		for (SToken o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SToken convertToSObject(Token input) {
		if (input == null) {
			return null;
		}
		
		SToken result = new SToken();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setTokenString(input.getTokenString());
		result.setExpires(input.getExpires());
		return result;
	}

	public Token convertFromSObject(SToken input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		Token result = convertFromSObject(input, (Token)session.create(StorePackage.eINSTANCE.getToken()), session);
		
		
		return result;
	}

	public Token convertFromSObject(SToken input) throws BimserverDatabaseException {
		Token result = convertFromSObject(input, StoreFactory.eINSTANCE.createToken(), null);
		return result;
	}

	public Token convertFromSObject(SToken input, Token result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setTokenString(input.getTokenString());
		result.setExpires(input.getExpires());
		return result;
	}

	public Set<SInternalServicePluginConfiguration> convertToSSetInternalServicePluginConfiguration(Collection<InternalServicePluginConfiguration> input) {
		Set<SInternalServicePluginConfiguration> result = new HashSet<SInternalServicePluginConfiguration>();
		for (InternalServicePluginConfiguration o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<InternalServicePluginConfiguration> convertFromSSetInternalServicePluginConfiguration(Collection<SInternalServicePluginConfiguration> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<InternalServicePluginConfiguration> result = new HashSet<InternalServicePluginConfiguration>();
		for (SInternalServicePluginConfiguration o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SInternalServicePluginConfiguration> convertToSListInternalServicePluginConfiguration(Collection<InternalServicePluginConfiguration> input) {
		List<SInternalServicePluginConfiguration> result = new ArrayList<SInternalServicePluginConfiguration>();
		for (InternalServicePluginConfiguration o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<InternalServicePluginConfiguration> convertFromSListInternalServicePluginConfiguration(Collection<SInternalServicePluginConfiguration> input, DatabaseSession session) throws BimserverDatabaseException {
		List<InternalServicePluginConfiguration> result = new ArrayList<InternalServicePluginConfiguration>();
		for (SInternalServicePluginConfiguration o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SInternalServicePluginConfiguration convertToSObject(InternalServicePluginConfiguration input) {
		if (input == null) {
			return null;
		}
		
		SInternalServicePluginConfiguration result = new SInternalServicePluginConfiguration();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setName(input.getName());
		result.setEnabled(input.getEnabled());
		result.setDescription(input.getDescription());
		result.setRemoteAccessible(input.isRemoteAccessible());
		result.setPublicProfile(input.isPublicProfile());
		PluginDescriptor pluginDescriptorVal = input.getPluginDescriptor();
		result.setPluginDescriptorId(pluginDescriptorVal == null ? -1 : pluginDescriptorVal.getOid());
		ObjectType settingsVal = input.getSettings();
		result.setSettingsId(settingsVal == null ? -1 : settingsVal.getOid());
		UserSettings userSettingsVal = input.getUserSettings();
		result.setUserSettingsId(userSettingsVal == null ? -1 : userSettingsVal.getOid());
		return result;
	}

	public InternalServicePluginConfiguration convertFromSObject(SInternalServicePluginConfiguration input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		InternalServicePluginConfiguration result = convertFromSObject(input, (InternalServicePluginConfiguration)session.create(StorePackage.eINSTANCE.getInternalServicePluginConfiguration()), session);
		
		
		return result;
	}

	public InternalServicePluginConfiguration convertFromSObject(SInternalServicePluginConfiguration input) throws BimserverDatabaseException {
		InternalServicePluginConfiguration result = convertFromSObject(input, StoreFactory.eINSTANCE.createInternalServicePluginConfiguration(), null);
		return result;
	}

	public InternalServicePluginConfiguration convertFromSObject(SInternalServicePluginConfiguration input, InternalServicePluginConfiguration result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setName(input.getName());
		result.setEnabled(input.getEnabled());
		result.setDescription(input.getDescription());
		result.setRemoteAccessible(input.isRemoteAccessible());
		result.setPublicProfile(input.isPublicProfile());
		result.setPluginDescriptor((PluginDescriptor)session.get(StorePackage.eINSTANCE.getPluginDescriptor(), input.getPluginDescriptorId(), OldQuery.getDefault()));
		result.setSettings((ObjectType)session.get(StorePackage.eINSTANCE.getObjectType(), input.getSettingsId(), OldQuery.getDefault()));
		result.setUserSettings((UserSettings)session.get(StorePackage.eINSTANCE.getUserSettings(), input.getUserSettingsId(), OldQuery.getDefault()));
		return result;
	}

	public Set<SServiceInterface> convertToSSetServiceInterface(Collection<ServiceInterface> input) {
		Set<SServiceInterface> result = new HashSet<SServiceInterface>();
		for (ServiceInterface o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ServiceInterface> convertFromSSetServiceInterface(Collection<SServiceInterface> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ServiceInterface> result = new HashSet<ServiceInterface>();
		for (SServiceInterface o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SServiceInterface> convertToSListServiceInterface(Collection<ServiceInterface> input) {
		List<SServiceInterface> result = new ArrayList<SServiceInterface>();
		for (ServiceInterface o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ServiceInterface> convertFromSListServiceInterface(Collection<SServiceInterface> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ServiceInterface> result = new ArrayList<ServiceInterface>();
		for (SServiceInterface o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SServiceInterface convertToSObject(ServiceInterface input) {
		if (input == null) {
			return null;
		}
		
		SServiceInterface result = new SServiceInterface();
		result.setName(input.getName());
		result.setNameSpace(input.getNameSpace());
		result.setSimpleName(input.getSimpleName());
		return result;
	}

	public ServiceInterface convertFromSObject(SServiceInterface input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		ServiceInterface result = convertFromSObject(input, (ServiceInterface)session.create(StorePackage.eINSTANCE.getServiceInterface()), session);
		
		return result;
	}

	public ServiceInterface convertFromSObject(SServiceInterface input) throws BimserverDatabaseException {
		ServiceInterface result = convertFromSObject(input, StoreFactory.eINSTANCE.createServiceInterface(), null);
		return result;
	}

	public ServiceInterface convertFromSObject(SServiceInterface input, ServiceInterface result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setName(input.getName());
		result.setNameSpace(input.getNameSpace());
		result.setSimpleName(input.getSimpleName());
		return result;
	}

	public Set<SServiceMethod> convertToSSetServiceMethod(Collection<ServiceMethod> input) {
		Set<SServiceMethod> result = new HashSet<SServiceMethod>();
		for (ServiceMethod o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ServiceMethod> convertFromSSetServiceMethod(Collection<SServiceMethod> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ServiceMethod> result = new HashSet<ServiceMethod>();
		for (SServiceMethod o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SServiceMethod> convertToSListServiceMethod(Collection<ServiceMethod> input) {
		List<SServiceMethod> result = new ArrayList<SServiceMethod>();
		for (ServiceMethod o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ServiceMethod> convertFromSListServiceMethod(Collection<SServiceMethod> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ServiceMethod> result = new ArrayList<ServiceMethod>();
		for (SServiceMethod o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SServiceMethod convertToSObject(ServiceMethod input) {
		if (input == null) {
			return null;
		}
		
		SServiceMethod result = new SServiceMethod();
		result.setName(input.getName());
		result.setDoc(input.getDoc());
		result.setReturnDoc(input.getReturnDoc());
		return result;
	}

	public ServiceMethod convertFromSObject(SServiceMethod input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		ServiceMethod result = convertFromSObject(input, (ServiceMethod)session.create(StorePackage.eINSTANCE.getServiceMethod()), session);
		
		return result;
	}

	public ServiceMethod convertFromSObject(SServiceMethod input) throws BimserverDatabaseException {
		ServiceMethod result = convertFromSObject(input, StoreFactory.eINSTANCE.createServiceMethod(), null);
		return result;
	}

	public ServiceMethod convertFromSObject(SServiceMethod input, ServiceMethod result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setName(input.getName());
		result.setDoc(input.getDoc());
		result.setReturnDoc(input.getReturnDoc());
		return result;
	}
		public SServiceSimpleType convertToSObject(ServiceSimpleType input) {
			return SServiceSimpleType.values()[input.ordinal()];
		}
		
		public ServiceSimpleType convertFromSObject(SServiceSimpleType input) {
			return ServiceSimpleType.values()[input.ordinal()];
		}

	public Set<SServiceField> convertToSSetServiceField(Collection<ServiceField> input) {
		Set<SServiceField> result = new HashSet<SServiceField>();
		for (ServiceField o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ServiceField> convertFromSSetServiceField(Collection<SServiceField> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ServiceField> result = new HashSet<ServiceField>();
		for (SServiceField o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SServiceField> convertToSListServiceField(Collection<ServiceField> input) {
		List<SServiceField> result = new ArrayList<SServiceField>();
		for (ServiceField o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ServiceField> convertFromSListServiceField(Collection<SServiceField> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ServiceField> result = new ArrayList<ServiceField>();
		for (SServiceField o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SServiceField convertToSObject(ServiceField input) {
		if (input == null) {
			return null;
		}
		
		SServiceField result = new SServiceField();
		result.setName(input.getName());
		result.setDoc(input.getDoc());
		ServiceType typeVal = input.getType();
		result.setType(convertToSObject(typeVal));
		ServiceType genericTypeVal = input.getGenericType();
		result.setGenericType(convertToSObject(genericTypeVal));
		return result;
	}

	public ServiceField convertFromSObject(SServiceField input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		ServiceField result = convertFromSObject(input, (ServiceField)session.create(StorePackage.eINSTANCE.getServiceField()), session);
		
		return result;
	}

	public ServiceField convertFromSObject(SServiceField input) throws BimserverDatabaseException {
		ServiceField result = convertFromSObject(input, StoreFactory.eINSTANCE.createServiceField(), null);
		return result;
	}

	public ServiceField convertFromSObject(SServiceField input, ServiceField result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setName(input.getName());
		result.setDoc(input.getDoc());
		result.setType(convertFromSObject(input.getType(), session));
		result.setGenericType(convertFromSObject(input.getGenericType(), session));
		return result;
	}

	public Set<SServiceType> convertToSSetServiceType(Collection<ServiceType> input) {
		Set<SServiceType> result = new HashSet<SServiceType>();
		for (ServiceType o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ServiceType> convertFromSSetServiceType(Collection<SServiceType> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ServiceType> result = new HashSet<ServiceType>();
		for (SServiceType o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SServiceType> convertToSListServiceType(Collection<ServiceType> input) {
		List<SServiceType> result = new ArrayList<SServiceType>();
		for (ServiceType o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ServiceType> convertFromSListServiceType(Collection<SServiceType> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ServiceType> result = new ArrayList<ServiceType>();
		for (SServiceType o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SServiceType convertToSObject(ServiceType input) {
		if (input == null) {
			return null;
		}
		
		SServiceType result = new SServiceType();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setName(input.getName());
		result.setSimpleName(input.getSimpleName());
		result.setSimpleType(SServiceSimpleType.values()[input.getSimpleType().ordinal()]);
		List<SServiceField> listfields = new ArrayList<SServiceField>();
		for (ServiceField v : input.getFields()) {
			listfields.add(convertToSObject(v));
		}
		result.setFields(listfields);
		return result;
	}

	public ServiceType convertFromSObject(SServiceType input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		ServiceType result = convertFromSObject(input, (ServiceType)session.create(StorePackage.eINSTANCE.getServiceType()), session);
		
		
		return result;
	}

	public ServiceType convertFromSObject(SServiceType input) throws BimserverDatabaseException {
		ServiceType result = convertFromSObject(input, StoreFactory.eINSTANCE.createServiceType(), null);
		return result;
	}

	public ServiceType convertFromSObject(SServiceType input, ServiceType result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setName(input.getName());
		result.setSimpleName(input.getSimpleName());
		result.setSimpleType(ServiceSimpleType.values()[input.getSimpleType().ordinal()]);
		List<ServiceField> listfields = result.getFields();
		for (SServiceField v : input.getFields()) {
			listfields.add(convertFromSObject(v, session));
		}
		return result;
	}

	public Set<SServiceParameter> convertToSSetServiceParameter(Collection<ServiceParameter> input) {
		Set<SServiceParameter> result = new HashSet<SServiceParameter>();
		for (ServiceParameter o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ServiceParameter> convertFromSSetServiceParameter(Collection<SServiceParameter> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ServiceParameter> result = new HashSet<ServiceParameter>();
		for (SServiceParameter o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SServiceParameter> convertToSListServiceParameter(Collection<ServiceParameter> input) {
		List<SServiceParameter> result = new ArrayList<SServiceParameter>();
		for (ServiceParameter o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ServiceParameter> convertFromSListServiceParameter(Collection<SServiceParameter> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ServiceParameter> result = new ArrayList<ServiceParameter>();
		for (SServiceParameter o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SServiceParameter convertToSObject(ServiceParameter input) {
		if (input == null) {
			return null;
		}
		
		SServiceParameter result = new SServiceParameter();
		result.setName(input.getName());
		result.setDoc(input.getDoc());
		ServiceType typeVal = input.getType();
		result.setType(convertToSObject(typeVal));
		ServiceType genericTypeVal = input.getGenericType();
		result.setGenericType(convertToSObject(genericTypeVal));
		return result;
	}

	public ServiceParameter convertFromSObject(SServiceParameter input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		ServiceParameter result = convertFromSObject(input, (ServiceParameter)session.create(StorePackage.eINSTANCE.getServiceParameter()), session);
		
		return result;
	}

	public ServiceParameter convertFromSObject(SServiceParameter input) throws BimserverDatabaseException {
		ServiceParameter result = convertFromSObject(input, StoreFactory.eINSTANCE.createServiceParameter(), null);
		return result;
	}

	public ServiceParameter convertFromSObject(SServiceParameter input, ServiceParameter result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setName(input.getName());
		result.setDoc(input.getDoc());
		result.setType(convertFromSObject(input.getType(), session));
		result.setGenericType(convertFromSObject(input.getGenericType(), session));
		return result;
	}
		public SPrimitiveEnum convertToSObject(PrimitiveEnum input) {
			return SPrimitiveEnum.values()[input.ordinal()];
		}
		
		public PrimitiveEnum convertFromSObject(SPrimitiveEnum input) {
			return PrimitiveEnum.values()[input.ordinal()];
		}

	public Set<STypeDefinition> convertToSSetTypeDefinition(Collection<TypeDefinition> input) {
		Set<STypeDefinition> result = new HashSet<STypeDefinition>();
		for (TypeDefinition o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<TypeDefinition> convertFromSSetTypeDefinition(Collection<STypeDefinition> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<TypeDefinition> result = new HashSet<TypeDefinition>();
		for (STypeDefinition o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<STypeDefinition> convertToSListTypeDefinition(Collection<TypeDefinition> input) {
		List<STypeDefinition> result = new ArrayList<STypeDefinition>();
		for (TypeDefinition o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<TypeDefinition> convertFromSListTypeDefinition(Collection<STypeDefinition> input, DatabaseSession session) throws BimserverDatabaseException {
		List<TypeDefinition> result = new ArrayList<TypeDefinition>();
		for (STypeDefinition o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public STypeDefinition convertToSObject(TypeDefinition input) {
		if (input == null) {
			return null;
		}
		
		if (input instanceof ArrayDefinition) {
			return convertToSObject((ArrayDefinition)input);
		}
		else if (input instanceof ObjectDefinition) {
			return convertToSObject((ObjectDefinition)input);
		}
		else if (input instanceof PrimitiveDefinition) {
			return convertToSObject((PrimitiveDefinition)input);
		}
		STypeDefinition result = new STypeDefinition();
		return result;
	}

	public TypeDefinition convertFromSObject(STypeDefinition input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		TypeDefinition result = convertFromSObject(input, (TypeDefinition)session.create(StorePackage.eINSTANCE.getTypeDefinition()), session);
		
		return result;
	}

	public TypeDefinition convertFromSObject(STypeDefinition input) throws BimserverDatabaseException {
		TypeDefinition result = convertFromSObject(input, StoreFactory.eINSTANCE.createTypeDefinition(), null);
		return result;
	}

	public TypeDefinition convertFromSObject(STypeDefinition input, TypeDefinition result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		if (input instanceof SArrayDefinition) {
			return convertFromSObject((SArrayDefinition)input, session);
		}
		else if (input instanceof SObjectDefinition) {
			return convertFromSObject((SObjectDefinition)input, session);
		}
		else if (input instanceof SPrimitiveDefinition) {
			return convertFromSObject((SPrimitiveDefinition)input, session);
		}
		return result;
	}

	public Set<SObjectDefinition> convertToSSetObjectDefinition(Collection<ObjectDefinition> input) {
		Set<SObjectDefinition> result = new HashSet<SObjectDefinition>();
		for (ObjectDefinition o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ObjectDefinition> convertFromSSetObjectDefinition(Collection<SObjectDefinition> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ObjectDefinition> result = new HashSet<ObjectDefinition>();
		for (SObjectDefinition o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SObjectDefinition> convertToSListObjectDefinition(Collection<ObjectDefinition> input) {
		List<SObjectDefinition> result = new ArrayList<SObjectDefinition>();
		for (ObjectDefinition o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ObjectDefinition> convertFromSListObjectDefinition(Collection<SObjectDefinition> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ObjectDefinition> result = new ArrayList<ObjectDefinition>();
		for (SObjectDefinition o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SObjectDefinition convertToSObject(ObjectDefinition input) {
		if (input == null) {
			return null;
		}
		
		SObjectDefinition result = new SObjectDefinition();
		List<SParameterDefinition> listparameters = new ArrayList<SParameterDefinition>();
		for (ParameterDefinition v : input.getParameters()) {
			listparameters.add(convertToSObject(v));
		}
		result.setParameters(listparameters);
		return result;
	}

	public ObjectDefinition convertFromSObject(SObjectDefinition input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		ObjectDefinition result = convertFromSObject(input, (ObjectDefinition)session.create(StorePackage.eINSTANCE.getObjectDefinition()), session);
		
		return result;
	}

	public ObjectDefinition convertFromSObject(SObjectDefinition input) throws BimserverDatabaseException {
		ObjectDefinition result = convertFromSObject(input, StoreFactory.eINSTANCE.createObjectDefinition(), null);
		return result;
	}

	public ObjectDefinition convertFromSObject(SObjectDefinition input, ObjectDefinition result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		List<ParameterDefinition> listparameters = result.getParameters();
		for (SParameterDefinition v : input.getParameters()) {
			listparameters.add(convertFromSObject(v, session));
		}
		return result;
	}

	public Set<SPrimitiveDefinition> convertToSSetPrimitiveDefinition(Collection<PrimitiveDefinition> input) {
		Set<SPrimitiveDefinition> result = new HashSet<SPrimitiveDefinition>();
		for (PrimitiveDefinition o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<PrimitiveDefinition> convertFromSSetPrimitiveDefinition(Collection<SPrimitiveDefinition> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<PrimitiveDefinition> result = new HashSet<PrimitiveDefinition>();
		for (SPrimitiveDefinition o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SPrimitiveDefinition> convertToSListPrimitiveDefinition(Collection<PrimitiveDefinition> input) {
		List<SPrimitiveDefinition> result = new ArrayList<SPrimitiveDefinition>();
		for (PrimitiveDefinition o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<PrimitiveDefinition> convertFromSListPrimitiveDefinition(Collection<SPrimitiveDefinition> input, DatabaseSession session) throws BimserverDatabaseException {
		List<PrimitiveDefinition> result = new ArrayList<PrimitiveDefinition>();
		for (SPrimitiveDefinition o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SPrimitiveDefinition convertToSObject(PrimitiveDefinition input) {
		if (input == null) {
			return null;
		}
		
		SPrimitiveDefinition result = new SPrimitiveDefinition();
		result.setType(SPrimitiveEnum.values()[input.getType().ordinal()]);
		return result;
	}

	public PrimitiveDefinition convertFromSObject(SPrimitiveDefinition input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		PrimitiveDefinition result = convertFromSObject(input, (PrimitiveDefinition)session.create(StorePackage.eINSTANCE.getPrimitiveDefinition()), session);
		
		return result;
	}

	public PrimitiveDefinition convertFromSObject(SPrimitiveDefinition input) throws BimserverDatabaseException {
		PrimitiveDefinition result = convertFromSObject(input, StoreFactory.eINSTANCE.createPrimitiveDefinition(), null);
		return result;
	}

	public PrimitiveDefinition convertFromSObject(SPrimitiveDefinition input, PrimitiveDefinition result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setType(PrimitiveEnum.values()[input.getType().ordinal()]);
		return result;
	}

	public Set<SArrayDefinition> convertToSSetArrayDefinition(Collection<ArrayDefinition> input) {
		Set<SArrayDefinition> result = new HashSet<SArrayDefinition>();
		for (ArrayDefinition o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ArrayDefinition> convertFromSSetArrayDefinition(Collection<SArrayDefinition> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ArrayDefinition> result = new HashSet<ArrayDefinition>();
		for (SArrayDefinition o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SArrayDefinition> convertToSListArrayDefinition(Collection<ArrayDefinition> input) {
		List<SArrayDefinition> result = new ArrayList<SArrayDefinition>();
		for (ArrayDefinition o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ArrayDefinition> convertFromSListArrayDefinition(Collection<SArrayDefinition> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ArrayDefinition> result = new ArrayList<ArrayDefinition>();
		for (SArrayDefinition o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SArrayDefinition convertToSObject(ArrayDefinition input) {
		if (input == null) {
			return null;
		}
		
		SArrayDefinition result = new SArrayDefinition();
		TypeDefinition typeVal = input.getType();
		result.setType(convertToSObject(typeVal));
		return result;
	}

	public ArrayDefinition convertFromSObject(SArrayDefinition input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		ArrayDefinition result = convertFromSObject(input, (ArrayDefinition)session.create(StorePackage.eINSTANCE.getArrayDefinition()), session);
		
		return result;
	}

	public ArrayDefinition convertFromSObject(SArrayDefinition input) throws BimserverDatabaseException {
		ArrayDefinition result = convertFromSObject(input, StoreFactory.eINSTANCE.createArrayDefinition(), null);
		return result;
	}

	public ArrayDefinition convertFromSObject(SArrayDefinition input, ArrayDefinition result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setType(convertFromSObject(input.getType(), session));
		return result;
	}

	public Set<SParameterDefinition> convertToSSetParameterDefinition(Collection<ParameterDefinition> input) {
		Set<SParameterDefinition> result = new HashSet<SParameterDefinition>();
		for (ParameterDefinition o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ParameterDefinition> convertFromSSetParameterDefinition(Collection<SParameterDefinition> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ParameterDefinition> result = new HashSet<ParameterDefinition>();
		for (SParameterDefinition o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SParameterDefinition> convertToSListParameterDefinition(Collection<ParameterDefinition> input) {
		List<SParameterDefinition> result = new ArrayList<SParameterDefinition>();
		for (ParameterDefinition o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ParameterDefinition> convertFromSListParameterDefinition(Collection<SParameterDefinition> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ParameterDefinition> result = new ArrayList<ParameterDefinition>();
		for (SParameterDefinition o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SParameterDefinition convertToSObject(ParameterDefinition input) {
		if (input == null) {
			return null;
		}
		
		SParameterDefinition result = new SParameterDefinition();
		result.setName(input.getName());
		result.setIdentifier(input.getIdentifier());
		result.setRequired(input.isRequired());
		result.setDescription(input.getDescription());
		TypeDefinition typeVal = input.getType();
		result.setType(convertToSObject(typeVal));
		Type defaultValueVal = input.getDefaultValue();
		result.setDefaultValue(convertToSObject(defaultValueVal));
		return result;
	}

	public ParameterDefinition convertFromSObject(SParameterDefinition input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		ParameterDefinition result = convertFromSObject(input, (ParameterDefinition)session.create(StorePackage.eINSTANCE.getParameterDefinition()), session);
		
		return result;
	}

	public ParameterDefinition convertFromSObject(SParameterDefinition input) throws BimserverDatabaseException {
		ParameterDefinition result = convertFromSObject(input, StoreFactory.eINSTANCE.createParameterDefinition(), null);
		return result;
	}

	public ParameterDefinition convertFromSObject(SParameterDefinition input, ParameterDefinition result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setName(input.getName());
		result.setIdentifier(input.getIdentifier());
		result.setRequired(input.isRequired());
		result.setDescription(input.getDescription());
		result.setType(convertFromSObject(input.getType(), session));
		result.setDefaultValue(convertFromSObject(input.getDefaultValue(), session));
		return result;
	}

	public Set<SType> convertToSSetType(Collection<Type> input) {
		Set<SType> result = new HashSet<SType>();
		for (Type o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<Type> convertFromSSetType(Collection<SType> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<Type> result = new HashSet<Type>();
		for (SType o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SType> convertToSListType(Collection<Type> input) {
		List<SType> result = new ArrayList<SType>();
		for (Type o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<Type> convertFromSListType(Collection<SType> input, DatabaseSession session) throws BimserverDatabaseException {
		List<Type> result = new ArrayList<Type>();
		for (SType o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SType convertToSObject(Type input) {
		if (input == null) {
			return null;
		}
		
		if (input instanceof ArrayType) {
			return convertToSObject((ArrayType)input);
		}
		else if (input instanceof ObjectType) {
			return convertToSObject((ObjectType)input);
		}
		else if (input instanceof PrimitiveType) {
			return convertToSObject((PrimitiveType)input);
		}
		SType result = new SType();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		return result;
	}

	public Type convertFromSObject(SType input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		Type result = convertFromSObject(input, (Type)session.create(StorePackage.eINSTANCE.getType()), session);
		
		
		return result;
	}

	public Type convertFromSObject(SType input) throws BimserverDatabaseException {
		Type result = convertFromSObject(input, StoreFactory.eINSTANCE.createType(), null);
		return result;
	}

	public Type convertFromSObject(SType input, Type result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		if (input instanceof SArrayType) {
			return convertFromSObject((SArrayType)input, session);
		}
		else if (input instanceof SObjectType) {
			return convertFromSObject((SObjectType)input, session);
		}
		else if (input instanceof SPrimitiveType) {
			return convertFromSObject((SPrimitiveType)input, session);
		}
		return result;
	}

	public Set<SObjectType> convertToSSetObjectType(Collection<ObjectType> input) {
		Set<SObjectType> result = new HashSet<SObjectType>();
		for (ObjectType o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ObjectType> convertFromSSetObjectType(Collection<SObjectType> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ObjectType> result = new HashSet<ObjectType>();
		for (SObjectType o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SObjectType> convertToSListObjectType(Collection<ObjectType> input) {
		List<SObjectType> result = new ArrayList<SObjectType>();
		for (ObjectType o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ObjectType> convertFromSListObjectType(Collection<SObjectType> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ObjectType> result = new ArrayList<ObjectType>();
		for (SObjectType o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SObjectType convertToSObject(ObjectType input) {
		if (input == null) {
			return null;
		}
		
		SObjectType result = new SObjectType();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setName(input.getName());
		List<SParameter> listparameters = new ArrayList<SParameter>();
		for (Parameter v : input.getParameters()) {
			listparameters.add(convertToSObject(v));
		}
		result.setParameters(listparameters);
		return result;
	}

	public ObjectType convertFromSObject(SObjectType input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		ObjectType result = convertFromSObject(input, (ObjectType)session.create(StorePackage.eINSTANCE.getObjectType()), session);
		
		
		return result;
	}

	public ObjectType convertFromSObject(SObjectType input) throws BimserverDatabaseException {
		ObjectType result = convertFromSObject(input, StoreFactory.eINSTANCE.createObjectType(), null);
		return result;
	}

	public ObjectType convertFromSObject(SObjectType input, ObjectType result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setName(input.getName());
		List<Parameter> listparameters = result.getParameters();
		for (SParameter v : input.getParameters()) {
			listparameters.add(convertFromSObject(v, session));
		}
		return result;
	}

	public Set<SPrimitiveType> convertToSSetPrimitiveType(Collection<PrimitiveType> input) {
		Set<SPrimitiveType> result = new HashSet<SPrimitiveType>();
		for (PrimitiveType o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<PrimitiveType> convertFromSSetPrimitiveType(Collection<SPrimitiveType> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<PrimitiveType> result = new HashSet<PrimitiveType>();
		for (SPrimitiveType o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SPrimitiveType> convertToSListPrimitiveType(Collection<PrimitiveType> input) {
		List<SPrimitiveType> result = new ArrayList<SPrimitiveType>();
		for (PrimitiveType o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<PrimitiveType> convertFromSListPrimitiveType(Collection<SPrimitiveType> input, DatabaseSession session) throws BimserverDatabaseException {
		List<PrimitiveType> result = new ArrayList<PrimitiveType>();
		for (SPrimitiveType o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SPrimitiveType convertToSObject(PrimitiveType input) {
		if (input == null) {
			return null;
		}
		
		if (input instanceof BooleanType) {
			return convertToSObject((BooleanType)input);
		}
		else if (input instanceof ByteArrayType) {
			return convertToSObject((ByteArrayType)input);
		}
		else if (input instanceof DoubleType) {
			return convertToSObject((DoubleType)input);
		}
		else if (input instanceof LongType) {
			return convertToSObject((LongType)input);
		}
		else if (input instanceof StringType) {
			return convertToSObject((StringType)input);
		}
		SPrimitiveType result = new SPrimitiveType();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		return result;
	}

	public PrimitiveType convertFromSObject(SPrimitiveType input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		PrimitiveType result = convertFromSObject(input, (PrimitiveType)session.create(StorePackage.eINSTANCE.getPrimitiveType()), session);
		
		
		return result;
	}

	public PrimitiveType convertFromSObject(SPrimitiveType input) throws BimserverDatabaseException {
		PrimitiveType result = convertFromSObject(input, StoreFactory.eINSTANCE.createPrimitiveType(), null);
		return result;
	}

	public PrimitiveType convertFromSObject(SPrimitiveType input, PrimitiveType result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		if (input instanceof SBooleanType) {
			return convertFromSObject((SBooleanType)input, session);
		}
		else if (input instanceof SByteArrayType) {
			return convertFromSObject((SByteArrayType)input, session);
		}
		else if (input instanceof SDoubleType) {
			return convertFromSObject((SDoubleType)input, session);
		}
		else if (input instanceof SLongType) {
			return convertFromSObject((SLongType)input, session);
		}
		else if (input instanceof SStringType) {
			return convertFromSObject((SStringType)input, session);
		}
		return result;
	}

	public Set<SLongType> convertToSSetLongType(Collection<LongType> input) {
		Set<SLongType> result = new HashSet<SLongType>();
		for (LongType o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<LongType> convertFromSSetLongType(Collection<SLongType> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<LongType> result = new HashSet<LongType>();
		for (SLongType o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SLongType> convertToSListLongType(Collection<LongType> input) {
		List<SLongType> result = new ArrayList<SLongType>();
		for (LongType o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<LongType> convertFromSListLongType(Collection<SLongType> input, DatabaseSession session) throws BimserverDatabaseException {
		List<LongType> result = new ArrayList<LongType>();
		for (SLongType o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SLongType convertToSObject(LongType input) {
		if (input == null) {
			return null;
		}
		
		SLongType result = new SLongType();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setValue(input.getValue());
		return result;
	}

	public LongType convertFromSObject(SLongType input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		LongType result = convertFromSObject(input, (LongType)session.create(StorePackage.eINSTANCE.getLongType()), session);
		
		
		return result;
	}

	public LongType convertFromSObject(SLongType input) throws BimserverDatabaseException {
		LongType result = convertFromSObject(input, StoreFactory.eINSTANCE.createLongType(), null);
		return result;
	}

	public LongType convertFromSObject(SLongType input, LongType result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setValue(input.getValue());
		return result;
	}

	public Set<SByteArrayType> convertToSSetByteArrayType(Collection<ByteArrayType> input) {
		Set<SByteArrayType> result = new HashSet<SByteArrayType>();
		for (ByteArrayType o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ByteArrayType> convertFromSSetByteArrayType(Collection<SByteArrayType> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ByteArrayType> result = new HashSet<ByteArrayType>();
		for (SByteArrayType o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SByteArrayType> convertToSListByteArrayType(Collection<ByteArrayType> input) {
		List<SByteArrayType> result = new ArrayList<SByteArrayType>();
		for (ByteArrayType o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ByteArrayType> convertFromSListByteArrayType(Collection<SByteArrayType> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ByteArrayType> result = new ArrayList<ByteArrayType>();
		for (SByteArrayType o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SByteArrayType convertToSObject(ByteArrayType input) {
		if (input == null) {
			return null;
		}
		
		SByteArrayType result = new SByteArrayType();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setValue(input.getValue());
		return result;
	}

	public ByteArrayType convertFromSObject(SByteArrayType input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		ByteArrayType result = convertFromSObject(input, (ByteArrayType)session.create(StorePackage.eINSTANCE.getByteArrayType()), session);
		
		
		return result;
	}

	public ByteArrayType convertFromSObject(SByteArrayType input) throws BimserverDatabaseException {
		ByteArrayType result = convertFromSObject(input, StoreFactory.eINSTANCE.createByteArrayType(), null);
		return result;
	}

	public ByteArrayType convertFromSObject(SByteArrayType input, ByteArrayType result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setValue(input.getValue());
		return result;
	}

	public Set<SDoubleType> convertToSSetDoubleType(Collection<DoubleType> input) {
		Set<SDoubleType> result = new HashSet<SDoubleType>();
		for (DoubleType o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<DoubleType> convertFromSSetDoubleType(Collection<SDoubleType> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<DoubleType> result = new HashSet<DoubleType>();
		for (SDoubleType o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SDoubleType> convertToSListDoubleType(Collection<DoubleType> input) {
		List<SDoubleType> result = new ArrayList<SDoubleType>();
		for (DoubleType o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<DoubleType> convertFromSListDoubleType(Collection<SDoubleType> input, DatabaseSession session) throws BimserverDatabaseException {
		List<DoubleType> result = new ArrayList<DoubleType>();
		for (SDoubleType o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SDoubleType convertToSObject(DoubleType input) {
		if (input == null) {
			return null;
		}
		
		SDoubleType result = new SDoubleType();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setValue(input.getValue());
		return result;
	}

	public DoubleType convertFromSObject(SDoubleType input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		DoubleType result = convertFromSObject(input, (DoubleType)session.create(StorePackage.eINSTANCE.getDoubleType()), session);
		
		
		return result;
	}

	public DoubleType convertFromSObject(SDoubleType input) throws BimserverDatabaseException {
		DoubleType result = convertFromSObject(input, StoreFactory.eINSTANCE.createDoubleType(), null);
		return result;
	}

	public DoubleType convertFromSObject(SDoubleType input, DoubleType result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setValue(input.getValue());
		return result;
	}

	public Set<SStringType> convertToSSetStringType(Collection<StringType> input) {
		Set<SStringType> result = new HashSet<SStringType>();
		for (StringType o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<StringType> convertFromSSetStringType(Collection<SStringType> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<StringType> result = new HashSet<StringType>();
		for (SStringType o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SStringType> convertToSListStringType(Collection<StringType> input) {
		List<SStringType> result = new ArrayList<SStringType>();
		for (StringType o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<StringType> convertFromSListStringType(Collection<SStringType> input, DatabaseSession session) throws BimserverDatabaseException {
		List<StringType> result = new ArrayList<StringType>();
		for (SStringType o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SStringType convertToSObject(StringType input) {
		if (input == null) {
			return null;
		}
		
		SStringType result = new SStringType();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setValue(input.getValue());
		return result;
	}

	public StringType convertFromSObject(SStringType input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		StringType result = convertFromSObject(input, (StringType)session.create(StorePackage.eINSTANCE.getStringType()), session);
		
		
		return result;
	}

	public StringType convertFromSObject(SStringType input) throws BimserverDatabaseException {
		StringType result = convertFromSObject(input, StoreFactory.eINSTANCE.createStringType(), null);
		return result;
	}

	public StringType convertFromSObject(SStringType input, StringType result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setValue(input.getValue());
		return result;
	}

	public Set<SBooleanType> convertToSSetBooleanType(Collection<BooleanType> input) {
		Set<SBooleanType> result = new HashSet<SBooleanType>();
		for (BooleanType o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<BooleanType> convertFromSSetBooleanType(Collection<SBooleanType> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<BooleanType> result = new HashSet<BooleanType>();
		for (SBooleanType o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SBooleanType> convertToSListBooleanType(Collection<BooleanType> input) {
		List<SBooleanType> result = new ArrayList<SBooleanType>();
		for (BooleanType o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<BooleanType> convertFromSListBooleanType(Collection<SBooleanType> input, DatabaseSession session) throws BimserverDatabaseException {
		List<BooleanType> result = new ArrayList<BooleanType>();
		for (SBooleanType o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SBooleanType convertToSObject(BooleanType input) {
		if (input == null) {
			return null;
		}
		
		SBooleanType result = new SBooleanType();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setValue(input.isValue());
		return result;
	}

	public BooleanType convertFromSObject(SBooleanType input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		BooleanType result = convertFromSObject(input, (BooleanType)session.create(StorePackage.eINSTANCE.getBooleanType()), session);
		
		
		return result;
	}

	public BooleanType convertFromSObject(SBooleanType input) throws BimserverDatabaseException {
		BooleanType result = convertFromSObject(input, StoreFactory.eINSTANCE.createBooleanType(), null);
		return result;
	}

	public BooleanType convertFromSObject(SBooleanType input, BooleanType result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setValue(input.isValue());
		return result;
	}

	public Set<SArrayType> convertToSSetArrayType(Collection<ArrayType> input) {
		Set<SArrayType> result = new HashSet<SArrayType>();
		for (ArrayType o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ArrayType> convertFromSSetArrayType(Collection<SArrayType> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ArrayType> result = new HashSet<ArrayType>();
		for (SArrayType o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SArrayType> convertToSListArrayType(Collection<ArrayType> input) {
		List<SArrayType> result = new ArrayList<SArrayType>();
		for (ArrayType o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ArrayType> convertFromSListArrayType(Collection<SArrayType> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ArrayType> result = new ArrayList<ArrayType>();
		for (SArrayType o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SArrayType convertToSObject(ArrayType input) {
		if (input == null) {
			return null;
		}
		
		SArrayType result = new SArrayType();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		List<SType> listvalues = new ArrayList<SType>();
		for (Type v : input.getValues()) {
			listvalues.add(convertToSObject(v));
		}
		result.setValues(listvalues);
		return result;
	}

	public ArrayType convertFromSObject(SArrayType input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		ArrayType result = convertFromSObject(input, (ArrayType)session.create(StorePackage.eINSTANCE.getArrayType()), session);
		
		
		return result;
	}

	public ArrayType convertFromSObject(SArrayType input) throws BimserverDatabaseException {
		ArrayType result = convertFromSObject(input, StoreFactory.eINSTANCE.createArrayType(), null);
		return result;
	}

	public ArrayType convertFromSObject(SArrayType input, ArrayType result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		List<Type> listvalues = result.getValues();
		for (SType v : input.getValues()) {
			listvalues.add(convertFromSObject(v, session));
		}
		return result;
	}

	public Set<SParameter> convertToSSetParameter(Collection<Parameter> input) {
		Set<SParameter> result = new HashSet<SParameter>();
		for (Parameter o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<Parameter> convertFromSSetParameter(Collection<SParameter> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<Parameter> result = new HashSet<Parameter>();
		for (SParameter o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SParameter> convertToSListParameter(Collection<Parameter> input) {
		List<SParameter> result = new ArrayList<SParameter>();
		for (Parameter o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<Parameter> convertFromSListParameter(Collection<SParameter> input, DatabaseSession session) throws BimserverDatabaseException {
		List<Parameter> result = new ArrayList<Parameter>();
		for (SParameter o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SParameter convertToSObject(Parameter input) {
		if (input == null) {
			return null;
		}
		
		SParameter result = new SParameter();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setIdentifier(input.getIdentifier());
		result.setName(input.getName());
		Type valueVal = input.getValue();
		result.setValue(convertToSObject(valueVal));
		return result;
	}

	public Parameter convertFromSObject(SParameter input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		Parameter result = convertFromSObject(input, (Parameter)session.create(StorePackage.eINSTANCE.getParameter()), session);
		
		
		return result;
	}

	public Parameter convertFromSObject(SParameter input) throws BimserverDatabaseException {
		Parameter result = convertFromSObject(input, StoreFactory.eINSTANCE.createParameter(), null);
		return result;
	}

	public Parameter convertFromSObject(SParameter input, Parameter result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setIdentifier(input.getIdentifier());
		result.setName(input.getName());
		result.setValue(convertFromSObject(input.getValue(), session));
		return result;
	}
		public SNotifictionResultEnum convertToSObject(NotifictionResultEnum input) {
			return SNotifictionResultEnum.values()[input.ordinal()];
		}
		
		public NotifictionResultEnum convertFromSObject(SNotifictionResultEnum input) {
			return NotifictionResultEnum.values()[input.ordinal()];
		}

	public Set<SImmediateNotificationResult> convertToSSetImmediateNotificationResult(Collection<ImmediateNotificationResult> input) {
		Set<SImmediateNotificationResult> result = new HashSet<SImmediateNotificationResult>();
		for (ImmediateNotificationResult o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ImmediateNotificationResult> convertFromSSetImmediateNotificationResult(Collection<SImmediateNotificationResult> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ImmediateNotificationResult> result = new HashSet<ImmediateNotificationResult>();
		for (SImmediateNotificationResult o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SImmediateNotificationResult> convertToSListImmediateNotificationResult(Collection<ImmediateNotificationResult> input) {
		List<SImmediateNotificationResult> result = new ArrayList<SImmediateNotificationResult>();
		for (ImmediateNotificationResult o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ImmediateNotificationResult> convertFromSListImmediateNotificationResult(Collection<SImmediateNotificationResult> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ImmediateNotificationResult> result = new ArrayList<ImmediateNotificationResult>();
		for (SImmediateNotificationResult o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SImmediateNotificationResult convertToSObject(ImmediateNotificationResult input) {
		if (input == null) {
			return null;
		}
		
		SImmediateNotificationResult result = new SImmediateNotificationResult();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setResult(SNotifictionResultEnum.values()[input.getResult().ordinal()]);
		result.setDescription(input.getDescription());
		return result;
	}

	public ImmediateNotificationResult convertFromSObject(SImmediateNotificationResult input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		ImmediateNotificationResult result = convertFromSObject(input, (ImmediateNotificationResult)session.create(StorePackage.eINSTANCE.getImmediateNotificationResult()), session);
		
		
		return result;
	}

	public ImmediateNotificationResult convertFromSObject(SImmediateNotificationResult input) throws BimserverDatabaseException {
		ImmediateNotificationResult result = convertFromSObject(input, StoreFactory.eINSTANCE.createImmediateNotificationResult(), null);
		return result;
	}

	public ImmediateNotificationResult convertFromSObject(SImmediateNotificationResult input, ImmediateNotificationResult result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setResult(NotifictionResultEnum.values()[input.getResult().ordinal()]);
		result.setDescription(input.getDescription());
		return result;
	}

	public Set<SRemoteServiceUpdate> convertToSSetRemoteServiceUpdate(Collection<RemoteServiceUpdate> input) {
		Set<SRemoteServiceUpdate> result = new HashSet<SRemoteServiceUpdate>();
		for (RemoteServiceUpdate o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<RemoteServiceUpdate> convertFromSSetRemoteServiceUpdate(Collection<SRemoteServiceUpdate> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<RemoteServiceUpdate> result = new HashSet<RemoteServiceUpdate>();
		for (SRemoteServiceUpdate o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SRemoteServiceUpdate> convertToSListRemoteServiceUpdate(Collection<RemoteServiceUpdate> input) {
		List<SRemoteServiceUpdate> result = new ArrayList<SRemoteServiceUpdate>();
		for (RemoteServiceUpdate o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<RemoteServiceUpdate> convertFromSListRemoteServiceUpdate(Collection<SRemoteServiceUpdate> input, DatabaseSession session) throws BimserverDatabaseException {
		List<RemoteServiceUpdate> result = new ArrayList<RemoteServiceUpdate>();
		for (SRemoteServiceUpdate o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SRemoteServiceUpdate convertToSObject(RemoteServiceUpdate input) {
		if (input == null) {
			return null;
		}
		
		if (input instanceof PercentageChange) {
			return convertToSObject((PercentageChange)input);
		}
		SRemoteServiceUpdate result = new SRemoteServiceUpdate();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		return result;
	}

	public RemoteServiceUpdate convertFromSObject(SRemoteServiceUpdate input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		RemoteServiceUpdate result = convertFromSObject(input, (RemoteServiceUpdate)session.create(StorePackage.eINSTANCE.getRemoteServiceUpdate()), session);
		
		
		return result;
	}

	public RemoteServiceUpdate convertFromSObject(SRemoteServiceUpdate input) throws BimserverDatabaseException {
		RemoteServiceUpdate result = convertFromSObject(input, StoreFactory.eINSTANCE.createRemoteServiceUpdate(), null);
		return result;
	}

	public RemoteServiceUpdate convertFromSObject(SRemoteServiceUpdate input, RemoteServiceUpdate result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		if (input instanceof SPercentageChange) {
			return convertFromSObject((SPercentageChange)input, session);
		}
		return result;
	}

	public Set<SPercentageChange> convertToSSetPercentageChange(Collection<PercentageChange> input) {
		Set<SPercentageChange> result = new HashSet<SPercentageChange>();
		for (PercentageChange o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<PercentageChange> convertFromSSetPercentageChange(Collection<SPercentageChange> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<PercentageChange> result = new HashSet<PercentageChange>();
		for (SPercentageChange o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SPercentageChange> convertToSListPercentageChange(Collection<PercentageChange> input) {
		List<SPercentageChange> result = new ArrayList<SPercentageChange>();
		for (PercentageChange o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<PercentageChange> convertFromSListPercentageChange(Collection<SPercentageChange> input, DatabaseSession session) throws BimserverDatabaseException {
		List<PercentageChange> result = new ArrayList<PercentageChange>();
		for (SPercentageChange o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SPercentageChange convertToSObject(PercentageChange input) {
		if (input == null) {
			return null;
		}
		
		SPercentageChange result = new SPercentageChange();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setPercentage(input.getPercentage());
		return result;
	}

	public PercentageChange convertFromSObject(SPercentageChange input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		PercentageChange result = convertFromSObject(input, (PercentageChange)session.create(StorePackage.eINSTANCE.getPercentageChange()), session);
		
		
		return result;
	}

	public PercentageChange convertFromSObject(SPercentageChange input) throws BimserverDatabaseException {
		PercentageChange result = convertFromSObject(input, StoreFactory.eINSTANCE.createPercentageChange(), null);
		return result;
	}

	public PercentageChange convertFromSObject(SPercentageChange input, PercentageChange result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setPercentage(input.getPercentage());
		return result;
	}

	public Set<SSystemInfo> convertToSSetSystemInfo(Collection<SystemInfo> input) {
		Set<SSystemInfo> result = new HashSet<SSystemInfo>();
		for (SystemInfo o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<SystemInfo> convertFromSSetSystemInfo(Collection<SSystemInfo> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<SystemInfo> result = new HashSet<SystemInfo>();
		for (SSystemInfo o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SSystemInfo> convertToSListSystemInfo(Collection<SystemInfo> input) {
		List<SSystemInfo> result = new ArrayList<SSystemInfo>();
		for (SystemInfo o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<SystemInfo> convertFromSListSystemInfo(Collection<SSystemInfo> input, DatabaseSession session) throws BimserverDatabaseException {
		List<SystemInfo> result = new ArrayList<SystemInfo>();
		for (SSystemInfo o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SSystemInfo convertToSObject(SystemInfo input) {
		if (input == null) {
			return null;
		}
		
		SSystemInfo result = new SSystemInfo();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setCpucores(input.getCpucores());
		result.setDatetime(input.getDatetime());
		result.setOsname(input.getOsname());
		result.setOsversion(input.getOsversion());
		result.setUserName(input.getUserName());
		result.setUserHome(input.getUserHome());
		result.setUserDir(input.getUserDir());
		return result;
	}

	public SystemInfo convertFromSObject(SSystemInfo input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		SystemInfo result = convertFromSObject(input, (SystemInfo)session.create(StorePackage.eINSTANCE.getSystemInfo()), session);
		
		
		return result;
	}

	public SystemInfo convertFromSObject(SSystemInfo input) throws BimserverDatabaseException {
		SystemInfo result = convertFromSObject(input, StoreFactory.eINSTANCE.createSystemInfo(), null);
		return result;
	}

	public SystemInfo convertFromSObject(SSystemInfo input, SystemInfo result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setCpucores(input.getCpucores());
		result.setDatetime(input.getDatetime());
		result.setOsname(input.getOsname());
		result.setOsversion(input.getOsversion());
		result.setUserName(input.getUserName());
		result.setUserHome(input.getUserHome());
		result.setUserDir(input.getUserDir());
		return result;
	}

	public Set<SJavaInfo> convertToSSetJavaInfo(Collection<JavaInfo> input) {
		Set<SJavaInfo> result = new HashSet<SJavaInfo>();
		for (JavaInfo o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<JavaInfo> convertFromSSetJavaInfo(Collection<SJavaInfo> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<JavaInfo> result = new HashSet<JavaInfo>();
		for (SJavaInfo o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SJavaInfo> convertToSListJavaInfo(Collection<JavaInfo> input) {
		List<SJavaInfo> result = new ArrayList<SJavaInfo>();
		for (JavaInfo o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<JavaInfo> convertFromSListJavaInfo(Collection<SJavaInfo> input, DatabaseSession session) throws BimserverDatabaseException {
		List<JavaInfo> result = new ArrayList<JavaInfo>();
		for (SJavaInfo o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SJavaInfo convertToSObject(JavaInfo input) {
		if (input == null) {
			return null;
		}
		
		SJavaInfo result = new SJavaInfo();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setHeapTotal(input.getHeapTotal());
		result.setHeapUsed(input.getHeapUsed());
		result.setHeapFree(input.getHeapFree());
		result.setHeapMax(input.getHeapMax());
		result.setThreads(input.getThreads());
		result.setJavaHome(input.getJavaHome());
		result.setJavaVersion(input.getJavaVersion());
		result.setJavaVendor(input.getJavaVendor());
		result.setJavaVendorurl(input.getJavaVendorurl());
		result.setJavavmVersion(input.getJavavmVersion());
		result.setJavavmVendor(input.getJavavmVendor());
		result.setJavavmName(input.getJavavmName());
		result.setJavaspecVersion(input.getJavaspecVersion());
		result.setJavaspecVendor(input.getJavaspecVendor());
		result.setJavaspecName(input.getJavaspecName());
		result.setJavaClassVersion(input.getJavaClassVersion());
		result.getJavaClasspath().addAll(input.getJavaClasspath());
		result.getJavaLibrarypath().addAll(input.getJavaLibrarypath());
		result.setJavaIoTmp(input.getJavaIoTmp());
		result.setJavaExtdir(input.getJavaExtdir());
		result.setJavaFileSeparator(input.getJavaFileSeparator());
		result.setJavaPathSeparator(input.getJavaPathSeparator());
		result.setJavaLineSeparator(input.getJavaLineSeparator());
		return result;
	}

	public JavaInfo convertFromSObject(SJavaInfo input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		JavaInfo result = convertFromSObject(input, (JavaInfo)session.create(StorePackage.eINSTANCE.getJavaInfo()), session);
		
		
		return result;
	}

	public JavaInfo convertFromSObject(SJavaInfo input) throws BimserverDatabaseException {
		JavaInfo result = convertFromSObject(input, StoreFactory.eINSTANCE.createJavaInfo(), null);
		return result;
	}

	public JavaInfo convertFromSObject(SJavaInfo input, JavaInfo result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setHeapTotal(input.getHeapTotal());
		result.setHeapUsed(input.getHeapUsed());
		result.setHeapFree(input.getHeapFree());
		result.setHeapMax(input.getHeapMax());
		result.setThreads(input.getThreads());
		result.setJavaHome(input.getJavaHome());
		result.setJavaVersion(input.getJavaVersion());
		result.setJavaVendor(input.getJavaVendor());
		result.setJavaVendorurl(input.getJavaVendorurl());
		result.setJavavmVersion(input.getJavavmVersion());
		result.setJavavmVendor(input.getJavavmVendor());
		result.setJavavmName(input.getJavavmName());
		result.setJavaspecVersion(input.getJavaspecVersion());
		result.setJavaspecVendor(input.getJavaspecVendor());
		result.setJavaspecName(input.getJavaspecName());
		result.setJavaClassVersion(input.getJavaClassVersion());
		result.getJavaClasspath().addAll(input.getJavaClasspath());
		result.getJavaLibrarypath().addAll(input.getJavaLibrarypath());
		result.setJavaIoTmp(input.getJavaIoTmp());
		result.setJavaExtdir(input.getJavaExtdir());
		result.setJavaFileSeparator(input.getJavaFileSeparator());
		result.setJavaPathSeparator(input.getJavaPathSeparator());
		result.setJavaLineSeparator(input.getJavaLineSeparator());
		return result;
	}

	public Set<SBimServerInfo> convertToSSetBimServerInfo(Collection<BimServerInfo> input) {
		Set<SBimServerInfo> result = new HashSet<SBimServerInfo>();
		for (BimServerInfo o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<BimServerInfo> convertFromSSetBimServerInfo(Collection<SBimServerInfo> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<BimServerInfo> result = new HashSet<BimServerInfo>();
		for (SBimServerInfo o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SBimServerInfo> convertToSListBimServerInfo(Collection<BimServerInfo> input) {
		List<SBimServerInfo> result = new ArrayList<SBimServerInfo>();
		for (BimServerInfo o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<BimServerInfo> convertFromSListBimServerInfo(Collection<SBimServerInfo> input, DatabaseSession session) throws BimserverDatabaseException {
		List<BimServerInfo> result = new ArrayList<BimServerInfo>();
		for (SBimServerInfo o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SBimServerInfo convertToSObject(BimServerInfo input) {
		if (input == null) {
			return null;
		}
		
		SBimServerInfo result = new SBimServerInfo();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setCurrentVersion(input.getCurrentVersion());
		result.setCurrentDate(input.getCurrentDate());
		result.setSchemaVersion(input.getSchemaVersion());
		result.setLatestDate(input.getLatestDate());
		result.setLatestVersion(input.getLatestVersion());
		result.setProjects(input.getProjects());
		result.setRevisions(input.getRevisions());
		result.setUsers(input.getUsers());
		result.setCheckouts(input.getCheckouts());
		result.setServerLogUrl(input.getServerLogUrl());
		result.setStarted(input.getStarted());
		return result;
	}

	public BimServerInfo convertFromSObject(SBimServerInfo input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		BimServerInfo result = convertFromSObject(input, (BimServerInfo)session.create(StorePackage.eINSTANCE.getBimServerInfo()), session);
		
		
		return result;
	}

	public BimServerInfo convertFromSObject(SBimServerInfo input) throws BimserverDatabaseException {
		BimServerInfo result = convertFromSObject(input, StoreFactory.eINSTANCE.createBimServerInfo(), null);
		return result;
	}

	public BimServerInfo convertFromSObject(SBimServerInfo input, BimServerInfo result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setCurrentVersion(input.getCurrentVersion());
		result.setCurrentDate(input.getCurrentDate());
		result.setSchemaVersion(input.getSchemaVersion());
		result.setLatestDate(input.getLatestDate());
		result.setLatestVersion(input.getLatestVersion());
		result.setProjects(input.getProjects());
		result.setRevisions(input.getRevisions());
		result.setUsers(input.getUsers());
		result.setCheckouts(input.getCheckouts());
		result.setServerLogUrl(input.getServerLogUrl());
		result.setStarted(input.getStarted());
		return result;
	}
		public SProgressTopicType convertToSObject(ProgressTopicType input) {
			return SProgressTopicType.values()[input.ordinal()];
		}
		
		public ProgressTopicType convertFromSObject(SProgressTopicType input) {
			return ProgressTopicType.values()[input.ordinal()];
		}

	public Set<SProjectSmall> convertToSSetProjectSmall(Collection<ProjectSmall> input) {
		Set<SProjectSmall> result = new HashSet<SProjectSmall>();
		for (ProjectSmall o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ProjectSmall> convertFromSSetProjectSmall(Collection<SProjectSmall> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ProjectSmall> result = new HashSet<ProjectSmall>();
		for (SProjectSmall o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SProjectSmall> convertToSListProjectSmall(Collection<ProjectSmall> input) {
		List<SProjectSmall> result = new ArrayList<SProjectSmall>();
		for (ProjectSmall o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ProjectSmall> convertFromSListProjectSmall(Collection<SProjectSmall> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ProjectSmall> result = new ArrayList<ProjectSmall>();
		for (SProjectSmall o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SProjectSmall convertToSObject(ProjectSmall input) {
		if (input == null) {
			return null;
		}
		
		SProjectSmall result = new SProjectSmall();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setName(input.getName());
		result.setParentId(input.getParentId());
		result.setState(SObjectState.values()[input.getState().ordinal()]);
		result.setNrRevisions(input.getNrRevisions());
		result.setNrSubProjects(input.getNrSubProjects());
		result.setHasCheckinRights(input.isHasCheckinRights());
		result.setLastRevisionId(input.getLastRevisionId());
		result.setSchema(input.getSchema());
		return result;
	}

	public ProjectSmall convertFromSObject(SProjectSmall input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		ProjectSmall result = convertFromSObject(input, (ProjectSmall)session.create(StorePackage.eINSTANCE.getProjectSmall()), session);
		
		
		return result;
	}

	public ProjectSmall convertFromSObject(SProjectSmall input) throws BimserverDatabaseException {
		ProjectSmall result = convertFromSObject(input, StoreFactory.eINSTANCE.createProjectSmall(), null);
		return result;
	}

	public ProjectSmall convertFromSObject(SProjectSmall input, ProjectSmall result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setName(input.getName());
		result.setParentId(input.getParentId());
		result.setState(ObjectState.values()[input.getState().ordinal()]);
		result.setNrRevisions(input.getNrRevisions());
		result.setNrSubProjects(input.getNrSubProjects());
		result.setHasCheckinRights(input.isHasCheckinRights());
		result.setLastRevisionId(input.getLastRevisionId());
		result.setSchema(input.getSchema());
		return result;
	}

	public Set<SIfcHeader> convertToSSetIfcHeader(Collection<IfcHeader> input) {
		Set<SIfcHeader> result = new HashSet<SIfcHeader>();
		for (IfcHeader o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<IfcHeader> convertFromSSetIfcHeader(Collection<SIfcHeader> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<IfcHeader> result = new HashSet<IfcHeader>();
		for (SIfcHeader o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SIfcHeader> convertToSListIfcHeader(Collection<IfcHeader> input) {
		List<SIfcHeader> result = new ArrayList<SIfcHeader>();
		for (IfcHeader o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<IfcHeader> convertFromSListIfcHeader(Collection<SIfcHeader> input, DatabaseSession session) throws BimserverDatabaseException {
		List<IfcHeader> result = new ArrayList<IfcHeader>();
		for (SIfcHeader o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SIfcHeader convertToSObject(IfcHeader input) {
		if (input == null) {
			return null;
		}
		
		SIfcHeader result = new SIfcHeader();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.getDescription().addAll(input.getDescription());
		result.setImplementationLevel(input.getImplementationLevel());
		result.setFilename(input.getFilename());
		result.setTimeStamp(input.getTimeStamp());
		result.getAuthor().addAll(input.getAuthor());
		result.getOrganization().addAll(input.getOrganization());
		result.setPreProcessorVersion(input.getPreProcessorVersion());
		result.setOriginatingSystem(input.getOriginatingSystem());
		result.setIfcSchemaVersion(input.getIfcSchemaVersion());
		result.setAuthorization(input.getAuthorization());
		return result;
	}

	public IfcHeader convertFromSObject(SIfcHeader input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		IfcHeader result = convertFromSObject(input, (IfcHeader)session.create(StorePackage.eINSTANCE.getIfcHeader()), session);
		
		
		return result;
	}

	public IfcHeader convertFromSObject(SIfcHeader input) throws BimserverDatabaseException {
		IfcHeader result = convertFromSObject(input, StoreFactory.eINSTANCE.createIfcHeader(), null);
		return result;
	}

	public IfcHeader convertFromSObject(SIfcHeader input, IfcHeader result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.getDescription().addAll(input.getDescription());
		result.setImplementationLevel(input.getImplementationLevel());
		result.setFilename(input.getFilename());
		result.setTimeStamp(input.getTimeStamp());
		result.getAuthor().addAll(input.getAuthor());
		result.getOrganization().addAll(input.getOrganization());
		result.setPreProcessorVersion(input.getPreProcessorVersion());
		result.setOriginatingSystem(input.getOriginatingSystem());
		result.setIfcSchemaVersion(input.getIfcSchemaVersion());
		result.setAuthorization(input.getAuthorization());
		return result;
	}

	public Set<SModelCheckerResultItem> convertToSSetModelCheckerResultItem(Collection<ModelCheckerResultItem> input) {
		Set<SModelCheckerResultItem> result = new HashSet<SModelCheckerResultItem>();
		for (ModelCheckerResultItem o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ModelCheckerResultItem> convertFromSSetModelCheckerResultItem(Collection<SModelCheckerResultItem> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ModelCheckerResultItem> result = new HashSet<ModelCheckerResultItem>();
		for (SModelCheckerResultItem o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SModelCheckerResultItem> convertToSListModelCheckerResultItem(Collection<ModelCheckerResultItem> input) {
		List<SModelCheckerResultItem> result = new ArrayList<SModelCheckerResultItem>();
		for (ModelCheckerResultItem o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ModelCheckerResultItem> convertFromSListModelCheckerResultItem(Collection<SModelCheckerResultItem> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ModelCheckerResultItem> result = new ArrayList<ModelCheckerResultItem>();
		for (SModelCheckerResultItem o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SModelCheckerResultItem convertToSObject(ModelCheckerResultItem input) {
		if (input == null) {
			return null;
		}
		
		if (input instanceof ModelCheckerResultHeader) {
			return convertToSObject((ModelCheckerResultHeader)input);
		}
		else if (input instanceof ModelCheckerResultLine) {
			return convertToSObject((ModelCheckerResultLine)input);
		}
		SModelCheckerResultItem result = new SModelCheckerResultItem();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		return result;
	}

	public ModelCheckerResultItem convertFromSObject(SModelCheckerResultItem input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		ModelCheckerResultItem result = convertFromSObject(input, (ModelCheckerResultItem)session.create(StorePackage.eINSTANCE.getModelCheckerResultItem()), session);
		
		
		return result;
	}

	public ModelCheckerResultItem convertFromSObject(SModelCheckerResultItem input) throws BimserverDatabaseException {
		ModelCheckerResultItem result = convertFromSObject(input, StoreFactory.eINSTANCE.createModelCheckerResultItem(), null);
		return result;
	}

	public ModelCheckerResultItem convertFromSObject(SModelCheckerResultItem input, ModelCheckerResultItem result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		if (input instanceof SModelCheckerResultHeader) {
			return convertFromSObject((SModelCheckerResultHeader)input, session);
		}
		else if (input instanceof SModelCheckerResultLine) {
			return convertFromSObject((SModelCheckerResultLine)input, session);
		}
		return result;
	}

	public Set<SModelCheckerResultHeader> convertToSSetModelCheckerResultHeader(Collection<ModelCheckerResultHeader> input) {
		Set<SModelCheckerResultHeader> result = new HashSet<SModelCheckerResultHeader>();
		for (ModelCheckerResultHeader o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ModelCheckerResultHeader> convertFromSSetModelCheckerResultHeader(Collection<SModelCheckerResultHeader> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ModelCheckerResultHeader> result = new HashSet<ModelCheckerResultHeader>();
		for (SModelCheckerResultHeader o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SModelCheckerResultHeader> convertToSListModelCheckerResultHeader(Collection<ModelCheckerResultHeader> input) {
		List<SModelCheckerResultHeader> result = new ArrayList<SModelCheckerResultHeader>();
		for (ModelCheckerResultHeader o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ModelCheckerResultHeader> convertFromSListModelCheckerResultHeader(Collection<SModelCheckerResultHeader> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ModelCheckerResultHeader> result = new ArrayList<ModelCheckerResultHeader>();
		for (SModelCheckerResultHeader o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SModelCheckerResultHeader convertToSObject(ModelCheckerResultHeader input) {
		if (input == null) {
			return null;
		}
		
		SModelCheckerResultHeader result = new SModelCheckerResultHeader();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setText(input.getText());
		return result;
	}

	public ModelCheckerResultHeader convertFromSObject(SModelCheckerResultHeader input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		ModelCheckerResultHeader result = convertFromSObject(input, (ModelCheckerResultHeader)session.create(StorePackage.eINSTANCE.getModelCheckerResultHeader()), session);
		
		
		return result;
	}

	public ModelCheckerResultHeader convertFromSObject(SModelCheckerResultHeader input) throws BimserverDatabaseException {
		ModelCheckerResultHeader result = convertFromSObject(input, StoreFactory.eINSTANCE.createModelCheckerResultHeader(), null);
		return result;
	}

	public ModelCheckerResultHeader convertFromSObject(SModelCheckerResultHeader input, ModelCheckerResultHeader result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setText(input.getText());
		return result;
	}
		public SModelCheckerResultType convertToSObject(ModelCheckerResultType input) {
			return SModelCheckerResultType.values()[input.ordinal()];
		}
		
		public ModelCheckerResultType convertFromSObject(SModelCheckerResultType input) {
			return ModelCheckerResultType.values()[input.ordinal()];
		}

	public Set<SModelCheckerResultLine> convertToSSetModelCheckerResultLine(Collection<ModelCheckerResultLine> input) {
		Set<SModelCheckerResultLine> result = new HashSet<SModelCheckerResultLine>();
		for (ModelCheckerResultLine o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ModelCheckerResultLine> convertFromSSetModelCheckerResultLine(Collection<SModelCheckerResultLine> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ModelCheckerResultLine> result = new HashSet<ModelCheckerResultLine>();
		for (SModelCheckerResultLine o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SModelCheckerResultLine> convertToSListModelCheckerResultLine(Collection<ModelCheckerResultLine> input) {
		List<SModelCheckerResultLine> result = new ArrayList<SModelCheckerResultLine>();
		for (ModelCheckerResultLine o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ModelCheckerResultLine> convertFromSListModelCheckerResultLine(Collection<SModelCheckerResultLine> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ModelCheckerResultLine> result = new ArrayList<ModelCheckerResultLine>();
		for (SModelCheckerResultLine o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SModelCheckerResultLine convertToSObject(ModelCheckerResultLine input) {
		if (input == null) {
			return null;
		}
		
		SModelCheckerResultLine result = new SModelCheckerResultLine();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setFieldOrClass(input.getFieldOrClass());
		result.setValue(input.getValue());
		result.setShouldBe(input.getShouldBe());
		result.setType(SModelCheckerResultType.values()[input.getType().ordinal()]);
		result.setObjectId(input.getObjectId());
		return result;
	}

	public ModelCheckerResultLine convertFromSObject(SModelCheckerResultLine input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		ModelCheckerResultLine result = convertFromSObject(input, (ModelCheckerResultLine)session.create(StorePackage.eINSTANCE.getModelCheckerResultLine()), session);
		
		
		return result;
	}

	public ModelCheckerResultLine convertFromSObject(SModelCheckerResultLine input) throws BimserverDatabaseException {
		ModelCheckerResultLine result = convertFromSObject(input, StoreFactory.eINSTANCE.createModelCheckerResultLine(), null);
		return result;
	}

	public ModelCheckerResultLine convertFromSObject(SModelCheckerResultLine input, ModelCheckerResultLine result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setFieldOrClass(input.getFieldOrClass());
		result.setValue(input.getValue());
		result.setShouldBe(input.getShouldBe());
		result.setType(ModelCheckerResultType.values()[input.getType().ordinal()]);
		result.setObjectId(input.getObjectId());
		return result;
	}

	public Set<SModelCheckerResult> convertToSSetModelCheckerResult(Collection<ModelCheckerResult> input) {
		Set<SModelCheckerResult> result = new HashSet<SModelCheckerResult>();
		for (ModelCheckerResult o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ModelCheckerResult> convertFromSSetModelCheckerResult(Collection<SModelCheckerResult> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ModelCheckerResult> result = new HashSet<ModelCheckerResult>();
		for (SModelCheckerResult o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SModelCheckerResult> convertToSListModelCheckerResult(Collection<ModelCheckerResult> input) {
		List<SModelCheckerResult> result = new ArrayList<SModelCheckerResult>();
		for (ModelCheckerResult o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ModelCheckerResult> convertFromSListModelCheckerResult(Collection<SModelCheckerResult> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ModelCheckerResult> result = new ArrayList<ModelCheckerResult>();
		for (SModelCheckerResult o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SModelCheckerResult convertToSObject(ModelCheckerResult input) {
		if (input == null) {
			return null;
		}
		
		SModelCheckerResult result = new SModelCheckerResult();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setValid(input.isValid());
		List<Long> listitems = new ArrayList<Long>();
		for (ModelCheckerResultItem v : input.getItems()) {
			listitems.add(v.getOid());
		}
		result.setItems(listitems);
		return result;
	}

	public ModelCheckerResult convertFromSObject(SModelCheckerResult input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		ModelCheckerResult result = convertFromSObject(input, (ModelCheckerResult)session.create(StorePackage.eINSTANCE.getModelCheckerResult()), session);
		
		
		return result;
	}

	public ModelCheckerResult convertFromSObject(SModelCheckerResult input) throws BimserverDatabaseException {
		ModelCheckerResult result = convertFromSObject(input, StoreFactory.eINSTANCE.createModelCheckerResult(), null);
		return result;
	}

	public ModelCheckerResult convertFromSObject(SModelCheckerResult input, ModelCheckerResult result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setValid(input.isValid());
		List<ModelCheckerResultItem> listitems = result.getItems();
		for (long oid : input.getItems()) {
			listitems.add((ModelCheckerResultItem)session.get(StorePackage.eINSTANCE.getModelCheckerResultItem(), oid, OldQuery.getDefault()));
		}
		return result;
	}

	public Set<SModelCheckerInstance> convertToSSetModelCheckerInstance(Collection<ModelCheckerInstance> input) {
		Set<SModelCheckerInstance> result = new HashSet<SModelCheckerInstance>();
		for (ModelCheckerInstance o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ModelCheckerInstance> convertFromSSetModelCheckerInstance(Collection<SModelCheckerInstance> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ModelCheckerInstance> result = new HashSet<ModelCheckerInstance>();
		for (SModelCheckerInstance o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SModelCheckerInstance> convertToSListModelCheckerInstance(Collection<ModelCheckerInstance> input) {
		List<SModelCheckerInstance> result = new ArrayList<SModelCheckerInstance>();
		for (ModelCheckerInstance o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ModelCheckerInstance> convertFromSListModelCheckerInstance(Collection<SModelCheckerInstance> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ModelCheckerInstance> result = new ArrayList<ModelCheckerInstance>();
		for (SModelCheckerInstance o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SModelCheckerInstance convertToSObject(ModelCheckerInstance input) {
		if (input == null) {
			return null;
		}
		
		SModelCheckerInstance result = new SModelCheckerInstance();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setName(input.getName());
		result.setDescription(input.getDescription());
		result.setCode(input.getCode());
		result.setCompiled(input.getCompiled());
		result.setValid(input.isValid());
		result.setModelCheckerPluginClassName(input.getModelCheckerPluginClassName());
		return result;
	}

	public ModelCheckerInstance convertFromSObject(SModelCheckerInstance input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		ModelCheckerInstance result = convertFromSObject(input, (ModelCheckerInstance)session.create(StorePackage.eINSTANCE.getModelCheckerInstance()), session);
		
		
		return result;
	}

	public ModelCheckerInstance convertFromSObject(SModelCheckerInstance input) throws BimserverDatabaseException {
		ModelCheckerInstance result = convertFromSObject(input, StoreFactory.eINSTANCE.createModelCheckerInstance(), null);
		return result;
	}

	public ModelCheckerInstance convertFromSObject(SModelCheckerInstance input, ModelCheckerInstance result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setName(input.getName());
		result.setDescription(input.getDescription());
		result.setCode(input.getCode());
		result.setCompiled(input.getCompiled());
		result.setValid(input.isValid());
		result.setModelCheckerPluginClassName(input.getModelCheckerPluginClassName());
		return result;
	}
		public SSmtpProtocol convertToSObject(SmtpProtocol input) {
			return SSmtpProtocol.values()[input.ordinal()];
		}
		
		public SmtpProtocol convertFromSObject(SSmtpProtocol input) {
			return SmtpProtocol.values()[input.ordinal()];
		}

	public Set<SMessagingSerializerPluginConfiguration> convertToSSetMessagingSerializerPluginConfiguration(Collection<MessagingSerializerPluginConfiguration> input) {
		Set<SMessagingSerializerPluginConfiguration> result = new HashSet<SMessagingSerializerPluginConfiguration>();
		for (MessagingSerializerPluginConfiguration o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<MessagingSerializerPluginConfiguration> convertFromSSetMessagingSerializerPluginConfiguration(Collection<SMessagingSerializerPluginConfiguration> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<MessagingSerializerPluginConfiguration> result = new HashSet<MessagingSerializerPluginConfiguration>();
		for (SMessagingSerializerPluginConfiguration o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SMessagingSerializerPluginConfiguration> convertToSListMessagingSerializerPluginConfiguration(Collection<MessagingSerializerPluginConfiguration> input) {
		List<SMessagingSerializerPluginConfiguration> result = new ArrayList<SMessagingSerializerPluginConfiguration>();
		for (MessagingSerializerPluginConfiguration o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<MessagingSerializerPluginConfiguration> convertFromSListMessagingSerializerPluginConfiguration(Collection<SMessagingSerializerPluginConfiguration> input, DatabaseSession session) throws BimserverDatabaseException {
		List<MessagingSerializerPluginConfiguration> result = new ArrayList<MessagingSerializerPluginConfiguration>();
		for (SMessagingSerializerPluginConfiguration o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SMessagingSerializerPluginConfiguration convertToSObject(MessagingSerializerPluginConfiguration input) {
		if (input == null) {
			return null;
		}
		
		SMessagingSerializerPluginConfiguration result = new SMessagingSerializerPluginConfiguration();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setName(input.getName());
		result.setEnabled(input.getEnabled());
		result.setDescription(input.getDescription());
		result.setStreaming(input.isStreaming());
		PluginDescriptor pluginDescriptorVal = input.getPluginDescriptor();
		result.setPluginDescriptorId(pluginDescriptorVal == null ? -1 : pluginDescriptorVal.getOid());
		ObjectType settingsVal = input.getSettings();
		result.setSettingsId(settingsVal == null ? -1 : settingsVal.getOid());
		ObjectIDMPluginConfiguration objectIDMVal = input.getObjectIDM();
		result.setObjectIDMId(objectIDMVal == null ? -1 : objectIDMVal.getOid());
		UserSettings userSettingsVal = input.getUserSettings();
		result.setUserSettingsId(userSettingsVal == null ? -1 : userSettingsVal.getOid());
		RenderEnginePluginConfiguration renderEngineVal = input.getRenderEngine();
		result.setRenderEngineId(renderEngineVal == null ? -1 : renderEngineVal.getOid());
		return result;
	}

	public MessagingSerializerPluginConfiguration convertFromSObject(SMessagingSerializerPluginConfiguration input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		MessagingSerializerPluginConfiguration result = convertFromSObject(input, (MessagingSerializerPluginConfiguration)session.create(StorePackage.eINSTANCE.getMessagingSerializerPluginConfiguration()), session);
		
		
		return result;
	}

	public MessagingSerializerPluginConfiguration convertFromSObject(SMessagingSerializerPluginConfiguration input) throws BimserverDatabaseException {
		MessagingSerializerPluginConfiguration result = convertFromSObject(input, StoreFactory.eINSTANCE.createMessagingSerializerPluginConfiguration(), null);
		return result;
	}

	public MessagingSerializerPluginConfiguration convertFromSObject(SMessagingSerializerPluginConfiguration input, MessagingSerializerPluginConfiguration result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setName(input.getName());
		result.setEnabled(input.getEnabled());
		result.setDescription(input.getDescription());
		result.setStreaming(input.isStreaming());
		result.setPluginDescriptor((PluginDescriptor)session.get(StorePackage.eINSTANCE.getPluginDescriptor(), input.getPluginDescriptorId(), OldQuery.getDefault()));
		result.setSettings((ObjectType)session.get(StorePackage.eINSTANCE.getObjectType(), input.getSettingsId(), OldQuery.getDefault()));
		result.setObjectIDM((ObjectIDMPluginConfiguration)session.get(StorePackage.eINSTANCE.getObjectIDMPluginConfiguration(), input.getObjectIDMId(), OldQuery.getDefault()));
		result.setUserSettings((UserSettings)session.get(StorePackage.eINSTANCE.getUserSettings(), input.getUserSettingsId(), OldQuery.getDefault()));
		result.setRenderEngine((RenderEnginePluginConfiguration)session.get(StorePackage.eINSTANCE.getRenderEnginePluginConfiguration(), input.getRenderEngineId(), OldQuery.getDefault()));
		return result;
	}

	public Set<SMetrics> convertToSSetMetrics(Collection<Metrics> input) {
		Set<SMetrics> result = new HashSet<SMetrics>();
		for (Metrics o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<Metrics> convertFromSSetMetrics(Collection<SMetrics> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<Metrics> result = new HashSet<Metrics>();
		for (SMetrics o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SMetrics> convertToSListMetrics(Collection<Metrics> input) {
		List<SMetrics> result = new ArrayList<SMetrics>();
		for (Metrics o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<Metrics> convertFromSListMetrics(Collection<SMetrics> input, DatabaseSession session) throws BimserverDatabaseException {
		List<Metrics> result = new ArrayList<Metrics>();
		for (SMetrics o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SMetrics convertToSObject(Metrics input) {
		if (input == null) {
			return null;
		}
		
		SMetrics result = new SMetrics();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		List<SInterfaceMetric> listinterfaces = new ArrayList<SInterfaceMetric>();
		for (InterfaceMetric v : input.getInterfaces()) {
			listinterfaces.add(convertToSObject(v));
		}
		result.setInterfaces(listinterfaces);
		return result;
	}

	public Metrics convertFromSObject(SMetrics input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		Metrics result = convertFromSObject(input, (Metrics)session.create(StorePackage.eINSTANCE.getMetrics()), session);
		
		
		return result;
	}

	public Metrics convertFromSObject(SMetrics input) throws BimserverDatabaseException {
		Metrics result = convertFromSObject(input, StoreFactory.eINSTANCE.createMetrics(), null);
		return result;
	}

	public Metrics convertFromSObject(SMetrics input, Metrics result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		List<InterfaceMetric> listinterfaces = result.getInterfaces();
		for (SInterfaceMetric v : input.getInterfaces()) {
			listinterfaces.add(convertFromSObject(v, session));
		}
		return result;
	}

	public Set<SInterfaceMetric> convertToSSetInterfaceMetric(Collection<InterfaceMetric> input) {
		Set<SInterfaceMetric> result = new HashSet<SInterfaceMetric>();
		for (InterfaceMetric o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<InterfaceMetric> convertFromSSetInterfaceMetric(Collection<SInterfaceMetric> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<InterfaceMetric> result = new HashSet<InterfaceMetric>();
		for (SInterfaceMetric o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SInterfaceMetric> convertToSListInterfaceMetric(Collection<InterfaceMetric> input) {
		List<SInterfaceMetric> result = new ArrayList<SInterfaceMetric>();
		for (InterfaceMetric o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<InterfaceMetric> convertFromSListInterfaceMetric(Collection<SInterfaceMetric> input, DatabaseSession session) throws BimserverDatabaseException {
		List<InterfaceMetric> result = new ArrayList<InterfaceMetric>();
		for (SInterfaceMetric o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SInterfaceMetric convertToSObject(InterfaceMetric input) {
		if (input == null) {
			return null;
		}
		
		SInterfaceMetric result = new SInterfaceMetric();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setName(input.getName());
		List<SMethodMetric> listmethods = new ArrayList<SMethodMetric>();
		for (MethodMetric v : input.getMethods()) {
			listmethods.add(convertToSObject(v));
		}
		result.setMethods(listmethods);
		return result;
	}

	public InterfaceMetric convertFromSObject(SInterfaceMetric input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		InterfaceMetric result = convertFromSObject(input, (InterfaceMetric)session.create(StorePackage.eINSTANCE.getInterfaceMetric()), session);
		
		
		return result;
	}

	public InterfaceMetric convertFromSObject(SInterfaceMetric input) throws BimserverDatabaseException {
		InterfaceMetric result = convertFromSObject(input, StoreFactory.eINSTANCE.createInterfaceMetric(), null);
		return result;
	}

	public InterfaceMetric convertFromSObject(SInterfaceMetric input, InterfaceMetric result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setName(input.getName());
		List<MethodMetric> listmethods = result.getMethods();
		for (SMethodMetric v : input.getMethods()) {
			listmethods.add(convertFromSObject(v, session));
		}
		return result;
	}

	public Set<SMethodMetric> convertToSSetMethodMetric(Collection<MethodMetric> input) {
		Set<SMethodMetric> result = new HashSet<SMethodMetric>();
		for (MethodMetric o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<MethodMetric> convertFromSSetMethodMetric(Collection<SMethodMetric> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<MethodMetric> result = new HashSet<MethodMetric>();
		for (SMethodMetric o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SMethodMetric> convertToSListMethodMetric(Collection<MethodMetric> input) {
		List<SMethodMetric> result = new ArrayList<SMethodMetric>();
		for (MethodMetric o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<MethodMetric> convertFromSListMethodMetric(Collection<SMethodMetric> input, DatabaseSession session) throws BimserverDatabaseException {
		List<MethodMetric> result = new ArrayList<MethodMetric>();
		for (SMethodMetric o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SMethodMetric convertToSObject(MethodMetric input) {
		if (input == null) {
			return null;
		}
		
		SMethodMetric result = new SMethodMetric();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setName(input.getName());
		result.setNrCalls(input.getNrCalls());
		result.setLastCall(input.getLastCall());
		result.setAverageMs(input.getAverageMs());
		result.setShortestMs(input.getShortestMs());
		result.setLongestMs(input.getLongestMs());
		return result;
	}

	public MethodMetric convertFromSObject(SMethodMetric input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		MethodMetric result = convertFromSObject(input, (MethodMetric)session.create(StorePackage.eINSTANCE.getMethodMetric()), session);
		
		
		return result;
	}

	public MethodMetric convertFromSObject(SMethodMetric input) throws BimserverDatabaseException {
		MethodMetric result = convertFromSObject(input, StoreFactory.eINSTANCE.createMethodMetric(), null);
		return result;
	}

	public MethodMetric convertFromSObject(SMethodMetric input, MethodMetric result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setName(input.getName());
		result.setNrCalls(input.getNrCalls());
		result.setLastCall(input.getLastCall());
		result.setAverageMs(input.getAverageMs());
		result.setShortestMs(input.getShortestMs());
		result.setLongestMs(input.getLongestMs());
		return result;
	}

	public Set<SPluginBundleVersion> convertToSSetPluginBundleVersion(Collection<PluginBundleVersion> input) {
		Set<SPluginBundleVersion> result = new HashSet<SPluginBundleVersion>();
		for (PluginBundleVersion o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<PluginBundleVersion> convertFromSSetPluginBundleVersion(Collection<SPluginBundleVersion> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<PluginBundleVersion> result = new HashSet<PluginBundleVersion>();
		for (SPluginBundleVersion o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SPluginBundleVersion> convertToSListPluginBundleVersion(Collection<PluginBundleVersion> input) {
		List<SPluginBundleVersion> result = new ArrayList<SPluginBundleVersion>();
		for (PluginBundleVersion o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<PluginBundleVersion> convertFromSListPluginBundleVersion(Collection<SPluginBundleVersion> input, DatabaseSession session) throws BimserverDatabaseException {
		List<PluginBundleVersion> result = new ArrayList<PluginBundleVersion>();
		for (SPluginBundleVersion o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SPluginBundleVersion convertToSObject(PluginBundleVersion input) {
		if (input == null) {
			return null;
		}
		
		SPluginBundleVersion result = new SPluginBundleVersion();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setVersion(input.getVersion());
		result.setType(SPluginBundleType.values()[input.getType().ordinal()]);
		result.setDescription(input.getDescription());
		result.setMismatch(input.isMismatch());
		result.setRepository(input.getRepository());
		result.setGroupId(input.getGroupId());
		result.setArtifactId(input.getArtifactId());
		result.setIcon(input.getIcon());
		result.setOrganization(input.getOrganization());
		result.setName(input.getName());
		result.setDate(input.getDate());
		return result;
	}

	public PluginBundleVersion convertFromSObject(SPluginBundleVersion input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		PluginBundleVersion result = convertFromSObject(input, (PluginBundleVersion)session.create(StorePackage.eINSTANCE.getPluginBundleVersion()), session);
		
		
		return result;
	}

	public PluginBundleVersion convertFromSObject(SPluginBundleVersion input) throws BimserverDatabaseException {
		PluginBundleVersion result = convertFromSObject(input, StoreFactory.eINSTANCE.createPluginBundleVersion(), null);
		return result;
	}

	public PluginBundleVersion convertFromSObject(SPluginBundleVersion input, PluginBundleVersion result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setVersion(input.getVersion());
		result.setType(PluginBundleType.values()[input.getType().ordinal()]);
		result.setDescription(input.getDescription());
		result.setMismatch(input.isMismatch());
		result.setRepository(input.getRepository());
		result.setGroupId(input.getGroupId());
		result.setArtifactId(input.getArtifactId());
		result.setIcon(input.getIcon());
		result.setOrganization(input.getOrganization());
		result.setName(input.getName());
		result.setDate(input.getDate());
		return result;
	}
		public SPluginBundleType convertToSObject(PluginBundleType input) {
			return SPluginBundleType.values()[input.ordinal()];
		}
		
		public PluginBundleType convertFromSObject(SPluginBundleType input) {
			return PluginBundleType.values()[input.ordinal()];
		}
		public SPluginType convertToSObject(PluginType input) {
			return SPluginType.values()[input.ordinal()];
		}
		
		public PluginType convertFromSObject(SPluginType input) {
			return PluginType.values()[input.ordinal()];
		}

	public Set<SPluginBundle> convertToSSetPluginBundle(Collection<PluginBundle> input) {
		Set<SPluginBundle> result = new HashSet<SPluginBundle>();
		for (PluginBundle o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<PluginBundle> convertFromSSetPluginBundle(Collection<SPluginBundle> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<PluginBundle> result = new HashSet<PluginBundle>();
		for (SPluginBundle o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SPluginBundle> convertToSListPluginBundle(Collection<PluginBundle> input) {
		List<SPluginBundle> result = new ArrayList<SPluginBundle>();
		for (PluginBundle o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<PluginBundle> convertFromSListPluginBundle(Collection<SPluginBundle> input, DatabaseSession session) throws BimserverDatabaseException {
		List<PluginBundle> result = new ArrayList<PluginBundle>();
		for (SPluginBundle o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SPluginBundle convertToSObject(PluginBundle input) {
		if (input == null) {
			return null;
		}
		
		SPluginBundle result = new SPluginBundle();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setOrganization(input.getOrganization());
		result.setName(input.getName());
		PluginBundleVersion latestVersionVal = input.getLatestVersion();
		result.setLatestVersion(convertToSObject(latestVersionVal));
		List<SPluginBundleVersion> listavailableVersions = new ArrayList<SPluginBundleVersion>();
		for (PluginBundleVersion v : input.getAvailableVersions()) {
			listavailableVersions.add(convertToSObject(v));
		}
		result.setAvailableVersions(listavailableVersions);
		PluginBundleVersion installedVersionVal = input.getInstalledVersion();
		result.setInstalledVersion(convertToSObject(installedVersionVal));
		return result;
	}

	public PluginBundle convertFromSObject(SPluginBundle input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		PluginBundle result = convertFromSObject(input, (PluginBundle)session.create(StorePackage.eINSTANCE.getPluginBundle()), session);
		
		
		return result;
	}

	public PluginBundle convertFromSObject(SPluginBundle input) throws BimserverDatabaseException {
		PluginBundle result = convertFromSObject(input, StoreFactory.eINSTANCE.createPluginBundle(), null);
		return result;
	}

	public PluginBundle convertFromSObject(SPluginBundle input, PluginBundle result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setOrganization(input.getOrganization());
		result.setName(input.getName());
		result.setLatestVersion(convertFromSObject(input.getLatestVersion(), session));
		List<PluginBundleVersion> listavailableVersions = result.getAvailableVersions();
		for (SPluginBundleVersion v : input.getAvailableVersions()) {
			listavailableVersions.add(convertFromSObject(v, session));
		}
		result.setInstalledVersion(convertFromSObject(input.getInstalledVersion(), session));
		return result;
	}

	public Set<SPluginInformation> convertToSSetPluginInformation(Collection<PluginInformation> input) {
		Set<SPluginInformation> result = new HashSet<SPluginInformation>();
		for (PluginInformation o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<PluginInformation> convertFromSSetPluginInformation(Collection<SPluginInformation> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<PluginInformation> result = new HashSet<PluginInformation>();
		for (SPluginInformation o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SPluginInformation> convertToSListPluginInformation(Collection<PluginInformation> input) {
		List<SPluginInformation> result = new ArrayList<SPluginInformation>();
		for (PluginInformation o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<PluginInformation> convertFromSListPluginInformation(Collection<SPluginInformation> input, DatabaseSession session) throws BimserverDatabaseException {
		List<PluginInformation> result = new ArrayList<PluginInformation>();
		for (SPluginInformation o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SPluginInformation convertToSObject(PluginInformation input) {
		if (input == null) {
			return null;
		}
		
		SPluginInformation result = new SPluginInformation();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setName(input.getName());
		result.setType(SPluginType.values()[input.getType().ordinal()]);
		result.setDescription(input.getDescription());
		result.setEnabled(input.isEnabled());
		result.setIdentifier(input.getIdentifier());
		result.setInstallForAllUsers(input.isInstallForAllUsers());
		result.setInstallForNewUsers(input.isInstallForNewUsers());
		return result;
	}

	public PluginInformation convertFromSObject(SPluginInformation input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		PluginInformation result = convertFromSObject(input, (PluginInformation)session.create(StorePackage.eINSTANCE.getPluginInformation()), session);
		
		
		return result;
	}

	public PluginInformation convertFromSObject(SPluginInformation input) throws BimserverDatabaseException {
		PluginInformation result = convertFromSObject(input, StoreFactory.eINSTANCE.createPluginInformation(), null);
		return result;
	}

	public PluginInformation convertFromSObject(SPluginInformation input, PluginInformation result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setName(input.getName());
		result.setType(PluginType.values()[input.getType().ordinal()]);
		result.setDescription(input.getDescription());
		result.setEnabled(input.isEnabled());
		result.setIdentifier(input.getIdentifier());
		result.setInstallForAllUsers(input.isInstallForAllUsers());
		result.setInstallForNewUsers(input.isInstallForNewUsers());
		return result;
	}

	public Set<SOAuthServer> convertToSSetOAuthServer(Collection<OAuthServer> input) {
		Set<SOAuthServer> result = new HashSet<SOAuthServer>();
		for (OAuthServer o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<OAuthServer> convertFromSSetOAuthServer(Collection<SOAuthServer> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<OAuthServer> result = new HashSet<OAuthServer>();
		for (SOAuthServer o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SOAuthServer> convertToSListOAuthServer(Collection<OAuthServer> input) {
		List<SOAuthServer> result = new ArrayList<SOAuthServer>();
		for (OAuthServer o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<OAuthServer> convertFromSListOAuthServer(Collection<SOAuthServer> input, DatabaseSession session) throws BimserverDatabaseException {
		List<OAuthServer> result = new ArrayList<OAuthServer>();
		for (SOAuthServer o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SOAuthServer convertToSObject(OAuthServer input) {
		if (input == null) {
			return null;
		}
		
		SOAuthServer result = new SOAuthServer();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setRegistrationUrl(input.getRegistrationUrl());
		result.setClientId(input.getClientId());
		result.setClientSecret(input.getClientSecret());
		result.setClientName(input.getClientName());
		result.setClientIcon(input.getClientIcon());
		result.setClientUrl(input.getClientUrl());
		result.setClientDescription(input.getClientDescription());
		result.setRedirectUrl(input.getRedirectUrl());
		result.setExpiresAt(input.getExpiresAt());
		result.setIssuedAt(input.getIssuedAt());
		result.setIncoming(input.isIncoming());
		result.setApiUrl(input.getApiUrl());
		result.setRegistrationEndpoint(input.getRegistrationEndpoint());
		return result;
	}

	public OAuthServer convertFromSObject(SOAuthServer input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		OAuthServer result = convertFromSObject(input, (OAuthServer)session.create(StorePackage.eINSTANCE.getOAuthServer()), session);
		
		
		return result;
	}

	public OAuthServer convertFromSObject(SOAuthServer input) throws BimserverDatabaseException {
		OAuthServer result = convertFromSObject(input, StoreFactory.eINSTANCE.createOAuthServer(), null);
		return result;
	}

	public OAuthServer convertFromSObject(SOAuthServer input, OAuthServer result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setRegistrationUrl(input.getRegistrationUrl());
		result.setClientId(input.getClientId());
		result.setClientSecret(input.getClientSecret());
		result.setClientName(input.getClientName());
		result.setClientIcon(input.getClientIcon());
		result.setClientUrl(input.getClientUrl());
		result.setClientDescription(input.getClientDescription());
		result.setRedirectUrl(input.getRedirectUrl());
		result.setExpiresAt(input.getExpiresAt());
		result.setIssuedAt(input.getIssuedAt());
		result.setIncoming(input.isIncoming());
		result.setApiUrl(input.getApiUrl());
		result.setRegistrationEndpoint(input.getRegistrationEndpoint());
		return result;
	}

	public Set<SOAuthAuthorizationCode> convertToSSetOAuthAuthorizationCode(Collection<OAuthAuthorizationCode> input) {
		Set<SOAuthAuthorizationCode> result = new HashSet<SOAuthAuthorizationCode>();
		for (OAuthAuthorizationCode o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<OAuthAuthorizationCode> convertFromSSetOAuthAuthorizationCode(Collection<SOAuthAuthorizationCode> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<OAuthAuthorizationCode> result = new HashSet<OAuthAuthorizationCode>();
		for (SOAuthAuthorizationCode o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SOAuthAuthorizationCode> convertToSListOAuthAuthorizationCode(Collection<OAuthAuthorizationCode> input) {
		List<SOAuthAuthorizationCode> result = new ArrayList<SOAuthAuthorizationCode>();
		for (OAuthAuthorizationCode o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<OAuthAuthorizationCode> convertFromSListOAuthAuthorizationCode(Collection<SOAuthAuthorizationCode> input, DatabaseSession session) throws BimserverDatabaseException {
		List<OAuthAuthorizationCode> result = new ArrayList<OAuthAuthorizationCode>();
		for (SOAuthAuthorizationCode o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SOAuthAuthorizationCode convertToSObject(OAuthAuthorizationCode input) {
		if (input == null) {
			return null;
		}
		
		SOAuthAuthorizationCode result = new SOAuthAuthorizationCode();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setCode(input.getCode());
		result.setIssued(input.getIssued());
		OAuthServer oauthServerVal = input.getOauthServer();
		result.setOauthServerId(oauthServerVal == null ? -1 : oauthServerVal.getOid());
		Authorization authorizationVal = input.getAuthorization();
		result.setAuthorizationId(authorizationVal == null ? -1 : authorizationVal.getOid());
		User userVal = input.getUser();
		result.setUserId(userVal == null ? -1 : userVal.getOid());
		return result;
	}

	public OAuthAuthorizationCode convertFromSObject(SOAuthAuthorizationCode input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		OAuthAuthorizationCode result = convertFromSObject(input, (OAuthAuthorizationCode)session.create(StorePackage.eINSTANCE.getOAuthAuthorizationCode()), session);
		
		
		return result;
	}

	public OAuthAuthorizationCode convertFromSObject(SOAuthAuthorizationCode input) throws BimserverDatabaseException {
		OAuthAuthorizationCode result = convertFromSObject(input, StoreFactory.eINSTANCE.createOAuthAuthorizationCode(), null);
		return result;
	}

	public OAuthAuthorizationCode convertFromSObject(SOAuthAuthorizationCode input, OAuthAuthorizationCode result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setCode(input.getCode());
		result.setIssued(input.getIssued());
		result.setOauthServer((OAuthServer)session.get(StorePackage.eINSTANCE.getOAuthServer(), input.getOauthServerId(), OldQuery.getDefault()));
		result.setAuthorization((Authorization)session.get(StorePackage.eINSTANCE.getAuthorization(), input.getAuthorizationId(), OldQuery.getDefault()));
		result.setUser((User)session.get(StorePackage.eINSTANCE.getUser(), input.getUserId(), OldQuery.getDefault()));
		return result;
	}

	public Set<SAuthorization> convertToSSetAuthorization(Collection<Authorization> input) {
		Set<SAuthorization> result = new HashSet<SAuthorization>();
		for (Authorization o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<Authorization> convertFromSSetAuthorization(Collection<SAuthorization> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<Authorization> result = new HashSet<Authorization>();
		for (SAuthorization o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SAuthorization> convertToSListAuthorization(Collection<Authorization> input) {
		List<SAuthorization> result = new ArrayList<SAuthorization>();
		for (Authorization o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<Authorization> convertFromSListAuthorization(Collection<SAuthorization> input, DatabaseSession session) throws BimserverDatabaseException {
		List<Authorization> result = new ArrayList<Authorization>();
		for (SAuthorization o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SAuthorization convertToSObject(Authorization input) {
		if (input == null) {
			return null;
		}
		
		if (input instanceof RunServiceAuthorization) {
			return convertToSObject((RunServiceAuthorization)input);
		}
		else if (input instanceof SingleProjectAuthorization) {
			return convertToSObject((SingleProjectAuthorization)input);
		}
		SAuthorization result = new SAuthorization();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		return result;
	}

	public Authorization convertFromSObject(SAuthorization input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		Authorization result = convertFromSObject(input, (Authorization)session.create(StorePackage.eINSTANCE.getAuthorization()), session);
		
		
		return result;
	}

	public Authorization convertFromSObject(SAuthorization input) throws BimserverDatabaseException {
		Authorization result = convertFromSObject(input, StoreFactory.eINSTANCE.createAuthorization(), null);
		return result;
	}

	public Authorization convertFromSObject(SAuthorization input, Authorization result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		if (input instanceof SRunServiceAuthorization) {
			return convertFromSObject((SRunServiceAuthorization)input, session);
		}
		else if (input instanceof SSingleProjectAuthorization) {
			return convertFromSObject((SSingleProjectAuthorization)input, session);
		}
		return result;
	}

	public Set<SSingleProjectAuthorization> convertToSSetSingleProjectAuthorization(Collection<SingleProjectAuthorization> input) {
		Set<SSingleProjectAuthorization> result = new HashSet<SSingleProjectAuthorization>();
		for (SingleProjectAuthorization o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<SingleProjectAuthorization> convertFromSSetSingleProjectAuthorization(Collection<SSingleProjectAuthorization> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<SingleProjectAuthorization> result = new HashSet<SingleProjectAuthorization>();
		for (SSingleProjectAuthorization o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SSingleProjectAuthorization> convertToSListSingleProjectAuthorization(Collection<SingleProjectAuthorization> input) {
		List<SSingleProjectAuthorization> result = new ArrayList<SSingleProjectAuthorization>();
		for (SingleProjectAuthorization o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<SingleProjectAuthorization> convertFromSListSingleProjectAuthorization(Collection<SSingleProjectAuthorization> input, DatabaseSession session) throws BimserverDatabaseException {
		List<SingleProjectAuthorization> result = new ArrayList<SingleProjectAuthorization>();
		for (SSingleProjectAuthorization o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SSingleProjectAuthorization convertToSObject(SingleProjectAuthorization input) {
		if (input == null) {
			return null;
		}
		
		SSingleProjectAuthorization result = new SSingleProjectAuthorization();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		Project projectVal = input.getProject();
		result.setProjectId(projectVal == null ? -1 : projectVal.getOid());
		return result;
	}

	public SingleProjectAuthorization convertFromSObject(SSingleProjectAuthorization input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		SingleProjectAuthorization result = convertFromSObject(input, (SingleProjectAuthorization)session.create(StorePackage.eINSTANCE.getSingleProjectAuthorization()), session);
		
		
		return result;
	}

	public SingleProjectAuthorization convertFromSObject(SSingleProjectAuthorization input) throws BimserverDatabaseException {
		SingleProjectAuthorization result = convertFromSObject(input, StoreFactory.eINSTANCE.createSingleProjectAuthorization(), null);
		return result;
	}

	public SingleProjectAuthorization convertFromSObject(SSingleProjectAuthorization input, SingleProjectAuthorization result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setProject((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getProjectId(), OldQuery.getDefault()));
		return result;
	}

	public Set<SNewServiceDescriptor> convertToSSetNewServiceDescriptor(Collection<NewServiceDescriptor> input) {
		Set<SNewServiceDescriptor> result = new HashSet<SNewServiceDescriptor>();
		for (NewServiceDescriptor o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<NewServiceDescriptor> convertFromSSetNewServiceDescriptor(Collection<SNewServiceDescriptor> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<NewServiceDescriptor> result = new HashSet<NewServiceDescriptor>();
		for (SNewServiceDescriptor o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SNewServiceDescriptor> convertToSListNewServiceDescriptor(Collection<NewServiceDescriptor> input) {
		List<SNewServiceDescriptor> result = new ArrayList<SNewServiceDescriptor>();
		for (NewServiceDescriptor o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<NewServiceDescriptor> convertFromSListNewServiceDescriptor(Collection<SNewServiceDescriptor> input, DatabaseSession session) throws BimserverDatabaseException {
		List<NewServiceDescriptor> result = new ArrayList<NewServiceDescriptor>();
		for (SNewServiceDescriptor o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SNewServiceDescriptor convertToSObject(NewServiceDescriptor input) {
		if (input == null) {
			return null;
		}
		
		SNewServiceDescriptor result = new SNewServiceDescriptor();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setName(input.getName());
		result.setDescription(input.getDescription());
		result.setProvider(input.getProvider());
		result.setAuthorizationUrl(input.getAuthorizationUrl());
		result.setTokenUrl(input.getTokenUrl());
		result.setResourceUrl(input.getResourceUrl());
		result.setRegisterUrl(input.getRegisterUrl());
		result.getInputs().addAll(input.getInputs());
		result.getOutputs().addAll(input.getOutputs());
		return result;
	}

	public NewServiceDescriptor convertFromSObject(SNewServiceDescriptor input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		NewServiceDescriptor result = convertFromSObject(input, (NewServiceDescriptor)session.create(StorePackage.eINSTANCE.getNewServiceDescriptor()), session);
		
		
		return result;
	}

	public NewServiceDescriptor convertFromSObject(SNewServiceDescriptor input) throws BimserverDatabaseException {
		NewServiceDescriptor result = convertFromSObject(input, StoreFactory.eINSTANCE.createNewServiceDescriptor(), null);
		return result;
	}

	public NewServiceDescriptor convertFromSObject(SNewServiceDescriptor input, NewServiceDescriptor result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setName(input.getName());
		result.setDescription(input.getDescription());
		result.setProvider(input.getProvider());
		result.setAuthorizationUrl(input.getAuthorizationUrl());
		result.setTokenUrl(input.getTokenUrl());
		result.setResourceUrl(input.getResourceUrl());
		result.setRegisterUrl(input.getRegisterUrl());
		result.getInputs().addAll(input.getInputs());
		result.getOutputs().addAll(input.getOutputs());
		return result;
	}

	public Set<SFormatSerializerMap> convertToSSetFormatSerializerMap(Collection<FormatSerializerMap> input) {
		Set<SFormatSerializerMap> result = new HashSet<SFormatSerializerMap>();
		for (FormatSerializerMap o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<FormatSerializerMap> convertFromSSetFormatSerializerMap(Collection<SFormatSerializerMap> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<FormatSerializerMap> result = new HashSet<FormatSerializerMap>();
		for (SFormatSerializerMap o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SFormatSerializerMap> convertToSListFormatSerializerMap(Collection<FormatSerializerMap> input) {
		List<SFormatSerializerMap> result = new ArrayList<SFormatSerializerMap>();
		for (FormatSerializerMap o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<FormatSerializerMap> convertFromSListFormatSerializerMap(Collection<SFormatSerializerMap> input, DatabaseSession session) throws BimserverDatabaseException {
		List<FormatSerializerMap> result = new ArrayList<FormatSerializerMap>();
		for (SFormatSerializerMap o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SFormatSerializerMap convertToSObject(FormatSerializerMap input) {
		if (input == null) {
			return null;
		}
		
		SFormatSerializerMap result = new SFormatSerializerMap();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setFormat(input.getFormat());
		List<SSerializerPluginConfiguration> listserializers = new ArrayList<SSerializerPluginConfiguration>();
		for (SerializerPluginConfiguration v : input.getSerializers()) {
			listserializers.add(convertToSObject(v));
		}
		result.setSerializers(listserializers);
		return result;
	}

	public FormatSerializerMap convertFromSObject(SFormatSerializerMap input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		FormatSerializerMap result = convertFromSObject(input, (FormatSerializerMap)session.create(StorePackage.eINSTANCE.getFormatSerializerMap()), session);
		
		
		return result;
	}

	public FormatSerializerMap convertFromSObject(SFormatSerializerMap input) throws BimserverDatabaseException {
		FormatSerializerMap result = convertFromSObject(input, StoreFactory.eINSTANCE.createFormatSerializerMap(), null);
		return result;
	}

	public FormatSerializerMap convertFromSObject(SFormatSerializerMap input, FormatSerializerMap result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setFormat(input.getFormat());
		List<SerializerPluginConfiguration> listserializers = result.getSerializers();
		for (SSerializerPluginConfiguration v : input.getSerializers()) {
			listserializers.add(convertFromSObject(v, session));
		}
		return result;
	}

	public Set<SAction> convertToSSetAction(Collection<Action> input) {
		Set<SAction> result = new HashSet<SAction>();
		for (Action o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<Action> convertFromSSetAction(Collection<SAction> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<Action> result = new HashSet<Action>();
		for (SAction o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SAction> convertToSListAction(Collection<Action> input) {
		List<SAction> result = new ArrayList<SAction>();
		for (Action o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<Action> convertFromSListAction(Collection<SAction> input, DatabaseSession session) throws BimserverDatabaseException {
		List<Action> result = new ArrayList<Action>();
		for (SAction o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SAction convertToSObject(Action input) {
		if (input == null) {
			return null;
		}
		
		if (input instanceof CheckinRevision) {
			return convertToSObject((CheckinRevision)input);
		}
		else if (input instanceof StoreExtendedData) {
			return convertToSObject((StoreExtendedData)input);
		}
		SAction result = new SAction();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		return result;
	}

	public Action convertFromSObject(SAction input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		Action result = convertFromSObject(input, (Action)session.create(StorePackage.eINSTANCE.getAction()), session);
		
		
		return result;
	}

	public Action convertFromSObject(SAction input) throws BimserverDatabaseException {
		Action result = convertFromSObject(input, StoreFactory.eINSTANCE.createAction(), null);
		return result;
	}

	public Action convertFromSObject(SAction input, Action result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		if (input instanceof SCheckinRevision) {
			return convertFromSObject((SCheckinRevision)input, session);
		}
		else if (input instanceof SStoreExtendedData) {
			return convertFromSObject((SStoreExtendedData)input, session);
		}
		return result;
	}

	public Set<SStoreExtendedData> convertToSSetStoreExtendedData(Collection<StoreExtendedData> input) {
		Set<SStoreExtendedData> result = new HashSet<SStoreExtendedData>();
		for (StoreExtendedData o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<StoreExtendedData> convertFromSSetStoreExtendedData(Collection<SStoreExtendedData> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<StoreExtendedData> result = new HashSet<StoreExtendedData>();
		for (SStoreExtendedData o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SStoreExtendedData> convertToSListStoreExtendedData(Collection<StoreExtendedData> input) {
		List<SStoreExtendedData> result = new ArrayList<SStoreExtendedData>();
		for (StoreExtendedData o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<StoreExtendedData> convertFromSListStoreExtendedData(Collection<SStoreExtendedData> input, DatabaseSession session) throws BimserverDatabaseException {
		List<StoreExtendedData> result = new ArrayList<StoreExtendedData>();
		for (SStoreExtendedData o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SStoreExtendedData convertToSObject(StoreExtendedData input) {
		if (input == null) {
			return null;
		}
		
		SStoreExtendedData result = new SStoreExtendedData();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		return result;
	}

	public StoreExtendedData convertFromSObject(SStoreExtendedData input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		StoreExtendedData result = convertFromSObject(input, (StoreExtendedData)session.create(StorePackage.eINSTANCE.getStoreExtendedData()), session);
		
		
		return result;
	}

	public StoreExtendedData convertFromSObject(SStoreExtendedData input) throws BimserverDatabaseException {
		StoreExtendedData result = convertFromSObject(input, StoreFactory.eINSTANCE.createStoreExtendedData(), null);
		return result;
	}

	public StoreExtendedData convertFromSObject(SStoreExtendedData input, StoreExtendedData result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		return result;
	}

	public Set<SCheckinRevision> convertToSSetCheckinRevision(Collection<CheckinRevision> input) {
		Set<SCheckinRevision> result = new HashSet<SCheckinRevision>();
		for (CheckinRevision o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<CheckinRevision> convertFromSSetCheckinRevision(Collection<SCheckinRevision> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<CheckinRevision> result = new HashSet<CheckinRevision>();
		for (SCheckinRevision o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SCheckinRevision> convertToSListCheckinRevision(Collection<CheckinRevision> input) {
		List<SCheckinRevision> result = new ArrayList<SCheckinRevision>();
		for (CheckinRevision o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<CheckinRevision> convertFromSListCheckinRevision(Collection<SCheckinRevision> input, DatabaseSession session) throws BimserverDatabaseException {
		List<CheckinRevision> result = new ArrayList<CheckinRevision>();
		for (SCheckinRevision o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SCheckinRevision convertToSObject(CheckinRevision input) {
		if (input == null) {
			return null;
		}
		
		SCheckinRevision result = new SCheckinRevision();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		Project projectVal = input.getProject();
		result.setProjectId(projectVal == null ? -1 : projectVal.getOid());
		return result;
	}

	public CheckinRevision convertFromSObject(SCheckinRevision input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		CheckinRevision result = convertFromSObject(input, (CheckinRevision)session.create(StorePackage.eINSTANCE.getCheckinRevision()), session);
		
		
		return result;
	}

	public CheckinRevision convertFromSObject(SCheckinRevision input) throws BimserverDatabaseException {
		CheckinRevision result = convertFromSObject(input, StoreFactory.eINSTANCE.createCheckinRevision(), null);
		return result;
	}

	public CheckinRevision convertFromSObject(SCheckinRevision input, CheckinRevision result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setProject((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getProjectId(), OldQuery.getDefault()));
		return result;
	}
		public SServiceStatus convertToSObject(ServiceStatus input) {
			return SServiceStatus.values()[input.ordinal()];
		}
		
		public ServiceStatus convertFromSObject(SServiceStatus input) {
			return ServiceStatus.values()[input.ordinal()];
		}

	public Set<SNewService> convertToSSetNewService(Collection<NewService> input) {
		Set<SNewService> result = new HashSet<SNewService>();
		for (NewService o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<NewService> convertFromSSetNewService(Collection<SNewService> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<NewService> result = new HashSet<NewService>();
		for (SNewService o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SNewService> convertToSListNewService(Collection<NewService> input) {
		List<SNewService> result = new ArrayList<SNewService>();
		for (NewService o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<NewService> convertFromSListNewService(Collection<SNewService> input, DatabaseSession session) throws BimserverDatabaseException {
		List<NewService> result = new ArrayList<NewService>();
		for (SNewService o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SNewService convertToSObject(NewService input) {
		if (input == null) {
			return null;
		}
		
		SNewService result = new SNewService();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setName(input.getName());
		result.setProvider(input.getProvider());
		result.setDescription(input.getDescription());
		result.setAuthorizationUrl(input.getAuthorizationUrl());
		result.setTokenUrl(input.getTokenUrl());
		result.setResourceUrl(input.getResourceUrl());
		result.setRegisterUrl(input.getRegisterUrl());
		result.setInput(input.getInput());
		result.setOauthCode(input.getOauthCode());
		result.setStatus(SServiceStatus.values()[input.getStatus().ordinal()]);
		result.setOutput(input.getOutput());
		result.setAccessToken(input.getAccessToken());
		result.setStateJson(input.getStateJson());
		SerializerPluginConfiguration serializerVal = input.getSerializer();
		result.setSerializerId(serializerVal == null ? -1 : serializerVal.getOid());
		Action actionVal = input.getAction();
		result.setAction(convertToSObject(actionVal));
		Project projectVal = input.getProject();
		result.setProjectId(projectVal == null ? -1 : projectVal.getOid());
		return result;
	}

	public NewService convertFromSObject(SNewService input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		NewService result = convertFromSObject(input, (NewService)session.create(StorePackage.eINSTANCE.getNewService()), session);
		
		
		return result;
	}

	public NewService convertFromSObject(SNewService input) throws BimserverDatabaseException {
		NewService result = convertFromSObject(input, StoreFactory.eINSTANCE.createNewService(), null);
		return result;
	}

	public NewService convertFromSObject(SNewService input, NewService result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setName(input.getName());
		result.setProvider(input.getProvider());
		result.setDescription(input.getDescription());
		result.setAuthorizationUrl(input.getAuthorizationUrl());
		result.setTokenUrl(input.getTokenUrl());
		result.setResourceUrl(input.getResourceUrl());
		result.setRegisterUrl(input.getRegisterUrl());
		result.setInput(input.getInput());
		result.setOauthCode(input.getOauthCode());
		result.setStatus(ServiceStatus.values()[input.getStatus().ordinal()]);
		result.setOutput(input.getOutput());
		result.setAccessToken(input.getAccessToken());
		result.setStateJson(input.getStateJson());
		result.setSerializer((SerializerPluginConfiguration)session.get(StorePackage.eINSTANCE.getSerializerPluginConfiguration(), input.getSerializerId(), OldQuery.getDefault()));
		result.setAction(convertFromSObject(input.getAction(), session));
		result.setProject((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getProjectId(), OldQuery.getDefault()));
		return result;
	}

	public Set<SRunServiceAuthorization> convertToSSetRunServiceAuthorization(Collection<RunServiceAuthorization> input) {
		Set<SRunServiceAuthorization> result = new HashSet<SRunServiceAuthorization>();
		for (RunServiceAuthorization o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<RunServiceAuthorization> convertFromSSetRunServiceAuthorization(Collection<SRunServiceAuthorization> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<RunServiceAuthorization> result = new HashSet<RunServiceAuthorization>();
		for (SRunServiceAuthorization o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SRunServiceAuthorization> convertToSListRunServiceAuthorization(Collection<RunServiceAuthorization> input) {
		List<SRunServiceAuthorization> result = new ArrayList<SRunServiceAuthorization>();
		for (RunServiceAuthorization o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<RunServiceAuthorization> convertFromSListRunServiceAuthorization(Collection<SRunServiceAuthorization> input, DatabaseSession session) throws BimserverDatabaseException {
		List<RunServiceAuthorization> result = new ArrayList<RunServiceAuthorization>();
		for (SRunServiceAuthorization o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SRunServiceAuthorization convertToSObject(RunServiceAuthorization input) {
		if (input == null) {
			return null;
		}
		
		SRunServiceAuthorization result = new SRunServiceAuthorization();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		InternalServicePluginConfiguration serviceVal = input.getService();
		result.setServiceId(serviceVal == null ? -1 : serviceVal.getOid());
		return result;
	}

	public RunServiceAuthorization convertFromSObject(SRunServiceAuthorization input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		RunServiceAuthorization result = convertFromSObject(input, (RunServiceAuthorization)session.create(StorePackage.eINSTANCE.getRunServiceAuthorization()), session);
		
		
		return result;
	}

	public RunServiceAuthorization convertFromSObject(SRunServiceAuthorization input) throws BimserverDatabaseException {
		RunServiceAuthorization result = convertFromSObject(input, StoreFactory.eINSTANCE.createRunServiceAuthorization(), null);
		return result;
	}

	public RunServiceAuthorization convertFromSObject(SRunServiceAuthorization input, RunServiceAuthorization result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setService((InternalServicePluginConfiguration)session.get(StorePackage.eINSTANCE.getInternalServicePluginConfiguration(), input.getServiceId(), OldQuery.getDefault()));
		return result;
	}

	public Set<SDensityCollection> convertToSSetDensityCollection(Collection<DensityCollection> input) {
		Set<SDensityCollection> result = new HashSet<SDensityCollection>();
		for (DensityCollection o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<DensityCollection> convertFromSSetDensityCollection(Collection<SDensityCollection> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<DensityCollection> result = new HashSet<DensityCollection>();
		for (SDensityCollection o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SDensityCollection> convertToSListDensityCollection(Collection<DensityCollection> input) {
		List<SDensityCollection> result = new ArrayList<SDensityCollection>();
		for (DensityCollection o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<DensityCollection> convertFromSListDensityCollection(Collection<SDensityCollection> input, DatabaseSession session) throws BimserverDatabaseException {
		List<DensityCollection> result = new ArrayList<DensityCollection>();
		for (SDensityCollection o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SDensityCollection convertToSObject(DensityCollection input) {
		if (input == null) {
			return null;
		}
		
		SDensityCollection result = new SDensityCollection();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		List<SDensity> listdensities = new ArrayList<SDensity>();
		for (Density v : input.getDensities()) {
			listdensities.add(convertToSObject(v));
		}
		result.setDensities(listdensities);
		return result;
	}

	public DensityCollection convertFromSObject(SDensityCollection input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		DensityCollection result = convertFromSObject(input, (DensityCollection)session.create(StorePackage.eINSTANCE.getDensityCollection()), session);
		
		
		return result;
	}

	public DensityCollection convertFromSObject(SDensityCollection input) throws BimserverDatabaseException {
		DensityCollection result = convertFromSObject(input, StoreFactory.eINSTANCE.createDensityCollection(), null);
		return result;
	}

	public DensityCollection convertFromSObject(SDensityCollection input, DensityCollection result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		List<Density> listdensities = result.getDensities();
		for (SDensity v : input.getDensities()) {
			listdensities.add(convertFromSObject(v, session));
		}
		return result;
	}

	public Set<SDensity> convertToSSetDensity(Collection<Density> input) {
		Set<SDensity> result = new HashSet<SDensity>();
		for (Density o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<Density> convertFromSSetDensity(Collection<SDensity> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<Density> result = new HashSet<Density>();
		for (SDensity o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SDensity> convertToSListDensity(Collection<Density> input) {
		List<SDensity> result = new ArrayList<SDensity>();
		for (Density o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<Density> convertFromSListDensity(Collection<SDensity> input, DatabaseSession session) throws BimserverDatabaseException {
		List<Density> result = new ArrayList<Density>();
		for (SDensity o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SDensity convertToSObject(Density input) {
		if (input == null) {
			return null;
		}
		
		SDensity result = new SDensity();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setType(input.getType());
		result.setGeometryInfoId(input.getGeometryInfoId());
		result.setTrianglesBelow(input.getTrianglesBelow());
		result.setTrianglesAbove(input.getTrianglesAbove());
		result.setVolume(input.getVolume());
		result.setDensity(input.getDensity());
		return result;
	}

	public Density convertFromSObject(SDensity input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		Density result = convertFromSObject(input, (Density)session.create(StorePackage.eINSTANCE.getDensity()), session);
		
		
		return result;
	}

	public Density convertFromSObject(SDensity input) throws BimserverDatabaseException {
		Density result = convertFromSObject(input, StoreFactory.eINSTANCE.createDensity(), null);
		return result;
	}

	public Density convertFromSObject(SDensity input, Density result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setType(input.getType());
		result.setGeometryInfoId(input.getGeometryInfoId());
		result.setTrianglesBelow(input.getTrianglesBelow());
		result.setTrianglesAbove(input.getTrianglesAbove());
		result.setVolume(input.getVolume());
		result.setDensity(input.getDensity());
		return result;
	}

	public Set<SLongCheckinActionState> convertToSSetLongCheckinActionState(Collection<LongCheckinActionState> input) {
		Set<SLongCheckinActionState> result = new HashSet<SLongCheckinActionState>();
		for (LongCheckinActionState o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<LongCheckinActionState> convertFromSSetLongCheckinActionState(Collection<SLongCheckinActionState> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<LongCheckinActionState> result = new HashSet<LongCheckinActionState>();
		for (SLongCheckinActionState o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SLongCheckinActionState> convertToSListLongCheckinActionState(Collection<LongCheckinActionState> input) {
		List<SLongCheckinActionState> result = new ArrayList<SLongCheckinActionState>();
		for (LongCheckinActionState o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<LongCheckinActionState> convertFromSListLongCheckinActionState(Collection<SLongCheckinActionState> input, DatabaseSession session) throws BimserverDatabaseException {
		List<LongCheckinActionState> result = new ArrayList<LongCheckinActionState>();
		for (SLongCheckinActionState o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SLongCheckinActionState convertToSObject(LongCheckinActionState input) {
		if (input == null) {
			return null;
		}
		
		SLongCheckinActionState result = new SLongCheckinActionState();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setStart(input.getStart());
		result.setEnd(input.getEnd());
		result.setProgress(input.getProgress());
		result.setState(SActionState.values()[input.getState().ordinal()]);
		result.setTitle(input.getTitle());
		result.setStage(input.getStage());
		result.getErrors().addAll(input.getErrors());
		result.getWarnings().addAll(input.getWarnings());
		result.getInfos().addAll(input.getInfos());
		result.setTopicId(input.getTopicId());
		result.setRoid(input.getRoid());
		result.setDeserializeErrorCode(input.getDeserializeErrorCode());
		return result;
	}

	public LongCheckinActionState convertFromSObject(SLongCheckinActionState input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		LongCheckinActionState result = convertFromSObject(input, (LongCheckinActionState)session.create(StorePackage.eINSTANCE.getLongCheckinActionState()), session);
		
		
		return result;
	}

	public LongCheckinActionState convertFromSObject(SLongCheckinActionState input) throws BimserverDatabaseException {
		LongCheckinActionState result = convertFromSObject(input, StoreFactory.eINSTANCE.createLongCheckinActionState(), null);
		return result;
	}

	public LongCheckinActionState convertFromSObject(SLongCheckinActionState input, LongCheckinActionState result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setStart(input.getStart());
		result.setEnd(input.getEnd());
		result.setProgress(input.getProgress());
		result.setState(ActionState.values()[input.getState().ordinal()]);
		result.setTitle(input.getTitle());
		result.setStage(input.getStage());
		result.getErrors().addAll(input.getErrors());
		result.getWarnings().addAll(input.getWarnings());
		result.getInfos().addAll(input.getInfos());
		result.setTopicId(input.getTopicId());
		result.setRoid(input.getRoid());
		result.setDeserializeErrorCode(input.getDeserializeErrorCode());
		return result;
	}

	public Set<STile> convertToSSetTile(Collection<Tile> input) {
		Set<STile> result = new HashSet<STile>();
		for (Tile o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<Tile> convertFromSSetTile(Collection<STile> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<Tile> result = new HashSet<Tile>();
		for (STile o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<STile> convertToSListTile(Collection<Tile> input) {
		List<STile> result = new ArrayList<STile>();
		for (Tile o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<Tile> convertFromSListTile(Collection<STile> input, DatabaseSession session) throws BimserverDatabaseException {
		List<Tile> result = new ArrayList<Tile>();
		for (STile o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public STile convertToSObject(Tile input) {
		if (input == null) {
			return null;
		}
		
		STile result = new STile();
		result.setOid(input.getOid());
		result.setUuid(input.getUuid());
		result.setRid(input.getRid());
		result.setTileId(input.getTileId());
		result.setNrObjects(input.getNrObjects());
		Bounds minBoundsVal = input.getMinBounds();
		result.setMinBounds(convertToSObject(minBoundsVal));
		Bounds boundsVal = input.getBounds();
		result.setBounds(convertToSObject(boundsVal));
		return result;
	}

	public Tile convertFromSObject(STile input, DatabaseSession session) throws BimserverDatabaseException {
		if (session == null) {
			throw new BimserverDatabaseException("session == null, use the other method");
		}
		Tile result = convertFromSObject(input, (Tile)session.create(StorePackage.eINSTANCE.getTile()), session);
		
		
		return result;
	}

	public Tile convertFromSObject(STile input) throws BimserverDatabaseException {
		Tile result = convertFromSObject(input, StoreFactory.eINSTANCE.createTile(), null);
		return result;
	}

	public Tile convertFromSObject(STile input, Tile result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setTileId(input.getTileId());
		result.setNrObjects(input.getNrObjects());
		result.setMinBounds(convertFromSObject(input.getMinBounds(), session));
		result.setBounds(convertFromSObject(input.getBounds(), session));
		return result;
	}
}