/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcRelDefinesByType;
import org.bimserver.models.ifc2x3.IfcTypeObject;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Rel Defines By Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelDefinesByTypeImpl#getRelatingType <em>Relating Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcRelDefinesByTypeImpl extends IfcRelDefinesImpl implements IfcRelDefinesByType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRelDefinesByTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcRelDefinesByType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTypeObject getRelatingType() {
		return (IfcTypeObject)eGet(Ifc2x3Package.eINSTANCE.getIfcRelDefinesByType_RelatingType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelatingType(IfcTypeObject newRelatingType) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcRelDefinesByType_RelatingType(), newRelatingType);
	}

} //IfcRelDefinesByTypeImpl
