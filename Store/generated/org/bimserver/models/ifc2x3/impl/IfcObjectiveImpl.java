/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcMetric;
import org.bimserver.models.ifc2x3.IfcObjective;
import org.bimserver.models.ifc2x3.IfcObjectiveEnum;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Objective</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcObjectiveImpl#getBenchmarkValues <em>Benchmark Values</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcObjectiveImpl#getResultValues <em>Result Values</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcObjectiveImpl#getObjectiveQualifier <em>Objective Qualifier</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcObjectiveImpl#getUserDefinedQualifier <em>User Defined Qualifier</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcObjectiveImpl extends IfcConstraintImpl implements IfcObjective {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcObjectiveImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcObjective();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMetric getBenchmarkValues() {
		return (IfcMetric)eGet(Ifc2x3Package.eINSTANCE.getIfcObjective_BenchmarkValues(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBenchmarkValues(IfcMetric newBenchmarkValues) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcObjective_BenchmarkValues(), newBenchmarkValues);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetBenchmarkValues() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcObjective_BenchmarkValues());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetBenchmarkValues() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcObjective_BenchmarkValues());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMetric getResultValues() {
		return (IfcMetric)eGet(Ifc2x3Package.eINSTANCE.getIfcObjective_ResultValues(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResultValues(IfcMetric newResultValues) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcObjective_ResultValues(), newResultValues);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetResultValues() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcObjective_ResultValues());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetResultValues() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcObjective_ResultValues());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcObjectiveEnum getObjectiveQualifier() {
		return (IfcObjectiveEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcObjective_ObjectiveQualifier(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObjectiveQualifier(IfcObjectiveEnum newObjectiveQualifier) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcObjective_ObjectiveQualifier(), newObjectiveQualifier);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUserDefinedQualifier() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcObjective_UserDefinedQualifier(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserDefinedQualifier(String newUserDefinedQualifier) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcObjective_UserDefinedQualifier(), newUserDefinedQualifier);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUserDefinedQualifier() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcObjective_UserDefinedQualifier());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUserDefinedQualifier() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcObjective_UserDefinedQualifier());
	}

} //IfcObjectiveImpl
