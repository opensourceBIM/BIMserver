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

import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcDimensionalExponents;
import org.bimserver.models.ifc2x3.IfcNamedUnit;
import org.bimserver.models.ifc2x3.IfcUnitEnum;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Named Unit</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcNamedUnitImpl#getDimensions <em>Dimensions</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcNamedUnitImpl#getUnitType <em>Unit Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcNamedUnitImpl extends IdEObjectImpl implements IfcNamedUnit
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcNamedUnitImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcNamedUnit();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount()
	{
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDimensionalExponents getDimensions()
	{
		return (IfcDimensionalExponents)eGet(Ifc2x3Package.eINSTANCE.getIfcNamedUnit_Dimensions(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDimensions(IfcDimensionalExponents newDimensions)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcNamedUnit_Dimensions(), newDimensions);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcUnitEnum getUnitType()
	{
		return (IfcUnitEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcNamedUnit_UnitType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitType(IfcUnitEnum newUnitType)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcNamedUnit_UnitType(), newUnitType);
	}

} //IfcNamedUnitImpl
