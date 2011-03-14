/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcMove;
import org.bimserver.models.ifc2x3.IfcSpatialStructureElement;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Move</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcMoveImpl#getMoveFrom <em>Move From</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcMoveImpl#getMoveTo <em>Move To</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcMoveImpl#getPunchList <em>Punch List</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcMoveImpl extends IfcTaskImpl implements IfcMove {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcMoveImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcMove();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSpatialStructureElement getMoveFrom() {
		return (IfcSpatialStructureElement)eGet(Ifc2x3Package.eINSTANCE.getIfcMove_MoveFrom(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMoveFrom(IfcSpatialStructureElement newMoveFrom) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcMove_MoveFrom(), newMoveFrom);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSpatialStructureElement getMoveTo() {
		return (IfcSpatialStructureElement)eGet(Ifc2x3Package.eINSTANCE.getIfcMove_MoveTo(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMoveTo(IfcSpatialStructureElement newMoveTo) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcMove_MoveTo(), newMoveTo);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getPunchList() {
		return (EList<String>)eGet(Ifc2x3Package.eINSTANCE.getIfcMove_PunchList(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPunchList() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcMove_PunchList());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPunchList() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcMove_PunchList());
	}

} //IfcMoveImpl
