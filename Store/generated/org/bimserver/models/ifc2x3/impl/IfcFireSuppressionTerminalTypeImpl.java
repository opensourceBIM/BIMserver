/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcFireSuppressionTerminalType;
import org.bimserver.models.ifc2x3.IfcFireSuppressionTerminalTypeEnum;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Fire Suppression Terminal Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcFireSuppressionTerminalTypeImpl#getPredefinedType <em>Predefined Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcFireSuppressionTerminalTypeImpl extends IfcFlowTerminalTypeImpl implements IfcFireSuppressionTerminalType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcFireSuppressionTerminalTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcFireSuppressionTerminalType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcFireSuppressionTerminalTypeEnum getPredefinedType() {
		return (IfcFireSuppressionTerminalTypeEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcFireSuppressionTerminalType_PredefinedType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPredefinedType(IfcFireSuppressionTerminalTypeEnum newPredefinedType) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcFireSuppressionTerminalType_PredefinedType(), newPredefinedType);
	}

} //IfcFireSuppressionTerminalTypeImpl
