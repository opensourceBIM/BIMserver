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

import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.models.ifc4.Ifc4Package;
import org.bimserver.models.ifc4.IfcRepresentation;
import org.bimserver.models.ifc4.IfcRepresentationContext;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Representation Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcRepresentationContextImpl#getContextIdentifier <em>Context Identifier</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcRepresentationContextImpl#getContextType <em>Context Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcRepresentationContextImpl#getRepresentationsInContext <em>Representations In Context</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcRepresentationContextImpl extends IdEObjectImpl implements IfcRepresentationContext {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRepresentationContextImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_REPRESENTATION_CONTEXT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getContextIdentifier() {
		return (String) eGet(Ifc4Package.Literals.IFC_REPRESENTATION_CONTEXT__CONTEXT_IDENTIFIER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setContextIdentifier(String newContextIdentifier) {
		eSet(Ifc4Package.Literals.IFC_REPRESENTATION_CONTEXT__CONTEXT_IDENTIFIER, newContextIdentifier);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetContextIdentifier() {
		eUnset(Ifc4Package.Literals.IFC_REPRESENTATION_CONTEXT__CONTEXT_IDENTIFIER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetContextIdentifier() {
		return eIsSet(Ifc4Package.Literals.IFC_REPRESENTATION_CONTEXT__CONTEXT_IDENTIFIER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getContextType() {
		return (String) eGet(Ifc4Package.Literals.IFC_REPRESENTATION_CONTEXT__CONTEXT_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setContextType(String newContextType) {
		eSet(Ifc4Package.Literals.IFC_REPRESENTATION_CONTEXT__CONTEXT_TYPE, newContextType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetContextType() {
		eUnset(Ifc4Package.Literals.IFC_REPRESENTATION_CONTEXT__CONTEXT_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetContextType() {
		return eIsSet(Ifc4Package.Literals.IFC_REPRESENTATION_CONTEXT__CONTEXT_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRepresentation> getRepresentationsInContext() {
		return (EList<IfcRepresentation>) eGet(Ifc4Package.Literals.IFC_REPRESENTATION_CONTEXT__REPRESENTATIONS_IN_CONTEXT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetRepresentationsInContext() {
		eUnset(Ifc4Package.Literals.IFC_REPRESENTATION_CONTEXT__REPRESENTATIONS_IN_CONTEXT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetRepresentationsInContext() {
		return eIsSet(Ifc4Package.Literals.IFC_REPRESENTATION_CONTEXT__REPRESENTATIONS_IN_CONTEXT);
	}

} //IfcRepresentationContextImpl
