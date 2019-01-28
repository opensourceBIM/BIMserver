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
import org.bimserver.models.ifc2x3tc1.IfcPhysicalComplexQuantity;
import org.bimserver.models.ifc2x3tc1.IfcPhysicalQuantity;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Physical Complex Quantity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcPhysicalComplexQuantityImpl#getHasQuantities <em>Has Quantities</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcPhysicalComplexQuantityImpl#getDiscrimination <em>Discrimination</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcPhysicalComplexQuantityImpl#getQuality <em>Quality</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcPhysicalComplexQuantityImpl#getUsage <em>Usage</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcPhysicalComplexQuantityImpl extends IfcPhysicalQuantityImpl implements IfcPhysicalComplexQuantity {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcPhysicalComplexQuantityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_PHYSICAL_COMPLEX_QUANTITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcPhysicalQuantity> getHasQuantities() {
		return (EList<IfcPhysicalQuantity>) eGet(
				Ifc2x3tc1Package.Literals.IFC_PHYSICAL_COMPLEX_QUANTITY__HAS_QUANTITIES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDiscrimination() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_PHYSICAL_COMPLEX_QUANTITY__DISCRIMINATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDiscrimination(String newDiscrimination) {
		eSet(Ifc2x3tc1Package.Literals.IFC_PHYSICAL_COMPLEX_QUANTITY__DISCRIMINATION, newDiscrimination);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getQuality() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_PHYSICAL_COMPLEX_QUANTITY__QUALITY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQuality(String newQuality) {
		eSet(Ifc2x3tc1Package.Literals.IFC_PHYSICAL_COMPLEX_QUANTITY__QUALITY, newQuality);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetQuality() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_PHYSICAL_COMPLEX_QUANTITY__QUALITY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetQuality() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_PHYSICAL_COMPLEX_QUANTITY__QUALITY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUsage() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_PHYSICAL_COMPLEX_QUANTITY__USAGE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsage(String newUsage) {
		eSet(Ifc2x3tc1Package.Literals.IFC_PHYSICAL_COMPLEX_QUANTITY__USAGE, newUsage);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUsage() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_PHYSICAL_COMPLEX_QUANTITY__USAGE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUsage() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_PHYSICAL_COMPLEX_QUANTITY__USAGE);
	}

} //IfcPhysicalComplexQuantityImpl
