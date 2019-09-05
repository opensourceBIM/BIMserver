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

public interface IfcConnectionPointGeometry extends IfcConnectionGeometry {
	/**
	 * Returns the value of the '<em><b>Point On Relating Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Point On Relating Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Point On Relating Element</em>' reference.
	 * @see #setPointOnRelatingElement(IfcPointOrVertexPoint)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcConnectionPointGeometry_PointOnRelatingElement()
	 * @model
	 * @generated
	 */
	IfcPointOrVertexPoint getPointOnRelatingElement();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcConnectionPointGeometry#getPointOnRelatingElement <em>Point On Relating Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Point On Relating Element</em>' reference.
	 * @see #getPointOnRelatingElement()
	 * @generated
	 */
	void setPointOnRelatingElement(IfcPointOrVertexPoint value);

	/**
	 * Returns the value of the '<em><b>Point On Related Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Point On Related Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Point On Related Element</em>' reference.
	 * @see #isSetPointOnRelatedElement()
	 * @see #unsetPointOnRelatedElement()
	 * @see #setPointOnRelatedElement(IfcPointOrVertexPoint)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcConnectionPointGeometry_PointOnRelatedElement()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcPointOrVertexPoint getPointOnRelatedElement();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcConnectionPointGeometry#getPointOnRelatedElement <em>Point On Related Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Point On Related Element</em>' reference.
	 * @see #isSetPointOnRelatedElement()
	 * @see #unsetPointOnRelatedElement()
	 * @see #getPointOnRelatedElement()
	 * @generated
	 */
	void setPointOnRelatedElement(IfcPointOrVertexPoint value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcConnectionPointGeometry#getPointOnRelatedElement <em>Point On Related Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPointOnRelatedElement()
	 * @see #getPointOnRelatedElement()
	 * @see #setPointOnRelatedElement(IfcPointOrVertexPoint)
	 * @generated
	 */
	void unsetPointOnRelatedElement();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcConnectionPointGeometry#getPointOnRelatedElement <em>Point On Related Element</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Point On Related Element</em>' reference is set.
	 * @see #unsetPointOnRelatedElement()
	 * @see #getPointOnRelatedElement()
	 * @see #setPointOnRelatedElement(IfcPointOrVertexPoint)
	 * @generated
	 */
	boolean isSetPointOnRelatedElement();

} // IfcConnectionPointGeometry
