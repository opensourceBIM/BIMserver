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
import org.bimserver.models.ifc4.IfcDistributionElement;
import org.bimserver.models.ifc4.IfcPort;
import org.bimserver.models.ifc4.IfcRelConnectsPortToElement;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Rel Connects Port To Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcRelConnectsPortToElementImpl#getRelatingPort <em>Relating Port</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcRelConnectsPortToElementImpl#getRelatedElement <em>Related Element</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcRelConnectsPortToElementImpl extends IfcRelConnectsImpl implements IfcRelConnectsPortToElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRelConnectsPortToElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_REL_CONNECTS_PORT_TO_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPort getRelatingPort() {
		return (IfcPort) eGet(Ifc4Package.Literals.IFC_REL_CONNECTS_PORT_TO_ELEMENT__RELATING_PORT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRelatingPort(IfcPort newRelatingPort) {
		eSet(Ifc4Package.Literals.IFC_REL_CONNECTS_PORT_TO_ELEMENT__RELATING_PORT, newRelatingPort);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDistributionElement getRelatedElement() {
		return (IfcDistributionElement) eGet(Ifc4Package.Literals.IFC_REL_CONNECTS_PORT_TO_ELEMENT__RELATED_ELEMENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRelatedElement(IfcDistributionElement newRelatedElement) {
		eSet(Ifc4Package.Literals.IFC_REL_CONNECTS_PORT_TO_ELEMENT__RELATED_ELEMENT, newRelatedElement);
	}

} //IfcRelConnectsPortToElementImpl
