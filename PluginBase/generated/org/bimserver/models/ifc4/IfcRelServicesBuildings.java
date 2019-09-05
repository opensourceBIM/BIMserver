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
 * A representation of the model object '<em><b>Ifc Rel Services Buildings</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcRelServicesBuildings#getRelatingSystem <em>Relating System</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcRelServicesBuildings#getRelatedBuildings <em>Related Buildings</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRelServicesBuildings()
 * @model
 * @generated
 */
public interface IfcRelServicesBuildings extends IfcRelConnects {
	/**
	 * Returns the value of the '<em><b>Relating System</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcSystem#getServicesBuildings <em>Services Buildings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relating System</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relating System</em>' reference.
	 * @see #setRelatingSystem(IfcSystem)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRelServicesBuildings_RelatingSystem()
	 * @see org.bimserver.models.ifc4.IfcSystem#getServicesBuildings
	 * @model opposite="ServicesBuildings"
	 *        annotation="inverse"
	 * @generated
	 */
	IfcSystem getRelatingSystem();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcRelServicesBuildings#getRelatingSystem <em>Relating System</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relating System</em>' reference.
	 * @see #getRelatingSystem()
	 * @generated
	 */
	void setRelatingSystem(IfcSystem value);

	/**
	 * Returns the value of the '<em><b>Related Buildings</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcSpatialElement}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcSpatialElement#getServicedBySystems <em>Serviced By Systems</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Related Buildings</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Related Buildings</em>' reference list.
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRelServicesBuildings_RelatedBuildings()
	 * @see org.bimserver.models.ifc4.IfcSpatialElement#getServicedBySystems
	 * @model opposite="ServicedBySystems"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcSpatialElement> getRelatedBuildings();

} // IfcRelServicesBuildings
