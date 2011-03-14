/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcCompositeProfileDef;
import org.bimserver.models.ifc2x3.IfcProfileDef;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Composite Profile Def</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCompositeProfileDefImpl#getProfiles <em>Profiles</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCompositeProfileDefImpl#getLabel <em>Label</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcCompositeProfileDefImpl extends IfcProfileDefImpl implements IfcCompositeProfileDef {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcCompositeProfileDefImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcCompositeProfileDef();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcProfileDef> getProfiles() {
		return (EList<IfcProfileDef>)eGet(Ifc2x3Package.eINSTANCE.getIfcCompositeProfileDef_Profiles(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLabel() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcCompositeProfileDef_Label(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabel(String newLabel) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcCompositeProfileDef_Label(), newLabel);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLabel() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcCompositeProfileDef_Label());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLabel() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcCompositeProfileDef_Label());
	}

} //IfcCompositeProfileDefImpl
