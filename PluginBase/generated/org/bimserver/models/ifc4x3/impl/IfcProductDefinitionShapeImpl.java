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
import org.bimserver.models.ifc4x3.IfcProduct;
import org.bimserver.models.ifc4x3.IfcProductDefinitionShape;
import org.bimserver.models.ifc4x3.IfcShapeAspect;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Product Definition Shape</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcProductDefinitionShapeImpl#getShapeOfProduct <em>Shape Of Product</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcProductDefinitionShapeImpl#getHasShapeAspects <em>Has Shape Aspects</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcProductDefinitionShapeImpl extends IfcProductRepresentationImpl implements IfcProductDefinitionShape {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcProductDefinitionShapeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.eINSTANCE.getIfcProductDefinitionShape();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcProduct> getShapeOfProduct() {
		return (EList<IfcProduct>) eGet(Ifc4x3Package.eINSTANCE.getIfcProductDefinitionShape_ShapeOfProduct(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetShapeOfProduct() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcProductDefinitionShape_ShapeOfProduct());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetShapeOfProduct() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcProductDefinitionShape_ShapeOfProduct());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcShapeAspect> getHasShapeAspects() {
		return (EList<IfcShapeAspect>) eGet(Ifc4x3Package.eINSTANCE.getIfcProductDefinitionShape_HasShapeAspects(),
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetHasShapeAspects() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcProductDefinitionShape_HasShapeAspects());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetHasShapeAspects() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcProductDefinitionShape_HasShapeAspects());
	}

} //IfcProductDefinitionShapeImpl
