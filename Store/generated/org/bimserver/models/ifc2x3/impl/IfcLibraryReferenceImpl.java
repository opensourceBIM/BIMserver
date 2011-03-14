/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcLibraryInformation;
import org.bimserver.models.ifc2x3.IfcLibraryReference;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Library Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLibraryReferenceImpl#getReferenceIntoLibrary <em>Reference Into Library</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcLibraryReferenceImpl extends IfcExternalReferenceImpl implements IfcLibraryReference {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcLibraryReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcLibraryReference();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcLibraryInformation> getReferenceIntoLibrary() {
		return (EList<IfcLibraryInformation>)eGet(Ifc2x3Package.eINSTANCE.getIfcLibraryReference_ReferenceIntoLibrary(), true);
	}

} //IfcLibraryReferenceImpl
