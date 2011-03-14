/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcObjectDefinition;
import org.bimserver.models.ifc2x3.IfcObjectTypeEnum;
import org.bimserver.models.ifc2x3.IfcRelAssigns;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Rel Assigns</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelAssignsImpl#getRelatedObjects <em>Related Objects</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelAssignsImpl#getRelatedObjectsType <em>Related Objects Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcRelAssignsImpl extends IfcRelationshipImpl implements IfcRelAssigns {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRelAssignsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcRelAssigns();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcObjectDefinition> getRelatedObjects() {
		return (EList<IfcObjectDefinition>)eGet(Ifc2x3Package.eINSTANCE.getIfcRelAssigns_RelatedObjects(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcObjectTypeEnum getRelatedObjectsType() {
		return (IfcObjectTypeEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcRelAssigns_RelatedObjectsType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelatedObjectsType(IfcObjectTypeEnum newRelatedObjectsType) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcRelAssigns_RelatedObjectsType(), newRelatedObjectsType);
	}

} //IfcRelAssignsImpl
