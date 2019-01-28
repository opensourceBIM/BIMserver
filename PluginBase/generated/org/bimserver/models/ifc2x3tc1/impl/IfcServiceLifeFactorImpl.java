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
import org.bimserver.models.ifc2x3tc1.IfcMeasureValue;
import org.bimserver.models.ifc2x3tc1.IfcServiceLifeFactor;
import org.bimserver.models.ifc2x3tc1.IfcServiceLifeFactorTypeEnum;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Service Life Factor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcServiceLifeFactorImpl#getPredefinedType <em>Predefined Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcServiceLifeFactorImpl#getUpperValue <em>Upper Value</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcServiceLifeFactorImpl#getMostUsedValue <em>Most Used Value</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcServiceLifeFactorImpl#getLowerValue <em>Lower Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcServiceLifeFactorImpl extends IfcPropertySetDefinitionImpl implements IfcServiceLifeFactor {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcServiceLifeFactorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_SERVICE_LIFE_FACTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcServiceLifeFactorTypeEnum getPredefinedType() {
		return (IfcServiceLifeFactorTypeEnum) eGet(Ifc2x3tc1Package.Literals.IFC_SERVICE_LIFE_FACTOR__PREDEFINED_TYPE,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPredefinedType(IfcServiceLifeFactorTypeEnum newPredefinedType) {
		eSet(Ifc2x3tc1Package.Literals.IFC_SERVICE_LIFE_FACTOR__PREDEFINED_TYPE, newPredefinedType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMeasureValue getUpperValue() {
		return (IfcMeasureValue) eGet(Ifc2x3tc1Package.Literals.IFC_SERVICE_LIFE_FACTOR__UPPER_VALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpperValue(IfcMeasureValue newUpperValue) {
		eSet(Ifc2x3tc1Package.Literals.IFC_SERVICE_LIFE_FACTOR__UPPER_VALUE, newUpperValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUpperValue() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_SERVICE_LIFE_FACTOR__UPPER_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUpperValue() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_SERVICE_LIFE_FACTOR__UPPER_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMeasureValue getMostUsedValue() {
		return (IfcMeasureValue) eGet(Ifc2x3tc1Package.Literals.IFC_SERVICE_LIFE_FACTOR__MOST_USED_VALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMostUsedValue(IfcMeasureValue newMostUsedValue) {
		eSet(Ifc2x3tc1Package.Literals.IFC_SERVICE_LIFE_FACTOR__MOST_USED_VALUE, newMostUsedValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMeasureValue getLowerValue() {
		return (IfcMeasureValue) eGet(Ifc2x3tc1Package.Literals.IFC_SERVICE_LIFE_FACTOR__LOWER_VALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLowerValue(IfcMeasureValue newLowerValue) {
		eSet(Ifc2x3tc1Package.Literals.IFC_SERVICE_LIFE_FACTOR__LOWER_VALUE, newLowerValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLowerValue() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_SERVICE_LIFE_FACTOR__LOWER_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLowerValue() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_SERVICE_LIFE_FACTOR__LOWER_VALUE);
	}

} //IfcServiceLifeFactorImpl
