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
 * A representation of the model object '<em><b>Ifc Door Lining Properties</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getLiningDepth <em>Lining Depth</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getLiningDepthAsString <em>Lining Depth As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getLiningThickness <em>Lining Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getLiningThicknessAsString <em>Lining Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getThresholdDepth <em>Threshold Depth</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getThresholdDepthAsString <em>Threshold Depth As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getThresholdThickness <em>Threshold Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getThresholdThicknessAsString <em>Threshold Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getTransomThickness <em>Transom Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getTransomThicknessAsString <em>Transom Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getTransomOffset <em>Transom Offset</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getTransomOffsetAsString <em>Transom Offset As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getLiningOffset <em>Lining Offset</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getLiningOffsetAsString <em>Lining Offset As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getThresholdOffset <em>Threshold Offset</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getThresholdOffsetAsString <em>Threshold Offset As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getCasingThickness <em>Casing Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getCasingThicknessAsString <em>Casing Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getCasingDepth <em>Casing Depth</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getCasingDepthAsString <em>Casing Depth As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getShapeAspectStyle <em>Shape Aspect Style</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDoorLiningProperties()
 * @model
 * @generated
 */
public interface IfcDoorLiningProperties extends IfcPropertySetDefinition
{
	/**
	 * Returns the value of the '<em><b>Lining Depth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lining Depth</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lining Depth</em>' attribute.
	 * @see #isSetLiningDepth()
	 * @see #unsetLiningDepth()
	 * @see #setLiningDepth(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDoorLiningProperties_LiningDepth()
	 * @model unsettable="true"
	 * @generated
	 */
	float getLiningDepth();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getLiningDepth <em>Lining Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lining Depth</em>' attribute.
	 * @see #isSetLiningDepth()
	 * @see #unsetLiningDepth()
	 * @see #getLiningDepth()
	 * @generated
	 */
	void setLiningDepth(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getLiningDepth <em>Lining Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLiningDepth()
	 * @see #getLiningDepth()
	 * @see #setLiningDepth(float)
	 * @generated
	 */
	void unsetLiningDepth();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getLiningDepth <em>Lining Depth</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Lining Depth</em>' attribute is set.
	 * @see #unsetLiningDepth()
	 * @see #getLiningDepth()
	 * @see #setLiningDepth(float)
	 * @generated
	 */
	boolean isSetLiningDepth();

	/**
	 * Returns the value of the '<em><b>Lining Depth As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lining Depth As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lining Depth As String</em>' attribute.
	 * @see #isSetLiningDepthAsString()
	 * @see #unsetLiningDepthAsString()
	 * @see #setLiningDepthAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDoorLiningProperties_LiningDepthAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getLiningDepthAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getLiningDepthAsString <em>Lining Depth As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lining Depth As String</em>' attribute.
	 * @see #isSetLiningDepthAsString()
	 * @see #unsetLiningDepthAsString()
	 * @see #getLiningDepthAsString()
	 * @generated
	 */
	void setLiningDepthAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getLiningDepthAsString <em>Lining Depth As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLiningDepthAsString()
	 * @see #getLiningDepthAsString()
	 * @see #setLiningDepthAsString(String)
	 * @generated
	 */
	void unsetLiningDepthAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getLiningDepthAsString <em>Lining Depth As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Lining Depth As String</em>' attribute is set.
	 * @see #unsetLiningDepthAsString()
	 * @see #getLiningDepthAsString()
	 * @see #setLiningDepthAsString(String)
	 * @generated
	 */
	boolean isSetLiningDepthAsString();

	/**
	 * Returns the value of the '<em><b>Lining Thickness</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lining Thickness</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lining Thickness</em>' attribute.
	 * @see #isSetLiningThickness()
	 * @see #unsetLiningThickness()
	 * @see #setLiningThickness(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDoorLiningProperties_LiningThickness()
	 * @model unsettable="true"
	 * @generated
	 */
	float getLiningThickness();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getLiningThickness <em>Lining Thickness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lining Thickness</em>' attribute.
	 * @see #isSetLiningThickness()
	 * @see #unsetLiningThickness()
	 * @see #getLiningThickness()
	 * @generated
	 */
	void setLiningThickness(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getLiningThickness <em>Lining Thickness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLiningThickness()
	 * @see #getLiningThickness()
	 * @see #setLiningThickness(float)
	 * @generated
	 */
	void unsetLiningThickness();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getLiningThickness <em>Lining Thickness</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Lining Thickness</em>' attribute is set.
	 * @see #unsetLiningThickness()
	 * @see #getLiningThickness()
	 * @see #setLiningThickness(float)
	 * @generated
	 */
	boolean isSetLiningThickness();

	/**
	 * Returns the value of the '<em><b>Lining Thickness As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lining Thickness As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lining Thickness As String</em>' attribute.
	 * @see #isSetLiningThicknessAsString()
	 * @see #unsetLiningThicknessAsString()
	 * @see #setLiningThicknessAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDoorLiningProperties_LiningThicknessAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getLiningThicknessAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getLiningThicknessAsString <em>Lining Thickness As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lining Thickness As String</em>' attribute.
	 * @see #isSetLiningThicknessAsString()
	 * @see #unsetLiningThicknessAsString()
	 * @see #getLiningThicknessAsString()
	 * @generated
	 */
	void setLiningThicknessAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getLiningThicknessAsString <em>Lining Thickness As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLiningThicknessAsString()
	 * @see #getLiningThicknessAsString()
	 * @see #setLiningThicknessAsString(String)
	 * @generated
	 */
	void unsetLiningThicknessAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getLiningThicknessAsString <em>Lining Thickness As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Lining Thickness As String</em>' attribute is set.
	 * @see #unsetLiningThicknessAsString()
	 * @see #getLiningThicknessAsString()
	 * @see #setLiningThicknessAsString(String)
	 * @generated
	 */
	boolean isSetLiningThicknessAsString();

	/**
	 * Returns the value of the '<em><b>Threshold Depth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Threshold Depth</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Threshold Depth</em>' attribute.
	 * @see #isSetThresholdDepth()
	 * @see #unsetThresholdDepth()
	 * @see #setThresholdDepth(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDoorLiningProperties_ThresholdDepth()
	 * @model unsettable="true"
	 * @generated
	 */
	float getThresholdDepth();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getThresholdDepth <em>Threshold Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Threshold Depth</em>' attribute.
	 * @see #isSetThresholdDepth()
	 * @see #unsetThresholdDepth()
	 * @see #getThresholdDepth()
	 * @generated
	 */
	void setThresholdDepth(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getThresholdDepth <em>Threshold Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetThresholdDepth()
	 * @see #getThresholdDepth()
	 * @see #setThresholdDepth(float)
	 * @generated
	 */
	void unsetThresholdDepth();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getThresholdDepth <em>Threshold Depth</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Threshold Depth</em>' attribute is set.
	 * @see #unsetThresholdDepth()
	 * @see #getThresholdDepth()
	 * @see #setThresholdDepth(float)
	 * @generated
	 */
	boolean isSetThresholdDepth();

	/**
	 * Returns the value of the '<em><b>Threshold Depth As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Threshold Depth As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Threshold Depth As String</em>' attribute.
	 * @see #isSetThresholdDepthAsString()
	 * @see #unsetThresholdDepthAsString()
	 * @see #setThresholdDepthAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDoorLiningProperties_ThresholdDepthAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getThresholdDepthAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getThresholdDepthAsString <em>Threshold Depth As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Threshold Depth As String</em>' attribute.
	 * @see #isSetThresholdDepthAsString()
	 * @see #unsetThresholdDepthAsString()
	 * @see #getThresholdDepthAsString()
	 * @generated
	 */
	void setThresholdDepthAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getThresholdDepthAsString <em>Threshold Depth As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetThresholdDepthAsString()
	 * @see #getThresholdDepthAsString()
	 * @see #setThresholdDepthAsString(String)
	 * @generated
	 */
	void unsetThresholdDepthAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getThresholdDepthAsString <em>Threshold Depth As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Threshold Depth As String</em>' attribute is set.
	 * @see #unsetThresholdDepthAsString()
	 * @see #getThresholdDepthAsString()
	 * @see #setThresholdDepthAsString(String)
	 * @generated
	 */
	boolean isSetThresholdDepthAsString();

	/**
	 * Returns the value of the '<em><b>Threshold Thickness</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Threshold Thickness</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Threshold Thickness</em>' attribute.
	 * @see #isSetThresholdThickness()
	 * @see #unsetThresholdThickness()
	 * @see #setThresholdThickness(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDoorLiningProperties_ThresholdThickness()
	 * @model unsettable="true"
	 * @generated
	 */
	float getThresholdThickness();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getThresholdThickness <em>Threshold Thickness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Threshold Thickness</em>' attribute.
	 * @see #isSetThresholdThickness()
	 * @see #unsetThresholdThickness()
	 * @see #getThresholdThickness()
	 * @generated
	 */
	void setThresholdThickness(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getThresholdThickness <em>Threshold Thickness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetThresholdThickness()
	 * @see #getThresholdThickness()
	 * @see #setThresholdThickness(float)
	 * @generated
	 */
	void unsetThresholdThickness();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getThresholdThickness <em>Threshold Thickness</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Threshold Thickness</em>' attribute is set.
	 * @see #unsetThresholdThickness()
	 * @see #getThresholdThickness()
	 * @see #setThresholdThickness(float)
	 * @generated
	 */
	boolean isSetThresholdThickness();

	/**
	 * Returns the value of the '<em><b>Threshold Thickness As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Threshold Thickness As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Threshold Thickness As String</em>' attribute.
	 * @see #isSetThresholdThicknessAsString()
	 * @see #unsetThresholdThicknessAsString()
	 * @see #setThresholdThicknessAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDoorLiningProperties_ThresholdThicknessAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getThresholdThicknessAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getThresholdThicknessAsString <em>Threshold Thickness As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Threshold Thickness As String</em>' attribute.
	 * @see #isSetThresholdThicknessAsString()
	 * @see #unsetThresholdThicknessAsString()
	 * @see #getThresholdThicknessAsString()
	 * @generated
	 */
	void setThresholdThicknessAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getThresholdThicknessAsString <em>Threshold Thickness As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetThresholdThicknessAsString()
	 * @see #getThresholdThicknessAsString()
	 * @see #setThresholdThicknessAsString(String)
	 * @generated
	 */
	void unsetThresholdThicknessAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getThresholdThicknessAsString <em>Threshold Thickness As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Threshold Thickness As String</em>' attribute is set.
	 * @see #unsetThresholdThicknessAsString()
	 * @see #getThresholdThicknessAsString()
	 * @see #setThresholdThicknessAsString(String)
	 * @generated
	 */
	boolean isSetThresholdThicknessAsString();

	/**
	 * Returns the value of the '<em><b>Transom Thickness</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transom Thickness</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transom Thickness</em>' attribute.
	 * @see #isSetTransomThickness()
	 * @see #unsetTransomThickness()
	 * @see #setTransomThickness(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDoorLiningProperties_TransomThickness()
	 * @model unsettable="true"
	 * @generated
	 */
	float getTransomThickness();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getTransomThickness <em>Transom Thickness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transom Thickness</em>' attribute.
	 * @see #isSetTransomThickness()
	 * @see #unsetTransomThickness()
	 * @see #getTransomThickness()
	 * @generated
	 */
	void setTransomThickness(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getTransomThickness <em>Transom Thickness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTransomThickness()
	 * @see #getTransomThickness()
	 * @see #setTransomThickness(float)
	 * @generated
	 */
	void unsetTransomThickness();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getTransomThickness <em>Transom Thickness</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Transom Thickness</em>' attribute is set.
	 * @see #unsetTransomThickness()
	 * @see #getTransomThickness()
	 * @see #setTransomThickness(float)
	 * @generated
	 */
	boolean isSetTransomThickness();

	/**
	 * Returns the value of the '<em><b>Transom Thickness As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transom Thickness As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transom Thickness As String</em>' attribute.
	 * @see #isSetTransomThicknessAsString()
	 * @see #unsetTransomThicknessAsString()
	 * @see #setTransomThicknessAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDoorLiningProperties_TransomThicknessAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getTransomThicknessAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getTransomThicknessAsString <em>Transom Thickness As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transom Thickness As String</em>' attribute.
	 * @see #isSetTransomThicknessAsString()
	 * @see #unsetTransomThicknessAsString()
	 * @see #getTransomThicknessAsString()
	 * @generated
	 */
	void setTransomThicknessAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getTransomThicknessAsString <em>Transom Thickness As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTransomThicknessAsString()
	 * @see #getTransomThicknessAsString()
	 * @see #setTransomThicknessAsString(String)
	 * @generated
	 */
	void unsetTransomThicknessAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getTransomThicknessAsString <em>Transom Thickness As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Transom Thickness As String</em>' attribute is set.
	 * @see #unsetTransomThicknessAsString()
	 * @see #getTransomThicknessAsString()
	 * @see #setTransomThicknessAsString(String)
	 * @generated
	 */
	boolean isSetTransomThicknessAsString();

	/**
	 * Returns the value of the '<em><b>Transom Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transom Offset</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transom Offset</em>' attribute.
	 * @see #isSetTransomOffset()
	 * @see #unsetTransomOffset()
	 * @see #setTransomOffset(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDoorLiningProperties_TransomOffset()
	 * @model unsettable="true"
	 * @generated
	 */
	float getTransomOffset();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getTransomOffset <em>Transom Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transom Offset</em>' attribute.
	 * @see #isSetTransomOffset()
	 * @see #unsetTransomOffset()
	 * @see #getTransomOffset()
	 * @generated
	 */
	void setTransomOffset(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getTransomOffset <em>Transom Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTransomOffset()
	 * @see #getTransomOffset()
	 * @see #setTransomOffset(float)
	 * @generated
	 */
	void unsetTransomOffset();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getTransomOffset <em>Transom Offset</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Transom Offset</em>' attribute is set.
	 * @see #unsetTransomOffset()
	 * @see #getTransomOffset()
	 * @see #setTransomOffset(float)
	 * @generated
	 */
	boolean isSetTransomOffset();

	/**
	 * Returns the value of the '<em><b>Transom Offset As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transom Offset As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transom Offset As String</em>' attribute.
	 * @see #isSetTransomOffsetAsString()
	 * @see #unsetTransomOffsetAsString()
	 * @see #setTransomOffsetAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDoorLiningProperties_TransomOffsetAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getTransomOffsetAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getTransomOffsetAsString <em>Transom Offset As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transom Offset As String</em>' attribute.
	 * @see #isSetTransomOffsetAsString()
	 * @see #unsetTransomOffsetAsString()
	 * @see #getTransomOffsetAsString()
	 * @generated
	 */
	void setTransomOffsetAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getTransomOffsetAsString <em>Transom Offset As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTransomOffsetAsString()
	 * @see #getTransomOffsetAsString()
	 * @see #setTransomOffsetAsString(String)
	 * @generated
	 */
	void unsetTransomOffsetAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getTransomOffsetAsString <em>Transom Offset As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Transom Offset As String</em>' attribute is set.
	 * @see #unsetTransomOffsetAsString()
	 * @see #getTransomOffsetAsString()
	 * @see #setTransomOffsetAsString(String)
	 * @generated
	 */
	boolean isSetTransomOffsetAsString();

	/**
	 * Returns the value of the '<em><b>Lining Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lining Offset</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lining Offset</em>' attribute.
	 * @see #isSetLiningOffset()
	 * @see #unsetLiningOffset()
	 * @see #setLiningOffset(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDoorLiningProperties_LiningOffset()
	 * @model unsettable="true"
	 * @generated
	 */
	float getLiningOffset();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getLiningOffset <em>Lining Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lining Offset</em>' attribute.
	 * @see #isSetLiningOffset()
	 * @see #unsetLiningOffset()
	 * @see #getLiningOffset()
	 * @generated
	 */
	void setLiningOffset(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getLiningOffset <em>Lining Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLiningOffset()
	 * @see #getLiningOffset()
	 * @see #setLiningOffset(float)
	 * @generated
	 */
	void unsetLiningOffset();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getLiningOffset <em>Lining Offset</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Lining Offset</em>' attribute is set.
	 * @see #unsetLiningOffset()
	 * @see #getLiningOffset()
	 * @see #setLiningOffset(float)
	 * @generated
	 */
	boolean isSetLiningOffset();

	/**
	 * Returns the value of the '<em><b>Lining Offset As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lining Offset As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lining Offset As String</em>' attribute.
	 * @see #isSetLiningOffsetAsString()
	 * @see #unsetLiningOffsetAsString()
	 * @see #setLiningOffsetAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDoorLiningProperties_LiningOffsetAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getLiningOffsetAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getLiningOffsetAsString <em>Lining Offset As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lining Offset As String</em>' attribute.
	 * @see #isSetLiningOffsetAsString()
	 * @see #unsetLiningOffsetAsString()
	 * @see #getLiningOffsetAsString()
	 * @generated
	 */
	void setLiningOffsetAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getLiningOffsetAsString <em>Lining Offset As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLiningOffsetAsString()
	 * @see #getLiningOffsetAsString()
	 * @see #setLiningOffsetAsString(String)
	 * @generated
	 */
	void unsetLiningOffsetAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getLiningOffsetAsString <em>Lining Offset As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Lining Offset As String</em>' attribute is set.
	 * @see #unsetLiningOffsetAsString()
	 * @see #getLiningOffsetAsString()
	 * @see #setLiningOffsetAsString(String)
	 * @generated
	 */
	boolean isSetLiningOffsetAsString();

	/**
	 * Returns the value of the '<em><b>Threshold Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Threshold Offset</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Threshold Offset</em>' attribute.
	 * @see #isSetThresholdOffset()
	 * @see #unsetThresholdOffset()
	 * @see #setThresholdOffset(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDoorLiningProperties_ThresholdOffset()
	 * @model unsettable="true"
	 * @generated
	 */
	float getThresholdOffset();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getThresholdOffset <em>Threshold Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Threshold Offset</em>' attribute.
	 * @see #isSetThresholdOffset()
	 * @see #unsetThresholdOffset()
	 * @see #getThresholdOffset()
	 * @generated
	 */
	void setThresholdOffset(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getThresholdOffset <em>Threshold Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetThresholdOffset()
	 * @see #getThresholdOffset()
	 * @see #setThresholdOffset(float)
	 * @generated
	 */
	void unsetThresholdOffset();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getThresholdOffset <em>Threshold Offset</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Threshold Offset</em>' attribute is set.
	 * @see #unsetThresholdOffset()
	 * @see #getThresholdOffset()
	 * @see #setThresholdOffset(float)
	 * @generated
	 */
	boolean isSetThresholdOffset();

	/**
	 * Returns the value of the '<em><b>Threshold Offset As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Threshold Offset As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Threshold Offset As String</em>' attribute.
	 * @see #isSetThresholdOffsetAsString()
	 * @see #unsetThresholdOffsetAsString()
	 * @see #setThresholdOffsetAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDoorLiningProperties_ThresholdOffsetAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getThresholdOffsetAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getThresholdOffsetAsString <em>Threshold Offset As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Threshold Offset As String</em>' attribute.
	 * @see #isSetThresholdOffsetAsString()
	 * @see #unsetThresholdOffsetAsString()
	 * @see #getThresholdOffsetAsString()
	 * @generated
	 */
	void setThresholdOffsetAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getThresholdOffsetAsString <em>Threshold Offset As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetThresholdOffsetAsString()
	 * @see #getThresholdOffsetAsString()
	 * @see #setThresholdOffsetAsString(String)
	 * @generated
	 */
	void unsetThresholdOffsetAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getThresholdOffsetAsString <em>Threshold Offset As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Threshold Offset As String</em>' attribute is set.
	 * @see #unsetThresholdOffsetAsString()
	 * @see #getThresholdOffsetAsString()
	 * @see #setThresholdOffsetAsString(String)
	 * @generated
	 */
	boolean isSetThresholdOffsetAsString();

	/**
	 * Returns the value of the '<em><b>Casing Thickness</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Casing Thickness</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Casing Thickness</em>' attribute.
	 * @see #isSetCasingThickness()
	 * @see #unsetCasingThickness()
	 * @see #setCasingThickness(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDoorLiningProperties_CasingThickness()
	 * @model unsettable="true"
	 * @generated
	 */
	float getCasingThickness();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getCasingThickness <em>Casing Thickness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Casing Thickness</em>' attribute.
	 * @see #isSetCasingThickness()
	 * @see #unsetCasingThickness()
	 * @see #getCasingThickness()
	 * @generated
	 */
	void setCasingThickness(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getCasingThickness <em>Casing Thickness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCasingThickness()
	 * @see #getCasingThickness()
	 * @see #setCasingThickness(float)
	 * @generated
	 */
	void unsetCasingThickness();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getCasingThickness <em>Casing Thickness</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Casing Thickness</em>' attribute is set.
	 * @see #unsetCasingThickness()
	 * @see #getCasingThickness()
	 * @see #setCasingThickness(float)
	 * @generated
	 */
	boolean isSetCasingThickness();

	/**
	 * Returns the value of the '<em><b>Casing Thickness As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Casing Thickness As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Casing Thickness As String</em>' attribute.
	 * @see #isSetCasingThicknessAsString()
	 * @see #unsetCasingThicknessAsString()
	 * @see #setCasingThicknessAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDoorLiningProperties_CasingThicknessAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getCasingThicknessAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getCasingThicknessAsString <em>Casing Thickness As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Casing Thickness As String</em>' attribute.
	 * @see #isSetCasingThicknessAsString()
	 * @see #unsetCasingThicknessAsString()
	 * @see #getCasingThicknessAsString()
	 * @generated
	 */
	void setCasingThicknessAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getCasingThicknessAsString <em>Casing Thickness As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCasingThicknessAsString()
	 * @see #getCasingThicknessAsString()
	 * @see #setCasingThicknessAsString(String)
	 * @generated
	 */
	void unsetCasingThicknessAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getCasingThicknessAsString <em>Casing Thickness As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Casing Thickness As String</em>' attribute is set.
	 * @see #unsetCasingThicknessAsString()
	 * @see #getCasingThicknessAsString()
	 * @see #setCasingThicknessAsString(String)
	 * @generated
	 */
	boolean isSetCasingThicknessAsString();

	/**
	 * Returns the value of the '<em><b>Casing Depth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Casing Depth</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Casing Depth</em>' attribute.
	 * @see #isSetCasingDepth()
	 * @see #unsetCasingDepth()
	 * @see #setCasingDepth(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDoorLiningProperties_CasingDepth()
	 * @model unsettable="true"
	 * @generated
	 */
	float getCasingDepth();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getCasingDepth <em>Casing Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Casing Depth</em>' attribute.
	 * @see #isSetCasingDepth()
	 * @see #unsetCasingDepth()
	 * @see #getCasingDepth()
	 * @generated
	 */
	void setCasingDepth(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getCasingDepth <em>Casing Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCasingDepth()
	 * @see #getCasingDepth()
	 * @see #setCasingDepth(float)
	 * @generated
	 */
	void unsetCasingDepth();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getCasingDepth <em>Casing Depth</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Casing Depth</em>' attribute is set.
	 * @see #unsetCasingDepth()
	 * @see #getCasingDepth()
	 * @see #setCasingDepth(float)
	 * @generated
	 */
	boolean isSetCasingDepth();

	/**
	 * Returns the value of the '<em><b>Casing Depth As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Casing Depth As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Casing Depth As String</em>' attribute.
	 * @see #isSetCasingDepthAsString()
	 * @see #unsetCasingDepthAsString()
	 * @see #setCasingDepthAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDoorLiningProperties_CasingDepthAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getCasingDepthAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getCasingDepthAsString <em>Casing Depth As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Casing Depth As String</em>' attribute.
	 * @see #isSetCasingDepthAsString()
	 * @see #unsetCasingDepthAsString()
	 * @see #getCasingDepthAsString()
	 * @generated
	 */
	void setCasingDepthAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getCasingDepthAsString <em>Casing Depth As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCasingDepthAsString()
	 * @see #getCasingDepthAsString()
	 * @see #setCasingDepthAsString(String)
	 * @generated
	 */
	void unsetCasingDepthAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getCasingDepthAsString <em>Casing Depth As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Casing Depth As String</em>' attribute is set.
	 * @see #unsetCasingDepthAsString()
	 * @see #getCasingDepthAsString()
	 * @see #setCasingDepthAsString(String)
	 * @generated
	 */
	boolean isSetCasingDepthAsString();

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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDoorLiningProperties_ShapeAspectStyle()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcShapeAspect getShapeAspectStyle();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getShapeAspectStyle <em>Shape Aspect Style</em>}' reference.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getShapeAspectStyle <em>Shape Aspect Style</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetShapeAspectStyle()
	 * @see #getShapeAspectStyle()
	 * @see #setShapeAspectStyle(IfcShapeAspect)
	 * @generated
	 */
	void unsetShapeAspectStyle();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorLiningProperties#getShapeAspectStyle <em>Shape Aspect Style</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Shape Aspect Style</em>' reference is set.
	 * @see #unsetShapeAspectStyle()
	 * @see #getShapeAspectStyle()
	 * @see #setShapeAspectStyle(IfcShapeAspect)
	 * @generated
	 */
	boolean isSetShapeAspectStyle();

} // IfcDoorLiningProperties
