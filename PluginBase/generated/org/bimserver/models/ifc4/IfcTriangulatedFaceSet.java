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
 * A representation of the model object '<em><b>Ifc Triangulated Face Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcTriangulatedFaceSet#getNormals <em>Normals</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcTriangulatedFaceSet#getClosed <em>Closed</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcTriangulatedFaceSet#getCoordIndex <em>Coord Index</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcTriangulatedFaceSet#getPnIndex <em>Pn Index</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcTriangulatedFaceSet#getNumberOfTriangles <em>Number Of Triangles</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTriangulatedFaceSet()
 * @model
 * @generated
 */
public interface IfcTriangulatedFaceSet extends IfcTessellatedFaceSet {
	/**
	 * Returns the value of the '<em><b>Normals</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.ListOfIfcParameterValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Normals</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Normals</em>' reference list.
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTriangulatedFaceSet_Normals()
	 * @model annotation="twodimensionalarray"
	 * @generated
	 */
	EList<ListOfIfcParameterValue> getNormals();

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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTriangulatedFaceSet_Closed()
	 * @model unsettable="true"
	 * @generated
	 */
	Tristate getClosed();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTriangulatedFaceSet#getClosed <em>Closed</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcTriangulatedFaceSet#getClosed <em>Closed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetClosed()
	 * @see #getClosed()
	 * @see #setClosed(Tristate)
	 * @generated
	 */
	void unsetClosed();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcTriangulatedFaceSet#getClosed <em>Closed</em>}' attribute is set.
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
	 * Returns the value of the '<em><b>Coord Index</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.ListOfELong}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Coord Index</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Coord Index</em>' reference list.
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTriangulatedFaceSet_CoordIndex()
	 * @model annotation="twodimensionalarray"
	 * @generated
	 */
	EList<ListOfELong> getCoordIndex();

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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTriangulatedFaceSet_PnIndex()
	 * @model unique="false" unsettable="true"
	 * @generated
	 */
	EList<Long> getPnIndex();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcTriangulatedFaceSet#getPnIndex <em>Pn Index</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPnIndex()
	 * @see #getPnIndex()
	 * @generated
	 */
	void unsetPnIndex();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcTriangulatedFaceSet#getPnIndex <em>Pn Index</em>}' attribute list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Pn Index</em>' attribute list is set.
	 * @see #unsetPnIndex()
	 * @see #getPnIndex()
	 * @generated
	 */
	boolean isSetPnIndex();

	/**
	 * Returns the value of the '<em><b>Number Of Triangles</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Of Triangles</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Of Triangles</em>' attribute.
	 * @see #isSetNumberOfTriangles()
	 * @see #unsetNumberOfTriangles()
	 * @see #setNumberOfTriangles(long)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTriangulatedFaceSet_NumberOfTriangles()
	 * @model unsettable="true" derived="true"
	 * @generated
	 */
	long getNumberOfTriangles();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTriangulatedFaceSet#getNumberOfTriangles <em>Number Of Triangles</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Of Triangles</em>' attribute.
	 * @see #isSetNumberOfTriangles()
	 * @see #unsetNumberOfTriangles()
	 * @see #getNumberOfTriangles()
	 * @generated
	 */
	void setNumberOfTriangles(long value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcTriangulatedFaceSet#getNumberOfTriangles <em>Number Of Triangles</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetNumberOfTriangles()
	 * @see #getNumberOfTriangles()
	 * @see #setNumberOfTriangles(long)
	 * @generated
	 */
	void unsetNumberOfTriangles();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcTriangulatedFaceSet#getNumberOfTriangles <em>Number Of Triangles</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Number Of Triangles</em>' attribute is set.
	 * @see #unsetNumberOfTriangles()
	 * @see #getNumberOfTriangles()
	 * @see #setNumberOfTriangles(long)
	 * @generated
	 */
	boolean isSetNumberOfTriangles();

} // IfcTriangulatedFaceSet
