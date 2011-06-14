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
package org.bimserver.models.ifc2x3;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Grid</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcGrid#getUAxes <em>UAxes</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcGrid#getVAxes <em>VAxes</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcGrid#getWAxes <em>WAxes</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcGrid#getContainedInStructure <em>Contained In Structure</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcGrid()
 * @model
 * @generated
 */
public interface IfcGrid extends IfcProduct
{
	/**
	 * Returns the value of the '<em><b>UAxes</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcGridAxis}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcGridAxis#getPartOfU <em>Part Of U</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>UAxes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>UAxes</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcGrid_UAxes()
	 * @see org.bimserver.models.ifc2x3.IfcGridAxis#getPartOfU
	 * @model opposite="PartOfU"
	 * @generated
	 */
	EList<IfcGridAxis> getUAxes();

	/**
	 * Returns the value of the '<em><b>VAxes</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcGridAxis}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcGridAxis#getPartOfV <em>Part Of V</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>VAxes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>VAxes</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcGrid_VAxes()
	 * @see org.bimserver.models.ifc2x3.IfcGridAxis#getPartOfV
	 * @model opposite="PartOfV"
	 * @generated
	 */
	EList<IfcGridAxis> getVAxes();

	/**
	 * Returns the value of the '<em><b>WAxes</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcGridAxis}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcGridAxis#getPartOfW <em>Part Of W</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>WAxes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>WAxes</em>' reference list.
	 * @see #isSetWAxes()
	 * @see #unsetWAxes()
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcGrid_WAxes()
	 * @see org.bimserver.models.ifc2x3.IfcGridAxis#getPartOfW
	 * @model opposite="PartOfW" unsettable="true"
	 * @generated
	 */
	EList<IfcGridAxis> getWAxes();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcGrid#getWAxes <em>WAxes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetWAxes()
	 * @see #getWAxes()
	 * @generated
	 */
	void unsetWAxes();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcGrid#getWAxes <em>WAxes</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>WAxes</em>' reference list is set.
	 * @see #unsetWAxes()
	 * @see #getWAxes()
	 * @generated
	 */
	boolean isSetWAxes();

	/**
	 * Returns the value of the '<em><b>Contained In Structure</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcRelContainedInSpatialStructure}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contained In Structure</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contained In Structure</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcGrid_ContainedInStructure()
	 * @model upper="2"
	 * @generated
	 */
	EList<IfcRelContainedInSpatialStructure> getContainedInStructure();

} // IfcGrid
