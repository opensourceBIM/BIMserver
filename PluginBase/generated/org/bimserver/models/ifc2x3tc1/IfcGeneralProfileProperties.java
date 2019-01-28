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

public interface IfcGeneralProfileProperties extends IfcProfileProperties {
	/**
	 * Returns the value of the '<em><b>Physical Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Physical Weight</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Physical Weight</em>' attribute.
	 * @see #isSetPhysicalWeight()
	 * @see #unsetPhysicalWeight()
	 * @see #setPhysicalWeight(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcGeneralProfileProperties_PhysicalWeight()
	 * @model unsettable="true"
	 * @generated
	 */
	double getPhysicalWeight();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcGeneralProfileProperties#getPhysicalWeight <em>Physical Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Physical Weight</em>' attribute.
	 * @see #isSetPhysicalWeight()
	 * @see #unsetPhysicalWeight()
	 * @see #getPhysicalWeight()
	 * @generated
	 */
	void setPhysicalWeight(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcGeneralProfileProperties#getPhysicalWeight <em>Physical Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPhysicalWeight()
	 * @see #getPhysicalWeight()
	 * @see #setPhysicalWeight(double)
	 * @generated
	 */
	void unsetPhysicalWeight();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcGeneralProfileProperties#getPhysicalWeight <em>Physical Weight</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Physical Weight</em>' attribute is set.
	 * @see #unsetPhysicalWeight()
	 * @see #getPhysicalWeight()
	 * @see #setPhysicalWeight(double)
	 * @generated
	 */
	boolean isSetPhysicalWeight();

	/**
	 * Returns the value of the '<em><b>Physical Weight As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Physical Weight As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Physical Weight As String</em>' attribute.
	 * @see #isSetPhysicalWeightAsString()
	 * @see #unsetPhysicalWeightAsString()
	 * @see #setPhysicalWeightAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcGeneralProfileProperties_PhysicalWeightAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getPhysicalWeightAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcGeneralProfileProperties#getPhysicalWeightAsString <em>Physical Weight As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Physical Weight As String</em>' attribute.
	 * @see #isSetPhysicalWeightAsString()
	 * @see #unsetPhysicalWeightAsString()
	 * @see #getPhysicalWeightAsString()
	 * @generated
	 */
	void setPhysicalWeightAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcGeneralProfileProperties#getPhysicalWeightAsString <em>Physical Weight As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPhysicalWeightAsString()
	 * @see #getPhysicalWeightAsString()
	 * @see #setPhysicalWeightAsString(String)
	 * @generated
	 */
	void unsetPhysicalWeightAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcGeneralProfileProperties#getPhysicalWeightAsString <em>Physical Weight As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Physical Weight As String</em>' attribute is set.
	 * @see #unsetPhysicalWeightAsString()
	 * @see #getPhysicalWeightAsString()
	 * @see #setPhysicalWeightAsString(String)
	 * @generated
	 */
	boolean isSetPhysicalWeightAsString();

	/**
	 * Returns the value of the '<em><b>Perimeter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Perimeter</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Perimeter</em>' attribute.
	 * @see #isSetPerimeter()
	 * @see #unsetPerimeter()
	 * @see #setPerimeter(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcGeneralProfileProperties_Perimeter()
	 * @model unsettable="true"
	 * @generated
	 */
	double getPerimeter();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcGeneralProfileProperties#getPerimeter <em>Perimeter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Perimeter</em>' attribute.
	 * @see #isSetPerimeter()
	 * @see #unsetPerimeter()
	 * @see #getPerimeter()
	 * @generated
	 */
	void setPerimeter(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcGeneralProfileProperties#getPerimeter <em>Perimeter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPerimeter()
	 * @see #getPerimeter()
	 * @see #setPerimeter(double)
	 * @generated
	 */
	void unsetPerimeter();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcGeneralProfileProperties#getPerimeter <em>Perimeter</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Perimeter</em>' attribute is set.
	 * @see #unsetPerimeter()
	 * @see #getPerimeter()
	 * @see #setPerimeter(double)
	 * @generated
	 */
	boolean isSetPerimeter();

	/**
	 * Returns the value of the '<em><b>Perimeter As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Perimeter As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Perimeter As String</em>' attribute.
	 * @see #isSetPerimeterAsString()
	 * @see #unsetPerimeterAsString()
	 * @see #setPerimeterAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcGeneralProfileProperties_PerimeterAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getPerimeterAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcGeneralProfileProperties#getPerimeterAsString <em>Perimeter As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Perimeter As String</em>' attribute.
	 * @see #isSetPerimeterAsString()
	 * @see #unsetPerimeterAsString()
	 * @see #getPerimeterAsString()
	 * @generated
	 */
	void setPerimeterAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcGeneralProfileProperties#getPerimeterAsString <em>Perimeter As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPerimeterAsString()
	 * @see #getPerimeterAsString()
	 * @see #setPerimeterAsString(String)
	 * @generated
	 */
	void unsetPerimeterAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcGeneralProfileProperties#getPerimeterAsString <em>Perimeter As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Perimeter As String</em>' attribute is set.
	 * @see #unsetPerimeterAsString()
	 * @see #getPerimeterAsString()
	 * @see #setPerimeterAsString(String)
	 * @generated
	 */
	boolean isSetPerimeterAsString();

	/**
	 * Returns the value of the '<em><b>Minimum Plate Thickness</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Minimum Plate Thickness</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Minimum Plate Thickness</em>' attribute.
	 * @see #isSetMinimumPlateThickness()
	 * @see #unsetMinimumPlateThickness()
	 * @see #setMinimumPlateThickness(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcGeneralProfileProperties_MinimumPlateThickness()
	 * @model unsettable="true"
	 * @generated
	 */
	double getMinimumPlateThickness();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcGeneralProfileProperties#getMinimumPlateThickness <em>Minimum Plate Thickness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minimum Plate Thickness</em>' attribute.
	 * @see #isSetMinimumPlateThickness()
	 * @see #unsetMinimumPlateThickness()
	 * @see #getMinimumPlateThickness()
	 * @generated
	 */
	void setMinimumPlateThickness(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcGeneralProfileProperties#getMinimumPlateThickness <em>Minimum Plate Thickness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMinimumPlateThickness()
	 * @see #getMinimumPlateThickness()
	 * @see #setMinimumPlateThickness(double)
	 * @generated
	 */
	void unsetMinimumPlateThickness();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcGeneralProfileProperties#getMinimumPlateThickness <em>Minimum Plate Thickness</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Minimum Plate Thickness</em>' attribute is set.
	 * @see #unsetMinimumPlateThickness()
	 * @see #getMinimumPlateThickness()
	 * @see #setMinimumPlateThickness(double)
	 * @generated
	 */
	boolean isSetMinimumPlateThickness();

	/**
	 * Returns the value of the '<em><b>Minimum Plate Thickness As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Minimum Plate Thickness As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Minimum Plate Thickness As String</em>' attribute.
	 * @see #isSetMinimumPlateThicknessAsString()
	 * @see #unsetMinimumPlateThicknessAsString()
	 * @see #setMinimumPlateThicknessAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcGeneralProfileProperties_MinimumPlateThicknessAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getMinimumPlateThicknessAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcGeneralProfileProperties#getMinimumPlateThicknessAsString <em>Minimum Plate Thickness As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minimum Plate Thickness As String</em>' attribute.
	 * @see #isSetMinimumPlateThicknessAsString()
	 * @see #unsetMinimumPlateThicknessAsString()
	 * @see #getMinimumPlateThicknessAsString()
	 * @generated
	 */
	void setMinimumPlateThicknessAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcGeneralProfileProperties#getMinimumPlateThicknessAsString <em>Minimum Plate Thickness As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMinimumPlateThicknessAsString()
	 * @see #getMinimumPlateThicknessAsString()
	 * @see #setMinimumPlateThicknessAsString(String)
	 * @generated
	 */
	void unsetMinimumPlateThicknessAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcGeneralProfileProperties#getMinimumPlateThicknessAsString <em>Minimum Plate Thickness As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Minimum Plate Thickness As String</em>' attribute is set.
	 * @see #unsetMinimumPlateThicknessAsString()
	 * @see #getMinimumPlateThicknessAsString()
	 * @see #setMinimumPlateThicknessAsString(String)
	 * @generated
	 */
	boolean isSetMinimumPlateThicknessAsString();

	/**
	 * Returns the value of the '<em><b>Maximum Plate Thickness</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Maximum Plate Thickness</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maximum Plate Thickness</em>' attribute.
	 * @see #isSetMaximumPlateThickness()
	 * @see #unsetMaximumPlateThickness()
	 * @see #setMaximumPlateThickness(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcGeneralProfileProperties_MaximumPlateThickness()
	 * @model unsettable="true"
	 * @generated
	 */
	double getMaximumPlateThickness();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcGeneralProfileProperties#getMaximumPlateThickness <em>Maximum Plate Thickness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximum Plate Thickness</em>' attribute.
	 * @see #isSetMaximumPlateThickness()
	 * @see #unsetMaximumPlateThickness()
	 * @see #getMaximumPlateThickness()
	 * @generated
	 */
	void setMaximumPlateThickness(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcGeneralProfileProperties#getMaximumPlateThickness <em>Maximum Plate Thickness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMaximumPlateThickness()
	 * @see #getMaximumPlateThickness()
	 * @see #setMaximumPlateThickness(double)
	 * @generated
	 */
	void unsetMaximumPlateThickness();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcGeneralProfileProperties#getMaximumPlateThickness <em>Maximum Plate Thickness</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Maximum Plate Thickness</em>' attribute is set.
	 * @see #unsetMaximumPlateThickness()
	 * @see #getMaximumPlateThickness()
	 * @see #setMaximumPlateThickness(double)
	 * @generated
	 */
	boolean isSetMaximumPlateThickness();

	/**
	 * Returns the value of the '<em><b>Maximum Plate Thickness As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Maximum Plate Thickness As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maximum Plate Thickness As String</em>' attribute.
	 * @see #isSetMaximumPlateThicknessAsString()
	 * @see #unsetMaximumPlateThicknessAsString()
	 * @see #setMaximumPlateThicknessAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcGeneralProfileProperties_MaximumPlateThicknessAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getMaximumPlateThicknessAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcGeneralProfileProperties#getMaximumPlateThicknessAsString <em>Maximum Plate Thickness As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximum Plate Thickness As String</em>' attribute.
	 * @see #isSetMaximumPlateThicknessAsString()
	 * @see #unsetMaximumPlateThicknessAsString()
	 * @see #getMaximumPlateThicknessAsString()
	 * @generated
	 */
	void setMaximumPlateThicknessAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcGeneralProfileProperties#getMaximumPlateThicknessAsString <em>Maximum Plate Thickness As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMaximumPlateThicknessAsString()
	 * @see #getMaximumPlateThicknessAsString()
	 * @see #setMaximumPlateThicknessAsString(String)
	 * @generated
	 */
	void unsetMaximumPlateThicknessAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcGeneralProfileProperties#getMaximumPlateThicknessAsString <em>Maximum Plate Thickness As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Maximum Plate Thickness As String</em>' attribute is set.
	 * @see #unsetMaximumPlateThicknessAsString()
	 * @see #getMaximumPlateThicknessAsString()
	 * @see #setMaximumPlateThicknessAsString(String)
	 * @generated
	 */
	boolean isSetMaximumPlateThicknessAsString();

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
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcGeneralProfileProperties_CrossSectionArea()
	 * @model unsettable="true"
	 * @generated
	 */
	double getCrossSectionArea();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcGeneralProfileProperties#getCrossSectionArea <em>Cross Section Area</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcGeneralProfileProperties#getCrossSectionArea <em>Cross Section Area</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCrossSectionArea()
	 * @see #getCrossSectionArea()
	 * @see #setCrossSectionArea(double)
	 * @generated
	 */
	void unsetCrossSectionArea();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcGeneralProfileProperties#getCrossSectionArea <em>Cross Section Area</em>}' attribute is set.
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
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcGeneralProfileProperties_CrossSectionAreaAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getCrossSectionAreaAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcGeneralProfileProperties#getCrossSectionAreaAsString <em>Cross Section Area As String</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcGeneralProfileProperties#getCrossSectionAreaAsString <em>Cross Section Area As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCrossSectionAreaAsString()
	 * @see #getCrossSectionAreaAsString()
	 * @see #setCrossSectionAreaAsString(String)
	 * @generated
	 */
	void unsetCrossSectionAreaAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcGeneralProfileProperties#getCrossSectionAreaAsString <em>Cross Section Area As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Cross Section Area As String</em>' attribute is set.
	 * @see #unsetCrossSectionAreaAsString()
	 * @see #getCrossSectionAreaAsString()
	 * @see #setCrossSectionAreaAsString(String)
	 * @generated
	 */
	boolean isSetCrossSectionAreaAsString();

} // IfcGeneralProfileProperties
