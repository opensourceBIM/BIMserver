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
 * A representation of the model object '<em><b>Ifc Open Cross Profile Def</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcOpenCrossProfileDef#getHorizontalWidths <em>Horizontal Widths</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcOpenCrossProfileDef#getWidths <em>Widths</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcOpenCrossProfileDef#getWidthsAsString <em>Widths As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcOpenCrossProfileDef#getSlopes <em>Slopes</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcOpenCrossProfileDef#getSlopesAsString <em>Slopes As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcOpenCrossProfileDef#getTags <em>Tags</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcOpenCrossProfileDef#getOffsetPoint <em>Offset Point</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcOpenCrossProfileDef()
 * @model
 * @generated
 */
public interface IfcOpenCrossProfileDef extends IfcProfileDef {
	/**
	 * Returns the value of the '<em><b>Horizontal Widths</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4x3.Tristate}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Horizontal Widths</em>' attribute.
	 * @see org.bimserver.models.ifc4x3.Tristate
	 * @see #setHorizontalWidths(Tristate)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcOpenCrossProfileDef_HorizontalWidths()
	 * @model
	 * @generated
	 */
	Tristate getHorizontalWidths();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcOpenCrossProfileDef#getHorizontalWidths <em>Horizontal Widths</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Horizontal Widths</em>' attribute.
	 * @see org.bimserver.models.ifc4x3.Tristate
	 * @see #getHorizontalWidths()
	 * @generated
	 */
	void setHorizontalWidths(Tristate value);

	/**
	 * Returns the value of the '<em><b>Widths</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Double}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Widths</em>' attribute list.
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcOpenCrossProfileDef_Widths()
	 * @model unique="false"
	 * @generated
	 */
	EList<Double> getWidths();

	/**
	 * Returns the value of the '<em><b>Widths As String</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Widths As String</em>' attribute list.
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcOpenCrossProfileDef_WidthsAsString()
	 * @model unique="false"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	EList<String> getWidthsAsString();

	/**
	 * Returns the value of the '<em><b>Slopes</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Double}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Slopes</em>' attribute list.
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcOpenCrossProfileDef_Slopes()
	 * @model unique="false"
	 * @generated
	 */
	EList<Double> getSlopes();

	/**
	 * Returns the value of the '<em><b>Slopes As String</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Slopes As String</em>' attribute list.
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcOpenCrossProfileDef_SlopesAsString()
	 * @model unique="false"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	EList<String> getSlopesAsString();

	/**
	 * Returns the value of the '<em><b>Tags</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tags</em>' attribute list.
	 * @see #isSetTags()
	 * @see #unsetTags()
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcOpenCrossProfileDef_Tags()
	 * @model unique="false" unsettable="true"
	 * @generated
	 */
	EList<String> getTags();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcOpenCrossProfileDef#getTags <em>Tags</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTags()
	 * @see #getTags()
	 * @generated
	 */
	void unsetTags();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcOpenCrossProfileDef#getTags <em>Tags</em>}' attribute list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Tags</em>' attribute list is set.
	 * @see #unsetTags()
	 * @see #getTags()
	 * @generated
	 */
	boolean isSetTags();

	/**
	 * Returns the value of the '<em><b>Offset Point</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Offset Point</em>' reference.
	 * @see #isSetOffsetPoint()
	 * @see #unsetOffsetPoint()
	 * @see #setOffsetPoint(IfcCartesianPoint)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcOpenCrossProfileDef_OffsetPoint()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcCartesianPoint getOffsetPoint();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcOpenCrossProfileDef#getOffsetPoint <em>Offset Point</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Offset Point</em>' reference.
	 * @see #isSetOffsetPoint()
	 * @see #unsetOffsetPoint()
	 * @see #getOffsetPoint()
	 * @generated
	 */
	void setOffsetPoint(IfcCartesianPoint value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcOpenCrossProfileDef#getOffsetPoint <em>Offset Point</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetOffsetPoint()
	 * @see #getOffsetPoint()
	 * @see #setOffsetPoint(IfcCartesianPoint)
	 * @generated
	 */
	void unsetOffsetPoint();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcOpenCrossProfileDef#getOffsetPoint <em>Offset Point</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Offset Point</em>' reference is set.
	 * @see #unsetOffsetPoint()
	 * @see #getOffsetPoint()
	 * @see #setOffsetPoint(IfcCartesianPoint)
	 * @generated
	 */
	boolean isSetOffsetPoint();

} // IfcOpenCrossProfileDef
