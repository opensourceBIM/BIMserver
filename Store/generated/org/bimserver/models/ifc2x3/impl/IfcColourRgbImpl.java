/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcColourRgb;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Colour Rgb</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcColourRgbImpl#getRed <em>Red</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcColourRgbImpl#getRedAsString <em>Red As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcColourRgbImpl#getGreen <em>Green</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcColourRgbImpl#getGreenAsString <em>Green As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcColourRgbImpl#getBlue <em>Blue</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcColourRgbImpl#getBlueAsString <em>Blue As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcColourRgbImpl extends IfcColourSpecificationImpl implements IfcColourRgb {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcColourRgbImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcColourRgb();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getRed() {
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcColourRgb_Red(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRed(float newRed) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcColourRgb_Red(), newRed);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRedAsString() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcColourRgb_RedAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRedAsString(String newRedAsString) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcColourRgb_RedAsString(), newRedAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getGreen() {
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcColourRgb_Green(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGreen(float newGreen) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcColourRgb_Green(), newGreen);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGreenAsString() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcColourRgb_GreenAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGreenAsString(String newGreenAsString) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcColourRgb_GreenAsString(), newGreenAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getBlue() {
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcColourRgb_Blue(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBlue(float newBlue) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcColourRgb_Blue(), newBlue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBlueAsString() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcColourRgb_BlueAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBlueAsString(String newBlueAsString) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcColourRgb_BlueAsString(), newBlueAsString);
	}

} //IfcColourRgbImpl
