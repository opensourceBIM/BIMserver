/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcStructuralAction;
import org.bimserver.models.ifc2x3.IfcStructuralReaction;
import org.bimserver.models.ifc2x3.Tristate;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Structural Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralActionImpl#getDestabilizingLoad <em>Destabilizing Load</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralActionImpl#getCausedBy <em>Caused By</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcStructuralActionImpl extends IfcStructuralActivityImpl implements IfcStructuralAction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcStructuralActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcStructuralAction();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tristate getDestabilizingLoad() {
		return (Tristate)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralAction_DestabilizingLoad(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDestabilizingLoad(Tristate newDestabilizingLoad) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralAction_DestabilizingLoad(), newDestabilizingLoad);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStructuralReaction getCausedBy() {
		return (IfcStructuralReaction)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralAction_CausedBy(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCausedBy(IfcStructuralReaction newCausedBy) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralAction_CausedBy(), newCausedBy);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCausedBy() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralAction_CausedBy());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCausedBy() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralAction_CausedBy());
	}

} //IfcStructuralActionImpl
