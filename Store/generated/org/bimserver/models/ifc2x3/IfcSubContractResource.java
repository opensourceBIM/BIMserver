/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Sub Contract Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSubContractResource#getSubContractor <em>Sub Contractor</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSubContractResource#getJobDescription <em>Job Description</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSubContractResource()
 * @model
 * @generated
 */
public interface IfcSubContractResource extends IfcConstructionResource {
	/**
	 * Returns the value of the '<em><b>Sub Contractor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Contractor</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Contractor</em>' reference.
	 * @see #isSetSubContractor()
	 * @see #unsetSubContractor()
	 * @see #setSubContractor(IfcActorSelect)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSubContractResource_SubContractor()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcActorSelect getSubContractor();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcSubContractResource#getSubContractor <em>Sub Contractor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sub Contractor</em>' reference.
	 * @see #isSetSubContractor()
	 * @see #unsetSubContractor()
	 * @see #getSubContractor()
	 * @generated
	 */
	void setSubContractor(IfcActorSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcSubContractResource#getSubContractor <em>Sub Contractor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSubContractor()
	 * @see #getSubContractor()
	 * @see #setSubContractor(IfcActorSelect)
	 * @generated
	 */
	void unsetSubContractor();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcSubContractResource#getSubContractor <em>Sub Contractor</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Sub Contractor</em>' reference is set.
	 * @see #unsetSubContractor()
	 * @see #getSubContractor()
	 * @see #setSubContractor(IfcActorSelect)
	 * @generated
	 */
	boolean isSetSubContractor();

	/**
	 * Returns the value of the '<em><b>Job Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Job Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Job Description</em>' attribute.
	 * @see #isSetJobDescription()
	 * @see #unsetJobDescription()
	 * @see #setJobDescription(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSubContractResource_JobDescription()
	 * @model unsettable="true"
	 * @generated
	 */
	String getJobDescription();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcSubContractResource#getJobDescription <em>Job Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Job Description</em>' attribute.
	 * @see #isSetJobDescription()
	 * @see #unsetJobDescription()
	 * @see #getJobDescription()
	 * @generated
	 */
	void setJobDescription(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcSubContractResource#getJobDescription <em>Job Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetJobDescription()
	 * @see #getJobDescription()
	 * @see #setJobDescription(String)
	 * @generated
	 */
	void unsetJobDescription();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcSubContractResource#getJobDescription <em>Job Description</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Job Description</em>' attribute is set.
	 * @see #unsetJobDescription()
	 * @see #getJobDescription()
	 * @see #setJobDescription(String)
	 * @generated
	 */
	boolean isSetJobDescription();

} // IfcSubContractResource
