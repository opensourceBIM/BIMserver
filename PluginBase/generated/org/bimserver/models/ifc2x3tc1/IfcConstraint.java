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

import org.bimserver.emf.IdEObject;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcConstraint#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcConstraint#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcConstraint#getConstraintGrade <em>Constraint Grade</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcConstraint#getConstraintSource <em>Constraint Source</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcConstraint#getCreatingActor <em>Creating Actor</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcConstraint#getCreationTime <em>Creation Time</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcConstraint#getUserDefinedGrade <em>User Defined Grade</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcConstraint#getClassifiedAs <em>Classified As</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcConstraint#getRelatesConstraints <em>Relates Constraints</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcConstraint#getIsRelatedWith <em>Is Related With</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcConstraint#getPropertiesForConstraint <em>Properties For Constraint</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcConstraint#getAggregates <em>Aggregates</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcConstraint#getIsAggregatedIn <em>Is Aggregated In</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcConstraint()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface IfcConstraint extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcConstraint_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcConstraint#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #isSetDescription()
	 * @see #unsetDescription()
	 * @see #setDescription(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcConstraint_Description()
	 * @model unsettable="true"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcConstraint#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #isSetDescription()
	 * @see #unsetDescription()
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcConstraint#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDescription()
	 * @see #getDescription()
	 * @see #setDescription(String)
	 * @generated
	 */
	void unsetDescription();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcConstraint#getDescription <em>Description</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Description</em>' attribute is set.
	 * @see #unsetDescription()
	 * @see #getDescription()
	 * @see #setDescription(String)
	 * @generated
	 */
	boolean isSetDescription();

	/**
	 * Returns the value of the '<em><b>Constraint Grade</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3tc1.IfcConstraintEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Grade</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint Grade</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.IfcConstraintEnum
	 * @see #setConstraintGrade(IfcConstraintEnum)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcConstraint_ConstraintGrade()
	 * @model
	 * @generated
	 */
	IfcConstraintEnum getConstraintGrade();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcConstraint#getConstraintGrade <em>Constraint Grade</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constraint Grade</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.IfcConstraintEnum
	 * @see #getConstraintGrade()
	 * @generated
	 */
	void setConstraintGrade(IfcConstraintEnum value);

	/**
	 * Returns the value of the '<em><b>Constraint Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Source</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint Source</em>' attribute.
	 * @see #isSetConstraintSource()
	 * @see #unsetConstraintSource()
	 * @see #setConstraintSource(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcConstraint_ConstraintSource()
	 * @model unsettable="true"
	 * @generated
	 */
	String getConstraintSource();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcConstraint#getConstraintSource <em>Constraint Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constraint Source</em>' attribute.
	 * @see #isSetConstraintSource()
	 * @see #unsetConstraintSource()
	 * @see #getConstraintSource()
	 * @generated
	 */
	void setConstraintSource(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcConstraint#getConstraintSource <em>Constraint Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetConstraintSource()
	 * @see #getConstraintSource()
	 * @see #setConstraintSource(String)
	 * @generated
	 */
	void unsetConstraintSource();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcConstraint#getConstraintSource <em>Constraint Source</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Constraint Source</em>' attribute is set.
	 * @see #unsetConstraintSource()
	 * @see #getConstraintSource()
	 * @see #setConstraintSource(String)
	 * @generated
	 */
	boolean isSetConstraintSource();

	/**
	 * Returns the value of the '<em><b>Creating Actor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Creating Actor</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Creating Actor</em>' reference.
	 * @see #isSetCreatingActor()
	 * @see #unsetCreatingActor()
	 * @see #setCreatingActor(IfcActorSelect)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcConstraint_CreatingActor()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcActorSelect getCreatingActor();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcConstraint#getCreatingActor <em>Creating Actor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Creating Actor</em>' reference.
	 * @see #isSetCreatingActor()
	 * @see #unsetCreatingActor()
	 * @see #getCreatingActor()
	 * @generated
	 */
	void setCreatingActor(IfcActorSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcConstraint#getCreatingActor <em>Creating Actor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCreatingActor()
	 * @see #getCreatingActor()
	 * @see #setCreatingActor(IfcActorSelect)
	 * @generated
	 */
	void unsetCreatingActor();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcConstraint#getCreatingActor <em>Creating Actor</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Creating Actor</em>' reference is set.
	 * @see #unsetCreatingActor()
	 * @see #getCreatingActor()
	 * @see #setCreatingActor(IfcActorSelect)
	 * @generated
	 */
	boolean isSetCreatingActor();

	/**
	 * Returns the value of the '<em><b>Creation Time</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Creation Time</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Creation Time</em>' reference.
	 * @see #isSetCreationTime()
	 * @see #unsetCreationTime()
	 * @see #setCreationTime(IfcDateTimeSelect)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcConstraint_CreationTime()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcDateTimeSelect getCreationTime();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcConstraint#getCreationTime <em>Creation Time</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Creation Time</em>' reference.
	 * @see #isSetCreationTime()
	 * @see #unsetCreationTime()
	 * @see #getCreationTime()
	 * @generated
	 */
	void setCreationTime(IfcDateTimeSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcConstraint#getCreationTime <em>Creation Time</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCreationTime()
	 * @see #getCreationTime()
	 * @see #setCreationTime(IfcDateTimeSelect)
	 * @generated
	 */
	void unsetCreationTime();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcConstraint#getCreationTime <em>Creation Time</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Creation Time</em>' reference is set.
	 * @see #unsetCreationTime()
	 * @see #getCreationTime()
	 * @see #setCreationTime(IfcDateTimeSelect)
	 * @generated
	 */
	boolean isSetCreationTime();

	/**
	 * Returns the value of the '<em><b>User Defined Grade</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Defined Grade</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Defined Grade</em>' attribute.
	 * @see #isSetUserDefinedGrade()
	 * @see #unsetUserDefinedGrade()
	 * @see #setUserDefinedGrade(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcConstraint_UserDefinedGrade()
	 * @model unsettable="true"
	 * @generated
	 */
	String getUserDefinedGrade();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcConstraint#getUserDefinedGrade <em>User Defined Grade</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Defined Grade</em>' attribute.
	 * @see #isSetUserDefinedGrade()
	 * @see #unsetUserDefinedGrade()
	 * @see #getUserDefinedGrade()
	 * @generated
	 */
	void setUserDefinedGrade(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcConstraint#getUserDefinedGrade <em>User Defined Grade</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUserDefinedGrade()
	 * @see #getUserDefinedGrade()
	 * @see #setUserDefinedGrade(String)
	 * @generated
	 */
	void unsetUserDefinedGrade();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcConstraint#getUserDefinedGrade <em>User Defined Grade</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>User Defined Grade</em>' attribute is set.
	 * @see #unsetUserDefinedGrade()
	 * @see #getUserDefinedGrade()
	 * @see #setUserDefinedGrade(String)
	 * @generated
	 */
	boolean isSetUserDefinedGrade();

	/**
	 * Returns the value of the '<em><b>Classified As</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3tc1.IfcConstraintClassificationRelationship}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3tc1.IfcConstraintClassificationRelationship#getClassifiedConstraint <em>Classified Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classified As</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classified As</em>' reference list.
	 * @see #isSetClassifiedAs()
	 * @see #unsetClassifiedAs()
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcConstraint_ClassifiedAs()
	 * @see org.bimserver.models.ifc2x3tc1.IfcConstraintClassificationRelationship#getClassifiedConstraint
	 * @model opposite="ClassifiedConstraint" unsettable="true"
	 * @generated
	 */
	EList<IfcConstraintClassificationRelationship> getClassifiedAs();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcConstraint#getClassifiedAs <em>Classified As</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetClassifiedAs()
	 * @see #getClassifiedAs()
	 * @generated
	 */
	void unsetClassifiedAs();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcConstraint#getClassifiedAs <em>Classified As</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Classified As</em>' reference list is set.
	 * @see #unsetClassifiedAs()
	 * @see #getClassifiedAs()
	 * @generated
	 */
	boolean isSetClassifiedAs();

	/**
	 * Returns the value of the '<em><b>Relates Constraints</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3tc1.IfcConstraintRelationship}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3tc1.IfcConstraintRelationship#getRelatingConstraint <em>Relating Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relates Constraints</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relates Constraints</em>' reference list.
	 * @see #isSetRelatesConstraints()
	 * @see #unsetRelatesConstraints()
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcConstraint_RelatesConstraints()
	 * @see org.bimserver.models.ifc2x3tc1.IfcConstraintRelationship#getRelatingConstraint
	 * @model opposite="RelatingConstraint" unsettable="true"
	 * @generated
	 */
	EList<IfcConstraintRelationship> getRelatesConstraints();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcConstraint#getRelatesConstraints <em>Relates Constraints</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRelatesConstraints()
	 * @see #getRelatesConstraints()
	 * @generated
	 */
	void unsetRelatesConstraints();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcConstraint#getRelatesConstraints <em>Relates Constraints</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Relates Constraints</em>' reference list is set.
	 * @see #unsetRelatesConstraints()
	 * @see #getRelatesConstraints()
	 * @generated
	 */
	boolean isSetRelatesConstraints();

	/**
	 * Returns the value of the '<em><b>Is Related With</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3tc1.IfcConstraintRelationship}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3tc1.IfcConstraintRelationship#getRelatedConstraints <em>Related Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Related With</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Related With</em>' reference list.
	 * @see #isSetIsRelatedWith()
	 * @see #unsetIsRelatedWith()
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcConstraint_IsRelatedWith()
	 * @see org.bimserver.models.ifc2x3tc1.IfcConstraintRelationship#getRelatedConstraints
	 * @model opposite="RelatedConstraints" unsettable="true"
	 * @generated
	 */
	EList<IfcConstraintRelationship> getIsRelatedWith();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcConstraint#getIsRelatedWith <em>Is Related With</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIsRelatedWith()
	 * @see #getIsRelatedWith()
	 * @generated
	 */
	void unsetIsRelatedWith();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcConstraint#getIsRelatedWith <em>Is Related With</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Is Related With</em>' reference list is set.
	 * @see #unsetIsRelatedWith()
	 * @see #getIsRelatedWith()
	 * @generated
	 */
	boolean isSetIsRelatedWith();

	/**
	 * Returns the value of the '<em><b>Properties For Constraint</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3tc1.IfcPropertyConstraintRelationship}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3tc1.IfcPropertyConstraintRelationship#getRelatingConstraint <em>Relating Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties For Constraint</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties For Constraint</em>' reference list.
	 * @see #isSetPropertiesForConstraint()
	 * @see #unsetPropertiesForConstraint()
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcConstraint_PropertiesForConstraint()
	 * @see org.bimserver.models.ifc2x3tc1.IfcPropertyConstraintRelationship#getRelatingConstraint
	 * @model opposite="RelatingConstraint" unsettable="true"
	 * @generated
	 */
	EList<IfcPropertyConstraintRelationship> getPropertiesForConstraint();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcConstraint#getPropertiesForConstraint <em>Properties For Constraint</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPropertiesForConstraint()
	 * @see #getPropertiesForConstraint()
	 * @generated
	 */
	void unsetPropertiesForConstraint();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcConstraint#getPropertiesForConstraint <em>Properties For Constraint</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Properties For Constraint</em>' reference list is set.
	 * @see #unsetPropertiesForConstraint()
	 * @see #getPropertiesForConstraint()
	 * @generated
	 */
	boolean isSetPropertiesForConstraint();

	/**
	 * Returns the value of the '<em><b>Aggregates</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3tc1.IfcConstraintAggregationRelationship}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3tc1.IfcConstraintAggregationRelationship#getRelatingConstraint <em>Relating Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Aggregates</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aggregates</em>' reference list.
	 * @see #isSetAggregates()
	 * @see #unsetAggregates()
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcConstraint_Aggregates()
	 * @see org.bimserver.models.ifc2x3tc1.IfcConstraintAggregationRelationship#getRelatingConstraint
	 * @model opposite="RelatingConstraint" unsettable="true"
	 * @generated
	 */
	EList<IfcConstraintAggregationRelationship> getAggregates();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcConstraint#getAggregates <em>Aggregates</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetAggregates()
	 * @see #getAggregates()
	 * @generated
	 */
	void unsetAggregates();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcConstraint#getAggregates <em>Aggregates</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Aggregates</em>' reference list is set.
	 * @see #unsetAggregates()
	 * @see #getAggregates()
	 * @generated
	 */
	boolean isSetAggregates();

	/**
	 * Returns the value of the '<em><b>Is Aggregated In</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3tc1.IfcConstraintAggregationRelationship}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3tc1.IfcConstraintAggregationRelationship#getRelatedConstraints <em>Related Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Aggregated In</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Aggregated In</em>' reference list.
	 * @see #isSetIsAggregatedIn()
	 * @see #unsetIsAggregatedIn()
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcConstraint_IsAggregatedIn()
	 * @see org.bimserver.models.ifc2x3tc1.IfcConstraintAggregationRelationship#getRelatedConstraints
	 * @model opposite="RelatedConstraints" unsettable="true"
	 * @generated
	 */
	EList<IfcConstraintAggregationRelationship> getIsAggregatedIn();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcConstraint#getIsAggregatedIn <em>Is Aggregated In</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIsAggregatedIn()
	 * @see #getIsAggregatedIn()
	 * @generated
	 */
	void unsetIsAggregatedIn();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcConstraint#getIsAggregatedIn <em>Is Aggregated In</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Is Aggregated In</em>' reference list is set.
	 * @see #unsetIsAggregatedIn()
	 * @see #getIsAggregatedIn()
	 * @generated
	 */
	boolean isSetIsAggregatedIn();

} // IfcConstraint
