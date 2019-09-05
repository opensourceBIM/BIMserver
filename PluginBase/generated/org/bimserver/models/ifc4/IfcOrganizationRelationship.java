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
 * A representation of the model object '<em><b>Ifc Organization Relationship</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcOrganizationRelationship#getRelatingOrganization <em>Relating Organization</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcOrganizationRelationship#getRelatedOrganizations <em>Related Organizations</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcOrganizationRelationship()
 * @model
 * @generated
 */
public interface IfcOrganizationRelationship extends IfcResourceLevelRelationship {
	/**
	 * Returns the value of the '<em><b>Relating Organization</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcOrganization#getRelates <em>Relates</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relating Organization</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relating Organization</em>' reference.
	 * @see #setRelatingOrganization(IfcOrganization)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcOrganizationRelationship_RelatingOrganization()
	 * @see org.bimserver.models.ifc4.IfcOrganization#getRelates
	 * @model opposite="Relates"
	 *        annotation="inverse"
	 * @generated
	 */
	IfcOrganization getRelatingOrganization();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcOrganizationRelationship#getRelatingOrganization <em>Relating Organization</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relating Organization</em>' reference.
	 * @see #getRelatingOrganization()
	 * @generated
	 */
	void setRelatingOrganization(IfcOrganization value);

	/**
	 * Returns the value of the '<em><b>Related Organizations</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcOrganization}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcOrganization#getIsRelatedBy <em>Is Related By</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Related Organizations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Related Organizations</em>' reference list.
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcOrganizationRelationship_RelatedOrganizations()
	 * @see org.bimserver.models.ifc4.IfcOrganization#getIsRelatedBy
	 * @model opposite="IsRelatedBy"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcOrganization> getRelatedOrganizations();

} // IfcOrganizationRelationship
