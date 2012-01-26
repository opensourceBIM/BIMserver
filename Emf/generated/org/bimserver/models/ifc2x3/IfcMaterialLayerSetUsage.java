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
	 * @see #isSetForLayerSet()
	 * @see #unsetForLayerSet()
	 * @see #setForLayerSet(IfcMaterialLayerSet)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcMaterialLayerSetUsage_ForLayerSet()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcMaterialLayerSet getForLayerSet();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcMaterialLayerSetUsage#getForLayerSet <em>For Layer Set</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>For Layer Set</em>' reference.
	 * @see #isSetForLayerSet()
	 * @see #unsetForLayerSet()
	 * @see #getForLayerSet()
	 * @generated
	 */
	void setForLayerSet(IfcMaterialLayerSet value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcMaterialLayerSetUsage#getForLayerSet <em>For Layer Set</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetForLayerSet()
	 * @see #getForLayerSet()
	 * @see #setForLayerSet(IfcMaterialLayerSet)
	 * @generated
	 */
	void unsetForLayerSet();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcMaterialLayerSetUsage#getForLayerSet <em>For Layer Set</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>For Layer Set</em>' reference is set.
	 * @see #unsetForLayerSet()
	 * @see #getForLayerSet()
	 * @see #setForLayerSet(IfcMaterialLayerSet)
	 * @generated
	 */
	boolean isSetForLayerSet();

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
	 * @see #isSetLayerSetDirection()
	 * @see #unsetLayerSetDirection()
	 * @see #setLayerSetDirection(IfcLayerSetDirectionEnum)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcMaterialLayerSetUsage_LayerSetDirection()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcLayerSetDirectionEnum getLayerSetDirection();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcMaterialLayerSetUsage#getLayerSetDirection <em>Layer Set Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Layer Set Direction</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcLayerSetDirectionEnum
	 * @see #isSetLayerSetDirection()
	 * @see #unsetLayerSetDirection()
	 * @see #getLayerSetDirection()
	 * @generated
	 */
	void setLayerSetDirection(IfcLayerSetDirectionEnum value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcMaterialLayerSetUsage#getLayerSetDirection <em>Layer Set Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLayerSetDirection()
	 * @see #getLayerSetDirection()
	 * @see #setLayerSetDirection(IfcLayerSetDirectionEnum)
	 * @generated
	 */
	void unsetLayerSetDirection();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcMaterialLayerSetUsage#getLayerSetDirection <em>Layer Set Direction</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Layer Set Direction</em>' attribute is set.
	 * @see #unsetLayerSetDirection()
	 * @see #getLayerSetDirection()
	 * @see #setLayerSetDirection(IfcLayerSetDirectionEnum)
	 * @generated
	 */
	boolean isSetLayerSetDirection();

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
	 * @see #isSetDirectionSense()
	 * @see #unsetDirectionSense()
	 * @see #setDirectionSense(IfcDirectionSenseEnum)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcMaterialLayerSetUsage_DirectionSense()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcDirectionSenseEnum getDirectionSense();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcMaterialLayerSetUsage#getDirectionSense <em>Direction Sense</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Direction Sense</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcDirectionSenseEnum
	 * @see #isSetDirectionSense()
	 * @see #unsetDirectionSense()
	 * @see #getDirectionSense()
	 * @generated
	 */
	void setDirectionSense(IfcDirectionSenseEnum value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcMaterialLayerSetUsage#getDirectionSense <em>Direction Sense</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDirectionSense()
	 * @see #getDirectionSense()
	 * @see #setDirectionSense(IfcDirectionSenseEnum)
	 * @generated
	 */
	void unsetDirectionSense();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcMaterialLayerSetUsage#getDirectionSense <em>Direction Sense</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Direction Sense</em>' attribute is set.
	 * @see #unsetDirectionSense()
	 * @see #getDirectionSense()
	 * @see #setDirectionSense(IfcDirectionSenseEnum)
	 * @generated
	 */
	boolean isSetDirectionSense();

	/**
	 * Returns the value of the '<em><b>Offset From Reference Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Offset From Reference Line</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Offset From Reference Line</em>' attribute.
	 * @see #isSetOffsetFromReferenceLine()
	 * @see #unsetOffsetFromReferenceLine()
	 * @see #setOffsetFromReferenceLine(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcMaterialLayerSetUsage_OffsetFromReferenceLine()
	 * @model unsettable="true"
	 * @generated
	 */
	double getOffsetFromReferenceLine();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcMaterialLayerSetUsage#getOffsetFromReferenceLine <em>Offset From Reference Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Offset From Reference Line</em>' attribute.
	 * @see #isSetOffsetFromReferenceLine()
	 * @see #unsetOffsetFromReferenceLine()
	 * @see #getOffsetFromReferenceLine()
	 * @generated
	 */
	void setOffsetFromReferenceLine(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcMaterialLayerSetUsage#getOffsetFromReferenceLine <em>Offset From Reference Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetOffsetFromReferenceLine()
	 * @see #getOffsetFromReferenceLine()
	 * @see #setOffsetFromReferenceLine(double)
	 * @generated
	 */
	void unsetOffsetFromReferenceLine();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcMaterialLayerSetUsage#getOffsetFromReferenceLine <em>Offset From Reference Line</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Offset From Reference Line</em>' attribute is set.
	 * @see #unsetOffsetFromReferenceLine()
	 * @see #getOffsetFromReferenceLine()
	 * @see #setOffsetFromReferenceLine(double)
	 * @generated
	 */
	boolean isSetOffsetFromReferenceLine();

	/**
	 * Returns the value of the '<em><b>Offset From Reference Line As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Offset From Reference Line As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Offset From Reference Line As String</em>' attribute.
	 * @see #isSetOffsetFromReferenceLineAsString()
	 * @see #unsetOffsetFromReferenceLineAsString()
	 * @see #setOffsetFromReferenceLineAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcMaterialLayerSetUsage_OffsetFromReferenceLineAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getOffsetFromReferenceLineAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcMaterialLayerSetUsage#getOffsetFromReferenceLineAsString <em>Offset From Reference Line As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Offset From Reference Line As String</em>' attribute.
	 * @see #isSetOffsetFromReferenceLineAsString()
	 * @see #unsetOffsetFromReferenceLineAsString()
	 * @see #getOffsetFromReferenceLineAsString()
	 * @generated
	 */
	void setOffsetFromReferenceLineAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcMaterialLayerSetUsage#getOffsetFromReferenceLineAsString <em>Offset From Reference Line As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetOffsetFromReferenceLineAsString()
	 * @see #getOffsetFromReferenceLineAsString()
	 * @see #setOffsetFromReferenceLineAsString(String)
	 * @generated
	 */
	void unsetOffsetFromReferenceLineAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcMaterialLayerSetUsage#getOffsetFromReferenceLineAsString <em>Offset From Reference Line As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Offset From Reference Line As String</em>' attribute is set.
	 * @see #unsetOffsetFromReferenceLineAsString()
	 * @see #getOffsetFromReferenceLineAsString()
	 * @see #setOffsetFromReferenceLineAsString(String)
	 * @generated
	 */
	boolean isSetOffsetFromReferenceLineAsString();

} // IfcMaterialLayerSetUsage
