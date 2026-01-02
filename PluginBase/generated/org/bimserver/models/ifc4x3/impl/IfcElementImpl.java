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
import org.bimserver.models.ifc4x3.IfcElement;
import org.bimserver.models.ifc4x3.IfcRelAdheresToElement;
import org.bimserver.models.ifc4x3.IfcRelConnectsElements;
import org.bimserver.models.ifc4x3.IfcRelConnectsWithRealizingElements;
import org.bimserver.models.ifc4x3.IfcRelContainedInSpatialStructure;
import org.bimserver.models.ifc4x3.IfcRelCoversBldgElements;
import org.bimserver.models.ifc4x3.IfcRelFillsElement;
import org.bimserver.models.ifc4x3.IfcRelInterferesElements;
import org.bimserver.models.ifc4x3.IfcRelProjectsElement;
import org.bimserver.models.ifc4x3.IfcRelSpaceBoundary;
import org.bimserver.models.ifc4x3.IfcRelVoidsElement;

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
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcElementImpl#getTag <em>Tag</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcElementImpl#getFillsVoids <em>Fills Voids</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcElementImpl#getConnectedTo <em>Connected To</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcElementImpl#getIsInterferedByElements <em>Is Interfered By Elements</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcElementImpl#getInterferesElements <em>Interferes Elements</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcElementImpl#getHasProjections <em>Has Projections</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcElementImpl#getHasOpenings <em>Has Openings</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcElementImpl#getIsConnectionRealization <em>Is Connection Realization</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcElementImpl#getProvidesBoundaries <em>Provides Boundaries</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcElementImpl#getConnectedFrom <em>Connected From</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcElementImpl#getContainedInStructure <em>Contained In Structure</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcElementImpl#getHasCoverings <em>Has Coverings</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcElementImpl#getHasSurfaceFeatures <em>Has Surface Features</em>}</li>
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
		return Ifc4x3Package.eINSTANCE.getIfcElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTag() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcElement_Tag(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTag(String newTag) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcElement_Tag(), newTag);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTag() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcElement_Tag());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTag() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcElement_Tag());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelFillsElement> getFillsVoids() {
		return (EList<IfcRelFillsElement>) eGet(Ifc4x3Package.eINSTANCE.getIfcElement_FillsVoids(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetFillsVoids() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcElement_FillsVoids());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetFillsVoids() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcElement_FillsVoids());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelConnectsElements> getConnectedTo() {
		return (EList<IfcRelConnectsElements>) eGet(Ifc4x3Package.eINSTANCE.getIfcElement_ConnectedTo(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetConnectedTo() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcElement_ConnectedTo());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetConnectedTo() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcElement_ConnectedTo());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelInterferesElements> getIsInterferedByElements() {
		return (EList<IfcRelInterferesElements>) eGet(Ifc4x3Package.eINSTANCE.getIfcElement_IsInterferedByElements(),
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetIsInterferedByElements() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcElement_IsInterferedByElements());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetIsInterferedByElements() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcElement_IsInterferedByElements());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelInterferesElements> getInterferesElements() {
		return (EList<IfcRelInterferesElements>) eGet(Ifc4x3Package.eINSTANCE.getIfcElement_InterferesElements(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetInterferesElements() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcElement_InterferesElements());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetInterferesElements() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcElement_InterferesElements());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelProjectsElement> getHasProjections() {
		return (EList<IfcRelProjectsElement>) eGet(Ifc4x3Package.eINSTANCE.getIfcElement_HasProjections(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetHasProjections() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcElement_HasProjections());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetHasProjections() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcElement_HasProjections());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelVoidsElement> getHasOpenings() {
		return (EList<IfcRelVoidsElement>) eGet(Ifc4x3Package.eINSTANCE.getIfcElement_HasOpenings(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetHasOpenings() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcElement_HasOpenings());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetHasOpenings() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcElement_HasOpenings());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelConnectsWithRealizingElements> getIsConnectionRealization() {
		return (EList<IfcRelConnectsWithRealizingElements>) eGet(
				Ifc4x3Package.eINSTANCE.getIfcElement_IsConnectionRealization(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetIsConnectionRealization() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcElement_IsConnectionRealization());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetIsConnectionRealization() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcElement_IsConnectionRealization());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelSpaceBoundary> getProvidesBoundaries() {
		return (EList<IfcRelSpaceBoundary>) eGet(Ifc4x3Package.eINSTANCE.getIfcElement_ProvidesBoundaries(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetProvidesBoundaries() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcElement_ProvidesBoundaries());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetProvidesBoundaries() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcElement_ProvidesBoundaries());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelConnectsElements> getConnectedFrom() {
		return (EList<IfcRelConnectsElements>) eGet(Ifc4x3Package.eINSTANCE.getIfcElement_ConnectedFrom(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetConnectedFrom() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcElement_ConnectedFrom());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetConnectedFrom() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcElement_ConnectedFrom());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelContainedInSpatialStructure> getContainedInStructure() {
		return (EList<IfcRelContainedInSpatialStructure>) eGet(
				Ifc4x3Package.eINSTANCE.getIfcElement_ContainedInStructure(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetContainedInStructure() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcElement_ContainedInStructure());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetContainedInStructure() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcElement_ContainedInStructure());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelCoversBldgElements> getHasCoverings() {
		return (EList<IfcRelCoversBldgElements>) eGet(Ifc4x3Package.eINSTANCE.getIfcElement_HasCoverings(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetHasCoverings() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcElement_HasCoverings());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetHasCoverings() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcElement_HasCoverings());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelAdheresToElement> getHasSurfaceFeatures() {
		return (EList<IfcRelAdheresToElement>) eGet(Ifc4x3Package.eINSTANCE.getIfcElement_HasSurfaceFeatures(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetHasSurfaceFeatures() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcElement_HasSurfaceFeatures());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetHasSurfaceFeatures() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcElement_HasSurfaceFeatures());
	}

} //IfcElementImpl
