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
 * A representation of the model object '<em><b>Ifc Resource Constraint Relationship</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcResourceConstraintRelationship#getRelatingConstraint <em>Relating Constraint</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcResourceConstraintRelationship#getRelatedResourceObjects <em>Related Resource Objects</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcResourceConstraintRelationship()
 * @model
 * @generated
 */
public interface IfcResourceConstraintRelationship extends IfcResourceLevelRelationship {
	/**
	 * Returns the value of the '<em><b>Relating Constraint</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcConstraint#getPropertiesForConstraint <em>Properties For Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relating Constraint</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relating Constraint</em>' reference.
	 * @see #setRelatingConstraint(IfcConstraint)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcResourceConstraintRelationship_RelatingConstraint()
	 * @see org.bimserver.models.ifc4.IfcConstraint#getPropertiesForConstraint
	 * @model opposite="PropertiesForConstraint"
	 *        annotation="inverse"
	 * @generated
	 */
	IfcConstraint getRelatingConstraint();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcResourceConstraintRelationship#getRelatingConstraint <em>Relating Constraint</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relating Constraint</em>' reference.
	 * @see #getRelatingConstraint()
	 * @generated
	 */
	void setRelatingConstraint(IfcConstraint value);

	/**
	 * Returns the value of the '<em><b>Related Resource Objects</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcResourceObjectSelect}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Related Resource Objects</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Related Resource Objects</em>' reference list.
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcResourceConstraintRelationship_RelatedResourceObjects()
	 * @model annotation="inverse"
	 * @generated
	 */
	EList<IfcResourceObjectSelect> getRelatedResourceObjects();

} // IfcResourceConstraintRelationship
