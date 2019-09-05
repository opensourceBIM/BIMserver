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

import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.models.ifc4.Ifc4Package;
import org.bimserver.models.ifc4.IfcAppliedValue;
import org.bimserver.models.ifc4.IfcAppliedValueSelect;
import org.bimserver.models.ifc4.IfcArithmeticOperatorEnum;
import org.bimserver.models.ifc4.IfcExternalReferenceRelationship;
import org.bimserver.models.ifc4.IfcMeasureWithUnit;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Applied Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcAppliedValueImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcAppliedValueImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcAppliedValueImpl#getAppliedValue <em>Applied Value</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcAppliedValueImpl#getUnitBasis <em>Unit Basis</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcAppliedValueImpl#getApplicableDate <em>Applicable Date</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcAppliedValueImpl#getFixedUntilDate <em>Fixed Until Date</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcAppliedValueImpl#getCategory <em>Category</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcAppliedValueImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcAppliedValueImpl#getArithmeticOperator <em>Arithmetic Operator</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcAppliedValueImpl#getComponents <em>Components</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcAppliedValueImpl#getHasExternalReference <em>Has External Reference</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcAppliedValueImpl extends IdEObjectImpl implements IfcAppliedValue {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcAppliedValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_APPLIED_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return (String) eGet(Ifc4Package.Literals.IFC_APPLIED_VALUE__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		eSet(Ifc4Package.Literals.IFC_APPLIED_VALUE__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetName() {
		eUnset(Ifc4Package.Literals.IFC_APPLIED_VALUE__NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetName() {
		return eIsSet(Ifc4Package.Literals.IFC_APPLIED_VALUE__NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDescription() {
		return (String) eGet(Ifc4Package.Literals.IFC_APPLIED_VALUE__DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescription(String newDescription) {
		eSet(Ifc4Package.Literals.IFC_APPLIED_VALUE__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDescription() {
		eUnset(Ifc4Package.Literals.IFC_APPLIED_VALUE__DESCRIPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDescription() {
		return eIsSet(Ifc4Package.Literals.IFC_APPLIED_VALUE__DESCRIPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcAppliedValueSelect getAppliedValue() {
		return (IfcAppliedValueSelect) eGet(Ifc4Package.Literals.IFC_APPLIED_VALUE__APPLIED_VALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAppliedValue(IfcAppliedValueSelect newAppliedValue) {
		eSet(Ifc4Package.Literals.IFC_APPLIED_VALUE__APPLIED_VALUE, newAppliedValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetAppliedValue() {
		eUnset(Ifc4Package.Literals.IFC_APPLIED_VALUE__APPLIED_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetAppliedValue() {
		return eIsSet(Ifc4Package.Literals.IFC_APPLIED_VALUE__APPLIED_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMeasureWithUnit getUnitBasis() {
		return (IfcMeasureWithUnit) eGet(Ifc4Package.Literals.IFC_APPLIED_VALUE__UNIT_BASIS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUnitBasis(IfcMeasureWithUnit newUnitBasis) {
		eSet(Ifc4Package.Literals.IFC_APPLIED_VALUE__UNIT_BASIS, newUnitBasis);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetUnitBasis() {
		eUnset(Ifc4Package.Literals.IFC_APPLIED_VALUE__UNIT_BASIS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetUnitBasis() {
		return eIsSet(Ifc4Package.Literals.IFC_APPLIED_VALUE__UNIT_BASIS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getApplicableDate() {
		return (String) eGet(Ifc4Package.Literals.IFC_APPLIED_VALUE__APPLICABLE_DATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setApplicableDate(String newApplicableDate) {
		eSet(Ifc4Package.Literals.IFC_APPLIED_VALUE__APPLICABLE_DATE, newApplicableDate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetApplicableDate() {
		eUnset(Ifc4Package.Literals.IFC_APPLIED_VALUE__APPLICABLE_DATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetApplicableDate() {
		return eIsSet(Ifc4Package.Literals.IFC_APPLIED_VALUE__APPLICABLE_DATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFixedUntilDate() {
		return (String) eGet(Ifc4Package.Literals.IFC_APPLIED_VALUE__FIXED_UNTIL_DATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFixedUntilDate(String newFixedUntilDate) {
		eSet(Ifc4Package.Literals.IFC_APPLIED_VALUE__FIXED_UNTIL_DATE, newFixedUntilDate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetFixedUntilDate() {
		eUnset(Ifc4Package.Literals.IFC_APPLIED_VALUE__FIXED_UNTIL_DATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetFixedUntilDate() {
		return eIsSet(Ifc4Package.Literals.IFC_APPLIED_VALUE__FIXED_UNTIL_DATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCategory() {
		return (String) eGet(Ifc4Package.Literals.IFC_APPLIED_VALUE__CATEGORY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCategory(String newCategory) {
		eSet(Ifc4Package.Literals.IFC_APPLIED_VALUE__CATEGORY, newCategory);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCategory() {
		eUnset(Ifc4Package.Literals.IFC_APPLIED_VALUE__CATEGORY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCategory() {
		return eIsSet(Ifc4Package.Literals.IFC_APPLIED_VALUE__CATEGORY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCondition() {
		return (String) eGet(Ifc4Package.Literals.IFC_APPLIED_VALUE__CONDITION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCondition(String newCondition) {
		eSet(Ifc4Package.Literals.IFC_APPLIED_VALUE__CONDITION, newCondition);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCondition() {
		eUnset(Ifc4Package.Literals.IFC_APPLIED_VALUE__CONDITION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCondition() {
		return eIsSet(Ifc4Package.Literals.IFC_APPLIED_VALUE__CONDITION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcArithmeticOperatorEnum getArithmeticOperator() {
		return (IfcArithmeticOperatorEnum) eGet(Ifc4Package.Literals.IFC_APPLIED_VALUE__ARITHMETIC_OPERATOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setArithmeticOperator(IfcArithmeticOperatorEnum newArithmeticOperator) {
		eSet(Ifc4Package.Literals.IFC_APPLIED_VALUE__ARITHMETIC_OPERATOR, newArithmeticOperator);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetArithmeticOperator() {
		eUnset(Ifc4Package.Literals.IFC_APPLIED_VALUE__ARITHMETIC_OPERATOR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetArithmeticOperator() {
		return eIsSet(Ifc4Package.Literals.IFC_APPLIED_VALUE__ARITHMETIC_OPERATOR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcAppliedValue> getComponents() {
		return (EList<IfcAppliedValue>) eGet(Ifc4Package.Literals.IFC_APPLIED_VALUE__COMPONENTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetComponents() {
		eUnset(Ifc4Package.Literals.IFC_APPLIED_VALUE__COMPONENTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetComponents() {
		return eIsSet(Ifc4Package.Literals.IFC_APPLIED_VALUE__COMPONENTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcExternalReferenceRelationship> getHasExternalReference() {
		return (EList<IfcExternalReferenceRelationship>) eGet(Ifc4Package.Literals.IFC_APPLIED_VALUE__HAS_EXTERNAL_REFERENCE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetHasExternalReference() {
		eUnset(Ifc4Package.Literals.IFC_APPLIED_VALUE__HAS_EXTERNAL_REFERENCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetHasExternalReference() {
		return eIsSet(Ifc4Package.Literals.IFC_APPLIED_VALUE__HAS_EXTERNAL_REFERENCE);
	}

} //IfcAppliedValueImpl
