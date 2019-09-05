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
import org.bimserver.models.ifc4.IfcRelConnectsElements;
import org.bimserver.models.ifc4.IfcRelConnectsWithRealizingElements;
import org.bimserver.models.ifc4.IfcRelContainedInSpatialStructure;
import org.bimserver.models.ifc4.IfcRelCoversBldgElements;
import org.bimserver.models.ifc4.IfcRelFillsElement;
import org.bimserver.models.ifc4.IfcRelInterferesElements;
import org.bimserver.models.ifc4.IfcRelProjectsElement;
import org.bimserver.models.ifc4.IfcRelReferencedInSpatialStructure;
import org.bimserver.models.ifc4.IfcRelSpaceBoundary;
import org.bimserver.models.ifc4.IfcRelVoidsElement;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcElementImpl#getTag <em>Tag</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcElementImpl#getFillsVoids <em>Fills Voids</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcElementImpl#getConnectedTo <em>Connected To</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcElementImpl#getIsInterferedByElements <em>Is Interfered By Elements</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcElementImpl#getInterferesElements <em>Interferes Elements</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcElementImpl#getHasProjections <em>Has Projections</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcElementImpl#getReferencedInStructures <em>Referenced In Structures</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcElementImpl#getHasOpenings <em>Has Openings</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcElementImpl#getIsConnectionRealization <em>Is Connection Realization</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcElementImpl#getProvidesBoundaries <em>Provides Boundaries</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcElementImpl#getConnectedFrom <em>Connected From</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcElementImpl#getContainedInStructure <em>Contained In Structure</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcElementImpl#getHasCoverings <em>Has Coverings</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcElementImpl extends IfcProductImpl implements IfcElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTag() {
		return (String) eGet(Ifc4Package.Literals.IFC_ELEMENT__TAG, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTag(String newTag) {
		eSet(Ifc4Package.Literals.IFC_ELEMENT__TAG, newTag);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTag() {
		eUnset(Ifc4Package.Literals.IFC_ELEMENT__TAG);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTag() {
		return eIsSet(Ifc4Package.Literals.IFC_ELEMENT__TAG);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelFillsElement> getFillsVoids() {
		return (EList<IfcRelFillsElement>) eGet(Ifc4Package.Literals.IFC_ELEMENT__FILLS_VOIDS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetFillsVoids() {
		eUnset(Ifc4Package.Literals.IFC_ELEMENT__FILLS_VOIDS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetFillsVoids() {
		return eIsSet(Ifc4Package.Literals.IFC_ELEMENT__FILLS_VOIDS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelConnectsElements> getConnectedTo() {
		return (EList<IfcRelConnectsElements>) eGet(Ifc4Package.Literals.IFC_ELEMENT__CONNECTED_TO, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetConnectedTo() {
		eUnset(Ifc4Package.Literals.IFC_ELEMENT__CONNECTED_TO);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetConnectedTo() {
		return eIsSet(Ifc4Package.Literals.IFC_ELEMENT__CONNECTED_TO);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelInterferesElements> getIsInterferedByElements() {
		return (EList<IfcRelInterferesElements>) eGet(Ifc4Package.Literals.IFC_ELEMENT__IS_INTERFERED_BY_ELEMENTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetIsInterferedByElements() {
		eUnset(Ifc4Package.Literals.IFC_ELEMENT__IS_INTERFERED_BY_ELEMENTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetIsInterferedByElements() {
		return eIsSet(Ifc4Package.Literals.IFC_ELEMENT__IS_INTERFERED_BY_ELEMENTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelInterferesElements> getInterferesElements() {
		return (EList<IfcRelInterferesElements>) eGet(Ifc4Package.Literals.IFC_ELEMENT__INTERFERES_ELEMENTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetInterferesElements() {
		eUnset(Ifc4Package.Literals.IFC_ELEMENT__INTERFERES_ELEMENTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetInterferesElements() {
		return eIsSet(Ifc4Package.Literals.IFC_ELEMENT__INTERFERES_ELEMENTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelProjectsElement> getHasProjections() {
		return (EList<IfcRelProjectsElement>) eGet(Ifc4Package.Literals.IFC_ELEMENT__HAS_PROJECTIONS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetHasProjections() {
		eUnset(Ifc4Package.Literals.IFC_ELEMENT__HAS_PROJECTIONS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetHasProjections() {
		return eIsSet(Ifc4Package.Literals.IFC_ELEMENT__HAS_PROJECTIONS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelReferencedInSpatialStructure> getReferencedInStructures() {
		return (EList<IfcRelReferencedInSpatialStructure>) eGet(Ifc4Package.Literals.IFC_ELEMENT__REFERENCED_IN_STRUCTURES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetReferencedInStructures() {
		eUnset(Ifc4Package.Literals.IFC_ELEMENT__REFERENCED_IN_STRUCTURES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetReferencedInStructures() {
		return eIsSet(Ifc4Package.Literals.IFC_ELEMENT__REFERENCED_IN_STRUCTURES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelVoidsElement> getHasOpenings() {
		return (EList<IfcRelVoidsElement>) eGet(Ifc4Package.Literals.IFC_ELEMENT__HAS_OPENINGS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetHasOpenings() {
		eUnset(Ifc4Package.Literals.IFC_ELEMENT__HAS_OPENINGS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetHasOpenings() {
		return eIsSet(Ifc4Package.Literals.IFC_ELEMENT__HAS_OPENINGS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelConnectsWithRealizingElements> getIsConnectionRealization() {
		return (EList<IfcRelConnectsWithRealizingElements>) eGet(Ifc4Package.Literals.IFC_ELEMENT__IS_CONNECTION_REALIZATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetIsConnectionRealization() {
		eUnset(Ifc4Package.Literals.IFC_ELEMENT__IS_CONNECTION_REALIZATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetIsConnectionRealization() {
		return eIsSet(Ifc4Package.Literals.IFC_ELEMENT__IS_CONNECTION_REALIZATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelSpaceBoundary> getProvidesBoundaries() {
		return (EList<IfcRelSpaceBoundary>) eGet(Ifc4Package.Literals.IFC_ELEMENT__PROVIDES_BOUNDARIES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetProvidesBoundaries() {
		eUnset(Ifc4Package.Literals.IFC_ELEMENT__PROVIDES_BOUNDARIES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetProvidesBoundaries() {
		return eIsSet(Ifc4Package.Literals.IFC_ELEMENT__PROVIDES_BOUNDARIES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelConnectsElements> getConnectedFrom() {
		return (EList<IfcRelConnectsElements>) eGet(Ifc4Package.Literals.IFC_ELEMENT__CONNECTED_FROM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetConnectedFrom() {
		eUnset(Ifc4Package.Literals.IFC_ELEMENT__CONNECTED_FROM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetConnectedFrom() {
		return eIsSet(Ifc4Package.Literals.IFC_ELEMENT__CONNECTED_FROM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelContainedInSpatialStructure> getContainedInStructure() {
		return (EList<IfcRelContainedInSpatialStructure>) eGet(Ifc4Package.Literals.IFC_ELEMENT__CONTAINED_IN_STRUCTURE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetContainedInStructure() {
		eUnset(Ifc4Package.Literals.IFC_ELEMENT__CONTAINED_IN_STRUCTURE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetContainedInStructure() {
		return eIsSet(Ifc4Package.Literals.IFC_ELEMENT__CONTAINED_IN_STRUCTURE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelCoversBldgElements> getHasCoverings() {
		return (EList<IfcRelCoversBldgElements>) eGet(Ifc4Package.Literals.IFC_ELEMENT__HAS_COVERINGS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetHasCoverings() {
		eUnset(Ifc4Package.Literals.IFC_ELEMENT__HAS_COVERINGS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetHasCoverings() {
		return eIsSet(Ifc4Package.Literals.IFC_ELEMENT__HAS_COVERINGS);
	}

} //IfcElementImpl
