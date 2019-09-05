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
import org.bimserver.models.ifc4.IfcQuantityCount;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Quantity Count</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcQuantityCountImpl#getCountValue <em>Count Value</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcQuantityCountImpl#getCountValueAsString <em>Count Value As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcQuantityCountImpl#getFormula <em>Formula</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcQuantityCountImpl extends IfcPhysicalSimpleQuantityImpl implements IfcQuantityCount {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcQuantityCountImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_QUANTITY_COUNT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getCountValue() {
		return (Double) eGet(Ifc4Package.Literals.IFC_QUANTITY_COUNT__COUNT_VALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCountValue(double newCountValue) {
		eSet(Ifc4Package.Literals.IFC_QUANTITY_COUNT__COUNT_VALUE, newCountValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCountValueAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_QUANTITY_COUNT__COUNT_VALUE_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCountValueAsString(String newCountValueAsString) {
		eSet(Ifc4Package.Literals.IFC_QUANTITY_COUNT__COUNT_VALUE_AS_STRING, newCountValueAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFormula() {
		return (String) eGet(Ifc4Package.Literals.IFC_QUANTITY_COUNT__FORMULA, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFormula(String newFormula) {
		eSet(Ifc4Package.Literals.IFC_QUANTITY_COUNT__FORMULA, newFormula);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetFormula() {
		eUnset(Ifc4Package.Literals.IFC_QUANTITY_COUNT__FORMULA);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetFormula() {
		return eIsSet(Ifc4Package.Literals.IFC_QUANTITY_COUNT__FORMULA);
	}

} //IfcQuantityCountImpl
