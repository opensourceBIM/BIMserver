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
 * A representation of the model object '<em><b>Ifc Draughting Callout</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcDraughtingCallout#getContents <em>Contents</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcDraughtingCallout#getIsRelatedFromCallout <em>Is Related From Callout</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcDraughtingCallout#getIsRelatedToCallout <em>Is Related To Callout</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDraughtingCallout()
 * @model
 * @generated
 */
public interface IfcDraughtingCallout extends IfcGeometricRepresentationItem
{
	/**
	 * Returns the value of the '<em><b>Contents</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcDraughtingCalloutElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contents</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contents</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDraughtingCallout_Contents()
	 * @model
	 * @generated
	 */
	EList<IfcDraughtingCalloutElement> getContents();

	/**
	 * Returns the value of the '<em><b>Is Related From Callout</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcDraughtingCalloutRelationship}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcDraughtingCalloutRelationship#getRelatedDraughtingCallout <em>Related Draughting Callout</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Related From Callout</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Related From Callout</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDraughtingCallout_IsRelatedFromCallout()
	 * @see org.bimserver.models.ifc2x3.IfcDraughtingCalloutRelationship#getRelatedDraughtingCallout
	 * @model opposite="RelatedDraughtingCallout"
	 * @generated
	 */
	EList<IfcDraughtingCalloutRelationship> getIsRelatedFromCallout();

	/**
	 * Returns the value of the '<em><b>Is Related To Callout</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcDraughtingCalloutRelationship}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcDraughtingCalloutRelationship#getRelatingDraughtingCallout <em>Relating Draughting Callout</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Related To Callout</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Related To Callout</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDraughtingCallout_IsRelatedToCallout()
	 * @see org.bimserver.models.ifc2x3.IfcDraughtingCalloutRelationship#getRelatingDraughtingCallout
	 * @model opposite="RelatingDraughtingCallout"
	 * @generated
	 */
	EList<IfcDraughtingCalloutRelationship> getIsRelatedToCallout();

} // IfcDraughtingCallout
