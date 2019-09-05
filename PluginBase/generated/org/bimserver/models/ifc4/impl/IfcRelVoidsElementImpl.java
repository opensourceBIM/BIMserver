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
import org.bimserver.models.ifc4.IfcFeatureElementSubtraction;
import org.bimserver.models.ifc4.IfcRelVoidsElement;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Rel Voids Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcRelVoidsElementImpl#getRelatingBuildingElement <em>Relating Building Element</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcRelVoidsElementImpl#getRelatedOpeningElement <em>Related Opening Element</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcRelVoidsElementImpl extends IfcRelDecomposesImpl implements IfcRelVoidsElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRelVoidsElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_REL_VOIDS_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcElement getRelatingBuildingElement() {
		return (IfcElement) eGet(Ifc4Package.Literals.IFC_REL_VOIDS_ELEMENT__RELATING_BUILDING_ELEMENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRelatingBuildingElement(IfcElement newRelatingBuildingElement) {
		eSet(Ifc4Package.Literals.IFC_REL_VOIDS_ELEMENT__RELATING_BUILDING_ELEMENT, newRelatingBuildingElement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcFeatureElementSubtraction getRelatedOpeningElement() {
		return (IfcFeatureElementSubtraction) eGet(Ifc4Package.Literals.IFC_REL_VOIDS_ELEMENT__RELATED_OPENING_ELEMENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRelatedOpeningElement(IfcFeatureElementSubtraction newRelatedOpeningElement) {
		eSet(Ifc4Package.Literals.IFC_REL_VOIDS_ELEMENT__RELATED_OPENING_ELEMENT, newRelatedOpeningElement);
	}

} //IfcRelVoidsElementImpl
