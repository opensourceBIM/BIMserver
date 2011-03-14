/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcElement;
import org.bimserver.models.ifc2x3.IfcRelConnectsStructuralElement;
import org.bimserver.models.ifc2x3.IfcStructuralMember;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Rel Connects Structural Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelConnectsStructuralElementImpl#getRelatingElement <em>Relating Element</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelConnectsStructuralElementImpl#getRelatedStructuralMember <em>Related Structural Member</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcRelConnectsStructuralElementImpl extends IfcRelConnectsImpl implements IfcRelConnectsStructuralElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRelConnectsStructuralElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcRelConnectsStructuralElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcElement getRelatingElement() {
		return (IfcElement)eGet(Ifc2x3Package.eINSTANCE.getIfcRelConnectsStructuralElement_RelatingElement(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelatingElement(IfcElement newRelatingElement) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcRelConnectsStructuralElement_RelatingElement(), newRelatingElement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStructuralMember getRelatedStructuralMember() {
		return (IfcStructuralMember)eGet(Ifc2x3Package.eINSTANCE.getIfcRelConnectsStructuralElement_RelatedStructuralMember(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelatedStructuralMember(IfcStructuralMember newRelatedStructuralMember) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcRelConnectsStructuralElement_RelatedStructuralMember(), newRelatedStructuralMember);
	}

} //IfcRelConnectsStructuralElementImpl
