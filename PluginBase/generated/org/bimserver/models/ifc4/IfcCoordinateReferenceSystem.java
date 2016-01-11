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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Coordinate Reference System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcCoordinateReferenceSystem#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcCoordinateReferenceSystem#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcCoordinateReferenceSystem#getGeodeticDatum <em>Geodetic Datum</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcCoordinateReferenceSystem#getVerticalDatum <em>Vertical Datum</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcCoordinateReferenceSystem()
 * @model
 * @generated
 */
public interface IfcCoordinateReferenceSystem extends IfcCoordinateReferenceSystemSelect {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #isSetName()
	 * @see #unsetName()
	 * @see #setName(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcCoordinateReferenceSystem_Name()
	 * @model unsettable="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcCoordinateReferenceSystem#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #isSetName()
	 * @see #unsetName()
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcCoordinateReferenceSystem#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetName()
	 * @see #getName()
	 * @see #setName(String)
	 * @generated
	 */
	void unsetName();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcCoordinateReferenceSystem#getName <em>Name</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Name</em>' attribute is set.
	 * @see #unsetName()
	 * @see #getName()
	 * @see #setName(String)
	 * @generated
	 */
	boolean isSetName();

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #isSetDescription()
	 * @see #unsetDescription()
	 * @see #setDescription(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcCoordinateReferenceSystem_Description()
	 * @model unsettable="true"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcCoordinateReferenceSystem#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #isSetDescription()
	 * @see #unsetDescription()
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcCoordinateReferenceSystem#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDescription()
	 * @see #getDescription()
	 * @see #setDescription(String)
	 * @generated
	 */
	void unsetDescription();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcCoordinateReferenceSystem#getDescription <em>Description</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Description</em>' attribute is set.
	 * @see #unsetDescription()
	 * @see #getDescription()
	 * @see #setDescription(String)
	 * @generated
	 */
	boolean isSetDescription();

	/**
	 * Returns the value of the '<em><b>Geodetic Datum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Geodetic Datum</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Geodetic Datum</em>' attribute.
	 * @see #setGeodeticDatum(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcCoordinateReferenceSystem_GeodeticDatum()
	 * @model
	 * @generated
	 */
	String getGeodeticDatum();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcCoordinateReferenceSystem#getGeodeticDatum <em>Geodetic Datum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Geodetic Datum</em>' attribute.
	 * @see #getGeodeticDatum()
	 * @generated
	 */
	void setGeodeticDatum(String value);

	/**
	 * Returns the value of the '<em><b>Vertical Datum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vertical Datum</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vertical Datum</em>' attribute.
	 * @see #isSetVerticalDatum()
	 * @see #unsetVerticalDatum()
	 * @see #setVerticalDatum(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcCoordinateReferenceSystem_VerticalDatum()
	 * @model unsettable="true"
	 * @generated
	 */
	String getVerticalDatum();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcCoordinateReferenceSystem#getVerticalDatum <em>Vertical Datum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vertical Datum</em>' attribute.
	 * @see #isSetVerticalDatum()
	 * @see #unsetVerticalDatum()
	 * @see #getVerticalDatum()
	 * @generated
	 */
	void setVerticalDatum(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcCoordinateReferenceSystem#getVerticalDatum <em>Vertical Datum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetVerticalDatum()
	 * @see #getVerticalDatum()
	 * @see #setVerticalDatum(String)
	 * @generated
	 */
	void unsetVerticalDatum();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcCoordinateReferenceSystem#getVerticalDatum <em>Vertical Datum</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Vertical Datum</em>' attribute is set.
	 * @see #unsetVerticalDatum()
	 * @see #getVerticalDatum()
	 * @see #setVerticalDatum(String)
	 * @generated
	 */
	boolean isSetVerticalDatum();

} // IfcCoordinateReferenceSystem
