/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.emf.IdEObjectImpl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcColour;
import org.bimserver.models.ifc2x3.IfcTextStyleForDefinedFont;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Text Style For Defined Font</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTextStyleForDefinedFontImpl#getColour <em>Colour</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTextStyleForDefinedFontImpl#getBackgroundColour <em>Background Colour</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcTextStyleForDefinedFontImpl extends IdEObjectImpl implements IfcTextStyleForDefinedFont {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcTextStyleForDefinedFontImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcTextStyleForDefinedFont();
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
	public IfcColour getColour() {
		return (IfcColour)eGet(Ifc2x3Package.eINSTANCE.getIfcTextStyleForDefinedFont_Colour(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColour(IfcColour newColour) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcTextStyleForDefinedFont_Colour(), newColour);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcColour getBackgroundColour() {
		return (IfcColour)eGet(Ifc2x3Package.eINSTANCE.getIfcTextStyleForDefinedFont_BackgroundColour(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBackgroundColour(IfcColour newBackgroundColour) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcTextStyleForDefinedFont_BackgroundColour(), newBackgroundColour);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetBackgroundColour() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcTextStyleForDefinedFont_BackgroundColour());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetBackgroundColour() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcTextStyleForDefinedFont_BackgroundColour());
	}

} //IfcTextStyleForDefinedFontImpl
