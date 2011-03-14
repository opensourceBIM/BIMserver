/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcDocumentSelect;
import org.bimserver.models.ifc2x3.IfcRelAssociatesDocument;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Rel Associates Document</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelAssociatesDocumentImpl#getRelatingDocument <em>Relating Document</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcRelAssociatesDocumentImpl extends IfcRelAssociatesImpl implements IfcRelAssociatesDocument {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRelAssociatesDocumentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcRelAssociatesDocument();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDocumentSelect getRelatingDocument() {
		return (IfcDocumentSelect)eGet(Ifc2x3Package.eINSTANCE.getIfcRelAssociatesDocument_RelatingDocument(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelatingDocument(IfcDocumentSelect newRelatingDocument) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcRelAssociatesDocument_RelatingDocument(), newRelatingDocument);
	}

} //IfcRelAssociatesDocumentImpl
