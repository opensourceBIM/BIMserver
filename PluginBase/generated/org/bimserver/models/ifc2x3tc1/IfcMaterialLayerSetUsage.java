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

public interface IfcMaterialLayerSetUsage extends IfcMaterialSelect {
	/**
	 * Returns the value of the '<em><b>For Layer Set</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>For Layer Set</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>For Layer Set</em>' reference.
	 * @see #setForLayerSet(IfcMaterialLayerSet)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcMaterialLayerSetUsage_ForLayerSet()
	 * @model
	 * @generated
	 */
	IfcMaterialLayerSet getForLayerSet();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMaterialLayerSetUsage#getForLayerSet <em>For Layer Set</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>For Layer Set</em>' reference.
	 * @see #getForLayerSet()
	 * @generated
	 */
	void setForLayerSet(IfcMaterialLayerSet value);

	/**
	 * Returns the value of the '<em><b>Layer Set Direction</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3tc1.IfcLayerSetDirectionEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layer Set Direction</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layer Set Direction</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.IfcLayerSetDirectionEnum
	 * @see #setLayerSetDirection(IfcLayerSetDirectionEnum)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcMaterialLayerSetUsage_LayerSetDirection()
	 * @model
	 * @generated
	 */
	IfcLayerSetDirectionEnum getLayerSetDirection();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMaterialLayerSetUsage#getLayerSetDirection <em>Layer Set Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Layer Set Direction</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.IfcLayerSetDirectionEnum
	 * @see #getLayerSetDirection()
	 * @generated
	 */
	void setLayerSetDirection(IfcLayerSetDirectionEnum value);

	/**
	 * Returns the value of the '<em><b>Direction Sense</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3tc1.IfcDirectionSenseEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Direction Sense</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Direction Sense</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.IfcDirectionSenseEnum
	 * @see #setDirectionSense(IfcDirectionSenseEnum)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcMaterialLayerSetUsage_DirectionSense()
	 * @model
	 * @generated
	 */
	IfcDirectionSenseEnum getDirectionSense();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMaterialLayerSetUsage#getDirectionSense <em>Direction Sense</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Direction Sense</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.IfcDirectionSenseEnum
	 * @see #getDirectionSense()
	 * @generated
	 */
	void setDirectionSense(IfcDirectionSenseEnum value);

	/**
	 * Returns the value of the '<em><b>Offset From Reference Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Offset From Reference Line</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Offset From Reference Line</em>' attribute.
	 * @see #setOffsetFromReferenceLine(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcMaterialLayerSetUsage_OffsetFromReferenceLine()
	 * @model
	 * @generated
	 */
	double getOffsetFromReferenceLine();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMaterialLayerSetUsage#getOffsetFromReferenceLine <em>Offset From Reference Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Offset From Reference Line</em>' attribute.
	 * @see #getOffsetFromReferenceLine()
	 * @generated
	 */
	void setOffsetFromReferenceLine(double value);

	/**
	 * Returns the value of the '<em><b>Offset From Reference Line As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Offset From Reference Line As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Offset From Reference Line As String</em>' attribute.
	 * @see #setOffsetFromReferenceLineAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcMaterialLayerSetUsage_OffsetFromReferenceLineAsString()
	 * @model
	 * @generated
	 */
	String getOffsetFromReferenceLineAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMaterialLayerSetUsage#getOffsetFromReferenceLineAsString <em>Offset From Reference Line As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Offset From Reference Line As String</em>' attribute.
	 * @see #getOffsetFromReferenceLineAsString()
	 * @generated
	 */
	void setOffsetFromReferenceLineAsString(String value);

} // IfcMaterialLayerSetUsage
