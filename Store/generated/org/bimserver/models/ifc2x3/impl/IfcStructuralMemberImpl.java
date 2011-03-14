/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcRelConnectsStructuralElement;
import org.bimserver.models.ifc2x3.IfcRelConnectsStructuralMember;
import org.bimserver.models.ifc2x3.IfcStructuralMember;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Structural Member</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralMemberImpl#getReferencesElement <em>References Element</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralMemberImpl#getConnectedBy <em>Connected By</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcStructuralMemberImpl extends IfcStructuralItemImpl implements IfcStructuralMember {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcStructuralMemberImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcStructuralMember();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelConnectsStructuralElement> getReferencesElement() {
		return (EList<IfcRelConnectsStructuralElement>)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralMember_ReferencesElement(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelConnectsStructuralMember> getConnectedBy() {
		return (EList<IfcRelConnectsStructuralMember>)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralMember_ConnectedBy(), true);
	}

} //IfcStructuralMemberImpl
