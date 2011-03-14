/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcCartesianTransformationOperator;
import org.bimserver.models.ifc2x3.IfcMappedItem;
import org.bimserver.models.ifc2x3.IfcRepresentationMap;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Mapped Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcMappedItemImpl#getMappingSource <em>Mapping Source</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcMappedItemImpl#getMappingTarget <em>Mapping Target</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcMappedItemImpl extends IfcRepresentationItemImpl implements IfcMappedItem {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcMappedItemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcMappedItem();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRepresentationMap getMappingSource() {
		return (IfcRepresentationMap)eGet(Ifc2x3Package.eINSTANCE.getIfcMappedItem_MappingSource(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMappingSource(IfcRepresentationMap newMappingSource) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcMappedItem_MappingSource(), newMappingSource);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCartesianTransformationOperator getMappingTarget() {
		return (IfcCartesianTransformationOperator)eGet(Ifc2x3Package.eINSTANCE.getIfcMappedItem_MappingTarget(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMappingTarget(IfcCartesianTransformationOperator newMappingTarget) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcMappedItem_MappingTarget(), newMappingTarget);
	}

} //IfcMappedItemImpl
