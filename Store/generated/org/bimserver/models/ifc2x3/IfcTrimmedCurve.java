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
 * A representation of the model object '<em><b>Ifc Trimmed Curve</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTrimmedCurve#getBasisCurve <em>Basis Curve</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTrimmedCurve#getTrim1 <em>Trim1</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTrimmedCurve#getTrim2 <em>Trim2</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTrimmedCurve#getSenseAgreement <em>Sense Agreement</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTrimmedCurve#getMasterRepresentation <em>Master Representation</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTrimmedCurve()
 * @model
 * @generated
 */
public interface IfcTrimmedCurve extends IfcBoundedCurve
{
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTrimmedCurve_BasisCurve()
	 * @model
	 * @generated
	 */
	IfcCurve getBasisCurve();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTrimmedCurve#getBasisCurve <em>Basis Curve</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Basis Curve</em>' reference.
	 * @see #getBasisCurve()
	 * @generated
	 */
	void setBasisCurve(IfcCurve value);

	/**
	 * Returns the value of the '<em><b>Trim1</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcTrimmingSelect}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trim1</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trim1</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTrimmedCurve_Trim1()
	 * @model
	 * @generated
	 */
	EList<IfcTrimmingSelect> getTrim1();

	/**
	 * Returns the value of the '<em><b>Trim2</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcTrimmingSelect}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trim2</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trim2</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTrimmedCurve_Trim2()
	 * @model
	 * @generated
	 */
	EList<IfcTrimmingSelect> getTrim2();

	/**
	 * Returns the value of the '<em><b>Sense Agreement</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.Tristate}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sense Agreement</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sense Agreement</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.Tristate
	 * @see #setSenseAgreement(Tristate)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTrimmedCurve_SenseAgreement()
	 * @model
	 * @generated
	 */
	Tristate getSenseAgreement();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTrimmedCurve#getSenseAgreement <em>Sense Agreement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sense Agreement</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.Tristate
	 * @see #getSenseAgreement()
	 * @generated
	 */
	void setSenseAgreement(Tristate value);

	/**
	 * Returns the value of the '<em><b>Master Representation</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.IfcTrimmingPreference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Master Representation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Master Representation</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcTrimmingPreference
	 * @see #setMasterRepresentation(IfcTrimmingPreference)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTrimmedCurve_MasterRepresentation()
	 * @model
	 * @generated
	 */
	IfcTrimmingPreference getMasterRepresentation();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTrimmedCurve#getMasterRepresentation <em>Master Representation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Master Representation</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcTrimmingPreference
	 * @see #getMasterRepresentation()
	 * @generated
	 */
	void setMasterRepresentation(IfcTrimmingPreference value);

} // IfcTrimmedCurve
