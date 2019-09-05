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
import org.bimserver.models.ifc4.IfcElement;
import org.bimserver.models.ifc4.IfcFeatureElementAddition;
import org.bimserver.models.ifc4.IfcRelProjectsElement;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Rel Projects Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcRelProjectsElementImpl#getRelatingElement <em>Relating Element</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcRelProjectsElementImpl#getRelatedFeatureElement <em>Related Feature Element</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcRelProjectsElementImpl extends IfcRelDecomposesImpl implements IfcRelProjectsElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRelProjectsElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_REL_PROJECTS_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcElement getRelatingElement() {
		return (IfcElement) eGet(Ifc4Package.Literals.IFC_REL_PROJECTS_ELEMENT__RELATING_ELEMENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRelatingElement(IfcElement newRelatingElement) {
		eSet(Ifc4Package.Literals.IFC_REL_PROJECTS_ELEMENT__RELATING_ELEMENT, newRelatingElement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcFeatureElementAddition getRelatedFeatureElement() {
		return (IfcFeatureElementAddition) eGet(Ifc4Package.Literals.IFC_REL_PROJECTS_ELEMENT__RELATED_FEATURE_ELEMENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRelatedFeatureElement(IfcFeatureElementAddition newRelatedFeatureElement) {
		eSet(Ifc4Package.Literals.IFC_REL_PROJECTS_ELEMENT__RELATED_FEATURE_ELEMENT, newRelatedFeatureElement);
	}

} //IfcRelProjectsElementImpl
