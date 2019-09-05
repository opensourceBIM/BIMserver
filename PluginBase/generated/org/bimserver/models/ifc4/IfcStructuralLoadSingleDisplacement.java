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

public interface IfcStructuralLoadSingleDisplacement extends IfcStructuralLoadStatic {
	/**
	 * Returns the value of the '<em><b>Displacement X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Displacement X</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Displacement X</em>' attribute.
	 * @see #isSetDisplacementX()
	 * @see #unsetDisplacementX()
	 * @see #setDisplacementX(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcStructuralLoadSingleDisplacement_DisplacementX()
	 * @model unsettable="true"
	 * @generated
	 */
	double getDisplacementX();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcStructuralLoadSingleDisplacement#getDisplacementX <em>Displacement X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Displacement X</em>' attribute.
	 * @see #isSetDisplacementX()
	 * @see #unsetDisplacementX()
	 * @see #getDisplacementX()
	 * @generated
	 */
	void setDisplacementX(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcStructuralLoadSingleDisplacement#getDisplacementX <em>Displacement X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDisplacementX()
	 * @see #getDisplacementX()
	 * @see #setDisplacementX(double)
	 * @generated
	 */
	void unsetDisplacementX();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcStructuralLoadSingleDisplacement#getDisplacementX <em>Displacement X</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Displacement X</em>' attribute is set.
	 * @see #unsetDisplacementX()
	 * @see #getDisplacementX()
	 * @see #setDisplacementX(double)
	 * @generated
	 */
	boolean isSetDisplacementX();

	/**
	 * Returns the value of the '<em><b>Displacement XAs String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Displacement XAs String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Displacement XAs String</em>' attribute.
	 * @see #isSetDisplacementXAsString()
	 * @see #unsetDisplacementXAsString()
	 * @see #setDisplacementXAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcStructuralLoadSingleDisplacement_DisplacementXAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getDisplacementXAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcStructuralLoadSingleDisplacement#getDisplacementXAsString <em>Displacement XAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Displacement XAs String</em>' attribute.
	 * @see #isSetDisplacementXAsString()
	 * @see #unsetDisplacementXAsString()
	 * @see #getDisplacementXAsString()
	 * @generated
	 */
	void setDisplacementXAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcStructuralLoadSingleDisplacement#getDisplacementXAsString <em>Displacement XAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDisplacementXAsString()
	 * @see #getDisplacementXAsString()
	 * @see #setDisplacementXAsString(String)
	 * @generated
	 */
	void unsetDisplacementXAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcStructuralLoadSingleDisplacement#getDisplacementXAsString <em>Displacement XAs String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Displacement XAs String</em>' attribute is set.
	 * @see #unsetDisplacementXAsString()
	 * @see #getDisplacementXAsString()
	 * @see #setDisplacementXAsString(String)
	 * @generated
	 */
	boolean isSetDisplacementXAsString();

	/**
	 * Returns the value of the '<em><b>Displacement Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Displacement Y</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Displacement Y</em>' attribute.
	 * @see #isSetDisplacementY()
	 * @see #unsetDisplacementY()
	 * @see #setDisplacementY(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcStructuralLoadSingleDisplacement_DisplacementY()
	 * @model unsettable="true"
	 * @generated
	 */
	double getDisplacementY();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcStructuralLoadSingleDisplacement#getDisplacementY <em>Displacement Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Displacement Y</em>' attribute.
	 * @see #isSetDisplacementY()
	 * @see #unsetDisplacementY()
	 * @see #getDisplacementY()
	 * @generated
	 */
	void setDisplacementY(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcStructuralLoadSingleDisplacement#getDisplacementY <em>Displacement Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDisplacementY()
	 * @see #getDisplacementY()
	 * @see #setDisplacementY(double)
	 * @generated
	 */
	void unsetDisplacementY();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcStructuralLoadSingleDisplacement#getDisplacementY <em>Displacement Y</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Displacement Y</em>' attribute is set.
	 * @see #unsetDisplacementY()
	 * @see #getDisplacementY()
	 * @see #setDisplacementY(double)
	 * @generated
	 */
	boolean isSetDisplacementY();

	/**
	 * Returns the value of the '<em><b>Displacement YAs String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Displacement YAs String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Displacement YAs String</em>' attribute.
	 * @see #isSetDisplacementYAsString()
	 * @see #unsetDisplacementYAsString()
	 * @see #setDisplacementYAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcStructuralLoadSingleDisplacement_DisplacementYAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getDisplacementYAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcStructuralLoadSingleDisplacement#getDisplacementYAsString <em>Displacement YAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Displacement YAs String</em>' attribute.
	 * @see #isSetDisplacementYAsString()
	 * @see #unsetDisplacementYAsString()
	 * @see #getDisplacementYAsString()
	 * @generated
	 */
	void setDisplacementYAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcStructuralLoadSingleDisplacement#getDisplacementYAsString <em>Displacement YAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDisplacementYAsString()
	 * @see #getDisplacementYAsString()
	 * @see #setDisplacementYAsString(String)
	 * @generated
	 */
	void unsetDisplacementYAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcStructuralLoadSingleDisplacement#getDisplacementYAsString <em>Displacement YAs String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Displacement YAs String</em>' attribute is set.
	 * @see #unsetDisplacementYAsString()
	 * @see #getDisplacementYAsString()
	 * @see #setDisplacementYAsString(String)
	 * @generated
	 */
	boolean isSetDisplacementYAsString();

	/**
	 * Returns the value of the '<em><b>Displacement Z</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Displacement Z</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Displacement Z</em>' attribute.
	 * @see #isSetDisplacementZ()
	 * @see #unsetDisplacementZ()
	 * @see #setDisplacementZ(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcStructuralLoadSingleDisplacement_DisplacementZ()
	 * @model unsettable="true"
	 * @generated
	 */
	double getDisplacementZ();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcStructuralLoadSingleDisplacement#getDisplacementZ <em>Displacement Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Displacement Z</em>' attribute.
	 * @see #isSetDisplacementZ()
	 * @see #unsetDisplacementZ()
	 * @see #getDisplacementZ()
	 * @generated
	 */
	void setDisplacementZ(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcStructuralLoadSingleDisplacement#getDisplacementZ <em>Displacement Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDisplacementZ()
	 * @see #getDisplacementZ()
	 * @see #setDisplacementZ(double)
	 * @generated
	 */
	void unsetDisplacementZ();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcStructuralLoadSingleDisplacement#getDisplacementZ <em>Displacement Z</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Displacement Z</em>' attribute is set.
	 * @see #unsetDisplacementZ()
	 * @see #getDisplacementZ()
	 * @see #setDisplacementZ(double)
	 * @generated
	 */
	boolean isSetDisplacementZ();

	/**
	 * Returns the value of the '<em><b>Displacement ZAs String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Displacement ZAs String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Displacement ZAs String</em>' attribute.
	 * @see #isSetDisplacementZAsString()
	 * @see #unsetDisplacementZAsString()
	 * @see #setDisplacementZAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcStructuralLoadSingleDisplacement_DisplacementZAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getDisplacementZAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcStructuralLoadSingleDisplacement#getDisplacementZAsString <em>Displacement ZAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Displacement ZAs String</em>' attribute.
	 * @see #isSetDisplacementZAsString()
	 * @see #unsetDisplacementZAsString()
	 * @see #getDisplacementZAsString()
	 * @generated
	 */
	void setDisplacementZAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcStructuralLoadSingleDisplacement#getDisplacementZAsString <em>Displacement ZAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDisplacementZAsString()
	 * @see #getDisplacementZAsString()
	 * @see #setDisplacementZAsString(String)
	 * @generated
	 */
	void unsetDisplacementZAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcStructuralLoadSingleDisplacement#getDisplacementZAsString <em>Displacement ZAs String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Displacement ZAs String</em>' attribute is set.
	 * @see #unsetDisplacementZAsString()
	 * @see #getDisplacementZAsString()
	 * @see #setDisplacementZAsString(String)
	 * @generated
	 */
	boolean isSetDisplacementZAsString();

	/**
	 * Returns the value of the '<em><b>Rotational Displacement RX</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rotational Displacement RX</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rotational Displacement RX</em>' attribute.
	 * @see #isSetRotationalDisplacementRX()
	 * @see #unsetRotationalDisplacementRX()
	 * @see #setRotationalDisplacementRX(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRX()
	 * @model unsettable="true"
	 * @generated
	 */
	double getRotationalDisplacementRX();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcStructuralLoadSingleDisplacement#getRotationalDisplacementRX <em>Rotational Displacement RX</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rotational Displacement RX</em>' attribute.
	 * @see #isSetRotationalDisplacementRX()
	 * @see #unsetRotationalDisplacementRX()
	 * @see #getRotationalDisplacementRX()
	 * @generated
	 */
	void setRotationalDisplacementRX(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcStructuralLoadSingleDisplacement#getRotationalDisplacementRX <em>Rotational Displacement RX</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRotationalDisplacementRX()
	 * @see #getRotationalDisplacementRX()
	 * @see #setRotationalDisplacementRX(double)
	 * @generated
	 */
	void unsetRotationalDisplacementRX();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcStructuralLoadSingleDisplacement#getRotationalDisplacementRX <em>Rotational Displacement RX</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Rotational Displacement RX</em>' attribute is set.
	 * @see #unsetRotationalDisplacementRX()
	 * @see #getRotationalDisplacementRX()
	 * @see #setRotationalDisplacementRX(double)
	 * @generated
	 */
	boolean isSetRotationalDisplacementRX();

	/**
	 * Returns the value of the '<em><b>Rotational Displacement RX As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rotational Displacement RX As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rotational Displacement RX As String</em>' attribute.
	 * @see #isSetRotationalDisplacementRXAsString()
	 * @see #unsetRotationalDisplacementRXAsString()
	 * @see #setRotationalDisplacementRXAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRXAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getRotationalDisplacementRXAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcStructuralLoadSingleDisplacement#getRotationalDisplacementRXAsString <em>Rotational Displacement RX As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rotational Displacement RX As String</em>' attribute.
	 * @see #isSetRotationalDisplacementRXAsString()
	 * @see #unsetRotationalDisplacementRXAsString()
	 * @see #getRotationalDisplacementRXAsString()
	 * @generated
	 */
	void setRotationalDisplacementRXAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcStructuralLoadSingleDisplacement#getRotationalDisplacementRXAsString <em>Rotational Displacement RX As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRotationalDisplacementRXAsString()
	 * @see #getRotationalDisplacementRXAsString()
	 * @see #setRotationalDisplacementRXAsString(String)
	 * @generated
	 */
	void unsetRotationalDisplacementRXAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcStructuralLoadSingleDisplacement#getRotationalDisplacementRXAsString <em>Rotational Displacement RX As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Rotational Displacement RX As String</em>' attribute is set.
	 * @see #unsetRotationalDisplacementRXAsString()
	 * @see #getRotationalDisplacementRXAsString()
	 * @see #setRotationalDisplacementRXAsString(String)
	 * @generated
	 */
	boolean isSetRotationalDisplacementRXAsString();

	/**
	 * Returns the value of the '<em><b>Rotational Displacement RY</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rotational Displacement RY</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rotational Displacement RY</em>' attribute.
	 * @see #isSetRotationalDisplacementRY()
	 * @see #unsetRotationalDisplacementRY()
	 * @see #setRotationalDisplacementRY(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRY()
	 * @model unsettable="true"
	 * @generated
	 */
	double getRotationalDisplacementRY();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcStructuralLoadSingleDisplacement#getRotationalDisplacementRY <em>Rotational Displacement RY</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rotational Displacement RY</em>' attribute.
	 * @see #isSetRotationalDisplacementRY()
	 * @see #unsetRotationalDisplacementRY()
	 * @see #getRotationalDisplacementRY()
	 * @generated
	 */
	void setRotationalDisplacementRY(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcStructuralLoadSingleDisplacement#getRotationalDisplacementRY <em>Rotational Displacement RY</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRotationalDisplacementRY()
	 * @see #getRotationalDisplacementRY()
	 * @see #setRotationalDisplacementRY(double)
	 * @generated
	 */
	void unsetRotationalDisplacementRY();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcStructuralLoadSingleDisplacement#getRotationalDisplacementRY <em>Rotational Displacement RY</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Rotational Displacement RY</em>' attribute is set.
	 * @see #unsetRotationalDisplacementRY()
	 * @see #getRotationalDisplacementRY()
	 * @see #setRotationalDisplacementRY(double)
	 * @generated
	 */
	boolean isSetRotationalDisplacementRY();

	/**
	 * Returns the value of the '<em><b>Rotational Displacement RY As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rotational Displacement RY As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rotational Displacement RY As String</em>' attribute.
	 * @see #isSetRotationalDisplacementRYAsString()
	 * @see #unsetRotationalDisplacementRYAsString()
	 * @see #setRotationalDisplacementRYAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRYAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getRotationalDisplacementRYAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcStructuralLoadSingleDisplacement#getRotationalDisplacementRYAsString <em>Rotational Displacement RY As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rotational Displacement RY As String</em>' attribute.
	 * @see #isSetRotationalDisplacementRYAsString()
	 * @see #unsetRotationalDisplacementRYAsString()
	 * @see #getRotationalDisplacementRYAsString()
	 * @generated
	 */
	void setRotationalDisplacementRYAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcStructuralLoadSingleDisplacement#getRotationalDisplacementRYAsString <em>Rotational Displacement RY As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRotationalDisplacementRYAsString()
	 * @see #getRotationalDisplacementRYAsString()
	 * @see #setRotationalDisplacementRYAsString(String)
	 * @generated
	 */
	void unsetRotationalDisplacementRYAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcStructuralLoadSingleDisplacement#getRotationalDisplacementRYAsString <em>Rotational Displacement RY As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Rotational Displacement RY As String</em>' attribute is set.
	 * @see #unsetRotationalDisplacementRYAsString()
	 * @see #getRotationalDisplacementRYAsString()
	 * @see #setRotationalDisplacementRYAsString(String)
	 * @generated
	 */
	boolean isSetRotationalDisplacementRYAsString();

	/**
	 * Returns the value of the '<em><b>Rotational Displacement RZ</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rotational Displacement RZ</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rotational Displacement RZ</em>' attribute.
	 * @see #isSetRotationalDisplacementRZ()
	 * @see #unsetRotationalDisplacementRZ()
	 * @see #setRotationalDisplacementRZ(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRZ()
	 * @model unsettable="true"
	 * @generated
	 */
	double getRotationalDisplacementRZ();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcStructuralLoadSingleDisplacement#getRotationalDisplacementRZ <em>Rotational Displacement RZ</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rotational Displacement RZ</em>' attribute.
	 * @see #isSetRotationalDisplacementRZ()
	 * @see #unsetRotationalDisplacementRZ()
	 * @see #getRotationalDisplacementRZ()
	 * @generated
	 */
	void setRotationalDisplacementRZ(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcStructuralLoadSingleDisplacement#getRotationalDisplacementRZ <em>Rotational Displacement RZ</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRotationalDisplacementRZ()
	 * @see #getRotationalDisplacementRZ()
	 * @see #setRotationalDisplacementRZ(double)
	 * @generated
	 */
	void unsetRotationalDisplacementRZ();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcStructuralLoadSingleDisplacement#getRotationalDisplacementRZ <em>Rotational Displacement RZ</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Rotational Displacement RZ</em>' attribute is set.
	 * @see #unsetRotationalDisplacementRZ()
	 * @see #getRotationalDisplacementRZ()
	 * @see #setRotationalDisplacementRZ(double)
	 * @generated
	 */
	boolean isSetRotationalDisplacementRZ();

	/**
	 * Returns the value of the '<em><b>Rotational Displacement RZ As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rotational Displacement RZ As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rotational Displacement RZ As String</em>' attribute.
	 * @see #isSetRotationalDisplacementRZAsString()
	 * @see #unsetRotationalDisplacementRZAsString()
	 * @see #setRotationalDisplacementRZAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRZAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getRotationalDisplacementRZAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcStructuralLoadSingleDisplacement#getRotationalDisplacementRZAsString <em>Rotational Displacement RZ As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rotational Displacement RZ As String</em>' attribute.
	 * @see #isSetRotationalDisplacementRZAsString()
	 * @see #unsetRotationalDisplacementRZAsString()
	 * @see #getRotationalDisplacementRZAsString()
	 * @generated
	 */
	void setRotationalDisplacementRZAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcStructuralLoadSingleDisplacement#getRotationalDisplacementRZAsString <em>Rotational Displacement RZ As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRotationalDisplacementRZAsString()
	 * @see #getRotationalDisplacementRZAsString()
	 * @see #setRotationalDisplacementRZAsString(String)
	 * @generated
	 */
	void unsetRotationalDisplacementRZAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcStructuralLoadSingleDisplacement#getRotationalDisplacementRZAsString <em>Rotational Displacement RZ As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Rotational Displacement RZ As String</em>' attribute is set.
	 * @see #unsetRotationalDisplacementRZAsString()
	 * @see #getRotationalDisplacementRZAsString()
	 * @see #setRotationalDisplacementRZAsString(String)
	 * @generated
	 */
	boolean isSetRotationalDisplacementRZAsString();

} // IfcStructuralLoadSingleDisplacement
