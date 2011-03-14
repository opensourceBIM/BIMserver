/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcFlowInstrumentType;
import org.bimserver.models.ifc2x3.IfcFlowInstrumentTypeEnum;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Flow Instrument Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcFlowInstrumentTypeImpl#getPredefinedType <em>Predefined Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcFlowInstrumentTypeImpl extends IfcDistributionControlElementTypeImpl implements IfcFlowInstrumentType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcFlowInstrumentTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcFlowInstrumentType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcFlowInstrumentTypeEnum getPredefinedType() {
		return (IfcFlowInstrumentTypeEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcFlowInstrumentType_PredefinedType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPredefinedType(IfcFlowInstrumentTypeEnum newPredefinedType) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcFlowInstrumentType_PredefinedType(), newPredefinedType);
	}

} //IfcFlowInstrumentTypeImpl
