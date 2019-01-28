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

public interface IfcReinforcingMesh extends IfcReinforcingElement {
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
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcReinforcingMesh_MeshLength()
	 * @model unsettable="true"
	 * @generated
	 */
	double getMeshLength();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcReinforcingMesh#getMeshLength <em>Mesh Length</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcReinforcingMesh#getMeshLength <em>Mesh Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMeshLength()
	 * @see #getMeshLength()
	 * @see #setMeshLength(double)
	 * @generated
	 */
	void unsetMeshLength();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcReinforcingMesh#getMeshLength <em>Mesh Length</em>}' attribute is set.
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
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcReinforcingMesh_MeshLengthAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getMeshLengthAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcReinforcingMesh#getMeshLengthAsString <em>Mesh Length As String</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcReinforcingMesh#getMeshLengthAsString <em>Mesh Length As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMeshLengthAsString()
	 * @see #getMeshLengthAsString()
	 * @see #setMeshLengthAsString(String)
	 * @generated
	 */
	void unsetMeshLengthAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcReinforcingMesh#getMeshLengthAsString <em>Mesh Length As String</em>}' attribute is set.
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
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcReinforcingMesh_MeshWidth()
	 * @model unsettable="true"
	 * @generated
	 */
	double getMeshWidth();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcReinforcingMesh#getMeshWidth <em>Mesh Width</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcReinforcingMesh#getMeshWidth <em>Mesh Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMeshWidth()
	 * @see #getMeshWidth()
	 * @see #setMeshWidth(double)
	 * @generated
	 */
	void unsetMeshWidth();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcReinforcingMesh#getMeshWidth <em>Mesh Width</em>}' attribute is set.
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
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcReinforcingMesh_MeshWidthAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getMeshWidthAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcReinforcingMesh#getMeshWidthAsString <em>Mesh Width As String</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcReinforcingMesh#getMeshWidthAsString <em>Mesh Width As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMeshWidthAsString()
	 * @see #getMeshWidthAsString()
	 * @see #setMeshWidthAsString(String)
	 * @generated
	 */
	void unsetMeshWidthAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcReinforcingMesh#getMeshWidthAsString <em>Mesh Width As String</em>}' attribute is set.
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
	 * @see #setLongitudinalBarNominalDiameter(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcReinforcingMesh_LongitudinalBarNominalDiameter()
	 * @model
	 * @generated
	 */
	double getLongitudinalBarNominalDiameter();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcReinforcingMesh#getLongitudinalBarNominalDiameter <em>Longitudinal Bar Nominal Diameter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Longitudinal Bar Nominal Diameter</em>' attribute.
	 * @see #getLongitudinalBarNominalDiameter()
	 * @generated
	 */
	void setLongitudinalBarNominalDiameter(double value);

	/**
	 * Returns the value of the '<em><b>Longitudinal Bar Nominal Diameter As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Longitudinal Bar Nominal Diameter As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Longitudinal Bar Nominal Diameter As String</em>' attribute.
	 * @see #setLongitudinalBarNominalDiameterAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcReinforcingMesh_LongitudinalBarNominalDiameterAsString()
	 * @model
	 * @generated
	 */
	String getLongitudinalBarNominalDiameterAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcReinforcingMesh#getLongitudinalBarNominalDiameterAsString <em>Longitudinal Bar Nominal Diameter As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Longitudinal Bar Nominal Diameter As String</em>' attribute.
	 * @see #getLongitudinalBarNominalDiameterAsString()
	 * @generated
	 */
	void setLongitudinalBarNominalDiameterAsString(String value);

	/**
	 * Returns the value of the '<em><b>Transverse Bar Nominal Diameter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transverse Bar Nominal Diameter</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transverse Bar Nominal Diameter</em>' attribute.
	 * @see #setTransverseBarNominalDiameter(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcReinforcingMesh_TransverseBarNominalDiameter()
	 * @model
	 * @generated
	 */
	double getTransverseBarNominalDiameter();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcReinforcingMesh#getTransverseBarNominalDiameter <em>Transverse Bar Nominal Diameter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transverse Bar Nominal Diameter</em>' attribute.
	 * @see #getTransverseBarNominalDiameter()
	 * @generated
	 */
	void setTransverseBarNominalDiameter(double value);

	/**
	 * Returns the value of the '<em><b>Transverse Bar Nominal Diameter As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transverse Bar Nominal Diameter As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transverse Bar Nominal Diameter As String</em>' attribute.
	 * @see #setTransverseBarNominalDiameterAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcReinforcingMesh_TransverseBarNominalDiameterAsString()
	 * @model
	 * @generated
	 */
	String getTransverseBarNominalDiameterAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcReinforcingMesh#getTransverseBarNominalDiameterAsString <em>Transverse Bar Nominal Diameter As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transverse Bar Nominal Diameter As String</em>' attribute.
	 * @see #getTransverseBarNominalDiameterAsString()
	 * @generated
	 */
	void setTransverseBarNominalDiameterAsString(String value);

	/**
	 * Returns the value of the '<em><b>Longitudinal Bar Cross Section Area</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Longitudinal Bar Cross Section Area</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Longitudinal Bar Cross Section Area</em>' attribute.
	 * @see #setLongitudinalBarCrossSectionArea(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcReinforcingMesh_LongitudinalBarCrossSectionArea()
	 * @model
	 * @generated
	 */
	double getLongitudinalBarCrossSectionArea();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcReinforcingMesh#getLongitudinalBarCrossSectionArea <em>Longitudinal Bar Cross Section Area</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Longitudinal Bar Cross Section Area</em>' attribute.
	 * @see #getLongitudinalBarCrossSectionArea()
	 * @generated
	 */
	void setLongitudinalBarCrossSectionArea(double value);

	/**
	 * Returns the value of the '<em><b>Longitudinal Bar Cross Section Area As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Longitudinal Bar Cross Section Area As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Longitudinal Bar Cross Section Area As String</em>' attribute.
	 * @see #setLongitudinalBarCrossSectionAreaAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcReinforcingMesh_LongitudinalBarCrossSectionAreaAsString()
	 * @model
	 * @generated
	 */
	String getLongitudinalBarCrossSectionAreaAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcReinforcingMesh#getLongitudinalBarCrossSectionAreaAsString <em>Longitudinal Bar Cross Section Area As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Longitudinal Bar Cross Section Area As String</em>' attribute.
	 * @see #getLongitudinalBarCrossSectionAreaAsString()
	 * @generated
	 */
	void setLongitudinalBarCrossSectionAreaAsString(String value);

	/**
	 * Returns the value of the '<em><b>Transverse Bar Cross Section Area</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transverse Bar Cross Section Area</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transverse Bar Cross Section Area</em>' attribute.
	 * @see #setTransverseBarCrossSectionArea(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcReinforcingMesh_TransverseBarCrossSectionArea()
	 * @model
	 * @generated
	 */
	double getTransverseBarCrossSectionArea();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcReinforcingMesh#getTransverseBarCrossSectionArea <em>Transverse Bar Cross Section Area</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transverse Bar Cross Section Area</em>' attribute.
	 * @see #getTransverseBarCrossSectionArea()
	 * @generated
	 */
	void setTransverseBarCrossSectionArea(double value);

	/**
	 * Returns the value of the '<em><b>Transverse Bar Cross Section Area As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transverse Bar Cross Section Area As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transverse Bar Cross Section Area As String</em>' attribute.
	 * @see #setTransverseBarCrossSectionAreaAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcReinforcingMesh_TransverseBarCrossSectionAreaAsString()
	 * @model
	 * @generated
	 */
	String getTransverseBarCrossSectionAreaAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcReinforcingMesh#getTransverseBarCrossSectionAreaAsString <em>Transverse Bar Cross Section Area As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transverse Bar Cross Section Area As String</em>' attribute.
	 * @see #getTransverseBarCrossSectionAreaAsString()
	 * @generated
	 */
	void setTransverseBarCrossSectionAreaAsString(String value);

	/**
	 * Returns the value of the '<em><b>Longitudinal Bar Spacing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Longitudinal Bar Spacing</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Longitudinal Bar Spacing</em>' attribute.
	 * @see #setLongitudinalBarSpacing(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcReinforcingMesh_LongitudinalBarSpacing()
	 * @model
	 * @generated
	 */
	double getLongitudinalBarSpacing();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcReinforcingMesh#getLongitudinalBarSpacing <em>Longitudinal Bar Spacing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Longitudinal Bar Spacing</em>' attribute.
	 * @see #getLongitudinalBarSpacing()
	 * @generated
	 */
	void setLongitudinalBarSpacing(double value);

	/**
	 * Returns the value of the '<em><b>Longitudinal Bar Spacing As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Longitudinal Bar Spacing As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Longitudinal Bar Spacing As String</em>' attribute.
	 * @see #setLongitudinalBarSpacingAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcReinforcingMesh_LongitudinalBarSpacingAsString()
	 * @model
	 * @generated
	 */
	String getLongitudinalBarSpacingAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcReinforcingMesh#getLongitudinalBarSpacingAsString <em>Longitudinal Bar Spacing As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Longitudinal Bar Spacing As String</em>' attribute.
	 * @see #getLongitudinalBarSpacingAsString()
	 * @generated
	 */
	void setLongitudinalBarSpacingAsString(String value);

	/**
	 * Returns the value of the '<em><b>Transverse Bar Spacing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transverse Bar Spacing</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transverse Bar Spacing</em>' attribute.
	 * @see #setTransverseBarSpacing(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcReinforcingMesh_TransverseBarSpacing()
	 * @model
	 * @generated
	 */
	double getTransverseBarSpacing();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcReinforcingMesh#getTransverseBarSpacing <em>Transverse Bar Spacing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transverse Bar Spacing</em>' attribute.
	 * @see #getTransverseBarSpacing()
	 * @generated
	 */
	void setTransverseBarSpacing(double value);

	/**
	 * Returns the value of the '<em><b>Transverse Bar Spacing As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transverse Bar Spacing As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transverse Bar Spacing As String</em>' attribute.
	 * @see #setTransverseBarSpacingAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcReinforcingMesh_TransverseBarSpacingAsString()
	 * @model
	 * @generated
	 */
	String getTransverseBarSpacingAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcReinforcingMesh#getTransverseBarSpacingAsString <em>Transverse Bar Spacing As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transverse Bar Spacing As String</em>' attribute.
	 * @see #getTransverseBarSpacingAsString()
	 * @generated
	 */
	void setTransverseBarSpacingAsString(String value);

} // IfcReinforcingMesh
