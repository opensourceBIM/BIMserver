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
package org.bimserver.models.ifc4x3.impl;

import org.bimserver.models.ifc4x3.Ifc4x3Package;
import org.bimserver.models.ifc4x3.IfcClassification;
import org.bimserver.models.ifc4x3.IfcClassificationReference;
import org.bimserver.models.ifc4x3.IfcRelAssociatesClassification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Classification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcClassificationImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcClassificationImpl#getEdition <em>Edition</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcClassificationImpl#getEditionDate <em>Edition Date</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcClassificationImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcClassificationImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcClassificationImpl#getSpecification <em>Specification</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcClassificationImpl#getReferenceTokens <em>Reference Tokens</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcClassificationImpl#getClassificationForObjects <em>Classification For Objects</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcClassificationImpl#getHasReferences <em>Has References</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcClassificationImpl extends IfcExternalInformationImpl implements IfcClassification {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcClassificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.eINSTANCE.getIfcClassification();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSource() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcClassification_Source(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSource(String newSource) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcClassification_Source(), newSource);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetSource() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcClassification_Source());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetSource() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcClassification_Source());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getEdition() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcClassification_Edition(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEdition(String newEdition) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcClassification_Edition(), newEdition);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetEdition() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcClassification_Edition());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetEdition() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcClassification_Edition());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getEditionDate() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcClassification_EditionDate(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEditionDate(String newEditionDate) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcClassification_EditionDate(), newEditionDate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetEditionDate() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcClassification_EditionDate());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetEditionDate() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcClassification_EditionDate());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcClassification_Name(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcClassification_Name(), newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDescription() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcClassification_Description(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescription(String newDescription) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcClassification_Description(), newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDescription() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcClassification_Description());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDescription() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcClassification_Description());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSpecification() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcClassification_Specification(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSpecification(String newSpecification) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcClassification_Specification(), newSpecification);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetSpecification() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcClassification_Specification());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetSpecification() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcClassification_Specification());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<String> getReferenceTokens() {
		return (EList<String>) eGet(Ifc4x3Package.eINSTANCE.getIfcClassification_ReferenceTokens(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetReferenceTokens() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcClassification_ReferenceTokens());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetReferenceTokens() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcClassification_ReferenceTokens());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelAssociatesClassification> getClassificationForObjects() {
		return (EList<IfcRelAssociatesClassification>) eGet(
				Ifc4x3Package.eINSTANCE.getIfcClassification_ClassificationForObjects(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetClassificationForObjects() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcClassification_ClassificationForObjects());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetClassificationForObjects() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcClassification_ClassificationForObjects());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcClassificationReference> getHasReferences() {
		return (EList<IfcClassificationReference>) eGet(Ifc4x3Package.eINSTANCE.getIfcClassification_HasReferences(),
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetHasReferences() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcClassification_HasReferences());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetHasReferences() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcClassification_HasReferences());
	}

} //IfcClassificationImpl
