/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcSwitchingDeviceType;
import org.bimserver.models.ifc2x3.IfcSwitchingDeviceTypeEnum;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Switching Device Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSwitchingDeviceTypeImpl#getPredefinedType <em>Predefined Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcSwitchingDeviceTypeImpl extends IfcFlowControllerTypeImpl implements IfcSwitchingDeviceType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcSwitchingDeviceTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcSwitchingDeviceType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSwitchingDeviceTypeEnum getPredefinedType() {
		return (IfcSwitchingDeviceTypeEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcSwitchingDeviceType_PredefinedType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPredefinedType(IfcSwitchingDeviceTypeEnum newPredefinedType) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcSwitchingDeviceType_PredefinedType(), newPredefinedType);
	}

} //IfcSwitchingDeviceTypeImpl
