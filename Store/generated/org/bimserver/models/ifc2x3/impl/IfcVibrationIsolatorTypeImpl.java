/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcVibrationIsolatorType;
import org.bimserver.models.ifc2x3.IfcVibrationIsolatorTypeEnum;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Vibration Isolator Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcVibrationIsolatorTypeImpl#getPredefinedType <em>Predefined Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcVibrationIsolatorTypeImpl extends IfcDiscreteAccessoryTypeImpl implements IfcVibrationIsolatorType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcVibrationIsolatorTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcVibrationIsolatorType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcVibrationIsolatorTypeEnum getPredefinedType() {
		return (IfcVibrationIsolatorTypeEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcVibrationIsolatorType_PredefinedType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPredefinedType(IfcVibrationIsolatorTypeEnum newPredefinedType) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcVibrationIsolatorType_PredefinedType(), newPredefinedType);
	}

} //IfcVibrationIsolatorTypeImpl
