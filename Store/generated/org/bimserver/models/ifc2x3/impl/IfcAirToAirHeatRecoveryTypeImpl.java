/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcAirToAirHeatRecoveryType;
import org.bimserver.models.ifc2x3.IfcAirToAirHeatRecoveryTypeEnum;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Air To Air Heat Recovery Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcAirToAirHeatRecoveryTypeImpl#getPredefinedType <em>Predefined Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcAirToAirHeatRecoveryTypeImpl extends IfcEnergyConversionDeviceTypeImpl implements IfcAirToAirHeatRecoveryType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcAirToAirHeatRecoveryTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcAirToAirHeatRecoveryType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAirToAirHeatRecoveryTypeEnum getPredefinedType() {
		return (IfcAirToAirHeatRecoveryTypeEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcAirToAirHeatRecoveryType_PredefinedType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPredefinedType(IfcAirToAirHeatRecoveryTypeEnum newPredefinedType) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcAirToAirHeatRecoveryType_PredefinedType(), newPredefinedType);
	}

} //IfcAirToAirHeatRecoveryTypeImpl
