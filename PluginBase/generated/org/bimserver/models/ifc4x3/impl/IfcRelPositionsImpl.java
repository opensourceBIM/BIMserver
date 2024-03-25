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
import org.bimserver.models.ifc4x3.IfcPositioningElement;
import org.bimserver.models.ifc4x3.IfcProduct;
import org.bimserver.models.ifc4x3.IfcRelPositions;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Rel Positions</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcRelPositionsImpl#getRelatingPositioningElement <em>Relating Positioning Element</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcRelPositionsImpl#getRelatedProducts <em>Related Products</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcRelPositionsImpl extends IfcRelConnectsImpl implements IfcRelPositions {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRelPositionsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.Literals.IFC_REL_POSITIONS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPositioningElement getRelatingPositioningElement() {
		return (IfcPositioningElement) eGet(Ifc4x3Package.Literals.IFC_REL_POSITIONS__RELATING_POSITIONING_ELEMENT,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRelatingPositioningElement(IfcPositioningElement newRelatingPositioningElement) {
		eSet(Ifc4x3Package.Literals.IFC_REL_POSITIONS__RELATING_POSITIONING_ELEMENT, newRelatingPositioningElement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcProduct> getRelatedProducts() {
		return (EList<IfcProduct>) eGet(Ifc4x3Package.Literals.IFC_REL_POSITIONS__RELATED_PRODUCTS, true);
	}

} //IfcRelPositionsImpl
