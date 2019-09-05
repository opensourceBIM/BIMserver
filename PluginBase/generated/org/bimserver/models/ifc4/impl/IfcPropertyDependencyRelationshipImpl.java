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
package org.bimserver.models.ifc4.impl;

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

import org.bimserver.models.ifc4.Ifc4Package;
import org.bimserver.models.ifc4.IfcProperty;
import org.bimserver.models.ifc4.IfcPropertyDependencyRelationship;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Property Dependency Relationship</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcPropertyDependencyRelationshipImpl#getDependingProperty <em>Depending Property</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcPropertyDependencyRelationshipImpl#getDependantProperty <em>Dependant Property</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcPropertyDependencyRelationshipImpl#getExpression <em>Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcPropertyDependencyRelationshipImpl extends IfcResourceLevelRelationshipImpl implements IfcPropertyDependencyRelationship {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcPropertyDependencyRelationshipImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_PROPERTY_DEPENDENCY_RELATIONSHIP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcProperty getDependingProperty() {
		return (IfcProperty) eGet(Ifc4Package.Literals.IFC_PROPERTY_DEPENDENCY_RELATIONSHIP__DEPENDING_PROPERTY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDependingProperty(IfcProperty newDependingProperty) {
		eSet(Ifc4Package.Literals.IFC_PROPERTY_DEPENDENCY_RELATIONSHIP__DEPENDING_PROPERTY, newDependingProperty);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcProperty getDependantProperty() {
		return (IfcProperty) eGet(Ifc4Package.Literals.IFC_PROPERTY_DEPENDENCY_RELATIONSHIP__DEPENDANT_PROPERTY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDependantProperty(IfcProperty newDependantProperty) {
		eSet(Ifc4Package.Literals.IFC_PROPERTY_DEPENDENCY_RELATIONSHIP__DEPENDANT_PROPERTY, newDependantProperty);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getExpression() {
		return (String) eGet(Ifc4Package.Literals.IFC_PROPERTY_DEPENDENCY_RELATIONSHIP__EXPRESSION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setExpression(String newExpression) {
		eSet(Ifc4Package.Literals.IFC_PROPERTY_DEPENDENCY_RELATIONSHIP__EXPRESSION, newExpression);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetExpression() {
		eUnset(Ifc4Package.Literals.IFC_PROPERTY_DEPENDENCY_RELATIONSHIP__EXPRESSION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetExpression() {
		return eIsSet(Ifc4Package.Literals.IFC_PROPERTY_DEPENDENCY_RELATIONSHIP__EXPRESSION);
	}

} //IfcPropertyDependencyRelationshipImpl
