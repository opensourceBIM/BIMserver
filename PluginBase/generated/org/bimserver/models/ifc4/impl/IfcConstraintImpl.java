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
package org.bimserver.models.ifc4.impl;

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
import org.bimserver.models.ifc4.Ifc4Package;
import org.bimserver.models.ifc4.IfcActorSelect;
import org.bimserver.models.ifc4.IfcConstraint;
import org.bimserver.models.ifc4.IfcConstraintEnum;
import org.bimserver.models.ifc4.IfcExternalReferenceRelationship;
import org.bimserver.models.ifc4.IfcResourceConstraintRelationship;
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
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcConstraintImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcConstraintImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcConstraintImpl#getConstraintGrade <em>Constraint Grade</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcConstraintImpl#getConstraintSource <em>Constraint Source</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcConstraintImpl#getCreatingActor <em>Creating Actor</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcConstraintImpl#getCreationTime <em>Creation Time</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcConstraintImpl#getUserDefinedGrade <em>User Defined Grade</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcConstraintImpl#getHasExternalReferences <em>Has External References</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcConstraintImpl#getPropertiesForConstraint <em>Properties For Constraint</em>}</li>
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
		return Ifc4Package.Literals.IFC_CONSTRAINT;
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
	@Override
	public String getName() {
		return (String) eGet(Ifc4Package.Literals.IFC_CONSTRAINT__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		eSet(Ifc4Package.Literals.IFC_CONSTRAINT__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDescription() {
		return (String) eGet(Ifc4Package.Literals.IFC_CONSTRAINT__DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescription(String newDescription) {
		eSet(Ifc4Package.Literals.IFC_CONSTRAINT__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDescription() {
		eUnset(Ifc4Package.Literals.IFC_CONSTRAINT__DESCRIPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDescription() {
		return eIsSet(Ifc4Package.Literals.IFC_CONSTRAINT__DESCRIPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcConstraintEnum getConstraintGrade() {
		return (IfcConstraintEnum) eGet(Ifc4Package.Literals.IFC_CONSTRAINT__CONSTRAINT_GRADE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setConstraintGrade(IfcConstraintEnum newConstraintGrade) {
		eSet(Ifc4Package.Literals.IFC_CONSTRAINT__CONSTRAINT_GRADE, newConstraintGrade);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getConstraintSource() {
		return (String) eGet(Ifc4Package.Literals.IFC_CONSTRAINT__CONSTRAINT_SOURCE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setConstraintSource(String newConstraintSource) {
		eSet(Ifc4Package.Literals.IFC_CONSTRAINT__CONSTRAINT_SOURCE, newConstraintSource);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetConstraintSource() {
		eUnset(Ifc4Package.Literals.IFC_CONSTRAINT__CONSTRAINT_SOURCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetConstraintSource() {
		return eIsSet(Ifc4Package.Literals.IFC_CONSTRAINT__CONSTRAINT_SOURCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcActorSelect getCreatingActor() {
		return (IfcActorSelect) eGet(Ifc4Package.Literals.IFC_CONSTRAINT__CREATING_ACTOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCreatingActor(IfcActorSelect newCreatingActor) {
		eSet(Ifc4Package.Literals.IFC_CONSTRAINT__CREATING_ACTOR, newCreatingActor);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCreatingActor() {
		eUnset(Ifc4Package.Literals.IFC_CONSTRAINT__CREATING_ACTOR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCreatingActor() {
		return eIsSet(Ifc4Package.Literals.IFC_CONSTRAINT__CREATING_ACTOR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreationTime() {
		return (String) eGet(Ifc4Package.Literals.IFC_CONSTRAINT__CREATION_TIME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCreationTime(String newCreationTime) {
		eSet(Ifc4Package.Literals.IFC_CONSTRAINT__CREATION_TIME, newCreationTime);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCreationTime() {
		eUnset(Ifc4Package.Literals.IFC_CONSTRAINT__CREATION_TIME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCreationTime() {
		return eIsSet(Ifc4Package.Literals.IFC_CONSTRAINT__CREATION_TIME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getUserDefinedGrade() {
		return (String) eGet(Ifc4Package.Literals.IFC_CONSTRAINT__USER_DEFINED_GRADE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUserDefinedGrade(String newUserDefinedGrade) {
		eSet(Ifc4Package.Literals.IFC_CONSTRAINT__USER_DEFINED_GRADE, newUserDefinedGrade);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetUserDefinedGrade() {
		eUnset(Ifc4Package.Literals.IFC_CONSTRAINT__USER_DEFINED_GRADE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetUserDefinedGrade() {
		return eIsSet(Ifc4Package.Literals.IFC_CONSTRAINT__USER_DEFINED_GRADE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcExternalReferenceRelationship> getHasExternalReferences() {
		return (EList<IfcExternalReferenceRelationship>) eGet(Ifc4Package.Literals.IFC_CONSTRAINT__HAS_EXTERNAL_REFERENCES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetHasExternalReferences() {
		eUnset(Ifc4Package.Literals.IFC_CONSTRAINT__HAS_EXTERNAL_REFERENCES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetHasExternalReferences() {
		return eIsSet(Ifc4Package.Literals.IFC_CONSTRAINT__HAS_EXTERNAL_REFERENCES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcResourceConstraintRelationship> getPropertiesForConstraint() {
		return (EList<IfcResourceConstraintRelationship>) eGet(Ifc4Package.Literals.IFC_CONSTRAINT__PROPERTIES_FOR_CONSTRAINT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPropertiesForConstraint() {
		eUnset(Ifc4Package.Literals.IFC_CONSTRAINT__PROPERTIES_FOR_CONSTRAINT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPropertiesForConstraint() {
		return eIsSet(Ifc4Package.Literals.IFC_CONSTRAINT__PROPERTIES_FOR_CONSTRAINT);
	}

} //IfcConstraintImpl
