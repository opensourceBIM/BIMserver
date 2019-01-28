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
import org.bimserver.models.ifc2x3tc1.IfcActionSourceTypeEnum;
import org.bimserver.models.ifc2x3tc1.IfcActionTypeEnum;
import org.bimserver.models.ifc2x3tc1.IfcLoadGroupTypeEnum;
import org.bimserver.models.ifc2x3tc1.IfcStructuralAnalysisModel;
import org.bimserver.models.ifc2x3tc1.IfcStructuralLoadGroup;
import org.bimserver.models.ifc2x3tc1.IfcStructuralResultGroup;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Structural Load Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralLoadGroupImpl#getPredefinedType <em>Predefined Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralLoadGroupImpl#getActionType <em>Action Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralLoadGroupImpl#getActionSource <em>Action Source</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralLoadGroupImpl#getCoefficient <em>Coefficient</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralLoadGroupImpl#getCoefficientAsString <em>Coefficient As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralLoadGroupImpl#getPurpose <em>Purpose</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralLoadGroupImpl#getSourceOfResultGroup <em>Source Of Result Group</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralLoadGroupImpl#getLoadGroupFor <em>Load Group For</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcStructuralLoadGroupImpl extends IfcGroupImpl implements IfcStructuralLoadGroup {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcStructuralLoadGroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_GROUP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcLoadGroupTypeEnum getPredefinedType() {
		return (IfcLoadGroupTypeEnum) eGet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_GROUP__PREDEFINED_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPredefinedType(IfcLoadGroupTypeEnum newPredefinedType) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_GROUP__PREDEFINED_TYPE, newPredefinedType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcActionTypeEnum getActionType() {
		return (IfcActionTypeEnum) eGet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_GROUP__ACTION_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActionType(IfcActionTypeEnum newActionType) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_GROUP__ACTION_TYPE, newActionType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcActionSourceTypeEnum getActionSource() {
		return (IfcActionSourceTypeEnum) eGet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_GROUP__ACTION_SOURCE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActionSource(IfcActionSourceTypeEnum newActionSource) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_GROUP__ACTION_SOURCE, newActionSource);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getCoefficient() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_GROUP__COEFFICIENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCoefficient(double newCoefficient) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_GROUP__COEFFICIENT, newCoefficient);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCoefficient() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_GROUP__COEFFICIENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCoefficient() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_GROUP__COEFFICIENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCoefficientAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_GROUP__COEFFICIENT_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCoefficientAsString(String newCoefficientAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_GROUP__COEFFICIENT_AS_STRING, newCoefficientAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCoefficientAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_GROUP__COEFFICIENT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCoefficientAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_GROUP__COEFFICIENT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPurpose() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_GROUP__PURPOSE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPurpose(String newPurpose) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_GROUP__PURPOSE, newPurpose);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPurpose() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_GROUP__PURPOSE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPurpose() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_GROUP__PURPOSE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcStructuralResultGroup> getSourceOfResultGroup() {
		return (EList<IfcStructuralResultGroup>) eGet(
				Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_GROUP__SOURCE_OF_RESULT_GROUP, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSourceOfResultGroup() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_GROUP__SOURCE_OF_RESULT_GROUP);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSourceOfResultGroup() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_GROUP__SOURCE_OF_RESULT_GROUP);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcStructuralAnalysisModel> getLoadGroupFor() {
		return (EList<IfcStructuralAnalysisModel>) eGet(
				Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_GROUP__LOAD_GROUP_FOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLoadGroupFor() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_GROUP__LOAD_GROUP_FOR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLoadGroupFor() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_GROUP__LOAD_GROUP_FOR);
	}

} //IfcStructuralLoadGroupImpl
