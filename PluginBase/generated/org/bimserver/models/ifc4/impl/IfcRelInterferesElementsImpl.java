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
import org.bimserver.models.ifc4.IfcConnectionGeometry;
import org.bimserver.models.ifc4.IfcElement;
import org.bimserver.models.ifc4.IfcRelInterferesElements;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Rel Interferes Elements</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcRelInterferesElementsImpl#getRelatingElement <em>Relating Element</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcRelInterferesElementsImpl#getRelatedElement <em>Related Element</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcRelInterferesElementsImpl#getInterferenceGeometry <em>Interference Geometry</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcRelInterferesElementsImpl#getInterferenceType <em>Interference Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcRelInterferesElementsImpl#isImpliedOrder <em>Implied Order</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcRelInterferesElementsImpl extends IfcRelConnectsImpl implements IfcRelInterferesElements {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRelInterferesElementsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_REL_INTERFERES_ELEMENTS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcElement getRelatingElement() {
		return (IfcElement) eGet(Ifc4Package.Literals.IFC_REL_INTERFERES_ELEMENTS__RELATING_ELEMENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRelatingElement(IfcElement newRelatingElement) {
		eSet(Ifc4Package.Literals.IFC_REL_INTERFERES_ELEMENTS__RELATING_ELEMENT, newRelatingElement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcElement getRelatedElement() {
		return (IfcElement) eGet(Ifc4Package.Literals.IFC_REL_INTERFERES_ELEMENTS__RELATED_ELEMENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRelatedElement(IfcElement newRelatedElement) {
		eSet(Ifc4Package.Literals.IFC_REL_INTERFERES_ELEMENTS__RELATED_ELEMENT, newRelatedElement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcConnectionGeometry getInterferenceGeometry() {
		return (IfcConnectionGeometry) eGet(Ifc4Package.Literals.IFC_REL_INTERFERES_ELEMENTS__INTERFERENCE_GEOMETRY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInterferenceGeometry(IfcConnectionGeometry newInterferenceGeometry) {
		eSet(Ifc4Package.Literals.IFC_REL_INTERFERES_ELEMENTS__INTERFERENCE_GEOMETRY, newInterferenceGeometry);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetInterferenceGeometry() {
		eUnset(Ifc4Package.Literals.IFC_REL_INTERFERES_ELEMENTS__INTERFERENCE_GEOMETRY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetInterferenceGeometry() {
		return eIsSet(Ifc4Package.Literals.IFC_REL_INTERFERES_ELEMENTS__INTERFERENCE_GEOMETRY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getInterferenceType() {
		return (String) eGet(Ifc4Package.Literals.IFC_REL_INTERFERES_ELEMENTS__INTERFERENCE_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInterferenceType(String newInterferenceType) {
		eSet(Ifc4Package.Literals.IFC_REL_INTERFERES_ELEMENTS__INTERFERENCE_TYPE, newInterferenceType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetInterferenceType() {
		eUnset(Ifc4Package.Literals.IFC_REL_INTERFERES_ELEMENTS__INTERFERENCE_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetInterferenceType() {
		return eIsSet(Ifc4Package.Literals.IFC_REL_INTERFERES_ELEMENTS__INTERFERENCE_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isImpliedOrder() {
		return (Boolean) eGet(Ifc4Package.Literals.IFC_REL_INTERFERES_ELEMENTS__IMPLIED_ORDER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setImpliedOrder(boolean newImpliedOrder) {
		eSet(Ifc4Package.Literals.IFC_REL_INTERFERES_ELEMENTS__IMPLIED_ORDER, newImpliedOrder);
	}

} //IfcRelInterferesElementsImpl
