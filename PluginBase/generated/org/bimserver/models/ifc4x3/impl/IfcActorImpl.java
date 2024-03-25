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
package org.bimserver.models.ifc4x3.impl;

import org.bimserver.models.ifc4x3.Ifc4x3Package;
import org.bimserver.models.ifc4x3.IfcActor;
import org.bimserver.models.ifc4x3.IfcActorSelect;
import org.bimserver.models.ifc4x3.IfcRelAssignsToActor;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Actor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcActorImpl#getTheActor <em>The Actor</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcActorImpl#getIsActingUpon <em>Is Acting Upon</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcActorImpl extends IfcObjectImpl implements IfcActor {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcActorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.Literals.IFC_ACTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcActorSelect getTheActor() {
		return (IfcActorSelect) eGet(Ifc4x3Package.Literals.IFC_ACTOR__THE_ACTOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTheActor(IfcActorSelect newTheActor) {
		eSet(Ifc4x3Package.Literals.IFC_ACTOR__THE_ACTOR, newTheActor);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelAssignsToActor> getIsActingUpon() {
		return (EList<IfcRelAssignsToActor>) eGet(Ifc4x3Package.Literals.IFC_ACTOR__IS_ACTING_UPON, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetIsActingUpon() {
		eUnset(Ifc4x3Package.Literals.IFC_ACTOR__IS_ACTING_UPON);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetIsActingUpon() {
		return eIsSet(Ifc4x3Package.Literals.IFC_ACTOR__IS_ACTING_UPON);
	}

} //IfcActorImpl
