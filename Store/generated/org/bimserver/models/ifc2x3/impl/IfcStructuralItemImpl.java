/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcRelConnectsStructuralActivity;
import org.bimserver.models.ifc2x3.IfcStructuralItem;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Structural Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralItemImpl#getAssignedStructuralActivity <em>Assigned Structural Activity</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcStructuralItemImpl extends IfcProductImpl implements IfcStructuralItem {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcStructuralItemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcStructuralItem();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelConnectsStructuralActivity> getAssignedStructuralActivity() {
		return (EList<IfcRelConnectsStructuralActivity>)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralItem_AssignedStructuralActivity(), true);
	}

} //IfcStructuralItemImpl
