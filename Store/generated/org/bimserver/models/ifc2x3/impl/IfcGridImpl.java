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
import org.bimserver.models.ifc2x3.IfcGrid;
import org.bimserver.models.ifc2x3.IfcGridAxis;
import org.bimserver.models.ifc2x3.IfcRelContainedInSpatialStructure;

import org.bimserver.models.ifc2x3.impl.IfcProductImpl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Grid</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcGridImpl#getUAxes <em>UAxes</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcGridImpl#getVAxes <em>VAxes</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcGridImpl#getWAxes <em>WAxes</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcGridImpl#getContainedInStructure <em>Contained In Structure</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcGridImpl extends IfcProductImpl implements IfcGrid
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
	protected IfcGridImpl()
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
		return Ifc2x3Package.Literals.IFC_GRID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcGridAxis> getUAxes()
	{
		return (EList<IfcGridAxis>)eGet(Ifc2x3Package.Literals.IFC_GRID__UAXES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcGridAxis> getVAxes()
	{
		return (EList<IfcGridAxis>)eGet(Ifc2x3Package.Literals.IFC_GRID__VAXES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcGridAxis> getWAxes()
	{
		return (EList<IfcGridAxis>)eGet(Ifc2x3Package.Literals.IFC_GRID__WAXES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetWAxes()
	{
		eUnset(Ifc2x3Package.Literals.IFC_GRID__WAXES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetWAxes()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_GRID__WAXES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelContainedInSpatialStructure> getContainedInStructure()
	{
		return (EList<IfcRelContainedInSpatialStructure>)eGet(Ifc2x3Package.Literals.IFC_GRID__CONTAINED_IN_STRUCTURE, true);
	}

} //IfcGridImpl
