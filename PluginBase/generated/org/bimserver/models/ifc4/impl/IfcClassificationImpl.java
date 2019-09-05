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
import org.bimserver.models.ifc4.IfcClassification;
import org.bimserver.models.ifc4.IfcClassificationReference;
import org.bimserver.models.ifc4.IfcRelAssociatesClassification;
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
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcClassificationImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcClassificationImpl#getEdition <em>Edition</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcClassificationImpl#getEditionDate <em>Edition Date</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcClassificationImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcClassificationImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcClassificationImpl#getLocation <em>Location</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcClassificationImpl#getReferenceTokens <em>Reference Tokens</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcClassificationImpl#getClassificationForObjects <em>Classification For Objects</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcClassificationImpl#getHasReferences <em>Has References</em>}</li>
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
		return Ifc4Package.Literals.IFC_CLASSIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSource() {
		return (String) eGet(Ifc4Package.Literals.IFC_CLASSIFICATION__SOURCE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSource(String newSource) {
		eSet(Ifc4Package.Literals.IFC_CLASSIFICATION__SOURCE, newSource);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetSource() {
		eUnset(Ifc4Package.Literals.IFC_CLASSIFICATION__SOURCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetSource() {
		return eIsSet(Ifc4Package.Literals.IFC_CLASSIFICATION__SOURCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getEdition() {
		return (String) eGet(Ifc4Package.Literals.IFC_CLASSIFICATION__EDITION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEdition(String newEdition) {
		eSet(Ifc4Package.Literals.IFC_CLASSIFICATION__EDITION, newEdition);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetEdition() {
		eUnset(Ifc4Package.Literals.IFC_CLASSIFICATION__EDITION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetEdition() {
		return eIsSet(Ifc4Package.Literals.IFC_CLASSIFICATION__EDITION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getEditionDate() {
		return (String) eGet(Ifc4Package.Literals.IFC_CLASSIFICATION__EDITION_DATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEditionDate(String newEditionDate) {
		eSet(Ifc4Package.Literals.IFC_CLASSIFICATION__EDITION_DATE, newEditionDate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetEditionDate() {
		eUnset(Ifc4Package.Literals.IFC_CLASSIFICATION__EDITION_DATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetEditionDate() {
		return eIsSet(Ifc4Package.Literals.IFC_CLASSIFICATION__EDITION_DATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return (String) eGet(Ifc4Package.Literals.IFC_CLASSIFICATION__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		eSet(Ifc4Package.Literals.IFC_CLASSIFICATION__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDescription() {
		return (String) eGet(Ifc4Package.Literals.IFC_CLASSIFICATION__DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescription(String newDescription) {
		eSet(Ifc4Package.Literals.IFC_CLASSIFICATION__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDescription() {
		eUnset(Ifc4Package.Literals.IFC_CLASSIFICATION__DESCRIPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDescription() {
		return eIsSet(Ifc4Package.Literals.IFC_CLASSIFICATION__DESCRIPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLocation() {
		return (String) eGet(Ifc4Package.Literals.IFC_CLASSIFICATION__LOCATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLocation(String newLocation) {
		eSet(Ifc4Package.Literals.IFC_CLASSIFICATION__LOCATION, newLocation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLocation() {
		eUnset(Ifc4Package.Literals.IFC_CLASSIFICATION__LOCATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLocation() {
		return eIsSet(Ifc4Package.Literals.IFC_CLASSIFICATION__LOCATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<String> getReferenceTokens() {
		return (EList<String>) eGet(Ifc4Package.Literals.IFC_CLASSIFICATION__REFERENCE_TOKENS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetReferenceTokens() {
		eUnset(Ifc4Package.Literals.IFC_CLASSIFICATION__REFERENCE_TOKENS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetReferenceTokens() {
		return eIsSet(Ifc4Package.Literals.IFC_CLASSIFICATION__REFERENCE_TOKENS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelAssociatesClassification> getClassificationForObjects() {
		return (EList<IfcRelAssociatesClassification>) eGet(Ifc4Package.Literals.IFC_CLASSIFICATION__CLASSIFICATION_FOR_OBJECTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetClassificationForObjects() {
		eUnset(Ifc4Package.Literals.IFC_CLASSIFICATION__CLASSIFICATION_FOR_OBJECTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetClassificationForObjects() {
		return eIsSet(Ifc4Package.Literals.IFC_CLASSIFICATION__CLASSIFICATION_FOR_OBJECTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcClassificationReference> getHasReferences() {
		return (EList<IfcClassificationReference>) eGet(Ifc4Package.Literals.IFC_CLASSIFICATION__HAS_REFERENCES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetHasReferences() {
		eUnset(Ifc4Package.Literals.IFC_CLASSIFICATION__HAS_REFERENCES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetHasReferences() {
		return eIsSet(Ifc4Package.Literals.IFC_CLASSIFICATION__HAS_REFERENCES);
	}

} //IfcClassificationImpl
