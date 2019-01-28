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
import org.bimserver.models.ifc2x3tc1.IfcPropertyTableValue;
import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.bimserver.models.ifc2x3tc1.IfcValue;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Property Table Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcPropertyTableValueImpl#getDefiningValues <em>Defining Values</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcPropertyTableValueImpl#getDefinedValues <em>Defined Values</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcPropertyTableValueImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcPropertyTableValueImpl#getDefiningUnit <em>Defining Unit</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcPropertyTableValueImpl#getDefinedUnit <em>Defined Unit</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcPropertyTableValueImpl extends IfcSimplePropertyImpl implements IfcPropertyTableValue {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcPropertyTableValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_PROPERTY_TABLE_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcValue> getDefiningValues() {
		return (EList<IfcValue>) eGet(Ifc2x3tc1Package.Literals.IFC_PROPERTY_TABLE_VALUE__DEFINING_VALUES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcValue> getDefinedValues() {
		return (EList<IfcValue>) eGet(Ifc2x3tc1Package.Literals.IFC_PROPERTY_TABLE_VALUE__DEFINED_VALUES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExpression() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_PROPERTY_TABLE_VALUE__EXPRESSION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpression(String newExpression) {
		eSet(Ifc2x3tc1Package.Literals.IFC_PROPERTY_TABLE_VALUE__EXPRESSION, newExpression);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetExpression() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_PROPERTY_TABLE_VALUE__EXPRESSION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetExpression() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_PROPERTY_TABLE_VALUE__EXPRESSION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcUnit getDefiningUnit() {
		return (IfcUnit) eGet(Ifc2x3tc1Package.Literals.IFC_PROPERTY_TABLE_VALUE__DEFINING_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefiningUnit(IfcUnit newDefiningUnit) {
		eSet(Ifc2x3tc1Package.Literals.IFC_PROPERTY_TABLE_VALUE__DEFINING_UNIT, newDefiningUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDefiningUnit() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_PROPERTY_TABLE_VALUE__DEFINING_UNIT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDefiningUnit() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_PROPERTY_TABLE_VALUE__DEFINING_UNIT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcUnit getDefinedUnit() {
		return (IfcUnit) eGet(Ifc2x3tc1Package.Literals.IFC_PROPERTY_TABLE_VALUE__DEFINED_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefinedUnit(IfcUnit newDefinedUnit) {
		eSet(Ifc2x3tc1Package.Literals.IFC_PROPERTY_TABLE_VALUE__DEFINED_UNIT, newDefinedUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDefinedUnit() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_PROPERTY_TABLE_VALUE__DEFINED_UNIT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDefinedUnit() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_PROPERTY_TABLE_VALUE__DEFINED_UNIT);
	}

} //IfcPropertyTableValueImpl
