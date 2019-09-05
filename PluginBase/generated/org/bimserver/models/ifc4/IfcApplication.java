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

import org.bimserver.emf.IdEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Application</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcApplication#getApplicationDeveloper <em>Application Developer</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcApplication#getVersion <em>Version</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcApplication#getApplicationFullName <em>Application Full Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcApplication#getApplicationIdentifier <em>Application Identifier</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcApplication()
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
	 * @see #setApplicationDeveloper(IfcOrganization)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcApplication_ApplicationDeveloper()
	 * @model
	 * @generated
	 */
	IfcOrganization getApplicationDeveloper();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcApplication#getApplicationDeveloper <em>Application Developer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Application Developer</em>' reference.
	 * @see #getApplicationDeveloper()
	 * @generated
	 */
	void setApplicationDeveloper(IfcOrganization value);

	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcApplication_Version()
	 * @model
	 * @generated
	 */
	String getVersion();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcApplication#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(String value);

	/**
	 * Returns the value of the '<em><b>Application Full Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Application Full Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Application Full Name</em>' attribute.
	 * @see #setApplicationFullName(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcApplication_ApplicationFullName()
	 * @model
	 * @generated
	 */
	String getApplicationFullName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcApplication#getApplicationFullName <em>Application Full Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Application Full Name</em>' attribute.
	 * @see #getApplicationFullName()
	 * @generated
	 */
	void setApplicationFullName(String value);

	/**
	 * Returns the value of the '<em><b>Application Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Application Identifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Application Identifier</em>' attribute.
	 * @see #setApplicationIdentifier(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcApplication_ApplicationIdentifier()
	 * @model
	 * @generated
	 */
	String getApplicationIdentifier();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcApplication#getApplicationIdentifier <em>Application Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Application Identifier</em>' attribute.
	 * @see #getApplicationIdentifier()
	 * @generated
	 */
	void setApplicationIdentifier(String value);

} // IfcApplication
