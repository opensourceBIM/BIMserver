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
import org.bimserver.models.ifc4.IfcQuantityTime;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Quantity Time</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcQuantityTimeImpl#getTimeValue <em>Time Value</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcQuantityTimeImpl#getTimeValueAsString <em>Time Value As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcQuantityTimeImpl#getFormula <em>Formula</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcQuantityTimeImpl extends IfcPhysicalSimpleQuantityImpl implements IfcQuantityTime {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcQuantityTimeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_QUANTITY_TIME;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getTimeValue() {
		return (Double) eGet(Ifc4Package.Literals.IFC_QUANTITY_TIME__TIME_VALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTimeValue(double newTimeValue) {
		eSet(Ifc4Package.Literals.IFC_QUANTITY_TIME__TIME_VALUE, newTimeValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTimeValueAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_QUANTITY_TIME__TIME_VALUE_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTimeValueAsString(String newTimeValueAsString) {
		eSet(Ifc4Package.Literals.IFC_QUANTITY_TIME__TIME_VALUE_AS_STRING, newTimeValueAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFormula() {
		return (String) eGet(Ifc4Package.Literals.IFC_QUANTITY_TIME__FORMULA, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFormula(String newFormula) {
		eSet(Ifc4Package.Literals.IFC_QUANTITY_TIME__FORMULA, newFormula);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetFormula() {
		eUnset(Ifc4Package.Literals.IFC_QUANTITY_TIME__FORMULA);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetFormula() {
		return eIsSet(Ifc4Package.Literals.IFC_QUANTITY_TIME__FORMULA);
	}

} //IfcQuantityTimeImpl
