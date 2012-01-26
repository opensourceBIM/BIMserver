/**
 * Copyright (C) 2011  BIMserver.org
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
package org.bimserver.models.ifc2x3;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Arbitrary Open Profile Def</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcArbitraryOpenProfileDef#getCurve <em>Curve</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcArbitraryOpenProfileDef()
 * @model
 * @generated
 */
public interface IfcArbitraryOpenProfileDef extends IfcProfileDef {
	/**
	 * Returns the value of the '<em><b>Curve</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Curve</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Curve</em>' reference.
	 * @see #isSetCurve()
	 * @see #unsetCurve()
	 * @see #setCurve(IfcBoundedCurve)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcArbitraryOpenProfileDef_Curve()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcBoundedCurve getCurve();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcArbitraryOpenProfileDef#getCurve <em>Curve</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Curve</em>' reference.
	 * @see #isSetCurve()
	 * @see #unsetCurve()
	 * @see #getCurve()
	 * @generated
	 */
	void setCurve(IfcBoundedCurve value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcArbitraryOpenProfileDef#getCurve <em>Curve</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCurve()
	 * @see #getCurve()
	 * @see #setCurve(IfcBoundedCurve)
	 * @generated
	 */
	void unsetCurve();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcArbitraryOpenProfileDef#getCurve <em>Curve</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Curve</em>' reference is set.
	 * @see #unsetCurve()
	 * @see #getCurve()
	 * @see #setCurve(IfcBoundedCurve)
	 * @generated
	 */
	boolean isSetCurve();

} // IfcArbitraryOpenProfileDef
