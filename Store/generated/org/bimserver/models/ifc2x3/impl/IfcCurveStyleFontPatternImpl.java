/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.emf.IdEObjectImpl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcCurveStyleFontPattern;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Curve Style Font Pattern</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCurveStyleFontPatternImpl#getVisibleSegmentLength <em>Visible Segment Length</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCurveStyleFontPatternImpl#getVisibleSegmentLengthAsString <em>Visible Segment Length As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCurveStyleFontPatternImpl#getInvisibleSegmentLength <em>Invisible Segment Length</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCurveStyleFontPatternImpl#getInvisibleSegmentLengthAsString <em>Invisible Segment Length As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcCurveStyleFontPatternImpl extends IdEObjectImpl implements IfcCurveStyleFontPattern {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcCurveStyleFontPatternImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcCurveStyleFontPattern();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getVisibleSegmentLength() {
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcCurveStyleFontPattern_VisibleSegmentLength(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVisibleSegmentLength(float newVisibleSegmentLength) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcCurveStyleFontPattern_VisibleSegmentLength(), newVisibleSegmentLength);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVisibleSegmentLengthAsString() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcCurveStyleFontPattern_VisibleSegmentLengthAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVisibleSegmentLengthAsString(String newVisibleSegmentLengthAsString) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcCurveStyleFontPattern_VisibleSegmentLengthAsString(), newVisibleSegmentLengthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getInvisibleSegmentLength() {
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcCurveStyleFontPattern_InvisibleSegmentLength(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInvisibleSegmentLength(float newInvisibleSegmentLength) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcCurveStyleFontPattern_InvisibleSegmentLength(), newInvisibleSegmentLength);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInvisibleSegmentLengthAsString() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcCurveStyleFontPattern_InvisibleSegmentLengthAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInvisibleSegmentLengthAsString(String newInvisibleSegmentLengthAsString) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcCurveStyleFontPattern_InvisibleSegmentLengthAsString(), newInvisibleSegmentLengthAsString);
	}

} //IfcCurveStyleFontPatternImpl
