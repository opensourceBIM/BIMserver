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

import org.bimserver.models.ifc4.Ifc4Package;
import org.bimserver.models.ifc4.IfcConstraint;
import org.bimserver.models.ifc4.IfcResourceConstraintRelationship;
import org.bimserver.models.ifc4.IfcResourceObjectSelect;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Resource Constraint Relationship</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcResourceConstraintRelationshipImpl#getRelatingConstraint <em>Relating Constraint</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcResourceConstraintRelationshipImpl#getRelatedResourceObjects <em>Related Resource Objects</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcResourceConstraintRelationshipImpl extends IfcResourceLevelRelationshipImpl implements IfcResourceConstraintRelationship {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcResourceConstraintRelationshipImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_RESOURCE_CONSTRAINT_RELATIONSHIP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcConstraint getRelatingConstraint() {
		return (IfcConstraint) eGet(Ifc4Package.Literals.IFC_RESOURCE_CONSTRAINT_RELATIONSHIP__RELATING_CONSTRAINT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRelatingConstraint(IfcConstraint newRelatingConstraint) {
		eSet(Ifc4Package.Literals.IFC_RESOURCE_CONSTRAINT_RELATIONSHIP__RELATING_CONSTRAINT, newRelatingConstraint);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcResourceObjectSelect> getRelatedResourceObjects() {
		return (EList<IfcResourceObjectSelect>) eGet(Ifc4Package.Literals.IFC_RESOURCE_CONSTRAINT_RELATIONSHIP__RELATED_RESOURCE_OBJECTS, true);
	}

} //IfcResourceConstraintRelationshipImpl
