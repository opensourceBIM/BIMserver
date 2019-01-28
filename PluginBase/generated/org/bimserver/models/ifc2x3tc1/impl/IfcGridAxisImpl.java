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

import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.IfcCurve;
import org.bimserver.models.ifc2x3tc1.IfcGrid;
import org.bimserver.models.ifc2x3tc1.IfcGridAxis;
import org.bimserver.models.ifc2x3tc1.IfcVirtualGridIntersection;
import org.bimserver.models.ifc2x3tc1.Tristate;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Grid Axis</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcGridAxisImpl#getAxisTag <em>Axis Tag</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcGridAxisImpl#getAxisCurve <em>Axis Curve</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcGridAxisImpl#getSameSense <em>Same Sense</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcGridAxisImpl#getPartOfW <em>Part Of W</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcGridAxisImpl#getPartOfV <em>Part Of V</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcGridAxisImpl#getPartOfU <em>Part Of U</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcGridAxisImpl#getHasIntersections <em>Has Intersections</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcGridAxisImpl extends IdEObjectImpl implements IfcGridAxis {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcGridAxisImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_GRID_AXIS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAxisTag() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_GRID_AXIS__AXIS_TAG, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAxisTag(String newAxisTag) {
		eSet(Ifc2x3tc1Package.Literals.IFC_GRID_AXIS__AXIS_TAG, newAxisTag);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetAxisTag() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_GRID_AXIS__AXIS_TAG);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetAxisTag() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_GRID_AXIS__AXIS_TAG);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCurve getAxisCurve() {
		return (IfcCurve) eGet(Ifc2x3tc1Package.Literals.IFC_GRID_AXIS__AXIS_CURVE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAxisCurve(IfcCurve newAxisCurve) {
		eSet(Ifc2x3tc1Package.Literals.IFC_GRID_AXIS__AXIS_CURVE, newAxisCurve);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tristate getSameSense() {
		return (Tristate) eGet(Ifc2x3tc1Package.Literals.IFC_GRID_AXIS__SAME_SENSE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSameSense(Tristate newSameSense) {
		eSet(Ifc2x3tc1Package.Literals.IFC_GRID_AXIS__SAME_SENSE, newSameSense);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcGrid> getPartOfW() {
		return (EList<IfcGrid>) eGet(Ifc2x3tc1Package.Literals.IFC_GRID_AXIS__PART_OF_W, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPartOfW() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_GRID_AXIS__PART_OF_W);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPartOfW() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_GRID_AXIS__PART_OF_W);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcGrid> getPartOfV() {
		return (EList<IfcGrid>) eGet(Ifc2x3tc1Package.Literals.IFC_GRID_AXIS__PART_OF_V, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPartOfV() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_GRID_AXIS__PART_OF_V);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPartOfV() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_GRID_AXIS__PART_OF_V);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcGrid> getPartOfU() {
		return (EList<IfcGrid>) eGet(Ifc2x3tc1Package.Literals.IFC_GRID_AXIS__PART_OF_U, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPartOfU() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_GRID_AXIS__PART_OF_U);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPartOfU() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_GRID_AXIS__PART_OF_U);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcVirtualGridIntersection> getHasIntersections() {
		return (EList<IfcVirtualGridIntersection>) eGet(Ifc2x3tc1Package.Literals.IFC_GRID_AXIS__HAS_INTERSECTIONS,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetHasIntersections() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_GRID_AXIS__HAS_INTERSECTIONS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetHasIntersections() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_GRID_AXIS__HAS_INTERSECTIONS);
	}

} //IfcGridAxisImpl
