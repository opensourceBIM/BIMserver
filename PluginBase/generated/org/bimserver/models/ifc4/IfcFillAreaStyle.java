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
 * A representation of the model object '<em><b>Ifc Fill Area Style</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcFillAreaStyle#getFillStyles <em>Fill Styles</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcFillAreaStyle#getModelorDraughting <em>Modelor Draughting</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcFillAreaStyle()
 * @model
 * @generated
 */
public interface IfcFillAreaStyle extends IfcPresentationStyle, IfcPresentationStyleSelect {
	/**
	 * Returns the value of the '<em><b>Fill Styles</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcFillStyleSelect}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fill Styles</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fill Styles</em>' reference list.
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcFillAreaStyle_FillStyles()
	 * @model
	 * @generated
	 */
	EList<IfcFillStyleSelect> getFillStyles();

	/**
	 * Returns the value of the '<em><b>Modelor Draughting</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.Tristate}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modelor Draughting</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modelor Draughting</em>' attribute.
	 * @see org.bimserver.models.ifc4.Tristate
	 * @see #isSetModelorDraughting()
	 * @see #unsetModelorDraughting()
	 * @see #setModelorDraughting(Tristate)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcFillAreaStyle_ModelorDraughting()
	 * @model unsettable="true"
	 * @generated
	 */
	Tristate getModelorDraughting();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcFillAreaStyle#getModelorDraughting <em>Modelor Draughting</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Modelor Draughting</em>' attribute.
	 * @see org.bimserver.models.ifc4.Tristate
	 * @see #isSetModelorDraughting()
	 * @see #unsetModelorDraughting()
	 * @see #getModelorDraughting()
	 * @generated
	 */
	void setModelorDraughting(Tristate value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcFillAreaStyle#getModelorDraughting <em>Modelor Draughting</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetModelorDraughting()
	 * @see #getModelorDraughting()
	 * @see #setModelorDraughting(Tristate)
	 * @generated
	 */
	void unsetModelorDraughting();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcFillAreaStyle#getModelorDraughting <em>Modelor Draughting</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Modelor Draughting</em>' attribute is set.
	 * @see #unsetModelorDraughting()
	 * @see #getModelorDraughting()
	 * @see #setModelorDraughting(Tristate)
	 * @generated
	 */
	boolean isSetModelorDraughting();

} // IfcFillAreaStyle
