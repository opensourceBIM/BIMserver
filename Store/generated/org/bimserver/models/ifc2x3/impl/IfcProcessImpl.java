/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcProcess;
import org.bimserver.models.ifc2x3.IfcRelAssignsToProcess;
import org.bimserver.models.ifc2x3.IfcRelSequence;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Process</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcProcessImpl#getOperatesOn <em>Operates On</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcProcessImpl#getIsSuccessorFrom <em>Is Successor From</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcProcessImpl#getIsPredecessorTo <em>Is Predecessor To</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcProcessImpl extends IfcObjectImpl implements IfcProcess {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcProcessImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcProcess();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelAssignsToProcess> getOperatesOn() {
		return (EList<IfcRelAssignsToProcess>)eGet(Ifc2x3Package.eINSTANCE.getIfcProcess_OperatesOn(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelSequence> getIsSuccessorFrom() {
		return (EList<IfcRelSequence>)eGet(Ifc2x3Package.eINSTANCE.getIfcProcess_IsSuccessorFrom(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelSequence> getIsPredecessorTo() {
		return (EList<IfcRelSequence>)eGet(Ifc2x3Package.eINSTANCE.getIfcProcess_IsPredecessorTo(), true);
	}

} //IfcProcessImpl
