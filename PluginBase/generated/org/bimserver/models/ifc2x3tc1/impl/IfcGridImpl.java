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
import org.bimserver.models.ifc2x3tc1.IfcGrid;
import org.bimserver.models.ifc2x3tc1.IfcGridAxis;
import org.bimserver.models.ifc2x3tc1.IfcRelContainedInSpatialStructure;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Grid</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcGridImpl#getUAxes <em>UAxes</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcGridImpl#getVAxes <em>VAxes</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcGridImpl#getWAxes <em>WAxes</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcGridImpl#getContainedInStructure <em>Contained In Structure</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcGridImpl extends IfcProductImpl implements IfcGrid {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcGridImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_GRID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcGridAxis> getUAxes() {
		return (EList<IfcGridAxis>) eGet(Ifc2x3tc1Package.Literals.IFC_GRID__UAXES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcGridAxis> getVAxes() {
		return (EList<IfcGridAxis>) eGet(Ifc2x3tc1Package.Literals.IFC_GRID__VAXES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcGridAxis> getWAxes() {
		return (EList<IfcGridAxis>) eGet(Ifc2x3tc1Package.Literals.IFC_GRID__WAXES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetWAxes() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_GRID__WAXES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetWAxes() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_GRID__WAXES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelContainedInSpatialStructure> getContainedInStructure() {
		return (EList<IfcRelContainedInSpatialStructure>) eGet(
				Ifc2x3tc1Package.Literals.IFC_GRID__CONTAINED_IN_STRUCTURE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetContainedInStructure() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_GRID__CONTAINED_IN_STRUCTURE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetContainedInStructure() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_GRID__CONTAINED_IN_STRUCTURE);
	}

} //IfcGridImpl
