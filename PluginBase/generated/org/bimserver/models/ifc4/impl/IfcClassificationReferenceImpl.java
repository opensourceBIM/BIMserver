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
import org.bimserver.models.ifc4.IfcClassificationReference;
import org.bimserver.models.ifc4.IfcClassificationReferenceSelect;
import org.bimserver.models.ifc4.IfcRelAssociatesClassification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Classification Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcClassificationReferenceImpl#getReferencedSource <em>Referenced Source</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcClassificationReferenceImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcClassificationReferenceImpl#getSort <em>Sort</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcClassificationReferenceImpl#getClassificationRefForObjects <em>Classification Ref For Objects</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcClassificationReferenceImpl#getHasReferences <em>Has References</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcClassificationReferenceImpl extends IfcExternalReferenceImpl implements IfcClassificationReference {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcClassificationReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_CLASSIFICATION_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcClassificationReferenceSelect getReferencedSource() {
		return (IfcClassificationReferenceSelect) eGet(Ifc4Package.Literals.IFC_CLASSIFICATION_REFERENCE__REFERENCED_SOURCE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferencedSource(IfcClassificationReferenceSelect newReferencedSource) {
		eSet(Ifc4Package.Literals.IFC_CLASSIFICATION_REFERENCE__REFERENCED_SOURCE, newReferencedSource);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetReferencedSource() {
		eUnset(Ifc4Package.Literals.IFC_CLASSIFICATION_REFERENCE__REFERENCED_SOURCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetReferencedSource() {
		return eIsSet(Ifc4Package.Literals.IFC_CLASSIFICATION_REFERENCE__REFERENCED_SOURCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDescription() {
		return (String) eGet(Ifc4Package.Literals.IFC_CLASSIFICATION_REFERENCE__DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescription(String newDescription) {
		eSet(Ifc4Package.Literals.IFC_CLASSIFICATION_REFERENCE__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDescription() {
		eUnset(Ifc4Package.Literals.IFC_CLASSIFICATION_REFERENCE__DESCRIPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDescription() {
		return eIsSet(Ifc4Package.Literals.IFC_CLASSIFICATION_REFERENCE__DESCRIPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSort() {
		return (String) eGet(Ifc4Package.Literals.IFC_CLASSIFICATION_REFERENCE__SORT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSort(String newSort) {
		eSet(Ifc4Package.Literals.IFC_CLASSIFICATION_REFERENCE__SORT, newSort);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetSort() {
		eUnset(Ifc4Package.Literals.IFC_CLASSIFICATION_REFERENCE__SORT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetSort() {
		return eIsSet(Ifc4Package.Literals.IFC_CLASSIFICATION_REFERENCE__SORT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelAssociatesClassification> getClassificationRefForObjects() {
		return (EList<IfcRelAssociatesClassification>) eGet(Ifc4Package.Literals.IFC_CLASSIFICATION_REFERENCE__CLASSIFICATION_REF_FOR_OBJECTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetClassificationRefForObjects() {
		eUnset(Ifc4Package.Literals.IFC_CLASSIFICATION_REFERENCE__CLASSIFICATION_REF_FOR_OBJECTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetClassificationRefForObjects() {
		return eIsSet(Ifc4Package.Literals.IFC_CLASSIFICATION_REFERENCE__CLASSIFICATION_REF_FOR_OBJECTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcClassificationReference> getHasReferences() {
		return (EList<IfcClassificationReference>) eGet(Ifc4Package.Literals.IFC_CLASSIFICATION_REFERENCE__HAS_REFERENCES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetHasReferences() {
		eUnset(Ifc4Package.Literals.IFC_CLASSIFICATION_REFERENCE__HAS_REFERENCES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetHasReferences() {
		return eIsSet(Ifc4Package.Literals.IFC_CLASSIFICATION_REFERENCE__HAS_REFERENCES);
	}

} //IfcClassificationReferenceImpl
