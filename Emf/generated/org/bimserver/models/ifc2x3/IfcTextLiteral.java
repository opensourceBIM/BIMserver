/**
 * Copyright (C) 2011  BIMserver.org
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
package org.bimserver.models.ifc2x3;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Text Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTextLiteral#getLiteral <em>Literal</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTextLiteral#getPlacement <em>Placement</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTextLiteral#getPath <em>Path</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTextLiteral()
 * @model
 * @generated
 */
public interface IfcTextLiteral extends IfcGeometricRepresentationItem {
	/**
	 * Returns the value of the '<em><b>Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Literal</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Literal</em>' attribute.
	 * @see #isSetLiteral()
	 * @see #unsetLiteral()
	 * @see #setLiteral(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTextLiteral_Literal()
	 * @model unsettable="true"
	 * @generated
	 */
	String getLiteral();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTextLiteral#getLiteral <em>Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Literal</em>' attribute.
	 * @see #isSetLiteral()
	 * @see #unsetLiteral()
	 * @see #getLiteral()
	 * @generated
	 */
	void setLiteral(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcTextLiteral#getLiteral <em>Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLiteral()
	 * @see #getLiteral()
	 * @see #setLiteral(String)
	 * @generated
	 */
	void unsetLiteral();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcTextLiteral#getLiteral <em>Literal</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Literal</em>' attribute is set.
	 * @see #unsetLiteral()
	 * @see #getLiteral()
	 * @see #setLiteral(String)
	 * @generated
	 */
	boolean isSetLiteral();

	/**
	 * Returns the value of the '<em><b>Placement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Placement</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Placement</em>' reference.
	 * @see #isSetPlacement()
	 * @see #unsetPlacement()
	 * @see #setPlacement(IfcAxis2Placement)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTextLiteral_Placement()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcAxis2Placement getPlacement();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTextLiteral#getPlacement <em>Placement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Placement</em>' reference.
	 * @see #isSetPlacement()
	 * @see #unsetPlacement()
	 * @see #getPlacement()
	 * @generated
	 */
	void setPlacement(IfcAxis2Placement value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcTextLiteral#getPlacement <em>Placement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPlacement()
	 * @see #getPlacement()
	 * @see #setPlacement(IfcAxis2Placement)
	 * @generated
	 */
	void unsetPlacement();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcTextLiteral#getPlacement <em>Placement</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Placement</em>' reference is set.
	 * @see #unsetPlacement()
	 * @see #getPlacement()
	 * @see #setPlacement(IfcAxis2Placement)
	 * @generated
	 */
	boolean isSetPlacement();

	/**
	 * Returns the value of the '<em><b>Path</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.IfcTextPath}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcTextPath
	 * @see #isSetPath()
	 * @see #unsetPath()
	 * @see #setPath(IfcTextPath)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTextLiteral_Path()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcTextPath getPath();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTextLiteral#getPath <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcTextPath
	 * @see #isSetPath()
	 * @see #unsetPath()
	 * @see #getPath()
	 * @generated
	 */
	void setPath(IfcTextPath value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcTextLiteral#getPath <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPath()
	 * @see #getPath()
	 * @see #setPath(IfcTextPath)
	 * @generated
	 */
	void unsetPath();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcTextLiteral#getPath <em>Path</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Path</em>' attribute is set.
	 * @see #unsetPath()
	 * @see #getPath()
	 * @see #setPath(IfcTextPath)
	 * @generated
	 */
	boolean isSetPath();

} // IfcTextLiteral
