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
import org.bimserver.models.ifc4x3.IfcPlanarExtent;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Planar Extent</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcPlanarExtentImpl#getSizeInX <em>Size In X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcPlanarExtentImpl#getSizeInXAsString <em>Size In XAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcPlanarExtentImpl#getSizeInY <em>Size In Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcPlanarExtentImpl#getSizeInYAsString <em>Size In YAs String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcPlanarExtentImpl extends IfcGeometricRepresentationItemImpl implements IfcPlanarExtent {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcPlanarExtentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.eINSTANCE.getIfcPlanarExtent();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getSizeInX() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcPlanarExtent_SizeInX(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSizeInX(double newSizeInX) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcPlanarExtent_SizeInX(), newSizeInX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSizeInXAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcPlanarExtent_SizeInXAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSizeInXAsString(String newSizeInXAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcPlanarExtent_SizeInXAsString(), newSizeInXAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getSizeInY() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcPlanarExtent_SizeInY(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSizeInY(double newSizeInY) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcPlanarExtent_SizeInY(), newSizeInY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSizeInYAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcPlanarExtent_SizeInYAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSizeInYAsString(String newSizeInYAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcPlanarExtent_SizeInYAsString(), newSizeInYAsString);
	}

} //IfcPlanarExtentImpl
