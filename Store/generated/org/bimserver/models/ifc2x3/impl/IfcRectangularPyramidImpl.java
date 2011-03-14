/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcRectangularPyramid;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Rectangular Pyramid</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRectangularPyramidImpl#getXLength <em>XLength</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRectangularPyramidImpl#getXLengthAsString <em>XLength As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRectangularPyramidImpl#getYLength <em>YLength</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRectangularPyramidImpl#getYLengthAsString <em>YLength As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRectangularPyramidImpl#getHeight <em>Height</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRectangularPyramidImpl#getHeightAsString <em>Height As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcRectangularPyramidImpl extends IfcCsgPrimitive3DImpl implements IfcRectangularPyramid {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRectangularPyramidImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcRectangularPyramid();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getXLength() {
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcRectangularPyramid_XLength(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXLength(float newXLength) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcRectangularPyramid_XLength(), newXLength);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getXLengthAsString() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcRectangularPyramid_XLengthAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXLengthAsString(String newXLengthAsString) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcRectangularPyramid_XLengthAsString(), newXLengthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getYLength() {
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcRectangularPyramid_YLength(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setYLength(float newYLength) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcRectangularPyramid_YLength(), newYLength);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getYLengthAsString() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcRectangularPyramid_YLengthAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setYLengthAsString(String newYLengthAsString) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcRectangularPyramid_YLengthAsString(), newYLengthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getHeight() {
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcRectangularPyramid_Height(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeight(float newHeight) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcRectangularPyramid_Height(), newHeight);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHeightAsString() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcRectangularPyramid_HeightAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeightAsString(String newHeightAsString) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcRectangularPyramid_HeightAsString(), newHeightAsString);
	}

} //IfcRectangularPyramidImpl
