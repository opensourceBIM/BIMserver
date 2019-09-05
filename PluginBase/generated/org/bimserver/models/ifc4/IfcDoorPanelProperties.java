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

public interface IfcDoorPanelProperties extends IfcPreDefinedPropertySet {
	/**
	 * Returns the value of the '<em><b>Panel Depth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Panel Depth</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Panel Depth</em>' attribute.
	 * @see #isSetPanelDepth()
	 * @see #unsetPanelDepth()
	 * @see #setPanelDepth(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcDoorPanelProperties_PanelDepth()
	 * @model unsettable="true"
	 * @generated
	 */
	double getPanelDepth();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcDoorPanelProperties#getPanelDepth <em>Panel Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Panel Depth</em>' attribute.
	 * @see #isSetPanelDepth()
	 * @see #unsetPanelDepth()
	 * @see #getPanelDepth()
	 * @generated
	 */
	void setPanelDepth(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcDoorPanelProperties#getPanelDepth <em>Panel Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPanelDepth()
	 * @see #getPanelDepth()
	 * @see #setPanelDepth(double)
	 * @generated
	 */
	void unsetPanelDepth();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcDoorPanelProperties#getPanelDepth <em>Panel Depth</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Panel Depth</em>' attribute is set.
	 * @see #unsetPanelDepth()
	 * @see #getPanelDepth()
	 * @see #setPanelDepth(double)
	 * @generated
	 */
	boolean isSetPanelDepth();

	/**
	 * Returns the value of the '<em><b>Panel Depth As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Panel Depth As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Panel Depth As String</em>' attribute.
	 * @see #isSetPanelDepthAsString()
	 * @see #unsetPanelDepthAsString()
	 * @see #setPanelDepthAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcDoorPanelProperties_PanelDepthAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getPanelDepthAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcDoorPanelProperties#getPanelDepthAsString <em>Panel Depth As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Panel Depth As String</em>' attribute.
	 * @see #isSetPanelDepthAsString()
	 * @see #unsetPanelDepthAsString()
	 * @see #getPanelDepthAsString()
	 * @generated
	 */
	void setPanelDepthAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcDoorPanelProperties#getPanelDepthAsString <em>Panel Depth As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPanelDepthAsString()
	 * @see #getPanelDepthAsString()
	 * @see #setPanelDepthAsString(String)
	 * @generated
	 */
	void unsetPanelDepthAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcDoorPanelProperties#getPanelDepthAsString <em>Panel Depth As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Panel Depth As String</em>' attribute is set.
	 * @see #unsetPanelDepthAsString()
	 * @see #getPanelDepthAsString()
	 * @see #setPanelDepthAsString(String)
	 * @generated
	 */
	boolean isSetPanelDepthAsString();

	/**
	 * Returns the value of the '<em><b>Panel Operation</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.IfcDoorPanelOperationEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Panel Operation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Panel Operation</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcDoorPanelOperationEnum
	 * @see #setPanelOperation(IfcDoorPanelOperationEnum)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcDoorPanelProperties_PanelOperation()
	 * @model
	 * @generated
	 */
	IfcDoorPanelOperationEnum getPanelOperation();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcDoorPanelProperties#getPanelOperation <em>Panel Operation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Panel Operation</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcDoorPanelOperationEnum
	 * @see #getPanelOperation()
	 * @generated
	 */
	void setPanelOperation(IfcDoorPanelOperationEnum value);

	/**
	 * Returns the value of the '<em><b>Panel Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Panel Width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Panel Width</em>' attribute.
	 * @see #isSetPanelWidth()
	 * @see #unsetPanelWidth()
	 * @see #setPanelWidth(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcDoorPanelProperties_PanelWidth()
	 * @model unsettable="true"
	 * @generated
	 */
	double getPanelWidth();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcDoorPanelProperties#getPanelWidth <em>Panel Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Panel Width</em>' attribute.
	 * @see #isSetPanelWidth()
	 * @see #unsetPanelWidth()
	 * @see #getPanelWidth()
	 * @generated
	 */
	void setPanelWidth(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcDoorPanelProperties#getPanelWidth <em>Panel Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPanelWidth()
	 * @see #getPanelWidth()
	 * @see #setPanelWidth(double)
	 * @generated
	 */
	void unsetPanelWidth();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcDoorPanelProperties#getPanelWidth <em>Panel Width</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Panel Width</em>' attribute is set.
	 * @see #unsetPanelWidth()
	 * @see #getPanelWidth()
	 * @see #setPanelWidth(double)
	 * @generated
	 */
	boolean isSetPanelWidth();

	/**
	 * Returns the value of the '<em><b>Panel Width As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Panel Width As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Panel Width As String</em>' attribute.
	 * @see #isSetPanelWidthAsString()
	 * @see #unsetPanelWidthAsString()
	 * @see #setPanelWidthAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcDoorPanelProperties_PanelWidthAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getPanelWidthAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcDoorPanelProperties#getPanelWidthAsString <em>Panel Width As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Panel Width As String</em>' attribute.
	 * @see #isSetPanelWidthAsString()
	 * @see #unsetPanelWidthAsString()
	 * @see #getPanelWidthAsString()
	 * @generated
	 */
	void setPanelWidthAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcDoorPanelProperties#getPanelWidthAsString <em>Panel Width As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPanelWidthAsString()
	 * @see #getPanelWidthAsString()
	 * @see #setPanelWidthAsString(String)
	 * @generated
	 */
	void unsetPanelWidthAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcDoorPanelProperties#getPanelWidthAsString <em>Panel Width As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Panel Width As String</em>' attribute is set.
	 * @see #unsetPanelWidthAsString()
	 * @see #getPanelWidthAsString()
	 * @see #setPanelWidthAsString(String)
	 * @generated
	 */
	boolean isSetPanelWidthAsString();

	/**
	 * Returns the value of the '<em><b>Panel Position</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.IfcDoorPanelPositionEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Panel Position</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Panel Position</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcDoorPanelPositionEnum
	 * @see #setPanelPosition(IfcDoorPanelPositionEnum)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcDoorPanelProperties_PanelPosition()
	 * @model
	 * @generated
	 */
	IfcDoorPanelPositionEnum getPanelPosition();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcDoorPanelProperties#getPanelPosition <em>Panel Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Panel Position</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcDoorPanelPositionEnum
	 * @see #getPanelPosition()
	 * @generated
	 */
	void setPanelPosition(IfcDoorPanelPositionEnum value);

	/**
	 * Returns the value of the '<em><b>Shape Aspect Style</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shape Aspect Style</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shape Aspect Style</em>' reference.
	 * @see #isSetShapeAspectStyle()
	 * @see #unsetShapeAspectStyle()
	 * @see #setShapeAspectStyle(IfcShapeAspect)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcDoorPanelProperties_ShapeAspectStyle()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcShapeAspect getShapeAspectStyle();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcDoorPanelProperties#getShapeAspectStyle <em>Shape Aspect Style</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shape Aspect Style</em>' reference.
	 * @see #isSetShapeAspectStyle()
	 * @see #unsetShapeAspectStyle()
	 * @see #getShapeAspectStyle()
	 * @generated
	 */
	void setShapeAspectStyle(IfcShapeAspect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcDoorPanelProperties#getShapeAspectStyle <em>Shape Aspect Style</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetShapeAspectStyle()
	 * @see #getShapeAspectStyle()
	 * @see #setShapeAspectStyle(IfcShapeAspect)
	 * @generated
	 */
	void unsetShapeAspectStyle();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcDoorPanelProperties#getShapeAspectStyle <em>Shape Aspect Style</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Shape Aspect Style</em>' reference is set.
	 * @see #unsetShapeAspectStyle()
	 * @see #getShapeAspectStyle()
	 * @see #setShapeAspectStyle(IfcShapeAspect)
	 * @generated
	 */
	boolean isSetShapeAspectStyle();

} // IfcDoorPanelProperties
