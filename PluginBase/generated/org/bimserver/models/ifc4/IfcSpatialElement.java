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
 * A representation of the model object '<em><b>Ifc Spatial Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcSpatialElement#getLongName <em>Long Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcSpatialElement#getContainsElements <em>Contains Elements</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcSpatialElement#getServicedBySystems <em>Serviced By Systems</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcSpatialElement#getReferencesElements <em>References Elements</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSpatialElement()
 * @model
 * @generated
 */
public interface IfcSpatialElement extends IfcProduct {
	/**
	 * Returns the value of the '<em><b>Long Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Long Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Long Name</em>' attribute.
	 * @see #isSetLongName()
	 * @see #unsetLongName()
	 * @see #setLongName(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSpatialElement_LongName()
	 * @model unsettable="true"
	 * @generated
	 */
	String getLongName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcSpatialElement#getLongName <em>Long Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Long Name</em>' attribute.
	 * @see #isSetLongName()
	 * @see #unsetLongName()
	 * @see #getLongName()
	 * @generated
	 */
	void setLongName(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcSpatialElement#getLongName <em>Long Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLongName()
	 * @see #getLongName()
	 * @see #setLongName(String)
	 * @generated
	 */
	void unsetLongName();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcSpatialElement#getLongName <em>Long Name</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Long Name</em>' attribute is set.
	 * @see #unsetLongName()
	 * @see #getLongName()
	 * @see #setLongName(String)
	 * @generated
	 */
	boolean isSetLongName();

	/**
	 * Returns the value of the '<em><b>Contains Elements</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcRelContainedInSpatialStructure}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcRelContainedInSpatialStructure#getRelatingStructure <em>Relating Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contains Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contains Elements</em>' reference list.
	 * @see #isSetContainsElements()
	 * @see #unsetContainsElements()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSpatialElement_ContainsElements()
	 * @see org.bimserver.models.ifc4.IfcRelContainedInSpatialStructure#getRelatingStructure
	 * @model opposite="RelatingStructure" unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcRelContainedInSpatialStructure> getContainsElements();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcSpatialElement#getContainsElements <em>Contains Elements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetContainsElements()
	 * @see #getContainsElements()
	 * @generated
	 */
	void unsetContainsElements();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcSpatialElement#getContainsElements <em>Contains Elements</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Contains Elements</em>' reference list is set.
	 * @see #unsetContainsElements()
	 * @see #getContainsElements()
	 * @generated
	 */
	boolean isSetContainsElements();

	/**
	 * Returns the value of the '<em><b>Serviced By Systems</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcRelServicesBuildings}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcRelServicesBuildings#getRelatedBuildings <em>Related Buildings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Serviced By Systems</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Serviced By Systems</em>' reference list.
	 * @see #isSetServicedBySystems()
	 * @see #unsetServicedBySystems()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSpatialElement_ServicedBySystems()
	 * @see org.bimserver.models.ifc4.IfcRelServicesBuildings#getRelatedBuildings
	 * @model opposite="RelatedBuildings" unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcRelServicesBuildings> getServicedBySystems();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcSpatialElement#getServicedBySystems <em>Serviced By Systems</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetServicedBySystems()
	 * @see #getServicedBySystems()
	 * @generated
	 */
	void unsetServicedBySystems();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcSpatialElement#getServicedBySystems <em>Serviced By Systems</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Serviced By Systems</em>' reference list is set.
	 * @see #unsetServicedBySystems()
	 * @see #getServicedBySystems()
	 * @generated
	 */
	boolean isSetServicedBySystems();

	/**
	 * Returns the value of the '<em><b>References Elements</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcRelReferencedInSpatialStructure}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcRelReferencedInSpatialStructure#getRelatingStructure <em>Relating Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>References Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>References Elements</em>' reference list.
	 * @see #isSetReferencesElements()
	 * @see #unsetReferencesElements()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSpatialElement_ReferencesElements()
	 * @see org.bimserver.models.ifc4.IfcRelReferencedInSpatialStructure#getRelatingStructure
	 * @model opposite="RelatingStructure" unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcRelReferencedInSpatialStructure> getReferencesElements();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcSpatialElement#getReferencesElements <em>References Elements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetReferencesElements()
	 * @see #getReferencesElements()
	 * @generated
	 */
	void unsetReferencesElements();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcSpatialElement#getReferencesElements <em>References Elements</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>References Elements</em>' reference list is set.
	 * @see #unsetReferencesElements()
	 * @see #getReferencesElements()
	 * @generated
	 */
	boolean isSetReferencesElements();

} // IfcSpatialElement
