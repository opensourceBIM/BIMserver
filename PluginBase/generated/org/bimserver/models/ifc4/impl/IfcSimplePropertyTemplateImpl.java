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
import org.bimserver.models.ifc4.IfcPropertyEnumeration;
import org.bimserver.models.ifc4.IfcSimplePropertyTemplate;
import org.bimserver.models.ifc4.IfcSimplePropertyTemplateTypeEnum;
import org.bimserver.models.ifc4.IfcStateEnum;
import org.bimserver.models.ifc4.IfcUnit;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Simple Property Template</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcSimplePropertyTemplateImpl#getTemplateType <em>Template Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcSimplePropertyTemplateImpl#getPrimaryMeasureType <em>Primary Measure Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcSimplePropertyTemplateImpl#getSecondaryMeasureType <em>Secondary Measure Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcSimplePropertyTemplateImpl#getEnumerators <em>Enumerators</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcSimplePropertyTemplateImpl#getPrimaryUnit <em>Primary Unit</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcSimplePropertyTemplateImpl#getSecondaryUnit <em>Secondary Unit</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcSimplePropertyTemplateImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcSimplePropertyTemplateImpl#getAccessState <em>Access State</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcSimplePropertyTemplateImpl extends IfcPropertyTemplateImpl implements IfcSimplePropertyTemplate {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcSimplePropertyTemplateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_SIMPLE_PROPERTY_TEMPLATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSimplePropertyTemplateTypeEnum getTemplateType() {
		return (IfcSimplePropertyTemplateTypeEnum) eGet(Ifc4Package.Literals.IFC_SIMPLE_PROPERTY_TEMPLATE__TEMPLATE_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTemplateType(IfcSimplePropertyTemplateTypeEnum newTemplateType) {
		eSet(Ifc4Package.Literals.IFC_SIMPLE_PROPERTY_TEMPLATE__TEMPLATE_TYPE, newTemplateType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTemplateType() {
		eUnset(Ifc4Package.Literals.IFC_SIMPLE_PROPERTY_TEMPLATE__TEMPLATE_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTemplateType() {
		return eIsSet(Ifc4Package.Literals.IFC_SIMPLE_PROPERTY_TEMPLATE__TEMPLATE_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPrimaryMeasureType() {
		return (String) eGet(Ifc4Package.Literals.IFC_SIMPLE_PROPERTY_TEMPLATE__PRIMARY_MEASURE_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPrimaryMeasureType(String newPrimaryMeasureType) {
		eSet(Ifc4Package.Literals.IFC_SIMPLE_PROPERTY_TEMPLATE__PRIMARY_MEASURE_TYPE, newPrimaryMeasureType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPrimaryMeasureType() {
		eUnset(Ifc4Package.Literals.IFC_SIMPLE_PROPERTY_TEMPLATE__PRIMARY_MEASURE_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPrimaryMeasureType() {
		return eIsSet(Ifc4Package.Literals.IFC_SIMPLE_PROPERTY_TEMPLATE__PRIMARY_MEASURE_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSecondaryMeasureType() {
		return (String) eGet(Ifc4Package.Literals.IFC_SIMPLE_PROPERTY_TEMPLATE__SECONDARY_MEASURE_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSecondaryMeasureType(String newSecondaryMeasureType) {
		eSet(Ifc4Package.Literals.IFC_SIMPLE_PROPERTY_TEMPLATE__SECONDARY_MEASURE_TYPE, newSecondaryMeasureType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetSecondaryMeasureType() {
		eUnset(Ifc4Package.Literals.IFC_SIMPLE_PROPERTY_TEMPLATE__SECONDARY_MEASURE_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetSecondaryMeasureType() {
		return eIsSet(Ifc4Package.Literals.IFC_SIMPLE_PROPERTY_TEMPLATE__SECONDARY_MEASURE_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPropertyEnumeration getEnumerators() {
		return (IfcPropertyEnumeration) eGet(Ifc4Package.Literals.IFC_SIMPLE_PROPERTY_TEMPLATE__ENUMERATORS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEnumerators(IfcPropertyEnumeration newEnumerators) {
		eSet(Ifc4Package.Literals.IFC_SIMPLE_PROPERTY_TEMPLATE__ENUMERATORS, newEnumerators);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetEnumerators() {
		eUnset(Ifc4Package.Literals.IFC_SIMPLE_PROPERTY_TEMPLATE__ENUMERATORS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetEnumerators() {
		return eIsSet(Ifc4Package.Literals.IFC_SIMPLE_PROPERTY_TEMPLATE__ENUMERATORS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcUnit getPrimaryUnit() {
		return (IfcUnit) eGet(Ifc4Package.Literals.IFC_SIMPLE_PROPERTY_TEMPLATE__PRIMARY_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPrimaryUnit(IfcUnit newPrimaryUnit) {
		eSet(Ifc4Package.Literals.IFC_SIMPLE_PROPERTY_TEMPLATE__PRIMARY_UNIT, newPrimaryUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPrimaryUnit() {
		eUnset(Ifc4Package.Literals.IFC_SIMPLE_PROPERTY_TEMPLATE__PRIMARY_UNIT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPrimaryUnit() {
		return eIsSet(Ifc4Package.Literals.IFC_SIMPLE_PROPERTY_TEMPLATE__PRIMARY_UNIT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcUnit getSecondaryUnit() {
		return (IfcUnit) eGet(Ifc4Package.Literals.IFC_SIMPLE_PROPERTY_TEMPLATE__SECONDARY_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSecondaryUnit(IfcUnit newSecondaryUnit) {
		eSet(Ifc4Package.Literals.IFC_SIMPLE_PROPERTY_TEMPLATE__SECONDARY_UNIT, newSecondaryUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetSecondaryUnit() {
		eUnset(Ifc4Package.Literals.IFC_SIMPLE_PROPERTY_TEMPLATE__SECONDARY_UNIT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetSecondaryUnit() {
		return eIsSet(Ifc4Package.Literals.IFC_SIMPLE_PROPERTY_TEMPLATE__SECONDARY_UNIT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getExpression() {
		return (String) eGet(Ifc4Package.Literals.IFC_SIMPLE_PROPERTY_TEMPLATE__EXPRESSION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setExpression(String newExpression) {
		eSet(Ifc4Package.Literals.IFC_SIMPLE_PROPERTY_TEMPLATE__EXPRESSION, newExpression);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetExpression() {
		eUnset(Ifc4Package.Literals.IFC_SIMPLE_PROPERTY_TEMPLATE__EXPRESSION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetExpression() {
		return eIsSet(Ifc4Package.Literals.IFC_SIMPLE_PROPERTY_TEMPLATE__EXPRESSION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcStateEnum getAccessState() {
		return (IfcStateEnum) eGet(Ifc4Package.Literals.IFC_SIMPLE_PROPERTY_TEMPLATE__ACCESS_STATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAccessState(IfcStateEnum newAccessState) {
		eSet(Ifc4Package.Literals.IFC_SIMPLE_PROPERTY_TEMPLATE__ACCESS_STATE, newAccessState);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetAccessState() {
		eUnset(Ifc4Package.Literals.IFC_SIMPLE_PROPERTY_TEMPLATE__ACCESS_STATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetAccessState() {
		return eIsSet(Ifc4Package.Literals.IFC_SIMPLE_PROPERTY_TEMPLATE__ACCESS_STATE);
	}

} //IfcSimplePropertyTemplateImpl
