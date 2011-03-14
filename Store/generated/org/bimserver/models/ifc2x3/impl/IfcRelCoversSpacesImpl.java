/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcCovering;
import org.bimserver.models.ifc2x3.IfcRelCoversSpaces;
import org.bimserver.models.ifc2x3.IfcSpace;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Rel Covers Spaces</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelCoversSpacesImpl#getRelatedSpace <em>Related Space</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelCoversSpacesImpl#getRelatedCoverings <em>Related Coverings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcRelCoversSpacesImpl extends IfcRelConnectsImpl implements IfcRelCoversSpaces {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRelCoversSpacesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcRelCoversSpaces();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSpace getRelatedSpace() {
		return (IfcSpace)eGet(Ifc2x3Package.eINSTANCE.getIfcRelCoversSpaces_RelatedSpace(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelatedSpace(IfcSpace newRelatedSpace) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcRelCoversSpaces_RelatedSpace(), newRelatedSpace);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcCovering> getRelatedCoverings() {
		return (EList<IfcCovering>)eGet(Ifc2x3Package.eINSTANCE.getIfcRelCoversSpaces_RelatedCoverings(), true);
	}

} //IfcRelCoversSpacesImpl
