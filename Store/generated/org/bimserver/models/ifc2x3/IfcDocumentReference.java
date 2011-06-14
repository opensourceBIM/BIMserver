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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Document Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcDocumentReference#getReferenceToDocument <em>Reference To Document</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDocumentReference()
 * @model
 * @generated
 */
public interface IfcDocumentReference extends IfcExternalReference, IfcDocumentSelect
{
	/**
	 * Returns the value of the '<em><b>Reference To Document</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcDocumentInformation}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcDocumentInformation#getDocumentReferences <em>Document References</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference To Document</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference To Document</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDocumentReference_ReferenceToDocument()
	 * @see org.bimserver.models.ifc2x3.IfcDocumentInformation#getDocumentReferences
	 * @model opposite="DocumentReferences" upper="2"
	 * @generated
	 */
	EList<IfcDocumentInformation> getReferenceToDocument();

} // IfcDocumentReference
