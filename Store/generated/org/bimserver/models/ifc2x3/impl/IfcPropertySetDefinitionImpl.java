/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcPropertySetDefinition;
import org.bimserver.models.ifc2x3.IfcRelDefinesByProperties;
import org.bimserver.models.ifc2x3.IfcTypeObject;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Property Set Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPropertySetDefinitionImpl#getPropertyDefinitionOf <em>Property Definition Of</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPropertySetDefinitionImpl#getDefinesType <em>Defines Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcPropertySetDefinitionImpl extends IfcPropertyDefinitionImpl implements IfcPropertySetDefinition {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcPropertySetDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcPropertySetDefinition();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelDefinesByProperties> getPropertyDefinitionOf() {
		return (EList<IfcRelDefinesByProperties>)eGet(Ifc2x3Package.eINSTANCE.getIfcPropertySetDefinition_PropertyDefinitionOf(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcTypeObject> getDefinesType() {
		return (EList<IfcTypeObject>)eGet(Ifc2x3Package.eINSTANCE.getIfcPropertySetDefinition_DefinesType(), true);
	}

} //IfcPropertySetDefinitionImpl
