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
 * A representation of the model object '<em><b>Ifc Reinforcing Bar Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcReinforcingBarType#getPredefinedType <em>Predefined Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcReinforcingBarType#getNominalDiameter <em>Nominal Diameter</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcReinforcingBarType#getNominalDiameterAsString <em>Nominal Diameter As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcReinforcingBarType#getCrossSectionArea <em>Cross Section Area</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcReinforcingBarType#getCrossSectionAreaAsString <em>Cross Section Area As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcReinforcingBarType#getBarLength <em>Bar Length</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcReinforcingBarType#getBarLengthAsString <em>Bar Length As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcReinforcingBarType#getBarSurface <em>Bar Surface</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcReinforcingBarType#getBendingShapeCode <em>Bending Shape Code</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcReinforcingBarType#getBendingParameters <em>Bending Parameters</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcReinforcingBarType()
 * @model
 * @generated
 */
public interface IfcReinforcingBarType extends IfcReinforcingElementType {
	/**
	 * Returns the value of the '<em><b>Predefined Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.IfcReinforcingBarTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predefined Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcReinforcingBarTypeEnum
	 * @see #setPredefinedType(IfcReinforcingBarTypeEnum)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcReinforcingBarType_PredefinedType()
	 * @model
	 * @generated
	 */
	IfcReinforcingBarTypeEnum getPredefinedType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingBarType#getPredefinedType <em>Predefined Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcReinforcingBarTypeEnum
	 * @see #getPredefinedType()
	 * @generated
	 */
	void setPredefinedType(IfcReinforcingBarTypeEnum value);

	/**
	 * Returns the value of the '<em><b>Nominal Diameter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nominal Diameter</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nominal Diameter</em>' attribute.
	 * @see #isSetNominalDiameter()
	 * @see #unsetNominalDiameter()
	 * @see #setNominalDiameter(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcReinforcingBarType_NominalDiameter()
	 * @model unsettable="true"
	 * @generated
	 */
	double getNominalDiameter();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingBarType#getNominalDiameter <em>Nominal Diameter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nominal Diameter</em>' attribute.
	 * @see #isSetNominalDiameter()
	 * @see #unsetNominalDiameter()
	 * @see #getNominalDiameter()
	 * @generated
	 */
	void setNominalDiameter(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingBarType#getNominalDiameter <em>Nominal Diameter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetNominalDiameter()
	 * @see #getNominalDiameter()
	 * @see #setNominalDiameter(double)
	 * @generated
	 */
	void unsetNominalDiameter();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingBarType#getNominalDiameter <em>Nominal Diameter</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Nominal Diameter</em>' attribute is set.
	 * @see #unsetNominalDiameter()
	 * @see #getNominalDiameter()
	 * @see #setNominalDiameter(double)
	 * @generated
	 */
	boolean isSetNominalDiameter();

	/**
	 * Returns the value of the '<em><b>Nominal Diameter As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nominal Diameter As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nominal Diameter As String</em>' attribute.
	 * @see #isSetNominalDiameterAsString()
	 * @see #unsetNominalDiameterAsString()
	 * @see #setNominalDiameterAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcReinforcingBarType_NominalDiameterAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getNominalDiameterAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingBarType#getNominalDiameterAsString <em>Nominal Diameter As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nominal Diameter As String</em>' attribute.
	 * @see #isSetNominalDiameterAsString()
	 * @see #unsetNominalDiameterAsString()
	 * @see #getNominalDiameterAsString()
	 * @generated
	 */
	void setNominalDiameterAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingBarType#getNominalDiameterAsString <em>Nominal Diameter As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetNominalDiameterAsString()
	 * @see #getNominalDiameterAsString()
	 * @see #setNominalDiameterAsString(String)
	 * @generated
	 */
	void unsetNominalDiameterAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingBarType#getNominalDiameterAsString <em>Nominal Diameter As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Nominal Diameter As String</em>' attribute is set.
	 * @see #unsetNominalDiameterAsString()
	 * @see #getNominalDiameterAsString()
	 * @see #setNominalDiameterAsString(String)
	 * @generated
	 */
	boolean isSetNominalDiameterAsString();

	/**
	 * Returns the value of the '<em><b>Cross Section Area</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cross Section Area</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cross Section Area</em>' attribute.
	 * @see #isSetCrossSectionArea()
	 * @see #unsetCrossSectionArea()
	 * @see #setCrossSectionArea(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcReinforcingBarType_CrossSectionArea()
	 * @model unsettable="true"
	 * @generated
	 */
	double getCrossSectionArea();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingBarType#getCrossSectionArea <em>Cross Section Area</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cross Section Area</em>' attribute.
	 * @see #isSetCrossSectionArea()
	 * @see #unsetCrossSectionArea()
	 * @see #getCrossSectionArea()
	 * @generated
	 */
	void setCrossSectionArea(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingBarType#getCrossSectionArea <em>Cross Section Area</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCrossSectionArea()
	 * @see #getCrossSectionArea()
	 * @see #setCrossSectionArea(double)
	 * @generated
	 */
	void unsetCrossSectionArea();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingBarType#getCrossSectionArea <em>Cross Section Area</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Cross Section Area</em>' attribute is set.
	 * @see #unsetCrossSectionArea()
	 * @see #getCrossSectionArea()
	 * @see #setCrossSectionArea(double)
	 * @generated
	 */
	boolean isSetCrossSectionArea();

	/**
	 * Returns the value of the '<em><b>Cross Section Area As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cross Section Area As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cross Section Area As String</em>' attribute.
	 * @see #isSetCrossSectionAreaAsString()
	 * @see #unsetCrossSectionAreaAsString()
	 * @see #setCrossSectionAreaAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcReinforcingBarType_CrossSectionAreaAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getCrossSectionAreaAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingBarType#getCrossSectionAreaAsString <em>Cross Section Area As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cross Section Area As String</em>' attribute.
	 * @see #isSetCrossSectionAreaAsString()
	 * @see #unsetCrossSectionAreaAsString()
	 * @see #getCrossSectionAreaAsString()
	 * @generated
	 */
	void setCrossSectionAreaAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingBarType#getCrossSectionAreaAsString <em>Cross Section Area As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCrossSectionAreaAsString()
	 * @see #getCrossSectionAreaAsString()
	 * @see #setCrossSectionAreaAsString(String)
	 * @generated
	 */
	void unsetCrossSectionAreaAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingBarType#getCrossSectionAreaAsString <em>Cross Section Area As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Cross Section Area As String</em>' attribute is set.
	 * @see #unsetCrossSectionAreaAsString()
	 * @see #getCrossSectionAreaAsString()
	 * @see #setCrossSectionAreaAsString(String)
	 * @generated
	 */
	boolean isSetCrossSectionAreaAsString();

	/**
	 * Returns the value of the '<em><b>Bar Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bar Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bar Length</em>' attribute.
	 * @see #isSetBarLength()
	 * @see #unsetBarLength()
	 * @see #setBarLength(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcReinforcingBarType_BarLength()
	 * @model unsettable="true"
	 * @generated
	 */
	double getBarLength();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingBarType#getBarLength <em>Bar Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bar Length</em>' attribute.
	 * @see #isSetBarLength()
	 * @see #unsetBarLength()
	 * @see #getBarLength()
	 * @generated
	 */
	void setBarLength(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingBarType#getBarLength <em>Bar Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBarLength()
	 * @see #getBarLength()
	 * @see #setBarLength(double)
	 * @generated
	 */
	void unsetBarLength();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingBarType#getBarLength <em>Bar Length</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Bar Length</em>' attribute is set.
	 * @see #unsetBarLength()
	 * @see #getBarLength()
	 * @see #setBarLength(double)
	 * @generated
	 */
	boolean isSetBarLength();

	/**
	 * Returns the value of the '<em><b>Bar Length As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bar Length As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bar Length As String</em>' attribute.
	 * @see #isSetBarLengthAsString()
	 * @see #unsetBarLengthAsString()
	 * @see #setBarLengthAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcReinforcingBarType_BarLengthAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getBarLengthAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingBarType#getBarLengthAsString <em>Bar Length As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bar Length As String</em>' attribute.
	 * @see #isSetBarLengthAsString()
	 * @see #unsetBarLengthAsString()
	 * @see #getBarLengthAsString()
	 * @generated
	 */
	void setBarLengthAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingBarType#getBarLengthAsString <em>Bar Length As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBarLengthAsString()
	 * @see #getBarLengthAsString()
	 * @see #setBarLengthAsString(String)
	 * @generated
	 */
	void unsetBarLengthAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingBarType#getBarLengthAsString <em>Bar Length As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Bar Length As String</em>' attribute is set.
	 * @see #unsetBarLengthAsString()
	 * @see #getBarLengthAsString()
	 * @see #setBarLengthAsString(String)
	 * @generated
	 */
	boolean isSetBarLengthAsString();

	/**
	 * Returns the value of the '<em><b>Bar Surface</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.IfcReinforcingBarSurfaceEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bar Surface</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bar Surface</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcReinforcingBarSurfaceEnum
	 * @see #isSetBarSurface()
	 * @see #unsetBarSurface()
	 * @see #setBarSurface(IfcReinforcingBarSurfaceEnum)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcReinforcingBarType_BarSurface()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcReinforcingBarSurfaceEnum getBarSurface();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingBarType#getBarSurface <em>Bar Surface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bar Surface</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcReinforcingBarSurfaceEnum
	 * @see #isSetBarSurface()
	 * @see #unsetBarSurface()
	 * @see #getBarSurface()
	 * @generated
	 */
	void setBarSurface(IfcReinforcingBarSurfaceEnum value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingBarType#getBarSurface <em>Bar Surface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBarSurface()
	 * @see #getBarSurface()
	 * @see #setBarSurface(IfcReinforcingBarSurfaceEnum)
	 * @generated
	 */
	void unsetBarSurface();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingBarType#getBarSurface <em>Bar Surface</em>}' attribute is set.
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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcReinforcingBarType_BendingShapeCode()
	 * @model unsettable="true"
	 * @generated
	 */
	String getBendingShapeCode();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingBarType#getBendingShapeCode <em>Bending Shape Code</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingBarType#getBendingShapeCode <em>Bending Shape Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBendingShapeCode()
	 * @see #getBendingShapeCode()
	 * @see #setBendingShapeCode(String)
	 * @generated
	 */
	void unsetBendingShapeCode();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingBarType#getBendingShapeCode <em>Bending Shape Code</em>}' attribute is set.
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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcReinforcingBarType_BendingParameters()
	 * @model unsettable="true"
	 * @generated
	 */
	EList<IfcBendingParameterSelect> getBendingParameters();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingBarType#getBendingParameters <em>Bending Parameters</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBendingParameters()
	 * @see #getBendingParameters()
	 * @generated
	 */
	void unsetBendingParameters();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingBarType#getBendingParameters <em>Bending Parameters</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Bending Parameters</em>' reference list is set.
	 * @see #unsetBendingParameters()
	 * @see #getBendingParameters()
	 * @generated
	 */
	boolean isSetBendingParameters();

} // IfcReinforcingBarType
