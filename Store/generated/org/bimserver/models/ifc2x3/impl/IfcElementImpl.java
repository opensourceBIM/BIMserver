/**
 *  (c) Copyright bimserver.org 2009
 *  Licensed under GNU GPLv3
 *  http://www.gnu.org/licenses/gpl-3.0.txt
 *  For more information mail to license@bimserver.org
 *  
 *  Bimserver.org is free software: you can redistribute it and/or modify 
 *  it under the terms of the GNU General Public License as published by 
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  Bimserver.org is distributed in the hope that it will be useful, but 
 *  WITHOUT ANY WARRANTY; without even the implied warranty of 
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 *  General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License a 
 *  long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcElement;
import org.bimserver.models.ifc2x3.IfcRelConnectsElements;
import org.bimserver.models.ifc2x3.IfcRelConnectsPortToElement;
import org.bimserver.models.ifc2x3.IfcRelConnectsStructuralElement;
import org.bimserver.models.ifc2x3.IfcRelConnectsWithRealizingElements;
import org.bimserver.models.ifc2x3.IfcRelContainedInSpatialStructure;
import org.bimserver.models.ifc2x3.IfcRelCoversBldgElements;
import org.bimserver.models.ifc2x3.IfcRelFillsElement;
import org.bimserver.models.ifc2x3.IfcRelProjectsElement;
import org.bimserver.models.ifc2x3.IfcRelReferencedInSpatialStructure;
import org.bimserver.models.ifc2x3.IfcRelSpaceBoundary;
import org.bimserver.models.ifc2x3.IfcRelVoidsElement;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcElementImpl#getTag <em>Tag</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcElementImpl#getFillsVoids <em>Fills Voids</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcElementImpl#getConnectedTo <em>Connected To</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcElementImpl#getHasCoverings <em>Has Coverings</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcElementImpl#getHasProjections <em>Has Projections</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcElementImpl#getHasStructuralMember <em>Has Structural Member</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcElementImpl#getReferencedInStructures <em>Referenced In Structures</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcElementImpl#getHasPorts <em>Has Ports</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcElementImpl#getHasOpenings <em>Has Openings</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcElementImpl#getIsConnectionRealization <em>Is Connection Realization</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcElementImpl#getProvidesBoundaries <em>Provides Boundaries</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcElementImpl#getConnectedFrom <em>Connected From</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcElementImpl#getContainedInStructure <em>Contained In Structure</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcElementImpl extends IfcProductImpl implements IfcElement
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcElementImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return Ifc2x3Package.eINSTANCE.getIfcElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTag()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcElement_Tag(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTag(String newTag)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcElement_Tag(), newTag);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTag()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcElement_Tag());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTag()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcElement_Tag());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelFillsElement> getFillsVoids()
	{
		return (EList<IfcRelFillsElement>)eGet(Ifc2x3Package.eINSTANCE.getIfcElement_FillsVoids(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelConnectsElements> getConnectedTo()
	{
		return (EList<IfcRelConnectsElements>)eGet(Ifc2x3Package.eINSTANCE.getIfcElement_ConnectedTo(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelCoversBldgElements> getHasCoverings()
	{
		return (EList<IfcRelCoversBldgElements>)eGet(Ifc2x3Package.eINSTANCE.getIfcElement_HasCoverings(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelProjectsElement> getHasProjections()
	{
		return (EList<IfcRelProjectsElement>)eGet(Ifc2x3Package.eINSTANCE.getIfcElement_HasProjections(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelConnectsStructuralElement> getHasStructuralMember()
	{
		return (EList<IfcRelConnectsStructuralElement>)eGet(Ifc2x3Package.eINSTANCE.getIfcElement_HasStructuralMember(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelReferencedInSpatialStructure> getReferencedInStructures()
	{
		return (EList<IfcRelReferencedInSpatialStructure>)eGet(Ifc2x3Package.eINSTANCE.getIfcElement_ReferencedInStructures(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelConnectsPortToElement> getHasPorts()
	{
		return (EList<IfcRelConnectsPortToElement>)eGet(Ifc2x3Package.eINSTANCE.getIfcElement_HasPorts(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelVoidsElement> getHasOpenings()
	{
		return (EList<IfcRelVoidsElement>)eGet(Ifc2x3Package.eINSTANCE.getIfcElement_HasOpenings(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelConnectsWithRealizingElements> getIsConnectionRealization()
	{
		return (EList<IfcRelConnectsWithRealizingElements>)eGet(Ifc2x3Package.eINSTANCE.getIfcElement_IsConnectionRealization(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelSpaceBoundary> getProvidesBoundaries()
	{
		return (EList<IfcRelSpaceBoundary>)eGet(Ifc2x3Package.eINSTANCE.getIfcElement_ProvidesBoundaries(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelConnectsElements> getConnectedFrom()
	{
		return (EList<IfcRelConnectsElements>)eGet(Ifc2x3Package.eINSTANCE.getIfcElement_ConnectedFrom(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelContainedInSpatialStructure> getContainedInStructure()
	{
		return (EList<IfcRelContainedInSpatialStructure>)eGet(Ifc2x3Package.eINSTANCE.getIfcElement_ContainedInStructure(), true);
	}

} //IfcElementImpl
