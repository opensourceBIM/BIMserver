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

import org.bimserver.models.ifc4.Ifc4Package;
import org.bimserver.models.ifc4.IfcBSplineSurface;
import org.bimserver.models.ifc4.IfcBSplineSurfaceForm;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc BSpline Surface</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBSplineSurfaceImpl#getUDegree <em>UDegree</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBSplineSurfaceImpl#getVDegree <em>VDegree</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBSplineSurfaceImpl#getSurfaceForm <em>Surface Form</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBSplineSurfaceImpl#isUClosed <em>UClosed</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBSplineSurfaceImpl#isVClosed <em>VClosed</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBSplineSurfaceImpl#isSelfIntersect <em>Self Intersect</em>}</li>
 * </ul>
 * </p>
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
	public int getUDegree() {
		return (Integer) eGet(Ifc4Package.Literals.IFC_BSPLINE_SURFACE__UDEGREE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUDegree(int newUDegree) {
		eSet(Ifc4Package.Literals.IFC_BSPLINE_SURFACE__UDEGREE, newUDegree);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getVDegree() {
		return (Integer) eGet(Ifc4Package.Literals.IFC_BSPLINE_SURFACE__VDEGREE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVDegree(int newVDegree) {
		eSet(Ifc4Package.Literals.IFC_BSPLINE_SURFACE__VDEGREE, newVDegree);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcBSplineSurfaceForm getSurfaceForm() {
		return (IfcBSplineSurfaceForm) eGet(Ifc4Package.Literals.IFC_BSPLINE_SURFACE__SURFACE_FORM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSurfaceForm(IfcBSplineSurfaceForm newSurfaceForm) {
		eSet(Ifc4Package.Literals.IFC_BSPLINE_SURFACE__SURFACE_FORM, newSurfaceForm);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUClosed() {
		return (Boolean) eGet(Ifc4Package.Literals.IFC_BSPLINE_SURFACE__UCLOSED, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUClosed(boolean newUClosed) {
		eSet(Ifc4Package.Literals.IFC_BSPLINE_SURFACE__UCLOSED, newUClosed);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isVClosed() {
		return (Boolean) eGet(Ifc4Package.Literals.IFC_BSPLINE_SURFACE__VCLOSED, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVClosed(boolean newVClosed) {
		eSet(Ifc4Package.Literals.IFC_BSPLINE_SURFACE__VCLOSED, newVClosed);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSelfIntersect() {
		return (Boolean) eGet(Ifc4Package.Literals.IFC_BSPLINE_SURFACE__SELF_INTERSECT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSelfIntersect(boolean newSelfIntersect) {
		eSet(Ifc4Package.Literals.IFC_BSPLINE_SURFACE__SELF_INTERSECT, newSelfIntersect);
	}

} //IfcBSplineSurfaceImpl
