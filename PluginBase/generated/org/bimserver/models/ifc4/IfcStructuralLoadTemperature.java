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

public interface IfcStructuralLoadTemperature extends IfcStructuralLoadStatic {
	/**
	 * Returns the value of the '<em><b>Delta TConstant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Delta TConstant</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Delta TConstant</em>' attribute.
	 * @see #isSetDeltaTConstant()
	 * @see #unsetDeltaTConstant()
	 * @see #setDeltaTConstant(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcStructuralLoadTemperature_DeltaTConstant()
	 * @model unsettable="true"
	 * @generated
	 */
	double getDeltaTConstant();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcStructuralLoadTemperature#getDeltaTConstant <em>Delta TConstant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Delta TConstant</em>' attribute.
	 * @see #isSetDeltaTConstant()
	 * @see #unsetDeltaTConstant()
	 * @see #getDeltaTConstant()
	 * @generated
	 */
	void setDeltaTConstant(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcStructuralLoadTemperature#getDeltaTConstant <em>Delta TConstant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDeltaTConstant()
	 * @see #getDeltaTConstant()
	 * @see #setDeltaTConstant(double)
	 * @generated
	 */
	void unsetDeltaTConstant();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcStructuralLoadTemperature#getDeltaTConstant <em>Delta TConstant</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Delta TConstant</em>' attribute is set.
	 * @see #unsetDeltaTConstant()
	 * @see #getDeltaTConstant()
	 * @see #setDeltaTConstant(double)
	 * @generated
	 */
	boolean isSetDeltaTConstant();

	/**
	 * Returns the value of the '<em><b>Delta TConstant As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Delta TConstant As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Delta TConstant As String</em>' attribute.
	 * @see #isSetDeltaTConstantAsString()
	 * @see #unsetDeltaTConstantAsString()
	 * @see #setDeltaTConstantAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcStructuralLoadTemperature_DeltaTConstantAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getDeltaTConstantAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcStructuralLoadTemperature#getDeltaTConstantAsString <em>Delta TConstant As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Delta TConstant As String</em>' attribute.
	 * @see #isSetDeltaTConstantAsString()
	 * @see #unsetDeltaTConstantAsString()
	 * @see #getDeltaTConstantAsString()
	 * @generated
	 */
	void setDeltaTConstantAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcStructuralLoadTemperature#getDeltaTConstantAsString <em>Delta TConstant As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDeltaTConstantAsString()
	 * @see #getDeltaTConstantAsString()
	 * @see #setDeltaTConstantAsString(String)
	 * @generated
	 */
	void unsetDeltaTConstantAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcStructuralLoadTemperature#getDeltaTConstantAsString <em>Delta TConstant As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Delta TConstant As String</em>' attribute is set.
	 * @see #unsetDeltaTConstantAsString()
	 * @see #getDeltaTConstantAsString()
	 * @see #setDeltaTConstantAsString(String)
	 * @generated
	 */
	boolean isSetDeltaTConstantAsString();

	/**
	 * Returns the value of the '<em><b>Delta TY</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Delta TY</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Delta TY</em>' attribute.
	 * @see #isSetDeltaTY()
	 * @see #unsetDeltaTY()
	 * @see #setDeltaTY(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcStructuralLoadTemperature_DeltaTY()
	 * @model unsettable="true"
	 * @generated
	 */
	double getDeltaTY();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcStructuralLoadTemperature#getDeltaTY <em>Delta TY</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Delta TY</em>' attribute.
	 * @see #isSetDeltaTY()
	 * @see #unsetDeltaTY()
	 * @see #getDeltaTY()
	 * @generated
	 */
	void setDeltaTY(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcStructuralLoadTemperature#getDeltaTY <em>Delta TY</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDeltaTY()
	 * @see #getDeltaTY()
	 * @see #setDeltaTY(double)
	 * @generated
	 */
	void unsetDeltaTY();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcStructuralLoadTemperature#getDeltaTY <em>Delta TY</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Delta TY</em>' attribute is set.
	 * @see #unsetDeltaTY()
	 * @see #getDeltaTY()
	 * @see #setDeltaTY(double)
	 * @generated
	 */
	boolean isSetDeltaTY();

	/**
	 * Returns the value of the '<em><b>Delta TY As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Delta TY As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Delta TY As String</em>' attribute.
	 * @see #isSetDeltaTYAsString()
	 * @see #unsetDeltaTYAsString()
	 * @see #setDeltaTYAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcStructuralLoadTemperature_DeltaTYAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getDeltaTYAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcStructuralLoadTemperature#getDeltaTYAsString <em>Delta TY As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Delta TY As String</em>' attribute.
	 * @see #isSetDeltaTYAsString()
	 * @see #unsetDeltaTYAsString()
	 * @see #getDeltaTYAsString()
	 * @generated
	 */
	void setDeltaTYAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcStructuralLoadTemperature#getDeltaTYAsString <em>Delta TY As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDeltaTYAsString()
	 * @see #getDeltaTYAsString()
	 * @see #setDeltaTYAsString(String)
	 * @generated
	 */
	void unsetDeltaTYAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcStructuralLoadTemperature#getDeltaTYAsString <em>Delta TY As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Delta TY As String</em>' attribute is set.
	 * @see #unsetDeltaTYAsString()
	 * @see #getDeltaTYAsString()
	 * @see #setDeltaTYAsString(String)
	 * @generated
	 */
	boolean isSetDeltaTYAsString();

	/**
	 * Returns the value of the '<em><b>Delta TZ</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Delta TZ</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Delta TZ</em>' attribute.
	 * @see #isSetDeltaTZ()
	 * @see #unsetDeltaTZ()
	 * @see #setDeltaTZ(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcStructuralLoadTemperature_DeltaTZ()
	 * @model unsettable="true"
	 * @generated
	 */
	double getDeltaTZ();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcStructuralLoadTemperature#getDeltaTZ <em>Delta TZ</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Delta TZ</em>' attribute.
	 * @see #isSetDeltaTZ()
	 * @see #unsetDeltaTZ()
	 * @see #getDeltaTZ()
	 * @generated
	 */
	void setDeltaTZ(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcStructuralLoadTemperature#getDeltaTZ <em>Delta TZ</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDeltaTZ()
	 * @see #getDeltaTZ()
	 * @see #setDeltaTZ(double)
	 * @generated
	 */
	void unsetDeltaTZ();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcStructuralLoadTemperature#getDeltaTZ <em>Delta TZ</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Delta TZ</em>' attribute is set.
	 * @see #unsetDeltaTZ()
	 * @see #getDeltaTZ()
	 * @see #setDeltaTZ(double)
	 * @generated
	 */
	boolean isSetDeltaTZ();

	/**
	 * Returns the value of the '<em><b>Delta TZ As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Delta TZ As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Delta TZ As String</em>' attribute.
	 * @see #isSetDeltaTZAsString()
	 * @see #unsetDeltaTZAsString()
	 * @see #setDeltaTZAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcStructuralLoadTemperature_DeltaTZAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getDeltaTZAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcStructuralLoadTemperature#getDeltaTZAsString <em>Delta TZ As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Delta TZ As String</em>' attribute.
	 * @see #isSetDeltaTZAsString()
	 * @see #unsetDeltaTZAsString()
	 * @see #getDeltaTZAsString()
	 * @generated
	 */
	void setDeltaTZAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcStructuralLoadTemperature#getDeltaTZAsString <em>Delta TZ As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDeltaTZAsString()
	 * @see #getDeltaTZAsString()
	 * @see #setDeltaTZAsString(String)
	 * @generated
	 */
	void unsetDeltaTZAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcStructuralLoadTemperature#getDeltaTZAsString <em>Delta TZ As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Delta TZ As String</em>' attribute is set.
	 * @see #unsetDeltaTZAsString()
	 * @see #getDeltaTZAsString()
	 * @see #setDeltaTZAsString(String)
	 * @generated
	 */
	boolean isSetDeltaTZAsString();

} // IfcStructuralLoadTemperature
