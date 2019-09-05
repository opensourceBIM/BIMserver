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
import org.bimserver.models.ifc4.IfcRelConnectsStructuralActivity;
import org.bimserver.models.ifc4.IfcStructuralActivity;
import org.bimserver.models.ifc4.IfcStructuralActivityAssignmentSelect;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Rel Connects Structural Activity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcRelConnectsStructuralActivityImpl#getRelatingElement <em>Relating Element</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcRelConnectsStructuralActivityImpl#getRelatedStructuralActivity <em>Related Structural Activity</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcRelConnectsStructuralActivityImpl extends IfcRelConnectsImpl implements IfcRelConnectsStructuralActivity {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRelConnectsStructuralActivityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_REL_CONNECTS_STRUCTURAL_ACTIVITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcStructuralActivityAssignmentSelect getRelatingElement() {
		return (IfcStructuralActivityAssignmentSelect) eGet(Ifc4Package.Literals.IFC_REL_CONNECTS_STRUCTURAL_ACTIVITY__RELATING_ELEMENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRelatingElement(IfcStructuralActivityAssignmentSelect newRelatingElement) {
		eSet(Ifc4Package.Literals.IFC_REL_CONNECTS_STRUCTURAL_ACTIVITY__RELATING_ELEMENT, newRelatingElement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcStructuralActivity getRelatedStructuralActivity() {
		return (IfcStructuralActivity) eGet(Ifc4Package.Literals.IFC_REL_CONNECTS_STRUCTURAL_ACTIVITY__RELATED_STRUCTURAL_ACTIVITY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRelatedStructuralActivity(IfcStructuralActivity newRelatedStructuralActivity) {
		eSet(Ifc4Package.Literals.IFC_REL_CONNECTS_STRUCTURAL_ACTIVITY__RELATED_STRUCTURAL_ACTIVITY, newRelatedStructuralActivity);
	}

} //IfcRelConnectsStructuralActivityImpl
