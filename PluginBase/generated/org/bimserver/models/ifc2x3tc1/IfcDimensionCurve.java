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
package org.bimserver.models.ifc2x3tc1;

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
 * A representation of the model object '<em><b>Ifc Dimension Curve</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcDimensionCurve#getAnnotatedBySymbols <em>Annotated By Symbols</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcDimensionCurve()
 * @model
 * @generated
 */
public interface IfcDimensionCurve extends IfcAnnotationCurveOccurrence {
	/**
	 * Returns the value of the '<em><b>Annotated By Symbols</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3tc1.IfcTerminatorSymbol}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annotated By Symbols</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annotated By Symbols</em>' reference list.
	 * @see #isSetAnnotatedBySymbols()
	 * @see #unsetAnnotatedBySymbols()
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcDimensionCurve_AnnotatedBySymbols()
	 * @model unsettable="true" upper="3"
	 * @generated
	 */
	EList<IfcTerminatorSymbol> getAnnotatedBySymbols();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcDimensionCurve#getAnnotatedBySymbols <em>Annotated By Symbols</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetAnnotatedBySymbols()
	 * @see #getAnnotatedBySymbols()
	 * @generated
	 */
	void unsetAnnotatedBySymbols();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcDimensionCurve#getAnnotatedBySymbols <em>Annotated By Symbols</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Annotated By Symbols</em>' reference list is set.
	 * @see #unsetAnnotatedBySymbols()
	 * @see #getAnnotatedBySymbols()
	 * @generated
	 */
	boolean isSetAnnotatedBySymbols();

} // IfcDimensionCurve
