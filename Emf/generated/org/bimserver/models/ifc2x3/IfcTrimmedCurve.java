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
	 * @see #isSetBasisCurve()
	 * @see #unsetBasisCurve()
	 * @see #setBasisCurve(IfcCurve)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTrimmedCurve_BasisCurve()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcCurve getBasisCurve();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTrimmedCurve#getBasisCurve <em>Basis Curve</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Basis Curve</em>' reference.
	 * @see #isSetBasisCurve()
	 * @see #unsetBasisCurve()
	 * @see #getBasisCurve()
	 * @generated
	 */
	void setBasisCurve(IfcCurve value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcTrimmedCurve#getBasisCurve <em>Basis Curve</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBasisCurve()
	 * @see #getBasisCurve()
	 * @see #setBasisCurve(IfcCurve)
	 * @generated
	 */
	void unsetBasisCurve();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcTrimmedCurve#getBasisCurve <em>Basis Curve</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Basis Curve</em>' reference is set.
	 * @see #unsetBasisCurve()
	 * @see #getBasisCurve()
	 * @see #setBasisCurve(IfcCurve)
	 * @generated
	 */
	boolean isSetBasisCurve();

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
	 * @see #isSetTrim1()
	 * @see #unsetTrim1()
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTrimmedCurve_Trim1()
	 * @model unsettable="true"
	 * @generated
	 */
	EList<IfcTrimmingSelect> getTrim1();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcTrimmedCurve#getTrim1 <em>Trim1</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTrim1()
	 * @see #getTrim1()
	 * @generated
	 */
	void unsetTrim1();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcTrimmedCurve#getTrim1 <em>Trim1</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Trim1</em>' reference list is set.
	 * @see #unsetTrim1()
	 * @see #getTrim1()
	 * @generated
	 */
	boolean isSetTrim1();

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
	 * @see #isSetTrim2()
	 * @see #unsetTrim2()
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTrimmedCurve_Trim2()
	 * @model unsettable="true"
	 * @generated
	 */
	EList<IfcTrimmingSelect> getTrim2();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcTrimmedCurve#getTrim2 <em>Trim2</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTrim2()
	 * @see #getTrim2()
	 * @generated
	 */
	void unsetTrim2();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcTrimmedCurve#getTrim2 <em>Trim2</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Trim2</em>' reference list is set.
	 * @see #unsetTrim2()
	 * @see #getTrim2()
	 * @generated
	 */
	boolean isSetTrim2();

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
	 * @see #isSetSenseAgreement()
	 * @see #unsetSenseAgreement()
	 * @see #setSenseAgreement(Tristate)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTrimmedCurve_SenseAgreement()
	 * @model unsettable="true"
	 * @generated
	 */
	Tristate getSenseAgreement();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTrimmedCurve#getSenseAgreement <em>Sense Agreement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sense Agreement</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.Tristate
	 * @see #isSetSenseAgreement()
	 * @see #unsetSenseAgreement()
	 * @see #getSenseAgreement()
	 * @generated
	 */
	void setSenseAgreement(Tristate value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcTrimmedCurve#getSenseAgreement <em>Sense Agreement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSenseAgreement()
	 * @see #getSenseAgreement()
	 * @see #setSenseAgreement(Tristate)
	 * @generated
	 */
	void unsetSenseAgreement();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcTrimmedCurve#getSenseAgreement <em>Sense Agreement</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Sense Agreement</em>' attribute is set.
	 * @see #unsetSenseAgreement()
	 * @see #getSenseAgreement()
	 * @see #setSenseAgreement(Tristate)
	 * @generated
	 */
	boolean isSetSenseAgreement();

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
	 * @see #isSetMasterRepresentation()
	 * @see #unsetMasterRepresentation()
	 * @see #setMasterRepresentation(IfcTrimmingPreference)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTrimmedCurve_MasterRepresentation()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcTrimmingPreference getMasterRepresentation();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTrimmedCurve#getMasterRepresentation <em>Master Representation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Master Representation</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcTrimmingPreference
	 * @see #isSetMasterRepresentation()
	 * @see #unsetMasterRepresentation()
	 * @see #getMasterRepresentation()
	 * @generated
	 */
	void setMasterRepresentation(IfcTrimmingPreference value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcTrimmedCurve#getMasterRepresentation <em>Master Representation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMasterRepresentation()
	 * @see #getMasterRepresentation()
	 * @see #setMasterRepresentation(IfcTrimmingPreference)
	 * @generated
	 */
	void unsetMasterRepresentation();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcTrimmedCurve#getMasterRepresentation <em>Master Representation</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Master Representation</em>' attribute is set.
	 * @see #unsetMasterRepresentation()
	 * @see #getMasterRepresentation()
	 * @see #setMasterRepresentation(IfcTrimmingPreference)
	 * @generated
	 */
	boolean isSetMasterRepresentation();

} // IfcTrimmedCurve
