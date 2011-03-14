/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcAxis2Placement3D;
import org.bimserver.models.ifc2x3.IfcDirection;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Axis2 Placement3 D</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcAxis2Placement3DImpl#getAxis <em>Axis</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcAxis2Placement3DImpl#getRefDirection <em>Ref Direction</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcAxis2Placement3DImpl extends IfcPlacementImpl implements IfcAxis2Placement3D {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcAxis2Placement3DImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcAxis2Placement3D();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDirection getAxis() {
		return (IfcDirection)eGet(Ifc2x3Package.eINSTANCE.getIfcAxis2Placement3D_Axis(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAxis(IfcDirection newAxis) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcAxis2Placement3D_Axis(), newAxis);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetAxis() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcAxis2Placement3D_Axis());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetAxis() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcAxis2Placement3D_Axis());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDirection getRefDirection() {
		return (IfcDirection)eGet(Ifc2x3Package.eINSTANCE.getIfcAxis2Placement3D_RefDirection(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefDirection(IfcDirection newRefDirection) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcAxis2Placement3D_RefDirection(), newRefDirection);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRefDirection() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcAxis2Placement3D_RefDirection());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRefDirection() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcAxis2Placement3D_RefDirection());
	}

} //IfcAxis2Placement3DImpl
