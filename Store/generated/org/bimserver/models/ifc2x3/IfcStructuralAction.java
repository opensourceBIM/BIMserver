/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Structural Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcStructuralAction#getDestabilizingLoad <em>Destabilizing Load</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcStructuralAction#getCausedBy <em>Caused By</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralAction()
 * @model
 * @generated
 */
public interface IfcStructuralAction extends IfcStructuralActivity {
	/**
	 * Returns the value of the '<em><b>Destabilizing Load</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.Tristate}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Destabilizing Load</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destabilizing Load</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.Tristate
	 * @see #setDestabilizingLoad(Tristate)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralAction_DestabilizingLoad()
	 * @model
	 * @generated
	 */
	Tristate getDestabilizingLoad();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralAction#getDestabilizingLoad <em>Destabilizing Load</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Destabilizing Load</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.Tristate
	 * @see #getDestabilizingLoad()
	 * @generated
	 */
	void setDestabilizingLoad(Tristate value);

	/**
	 * Returns the value of the '<em><b>Caused By</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcStructuralReaction#getCauses <em>Causes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Caused By</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Caused By</em>' reference.
	 * @see #isSetCausedBy()
	 * @see #unsetCausedBy()
	 * @see #setCausedBy(IfcStructuralReaction)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralAction_CausedBy()
	 * @see org.bimserver.models.ifc2x3.IfcStructuralReaction#getCauses
	 * @model opposite="Causes" unsettable="true"
	 * @generated
	 */
	IfcStructuralReaction getCausedBy();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralAction#getCausedBy <em>Caused By</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Caused By</em>' reference.
	 * @see #isSetCausedBy()
	 * @see #unsetCausedBy()
	 * @see #getCausedBy()
	 * @generated
	 */
	void setCausedBy(IfcStructuralReaction value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralAction#getCausedBy <em>Caused By</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCausedBy()
	 * @see #getCausedBy()
	 * @see #setCausedBy(IfcStructuralReaction)
	 * @generated
	 */
	void unsetCausedBy();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralAction#getCausedBy <em>Caused By</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Caused By</em>' reference is set.
	 * @see #unsetCausedBy()
	 * @see #getCausedBy()
	 * @see #setCausedBy(IfcStructuralReaction)
	 * @generated
	 */
	boolean isSetCausedBy();

} // IfcStructuralAction
