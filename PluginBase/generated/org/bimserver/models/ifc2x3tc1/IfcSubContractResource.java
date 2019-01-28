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
package org.bimserver.models.ifc2x3tc1;

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
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcSubContractResource_SubContractor()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcActorSelect getSubContractor();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSubContractResource#getSubContractor <em>Sub Contractor</em>}' reference.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSubContractResource#getSubContractor <em>Sub Contractor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSubContractor()
	 * @see #getSubContractor()
	 * @see #setSubContractor(IfcActorSelect)
	 * @generated
	 */
	void unsetSubContractor();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSubContractResource#getSubContractor <em>Sub Contractor</em>}' reference is set.
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
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcSubContractResource_JobDescription()
	 * @model unsettable="true"
	 * @generated
	 */
	String getJobDescription();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSubContractResource#getJobDescription <em>Job Description</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSubContractResource#getJobDescription <em>Job Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetJobDescription()
	 * @see #getJobDescription()
	 * @see #setJobDescription(String)
	 * @generated
	 */
	void unsetJobDescription();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSubContractResource#getJobDescription <em>Job Description</em>}' attribute is set.
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
