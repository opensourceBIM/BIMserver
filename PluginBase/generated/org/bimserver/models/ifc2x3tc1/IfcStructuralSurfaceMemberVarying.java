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
package org.bimserver.models.ifc2x3tc1;

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
 * A representation of the model object '<em><b>Ifc Structural Surface Member Varying</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcStructuralSurfaceMemberVarying#getSubsequentThickness <em>Subsequent Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcStructuralSurfaceMemberVarying#getSubsequentThicknessAsString <em>Subsequent Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcStructuralSurfaceMemberVarying#getVaryingThicknessLocation <em>Varying Thickness Location</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcStructuralSurfaceMemberVarying#getVaryingThickness <em>Varying Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcStructuralSurfaceMemberVarying#getVaryingThicknessAsString <em>Varying Thickness As String</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcStructuralSurfaceMemberVarying()
 * @model
 * @generated
 */
public interface IfcStructuralSurfaceMemberVarying extends IfcStructuralSurfaceMember {
	/**
	 * Returns the value of the '<em><b>Subsequent Thickness</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Double}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subsequent Thickness</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subsequent Thickness</em>' attribute list.
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcStructuralSurfaceMemberVarying_SubsequentThickness()
	 * @model unique="false"
	 * @generated
	 */
	EList<Double> getSubsequentThickness();

	/**
	 * Returns the value of the '<em><b>Subsequent Thickness As String</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subsequent Thickness As String</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subsequent Thickness As String</em>' attribute list.
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcStructuralSurfaceMemberVarying_SubsequentThicknessAsString()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getSubsequentThicknessAsString();

	/**
	 * Returns the value of the '<em><b>Varying Thickness Location</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Varying Thickness Location</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Varying Thickness Location</em>' reference.
	 * @see #setVaryingThicknessLocation(IfcShapeAspect)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcStructuralSurfaceMemberVarying_VaryingThicknessLocation()
	 * @model
	 * @generated
	 */
	IfcShapeAspect getVaryingThicknessLocation();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralSurfaceMemberVarying#getVaryingThicknessLocation <em>Varying Thickness Location</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Varying Thickness Location</em>' reference.
	 * @see #getVaryingThicknessLocation()
	 * @generated
	 */
	void setVaryingThicknessLocation(IfcShapeAspect value);

	/**
	 * Returns the value of the '<em><b>Varying Thickness</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Varying Thickness</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Varying Thickness</em>' attribute.
	 * @see #isSetVaryingThickness()
	 * @see #unsetVaryingThickness()
	 * @see #setVaryingThickness(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcStructuralSurfaceMemberVarying_VaryingThickness()
	 * @model unsettable="true" derived="true"
	 * @generated
	 */
	double getVaryingThickness();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralSurfaceMemberVarying#getVaryingThickness <em>Varying Thickness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Varying Thickness</em>' attribute.
	 * @see #isSetVaryingThickness()
	 * @see #unsetVaryingThickness()
	 * @see #getVaryingThickness()
	 * @generated
	 */
	void setVaryingThickness(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralSurfaceMemberVarying#getVaryingThickness <em>Varying Thickness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetVaryingThickness()
	 * @see #getVaryingThickness()
	 * @see #setVaryingThickness(double)
	 * @generated
	 */
	void unsetVaryingThickness();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralSurfaceMemberVarying#getVaryingThickness <em>Varying Thickness</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Varying Thickness</em>' attribute is set.
	 * @see #unsetVaryingThickness()
	 * @see #getVaryingThickness()
	 * @see #setVaryingThickness(double)
	 * @generated
	 */
	boolean isSetVaryingThickness();

	/**
	 * Returns the value of the '<em><b>Varying Thickness As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Varying Thickness As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Varying Thickness As String</em>' attribute.
	 * @see #isSetVaryingThicknessAsString()
	 * @see #unsetVaryingThicknessAsString()
	 * @see #setVaryingThicknessAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcStructuralSurfaceMemberVarying_VaryingThicknessAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getVaryingThicknessAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralSurfaceMemberVarying#getVaryingThicknessAsString <em>Varying Thickness As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Varying Thickness As String</em>' attribute.
	 * @see #isSetVaryingThicknessAsString()
	 * @see #unsetVaryingThicknessAsString()
	 * @see #getVaryingThicknessAsString()
	 * @generated
	 */
	void setVaryingThicknessAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralSurfaceMemberVarying#getVaryingThicknessAsString <em>Varying Thickness As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetVaryingThicknessAsString()
	 * @see #getVaryingThicknessAsString()
	 * @see #setVaryingThicknessAsString(String)
	 * @generated
	 */
	void unsetVaryingThicknessAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralSurfaceMemberVarying#getVaryingThicknessAsString <em>Varying Thickness As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Varying Thickness As String</em>' attribute is set.
	 * @see #unsetVaryingThicknessAsString()
	 * @see #getVaryingThicknessAsString()
	 * @see #setVaryingThicknessAsString(String)
	 * @generated
	 */
	boolean isSetVaryingThicknessAsString();

} // IfcStructuralSurfaceMemberVarying
