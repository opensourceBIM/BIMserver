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
package org.bimserver.models.ifc2x3tc1.impl;

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

import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.IfcAnalysisTheoryTypeEnum;
import org.bimserver.models.ifc2x3tc1.IfcStructuralAnalysisModel;
import org.bimserver.models.ifc2x3tc1.IfcStructuralLoadGroup;
import org.bimserver.models.ifc2x3tc1.IfcStructuralResultGroup;
import org.bimserver.models.ifc2x3tc1.Tristate;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Structural Result Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralResultGroupImpl#getTheoryType <em>Theory Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralResultGroupImpl#getResultForLoadGroup <em>Result For Load Group</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralResultGroupImpl#getIsLinear <em>Is Linear</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralResultGroupImpl#getResultGroupFor <em>Result Group For</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcStructuralResultGroupImpl extends IfcGroupImpl implements IfcStructuralResultGroup {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcStructuralResultGroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_RESULT_GROUP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAnalysisTheoryTypeEnum getTheoryType() {
		return (IfcAnalysisTheoryTypeEnum) eGet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_RESULT_GROUP__THEORY_TYPE,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTheoryType(IfcAnalysisTheoryTypeEnum newTheoryType) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_RESULT_GROUP__THEORY_TYPE, newTheoryType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStructuralLoadGroup getResultForLoadGroup() {
		return (IfcStructuralLoadGroup) eGet(
				Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_RESULT_GROUP__RESULT_FOR_LOAD_GROUP, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResultForLoadGroup(IfcStructuralLoadGroup newResultForLoadGroup) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_RESULT_GROUP__RESULT_FOR_LOAD_GROUP, newResultForLoadGroup);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetResultForLoadGroup() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_RESULT_GROUP__RESULT_FOR_LOAD_GROUP);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetResultForLoadGroup() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_RESULT_GROUP__RESULT_FOR_LOAD_GROUP);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tristate getIsLinear() {
		return (Tristate) eGet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_RESULT_GROUP__IS_LINEAR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsLinear(Tristate newIsLinear) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_RESULT_GROUP__IS_LINEAR, newIsLinear);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcStructuralAnalysisModel> getResultGroupFor() {
		return (EList<IfcStructuralAnalysisModel>) eGet(
				Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_RESULT_GROUP__RESULT_GROUP_FOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetResultGroupFor() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_RESULT_GROUP__RESULT_GROUP_FOR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetResultGroupFor() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_RESULT_GROUP__RESULT_GROUP_FOR);
	}

} //IfcStructuralResultGroupImpl
