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
import org.bimserver.models.ifc4.IfcApproval;
import org.bimserver.models.ifc4.IfcResourceApprovalRelationship;
import org.bimserver.models.ifc4.IfcResourceObjectSelect;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Resource Approval Relationship</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcResourceApprovalRelationshipImpl#getRelatedResourceObjects <em>Related Resource Objects</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcResourceApprovalRelationshipImpl#getRelatingApproval <em>Relating Approval</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcResourceApprovalRelationshipImpl extends IfcResourceLevelRelationshipImpl implements IfcResourceApprovalRelationship {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcResourceApprovalRelationshipImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_RESOURCE_APPROVAL_RELATIONSHIP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcResourceObjectSelect> getRelatedResourceObjects() {
		return (EList<IfcResourceObjectSelect>) eGet(Ifc4Package.Literals.IFC_RESOURCE_APPROVAL_RELATIONSHIP__RELATED_RESOURCE_OBJECTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcApproval getRelatingApproval() {
		return (IfcApproval) eGet(Ifc4Package.Literals.IFC_RESOURCE_APPROVAL_RELATIONSHIP__RELATING_APPROVAL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRelatingApproval(IfcApproval newRelatingApproval) {
		eSet(Ifc4Package.Literals.IFC_RESOURCE_APPROVAL_RELATIONSHIP__RELATING_APPROVAL, newRelatingApproval);
	}

} //IfcResourceApprovalRelationshipImpl
