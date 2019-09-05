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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Geometric Representation Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcGeometricRepresentationContext#getCoordinateSpaceDimension <em>Coordinate Space Dimension</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcGeometricRepresentationContext#getPrecision <em>Precision</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcGeometricRepresentationContext#getPrecisionAsString <em>Precision As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcGeometricRepresentationContext#getWorldCoordinateSystem <em>World Coordinate System</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcGeometricRepresentationContext#getTrueNorth <em>True North</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcGeometricRepresentationContext#getHasSubContexts <em>Has Sub Contexts</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcGeometricRepresentationContext#getHasCoordinateOperation <em>Has Coordinate Operation</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcGeometricRepresentationContext()
 * @model
 * @generated
 */
public interface IfcGeometricRepresentationContext extends IfcRepresentationContext, IfcCoordinateReferenceSystemSelect {
	/**
	 * Returns the value of the '<em><b>Coordinate Space Dimension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Coordinate Space Dimension</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Coordinate Space Dimension</em>' attribute.
	 * @see #setCoordinateSpaceDimension(long)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcGeometricRepresentationContext_CoordinateSpaceDimension()
	 * @model
	 * @generated
	 */
	long getCoordinateSpaceDimension();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcGeometricRepresentationContext#getCoordinateSpaceDimension <em>Coordinate Space Dimension</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Coordinate Space Dimension</em>' attribute.
	 * @see #getCoordinateSpaceDimension()
	 * @generated
	 */
	void setCoordinateSpaceDimension(long value);

	/**
	 * Returns the value of the '<em><b>Precision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Precision</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Precision</em>' attribute.
	 * @see #isSetPrecision()
	 * @see #unsetPrecision()
	 * @see #setPrecision(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcGeometricRepresentationContext_Precision()
	 * @model unsettable="true"
	 * @generated
	 */
	double getPrecision();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcGeometricRepresentationContext#getPrecision <em>Precision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Precision</em>' attribute.
	 * @see #isSetPrecision()
	 * @see #unsetPrecision()
	 * @see #getPrecision()
	 * @generated
	 */
	void setPrecision(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcGeometricRepresentationContext#getPrecision <em>Precision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPrecision()
	 * @see #getPrecision()
	 * @see #setPrecision(double)
	 * @generated
	 */
	void unsetPrecision();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcGeometricRepresentationContext#getPrecision <em>Precision</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Precision</em>' attribute is set.
	 * @see #unsetPrecision()
	 * @see #getPrecision()
	 * @see #setPrecision(double)
	 * @generated
	 */
	boolean isSetPrecision();

	/**
	 * Returns the value of the '<em><b>Precision As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Precision As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Precision As String</em>' attribute.
	 * @see #isSetPrecisionAsString()
	 * @see #unsetPrecisionAsString()
	 * @see #setPrecisionAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcGeometricRepresentationContext_PrecisionAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getPrecisionAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcGeometricRepresentationContext#getPrecisionAsString <em>Precision As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Precision As String</em>' attribute.
	 * @see #isSetPrecisionAsString()
	 * @see #unsetPrecisionAsString()
	 * @see #getPrecisionAsString()
	 * @generated
	 */
	void setPrecisionAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcGeometricRepresentationContext#getPrecisionAsString <em>Precision As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPrecisionAsString()
	 * @see #getPrecisionAsString()
	 * @see #setPrecisionAsString(String)
	 * @generated
	 */
	void unsetPrecisionAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcGeometricRepresentationContext#getPrecisionAsString <em>Precision As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Precision As String</em>' attribute is set.
	 * @see #unsetPrecisionAsString()
	 * @see #getPrecisionAsString()
	 * @see #setPrecisionAsString(String)
	 * @generated
	 */
	boolean isSetPrecisionAsString();

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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcGeometricRepresentationContext_WorldCoordinateSystem()
	 * @model
	 * @generated
	 */
	IfcAxis2Placement getWorldCoordinateSystem();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcGeometricRepresentationContext#getWorldCoordinateSystem <em>World Coordinate System</em>}' reference.
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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcGeometricRepresentationContext_TrueNorth()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcDirection getTrueNorth();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcGeometricRepresentationContext#getTrueNorth <em>True North</em>}' reference.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcGeometricRepresentationContext#getTrueNorth <em>True North</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTrueNorth()
	 * @see #getTrueNorth()
	 * @see #setTrueNorth(IfcDirection)
	 * @generated
	 */
	void unsetTrueNorth();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcGeometricRepresentationContext#getTrueNorth <em>True North</em>}' reference is set.
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
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcGeometricRepresentationSubContext}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcGeometricRepresentationSubContext#getParentContext <em>Parent Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Sub Contexts</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Sub Contexts</em>' reference list.
	 * @see #isSetHasSubContexts()
	 * @see #unsetHasSubContexts()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcGeometricRepresentationContext_HasSubContexts()
	 * @see org.bimserver.models.ifc4.IfcGeometricRepresentationSubContext#getParentContext
	 * @model opposite="ParentContext" unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcGeometricRepresentationSubContext> getHasSubContexts();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcGeometricRepresentationContext#getHasSubContexts <em>Has Sub Contexts</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetHasSubContexts()
	 * @see #getHasSubContexts()
	 * @generated
	 */
	void unsetHasSubContexts();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcGeometricRepresentationContext#getHasSubContexts <em>Has Sub Contexts</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Has Sub Contexts</em>' reference list is set.
	 * @see #unsetHasSubContexts()
	 * @see #getHasSubContexts()
	 * @generated
	 */
	boolean isSetHasSubContexts();

	/**
	 * Returns the value of the '<em><b>Has Coordinate Operation</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcCoordinateOperation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Coordinate Operation</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Coordinate Operation</em>' reference list.
	 * @see #isSetHasCoordinateOperation()
	 * @see #unsetHasCoordinateOperation()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcGeometricRepresentationContext_HasCoordinateOperation()
	 * @model unsettable="true" upper="2"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcCoordinateOperation> getHasCoordinateOperation();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcGeometricRepresentationContext#getHasCoordinateOperation <em>Has Coordinate Operation</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetHasCoordinateOperation()
	 * @see #getHasCoordinateOperation()
	 * @generated
	 */
	void unsetHasCoordinateOperation();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcGeometricRepresentationContext#getHasCoordinateOperation <em>Has Coordinate Operation</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Has Coordinate Operation</em>' reference list is set.
	 * @see #unsetHasCoordinateOperation()
	 * @see #getHasCoordinateOperation()
	 * @generated
	 */
	boolean isSetHasCoordinateOperation();

} // IfcGeometricRepresentationContext
