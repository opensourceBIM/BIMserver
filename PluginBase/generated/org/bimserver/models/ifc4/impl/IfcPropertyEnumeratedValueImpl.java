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
import org.bimserver.models.ifc4.IfcPropertyEnumeratedValue;
import org.bimserver.models.ifc4.IfcPropertyEnumeration;
import org.bimserver.models.ifc4.IfcValue;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Property Enumerated Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcPropertyEnumeratedValueImpl#getEnumerationValues <em>Enumeration Values</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcPropertyEnumeratedValueImpl#getEnumerationReference <em>Enumeration Reference</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcPropertyEnumeratedValueImpl extends IfcSimplePropertyImpl implements IfcPropertyEnumeratedValue {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcPropertyEnumeratedValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_PROPERTY_ENUMERATED_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcValue> getEnumerationValues() {
		return (EList<IfcValue>) eGet(Ifc4Package.Literals.IFC_PROPERTY_ENUMERATED_VALUE__ENUMERATION_VALUES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetEnumerationValues() {
		eUnset(Ifc4Package.Literals.IFC_PROPERTY_ENUMERATED_VALUE__ENUMERATION_VALUES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetEnumerationValues() {
		return eIsSet(Ifc4Package.Literals.IFC_PROPERTY_ENUMERATED_VALUE__ENUMERATION_VALUES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPropertyEnumeration getEnumerationReference() {
		return (IfcPropertyEnumeration) eGet(Ifc4Package.Literals.IFC_PROPERTY_ENUMERATED_VALUE__ENUMERATION_REFERENCE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEnumerationReference(IfcPropertyEnumeration newEnumerationReference) {
		eSet(Ifc4Package.Literals.IFC_PROPERTY_ENUMERATED_VALUE__ENUMERATION_REFERENCE, newEnumerationReference);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetEnumerationReference() {
		eUnset(Ifc4Package.Literals.IFC_PROPERTY_ENUMERATED_VALUE__ENUMERATION_REFERENCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetEnumerationReference() {
		return eIsSet(Ifc4Package.Literals.IFC_PROPERTY_ENUMERATED_VALUE__ENUMERATION_REFERENCE);
	}

} //IfcPropertyEnumeratedValueImpl
