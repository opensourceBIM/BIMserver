/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcAssemblyPlaceEnum;
import org.bimserver.models.ifc2x3.IfcFurnitureType;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Furniture Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcFurnitureTypeImpl#getAssemblyPlace <em>Assembly Place</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcFurnitureTypeImpl extends IfcFurnishingElementTypeImpl implements IfcFurnitureType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcFurnitureTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcFurnitureType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAssemblyPlaceEnum getAssemblyPlace() {
		return (IfcAssemblyPlaceEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcFurnitureType_AssemblyPlace(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssemblyPlace(IfcAssemblyPlaceEnum newAssemblyPlace) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcFurnitureType_AssemblyPlace(), newAssemblyPlace);
	}

} //IfcFurnitureTypeImpl
