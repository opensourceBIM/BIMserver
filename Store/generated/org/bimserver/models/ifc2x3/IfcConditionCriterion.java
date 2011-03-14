/**
 * <copyright>
 * </copyright>
 *
 * $Id$
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
	 * @see #setCriterion(IfcConditionCriterionSelect)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcConditionCriterion_Criterion()
	 * @model
	 * @generated
	 */
	IfcConditionCriterionSelect getCriterion();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcConditionCriterion#getCriterion <em>Criterion</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Criterion</em>' reference.
	 * @see #getCriterion()
	 * @generated
	 */
	void setCriterion(IfcConditionCriterionSelect value);

	/**
	 * Returns the value of the '<em><b>Criterion Date Time</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Criterion Date Time</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Criterion Date Time</em>' reference.
	 * @see #setCriterionDateTime(IfcDateTimeSelect)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcConditionCriterion_CriterionDateTime()
	 * @model
	 * @generated
	 */
	IfcDateTimeSelect getCriterionDateTime();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcConditionCriterion#getCriterionDateTime <em>Criterion Date Time</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Criterion Date Time</em>' reference.
	 * @see #getCriterionDateTime()
	 * @generated
	 */
	void setCriterionDateTime(IfcDateTimeSelect value);

} // IfcConditionCriterion
