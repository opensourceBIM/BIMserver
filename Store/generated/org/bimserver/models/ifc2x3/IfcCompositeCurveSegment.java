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
 * A representation of the model object '<em><b>Ifc Composite Curve Segment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCompositeCurveSegment#getTransition <em>Transition</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCompositeCurveSegment#getSameSense <em>Same Sense</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCompositeCurveSegment#getParentCurve <em>Parent Curve</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCompositeCurveSegment#getUsingCurves <em>Using Curves</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCompositeCurveSegment#getDim <em>Dim</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCompositeCurveSegment()
 * @model
 * @generated
 */
public interface IfcCompositeCurveSegment extends IfcGeometricRepresentationItem {
	/**
	 * Returns the value of the '<em><b>Transition</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.IfcTransitionCode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transition</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcTransitionCode
	 * @see #setTransition(IfcTransitionCode)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCompositeCurveSegment_Transition()
	 * @model
	 * @generated
	 */
	IfcTransitionCode getTransition();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCompositeCurveSegment#getTransition <em>Transition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transition</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcTransitionCode
	 * @see #getTransition()
	 * @generated
	 */
	void setTransition(IfcTransitionCode value);

	/**
	 * Returns the value of the '<em><b>Same Sense</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.Tristate}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Same Sense</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Same Sense</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.Tristate
	 * @see #setSameSense(Tristate)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCompositeCurveSegment_SameSense()
	 * @model
	 * @generated
	 */
	Tristate getSameSense();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCompositeCurveSegment#getSameSense <em>Same Sense</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Same Sense</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.Tristate
	 * @see #getSameSense()
	 * @generated
	 */
	void setSameSense(Tristate value);

	/**
	 * Returns the value of the '<em><b>Parent Curve</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Curve</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Curve</em>' reference.
	 * @see #setParentCurve(IfcCurve)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCompositeCurveSegment_ParentCurve()
	 * @model
	 * @generated
	 */
	IfcCurve getParentCurve();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCompositeCurveSegment#getParentCurve <em>Parent Curve</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Curve</em>' reference.
	 * @see #getParentCurve()
	 * @generated
	 */
	void setParentCurve(IfcCurve value);

	/**
	 * Returns the value of the '<em><b>Using Curves</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcCompositeCurve}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcCompositeCurve#getSegments <em>Segments</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Using Curves</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Using Curves</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCompositeCurveSegment_UsingCurves()
	 * @see org.bimserver.models.ifc2x3.IfcCompositeCurve#getSegments
	 * @model opposite="Segments"
	 * @generated
	 */
	EList<IfcCompositeCurve> getUsingCurves();

	/**
	 * Returns the value of the '<em><b>Dim</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dim</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dim</em>' attribute.
	 * @see #setDim(int)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCompositeCurveSegment_Dim()
	 * @model derived="true"
	 * @generated
	 */
	int getDim();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCompositeCurveSegment#getDim <em>Dim</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dim</em>' attribute.
	 * @see #getDim()
	 * @generated
	 */
	void setDim(int value);

} // IfcCompositeCurveSegment
