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

public interface IfcPropertyDependencyRelationship extends IfcResourceLevelRelationship {
	/**
	 * Returns the value of the '<em><b>Depending Property</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcProperty#getPropertyForDependance <em>Property For Dependance</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Depending Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Depending Property</em>' reference.
	 * @see #setDependingProperty(IfcProperty)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcPropertyDependencyRelationship_DependingProperty()
	 * @see org.bimserver.models.ifc4.IfcProperty#getPropertyForDependance
	 * @model opposite="PropertyForDependance"
	 *        annotation="inverse"
	 * @generated
	 */
	IfcProperty getDependingProperty();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcPropertyDependencyRelationship#getDependingProperty <em>Depending Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Depending Property</em>' reference.
	 * @see #getDependingProperty()
	 * @generated
	 */
	void setDependingProperty(IfcProperty value);

	/**
	 * Returns the value of the '<em><b>Dependant Property</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcProperty#getPropertyDependsOn <em>Property Depends On</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependant Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependant Property</em>' reference.
	 * @see #setDependantProperty(IfcProperty)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcPropertyDependencyRelationship_DependantProperty()
	 * @see org.bimserver.models.ifc4.IfcProperty#getPropertyDependsOn
	 * @model opposite="PropertyDependsOn"
	 *        annotation="inverse"
	 * @generated
	 */
	IfcProperty getDependantProperty();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcPropertyDependencyRelationship#getDependantProperty <em>Dependant Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dependant Property</em>' reference.
	 * @see #getDependantProperty()
	 * @generated
	 */
	void setDependantProperty(IfcProperty value);

	/**
	 * Returns the value of the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' attribute.
	 * @see #isSetExpression()
	 * @see #unsetExpression()
	 * @see #setExpression(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcPropertyDependencyRelationship_Expression()
	 * @model unsettable="true"
	 * @generated
	 */
	String getExpression();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcPropertyDependencyRelationship#getExpression <em>Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' attribute.
	 * @see #isSetExpression()
	 * @see #unsetExpression()
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcPropertyDependencyRelationship#getExpression <em>Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetExpression()
	 * @see #getExpression()
	 * @see #setExpression(String)
	 * @generated
	 */
	void unsetExpression();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcPropertyDependencyRelationship#getExpression <em>Expression</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Expression</em>' attribute is set.
	 * @see #unsetExpression()
	 * @see #getExpression()
	 * @see #setExpression(String)
	 * @generated
	 */
	boolean isSetExpression();

} // IfcPropertyDependencyRelationship
