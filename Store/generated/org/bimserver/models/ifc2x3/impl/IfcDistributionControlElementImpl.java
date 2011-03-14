/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcDistributionControlElement;
import org.bimserver.models.ifc2x3.IfcRelFlowControlElements;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Distribution Control Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDistributionControlElementImpl#getControlElementId <em>Control Element Id</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDistributionControlElementImpl#getAssignedToFlowElement <em>Assigned To Flow Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcDistributionControlElementImpl extends IfcDistributionElementImpl implements IfcDistributionControlElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcDistributionControlElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcDistributionControlElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getControlElementId() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcDistributionControlElement_ControlElementId(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setControlElementId(String newControlElementId) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcDistributionControlElement_ControlElementId(), newControlElementId);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetControlElementId() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcDistributionControlElement_ControlElementId());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetControlElementId() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcDistributionControlElement_ControlElementId());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelFlowControlElements> getAssignedToFlowElement() {
		return (EList<IfcRelFlowControlElements>)eGet(Ifc2x3Package.eINSTANCE.getIfcDistributionControlElement_AssignedToFlowElement(), true);
	}

} //IfcDistributionControlElementImpl
