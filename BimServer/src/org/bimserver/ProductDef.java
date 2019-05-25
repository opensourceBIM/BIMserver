package org.bimserver;

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

import org.bimserver.shared.HashMapVirtualObject;

public class ProductDef {

	private long oid;
	private HashMapVirtualObject object;
	private long masterOid;
	private double[] mappingMatrix;
	private double[] productMatrix;
	private long mappedItemOid;
	private long representationOid;

	public ProductDef(long oid) {
		this.oid = oid;
	}

	public long getOid() {
		return oid;
	}

	public void setObject(HashMapVirtualObject object) {
		this.object = object;
	}
	
	public HashMapVirtualObject getObject() {
		return object;
	}

	public void setMasterOid(long masterOid) {
		this.masterOid = masterOid;
	}
	
	public long getMasterOid() {
		return masterOid;
	}

	public void setProductMatrix(double[] productMatrix) {
		this.productMatrix = productMatrix;
	}

	public void setMappingMatrix(double[] mappingMatrix) {
		this.mappingMatrix = mappingMatrix;
	}
	
	public double[] getProductMatrix() {
		return productMatrix;
	}
	
	public double[] getMappingMatrix() {
		return mappingMatrix;
	}

	public long getMappedItemOid() {
		return mappedItemOid;
	}

	public void setMappedItemOid(long mappedItemOid) {
		this.mappedItemOid = mappedItemOid;
		
	}

	public void setRepresentationOid(long representationOid) {
		this.representationOid = representationOid;
	}
	
	public long getRepresentationOid() {
		return representationOid;
	}
}
