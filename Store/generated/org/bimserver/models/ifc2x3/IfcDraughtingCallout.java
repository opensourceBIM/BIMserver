/**
 * <copyright>
 * </copyright>
 *
 * $Id$
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
public interface IfcDraughtingCallout extends IfcGeometricRepresentationItem {
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
