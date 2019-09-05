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
package org.bimserver.models.ifc4;

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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc BSpline Surface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcBSplineSurface#getUDegree <em>UDegree</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcBSplineSurface#getVDegree <em>VDegree</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcBSplineSurface#getControlPointsList <em>Control Points List</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcBSplineSurface#getSurfaceForm <em>Surface Form</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcBSplineSurface#getUClosed <em>UClosed</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcBSplineSurface#getVClosed <em>VClosed</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcBSplineSurface#getSelfIntersect <em>Self Intersect</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcBSplineSurface#getUUpper <em>UUpper</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcBSplineSurface#getVUpper <em>VUpper</em>}</li>
 * </ul>
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
	 * @see #setUDegree(long)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcBSplineSurface_UDegree()
	 * @model
	 * @generated
	 */
	long getUDegree();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcBSplineSurface#getUDegree <em>UDegree</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>UDegree</em>' attribute.
	 * @see #getUDegree()
	 * @generated
	 */
	void setUDegree(long value);

	/**
	 * Returns the value of the '<em><b>VDegree</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>VDegree</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>VDegree</em>' attribute.
	 * @see #setVDegree(long)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcBSplineSurface_VDegree()
	 * @model
	 * @generated
	 */
	long getVDegree();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcBSplineSurface#getVDegree <em>VDegree</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>VDegree</em>' attribute.
	 * @see #getVDegree()
	 * @generated
	 */
	void setVDegree(long value);

	/**
	 * Returns the value of the '<em><b>Control Points List</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.ListOfIfcCartesianPoint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Control Points List</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Control Points List</em>' reference list.
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcBSplineSurface_ControlPointsList()
	 * @model annotation="twodimensionalarray"
	 * @generated
	 */
	EList<ListOfIfcCartesianPoint> getControlPointsList();

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
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.Tristate}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>UClosed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>UClosed</em>' attribute.
	 * @see org.bimserver.models.ifc4.Tristate
	 * @see #setUClosed(Tristate)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcBSplineSurface_UClosed()
	 * @model
	 * @generated
	 */
	Tristate getUClosed();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcBSplineSurface#getUClosed <em>UClosed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>UClosed</em>' attribute.
	 * @see org.bimserver.models.ifc4.Tristate
	 * @see #getUClosed()
	 * @generated
	 */
	void setUClosed(Tristate value);

	/**
	 * Returns the value of the '<em><b>VClosed</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.Tristate}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>VClosed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>VClosed</em>' attribute.
	 * @see org.bimserver.models.ifc4.Tristate
	 * @see #setVClosed(Tristate)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcBSplineSurface_VClosed()
	 * @model
	 * @generated
	 */
	Tristate getVClosed();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcBSplineSurface#getVClosed <em>VClosed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>VClosed</em>' attribute.
	 * @see org.bimserver.models.ifc4.Tristate
	 * @see #getVClosed()
	 * @generated
	 */
	void setVClosed(Tristate value);

	/**
	 * Returns the value of the '<em><b>Self Intersect</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.Tristate}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Self Intersect</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Self Intersect</em>' attribute.
	 * @see org.bimserver.models.ifc4.Tristate
	 * @see #setSelfIntersect(Tristate)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcBSplineSurface_SelfIntersect()
	 * @model
	 * @generated
	 */
	Tristate getSelfIntersect();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcBSplineSurface#getSelfIntersect <em>Self Intersect</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Self Intersect</em>' attribute.
	 * @see org.bimserver.models.ifc4.Tristate
	 * @see #getSelfIntersect()
	 * @generated
	 */
	void setSelfIntersect(Tristate value);

	/**
	 * Returns the value of the '<em><b>UUpper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>UUpper</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>UUpper</em>' attribute.
	 * @see #isSetUUpper()
	 * @see #unsetUUpper()
	 * @see #setUUpper(long)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcBSplineSurface_UUpper()
	 * @model unsettable="true" derived="true"
	 * @generated
	 */
	long getUUpper();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcBSplineSurface#getUUpper <em>UUpper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>UUpper</em>' attribute.
	 * @see #isSetUUpper()
	 * @see #unsetUUpper()
	 * @see #getUUpper()
	 * @generated
	 */
	void setUUpper(long value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcBSplineSurface#getUUpper <em>UUpper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUUpper()
	 * @see #getUUpper()
	 * @see #setUUpper(long)
	 * @generated
	 */
	void unsetUUpper();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcBSplineSurface#getUUpper <em>UUpper</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>UUpper</em>' attribute is set.
	 * @see #unsetUUpper()
	 * @see #getUUpper()
	 * @see #setUUpper(long)
	 * @generated
	 */
	boolean isSetUUpper();

	/**
	 * Returns the value of the '<em><b>VUpper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>VUpper</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>VUpper</em>' attribute.
	 * @see #isSetVUpper()
	 * @see #unsetVUpper()
	 * @see #setVUpper(long)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcBSplineSurface_VUpper()
	 * @model unsettable="true" derived="true"
	 * @generated
	 */
	long getVUpper();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcBSplineSurface#getVUpper <em>VUpper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>VUpper</em>' attribute.
	 * @see #isSetVUpper()
	 * @see #unsetVUpper()
	 * @see #getVUpper()
	 * @generated
	 */
	void setVUpper(long value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcBSplineSurface#getVUpper <em>VUpper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetVUpper()
	 * @see #getVUpper()
	 * @see #setVUpper(long)
	 * @generated
	 */
	void unsetVUpper();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcBSplineSurface#getVUpper <em>VUpper</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>VUpper</em>' attribute is set.
	 * @see #unsetVUpper()
	 * @see #getVUpper()
	 * @see #setVUpper(long)
	 * @generated
	 */
	boolean isSetVUpper();

} // IfcBSplineSurface
