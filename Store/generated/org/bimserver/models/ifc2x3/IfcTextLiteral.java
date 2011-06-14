/**
 *  (c) Copyright bimserver.org 2009
 *  Licensed under GNU GPLv3
 *  http://www.gnu.org/licenses/gpl-3.0.txt
 *  For more information mail to license@bimserver.org
 *  
 *  Bimserver.org is free software: you can redistribute it and/or modify 
 *  it under the terms of the GNU General Public License as published by 
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  Bimserver.org is distributed in the hope that it will be useful, but 
 *  WITHOUT ANY WARRANTY; without even the implied warranty of 
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 *  General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License a 
 *  long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
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
public interface IfcTextLiteral extends IfcGeometricRepresentationItem
{
	/**
	 * Returns the value of the '<em><b>Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Literal</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Literal</em>' attribute.
	 * @see #setLiteral(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTextLiteral_Literal()
	 * @model
	 * @generated
	 */
	String getLiteral();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTextLiteral#getLiteral <em>Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Literal</em>' attribute.
	 * @see #getLiteral()
	 * @generated
	 */
	void setLiteral(String value);

	/**
	 * Returns the value of the '<em><b>Placement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Placement</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Placement</em>' reference.
	 * @see #setPlacement(IfcAxis2Placement)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTextLiteral_Placement()
	 * @model
	 * @generated
	 */
	IfcAxis2Placement getPlacement();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTextLiteral#getPlacement <em>Placement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Placement</em>' reference.
	 * @see #getPlacement()
	 * @generated
	 */
	void setPlacement(IfcAxis2Placement value);

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
	 * @see #setPath(IfcTextPath)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTextLiteral_Path()
	 * @model
	 * @generated
	 */
	IfcTextPath getPath();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTextLiteral#getPath <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcTextPath
	 * @see #getPath()
	 * @generated
	 */
	void setPath(IfcTextPath value);

} // IfcTextLiteral
