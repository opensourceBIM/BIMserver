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

import org.bimserver.models.ifc4.Ifc4Package;
import org.bimserver.models.ifc4.IfcCurveInterpolationEnum;
import org.bimserver.models.ifc4.IfcPropertyTableValue;
import org.bimserver.models.ifc4.IfcUnit;
import org.bimserver.models.ifc4.IfcValue;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Property Table Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcPropertyTableValueImpl#getDefiningValues <em>Defining Values</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcPropertyTableValueImpl#getDefinedValues <em>Defined Values</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcPropertyTableValueImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcPropertyTableValueImpl#getDefiningUnit <em>Defining Unit</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcPropertyTableValueImpl#getDefinedUnit <em>Defined Unit</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcPropertyTableValueImpl#getCurveInterpolation <em>Curve Interpolation</em>}</li>
 * </ul>
 * </p>
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
		return Ifc4Package.Literals.IFC_PROPERTY_TABLE_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcValue> getDefiningValues() {
		return (EList<IfcValue>) eGet(Ifc4Package.Literals.IFC_PROPERTY_TABLE_VALUE__DEFINING_VALUES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDefiningValues() {
		eUnset(Ifc4Package.Literals.IFC_PROPERTY_TABLE_VALUE__DEFINING_VALUES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDefiningValues() {
		return eIsSet(Ifc4Package.Literals.IFC_PROPERTY_TABLE_VALUE__DEFINING_VALUES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcValue> getDefinedValues() {
		return (EList<IfcValue>) eGet(Ifc4Package.Literals.IFC_PROPERTY_TABLE_VALUE__DEFINED_VALUES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDefinedValues() {
		eUnset(Ifc4Package.Literals.IFC_PROPERTY_TABLE_VALUE__DEFINED_VALUES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDefinedValues() {
		return eIsSet(Ifc4Package.Literals.IFC_PROPERTY_TABLE_VALUE__DEFINED_VALUES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExpression() {
		return (String) eGet(Ifc4Package.Literals.IFC_PROPERTY_TABLE_VALUE__EXPRESSION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpression(String newExpression) {
		eSet(Ifc4Package.Literals.IFC_PROPERTY_TABLE_VALUE__EXPRESSION, newExpression);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetExpression() {
		eUnset(Ifc4Package.Literals.IFC_PROPERTY_TABLE_VALUE__EXPRESSION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetExpression() {
		return eIsSet(Ifc4Package.Literals.IFC_PROPERTY_TABLE_VALUE__EXPRESSION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcUnit getDefiningUnit() {
		return (IfcUnit) eGet(Ifc4Package.Literals.IFC_PROPERTY_TABLE_VALUE__DEFINING_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefiningUnit(IfcUnit newDefiningUnit) {
		eSet(Ifc4Package.Literals.IFC_PROPERTY_TABLE_VALUE__DEFINING_UNIT, newDefiningUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDefiningUnit() {
		eUnset(Ifc4Package.Literals.IFC_PROPERTY_TABLE_VALUE__DEFINING_UNIT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDefiningUnit() {
		return eIsSet(Ifc4Package.Literals.IFC_PROPERTY_TABLE_VALUE__DEFINING_UNIT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcUnit getDefinedUnit() {
		return (IfcUnit) eGet(Ifc4Package.Literals.IFC_PROPERTY_TABLE_VALUE__DEFINED_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefinedUnit(IfcUnit newDefinedUnit) {
		eSet(Ifc4Package.Literals.IFC_PROPERTY_TABLE_VALUE__DEFINED_UNIT, newDefinedUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDefinedUnit() {
		eUnset(Ifc4Package.Literals.IFC_PROPERTY_TABLE_VALUE__DEFINED_UNIT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDefinedUnit() {
		return eIsSet(Ifc4Package.Literals.IFC_PROPERTY_TABLE_VALUE__DEFINED_UNIT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCurveInterpolationEnum getCurveInterpolation() {
		return (IfcCurveInterpolationEnum) eGet(Ifc4Package.Literals.IFC_PROPERTY_TABLE_VALUE__CURVE_INTERPOLATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurveInterpolation(IfcCurveInterpolationEnum newCurveInterpolation) {
		eSet(Ifc4Package.Literals.IFC_PROPERTY_TABLE_VALUE__CURVE_INTERPOLATION, newCurveInterpolation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCurveInterpolation() {
		eUnset(Ifc4Package.Literals.IFC_PROPERTY_TABLE_VALUE__CURVE_INTERPOLATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCurveInterpolation() {
		return eIsSet(Ifc4Package.Literals.IFC_PROPERTY_TABLE_VALUE__CURVE_INTERPOLATION);
	}

} //IfcPropertyTableValueImpl
