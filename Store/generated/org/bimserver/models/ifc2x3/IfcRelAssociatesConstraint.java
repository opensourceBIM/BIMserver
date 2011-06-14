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
 * A representation of the model object '<em><b>Ifc Rel Associates Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRelAssociatesConstraint#getIntent <em>Intent</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRelAssociatesConstraint#getRelatingConstraint <em>Relating Constraint</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelAssociatesConstraint()
 * @model
 * @generated
 */
public interface IfcRelAssociatesConstraint extends IfcRelAssociates
{
	/**
	 * Returns the value of the '<em><b>Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Intent</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intent</em>' attribute.
	 * @see #setIntent(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelAssociatesConstraint_Intent()
	 * @model
	 * @generated
	 */
	String getIntent();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelAssociatesConstraint#getIntent <em>Intent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Intent</em>' attribute.
	 * @see #getIntent()
	 * @generated
	 */
	void setIntent(String value);

	/**
	 * Returns the value of the '<em><b>Relating Constraint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relating Constraint</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relating Constraint</em>' reference.
	 * @see #setRelatingConstraint(IfcConstraint)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelAssociatesConstraint_RelatingConstraint()
	 * @model
	 * @generated
	 */
	IfcConstraint getRelatingConstraint();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelAssociatesConstraint#getRelatingConstraint <em>Relating Constraint</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relating Constraint</em>' reference.
	 * @see #getRelatingConstraint()
	 * @generated
	 */
	void setRelatingConstraint(IfcConstraint value);

} // IfcRelAssociatesConstraint
