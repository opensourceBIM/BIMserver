/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTask#getTaskId <em>Task Id</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTask#getStatus <em>Status</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTask#getWorkMethod <em>Work Method</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTask#getIsMilestone <em>Is Milestone</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTask#getPriority <em>Priority</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTask()
 * @model
 * @generated
 */
public interface IfcTask extends IfcProcess {
	/**
	 * Returns the value of the '<em><b>Task Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Task Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Task Id</em>' attribute.
	 * @see #setTaskId(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTask_TaskId()
	 * @model
	 * @generated
	 */
	String getTaskId();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTask#getTaskId <em>Task Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Task Id</em>' attribute.
	 * @see #getTaskId()
	 * @generated
	 */
	void setTaskId(String value);

	/**
	 * Returns the value of the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status</em>' attribute.
	 * @see #isSetStatus()
	 * @see #unsetStatus()
	 * @see #setStatus(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTask_Status()
	 * @model unsettable="true"
	 * @generated
	 */
	String getStatus();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTask#getStatus <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Status</em>' attribute.
	 * @see #isSetStatus()
	 * @see #unsetStatus()
	 * @see #getStatus()
	 * @generated
	 */
	void setStatus(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcTask#getStatus <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetStatus()
	 * @see #getStatus()
	 * @see #setStatus(String)
	 * @generated
	 */
	void unsetStatus();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcTask#getStatus <em>Status</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Status</em>' attribute is set.
	 * @see #unsetStatus()
	 * @see #getStatus()
	 * @see #setStatus(String)
	 * @generated
	 */
	boolean isSetStatus();

	/**
	 * Returns the value of the '<em><b>Work Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Work Method</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Work Method</em>' attribute.
	 * @see #isSetWorkMethod()
	 * @see #unsetWorkMethod()
	 * @see #setWorkMethod(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTask_WorkMethod()
	 * @model unsettable="true"
	 * @generated
	 */
	String getWorkMethod();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTask#getWorkMethod <em>Work Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Work Method</em>' attribute.
	 * @see #isSetWorkMethod()
	 * @see #unsetWorkMethod()
	 * @see #getWorkMethod()
	 * @generated
	 */
	void setWorkMethod(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcTask#getWorkMethod <em>Work Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetWorkMethod()
	 * @see #getWorkMethod()
	 * @see #setWorkMethod(String)
	 * @generated
	 */
	void unsetWorkMethod();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcTask#getWorkMethod <em>Work Method</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Work Method</em>' attribute is set.
	 * @see #unsetWorkMethod()
	 * @see #getWorkMethod()
	 * @see #setWorkMethod(String)
	 * @generated
	 */
	boolean isSetWorkMethod();

	/**
	 * Returns the value of the '<em><b>Is Milestone</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.Tristate}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Milestone</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Milestone</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.Tristate
	 * @see #setIsMilestone(Tristate)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTask_IsMilestone()
	 * @model
	 * @generated
	 */
	Tristate getIsMilestone();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTask#getIsMilestone <em>Is Milestone</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Milestone</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.Tristate
	 * @see #getIsMilestone()
	 * @generated
	 */
	void setIsMilestone(Tristate value);

	/**
	 * Returns the value of the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Priority</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Priority</em>' attribute.
	 * @see #setPriority(int)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTask_Priority()
	 * @model
	 * @generated
	 */
	int getPriority();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTask#getPriority <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Priority</em>' attribute.
	 * @see #getPriority()
	 * @generated
	 */
	void setPriority(int value);

} // IfcTask
