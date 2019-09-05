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
import org.bimserver.models.ifc4.IfcGrid;
import org.bimserver.models.ifc4.IfcGridAxis;
import org.bimserver.models.ifc4.IfcGridTypeEnum;
import org.bimserver.models.ifc4.IfcRelContainedInSpatialStructure;
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
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcGridImpl#getUAxes <em>UAxes</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcGridImpl#getVAxes <em>VAxes</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcGridImpl#getWAxes <em>WAxes</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcGridImpl#getPredefinedType <em>Predefined Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcGridImpl#getContainedInStructure <em>Contained In Structure</em>}</li>
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
		return Ifc4Package.Literals.IFC_GRID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcGridAxis> getUAxes() {
		return (EList<IfcGridAxis>) eGet(Ifc4Package.Literals.IFC_GRID__UAXES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcGridAxis> getVAxes() {
		return (EList<IfcGridAxis>) eGet(Ifc4Package.Literals.IFC_GRID__VAXES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcGridAxis> getWAxes() {
		return (EList<IfcGridAxis>) eGet(Ifc4Package.Literals.IFC_GRID__WAXES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetWAxes() {
		eUnset(Ifc4Package.Literals.IFC_GRID__WAXES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetWAxes() {
		return eIsSet(Ifc4Package.Literals.IFC_GRID__WAXES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcGridTypeEnum getPredefinedType() {
		return (IfcGridTypeEnum) eGet(Ifc4Package.Literals.IFC_GRID__PREDEFINED_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPredefinedType(IfcGridTypeEnum newPredefinedType) {
		eSet(Ifc4Package.Literals.IFC_GRID__PREDEFINED_TYPE, newPredefinedType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPredefinedType() {
		eUnset(Ifc4Package.Literals.IFC_GRID__PREDEFINED_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPredefinedType() {
		return eIsSet(Ifc4Package.Literals.IFC_GRID__PREDEFINED_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelContainedInSpatialStructure> getContainedInStructure() {
		return (EList<IfcRelContainedInSpatialStructure>) eGet(Ifc4Package.Literals.IFC_GRID__CONTAINED_IN_STRUCTURE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetContainedInStructure() {
		eUnset(Ifc4Package.Literals.IFC_GRID__CONTAINED_IN_STRUCTURE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetContainedInStructure() {
		return eIsSet(Ifc4Package.Literals.IFC_GRID__CONTAINED_IN_STRUCTURE);
	}

} //IfcGridImpl
