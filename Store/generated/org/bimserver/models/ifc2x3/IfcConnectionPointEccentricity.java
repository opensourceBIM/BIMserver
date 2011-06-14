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
 * A representation of the model object '<em><b>Ifc Connection Point Eccentricity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcConnectionPointEccentricity#getEccentricityInX <em>Eccentricity In X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcConnectionPointEccentricity#getEccentricityInXAsString <em>Eccentricity In XAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcConnectionPointEccentricity#getEccentricityInY <em>Eccentricity In Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcConnectionPointEccentricity#getEccentricityInYAsString <em>Eccentricity In YAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcConnectionPointEccentricity#getEccentricityInZ <em>Eccentricity In Z</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcConnectionPointEccentricity#getEccentricityInZAsString <em>Eccentricity In ZAs String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcConnectionPointEccentricity()
 * @model
 * @generated
 */
public interface IfcConnectionPointEccentricity extends IfcConnectionPointGeometry
{
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
	 * @see #setEccentricityInX(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcConnectionPointEccentricity_EccentricityInX()
	 * @model unsettable="true"
	 * @generated
	 */
	float getEccentricityInX();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcConnectionPointEccentricity#getEccentricityInX <em>Eccentricity In X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Eccentricity In X</em>' attribute.
	 * @see #isSetEccentricityInX()
	 * @see #unsetEccentricityInX()
	 * @see #getEccentricityInX()
	 * @generated
	 */
	void setEccentricityInX(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcConnectionPointEccentricity#getEccentricityInX <em>Eccentricity In X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetEccentricityInX()
	 * @see #getEccentricityInX()
	 * @see #setEccentricityInX(float)
	 * @generated
	 */
	void unsetEccentricityInX();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcConnectionPointEccentricity#getEccentricityInX <em>Eccentricity In X</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Eccentricity In X</em>' attribute is set.
	 * @see #unsetEccentricityInX()
	 * @see #getEccentricityInX()
	 * @see #setEccentricityInX(float)
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcConnectionPointEccentricity_EccentricityInXAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getEccentricityInXAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcConnectionPointEccentricity#getEccentricityInXAsString <em>Eccentricity In XAs String</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcConnectionPointEccentricity#getEccentricityInXAsString <em>Eccentricity In XAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetEccentricityInXAsString()
	 * @see #getEccentricityInXAsString()
	 * @see #setEccentricityInXAsString(String)
	 * @generated
	 */
	void unsetEccentricityInXAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcConnectionPointEccentricity#getEccentricityInXAsString <em>Eccentricity In XAs String</em>}' attribute is set.
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
	 * @see #setEccentricityInY(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcConnectionPointEccentricity_EccentricityInY()
	 * @model unsettable="true"
	 * @generated
	 */
	float getEccentricityInY();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcConnectionPointEccentricity#getEccentricityInY <em>Eccentricity In Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Eccentricity In Y</em>' attribute.
	 * @see #isSetEccentricityInY()
	 * @see #unsetEccentricityInY()
	 * @see #getEccentricityInY()
	 * @generated
	 */
	void setEccentricityInY(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcConnectionPointEccentricity#getEccentricityInY <em>Eccentricity In Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetEccentricityInY()
	 * @see #getEccentricityInY()
	 * @see #setEccentricityInY(float)
	 * @generated
	 */
	void unsetEccentricityInY();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcConnectionPointEccentricity#getEccentricityInY <em>Eccentricity In Y</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Eccentricity In Y</em>' attribute is set.
	 * @see #unsetEccentricityInY()
	 * @see #getEccentricityInY()
	 * @see #setEccentricityInY(float)
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcConnectionPointEccentricity_EccentricityInYAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getEccentricityInYAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcConnectionPointEccentricity#getEccentricityInYAsString <em>Eccentricity In YAs String</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcConnectionPointEccentricity#getEccentricityInYAsString <em>Eccentricity In YAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetEccentricityInYAsString()
	 * @see #getEccentricityInYAsString()
	 * @see #setEccentricityInYAsString(String)
	 * @generated
	 */
	void unsetEccentricityInYAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcConnectionPointEccentricity#getEccentricityInYAsString <em>Eccentricity In YAs String</em>}' attribute is set.
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
	 * @see #setEccentricityInZ(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcConnectionPointEccentricity_EccentricityInZ()
	 * @model unsettable="true"
	 * @generated
	 */
	float getEccentricityInZ();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcConnectionPointEccentricity#getEccentricityInZ <em>Eccentricity In Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Eccentricity In Z</em>' attribute.
	 * @see #isSetEccentricityInZ()
	 * @see #unsetEccentricityInZ()
	 * @see #getEccentricityInZ()
	 * @generated
	 */
	void setEccentricityInZ(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcConnectionPointEccentricity#getEccentricityInZ <em>Eccentricity In Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetEccentricityInZ()
	 * @see #getEccentricityInZ()
	 * @see #setEccentricityInZ(float)
	 * @generated
	 */
	void unsetEccentricityInZ();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcConnectionPointEccentricity#getEccentricityInZ <em>Eccentricity In Z</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Eccentricity In Z</em>' attribute is set.
	 * @see #unsetEccentricityInZ()
	 * @see #getEccentricityInZ()
	 * @see #setEccentricityInZ(float)
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcConnectionPointEccentricity_EccentricityInZAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getEccentricityInZAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcConnectionPointEccentricity#getEccentricityInZAsString <em>Eccentricity In ZAs String</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcConnectionPointEccentricity#getEccentricityInZAsString <em>Eccentricity In ZAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetEccentricityInZAsString()
	 * @see #getEccentricityInZAsString()
	 * @see #setEccentricityInZAsString(String)
	 * @generated
	 */
	void unsetEccentricityInZAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcConnectionPointEccentricity#getEccentricityInZAsString <em>Eccentricity In ZAs String</em>}' attribute is set.
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
