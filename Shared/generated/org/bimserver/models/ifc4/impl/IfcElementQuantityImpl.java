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
import org.bimserver.models.ifc4.IfcElementQuantity;
import org.bimserver.models.ifc4.IfcPhysicalQuantity;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Element Quantity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcElementQuantityImpl#getMethodOfMeasurement <em>Method Of Measurement</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcElementQuantityImpl#getQuantities <em>Quantities</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcElementQuantityImpl extends IfcQuantitySetImpl implements IfcElementQuantity {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcElementQuantityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_ELEMENT_QUANTITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMethodOfMeasurement() {
		return (String) eGet(Ifc4Package.Literals.IFC_ELEMENT_QUANTITY__METHOD_OF_MEASUREMENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMethodOfMeasurement(String newMethodOfMeasurement) {
		eSet(Ifc4Package.Literals.IFC_ELEMENT_QUANTITY__METHOD_OF_MEASUREMENT, newMethodOfMeasurement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMethodOfMeasurement() {
		eUnset(Ifc4Package.Literals.IFC_ELEMENT_QUANTITY__METHOD_OF_MEASUREMENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMethodOfMeasurement() {
		return eIsSet(Ifc4Package.Literals.IFC_ELEMENT_QUANTITY__METHOD_OF_MEASUREMENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcPhysicalQuantity> getQuantities() {
		return (EList<IfcPhysicalQuantity>) eGet(Ifc4Package.Literals.IFC_ELEMENT_QUANTITY__QUANTITIES, true);
	}

} //IfcElementQuantityImpl
