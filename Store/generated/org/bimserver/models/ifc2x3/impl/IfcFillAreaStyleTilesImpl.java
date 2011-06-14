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
import org.bimserver.models.ifc2x3.IfcFillAreaStyleTileShapeSelect;
import org.bimserver.models.ifc2x3.IfcFillAreaStyleTiles;
import org.bimserver.models.ifc2x3.IfcOneDirectionRepeatFactor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Fill Area Style Tiles</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcFillAreaStyleTilesImpl#getTilingPattern <em>Tiling Pattern</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcFillAreaStyleTilesImpl#getTiles <em>Tiles</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcFillAreaStyleTilesImpl#getTilingScale <em>Tiling Scale</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcFillAreaStyleTilesImpl#getTilingScaleAsString <em>Tiling Scale As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcFillAreaStyleTilesImpl extends IfcGeometricRepresentationItemImpl implements IfcFillAreaStyleTiles
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcFillAreaStyleTilesImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcFillAreaStyleTiles();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcOneDirectionRepeatFactor getTilingPattern()
	{
		return (IfcOneDirectionRepeatFactor)eGet(Ifc2x3Package.eINSTANCE.getIfcFillAreaStyleTiles_TilingPattern(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTilingPattern(IfcOneDirectionRepeatFactor newTilingPattern)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcFillAreaStyleTiles_TilingPattern(), newTilingPattern);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcFillAreaStyleTileShapeSelect> getTiles()
	{
		return (EList<IfcFillAreaStyleTileShapeSelect>)eGet(Ifc2x3Package.eINSTANCE.getIfcFillAreaStyleTiles_Tiles(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getTilingScale()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcFillAreaStyleTiles_TilingScale(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTilingScale(float newTilingScale)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcFillAreaStyleTiles_TilingScale(), newTilingScale);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTilingScaleAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcFillAreaStyleTiles_TilingScaleAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTilingScaleAsString(String newTilingScaleAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcFillAreaStyleTiles_TilingScaleAsString(), newTilingScaleAsString);
	}

} //IfcFillAreaStyleTilesImpl
