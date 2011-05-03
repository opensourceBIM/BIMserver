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
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.emf.IdEObjectImpl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcDocumentElectronicFormat;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Document Electronic Format</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDocumentElectronicFormatImpl#getFileExtension <em>File Extension</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDocumentElectronicFormatImpl#getMimeContentType <em>Mime Content Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDocumentElectronicFormatImpl#getMimeSubtype <em>Mime Subtype</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcDocumentElectronicFormatImpl extends IdEObjectImpl implements IfcDocumentElectronicFormat
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = " (c) Copyright bimserver.org 2009\r\n Licensed under GNU GPLv3\r\n http://www.gnu.org/licenses/gpl-3.0.txt\r\n For more information mail to license@bimserver.org\r\n \r\n Bimserver.org is free software: you can redistribute it and/or modify \r\n it under the terms of the GNU General Public License as published by \r\n the Free Software Foundation, either version 3 of the License, or\r\n (at your option) any later version.\r\n \r\n Bimserver.org is distributed in the hope that it will be useful, but \r\n WITHOUT ANY WARRANTY; without even the implied warranty of \r\n MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU \r\n General Public License for more details.\r\n \r\n You should have received a copy of the GNU General Public License a \r\n long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcDocumentElectronicFormatImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return Ifc2x3Package.Literals.IFC_DOCUMENT_ELECTRONIC_FORMAT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount()
	{
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFileExtension()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_DOCUMENT_ELECTRONIC_FORMAT__FILE_EXTENSION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFileExtension(String newFileExtension)
	{
		eSet(Ifc2x3Package.Literals.IFC_DOCUMENT_ELECTRONIC_FORMAT__FILE_EXTENSION, newFileExtension);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFileExtension()
	{
		eUnset(Ifc2x3Package.Literals.IFC_DOCUMENT_ELECTRONIC_FORMAT__FILE_EXTENSION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFileExtension()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_DOCUMENT_ELECTRONIC_FORMAT__FILE_EXTENSION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMimeContentType()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_DOCUMENT_ELECTRONIC_FORMAT__MIME_CONTENT_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMimeContentType(String newMimeContentType)
	{
		eSet(Ifc2x3Package.Literals.IFC_DOCUMENT_ELECTRONIC_FORMAT__MIME_CONTENT_TYPE, newMimeContentType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMimeContentType()
	{
		eUnset(Ifc2x3Package.Literals.IFC_DOCUMENT_ELECTRONIC_FORMAT__MIME_CONTENT_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMimeContentType()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_DOCUMENT_ELECTRONIC_FORMAT__MIME_CONTENT_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMimeSubtype()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_DOCUMENT_ELECTRONIC_FORMAT__MIME_SUBTYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMimeSubtype(String newMimeSubtype)
	{
		eSet(Ifc2x3Package.Literals.IFC_DOCUMENT_ELECTRONIC_FORMAT__MIME_SUBTYPE, newMimeSubtype);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMimeSubtype()
	{
		eUnset(Ifc2x3Package.Literals.IFC_DOCUMENT_ELECTRONIC_FORMAT__MIME_SUBTYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMimeSubtype()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_DOCUMENT_ELECTRONIC_FORMAT__MIME_SUBTYPE);
	}

} //IfcDocumentElectronicFormatImpl
