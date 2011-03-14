/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcDistributionControlElement;
import org.bimserver.models.ifc2x3.IfcDistributionFlowElement;
import org.bimserver.models.ifc2x3.IfcRelFlowControlElements;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Rel Flow Control Elements</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelFlowControlElementsImpl#getRelatedControlElements <em>Related Control Elements</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelFlowControlElementsImpl#getRelatingFlowElement <em>Relating Flow Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcRelFlowControlElementsImpl extends IfcRelConnectsImpl implements IfcRelFlowControlElements {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRelFlowControlElementsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcRelFlowControlElements();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcDistributionControlElement> getRelatedControlElements() {
		return (EList<IfcDistributionControlElement>)eGet(Ifc2x3Package.eINSTANCE.getIfcRelFlowControlElements_RelatedControlElements(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDistributionFlowElement getRelatingFlowElement() {
		return (IfcDistributionFlowElement)eGet(Ifc2x3Package.eINSTANCE.getIfcRelFlowControlElements_RelatingFlowElement(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelatingFlowElement(IfcDistributionFlowElement newRelatingFlowElement) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcRelFlowControlElements_RelatingFlowElement(), newRelatingFlowElement);
	}

} //IfcRelFlowControlElementsImpl
