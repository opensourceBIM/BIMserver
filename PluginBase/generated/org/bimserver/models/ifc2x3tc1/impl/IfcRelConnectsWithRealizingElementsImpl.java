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

import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.IfcElement;
import org.bimserver.models.ifc2x3tc1.IfcRelConnectsWithRealizingElements;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Rel Connects With Realizing Elements</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcRelConnectsWithRealizingElementsImpl#getRealizingElements <em>Realizing Elements</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcRelConnectsWithRealizingElementsImpl#getConnectionType <em>Connection Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcRelConnectsWithRealizingElementsImpl extends IfcRelConnectsElementsImpl
		implements IfcRelConnectsWithRealizingElements {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRelConnectsWithRealizingElementsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_REL_CONNECTS_WITH_REALIZING_ELEMENTS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcElement> getRealizingElements() {
		return (EList<IfcElement>) eGet(
				Ifc2x3tc1Package.Literals.IFC_REL_CONNECTS_WITH_REALIZING_ELEMENTS__REALIZING_ELEMENTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConnectionType() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_REL_CONNECTS_WITH_REALIZING_ELEMENTS__CONNECTION_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConnectionType(String newConnectionType) {
		eSet(Ifc2x3tc1Package.Literals.IFC_REL_CONNECTS_WITH_REALIZING_ELEMENTS__CONNECTION_TYPE, newConnectionType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetConnectionType() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_REL_CONNECTS_WITH_REALIZING_ELEMENTS__CONNECTION_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetConnectionType() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_REL_CONNECTS_WITH_REALIZING_ELEMENTS__CONNECTION_TYPE);
	}

} //IfcRelConnectsWithRealizingElementsImpl
