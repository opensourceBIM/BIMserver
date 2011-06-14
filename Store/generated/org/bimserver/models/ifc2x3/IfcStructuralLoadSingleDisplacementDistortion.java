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
 * A representation of the model object '<em><b>Ifc Structural Load Single Displacement Distortion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleDisplacementDistortion#getDistortion <em>Distortion</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleDisplacementDistortion#getDistortionAsString <em>Distortion As String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralLoadSingleDisplacementDistortion()
 * @model
 * @generated
 */
public interface IfcStructuralLoadSingleDisplacementDistortion extends IfcStructuralLoadSingleDisplacement
{
	/**
	 * Returns the value of the '<em><b>Distortion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Distortion</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Distortion</em>' attribute.
	 * @see #isSetDistortion()
	 * @see #unsetDistortion()
	 * @see #setDistortion(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralLoadSingleDisplacementDistortion_Distortion()
	 * @model unsettable="true"
	 * @generated
	 */
	float getDistortion();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleDisplacementDistortion#getDistortion <em>Distortion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Distortion</em>' attribute.
	 * @see #isSetDistortion()
	 * @see #unsetDistortion()
	 * @see #getDistortion()
	 * @generated
	 */
	void setDistortion(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleDisplacementDistortion#getDistortion <em>Distortion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDistortion()
	 * @see #getDistortion()
	 * @see #setDistortion(float)
	 * @generated
	 */
	void unsetDistortion();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleDisplacementDistortion#getDistortion <em>Distortion</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Distortion</em>' attribute is set.
	 * @see #unsetDistortion()
	 * @see #getDistortion()
	 * @see #setDistortion(float)
	 * @generated
	 */
	boolean isSetDistortion();

	/**
	 * Returns the value of the '<em><b>Distortion As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Distortion As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Distortion As String</em>' attribute.
	 * @see #isSetDistortionAsString()
	 * @see #unsetDistortionAsString()
	 * @see #setDistortionAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralLoadSingleDisplacementDistortion_DistortionAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getDistortionAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleDisplacementDistortion#getDistortionAsString <em>Distortion As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Distortion As String</em>' attribute.
	 * @see #isSetDistortionAsString()
	 * @see #unsetDistortionAsString()
	 * @see #getDistortionAsString()
	 * @generated
	 */
	void setDistortionAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleDisplacementDistortion#getDistortionAsString <em>Distortion As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDistortionAsString()
	 * @see #getDistortionAsString()
	 * @see #setDistortionAsString(String)
	 * @generated
	 */
	void unsetDistortionAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleDisplacementDistortion#getDistortionAsString <em>Distortion As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Distortion As String</em>' attribute is set.
	 * @see #unsetDistortionAsString()
	 * @see #getDistortionAsString()
	 * @see #setDistortionAsString(String)
	 * @generated
	 */
	boolean isSetDistortionAsString();

} // IfcStructuralLoadSingleDisplacementDistortion
