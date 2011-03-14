/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcDistributionPort;
import org.bimserver.models.ifc2x3.IfcFlowDirectionEnum;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Distribution Port</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDistributionPortImpl#getFlowDirection <em>Flow Direction</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcDistributionPortImpl extends IfcPortImpl implements IfcDistributionPort {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcDistributionPortImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcDistributionPort();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcFlowDirectionEnum getFlowDirection() {
		return (IfcFlowDirectionEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcDistributionPort_FlowDirection(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFlowDirection(IfcFlowDirectionEnum newFlowDirection) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcDistributionPort_FlowDirection(), newFlowDirection);
	}

} //IfcDistributionPortImpl
