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
import org.bimserver.models.ifc2x3.IfcRelConnectsPortToElement;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Rel Connects Port To Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelConnectsPortToElementImpl#getRelatingPort <em>Relating Port</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelConnectsPortToElementImpl#getRelatedElement <em>Related Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcRelConnectsPortToElementImpl extends IfcRelConnectsImpl implements IfcRelConnectsPortToElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRelConnectsPortToElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcRelConnectsPortToElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPort getRelatingPort() {
		return (IfcPort)eGet(Ifc2x3Package.eINSTANCE.getIfcRelConnectsPortToElement_RelatingPort(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelatingPort(IfcPort newRelatingPort) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcRelConnectsPortToElement_RelatingPort(), newRelatingPort);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcElement getRelatedElement() {
		return (IfcElement)eGet(Ifc2x3Package.eINSTANCE.getIfcRelConnectsPortToElement_RelatedElement(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelatedElement(IfcElement newRelatedElement) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcRelConnectsPortToElement_RelatedElement(), newRelatedElement);
	}

} //IfcRelConnectsPortToElementImpl
