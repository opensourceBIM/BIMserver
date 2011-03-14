/**
 * <copyright>
 * </copyright>
 *
 * $Id$
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
public interface IfcDocumentReference extends IfcExternalReference, IfcDocumentSelect {
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
