/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Local Placement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcLocalPlacement#getPlacementRelTo <em>Placement Rel To</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcLocalPlacement#getRelativePlacement <em>Relative Placement</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLocalPlacement()
 * @model
 * @generated
 */
public interface IfcLocalPlacement extends IfcObjectPlacement {
	/**
	 * Returns the value of the '<em><b>Placement Rel To</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcObjectPlacement#getReferencedByPlacements <em>Referenced By Placements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Placement Rel To</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Placement Rel To</em>' reference.
	 * @see #isSetPlacementRelTo()
	 * @see #unsetPlacementRelTo()
	 * @see #setPlacementRelTo(IfcObjectPlacement)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLocalPlacement_PlacementRelTo()
	 * @see org.bimserver.models.ifc2x3.IfcObjectPlacement#getReferencedByPlacements
	 * @model opposite="ReferencedByPlacements" unsettable="true"
	 * @generated
	 */
	IfcObjectPlacement getPlacementRelTo();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcLocalPlacement#getPlacementRelTo <em>Placement Rel To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Placement Rel To</em>' reference.
	 * @see #isSetPlacementRelTo()
	 * @see #unsetPlacementRelTo()
	 * @see #getPlacementRelTo()
	 * @generated
	 */
	void setPlacementRelTo(IfcObjectPlacement value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcLocalPlacement#getPlacementRelTo <em>Placement Rel To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPlacementRelTo()
	 * @see #getPlacementRelTo()
	 * @see #setPlacementRelTo(IfcObjectPlacement)
	 * @generated
	 */
	void unsetPlacementRelTo();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcLocalPlacement#getPlacementRelTo <em>Placement Rel To</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Placement Rel To</em>' reference is set.
	 * @see #unsetPlacementRelTo()
	 * @see #getPlacementRelTo()
	 * @see #setPlacementRelTo(IfcObjectPlacement)
	 * @generated
	 */
	boolean isSetPlacementRelTo();

	/**
	 * Returns the value of the '<em><b>Relative Placement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relative Placement</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relative Placement</em>' reference.
	 * @see #setRelativePlacement(IfcAxis2Placement)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLocalPlacement_RelativePlacement()
	 * @model
	 * @generated
	 */
	IfcAxis2Placement getRelativePlacement();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcLocalPlacement#getRelativePlacement <em>Relative Placement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relative Placement</em>' reference.
	 * @see #getRelativePlacement()
	 * @generated
	 */
	void setRelativePlacement(IfcAxis2Placement value);

} // IfcLocalPlacement
