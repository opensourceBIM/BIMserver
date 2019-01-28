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
package org.bimserver.models.ifc2x3tc1.impl;

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

import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.IfcActorSelect;
import org.bimserver.models.ifc2x3tc1.IfcConstraint;
import org.bimserver.models.ifc2x3tc1.IfcConstraintAggregationRelationship;
import org.bimserver.models.ifc2x3tc1.IfcConstraintClassificationRelationship;
import org.bimserver.models.ifc2x3tc1.IfcConstraintEnum;
import org.bimserver.models.ifc2x3tc1.IfcConstraintRelationship;
import org.bimserver.models.ifc2x3tc1.IfcDateTimeSelect;
import org.bimserver.models.ifc2x3tc1.IfcPropertyConstraintRelationship;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcConstraintImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcConstraintImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcConstraintImpl#getConstraintGrade <em>Constraint Grade</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcConstraintImpl#getConstraintSource <em>Constraint Source</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcConstraintImpl#getCreatingActor <em>Creating Actor</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcConstraintImpl#getCreationTime <em>Creation Time</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcConstraintImpl#getUserDefinedGrade <em>User Defined Grade</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcConstraintImpl#getClassifiedAs <em>Classified As</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcConstraintImpl#getRelatesConstraints <em>Relates Constraints</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcConstraintImpl#getIsRelatedWith <em>Is Related With</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcConstraintImpl#getPropertiesForConstraint <em>Properties For Constraint</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcConstraintImpl#getAggregates <em>Aggregates</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcConstraintImpl#getIsAggregatedIn <em>Is Aggregated In</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcConstraintImpl extends IdEObjectImpl implements IfcConstraint {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_CONSTRAINT__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(Ifc2x3tc1Package.Literals.IFC_CONSTRAINT__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_CONSTRAINT__DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		eSet(Ifc2x3tc1Package.Literals.IFC_CONSTRAINT__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDescription() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_CONSTRAINT__DESCRIPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDescription() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_CONSTRAINT__DESCRIPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcConstraintEnum getConstraintGrade() {
		return (IfcConstraintEnum) eGet(Ifc2x3tc1Package.Literals.IFC_CONSTRAINT__CONSTRAINT_GRADE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstraintGrade(IfcConstraintEnum newConstraintGrade) {
		eSet(Ifc2x3tc1Package.Literals.IFC_CONSTRAINT__CONSTRAINT_GRADE, newConstraintGrade);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConstraintSource() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_CONSTRAINT__CONSTRAINT_SOURCE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstraintSource(String newConstraintSource) {
		eSet(Ifc2x3tc1Package.Literals.IFC_CONSTRAINT__CONSTRAINT_SOURCE, newConstraintSource);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetConstraintSource() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_CONSTRAINT__CONSTRAINT_SOURCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetConstraintSource() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_CONSTRAINT__CONSTRAINT_SOURCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcActorSelect getCreatingActor() {
		return (IfcActorSelect) eGet(Ifc2x3tc1Package.Literals.IFC_CONSTRAINT__CREATING_ACTOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreatingActor(IfcActorSelect newCreatingActor) {
		eSet(Ifc2x3tc1Package.Literals.IFC_CONSTRAINT__CREATING_ACTOR, newCreatingActor);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCreatingActor() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_CONSTRAINT__CREATING_ACTOR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCreatingActor() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_CONSTRAINT__CREATING_ACTOR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDateTimeSelect getCreationTime() {
		return (IfcDateTimeSelect) eGet(Ifc2x3tc1Package.Literals.IFC_CONSTRAINT__CREATION_TIME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreationTime(IfcDateTimeSelect newCreationTime) {
		eSet(Ifc2x3tc1Package.Literals.IFC_CONSTRAINT__CREATION_TIME, newCreationTime);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCreationTime() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_CONSTRAINT__CREATION_TIME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCreationTime() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_CONSTRAINT__CREATION_TIME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUserDefinedGrade() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_CONSTRAINT__USER_DEFINED_GRADE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserDefinedGrade(String newUserDefinedGrade) {
		eSet(Ifc2x3tc1Package.Literals.IFC_CONSTRAINT__USER_DEFINED_GRADE, newUserDefinedGrade);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUserDefinedGrade() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_CONSTRAINT__USER_DEFINED_GRADE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUserDefinedGrade() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_CONSTRAINT__USER_DEFINED_GRADE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcConstraintClassificationRelationship> getClassifiedAs() {
		return (EList<IfcConstraintClassificationRelationship>) eGet(
				Ifc2x3tc1Package.Literals.IFC_CONSTRAINT__CLASSIFIED_AS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetClassifiedAs() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_CONSTRAINT__CLASSIFIED_AS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetClassifiedAs() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_CONSTRAINT__CLASSIFIED_AS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcConstraintRelationship> getRelatesConstraints() {
		return (EList<IfcConstraintRelationship>) eGet(Ifc2x3tc1Package.Literals.IFC_CONSTRAINT__RELATES_CONSTRAINTS,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRelatesConstraints() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_CONSTRAINT__RELATES_CONSTRAINTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRelatesConstraints() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_CONSTRAINT__RELATES_CONSTRAINTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcConstraintRelationship> getIsRelatedWith() {
		return (EList<IfcConstraintRelationship>) eGet(Ifc2x3tc1Package.Literals.IFC_CONSTRAINT__IS_RELATED_WITH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIsRelatedWith() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_CONSTRAINT__IS_RELATED_WITH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIsRelatedWith() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_CONSTRAINT__IS_RELATED_WITH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcPropertyConstraintRelationship> getPropertiesForConstraint() {
		return (EList<IfcPropertyConstraintRelationship>) eGet(
				Ifc2x3tc1Package.Literals.IFC_CONSTRAINT__PROPERTIES_FOR_CONSTRAINT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPropertiesForConstraint() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_CONSTRAINT__PROPERTIES_FOR_CONSTRAINT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPropertiesForConstraint() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_CONSTRAINT__PROPERTIES_FOR_CONSTRAINT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcConstraintAggregationRelationship> getAggregates() {
		return (EList<IfcConstraintAggregationRelationship>) eGet(Ifc2x3tc1Package.Literals.IFC_CONSTRAINT__AGGREGATES,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetAggregates() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_CONSTRAINT__AGGREGATES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetAggregates() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_CONSTRAINT__AGGREGATES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcConstraintAggregationRelationship> getIsAggregatedIn() {
		return (EList<IfcConstraintAggregationRelationship>) eGet(
				Ifc2x3tc1Package.Literals.IFC_CONSTRAINT__IS_AGGREGATED_IN, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIsAggregatedIn() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_CONSTRAINT__IS_AGGREGATED_IN);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIsAggregatedIn() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_CONSTRAINT__IS_AGGREGATED_IN);
	}

} //IfcConstraintImpl
