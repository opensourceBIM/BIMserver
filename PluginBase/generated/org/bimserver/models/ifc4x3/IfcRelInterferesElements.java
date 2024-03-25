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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Rel Interferes Elements</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcRelInterferesElements#getRelatingElement <em>Relating Element</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcRelInterferesElements#getRelatedElement <em>Related Element</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcRelInterferesElements#getInterferenceGeometry <em>Interference Geometry</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcRelInterferesElements#getInterferenceType <em>Interference Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcRelInterferesElements#getImpliedOrder <em>Implied Order</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcRelInterferesElements#getInterferenceSpace <em>Interference Space</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcRelInterferesElements()
 * @model
 * @generated
 */
public interface IfcRelInterferesElements extends IfcRelConnects {
	/**
	 * Returns the value of the '<em><b>Relating Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relating Element</em>' reference.
	 * @see #setRelatingElement(IfcInterferenceSelect)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcRelInterferesElements_RelatingElement()
	 * @model annotation="inverse"
	 *        annotation="inverse"
	 * @generated
	 */
	IfcInterferenceSelect getRelatingElement();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcRelInterferesElements#getRelatingElement <em>Relating Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relating Element</em>' reference.
	 * @see #getRelatingElement()
	 * @generated
	 */
	void setRelatingElement(IfcInterferenceSelect value);

	/**
	 * Returns the value of the '<em><b>Related Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Related Element</em>' reference.
	 * @see #setRelatedElement(IfcInterferenceSelect)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcRelInterferesElements_RelatedElement()
	 * @model annotation="inverse"
	 *        annotation="inverse"
	 * @generated
	 */
	IfcInterferenceSelect getRelatedElement();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcRelInterferesElements#getRelatedElement <em>Related Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Related Element</em>' reference.
	 * @see #getRelatedElement()
	 * @generated
	 */
	void setRelatedElement(IfcInterferenceSelect value);

	/**
	 * Returns the value of the '<em><b>Interference Geometry</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interference Geometry</em>' reference.
	 * @see #isSetInterferenceGeometry()
	 * @see #unsetInterferenceGeometry()
	 * @see #setInterferenceGeometry(IfcConnectionGeometry)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcRelInterferesElements_InterferenceGeometry()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcConnectionGeometry getInterferenceGeometry();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcRelInterferesElements#getInterferenceGeometry <em>Interference Geometry</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interference Geometry</em>' reference.
	 * @see #isSetInterferenceGeometry()
	 * @see #unsetInterferenceGeometry()
	 * @see #getInterferenceGeometry()
	 * @generated
	 */
	void setInterferenceGeometry(IfcConnectionGeometry value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcRelInterferesElements#getInterferenceGeometry <em>Interference Geometry</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetInterferenceGeometry()
	 * @see #getInterferenceGeometry()
	 * @see #setInterferenceGeometry(IfcConnectionGeometry)
	 * @generated
	 */
	void unsetInterferenceGeometry();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcRelInterferesElements#getInterferenceGeometry <em>Interference Geometry</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Interference Geometry</em>' reference is set.
	 * @see #unsetInterferenceGeometry()
	 * @see #getInterferenceGeometry()
	 * @see #setInterferenceGeometry(IfcConnectionGeometry)
	 * @generated
	 */
	boolean isSetInterferenceGeometry();

	/**
	 * Returns the value of the '<em><b>Interference Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interference Type</em>' attribute.
	 * @see #isSetInterferenceType()
	 * @see #unsetInterferenceType()
	 * @see #setInterferenceType(String)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcRelInterferesElements_InterferenceType()
	 * @model unsettable="true"
	 * @generated
	 */
	String getInterferenceType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcRelInterferesElements#getInterferenceType <em>Interference Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interference Type</em>' attribute.
	 * @see #isSetInterferenceType()
	 * @see #unsetInterferenceType()
	 * @see #getInterferenceType()
	 * @generated
	 */
	void setInterferenceType(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcRelInterferesElements#getInterferenceType <em>Interference Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetInterferenceType()
	 * @see #getInterferenceType()
	 * @see #setInterferenceType(String)
	 * @generated
	 */
	void unsetInterferenceType();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcRelInterferesElements#getInterferenceType <em>Interference Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Interference Type</em>' attribute is set.
	 * @see #unsetInterferenceType()
	 * @see #getInterferenceType()
	 * @see #setInterferenceType(String)
	 * @generated
	 */
	boolean isSetInterferenceType();

	/**
	 * Returns the value of the '<em><b>Implied Order</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4x3.Tristate}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implied Order</em>' attribute.
	 * @see org.bimserver.models.ifc4x3.Tristate
	 * @see #setImpliedOrder(Tristate)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcRelInterferesElements_ImpliedOrder()
	 * @model
	 * @generated
	 */
	Tristate getImpliedOrder();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcRelInterferesElements#getImpliedOrder <em>Implied Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implied Order</em>' attribute.
	 * @see org.bimserver.models.ifc4x3.Tristate
	 * @see #getImpliedOrder()
	 * @generated
	 */
	void setImpliedOrder(Tristate value);

	/**
	 * Returns the value of the '<em><b>Interference Space</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interference Space</em>' reference.
	 * @see #isSetInterferenceSpace()
	 * @see #unsetInterferenceSpace()
	 * @see #setInterferenceSpace(IfcSpatialZone)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcRelInterferesElements_InterferenceSpace()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcSpatialZone getInterferenceSpace();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcRelInterferesElements#getInterferenceSpace <em>Interference Space</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interference Space</em>' reference.
	 * @see #isSetInterferenceSpace()
	 * @see #unsetInterferenceSpace()
	 * @see #getInterferenceSpace()
	 * @generated
	 */
	void setInterferenceSpace(IfcSpatialZone value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcRelInterferesElements#getInterferenceSpace <em>Interference Space</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetInterferenceSpace()
	 * @see #getInterferenceSpace()
	 * @see #setInterferenceSpace(IfcSpatialZone)
	 * @generated
	 */
	void unsetInterferenceSpace();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcRelInterferesElements#getInterferenceSpace <em>Interference Space</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Interference Space</em>' reference is set.
	 * @see #unsetInterferenceSpace()
	 * @see #getInterferenceSpace()
	 * @see #setInterferenceSpace(IfcSpatialZone)
	 * @generated
	 */
	boolean isSetInterferenceSpace();

} // IfcRelInterferesElements
