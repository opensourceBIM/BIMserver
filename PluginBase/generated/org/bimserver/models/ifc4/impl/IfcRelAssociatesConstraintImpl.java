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
import org.bimserver.models.ifc4.IfcRelAssociatesConstraint;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Rel Associates Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcRelAssociatesConstraintImpl#getIntent <em>Intent</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcRelAssociatesConstraintImpl#getRelatingConstraint <em>Relating Constraint</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcRelAssociatesConstraintImpl extends IfcRelAssociatesImpl implements IfcRelAssociatesConstraint {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRelAssociatesConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_REL_ASSOCIATES_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getIntent() {
		return (String) eGet(Ifc4Package.Literals.IFC_REL_ASSOCIATES_CONSTRAINT__INTENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIntent(String newIntent) {
		eSet(Ifc4Package.Literals.IFC_REL_ASSOCIATES_CONSTRAINT__INTENT, newIntent);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetIntent() {
		eUnset(Ifc4Package.Literals.IFC_REL_ASSOCIATES_CONSTRAINT__INTENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetIntent() {
		return eIsSet(Ifc4Package.Literals.IFC_REL_ASSOCIATES_CONSTRAINT__INTENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcConstraint getRelatingConstraint() {
		return (IfcConstraint) eGet(Ifc4Package.Literals.IFC_REL_ASSOCIATES_CONSTRAINT__RELATING_CONSTRAINT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRelatingConstraint(IfcConstraint newRelatingConstraint) {
		eSet(Ifc4Package.Literals.IFC_REL_ASSOCIATES_CONSTRAINT__RELATING_CONSTRAINT, newRelatingConstraint);
	}

} //IfcRelAssociatesConstraintImpl
