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
import org.bimserver.models.ifc2x3tc1.IfcArithmeticOperatorEnum;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Applied Value Relationship</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcAppliedValueRelationshipImpl#getComponentOfTotal <em>Component Of Total</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcAppliedValueRelationshipImpl#getComponents <em>Components</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcAppliedValueRelationshipImpl#getArithmeticOperator <em>Arithmetic Operator</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcAppliedValueRelationshipImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcAppliedValueRelationshipImpl#getDescription <em>Description</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcAppliedValueRelationshipImpl extends IdEObjectImpl implements IfcAppliedValueRelationship {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcAppliedValueRelationshipImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_APPLIED_VALUE_RELATIONSHIP;
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
	public IfcAppliedValue getComponentOfTotal() {
		return (IfcAppliedValue) eGet(Ifc2x3tc1Package.Literals.IFC_APPLIED_VALUE_RELATIONSHIP__COMPONENT_OF_TOTAL,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComponentOfTotal(IfcAppliedValue newComponentOfTotal) {
		eSet(Ifc2x3tc1Package.Literals.IFC_APPLIED_VALUE_RELATIONSHIP__COMPONENT_OF_TOTAL, newComponentOfTotal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcAppliedValue> getComponents() {
		return (EList<IfcAppliedValue>) eGet(Ifc2x3tc1Package.Literals.IFC_APPLIED_VALUE_RELATIONSHIP__COMPONENTS,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcArithmeticOperatorEnum getArithmeticOperator() {
		return (IfcArithmeticOperatorEnum) eGet(
				Ifc2x3tc1Package.Literals.IFC_APPLIED_VALUE_RELATIONSHIP__ARITHMETIC_OPERATOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArithmeticOperator(IfcArithmeticOperatorEnum newArithmeticOperator) {
		eSet(Ifc2x3tc1Package.Literals.IFC_APPLIED_VALUE_RELATIONSHIP__ARITHMETIC_OPERATOR, newArithmeticOperator);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_APPLIED_VALUE_RELATIONSHIP__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(Ifc2x3tc1Package.Literals.IFC_APPLIED_VALUE_RELATIONSHIP__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetName() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_APPLIED_VALUE_RELATIONSHIP__NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetName() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_APPLIED_VALUE_RELATIONSHIP__NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_APPLIED_VALUE_RELATIONSHIP__DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		eSet(Ifc2x3tc1Package.Literals.IFC_APPLIED_VALUE_RELATIONSHIP__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDescription() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_APPLIED_VALUE_RELATIONSHIP__DESCRIPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDescription() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_APPLIED_VALUE_RELATIONSHIP__DESCRIPTION);
	}

} //IfcAppliedValueRelationshipImpl
