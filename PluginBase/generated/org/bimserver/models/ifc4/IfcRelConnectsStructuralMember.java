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

public interface IfcRelConnectsStructuralMember extends IfcRelConnects {
	/**
	 * Returns the value of the '<em><b>Relating Structural Member</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcStructuralMember#getConnectedBy <em>Connected By</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relating Structural Member</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relating Structural Member</em>' reference.
	 * @see #setRelatingStructuralMember(IfcStructuralMember)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRelConnectsStructuralMember_RelatingStructuralMember()
	 * @see org.bimserver.models.ifc4.IfcStructuralMember#getConnectedBy
	 * @model opposite="ConnectedBy"
	 *        annotation="inverse"
	 * @generated
	 */
	IfcStructuralMember getRelatingStructuralMember();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcRelConnectsStructuralMember#getRelatingStructuralMember <em>Relating Structural Member</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relating Structural Member</em>' reference.
	 * @see #getRelatingStructuralMember()
	 * @generated
	 */
	void setRelatingStructuralMember(IfcStructuralMember value);

	/**
	 * Returns the value of the '<em><b>Related Structural Connection</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcStructuralConnection#getConnectsStructuralMembers <em>Connects Structural Members</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Related Structural Connection</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Related Structural Connection</em>' reference.
	 * @see #setRelatedStructuralConnection(IfcStructuralConnection)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRelConnectsStructuralMember_RelatedStructuralConnection()
	 * @see org.bimserver.models.ifc4.IfcStructuralConnection#getConnectsStructuralMembers
	 * @model opposite="ConnectsStructuralMembers"
	 *        annotation="inverse"
	 * @generated
	 */
	IfcStructuralConnection getRelatedStructuralConnection();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcRelConnectsStructuralMember#getRelatedStructuralConnection <em>Related Structural Connection</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Related Structural Connection</em>' reference.
	 * @see #getRelatedStructuralConnection()
	 * @generated
	 */
	void setRelatedStructuralConnection(IfcStructuralConnection value);

	/**
	 * Returns the value of the '<em><b>Applied Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Applied Condition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Applied Condition</em>' reference.
	 * @see #isSetAppliedCondition()
	 * @see #unsetAppliedCondition()
	 * @see #setAppliedCondition(IfcBoundaryCondition)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRelConnectsStructuralMember_AppliedCondition()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcBoundaryCondition getAppliedCondition();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcRelConnectsStructuralMember#getAppliedCondition <em>Applied Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Applied Condition</em>' reference.
	 * @see #isSetAppliedCondition()
	 * @see #unsetAppliedCondition()
	 * @see #getAppliedCondition()
	 * @generated
	 */
	void setAppliedCondition(IfcBoundaryCondition value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcRelConnectsStructuralMember#getAppliedCondition <em>Applied Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetAppliedCondition()
	 * @see #getAppliedCondition()
	 * @see #setAppliedCondition(IfcBoundaryCondition)
	 * @generated
	 */
	void unsetAppliedCondition();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcRelConnectsStructuralMember#getAppliedCondition <em>Applied Condition</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Applied Condition</em>' reference is set.
	 * @see #unsetAppliedCondition()
	 * @see #getAppliedCondition()
	 * @see #setAppliedCondition(IfcBoundaryCondition)
	 * @generated
	 */
	boolean isSetAppliedCondition();

	/**
	 * Returns the value of the '<em><b>Additional Conditions</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Additional Conditions</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Additional Conditions</em>' reference.
	 * @see #isSetAdditionalConditions()
	 * @see #unsetAdditionalConditions()
	 * @see #setAdditionalConditions(IfcStructuralConnectionCondition)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRelConnectsStructuralMember_AdditionalConditions()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcStructuralConnectionCondition getAdditionalConditions();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcRelConnectsStructuralMember#getAdditionalConditions <em>Additional Conditions</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Additional Conditions</em>' reference.
	 * @see #isSetAdditionalConditions()
	 * @see #unsetAdditionalConditions()
	 * @see #getAdditionalConditions()
	 * @generated
	 */
	void setAdditionalConditions(IfcStructuralConnectionCondition value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcRelConnectsStructuralMember#getAdditionalConditions <em>Additional Conditions</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetAdditionalConditions()
	 * @see #getAdditionalConditions()
	 * @see #setAdditionalConditions(IfcStructuralConnectionCondition)
	 * @generated
	 */
	void unsetAdditionalConditions();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcRelConnectsStructuralMember#getAdditionalConditions <em>Additional Conditions</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Additional Conditions</em>' reference is set.
	 * @see #unsetAdditionalConditions()
	 * @see #getAdditionalConditions()
	 * @see #setAdditionalConditions(IfcStructuralConnectionCondition)
	 * @generated
	 */
	boolean isSetAdditionalConditions();

	/**
	 * Returns the value of the '<em><b>Supported Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Supported Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Supported Length</em>' attribute.
	 * @see #isSetSupportedLength()
	 * @see #unsetSupportedLength()
	 * @see #setSupportedLength(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRelConnectsStructuralMember_SupportedLength()
	 * @model unsettable="true"
	 * @generated
	 */
	double getSupportedLength();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcRelConnectsStructuralMember#getSupportedLength <em>Supported Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Supported Length</em>' attribute.
	 * @see #isSetSupportedLength()
	 * @see #unsetSupportedLength()
	 * @see #getSupportedLength()
	 * @generated
	 */
	void setSupportedLength(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcRelConnectsStructuralMember#getSupportedLength <em>Supported Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSupportedLength()
	 * @see #getSupportedLength()
	 * @see #setSupportedLength(double)
	 * @generated
	 */
	void unsetSupportedLength();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcRelConnectsStructuralMember#getSupportedLength <em>Supported Length</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Supported Length</em>' attribute is set.
	 * @see #unsetSupportedLength()
	 * @see #getSupportedLength()
	 * @see #setSupportedLength(double)
	 * @generated
	 */
	boolean isSetSupportedLength();

	/**
	 * Returns the value of the '<em><b>Supported Length As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Supported Length As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Supported Length As String</em>' attribute.
	 * @see #isSetSupportedLengthAsString()
	 * @see #unsetSupportedLengthAsString()
	 * @see #setSupportedLengthAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRelConnectsStructuralMember_SupportedLengthAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getSupportedLengthAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcRelConnectsStructuralMember#getSupportedLengthAsString <em>Supported Length As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Supported Length As String</em>' attribute.
	 * @see #isSetSupportedLengthAsString()
	 * @see #unsetSupportedLengthAsString()
	 * @see #getSupportedLengthAsString()
	 * @generated
	 */
	void setSupportedLengthAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcRelConnectsStructuralMember#getSupportedLengthAsString <em>Supported Length As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSupportedLengthAsString()
	 * @see #getSupportedLengthAsString()
	 * @see #setSupportedLengthAsString(String)
	 * @generated
	 */
	void unsetSupportedLengthAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcRelConnectsStructuralMember#getSupportedLengthAsString <em>Supported Length As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Supported Length As String</em>' attribute is set.
	 * @see #unsetSupportedLengthAsString()
	 * @see #getSupportedLengthAsString()
	 * @see #setSupportedLengthAsString(String)
	 * @generated
	 */
	boolean isSetSupportedLengthAsString();

	/**
	 * Returns the value of the '<em><b>Condition Coordinate System</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition Coordinate System</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition Coordinate System</em>' reference.
	 * @see #isSetConditionCoordinateSystem()
	 * @see #unsetConditionCoordinateSystem()
	 * @see #setConditionCoordinateSystem(IfcAxis2Placement3D)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRelConnectsStructuralMember_ConditionCoordinateSystem()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcAxis2Placement3D getConditionCoordinateSystem();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcRelConnectsStructuralMember#getConditionCoordinateSystem <em>Condition Coordinate System</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition Coordinate System</em>' reference.
	 * @see #isSetConditionCoordinateSystem()
	 * @see #unsetConditionCoordinateSystem()
	 * @see #getConditionCoordinateSystem()
	 * @generated
	 */
	void setConditionCoordinateSystem(IfcAxis2Placement3D value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcRelConnectsStructuralMember#getConditionCoordinateSystem <em>Condition Coordinate System</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetConditionCoordinateSystem()
	 * @see #getConditionCoordinateSystem()
	 * @see #setConditionCoordinateSystem(IfcAxis2Placement3D)
	 * @generated
	 */
	void unsetConditionCoordinateSystem();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcRelConnectsStructuralMember#getConditionCoordinateSystem <em>Condition Coordinate System</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Condition Coordinate System</em>' reference is set.
	 * @see #unsetConditionCoordinateSystem()
	 * @see #getConditionCoordinateSystem()
	 * @see #setConditionCoordinateSystem(IfcAxis2Placement3D)
	 * @generated
	 */
	boolean isSetConditionCoordinateSystem();

} // IfcRelConnectsStructuralMember
