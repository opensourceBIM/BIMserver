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
 * A representation of the model object '<em><b>Ifc Constraint Classification Relationship</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcConstraintClassificationRelationship#getClassifiedConstraint <em>Classified Constraint</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcConstraintClassificationRelationship#getRelatedClassifications <em>Related Classifications</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcConstraintClassificationRelationship()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface IfcConstraintClassificationRelationship extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Classified Constraint</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3tc1.IfcConstraint#getClassifiedAs <em>Classified As</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classified Constraint</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classified Constraint</em>' reference.
	 * @see #setClassifiedConstraint(IfcConstraint)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcConstraintClassificationRelationship_ClassifiedConstraint()
	 * @see org.bimserver.models.ifc2x3tc1.IfcConstraint#getClassifiedAs
	 * @model opposite="ClassifiedAs"
	 * @generated
	 */
	IfcConstraint getClassifiedConstraint();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcConstraintClassificationRelationship#getClassifiedConstraint <em>Classified Constraint</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Classified Constraint</em>' reference.
	 * @see #getClassifiedConstraint()
	 * @generated
	 */
	void setClassifiedConstraint(IfcConstraint value);

	/**
	 * Returns the value of the '<em><b>Related Classifications</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3tc1.IfcClassificationNotationSelect}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Related Classifications</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Related Classifications</em>' reference list.
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcConstraintClassificationRelationship_RelatedClassifications()
	 * @model
	 * @generated
	 */
	EList<IfcClassificationNotationSelect> getRelatedClassifications();

} // IfcConstraintClassificationRelationship
