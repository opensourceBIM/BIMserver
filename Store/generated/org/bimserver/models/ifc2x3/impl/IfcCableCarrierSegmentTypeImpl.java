/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcCableCarrierSegmentType;
import org.bimserver.models.ifc2x3.IfcCableCarrierSegmentTypeEnum;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Cable Carrier Segment Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCableCarrierSegmentTypeImpl#getPredefinedType <em>Predefined Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcCableCarrierSegmentTypeImpl extends IfcFlowSegmentTypeImpl implements IfcCableCarrierSegmentType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcCableCarrierSegmentTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcCableCarrierSegmentType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCableCarrierSegmentTypeEnum getPredefinedType() {
		return (IfcCableCarrierSegmentTypeEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcCableCarrierSegmentType_PredefinedType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPredefinedType(IfcCableCarrierSegmentTypeEnum newPredefinedType) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcCableCarrierSegmentType_PredefinedType(), newPredefinedType);
	}

} //IfcCableCarrierSegmentTypeImpl
