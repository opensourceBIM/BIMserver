/**
 * Copyright (C) 2009-2014 BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.bimserver.models.ifc4.impl;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import org.bimserver.models.ifc4.Ifc4Package;
import org.bimserver.models.ifc4.IfcGlobalOrLocalEnum;
import org.bimserver.models.ifc4.IfcRelConnectsStructuralActivity;
import org.bimserver.models.ifc4.IfcStructuralActivity;
import org.bimserver.models.ifc4.IfcStructuralLoad;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Structural Activity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcStructuralActivityImpl#getAppliedLoad <em>Applied Load</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcStructuralActivityImpl#getGlobalOrLocal <em>Global Or Local</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcStructuralActivityImpl#getAssignedToStructuralItem <em>Assigned To Structural Item</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcStructuralActivityImpl extends IfcProductImpl implements IfcStructuralActivity {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcStructuralActivityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_STRUCTURAL_ACTIVITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcStructuralLoad getAppliedLoad() {
		return (IfcStructuralLoad) eGet(Ifc4Package.Literals.IFC_STRUCTURAL_ACTIVITY__APPLIED_LOAD, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAppliedLoad(IfcStructuralLoad newAppliedLoad) {
		eSet(Ifc4Package.Literals.IFC_STRUCTURAL_ACTIVITY__APPLIED_LOAD, newAppliedLoad);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcGlobalOrLocalEnum getGlobalOrLocal() {
		return (IfcGlobalOrLocalEnum) eGet(Ifc4Package.Literals.IFC_STRUCTURAL_ACTIVITY__GLOBAL_OR_LOCAL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGlobalOrLocal(IfcGlobalOrLocalEnum newGlobalOrLocal) {
		eSet(Ifc4Package.Literals.IFC_STRUCTURAL_ACTIVITY__GLOBAL_OR_LOCAL, newGlobalOrLocal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelConnectsStructuralActivity> getAssignedToStructuralItem() {
		return (EList<IfcRelConnectsStructuralActivity>) eGet(Ifc4Package.Literals.IFC_STRUCTURAL_ACTIVITY__ASSIGNED_TO_STRUCTURAL_ITEM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetAssignedToStructuralItem() {
		eUnset(Ifc4Package.Literals.IFC_STRUCTURAL_ACTIVITY__ASSIGNED_TO_STRUCTURAL_ITEM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetAssignedToStructuralItem() {
		return eIsSet(Ifc4Package.Literals.IFC_STRUCTURAL_ACTIVITY__ASSIGNED_TO_STRUCTURAL_ITEM);
	}

} //IfcStructuralActivityImpl
