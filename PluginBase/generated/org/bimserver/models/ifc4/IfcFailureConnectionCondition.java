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

public interface IfcFailureConnectionCondition extends IfcStructuralConnectionCondition {
	/**
	 * Returns the value of the '<em><b>Tension Failure X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tension Failure X</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tension Failure X</em>' attribute.
	 * @see #isSetTensionFailureX()
	 * @see #unsetTensionFailureX()
	 * @see #setTensionFailureX(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcFailureConnectionCondition_TensionFailureX()
	 * @model unsettable="true"
	 * @generated
	 */
	double getTensionFailureX();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcFailureConnectionCondition#getTensionFailureX <em>Tension Failure X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tension Failure X</em>' attribute.
	 * @see #isSetTensionFailureX()
	 * @see #unsetTensionFailureX()
	 * @see #getTensionFailureX()
	 * @generated
	 */
	void setTensionFailureX(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcFailureConnectionCondition#getTensionFailureX <em>Tension Failure X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTensionFailureX()
	 * @see #getTensionFailureX()
	 * @see #setTensionFailureX(double)
	 * @generated
	 */
	void unsetTensionFailureX();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcFailureConnectionCondition#getTensionFailureX <em>Tension Failure X</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Tension Failure X</em>' attribute is set.
	 * @see #unsetTensionFailureX()
	 * @see #getTensionFailureX()
	 * @see #setTensionFailureX(double)
	 * @generated
	 */
	boolean isSetTensionFailureX();

	/**
	 * Returns the value of the '<em><b>Tension Failure XAs String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tension Failure XAs String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tension Failure XAs String</em>' attribute.
	 * @see #isSetTensionFailureXAsString()
	 * @see #unsetTensionFailureXAsString()
	 * @see #setTensionFailureXAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcFailureConnectionCondition_TensionFailureXAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getTensionFailureXAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcFailureConnectionCondition#getTensionFailureXAsString <em>Tension Failure XAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tension Failure XAs String</em>' attribute.
	 * @see #isSetTensionFailureXAsString()
	 * @see #unsetTensionFailureXAsString()
	 * @see #getTensionFailureXAsString()
	 * @generated
	 */
	void setTensionFailureXAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcFailureConnectionCondition#getTensionFailureXAsString <em>Tension Failure XAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTensionFailureXAsString()
	 * @see #getTensionFailureXAsString()
	 * @see #setTensionFailureXAsString(String)
	 * @generated
	 */
	void unsetTensionFailureXAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcFailureConnectionCondition#getTensionFailureXAsString <em>Tension Failure XAs String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Tension Failure XAs String</em>' attribute is set.
	 * @see #unsetTensionFailureXAsString()
	 * @see #getTensionFailureXAsString()
	 * @see #setTensionFailureXAsString(String)
	 * @generated
	 */
	boolean isSetTensionFailureXAsString();

	/**
	 * Returns the value of the '<em><b>Tension Failure Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tension Failure Y</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tension Failure Y</em>' attribute.
	 * @see #isSetTensionFailureY()
	 * @see #unsetTensionFailureY()
	 * @see #setTensionFailureY(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcFailureConnectionCondition_TensionFailureY()
	 * @model unsettable="true"
	 * @generated
	 */
	double getTensionFailureY();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcFailureConnectionCondition#getTensionFailureY <em>Tension Failure Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tension Failure Y</em>' attribute.
	 * @see #isSetTensionFailureY()
	 * @see #unsetTensionFailureY()
	 * @see #getTensionFailureY()
	 * @generated
	 */
	void setTensionFailureY(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcFailureConnectionCondition#getTensionFailureY <em>Tension Failure Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTensionFailureY()
	 * @see #getTensionFailureY()
	 * @see #setTensionFailureY(double)
	 * @generated
	 */
	void unsetTensionFailureY();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcFailureConnectionCondition#getTensionFailureY <em>Tension Failure Y</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Tension Failure Y</em>' attribute is set.
	 * @see #unsetTensionFailureY()
	 * @see #getTensionFailureY()
	 * @see #setTensionFailureY(double)
	 * @generated
	 */
	boolean isSetTensionFailureY();

	/**
	 * Returns the value of the '<em><b>Tension Failure YAs String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tension Failure YAs String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tension Failure YAs String</em>' attribute.
	 * @see #isSetTensionFailureYAsString()
	 * @see #unsetTensionFailureYAsString()
	 * @see #setTensionFailureYAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcFailureConnectionCondition_TensionFailureYAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getTensionFailureYAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcFailureConnectionCondition#getTensionFailureYAsString <em>Tension Failure YAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tension Failure YAs String</em>' attribute.
	 * @see #isSetTensionFailureYAsString()
	 * @see #unsetTensionFailureYAsString()
	 * @see #getTensionFailureYAsString()
	 * @generated
	 */
	void setTensionFailureYAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcFailureConnectionCondition#getTensionFailureYAsString <em>Tension Failure YAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTensionFailureYAsString()
	 * @see #getTensionFailureYAsString()
	 * @see #setTensionFailureYAsString(String)
	 * @generated
	 */
	void unsetTensionFailureYAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcFailureConnectionCondition#getTensionFailureYAsString <em>Tension Failure YAs String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Tension Failure YAs String</em>' attribute is set.
	 * @see #unsetTensionFailureYAsString()
	 * @see #getTensionFailureYAsString()
	 * @see #setTensionFailureYAsString(String)
	 * @generated
	 */
	boolean isSetTensionFailureYAsString();

	/**
	 * Returns the value of the '<em><b>Tension Failure Z</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tension Failure Z</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tension Failure Z</em>' attribute.
	 * @see #isSetTensionFailureZ()
	 * @see #unsetTensionFailureZ()
	 * @see #setTensionFailureZ(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcFailureConnectionCondition_TensionFailureZ()
	 * @model unsettable="true"
	 * @generated
	 */
	double getTensionFailureZ();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcFailureConnectionCondition#getTensionFailureZ <em>Tension Failure Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tension Failure Z</em>' attribute.
	 * @see #isSetTensionFailureZ()
	 * @see #unsetTensionFailureZ()
	 * @see #getTensionFailureZ()
	 * @generated
	 */
	void setTensionFailureZ(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcFailureConnectionCondition#getTensionFailureZ <em>Tension Failure Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTensionFailureZ()
	 * @see #getTensionFailureZ()
	 * @see #setTensionFailureZ(double)
	 * @generated
	 */
	void unsetTensionFailureZ();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcFailureConnectionCondition#getTensionFailureZ <em>Tension Failure Z</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Tension Failure Z</em>' attribute is set.
	 * @see #unsetTensionFailureZ()
	 * @see #getTensionFailureZ()
	 * @see #setTensionFailureZ(double)
	 * @generated
	 */
	boolean isSetTensionFailureZ();

	/**
	 * Returns the value of the '<em><b>Tension Failure ZAs String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tension Failure ZAs String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tension Failure ZAs String</em>' attribute.
	 * @see #isSetTensionFailureZAsString()
	 * @see #unsetTensionFailureZAsString()
	 * @see #setTensionFailureZAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcFailureConnectionCondition_TensionFailureZAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getTensionFailureZAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcFailureConnectionCondition#getTensionFailureZAsString <em>Tension Failure ZAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tension Failure ZAs String</em>' attribute.
	 * @see #isSetTensionFailureZAsString()
	 * @see #unsetTensionFailureZAsString()
	 * @see #getTensionFailureZAsString()
	 * @generated
	 */
	void setTensionFailureZAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcFailureConnectionCondition#getTensionFailureZAsString <em>Tension Failure ZAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTensionFailureZAsString()
	 * @see #getTensionFailureZAsString()
	 * @see #setTensionFailureZAsString(String)
	 * @generated
	 */
	void unsetTensionFailureZAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcFailureConnectionCondition#getTensionFailureZAsString <em>Tension Failure ZAs String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Tension Failure ZAs String</em>' attribute is set.
	 * @see #unsetTensionFailureZAsString()
	 * @see #getTensionFailureZAsString()
	 * @see #setTensionFailureZAsString(String)
	 * @generated
	 */
	boolean isSetTensionFailureZAsString();

	/**
	 * Returns the value of the '<em><b>Compression Failure X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compression Failure X</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compression Failure X</em>' attribute.
	 * @see #isSetCompressionFailureX()
	 * @see #unsetCompressionFailureX()
	 * @see #setCompressionFailureX(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcFailureConnectionCondition_CompressionFailureX()
	 * @model unsettable="true"
	 * @generated
	 */
	double getCompressionFailureX();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcFailureConnectionCondition#getCompressionFailureX <em>Compression Failure X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Compression Failure X</em>' attribute.
	 * @see #isSetCompressionFailureX()
	 * @see #unsetCompressionFailureX()
	 * @see #getCompressionFailureX()
	 * @generated
	 */
	void setCompressionFailureX(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcFailureConnectionCondition#getCompressionFailureX <em>Compression Failure X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCompressionFailureX()
	 * @see #getCompressionFailureX()
	 * @see #setCompressionFailureX(double)
	 * @generated
	 */
	void unsetCompressionFailureX();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcFailureConnectionCondition#getCompressionFailureX <em>Compression Failure X</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Compression Failure X</em>' attribute is set.
	 * @see #unsetCompressionFailureX()
	 * @see #getCompressionFailureX()
	 * @see #setCompressionFailureX(double)
	 * @generated
	 */
	boolean isSetCompressionFailureX();

	/**
	 * Returns the value of the '<em><b>Compression Failure XAs String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compression Failure XAs String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compression Failure XAs String</em>' attribute.
	 * @see #isSetCompressionFailureXAsString()
	 * @see #unsetCompressionFailureXAsString()
	 * @see #setCompressionFailureXAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcFailureConnectionCondition_CompressionFailureXAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getCompressionFailureXAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcFailureConnectionCondition#getCompressionFailureXAsString <em>Compression Failure XAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Compression Failure XAs String</em>' attribute.
	 * @see #isSetCompressionFailureXAsString()
	 * @see #unsetCompressionFailureXAsString()
	 * @see #getCompressionFailureXAsString()
	 * @generated
	 */
	void setCompressionFailureXAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcFailureConnectionCondition#getCompressionFailureXAsString <em>Compression Failure XAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCompressionFailureXAsString()
	 * @see #getCompressionFailureXAsString()
	 * @see #setCompressionFailureXAsString(String)
	 * @generated
	 */
	void unsetCompressionFailureXAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcFailureConnectionCondition#getCompressionFailureXAsString <em>Compression Failure XAs String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Compression Failure XAs String</em>' attribute is set.
	 * @see #unsetCompressionFailureXAsString()
	 * @see #getCompressionFailureXAsString()
	 * @see #setCompressionFailureXAsString(String)
	 * @generated
	 */
	boolean isSetCompressionFailureXAsString();

	/**
	 * Returns the value of the '<em><b>Compression Failure Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compression Failure Y</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compression Failure Y</em>' attribute.
	 * @see #isSetCompressionFailureY()
	 * @see #unsetCompressionFailureY()
	 * @see #setCompressionFailureY(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcFailureConnectionCondition_CompressionFailureY()
	 * @model unsettable="true"
	 * @generated
	 */
	double getCompressionFailureY();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcFailureConnectionCondition#getCompressionFailureY <em>Compression Failure Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Compression Failure Y</em>' attribute.
	 * @see #isSetCompressionFailureY()
	 * @see #unsetCompressionFailureY()
	 * @see #getCompressionFailureY()
	 * @generated
	 */
	void setCompressionFailureY(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcFailureConnectionCondition#getCompressionFailureY <em>Compression Failure Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCompressionFailureY()
	 * @see #getCompressionFailureY()
	 * @see #setCompressionFailureY(double)
	 * @generated
	 */
	void unsetCompressionFailureY();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcFailureConnectionCondition#getCompressionFailureY <em>Compression Failure Y</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Compression Failure Y</em>' attribute is set.
	 * @see #unsetCompressionFailureY()
	 * @see #getCompressionFailureY()
	 * @see #setCompressionFailureY(double)
	 * @generated
	 */
	boolean isSetCompressionFailureY();

	/**
	 * Returns the value of the '<em><b>Compression Failure YAs String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compression Failure YAs String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compression Failure YAs String</em>' attribute.
	 * @see #isSetCompressionFailureYAsString()
	 * @see #unsetCompressionFailureYAsString()
	 * @see #setCompressionFailureYAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcFailureConnectionCondition_CompressionFailureYAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getCompressionFailureYAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcFailureConnectionCondition#getCompressionFailureYAsString <em>Compression Failure YAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Compression Failure YAs String</em>' attribute.
	 * @see #isSetCompressionFailureYAsString()
	 * @see #unsetCompressionFailureYAsString()
	 * @see #getCompressionFailureYAsString()
	 * @generated
	 */
	void setCompressionFailureYAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcFailureConnectionCondition#getCompressionFailureYAsString <em>Compression Failure YAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCompressionFailureYAsString()
	 * @see #getCompressionFailureYAsString()
	 * @see #setCompressionFailureYAsString(String)
	 * @generated
	 */
	void unsetCompressionFailureYAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcFailureConnectionCondition#getCompressionFailureYAsString <em>Compression Failure YAs String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Compression Failure YAs String</em>' attribute is set.
	 * @see #unsetCompressionFailureYAsString()
	 * @see #getCompressionFailureYAsString()
	 * @see #setCompressionFailureYAsString(String)
	 * @generated
	 */
	boolean isSetCompressionFailureYAsString();

	/**
	 * Returns the value of the '<em><b>Compression Failure Z</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compression Failure Z</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compression Failure Z</em>' attribute.
	 * @see #isSetCompressionFailureZ()
	 * @see #unsetCompressionFailureZ()
	 * @see #setCompressionFailureZ(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcFailureConnectionCondition_CompressionFailureZ()
	 * @model unsettable="true"
	 * @generated
	 */
	double getCompressionFailureZ();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcFailureConnectionCondition#getCompressionFailureZ <em>Compression Failure Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Compression Failure Z</em>' attribute.
	 * @see #isSetCompressionFailureZ()
	 * @see #unsetCompressionFailureZ()
	 * @see #getCompressionFailureZ()
	 * @generated
	 */
	void setCompressionFailureZ(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcFailureConnectionCondition#getCompressionFailureZ <em>Compression Failure Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCompressionFailureZ()
	 * @see #getCompressionFailureZ()
	 * @see #setCompressionFailureZ(double)
	 * @generated
	 */
	void unsetCompressionFailureZ();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcFailureConnectionCondition#getCompressionFailureZ <em>Compression Failure Z</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Compression Failure Z</em>' attribute is set.
	 * @see #unsetCompressionFailureZ()
	 * @see #getCompressionFailureZ()
	 * @see #setCompressionFailureZ(double)
	 * @generated
	 */
	boolean isSetCompressionFailureZ();

	/**
	 * Returns the value of the '<em><b>Compression Failure ZAs String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compression Failure ZAs String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compression Failure ZAs String</em>' attribute.
	 * @see #isSetCompressionFailureZAsString()
	 * @see #unsetCompressionFailureZAsString()
	 * @see #setCompressionFailureZAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcFailureConnectionCondition_CompressionFailureZAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getCompressionFailureZAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcFailureConnectionCondition#getCompressionFailureZAsString <em>Compression Failure ZAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Compression Failure ZAs String</em>' attribute.
	 * @see #isSetCompressionFailureZAsString()
	 * @see #unsetCompressionFailureZAsString()
	 * @see #getCompressionFailureZAsString()
	 * @generated
	 */
	void setCompressionFailureZAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcFailureConnectionCondition#getCompressionFailureZAsString <em>Compression Failure ZAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCompressionFailureZAsString()
	 * @see #getCompressionFailureZAsString()
	 * @see #setCompressionFailureZAsString(String)
	 * @generated
	 */
	void unsetCompressionFailureZAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcFailureConnectionCondition#getCompressionFailureZAsString <em>Compression Failure ZAs String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Compression Failure ZAs String</em>' attribute is set.
	 * @see #unsetCompressionFailureZAsString()
	 * @see #getCompressionFailureZAsString()
	 * @see #setCompressionFailureZAsString(String)
	 * @generated
	 */
	boolean isSetCompressionFailureZAsString();

} // IfcFailureConnectionCondition
