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
 * A representation of the model object '<em><b>Ifc Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcElement#getTag <em>Tag</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcElement#getFillsVoids <em>Fills Voids</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcElement#getConnectedTo <em>Connected To</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcElement#getHasCoverings <em>Has Coverings</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcElement#getHasProjections <em>Has Projections</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcElement#getHasStructuralMember <em>Has Structural Member</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcElement#getReferencedInStructures <em>Referenced In Structures</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcElement#getHasPorts <em>Has Ports</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcElement#getHasOpenings <em>Has Openings</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcElement#getIsConnectionRealization <em>Is Connection Realization</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcElement#getProvidesBoundaries <em>Provides Boundaries</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcElement#getConnectedFrom <em>Connected From</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcElement#getContainedInStructure <em>Contained In Structure</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcElement()
 * @model
 * @generated
 */
public interface IfcElement extends IfcProduct, IfcStructuralActivityAssignmentSelect
{
	/**
	 * Returns the value of the '<em><b>Tag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tag</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tag</em>' attribute.
	 * @see #isSetTag()
	 * @see #unsetTag()
	 * @see #setTag(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcElement_Tag()
	 * @model unsettable="true"
	 * @generated
	 */
	String getTag();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcElement#getTag <em>Tag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tag</em>' attribute.
	 * @see #isSetTag()
	 * @see #unsetTag()
	 * @see #getTag()
	 * @generated
	 */
	void setTag(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcElement#getTag <em>Tag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTag()
	 * @see #getTag()
	 * @see #setTag(String)
	 * @generated
	 */
	void unsetTag();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcElement#getTag <em>Tag</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Tag</em>' attribute is set.
	 * @see #unsetTag()
	 * @see #getTag()
	 * @see #setTag(String)
	 * @generated
	 */
	boolean isSetTag();

	/**
	 * Returns the value of the '<em><b>Fills Voids</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcRelFillsElement}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcRelFillsElement#getRelatedBuildingElement <em>Related Building Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fills Voids</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fills Voids</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcElement_FillsVoids()
	 * @see org.bimserver.models.ifc2x3.IfcRelFillsElement#getRelatedBuildingElement
	 * @model opposite="RelatedBuildingElement" upper="2"
	 * @generated
	 */
	EList<IfcRelFillsElement> getFillsVoids();

	/**
	 * Returns the value of the '<em><b>Connected To</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcRelConnectsElements}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcRelConnectsElements#getRelatingElement <em>Relating Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connected To</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connected To</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcElement_ConnectedTo()
	 * @see org.bimserver.models.ifc2x3.IfcRelConnectsElements#getRelatingElement
	 * @model opposite="RelatingElement"
	 * @generated
	 */
	EList<IfcRelConnectsElements> getConnectedTo();

	/**
	 * Returns the value of the '<em><b>Has Coverings</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcRelCoversBldgElements}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcRelCoversBldgElements#getRelatingBuildingElement <em>Relating Building Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Coverings</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Coverings</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcElement_HasCoverings()
	 * @see org.bimserver.models.ifc2x3.IfcRelCoversBldgElements#getRelatingBuildingElement
	 * @model opposite="RelatingBuildingElement"
	 * @generated
	 */
	EList<IfcRelCoversBldgElements> getHasCoverings();

	/**
	 * Returns the value of the '<em><b>Has Projections</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcRelProjectsElement}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcRelProjectsElement#getRelatingElement <em>Relating Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Projections</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Projections</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcElement_HasProjections()
	 * @see org.bimserver.models.ifc2x3.IfcRelProjectsElement#getRelatingElement
	 * @model opposite="RelatingElement"
	 * @generated
	 */
	EList<IfcRelProjectsElement> getHasProjections();

	/**
	 * Returns the value of the '<em><b>Has Structural Member</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcRelConnectsStructuralElement}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcRelConnectsStructuralElement#getRelatingElement <em>Relating Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Structural Member</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Structural Member</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcElement_HasStructuralMember()
	 * @see org.bimserver.models.ifc2x3.IfcRelConnectsStructuralElement#getRelatingElement
	 * @model opposite="RelatingElement"
	 * @generated
	 */
	EList<IfcRelConnectsStructuralElement> getHasStructuralMember();

	/**
	 * Returns the value of the '<em><b>Referenced In Structures</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcRelReferencedInSpatialStructure}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referenced In Structures</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenced In Structures</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcElement_ReferencedInStructures()
	 * @model
	 * @generated
	 */
	EList<IfcRelReferencedInSpatialStructure> getReferencedInStructures();

	/**
	 * Returns the value of the '<em><b>Has Ports</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcRelConnectsPortToElement}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcRelConnectsPortToElement#getRelatedElement <em>Related Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Ports</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Ports</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcElement_HasPorts()
	 * @see org.bimserver.models.ifc2x3.IfcRelConnectsPortToElement#getRelatedElement
	 * @model opposite="RelatedElement"
	 * @generated
	 */
	EList<IfcRelConnectsPortToElement> getHasPorts();

	/**
	 * Returns the value of the '<em><b>Has Openings</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcRelVoidsElement}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcRelVoidsElement#getRelatingBuildingElement <em>Relating Building Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Openings</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Openings</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcElement_HasOpenings()
	 * @see org.bimserver.models.ifc2x3.IfcRelVoidsElement#getRelatingBuildingElement
	 * @model opposite="RelatingBuildingElement"
	 * @generated
	 */
	EList<IfcRelVoidsElement> getHasOpenings();

	/**
	 * Returns the value of the '<em><b>Is Connection Realization</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcRelConnectsWithRealizingElements}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcRelConnectsWithRealizingElements#getRealizingElements <em>Realizing Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Connection Realization</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Connection Realization</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcElement_IsConnectionRealization()
	 * @see org.bimserver.models.ifc2x3.IfcRelConnectsWithRealizingElements#getRealizingElements
	 * @model opposite="RealizingElements"
	 * @generated
	 */
	EList<IfcRelConnectsWithRealizingElements> getIsConnectionRealization();

	/**
	 * Returns the value of the '<em><b>Provides Boundaries</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcRelSpaceBoundary}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcRelSpaceBoundary#getRelatedBuildingElement <em>Related Building Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provides Boundaries</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provides Boundaries</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcElement_ProvidesBoundaries()
	 * @see org.bimserver.models.ifc2x3.IfcRelSpaceBoundary#getRelatedBuildingElement
	 * @model opposite="RelatedBuildingElement"
	 * @generated
	 */
	EList<IfcRelSpaceBoundary> getProvidesBoundaries();

	/**
	 * Returns the value of the '<em><b>Connected From</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcRelConnectsElements}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcRelConnectsElements#getRelatedElement <em>Related Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connected From</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connected From</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcElement_ConnectedFrom()
	 * @see org.bimserver.models.ifc2x3.IfcRelConnectsElements#getRelatedElement
	 * @model opposite="RelatedElement"
	 * @generated
	 */
	EList<IfcRelConnectsElements> getConnectedFrom();

	/**
	 * Returns the value of the '<em><b>Contained In Structure</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcRelContainedInSpatialStructure}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contained In Structure</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contained In Structure</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcElement_ContainedInStructure()
	 * @model upper="2"
	 * @generated
	 */
	EList<IfcRelContainedInSpatialStructure> getContainedInStructure();

} // IfcElement
