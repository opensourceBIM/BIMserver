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
package org.bimserver.models.ifc2x3tc1;

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

public interface IfcConnectionPointEccentricity extends IfcConnectionPointGeometry {
	/**
	 * Returns the value of the '<em><b>Eccentricity In X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Eccentricity In X</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Eccentricity In X</em>' attribute.
	 * @see #isSetEccentricityInX()
	 * @see #unsetEccentricityInX()
	 * @see #setEccentricityInX(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcConnectionPointEccentricity_EccentricityInX()
	 * @model unsettable="true"
	 * @generated
	 */
	double getEccentricityInX();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcConnectionPointEccentricity#getEccentricityInX <em>Eccentricity In X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Eccentricity In X</em>' attribute.
	 * @see #isSetEccentricityInX()
	 * @see #unsetEccentricityInX()
	 * @see #getEccentricityInX()
	 * @generated
	 */
	void setEccentricityInX(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcConnectionPointEccentricity#getEccentricityInX <em>Eccentricity In X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetEccentricityInX()
	 * @see #getEccentricityInX()
	 * @see #setEccentricityInX(double)
	 * @generated
	 */
	void unsetEccentricityInX();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcConnectionPointEccentricity#getEccentricityInX <em>Eccentricity In X</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Eccentricity In X</em>' attribute is set.
	 * @see #unsetEccentricityInX()
	 * @see #getEccentricityInX()
	 * @see #setEccentricityInX(double)
	 * @generated
	 */
	boolean isSetEccentricityInX();

	/**
	 * Returns the value of the '<em><b>Eccentricity In XAs String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Eccentricity In XAs String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Eccentricity In XAs String</em>' attribute.
	 * @see #isSetEccentricityInXAsString()
	 * @see #unsetEccentricityInXAsString()
	 * @see #setEccentricityInXAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcConnectionPointEccentricity_EccentricityInXAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getEccentricityInXAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcConnectionPointEccentricity#getEccentricityInXAsString <em>Eccentricity In XAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Eccentricity In XAs String</em>' attribute.
	 * @see #isSetEccentricityInXAsString()
	 * @see #unsetEccentricityInXAsString()
	 * @see #getEccentricityInXAsString()
	 * @generated
	 */
	void setEccentricityInXAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcConnectionPointEccentricity#getEccentricityInXAsString <em>Eccentricity In XAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetEccentricityInXAsString()
	 * @see #getEccentricityInXAsString()
	 * @see #setEccentricityInXAsString(String)
	 * @generated
	 */
	void unsetEccentricityInXAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcConnectionPointEccentricity#getEccentricityInXAsString <em>Eccentricity In XAs String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Eccentricity In XAs String</em>' attribute is set.
	 * @see #unsetEccentricityInXAsString()
	 * @see #getEccentricityInXAsString()
	 * @see #setEccentricityInXAsString(String)
	 * @generated
	 */
	boolean isSetEccentricityInXAsString();

	/**
	 * Returns the value of the '<em><b>Eccentricity In Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Eccentricity In Y</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Eccentricity In Y</em>' attribute.
	 * @see #isSetEccentricityInY()
	 * @see #unsetEccentricityInY()
	 * @see #setEccentricityInY(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcConnectionPointEccentricity_EccentricityInY()
	 * @model unsettable="true"
	 * @generated
	 */
	double getEccentricityInY();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcConnectionPointEccentricity#getEccentricityInY <em>Eccentricity In Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Eccentricity In Y</em>' attribute.
	 * @see #isSetEccentricityInY()
	 * @see #unsetEccentricityInY()
	 * @see #getEccentricityInY()
	 * @generated
	 */
	void setEccentricityInY(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcConnectionPointEccentricity#getEccentricityInY <em>Eccentricity In Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetEccentricityInY()
	 * @see #getEccentricityInY()
	 * @see #setEccentricityInY(double)
	 * @generated
	 */
	void unsetEccentricityInY();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcConnectionPointEccentricity#getEccentricityInY <em>Eccentricity In Y</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Eccentricity In Y</em>' attribute is set.
	 * @see #unsetEccentricityInY()
	 * @see #getEccentricityInY()
	 * @see #setEccentricityInY(double)
	 * @generated
	 */
	boolean isSetEccentricityInY();

	/**
	 * Returns the value of the '<em><b>Eccentricity In YAs String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Eccentricity In YAs String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Eccentricity In YAs String</em>' attribute.
	 * @see #isSetEccentricityInYAsString()
	 * @see #unsetEccentricityInYAsString()
	 * @see #setEccentricityInYAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcConnectionPointEccentricity_EccentricityInYAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getEccentricityInYAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcConnectionPointEccentricity#getEccentricityInYAsString <em>Eccentricity In YAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Eccentricity In YAs String</em>' attribute.
	 * @see #isSetEccentricityInYAsString()
	 * @see #unsetEccentricityInYAsString()
	 * @see #getEccentricityInYAsString()
	 * @generated
	 */
	void setEccentricityInYAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcConnectionPointEccentricity#getEccentricityInYAsString <em>Eccentricity In YAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetEccentricityInYAsString()
	 * @see #getEccentricityInYAsString()
	 * @see #setEccentricityInYAsString(String)
	 * @generated
	 */
	void unsetEccentricityInYAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcConnectionPointEccentricity#getEccentricityInYAsString <em>Eccentricity In YAs String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Eccentricity In YAs String</em>' attribute is set.
	 * @see #unsetEccentricityInYAsString()
	 * @see #getEccentricityInYAsString()
	 * @see #setEccentricityInYAsString(String)
	 * @generated
	 */
	boolean isSetEccentricityInYAsString();

	/**
	 * Returns the value of the '<em><b>Eccentricity In Z</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Eccentricity In Z</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Eccentricity In Z</em>' attribute.
	 * @see #isSetEccentricityInZ()
	 * @see #unsetEccentricityInZ()
	 * @see #setEccentricityInZ(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcConnectionPointEccentricity_EccentricityInZ()
	 * @model unsettable="true"
	 * @generated
	 */
	double getEccentricityInZ();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcConnectionPointEccentricity#getEccentricityInZ <em>Eccentricity In Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Eccentricity In Z</em>' attribute.
	 * @see #isSetEccentricityInZ()
	 * @see #unsetEccentricityInZ()
	 * @see #getEccentricityInZ()
	 * @generated
	 */
	void setEccentricityInZ(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcConnectionPointEccentricity#getEccentricityInZ <em>Eccentricity In Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetEccentricityInZ()
	 * @see #getEccentricityInZ()
	 * @see #setEccentricityInZ(double)
	 * @generated
	 */
	void unsetEccentricityInZ();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcConnectionPointEccentricity#getEccentricityInZ <em>Eccentricity In Z</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Eccentricity In Z</em>' attribute is set.
	 * @see #unsetEccentricityInZ()
	 * @see #getEccentricityInZ()
	 * @see #setEccentricityInZ(double)
	 * @generated
	 */
	boolean isSetEccentricityInZ();

	/**
	 * Returns the value of the '<em><b>Eccentricity In ZAs String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Eccentricity In ZAs String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Eccentricity In ZAs String</em>' attribute.
	 * @see #isSetEccentricityInZAsString()
	 * @see #unsetEccentricityInZAsString()
	 * @see #setEccentricityInZAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcConnectionPointEccentricity_EccentricityInZAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getEccentricityInZAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcConnectionPointEccentricity#getEccentricityInZAsString <em>Eccentricity In ZAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Eccentricity In ZAs String</em>' attribute.
	 * @see #isSetEccentricityInZAsString()
	 * @see #unsetEccentricityInZAsString()
	 * @see #getEccentricityInZAsString()
	 * @generated
	 */
	void setEccentricityInZAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcConnectionPointEccentricity#getEccentricityInZAsString <em>Eccentricity In ZAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetEccentricityInZAsString()
	 * @see #getEccentricityInZAsString()
	 * @see #setEccentricityInZAsString(String)
	 * @generated
	 */
	void unsetEccentricityInZAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcConnectionPointEccentricity#getEccentricityInZAsString <em>Eccentricity In ZAs String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Eccentricity In ZAs String</em>' attribute is set.
	 * @see #unsetEccentricityInZAsString()
	 * @see #getEccentricityInZAsString()
	 * @see #setEccentricityInZAsString(String)
	 * @generated
	 */
	boolean isSetEccentricityInZAsString();

} // IfcConnectionPointEccentricity
