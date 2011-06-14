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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Spatial Structure Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSpatialStructureElement#getLongName <em>Long Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSpatialStructureElement#getCompositionType <em>Composition Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSpatialStructureElement#getReferencesElements <em>References Elements</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSpatialStructureElement#getServicedBySystems <em>Serviced By Systems</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSpatialStructureElement#getContainsElements <em>Contains Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSpatialStructureElement()
 * @model
 * @generated
 */
public interface IfcSpatialStructureElement extends IfcProduct
{
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSpatialStructureElement_LongName()
	 * @model unsettable="true"
	 * @generated
	 */
	String getLongName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcSpatialStructureElement#getLongName <em>Long Name</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcSpatialStructureElement#getLongName <em>Long Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLongName()
	 * @see #getLongName()
	 * @see #setLongName(String)
	 * @generated
	 */
	void unsetLongName();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcSpatialStructureElement#getLongName <em>Long Name</em>}' attribute is set.
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
	 * Returns the value of the '<em><b>Composition Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.IfcElementCompositionEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Composition Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composition Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcElementCompositionEnum
	 * @see #setCompositionType(IfcElementCompositionEnum)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSpatialStructureElement_CompositionType()
	 * @model
	 * @generated
	 */
	IfcElementCompositionEnum getCompositionType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcSpatialStructureElement#getCompositionType <em>Composition Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Composition Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcElementCompositionEnum
	 * @see #getCompositionType()
	 * @generated
	 */
	void setCompositionType(IfcElementCompositionEnum value);

	/**
	 * Returns the value of the '<em><b>References Elements</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcRelReferencedInSpatialStructure}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcRelReferencedInSpatialStructure#getRelatingStructure <em>Relating Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>References Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>References Elements</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSpatialStructureElement_ReferencesElements()
	 * @see org.bimserver.models.ifc2x3.IfcRelReferencedInSpatialStructure#getRelatingStructure
	 * @model opposite="RelatingStructure"
	 * @generated
	 */
	EList<IfcRelReferencedInSpatialStructure> getReferencesElements();

	/**
	 * Returns the value of the '<em><b>Serviced By Systems</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcRelServicesBuildings}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcRelServicesBuildings#getRelatedBuildings <em>Related Buildings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Serviced By Systems</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Serviced By Systems</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSpatialStructureElement_ServicedBySystems()
	 * @see org.bimserver.models.ifc2x3.IfcRelServicesBuildings#getRelatedBuildings
	 * @model opposite="RelatedBuildings"
	 * @generated
	 */
	EList<IfcRelServicesBuildings> getServicedBySystems();

	/**
	 * Returns the value of the '<em><b>Contains Elements</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcRelContainedInSpatialStructure}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcRelContainedInSpatialStructure#getRelatingStructure <em>Relating Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contains Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contains Elements</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSpatialStructureElement_ContainsElements()
	 * @see org.bimserver.models.ifc2x3.IfcRelContainedInSpatialStructure#getRelatingStructure
	 * @model opposite="RelatingStructure"
	 * @generated
	 */
	EList<IfcRelContainedInSpatialStructure> getContainsElements();

} // IfcSpatialStructureElement
