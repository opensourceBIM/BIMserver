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

import org.bimserver.emf.IdEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Document Electronic Format</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcDocumentElectronicFormat#getFileExtension <em>File Extension</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcDocumentElectronicFormat#getMimeContentType <em>Mime Content Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcDocumentElectronicFormat#getMimeSubtype <em>Mime Subtype</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcDocumentElectronicFormat()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface IfcDocumentElectronicFormat extends IdEObject {
	/**
	 * Returns the value of the '<em><b>File Extension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File Extension</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File Extension</em>' attribute.
	 * @see #isSetFileExtension()
	 * @see #unsetFileExtension()
	 * @see #setFileExtension(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcDocumentElectronicFormat_FileExtension()
	 * @model unsettable="true"
	 * @generated
	 */
	String getFileExtension();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcDocumentElectronicFormat#getFileExtension <em>File Extension</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File Extension</em>' attribute.
	 * @see #isSetFileExtension()
	 * @see #unsetFileExtension()
	 * @see #getFileExtension()
	 * @generated
	 */
	void setFileExtension(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcDocumentElectronicFormat#getFileExtension <em>File Extension</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFileExtension()
	 * @see #getFileExtension()
	 * @see #setFileExtension(String)
	 * @generated
	 */
	void unsetFileExtension();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcDocumentElectronicFormat#getFileExtension <em>File Extension</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>File Extension</em>' attribute is set.
	 * @see #unsetFileExtension()
	 * @see #getFileExtension()
	 * @see #setFileExtension(String)
	 * @generated
	 */
	boolean isSetFileExtension();

	/**
	 * Returns the value of the '<em><b>Mime Content Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mime Content Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mime Content Type</em>' attribute.
	 * @see #isSetMimeContentType()
	 * @see #unsetMimeContentType()
	 * @see #setMimeContentType(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcDocumentElectronicFormat_MimeContentType()
	 * @model unsettable="true"
	 * @generated
	 */
	String getMimeContentType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcDocumentElectronicFormat#getMimeContentType <em>Mime Content Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mime Content Type</em>' attribute.
	 * @see #isSetMimeContentType()
	 * @see #unsetMimeContentType()
	 * @see #getMimeContentType()
	 * @generated
	 */
	void setMimeContentType(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcDocumentElectronicFormat#getMimeContentType <em>Mime Content Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMimeContentType()
	 * @see #getMimeContentType()
	 * @see #setMimeContentType(String)
	 * @generated
	 */
	void unsetMimeContentType();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcDocumentElectronicFormat#getMimeContentType <em>Mime Content Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Mime Content Type</em>' attribute is set.
	 * @see #unsetMimeContentType()
	 * @see #getMimeContentType()
	 * @see #setMimeContentType(String)
	 * @generated
	 */
	boolean isSetMimeContentType();

	/**
	 * Returns the value of the '<em><b>Mime Subtype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mime Subtype</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mime Subtype</em>' attribute.
	 * @see #isSetMimeSubtype()
	 * @see #unsetMimeSubtype()
	 * @see #setMimeSubtype(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcDocumentElectronicFormat_MimeSubtype()
	 * @model unsettable="true"
	 * @generated
	 */
	String getMimeSubtype();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcDocumentElectronicFormat#getMimeSubtype <em>Mime Subtype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mime Subtype</em>' attribute.
	 * @see #isSetMimeSubtype()
	 * @see #unsetMimeSubtype()
	 * @see #getMimeSubtype()
	 * @generated
	 */
	void setMimeSubtype(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcDocumentElectronicFormat#getMimeSubtype <em>Mime Subtype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMimeSubtype()
	 * @see #getMimeSubtype()
	 * @see #setMimeSubtype(String)
	 * @generated
	 */
	void unsetMimeSubtype();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcDocumentElectronicFormat#getMimeSubtype <em>Mime Subtype</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Mime Subtype</em>' attribute is set.
	 * @see #unsetMimeSubtype()
	 * @see #getMimeSubtype()
	 * @see #setMimeSubtype(String)
	 * @generated
	 */
	boolean isSetMimeSubtype();

} // IfcDocumentElectronicFormat
