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
import org.bimserver.models.ifc2x3tc1.IfcEnvironmentalImpactCategoryEnum;
import org.bimserver.models.ifc2x3tc1.IfcEnvironmentalImpactValue;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Environmental Impact Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcEnvironmentalImpactValueImpl#getImpactType <em>Impact Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcEnvironmentalImpactValueImpl#getCategory <em>Category</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcEnvironmentalImpactValueImpl#getUserDefinedCategory <em>User Defined Category</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcEnvironmentalImpactValueImpl extends IfcAppliedValueImpl implements IfcEnvironmentalImpactValue {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcEnvironmentalImpactValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_ENVIRONMENTAL_IMPACT_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getImpactType() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_ENVIRONMENTAL_IMPACT_VALUE__IMPACT_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImpactType(String newImpactType) {
		eSet(Ifc2x3tc1Package.Literals.IFC_ENVIRONMENTAL_IMPACT_VALUE__IMPACT_TYPE, newImpactType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcEnvironmentalImpactCategoryEnum getCategory() {
		return (IfcEnvironmentalImpactCategoryEnum) eGet(
				Ifc2x3tc1Package.Literals.IFC_ENVIRONMENTAL_IMPACT_VALUE__CATEGORY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCategory(IfcEnvironmentalImpactCategoryEnum newCategory) {
		eSet(Ifc2x3tc1Package.Literals.IFC_ENVIRONMENTAL_IMPACT_VALUE__CATEGORY, newCategory);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUserDefinedCategory() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_ENVIRONMENTAL_IMPACT_VALUE__USER_DEFINED_CATEGORY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserDefinedCategory(String newUserDefinedCategory) {
		eSet(Ifc2x3tc1Package.Literals.IFC_ENVIRONMENTAL_IMPACT_VALUE__USER_DEFINED_CATEGORY, newUserDefinedCategory);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUserDefinedCategory() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_ENVIRONMENTAL_IMPACT_VALUE__USER_DEFINED_CATEGORY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUserDefinedCategory() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_ENVIRONMENTAL_IMPACT_VALUE__USER_DEFINED_CATEGORY);
	}

} //IfcEnvironmentalImpactValueImpl
