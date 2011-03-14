/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcConnectionTypeEnum;
import org.bimserver.models.ifc2x3.IfcRelConnectsPathElements;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Rel Connects Path Elements</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelConnectsPathElementsImpl#getRelatingPriorities <em>Relating Priorities</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelConnectsPathElementsImpl#getRelatedPriorities <em>Related Priorities</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelConnectsPathElementsImpl#getRelatedConnectionType <em>Related Connection Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelConnectsPathElementsImpl#getRelatingConnectionType <em>Relating Connection Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcRelConnectsPathElementsImpl extends IfcRelConnectsElementsImpl implements IfcRelConnectsPathElements {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRelConnectsPathElementsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcRelConnectsPathElements();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Integer> getRelatingPriorities() {
		return (EList<Integer>)eGet(Ifc2x3Package.eINSTANCE.getIfcRelConnectsPathElements_RelatingPriorities(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Integer> getRelatedPriorities() {
		return (EList<Integer>)eGet(Ifc2x3Package.eINSTANCE.getIfcRelConnectsPathElements_RelatedPriorities(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcConnectionTypeEnum getRelatedConnectionType() {
		return (IfcConnectionTypeEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcRelConnectsPathElements_RelatedConnectionType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelatedConnectionType(IfcConnectionTypeEnum newRelatedConnectionType) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcRelConnectsPathElements_RelatedConnectionType(), newRelatedConnectionType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcConnectionTypeEnum getRelatingConnectionType() {
		return (IfcConnectionTypeEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcRelConnectsPathElements_RelatingConnectionType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelatingConnectionType(IfcConnectionTypeEnum newRelatingConnectionType) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcRelConnectsPathElements_RelatingConnectionType(), newRelatingConnectionType);
	}

} //IfcRelConnectsPathElementsImpl
