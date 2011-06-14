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

import org.bimserver.emf.IdEObject;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcConstraint#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcConstraint#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcConstraint#getConstraintGrade <em>Constraint Grade</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcConstraint#getConstraintSource <em>Constraint Source</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcConstraint#getCreatingActor <em>Creating Actor</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcConstraint#getCreationTime <em>Creation Time</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcConstraint#getUserDefinedGrade <em>User Defined Grade</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcConstraint#getClassifiedAs <em>Classified As</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcConstraint#getRelatesConstraints <em>Relates Constraints</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcConstraint#getIsRelatedWith <em>Is Related With</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcConstraint#getPropertiesForConstraint <em>Properties For Constraint</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcConstraint#getAggregates <em>Aggregates</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcConstraint#getIsAggregatedIn <em>Is Aggregated In</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcConstraint()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface IfcConstraint extends IdEObject
{
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcConstraint_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcConstraint#getName <em>Name</em>}' attribute.
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcConstraint_Description()
	 * @model unsettable="true"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcConstraint#getDescription <em>Description</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcConstraint#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDescription()
	 * @see #getDescription()
	 * @see #setDescription(String)
	 * @generated
	 */
	void unsetDescription();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcConstraint#getDescription <em>Description</em>}' attribute is set.
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
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.IfcConstraintEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Grade</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint Grade</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcConstraintEnum
	 * @see #setConstraintGrade(IfcConstraintEnum)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcConstraint_ConstraintGrade()
	 * @model
	 * @generated
	 */
	IfcConstraintEnum getConstraintGrade();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcConstraint#getConstraintGrade <em>Constraint Grade</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constraint Grade</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcConstraintEnum
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcConstraint_ConstraintSource()
	 * @model unsettable="true"
	 * @generated
	 */
	String getConstraintSource();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcConstraint#getConstraintSource <em>Constraint Source</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcConstraint#getConstraintSource <em>Constraint Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetConstraintSource()
	 * @see #getConstraintSource()
	 * @see #setConstraintSource(String)
	 * @generated
	 */
	void unsetConstraintSource();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcConstraint#getConstraintSource <em>Constraint Source</em>}' attribute is set.
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcConstraint_CreatingActor()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcActorSelect getCreatingActor();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcConstraint#getCreatingActor <em>Creating Actor</em>}' reference.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcConstraint#getCreatingActor <em>Creating Actor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCreatingActor()
	 * @see #getCreatingActor()
	 * @see #setCreatingActor(IfcActorSelect)
	 * @generated
	 */
	void unsetCreatingActor();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcConstraint#getCreatingActor <em>Creating Actor</em>}' reference is set.
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcConstraint_CreationTime()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcDateTimeSelect getCreationTime();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcConstraint#getCreationTime <em>Creation Time</em>}' reference.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcConstraint#getCreationTime <em>Creation Time</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCreationTime()
	 * @see #getCreationTime()
	 * @see #setCreationTime(IfcDateTimeSelect)
	 * @generated
	 */
	void unsetCreationTime();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcConstraint#getCreationTime <em>Creation Time</em>}' reference is set.
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcConstraint_UserDefinedGrade()
	 * @model unsettable="true"
	 * @generated
	 */
	String getUserDefinedGrade();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcConstraint#getUserDefinedGrade <em>User Defined Grade</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcConstraint#getUserDefinedGrade <em>User Defined Grade</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUserDefinedGrade()
	 * @see #getUserDefinedGrade()
	 * @see #setUserDefinedGrade(String)
	 * @generated
	 */
	void unsetUserDefinedGrade();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcConstraint#getUserDefinedGrade <em>User Defined Grade</em>}' attribute is set.
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
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcConstraintClassificationRelationship}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcConstraintClassificationRelationship#getClassifiedConstraint <em>Classified Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classified As</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classified As</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcConstraint_ClassifiedAs()
	 * @see org.bimserver.models.ifc2x3.IfcConstraintClassificationRelationship#getClassifiedConstraint
	 * @model opposite="ClassifiedConstraint"
	 * @generated
	 */
	EList<IfcConstraintClassificationRelationship> getClassifiedAs();

	/**
	 * Returns the value of the '<em><b>Relates Constraints</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcConstraintRelationship}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcConstraintRelationship#getRelatingConstraint <em>Relating Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relates Constraints</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relates Constraints</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcConstraint_RelatesConstraints()
	 * @see org.bimserver.models.ifc2x3.IfcConstraintRelationship#getRelatingConstraint
	 * @model opposite="RelatingConstraint"
	 * @generated
	 */
	EList<IfcConstraintRelationship> getRelatesConstraints();

	/**
	 * Returns the value of the '<em><b>Is Related With</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcConstraintRelationship}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcConstraintRelationship#getRelatedConstraints <em>Related Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Related With</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Related With</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcConstraint_IsRelatedWith()
	 * @see org.bimserver.models.ifc2x3.IfcConstraintRelationship#getRelatedConstraints
	 * @model opposite="RelatedConstraints"
	 * @generated
	 */
	EList<IfcConstraintRelationship> getIsRelatedWith();

	/**
	 * Returns the value of the '<em><b>Properties For Constraint</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcPropertyConstraintRelationship}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcPropertyConstraintRelationship#getRelatingConstraint <em>Relating Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties For Constraint</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties For Constraint</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcConstraint_PropertiesForConstraint()
	 * @see org.bimserver.models.ifc2x3.IfcPropertyConstraintRelationship#getRelatingConstraint
	 * @model opposite="RelatingConstraint"
	 * @generated
	 */
	EList<IfcPropertyConstraintRelationship> getPropertiesForConstraint();

	/**
	 * Returns the value of the '<em><b>Aggregates</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcConstraintAggregationRelationship}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcConstraintAggregationRelationship#getRelatingConstraint <em>Relating Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Aggregates</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aggregates</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcConstraint_Aggregates()
	 * @see org.bimserver.models.ifc2x3.IfcConstraintAggregationRelationship#getRelatingConstraint
	 * @model opposite="RelatingConstraint"
	 * @generated
	 */
	EList<IfcConstraintAggregationRelationship> getAggregates();

	/**
	 * Returns the value of the '<em><b>Is Aggregated In</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcConstraintAggregationRelationship}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcConstraintAggregationRelationship#getRelatedConstraints <em>Related Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Aggregated In</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Aggregated In</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcConstraint_IsAggregatedIn()
	 * @see org.bimserver.models.ifc2x3.IfcConstraintAggregationRelationship#getRelatedConstraints
	 * @model opposite="RelatedConstraints"
	 * @generated
	 */
	EList<IfcConstraintAggregationRelationship> getIsAggregatedIn();

} // IfcConstraint
