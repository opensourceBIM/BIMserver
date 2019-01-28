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

import org.bimserver.emf.IdEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Reinforcement Bar Properties</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcReinforcementBarProperties#getTotalCrossSectionArea <em>Total Cross Section Area</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcReinforcementBarProperties#getTotalCrossSectionAreaAsString <em>Total Cross Section Area As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcReinforcementBarProperties#getSteelGrade <em>Steel Grade</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcReinforcementBarProperties#getBarSurface <em>Bar Surface</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcReinforcementBarProperties#getEffectiveDepth <em>Effective Depth</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcReinforcementBarProperties#getEffectiveDepthAsString <em>Effective Depth As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcReinforcementBarProperties#getNominalBarDiameter <em>Nominal Bar Diameter</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcReinforcementBarProperties#getNominalBarDiameterAsString <em>Nominal Bar Diameter As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcReinforcementBarProperties#getBarCount <em>Bar Count</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcReinforcementBarProperties#getBarCountAsString <em>Bar Count As String</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcReinforcementBarProperties()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface IfcReinforcementBarProperties extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Total Cross Section Area</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Total Cross Section Area</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total Cross Section Area</em>' attribute.
	 * @see #setTotalCrossSectionArea(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcReinforcementBarProperties_TotalCrossSectionArea()
	 * @model
	 * @generated
	 */
	double getTotalCrossSectionArea();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcReinforcementBarProperties#getTotalCrossSectionArea <em>Total Cross Section Area</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Cross Section Area</em>' attribute.
	 * @see #getTotalCrossSectionArea()
	 * @generated
	 */
	void setTotalCrossSectionArea(double value);

	/**
	 * Returns the value of the '<em><b>Total Cross Section Area As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Total Cross Section Area As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total Cross Section Area As String</em>' attribute.
	 * @see #setTotalCrossSectionAreaAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcReinforcementBarProperties_TotalCrossSectionAreaAsString()
	 * @model
	 * @generated
	 */
	String getTotalCrossSectionAreaAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcReinforcementBarProperties#getTotalCrossSectionAreaAsString <em>Total Cross Section Area As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Cross Section Area As String</em>' attribute.
	 * @see #getTotalCrossSectionAreaAsString()
	 * @generated
	 */
	void setTotalCrossSectionAreaAsString(String value);

	/**
	 * Returns the value of the '<em><b>Steel Grade</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Steel Grade</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Steel Grade</em>' attribute.
	 * @see #setSteelGrade(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcReinforcementBarProperties_SteelGrade()
	 * @model
	 * @generated
	 */
	String getSteelGrade();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcReinforcementBarProperties#getSteelGrade <em>Steel Grade</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Steel Grade</em>' attribute.
	 * @see #getSteelGrade()
	 * @generated
	 */
	void setSteelGrade(String value);

	/**
	 * Returns the value of the '<em><b>Bar Surface</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3tc1.IfcReinforcingBarSurfaceEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bar Surface</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bar Surface</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.IfcReinforcingBarSurfaceEnum
	 * @see #isSetBarSurface()
	 * @see #unsetBarSurface()
	 * @see #setBarSurface(IfcReinforcingBarSurfaceEnum)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcReinforcementBarProperties_BarSurface()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcReinforcingBarSurfaceEnum getBarSurface();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcReinforcementBarProperties#getBarSurface <em>Bar Surface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bar Surface</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.IfcReinforcingBarSurfaceEnum
	 * @see #isSetBarSurface()
	 * @see #unsetBarSurface()
	 * @see #getBarSurface()
	 * @generated
	 */
	void setBarSurface(IfcReinforcingBarSurfaceEnum value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcReinforcementBarProperties#getBarSurface <em>Bar Surface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBarSurface()
	 * @see #getBarSurface()
	 * @see #setBarSurface(IfcReinforcingBarSurfaceEnum)
	 * @generated
	 */
	void unsetBarSurface();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcReinforcementBarProperties#getBarSurface <em>Bar Surface</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Bar Surface</em>' attribute is set.
	 * @see #unsetBarSurface()
	 * @see #getBarSurface()
	 * @see #setBarSurface(IfcReinforcingBarSurfaceEnum)
	 * @generated
	 */
	boolean isSetBarSurface();

	/**
	 * Returns the value of the '<em><b>Effective Depth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Effective Depth</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Effective Depth</em>' attribute.
	 * @see #isSetEffectiveDepth()
	 * @see #unsetEffectiveDepth()
	 * @see #setEffectiveDepth(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcReinforcementBarProperties_EffectiveDepth()
	 * @model unsettable="true"
	 * @generated
	 */
	double getEffectiveDepth();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcReinforcementBarProperties#getEffectiveDepth <em>Effective Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Effective Depth</em>' attribute.
	 * @see #isSetEffectiveDepth()
	 * @see #unsetEffectiveDepth()
	 * @see #getEffectiveDepth()
	 * @generated
	 */
	void setEffectiveDepth(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcReinforcementBarProperties#getEffectiveDepth <em>Effective Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetEffectiveDepth()
	 * @see #getEffectiveDepth()
	 * @see #setEffectiveDepth(double)
	 * @generated
	 */
	void unsetEffectiveDepth();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcReinforcementBarProperties#getEffectiveDepth <em>Effective Depth</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Effective Depth</em>' attribute is set.
	 * @see #unsetEffectiveDepth()
	 * @see #getEffectiveDepth()
	 * @see #setEffectiveDepth(double)
	 * @generated
	 */
	boolean isSetEffectiveDepth();

	/**
	 * Returns the value of the '<em><b>Effective Depth As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Effective Depth As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Effective Depth As String</em>' attribute.
	 * @see #isSetEffectiveDepthAsString()
	 * @see #unsetEffectiveDepthAsString()
	 * @see #setEffectiveDepthAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcReinforcementBarProperties_EffectiveDepthAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getEffectiveDepthAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcReinforcementBarProperties#getEffectiveDepthAsString <em>Effective Depth As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Effective Depth As String</em>' attribute.
	 * @see #isSetEffectiveDepthAsString()
	 * @see #unsetEffectiveDepthAsString()
	 * @see #getEffectiveDepthAsString()
	 * @generated
	 */
	void setEffectiveDepthAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcReinforcementBarProperties#getEffectiveDepthAsString <em>Effective Depth As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetEffectiveDepthAsString()
	 * @see #getEffectiveDepthAsString()
	 * @see #setEffectiveDepthAsString(String)
	 * @generated
	 */
	void unsetEffectiveDepthAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcReinforcementBarProperties#getEffectiveDepthAsString <em>Effective Depth As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Effective Depth As String</em>' attribute is set.
	 * @see #unsetEffectiveDepthAsString()
	 * @see #getEffectiveDepthAsString()
	 * @see #setEffectiveDepthAsString(String)
	 * @generated
	 */
	boolean isSetEffectiveDepthAsString();

	/**
	 * Returns the value of the '<em><b>Nominal Bar Diameter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nominal Bar Diameter</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nominal Bar Diameter</em>' attribute.
	 * @see #isSetNominalBarDiameter()
	 * @see #unsetNominalBarDiameter()
	 * @see #setNominalBarDiameter(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcReinforcementBarProperties_NominalBarDiameter()
	 * @model unsettable="true"
	 * @generated
	 */
	double getNominalBarDiameter();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcReinforcementBarProperties#getNominalBarDiameter <em>Nominal Bar Diameter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nominal Bar Diameter</em>' attribute.
	 * @see #isSetNominalBarDiameter()
	 * @see #unsetNominalBarDiameter()
	 * @see #getNominalBarDiameter()
	 * @generated
	 */
	void setNominalBarDiameter(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcReinforcementBarProperties#getNominalBarDiameter <em>Nominal Bar Diameter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetNominalBarDiameter()
	 * @see #getNominalBarDiameter()
	 * @see #setNominalBarDiameter(double)
	 * @generated
	 */
	void unsetNominalBarDiameter();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcReinforcementBarProperties#getNominalBarDiameter <em>Nominal Bar Diameter</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Nominal Bar Diameter</em>' attribute is set.
	 * @see #unsetNominalBarDiameter()
	 * @see #getNominalBarDiameter()
	 * @see #setNominalBarDiameter(double)
	 * @generated
	 */
	boolean isSetNominalBarDiameter();

	/**
	 * Returns the value of the '<em><b>Nominal Bar Diameter As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nominal Bar Diameter As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nominal Bar Diameter As String</em>' attribute.
	 * @see #isSetNominalBarDiameterAsString()
	 * @see #unsetNominalBarDiameterAsString()
	 * @see #setNominalBarDiameterAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcReinforcementBarProperties_NominalBarDiameterAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getNominalBarDiameterAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcReinforcementBarProperties#getNominalBarDiameterAsString <em>Nominal Bar Diameter As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nominal Bar Diameter As String</em>' attribute.
	 * @see #isSetNominalBarDiameterAsString()
	 * @see #unsetNominalBarDiameterAsString()
	 * @see #getNominalBarDiameterAsString()
	 * @generated
	 */
	void setNominalBarDiameterAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcReinforcementBarProperties#getNominalBarDiameterAsString <em>Nominal Bar Diameter As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetNominalBarDiameterAsString()
	 * @see #getNominalBarDiameterAsString()
	 * @see #setNominalBarDiameterAsString(String)
	 * @generated
	 */
	void unsetNominalBarDiameterAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcReinforcementBarProperties#getNominalBarDiameterAsString <em>Nominal Bar Diameter As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Nominal Bar Diameter As String</em>' attribute is set.
	 * @see #unsetNominalBarDiameterAsString()
	 * @see #getNominalBarDiameterAsString()
	 * @see #setNominalBarDiameterAsString(String)
	 * @generated
	 */
	boolean isSetNominalBarDiameterAsString();

	/**
	 * Returns the value of the '<em><b>Bar Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bar Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bar Count</em>' attribute.
	 * @see #isSetBarCount()
	 * @see #unsetBarCount()
	 * @see #setBarCount(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcReinforcementBarProperties_BarCount()
	 * @model unsettable="true"
	 * @generated
	 */
	double getBarCount();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcReinforcementBarProperties#getBarCount <em>Bar Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bar Count</em>' attribute.
	 * @see #isSetBarCount()
	 * @see #unsetBarCount()
	 * @see #getBarCount()
	 * @generated
	 */
	void setBarCount(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcReinforcementBarProperties#getBarCount <em>Bar Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBarCount()
	 * @see #getBarCount()
	 * @see #setBarCount(double)
	 * @generated
	 */
	void unsetBarCount();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcReinforcementBarProperties#getBarCount <em>Bar Count</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Bar Count</em>' attribute is set.
	 * @see #unsetBarCount()
	 * @see #getBarCount()
	 * @see #setBarCount(double)
	 * @generated
	 */
	boolean isSetBarCount();

	/**
	 * Returns the value of the '<em><b>Bar Count As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bar Count As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bar Count As String</em>' attribute.
	 * @see #isSetBarCountAsString()
	 * @see #unsetBarCountAsString()
	 * @see #setBarCountAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcReinforcementBarProperties_BarCountAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getBarCountAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcReinforcementBarProperties#getBarCountAsString <em>Bar Count As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bar Count As String</em>' attribute.
	 * @see #isSetBarCountAsString()
	 * @see #unsetBarCountAsString()
	 * @see #getBarCountAsString()
	 * @generated
	 */
	void setBarCountAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcReinforcementBarProperties#getBarCountAsString <em>Bar Count As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBarCountAsString()
	 * @see #getBarCountAsString()
	 * @see #setBarCountAsString(String)
	 * @generated
	 */
	void unsetBarCountAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcReinforcementBarProperties#getBarCountAsString <em>Bar Count As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Bar Count As String</em>' attribute is set.
	 * @see #unsetBarCountAsString()
	 * @see #getBarCountAsString()
	 * @see #setBarCountAsString(String)
	 * @generated
	 */
	boolean isSetBarCountAsString();

} // IfcReinforcementBarProperties
