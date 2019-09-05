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
import org.bimserver.models.ifc4.IfcPlanarExtent;
import org.bimserver.models.ifc4.IfcTextLiteralWithExtent;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Text Literal With Extent</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTextLiteralWithExtentImpl#getExtent <em>Extent</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTextLiteralWithExtentImpl#getBoxAlignment <em>Box Alignment</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcTextLiteralWithExtentImpl extends IfcTextLiteralImpl implements IfcTextLiteralWithExtent {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcTextLiteralWithExtentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_TEXT_LITERAL_WITH_EXTENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPlanarExtent getExtent() {
		return (IfcPlanarExtent) eGet(Ifc4Package.Literals.IFC_TEXT_LITERAL_WITH_EXTENT__EXTENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setExtent(IfcPlanarExtent newExtent) {
		eSet(Ifc4Package.Literals.IFC_TEXT_LITERAL_WITH_EXTENT__EXTENT, newExtent);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getBoxAlignment() {
		return (String) eGet(Ifc4Package.Literals.IFC_TEXT_LITERAL_WITH_EXTENT__BOX_ALIGNMENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBoxAlignment(String newBoxAlignment) {
		eSet(Ifc4Package.Literals.IFC_TEXT_LITERAL_WITH_EXTENT__BOX_ALIGNMENT, newBoxAlignment);
	}

} //IfcTextLiteralWithExtentImpl
