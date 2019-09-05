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
package org.bimserver.models.ifc4;

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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Polygonal Face Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcPolygonalFaceSet#getClosed <em>Closed</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcPolygonalFaceSet#getFaces <em>Faces</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcPolygonalFaceSet#getPnIndex <em>Pn Index</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcPolygonalFaceSet()
 * @model
 * @generated
 */
public interface IfcPolygonalFaceSet extends IfcTessellatedFaceSet {
	/**
	 * Returns the value of the '<em><b>Closed</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.Tristate}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Closed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Closed</em>' attribute.
	 * @see org.bimserver.models.ifc4.Tristate
	 * @see #isSetClosed()
	 * @see #unsetClosed()
	 * @see #setClosed(Tristate)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcPolygonalFaceSet_Closed()
	 * @model unsettable="true"
	 * @generated
	 */
	Tristate getClosed();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcPolygonalFaceSet#getClosed <em>Closed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Closed</em>' attribute.
	 * @see org.bimserver.models.ifc4.Tristate
	 * @see #isSetClosed()
	 * @see #unsetClosed()
	 * @see #getClosed()
	 * @generated
	 */
	void setClosed(Tristate value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcPolygonalFaceSet#getClosed <em>Closed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetClosed()
	 * @see #getClosed()
	 * @see #setClosed(Tristate)
	 * @generated
	 */
	void unsetClosed();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcPolygonalFaceSet#getClosed <em>Closed</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Closed</em>' attribute is set.
	 * @see #unsetClosed()
	 * @see #getClosed()
	 * @see #setClosed(Tristate)
	 * @generated
	 */
	boolean isSetClosed();

	/**
	 * Returns the value of the '<em><b>Faces</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcIndexedPolygonalFace}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcIndexedPolygonalFace#getToFaceSet <em>To Face Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Faces</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Faces</em>' reference list.
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcPolygonalFaceSet_Faces()
	 * @see org.bimserver.models.ifc4.IfcIndexedPolygonalFace#getToFaceSet
	 * @model opposite="ToFaceSet"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcIndexedPolygonalFace> getFaces();

	/**
	 * Returns the value of the '<em><b>Pn Index</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Long}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pn Index</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pn Index</em>' attribute list.
	 * @see #isSetPnIndex()
	 * @see #unsetPnIndex()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcPolygonalFaceSet_PnIndex()
	 * @model unique="false" unsettable="true"
	 * @generated
	 */
	EList<Long> getPnIndex();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcPolygonalFaceSet#getPnIndex <em>Pn Index</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPnIndex()
	 * @see #getPnIndex()
	 * @generated
	 */
	void unsetPnIndex();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcPolygonalFaceSet#getPnIndex <em>Pn Index</em>}' attribute list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Pn Index</em>' attribute list is set.
	 * @see #unsetPnIndex()
	 * @see #getPnIndex()
	 * @generated
	 */
	boolean isSetPnIndex();

} // IfcPolygonalFaceSet
