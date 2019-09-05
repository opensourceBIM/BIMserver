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
package org.bimserver.models.ifc4;

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

import org.bimserver.emf.IdEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Coordinate Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcCoordinateOperation#getSourceCRS <em>Source CRS</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcCoordinateOperation#getTargetCRS <em>Target CRS</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcCoordinateOperation()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface IfcCoordinateOperation extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Source CRS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source CRS</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source CRS</em>' reference.
	 * @see #setSourceCRS(IfcCoordinateReferenceSystemSelect)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcCoordinateOperation_SourceCRS()
	 * @model annotation="inverse"
	 *        annotation="inverse"
	 * @generated
	 */
	IfcCoordinateReferenceSystemSelect getSourceCRS();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcCoordinateOperation#getSourceCRS <em>Source CRS</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source CRS</em>' reference.
	 * @see #getSourceCRS()
	 * @generated
	 */
	void setSourceCRS(IfcCoordinateReferenceSystemSelect value);

	/**
	 * Returns the value of the '<em><b>Target CRS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target CRS</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target CRS</em>' reference.
	 * @see #setTargetCRS(IfcCoordinateReferenceSystem)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcCoordinateOperation_TargetCRS()
	 * @model
	 * @generated
	 */
	IfcCoordinateReferenceSystem getTargetCRS();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcCoordinateOperation#getTargetCRS <em>Target CRS</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target CRS</em>' reference.
	 * @see #getTargetCRS()
	 * @generated
	 */
	void setTargetCRS(IfcCoordinateReferenceSystem value);

} // IfcCoordinateOperation
