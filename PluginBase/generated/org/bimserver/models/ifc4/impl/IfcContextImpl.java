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
import org.bimserver.models.ifc4.IfcContext;
import org.bimserver.models.ifc4.IfcRelDeclares;
import org.bimserver.models.ifc4.IfcRelDefinesByProperties;
import org.bimserver.models.ifc4.IfcRepresentationContext;
import org.bimserver.models.ifc4.IfcUnitAssignment;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcContextImpl#getObjectType <em>Object Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcContextImpl#getLongName <em>Long Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcContextImpl#getPhase <em>Phase</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcContextImpl#getRepresentationContexts <em>Representation Contexts</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcContextImpl#getUnitsInContext <em>Units In Context</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcContextImpl#getIsDefinedBy <em>Is Defined By</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcContextImpl#getDeclares <em>Declares</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcContextImpl extends IfcObjectDefinitionImpl implements IfcContext {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcContextImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_CONTEXT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getObjectType() {
		return (String) eGet(Ifc4Package.Literals.IFC_CONTEXT__OBJECT_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setObjectType(String newObjectType) {
		eSet(Ifc4Package.Literals.IFC_CONTEXT__OBJECT_TYPE, newObjectType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetObjectType() {
		eUnset(Ifc4Package.Literals.IFC_CONTEXT__OBJECT_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetObjectType() {
		return eIsSet(Ifc4Package.Literals.IFC_CONTEXT__OBJECT_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLongName() {
		return (String) eGet(Ifc4Package.Literals.IFC_CONTEXT__LONG_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLongName(String newLongName) {
		eSet(Ifc4Package.Literals.IFC_CONTEXT__LONG_NAME, newLongName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLongName() {
		eUnset(Ifc4Package.Literals.IFC_CONTEXT__LONG_NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLongName() {
		return eIsSet(Ifc4Package.Literals.IFC_CONTEXT__LONG_NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPhase() {
		return (String) eGet(Ifc4Package.Literals.IFC_CONTEXT__PHASE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPhase(String newPhase) {
		eSet(Ifc4Package.Literals.IFC_CONTEXT__PHASE, newPhase);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPhase() {
		eUnset(Ifc4Package.Literals.IFC_CONTEXT__PHASE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPhase() {
		return eIsSet(Ifc4Package.Literals.IFC_CONTEXT__PHASE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRepresentationContext> getRepresentationContexts() {
		return (EList<IfcRepresentationContext>) eGet(Ifc4Package.Literals.IFC_CONTEXT__REPRESENTATION_CONTEXTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetRepresentationContexts() {
		eUnset(Ifc4Package.Literals.IFC_CONTEXT__REPRESENTATION_CONTEXTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetRepresentationContexts() {
		return eIsSet(Ifc4Package.Literals.IFC_CONTEXT__REPRESENTATION_CONTEXTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcUnitAssignment getUnitsInContext() {
		return (IfcUnitAssignment) eGet(Ifc4Package.Literals.IFC_CONTEXT__UNITS_IN_CONTEXT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUnitsInContext(IfcUnitAssignment newUnitsInContext) {
		eSet(Ifc4Package.Literals.IFC_CONTEXT__UNITS_IN_CONTEXT, newUnitsInContext);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetUnitsInContext() {
		eUnset(Ifc4Package.Literals.IFC_CONTEXT__UNITS_IN_CONTEXT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetUnitsInContext() {
		return eIsSet(Ifc4Package.Literals.IFC_CONTEXT__UNITS_IN_CONTEXT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelDefinesByProperties> getIsDefinedBy() {
		return (EList<IfcRelDefinesByProperties>) eGet(Ifc4Package.Literals.IFC_CONTEXT__IS_DEFINED_BY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetIsDefinedBy() {
		eUnset(Ifc4Package.Literals.IFC_CONTEXT__IS_DEFINED_BY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetIsDefinedBy() {
		return eIsSet(Ifc4Package.Literals.IFC_CONTEXT__IS_DEFINED_BY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelDeclares> getDeclares() {
		return (EList<IfcRelDeclares>) eGet(Ifc4Package.Literals.IFC_CONTEXT__DECLARES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDeclares() {
		eUnset(Ifc4Package.Literals.IFC_CONTEXT__DECLARES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDeclares() {
		return eIsSet(Ifc4Package.Literals.IFC_CONTEXT__DECLARES);
	}

} //IfcContextImpl
