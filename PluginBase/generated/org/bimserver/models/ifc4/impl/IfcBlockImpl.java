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
import org.bimserver.models.ifc4.IfcBlock;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Block</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBlockImpl#getXLength <em>XLength</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBlockImpl#getXLengthAsString <em>XLength As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBlockImpl#getYLength <em>YLength</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBlockImpl#getYLengthAsString <em>YLength As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBlockImpl#getZLength <em>ZLength</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBlockImpl#getZLengthAsString <em>ZLength As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcBlockImpl extends IfcCsgPrimitive3DImpl implements IfcBlock {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcBlockImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_BLOCK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getXLength() {
		return (Double) eGet(Ifc4Package.Literals.IFC_BLOCK__XLENGTH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setXLength(double newXLength) {
		eSet(Ifc4Package.Literals.IFC_BLOCK__XLENGTH, newXLength);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getXLengthAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_BLOCK__XLENGTH_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setXLengthAsString(String newXLengthAsString) {
		eSet(Ifc4Package.Literals.IFC_BLOCK__XLENGTH_AS_STRING, newXLengthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getYLength() {
		return (Double) eGet(Ifc4Package.Literals.IFC_BLOCK__YLENGTH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setYLength(double newYLength) {
		eSet(Ifc4Package.Literals.IFC_BLOCK__YLENGTH, newYLength);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getYLengthAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_BLOCK__YLENGTH_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setYLengthAsString(String newYLengthAsString) {
		eSet(Ifc4Package.Literals.IFC_BLOCK__YLENGTH_AS_STRING, newYLengthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getZLength() {
		return (Double) eGet(Ifc4Package.Literals.IFC_BLOCK__ZLENGTH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setZLength(double newZLength) {
		eSet(Ifc4Package.Literals.IFC_BLOCK__ZLENGTH, newZLength);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getZLengthAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_BLOCK__ZLENGTH_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setZLengthAsString(String newZLengthAsString) {
		eSet(Ifc4Package.Literals.IFC_BLOCK__ZLENGTH_AS_STRING, newZLengthAsString);
	}

} //IfcBlockImpl
