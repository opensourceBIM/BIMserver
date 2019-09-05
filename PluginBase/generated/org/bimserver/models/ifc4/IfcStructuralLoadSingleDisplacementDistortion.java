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

public interface IfcStructuralLoadSingleDisplacementDistortion extends IfcStructuralLoadSingleDisplacement {
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
	 * @see #setDistortion(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcStructuralLoadSingleDisplacementDistortion_Distortion()
	 * @model unsettable="true"
	 * @generated
	 */
	double getDistortion();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcStructuralLoadSingleDisplacementDistortion#getDistortion <em>Distortion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Distortion</em>' attribute.
	 * @see #isSetDistortion()
	 * @see #unsetDistortion()
	 * @see #getDistortion()
	 * @generated
	 */
	void setDistortion(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcStructuralLoadSingleDisplacementDistortion#getDistortion <em>Distortion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDistortion()
	 * @see #getDistortion()
	 * @see #setDistortion(double)
	 * @generated
	 */
	void unsetDistortion();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcStructuralLoadSingleDisplacementDistortion#getDistortion <em>Distortion</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Distortion</em>' attribute is set.
	 * @see #unsetDistortion()
	 * @see #getDistortion()
	 * @see #setDistortion(double)
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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcStructuralLoadSingleDisplacementDistortion_DistortionAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getDistortionAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcStructuralLoadSingleDisplacementDistortion#getDistortionAsString <em>Distortion As String</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcStructuralLoadSingleDisplacementDistortion#getDistortionAsString <em>Distortion As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDistortionAsString()
	 * @see #getDistortionAsString()
	 * @see #setDistortionAsString(String)
	 * @generated
	 */
	void unsetDistortionAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcStructuralLoadSingleDisplacementDistortion#getDistortionAsString <em>Distortion As String</em>}' attribute is set.
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
