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
package org.bimserver.models.ifc4x3;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Geographic CRS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcGeographicCRS#getPrimeMeridian <em>Prime Meridian</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcGeographicCRS#getAngleUnit <em>Angle Unit</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcGeographicCRS#getHeightUnit <em>Height Unit</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcGeographicCRS()
 * @model
 * @generated
 */
public interface IfcGeographicCRS extends IfcCoordinateReferenceSystem {
	/**
	 * Returns the value of the '<em><b>Prime Meridian</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prime Meridian</em>' attribute.
	 * @see #isSetPrimeMeridian()
	 * @see #unsetPrimeMeridian()
	 * @see #setPrimeMeridian(String)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcGeographicCRS_PrimeMeridian()
	 * @model unsettable="true"
	 * @generated
	 */
	String getPrimeMeridian();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcGeographicCRS#getPrimeMeridian <em>Prime Meridian</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prime Meridian</em>' attribute.
	 * @see #isSetPrimeMeridian()
	 * @see #unsetPrimeMeridian()
	 * @see #getPrimeMeridian()
	 * @generated
	 */
	void setPrimeMeridian(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcGeographicCRS#getPrimeMeridian <em>Prime Meridian</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPrimeMeridian()
	 * @see #getPrimeMeridian()
	 * @see #setPrimeMeridian(String)
	 * @generated
	 */
	void unsetPrimeMeridian();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcGeographicCRS#getPrimeMeridian <em>Prime Meridian</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Prime Meridian</em>' attribute is set.
	 * @see #unsetPrimeMeridian()
	 * @see #getPrimeMeridian()
	 * @see #setPrimeMeridian(String)
	 * @generated
	 */
	boolean isSetPrimeMeridian();

	/**
	 * Returns the value of the '<em><b>Angle Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Angle Unit</em>' reference.
	 * @see #isSetAngleUnit()
	 * @see #unsetAngleUnit()
	 * @see #setAngleUnit(IfcNamedUnit)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcGeographicCRS_AngleUnit()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcNamedUnit getAngleUnit();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcGeographicCRS#getAngleUnit <em>Angle Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Angle Unit</em>' reference.
	 * @see #isSetAngleUnit()
	 * @see #unsetAngleUnit()
	 * @see #getAngleUnit()
	 * @generated
	 */
	void setAngleUnit(IfcNamedUnit value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcGeographicCRS#getAngleUnit <em>Angle Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetAngleUnit()
	 * @see #getAngleUnit()
	 * @see #setAngleUnit(IfcNamedUnit)
	 * @generated
	 */
	void unsetAngleUnit();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcGeographicCRS#getAngleUnit <em>Angle Unit</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Angle Unit</em>' reference is set.
	 * @see #unsetAngleUnit()
	 * @see #getAngleUnit()
	 * @see #setAngleUnit(IfcNamedUnit)
	 * @generated
	 */
	boolean isSetAngleUnit();

	/**
	 * Returns the value of the '<em><b>Height Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Height Unit</em>' reference.
	 * @see #isSetHeightUnit()
	 * @see #unsetHeightUnit()
	 * @see #setHeightUnit(IfcNamedUnit)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcGeographicCRS_HeightUnit()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcNamedUnit getHeightUnit();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcGeographicCRS#getHeightUnit <em>Height Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Height Unit</em>' reference.
	 * @see #isSetHeightUnit()
	 * @see #unsetHeightUnit()
	 * @see #getHeightUnit()
	 * @generated
	 */
	void setHeightUnit(IfcNamedUnit value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcGeographicCRS#getHeightUnit <em>Height Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetHeightUnit()
	 * @see #getHeightUnit()
	 * @see #setHeightUnit(IfcNamedUnit)
	 * @generated
	 */
	void unsetHeightUnit();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcGeographicCRS#getHeightUnit <em>Height Unit</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Height Unit</em>' reference is set.
	 * @see #unsetHeightUnit()
	 * @see #getHeightUnit()
	 * @see #setHeightUnit(IfcNamedUnit)
	 * @generated
	 */
	boolean isSetHeightUnit();

} // IfcGeographicCRS
