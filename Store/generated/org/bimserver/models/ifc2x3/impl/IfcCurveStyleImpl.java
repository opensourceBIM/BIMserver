/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcColour;
import org.bimserver.models.ifc2x3.IfcCurveFontOrScaledCurveFontSelect;
import org.bimserver.models.ifc2x3.IfcCurveStyle;
import org.bimserver.models.ifc2x3.IfcSizeSelect;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Curve Style</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCurveStyleImpl#getCurveFont <em>Curve Font</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCurveStyleImpl#getCurveWidth <em>Curve Width</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCurveStyleImpl#getCurveColour <em>Curve Colour</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcCurveStyleImpl extends IfcPresentationStyleImpl implements IfcCurveStyle {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcCurveStyleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcCurveStyle();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCurveFontOrScaledCurveFontSelect getCurveFont() {
		return (IfcCurveFontOrScaledCurveFontSelect)eGet(Ifc2x3Package.eINSTANCE.getIfcCurveStyle_CurveFont(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurveFont(IfcCurveFontOrScaledCurveFontSelect newCurveFont) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcCurveStyle_CurveFont(), newCurveFont);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCurveFont() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcCurveStyle_CurveFont());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCurveFont() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcCurveStyle_CurveFont());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSizeSelect getCurveWidth() {
		return (IfcSizeSelect)eGet(Ifc2x3Package.eINSTANCE.getIfcCurveStyle_CurveWidth(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurveWidth(IfcSizeSelect newCurveWidth) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcCurveStyle_CurveWidth(), newCurveWidth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCurveWidth() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcCurveStyle_CurveWidth());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCurveWidth() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcCurveStyle_CurveWidth());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcColour getCurveColour() {
		return (IfcColour)eGet(Ifc2x3Package.eINSTANCE.getIfcCurveStyle_CurveColour(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurveColour(IfcColour newCurveColour) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcCurveStyle_CurveColour(), newCurveColour);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCurveColour() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcCurveStyle_CurveColour());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCurveColour() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcCurveStyle_CurveColour());
	}

} //IfcCurveStyleImpl
