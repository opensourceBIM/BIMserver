/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcMaterial;
import org.bimserver.models.ifc2x3.IfcMaterialDefinitionRepresentation;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Material Definition Representation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcMaterialDefinitionRepresentationImpl#getRepresentedMaterial <em>Represented Material</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcMaterialDefinitionRepresentationImpl extends IfcProductRepresentationImpl implements IfcMaterialDefinitionRepresentation {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcMaterialDefinitionRepresentationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcMaterialDefinitionRepresentation();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMaterial getRepresentedMaterial() {
		return (IfcMaterial)eGet(Ifc2x3Package.eINSTANCE.getIfcMaterialDefinitionRepresentation_RepresentedMaterial(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepresentedMaterial(IfcMaterial newRepresentedMaterial) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcMaterialDefinitionRepresentation_RepresentedMaterial(), newRepresentedMaterial);
	}

} //IfcMaterialDefinitionRepresentationImpl
