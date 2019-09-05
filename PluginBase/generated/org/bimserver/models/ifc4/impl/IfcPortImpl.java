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
import org.bimserver.models.ifc4.IfcPort;
import org.bimserver.models.ifc4.IfcRelConnectsPortToElement;
import org.bimserver.models.ifc4.IfcRelConnectsPorts;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Port</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcPortImpl#getContainedIn <em>Contained In</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcPortImpl#getConnectedFrom <em>Connected From</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcPortImpl#getConnectedTo <em>Connected To</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcPortImpl extends IfcProductImpl implements IfcPort {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcPortImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_PORT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelConnectsPortToElement> getContainedIn() {
		return (EList<IfcRelConnectsPortToElement>) eGet(Ifc4Package.Literals.IFC_PORT__CONTAINED_IN, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetContainedIn() {
		eUnset(Ifc4Package.Literals.IFC_PORT__CONTAINED_IN);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetContainedIn() {
		return eIsSet(Ifc4Package.Literals.IFC_PORT__CONTAINED_IN);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelConnectsPorts> getConnectedFrom() {
		return (EList<IfcRelConnectsPorts>) eGet(Ifc4Package.Literals.IFC_PORT__CONNECTED_FROM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetConnectedFrom() {
		eUnset(Ifc4Package.Literals.IFC_PORT__CONNECTED_FROM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetConnectedFrom() {
		return eIsSet(Ifc4Package.Literals.IFC_PORT__CONNECTED_FROM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelConnectsPorts> getConnectedTo() {
		return (EList<IfcRelConnectsPorts>) eGet(Ifc4Package.Literals.IFC_PORT__CONNECTED_TO, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetConnectedTo() {
		eUnset(Ifc4Package.Literals.IFC_PORT__CONNECTED_TO);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetConnectedTo() {
		return eIsSet(Ifc4Package.Literals.IFC_PORT__CONNECTED_TO);
	}

} //IfcPortImpl
