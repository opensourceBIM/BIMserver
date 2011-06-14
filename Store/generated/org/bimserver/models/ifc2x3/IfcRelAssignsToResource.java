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
 * A representation of the model object '<em><b>Ifc Rel Assigns To Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRelAssignsToResource#getRelatingResource <em>Relating Resource</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelAssignsToResource()
 * @model
 * @generated
 */
public interface IfcRelAssignsToResource extends IfcRelAssigns
{
	/**
	 * Returns the value of the '<em><b>Relating Resource</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcResource#getResourceOf <em>Resource Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relating Resource</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relating Resource</em>' reference.
	 * @see #setRelatingResource(IfcResource)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelAssignsToResource_RelatingResource()
	 * @see org.bimserver.models.ifc2x3.IfcResource#getResourceOf
	 * @model opposite="ResourceOf"
	 * @generated
	 */
	IfcResource getRelatingResource();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelAssignsToResource#getRelatingResource <em>Relating Resource</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relating Resource</em>' reference.
	 * @see #getRelatingResource()
	 * @generated
	 */
	void setRelatingResource(IfcResource value);

} // IfcRelAssignsToResource
