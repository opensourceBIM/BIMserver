/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcHeatExchangerType;
import org.bimserver.models.ifc2x3.IfcHeatExchangerTypeEnum;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Heat Exchanger Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcHeatExchangerTypeImpl#getPredefinedType <em>Predefined Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcHeatExchangerTypeImpl extends IfcEnergyConversionDeviceTypeImpl implements IfcHeatExchangerType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcHeatExchangerTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcHeatExchangerType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcHeatExchangerTypeEnum getPredefinedType() {
		return (IfcHeatExchangerTypeEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcHeatExchangerType_PredefinedType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPredefinedType(IfcHeatExchangerTypeEnum newPredefinedType) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcHeatExchangerType_PredefinedType(), newPredefinedType);
	}

} //IfcHeatExchangerTypeImpl
