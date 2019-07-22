package org.bimserver.interfaces.objects;

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
import javax.xml.bind.annotation.XmlTransient;
import java.util.UUID;
import org.bimserver.shared.meta.*;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class SGeometryData implements SDataBase
{
	private long oid = -1;
	private UUID uuid;
	private int rid = 0;

	@XmlTransient
	private static SClass sClass;
	private int nrIndices;
	private int nrVertices;
	private int nrNormals;
	private int nrColors;
	private long indicesId = -1;
	private long verticesId = -1;
	private long verticesQuantizedId = -1;
	private long normalsId = -1;
	private long normalsQuantizedId = -1;
	private long colorsQuantizedId = -1;
	private SVector4f color;
	private boolean hasTransparency;
	private int reused;
	private short type;
	private SVector4f mostUsedColor;
	private SBounds boundsMm;
	private int saveableTriangles;
	private SColorPack colorPack;
	private long lineIndicesId = -1;
	private int nrLineIndices;

	public long getOid() {
		return this.oid;
	}

	public void setOid(long oid) {
		this.oid = oid;
	}

	public UUID getUuid() {
		return this.uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public int getRid() {
		return rid;
	}
	
	public void setRid(int rid) {
		this.rid = rid;
	}
	
	@XmlTransient
	public SClass getSClass() {
		return sClass;
	}
	
	public static void setSClass(SClass sClass) {
		SGeometryData.sClass = sClass;
	}

	public Object sGet(SField sField) {
		if (sField.getName().equals("nrIndices")) {
			return getNrIndices();
		}
		if (sField.getName().equals("nrVertices")) {
			return getNrVertices();
		}
		if (sField.getName().equals("nrNormals")) {
			return getNrNormals();
		}
		if (sField.getName().equals("nrColors")) {
			return getNrColors();
		}
		if (sField.getName().equals("indicesId")) {
			return getIndicesId();
		}
		if (sField.getName().equals("verticesId")) {
			return getVerticesId();
		}
		if (sField.getName().equals("verticesQuantizedId")) {
			return getVerticesQuantizedId();
		}
		if (sField.getName().equals("normalsId")) {
			return getNormalsId();
		}
		if (sField.getName().equals("normalsQuantizedId")) {
			return getNormalsQuantizedId();
		}
		if (sField.getName().equals("colorsQuantizedId")) {
			return getColorsQuantizedId();
		}
		if (sField.getName().equals("color")) {
			return getColor();
		}
		if (sField.getName().equals("hasTransparency")) {
			return isHasTransparency();
		}
		if (sField.getName().equals("reused")) {
			return getReused();
		}
		if (sField.getName().equals("type")) {
			return getType();
		}
		if (sField.getName().equals("mostUsedColor")) {
			return getMostUsedColor();
		}
		if (sField.getName().equals("boundsMm")) {
			return getBoundsMm();
		}
		if (sField.getName().equals("saveableTriangles")) {
			return getSaveableTriangles();
		}
		if (sField.getName().equals("colorPack")) {
			return getColorPack();
		}
		if (sField.getName().equals("lineIndicesId")) {
			return getLineIndicesId();
		}
		if (sField.getName().equals("nrLineIndices")) {
			return getNrLineIndices();
		}
		if (sField.getName().equals("oid")) {
			return getOid();
		}
		if (sField.getName().equals("rid")) {
			return getRid();
		}
		if (sField.getName().equals("uuid")) {
			return getUuid();
		}
		throw new RuntimeException("Field " + sField.getName() + " not found");
	}

	public void sSet(SField sField, Object val) {
		if (sField.getName().equals("nrIndices")) {
			setNrIndices((Integer)val);
			return;
		}
		if (sField.getName().equals("nrVertices")) {
			setNrVertices((Integer)val);
			return;
		}
		if (sField.getName().equals("nrNormals")) {
			setNrNormals((Integer)val);
			return;
		}
		if (sField.getName().equals("nrColors")) {
			setNrColors((Integer)val);
			return;
		}
		if (sField.getName().equals("indicesId")) {
			setIndicesId((Long)val);
			return;
		}
		if (sField.getName().equals("verticesId")) {
			setVerticesId((Long)val);
			return;
		}
		if (sField.getName().equals("verticesQuantizedId")) {
			setVerticesQuantizedId((Long)val);
			return;
		}
		if (sField.getName().equals("normalsId")) {
			setNormalsId((Long)val);
			return;
		}
		if (sField.getName().equals("normalsQuantizedId")) {
			setNormalsQuantizedId((Long)val);
			return;
		}
		if (sField.getName().equals("colorsQuantizedId")) {
			setColorsQuantizedId((Long)val);
			return;
		}
		if (sField.getName().equals("color")) {
			setColor((SVector4f)val);
			return;
		}
		if (sField.getName().equals("hasTransparency")) {
			setHasTransparency((Boolean)val);
			return;
		}
		if (sField.getName().equals("reused")) {
			setReused((Integer)val);
			return;
		}
		if (sField.getName().equals("type")) {
			setType((Short)val);
			return;
		}
		if (sField.getName().equals("mostUsedColor")) {
			setMostUsedColor((SVector4f)val);
			return;
		}
		if (sField.getName().equals("boundsMm")) {
			setBoundsMm((SBounds)val);
			return;
		}
		if (sField.getName().equals("saveableTriangles")) {
			setSaveableTriangles((Integer)val);
			return;
		}
		if (sField.getName().equals("colorPack")) {
			setColorPack((SColorPack)val);
			return;
		}
		if (sField.getName().equals("lineIndicesId")) {
			setLineIndicesId((Long)val);
			return;
		}
		if (sField.getName().equals("nrLineIndices")) {
			setNrLineIndices((Integer)val);
			return;
		}
		if (sField.getName().equals("oid")) {
			setOid((Long)val);
			return;
		}
		if (sField.getName().equals("rid")) {
			setRid((Integer)val);
			return;
		}
		if (sField.getName().equals("uuid")) {
			setUuid((UUID)val);
			return;
		}
		throw new RuntimeException("Field " + sField.getName() + " not found");
	}
	
	public int getNrIndices() {
		return nrIndices;
	}

	public void setNrIndices(int nrIndices) {
		this.nrIndices = nrIndices;
	}
	
	public int getNrVertices() {
		return nrVertices;
	}

	public void setNrVertices(int nrVertices) {
		this.nrVertices = nrVertices;
	}
	
	public int getNrNormals() {
		return nrNormals;
	}

	public void setNrNormals(int nrNormals) {
		this.nrNormals = nrNormals;
	}
	
	public int getNrColors() {
		return nrColors;
	}

	public void setNrColors(int nrColors) {
		this.nrColors = nrColors;
	}
	
	public long getIndicesId() {
		return indicesId;
	}

	public void setIndicesId(long indicesId) {
		this.indicesId = indicesId;
	}
	
	public long getVerticesId() {
		return verticesId;
	}

	public void setVerticesId(long verticesId) {
		this.verticesId = verticesId;
	}
	
	public long getVerticesQuantizedId() {
		return verticesQuantizedId;
	}

	public void setVerticesQuantizedId(long verticesQuantizedId) {
		this.verticesQuantizedId = verticesQuantizedId;
	}
	
	public long getNormalsId() {
		return normalsId;
	}

	public void setNormalsId(long normalsId) {
		this.normalsId = normalsId;
	}
	
	public long getNormalsQuantizedId() {
		return normalsQuantizedId;
	}

	public void setNormalsQuantizedId(long normalsQuantizedId) {
		this.normalsQuantizedId = normalsQuantizedId;
	}
	
	public long getColorsQuantizedId() {
		return colorsQuantizedId;
	}

	public void setColorsQuantizedId(long colorsQuantizedId) {
		this.colorsQuantizedId = colorsQuantizedId;
	}
	
	public SVector4f getColor() {
		return color;
	}

	public void setColor(SVector4f color) {
		this.color = color;
	}
	
	
	public boolean isHasTransparency() {
		return hasTransparency;
	}

	public void setHasTransparency(boolean hasTransparency) {
		this.hasTransparency = hasTransparency;
	}
	
	public int getReused() {
		return reused;
	}

	public void setReused(int reused) {
		this.reused = reused;
	}
	
	public short getType() {
		return type;
	}

	public void setType(short type) {
		this.type = type;
	}
	
	public SVector4f getMostUsedColor() {
		return mostUsedColor;
	}

	public void setMostUsedColor(SVector4f mostUsedColor) {
		this.mostUsedColor = mostUsedColor;
	}
	
	
	public SBounds getBoundsMm() {
		return boundsMm;
	}

	public void setBoundsMm(SBounds boundsMm) {
		this.boundsMm = boundsMm;
	}
	
	
	public int getSaveableTriangles() {
		return saveableTriangles;
	}

	public void setSaveableTriangles(int saveableTriangles) {
		this.saveableTriangles = saveableTriangles;
	}
	
	public SColorPack getColorPack() {
		return colorPack;
	}

	public void setColorPack(SColorPack colorPack) {
		this.colorPack = colorPack;
	}
	
	
	public long getLineIndicesId() {
		return lineIndicesId;
	}

	public void setLineIndicesId(long lineIndicesId) {
		this.lineIndicesId = lineIndicesId;
	}
	
	public int getNrLineIndices() {
		return nrLineIndices;
	}

	public void setNrLineIndices(int nrLineIndices) {
		this.nrLineIndices = nrLineIndices;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (oid ^ (oid >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SGeometryData other = (SGeometryData) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}