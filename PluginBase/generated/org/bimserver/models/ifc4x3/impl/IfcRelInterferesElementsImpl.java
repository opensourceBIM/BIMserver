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
import org.bimserver.models.ifc4x3.IfcConnectionGeometry;
import org.bimserver.models.ifc4x3.IfcInterferenceSelect;
import org.bimserver.models.ifc4x3.IfcRelInterferesElements;
import org.bimserver.models.ifc4x3.IfcSpatialZone;
import org.bimserver.models.ifc4x3.Tristate;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Rel Interferes Elements</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcRelInterferesElementsImpl#getRelatingElement <em>Relating Element</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcRelInterferesElementsImpl#getRelatedElement <em>Related Element</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcRelInterferesElementsImpl#getInterferenceGeometry <em>Interference Geometry</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcRelInterferesElementsImpl#getInterferenceType <em>Interference Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcRelInterferesElementsImpl#getImpliedOrder <em>Implied Order</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcRelInterferesElementsImpl#getInterferenceSpace <em>Interference Space</em>}</li>
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
		return Ifc4x3Package.eINSTANCE.getIfcRelInterferesElements();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcInterferenceSelect getRelatingElement() {
		return (IfcInterferenceSelect) eGet(Ifc4x3Package.eINSTANCE.getIfcRelInterferesElements_RelatingElement(),
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRelatingElement(IfcInterferenceSelect newRelatingElement) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcRelInterferesElements_RelatingElement(), newRelatingElement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcInterferenceSelect getRelatedElement() {
		return (IfcInterferenceSelect) eGet(Ifc4x3Package.eINSTANCE.getIfcRelInterferesElements_RelatedElement(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRelatedElement(IfcInterferenceSelect newRelatedElement) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcRelInterferesElements_RelatedElement(), newRelatedElement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcConnectionGeometry getInterferenceGeometry() {
		return (IfcConnectionGeometry) eGet(Ifc4x3Package.eINSTANCE.getIfcRelInterferesElements_InterferenceGeometry(),
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInterferenceGeometry(IfcConnectionGeometry newInterferenceGeometry) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcRelInterferesElements_InterferenceGeometry(), newInterferenceGeometry);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetInterferenceGeometry() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcRelInterferesElements_InterferenceGeometry());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetInterferenceGeometry() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcRelInterferesElements_InterferenceGeometry());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getInterferenceType() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcRelInterferesElements_InterferenceType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInterferenceType(String newInterferenceType) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcRelInterferesElements_InterferenceType(), newInterferenceType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetInterferenceType() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcRelInterferesElements_InterferenceType());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetInterferenceType() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcRelInterferesElements_InterferenceType());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Tristate getImpliedOrder() {
		return (Tristate) eGet(Ifc4x3Package.eINSTANCE.getIfcRelInterferesElements_ImpliedOrder(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setImpliedOrder(Tristate newImpliedOrder) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcRelInterferesElements_ImpliedOrder(), newImpliedOrder);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSpatialZone getInterferenceSpace() {
		return (IfcSpatialZone) eGet(Ifc4x3Package.eINSTANCE.getIfcRelInterferesElements_InterferenceSpace(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInterferenceSpace(IfcSpatialZone newInterferenceSpace) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcRelInterferesElements_InterferenceSpace(), newInterferenceSpace);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetInterferenceSpace() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcRelInterferesElements_InterferenceSpace());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetInterferenceSpace() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcRelInterferesElements_InterferenceSpace());
	}

} //IfcRelInterferesElementsImpl
