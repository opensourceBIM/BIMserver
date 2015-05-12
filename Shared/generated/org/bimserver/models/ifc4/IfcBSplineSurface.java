/**
 * Copyright (C) 2009-2013 BIMserver.org
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
package org.bimserver.models.ifc4;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc BSpline Surface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcBSplineSurface#getUDegree <em>UDegree</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcBSplineSurface#getVDegree <em>VDegree</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcBSplineSurface#getSurfaceForm <em>Surface Form</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcBSplineSurface#isUClosed <em>UClosed</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcBSplineSurface#isVClosed <em>VClosed</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcBSplineSurface#isSelfIntersect <em>Self Intersect</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcBSplineSurface()
 * @model
 * @generated
 */
public interface IfcBSplineSurface extends IfcBoundedSurface {
	/**
	 * Returns the value of the '<em><b>UDegree</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>UDegree</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>UDegree</em>' attribute.
	 * @see #setUDegree(int)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcBSplineSurface_UDegree()
	 * @model
	 * @generated
	 */
	int getUDegree();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcBSplineSurface#getUDegree <em>UDegree</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>UDegree</em>' attribute.
	 * @see #getUDegree()
	 * @generated
	 */
	void setUDegree(int value);

	/**
	 * Returns the value of the '<em><b>VDegree</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>VDegree</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>VDegree</em>' attribute.
	 * @see #setVDegree(int)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcBSplineSurface_VDegree()
	 * @model
	 * @generated
	 */
	int getVDegree();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcBSplineSurface#getVDegree <em>VDegree</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>VDegree</em>' attribute.
	 * @see #getVDegree()
	 * @generated
	 */
	void setVDegree(int value);

	/**
	 * Returns the value of the '<em><b>Surface Form</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.IfcBSplineSurfaceForm}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Surface Form</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Surface Form</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcBSplineSurfaceForm
	 * @see #setSurfaceForm(IfcBSplineSurfaceForm)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcBSplineSurface_SurfaceForm()
	 * @model
	 * @generated
	 */
	IfcBSplineSurfaceForm getSurfaceForm();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcBSplineSurface#getSurfaceForm <em>Surface Form</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Surface Form</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcBSplineSurfaceForm
	 * @see #getSurfaceForm()
	 * @generated
	 */
	void setSurfaceForm(IfcBSplineSurfaceForm value);

	/**
	 * Returns the value of the '<em><b>UClosed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>UClosed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>UClosed</em>' attribute.
	 * @see #setUClosed(boolean)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcBSplineSurface_UClosed()
	 * @model
	 * @generated
	 */
	boolean isUClosed();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcBSplineSurface#isUClosed <em>UClosed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>UClosed</em>' attribute.
	 * @see #isUClosed()
	 * @generated
	 */
	void setUClosed(boolean value);

	/**
	 * Returns the value of the '<em><b>VClosed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>VClosed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>VClosed</em>' attribute.
	 * @see #setVClosed(boolean)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcBSplineSurface_VClosed()
	 * @model
	 * @generated
	 */
	boolean isVClosed();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcBSplineSurface#isVClosed <em>VClosed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>VClosed</em>' attribute.
	 * @see #isVClosed()
	 * @generated
	 */
	void setVClosed(boolean value);

	/**
	 * Returns the value of the '<em><b>Self Intersect</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Self Intersect</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Self Intersect</em>' attribute.
	 * @see #setSelfIntersect(boolean)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcBSplineSurface_SelfIntersect()
	 * @model
	 * @generated
	 */
	boolean isSelfIntersect();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcBSplineSurface#isSelfIntersect <em>Self Intersect</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Self Intersect</em>' attribute.
	 * @see #isSelfIntersect()
	 * @generated
	 */
	void setSelfIntersect(boolean value);

} // IfcBSplineSurface
