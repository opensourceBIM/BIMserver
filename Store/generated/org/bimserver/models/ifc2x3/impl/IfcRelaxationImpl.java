/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.emf.IdEObjectImpl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcRelaxation;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Relaxation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelaxationImpl#getRelaxationValue <em>Relaxation Value</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelaxationImpl#getRelaxationValueAsString <em>Relaxation Value As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelaxationImpl#getInitialStress <em>Initial Stress</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelaxationImpl#getInitialStressAsString <em>Initial Stress As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcRelaxationImpl extends IdEObjectImpl implements IfcRelaxation {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRelaxationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcRelaxation();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getRelaxationValue() {
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcRelaxation_RelaxationValue(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelaxationValue(float newRelaxationValue) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcRelaxation_RelaxationValue(), newRelaxationValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRelaxationValueAsString() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcRelaxation_RelaxationValueAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelaxationValueAsString(String newRelaxationValueAsString) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcRelaxation_RelaxationValueAsString(), newRelaxationValueAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getInitialStress() {
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcRelaxation_InitialStress(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialStress(float newInitialStress) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcRelaxation_InitialStress(), newInitialStress);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInitialStressAsString() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcRelaxation_InitialStressAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialStressAsString(String newInitialStressAsString) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcRelaxation_InitialStressAsString(), newInitialStressAsString);
	}

} //IfcRelaxationImpl
