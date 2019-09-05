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
 *   <li>{@link org.bimserver.models.ifc4.IfcConstraint#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcConstraint#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcConstraint#getConstraintGrade <em>Constraint Grade</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcConstraint#getConstraintSource <em>Constraint Source</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcConstraint#getCreatingActor <em>Creating Actor</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcConstraint#getCreationTime <em>Creation Time</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcConstraint#getUserDefinedGrade <em>User Defined Grade</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcConstraint#getHasExternalReferences <em>Has External References</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcConstraint#getPropertiesForConstraint <em>Properties For Constraint</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcConstraint()
 * @model
 * @generated
 */
public interface IfcConstraint extends IfcResourceObjectSelect {
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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcConstraint_Name()
	 * @model annotation="singleindex"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcConstraint#getName <em>Name</em>}' attribute.
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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcConstraint_Description()
	 * @model unsettable="true"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcConstraint#getDescription <em>Description</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcConstraint#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDescription()
	 * @see #getDescription()
	 * @see #setDescription(String)
	 * @generated
	 */
	void unsetDescription();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcConstraint#getDescription <em>Description</em>}' attribute is set.
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
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.IfcConstraintEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Grade</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint Grade</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcConstraintEnum
	 * @see #setConstraintGrade(IfcConstraintEnum)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcConstraint_ConstraintGrade()
	 * @model
	 * @generated
	 */
	IfcConstraintEnum getConstraintGrade();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcConstraint#getConstraintGrade <em>Constraint Grade</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constraint Grade</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcConstraintEnum
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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcConstraint_ConstraintSource()
	 * @model unsettable="true"
	 * @generated
	 */
	String getConstraintSource();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcConstraint#getConstraintSource <em>Constraint Source</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcConstraint#getConstraintSource <em>Constraint Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetConstraintSource()
	 * @see #getConstraintSource()
	 * @see #setConstraintSource(String)
	 * @generated
	 */
	void unsetConstraintSource();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcConstraint#getConstraintSource <em>Constraint Source</em>}' attribute is set.
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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcConstraint_CreatingActor()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcActorSelect getCreatingActor();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcConstraint#getCreatingActor <em>Creating Actor</em>}' reference.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcConstraint#getCreatingActor <em>Creating Actor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCreatingActor()
	 * @see #getCreatingActor()
	 * @see #setCreatingActor(IfcActorSelect)
	 * @generated
	 */
	void unsetCreatingActor();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcConstraint#getCreatingActor <em>Creating Actor</em>}' reference is set.
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
	 * Returns the value of the '<em><b>Creation Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Creation Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Creation Time</em>' attribute.
	 * @see #isSetCreationTime()
	 * @see #unsetCreationTime()
	 * @see #setCreationTime(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcConstraint_CreationTime()
	 * @model unsettable="true"
	 * @generated
	 */
	String getCreationTime();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcConstraint#getCreationTime <em>Creation Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Creation Time</em>' attribute.
	 * @see #isSetCreationTime()
	 * @see #unsetCreationTime()
	 * @see #getCreationTime()
	 * @generated
	 */
	void setCreationTime(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcConstraint#getCreationTime <em>Creation Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCreationTime()
	 * @see #getCreationTime()
	 * @see #setCreationTime(String)
	 * @generated
	 */
	void unsetCreationTime();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcConstraint#getCreationTime <em>Creation Time</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Creation Time</em>' attribute is set.
	 * @see #unsetCreationTime()
	 * @see #getCreationTime()
	 * @see #setCreationTime(String)
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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcConstraint_UserDefinedGrade()
	 * @model unsettable="true"
	 * @generated
	 */
	String getUserDefinedGrade();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcConstraint#getUserDefinedGrade <em>User Defined Grade</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcConstraint#getUserDefinedGrade <em>User Defined Grade</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUserDefinedGrade()
	 * @see #getUserDefinedGrade()
	 * @see #setUserDefinedGrade(String)
	 * @generated
	 */
	void unsetUserDefinedGrade();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcConstraint#getUserDefinedGrade <em>User Defined Grade</em>}' attribute is set.
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
	 * Returns the value of the '<em><b>Has External References</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcExternalReferenceRelationship}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has External References</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has External References</em>' reference list.
	 * @see #isSetHasExternalReferences()
	 * @see #unsetHasExternalReferences()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcConstraint_HasExternalReferences()
	 * @model unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcExternalReferenceRelationship> getHasExternalReferences();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcConstraint#getHasExternalReferences <em>Has External References</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetHasExternalReferences()
	 * @see #getHasExternalReferences()
	 * @generated
	 */
	void unsetHasExternalReferences();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcConstraint#getHasExternalReferences <em>Has External References</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Has External References</em>' reference list is set.
	 * @see #unsetHasExternalReferences()
	 * @see #getHasExternalReferences()
	 * @generated
	 */
	boolean isSetHasExternalReferences();

	/**
	 * Returns the value of the '<em><b>Properties For Constraint</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcResourceConstraintRelationship}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcResourceConstraintRelationship#getRelatingConstraint <em>Relating Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties For Constraint</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties For Constraint</em>' reference list.
	 * @see #isSetPropertiesForConstraint()
	 * @see #unsetPropertiesForConstraint()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcConstraint_PropertiesForConstraint()
	 * @see org.bimserver.models.ifc4.IfcResourceConstraintRelationship#getRelatingConstraint
	 * @model opposite="RelatingConstraint" unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcResourceConstraintRelationship> getPropertiesForConstraint();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcConstraint#getPropertiesForConstraint <em>Properties For Constraint</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPropertiesForConstraint()
	 * @see #getPropertiesForConstraint()
	 * @generated
	 */
	void unsetPropertiesForConstraint();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcConstraint#getPropertiesForConstraint <em>Properties For Constraint</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Properties For Constraint</em>' reference list is set.
	 * @see #unsetPropertiesForConstraint()
	 * @see #getPropertiesForConstraint()
	 * @generated
	 */
	boolean isSetPropertiesForConstraint();

} // IfcConstraint
