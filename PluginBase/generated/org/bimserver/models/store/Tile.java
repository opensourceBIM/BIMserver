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
package org.bimserver.models.store;

import org.bimserver.emf.IdEObject;
import org.bimserver.models.geometry.Bounds;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tile</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.store.Tile#getTileId <em>Tile Id</em>}</li>
 *   <li>{@link org.bimserver.models.store.Tile#getNrObjects <em>Nr Objects</em>}</li>
 *   <li>{@link org.bimserver.models.store.Tile#getMinBounds <em>Min Bounds</em>}</li>
 *   <li>{@link org.bimserver.models.store.Tile#getBounds <em>Bounds</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.store.StorePackage#getTile()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface Tile extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Tile Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tile Id</em>' attribute.
	 * @see #setTileId(int)
	 * @see org.bimserver.models.store.StorePackage#getTile_TileId()
	 * @model
	 * @generated
	 */
	int getTileId();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Tile#getTileId <em>Tile Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tile Id</em>' attribute.
	 * @see #getTileId()
	 * @generated
	 */
	void setTileId(int value);

	/**
	 * Returns the value of the '<em><b>Nr Objects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nr Objects</em>' attribute.
	 * @see #setNrObjects(int)
	 * @see org.bimserver.models.store.StorePackage#getTile_NrObjects()
	 * @model
	 * @generated
	 */
	int getNrObjects();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Tile#getNrObjects <em>Nr Objects</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nr Objects</em>' attribute.
	 * @see #getNrObjects()
	 * @generated
	 */
	void setNrObjects(int value);

	/**
	 * Returns the value of the '<em><b>Min Bounds</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Bounds</em>' reference.
	 * @see #setMinBounds(Bounds)
	 * @see org.bimserver.models.store.StorePackage#getTile_MinBounds()
	 * @model annotation="embedsreference"
	 * @generated
	 */
	Bounds getMinBounds();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Tile#getMinBounds <em>Min Bounds</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Bounds</em>' reference.
	 * @see #getMinBounds()
	 * @generated
	 */
	void setMinBounds(Bounds value);

	/**
	 * Returns the value of the '<em><b>Bounds</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bounds</em>' reference.
	 * @see #setBounds(Bounds)
	 * @see org.bimserver.models.store.StorePackage#getTile_Bounds()
	 * @model annotation="embedsreference"
	 * @generated
	 */
	Bounds getBounds();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Tile#getBounds <em>Bounds</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bounds</em>' reference.
	 * @see #getBounds()
	 * @generated
	 */
	void setBounds(Bounds value);

} // Tile
