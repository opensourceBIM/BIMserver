/**
 * Copyright (C) 2009-2014 BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.bimserver.models.ifc4.impl;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import org.bimserver.models.ifc4.Ifc4Package;
import org.bimserver.models.ifc4.IfcConstraint;
import org.bimserver.models.ifc4.IfcLogicalOperatorEnum;
import org.bimserver.models.ifc4.IfcObjective;
import org.bimserver.models.ifc4.IfcObjectiveEnum;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Objective</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcObjectiveImpl#getBenchmarkValues <em>Benchmark Values</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcObjectiveImpl#getLogicalAggregator <em>Logical Aggregator</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcObjectiveImpl#getObjectiveQualifier <em>Objective Qualifier</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcObjectiveImpl#getUserDefinedQualifier <em>User Defined Qualifier</em>}</li>
 * </ul>
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
		return Ifc4Package.Literals.IFC_OBJECTIVE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcConstraint> getBenchmarkValues() {
		return (EList<IfcConstraint>) eGet(Ifc4Package.Literals.IFC_OBJECTIVE__BENCHMARK_VALUES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetBenchmarkValues() {
		eUnset(Ifc4Package.Literals.IFC_OBJECTIVE__BENCHMARK_VALUES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetBenchmarkValues() {
		return eIsSet(Ifc4Package.Literals.IFC_OBJECTIVE__BENCHMARK_VALUES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcLogicalOperatorEnum getLogicalAggregator() {
		return (IfcLogicalOperatorEnum) eGet(Ifc4Package.Literals.IFC_OBJECTIVE__LOGICAL_AGGREGATOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLogicalAggregator(IfcLogicalOperatorEnum newLogicalAggregator) {
		eSet(Ifc4Package.Literals.IFC_OBJECTIVE__LOGICAL_AGGREGATOR, newLogicalAggregator);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLogicalAggregator() {
		eUnset(Ifc4Package.Literals.IFC_OBJECTIVE__LOGICAL_AGGREGATOR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLogicalAggregator() {
		return eIsSet(Ifc4Package.Literals.IFC_OBJECTIVE__LOGICAL_AGGREGATOR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcObjectiveEnum getObjectiveQualifier() {
		return (IfcObjectiveEnum) eGet(Ifc4Package.Literals.IFC_OBJECTIVE__OBJECTIVE_QUALIFIER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setObjectiveQualifier(IfcObjectiveEnum newObjectiveQualifier) {
		eSet(Ifc4Package.Literals.IFC_OBJECTIVE__OBJECTIVE_QUALIFIER, newObjectiveQualifier);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getUserDefinedQualifier() {
		return (String) eGet(Ifc4Package.Literals.IFC_OBJECTIVE__USER_DEFINED_QUALIFIER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUserDefinedQualifier(String newUserDefinedQualifier) {
		eSet(Ifc4Package.Literals.IFC_OBJECTIVE__USER_DEFINED_QUALIFIER, newUserDefinedQualifier);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetUserDefinedQualifier() {
		eUnset(Ifc4Package.Literals.IFC_OBJECTIVE__USER_DEFINED_QUALIFIER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetUserDefinedQualifier() {
		return eIsSet(Ifc4Package.Literals.IFC_OBJECTIVE__USER_DEFINED_QUALIFIER);
	}

} //IfcObjectiveImpl
