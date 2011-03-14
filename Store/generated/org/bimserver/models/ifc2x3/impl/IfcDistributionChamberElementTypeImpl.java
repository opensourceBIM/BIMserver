/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcDistributionChamberElementType;
import org.bimserver.models.ifc2x3.IfcDistributionChamberElementTypeEnum;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Distribution Chamber Element Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDistributionChamberElementTypeImpl#getPredefinedType <em>Predefined Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcDistributionChamberElementTypeImpl extends IfcDistributionFlowElementTypeImpl implements IfcDistributionChamberElementType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcDistributionChamberElementTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcDistributionChamberElementType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDistributionChamberElementTypeEnum getPredefinedType() {
		return (IfcDistributionChamberElementTypeEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcDistributionChamberElementType_PredefinedType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPredefinedType(IfcDistributionChamberElementTypeEnum newPredefinedType) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcDistributionChamberElementType_PredefinedType(), newPredefinedType);
	}

} //IfcDistributionChamberElementTypeImpl
