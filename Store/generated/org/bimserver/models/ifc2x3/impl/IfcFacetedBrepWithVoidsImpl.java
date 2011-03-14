/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcClosedShell;
import org.bimserver.models.ifc2x3.IfcFacetedBrepWithVoids;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Faceted Brep With Voids</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcFacetedBrepWithVoidsImpl#getVoids <em>Voids</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcFacetedBrepWithVoidsImpl extends IfcManifoldSolidBrepImpl implements IfcFacetedBrepWithVoids {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcFacetedBrepWithVoidsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcFacetedBrepWithVoids();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcClosedShell> getVoids() {
		return (EList<IfcClosedShell>)eGet(Ifc2x3Package.eINSTANCE.getIfcFacetedBrepWithVoids_Voids(), true);
	}

} //IfcFacetedBrepWithVoidsImpl
