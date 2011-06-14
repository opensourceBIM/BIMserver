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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Tendon</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTendon#getPredefinedType <em>Predefined Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTendon#getNominalDiameter <em>Nominal Diameter</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTendon#getNominalDiameterAsString <em>Nominal Diameter As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTendon#getCrossSectionArea <em>Cross Section Area</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTendon#getCrossSectionAreaAsString <em>Cross Section Area As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTendon#getTensionForce <em>Tension Force</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTendon#getTensionForceAsString <em>Tension Force As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTendon#getPreStress <em>Pre Stress</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTendon#getPreStressAsString <em>Pre Stress As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTendon#getFrictionCoefficient <em>Friction Coefficient</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTendon#getFrictionCoefficientAsString <em>Friction Coefficient As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTendon#getAnchorageSlip <em>Anchorage Slip</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTendon#getAnchorageSlipAsString <em>Anchorage Slip As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTendon#getMinCurvatureRadius <em>Min Curvature Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTendon#getMinCurvatureRadiusAsString <em>Min Curvature Radius As String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTendon()
 * @model
 * @generated
 */
public interface IfcTendon extends IfcReinforcingElement
{
	/**
	 * Returns the value of the '<em><b>Predefined Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.IfcTendonTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predefined Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcTendonTypeEnum
	 * @see #setPredefinedType(IfcTendonTypeEnum)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTendon_PredefinedType()
	 * @model
	 * @generated
	 */
	IfcTendonTypeEnum getPredefinedType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTendon#getPredefinedType <em>Predefined Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcTendonTypeEnum
	 * @see #getPredefinedType()
	 * @generated
	 */
	void setPredefinedType(IfcTendonTypeEnum value);

	/**
	 * Returns the value of the '<em><b>Nominal Diameter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nominal Diameter</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nominal Diameter</em>' attribute.
	 * @see #setNominalDiameter(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTendon_NominalDiameter()
	 * @model
	 * @generated
	 */
	float getNominalDiameter();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTendon#getNominalDiameter <em>Nominal Diameter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nominal Diameter</em>' attribute.
	 * @see #getNominalDiameter()
	 * @generated
	 */
	void setNominalDiameter(float value);

	/**
	 * Returns the value of the '<em><b>Nominal Diameter As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nominal Diameter As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nominal Diameter As String</em>' attribute.
	 * @see #setNominalDiameterAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTendon_NominalDiameterAsString()
	 * @model
	 * @generated
	 */
	String getNominalDiameterAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTendon#getNominalDiameterAsString <em>Nominal Diameter As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nominal Diameter As String</em>' attribute.
	 * @see #getNominalDiameterAsString()
	 * @generated
	 */
	void setNominalDiameterAsString(String value);

	/**
	 * Returns the value of the '<em><b>Cross Section Area</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cross Section Area</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cross Section Area</em>' attribute.
	 * @see #setCrossSectionArea(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTendon_CrossSectionArea()
	 * @model
	 * @generated
	 */
	float getCrossSectionArea();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTendon#getCrossSectionArea <em>Cross Section Area</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cross Section Area</em>' attribute.
	 * @see #getCrossSectionArea()
	 * @generated
	 */
	void setCrossSectionArea(float value);

	/**
	 * Returns the value of the '<em><b>Cross Section Area As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cross Section Area As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cross Section Area As String</em>' attribute.
	 * @see #setCrossSectionAreaAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTendon_CrossSectionAreaAsString()
	 * @model
	 * @generated
	 */
	String getCrossSectionAreaAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTendon#getCrossSectionAreaAsString <em>Cross Section Area As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cross Section Area As String</em>' attribute.
	 * @see #getCrossSectionAreaAsString()
	 * @generated
	 */
	void setCrossSectionAreaAsString(String value);

	/**
	 * Returns the value of the '<em><b>Tension Force</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tension Force</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tension Force</em>' attribute.
	 * @see #isSetTensionForce()
	 * @see #unsetTensionForce()
	 * @see #setTensionForce(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTendon_TensionForce()
	 * @model unsettable="true"
	 * @generated
	 */
	float getTensionForce();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTendon#getTensionForce <em>Tension Force</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tension Force</em>' attribute.
	 * @see #isSetTensionForce()
	 * @see #unsetTensionForce()
	 * @see #getTensionForce()
	 * @generated
	 */
	void setTensionForce(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcTendon#getTensionForce <em>Tension Force</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTensionForce()
	 * @see #getTensionForce()
	 * @see #setTensionForce(float)
	 * @generated
	 */
	void unsetTensionForce();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcTendon#getTensionForce <em>Tension Force</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Tension Force</em>' attribute is set.
	 * @see #unsetTensionForce()
	 * @see #getTensionForce()
	 * @see #setTensionForce(float)
	 * @generated
	 */
	boolean isSetTensionForce();

	/**
	 * Returns the value of the '<em><b>Tension Force As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tension Force As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tension Force As String</em>' attribute.
	 * @see #isSetTensionForceAsString()
	 * @see #unsetTensionForceAsString()
	 * @see #setTensionForceAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTendon_TensionForceAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getTensionForceAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTendon#getTensionForceAsString <em>Tension Force As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tension Force As String</em>' attribute.
	 * @see #isSetTensionForceAsString()
	 * @see #unsetTensionForceAsString()
	 * @see #getTensionForceAsString()
	 * @generated
	 */
	void setTensionForceAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcTendon#getTensionForceAsString <em>Tension Force As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTensionForceAsString()
	 * @see #getTensionForceAsString()
	 * @see #setTensionForceAsString(String)
	 * @generated
	 */
	void unsetTensionForceAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcTendon#getTensionForceAsString <em>Tension Force As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Tension Force As String</em>' attribute is set.
	 * @see #unsetTensionForceAsString()
	 * @see #getTensionForceAsString()
	 * @see #setTensionForceAsString(String)
	 * @generated
	 */
	boolean isSetTensionForceAsString();

	/**
	 * Returns the value of the '<em><b>Pre Stress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pre Stress</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pre Stress</em>' attribute.
	 * @see #isSetPreStress()
	 * @see #unsetPreStress()
	 * @see #setPreStress(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTendon_PreStress()
	 * @model unsettable="true"
	 * @generated
	 */
	float getPreStress();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTendon#getPreStress <em>Pre Stress</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pre Stress</em>' attribute.
	 * @see #isSetPreStress()
	 * @see #unsetPreStress()
	 * @see #getPreStress()
	 * @generated
	 */
	void setPreStress(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcTendon#getPreStress <em>Pre Stress</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPreStress()
	 * @see #getPreStress()
	 * @see #setPreStress(float)
	 * @generated
	 */
	void unsetPreStress();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcTendon#getPreStress <em>Pre Stress</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Pre Stress</em>' attribute is set.
	 * @see #unsetPreStress()
	 * @see #getPreStress()
	 * @see #setPreStress(float)
	 * @generated
	 */
	boolean isSetPreStress();

	/**
	 * Returns the value of the '<em><b>Pre Stress As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pre Stress As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pre Stress As String</em>' attribute.
	 * @see #isSetPreStressAsString()
	 * @see #unsetPreStressAsString()
	 * @see #setPreStressAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTendon_PreStressAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getPreStressAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTendon#getPreStressAsString <em>Pre Stress As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pre Stress As String</em>' attribute.
	 * @see #isSetPreStressAsString()
	 * @see #unsetPreStressAsString()
	 * @see #getPreStressAsString()
	 * @generated
	 */
	void setPreStressAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcTendon#getPreStressAsString <em>Pre Stress As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPreStressAsString()
	 * @see #getPreStressAsString()
	 * @see #setPreStressAsString(String)
	 * @generated
	 */
	void unsetPreStressAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcTendon#getPreStressAsString <em>Pre Stress As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Pre Stress As String</em>' attribute is set.
	 * @see #unsetPreStressAsString()
	 * @see #getPreStressAsString()
	 * @see #setPreStressAsString(String)
	 * @generated
	 */
	boolean isSetPreStressAsString();

	/**
	 * Returns the value of the '<em><b>Friction Coefficient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Friction Coefficient</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Friction Coefficient</em>' attribute.
	 * @see #isSetFrictionCoefficient()
	 * @see #unsetFrictionCoefficient()
	 * @see #setFrictionCoefficient(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTendon_FrictionCoefficient()
	 * @model unsettable="true"
	 * @generated
	 */
	float getFrictionCoefficient();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTendon#getFrictionCoefficient <em>Friction Coefficient</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Friction Coefficient</em>' attribute.
	 * @see #isSetFrictionCoefficient()
	 * @see #unsetFrictionCoefficient()
	 * @see #getFrictionCoefficient()
	 * @generated
	 */
	void setFrictionCoefficient(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcTendon#getFrictionCoefficient <em>Friction Coefficient</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFrictionCoefficient()
	 * @see #getFrictionCoefficient()
	 * @see #setFrictionCoefficient(float)
	 * @generated
	 */
	void unsetFrictionCoefficient();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcTendon#getFrictionCoefficient <em>Friction Coefficient</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Friction Coefficient</em>' attribute is set.
	 * @see #unsetFrictionCoefficient()
	 * @see #getFrictionCoefficient()
	 * @see #setFrictionCoefficient(float)
	 * @generated
	 */
	boolean isSetFrictionCoefficient();

	/**
	 * Returns the value of the '<em><b>Friction Coefficient As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Friction Coefficient As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Friction Coefficient As String</em>' attribute.
	 * @see #isSetFrictionCoefficientAsString()
	 * @see #unsetFrictionCoefficientAsString()
	 * @see #setFrictionCoefficientAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTendon_FrictionCoefficientAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getFrictionCoefficientAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTendon#getFrictionCoefficientAsString <em>Friction Coefficient As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Friction Coefficient As String</em>' attribute.
	 * @see #isSetFrictionCoefficientAsString()
	 * @see #unsetFrictionCoefficientAsString()
	 * @see #getFrictionCoefficientAsString()
	 * @generated
	 */
	void setFrictionCoefficientAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcTendon#getFrictionCoefficientAsString <em>Friction Coefficient As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFrictionCoefficientAsString()
	 * @see #getFrictionCoefficientAsString()
	 * @see #setFrictionCoefficientAsString(String)
	 * @generated
	 */
	void unsetFrictionCoefficientAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcTendon#getFrictionCoefficientAsString <em>Friction Coefficient As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Friction Coefficient As String</em>' attribute is set.
	 * @see #unsetFrictionCoefficientAsString()
	 * @see #getFrictionCoefficientAsString()
	 * @see #setFrictionCoefficientAsString(String)
	 * @generated
	 */
	boolean isSetFrictionCoefficientAsString();

	/**
	 * Returns the value of the '<em><b>Anchorage Slip</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Anchorage Slip</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Anchorage Slip</em>' attribute.
	 * @see #isSetAnchorageSlip()
	 * @see #unsetAnchorageSlip()
	 * @see #setAnchorageSlip(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTendon_AnchorageSlip()
	 * @model unsettable="true"
	 * @generated
	 */
	float getAnchorageSlip();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTendon#getAnchorageSlip <em>Anchorage Slip</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Anchorage Slip</em>' attribute.
	 * @see #isSetAnchorageSlip()
	 * @see #unsetAnchorageSlip()
	 * @see #getAnchorageSlip()
	 * @generated
	 */
	void setAnchorageSlip(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcTendon#getAnchorageSlip <em>Anchorage Slip</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetAnchorageSlip()
	 * @see #getAnchorageSlip()
	 * @see #setAnchorageSlip(float)
	 * @generated
	 */
	void unsetAnchorageSlip();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcTendon#getAnchorageSlip <em>Anchorage Slip</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Anchorage Slip</em>' attribute is set.
	 * @see #unsetAnchorageSlip()
	 * @see #getAnchorageSlip()
	 * @see #setAnchorageSlip(float)
	 * @generated
	 */
	boolean isSetAnchorageSlip();

	/**
	 * Returns the value of the '<em><b>Anchorage Slip As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Anchorage Slip As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Anchorage Slip As String</em>' attribute.
	 * @see #isSetAnchorageSlipAsString()
	 * @see #unsetAnchorageSlipAsString()
	 * @see #setAnchorageSlipAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTendon_AnchorageSlipAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getAnchorageSlipAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTendon#getAnchorageSlipAsString <em>Anchorage Slip As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Anchorage Slip As String</em>' attribute.
	 * @see #isSetAnchorageSlipAsString()
	 * @see #unsetAnchorageSlipAsString()
	 * @see #getAnchorageSlipAsString()
	 * @generated
	 */
	void setAnchorageSlipAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcTendon#getAnchorageSlipAsString <em>Anchorage Slip As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetAnchorageSlipAsString()
	 * @see #getAnchorageSlipAsString()
	 * @see #setAnchorageSlipAsString(String)
	 * @generated
	 */
	void unsetAnchorageSlipAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcTendon#getAnchorageSlipAsString <em>Anchorage Slip As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Anchorage Slip As String</em>' attribute is set.
	 * @see #unsetAnchorageSlipAsString()
	 * @see #getAnchorageSlipAsString()
	 * @see #setAnchorageSlipAsString(String)
	 * @generated
	 */
	boolean isSetAnchorageSlipAsString();

	/**
	 * Returns the value of the '<em><b>Min Curvature Radius</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Curvature Radius</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Curvature Radius</em>' attribute.
	 * @see #isSetMinCurvatureRadius()
	 * @see #unsetMinCurvatureRadius()
	 * @see #setMinCurvatureRadius(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTendon_MinCurvatureRadius()
	 * @model unsettable="true"
	 * @generated
	 */
	float getMinCurvatureRadius();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTendon#getMinCurvatureRadius <em>Min Curvature Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Curvature Radius</em>' attribute.
	 * @see #isSetMinCurvatureRadius()
	 * @see #unsetMinCurvatureRadius()
	 * @see #getMinCurvatureRadius()
	 * @generated
	 */
	void setMinCurvatureRadius(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcTendon#getMinCurvatureRadius <em>Min Curvature Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMinCurvatureRadius()
	 * @see #getMinCurvatureRadius()
	 * @see #setMinCurvatureRadius(float)
	 * @generated
	 */
	void unsetMinCurvatureRadius();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcTendon#getMinCurvatureRadius <em>Min Curvature Radius</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Min Curvature Radius</em>' attribute is set.
	 * @see #unsetMinCurvatureRadius()
	 * @see #getMinCurvatureRadius()
	 * @see #setMinCurvatureRadius(float)
	 * @generated
	 */
	boolean isSetMinCurvatureRadius();

	/**
	 * Returns the value of the '<em><b>Min Curvature Radius As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Curvature Radius As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Curvature Radius As String</em>' attribute.
	 * @see #isSetMinCurvatureRadiusAsString()
	 * @see #unsetMinCurvatureRadiusAsString()
	 * @see #setMinCurvatureRadiusAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTendon_MinCurvatureRadiusAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getMinCurvatureRadiusAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTendon#getMinCurvatureRadiusAsString <em>Min Curvature Radius As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Curvature Radius As String</em>' attribute.
	 * @see #isSetMinCurvatureRadiusAsString()
	 * @see #unsetMinCurvatureRadiusAsString()
	 * @see #getMinCurvatureRadiusAsString()
	 * @generated
	 */
	void setMinCurvatureRadiusAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcTendon#getMinCurvatureRadiusAsString <em>Min Curvature Radius As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMinCurvatureRadiusAsString()
	 * @see #getMinCurvatureRadiusAsString()
	 * @see #setMinCurvatureRadiusAsString(String)
	 * @generated
	 */
	void unsetMinCurvatureRadiusAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcTendon#getMinCurvatureRadiusAsString <em>Min Curvature Radius As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Min Curvature Radius As String</em>' attribute is set.
	 * @see #unsetMinCurvatureRadiusAsString()
	 * @see #getMinCurvatureRadiusAsString()
	 * @see #setMinCurvatureRadiusAsString(String)
	 * @generated
	 */
	boolean isSetMinCurvatureRadiusAsString();

} // IfcTendon
