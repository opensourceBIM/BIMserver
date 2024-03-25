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
package org.bimserver.models.ifc4x3;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Grid</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcGrid#getUAxes <em>UAxes</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcGrid#getVAxes <em>VAxes</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcGrid#getWAxes <em>WAxes</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcGrid#getPredefinedType <em>Predefined Type</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcGrid()
 * @model
 * @generated
 */
public interface IfcGrid extends IfcPositioningElement {
	/**
	 * Returns the value of the '<em><b>UAxes</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4x3.IfcGridAxis}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4x3.IfcGridAxis#getPartOfU <em>Part Of U</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>UAxes</em>' reference list.
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcGrid_UAxes()
	 * @see org.bimserver.models.ifc4x3.IfcGridAxis#getPartOfU
	 * @model opposite="PartOfU"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcGridAxis> getUAxes();

	/**
	 * Returns the value of the '<em><b>VAxes</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4x3.IfcGridAxis}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4x3.IfcGridAxis#getPartOfV <em>Part Of V</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>VAxes</em>' reference list.
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcGrid_VAxes()
	 * @see org.bimserver.models.ifc4x3.IfcGridAxis#getPartOfV
	 * @model opposite="PartOfV"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcGridAxis> getVAxes();

	/**
	 * Returns the value of the '<em><b>WAxes</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4x3.IfcGridAxis}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4x3.IfcGridAxis#getPartOfW <em>Part Of W</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>WAxes</em>' reference list.
	 * @see #isSetWAxes()
	 * @see #unsetWAxes()
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcGrid_WAxes()
	 * @see org.bimserver.models.ifc4x3.IfcGridAxis#getPartOfW
	 * @model opposite="PartOfW" unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcGridAxis> getWAxes();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcGrid#getWAxes <em>WAxes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetWAxes()
	 * @see #getWAxes()
	 * @generated
	 */
	void unsetWAxes();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcGrid#getWAxes <em>WAxes</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>WAxes</em>' reference list is set.
	 * @see #unsetWAxes()
	 * @see #getWAxes()
	 * @generated
	 */
	boolean isSetWAxes();

	/**
	 * Returns the value of the '<em><b>Predefined Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4x3.IfcGridTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc4x3.IfcGridTypeEnum
	 * @see #isSetPredefinedType()
	 * @see #unsetPredefinedType()
	 * @see #setPredefinedType(IfcGridTypeEnum)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcGrid_PredefinedType()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcGridTypeEnum getPredefinedType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcGrid#getPredefinedType <em>Predefined Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc4x3.IfcGridTypeEnum
	 * @see #isSetPredefinedType()
	 * @see #unsetPredefinedType()
	 * @see #getPredefinedType()
	 * @generated
	 */
	void setPredefinedType(IfcGridTypeEnum value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcGrid#getPredefinedType <em>Predefined Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPredefinedType()
	 * @see #getPredefinedType()
	 * @see #setPredefinedType(IfcGridTypeEnum)
	 * @generated
	 */
	void unsetPredefinedType();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcGrid#getPredefinedType <em>Predefined Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Predefined Type</em>' attribute is set.
	 * @see #unsetPredefinedType()
	 * @see #getPredefinedType()
	 * @see #setPredefinedType(IfcGridTypeEnum)
	 * @generated
	 */
	boolean isSetPredefinedType();

} // IfcGrid
