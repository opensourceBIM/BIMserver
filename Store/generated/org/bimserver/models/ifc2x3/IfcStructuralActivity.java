/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Structural Activity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcStructuralActivity#getAppliedLoad <em>Applied Load</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcStructuralActivity#getGlobalOrLocal <em>Global Or Local</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcStructuralActivity#getAssignedToStructuralItem <em>Assigned To Structural Item</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralActivity()
 * @model
 * @generated
 */
public interface IfcStructuralActivity extends IfcProduct {
	/**
	 * Returns the value of the '<em><b>Applied Load</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Applied Load</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Applied Load</em>' reference.
	 * @see #setAppliedLoad(IfcStructuralLoad)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralActivity_AppliedLoad()
	 * @model
	 * @generated
	 */
	IfcStructuralLoad getAppliedLoad();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralActivity#getAppliedLoad <em>Applied Load</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Applied Load</em>' reference.
	 * @see #getAppliedLoad()
	 * @generated
	 */
	void setAppliedLoad(IfcStructuralLoad value);

	/**
	 * Returns the value of the '<em><b>Global Or Local</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.IfcGlobalOrLocalEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Global Or Local</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Global Or Local</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcGlobalOrLocalEnum
	 * @see #setGlobalOrLocal(IfcGlobalOrLocalEnum)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralActivity_GlobalOrLocal()
	 * @model
	 * @generated
	 */
	IfcGlobalOrLocalEnum getGlobalOrLocal();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralActivity#getGlobalOrLocal <em>Global Or Local</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Global Or Local</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcGlobalOrLocalEnum
	 * @see #getGlobalOrLocal()
	 * @generated
	 */
	void setGlobalOrLocal(IfcGlobalOrLocalEnum value);

	/**
	 * Returns the value of the '<em><b>Assigned To Structural Item</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcRelConnectsStructuralActivity#getRelatedStructuralActivity <em>Related Structural Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assigned To Structural Item</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assigned To Structural Item</em>' reference.
	 * @see #setAssignedToStructuralItem(IfcRelConnectsStructuralActivity)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralActivity_AssignedToStructuralItem()
	 * @see org.bimserver.models.ifc2x3.IfcRelConnectsStructuralActivity#getRelatedStructuralActivity
	 * @model opposite="RelatedStructuralActivity"
	 * @generated
	 */
	IfcRelConnectsStructuralActivity getAssignedToStructuralItem();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralActivity#getAssignedToStructuralItem <em>Assigned To Structural Item</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assigned To Structural Item</em>' reference.
	 * @see #getAssignedToStructuralItem()
	 * @generated
	 */
	void setAssignedToStructuralItem(IfcRelConnectsStructuralActivity value);

} // IfcStructuralActivity
