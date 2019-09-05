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

public interface IfcMetric extends IfcConstraint {
	/**
	 * Returns the value of the '<em><b>Benchmark</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.IfcBenchmarkEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Benchmark</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Benchmark</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcBenchmarkEnum
	 * @see #setBenchmark(IfcBenchmarkEnum)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMetric_Benchmark()
	 * @model
	 * @generated
	 */
	IfcBenchmarkEnum getBenchmark();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcMetric#getBenchmark <em>Benchmark</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Benchmark</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcBenchmarkEnum
	 * @see #getBenchmark()
	 * @generated
	 */
	void setBenchmark(IfcBenchmarkEnum value);

	/**
	 * Returns the value of the '<em><b>Value Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Source</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Source</em>' attribute.
	 * @see #isSetValueSource()
	 * @see #unsetValueSource()
	 * @see #setValueSource(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMetric_ValueSource()
	 * @model unsettable="true"
	 * @generated
	 */
	String getValueSource();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcMetric#getValueSource <em>Value Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Source</em>' attribute.
	 * @see #isSetValueSource()
	 * @see #unsetValueSource()
	 * @see #getValueSource()
	 * @generated
	 */
	void setValueSource(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcMetric#getValueSource <em>Value Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetValueSource()
	 * @see #getValueSource()
	 * @see #setValueSource(String)
	 * @generated
	 */
	void unsetValueSource();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcMetric#getValueSource <em>Value Source</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Value Source</em>' attribute is set.
	 * @see #unsetValueSource()
	 * @see #getValueSource()
	 * @see #setValueSource(String)
	 * @generated
	 */
	boolean isSetValueSource();

	/**
	 * Returns the value of the '<em><b>Data Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Value</em>' reference.
	 * @see #isSetDataValue()
	 * @see #unsetDataValue()
	 * @see #setDataValue(IfcMetricValueSelect)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMetric_DataValue()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcMetricValueSelect getDataValue();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcMetric#getDataValue <em>Data Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Value</em>' reference.
	 * @see #isSetDataValue()
	 * @see #unsetDataValue()
	 * @see #getDataValue()
	 * @generated
	 */
	void setDataValue(IfcMetricValueSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcMetric#getDataValue <em>Data Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDataValue()
	 * @see #getDataValue()
	 * @see #setDataValue(IfcMetricValueSelect)
	 * @generated
	 */
	void unsetDataValue();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcMetric#getDataValue <em>Data Value</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Data Value</em>' reference is set.
	 * @see #unsetDataValue()
	 * @see #getDataValue()
	 * @see #setDataValue(IfcMetricValueSelect)
	 * @generated
	 */
	boolean isSetDataValue();

	/**
	 * Returns the value of the '<em><b>Reference Path</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference Path</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference Path</em>' reference.
	 * @see #isSetReferencePath()
	 * @see #unsetReferencePath()
	 * @see #setReferencePath(IfcReference)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMetric_ReferencePath()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcReference getReferencePath();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcMetric#getReferencePath <em>Reference Path</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reference Path</em>' reference.
	 * @see #isSetReferencePath()
	 * @see #unsetReferencePath()
	 * @see #getReferencePath()
	 * @generated
	 */
	void setReferencePath(IfcReference value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcMetric#getReferencePath <em>Reference Path</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetReferencePath()
	 * @see #getReferencePath()
	 * @see #setReferencePath(IfcReference)
	 * @generated
	 */
	void unsetReferencePath();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcMetric#getReferencePath <em>Reference Path</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Reference Path</em>' reference is set.
	 * @see #unsetReferencePath()
	 * @see #getReferencePath()
	 * @see #setReferencePath(IfcReference)
	 * @generated
	 */
	boolean isSetReferencePath();

} // IfcMetric
