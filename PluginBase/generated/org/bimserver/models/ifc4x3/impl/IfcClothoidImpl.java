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
import org.bimserver.models.ifc4x3.IfcClothoid;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Clothoid</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcClothoidImpl#getClothoidConstant <em>Clothoid Constant</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcClothoidImpl#getClothoidConstantAsString <em>Clothoid Constant As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcClothoidImpl extends IfcSpiralImpl implements IfcClothoid {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcClothoidImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.Literals.IFC_CLOTHOID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getClothoidConstant() {
		return (Double) eGet(Ifc4x3Package.Literals.IFC_CLOTHOID__CLOTHOID_CONSTANT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setClothoidConstant(double newClothoidConstant) {
		eSet(Ifc4x3Package.Literals.IFC_CLOTHOID__CLOTHOID_CONSTANT, newClothoidConstant);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getClothoidConstantAsString() {
		return (String) eGet(Ifc4x3Package.Literals.IFC_CLOTHOID__CLOTHOID_CONSTANT_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setClothoidConstantAsString(String newClothoidConstantAsString) {
		eSet(Ifc4x3Package.Literals.IFC_CLOTHOID__CLOTHOID_CONSTANT_AS_STRING, newClothoidConstantAsString);
	}

} //IfcClothoidImpl
