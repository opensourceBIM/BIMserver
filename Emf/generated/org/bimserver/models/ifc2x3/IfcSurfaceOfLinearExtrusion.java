/**
 * Copyright (C) 2011  BIMserver.org
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
public interface IfcSurfaceOfLinearExtrusion extends IfcSweptSurface {
	/**
	 * Returns the value of the '<em><b>Extruded Direction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extruded Direction</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extruded Direction</em>' reference.
	 * @see #isSetExtrudedDirection()
	 * @see #unsetExtrudedDirection()
	 * @see #setExtrudedDirection(IfcDirection)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSurfaceOfLinearExtrusion_ExtrudedDirection()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcDirection getExtrudedDirection();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcSurfaceOfLinearExtrusion#getExtrudedDirection <em>Extruded Direction</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extruded Direction</em>' reference.
	 * @see #isSetExtrudedDirection()
	 * @see #unsetExtrudedDirection()
	 * @see #getExtrudedDirection()
	 * @generated
	 */
	void setExtrudedDirection(IfcDirection value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcSurfaceOfLinearExtrusion#getExtrudedDirection <em>Extruded Direction</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetExtrudedDirection()
	 * @see #getExtrudedDirection()
	 * @see #setExtrudedDirection(IfcDirection)
	 * @generated
	 */
	void unsetExtrudedDirection();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcSurfaceOfLinearExtrusion#getExtrudedDirection <em>Extruded Direction</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Extruded Direction</em>' reference is set.
	 * @see #unsetExtrudedDirection()
	 * @see #getExtrudedDirection()
	 * @see #setExtrudedDirection(IfcDirection)
	 * @generated
	 */
	boolean isSetExtrudedDirection();

	/**
	 * Returns the value of the '<em><b>Depth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Depth</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Depth</em>' attribute.
	 * @see #isSetDepth()
	 * @see #unsetDepth()
	 * @see #setDepth(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSurfaceOfLinearExtrusion_Depth()
	 * @model unsettable="true"
	 * @generated
	 */
	double getDepth();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcSurfaceOfLinearExtrusion#getDepth <em>Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Depth</em>' attribute.
	 * @see #isSetDepth()
	 * @see #unsetDepth()
	 * @see #getDepth()
	 * @generated
	 */
	void setDepth(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcSurfaceOfLinearExtrusion#getDepth <em>Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDepth()
	 * @see #getDepth()
	 * @see #setDepth(double)
	 * @generated
	 */
	void unsetDepth();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcSurfaceOfLinearExtrusion#getDepth <em>Depth</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Depth</em>' attribute is set.
	 * @see #unsetDepth()
	 * @see #getDepth()
	 * @see #setDepth(double)
	 * @generated
	 */
	boolean isSetDepth();

	/**
	 * Returns the value of the '<em><b>Depth As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Depth As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Depth As String</em>' attribute.
	 * @see #isSetDepthAsString()
	 * @see #unsetDepthAsString()
	 * @see #setDepthAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSurfaceOfLinearExtrusion_DepthAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getDepthAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcSurfaceOfLinearExtrusion#getDepthAsString <em>Depth As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Depth As String</em>' attribute.
	 * @see #isSetDepthAsString()
	 * @see #unsetDepthAsString()
	 * @see #getDepthAsString()
	 * @generated
	 */
	void setDepthAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcSurfaceOfLinearExtrusion#getDepthAsString <em>Depth As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDepthAsString()
	 * @see #getDepthAsString()
	 * @see #setDepthAsString(String)
	 * @generated
	 */
	void unsetDepthAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcSurfaceOfLinearExtrusion#getDepthAsString <em>Depth As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Depth As String</em>' attribute is set.
	 * @see #unsetDepthAsString()
	 * @see #getDepthAsString()
	 * @see #setDepthAsString(String)
	 * @generated
	 */
	boolean isSetDepthAsString();

} // IfcSurfaceOfLinearExtrusion
