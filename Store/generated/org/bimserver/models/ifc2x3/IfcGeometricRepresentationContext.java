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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Geometric Representation Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcGeometricRepresentationContext#getCoordinateSpaceDimension <em>Coordinate Space Dimension</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcGeometricRepresentationContext#getPrecision <em>Precision</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcGeometricRepresentationContext#getPrecisionAsString <em>Precision As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcGeometricRepresentationContext#getWorldCoordinateSystem <em>World Coordinate System</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcGeometricRepresentationContext#getTrueNorth <em>True North</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcGeometricRepresentationContext#getHasSubContexts <em>Has Sub Contexts</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcGeometricRepresentationContext()
 * @model
 * @generated
 */
public interface IfcGeometricRepresentationContext extends IfcRepresentationContext
{
	/**
	 * Returns the value of the '<em><b>Coordinate Space Dimension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Coordinate Space Dimension</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Coordinate Space Dimension</em>' attribute.
	 * @see #setCoordinateSpaceDimension(int)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcGeometricRepresentationContext_CoordinateSpaceDimension()
	 * @model
	 * @generated
	 */
	int getCoordinateSpaceDimension();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcGeometricRepresentationContext#getCoordinateSpaceDimension <em>Coordinate Space Dimension</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Coordinate Space Dimension</em>' attribute.
	 * @see #getCoordinateSpaceDimension()
	 * @generated
	 */
	void setCoordinateSpaceDimension(int value);

	/**
	 * Returns the value of the '<em><b>Precision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Precision</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Precision</em>' attribute.
	 * @see #setPrecision(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcGeometricRepresentationContext_Precision()
	 * @model
	 * @generated
	 */
	float getPrecision();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcGeometricRepresentationContext#getPrecision <em>Precision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Precision</em>' attribute.
	 * @see #getPrecision()
	 * @generated
	 */
	void setPrecision(float value);

	/**
	 * Returns the value of the '<em><b>Precision As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Precision As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Precision As String</em>' attribute.
	 * @see #setPrecisionAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcGeometricRepresentationContext_PrecisionAsString()
	 * @model
	 * @generated
	 */
	String getPrecisionAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcGeometricRepresentationContext#getPrecisionAsString <em>Precision As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Precision As String</em>' attribute.
	 * @see #getPrecisionAsString()
	 * @generated
	 */
	void setPrecisionAsString(String value);

	/**
	 * Returns the value of the '<em><b>World Coordinate System</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>World Coordinate System</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>World Coordinate System</em>' reference.
	 * @see #setWorldCoordinateSystem(IfcAxis2Placement)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcGeometricRepresentationContext_WorldCoordinateSystem()
	 * @model
	 * @generated
	 */
	IfcAxis2Placement getWorldCoordinateSystem();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcGeometricRepresentationContext#getWorldCoordinateSystem <em>World Coordinate System</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>World Coordinate System</em>' reference.
	 * @see #getWorldCoordinateSystem()
	 * @generated
	 */
	void setWorldCoordinateSystem(IfcAxis2Placement value);

	/**
	 * Returns the value of the '<em><b>True North</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>True North</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>True North</em>' reference.
	 * @see #isSetTrueNorth()
	 * @see #unsetTrueNorth()
	 * @see #setTrueNorth(IfcDirection)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcGeometricRepresentationContext_TrueNorth()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcDirection getTrueNorth();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcGeometricRepresentationContext#getTrueNorth <em>True North</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>True North</em>' reference.
	 * @see #isSetTrueNorth()
	 * @see #unsetTrueNorth()
	 * @see #getTrueNorth()
	 * @generated
	 */
	void setTrueNorth(IfcDirection value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcGeometricRepresentationContext#getTrueNorth <em>True North</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTrueNorth()
	 * @see #getTrueNorth()
	 * @see #setTrueNorth(IfcDirection)
	 * @generated
	 */
	void unsetTrueNorth();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcGeometricRepresentationContext#getTrueNorth <em>True North</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>True North</em>' reference is set.
	 * @see #unsetTrueNorth()
	 * @see #getTrueNorth()
	 * @see #setTrueNorth(IfcDirection)
	 * @generated
	 */
	boolean isSetTrueNorth();

	/**
	 * Returns the value of the '<em><b>Has Sub Contexts</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcGeometricRepresentationSubContext}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcGeometricRepresentationSubContext#getParentContext <em>Parent Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Sub Contexts</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Sub Contexts</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcGeometricRepresentationContext_HasSubContexts()
	 * @see org.bimserver.models.ifc2x3.IfcGeometricRepresentationSubContext#getParentContext
	 * @model opposite="ParentContext"
	 * @generated
	 */
	EList<IfcGeometricRepresentationSubContext> getHasSubContexts();

} // IfcGeometricRepresentationContext
