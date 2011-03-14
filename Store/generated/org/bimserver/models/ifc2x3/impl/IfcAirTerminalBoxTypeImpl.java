/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcAirTerminalBoxType;
import org.bimserver.models.ifc2x3.IfcAirTerminalBoxTypeEnum;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Air Terminal Box Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcAirTerminalBoxTypeImpl#getPredefinedType <em>Predefined Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcAirTerminalBoxTypeImpl extends IfcFlowControllerTypeImpl implements IfcAirTerminalBoxType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcAirTerminalBoxTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcAirTerminalBoxType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAirTerminalBoxTypeEnum getPredefinedType() {
		return (IfcAirTerminalBoxTypeEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcAirTerminalBoxType_PredefinedType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPredefinedType(IfcAirTerminalBoxTypeEnum newPredefinedType) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcAirTerminalBoxType_PredefinedType(), newPredefinedType);
	}

} //IfcAirTerminalBoxTypeImpl
