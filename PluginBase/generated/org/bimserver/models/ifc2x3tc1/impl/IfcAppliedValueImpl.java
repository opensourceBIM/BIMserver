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

import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.IfcAppliedValue;
import org.bimserver.models.ifc2x3tc1.IfcAppliedValueRelationship;
import org.bimserver.models.ifc2x3tc1.IfcAppliedValueSelect;
import org.bimserver.models.ifc2x3tc1.IfcDateTimeSelect;
import org.bimserver.models.ifc2x3tc1.IfcMeasureWithUnit;
import org.bimserver.models.ifc2x3tc1.IfcReferencesValueDocument;
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
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcAppliedValueImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcAppliedValueImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcAppliedValueImpl#getAppliedValue <em>Applied Value</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcAppliedValueImpl#getUnitBasis <em>Unit Basis</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcAppliedValueImpl#getApplicableDate <em>Applicable Date</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcAppliedValueImpl#getFixedUntilDate <em>Fixed Until Date</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcAppliedValueImpl#getValuesReferenced <em>Values Referenced</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcAppliedValueImpl#getValueOfComponents <em>Value Of Components</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcAppliedValueImpl#getIsComponentIn <em>Is Component In</em>}</li>
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
		return Ifc2x3tc1Package.Literals.IFC_APPLIED_VALUE;
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
	public String getName() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_APPLIED_VALUE__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(Ifc2x3tc1Package.Literals.IFC_APPLIED_VALUE__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetName() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_APPLIED_VALUE__NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetName() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_APPLIED_VALUE__NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_APPLIED_VALUE__DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		eSet(Ifc2x3tc1Package.Literals.IFC_APPLIED_VALUE__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDescription() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_APPLIED_VALUE__DESCRIPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDescription() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_APPLIED_VALUE__DESCRIPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAppliedValueSelect getAppliedValue() {
		return (IfcAppliedValueSelect) eGet(Ifc2x3tc1Package.Literals.IFC_APPLIED_VALUE__APPLIED_VALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAppliedValue(IfcAppliedValueSelect newAppliedValue) {
		eSet(Ifc2x3tc1Package.Literals.IFC_APPLIED_VALUE__APPLIED_VALUE, newAppliedValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetAppliedValue() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_APPLIED_VALUE__APPLIED_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetAppliedValue() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_APPLIED_VALUE__APPLIED_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMeasureWithUnit getUnitBasis() {
		return (IfcMeasureWithUnit) eGet(Ifc2x3tc1Package.Literals.IFC_APPLIED_VALUE__UNIT_BASIS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitBasis(IfcMeasureWithUnit newUnitBasis) {
		eSet(Ifc2x3tc1Package.Literals.IFC_APPLIED_VALUE__UNIT_BASIS, newUnitBasis);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUnitBasis() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_APPLIED_VALUE__UNIT_BASIS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUnitBasis() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_APPLIED_VALUE__UNIT_BASIS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDateTimeSelect getApplicableDate() {
		return (IfcDateTimeSelect) eGet(Ifc2x3tc1Package.Literals.IFC_APPLIED_VALUE__APPLICABLE_DATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setApplicableDate(IfcDateTimeSelect newApplicableDate) {
		eSet(Ifc2x3tc1Package.Literals.IFC_APPLIED_VALUE__APPLICABLE_DATE, newApplicableDate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetApplicableDate() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_APPLIED_VALUE__APPLICABLE_DATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetApplicableDate() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_APPLIED_VALUE__APPLICABLE_DATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDateTimeSelect getFixedUntilDate() {
		return (IfcDateTimeSelect) eGet(Ifc2x3tc1Package.Literals.IFC_APPLIED_VALUE__FIXED_UNTIL_DATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFixedUntilDate(IfcDateTimeSelect newFixedUntilDate) {
		eSet(Ifc2x3tc1Package.Literals.IFC_APPLIED_VALUE__FIXED_UNTIL_DATE, newFixedUntilDate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFixedUntilDate() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_APPLIED_VALUE__FIXED_UNTIL_DATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFixedUntilDate() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_APPLIED_VALUE__FIXED_UNTIL_DATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcReferencesValueDocument> getValuesReferenced() {
		return (EList<IfcReferencesValueDocument>) eGet(Ifc2x3tc1Package.Literals.IFC_APPLIED_VALUE__VALUES_REFERENCED,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetValuesReferenced() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_APPLIED_VALUE__VALUES_REFERENCED);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetValuesReferenced() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_APPLIED_VALUE__VALUES_REFERENCED);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcAppliedValueRelationship> getValueOfComponents() {
		return (EList<IfcAppliedValueRelationship>) eGet(
				Ifc2x3tc1Package.Literals.IFC_APPLIED_VALUE__VALUE_OF_COMPONENTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetValueOfComponents() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_APPLIED_VALUE__VALUE_OF_COMPONENTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetValueOfComponents() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_APPLIED_VALUE__VALUE_OF_COMPONENTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcAppliedValueRelationship> getIsComponentIn() {
		return (EList<IfcAppliedValueRelationship>) eGet(Ifc2x3tc1Package.Literals.IFC_APPLIED_VALUE__IS_COMPONENT_IN,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIsComponentIn() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_APPLIED_VALUE__IS_COMPONENT_IN);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIsComponentIn() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_APPLIED_VALUE__IS_COMPONENT_IN);
	}

} //IfcAppliedValueImpl
