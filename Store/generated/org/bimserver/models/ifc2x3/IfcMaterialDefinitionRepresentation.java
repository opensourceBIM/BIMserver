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

import org.bimserver.models.ifc2x3.IfcMaterial;
import org.bimserver.models.ifc2x3.IfcProductRepresentation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Material Definition Representation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcMaterialDefinitionRepresentation#getRepresentedMaterial <em>Represented Material</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcMaterialDefinitionRepresentation()
 * @model
 * @generated
 */
public interface IfcMaterialDefinitionRepresentation extends IfcProductRepresentation
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = " (c) Copyright bimserver.org 2009\r\n Licensed under GNU GPLv3\r\n http://www.gnu.org/licenses/gpl-3.0.txt\r\n For more information mail to license@bimserver.org\r\n \r\n Bimserver.org is free software: you can redistribute it and/or modify \r\n it under the terms of the GNU General Public License as published by \r\n the Free Software Foundation, either version 3 of the License, or\r\n (at your option) any later version.\r\n \r\n Bimserver.org is distributed in the hope that it will be useful, but \r\n WITHOUT ANY WARRANTY; without even the implied warranty of \r\n MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU \r\n General Public License for more details.\r\n \r\n You should have received a copy of the GNU General Public License a \r\n long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.";

	/**
	 * Returns the value of the '<em><b>Represented Material</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcMaterial#getHasRepresentation <em>Has Representation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Represented Material</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Represented Material</em>' reference.
	 * @see #setRepresentedMaterial(IfcMaterial)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcMaterialDefinitionRepresentation_RepresentedMaterial()
	 * @see org.bimserver.models.ifc2x3.IfcMaterial#getHasRepresentation
	 * @model opposite="HasRepresentation"
	 * @generated
	 */
	IfcMaterial getRepresentedMaterial();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcMaterialDefinitionRepresentation#getRepresentedMaterial <em>Represented Material</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Represented Material</em>' reference.
	 * @see #getRepresentedMaterial()
	 * @generated
	 */
	void setRepresentedMaterial(IfcMaterial value);

} // IfcMaterialDefinitionRepresentation
