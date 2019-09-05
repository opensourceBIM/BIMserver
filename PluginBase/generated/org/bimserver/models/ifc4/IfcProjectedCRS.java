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

public interface IfcProjectedCRS extends IfcCoordinateReferenceSystem {
	/**
	 * Returns the value of the '<em><b>Map Projection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Map Projection</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Map Projection</em>' attribute.
	 * @see #isSetMapProjection()
	 * @see #unsetMapProjection()
	 * @see #setMapProjection(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcProjectedCRS_MapProjection()
	 * @model unsettable="true"
	 * @generated
	 */
	String getMapProjection();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcProjectedCRS#getMapProjection <em>Map Projection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Map Projection</em>' attribute.
	 * @see #isSetMapProjection()
	 * @see #unsetMapProjection()
	 * @see #getMapProjection()
	 * @generated
	 */
	void setMapProjection(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcProjectedCRS#getMapProjection <em>Map Projection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMapProjection()
	 * @see #getMapProjection()
	 * @see #setMapProjection(String)
	 * @generated
	 */
	void unsetMapProjection();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcProjectedCRS#getMapProjection <em>Map Projection</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Map Projection</em>' attribute is set.
	 * @see #unsetMapProjection()
	 * @see #getMapProjection()
	 * @see #setMapProjection(String)
	 * @generated
	 */
	boolean isSetMapProjection();

	/**
	 * Returns the value of the '<em><b>Map Zone</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Map Zone</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Map Zone</em>' attribute.
	 * @see #isSetMapZone()
	 * @see #unsetMapZone()
	 * @see #setMapZone(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcProjectedCRS_MapZone()
	 * @model unsettable="true"
	 * @generated
	 */
	String getMapZone();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcProjectedCRS#getMapZone <em>Map Zone</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Map Zone</em>' attribute.
	 * @see #isSetMapZone()
	 * @see #unsetMapZone()
	 * @see #getMapZone()
	 * @generated
	 */
	void setMapZone(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcProjectedCRS#getMapZone <em>Map Zone</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMapZone()
	 * @see #getMapZone()
	 * @see #setMapZone(String)
	 * @generated
	 */
	void unsetMapZone();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcProjectedCRS#getMapZone <em>Map Zone</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Map Zone</em>' attribute is set.
	 * @see #unsetMapZone()
	 * @see #getMapZone()
	 * @see #setMapZone(String)
	 * @generated
	 */
	boolean isSetMapZone();

	/**
	 * Returns the value of the '<em><b>Map Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Map Unit</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Map Unit</em>' reference.
	 * @see #isSetMapUnit()
	 * @see #unsetMapUnit()
	 * @see #setMapUnit(IfcNamedUnit)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcProjectedCRS_MapUnit()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcNamedUnit getMapUnit();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcProjectedCRS#getMapUnit <em>Map Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Map Unit</em>' reference.
	 * @see #isSetMapUnit()
	 * @see #unsetMapUnit()
	 * @see #getMapUnit()
	 * @generated
	 */
	void setMapUnit(IfcNamedUnit value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcProjectedCRS#getMapUnit <em>Map Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMapUnit()
	 * @see #getMapUnit()
	 * @see #setMapUnit(IfcNamedUnit)
	 * @generated
	 */
	void unsetMapUnit();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcProjectedCRS#getMapUnit <em>Map Unit</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Map Unit</em>' reference is set.
	 * @see #unsetMapUnit()
	 * @see #getMapUnit()
	 * @see #setMapUnit(IfcNamedUnit)
	 * @generated
	 */
	boolean isSetMapUnit();

} // IfcProjectedCRS
