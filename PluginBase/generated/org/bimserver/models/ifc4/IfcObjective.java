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
package org.bimserver.models.ifc4;

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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Objective</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcObjective#getBenchmarkValues <em>Benchmark Values</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcObjective#getLogicalAggregator <em>Logical Aggregator</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcObjective#getObjectiveQualifier <em>Objective Qualifier</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcObjective#getUserDefinedQualifier <em>User Defined Qualifier</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcObjective()
 * @model
 * @generated
 */
public interface IfcObjective extends IfcConstraint {
	/**
	 * Returns the value of the '<em><b>Benchmark Values</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcConstraint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Benchmark Values</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Benchmark Values</em>' reference list.
	 * @see #isSetBenchmarkValues()
	 * @see #unsetBenchmarkValues()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcObjective_BenchmarkValues()
	 * @model unsettable="true"
	 * @generated
	 */
	EList<IfcConstraint> getBenchmarkValues();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcObjective#getBenchmarkValues <em>Benchmark Values</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBenchmarkValues()
	 * @see #getBenchmarkValues()
	 * @generated
	 */
	void unsetBenchmarkValues();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcObjective#getBenchmarkValues <em>Benchmark Values</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Benchmark Values</em>' reference list is set.
	 * @see #unsetBenchmarkValues()
	 * @see #getBenchmarkValues()
	 * @generated
	 */
	boolean isSetBenchmarkValues();

	/**
	 * Returns the value of the '<em><b>Logical Aggregator</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.IfcLogicalOperatorEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Logical Aggregator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Logical Aggregator</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcLogicalOperatorEnum
	 * @see #isSetLogicalAggregator()
	 * @see #unsetLogicalAggregator()
	 * @see #setLogicalAggregator(IfcLogicalOperatorEnum)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcObjective_LogicalAggregator()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcLogicalOperatorEnum getLogicalAggregator();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcObjective#getLogicalAggregator <em>Logical Aggregator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Logical Aggregator</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcLogicalOperatorEnum
	 * @see #isSetLogicalAggregator()
	 * @see #unsetLogicalAggregator()
	 * @see #getLogicalAggregator()
	 * @generated
	 */
	void setLogicalAggregator(IfcLogicalOperatorEnum value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcObjective#getLogicalAggregator <em>Logical Aggregator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLogicalAggregator()
	 * @see #getLogicalAggregator()
	 * @see #setLogicalAggregator(IfcLogicalOperatorEnum)
	 * @generated
	 */
	void unsetLogicalAggregator();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcObjective#getLogicalAggregator <em>Logical Aggregator</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Logical Aggregator</em>' attribute is set.
	 * @see #unsetLogicalAggregator()
	 * @see #getLogicalAggregator()
	 * @see #setLogicalAggregator(IfcLogicalOperatorEnum)
	 * @generated
	 */
	boolean isSetLogicalAggregator();

	/**
	 * Returns the value of the '<em><b>Objective Qualifier</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.IfcObjectiveEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Objective Qualifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Objective Qualifier</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcObjectiveEnum
	 * @see #setObjectiveQualifier(IfcObjectiveEnum)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcObjective_ObjectiveQualifier()
	 * @model
	 * @generated
	 */
	IfcObjectiveEnum getObjectiveQualifier();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcObjective#getObjectiveQualifier <em>Objective Qualifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Objective Qualifier</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcObjectiveEnum
	 * @see #getObjectiveQualifier()
	 * @generated
	 */
	void setObjectiveQualifier(IfcObjectiveEnum value);

	/**
	 * Returns the value of the '<em><b>User Defined Qualifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Defined Qualifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Defined Qualifier</em>' attribute.
	 * @see #isSetUserDefinedQualifier()
	 * @see #unsetUserDefinedQualifier()
	 * @see #setUserDefinedQualifier(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcObjective_UserDefinedQualifier()
	 * @model unsettable="true"
	 * @generated
	 */
	String getUserDefinedQualifier();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcObjective#getUserDefinedQualifier <em>User Defined Qualifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Defined Qualifier</em>' attribute.
	 * @see #isSetUserDefinedQualifier()
	 * @see #unsetUserDefinedQualifier()
	 * @see #getUserDefinedQualifier()
	 * @generated
	 */
	void setUserDefinedQualifier(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcObjective#getUserDefinedQualifier <em>User Defined Qualifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUserDefinedQualifier()
	 * @see #getUserDefinedQualifier()
	 * @see #setUserDefinedQualifier(String)
	 * @generated
	 */
	void unsetUserDefinedQualifier();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcObjective#getUserDefinedQualifier <em>User Defined Qualifier</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>User Defined Qualifier</em>' attribute is set.
	 * @see #unsetUserDefinedQualifier()
	 * @see #getUserDefinedQualifier()
	 * @see #setUserDefinedQualifier(String)
	 * @generated
	 */
	boolean isSetUserDefinedQualifier();

} // IfcObjective
