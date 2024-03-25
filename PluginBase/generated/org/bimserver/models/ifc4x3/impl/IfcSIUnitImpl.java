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
package org.bimserver.models.ifc4x3.impl;

import org.bimserver.models.ifc4x3.Ifc4x3Package;
import org.bimserver.models.ifc4x3.IfcSIPrefix;
import org.bimserver.models.ifc4x3.IfcSIUnit;
import org.bimserver.models.ifc4x3.IfcSIUnitName;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc SI Unit</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcSIUnitImpl#getPrefix <em>Prefix</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcSIUnitImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcSIUnitImpl extends IfcNamedUnitImpl implements IfcSIUnit {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcSIUnitImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.Literals.IFC_SI_UNIT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSIPrefix getPrefix() {
		return (IfcSIPrefix) eGet(Ifc4x3Package.Literals.IFC_SI_UNIT__PREFIX, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPrefix(IfcSIPrefix newPrefix) {
		eSet(Ifc4x3Package.Literals.IFC_SI_UNIT__PREFIX, newPrefix);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPrefix() {
		eUnset(Ifc4x3Package.Literals.IFC_SI_UNIT__PREFIX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPrefix() {
		return eIsSet(Ifc4x3Package.Literals.IFC_SI_UNIT__PREFIX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSIUnitName getName() {
		return (IfcSIUnitName) eGet(Ifc4x3Package.Literals.IFC_SI_UNIT__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(IfcSIUnitName newName) {
		eSet(Ifc4x3Package.Literals.IFC_SI_UNIT__NAME, newName);
	}

} //IfcSIUnitImpl
