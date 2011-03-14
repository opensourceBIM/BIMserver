/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcCableCarrierFittingType;
import org.bimserver.models.ifc2x3.IfcCableCarrierFittingTypeEnum;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Cable Carrier Fitting Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCableCarrierFittingTypeImpl#getPredefinedType <em>Predefined Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcCableCarrierFittingTypeImpl extends IfcFlowFittingTypeImpl implements IfcCableCarrierFittingType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcCableCarrierFittingTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcCableCarrierFittingType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCableCarrierFittingTypeEnum getPredefinedType() {
		return (IfcCableCarrierFittingTypeEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcCableCarrierFittingType_PredefinedType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPredefinedType(IfcCableCarrierFittingTypeEnum newPredefinedType) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcCableCarrierFittingType_PredefinedType(), newPredefinedType);
	}

} //IfcCableCarrierFittingTypeImpl
