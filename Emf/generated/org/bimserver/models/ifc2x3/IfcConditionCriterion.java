/**
 * Copyright (C) 2011  BIMserver.org
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
package org.bimserver.models.ifc2x3;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Condition Criterion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcConditionCriterion#getCriterion <em>Criterion</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcConditionCriterion#getCriterionDateTime <em>Criterion Date Time</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcConditionCriterion()
 * @model
 * @generated
 */
public interface IfcConditionCriterion extends IfcControl {
	/**
	 * Returns the value of the '<em><b>Criterion</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Criterion</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Criterion</em>' reference.
	 * @see #isSetCriterion()
	 * @see #unsetCriterion()
	 * @see #setCriterion(IfcConditionCriterionSelect)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcConditionCriterion_Criterion()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcConditionCriterionSelect getCriterion();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcConditionCriterion#getCriterion <em>Criterion</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Criterion</em>' reference.
	 * @see #isSetCriterion()
	 * @see #unsetCriterion()
	 * @see #getCriterion()
	 * @generated
	 */
	void setCriterion(IfcConditionCriterionSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcConditionCriterion#getCriterion <em>Criterion</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCriterion()
	 * @see #getCriterion()
	 * @see #setCriterion(IfcConditionCriterionSelect)
	 * @generated
	 */
	void unsetCriterion();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcConditionCriterion#getCriterion <em>Criterion</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Criterion</em>' reference is set.
	 * @see #unsetCriterion()
	 * @see #getCriterion()
	 * @see #setCriterion(IfcConditionCriterionSelect)
	 * @generated
	 */
	boolean isSetCriterion();

	/**
	 * Returns the value of the '<em><b>Criterion Date Time</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Criterion Date Time</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Criterion Date Time</em>' reference.
	 * @see #isSetCriterionDateTime()
	 * @see #unsetCriterionDateTime()
	 * @see #setCriterionDateTime(IfcDateTimeSelect)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcConditionCriterion_CriterionDateTime()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcDateTimeSelect getCriterionDateTime();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcConditionCriterion#getCriterionDateTime <em>Criterion Date Time</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Criterion Date Time</em>' reference.
	 * @see #isSetCriterionDateTime()
	 * @see #unsetCriterionDateTime()
	 * @see #getCriterionDateTime()
	 * @generated
	 */
	void setCriterionDateTime(IfcDateTimeSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcConditionCriterion#getCriterionDateTime <em>Criterion Date Time</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCriterionDateTime()
	 * @see #getCriterionDateTime()
	 * @see #setCriterionDateTime(IfcDateTimeSelect)
	 * @generated
	 */
	void unsetCriterionDateTime();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcConditionCriterion#getCriterionDateTime <em>Criterion Date Time</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Criterion Date Time</em>' reference is set.
	 * @see #unsetCriterionDateTime()
	 * @see #getCriterionDateTime()
	 * @see #setCriterionDateTime(IfcDateTimeSelect)
	 * @generated
	 */
	boolean isSetCriterionDateTime();

} // IfcConditionCriterion
