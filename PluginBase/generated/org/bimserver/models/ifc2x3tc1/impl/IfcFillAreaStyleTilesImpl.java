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
import org.bimserver.models.ifc2x3tc1.IfcFillAreaStyleTileShapeSelect;
import org.bimserver.models.ifc2x3tc1.IfcFillAreaStyleTiles;
import org.bimserver.models.ifc2x3tc1.IfcOneDirectionRepeatFactor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Fill Area Style Tiles</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcFillAreaStyleTilesImpl#getTilingPattern <em>Tiling Pattern</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcFillAreaStyleTilesImpl#getTiles <em>Tiles</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcFillAreaStyleTilesImpl#getTilingScale <em>Tiling Scale</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcFillAreaStyleTilesImpl#getTilingScaleAsString <em>Tiling Scale As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcFillAreaStyleTilesImpl extends IfcGeometricRepresentationItemImpl implements IfcFillAreaStyleTiles {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcFillAreaStyleTilesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_FILL_AREA_STYLE_TILES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcOneDirectionRepeatFactor getTilingPattern() {
		return (IfcOneDirectionRepeatFactor) eGet(Ifc2x3tc1Package.Literals.IFC_FILL_AREA_STYLE_TILES__TILING_PATTERN,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTilingPattern(IfcOneDirectionRepeatFactor newTilingPattern) {
		eSet(Ifc2x3tc1Package.Literals.IFC_FILL_AREA_STYLE_TILES__TILING_PATTERN, newTilingPattern);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcFillAreaStyleTileShapeSelect> getTiles() {
		return (EList<IfcFillAreaStyleTileShapeSelect>) eGet(Ifc2x3tc1Package.Literals.IFC_FILL_AREA_STYLE_TILES__TILES,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getTilingScale() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_FILL_AREA_STYLE_TILES__TILING_SCALE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTilingScale(double newTilingScale) {
		eSet(Ifc2x3tc1Package.Literals.IFC_FILL_AREA_STYLE_TILES__TILING_SCALE, newTilingScale);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTilingScaleAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_FILL_AREA_STYLE_TILES__TILING_SCALE_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTilingScaleAsString(String newTilingScaleAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_FILL_AREA_STYLE_TILES__TILING_SCALE_AS_STRING, newTilingScaleAsString);
	}

} //IfcFillAreaStyleTilesImpl
