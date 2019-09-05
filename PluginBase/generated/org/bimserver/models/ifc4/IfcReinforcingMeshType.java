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
 * A representation of the model object '<em><b>Ifc Reinforcing Mesh Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getPredefinedType <em>Predefined Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getMeshLength <em>Mesh Length</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getMeshLengthAsString <em>Mesh Length As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getMeshWidth <em>Mesh Width</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getMeshWidthAsString <em>Mesh Width As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getLongitudinalBarNominalDiameter <em>Longitudinal Bar Nominal Diameter</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getLongitudinalBarNominalDiameterAsString <em>Longitudinal Bar Nominal Diameter As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getTransverseBarNominalDiameter <em>Transverse Bar Nominal Diameter</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getTransverseBarNominalDiameterAsString <em>Transverse Bar Nominal Diameter As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getLongitudinalBarCrossSectionArea <em>Longitudinal Bar Cross Section Area</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getLongitudinalBarCrossSectionAreaAsString <em>Longitudinal Bar Cross Section Area As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getTransverseBarCrossSectionArea <em>Transverse Bar Cross Section Area</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getTransverseBarCrossSectionAreaAsString <em>Transverse Bar Cross Section Area As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getLongitudinalBarSpacing <em>Longitudinal Bar Spacing</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getLongitudinalBarSpacingAsString <em>Longitudinal Bar Spacing As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getTransverseBarSpacing <em>Transverse Bar Spacing</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getTransverseBarSpacingAsString <em>Transverse Bar Spacing As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getBendingShapeCode <em>Bending Shape Code</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getBendingParameters <em>Bending Parameters</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcReinforcingMeshType()
 * @model
 * @generated
 */
public interface IfcReinforcingMeshType extends IfcReinforcingElementType {
	/**
	 * Returns the value of the '<em><b>Predefined Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.IfcReinforcingMeshTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predefined Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcReinforcingMeshTypeEnum
	 * @see #setPredefinedType(IfcReinforcingMeshTypeEnum)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcReinforcingMeshType_PredefinedType()
	 * @model
	 * @generated
	 */
	IfcReinforcingMeshTypeEnum getPredefinedType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getPredefinedType <em>Predefined Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcReinforcingMeshTypeEnum
	 * @see #getPredefinedType()
	 * @generated
	 */
	void setPredefinedType(IfcReinforcingMeshTypeEnum value);

	/**
	 * Returns the value of the '<em><b>Mesh Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mesh Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mesh Length</em>' attribute.
	 * @see #isSetMeshLength()
	 * @see #unsetMeshLength()
	 * @see #setMeshLength(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcReinforcingMeshType_MeshLength()
	 * @model unsettable="true"
	 * @generated
	 */
	double getMeshLength();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getMeshLength <em>Mesh Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mesh Length</em>' attribute.
	 * @see #isSetMeshLength()
	 * @see #unsetMeshLength()
	 * @see #getMeshLength()
	 * @generated
	 */
	void setMeshLength(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getMeshLength <em>Mesh Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMeshLength()
	 * @see #getMeshLength()
	 * @see #setMeshLength(double)
	 * @generated
	 */
	void unsetMeshLength();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getMeshLength <em>Mesh Length</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Mesh Length</em>' attribute is set.
	 * @see #unsetMeshLength()
	 * @see #getMeshLength()
	 * @see #setMeshLength(double)
	 * @generated
	 */
	boolean isSetMeshLength();

	/**
	 * Returns the value of the '<em><b>Mesh Length As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mesh Length As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mesh Length As String</em>' attribute.
	 * @see #isSetMeshLengthAsString()
	 * @see #unsetMeshLengthAsString()
	 * @see #setMeshLengthAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcReinforcingMeshType_MeshLengthAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getMeshLengthAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getMeshLengthAsString <em>Mesh Length As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mesh Length As String</em>' attribute.
	 * @see #isSetMeshLengthAsString()
	 * @see #unsetMeshLengthAsString()
	 * @see #getMeshLengthAsString()
	 * @generated
	 */
	void setMeshLengthAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getMeshLengthAsString <em>Mesh Length As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMeshLengthAsString()
	 * @see #getMeshLengthAsString()
	 * @see #setMeshLengthAsString(String)
	 * @generated
	 */
	void unsetMeshLengthAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getMeshLengthAsString <em>Mesh Length As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Mesh Length As String</em>' attribute is set.
	 * @see #unsetMeshLengthAsString()
	 * @see #getMeshLengthAsString()
	 * @see #setMeshLengthAsString(String)
	 * @generated
	 */
	boolean isSetMeshLengthAsString();

	/**
	 * Returns the value of the '<em><b>Mesh Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mesh Width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mesh Width</em>' attribute.
	 * @see #isSetMeshWidth()
	 * @see #unsetMeshWidth()
	 * @see #setMeshWidth(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcReinforcingMeshType_MeshWidth()
	 * @model unsettable="true"
	 * @generated
	 */
	double getMeshWidth();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getMeshWidth <em>Mesh Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mesh Width</em>' attribute.
	 * @see #isSetMeshWidth()
	 * @see #unsetMeshWidth()
	 * @see #getMeshWidth()
	 * @generated
	 */
	void setMeshWidth(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getMeshWidth <em>Mesh Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMeshWidth()
	 * @see #getMeshWidth()
	 * @see #setMeshWidth(double)
	 * @generated
	 */
	void unsetMeshWidth();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getMeshWidth <em>Mesh Width</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Mesh Width</em>' attribute is set.
	 * @see #unsetMeshWidth()
	 * @see #getMeshWidth()
	 * @see #setMeshWidth(double)
	 * @generated
	 */
	boolean isSetMeshWidth();

	/**
	 * Returns the value of the '<em><b>Mesh Width As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mesh Width As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mesh Width As String</em>' attribute.
	 * @see #isSetMeshWidthAsString()
	 * @see #unsetMeshWidthAsString()
	 * @see #setMeshWidthAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcReinforcingMeshType_MeshWidthAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getMeshWidthAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getMeshWidthAsString <em>Mesh Width As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mesh Width As String</em>' attribute.
	 * @see #isSetMeshWidthAsString()
	 * @see #unsetMeshWidthAsString()
	 * @see #getMeshWidthAsString()
	 * @generated
	 */
	void setMeshWidthAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getMeshWidthAsString <em>Mesh Width As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMeshWidthAsString()
	 * @see #getMeshWidthAsString()
	 * @see #setMeshWidthAsString(String)
	 * @generated
	 */
	void unsetMeshWidthAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getMeshWidthAsString <em>Mesh Width As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Mesh Width As String</em>' attribute is set.
	 * @see #unsetMeshWidthAsString()
	 * @see #getMeshWidthAsString()
	 * @see #setMeshWidthAsString(String)
	 * @generated
	 */
	boolean isSetMeshWidthAsString();

	/**
	 * Returns the value of the '<em><b>Longitudinal Bar Nominal Diameter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Longitudinal Bar Nominal Diameter</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Longitudinal Bar Nominal Diameter</em>' attribute.
	 * @see #isSetLongitudinalBarNominalDiameter()
	 * @see #unsetLongitudinalBarNominalDiameter()
	 * @see #setLongitudinalBarNominalDiameter(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcReinforcingMeshType_LongitudinalBarNominalDiameter()
	 * @model unsettable="true"
	 * @generated
	 */
	double getLongitudinalBarNominalDiameter();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getLongitudinalBarNominalDiameter <em>Longitudinal Bar Nominal Diameter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Longitudinal Bar Nominal Diameter</em>' attribute.
	 * @see #isSetLongitudinalBarNominalDiameter()
	 * @see #unsetLongitudinalBarNominalDiameter()
	 * @see #getLongitudinalBarNominalDiameter()
	 * @generated
	 */
	void setLongitudinalBarNominalDiameter(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getLongitudinalBarNominalDiameter <em>Longitudinal Bar Nominal Diameter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLongitudinalBarNominalDiameter()
	 * @see #getLongitudinalBarNominalDiameter()
	 * @see #setLongitudinalBarNominalDiameter(double)
	 * @generated
	 */
	void unsetLongitudinalBarNominalDiameter();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getLongitudinalBarNominalDiameter <em>Longitudinal Bar Nominal Diameter</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Longitudinal Bar Nominal Diameter</em>' attribute is set.
	 * @see #unsetLongitudinalBarNominalDiameter()
	 * @see #getLongitudinalBarNominalDiameter()
	 * @see #setLongitudinalBarNominalDiameter(double)
	 * @generated
	 */
	boolean isSetLongitudinalBarNominalDiameter();

	/**
	 * Returns the value of the '<em><b>Longitudinal Bar Nominal Diameter As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Longitudinal Bar Nominal Diameter As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Longitudinal Bar Nominal Diameter As String</em>' attribute.
	 * @see #isSetLongitudinalBarNominalDiameterAsString()
	 * @see #unsetLongitudinalBarNominalDiameterAsString()
	 * @see #setLongitudinalBarNominalDiameterAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcReinforcingMeshType_LongitudinalBarNominalDiameterAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getLongitudinalBarNominalDiameterAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getLongitudinalBarNominalDiameterAsString <em>Longitudinal Bar Nominal Diameter As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Longitudinal Bar Nominal Diameter As String</em>' attribute.
	 * @see #isSetLongitudinalBarNominalDiameterAsString()
	 * @see #unsetLongitudinalBarNominalDiameterAsString()
	 * @see #getLongitudinalBarNominalDiameterAsString()
	 * @generated
	 */
	void setLongitudinalBarNominalDiameterAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getLongitudinalBarNominalDiameterAsString <em>Longitudinal Bar Nominal Diameter As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLongitudinalBarNominalDiameterAsString()
	 * @see #getLongitudinalBarNominalDiameterAsString()
	 * @see #setLongitudinalBarNominalDiameterAsString(String)
	 * @generated
	 */
	void unsetLongitudinalBarNominalDiameterAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getLongitudinalBarNominalDiameterAsString <em>Longitudinal Bar Nominal Diameter As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Longitudinal Bar Nominal Diameter As String</em>' attribute is set.
	 * @see #unsetLongitudinalBarNominalDiameterAsString()
	 * @see #getLongitudinalBarNominalDiameterAsString()
	 * @see #setLongitudinalBarNominalDiameterAsString(String)
	 * @generated
	 */
	boolean isSetLongitudinalBarNominalDiameterAsString();

	/**
	 * Returns the value of the '<em><b>Transverse Bar Nominal Diameter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transverse Bar Nominal Diameter</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transverse Bar Nominal Diameter</em>' attribute.
	 * @see #isSetTransverseBarNominalDiameter()
	 * @see #unsetTransverseBarNominalDiameter()
	 * @see #setTransverseBarNominalDiameter(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcReinforcingMeshType_TransverseBarNominalDiameter()
	 * @model unsettable="true"
	 * @generated
	 */
	double getTransverseBarNominalDiameter();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getTransverseBarNominalDiameter <em>Transverse Bar Nominal Diameter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transverse Bar Nominal Diameter</em>' attribute.
	 * @see #isSetTransverseBarNominalDiameter()
	 * @see #unsetTransverseBarNominalDiameter()
	 * @see #getTransverseBarNominalDiameter()
	 * @generated
	 */
	void setTransverseBarNominalDiameter(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getTransverseBarNominalDiameter <em>Transverse Bar Nominal Diameter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTransverseBarNominalDiameter()
	 * @see #getTransverseBarNominalDiameter()
	 * @see #setTransverseBarNominalDiameter(double)
	 * @generated
	 */
	void unsetTransverseBarNominalDiameter();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getTransverseBarNominalDiameter <em>Transverse Bar Nominal Diameter</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Transverse Bar Nominal Diameter</em>' attribute is set.
	 * @see #unsetTransverseBarNominalDiameter()
	 * @see #getTransverseBarNominalDiameter()
	 * @see #setTransverseBarNominalDiameter(double)
	 * @generated
	 */
	boolean isSetTransverseBarNominalDiameter();

	/**
	 * Returns the value of the '<em><b>Transverse Bar Nominal Diameter As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transverse Bar Nominal Diameter As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transverse Bar Nominal Diameter As String</em>' attribute.
	 * @see #isSetTransverseBarNominalDiameterAsString()
	 * @see #unsetTransverseBarNominalDiameterAsString()
	 * @see #setTransverseBarNominalDiameterAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcReinforcingMeshType_TransverseBarNominalDiameterAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getTransverseBarNominalDiameterAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getTransverseBarNominalDiameterAsString <em>Transverse Bar Nominal Diameter As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transverse Bar Nominal Diameter As String</em>' attribute.
	 * @see #isSetTransverseBarNominalDiameterAsString()
	 * @see #unsetTransverseBarNominalDiameterAsString()
	 * @see #getTransverseBarNominalDiameterAsString()
	 * @generated
	 */
	void setTransverseBarNominalDiameterAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getTransverseBarNominalDiameterAsString <em>Transverse Bar Nominal Diameter As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTransverseBarNominalDiameterAsString()
	 * @see #getTransverseBarNominalDiameterAsString()
	 * @see #setTransverseBarNominalDiameterAsString(String)
	 * @generated
	 */
	void unsetTransverseBarNominalDiameterAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getTransverseBarNominalDiameterAsString <em>Transverse Bar Nominal Diameter As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Transverse Bar Nominal Diameter As String</em>' attribute is set.
	 * @see #unsetTransverseBarNominalDiameterAsString()
	 * @see #getTransverseBarNominalDiameterAsString()
	 * @see #setTransverseBarNominalDiameterAsString(String)
	 * @generated
	 */
	boolean isSetTransverseBarNominalDiameterAsString();

	/**
	 * Returns the value of the '<em><b>Longitudinal Bar Cross Section Area</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Longitudinal Bar Cross Section Area</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Longitudinal Bar Cross Section Area</em>' attribute.
	 * @see #isSetLongitudinalBarCrossSectionArea()
	 * @see #unsetLongitudinalBarCrossSectionArea()
	 * @see #setLongitudinalBarCrossSectionArea(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcReinforcingMeshType_LongitudinalBarCrossSectionArea()
	 * @model unsettable="true"
	 * @generated
	 */
	double getLongitudinalBarCrossSectionArea();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getLongitudinalBarCrossSectionArea <em>Longitudinal Bar Cross Section Area</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Longitudinal Bar Cross Section Area</em>' attribute.
	 * @see #isSetLongitudinalBarCrossSectionArea()
	 * @see #unsetLongitudinalBarCrossSectionArea()
	 * @see #getLongitudinalBarCrossSectionArea()
	 * @generated
	 */
	void setLongitudinalBarCrossSectionArea(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getLongitudinalBarCrossSectionArea <em>Longitudinal Bar Cross Section Area</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLongitudinalBarCrossSectionArea()
	 * @see #getLongitudinalBarCrossSectionArea()
	 * @see #setLongitudinalBarCrossSectionArea(double)
	 * @generated
	 */
	void unsetLongitudinalBarCrossSectionArea();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getLongitudinalBarCrossSectionArea <em>Longitudinal Bar Cross Section Area</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Longitudinal Bar Cross Section Area</em>' attribute is set.
	 * @see #unsetLongitudinalBarCrossSectionArea()
	 * @see #getLongitudinalBarCrossSectionArea()
	 * @see #setLongitudinalBarCrossSectionArea(double)
	 * @generated
	 */
	boolean isSetLongitudinalBarCrossSectionArea();

	/**
	 * Returns the value of the '<em><b>Longitudinal Bar Cross Section Area As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Longitudinal Bar Cross Section Area As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Longitudinal Bar Cross Section Area As String</em>' attribute.
	 * @see #isSetLongitudinalBarCrossSectionAreaAsString()
	 * @see #unsetLongitudinalBarCrossSectionAreaAsString()
	 * @see #setLongitudinalBarCrossSectionAreaAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcReinforcingMeshType_LongitudinalBarCrossSectionAreaAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getLongitudinalBarCrossSectionAreaAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getLongitudinalBarCrossSectionAreaAsString <em>Longitudinal Bar Cross Section Area As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Longitudinal Bar Cross Section Area As String</em>' attribute.
	 * @see #isSetLongitudinalBarCrossSectionAreaAsString()
	 * @see #unsetLongitudinalBarCrossSectionAreaAsString()
	 * @see #getLongitudinalBarCrossSectionAreaAsString()
	 * @generated
	 */
	void setLongitudinalBarCrossSectionAreaAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getLongitudinalBarCrossSectionAreaAsString <em>Longitudinal Bar Cross Section Area As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLongitudinalBarCrossSectionAreaAsString()
	 * @see #getLongitudinalBarCrossSectionAreaAsString()
	 * @see #setLongitudinalBarCrossSectionAreaAsString(String)
	 * @generated
	 */
	void unsetLongitudinalBarCrossSectionAreaAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getLongitudinalBarCrossSectionAreaAsString <em>Longitudinal Bar Cross Section Area As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Longitudinal Bar Cross Section Area As String</em>' attribute is set.
	 * @see #unsetLongitudinalBarCrossSectionAreaAsString()
	 * @see #getLongitudinalBarCrossSectionAreaAsString()
	 * @see #setLongitudinalBarCrossSectionAreaAsString(String)
	 * @generated
	 */
	boolean isSetLongitudinalBarCrossSectionAreaAsString();

	/**
	 * Returns the value of the '<em><b>Transverse Bar Cross Section Area</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transverse Bar Cross Section Area</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transverse Bar Cross Section Area</em>' attribute.
	 * @see #isSetTransverseBarCrossSectionArea()
	 * @see #unsetTransverseBarCrossSectionArea()
	 * @see #setTransverseBarCrossSectionArea(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcReinforcingMeshType_TransverseBarCrossSectionArea()
	 * @model unsettable="true"
	 * @generated
	 */
	double getTransverseBarCrossSectionArea();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getTransverseBarCrossSectionArea <em>Transverse Bar Cross Section Area</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transverse Bar Cross Section Area</em>' attribute.
	 * @see #isSetTransverseBarCrossSectionArea()
	 * @see #unsetTransverseBarCrossSectionArea()
	 * @see #getTransverseBarCrossSectionArea()
	 * @generated
	 */
	void setTransverseBarCrossSectionArea(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getTransverseBarCrossSectionArea <em>Transverse Bar Cross Section Area</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTransverseBarCrossSectionArea()
	 * @see #getTransverseBarCrossSectionArea()
	 * @see #setTransverseBarCrossSectionArea(double)
	 * @generated
	 */
	void unsetTransverseBarCrossSectionArea();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getTransverseBarCrossSectionArea <em>Transverse Bar Cross Section Area</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Transverse Bar Cross Section Area</em>' attribute is set.
	 * @see #unsetTransverseBarCrossSectionArea()
	 * @see #getTransverseBarCrossSectionArea()
	 * @see #setTransverseBarCrossSectionArea(double)
	 * @generated
	 */
	boolean isSetTransverseBarCrossSectionArea();

	/**
	 * Returns the value of the '<em><b>Transverse Bar Cross Section Area As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transverse Bar Cross Section Area As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transverse Bar Cross Section Area As String</em>' attribute.
	 * @see #isSetTransverseBarCrossSectionAreaAsString()
	 * @see #unsetTransverseBarCrossSectionAreaAsString()
	 * @see #setTransverseBarCrossSectionAreaAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcReinforcingMeshType_TransverseBarCrossSectionAreaAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getTransverseBarCrossSectionAreaAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getTransverseBarCrossSectionAreaAsString <em>Transverse Bar Cross Section Area As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transverse Bar Cross Section Area As String</em>' attribute.
	 * @see #isSetTransverseBarCrossSectionAreaAsString()
	 * @see #unsetTransverseBarCrossSectionAreaAsString()
	 * @see #getTransverseBarCrossSectionAreaAsString()
	 * @generated
	 */
	void setTransverseBarCrossSectionAreaAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getTransverseBarCrossSectionAreaAsString <em>Transverse Bar Cross Section Area As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTransverseBarCrossSectionAreaAsString()
	 * @see #getTransverseBarCrossSectionAreaAsString()
	 * @see #setTransverseBarCrossSectionAreaAsString(String)
	 * @generated
	 */
	void unsetTransverseBarCrossSectionAreaAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getTransverseBarCrossSectionAreaAsString <em>Transverse Bar Cross Section Area As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Transverse Bar Cross Section Area As String</em>' attribute is set.
	 * @see #unsetTransverseBarCrossSectionAreaAsString()
	 * @see #getTransverseBarCrossSectionAreaAsString()
	 * @see #setTransverseBarCrossSectionAreaAsString(String)
	 * @generated
	 */
	boolean isSetTransverseBarCrossSectionAreaAsString();

	/**
	 * Returns the value of the '<em><b>Longitudinal Bar Spacing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Longitudinal Bar Spacing</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Longitudinal Bar Spacing</em>' attribute.
	 * @see #isSetLongitudinalBarSpacing()
	 * @see #unsetLongitudinalBarSpacing()
	 * @see #setLongitudinalBarSpacing(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcReinforcingMeshType_LongitudinalBarSpacing()
	 * @model unsettable="true"
	 * @generated
	 */
	double getLongitudinalBarSpacing();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getLongitudinalBarSpacing <em>Longitudinal Bar Spacing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Longitudinal Bar Spacing</em>' attribute.
	 * @see #isSetLongitudinalBarSpacing()
	 * @see #unsetLongitudinalBarSpacing()
	 * @see #getLongitudinalBarSpacing()
	 * @generated
	 */
	void setLongitudinalBarSpacing(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getLongitudinalBarSpacing <em>Longitudinal Bar Spacing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLongitudinalBarSpacing()
	 * @see #getLongitudinalBarSpacing()
	 * @see #setLongitudinalBarSpacing(double)
	 * @generated
	 */
	void unsetLongitudinalBarSpacing();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getLongitudinalBarSpacing <em>Longitudinal Bar Spacing</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Longitudinal Bar Spacing</em>' attribute is set.
	 * @see #unsetLongitudinalBarSpacing()
	 * @see #getLongitudinalBarSpacing()
	 * @see #setLongitudinalBarSpacing(double)
	 * @generated
	 */
	boolean isSetLongitudinalBarSpacing();

	/**
	 * Returns the value of the '<em><b>Longitudinal Bar Spacing As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Longitudinal Bar Spacing As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Longitudinal Bar Spacing As String</em>' attribute.
	 * @see #isSetLongitudinalBarSpacingAsString()
	 * @see #unsetLongitudinalBarSpacingAsString()
	 * @see #setLongitudinalBarSpacingAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcReinforcingMeshType_LongitudinalBarSpacingAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getLongitudinalBarSpacingAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getLongitudinalBarSpacingAsString <em>Longitudinal Bar Spacing As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Longitudinal Bar Spacing As String</em>' attribute.
	 * @see #isSetLongitudinalBarSpacingAsString()
	 * @see #unsetLongitudinalBarSpacingAsString()
	 * @see #getLongitudinalBarSpacingAsString()
	 * @generated
	 */
	void setLongitudinalBarSpacingAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getLongitudinalBarSpacingAsString <em>Longitudinal Bar Spacing As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLongitudinalBarSpacingAsString()
	 * @see #getLongitudinalBarSpacingAsString()
	 * @see #setLongitudinalBarSpacingAsString(String)
	 * @generated
	 */
	void unsetLongitudinalBarSpacingAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getLongitudinalBarSpacingAsString <em>Longitudinal Bar Spacing As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Longitudinal Bar Spacing As String</em>' attribute is set.
	 * @see #unsetLongitudinalBarSpacingAsString()
	 * @see #getLongitudinalBarSpacingAsString()
	 * @see #setLongitudinalBarSpacingAsString(String)
	 * @generated
	 */
	boolean isSetLongitudinalBarSpacingAsString();

	/**
	 * Returns the value of the '<em><b>Transverse Bar Spacing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transverse Bar Spacing</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transverse Bar Spacing</em>' attribute.
	 * @see #isSetTransverseBarSpacing()
	 * @see #unsetTransverseBarSpacing()
	 * @see #setTransverseBarSpacing(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcReinforcingMeshType_TransverseBarSpacing()
	 * @model unsettable="true"
	 * @generated
	 */
	double getTransverseBarSpacing();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getTransverseBarSpacing <em>Transverse Bar Spacing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transverse Bar Spacing</em>' attribute.
	 * @see #isSetTransverseBarSpacing()
	 * @see #unsetTransverseBarSpacing()
	 * @see #getTransverseBarSpacing()
	 * @generated
	 */
	void setTransverseBarSpacing(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getTransverseBarSpacing <em>Transverse Bar Spacing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTransverseBarSpacing()
	 * @see #getTransverseBarSpacing()
	 * @see #setTransverseBarSpacing(double)
	 * @generated
	 */
	void unsetTransverseBarSpacing();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getTransverseBarSpacing <em>Transverse Bar Spacing</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Transverse Bar Spacing</em>' attribute is set.
	 * @see #unsetTransverseBarSpacing()
	 * @see #getTransverseBarSpacing()
	 * @see #setTransverseBarSpacing(double)
	 * @generated
	 */
	boolean isSetTransverseBarSpacing();

	/**
	 * Returns the value of the '<em><b>Transverse Bar Spacing As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transverse Bar Spacing As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transverse Bar Spacing As String</em>' attribute.
	 * @see #isSetTransverseBarSpacingAsString()
	 * @see #unsetTransverseBarSpacingAsString()
	 * @see #setTransverseBarSpacingAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcReinforcingMeshType_TransverseBarSpacingAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getTransverseBarSpacingAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getTransverseBarSpacingAsString <em>Transverse Bar Spacing As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transverse Bar Spacing As String</em>' attribute.
	 * @see #isSetTransverseBarSpacingAsString()
	 * @see #unsetTransverseBarSpacingAsString()
	 * @see #getTransverseBarSpacingAsString()
	 * @generated
	 */
	void setTransverseBarSpacingAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getTransverseBarSpacingAsString <em>Transverse Bar Spacing As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTransverseBarSpacingAsString()
	 * @see #getTransverseBarSpacingAsString()
	 * @see #setTransverseBarSpacingAsString(String)
	 * @generated
	 */
	void unsetTransverseBarSpacingAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getTransverseBarSpacingAsString <em>Transverse Bar Spacing As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Transverse Bar Spacing As String</em>' attribute is set.
	 * @see #unsetTransverseBarSpacingAsString()
	 * @see #getTransverseBarSpacingAsString()
	 * @see #setTransverseBarSpacingAsString(String)
	 * @generated
	 */
	boolean isSetTransverseBarSpacingAsString();

	/**
	 * Returns the value of the '<em><b>Bending Shape Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bending Shape Code</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bending Shape Code</em>' attribute.
	 * @see #isSetBendingShapeCode()
	 * @see #unsetBendingShapeCode()
	 * @see #setBendingShapeCode(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcReinforcingMeshType_BendingShapeCode()
	 * @model unsettable="true"
	 * @generated
	 */
	String getBendingShapeCode();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getBendingShapeCode <em>Bending Shape Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bending Shape Code</em>' attribute.
	 * @see #isSetBendingShapeCode()
	 * @see #unsetBendingShapeCode()
	 * @see #getBendingShapeCode()
	 * @generated
	 */
	void setBendingShapeCode(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getBendingShapeCode <em>Bending Shape Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBendingShapeCode()
	 * @see #getBendingShapeCode()
	 * @see #setBendingShapeCode(String)
	 * @generated
	 */
	void unsetBendingShapeCode();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getBendingShapeCode <em>Bending Shape Code</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Bending Shape Code</em>' attribute is set.
	 * @see #unsetBendingShapeCode()
	 * @see #getBendingShapeCode()
	 * @see #setBendingShapeCode(String)
	 * @generated
	 */
	boolean isSetBendingShapeCode();

	/**
	 * Returns the value of the '<em><b>Bending Parameters</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcBendingParameterSelect}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bending Parameters</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bending Parameters</em>' reference list.
	 * @see #isSetBendingParameters()
	 * @see #unsetBendingParameters()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcReinforcingMeshType_BendingParameters()
	 * @model unsettable="true"
	 * @generated
	 */
	EList<IfcBendingParameterSelect> getBendingParameters();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getBendingParameters <em>Bending Parameters</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBendingParameters()
	 * @see #getBendingParameters()
	 * @generated
	 */
	void unsetBendingParameters();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingMeshType#getBendingParameters <em>Bending Parameters</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Bending Parameters</em>' reference list is set.
	 * @see #unsetBendingParameters()
	 * @see #getBendingParameters()
	 * @generated
	 */
	boolean isSetBendingParameters();

} // IfcReinforcingMeshType
