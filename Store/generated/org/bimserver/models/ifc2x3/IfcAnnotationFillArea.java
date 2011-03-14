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
 * A representation of the model object '<em><b>Ifc Annotation Fill Area</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcAnnotationFillArea#getOuterBoundary <em>Outer Boundary</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcAnnotationFillArea#getInnerBoundaries <em>Inner Boundaries</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcAnnotationFillArea()
 * @model
 * @generated
 */
public interface IfcAnnotationFillArea extends IfcGeometricRepresentationItem {
	/**
	 * Returns the value of the '<em><b>Outer Boundary</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outer Boundary</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outer Boundary</em>' reference.
	 * @see #setOuterBoundary(IfcCurve)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcAnnotationFillArea_OuterBoundary()
	 * @model
	 * @generated
	 */
	IfcCurve getOuterBoundary();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcAnnotationFillArea#getOuterBoundary <em>Outer Boundary</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outer Boundary</em>' reference.
	 * @see #getOuterBoundary()
	 * @generated
	 */
	void setOuterBoundary(IfcCurve value);

	/**
	 * Returns the value of the '<em><b>Inner Boundaries</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcCurve}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inner Boundaries</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inner Boundaries</em>' reference list.
	 * @see #isSetInnerBoundaries()
	 * @see #unsetInnerBoundaries()
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcAnnotationFillArea_InnerBoundaries()
	 * @model unsettable="true"
	 * @generated
	 */
	EList<IfcCurve> getInnerBoundaries();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcAnnotationFillArea#getInnerBoundaries <em>Inner Boundaries</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetInnerBoundaries()
	 * @see #getInnerBoundaries()
	 * @generated
	 */
	void unsetInnerBoundaries();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcAnnotationFillArea#getInnerBoundaries <em>Inner Boundaries</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Inner Boundaries</em>' reference list is set.
	 * @see #unsetInnerBoundaries()
	 * @see #getInnerBoundaries()
	 * @generated
	 */
	boolean isSetInnerBoundaries();

} // IfcAnnotationFillArea
