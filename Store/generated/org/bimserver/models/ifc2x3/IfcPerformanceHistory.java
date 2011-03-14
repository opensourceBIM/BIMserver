/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Performance History</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcPerformanceHistory#getLifeCyclePhase <em>Life Cycle Phase</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPerformanceHistory()
 * @model
 * @generated
 */
public interface IfcPerformanceHistory extends IfcControl {
	/**
	 * Returns the value of the '<em><b>Life Cycle Phase</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Life Cycle Phase</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Life Cycle Phase</em>' attribute.
	 * @see #setLifeCyclePhase(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPerformanceHistory_LifeCyclePhase()
	 * @model
	 * @generated
	 */
	String getLifeCyclePhase();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcPerformanceHistory#getLifeCyclePhase <em>Life Cycle Phase</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Life Cycle Phase</em>' attribute.
	 * @see #getLifeCyclePhase()
	 * @generated
	 */
	void setLifeCyclePhase(String value);

} // IfcPerformanceHistory
