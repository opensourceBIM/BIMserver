/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcElement;
import org.bimserver.models.ifc2x3.IfcPort;
import org.bimserver.models.ifc2x3.IfcRelConnectsPorts;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Rel Connects Ports</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelConnectsPortsImpl#getRelatingPort <em>Relating Port</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelConnectsPortsImpl#getRelatedPort <em>Related Port</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelConnectsPortsImpl#getRealizingElement <em>Realizing Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcRelConnectsPortsImpl extends IfcRelConnectsImpl implements IfcRelConnectsPorts {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRelConnectsPortsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcRelConnectsPorts();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPort getRelatingPort() {
		return (IfcPort)eGet(Ifc2x3Package.eINSTANCE.getIfcRelConnectsPorts_RelatingPort(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelatingPort(IfcPort newRelatingPort) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcRelConnectsPorts_RelatingPort(), newRelatingPort);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPort getRelatedPort() {
		return (IfcPort)eGet(Ifc2x3Package.eINSTANCE.getIfcRelConnectsPorts_RelatedPort(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelatedPort(IfcPort newRelatedPort) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcRelConnectsPorts_RelatedPort(), newRelatedPort);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcElement getRealizingElement() {
		return (IfcElement)eGet(Ifc2x3Package.eINSTANCE.getIfcRelConnectsPorts_RealizingElement(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRealizingElement(IfcElement newRealizingElement) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcRelConnectsPorts_RealizingElement(), newRealizingElement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRealizingElement() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcRelConnectsPorts_RealizingElement());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRealizingElement() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcRelConnectsPorts_RealizingElement());
	}

} //IfcRelConnectsPortsImpl
