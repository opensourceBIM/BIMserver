/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcAxis2Placement;
import org.bimserver.models.ifc2x3.IfcLocalPlacement;
import org.bimserver.models.ifc2x3.IfcObjectPlacement;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Local Placement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLocalPlacementImpl#getPlacementRelTo <em>Placement Rel To</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLocalPlacementImpl#getRelativePlacement <em>Relative Placement</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcLocalPlacementImpl extends IfcObjectPlacementImpl implements IfcLocalPlacement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcLocalPlacementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcLocalPlacement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcObjectPlacement getPlacementRelTo() {
		return (IfcObjectPlacement)eGet(Ifc2x3Package.eINSTANCE.getIfcLocalPlacement_PlacementRelTo(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlacementRelTo(IfcObjectPlacement newPlacementRelTo) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcLocalPlacement_PlacementRelTo(), newPlacementRelTo);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPlacementRelTo() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcLocalPlacement_PlacementRelTo());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPlacementRelTo() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcLocalPlacement_PlacementRelTo());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAxis2Placement getRelativePlacement() {
		return (IfcAxis2Placement)eGet(Ifc2x3Package.eINSTANCE.getIfcLocalPlacement_RelativePlacement(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelativePlacement(IfcAxis2Placement newRelativePlacement) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcLocalPlacement_RelativePlacement(), newRelativePlacement);
	}

} //IfcLocalPlacementImpl
