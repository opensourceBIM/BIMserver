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
 * A representation of the model object '<em><b>Ifc Structural Load Single Displacement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleDisplacement#getDisplacementX <em>Displacement X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleDisplacement#getDisplacementXAsString <em>Displacement XAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleDisplacement#getDisplacementY <em>Displacement Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleDisplacement#getDisplacementYAsString <em>Displacement YAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleDisplacement#getDisplacementZ <em>Displacement Z</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleDisplacement#getDisplacementZAsString <em>Displacement ZAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleDisplacement#getRotationalDisplacementRX <em>Rotational Displacement RX</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleDisplacement#getRotationalDisplacementRXAsString <em>Rotational Displacement RX As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleDisplacement#getRotationalDisplacementRY <em>Rotational Displacement RY</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleDisplacement#getRotationalDisplacementRYAsString <em>Rotational Displacement RY As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleDisplacement#getRotationalDisplacementRZ <em>Rotational Displacement RZ</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleDisplacement#getRotationalDisplacementRZAsString <em>Rotational Displacement RZ As String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralLoadSingleDisplacement()
 * @model
 * @generated
 */
public interface IfcStructuralLoadSingleDisplacement extends IfcStructuralLoadStatic
{
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
	 * @see #setDisplacementX(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralLoadSingleDisplacement_DisplacementX()
	 * @model unsettable="true"
	 * @generated
	 */
	float getDisplacementX();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleDisplacement#getDisplacementX <em>Displacement X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Displacement X</em>' attribute.
	 * @see #isSetDisplacementX()
	 * @see #unsetDisplacementX()
	 * @see #getDisplacementX()
	 * @generated
	 */
	void setDisplacementX(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleDisplacement#getDisplacementX <em>Displacement X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDisplacementX()
	 * @see #getDisplacementX()
	 * @see #setDisplacementX(float)
	 * @generated
	 */
	void unsetDisplacementX();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleDisplacement#getDisplacementX <em>Displacement X</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Displacement X</em>' attribute is set.
	 * @see #unsetDisplacementX()
	 * @see #getDisplacementX()
	 * @see #setDisplacementX(float)
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralLoadSingleDisplacement_DisplacementXAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getDisplacementXAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleDisplacement#getDisplacementXAsString <em>Displacement XAs String</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleDisplacement#getDisplacementXAsString <em>Displacement XAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDisplacementXAsString()
	 * @see #getDisplacementXAsString()
	 * @see #setDisplacementXAsString(String)
	 * @generated
	 */
	void unsetDisplacementXAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleDisplacement#getDisplacementXAsString <em>Displacement XAs String</em>}' attribute is set.
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
	 * @see #setDisplacementY(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralLoadSingleDisplacement_DisplacementY()
	 * @model unsettable="true"
	 * @generated
	 */
	float getDisplacementY();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleDisplacement#getDisplacementY <em>Displacement Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Displacement Y</em>' attribute.
	 * @see #isSetDisplacementY()
	 * @see #unsetDisplacementY()
	 * @see #getDisplacementY()
	 * @generated
	 */
	void setDisplacementY(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleDisplacement#getDisplacementY <em>Displacement Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDisplacementY()
	 * @see #getDisplacementY()
	 * @see #setDisplacementY(float)
	 * @generated
	 */
	void unsetDisplacementY();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleDisplacement#getDisplacementY <em>Displacement Y</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Displacement Y</em>' attribute is set.
	 * @see #unsetDisplacementY()
	 * @see #getDisplacementY()
	 * @see #setDisplacementY(float)
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralLoadSingleDisplacement_DisplacementYAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getDisplacementYAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleDisplacement#getDisplacementYAsString <em>Displacement YAs String</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleDisplacement#getDisplacementYAsString <em>Displacement YAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDisplacementYAsString()
	 * @see #getDisplacementYAsString()
	 * @see #setDisplacementYAsString(String)
	 * @generated
	 */
	void unsetDisplacementYAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleDisplacement#getDisplacementYAsString <em>Displacement YAs String</em>}' attribute is set.
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
	 * @see #setDisplacementZ(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralLoadSingleDisplacement_DisplacementZ()
	 * @model unsettable="true"
	 * @generated
	 */
	float getDisplacementZ();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleDisplacement#getDisplacementZ <em>Displacement Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Displacement Z</em>' attribute.
	 * @see #isSetDisplacementZ()
	 * @see #unsetDisplacementZ()
	 * @see #getDisplacementZ()
	 * @generated
	 */
	void setDisplacementZ(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleDisplacement#getDisplacementZ <em>Displacement Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDisplacementZ()
	 * @see #getDisplacementZ()
	 * @see #setDisplacementZ(float)
	 * @generated
	 */
	void unsetDisplacementZ();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleDisplacement#getDisplacementZ <em>Displacement Z</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Displacement Z</em>' attribute is set.
	 * @see #unsetDisplacementZ()
	 * @see #getDisplacementZ()
	 * @see #setDisplacementZ(float)
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralLoadSingleDisplacement_DisplacementZAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getDisplacementZAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleDisplacement#getDisplacementZAsString <em>Displacement ZAs String</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleDisplacement#getDisplacementZAsString <em>Displacement ZAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDisplacementZAsString()
	 * @see #getDisplacementZAsString()
	 * @see #setDisplacementZAsString(String)
	 * @generated
	 */
	void unsetDisplacementZAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleDisplacement#getDisplacementZAsString <em>Displacement ZAs String</em>}' attribute is set.
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
	 * @see #setRotationalDisplacementRX(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRX()
	 * @model unsettable="true"
	 * @generated
	 */
	float getRotationalDisplacementRX();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleDisplacement#getRotationalDisplacementRX <em>Rotational Displacement RX</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rotational Displacement RX</em>' attribute.
	 * @see #isSetRotationalDisplacementRX()
	 * @see #unsetRotationalDisplacementRX()
	 * @see #getRotationalDisplacementRX()
	 * @generated
	 */
	void setRotationalDisplacementRX(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleDisplacement#getRotationalDisplacementRX <em>Rotational Displacement RX</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRotationalDisplacementRX()
	 * @see #getRotationalDisplacementRX()
	 * @see #setRotationalDisplacementRX(float)
	 * @generated
	 */
	void unsetRotationalDisplacementRX();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleDisplacement#getRotationalDisplacementRX <em>Rotational Displacement RX</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Rotational Displacement RX</em>' attribute is set.
	 * @see #unsetRotationalDisplacementRX()
	 * @see #getRotationalDisplacementRX()
	 * @see #setRotationalDisplacementRX(float)
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRXAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getRotationalDisplacementRXAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleDisplacement#getRotationalDisplacementRXAsString <em>Rotational Displacement RX As String</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleDisplacement#getRotationalDisplacementRXAsString <em>Rotational Displacement RX As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRotationalDisplacementRXAsString()
	 * @see #getRotationalDisplacementRXAsString()
	 * @see #setRotationalDisplacementRXAsString(String)
	 * @generated
	 */
	void unsetRotationalDisplacementRXAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleDisplacement#getRotationalDisplacementRXAsString <em>Rotational Displacement RX As String</em>}' attribute is set.
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
	 * @see #setRotationalDisplacementRY(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRY()
	 * @model unsettable="true"
	 * @generated
	 */
	float getRotationalDisplacementRY();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleDisplacement#getRotationalDisplacementRY <em>Rotational Displacement RY</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rotational Displacement RY</em>' attribute.
	 * @see #isSetRotationalDisplacementRY()
	 * @see #unsetRotationalDisplacementRY()
	 * @see #getRotationalDisplacementRY()
	 * @generated
	 */
	void setRotationalDisplacementRY(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleDisplacement#getRotationalDisplacementRY <em>Rotational Displacement RY</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRotationalDisplacementRY()
	 * @see #getRotationalDisplacementRY()
	 * @see #setRotationalDisplacementRY(float)
	 * @generated
	 */
	void unsetRotationalDisplacementRY();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleDisplacement#getRotationalDisplacementRY <em>Rotational Displacement RY</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Rotational Displacement RY</em>' attribute is set.
	 * @see #unsetRotationalDisplacementRY()
	 * @see #getRotationalDisplacementRY()
	 * @see #setRotationalDisplacementRY(float)
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRYAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getRotationalDisplacementRYAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleDisplacement#getRotationalDisplacementRYAsString <em>Rotational Displacement RY As String</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleDisplacement#getRotationalDisplacementRYAsString <em>Rotational Displacement RY As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRotationalDisplacementRYAsString()
	 * @see #getRotationalDisplacementRYAsString()
	 * @see #setRotationalDisplacementRYAsString(String)
	 * @generated
	 */
	void unsetRotationalDisplacementRYAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleDisplacement#getRotationalDisplacementRYAsString <em>Rotational Displacement RY As String</em>}' attribute is set.
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
	 * @see #setRotationalDisplacementRZ(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRZ()
	 * @model unsettable="true"
	 * @generated
	 */
	float getRotationalDisplacementRZ();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleDisplacement#getRotationalDisplacementRZ <em>Rotational Displacement RZ</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rotational Displacement RZ</em>' attribute.
	 * @see #isSetRotationalDisplacementRZ()
	 * @see #unsetRotationalDisplacementRZ()
	 * @see #getRotationalDisplacementRZ()
	 * @generated
	 */
	void setRotationalDisplacementRZ(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleDisplacement#getRotationalDisplacementRZ <em>Rotational Displacement RZ</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRotationalDisplacementRZ()
	 * @see #getRotationalDisplacementRZ()
	 * @see #setRotationalDisplacementRZ(float)
	 * @generated
	 */
	void unsetRotationalDisplacementRZ();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleDisplacement#getRotationalDisplacementRZ <em>Rotational Displacement RZ</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Rotational Displacement RZ</em>' attribute is set.
	 * @see #unsetRotationalDisplacementRZ()
	 * @see #getRotationalDisplacementRZ()
	 * @see #setRotationalDisplacementRZ(float)
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRZAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getRotationalDisplacementRZAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleDisplacement#getRotationalDisplacementRZAsString <em>Rotational Displacement RZ As String</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleDisplacement#getRotationalDisplacementRZAsString <em>Rotational Displacement RZ As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRotationalDisplacementRZAsString()
	 * @see #getRotationalDisplacementRZAsString()
	 * @see #setRotationalDisplacementRZAsString(String)
	 * @generated
	 */
	void unsetRotationalDisplacementRZAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleDisplacement#getRotationalDisplacementRZAsString <em>Rotational Displacement RZ As String</em>}' attribute is set.
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
