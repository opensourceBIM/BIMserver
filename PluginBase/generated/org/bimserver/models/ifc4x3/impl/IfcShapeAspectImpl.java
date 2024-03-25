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

import org.bimserver.emf.IdEObjectImpl;

import org.bimserver.models.ifc4x3.Ifc4x3Package;
import org.bimserver.models.ifc4x3.IfcExternalReferenceRelationship;
import org.bimserver.models.ifc4x3.IfcProductRepresentationSelect;
import org.bimserver.models.ifc4x3.IfcShapeAspect;
import org.bimserver.models.ifc4x3.IfcShapeModel;
import org.bimserver.models.ifc4x3.Tristate;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Shape Aspect</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcShapeAspectImpl#getShapeRepresentations <em>Shape Representations</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcShapeAspectImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcShapeAspectImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcShapeAspectImpl#getProductDefinitional <em>Product Definitional</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcShapeAspectImpl#getPartOfProductDefinitionShape <em>Part Of Product Definition Shape</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcShapeAspectImpl#getHasExternalReferences <em>Has External References</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcShapeAspectImpl extends IdEObjectImpl implements IfcShapeAspect {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcShapeAspectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.Literals.IFC_SHAPE_ASPECT;
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
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcShapeModel> getShapeRepresentations() {
		return (EList<IfcShapeModel>) eGet(Ifc4x3Package.Literals.IFC_SHAPE_ASPECT__SHAPE_REPRESENTATIONS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return (String) eGet(Ifc4x3Package.Literals.IFC_SHAPE_ASPECT__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		eSet(Ifc4x3Package.Literals.IFC_SHAPE_ASPECT__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetName() {
		eUnset(Ifc4x3Package.Literals.IFC_SHAPE_ASPECT__NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetName() {
		return eIsSet(Ifc4x3Package.Literals.IFC_SHAPE_ASPECT__NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDescription() {
		return (String) eGet(Ifc4x3Package.Literals.IFC_SHAPE_ASPECT__DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescription(String newDescription) {
		eSet(Ifc4x3Package.Literals.IFC_SHAPE_ASPECT__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDescription() {
		eUnset(Ifc4x3Package.Literals.IFC_SHAPE_ASPECT__DESCRIPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDescription() {
		return eIsSet(Ifc4x3Package.Literals.IFC_SHAPE_ASPECT__DESCRIPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Tristate getProductDefinitional() {
		return (Tristate) eGet(Ifc4x3Package.Literals.IFC_SHAPE_ASPECT__PRODUCT_DEFINITIONAL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setProductDefinitional(Tristate newProductDefinitional) {
		eSet(Ifc4x3Package.Literals.IFC_SHAPE_ASPECT__PRODUCT_DEFINITIONAL, newProductDefinitional);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcProductRepresentationSelect getPartOfProductDefinitionShape() {
		return (IfcProductRepresentationSelect) eGet(
				Ifc4x3Package.Literals.IFC_SHAPE_ASPECT__PART_OF_PRODUCT_DEFINITION_SHAPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPartOfProductDefinitionShape(IfcProductRepresentationSelect newPartOfProductDefinitionShape) {
		eSet(Ifc4x3Package.Literals.IFC_SHAPE_ASPECT__PART_OF_PRODUCT_DEFINITION_SHAPE,
				newPartOfProductDefinitionShape);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPartOfProductDefinitionShape() {
		eUnset(Ifc4x3Package.Literals.IFC_SHAPE_ASPECT__PART_OF_PRODUCT_DEFINITION_SHAPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPartOfProductDefinitionShape() {
		return eIsSet(Ifc4x3Package.Literals.IFC_SHAPE_ASPECT__PART_OF_PRODUCT_DEFINITION_SHAPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcExternalReferenceRelationship> getHasExternalReferences() {
		return (EList<IfcExternalReferenceRelationship>) eGet(
				Ifc4x3Package.Literals.IFC_SHAPE_ASPECT__HAS_EXTERNAL_REFERENCES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetHasExternalReferences() {
		eUnset(Ifc4x3Package.Literals.IFC_SHAPE_ASPECT__HAS_EXTERNAL_REFERENCES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetHasExternalReferences() {
		return eIsSet(Ifc4x3Package.Literals.IFC_SHAPE_ASPECT__HAS_EXTERNAL_REFERENCES);
	}

} //IfcShapeAspectImpl
