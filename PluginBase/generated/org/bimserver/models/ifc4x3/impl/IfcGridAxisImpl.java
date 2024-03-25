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

import org.bimserver.emf.IdEObjectImpl;

import org.bimserver.models.ifc4x3.Ifc4x3Package;
import org.bimserver.models.ifc4x3.IfcCurve;
import org.bimserver.models.ifc4x3.IfcGrid;
import org.bimserver.models.ifc4x3.IfcGridAxis;
import org.bimserver.models.ifc4x3.IfcVirtualGridIntersection;
import org.bimserver.models.ifc4x3.Tristate;

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
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcGridAxisImpl#getAxisTag <em>Axis Tag</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcGridAxisImpl#getAxisCurve <em>Axis Curve</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcGridAxisImpl#getSameSense <em>Same Sense</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcGridAxisImpl#getPartOfW <em>Part Of W</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcGridAxisImpl#getPartOfV <em>Part Of V</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcGridAxisImpl#getPartOfU <em>Part Of U</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcGridAxisImpl#getHasIntersections <em>Has Intersections</em>}</li>
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
		return Ifc4x3Package.Literals.IFC_GRID_AXIS;
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
	@Override
	public String getAxisTag() {
		return (String) eGet(Ifc4x3Package.Literals.IFC_GRID_AXIS__AXIS_TAG, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAxisTag(String newAxisTag) {
		eSet(Ifc4x3Package.Literals.IFC_GRID_AXIS__AXIS_TAG, newAxisTag);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetAxisTag() {
		eUnset(Ifc4x3Package.Literals.IFC_GRID_AXIS__AXIS_TAG);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetAxisTag() {
		return eIsSet(Ifc4x3Package.Literals.IFC_GRID_AXIS__AXIS_TAG);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCurve getAxisCurve() {
		return (IfcCurve) eGet(Ifc4x3Package.Literals.IFC_GRID_AXIS__AXIS_CURVE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAxisCurve(IfcCurve newAxisCurve) {
		eSet(Ifc4x3Package.Literals.IFC_GRID_AXIS__AXIS_CURVE, newAxisCurve);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Tristate getSameSense() {
		return (Tristate) eGet(Ifc4x3Package.Literals.IFC_GRID_AXIS__SAME_SENSE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSameSense(Tristate newSameSense) {
		eSet(Ifc4x3Package.Literals.IFC_GRID_AXIS__SAME_SENSE, newSameSense);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcGrid> getPartOfW() {
		return (EList<IfcGrid>) eGet(Ifc4x3Package.Literals.IFC_GRID_AXIS__PART_OF_W, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPartOfW() {
		eUnset(Ifc4x3Package.Literals.IFC_GRID_AXIS__PART_OF_W);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPartOfW() {
		return eIsSet(Ifc4x3Package.Literals.IFC_GRID_AXIS__PART_OF_W);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcGrid> getPartOfV() {
		return (EList<IfcGrid>) eGet(Ifc4x3Package.Literals.IFC_GRID_AXIS__PART_OF_V, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPartOfV() {
		eUnset(Ifc4x3Package.Literals.IFC_GRID_AXIS__PART_OF_V);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPartOfV() {
		return eIsSet(Ifc4x3Package.Literals.IFC_GRID_AXIS__PART_OF_V);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcGrid> getPartOfU() {
		return (EList<IfcGrid>) eGet(Ifc4x3Package.Literals.IFC_GRID_AXIS__PART_OF_U, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPartOfU() {
		eUnset(Ifc4x3Package.Literals.IFC_GRID_AXIS__PART_OF_U);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPartOfU() {
		return eIsSet(Ifc4x3Package.Literals.IFC_GRID_AXIS__PART_OF_U);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcVirtualGridIntersection> getHasIntersections() {
		return (EList<IfcVirtualGridIntersection>) eGet(Ifc4x3Package.Literals.IFC_GRID_AXIS__HAS_INTERSECTIONS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetHasIntersections() {
		eUnset(Ifc4x3Package.Literals.IFC_GRID_AXIS__HAS_INTERSECTIONS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetHasIntersections() {
		return eIsSet(Ifc4x3Package.Literals.IFC_GRID_AXIS__HAS_INTERSECTIONS);
	}

} //IfcGridAxisImpl
