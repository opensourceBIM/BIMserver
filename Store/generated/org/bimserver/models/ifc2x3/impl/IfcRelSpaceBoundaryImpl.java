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

import org.bimserver.models.ifc2x3.impl.IfcRelConnectsImpl;

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
	public static final String copyright = " (c) Copyright bimserver.org 2009\r\n Licensed under GNU GPLv3\r\n http://www.gnu.org/licenses/gpl-3.0.txt\r\n For more information mail to license@bimserver.org\r\n \r\n Bimserver.org is free software: you can redistribute it and/or modify \r\n it under the terms of the GNU General Public License as published by \r\n the Free Software Foundation, either version 3 of the License, or\r\n (at your option) any later version.\r\n \r\n Bimserver.org is distributed in the hope that it will be useful, but \r\n WITHOUT ANY WARRANTY; without even the implied warranty of \r\n MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU \r\n General Public License for more details.\r\n \r\n You should have received a copy of the GNU General Public License a \r\n long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.";

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
		return Ifc2x3Package.Literals.IFC_REL_SPACE_BOUNDARY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSpace getRelatingSpace()
	{
		return (IfcSpace)eGet(Ifc2x3Package.Literals.IFC_REL_SPACE_BOUNDARY__RELATING_SPACE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelatingSpace(IfcSpace newRelatingSpace)
	{
		eSet(Ifc2x3Package.Literals.IFC_REL_SPACE_BOUNDARY__RELATING_SPACE, newRelatingSpace);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcElement getRelatedBuildingElement()
	{
		return (IfcElement)eGet(Ifc2x3Package.Literals.IFC_REL_SPACE_BOUNDARY__RELATED_BUILDING_ELEMENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelatedBuildingElement(IfcElement newRelatedBuildingElement)
	{
		eSet(Ifc2x3Package.Literals.IFC_REL_SPACE_BOUNDARY__RELATED_BUILDING_ELEMENT, newRelatedBuildingElement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRelatedBuildingElement()
	{
		eUnset(Ifc2x3Package.Literals.IFC_REL_SPACE_BOUNDARY__RELATED_BUILDING_ELEMENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRelatedBuildingElement()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_REL_SPACE_BOUNDARY__RELATED_BUILDING_ELEMENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcConnectionGeometry getConnectionGeometry()
	{
		return (IfcConnectionGeometry)eGet(Ifc2x3Package.Literals.IFC_REL_SPACE_BOUNDARY__CONNECTION_GEOMETRY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConnectionGeometry(IfcConnectionGeometry newConnectionGeometry)
	{
		eSet(Ifc2x3Package.Literals.IFC_REL_SPACE_BOUNDARY__CONNECTION_GEOMETRY, newConnectionGeometry);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetConnectionGeometry()
	{
		eUnset(Ifc2x3Package.Literals.IFC_REL_SPACE_BOUNDARY__CONNECTION_GEOMETRY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetConnectionGeometry()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_REL_SPACE_BOUNDARY__CONNECTION_GEOMETRY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPhysicalOrVirtualEnum getPhysicalOrVirtualBoundary()
	{
		return (IfcPhysicalOrVirtualEnum)eGet(Ifc2x3Package.Literals.IFC_REL_SPACE_BOUNDARY__PHYSICAL_OR_VIRTUAL_BOUNDARY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPhysicalOrVirtualBoundary(IfcPhysicalOrVirtualEnum newPhysicalOrVirtualBoundary)
	{
		eSet(Ifc2x3Package.Literals.IFC_REL_SPACE_BOUNDARY__PHYSICAL_OR_VIRTUAL_BOUNDARY, newPhysicalOrVirtualBoundary);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcInternalOrExternalEnum getInternalOrExternalBoundary()
	{
		return (IfcInternalOrExternalEnum)eGet(Ifc2x3Package.Literals.IFC_REL_SPACE_BOUNDARY__INTERNAL_OR_EXTERNAL_BOUNDARY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInternalOrExternalBoundary(IfcInternalOrExternalEnum newInternalOrExternalBoundary)
	{
		eSet(Ifc2x3Package.Literals.IFC_REL_SPACE_BOUNDARY__INTERNAL_OR_EXTERNAL_BOUNDARY, newInternalOrExternalBoundary);
	}

} //IfcRelSpaceBoundaryImpl
