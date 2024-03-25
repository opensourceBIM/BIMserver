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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Toroidal Surface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcToroidalSurface#getMajorRadius <em>Major Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcToroidalSurface#getMajorRadiusAsString <em>Major Radius As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcToroidalSurface#getMinorRadius <em>Minor Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcToroidalSurface#getMinorRadiusAsString <em>Minor Radius As String</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcToroidalSurface()
 * @model
 * @generated
 */
public interface IfcToroidalSurface extends IfcElementarySurface {
	/**
	 * Returns the value of the '<em><b>Major Radius</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Major Radius</em>' attribute.
	 * @see #setMajorRadius(double)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcToroidalSurface_MajorRadius()
	 * @model
	 * @generated
	 */
	double getMajorRadius();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcToroidalSurface#getMajorRadius <em>Major Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Major Radius</em>' attribute.
	 * @see #getMajorRadius()
	 * @generated
	 */
	void setMajorRadius(double value);

	/**
	 * Returns the value of the '<em><b>Major Radius As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Major Radius As String</em>' attribute.
	 * @see #setMajorRadiusAsString(String)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcToroidalSurface_MajorRadiusAsString()
	 * @model annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getMajorRadiusAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcToroidalSurface#getMajorRadiusAsString <em>Major Radius As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Major Radius As String</em>' attribute.
	 * @see #getMajorRadiusAsString()
	 * @generated
	 */
	void setMajorRadiusAsString(String value);

	/**
	 * Returns the value of the '<em><b>Minor Radius</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Minor Radius</em>' attribute.
	 * @see #setMinorRadius(double)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcToroidalSurface_MinorRadius()
	 * @model
	 * @generated
	 */
	double getMinorRadius();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcToroidalSurface#getMinorRadius <em>Minor Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minor Radius</em>' attribute.
	 * @see #getMinorRadius()
	 * @generated
	 */
	void setMinorRadius(double value);

	/**
	 * Returns the value of the '<em><b>Minor Radius As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Minor Radius As String</em>' attribute.
	 * @see #setMinorRadiusAsString(String)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcToroidalSurface_MinorRadiusAsString()
	 * @model annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getMinorRadiusAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcToroidalSurface#getMinorRadiusAsString <em>Minor Radius As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minor Radius As String</em>' attribute.
	 * @see #getMinorRadiusAsString()
	 * @generated
	 */
	void setMinorRadiusAsString(String value);

} // IfcToroidalSurface
