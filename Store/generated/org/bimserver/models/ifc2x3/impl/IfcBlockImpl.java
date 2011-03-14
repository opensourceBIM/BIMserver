/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcBlock;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Block</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBlockImpl#getXLength <em>XLength</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBlockImpl#getXLengthAsString <em>XLength As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBlockImpl#getYLength <em>YLength</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBlockImpl#getYLengthAsString <em>YLength As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBlockImpl#getZLength <em>ZLength</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBlockImpl#getZLengthAsString <em>ZLength As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcBlockImpl extends IfcCsgPrimitive3DImpl implements IfcBlock {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcBlockImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcBlock();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getXLength() {
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcBlock_XLength(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXLength(float newXLength) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcBlock_XLength(), newXLength);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getXLengthAsString() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcBlock_XLengthAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXLengthAsString(String newXLengthAsString) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcBlock_XLengthAsString(), newXLengthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getYLength() {
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcBlock_YLength(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setYLength(float newYLength) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcBlock_YLength(), newYLength);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getYLengthAsString() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcBlock_YLengthAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setYLengthAsString(String newYLengthAsString) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcBlock_YLengthAsString(), newYLengthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getZLength() {
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcBlock_ZLength(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setZLength(float newZLength) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcBlock_ZLength(), newZLength);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getZLengthAsString() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcBlock_ZLengthAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setZLengthAsString(String newZLengthAsString) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcBlock_ZLengthAsString(), newZLengthAsString);
	}

} //IfcBlockImpl
