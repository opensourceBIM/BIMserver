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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Arbitrary Closed Profile Def</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcArbitraryClosedProfileDef#getOuterCurve <em>Outer Curve</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcArbitraryClosedProfileDef()
 * @model
 * @generated
 */
public interface IfcArbitraryClosedProfileDef extends IfcProfileDef {
	/**
	 * Returns the value of the '<em><b>Outer Curve</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outer Curve</em>' reference.
	 * @see #setOuterCurve(IfcCurve)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcArbitraryClosedProfileDef_OuterCurve()
	 * @model
	 * @generated
	 */
	IfcCurve getOuterCurve();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcArbitraryClosedProfileDef#getOuterCurve <em>Outer Curve</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outer Curve</em>' reference.
	 * @see #getOuterCurve()
	 * @generated
	 */
	void setOuterCurve(IfcCurve value);

} // IfcArbitraryClosedProfileDef
