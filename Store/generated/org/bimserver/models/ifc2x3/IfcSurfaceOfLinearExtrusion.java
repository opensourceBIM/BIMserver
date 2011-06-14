/**
 *  (c) Copyright bimserver.org 2009
 *  Licensed under GNU GPLv3
 *  http://www.gnu.org/licenses/gpl-3.0.txt
 *  For more information mail to license@bimserver.org
 *  
 *  Bimserver.org is free software: you can redistribute it and/or modify 
 *  it under the terms of the GNU General Public License as published by 
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  Bimserver.org is distributed in the hope that it will be useful, but 
 *  WITHOUT ANY WARRANTY; without even the implied warranty of 
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 *  General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License a 
 *  long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 */
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Surface Of Linear Extrusion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSurfaceOfLinearExtrusion#getExtrudedDirection <em>Extruded Direction</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSurfaceOfLinearExtrusion#getDepth <em>Depth</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSurfaceOfLinearExtrusion#getDepthAsString <em>Depth As String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSurfaceOfLinearExtrusion()
 * @model
 * @generated
 */
public interface IfcSurfaceOfLinearExtrusion extends IfcSweptSurface
{
	/**
	 * Returns the value of the '<em><b>Extruded Direction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extruded Direction</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extruded Direction</em>' reference.
	 * @see #setExtrudedDirection(IfcDirection)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSurfaceOfLinearExtrusion_ExtrudedDirection()
	 * @model
	 * @generated
	 */
	IfcDirection getExtrudedDirection();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcSurfaceOfLinearExtrusion#getExtrudedDirection <em>Extruded Direction</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extruded Direction</em>' reference.
	 * @see #getExtrudedDirection()
	 * @generated
	 */
	void setExtrudedDirection(IfcDirection value);

	/**
	 * Returns the value of the '<em><b>Depth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Depth</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Depth</em>' attribute.
	 * @see #setDepth(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSurfaceOfLinearExtrusion_Depth()
	 * @model
	 * @generated
	 */
	float getDepth();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcSurfaceOfLinearExtrusion#getDepth <em>Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Depth</em>' attribute.
	 * @see #getDepth()
	 * @generated
	 */
	void setDepth(float value);

	/**
	 * Returns the value of the '<em><b>Depth As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Depth As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Depth As String</em>' attribute.
	 * @see #setDepthAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSurfaceOfLinearExtrusion_DepthAsString()
	 * @model
	 * @generated
	 */
	String getDepthAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcSurfaceOfLinearExtrusion#getDepthAsString <em>Depth As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Depth As String</em>' attribute.
	 * @see #getDepthAsString()
	 * @generated
	 */
	void setDepthAsString(String value);

} // IfcSurfaceOfLinearExtrusion
