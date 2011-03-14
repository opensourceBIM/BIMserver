/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcLibrarySelect;
import org.bimserver.models.ifc2x3.IfcRelAssociatesLibrary;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Rel Associates Library</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelAssociatesLibraryImpl#getRelatingLibrary <em>Relating Library</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcRelAssociatesLibraryImpl extends IfcRelAssociatesImpl implements IfcRelAssociatesLibrary {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRelAssociatesLibraryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcRelAssociatesLibrary();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcLibrarySelect getRelatingLibrary() {
		return (IfcLibrarySelect)eGet(Ifc2x3Package.eINSTANCE.getIfcRelAssociatesLibrary_RelatingLibrary(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelatingLibrary(IfcLibrarySelect newRelatingLibrary) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcRelAssociatesLibrary_RelatingLibrary(), newRelatingLibrary);
	}

} //IfcRelAssociatesLibraryImpl
