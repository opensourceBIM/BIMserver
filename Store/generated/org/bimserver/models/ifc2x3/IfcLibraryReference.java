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
 * A representation of the model object '<em><b>Ifc Library Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcLibraryReference#getReferenceIntoLibrary <em>Reference Into Library</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLibraryReference()
 * @model
 * @generated
 */
public interface IfcLibraryReference extends IfcExternalReference, IfcLibrarySelect {
	/**
	 * Returns the value of the '<em><b>Reference Into Library</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcLibraryInformation}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcLibraryInformation#getLibraryReference <em>Library Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference Into Library</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference Into Library</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLibraryReference_ReferenceIntoLibrary()
	 * @see org.bimserver.models.ifc2x3.IfcLibraryInformation#getLibraryReference
	 * @model opposite="LibraryReference" upper="2"
	 * @generated
	 */
	EList<IfcLibraryInformation> getReferenceIntoLibrary();

} // IfcLibraryReference
