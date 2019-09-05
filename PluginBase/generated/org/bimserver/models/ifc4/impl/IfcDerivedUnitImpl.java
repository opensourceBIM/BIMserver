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
import org.bimserver.models.ifc4.IfcDerivedUnit;
import org.bimserver.models.ifc4.IfcDerivedUnitElement;
import org.bimserver.models.ifc4.IfcDerivedUnitEnum;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Derived Unit</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDerivedUnitImpl#getElements <em>Elements</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDerivedUnitImpl#getUnitType <em>Unit Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDerivedUnitImpl#getUserDefinedType <em>User Defined Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcDerivedUnitImpl extends IdEObjectImpl implements IfcDerivedUnit {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcDerivedUnitImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_DERIVED_UNIT;
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
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcDerivedUnitElement> getElements() {
		return (EList<IfcDerivedUnitElement>) eGet(Ifc4Package.Literals.IFC_DERIVED_UNIT__ELEMENTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDerivedUnitEnum getUnitType() {
		return (IfcDerivedUnitEnum) eGet(Ifc4Package.Literals.IFC_DERIVED_UNIT__UNIT_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUnitType(IfcDerivedUnitEnum newUnitType) {
		eSet(Ifc4Package.Literals.IFC_DERIVED_UNIT__UNIT_TYPE, newUnitType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getUserDefinedType() {
		return (String) eGet(Ifc4Package.Literals.IFC_DERIVED_UNIT__USER_DEFINED_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUserDefinedType(String newUserDefinedType) {
		eSet(Ifc4Package.Literals.IFC_DERIVED_UNIT__USER_DEFINED_TYPE, newUserDefinedType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetUserDefinedType() {
		eUnset(Ifc4Package.Literals.IFC_DERIVED_UNIT__USER_DEFINED_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetUserDefinedType() {
		return eIsSet(Ifc4Package.Literals.IFC_DERIVED_UNIT__USER_DEFINED_TYPE);
	}

} //IfcDerivedUnitImpl
