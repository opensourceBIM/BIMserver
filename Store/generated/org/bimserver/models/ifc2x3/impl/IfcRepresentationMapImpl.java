/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.emf.IdEObjectImpl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcAxis2Placement;
import org.bimserver.models.ifc2x3.IfcMappedItem;
import org.bimserver.models.ifc2x3.IfcRepresentation;
import org.bimserver.models.ifc2x3.IfcRepresentationMap;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Representation Map</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRepresentationMapImpl#getMappingOrigin <em>Mapping Origin</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRepresentationMapImpl#getMappedRepresentation <em>Mapped Representation</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRepresentationMapImpl#getMapUsage <em>Map Usage</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcRepresentationMapImpl extends IdEObjectImpl implements IfcRepresentationMap {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRepresentationMapImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcRepresentationMap();
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
	public IfcAxis2Placement getMappingOrigin() {
		return (IfcAxis2Placement)eGet(Ifc2x3Package.eINSTANCE.getIfcRepresentationMap_MappingOrigin(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMappingOrigin(IfcAxis2Placement newMappingOrigin) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcRepresentationMap_MappingOrigin(), newMappingOrigin);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRepresentation getMappedRepresentation() {
		return (IfcRepresentation)eGet(Ifc2x3Package.eINSTANCE.getIfcRepresentationMap_MappedRepresentation(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMappedRepresentation(IfcRepresentation newMappedRepresentation) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcRepresentationMap_MappedRepresentation(), newMappedRepresentation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcMappedItem> getMapUsage() {
		return (EList<IfcMappedItem>)eGet(Ifc2x3Package.eINSTANCE.getIfcRepresentationMap_MapUsage(), true);
	}

} //IfcRepresentationMapImpl
