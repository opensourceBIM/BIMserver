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
 * A representation of the model object '<em><b>Ifc Trimmed Curve</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcTrimmedCurve#getBasisCurve <em>Basis Curve</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcTrimmedCurve#getTrim1 <em>Trim1</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcTrimmedCurve#getTrim2 <em>Trim2</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcTrimmedCurve#getSenseAgreement <em>Sense Agreement</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcTrimmedCurve#getMasterRepresentation <em>Master Representation</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTrimmedCurve()
 * @model
 * @generated
 */
public interface IfcTrimmedCurve extends IfcBoundedCurve {
	/**
	 * Returns the value of the '<em><b>Basis Curve</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Basis Curve</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Basis Curve</em>' reference.
	 * @see #setBasisCurve(IfcCurve)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTrimmedCurve_BasisCurve()
	 * @model
	 * @generated
	 */
	IfcCurve getBasisCurve();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTrimmedCurve#getBasisCurve <em>Basis Curve</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Basis Curve</em>' reference.
	 * @see #getBasisCurve()
	 * @generated
	 */
	void setBasisCurve(IfcCurve value);

	/**
	 * Returns the value of the '<em><b>Trim1</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcTrimmingSelect}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trim1</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trim1</em>' reference list.
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTrimmedCurve_Trim1()
	 * @model
	 * @generated
	 */
	EList<IfcTrimmingSelect> getTrim1();

	/**
	 * Returns the value of the '<em><b>Trim2</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcTrimmingSelect}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trim2</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trim2</em>' reference list.
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTrimmedCurve_Trim2()
	 * @model
	 * @generated
	 */
	EList<IfcTrimmingSelect> getTrim2();

	/**
	 * Returns the value of the '<em><b>Sense Agreement</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.Tristate}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sense Agreement</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sense Agreement</em>' attribute.
	 * @see org.bimserver.models.ifc4.Tristate
	 * @see #setSenseAgreement(Tristate)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTrimmedCurve_SenseAgreement()
	 * @model
	 * @generated
	 */
	Tristate getSenseAgreement();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTrimmedCurve#getSenseAgreement <em>Sense Agreement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sense Agreement</em>' attribute.
	 * @see org.bimserver.models.ifc4.Tristate
	 * @see #getSenseAgreement()
	 * @generated
	 */
	void setSenseAgreement(Tristate value);

	/**
	 * Returns the value of the '<em><b>Master Representation</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.IfcTrimmingPreference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Master Representation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Master Representation</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcTrimmingPreference
	 * @see #setMasterRepresentation(IfcTrimmingPreference)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTrimmedCurve_MasterRepresentation()
	 * @model
	 * @generated
	 */
	IfcTrimmingPreference getMasterRepresentation();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTrimmedCurve#getMasterRepresentation <em>Master Representation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Master Representation</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcTrimmingPreference
	 * @see #getMasterRepresentation()
	 * @generated
	 */
	void setMasterRepresentation(IfcTrimmingPreference value);

} // IfcTrimmedCurve
