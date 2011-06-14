/**
 *  (c) Copyright bimserver.org 2009
 *  Licensed under GNU GPLv3
 *  http://www.gnu.org/licenses/gpl-3.0.txt
 *  For more information mail to license@bimserver.org
 *  
 *  Bimserver.org is free software: you can redistribute it and/or modify 
 *  it under the terms of the GNU General Public License as published by 
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  Bimserver.org is distributed in the hope that it will be useful, but 
 *  WITHOUT ANY WARRANTY; without even the implied warranty of 
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 *  General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License a 
 *  long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
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
public interface IfcSubContractResource extends IfcConstructionResource
{
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
