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
 * A representation of the model object '<em><b>Ifc Material Layer Set Usage</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcMaterialLayerSetUsage#getForLayerSet <em>For Layer Set</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcMaterialLayerSetUsage#getLayerSetDirection <em>Layer Set Direction</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcMaterialLayerSetUsage#getDirectionSense <em>Direction Sense</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcMaterialLayerSetUsage#getOffsetFromReferenceLine <em>Offset From Reference Line</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcMaterialLayerSetUsage#getOffsetFromReferenceLineAsString <em>Offset From Reference Line As String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcMaterialLayerSetUsage()
 * @model
 * @generated
 */
public interface IfcMaterialLayerSetUsage extends IfcMaterialSelect
{
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcMaterialLayerSetUsage_ForLayerSet()
	 * @model
	 * @generated
	 */
	IfcMaterialLayerSet getForLayerSet();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcMaterialLayerSetUsage#getForLayerSet <em>For Layer Set</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>For Layer Set</em>' reference.
	 * @see #getForLayerSet()
	 * @generated
	 */
	void setForLayerSet(IfcMaterialLayerSet value);

	/**
	 * Returns the value of the '<em><b>Layer Set Direction</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.IfcLayerSetDirectionEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layer Set Direction</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layer Set Direction</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcLayerSetDirectionEnum
	 * @see #setLayerSetDirection(IfcLayerSetDirectionEnum)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcMaterialLayerSetUsage_LayerSetDirection()
	 * @model
	 * @generated
	 */
	IfcLayerSetDirectionEnum getLayerSetDirection();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcMaterialLayerSetUsage#getLayerSetDirection <em>Layer Set Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Layer Set Direction</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcLayerSetDirectionEnum
	 * @see #getLayerSetDirection()
	 * @generated
	 */
	void setLayerSetDirection(IfcLayerSetDirectionEnum value);

	/**
	 * Returns the value of the '<em><b>Direction Sense</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.IfcDirectionSenseEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Direction Sense</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Direction Sense</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcDirectionSenseEnum
	 * @see #setDirectionSense(IfcDirectionSenseEnum)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcMaterialLayerSetUsage_DirectionSense()
	 * @model
	 * @generated
	 */
	IfcDirectionSenseEnum getDirectionSense();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcMaterialLayerSetUsage#getDirectionSense <em>Direction Sense</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Direction Sense</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcDirectionSenseEnum
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
	 * @see #setOffsetFromReferenceLine(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcMaterialLayerSetUsage_OffsetFromReferenceLine()
	 * @model
	 * @generated
	 */
	float getOffsetFromReferenceLine();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcMaterialLayerSetUsage#getOffsetFromReferenceLine <em>Offset From Reference Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Offset From Reference Line</em>' attribute.
	 * @see #getOffsetFromReferenceLine()
	 * @generated
	 */
	void setOffsetFromReferenceLine(float value);

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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcMaterialLayerSetUsage_OffsetFromReferenceLineAsString()
	 * @model
	 * @generated
	 */
	String getOffsetFromReferenceLineAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcMaterialLayerSetUsage#getOffsetFromReferenceLineAsString <em>Offset From Reference Line As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Offset From Reference Line As String</em>' attribute.
	 * @see #getOffsetFromReferenceLineAsString()
	 * @generated
	 */
	void setOffsetFromReferenceLineAsString(String value);

} // IfcMaterialLayerSetUsage
