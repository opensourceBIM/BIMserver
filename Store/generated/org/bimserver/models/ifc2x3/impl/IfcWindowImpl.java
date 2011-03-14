/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcWindow;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Window</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcWindowImpl#getOverallHeight <em>Overall Height</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcWindowImpl#getOverallHeightAsString <em>Overall Height As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcWindowImpl#getOverallWidth <em>Overall Width</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcWindowImpl#getOverallWidthAsString <em>Overall Width As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcWindowImpl extends IfcBuildingElementImpl implements IfcWindow {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcWindowImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcWindow();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getOverallHeight() {
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcWindow_OverallHeight(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOverallHeight(float newOverallHeight) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcWindow_OverallHeight(), newOverallHeight);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetOverallHeight() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcWindow_OverallHeight());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOverallHeight() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcWindow_OverallHeight());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOverallHeightAsString() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcWindow_OverallHeightAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOverallHeightAsString(String newOverallHeightAsString) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcWindow_OverallHeightAsString(), newOverallHeightAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetOverallHeightAsString() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcWindow_OverallHeightAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOverallHeightAsString() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcWindow_OverallHeightAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getOverallWidth() {
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcWindow_OverallWidth(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOverallWidth(float newOverallWidth) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcWindow_OverallWidth(), newOverallWidth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetOverallWidth() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcWindow_OverallWidth());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOverallWidth() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcWindow_OverallWidth());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOverallWidthAsString() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcWindow_OverallWidthAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOverallWidthAsString(String newOverallWidthAsString) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcWindow_OverallWidthAsString(), newOverallWidthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetOverallWidthAsString() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcWindow_OverallWidthAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOverallWidthAsString() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcWindow_OverallWidthAsString());
	}

} //IfcWindowImpl
