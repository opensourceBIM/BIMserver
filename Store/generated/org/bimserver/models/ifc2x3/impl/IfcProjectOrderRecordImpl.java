/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcProjectOrderRecord;
import org.bimserver.models.ifc2x3.IfcProjectOrderRecordTypeEnum;
import org.bimserver.models.ifc2x3.IfcRelAssignsToProjectOrder;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Project Order Record</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcProjectOrderRecordImpl#getRecords <em>Records</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcProjectOrderRecordImpl#getPredefinedType <em>Predefined Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcProjectOrderRecordImpl extends IfcControlImpl implements IfcProjectOrderRecord {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcProjectOrderRecordImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcProjectOrderRecord();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelAssignsToProjectOrder> getRecords() {
		return (EList<IfcRelAssignsToProjectOrder>)eGet(Ifc2x3Package.eINSTANCE.getIfcProjectOrderRecord_Records(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcProjectOrderRecordTypeEnum getPredefinedType() {
		return (IfcProjectOrderRecordTypeEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcProjectOrderRecord_PredefinedType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPredefinedType(IfcProjectOrderRecordTypeEnum newPredefinedType) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcProjectOrderRecord_PredefinedType(), newPredefinedType);
	}

} //IfcProjectOrderRecordImpl
