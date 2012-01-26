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
 * A representation of the model object '<em><b>Ifc Rel Space Boundary</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRelSpaceBoundary#getRelatingSpace <em>Relating Space</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRelSpaceBoundary#getRelatedBuildingElement <em>Related Building Element</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRelSpaceBoundary#getConnectionGeometry <em>Connection Geometry</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRelSpaceBoundary#getPhysicalOrVirtualBoundary <em>Physical Or Virtual Boundary</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRelSpaceBoundary#getInternalOrExternalBoundary <em>Internal Or External Boundary</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelSpaceBoundary()
 * @model
 * @generated
 */
public interface IfcRelSpaceBoundary extends IfcRelConnects {
	/**
	 * Returns the value of the '<em><b>Relating Space</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcSpace#getBoundedBy <em>Bounded By</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relating Space</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relating Space</em>' reference.
	 * @see #isSetRelatingSpace()
	 * @see #unsetRelatingSpace()
	 * @see #setRelatingSpace(IfcSpace)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelSpaceBoundary_RelatingSpace()
	 * @see org.bimserver.models.ifc2x3.IfcSpace#getBoundedBy
	 * @model opposite="BoundedBy" unsettable="true"
	 * @generated
	 */
	IfcSpace getRelatingSpace();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelSpaceBoundary#getRelatingSpace <em>Relating Space</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relating Space</em>' reference.
	 * @see #isSetRelatingSpace()
	 * @see #unsetRelatingSpace()
	 * @see #getRelatingSpace()
	 * @generated
	 */
	void setRelatingSpace(IfcSpace value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelSpaceBoundary#getRelatingSpace <em>Relating Space</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRelatingSpace()
	 * @see #getRelatingSpace()
	 * @see #setRelatingSpace(IfcSpace)
	 * @generated
	 */
	void unsetRelatingSpace();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRelSpaceBoundary#getRelatingSpace <em>Relating Space</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Relating Space</em>' reference is set.
	 * @see #unsetRelatingSpace()
	 * @see #getRelatingSpace()
	 * @see #setRelatingSpace(IfcSpace)
	 * @generated
	 */
	boolean isSetRelatingSpace();

	/**
	 * Returns the value of the '<em><b>Related Building Element</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcElement#getProvidesBoundaries <em>Provides Boundaries</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Related Building Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Related Building Element</em>' reference.
	 * @see #isSetRelatedBuildingElement()
	 * @see #unsetRelatedBuildingElement()
	 * @see #setRelatedBuildingElement(IfcElement)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelSpaceBoundary_RelatedBuildingElement()
	 * @see org.bimserver.models.ifc2x3.IfcElement#getProvidesBoundaries
	 * @model opposite="ProvidesBoundaries" unsettable="true"
	 * @generated
	 */
	IfcElement getRelatedBuildingElement();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelSpaceBoundary#getRelatedBuildingElement <em>Related Building Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Related Building Element</em>' reference.
	 * @see #isSetRelatedBuildingElement()
	 * @see #unsetRelatedBuildingElement()
	 * @see #getRelatedBuildingElement()
	 * @generated
	 */
	void setRelatedBuildingElement(IfcElement value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelSpaceBoundary#getRelatedBuildingElement <em>Related Building Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRelatedBuildingElement()
	 * @see #getRelatedBuildingElement()
	 * @see #setRelatedBuildingElement(IfcElement)
	 * @generated
	 */
	void unsetRelatedBuildingElement();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRelSpaceBoundary#getRelatedBuildingElement <em>Related Building Element</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Related Building Element</em>' reference is set.
	 * @see #unsetRelatedBuildingElement()
	 * @see #getRelatedBuildingElement()
	 * @see #setRelatedBuildingElement(IfcElement)
	 * @generated
	 */
	boolean isSetRelatedBuildingElement();

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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelSpaceBoundary_ConnectionGeometry()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcConnectionGeometry getConnectionGeometry();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelSpaceBoundary#getConnectionGeometry <em>Connection Geometry</em>}' reference.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelSpaceBoundary#getConnectionGeometry <em>Connection Geometry</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetConnectionGeometry()
	 * @see #getConnectionGeometry()
	 * @see #setConnectionGeometry(IfcConnectionGeometry)
	 * @generated
	 */
	void unsetConnectionGeometry();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRelSpaceBoundary#getConnectionGeometry <em>Connection Geometry</em>}' reference is set.
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
	 * Returns the value of the '<em><b>Physical Or Virtual Boundary</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.IfcPhysicalOrVirtualEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Physical Or Virtual Boundary</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Physical Or Virtual Boundary</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcPhysicalOrVirtualEnum
	 * @see #isSetPhysicalOrVirtualBoundary()
	 * @see #unsetPhysicalOrVirtualBoundary()
	 * @see #setPhysicalOrVirtualBoundary(IfcPhysicalOrVirtualEnum)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelSpaceBoundary_PhysicalOrVirtualBoundary()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcPhysicalOrVirtualEnum getPhysicalOrVirtualBoundary();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelSpaceBoundary#getPhysicalOrVirtualBoundary <em>Physical Or Virtual Boundary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Physical Or Virtual Boundary</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcPhysicalOrVirtualEnum
	 * @see #isSetPhysicalOrVirtualBoundary()
	 * @see #unsetPhysicalOrVirtualBoundary()
	 * @see #getPhysicalOrVirtualBoundary()
	 * @generated
	 */
	void setPhysicalOrVirtualBoundary(IfcPhysicalOrVirtualEnum value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelSpaceBoundary#getPhysicalOrVirtualBoundary <em>Physical Or Virtual Boundary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPhysicalOrVirtualBoundary()
	 * @see #getPhysicalOrVirtualBoundary()
	 * @see #setPhysicalOrVirtualBoundary(IfcPhysicalOrVirtualEnum)
	 * @generated
	 */
	void unsetPhysicalOrVirtualBoundary();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRelSpaceBoundary#getPhysicalOrVirtualBoundary <em>Physical Or Virtual Boundary</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Physical Or Virtual Boundary</em>' attribute is set.
	 * @see #unsetPhysicalOrVirtualBoundary()
	 * @see #getPhysicalOrVirtualBoundary()
	 * @see #setPhysicalOrVirtualBoundary(IfcPhysicalOrVirtualEnum)
	 * @generated
	 */
	boolean isSetPhysicalOrVirtualBoundary();

	/**
	 * Returns the value of the '<em><b>Internal Or External Boundary</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.IfcInternalOrExternalEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Internal Or External Boundary</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Internal Or External Boundary</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcInternalOrExternalEnum
	 * @see #isSetInternalOrExternalBoundary()
	 * @see #unsetInternalOrExternalBoundary()
	 * @see #setInternalOrExternalBoundary(IfcInternalOrExternalEnum)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelSpaceBoundary_InternalOrExternalBoundary()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcInternalOrExternalEnum getInternalOrExternalBoundary();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelSpaceBoundary#getInternalOrExternalBoundary <em>Internal Or External Boundary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Internal Or External Boundary</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcInternalOrExternalEnum
	 * @see #isSetInternalOrExternalBoundary()
	 * @see #unsetInternalOrExternalBoundary()
	 * @see #getInternalOrExternalBoundary()
	 * @generated
	 */
	void setInternalOrExternalBoundary(IfcInternalOrExternalEnum value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelSpaceBoundary#getInternalOrExternalBoundary <em>Internal Or External Boundary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetInternalOrExternalBoundary()
	 * @see #getInternalOrExternalBoundary()
	 * @see #setInternalOrExternalBoundary(IfcInternalOrExternalEnum)
	 * @generated
	 */
	void unsetInternalOrExternalBoundary();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRelSpaceBoundary#getInternalOrExternalBoundary <em>Internal Or External Boundary</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Internal Or External Boundary</em>' attribute is set.
	 * @see #unsetInternalOrExternalBoundary()
	 * @see #getInternalOrExternalBoundary()
	 * @see #setInternalOrExternalBoundary(IfcInternalOrExternalEnum)
	 * @generated
	 */
	boolean isSetInternalOrExternalBoundary();

} // IfcRelSpaceBoundary
