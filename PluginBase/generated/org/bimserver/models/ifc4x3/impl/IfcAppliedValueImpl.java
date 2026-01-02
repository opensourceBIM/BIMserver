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
package org.bimserver.models.ifc4x3.impl;

import org.bimserver.emf.IdEObjectImpl;

import org.bimserver.models.ifc4x3.Ifc4x3Package;
import org.bimserver.models.ifc4x3.IfcAppliedValue;
import org.bimserver.models.ifc4x3.IfcAppliedValueSelect;
import org.bimserver.models.ifc4x3.IfcArithmeticOperatorEnum;
import org.bimserver.models.ifc4x3.IfcExternalReferenceRelationship;
import org.bimserver.models.ifc4x3.IfcMeasureWithUnit;

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
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAppliedValueImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAppliedValueImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAppliedValueImpl#getAppliedValue <em>Applied Value</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAppliedValueImpl#getUnitBasis <em>Unit Basis</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAppliedValueImpl#getApplicableDate <em>Applicable Date</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAppliedValueImpl#getFixedUntilDate <em>Fixed Until Date</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAppliedValueImpl#getCategory <em>Category</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAppliedValueImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAppliedValueImpl#getArithmeticOperator <em>Arithmetic Operator</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAppliedValueImpl#getComponents <em>Components</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAppliedValueImpl#getHasExternalReference <em>Has External Reference</em>}</li>
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
		return Ifc4x3Package.eINSTANCE.getIfcAppliedValue();
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
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcAppliedValue_Name(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcAppliedValue_Name(), newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetName() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcAppliedValue_Name());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetName() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcAppliedValue_Name());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDescription() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcAppliedValue_Description(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescription(String newDescription) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcAppliedValue_Description(), newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDescription() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcAppliedValue_Description());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDescription() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcAppliedValue_Description());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcAppliedValueSelect getAppliedValue() {
		return (IfcAppliedValueSelect) eGet(Ifc4x3Package.eINSTANCE.getIfcAppliedValue_AppliedValue(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAppliedValue(IfcAppliedValueSelect newAppliedValue) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcAppliedValue_AppliedValue(), newAppliedValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetAppliedValue() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcAppliedValue_AppliedValue());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetAppliedValue() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcAppliedValue_AppliedValue());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMeasureWithUnit getUnitBasis() {
		return (IfcMeasureWithUnit) eGet(Ifc4x3Package.eINSTANCE.getIfcAppliedValue_UnitBasis(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUnitBasis(IfcMeasureWithUnit newUnitBasis) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcAppliedValue_UnitBasis(), newUnitBasis);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetUnitBasis() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcAppliedValue_UnitBasis());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetUnitBasis() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcAppliedValue_UnitBasis());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getApplicableDate() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcAppliedValue_ApplicableDate(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setApplicableDate(String newApplicableDate) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcAppliedValue_ApplicableDate(), newApplicableDate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetApplicableDate() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcAppliedValue_ApplicableDate());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetApplicableDate() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcAppliedValue_ApplicableDate());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFixedUntilDate() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcAppliedValue_FixedUntilDate(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFixedUntilDate(String newFixedUntilDate) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcAppliedValue_FixedUntilDate(), newFixedUntilDate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetFixedUntilDate() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcAppliedValue_FixedUntilDate());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetFixedUntilDate() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcAppliedValue_FixedUntilDate());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCategory() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcAppliedValue_Category(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCategory(String newCategory) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcAppliedValue_Category(), newCategory);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCategory() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcAppliedValue_Category());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCategory() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcAppliedValue_Category());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCondition() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcAppliedValue_Condition(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCondition(String newCondition) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcAppliedValue_Condition(), newCondition);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCondition() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcAppliedValue_Condition());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCondition() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcAppliedValue_Condition());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcArithmeticOperatorEnum getArithmeticOperator() {
		return (IfcArithmeticOperatorEnum) eGet(Ifc4x3Package.eINSTANCE.getIfcAppliedValue_ArithmeticOperator(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setArithmeticOperator(IfcArithmeticOperatorEnum newArithmeticOperator) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcAppliedValue_ArithmeticOperator(), newArithmeticOperator);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetArithmeticOperator() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcAppliedValue_ArithmeticOperator());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetArithmeticOperator() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcAppliedValue_ArithmeticOperator());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcAppliedValue> getComponents() {
		return (EList<IfcAppliedValue>) eGet(Ifc4x3Package.eINSTANCE.getIfcAppliedValue_Components(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetComponents() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcAppliedValue_Components());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetComponents() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcAppliedValue_Components());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcExternalReferenceRelationship> getHasExternalReference() {
		return (EList<IfcExternalReferenceRelationship>) eGet(
				Ifc4x3Package.eINSTANCE.getIfcAppliedValue_HasExternalReference(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetHasExternalReference() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcAppliedValue_HasExternalReference());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetHasExternalReference() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcAppliedValue_HasExternalReference());
	}

} //IfcAppliedValueImpl
