/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Face Bound</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcFaceBound#getBound <em>Bound</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcFaceBound#getOrientation <em>Orientation</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcFaceBound()
 * @model
 * @generated
 */
public interface IfcFaceBound extends IfcTopologicalRepresentationItem {
	/**
	 * Returns the value of the '<em><b>Bound</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bound</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bound</em>' reference.
	 * @see #setBound(IfcLoop)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcFaceBound_Bound()
	 * @model
	 * @generated
	 */
	IfcLoop getBound();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcFaceBound#getBound <em>Bound</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bound</em>' reference.
	 * @see #getBound()
	 * @generated
	 */
	void setBound(IfcLoop value);

	/**
	 * Returns the value of the '<em><b>Orientation</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.Tristate}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Orientation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Orientation</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.Tristate
	 * @see #setOrientation(Tristate)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcFaceBound_Orientation()
	 * @model
	 * @generated
	 */
	Tristate getOrientation();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcFaceBound#getOrientation <em>Orientation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Orientation</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.Tristate
	 * @see #getOrientation()
	 * @generated
	 */
	void setOrientation(Tristate value);

} // IfcFaceBound
