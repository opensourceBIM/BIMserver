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
 * A representation of the model object '<em><b>Ifc Surface Style Refraction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSurfaceStyleRefraction#getRefractionIndex <em>Refraction Index</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSurfaceStyleRefraction#getRefractionIndexAsString <em>Refraction Index As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSurfaceStyleRefraction#getDispersionFactor <em>Dispersion Factor</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSurfaceStyleRefraction#getDispersionFactorAsString <em>Dispersion Factor As String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSurfaceStyleRefraction()
 * @model
 * @generated
 */
public interface IfcSurfaceStyleRefraction extends IfcSurfaceStyleElementSelect
{
	/**
	 * Returns the value of the '<em><b>Refraction Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refraction Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refraction Index</em>' attribute.
	 * @see #isSetRefractionIndex()
	 * @see #unsetRefractionIndex()
	 * @see #setRefractionIndex(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSurfaceStyleRefraction_RefractionIndex()
	 * @model unsettable="true"
	 * @generated
	 */
	float getRefractionIndex();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcSurfaceStyleRefraction#getRefractionIndex <em>Refraction Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Refraction Index</em>' attribute.
	 * @see #isSetRefractionIndex()
	 * @see #unsetRefractionIndex()
	 * @see #getRefractionIndex()
	 * @generated
	 */
	void setRefractionIndex(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcSurfaceStyleRefraction#getRefractionIndex <em>Refraction Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRefractionIndex()
	 * @see #getRefractionIndex()
	 * @see #setRefractionIndex(float)
	 * @generated
	 */
	void unsetRefractionIndex();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcSurfaceStyleRefraction#getRefractionIndex <em>Refraction Index</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Refraction Index</em>' attribute is set.
	 * @see #unsetRefractionIndex()
	 * @see #getRefractionIndex()
	 * @see #setRefractionIndex(float)
	 * @generated
	 */
	boolean isSetRefractionIndex();

	/**
	 * Returns the value of the '<em><b>Refraction Index As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refraction Index As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refraction Index As String</em>' attribute.
	 * @see #isSetRefractionIndexAsString()
	 * @see #unsetRefractionIndexAsString()
	 * @see #setRefractionIndexAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSurfaceStyleRefraction_RefractionIndexAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getRefractionIndexAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcSurfaceStyleRefraction#getRefractionIndexAsString <em>Refraction Index As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Refraction Index As String</em>' attribute.
	 * @see #isSetRefractionIndexAsString()
	 * @see #unsetRefractionIndexAsString()
	 * @see #getRefractionIndexAsString()
	 * @generated
	 */
	void setRefractionIndexAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcSurfaceStyleRefraction#getRefractionIndexAsString <em>Refraction Index As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRefractionIndexAsString()
	 * @see #getRefractionIndexAsString()
	 * @see #setRefractionIndexAsString(String)
	 * @generated
	 */
	void unsetRefractionIndexAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcSurfaceStyleRefraction#getRefractionIndexAsString <em>Refraction Index As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Refraction Index As String</em>' attribute is set.
	 * @see #unsetRefractionIndexAsString()
	 * @see #getRefractionIndexAsString()
	 * @see #setRefractionIndexAsString(String)
	 * @generated
	 */
	boolean isSetRefractionIndexAsString();

	/**
	 * Returns the value of the '<em><b>Dispersion Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dispersion Factor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dispersion Factor</em>' attribute.
	 * @see #isSetDispersionFactor()
	 * @see #unsetDispersionFactor()
	 * @see #setDispersionFactor(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSurfaceStyleRefraction_DispersionFactor()
	 * @model unsettable="true"
	 * @generated
	 */
	float getDispersionFactor();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcSurfaceStyleRefraction#getDispersionFactor <em>Dispersion Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dispersion Factor</em>' attribute.
	 * @see #isSetDispersionFactor()
	 * @see #unsetDispersionFactor()
	 * @see #getDispersionFactor()
	 * @generated
	 */
	void setDispersionFactor(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcSurfaceStyleRefraction#getDispersionFactor <em>Dispersion Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDispersionFactor()
	 * @see #getDispersionFactor()
	 * @see #setDispersionFactor(float)
	 * @generated
	 */
	void unsetDispersionFactor();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcSurfaceStyleRefraction#getDispersionFactor <em>Dispersion Factor</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Dispersion Factor</em>' attribute is set.
	 * @see #unsetDispersionFactor()
	 * @see #getDispersionFactor()
	 * @see #setDispersionFactor(float)
	 * @generated
	 */
	boolean isSetDispersionFactor();

	/**
	 * Returns the value of the '<em><b>Dispersion Factor As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dispersion Factor As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dispersion Factor As String</em>' attribute.
	 * @see #isSetDispersionFactorAsString()
	 * @see #unsetDispersionFactorAsString()
	 * @see #setDispersionFactorAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSurfaceStyleRefraction_DispersionFactorAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getDispersionFactorAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcSurfaceStyleRefraction#getDispersionFactorAsString <em>Dispersion Factor As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dispersion Factor As String</em>' attribute.
	 * @see #isSetDispersionFactorAsString()
	 * @see #unsetDispersionFactorAsString()
	 * @see #getDispersionFactorAsString()
	 * @generated
	 */
	void setDispersionFactorAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcSurfaceStyleRefraction#getDispersionFactorAsString <em>Dispersion Factor As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDispersionFactorAsString()
	 * @see #getDispersionFactorAsString()
	 * @see #setDispersionFactorAsString(String)
	 * @generated
	 */
	void unsetDispersionFactorAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcSurfaceStyleRefraction#getDispersionFactorAsString <em>Dispersion Factor As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Dispersion Factor As String</em>' attribute is set.
	 * @see #unsetDispersionFactorAsString()
	 * @see #getDispersionFactorAsString()
	 * @see #setDispersionFactorAsString(String)
	 * @generated
	 */
	boolean isSetDispersionFactorAsString();

} // IfcSurfaceStyleRefraction
