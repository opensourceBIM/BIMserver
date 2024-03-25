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
package org.bimserver.models.ifc4x3;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Surface Curve</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcSurfaceCurve#getCurve3D <em>Curve3 D</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcSurfaceCurve#getAssociatedGeometry <em>Associated Geometry</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcSurfaceCurve#getMasterRepresentation <em>Master Representation</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcSurfaceCurve()
 * @model
 * @generated
 */
public interface IfcSurfaceCurve extends IfcCurve, IfcCurveOnSurface {
	/**
	 * Returns the value of the '<em><b>Curve3 D</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Curve3 D</em>' reference.
	 * @see #setCurve3D(IfcCurve)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcSurfaceCurve_Curve3D()
	 * @model
	 * @generated
	 */
	IfcCurve getCurve3D();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcSurfaceCurve#getCurve3D <em>Curve3 D</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Curve3 D</em>' reference.
	 * @see #getCurve3D()
	 * @generated
	 */
	void setCurve3D(IfcCurve value);

	/**
	 * Returns the value of the '<em><b>Associated Geometry</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4x3.IfcPcurve}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Associated Geometry</em>' reference list.
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcSurfaceCurve_AssociatedGeometry()
	 * @model
	 * @generated
	 */
	EList<IfcPcurve> getAssociatedGeometry();

	/**
	 * Returns the value of the '<em><b>Master Representation</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4x3.IfcPreferredSurfaceCurveRepresentation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Master Representation</em>' attribute.
	 * @see org.bimserver.models.ifc4x3.IfcPreferredSurfaceCurveRepresentation
	 * @see #setMasterRepresentation(IfcPreferredSurfaceCurveRepresentation)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcSurfaceCurve_MasterRepresentation()
	 * @model
	 * @generated
	 */
	IfcPreferredSurfaceCurveRepresentation getMasterRepresentation();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcSurfaceCurve#getMasterRepresentation <em>Master Representation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Master Representation</em>' attribute.
	 * @see org.bimserver.models.ifc4x3.IfcPreferredSurfaceCurveRepresentation
	 * @see #getMasterRepresentation()
	 * @generated
	 */
	void setMasterRepresentation(IfcPreferredSurfaceCurveRepresentation value);

} // IfcSurfaceCurve
