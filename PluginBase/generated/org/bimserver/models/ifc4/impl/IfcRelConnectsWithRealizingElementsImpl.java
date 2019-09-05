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
import org.bimserver.models.ifc4.IfcElement;
import org.bimserver.models.ifc4.IfcRelConnectsWithRealizingElements;
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
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcRelConnectsWithRealizingElementsImpl#getRealizingElements <em>Realizing Elements</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcRelConnectsWithRealizingElementsImpl#getConnectionType <em>Connection Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcRelConnectsWithRealizingElementsImpl extends IfcRelConnectsElementsImpl implements IfcRelConnectsWithRealizingElements {
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
		return Ifc4Package.Literals.IFC_REL_CONNECTS_WITH_REALIZING_ELEMENTS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcElement> getRealizingElements() {
		return (EList<IfcElement>) eGet(Ifc4Package.Literals.IFC_REL_CONNECTS_WITH_REALIZING_ELEMENTS__REALIZING_ELEMENTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getConnectionType() {
		return (String) eGet(Ifc4Package.Literals.IFC_REL_CONNECTS_WITH_REALIZING_ELEMENTS__CONNECTION_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setConnectionType(String newConnectionType) {
		eSet(Ifc4Package.Literals.IFC_REL_CONNECTS_WITH_REALIZING_ELEMENTS__CONNECTION_TYPE, newConnectionType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetConnectionType() {
		eUnset(Ifc4Package.Literals.IFC_REL_CONNECTS_WITH_REALIZING_ELEMENTS__CONNECTION_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetConnectionType() {
		return eIsSet(Ifc4Package.Literals.IFC_REL_CONNECTS_WITH_REALIZING_ELEMENTS__CONNECTION_TYPE);
	}

} //IfcRelConnectsWithRealizingElementsImpl
