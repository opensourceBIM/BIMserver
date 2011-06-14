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
import org.bimserver.models.ifc2x3.IfcConnectionGeometry;
import org.bimserver.models.ifc2x3.IfcElement;
import org.bimserver.models.ifc2x3.IfcInternalOrExternalEnum;
import org.bimserver.models.ifc2x3.IfcPhysicalOrVirtualEnum;
import org.bimserver.models.ifc2x3.IfcRelSpaceBoundary;
import org.bimserver.models.ifc2x3.IfcSpace;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Rel Space Boundary</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelSpaceBoundaryImpl#getRelatingSpace <em>Relating Space</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelSpaceBoundaryImpl#getRelatedBuildingElement <em>Related Building Element</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelSpaceBoundaryImpl#getConnectionGeometry <em>Connection Geometry</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelSpaceBoundaryImpl#getPhysicalOrVirtualBoundary <em>Physical Or Virtual Boundary</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelSpaceBoundaryImpl#getInternalOrExternalBoundary <em>Internal Or External Boundary</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcRelSpaceBoundaryImpl extends IfcRelConnectsImpl implements IfcRelSpaceBoundary
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRelSpaceBoundaryImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcRelSpaceBoundary();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSpace getRelatingSpace()
	{
		return (IfcSpace)eGet(Ifc2x3Package.eINSTANCE.getIfcRelSpaceBoundary_RelatingSpace(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelatingSpace(IfcSpace newRelatingSpace)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcRelSpaceBoundary_RelatingSpace(), newRelatingSpace);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcElement getRelatedBuildingElement()
	{
		return (IfcElement)eGet(Ifc2x3Package.eINSTANCE.getIfcRelSpaceBoundary_RelatedBuildingElement(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelatedBuildingElement(IfcElement newRelatedBuildingElement)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcRelSpaceBoundary_RelatedBuildingElement(), newRelatedBuildingElement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRelatedBuildingElement()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcRelSpaceBoundary_RelatedBuildingElement());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRelatedBuildingElement()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcRelSpaceBoundary_RelatedBuildingElement());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcConnectionGeometry getConnectionGeometry()
	{
		return (IfcConnectionGeometry)eGet(Ifc2x3Package.eINSTANCE.getIfcRelSpaceBoundary_ConnectionGeometry(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConnectionGeometry(IfcConnectionGeometry newConnectionGeometry)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcRelSpaceBoundary_ConnectionGeometry(), newConnectionGeometry);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetConnectionGeometry()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcRelSpaceBoundary_ConnectionGeometry());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetConnectionGeometry()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcRelSpaceBoundary_ConnectionGeometry());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPhysicalOrVirtualEnum getPhysicalOrVirtualBoundary()
	{
		return (IfcPhysicalOrVirtualEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcRelSpaceBoundary_PhysicalOrVirtualBoundary(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPhysicalOrVirtualBoundary(IfcPhysicalOrVirtualEnum newPhysicalOrVirtualBoundary)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcRelSpaceBoundary_PhysicalOrVirtualBoundary(), newPhysicalOrVirtualBoundary);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcInternalOrExternalEnum getInternalOrExternalBoundary()
	{
		return (IfcInternalOrExternalEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcRelSpaceBoundary_InternalOrExternalBoundary(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInternalOrExternalBoundary(IfcInternalOrExternalEnum newInternalOrExternalBoundary)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcRelSpaceBoundary_InternalOrExternalBoundary(), newInternalOrExternalBoundary);
	}

} //IfcRelSpaceBoundaryImpl
