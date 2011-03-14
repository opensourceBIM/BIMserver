/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcEvaporativeCoolerType;
import org.bimserver.models.ifc2x3.IfcEvaporativeCoolerTypeEnum;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Evaporative Cooler Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcEvaporativeCoolerTypeImpl#getPredefinedType <em>Predefined Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcEvaporativeCoolerTypeImpl extends IfcEnergyConversionDeviceTypeImpl implements IfcEvaporativeCoolerType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcEvaporativeCoolerTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcEvaporativeCoolerType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcEvaporativeCoolerTypeEnum getPredefinedType() {
		return (IfcEvaporativeCoolerTypeEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcEvaporativeCoolerType_PredefinedType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPredefinedType(IfcEvaporativeCoolerTypeEnum newPredefinedType) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcEvaporativeCoolerType_PredefinedType(), newPredefinedType);
	}

} //IfcEvaporativeCoolerTypeImpl
