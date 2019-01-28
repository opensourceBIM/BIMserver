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
import org.bimserver.models.ifc2x3tc1.IfcRelConnectsElements;
import org.bimserver.models.ifc2x3tc1.IfcRelConnectsPortToElement;
import org.bimserver.models.ifc2x3tc1.IfcRelConnectsStructuralElement;
import org.bimserver.models.ifc2x3tc1.IfcRelConnectsWithRealizingElements;
import org.bimserver.models.ifc2x3tc1.IfcRelContainedInSpatialStructure;
import org.bimserver.models.ifc2x3tc1.IfcRelCoversBldgElements;
import org.bimserver.models.ifc2x3tc1.IfcRelFillsElement;
import org.bimserver.models.ifc2x3tc1.IfcRelProjectsElement;
import org.bimserver.models.ifc2x3tc1.IfcRelReferencedInSpatialStructure;
import org.bimserver.models.ifc2x3tc1.IfcRelSpaceBoundary;
import org.bimserver.models.ifc2x3tc1.IfcRelVoidsElement;
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
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcElementImpl#getTag <em>Tag</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcElementImpl#getHasStructuralMember <em>Has Structural Member</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcElementImpl#getFillsVoids <em>Fills Voids</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcElementImpl#getConnectedTo <em>Connected To</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcElementImpl#getHasCoverings <em>Has Coverings</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcElementImpl#getHasProjections <em>Has Projections</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcElementImpl#getReferencedInStructures <em>Referenced In Structures</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcElementImpl#getHasPorts <em>Has Ports</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcElementImpl#getHasOpenings <em>Has Openings</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcElementImpl#getIsConnectionRealization <em>Is Connection Realization</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcElementImpl#getProvidesBoundaries <em>Provides Boundaries</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcElementImpl#getConnectedFrom <em>Connected From</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcElementImpl#getContainedInStructure <em>Contained In Structure</em>}</li>
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
		return Ifc2x3tc1Package.Literals.IFC_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTag() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_ELEMENT__TAG, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTag(String newTag) {
		eSet(Ifc2x3tc1Package.Literals.IFC_ELEMENT__TAG, newTag);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTag() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_ELEMENT__TAG);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTag() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_ELEMENT__TAG);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelConnectsStructuralElement> getHasStructuralMember() {
		return (EList<IfcRelConnectsStructuralElement>) eGet(
				Ifc2x3tc1Package.Literals.IFC_ELEMENT__HAS_STRUCTURAL_MEMBER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetHasStructuralMember() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_ELEMENT__HAS_STRUCTURAL_MEMBER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetHasStructuralMember() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_ELEMENT__HAS_STRUCTURAL_MEMBER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelFillsElement> getFillsVoids() {
		return (EList<IfcRelFillsElement>) eGet(Ifc2x3tc1Package.Literals.IFC_ELEMENT__FILLS_VOIDS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFillsVoids() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_ELEMENT__FILLS_VOIDS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFillsVoids() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_ELEMENT__FILLS_VOIDS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelConnectsElements> getConnectedTo() {
		return (EList<IfcRelConnectsElements>) eGet(Ifc2x3tc1Package.Literals.IFC_ELEMENT__CONNECTED_TO, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetConnectedTo() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_ELEMENT__CONNECTED_TO);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetConnectedTo() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_ELEMENT__CONNECTED_TO);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelCoversBldgElements> getHasCoverings() {
		return (EList<IfcRelCoversBldgElements>) eGet(Ifc2x3tc1Package.Literals.IFC_ELEMENT__HAS_COVERINGS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetHasCoverings() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_ELEMENT__HAS_COVERINGS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetHasCoverings() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_ELEMENT__HAS_COVERINGS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelProjectsElement> getHasProjections() {
		return (EList<IfcRelProjectsElement>) eGet(Ifc2x3tc1Package.Literals.IFC_ELEMENT__HAS_PROJECTIONS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetHasProjections() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_ELEMENT__HAS_PROJECTIONS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetHasProjections() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_ELEMENT__HAS_PROJECTIONS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelReferencedInSpatialStructure> getReferencedInStructures() {
		return (EList<IfcRelReferencedInSpatialStructure>) eGet(
				Ifc2x3tc1Package.Literals.IFC_ELEMENT__REFERENCED_IN_STRUCTURES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetReferencedInStructures() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_ELEMENT__REFERENCED_IN_STRUCTURES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetReferencedInStructures() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_ELEMENT__REFERENCED_IN_STRUCTURES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelConnectsPortToElement> getHasPorts() {
		return (EList<IfcRelConnectsPortToElement>) eGet(Ifc2x3tc1Package.Literals.IFC_ELEMENT__HAS_PORTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetHasPorts() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_ELEMENT__HAS_PORTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetHasPorts() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_ELEMENT__HAS_PORTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelVoidsElement> getHasOpenings() {
		return (EList<IfcRelVoidsElement>) eGet(Ifc2x3tc1Package.Literals.IFC_ELEMENT__HAS_OPENINGS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetHasOpenings() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_ELEMENT__HAS_OPENINGS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetHasOpenings() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_ELEMENT__HAS_OPENINGS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelConnectsWithRealizingElements> getIsConnectionRealization() {
		return (EList<IfcRelConnectsWithRealizingElements>) eGet(
				Ifc2x3tc1Package.Literals.IFC_ELEMENT__IS_CONNECTION_REALIZATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIsConnectionRealization() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_ELEMENT__IS_CONNECTION_REALIZATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIsConnectionRealization() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_ELEMENT__IS_CONNECTION_REALIZATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelSpaceBoundary> getProvidesBoundaries() {
		return (EList<IfcRelSpaceBoundary>) eGet(Ifc2x3tc1Package.Literals.IFC_ELEMENT__PROVIDES_BOUNDARIES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetProvidesBoundaries() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_ELEMENT__PROVIDES_BOUNDARIES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetProvidesBoundaries() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_ELEMENT__PROVIDES_BOUNDARIES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelConnectsElements> getConnectedFrom() {
		return (EList<IfcRelConnectsElements>) eGet(Ifc2x3tc1Package.Literals.IFC_ELEMENT__CONNECTED_FROM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetConnectedFrom() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_ELEMENT__CONNECTED_FROM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetConnectedFrom() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_ELEMENT__CONNECTED_FROM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelContainedInSpatialStructure> getContainedInStructure() {
		return (EList<IfcRelContainedInSpatialStructure>) eGet(
				Ifc2x3tc1Package.Literals.IFC_ELEMENT__CONTAINED_IN_STRUCTURE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetContainedInStructure() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_ELEMENT__CONTAINED_IN_STRUCTURE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetContainedInStructure() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_ELEMENT__CONTAINED_IN_STRUCTURE);
	}

} //IfcElementImpl
