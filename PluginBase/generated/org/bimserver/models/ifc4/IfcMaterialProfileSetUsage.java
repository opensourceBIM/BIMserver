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

public interface IfcMaterialProfileSetUsage extends IfcMaterialUsageDefinition {
	/**
	 * Returns the value of the '<em><b>For Profile Set</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>For Profile Set</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>For Profile Set</em>' reference.
	 * @see #setForProfileSet(IfcMaterialProfileSet)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMaterialProfileSetUsage_ForProfileSet()
	 * @model
	 * @generated
	 */
	IfcMaterialProfileSet getForProfileSet();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcMaterialProfileSetUsage#getForProfileSet <em>For Profile Set</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>For Profile Set</em>' reference.
	 * @see #getForProfileSet()
	 * @generated
	 */
	void setForProfileSet(IfcMaterialProfileSet value);

	/**
	 * Returns the value of the '<em><b>Cardinal Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cardinal Point</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cardinal Point</em>' attribute.
	 * @see #isSetCardinalPoint()
	 * @see #unsetCardinalPoint()
	 * @see #setCardinalPoint(long)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMaterialProfileSetUsage_CardinalPoint()
	 * @model unsettable="true"
	 * @generated
	 */
	long getCardinalPoint();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcMaterialProfileSetUsage#getCardinalPoint <em>Cardinal Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cardinal Point</em>' attribute.
	 * @see #isSetCardinalPoint()
	 * @see #unsetCardinalPoint()
	 * @see #getCardinalPoint()
	 * @generated
	 */
	void setCardinalPoint(long value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcMaterialProfileSetUsage#getCardinalPoint <em>Cardinal Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCardinalPoint()
	 * @see #getCardinalPoint()
	 * @see #setCardinalPoint(long)
	 * @generated
	 */
	void unsetCardinalPoint();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcMaterialProfileSetUsage#getCardinalPoint <em>Cardinal Point</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Cardinal Point</em>' attribute is set.
	 * @see #unsetCardinalPoint()
	 * @see #getCardinalPoint()
	 * @see #setCardinalPoint(long)
	 * @generated
	 */
	boolean isSetCardinalPoint();

	/**
	 * Returns the value of the '<em><b>Reference Extent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference Extent</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference Extent</em>' attribute.
	 * @see #isSetReferenceExtent()
	 * @see #unsetReferenceExtent()
	 * @see #setReferenceExtent(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMaterialProfileSetUsage_ReferenceExtent()
	 * @model unsettable="true"
	 * @generated
	 */
	double getReferenceExtent();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcMaterialProfileSetUsage#getReferenceExtent <em>Reference Extent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reference Extent</em>' attribute.
	 * @see #isSetReferenceExtent()
	 * @see #unsetReferenceExtent()
	 * @see #getReferenceExtent()
	 * @generated
	 */
	void setReferenceExtent(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcMaterialProfileSetUsage#getReferenceExtent <em>Reference Extent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetReferenceExtent()
	 * @see #getReferenceExtent()
	 * @see #setReferenceExtent(double)
	 * @generated
	 */
	void unsetReferenceExtent();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcMaterialProfileSetUsage#getReferenceExtent <em>Reference Extent</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Reference Extent</em>' attribute is set.
	 * @see #unsetReferenceExtent()
	 * @see #getReferenceExtent()
	 * @see #setReferenceExtent(double)
	 * @generated
	 */
	boolean isSetReferenceExtent();

	/**
	 * Returns the value of the '<em><b>Reference Extent As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference Extent As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference Extent As String</em>' attribute.
	 * @see #isSetReferenceExtentAsString()
	 * @see #unsetReferenceExtentAsString()
	 * @see #setReferenceExtentAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMaterialProfileSetUsage_ReferenceExtentAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getReferenceExtentAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcMaterialProfileSetUsage#getReferenceExtentAsString <em>Reference Extent As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reference Extent As String</em>' attribute.
	 * @see #isSetReferenceExtentAsString()
	 * @see #unsetReferenceExtentAsString()
	 * @see #getReferenceExtentAsString()
	 * @generated
	 */
	void setReferenceExtentAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcMaterialProfileSetUsage#getReferenceExtentAsString <em>Reference Extent As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetReferenceExtentAsString()
	 * @see #getReferenceExtentAsString()
	 * @see #setReferenceExtentAsString(String)
	 * @generated
	 */
	void unsetReferenceExtentAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcMaterialProfileSetUsage#getReferenceExtentAsString <em>Reference Extent As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Reference Extent As String</em>' attribute is set.
	 * @see #unsetReferenceExtentAsString()
	 * @see #getReferenceExtentAsString()
	 * @see #setReferenceExtentAsString(String)
	 * @generated
	 */
	boolean isSetReferenceExtentAsString();

} // IfcMaterialProfileSetUsage
