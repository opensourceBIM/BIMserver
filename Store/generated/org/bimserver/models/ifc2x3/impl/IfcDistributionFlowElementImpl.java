/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcDistributionFlowElement;
import org.bimserver.models.ifc2x3.IfcRelFlowControlElements;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Distribution Flow Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDistributionFlowElementImpl#getHasControlElements <em>Has Control Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcDistributionFlowElementImpl extends IfcDistributionElementImpl implements IfcDistributionFlowElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcDistributionFlowElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcDistributionFlowElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelFlowControlElements> getHasControlElements() {
		return (EList<IfcRelFlowControlElements>)eGet(Ifc2x3Package.eINSTANCE.getIfcDistributionFlowElement_HasControlElements(), true);
	}

} //IfcDistributionFlowElementImpl
