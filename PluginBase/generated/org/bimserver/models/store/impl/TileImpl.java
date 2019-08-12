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
package org.bimserver.models.store.impl;

import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.models.geometry.Bounds;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.Tile;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tile</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.store.impl.TileImpl#getTileId <em>Tile Id</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.TileImpl#getNrObjects <em>Nr Objects</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.TileImpl#getMinBounds <em>Min Bounds</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.TileImpl#getBounds <em>Bounds</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TileImpl extends IdEObjectImpl implements Tile {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TileImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StorePackage.Literals.TILE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getTileId() {
		return (Integer) eGet(StorePackage.Literals.TILE__TILE_ID, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTileId(int newTileId) {
		eSet(StorePackage.Literals.TILE__TILE_ID, newTileId);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getNrObjects() {
		return (Integer) eGet(StorePackage.Literals.TILE__NR_OBJECTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNrObjects(int newNrObjects) {
		eSet(StorePackage.Literals.TILE__NR_OBJECTS, newNrObjects);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Bounds getMinBounds() {
		return (Bounds) eGet(StorePackage.Literals.TILE__MIN_BOUNDS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMinBounds(Bounds newMinBounds) {
		eSet(StorePackage.Literals.TILE__MIN_BOUNDS, newMinBounds);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Bounds getBounds() {
		return (Bounds) eGet(StorePackage.Literals.TILE__BOUNDS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBounds(Bounds newBounds) {
		eSet(StorePackage.Literals.TILE__BOUNDS, newBounds);
	}

} //TileImpl
