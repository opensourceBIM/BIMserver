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
import org.bimserver.models.ifc4.IfcActor;
import org.bimserver.models.ifc4.IfcActorRole;
import org.bimserver.models.ifc4.IfcRelAssignsToActor;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Rel Assigns To Actor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcRelAssignsToActorImpl#getRelatingActor <em>Relating Actor</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcRelAssignsToActorImpl#getActingRole <em>Acting Role</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcRelAssignsToActorImpl extends IfcRelAssignsImpl implements IfcRelAssignsToActor {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRelAssignsToActorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_REL_ASSIGNS_TO_ACTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcActor getRelatingActor() {
		return (IfcActor) eGet(Ifc4Package.Literals.IFC_REL_ASSIGNS_TO_ACTOR__RELATING_ACTOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRelatingActor(IfcActor newRelatingActor) {
		eSet(Ifc4Package.Literals.IFC_REL_ASSIGNS_TO_ACTOR__RELATING_ACTOR, newRelatingActor);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcActorRole getActingRole() {
		return (IfcActorRole) eGet(Ifc4Package.Literals.IFC_REL_ASSIGNS_TO_ACTOR__ACTING_ROLE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setActingRole(IfcActorRole newActingRole) {
		eSet(Ifc4Package.Literals.IFC_REL_ASSIGNS_TO_ACTOR__ACTING_ROLE, newActingRole);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetActingRole() {
		eUnset(Ifc4Package.Literals.IFC_REL_ASSIGNS_TO_ACTOR__ACTING_ROLE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetActingRole() {
		return eIsSet(Ifc4Package.Literals.IFC_REL_ASSIGNS_TO_ACTOR__ACTING_ROLE);
	}

} //IfcRelAssignsToActorImpl
