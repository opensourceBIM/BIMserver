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
package org.bimserver.models.ifc2x3tc1;

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
 * A representation of the model object '<em><b>Ifc Draughting Callout</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcDraughtingCallout#getContents <em>Contents</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcDraughtingCallout#getIsRelatedFromCallout <em>Is Related From Callout</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcDraughtingCallout#getIsRelatedToCallout <em>Is Related To Callout</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcDraughtingCallout()
 * @model
 * @generated
 */
public interface IfcDraughtingCallout extends IfcGeometricRepresentationItem {
	/**
	 * Returns the value of the '<em><b>Contents</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3tc1.IfcDraughtingCalloutElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contents</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contents</em>' reference list.
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcDraughtingCallout_Contents()
	 * @model
	 * @generated
	 */
	EList<IfcDraughtingCalloutElement> getContents();

	/**
	 * Returns the value of the '<em><b>Is Related From Callout</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3tc1.IfcDraughtingCalloutRelationship}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3tc1.IfcDraughtingCalloutRelationship#getRelatedDraughtingCallout <em>Related Draughting Callout</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Related From Callout</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Related From Callout</em>' reference list.
	 * @see #isSetIsRelatedFromCallout()
	 * @see #unsetIsRelatedFromCallout()
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcDraughtingCallout_IsRelatedFromCallout()
	 * @see org.bimserver.models.ifc2x3tc1.IfcDraughtingCalloutRelationship#getRelatedDraughtingCallout
	 * @model opposite="RelatedDraughtingCallout" unsettable="true"
	 * @generated
	 */
	EList<IfcDraughtingCalloutRelationship> getIsRelatedFromCallout();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcDraughtingCallout#getIsRelatedFromCallout <em>Is Related From Callout</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIsRelatedFromCallout()
	 * @see #getIsRelatedFromCallout()
	 * @generated
	 */
	void unsetIsRelatedFromCallout();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcDraughtingCallout#getIsRelatedFromCallout <em>Is Related From Callout</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Is Related From Callout</em>' reference list is set.
	 * @see #unsetIsRelatedFromCallout()
	 * @see #getIsRelatedFromCallout()
	 * @generated
	 */
	boolean isSetIsRelatedFromCallout();

	/**
	 * Returns the value of the '<em><b>Is Related To Callout</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3tc1.IfcDraughtingCalloutRelationship}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3tc1.IfcDraughtingCalloutRelationship#getRelatingDraughtingCallout <em>Relating Draughting Callout</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Related To Callout</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Related To Callout</em>' reference list.
	 * @see #isSetIsRelatedToCallout()
	 * @see #unsetIsRelatedToCallout()
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcDraughtingCallout_IsRelatedToCallout()
	 * @see org.bimserver.models.ifc2x3tc1.IfcDraughtingCalloutRelationship#getRelatingDraughtingCallout
	 * @model opposite="RelatingDraughtingCallout" unsettable="true"
	 * @generated
	 */
	EList<IfcDraughtingCalloutRelationship> getIsRelatedToCallout();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcDraughtingCallout#getIsRelatedToCallout <em>Is Related To Callout</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIsRelatedToCallout()
	 * @see #getIsRelatedToCallout()
	 * @generated
	 */
	void unsetIsRelatedToCallout();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcDraughtingCallout#getIsRelatedToCallout <em>Is Related To Callout</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Is Related To Callout</em>' reference list is set.
	 * @see #unsetIsRelatedToCallout()
	 * @see #getIsRelatedToCallout()
	 * @generated
	 */
	boolean isSetIsRelatedToCallout();

} // IfcDraughtingCallout
