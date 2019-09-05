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
import org.bimserver.models.ifc4.IfcBSplineSurface;
import org.bimserver.models.ifc4.IfcBSplineSurfaceForm;
import org.bimserver.models.ifc4.ListOfIfcCartesianPoint;
import org.bimserver.models.ifc4.Tristate;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc BSpline Surface</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBSplineSurfaceImpl#getUDegree <em>UDegree</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBSplineSurfaceImpl#getVDegree <em>VDegree</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBSplineSurfaceImpl#getControlPointsList <em>Control Points List</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBSplineSurfaceImpl#getSurfaceForm <em>Surface Form</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBSplineSurfaceImpl#getUClosed <em>UClosed</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBSplineSurfaceImpl#getVClosed <em>VClosed</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBSplineSurfaceImpl#getSelfIntersect <em>Self Intersect</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBSplineSurfaceImpl#getUUpper <em>UUpper</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBSplineSurfaceImpl#getVUpper <em>VUpper</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcBSplineSurfaceImpl extends IfcBoundedSurfaceImpl implements IfcBSplineSurface {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcBSplineSurfaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_BSPLINE_SURFACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getUDegree() {
		return (Long) eGet(Ifc4Package.Literals.IFC_BSPLINE_SURFACE__UDEGREE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUDegree(long newUDegree) {
		eSet(Ifc4Package.Literals.IFC_BSPLINE_SURFACE__UDEGREE, newUDegree);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getVDegree() {
		return (Long) eGet(Ifc4Package.Literals.IFC_BSPLINE_SURFACE__VDEGREE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVDegree(long newVDegree) {
		eSet(Ifc4Package.Literals.IFC_BSPLINE_SURFACE__VDEGREE, newVDegree);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<ListOfIfcCartesianPoint> getControlPointsList() {
		return (EList<ListOfIfcCartesianPoint>) eGet(Ifc4Package.Literals.IFC_BSPLINE_SURFACE__CONTROL_POINTS_LIST, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcBSplineSurfaceForm getSurfaceForm() {
		return (IfcBSplineSurfaceForm) eGet(Ifc4Package.Literals.IFC_BSPLINE_SURFACE__SURFACE_FORM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSurfaceForm(IfcBSplineSurfaceForm newSurfaceForm) {
		eSet(Ifc4Package.Literals.IFC_BSPLINE_SURFACE__SURFACE_FORM, newSurfaceForm);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Tristate getUClosed() {
		return (Tristate) eGet(Ifc4Package.Literals.IFC_BSPLINE_SURFACE__UCLOSED, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUClosed(Tristate newUClosed) {
		eSet(Ifc4Package.Literals.IFC_BSPLINE_SURFACE__UCLOSED, newUClosed);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Tristate getVClosed() {
		return (Tristate) eGet(Ifc4Package.Literals.IFC_BSPLINE_SURFACE__VCLOSED, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVClosed(Tristate newVClosed) {
		eSet(Ifc4Package.Literals.IFC_BSPLINE_SURFACE__VCLOSED, newVClosed);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Tristate getSelfIntersect() {
		return (Tristate) eGet(Ifc4Package.Literals.IFC_BSPLINE_SURFACE__SELF_INTERSECT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSelfIntersect(Tristate newSelfIntersect) {
		eSet(Ifc4Package.Literals.IFC_BSPLINE_SURFACE__SELF_INTERSECT, newSelfIntersect);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getUUpper() {
		return (Long) eGet(Ifc4Package.Literals.IFC_BSPLINE_SURFACE__UUPPER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUUpper(long newUUpper) {
		eSet(Ifc4Package.Literals.IFC_BSPLINE_SURFACE__UUPPER, newUUpper);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetUUpper() {
		eUnset(Ifc4Package.Literals.IFC_BSPLINE_SURFACE__UUPPER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetUUpper() {
		return eIsSet(Ifc4Package.Literals.IFC_BSPLINE_SURFACE__UUPPER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getVUpper() {
		return (Long) eGet(Ifc4Package.Literals.IFC_BSPLINE_SURFACE__VUPPER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVUpper(long newVUpper) {
		eSet(Ifc4Package.Literals.IFC_BSPLINE_SURFACE__VUPPER, newVUpper);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetVUpper() {
		eUnset(Ifc4Package.Literals.IFC_BSPLINE_SURFACE__VUPPER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetVUpper() {
		return eIsSet(Ifc4Package.Literals.IFC_BSPLINE_SURFACE__VUPPER);
	}

} //IfcBSplineSurfaceImpl
