/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcPropertySetDefinition;
import org.bimserver.models.ifc2x3.IfcRelDefinesByType;
import org.bimserver.models.ifc2x3.IfcTypeObject;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Type Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTypeObjectImpl#getApplicableOccurrence <em>Applicable Occurrence</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTypeObjectImpl#getHasPropertySets <em>Has Property Sets</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTypeObjectImpl#getObjectTypeOf <em>Object Type Of</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcTypeObjectImpl extends IfcObjectDefinitionImpl implements IfcTypeObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcTypeObjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcTypeObject();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getApplicableOccurrence() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcTypeObject_ApplicableOccurrence(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setApplicableOccurrence(String newApplicableOccurrence) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcTypeObject_ApplicableOccurrence(), newApplicableOccurrence);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetApplicableOccurrence() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcTypeObject_ApplicableOccurrence());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetApplicableOccurrence() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcTypeObject_ApplicableOccurrence());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcPropertySetDefinition> getHasPropertySets() {
		return (EList<IfcPropertySetDefinition>)eGet(Ifc2x3Package.eINSTANCE.getIfcTypeObject_HasPropertySets(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetHasPropertySets() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcTypeObject_HasPropertySets());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetHasPropertySets() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcTypeObject_HasPropertySets());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelDefinesByType> getObjectTypeOf() {
		return (EList<IfcRelDefinesByType>)eGet(Ifc2x3Package.eINSTANCE.getIfcTypeObject_ObjectTypeOf(), true);
	}

} //IfcTypeObjectImpl
