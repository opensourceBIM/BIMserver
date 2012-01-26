/**
 * Copyright (C) 2011  BIMserver.org
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
package org.bimserver.models.ifc2x3;

import org.bimserver.emf.IdEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Application</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcApplication#getApplicationDeveloper <em>Application Developer</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcApplication#getVersion <em>Version</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcApplication#getApplicationFullName <em>Application Full Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcApplication#getApplicationIdentifier <em>Application Identifier</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcApplication()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface IfcApplication extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Application Developer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Application Developer</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Application Developer</em>' reference.
	 * @see #isSetApplicationDeveloper()
	 * @see #unsetApplicationDeveloper()
	 * @see #setApplicationDeveloper(IfcOrganization)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcApplication_ApplicationDeveloper()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcOrganization getApplicationDeveloper();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcApplication#getApplicationDeveloper <em>Application Developer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Application Developer</em>' reference.
	 * @see #isSetApplicationDeveloper()
	 * @see #unsetApplicationDeveloper()
	 * @see #getApplicationDeveloper()
	 * @generated
	 */
	void setApplicationDeveloper(IfcOrganization value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcApplication#getApplicationDeveloper <em>Application Developer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetApplicationDeveloper()
	 * @see #getApplicationDeveloper()
	 * @see #setApplicationDeveloper(IfcOrganization)
	 * @generated
	 */
	void unsetApplicationDeveloper();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcApplication#getApplicationDeveloper <em>Application Developer</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Application Developer</em>' reference is set.
	 * @see #unsetApplicationDeveloper()
	 * @see #getApplicationDeveloper()
	 * @see #setApplicationDeveloper(IfcOrganization)
	 * @generated
	 */
	boolean isSetApplicationDeveloper();

	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #isSetVersion()
	 * @see #unsetVersion()
	 * @see #setVersion(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcApplication_Version()
	 * @model unsettable="true"
	 * @generated
	 */
	String getVersion();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcApplication#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #isSetVersion()
	 * @see #unsetVersion()
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcApplication#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetVersion()
	 * @see #getVersion()
	 * @see #setVersion(String)
	 * @generated
	 */
	void unsetVersion();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcApplication#getVersion <em>Version</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Version</em>' attribute is set.
	 * @see #unsetVersion()
	 * @see #getVersion()
	 * @see #setVersion(String)
	 * @generated
	 */
	boolean isSetVersion();

	/**
	 * Returns the value of the '<em><b>Application Full Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Application Full Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Application Full Name</em>' attribute.
	 * @see #isSetApplicationFullName()
	 * @see #unsetApplicationFullName()
	 * @see #setApplicationFullName(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcApplication_ApplicationFullName()
	 * @model unsettable="true"
	 * @generated
	 */
	String getApplicationFullName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcApplication#getApplicationFullName <em>Application Full Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Application Full Name</em>' attribute.
	 * @see #isSetApplicationFullName()
	 * @see #unsetApplicationFullName()
	 * @see #getApplicationFullName()
	 * @generated
	 */
	void setApplicationFullName(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcApplication#getApplicationFullName <em>Application Full Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetApplicationFullName()
	 * @see #getApplicationFullName()
	 * @see #setApplicationFullName(String)
	 * @generated
	 */
	void unsetApplicationFullName();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcApplication#getApplicationFullName <em>Application Full Name</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Application Full Name</em>' attribute is set.
	 * @see #unsetApplicationFullName()
	 * @see #getApplicationFullName()
	 * @see #setApplicationFullName(String)
	 * @generated
	 */
	boolean isSetApplicationFullName();

	/**
	 * Returns the value of the '<em><b>Application Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Application Identifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Application Identifier</em>' attribute.
	 * @see #isSetApplicationIdentifier()
	 * @see #unsetApplicationIdentifier()
	 * @see #setApplicationIdentifier(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcApplication_ApplicationIdentifier()
	 * @model unsettable="true"
	 * @generated
	 */
	String getApplicationIdentifier();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcApplication#getApplicationIdentifier <em>Application Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Application Identifier</em>' attribute.
	 * @see #isSetApplicationIdentifier()
	 * @see #unsetApplicationIdentifier()
	 * @see #getApplicationIdentifier()
	 * @generated
	 */
	void setApplicationIdentifier(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcApplication#getApplicationIdentifier <em>Application Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetApplicationIdentifier()
	 * @see #getApplicationIdentifier()
	 * @see #setApplicationIdentifier(String)
	 * @generated
	 */
	void unsetApplicationIdentifier();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcApplication#getApplicationIdentifier <em>Application Identifier</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Application Identifier</em>' attribute is set.
	 * @see #unsetApplicationIdentifier()
	 * @see #getApplicationIdentifier()
	 * @see #setApplicationIdentifier(String)
	 * @generated
	 */
	boolean isSetApplicationIdentifier();

} // IfcApplication
