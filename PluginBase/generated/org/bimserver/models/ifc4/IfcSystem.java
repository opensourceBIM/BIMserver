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
 * A representation of the model object '<em><b>Ifc System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcSystem#getServicesBuildings <em>Services Buildings</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSystem()
 * @model
 * @generated
 */
public interface IfcSystem extends IfcGroup {
	/**
	 * Returns the value of the '<em><b>Services Buildings</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcRelServicesBuildings}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcRelServicesBuildings#getRelatingSystem <em>Relating System</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Services Buildings</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Services Buildings</em>' reference list.
	 * @see #isSetServicesBuildings()
	 * @see #unsetServicesBuildings()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSystem_ServicesBuildings()
	 * @see org.bimserver.models.ifc4.IfcRelServicesBuildings#getRelatingSystem
	 * @model opposite="RelatingSystem" unsettable="true" upper="2"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcRelServicesBuildings> getServicesBuildings();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcSystem#getServicesBuildings <em>Services Buildings</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetServicesBuildings()
	 * @see #getServicesBuildings()
	 * @generated
	 */
	void unsetServicesBuildings();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcSystem#getServicesBuildings <em>Services Buildings</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Services Buildings</em>' reference list is set.
	 * @see #unsetServicesBuildings()
	 * @see #getServicesBuildings()
	 * @generated
	 */
	boolean isSetServicesBuildings();

} // IfcSystem
