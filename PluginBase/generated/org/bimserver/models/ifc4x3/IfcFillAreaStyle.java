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
 * A representation of the model object '<em><b>Ifc Fill Area Style</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcFillAreaStyle#getFillStyles <em>Fill Styles</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcFillAreaStyle#getModelOrDraughting <em>Model Or Draughting</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcFillAreaStyle()
 * @model
 * @generated
 */
public interface IfcFillAreaStyle extends IfcPresentationStyle {
	/**
	 * Returns the value of the '<em><b>Fill Styles</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4x3.IfcFillStyleSelect}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fill Styles</em>' reference list.
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcFillAreaStyle_FillStyles()
	 * @model
	 * @generated
	 */
	EList<IfcFillStyleSelect> getFillStyles();

	/**
	 * Returns the value of the '<em><b>Model Or Draughting</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4x3.Tristate}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Or Draughting</em>' attribute.
	 * @see org.bimserver.models.ifc4x3.Tristate
	 * @see #isSetModelOrDraughting()
	 * @see #unsetModelOrDraughting()
	 * @see #setModelOrDraughting(Tristate)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcFillAreaStyle_ModelOrDraughting()
	 * @model unsettable="true"
	 * @generated
	 */
	Tristate getModelOrDraughting();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcFillAreaStyle#getModelOrDraughting <em>Model Or Draughting</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model Or Draughting</em>' attribute.
	 * @see org.bimserver.models.ifc4x3.Tristate
	 * @see #isSetModelOrDraughting()
	 * @see #unsetModelOrDraughting()
	 * @see #getModelOrDraughting()
	 * @generated
	 */
	void setModelOrDraughting(Tristate value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcFillAreaStyle#getModelOrDraughting <em>Model Or Draughting</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetModelOrDraughting()
	 * @see #getModelOrDraughting()
	 * @see #setModelOrDraughting(Tristate)
	 * @generated
	 */
	void unsetModelOrDraughting();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcFillAreaStyle#getModelOrDraughting <em>Model Or Draughting</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Model Or Draughting</em>' attribute is set.
	 * @see #unsetModelOrDraughting()
	 * @see #getModelOrDraughting()
	 * @see #setModelOrDraughting(Tristate)
	 * @generated
	 */
	boolean isSetModelOrDraughting();

} // IfcFillAreaStyle
