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

import org.bimserver.emf.IdEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Alignment Parameter Segment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcAlignmentParameterSegment#getStartTag <em>Start Tag</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcAlignmentParameterSegment#getEndTag <em>End Tag</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcAlignmentParameterSegment()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface IfcAlignmentParameterSegment extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Start Tag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Tag</em>' attribute.
	 * @see #isSetStartTag()
	 * @see #unsetStartTag()
	 * @see #setStartTag(String)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcAlignmentParameterSegment_StartTag()
	 * @model unsettable="true"
	 * @generated
	 */
	String getStartTag();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcAlignmentParameterSegment#getStartTag <em>Start Tag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Tag</em>' attribute.
	 * @see #isSetStartTag()
	 * @see #unsetStartTag()
	 * @see #getStartTag()
	 * @generated
	 */
	void setStartTag(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcAlignmentParameterSegment#getStartTag <em>Start Tag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetStartTag()
	 * @see #getStartTag()
	 * @see #setStartTag(String)
	 * @generated
	 */
	void unsetStartTag();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcAlignmentParameterSegment#getStartTag <em>Start Tag</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Start Tag</em>' attribute is set.
	 * @see #unsetStartTag()
	 * @see #getStartTag()
	 * @see #setStartTag(String)
	 * @generated
	 */
	boolean isSetStartTag();

	/**
	 * Returns the value of the '<em><b>End Tag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Tag</em>' attribute.
	 * @see #isSetEndTag()
	 * @see #unsetEndTag()
	 * @see #setEndTag(String)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcAlignmentParameterSegment_EndTag()
	 * @model unsettable="true"
	 * @generated
	 */
	String getEndTag();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcAlignmentParameterSegment#getEndTag <em>End Tag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Tag</em>' attribute.
	 * @see #isSetEndTag()
	 * @see #unsetEndTag()
	 * @see #getEndTag()
	 * @generated
	 */
	void setEndTag(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcAlignmentParameterSegment#getEndTag <em>End Tag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetEndTag()
	 * @see #getEndTag()
	 * @see #setEndTag(String)
	 * @generated
	 */
	void unsetEndTag();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcAlignmentParameterSegment#getEndTag <em>End Tag</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>End Tag</em>' attribute is set.
	 * @see #unsetEndTag()
	 * @see #getEndTag()
	 * @see #setEndTag(String)
	 * @generated
	 */
	boolean isSetEndTag();

} // IfcAlignmentParameterSegment
