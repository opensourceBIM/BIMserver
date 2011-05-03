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
import org.bimserver.models.ifc2x3.IfcElementCompositionEnum;
import org.bimserver.models.ifc2x3.IfcRelContainedInSpatialStructure;
import org.bimserver.models.ifc2x3.IfcRelReferencedInSpatialStructure;
import org.bimserver.models.ifc2x3.IfcRelServicesBuildings;
import org.bimserver.models.ifc2x3.IfcSpatialStructureElement;

import org.bimserver.models.ifc2x3.impl.IfcProductImpl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Spatial Structure Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSpatialStructureElementImpl#getLongName <em>Long Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSpatialStructureElementImpl#getCompositionType <em>Composition Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSpatialStructureElementImpl#getReferencesElements <em>References Elements</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSpatialStructureElementImpl#getServicedBySystems <em>Serviced By Systems</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSpatialStructureElementImpl#getContainsElements <em>Contains Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcSpatialStructureElementImpl extends IfcProductImpl implements IfcSpatialStructureElement
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
	protected IfcSpatialStructureElementImpl()
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
		return Ifc2x3Package.Literals.IFC_SPATIAL_STRUCTURE_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLongName()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_SPATIAL_STRUCTURE_ELEMENT__LONG_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLongName(String newLongName)
	{
		eSet(Ifc2x3Package.Literals.IFC_SPATIAL_STRUCTURE_ELEMENT__LONG_NAME, newLongName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLongName()
	{
		eUnset(Ifc2x3Package.Literals.IFC_SPATIAL_STRUCTURE_ELEMENT__LONG_NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLongName()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_SPATIAL_STRUCTURE_ELEMENT__LONG_NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcElementCompositionEnum getCompositionType()
	{
		return (IfcElementCompositionEnum)eGet(Ifc2x3Package.Literals.IFC_SPATIAL_STRUCTURE_ELEMENT__COMPOSITION_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompositionType(IfcElementCompositionEnum newCompositionType)
	{
		eSet(Ifc2x3Package.Literals.IFC_SPATIAL_STRUCTURE_ELEMENT__COMPOSITION_TYPE, newCompositionType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelReferencedInSpatialStructure> getReferencesElements()
	{
		return (EList<IfcRelReferencedInSpatialStructure>)eGet(Ifc2x3Package.Literals.IFC_SPATIAL_STRUCTURE_ELEMENT__REFERENCES_ELEMENTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelServicesBuildings> getServicedBySystems()
	{
		return (EList<IfcRelServicesBuildings>)eGet(Ifc2x3Package.Literals.IFC_SPATIAL_STRUCTURE_ELEMENT__SERVICED_BY_SYSTEMS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelContainedInSpatialStructure> getContainsElements()
	{
		return (EList<IfcRelContainedInSpatialStructure>)eGet(Ifc2x3Package.Literals.IFC_SPATIAL_STRUCTURE_ELEMENT__CONTAINS_ELEMENTS, true);
	}

} //IfcSpatialStructureElementImpl
