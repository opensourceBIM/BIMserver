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
 * A representation of the model object '<em><b>Ifc Rel Connects Elements</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRelConnectsElements#getConnectionGeometry <em>Connection Geometry</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRelConnectsElements#getRelatingElement <em>Relating Element</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRelConnectsElements#getRelatedElement <em>Related Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelConnectsElements()
 * @model
 * @generated
 */
public interface IfcRelConnectsElements extends IfcRelConnects {
	/**
	 * Returns the value of the '<em><b>Connection Geometry</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connection Geometry</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connection Geometry</em>' reference.
	 * @see #isSetConnectionGeometry()
	 * @see #unsetConnectionGeometry()
	 * @see #setConnectionGeometry(IfcConnectionGeometry)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelConnectsElements_ConnectionGeometry()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcConnectionGeometry getConnectionGeometry();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelConnectsElements#getConnectionGeometry <em>Connection Geometry</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connection Geometry</em>' reference.
	 * @see #isSetConnectionGeometry()
	 * @see #unsetConnectionGeometry()
	 * @see #getConnectionGeometry()
	 * @generated
	 */
	void setConnectionGeometry(IfcConnectionGeometry value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelConnectsElements#getConnectionGeometry <em>Connection Geometry</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetConnectionGeometry()
	 * @see #getConnectionGeometry()
	 * @see #setConnectionGeometry(IfcConnectionGeometry)
	 * @generated
	 */
	void unsetConnectionGeometry();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRelConnectsElements#getConnectionGeometry <em>Connection Geometry</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Connection Geometry</em>' reference is set.
	 * @see #unsetConnectionGeometry()
	 * @see #getConnectionGeometry()
	 * @see #setConnectionGeometry(IfcConnectionGeometry)
	 * @generated
	 */
	boolean isSetConnectionGeometry();

	/**
	 * Returns the value of the '<em><b>Relating Element</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcElement#getConnectedTo <em>Connected To</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relating Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relating Element</em>' reference.
	 * @see #isSetRelatingElement()
	 * @see #unsetRelatingElement()
	 * @see #setRelatingElement(IfcElement)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelConnectsElements_RelatingElement()
	 * @see org.bimserver.models.ifc2x3.IfcElement#getConnectedTo
	 * @model opposite="ConnectedTo" unsettable="true"
	 * @generated
	 */
	IfcElement getRelatingElement();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelConnectsElements#getRelatingElement <em>Relating Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relating Element</em>' reference.
	 * @see #isSetRelatingElement()
	 * @see #unsetRelatingElement()
	 * @see #getRelatingElement()
	 * @generated
	 */
	void setRelatingElement(IfcElement value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelConnectsElements#getRelatingElement <em>Relating Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRelatingElement()
	 * @see #getRelatingElement()
	 * @see #setRelatingElement(IfcElement)
	 * @generated
	 */
	void unsetRelatingElement();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRelConnectsElements#getRelatingElement <em>Relating Element</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Relating Element</em>' reference is set.
	 * @see #unsetRelatingElement()
	 * @see #getRelatingElement()
	 * @see #setRelatingElement(IfcElement)
	 * @generated
	 */
	boolean isSetRelatingElement();

	/**
	 * Returns the value of the '<em><b>Related Element</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcElement#getConnectedFrom <em>Connected From</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Related Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Related Element</em>' reference.
	 * @see #isSetRelatedElement()
	 * @see #unsetRelatedElement()
	 * @see #setRelatedElement(IfcElement)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelConnectsElements_RelatedElement()
	 * @see org.bimserver.models.ifc2x3.IfcElement#getConnectedFrom
	 * @model opposite="ConnectedFrom" unsettable="true"
	 * @generated
	 */
	IfcElement getRelatedElement();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelConnectsElements#getRelatedElement <em>Related Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Related Element</em>' reference.
	 * @see #isSetRelatedElement()
	 * @see #unsetRelatedElement()
	 * @see #getRelatedElement()
	 * @generated
	 */
	void setRelatedElement(IfcElement value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelConnectsElements#getRelatedElement <em>Related Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRelatedElement()
	 * @see #getRelatedElement()
	 * @see #setRelatedElement(IfcElement)
	 * @generated
	 */
	void unsetRelatedElement();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRelConnectsElements#getRelatedElement <em>Related Element</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Related Element</em>' reference is set.
	 * @see #unsetRelatedElement()
	 * @see #getRelatedElement()
	 * @see #setRelatedElement(IfcElement)
	 * @generated
	 */
	boolean isSetRelatedElement();

} // IfcRelConnectsElements
