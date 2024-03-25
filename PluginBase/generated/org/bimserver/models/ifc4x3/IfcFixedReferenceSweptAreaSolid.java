/**
 * Copyright (C) 2009-2014 BIMserver.org
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
 */
package org.bimserver.models.ifc4x3;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Fixed Reference Swept Area Solid</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcFixedReferenceSweptAreaSolid#getFixedReference <em>Fixed Reference</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcFixedReferenceSweptAreaSolid()
 * @model
 * @generated
 */
public interface IfcFixedReferenceSweptAreaSolid extends IfcDirectrixCurveSweptAreaSolid {
	/**
	 * Returns the value of the '<em><b>Fixed Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fixed Reference</em>' reference.
	 * @see #setFixedReference(IfcDirection)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcFixedReferenceSweptAreaSolid_FixedReference()
	 * @model
	 * @generated
	 */
	IfcDirection getFixedReference();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcFixedReferenceSweptAreaSolid#getFixedReference <em>Fixed Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fixed Reference</em>' reference.
	 * @see #getFixedReference()
	 * @generated
	 */
	void setFixedReference(IfcDirection value);

} // IfcFixedReferenceSweptAreaSolid
